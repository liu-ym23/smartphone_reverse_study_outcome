package com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.broadcastgame.api.feature_panel.PreviewOpenFeatureTalentSettingUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.AuditInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.api.utils.SchemaInfo;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformAnchorServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformClient;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.MiniAppExplainCardApi;
import com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorMiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.context.PreviewAnchorMiniAppContext;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.AnchorShelfContextService;
import com.bytedance.android.livesdk.config.ud0;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.ies.utility.SharedPrefHelper;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b(\u0018\u0000 j2\u00020\u00012\u00020\u0002:\u0003kl:B\u0007¢\u0006\u0004\bh\u0010iJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J \u0010\u0014\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u000bH\u0002J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u000bH\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J)\u0010\u001d\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u001a*\b\u0012\u0004\u0012\u00028\u00000\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000e\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0010J\u0006\u0010!\u001a\u00020\u0003J\u0006\u0010\"\u001a\u00020\u0003J\u0006\u0010#\u001a\u00020\u0003J$\u0010&\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$J\u0006\u0010(\u001a\u00020'J\u000e\u0010*\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0007J\b\u0010+\u001a\u0004\u0018\u00010\u000bJ\b\u0010,\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010/\u001a\u00020\u00032\u0006\u0010.\u001a\u00020-J\u000e\u00101\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0018J\u0006\u00102\u001a\u00020\u0018J\u0006\u00103\u001a\u00020\u0003J\u0006\u00104\u001a\u00020\u0018J\u0006\u00105\u001a\u00020\u0003J\u0006\u00106\u001a\u00020\u0018J\b\u00107\u001a\u00020\u0003H\u0014J\t\u00108\u001a\u00020\u0003H\u0096\u0001J\u0011\u0010;\u001a\u00020\u00032\u0006\u0010:\u001a\u000209H\u0096\u0001J\r\u0010<\u001a\u00020\u0003*\u000209H\u0096\u0001R*\u0010?\u001a\u00020=2\u0006\u0010>\u001a\u00020=8\u0006@GX\u0086.¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR!\u0010J\u001a\b\u0012\u0004\u0012\u00020E0\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR!\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00180\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bK\u0010G\u001a\u0004\bL\u0010IR!\u0010P\u001a\b\u0012\u0004\u0012\u00020\t0\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bN\u0010G\u001a\u0004\bO\u0010IR!\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00070\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010G\u001a\u0004\bR\u0010IR!\u0010V\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bT\u0010G\u001a\u0004\bU\u0010IR!\u00100\u001a\b\u0012\u0004\u0012\u00020\u00180\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bW\u0010G\u001a\u0004\b0\u0010IR!\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00180\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bX\u0010G\u001a\u0004\bY\u0010IR\u0016\u0010\u001f\u001a\u00020\u00108\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001f\u0010[R\u0016\u0010\\\u001a\u00020\u00108\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\\\u0010[R\u001d\u0010`\u001a\u0004\u0018\u00010\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b]\u0010G\u001a\u0004\b^\u0010_R\u001b\u0010b\u001a\u00020\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\ba\u0010G\u001a\u0004\bb\u0010cR\u001b\u0010e\u001a\u00020\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bd\u0010G\u001a\u0004\be\u0010cR\u001b\u0010g\u001a\u00020\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bf\u0010G\u001a\u0004\bg\u0010c¨\u0006m"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/explaincardsetting/ExplainCardSettingViewModel;", "Landroidx/lifecycle/ViewModel;", "", "", "refreshCard", "updateCustomCover", "refreshCustomTitle", "", "customizedCoverType", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/explaincardsetting/ExplainCardSettingViewModel$d;", "buildCustomizedCoverUiState", "", "getTextPosterDescription", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfCardInfo;", "shelfCardInfo", "customizedCoverUrl", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/explaincardsetting/ExplainCardSettingsInfo;", "buildCustomizedCoverSettingsInfo", "coverType", "url", "buildNonCustomizedCoverSettingsInfo", "title", "setExplainCardTitle", "setTextPosterTitle", "", "isSamePage", "T", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/explaincardsetting/s;", "data", "postValue", "(Lcom/bytedance/android/live/openplatform/impl/miniappanchor/explaincardsetting/s;Ljava/lang/Object;)V", "explainCardSettingsInfo", "initData", "fetchPresetData", "observerData", "savePageData", "Lcom/bytedance/android/live/base/model/ImageModel;", "img", "setCover", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/explaincardsetting/ExplainCardCoverActionSheetDialog$Config;", "buildCoverActionConfig", "targetType", "changeCover", "getExplainCardTitle", "getTextPosterTitle", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/explaincardsetting/ExplainCardSettingViewModel$b;", "event", "changeTitle", "isIntroducing", "setIsIntroducing", "canModifyCover", "reportGiveUpRemainder", "isShowReplaceDialog", "clearTalentPayload", "isCardChanged", "onCleared", "dispose", "Lio/reactivex/disposables/Disposable;", "d", "remove", "autoDispose", "Lso0/a;", "<set-?>", "miniAppAnchorService", "Lso0/a;", "getMiniAppAnchorService", "()Lso0/a;", "setMiniAppAnchorService", "(Lso0/a;)V", "Lcom/bytedance/android/live/openplatform/impl/miniappcommon/explaincard/b;", "explainCardInfo$delegate", "Lkotlin/Lazy;", "getExplainCardInfo", "()Lcom/bytedance/android/live/openplatform/impl/miniappanchor/explaincardsetting/s;", "explainCardInfo", "loadingStatus$delegate", "getLoadingStatus", "loadingStatus", "customCover$delegate", "getCustomCover", "customCover", "changeCoverEvent$delegate", "getChangeCoverEvent", "changeCoverEvent", "customTitle$delegate", "getCustomTitle", "customTitle", "isIntroducing$delegate", "finish$delegate", "getFinish", "finish", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/explaincardsetting/ExplainCardSettingsInfo;", "originExplainCardSettingsInfo", "appId$delegate", "getAppId", "()Ljava/lang/String;", "appId", "isEdit$delegate", "isEdit", "()Z", "isShelf$delegate", "isShelf", "isTalentMount$delegate", "isTalentMount", "<init>", "()V", "Companion", "b", "c", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExplainCardSettingViewModel extends ViewModel {
    public static final c Companion = null;
    private static final String TAG = "ExplainCardSettingViewModel";
    private final /* synthetic */ com.bytedance.android.live.openplatform.impl.base.utils.a $$delegate_0;
    private final Lazy appId$delegate;
    private final Lazy changeCoverEvent$delegate;
    private final Lazy customCover$delegate;
    private final Lazy customTitle$delegate;
    private final Lazy explainCardInfo$delegate;
    private ExplainCardSettingsInfo explainCardSettingsInfo;
    private final Lazy finish$delegate;
    private final Lazy isEdit$delegate;
    private final Lazy isIntroducing$delegate;
    private final Lazy isShelf$delegate;
    private final Lazy isTalentMount$delegate;
    private final Lazy loadingStatus$delegate;
    public so0.a miniAppAnchorService;
    private ExplainCardSettingsInfo originExplainCardSettingsInfo;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ ExplainCardSettingViewModel a;

        public a(ExplainCardSettingViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r9) {
            sh6.b r10 = (sh6.b) r9;
            if (ExplainCardSettingViewModel.access$getExplainCardSettingsInfo$li(this.a) == null) goto L45;
            ShelfInfo r0 = (ShelfInfo) sh6.c.b(r10);
            ShelfCardInfo r1 = null;
            if (r0 == null) goto L10;
            ShelfMicroAppInfo r2 = r0.appInfo;
            if (r2 == null) goto L10;
            String r3 = r2.appId;
        L11:
            ShelfMicroAppInfo r4 = ExplainCardSettingViewModel.access$getExplainCardSettingsInfo$p(this.a).g();
            if (r4 == null) goto L14;
            String r5 = r4.appId;
        L16:
            if ((!Intrinsics.areEqual(r3, r5)) == true) goto L46;
            ShelfInfo r11 = (ShelfInfo) sh6.c.b(r10);
            if (r11 == null) goto L43;
            List<ShelfCardInfo> r12 = r11.cardInfoList;
            if (r12 == null) goto L44;
            Iterator<T> r13 = r12.iterator();
        L24:
            if (r13.hasNext() == false) goto L33;
            T r6 = r13.next();
            long r7 = ((ShelfCardInfo) r6).getCardId();
            ShelfCardInfo r8 = ExplainCardSettingViewModel.access$getExplainCardSettingsInfo$p(this.a).shelfCardInfo;
            if (r8 != null) goto L28;
        L30:
            boolean r14 = false;
        L31:
            if (r14 == false) goto L24;
            r1 = r6;
            goto L33
        L28:
            if (r7 != r8.getCardId()) goto L30;
            r14 = true;
        L33:
            ShelfCardInfo r15 = r1;
            if (r15 == null) goto L47;
            ExplainCardSettingViewModel r16 = this.a;
            r16.initData(ExplainCardSettingsInfo.a(ExplainCardSettingViewModel.access$getExplainCardSettingsInfo$p(r16), r15));
            return;
        L47:
            return;
        L44:
            return;
        L43:
            return;
        L46:
            return;
        L14:
            r5 = null;
        L10:
            r3 = null;
            goto L11
        }
    }

    public static final class b {
        public final int a;
        public final String b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L10;
            b r4 = (b) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            int r0 = this.a * 31;
            String r1 = this.b;
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L7:
            return r0 + r2;
        L5:
            r2 = 0;
            goto L7
        }

        public final String toString() {
            return "ChangeTitleEvent(editorType=" + this.a + ", newTitle=" + this.b + ")";
        }

        public b(int r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "newTitle");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c {
        public c() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting.ExplainCardSettingViewModel$canModifyCover$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass1 extends MutablePropertyReference0Impl {
        public AnonymousClass1(ExplainCardSettingViewModel r7) {
            super(r7, ExplainCardSettingViewModel.class, "explainCardSettingsInfo", "getExplainCardSettingsInfo()Lcom/bytedance/android/live/openplatform/impl/miniappanchor/explaincardsetting/ExplainCardSettingsInfo;", 0);
        }

        public Object get() {
            return ExplainCardSettingViewModel.access$getExplainCardSettingsInfo$p((ExplainCardSettingViewModel) ((CallableReference) this).receiver);
        }

        public void set(Object r2) {
            ExplainCardSettingViewModel.access$setExplainCardSettingsInfo$p((ExplainCardSettingViewModel) ((CallableReference) this).receiver, (ExplainCardSettingsInfo) r2);
        }
    }

    public static abstract class d {
        public final String a;

        public static final class a extends d {
            public final String b;
            public final String c;

            @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting.ExplainCardSettingViewModel.d
            public final boolean a() {
                return r2.a(this.b);
            }

            public a(String r2, String r3, String r4) {
                Intrinsics.checkNotNullParameter(r2, "description");
                Intrinsics.checkNotNullParameter(r3, "reviewStatus");
                Intrinsics.checkNotNullParameter(r4, "customizedCoverUrl");
                super(r2);
                this.b = r3;
                this.c = r4;
            }
        }

        public static final class b extends d {
            public b(String r2) {
                Intrinsics.checkNotNullParameter(r2, "description");
                super(r2);
            }
        }

        public static final class c extends d {
            public c(String r2) {
                Intrinsics.checkNotNullParameter(r2, "description");
                super(r2);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting.ExplainCardSettingViewModel$d$d, reason: collision with other inner class name */
        public static final class C0146d extends d {
            public C0146d(String r2) {
                Intrinsics.checkNotNullParameter(r2, "description");
                super(r2);
            }
        }

        public static final class e extends d {
            public static final e b = null;

            static {
                b = new e();
            }

            public e() {
                super("");
            }
        }

        public boolean a() {
            return false;
        }

        public d(String r1) {
            this.a = r1;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ ExplainCardSettingViewModel a;

        public e(ExplainCardSettingViewModel r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void accept(Object r6) {
            ExplainCardSettingViewModel r0 = this.a;
            ExplainCardSettingsInfo r1 = ExplainCardSettingViewModel.access$getExplainCardSettingsInfo$p(r0);
            com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.e r7 = (com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.e) ((com.bytedance.android.live.network.response.e) r6).data;
            ShelfCardInfo r2 = r1.shelfCardInfo;
            if (r2 == null) goto L5;
            String r3 = r2.o0();
        L6:
            ShelfCardInfo r4 = r1.shelfCardInfo;
            if (r4 == null) goto L9;
            String r5 = r4.j0();
        L10:
            ExplainCardSettingViewModel.access$setExplainCardSettingsInfo$p(r0, r1.b(r7, r3, r5));
            ExplainCardSettingViewModel.access$refreshCard(this.a);
            ExplainCardSettingViewModel r8 = this.a;
            ExplainCardSettingViewModel.access$postValue(r8, r8.getLoadingStatus(), null);
            return;
        L9:
            r5 = null;
            goto L10
        L5:
            r3 = null;
            goto L6
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ ExplainCardSettingViewModel a;

        public f(ExplainCardSettingViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            ExplainCardSettingViewModel.access$refreshCard(this.a);
            ExplainCardSettingViewModel r5 = this.a;
            ExplainCardSettingViewModel.access$postValue(r5, r5.getLoadingStatus(), null);
        }
    }

    static {
        Companion = new c();
    }

    public void autoDispose(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$autoDispose");
        this.$$delegate_0.a(r2);
    }

    public void dispose() {
        this.$$delegate_0.b();
    }

    public final String getAppId() {
        return (String) this.appId$delegate.getValue();
    }

    public final s<Integer> getChangeCoverEvent() {
        return (s) this.changeCoverEvent$delegate.getValue();
    }

    public final s<d> getCustomCover() {
        return (s) this.customCover$delegate.getValue();
    }

    public final s<String> getCustomTitle() {
        return (s) this.customTitle$delegate.getValue();
    }

    public final s<com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.b> getExplainCardInfo() {
        return (s) this.explainCardInfo$delegate.getValue();
    }

    public final s<Boolean> getFinish() {
        return (s) this.finish$delegate.getValue();
    }

    public final s<Boolean> getLoadingStatus() {
        return (s) this.loadingStatus$delegate.getValue();
    }

    public final boolean isEdit() {
        return ((Boolean) this.isEdit$delegate.getValue()).booleanValue();
    }

    public final s<Boolean> isIntroducing() {
        return (s) this.isIntroducing$delegate.getValue();
    }

    public final boolean isShelf() {
        return ((Boolean) this.isShelf$delegate.getValue()).booleanValue();
    }

    public final boolean isTalentMount() {
        return ((Boolean) this.isTalentMount$delegate.getValue()).booleanValue();
    }

    public void remove(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
        this.$$delegate_0.c(r2);
    }

    private final String getTextPosterDescription() {
        ExplainCardSettingsInfo r0 = this.explainCardSettingsInfo;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L5:
        ShelfCardInfo r1 = r0.shelfCardInfo;
        if (r1 == null) goto L8;
        String r2 = r1.j0();
    L9:
        if (r2 != null) goto L11;
    L14:
        boolean r3 = true;
    L15:
        if (r3 == false) goto L19;
        return "";
    L19:
        return s1.B(2131921105) + 65306 + r2;
    L11:
        if (r2.length() == 0) goto L14;
        r3 = false;
        goto L15
    L8:
        r2 = null;
        goto L9
    }

    public final ExplainCardCoverActionSheetDialog.Config buildCoverActionConfig() {
        ExplainCardSettingsInfo r1 = this.explainCardSettingsInfo;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L5:
        ShelfCardInfo r2 = r1.shelfCardInfo;
        if (r2 == null) goto L9;
        String r3 = r2.j0();
        if (r3 == null) goto L9;
    L10:
        ExplainCardSettingsInfo r4 = this.explainCardSettingsInfo;
        if (r4 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L13:
        ShelfCardInfo r5 = r4.shelfCardInfo;
        boolean r6 = false;
        if (r5 == null) goto L20;
        String r7 = r5.S();
        if (r7 == null) goto L20;
        if (r2.a(r7) != true) goto L20;
        boolean r8 = true;
    L21:
        ExplainCardSettingsInfo r9 = this.explainCardSettingsInfo;
        if (r9 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L24:
        ShelfCardInfo r10 = r9.shelfCardInfo;
        if (r10 == null) goto L32;
        String r11 = r10.b0();
        if (r11 == null) goto L32;
        if (r2.a(r11) != true) goto L32;
        r6 = true;
    L32:
        return new ExplainCardCoverActionSheetDialog.Config(r3, r8, r6);
    L20:
        r8 = false;
    L9:
        r3 = "";
        goto L10
    }

    public final boolean canModifyCover() {
        ExplainCardSettingsInfo r0 = this.explainCardSettingsInfo;
        if (r0 != null) goto L5;
        return true;
    L5:
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L7:
        ShelfCardInfo r1 = r0.shelfCardInfo;
        if (r1 != null) goto L10;
        return true;
    L10:
        return r1.r();
    }

    public final void clearTalentPayload() {
        so0.a r0 = this.miniAppAnchorService;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L5:
        OpenPlatformContext r1 = r0.a();
        if ((r1 instanceof PreviewAnchorMiniAppContext) == true) goto L8;
        r1 = null;
    L8:
        PreviewAnchorMiniAppContext r2 = (PreviewAnchorMiniAppContext) r1;
        if (r2 == null) goto L12;
        r2.clearTalentPayload();
        return;
    }

    public final so0.a getMiniAppAnchorService() {
        so0.a r0 = this.miniAppAnchorService;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L5:
        return r0;
    }

    public final String getTextPosterTitle() {
        ExplainCardSettingsInfo r0 = this.explainCardSettingsInfo;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L5:
        ShelfCardInfo r1 = r0.shelfCardInfo;
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.j0();
    }

    public final boolean isCardChanged() {
        ExplainCardSettingsInfo r0 = this.originExplainCardSettingsInfo;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("originExplainCardSettingsInfo");
    L5:
        ExplainCardSettingsInfo r1 = this.explainCardSettingsInfo;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L9:
        return !Intrinsics.areEqual(r0, r1);
    }

    public final boolean isShowReplaceDialog() {
        so0.a r0 = this.miniAppAnchorService;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L5:
        OpenPlatformContext r1 = r0.a();
        if (r1 == null) goto L14;
        AnchorShelfContextService r2 = (AnchorShelfContextService) r1.getService(AnchorShelfContextService.class);
        if (r2 == null) goto L14;
        if (r2.isMounted() != true) goto L14;
        if (isSamePage() == true) goto L14;
        return true;
    L14:
        return false;
    }

    public final void reportGiveUpRemainder() {
        so0.a r0 = this.miniAppAnchorService;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L5:
        OpenPlatformContext r1 = r0.a();
        if (r1 == null) goto L28;
        AnchorMiniAppAppLogContextService r2 = (AnchorMiniAppAppLogContextService) r1.getService(AnchorMiniAppAppLogContextService.class);
        if (r2 == null) goto L29;
        ExplainCardSettingsInfo r3 = this.explainCardSettingsInfo;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L12:
        ShelfMicroAppInfo r4 = r3.g();
        if (r4 == null) goto L16;
        String r5 = r4.appId;
        if (r5 == null) goto L16;
    L17:
        ExplainCardSettingsInfo r6 = this.explainCardSettingsInfo;
        if (r6 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L20:
        ShelfCardInfo r7 = r6.shelfCardInfo;
        if (r7 == null) goto L25;
        String r8 = r7.a0();
        if (r8 == null) goto L25;
        String r9 = com.bytedance.android.live.openplatform.api.utils.h.b(r8);
    L26:
        r2.reportGiveUpRemainder(r5, r9);
        return;
    L25:
        r9 = null;
    L16:
        r5 = "";
        goto L17
    L29:
        return;
    }

    public final void savePageData() {
        ExplainCardSettingsInfo r0 = this.explainCardSettingsInfo;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L6:
        if (r0.i() == false) goto L33;
        ExplainCardSettingsInfo r1 = this.explainCardSettingsInfo;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L11:
        if (r1.h() == false) goto L21;
        xs2.b.a().post(new zp0.a());
        ExplainCardSettingsInfo r2 = this.explainCardSettingsInfo;
        if (r2 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L15:
        ShelfCardInfo r3 = r2.shelfCardInfo;
        if (r3 == null) goto L100;
        xs2.b r4 = xs2.b.a();
        ExplainCardSettingsInfo r5 = this.explainCardSettingsInfo;
        if (r5 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L20:
        r4.post(new zp0.b(2, r3, r5.c()));
    L100:
        if (isTalentMount() == false) goto L102;
        SharedPrefHelper r6 = PreviewOpenFeatureTalentSettingUtil.a;
        PreviewOpenFeatureTalentSettingUtil.a(PreviewOpenFeatureTalentSettingUtil.Type.TALENT);
        return;
    L102:
        SharedPrefHelper r7 = PreviewOpenFeatureTalentSettingUtil.a;
        PreviewOpenFeatureTalentSettingUtil.a(PreviewOpenFeatureTalentSettingUtil.Type.MINIAPP);
        return;
    L21:
        so0.a r8 = this.miniAppAnchorService;
        if (r8 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L24:
        OpenPlatformContext r9 = r8.a();
        if (r9 == null) goto L100;
        AnchorShelfContextService r10 = (AnchorShelfContextService) r9.getService(AnchorShelfContextService.class);
        if (r10 == null) goto L100;
        ExplainCardSettingsInfo r11 = this.explainCardSettingsInfo;
        if (r11 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L31:
        r10.putCardOnShelf(r11, C03192.INSTANCE);
        goto L100
    L33:
        if (isSamePage() == true) goto L81;
        so0.a r12 = this.miniAppAnchorService;
        if (r12 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L37:
        OpenPlatformContext r13 = r12.a();
        if (r13 == null) goto L81;
        AnchorMiniAppAppLogContextService r14 = (AnchorMiniAppAppLogContextService) r13.getService(AnchorMiniAppAppLogContextService.class);
        if (r14 == null) goto L81;
        ExplainCardSettingsInfo r15 = this.explainCardSettingsInfo;
        if (r15 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L44:
        ShelfMicroAppInfo r16 = r15.g();
        String r17 = "";
        if (r16 == null) goto L48;
        String r18 = r16.appId;
        if (r18 == null) goto L48;
    L49:
        ExplainCardSettingsInfo r19 = this.explainCardSettingsInfo;
        if (r19 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L52:
        ShelfCardInfo r20 = r19.shelfCardInfo;
        if (r20 == null) goto L57;
        String r21 = r20.a0();
        if (r21 == null) goto L57;
        String r22 = com.bytedance.android.live.openplatform.api.utils.h.b(r21);
    L58:
        ExplainCardSettingsInfo r23 = this.explainCardSettingsInfo;
        if (r23 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L61:
        String r24 = r23.d();
        if (r24 != null) goto L64;
        r24 = "";
    L64:
        ExplainCardSettingsInfo r25 = this.explainCardSettingsInfo;
        if (r25 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L67:
        r25.getClass();
        SchemaInfo.b r26 = SchemaInfo.s;
        ShelfCardInfo r27 = r25.shelfCardInfo;
        if (r27 == null) goto L70;
        String r28 = r27.a0();
    L71:
        r26.getClass();
        SchemaInfo r29 = SchemaInfo.b.b(r28);
        if (r29 == null) goto L79;
        JSONObject r30 = r29.b();
        if (r30 == null) goto L79;
        String r31 = r30.optString("enter_position");
        if (r31 == null) goto L79;
        r17 = r31;
    L79:
        r14.reportSmallProgramAdd(r18, r22, r24, r17);
        goto L81
    L70:
        r28 = null;
    L57:
        r22 = "";
    L48:
        r18 = "";
    L81:
        if (((Boolean) ud0.a.getValue()).booleanValue() == false) goto L88;
        ExplainCardSettingsInfo r32 = this.explainCardSettingsInfo;
        if (r32 != null) goto L86;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L86:
        if (r32.e() != ShelfInfo.MountType.TalentMount.getValue()) goto L88;
        HashMap<String, zo0.f> r33 = zo0.g.a;
        zo0.f r34 = zo0.h.b(PerformanceScene.SHELF_DIALOG);
        r34.o();
        zo0.h.a(r34, "talent");
    L88:
        so0.a r35 = this.miniAppAnchorService;
        if (r35 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L91:
        OpenPlatformContext r36 = r35.a();
        if (r36 == null) goto L100;
        AnchorShelfContextService r37 = (AnchorShelfContextService) r36.getService(AnchorShelfContextService.class);
        if (r37 == null) goto L100;
        ExplainCardSettingsInfo r38 = this.explainCardSettingsInfo;
        if (r38 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L98:
        AnchorShelfContextService.modifyShelf$default(r37, r38.j(), false, new AnonymousClass3(this), null, 10, null);
        goto L100
    }

    public ExplainCardSettingViewModel() {
        this.$$delegate_0 = new com.bytedance.android.live.openplatform.impl.base.utils.a();
        this.explainCardInfo$delegate = LazyKt.lazy(ExplainCardSettingViewModel$explainCardInfo$2.INSTANCE);
        this.loadingStatus$delegate = LazyKt.lazy(ExplainCardSettingViewModel$loadingStatus$2.INSTANCE);
        this.customCover$delegate = LazyKt.lazy(ExplainCardSettingViewModel$customCover$2.INSTANCE);
        this.changeCoverEvent$delegate = LazyKt.lazy(ExplainCardSettingViewModel$changeCoverEvent$2.INSTANCE);
        this.customTitle$delegate = LazyKt.lazy(ExplainCardSettingViewModel$customTitle$2.INSTANCE);
        this.isIntroducing$delegate = LazyKt.lazy(C03152.INSTANCE);
        this.finish$delegate = LazyKt.lazy(ExplainCardSettingViewModel$finish$2.INSTANCE);
        this.appId$delegate = LazyKt.lazy(new ExplainCardSettingViewModel$appId$2(this));
        this.isEdit$delegate = LazyKt.lazy(new AnonymousClass2(this));
        this.isShelf$delegate = LazyKt.lazy(new C03162(this));
        this.isTalentMount$delegate = LazyKt.lazy(new C03172(this));
        OpenPlatformAnchorServiceImpl.Companion.getClass();
        setMiniAppAnchorService((so0.a) ((po0.a.b) OpenPlatformAnchorServiceImpl.access$getDiComponent$cp()).a().a.b.get());
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r0 = AnchorMiniAppDataContext.a.a();
        if (r0 == null) goto L12;
        com.bytedance.live.datacontext.n<ShelfInfo> r1 = r0.m618getShelfInfo();
        if (r1 == null) goto L13;
        Observable r2 = r1.a();
        if (r2 == null) goto L14;
        Disposable r3 = r2.subscribe(new a(this));
        if (r3 == null) goto L15;
        autoDispose(r3);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    private final boolean isSamePage() {
        if (isShelf() == false) goto L5;
        return true;
    L5:
        so0.a r0 = this.miniAppAnchorService;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L8:
        OpenPlatformContext r1 = r0.a();
        if (r1 == null) goto L51;
        AnchorShelfContextService r2 = (AnchorShelfContextService) r1.getService(AnchorShelfContextService.class);
        if (r2 == null) goto L51;
        ShelfInfo r3 = r2.getCurShelfInfo();
        if (r3 == null) goto L51;
        List<ShelfCardInfo> r4 = r3.cardInfoList;
        if (r4 == null) goto L41;
        ShelfCardInfo r5 = (ShelfCardInfo) CollectionsKt.firstOrNull(r4);
        if (r5 == null) goto L41;
        String r6 = r5.a0();
        if (r6 == null) goto L41;
        ExplainCardSettingsInfo r7 = this.explainCardSettingsInfo;
        if (r7 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L24:
        ShelfCardInfo r8 = r7.shelfCardInfo;
        if (r8 == null) goto L28;
        String r9 = r8.a0();
        if (r9 == null) goto L28;
    L29:
        Intrinsics.checkNotNullParameter(r6, "$this$isSamePage");
        Intrinsics.checkNotNullParameter(r9, "schema");
        String r10 = com.bytedance.android.live.openplatform.api.utils.h.b(r6);
        String r11 = com.bytedance.android.live.openplatform.api.utils.h.b(r9);
        Intrinsics.checkNotNullParameter(r6, "$this$isSameMiniApp");
        Intrinsics.checkNotNullParameter(r9, "schema");
        String r12 = com.bytedance.android.live.openplatform.api.utils.h.a(r6);
        String r13 = com.bytedance.android.live.openplatform.api.utils.h.a(r9);
        if ((!StringsKt.isBlank(r12)) == true) goto L32;
    L34:
        boolean r14 = false;
    L35:
        if (r14 == false) goto L41;
        if ((!StringsKt.isBlank(r10)) == false) goto L41;
        if (Intrinsics.areEqual(r10, r11) == false) goto L41;
        boolean r15 = true;
    L42:
        if (r15 == false) goto L49;
        int r16 = r3.mountType;
        ExplainCardSettingsInfo r17 = this.explainCardSettingsInfo;
        if (r17 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L47:
        if (r16 != r17.e()) goto L49;
        return true;
    L49:
        return false;
    L32:
        if (Intrinsics.areEqual(r12, r13) == false) goto L34;
        r14 = true;
    L28:
        r9 = "";
    L41:
        r15 = false;
    L51:
        return false;
    }

    private final void refreshCard() {
        s<com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.b> r0 = getExplainCardInfo();
        ExplainCardSettingsInfo r1 = this.explainCardSettingsInfo;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L5:
        ShelfCardInfo r2 = r1.shelfCardInfo;
        if (r2 == null) goto L15;
        ExplainCardSettingsInfo r4 = this.explainCardSettingsInfo;
        if (r4 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L10:
        ShelfMicroAppInfo r5 = r4.g();
        if (r5 == null) goto L13;
        String r6 = r5.name;
    L14:
        String r7 = r2.i(r6);
    L16:
        ExplainCardSettingsInfo r3 = this.explainCardSettingsInfo;
        if (r3 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L19:
        ShelfCardInfo r8 = r3.shelfCardInfo;
        if (r8 == null) goto L22;
        String r9 = r8.h();
    L23:
        ExplainCardSettingsInfo r10 = this.explainCardSettingsInfo;
        if (r10 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L26:
        ShelfMicroAppInfo r11 = r10.g();
        if (r11 == null) goto L29;
        ImageModel r12 = r11.icon;
    L30:
        ExplainCardSettingsInfo r13 = this.explainCardSettingsInfo;
        if (r13 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L33:
        ShelfMicroAppInfo r14 = r13.g();
        if (r14 == null) goto L36;
        String r15 = r14.name;
    L37:
        ExplainCardSettingsInfo r16 = this.explainCardSettingsInfo;
        if (r16 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L40:
        ShelfCardInfo r17 = r16.shelfCardInfo;
        if (r17 == null) goto L45;
        ProductInfo r18 = r17.getProductInfo();
        if (r18 == null) goto L45;
        String r19 = r18.actionText;
    L46:
        postValue(r0, new com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.b(r7, r9, r12, r15, r19, 387));
        updateCustomCover();
        refreshCustomTitle();
        return;
    L45:
        r19 = null;
        goto L46
    L36:
        r15 = null;
        goto L37
    L29:
        r12 = null;
        goto L30
    L22:
        r9 = null;
        goto L23
    L13:
        r6 = null;
        goto L14
    L15:
        r7 = null;
        goto L16
    }

    private final void refreshCustomTitle() {
        s<String> r0 = getCustomTitle();
        ExplainCardSettingsInfo r1 = this.explainCardSettingsInfo;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L5:
        ShelfCardInfo r2 = r1.shelfCardInfo;
        String r3 = null;
        if (r2 == null) goto L14;
        ExplainCardSettingsInfo r4 = this.explainCardSettingsInfo;
        if (r4 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L10:
        ShelfMicroAppInfo r5 = r4.g();
        if (r5 == null) goto L13;
        r3 = r5.name;
    L13:
        r3 = r2.i(r3);
    L14:
        postValue(r0, r3);
    }

    private final void updateCustomCover() {
        s<d> r0 = getCustomCover();
        ExplainCardSettingsInfo r1 = this.explainCardSettingsInfo;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L5:
        ShelfCardInfo r2 = r1.shelfCardInfo;
        if (r2 == null) goto L8;
        Integer r3 = Integer.valueOf(r2.c0());
    L9:
        if (r3 != null) goto L12;
    L21:
        if (r3 != null) goto L24;
    L26:
        if (r3 != null) goto L29;
    L31:
        if (r3 != null) goto L34;
    L36:
        d r4 = d.e.b;
    L37:
        postValue(r0, r4);
        return;
    L34:
        if (r3.intValue() != 3) goto L36;
        r4 = new d.c(s1.B(2131921058));
        goto L37
    L29:
        if (r3.intValue() != 1) goto L31;
        r4 = new d.b(s1.B(2131921045));
        goto L37
    L24:
        if (r3.intValue() != 2) goto L26;
        r4 = new d.C0146d(getTextPosterDescription());
        goto L37
    L12:
        if (r3.intValue() != 4) goto L21;
        ExplainCardSettingsInfo r5 = this.explainCardSettingsInfo;
        if (r5 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L16:
        ShelfCardInfo r6 = r5.shelfCardInfo;
        if (r6 == null) goto L19;
        int r7 = r6.z();
    L20:
        r4 = buildCustomizedCoverUiState(r7);
        goto L37
    L19:
        r7 = 0;
        goto L20
    L8:
        r3 = null;
        goto L9
    }

    public final void fetchPresetData() {
        postValue(getLoadingStatus(), Boolean.TRUE);
        Lazy r0 = LiveOpenPlatformClient.c;
        MiniAppExplainCardApi r1 = (MiniAppExplainCardApi) LiveOpenPlatformClient.a.a().a(MiniAppExplainCardApi.class);
        ExplainCardSettingsInfo r2 = this.explainCardSettingsInfo;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L5:
        ShelfMicroAppInfo r3 = r2.g();
        String r4 = null;
        if (r3 == null) goto L8;
        String r5 = r3.appId;
    L9:
        ExplainCardSettingsInfo r6 = this.explainCardSettingsInfo;
        if (r6 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L12:
        ShelfCardInfo r7 = r6.shelfCardInfo;
        if (r7 == null) goto L15;
        String r8 = r7.a0();
    L16:
        ExplainCardSettingsInfo r9 = this.explainCardSettingsInfo;
        if (r9 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L19:
        ShelfCardInfo r10 = r9.shelfCardInfo;
        if (r10 == null) goto L22;
        r4 = r10.i0();
    L22:
        autoDispose(r1.getPresetCard(r5, r8, r4, false).compose(RxUtil.rxSchedulerHelper()).subscribe(new e(this), new f(this)));
        return;
    L15:
        r8 = null;
        goto L16
    L8:
        r5 = null;
        goto L9
    }

    public final String getExplainCardTitle() {
        return (String) getCustomTitle().a.getValue();
    }

    public final void observerData() {
        autoDispose(com.bytedance.android.live.openplatform.impl.base.utils.m.f(xs2.b.a().b(ExplainCardSettingDialog.a.class), new C03181(this)));
    }

    public void onCleared() {
        super.onCleared();
        dispose();
    }

    public static final /* synthetic */ ExplainCardSettingsInfo access$getExplainCardSettingsInfo$li(ExplainCardSettingViewModel r0) {
        return r0.explainCardSettingsInfo;
    }

    public static final /* synthetic */ ExplainCardSettingsInfo access$getExplainCardSettingsInfo$p(ExplainCardSettingViewModel r1) {
        ExplainCardSettingsInfo r2 = r1.explainCardSettingsInfo;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L5:
        return r2;
    }

    public static final /* synthetic */ void access$refreshCard(ExplainCardSettingViewModel r0) {
        r0.refreshCard();
    }

    private final d buildCustomizedCoverUiState(int r10) {
        if (r10 != 2) goto L5;
        String r11 = getTextPosterDescription();
    L6:
        ExplainCardSettingsInfo r1 = this.explainCardSettingsInfo;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L9:
        ShelfCardInfo r2 = r1.shelfCardInfo;
        String r3 = "";
        if (r2 != null) goto L12;
    L14:
        ExplainCardSettingsInfo r4 = this.explainCardSettingsInfo;
        if (r4 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L17:
        ShelfCardInfo r5 = r4.shelfCardInfo;
        if (r5 != null) goto L20;
    L31:
        String r6 = "";
    L32:
        ExplainCardSettingsInfo r7 = this.explainCardSettingsInfo;
        if (r7 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L35:
        ShelfCardInfo r8 = r7.shelfCardInfo;
        if (r8 == null) goto L42;
        String r9 = r8.D();
        if (r9 == null) goto L42;
        r3 = r9;
    L42:
        return new d.a(r11, r6, r3);
    L20:
        if (r5.getCardId() != 0) goto L31;
        ExplainCardSettingsInfo r12 = this.explainCardSettingsInfo;
        if (r12 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L24:
        ShelfCardInfo r13 = r12.shelfCardInfo;
        if (r13 == null) goto L31;
        String r14 = r13.D();
        if (r14 == null) goto L31;
        if ((!StringsKt.isBlank(r14)) != true) goto L31;
        r6 = s1.B(2131920882);
        goto L32
    L12:
        if (r2.H0(1) != true) goto L14;
        r6 = s1.B(2131921052);
        goto L32
    L5:
        r11 = s1.B(2131920936);
        goto L6
    }

    private final void setExplainCardTitle(String r28) {
        ExplainCardSettingsInfo r1 = this.explainCardSettingsInfo;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L5:
        ExplainCardSettingsInfo r3 = this.explainCardSettingsInfo;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L8:
        ShelfCardInfo r4 = r3.shelfCardInfo;
        com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.b r5 = null;
        if (r4 == null) goto L11;
        ShelfCardInfo r6 = ShelfCardInfo.g(r4, null, null, null, r28, true, null, 0, 0, null, null, null, 0, null, null, null, null, null, 0, 0, -97, 7);
    L12:
        this.explainCardSettingsInfo = ExplainCardSettingsInfo.a(r1, r6);
        postValue(getCustomTitle(), r28);
        s<com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.b> r2 = getExplainCardInfo();
        com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.b r7 = (com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.b) getExplainCardInfo().a.getValue();
        if (r7 == null) goto L29;
        ExplainCardSettingsInfo r8 = this.explainCardSettingsInfo;
        if (r8 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L17:
        ShelfCardInfo r9 = r8.shelfCardInfo;
        if (r9 == null) goto L27;
        ExplainCardSettingsInfo r10 = this.explainCardSettingsInfo;
        if (r10 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L22:
        ShelfMicroAppInfo r11 = r10.g();
        if (r11 == null) goto L25;
        String r12 = r11.name;
    L26:
        String r13 = r9.i(r12);
    L28:
        r5 = com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.b.a(r7, r13, null, 507);
        goto L29
    L25:
        r12 = null;
        goto L26
    L27:
        r13 = null;
    L29:
        postValue(r2, r5);
        return;
    L11:
        r6 = null;
        goto L12
    }

    private final void setTextPosterTitle(final String r6) {
        int r0 = TextPosterHelper.a;
        ExplainCardSettingsInfo r1 = this.explainCardSettingsInfo;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L5:
        ShelfCardInfo r2 = r1.shelfCardInfo;
        if (r2 == null) goto L8;
        ProductInfo r3 = r2.getProductInfo();
    L9:
        final String r4 = TextPosterHelper.a(r3);
        if (r4 != null) goto L14;
        if (r2 == null) goto L13;
        r4 = r2.I();
        goto L14
    L13:
        r4 = null;
    L14:
        String r5 = "";
        if (r4 != null) goto L17;
        r4 = "";
    L17:
        int r7 = qo0.a.a;
        qo0.a.c(TAG, "new title: " + r6 + ", default title: " + r4);
        so0.a r8 = this.miniAppAnchorService;
        if (r8 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L20:
        OpenPlatformContext r9 = r8.a();
        Intrinsics.checkNotNull(r9);
        Context r10 = r9.getContext();
        String r11 = getAppId();
        if (r11 == null) goto L24;
        r5 = r11;
    L24:
        Disposable r12 = TextPosterHelper.c(r10, r5, r6, new C03201(this, r6, r4), null);
        if (r12 == null) goto L28;
        autoDispose(r12);
        return;
    L28:
        return;
    L8:
        r3 = null;
        goto L9
    }

    public final void changeCover(int r2) {
        postValue(getChangeCoverEvent(), Integer.valueOf(r2));
    }

    public final void changeTitle(b r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        String r0 = r3.b;
        int r4 = r3.a;
        if (r4 != 1) goto L5;
        setExplainCardTitle(r0);
        return;
    L5:
        if (r4 != 2) goto L11;
        setTextPosterTitle(r0);
        return;
    }

    public final void initData(ExplainCardSettingsInfo r6) {
        Intrinsics.checkNotNullParameter(r6, "explainCardSettingsInfo");
        this.explainCardSettingsInfo = r6;
        this.originExplainCardSettingsInfo = r6;
        refreshCard();
        s<Boolean> r7 = isIntroducing();
        ExplainCardSettingsInfo r1 = this.explainCardSettingsInfo;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L5:
        ShelfCardInfo r0 = r1.shelfCardInfo;
        if (r0 != null) goto L8;
    L10:
        boolean r2 = false;
    L11:
        postValue(r7, Boolean.valueOf(r2));
        return;
    L8:
        if (r0.getStatus() != 1) goto L10;
        r2 = true;
        goto L11
    }

    public final void setIsIntroducing(boolean r28) {
        postValue(isIntroducing(), Boolean.valueOf(r28));
        ExplainCardSettingsInfo r1 = this.explainCardSettingsInfo;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L5:
        ExplainCardSettingsInfo r3 = this.explainCardSettingsInfo;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L8:
        ShelfCardInfo r4 = r3.shelfCardInfo;
        if (r4 != null) goto L11;
        ShelfCardInfo r2 = null;
    L16:
        this.explainCardSettingsInfo = ExplainCardSettingsInfo.a(r1, r2);
        return;
    L11:
        if (r28 == false) goto L13;
        long r5 = 1;
    L14:
        r2 = ShelfCardInfo.g(r4, null, null, null, null, false, null, r5, 0, null, null, null, 0, null, null, null, null, null, 0, 0, -8193, 7);
        goto L16
    L13:
        r5 = 0;
        goto L14
    }

    @Inject
    public final void setMiniAppAnchorService(so0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.miniAppAnchorService = r2;
    }

    public static final /* synthetic */ void access$setExplainCardSettingsInfo$li(ExplainCardSettingViewModel r0, ExplainCardSettingsInfo r1) {
        r0.explainCardSettingsInfo = r1;
    }

    public static final /* synthetic */ void access$setExplainCardSettingsInfo$p(ExplainCardSettingViewModel r0, ExplainCardSettingsInfo r1) {
        r0.explainCardSettingsInfo = r1;
    }

    private final <T> void postValue(s<T> r2, T r3) {
        r2.getClass();
        Intrinsics.checkNotNullParameter(this, "$this$setValue");
        r2.a.postValue(r3);
    }

    public static final /* synthetic */ void access$postValue(ExplainCardSettingViewModel r0, s r1, Object r2) {
        r0.postValue(r1, r2);
    }

    private final ExplainCardSettingsInfo buildCustomizedCoverSettingsInfo(ShelfCardInfo r27, int r28, String r29) {
        ExplainCardSettingsInfo r1 = this.explainCardSettingsInfo;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L5:
        ExplainCardSettingsInfo r3 = this.explainCardSettingsInfo;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L8:
        ShelfCardInfo r4 = r3.shelfCardInfo;
        if (r4 == null) goto L20;
        List<AuditInfo> r5 = r4.q();
        if (r5 == null) goto L20;
        List<AuditInfo> r6 = r5;
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r7 = r6.iterator();
    L14:
        if (r7.hasNext() == false) goto L19;
        AuditInfo r14 = (AuditInfo) r7.next();
        if (r14.b() != 1) goto L18;
        r14 = AuditInfo.a(r14);
    L18:
        r13.add(r14);
        goto L14
    L19:
        ArrayList r15 = r13;
    L21:
        int r16 = ShelfCardInfo.Source.Phone.getValue();
        ExplainCardSettingsInfo r12 = this.explainCardSettingsInfo;     // Catch: JSONException -> L41
        if (r12 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");     // Catch: JSONException -> L41
    L25:
        ShelfCardInfo r2 = r12.shelfCardInfo;     // Catch: JSONException -> L41
        if (r2 == null) goto L29;
        String r8 = r2.t();     // Catch: JSONException -> L41
        if (r8 == null) goto L29;
    L30:
        JSONObject r9 = new JSONObject(r8);     // Catch: JSONException -> L41
        so0.a r17 = this.miniAppAnchorService;     // Catch: JSONException -> L41
        if (r17 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");     // Catch: JSONException -> L41
    L33:
        OpenPlatformContext r18 = r17.a();     // Catch: JSONException -> L41
        if (r18 != null) goto L36;
    L38:
        String r10 = "before_live";
    L39:
        r9.put("adding_page_live_status", r10);     // Catch: JSONException -> L41
        Unit r11 = Unit.INSTANCE;     // Catch: JSONException -> L41
        String r19 = r9.toString();     // Catch: JSONException -> L41
    L43:
        return ExplainCardSettingsInfo.a(r1, ShelfCardInfo.g(r27, null, null, null, null, false, r29, 0, r16, r19, r15, null, 0, null, null, null, null, null, 4, r28, -4293762, 1));
    L36:
        if (r18.isInLive() != true) goto L38;
        r10 = "in_live";
    L29:
        r8 = "{}";
    L41:
        r19 = null;
    L20:
        r15 = null;
        goto L21
    }

    private final ExplainCardSettingsInfo buildNonCustomizedCoverSettingsInfo(ShelfCardInfo r27, int r28, String r29) {
        ExplainCardSettingsInfo r1 = this.explainCardSettingsInfo;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L5:
        ExplainCardSettingsInfo r3 = this.explainCardSettingsInfo;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L8:
        ShelfCardInfo r2 = r3.shelfCardInfo;
        if (r2 == null) goto L20;
        List<AuditInfo> r4 = r2.q();
        if (r4 == null) goto L20;
        List<AuditInfo> r5 = r4;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r7 = r5.iterator();
    L14:
        if (r7.hasNext() == false) goto L19;
        AuditInfo r8 = (AuditInfo) r7.next();
        if (r8.b() != 1) goto L18;
        r8 = AuditInfo.a(r8);
    L18:
        r6.add(r8);
        goto L14
    L19:
        ArrayList r14 = r6;
    L22:
        return ExplainCardSettingsInfo.a(r1, ShelfCardInfo.g(r27, null, null, r29, null, false, null, 0, 0, null, r14, null, 0, null, null, null, null, null, r28, 0, -6292625, 1));
    L20:
        r14 = null;
        goto L22
    }

    public final void setCover(int r9, int r10, ImageModel r11) {
        int r0 = qo0.a.a;
        qo0.a.c(TAG, "set cover, type: " + r9 + ", customized type: " + r10 + ", img: " + r11);
        ExplainCardSettingsInfo r1 = this.explainCardSettingsInfo;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L5:
        ShelfCardInfo r2 = r1.shelfCardInfo;
        if (r2 == null) goto L79;
        if (r9 == 0) goto L80;
        com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.b r3 = null;
        if (r9 == 1) goto L52;
        if (r9 == 2) goto L42;
        if (r9 != 3) goto L14;
        String r12 = r2.b0();
        if (r12 != null) goto L35;
    L38:
        boolean r13 = true;
    L39:
        if (r13 == false) goto L41;
        return;
    L41:
        ExplainCardSettingsInfo r14 = buildNonCustomizedCoverSettingsInfo(r2, r9, r12);
    L62:
        this.explainCardSettingsInfo = r14;
        updateCustomCover();
        if (r9 == 1) goto L66;
        if (r9 == 2) goto L66;
        if (r9 == 3) goto L66;
    L67:
        s<com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.b> r15 = getExplainCardInfo();
        com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.b r16 = (com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.b) getExplainCardInfo().a.getValue();
        if (r16 == null) goto L77;
        ExplainCardSettingsInfo r17 = this.explainCardSettingsInfo;
        if (r17 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("explainCardSettingsInfo");
    L72:
        ShelfCardInfo r18 = r17.shelfCardInfo;
        if (r18 == null) goto L75;
        String r19 = r18.h();
    L76:
        r3 = com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.b.a(r16, null, r19, 503);
        goto L77
    L75:
        r19 = null;
    L77:
        postValue(r15, r3);
        return;
    L66:
        f2.b(2131920924, 0);
        goto L67
    L35:
        if (r12.length() == 0) goto L38;
        r13 = false;
        goto L39
    L14:
        if (r9 == 4) goto L16;
        return;
    L16:
        if (r10 != 0) goto L18;
        return;
    L18:
        if (r11 == null) goto L22;
        List r110 = r11.getUrls();
        if (r110 == null) goto L22;
        String r111 = (String) CollectionsKt.firstOrNull(r110);
    L23:
        if (r111 != null) goto L25;
    L28:
        boolean r7 = true;
    L29:
        if (r7 == false) goto L31;
        return;
    L31:
        r14 = buildCustomizedCoverSettingsInfo(r2, r10, r111);
        goto L62
    L25:
        if (r111.length() == 0) goto L28;
        r7 = false;
    L22:
        r111 = null;
        goto L23
    L42:
        String r112 = r2.o0();
        if (r112 != null) goto L45;
    L48:
        boolean r113 = true;
    L49:
        if (r113 == false) goto L51;
        return;
    L51:
        r14 = buildNonCustomizedCoverSettingsInfo(r2, r9, r112);
        goto L62
    L45:
        if (r112.length() == 0) goto L48;
        r113 = false;
        goto L49
    L52:
        String r114 = r2.S();
        if (r114 != null) goto L55;
    L58:
        boolean r115 = true;
    L59:
        if (r115 == false) goto L61;
        return;
    L61:
        r14 = buildNonCustomizedCoverSettingsInfo(r2, r9, r114);
        goto L62
    L55:
        if (r114.length() == 0) goto L58;
        r115 = false;
        goto L59
    L80:
        return;
    }

    public static /* synthetic */ void setCover$default(ExplainCardSettingViewModel r0, int r1, int r2, ImageModel r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = null;
    L8:
        r0.setCover(r1, r2, r3);
    }
}
