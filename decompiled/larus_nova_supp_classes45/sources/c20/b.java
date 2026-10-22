package c20;

import a20.k;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.broadcastgame.api.model.OpenFeatureScene;
import com.bytedance.android.live.broadcastgame.api.model.l0;
import com.bytedance.android.live.broadcastgame.api.model.m0;
import com.bytedance.android.live.broadcastgame.api.model.p;
import com.bytedance.android.live.broadcastgame.api.stampavailable.OpenPlatformApi;
import com.bytedance.android.live.broadcastgame.opengame.network.LiveOpenGameClient;
import com.bytedance.android.live.broadcastgame.opengame.q;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.config.sd0;
import com.bytedance.android.livesdk.config.td0;
import com.bytedance.android.livesdk.live.extension.plugin.api.effectsdk.ILiveWrappedEffectSDKService;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.reflect.TypeToken;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements k {
    public final SharedPrefHelper a;
    public final LinkedList<String> b;
    public final String c;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"c20/b$a", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/LinkedList;", "", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<LinkedList<String>> {
        public a() {
        }
    }

    /* JADX INFO: renamed from: c20.b$b, reason: collision with other inner class name */
    public static final class C0003b {
    }

    public static final class c<T> implements ObservableOnSubscribe {
        public final /* synthetic */ b a;
        public final /* synthetic */ String b;

        public c(b r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void subscribe(ObservableEmitter<p> r18) {
            Intrinsics.checkNotNullParameter(r18, "it");
            b r0 = this.a;
            String r4 = this.b;
            r0.getClass();
            StringBuffer r5 = new StringBuffer();
            FileInputStream r9 = null;
            PolarisFileWrapper r11 = new PolarisFileWrapper(r4);     // Catch: Throwable -> L7 IOException -> L9 FileNotFoundException -> L11
            String r12 = "";
            if (r11.exists() == true) goto L14;
            int r13 = q.a;     // Catch: Throwable -> L7 IOException -> L9 FileNotFoundException -> L11
            q.g("cacheFile name: " + r4 + " no exists.", "OpenFeaturePanelModel");     // Catch: Throwable -> L7 IOException -> L9 FileNotFoundException -> L11
        L46:
            if (r12.length() <= 0) goto L48;
            boolean r6 = true;
        L49:
            if (r6 == false) goto L54;
            p r1 = (p) GsonProtectorUtils.fromJson(GsonHelper.get(), r12, p.class);
            if (r1 == null) goto L53;
            r18.onNext(r1);
        L55:
            r18.onComplete();
            return;
        L53:
            r18.onError(new Throwable("gson convert error"));
            goto L55
        L54:
            r18.onError(new Throwable("no cache"));
            goto L55
        L48:
            r6 = false;
            goto L49
        L14:
            if ((System.currentTimeMillis() - r11.lastModified()) <= ((Integer) sd0.a.getValue()).intValue()) goto L16;
            b.k("", r4);     // Catch: Throwable -> L7 IOException -> L9 FileNotFoundException -> L11
            int r2 = q.a;     // Catch: Throwable -> L7 IOException -> L9 FileNotFoundException -> L11
            q.g("cacheFile name is out of time.", "OpenFeaturePanelModel");     // Catch: Throwable -> L7 IOException -> L9 FileNotFoundException -> L11
            goto L46
        L16:
            FileInputStream r7 = new PolarisFileInputStreamWrapper(r11);     // Catch: Throwable -> L7 IOException -> L9 FileNotFoundException -> L11
            BufferedReader r3 = new BufferedReader(new InputStreamReader(r7, "UTF-8"));     // Catch: Throwable -> L29 IOException -> L31 FileNotFoundException -> L33
            String r8 = r3.readLine();     // Catch: Throwable -> L29 IOException -> L31 FileNotFoundException -> L33
        L18:
            if (r8 == null) goto L23;
            if (r8.length() == 0) goto L23;
            boolean r14 = false;
        L24:
            if (r14 == true) goto L27;
            r5.append(r8);     // Catch: Throwable -> L29 IOException -> L31 FileNotFoundException -> L33
            r8 = r3.readLine();     // Catch: Throwable -> L29 IOException -> L31 FileNotFoundException -> L33
            goto L18
        L27:
            r7.close();     // Catch: IOException -> L42
        L67:
        L44:
            r12 = r5.toString();
            goto L46
        L23:
            r14 = true;
        L33:
            e = e;
            r9 = r7;
        L38:
            q.j(e, "OpenFeaturePanelModel", 4);     // Catch: Throwable -> L7
            if (r9 == null) goto L44;
        L40:
            r9.close();     // Catch: IOException -> L42
        L31:
            e = e;
            r9 = r7;
        L35:
            q.j(e, "OpenFeaturePanelModel", 4);     // Catch: Throwable -> L7
            if (r9 == null) goto L44;
        L29:
            th = move-exception;
            Throwable r15 = th;
        L58:
            if (r7 == null) goto L73;
            r7.close();     // Catch: IOException -> L61
            throw r15;
        L61:
            e = move-exception;
            int r16 = q.a;
            q.j(e, "OpenFeaturePanelModel", 4);
            throw r15;
        L73:
            throw r15;
        L7:
            th = move-exception;
            r15 = th;
            r7 = null;
        L11:
            e = e;
        L9:
            e = e;
        L42:
            e = move-exception;
            q.j(e, "OpenFeaturePanelModel", 4);
            goto L44
        }
    }

    public static final class d<T> implements ObservableOnSubscribe {
        public final /* synthetic */ b a;
        public final /* synthetic */ p b;
        public final /* synthetic */ String c;

        public d(b r1, p r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void subscribe(ObservableEmitter<Unit> r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            String r0 = GsonProtectorUtils.toJson(GsonHelper.get(), this.b);
            b r1 = this.a;
            String r2 = this.c;
            r1.getClass();
            b.k(r0, r2);
            int r3 = q.a;
            q.h("写入本地缓存，当前线程是否是主线程" + MainThreadPostUtils.a());
            r4.onComplete();
        }
    }

    static {
    }

    @Override // a20.k
    public final void b() {
        this.a.m(this.c, GsonProtectorUtils.toJson(GsonHelper.getDefault(), this.b));
    }

    public b() {
        SharedPrefHelper r0 = SharedPrefHelper.b(s1.getContext());
        this.a = r0;
        this.b = new LinkedList();
        String r1 = "opensearch:" + jc1.k.n(IUserService.class).user().n();
        this.c = r1;
        LinkedList<String> r2 = (LinkedList) GsonHelper.getDefault().fromJson(r0.j(r1, ""), new a().getType());     // Catch: Exception -> L7
        if (r2 != null) goto L9;
        r2 = new LinkedList();     // Catch: Exception -> L7
    L9:
        this.b = r2;
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        r2 = new LinkedList();
        goto L9
    }

    @Override // a20.k
    public final LinkedList<String> a() {
        return this.b;
    }

    @Override // a20.k
    public final void h(String r2) {
        Intrinsics.checkNotNullParameter(r2, "keyWord");
        if (this.b.contains(r2) == false) goto L5;
        this.b.remove(r2);
    L5:
        this.b.add(r2);
        if (this.b.size() <= 6) goto L13;
        LinkedList<String> r3 = this.b;
        if ((r3 instanceof Queue) == true) goto L10;
        r3 = null;
    L10:
        if (r3 == null) goto L14;
        String r4 = r3.poll();
        return;
    L14:
        return;
    }

    public static void k(String r4, String r5) {
        int r0 = q.a;
        q.g(r5, "OpenFeaturePanelModel");
        FileOutputStream r2 = null;
        PolarisFileWrapper r3 = new PolarisFileWrapper(r5);     // Catch: Throwable -> L22 IOException -> L24 FileNotFoundException -> L28
        if (r3.exists() == true) goto L6;
        r3.getParentFile().mkdirs();     // Catch: Throwable -> L22 IOException -> L24 FileNotFoundException -> L28
        r3.createNewFile();     // Catch: Throwable -> L22 IOException -> L24 FileNotFoundException -> L28
    L6:
        FileOutputStream r6 = new PolarisFileOutputStreamWrapper(r3);     // Catch: Throwable -> L22 IOException -> L24 FileNotFoundException -> L28
    L51:
        Charset r7 = Charsets.UTF_8;     // Catch: Throwable -> L16 IOException -> L18 FileNotFoundException -> L20
        if (r4 == null) goto L15;
        r6.write(r4.getBytes(r7));     // Catch: Throwable -> L16 IOException -> L18 FileNotFoundException -> L20
        r6.close();     // Catch: IOException -> L12
        return;
    L12:
        e = e;
        int r8 = q.a;
    L34:
        q.j(e, "OpenFeaturePanelModel", 4);
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Throwable -> L16 IOException -> L18 FileNotFoundException -> L20
    L20:
        e = e;
        r2 = r6;
    L29:
        q.j(e, "OpenFeaturePanelModel", 4);     // Catch: Throwable -> L22
        if (r2 == null) goto L53;
    L43:
        r2.close();     // Catch: IOException -> L33
        return;
    L33:
        e = e;
        goto L34
    L53:
        return;
    L18:
        e = e;
        r2 = r6;
    L25:
        q.j(e, "OpenFeaturePanelModel", 4);     // Catch: Throwable -> L22
        if (r2 != null) goto L43;
        return;
    L16:
        th = th;
    L37:
        if (r6 != null) goto L45;
    L42:
        throw th;
    L45:
        r6.close();     // Catch: IOException -> L40
    L40:
        e = move-exception;
        int r9 = q.a;
        q.j(e, "OpenFeaturePanelModel", 4);
    L22:
        th = th;
        r6 = null;
    L28:
        e = e;
    L24:
        e = e;
        goto L25
    }

    @Override // a20.k
    public final Observable<p> e(@OpenFeatureScene long r5, String r7) {
        Intrinsics.checkNotNullParameter(r7, "cacheFileName");
        if (r5 != 1) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(td0.a.getValue(), Boolean.FALSE) == false) goto L10;
        int r6 = q.a;
        q.g("不加载缓存的本地列表数据", "OpenFeaturePanelModel");
        return null;
    L10:
        return Observable.create(new c(this, r7)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override // a20.k
    public final Observable<Unit> f(p r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "resp");
        Intrinsics.checkNotNullParameter(r4, "fileName");
        if (Intrinsics.areEqual(td0.a.getValue(), Boolean.FALSE) == false) goto L7;
        int r5 = q.a;
        q.g("Don't save data to local.", "OpenFeaturePanelModel");
        return null;
    L7:
        return Observable.create(new d(this, r3, r4)).subscribeOn(Schedulers.io());
    }

    @Override // a20.k
    public final Observable<e<l0>> i(long r3, String r5) {
        Intrinsics.checkNotNullParameter(r5, "effectSdkVersion");
        return ((OpenPlatformApi) ((LiveOpenGameClient) LiveOpenGameClient.e.getValue()).a(OpenPlatformApi.class)).fetchFeatureAllItemList(r3, r5).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override // a20.k
    public final Observable<e<m0>> g(@OpenFeatureScene long r11, Long r13, int r14, String r15) {
        Intrinsics.checkNotNullParameter(r15, "keyWord");
        OpenPlatformApi r1 = (OpenPlatformApi) ((LiveOpenGameClient) LiveOpenGameClient.e.getValue()).a(OpenPlatformApi.class);
        if (r11 != 2) goto L8;
        ILiveWrappedEffectSDKService.Companion.getClass();
        ILiveWrappedEffectSDKService r0 = ILiveWrappedEffectSDKService.a.a();
        if (r0 == null) goto L8;
        String r2 = r0.getSdkVersion();
        if (r2 == null) goto L8;
    L10:
        return r1.searchEntranceV3(r11, r13, r15, r2, r14, 2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    L8:
        r2 = "";
        goto L10
    }

    @Override // a20.k
    public final Observable<e<m0>> j(@OpenFeatureScene long r9, Long r11, int r12, String r13) {
        Intrinsics.checkNotNullParameter(r13, "keyWord");
        OpenPlatformApi r1 = (OpenPlatformApi) ((LiveOpenGameClient) LiveOpenGameClient.e.getValue()).a(OpenPlatformApi.class);
        if (r9 != 2) goto L8;
        ILiveWrappedEffectSDKService.Companion.getClass();
        ILiveWrappedEffectSDKService r0 = ILiveWrappedEffectSDKService.a.a();
        if (r0 == null) goto L8;
        String r2 = r0.getSdkVersion();
        if (r2 == null) goto L8;
    L10:
        return r1.searchEntrance(r9, r11, r13, r12, r2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    L8:
        r2 = "";
        goto L10
    }

    @Override // a20.k
    public final Observable<e<p>> c(long r11, long r13, int r15, String r16, int r17, String r18) {
        Intrinsics.checkNotNullParameter(r16, "effectSdkVersion");
        Intrinsics.checkNotNullParameter(r18, "cacheHash");
        return ((OpenPlatformApi) ((LiveOpenGameClient) LiveOpenGameClient.e.getValue()).a(OpenPlatformApi.class)).fetchFeatureList(r11, r13, r15, r16, r17, r18).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override // a20.k
    public final Observable<e<p>> d(long r14, long r16, int r18, String r19, String r21, int r22, String r23) {
        Intrinsics.checkNotNullParameter(r19, "effectSdkVersion");
        Intrinsics.checkNotNullParameter(r21, "cacheHash");
        Intrinsics.checkNotNullParameter(r23, "clickSource");
        return ((OpenPlatformApi) ((LiveOpenGameClient) LiveOpenGameClient.e.getValue()).a(OpenPlatformApi.class)).fetchFeatureListV3(r14, r16, r18, r19, r21, r23, r22, 2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
