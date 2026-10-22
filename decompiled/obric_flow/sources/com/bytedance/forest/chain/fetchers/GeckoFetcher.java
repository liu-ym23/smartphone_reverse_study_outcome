package com.bytedance.forest.chain.fetchers;

import ai.j0;
import android.os.Handler;
import androidx.annotation.Keep;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.ErrorInfo$Type;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.w;
import com.bytedance.forest.utils.q;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.model.CheckRequestBodyModel;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 32\u00020\u0001:\u00014B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J;\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0015\u0010\u0016JI\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00142\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJM\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ?\u0010%\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b%\u0010&J7\u0010+\u001a\u00020*2\u0006\u0010(\u001a\u00020'2\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010$\u001a\u00020)H\u0002¢\u0006\u0004\b+\u0010,J\u001f\u0010-\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b-\u0010.J3\u0010/\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u000bH\u0016¢\u0006\u0004\b1\u00102¨\u00065"}, d2 = {"Lcom/bytedance/forest/chain/fetchers/GeckoFetcher;", "Lcom/bytedance/forest/chain/fetchers/ResourceFetcher;", "Lcom/bytedance/forest/Forest;", "forest", "<init>", "(Lcom/bytedance/forest/Forest;)V", "Lcom/bytedance/forest/model/Request;", "request", "Lcom/bytedance/forest/model/w;", "response", "Lkotlin/Function1;", "", "callback", "Lcom/bytedance/forest/model/l;", "loaderConfig", "pullGeckoPackage", "(Lcom/bytedance/forest/model/Request;Lcom/bytedance/forest/model/w;Lkotlin/jvm/functions/Function1;Lcom/bytedance/forest/model/l;)V", "", LynxMonitorService.KEY_CHANNEL, "bundle", "", "isPathTraversal", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/forest/model/w;)Z", "isCache", "", "channelVersion", "Lkotlin/Function0;", "loadGeckoFile", "(Lcom/bytedance/forest/model/Request;Lcom/bytedance/forest/model/w;ZLjava/lang/Long;Lcom/bytedance/forest/model/l;Lkotlin/jvm/functions/Function0;)V", "Lcom/bytedance/iesgurd/d;", "geckoLoadOfflineFile", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/bytedance/forest/model/w;Lcom/bytedance/forest/model/l;Lkotlin/jvm/functions/Function1;)V", "accessKey", "useInteraction", "tag", "Lcom/bytedance/forest/chain/fetchers/m;", "listener", "checkUpdate", "(Lcom/bytedance/forest/Forest;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/bytedance/forest/chain/fetchers/m;)V", "Lcom/bytedance/forest/chain/fetchers/GeckoXAdapter;", "adapter", "Lpa/a;", "Lcom/bytedance/geckox/OptionCheckUpdateParams;", "buildChannelOptionParams", "(Lcom/bytedance/forest/chain/fetchers/GeckoXAdapter;Ljava/lang/String;ZLjava/lang/String;Lpa/a;)Lcom/bytedance/geckox/OptionCheckUpdateParams;", "fetchSync", "(Lcom/bytedance/forest/model/Request;Lcom/bytedance/forest/model/w;)V", "fetchAsync", "(Lcom/bytedance/forest/model/Request;Lcom/bytedance/forest/model/w;Lkotlin/jvm/functions/Function1;)V", "cancel", "()V", "Companion", "com/bytedance/forest/chain/fetchers/d", "forest_release"}, k = 1, mv = {1, 4, 0})
public final class GeckoFetcher extends ResourceFetcher {
    public static final d Companion = null;
    public static final String GECKO_SDK_INVOKE_ASYNC_TAG = "Forest";
    public static final String GECKO_SDK_INVOKE_SYNC_TAG = "Forest_Update";
    public static final String TAG = "GeckoFetcher";

    /* JADX INFO: renamed from: com.bytedance.forest.chain.fetchers.GeckoFetcher$fetchAsync$4, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 16})
    public static final class AnonymousClass4 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GeckoFetcher f4259a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ w f4260b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function1 f4261c;
        public final /* synthetic */ Request d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ com.bytedance.forest.model.l g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f4262h;

        public AnonymousClass4(GeckoFetcher r5, w r10, Function1 r11, Request r12, String r13, String r14, com.bytedance.forest.model.l r15, String r16) {
            this.f4259a = r5;
            this.f4260b = r10;
            this.f4261c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
            this.g = r15;
            this.f4262h = r16;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            if (this.f4260b.f4442r == false) goto L8;
            this.f4261c.invoke(this.f4260b);
            if (this.d.getDisableGeckoUpdate() == true) goto L15;
            GeckoFetcher r5 = this.f4259a;
            GeckoFetcher.access$checkUpdate(r5, r5.getForest(), this.e, this.f, this.d.getUseInteraction(), GeckoFetcher.GECKO_SDK_INVOKE_ASYNC_TAG, new f(this));
        L15:
            return Unit.INSTANCE;
        L8:
            if (this.d.getDisableGeckoUpdate() == false) goto L11;
            com.bytedance.forest.utils.d.b(this.f4259a.getContext$forest_release().g, 6, GeckoFetcher.TAG, "disable gecko update and no file exists", true, null, "gecko_fetch_error", 16);
            com.bytedance.forest.model.c r10 = this.f4260b.s;
            ErrorInfo$Type r11 = ErrorInfo$Type.f4311c;
            r10.getClass();
            r10.f4360a += r10.a(r11, 6, "disable gecko update and no file exists");
            this.f4261c.invoke(this.f4260b);
            goto L15
        L11:
            if (this.d.getWaitGeckoUpdate() == false) goto L13;
            GeckoFetcher.access$pullGeckoPackage(this.f4259a, this.d, this.f4260b, this.f4261c, this.g);
            goto L15
        L13:
            this.f4261c.invoke(this.f4260b);
            goto L15
        }
    }

    static {
        Companion = new d();
    }

    public GeckoFetcher(Forest r5) {
        super(r5);
    }

    public static final /* synthetic */ void access$checkUpdate(GeckoFetcher r5, Forest r10, String r11, String r12, boolean r13, String r14, m r15) {
        r5.checkUpdate(r10, r11, r12, r13, r14, r15);
    }

    public static final /* synthetic */ void access$loadGeckoFile(GeckoFetcher r5, Request r10, w r11, boolean r12, Long r13, com.bytedance.forest.model.l r14, Function0 r15) {
        r5.loadGeckoFile(r10, r11, r12, r13, r14, r15);
    }

    public static final /* synthetic */ void access$pullGeckoPackage(GeckoFetcher r5, Request r10, w r11, Function1 r12, com.bytedance.forest.model.l r13) {
        r5.pullGeckoPackage(r10, r11, r12, r13);
    }

    private final OptionCheckUpdateParams buildChannelOptionParams(GeckoXAdapter r5, String r10, boolean r11, String r12, pa.a r13) {
        OptionCheckUpdateParams r14 = new OptionCheckUpdateParams();
        r14.setTag(r12);
        OptionCheckUpdateParams r15 = r14.setRequestWhenHasLocalVersion(false).setCustomParam(r5.getCustomParams$forest_release(r10)).setListener(r13);
        if (r11 == false) goto L5;
        r15.setChannelUpdatePriority(3);
    L5:
        return r15;
    }

    private final void checkUpdate(Forest r10, String r11, String r12, boolean r13, String r14, m r15) {
        if (r12.length() != 0) goto L6;
        r15.a("", new Exception("update failed because channel is null"));
        return;
    L6:
        e r5 = new e(this, r15, r12, r11);
        GeckoXAdapter r16 = r10.getGeckoXAdapter();
        com.bytedance.geckox.g r17 = r16.getNormalGeckoXClient$forest_release(r11);
        if (r17 == null) goto L10;
        HashMap r18 = new HashMap();
        ArrayList r19 = new ArrayList();
        r19.add(new CheckRequestBodyModel.TargetChannel(r12));
        r18.put(r11, r19);
        r17.b(r18, buildChannelOptionParams(r16, r11, r13, r14, r5));
        return;
    L10:
        r15.a(r12, new Throwable("GeckoXClient is null"));
    }

    private final void geckoLoadOfflineFile(String r10, String r11, Long r12, w r13, final com.bytedance.forest.model.l r14, final Function1<? super com.bytedance.iesgurd.d, Unit> r15) {
        getForest().getGeckoXAdapter().getGeckoResourceData(r13, r10, r11, r12, r14, new C01761(this, r14, r15));
    }

    private final boolean isPathTraversal(String r12, String r13, w r14) {
        int r5 = getForest().getConfig().f4380c;
        if (r5 != 0) goto L6;
        return false;
    L6:
        if (StringsKt.g(r12, "../") == false) goto L8;
    L9:
        com.bytedance.forest.utils.d r10 = getContext$forest_release().g;
        StringBuilder r11 = com.lynx.tasm.base.a.e("security check failed: gecko fetcher path traversal, channel = ", r12, ", bundle = ", r13, ", mode = ");
        r11.append(r5);
        com.bytedance.forest.utils.d.b(r10, 6, TAG, r11.toString(), true, null, null, 48);
        com.bytedance.forest.b r15 = getContext$forest_release().f4619a;
        com.bytedance.forest.utils.e r16 = getContext$forest_release();
        int r17 = getForest().getConfig().f4380c;
        r15.getClass();
        com.bytedance.apm.b r18 = new com.bytedance.apm.b(r12, r13, r17, r14, r16);
        ((Handler) q.f4658c.getValue()).post(r18);
        if (r5 != 2) goto L13;
        return true;
    L13:
        return false;
    L8:
        if (StringsKt.g(r13, "../") == false) goto L13;
        goto L9
    }

    private final void loadGeckoFile(final Request r17, final w r18, final boolean r19, final Long r20, com.bytedance.forest.model.l r21, final Function0<Unit> r22) {
        final String r5 = r21.f4386b;
        final String r12 = r17.getGeckoModel().f4390b;
        final String r13 = r17.getGeckoModel().f4391c;
        if (isPathTraversal(r12, r13, r18) == false) goto L6;
        r18.f4442r = false;
        com.bytedance.forest.model.c r10 = r18.s;
        r10.getClass();
        r10.f4360a += r10.a(ErrorInfo$Type.f4311c, 8, "security check failed: gecko fetcher path traversal, channel = " + r12 + ", bundle = " + r13);
        r22.invoke();
        return;
    L6:
        getContext$forest_release().b(new String[]{"gecko_start"});
        geckoLoadOfflineFile(r12, r13, r20, r18, r21, new AnonymousClass2(this, r17, r18, r22, r5, r12, r13, r20, r19));
    }

    public static /* synthetic */ void loadGeckoFile$default(GeckoFetcher r10, Request r11, w r12, boolean r13, Long r14, com.bytedance.forest.model.l r15, Function0 r16, int r17, Object r18) {
        if ((r17 & 8) == 0) goto L5;
        r14 = null;
    L5:
        r10.loadGeckoFile(r11, r12, r13, r14, r15, r16);
    }

    private final void pullGeckoPackage(Request r13, w r14, Function1<? super w, Unit> r15, com.bytedance.forest.model.l r16) {
        boolean r5 = r13.getOnlyLocal();
        if (r5 == false) goto L6;
        com.bytedance.forest.model.c r10 = r14.s;
        ErrorInfo$Type r11 = ErrorInfo$Type.f4311c;
        r10.getClass();
        r10.f4360a += r10.a(r11, 7, "gecko only local");
        r15.invoke(r14);
        return;
    L6:
        r13.setUseInteraction(true);
        getContext$forest_release().b(new String[]{"gecko_update_start"});
        checkUpdate(getForest(), r16.f4386b, r13.getGeckoModel().f4390b, r13.getUseInteraction(), GECKO_SDK_INVOKE_SYNC_TAG, new g(this, r13, r5, r14, r16, r15));
    }

    @Override // com.bytedance.forest.chain.fetchers.ResourceFetcher
    public void cancel() {
    }

    @Override // com.bytedance.forest.chain.fetchers.ResourceFetcher
    public void fetchAsync(Request r19, w r20, Function1<? super w, Unit> r21) {
        getContext$forest_release().b(new String[]{"gecko_total_start"});
        com.bytedance.forest.utils.d.b(getContext$forest_release().g, 3, TAG, "start to fetchAsync from gecko", true, null, "gecko_total_start", 16);
        final String r10 = r19.getGeckoModel().f4390b;
        final String r11 = r19.getGeckoModel().f4391c;
        if (r10.length() != 0) goto L6;
    L7:
        com.bytedance.forest.model.c r5 = r20.s;
        ErrorInfo$Type r12 = ErrorInfo$Type.f4311c;
        r5.getClass();
        r5.f4360a += r5.a(r12, 3, "channel is empty for gecko");
        r21.invoke(r20);
        return;
    L6:
        if (r11.length() == 0) goto L7;
        String r13 = r19.getGeckoModel().f4389a;
        if (r13.length() != 0) goto L12;
        com.bytedance.forest.utils.d.b(getContext$forest_release().g, 4, TAG, "config accessKey not found, using default", true, null, "gecko_ak_empty_use_default", 16);
    L12:
        getContext$forest_release().b(new String[]{"gecko_get_config_start"});
        final com.bytedance.forest.model.l r14 = getForest().getConfig().a(r13);
        getContext$forest_release().b(new String[]{"gecko_get_config_finish"});
        if (r14 != null) goto L16;
        com.bytedance.forest.model.c r15 = r20.s;
        r15.f4361b = 4;
        r15.f4365j = j0.k("can not find offline root path for access key ", r13, ". Neither transmit related parameters of GeckoConfig in ForestConfig nor register access key to gecko sdk.");
        r21.invoke(r20);
        return;
    L16:
        com.bytedance.forest.utils.d.c(getContext$forest_release().g, 3, TAG, null, "gecko_config_get", new AnonymousClass3(r14, r10, r11), 8);
        loadGeckoFile(r19, r20, true, null, r14, new AnonymousClass4(this, r20, r21, r19, r14.f4386b, r10, r14, r11));
    }

    @Override // com.bytedance.forest.chain.fetchers.ResourceFetcher
    public void fetchSync(Request r10, w r11) {
        com.bytedance.forest.utils.d.b(getContext$forest_release().g, 3, TAG, "start to fetchSync from gecko", true, null, "gecko_total_start", 16);
        final CountDownLatch r5 = new CountDownLatch(1);
        fetchAsync(r10, r11, new AnonymousClass1(r5));
        r5.await(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
    }
}
