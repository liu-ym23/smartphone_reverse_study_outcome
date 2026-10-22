package m1b;

import android.content.Context;
import android.hardware.input.InputManager;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.InputDevice;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.common.utility.Logger;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;
import com.ss.android.lark.chameleon.IModelCmlActivity;
import com.ss.android.lark.chameleon.LKAPIModules;
import com.ss.android.lark.chameleon.OpenConfig;
import com.ss.android.lark.chameleonv2.lkapi.system.ISystem$DeviceVibrateRequest;
import com.ss.android.lark.chameleonv2.lkapi.system.ISystem$DeviceVibrateType;
import com.ss.android.lark.chameleonv2.lkapi.system.ISystem$Ipc$EventType;
import com.ss.android.lark.forseti.widget.ForsetiStackChainViewGroup;
import com.ss.android.lark.ui.component_container.ResponsiveBaseFragment;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends z0b.a {
    public static final /* synthetic */ int c = 0;
    public final InputManager a;
    public e b;

    /* JADX INFO: renamed from: m1b.a$a, reason: collision with other inner class name */
    public static final class C0254a {
    }

    public final class b extends AbsChameleonHandler<ISystem$DeviceVibrateRequest> {
        public final String a;

        /* JADX INFO: renamed from: m1b.a$b$a, reason: collision with other inner class name */
        public /* synthetic */ class C0255a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[ISystem$DeviceVibrateType.values().length];
                r0[ISystem$DeviceVibrateType.LONG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
            L4:
                a = r0;
            }
        }

        public b() {
            this.a = LKAPIModules.System.DeviceVibrate.getValue();
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.a;
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(ISystem$DeviceVibrateRequest r6, Callback r7) {
            ISystem$DeviceVibrateRequest r8 = r6;
            Intrinsics.checkNotNullParameter(r8, "req");
            Intrinsics.checkNotNullParameter(r7, "callback");
            if (C0255a.a[r8.getType().ordinal()] != 1) goto L5;
            long r0 = 400;
        L6:
            IChameleonHandlerContext r9 = getContext();
            if (r9 == null) goto L11;
            Context r10 = r9.getCmlContext();
            if (r10 == null) goto L11;
            Object r11 = r10.getSystemService("vibrator");
        L12:
            Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type android.os.Vibrator");
            Vibrator r12 = (Vibrator) r11;
            if (Build.VERSION.SDK_INT < 26) goto L15;
            r12.vibrate(VibrationEffect.createOneShot(r0, -1));
        L16:
            r7.success(null);
            return;
        L15:
            r12.vibrate(r0);
        L11:
            r11 = null;
            goto L12
        L5:
            r0 = 30;
            goto L6
        }
    }

    public final class c extends AbsChameleonHandler<Unit> {
        public final String a;
        public final /* synthetic */ a b;

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.a;
        }

        public c(a r1) {
            this.b = r1;
            this.a = LKAPIModules.System.GetInputDevice.getValue();
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(Callback r2) {
            Intrinsics.checkNotNullParameter(r2, "callback");
            r2.success(a.f(this.b));
        }
    }

    public final class d extends AbsChameleonHandler<Unit> {
        public final String a;

        public d() {
            this.a = LKAPIModules.Internal.System.GetStatusBarHeight.getValue();
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.a;
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(Callback r6) {
            Intrinsics.checkNotNullParameter(r6, "callback");
            IChameleonHandlerContext r0 = getContext();
            ForsetiStackChainViewGroup r1 = null;
            if (r0 == null) goto L7;
            Fragment r2 = r0.getFragment();
            if (r2 == null) goto L7;
            FragmentActivity r3 = r2.getActivity();
        L8:
            boolean r4 = false;
            if ((r3 instanceof IModelCmlActivity) == false) goto L27;
            IChameleonHandlerContext r5 = getContext();
            if (r5 == null) goto L56;
            Fragment r7 = r5.getFragment();
            if (r7 == null) goto L56;
            FragmentActivity r8 = r7.getActivity();
            if (r8 == null) goto L56;
            Intrinsics.checkNotNullParameter(r8, "<this>");
            ResponsiveBaseFragment r9 = r8.getSupportFragmentManager().findFragmentByTag("ResponsiveBaseFragment");
            if ((r9 instanceof ResponsiveBaseFragment) == false) goto L19;
            ResponsiveBaseFragment r10 = r9;
        L20:
            if (r10 == null) goto L26;
            ForsetiStackChainViewGroup r11 = r10.d;
            if (r11 != null) goto L24;
            Intrinsics.throwUninitializedPropertyAccessException("stackViewGroup");
        L25:
            r4 = r1.d;
            goto L26
        L24:
            r1 = r11;
        L26:
            r1 = Boolean.valueOf(r4);
            goto L56
        L19:
            r10 = null;
        L56:
            if (Intrinsics.areEqual(r1, Boolean.FALSE) == false) goto L58;
            float r12 = 18.0f;
        L59:
            r6.success(Float.valueOf(r12));
            return;
        L58:
            r12 = UIUtils.px2dp(LarkContext.getApplication(), DeviceUtils.getStatusHeight(LarkContext.getApplication()));
            goto L59
        L27:
            sua.a r13 = (sua.a) ApiUtils.getApi(sua.a.class);
            if (r13 == null) goto L36;
            IChameleonHandlerContext r14 = getContext();
            if (r14 == null) goto L34;
            Fragment r15 = r14.getFragment();
            if (r15 == null) goto L34;
            FragmentActivity r16 = r15.getActivity();
        L35:
            boolean r17 = r13.isRunningInForseti(r16);
        L38:
            if (r17 == false) goto L53;
            IChameleonHandlerContext r18 = getContext();
            if (r18 == null) goto L42;
            ForsetiStackChainViewGroup r19 = r18.getWebview();
        L44:
            if ((r19 instanceof IChameleonHandlerContext) == false) goto L46;
            r1 = (IChameleonHandlerContext) r19;
        L46:
            if (r1 == null) goto L53;
            ChameleonConfig r20 = r1.getChameleonConfig();
            if (r20 == null) goto L53;
            OpenConfig r21 = r20.getOpenConfig();
            if (r21 == null) goto L53;
            if (r21.isModelView() == false) goto L53;
        L54:
            r1 = Boolean.valueOf(r4);
            goto L56
        L42:
            r19 = null;
        L53:
            r4 = true;
        L34:
            r16 = null;
            goto L35
        L36:
            r17 = false;
        L7:
            r3 = null;
            goto L8
        }
    }

    public static final class e implements InputManager.InputDeviceListener {
        public final /* synthetic */ a a;
        public final /* synthetic */ IChameleonHandlerContext b;

        public final void a() {
            String r0 = a.f(this.a);
            IChameleonHandlerContext r1 = this.b;
            if (r1 == null) goto L5;
            r1.sendEvent(ISystem$Ipc$EventType.INPUT_DEVICE_CHANGED.getValue(), r0);
        L5:
            Logger.i("LK_API_TAG_System", "input device change ,deviceType = ".concat(r0));
        }

        @Override // android.hardware.input.InputManager.InputDeviceListener
        public final void onInputDeviceAdded(int r1) {
            a();
        }

        @Override // android.hardware.input.InputManager.InputDeviceListener
        public final void onInputDeviceChanged(int r1) {
            a();
        }

        @Override // android.hardware.input.InputManager.InputDeviceListener
        public final void onInputDeviceRemoved(int r1) {
            a();
        }

        public e(a r1, IChameleonHandlerContext r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    @Override // z0b.a
    public final List<AbsChameleonHandler<?>> c() {
        return CollectionsKt.arrayListOf(new AbsChameleonHandler[]{new d(), new b(), new c(this)});
    }

    public a() {
        this.a = (InputManager) ContextCompat.getSystemService(LarkContext.getApplication(), InputManager.class);
    }

    public static final String f(a r6) {
        r6.getClass();
        String r7 = "touch";
        int[] r0 = InputDevice.getDeviceIds();     // Catch: Throwable -> L14
        int r1 = r0.length;     // Catch: Throwable -> L14
        int r3 = 0;
    L4:
        if (r3 >= r1) goto L16;
        InputDevice r4 = InputDevice.getDevice(r0[r3]);     // Catch: Throwable -> L14
        if (r4 == null) goto L13;
        if ((r4.getSources() & 1056778) == 0) goto L10;
        boolean r5 = true;
    L11:
        if (r5 == false) goto L13;
        r7 = "mouse";
        goto L13
    L10:
        r5 = false;
    L13:
        r3 = r3 + 1;
    L16:
        return r7;
    L14:
        th = move-exception;
        Logger.e("LK_API_TAG_System", "getDevicesType error", th);
        goto L16
    }

    @Override // z0b.a
    public final void d(IChameleonHandlerContext r2) {
        this.b = new e(this, r2);
    }

    @Override // z0b.a
    public final void e(IChameleonHandlerContext r2) {
        e r3 = this.b;
        if (r3 == null) goto L8;
        InputManager r0 = this.a;
        if (r0 == null) goto L9;
        r0.unregisterInputDeviceListener(r3);
        return;
    L9:
        return;
    }
}
