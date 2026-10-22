package com.ss.android.lark.forsetiutils.config;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.CarUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(v28.a.class)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016J6\u0010\u0016\u001a\u0002H\u0017\"\u0004\b\u0000\u0010\u00172\u0019\u0010\u0018\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00170\u0019¢\u0006\u0002\b\u001a2\u0006\u0010\u001b\u001a\u0002H\u0017H\u0002¢\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u0007H\u0002J\b\u0010\u001e\u001a\u00020\u0007H\u0002J\b\u0010\u001f\u001a\u00020\u0007H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006!"}, d2 = {"Lcom/ss/android/lark/forsetiutils/config/CarAdaptConfigImpl;", "Lcom/larksuite/framework/utils/caradapt/ICarAdaptConfig;", "<init>", "()V", "rawConfig", "Lcom/ss/android/lark/forsetiutils/config/CarAdaptConfigData;", "defaultConfig", "Lcom/ss/android/lark/forsetiutils/config/CarAdaptConfigItem;", "getDefaultConfig", "()Lcom/ss/android/lark/forsetiutils/config/CarAdaptConfigItem;", "defaultConfig$delegate", "Lkotlin/Lazy;", "getConfig", "enableWorkplace", "", "enableSystemFilePicker", "enableResponsiveComponentContainer", "isMiniappInHostStack", "enableFontScale", "enableSendImage", "enableRedPacket", "enableThirdShare", "getValue", "T", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "defValue", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)Ljava/lang/Object;", "getXiaomiDefaultConfig", "getXiaopengDefaultConfig", "getNioDefaultConfig", "Companion", "forseti-utils_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class CarAdaptConfigImpl implements v28.a {
    public static final a Companion = null;
    private static final String TAG = "CarAdaptConfig";
    private final Lazy defaultConfig$delegate;
    private CarAdaptConfigData rawConfig;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    private final com.ss.android.lark.forsetiutils.config.a getConfig() {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        CarAdaptConfigData r3 = this.rawConfig;     // Catch: Throwable -> L11
        if (r3 == null) goto L6;
        com.ss.android.lark.forsetiutils.config.a r4 = r3.b();     // Catch: Throwable -> L11
    L7:
        if (r4 != null) goto L9;
        this.rawConfig = (CarAdaptConfigData) SettingManager.getInstance().get(CarAdaptConfigData.class);     // Catch: Throwable -> L11
        Log.i(TAG, "config: " + this.rawConfig);     // Catch: Throwable -> L11
    L9:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L14:
        if (CarUtils.c() == false) goto L19;
        CarAdaptConfigData r0 = this.rawConfig;
        if (r0 != null) goto L27;
        return null;
    L27:
        return r0.b();
    L19:
        if (CarUtils.b() == false) goto L28;
        CarAdaptConfigData r1 = this.rawConfig;
        if (r1 != null) goto L23;
        return null;
    L23:
        return r1.a();
    L28:
        return null;
    L6:
        r4 = null;
    L11:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    private final com.ss.android.lark.forsetiutils.config.a getDefaultConfig() {
        return (com.ss.android.lark.forsetiutils.config.a) this.defaultConfig$delegate.getValue();
    }

    private final com.ss.android.lark.forsetiutils.config.a getNioDefaultConfig() {
        Boolean r8 = Boolean.FALSE;
        Boolean r4 = Boolean.TRUE;
        return new com.ss.android.lark.forsetiutils.config.a(r8, r4, r4, r4, r8, r8, r8, r8);
    }

    private final com.ss.android.lark.forsetiutils.config.a getXiaomiDefaultConfig() {
        Boolean r8 = Boolean.FALSE;
        Boolean r7 = Boolean.TRUE;
        return new com.ss.android.lark.forsetiutils.config.a(r8, r7, r7, r7, r7, r7, r7, r8);
    }

    private final com.ss.android.lark.forsetiutils.config.a getXiaopengDefaultConfig() {
        Boolean r8 = Boolean.FALSE;
        Boolean r7 = Boolean.TRUE;
        return new com.ss.android.lark.forsetiutils.config.a(r8, r8, r7, r7, r7, r7, r7, r8);
    }

    public boolean enableFontScale() {
        return ((Boolean) getValue(AnonymousClass1.INSTANCE, Boolean.TRUE)).booleanValue();
    }

    public boolean enableRedPacket() {
        return ((Boolean) getValue(C03741.INSTANCE, Boolean.TRUE)).booleanValue();
    }

    public boolean enableResponsiveComponentContainer() {
        return ((Boolean) getValue(C03751.INSTANCE, Boolean.TRUE)).booleanValue();
    }

    public boolean enableSendImage() {
        return ((Boolean) getValue(C03761.INSTANCE, Boolean.TRUE)).booleanValue();
    }

    public boolean enableSystemFilePicker() {
        return ((Boolean) getValue(C03771.INSTANCE, Boolean.TRUE)).booleanValue();
    }

    public boolean enableThirdShare() {
        return ((Boolean) getValue(C03781.INSTANCE, Boolean.TRUE)).booleanValue();
    }

    public boolean enableWorkplace() {
        return ((Boolean) getValue(C03791.INSTANCE, Boolean.TRUE)).booleanValue();
    }

    public boolean isMiniappInHostStack() {
        return ((Boolean) getValue(C03801.INSTANCE, Boolean.FALSE)).booleanValue();
    }

    public CarAdaptConfigImpl() {
        this.defaultConfig$delegate = LazyKt.lazy(new CarAdaptConfigImpl$defaultConfig$2(this));
    }

    public static final /* synthetic */ com.ss.android.lark.forsetiutils.config.a access$getNioDefaultConfig(CarAdaptConfigImpl r0) {
        return r0.getNioDefaultConfig();
    }

    public static final /* synthetic */ com.ss.android.lark.forsetiutils.config.a access$getXiaomiDefaultConfig(CarAdaptConfigImpl r0) {
        return r0.getXiaomiDefaultConfig();
    }

    public static final /* synthetic */ com.ss.android.lark.forsetiutils.config.a access$getXiaopengDefaultConfig(CarAdaptConfigImpl r0) {
        return r0.getXiaopengDefaultConfig();
    }

    private final <T> T getValue(final Function1<? super com.ss.android.lark.forsetiutils.config.a, ? extends T> r2, T r3) {
        Function1<com.ss.android.lark.forsetiutils.config.a, T> r0 = new CarAdaptConfigImpl$getValue$getValueMayNull$1(r2);
        Object r4 = r0.invoke(getConfig());
        if (r4 != null) goto L8;
        r4 = r0.invoke(getDefaultConfig());
        if (r4 != null) goto L8;
        return r3;
    L8:
        return (T) r4;
    }
}
