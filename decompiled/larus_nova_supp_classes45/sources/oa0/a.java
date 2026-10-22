package oa0;

import android.util.Base64;
import android.util.Pair;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.impl.strategy.Strategy;
import com.bytedance.android.live.impl.strategy.StrategyPlatformApiForSaas;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.jsbridge.methods.draft.m;
import com.bytedance.android.livesdk.z2;
import com.bytedance.android.livesdkapi.api.IUtilsCommonService;
import com.bytedance.android.livesdkapi.depend.model.live.StrategyInitConfig;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import j40.i3;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static int a;
    public static String b;
    public static long c;
    public static long d;
    public static volatile boolean e;
    public static final StrategyInitConfig f = null;

    /* JADX INFO: renamed from: oa0.a$a, reason: collision with other inner class name */
    public static final class C0254a<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ Function1 b;

        public C0254a(long r1, Function1 r3) {
            this.a = r1;
            this.b = r3;
        }

        public final void accept(Object r9) {
            Response r11 = (Response) r9;
            int r0 = a.a;
            a.c = System.currentTimeMillis() - this.a;
            long r1 = System.currentTimeMillis();
            if (r11 == null) goto L5;
            Strategy r3 = (Strategy) ((BaseResponse) r11).data;
        L6:
            boolean r4 = false;
            if (r3 == null) goto L20;
            if (r11 == null) goto L12;
            Strategy r5 = (Strategy) ((BaseResponse) r11).data;
            if (r5 == null) goto L12;
            String r6 = r5.getId();
        L14:
            if (StringsKt.equals$default(r6, "", false, 2, null) == true) goto L20;
            a.a = 1008;
            SharedPrefHelper.b(s1.getContext()).l("ttlivesdk_strategy_hash", ((Strategy) ((BaseResponse) r11).data).getStrategyHash());
            SharedPrefHelper.b(s1.getContext()).l("ttlivesdk_strategy_id", ((Strategy) ((BaseResponse) r11).data).getId());
            SharedPrefHelper.b(s1.getContext()).l("ttlivesdk_strategy_data", GsonProtectorUtils.toJson(new Gson(), ((BaseResponse) r11).data));
            Strategy r2 = (Strategy) ((BaseResponse) r11).data;
            Intrinsics.checkNotNullParameter(r2, "strategy");
            if (Intrinsics.areEqual(i3.a.getValue(), Boolean.FALSE) == true) goto L19;
            ByteArrayOutputStream r7 = new ByteArrayOutputStream();
            ObjectOutputStream r8 = new ObjectOutputStream(r7);
            r8.writeObject(r2);
            SharedPrefHelper.b(s1.getContext()).m("ttlivesdk_strategy_data_v2", Base64.encodeToString(r7.toByteArray(), 2));
            r7.close();
            r8.close();
        L19:
            SharedPrefHelper.b(s1.getContext()).a();
            a.d = System.currentTimeMillis() - r1;
            this.b.invoke(((BaseResponse) r11).data);
            return;
        L12:
            r6 = null;
        L20:
            Strategy r12 = a.b();
            if (r12 == null) goto L23;
            a.d = System.currentTimeMillis() - r1;
            this.b.invoke(r12);
            return;
        L23:
            String r13 = SharedPrefHelper.b(s1.getContext()).j("ttlivesdk_strategy_data", "");
            if (r13 != null) goto L26;
        L27:
            r4 = true;
        L28:
            if (r4 == true) goto L30;
            a.a = 1009;
            Strategy r14 = (Strategy) GsonProtectorUtils.fromJson(new Gson(), r13, Strategy.class);
            a.d = System.currentTimeMillis() - r1;
            this.b.invoke(r14);
            return;
        L30:
            a.a = 1005;
            return;
        L26:
            if (r13.length() != 0) goto L28;
        L5:
            r3 = null;
            goto L6
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ Function1 b;

        public b(long r1, Function1 r3) {
            this.a = r1;
            this.b = r3;
        }

        public final void accept(Object r7) {
            Throwable r8 = (Throwable) r7;
            Intrinsics.checkNotNullParameter(r8, "obj");
            long r0 = System.currentTimeMillis();
            int r2 = a.a;
            a.c = System.currentTimeMillis() - this.a;
            String r9 = String.valueOf(r8.getMessage());
            Intrinsics.checkNotNullParameter(r9, "<set-?>");
            a.b = r9;
            Strategy r11 = a.b();
            if (r11 == null) goto L5;
            a.d = System.currentTimeMillis() - r0;
            this.b.invoke(r11);
            return;
        L5:
            String r12 = SharedPrefHelper.b(s1.getContext()).j("ttlivesdk_strategy_data", "");
            a.a = 1006;
            if (r12 != null) goto L8;
        L11:
            boolean r3 = true;
        L12:
            if (r3 == true) goto L14;
            Strategy r13 = (Strategy) GsonProtectorUtils.fromJson(new Gson(), r12, Strategy.class);
            a.d = System.currentTimeMillis() - r0;
            this.b.invoke(r13);
            return;
        L14:
            a.a = 1007;
            return;
        L8:
            if (r12.length() == 0) goto L11;
            r3 = false;
            goto L12
        }
    }

    public static final class c extends BDNetworkTagContextProviderAdapter {
        public final int triggerType() {
            return 0;
        }

        public c() {
        }
    }

    static {
        a = -1;
        b = "";
        c = -1;
        d = -1;
        f = (StrategyInitConfig) z2.a.getValue();
    }

    public static Strategy b() {
        if (Intrinsics.areEqual(i3.a.getValue(), Boolean.FALSE) == false) goto L5;
    L21:
        return null;
    L5:
        if (e == true) goto L21;
        boolean r0 = true;
        e = true;
        String r2 = SharedPrefHelper.b(s1.getContext()).j("ttlivesdk_strategy_data_v2", "");
        if (r2 != null) goto L10;
    L13:
        if (r0 == false) goto L15;
        return null;
    L15:
        ByteArrayInputStream r1 = new ByteArrayInputStream(Base64.decode(r2, 2));
        ObjectInputStream r3 = new ObjectInputStream(r1);
        r1.close();
        r3.close();
        a = 1010;
        Object r4 = r3.readObject();
        if (r4 == null) goto L20;
        return (Strategy) r4;
    L20:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.impl.strategy.Strategy");
    L10:
        if (r2.length() == 0) goto L13;
        r0 = false;
        goto L13
    }

    public static Strategy a(boolean r7) {
        Strategy r0 = b();
        if (r0 == null) goto L5;
        return r0;
    L5:
        long r1 = System.currentTimeMillis();
        boolean r2 = true;
        if (r7 == false) goto L16;
        String r8 = SharedPrefHelper.b(s1.getContext()).j("ttlivesdk_strategy_slice_data", "");
        if (r8 != null) goto L10;
    L13:
        boolean r6 = true;
    L14:
        if (r6 == false) goto L17;
        r8 = SharedPrefHelper.b(s1.getContext()).j("ttlivesdk_strategy_data", "");
    L17:
        if (r8 != null) goto L19;
    L22:
        if (r2 == true) goto L25;
        Strategy r9 = (Strategy) GsonProtectorUtils.fromJson(new Gson(), r8, Strategy.class);
        d = System.currentTimeMillis() - r1;
        return r9;
    L25:
        return null;
    L19:
        if (r8.length() == 0) goto L22;
        r2 = false;
        goto L22
    L10:
        if (r8.length() == 0) goto L13;
        r6 = false;
        goto L14
    L16:
        r8 = SharedPrefHelper.b(s1.getContext()).j("ttlivesdk_strategy_data", "");
        goto L17
    }

    public static void c(Function1 r8) {
        Intrinsics.checkNotNullParameter(r8, "init");
        long r0 = System.currentTimeMillis();
        String r4 = "-1";
        String r2 = SharedPrefHelper.b(s1.getContext()).j("ttlivesdk_strategy_hash", "-1");
        Boolean r3 = Boolean.valueOf(SharedPrefHelper.b(s1.getContext()).f("ttlivesdk_strategy_sp_last_v2", false));
        i3 r6 = i3.a;
        if ((!Intrinsics.areEqual(r3, r6.getValue())) == false) goto L5;
        SharedPrefHelper.b(s1.getContext()).l("ttlivesdk_strategy_sp_last_v2", r6.getValue());
    L6:
        Pair r5 = BDNetworkTagManager.getInstance().buildBDNetworkTag(new c());
        if (r5 == null) goto L10;
        String r7 = (String) r5.second;
        if (r7 == null) goto L10;
    L11:
        ((du2.a) ((StrategyPlatformApiForSaas) k.n(IUtilsCommonService.class).liveClientGetService(StrategyPlatformApiForSaas.class)).fetchStrategySource(r7, r4).as(new du2.b())).g(3).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(new C0254a(r0, r8), new b(r0, r8));
        return;
    L10:
        r7 = "";
        goto L11
    L5:
        r4 = r2;
        goto L6
    }

    public static void d(Strategy r2) {
        Intrinsics.checkNotNullParameter(r2, "strategy");
        StrategyInitConfig r0 = f;
        if (r0.getEnableUseSliceStrategy() == true) goto L5;
        return;
    L5:
        Strategy r3 = r2.deepCopy().filterUsefulCombineInfoByFactors(CollectionsKt.toMutableSet(r0.getStrategyInitFactors()));
        if (r3 == null) goto L9;
        String r4 = m.a(r3);
        if (r4 == null) goto L9;
    L10:
        SharedPrefHelper.b(s1.getContext()).l("ttlivesdk_strategy_slice_data", r4);
        SharedPrefHelper.b(s1.getContext()).a();
        return;
    L9:
        r4 = "";
        goto L10
    }
}
