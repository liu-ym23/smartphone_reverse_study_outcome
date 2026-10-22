package my7;

import android.app.Activity;
import android.os.Build;
import com.ss.android.lark.log.Log;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d {
    public static final List<a> a = null;

    public interface a {
        void a(Activity r1, Throwable r2);

        boolean b(Throwable r1);
    }

    public static final class b implements a {
        public b() {
        }

        @Override // my7.d.a
        public final boolean b(Throwable r10) {
            Intrinsics.checkNotNullParameter(r10, "throwable");
            if (Build.VERSION.SDK_INT == 34) goto L5;
            return false;
        L5:
            String r0 = Build.BRAND;
            String r1 = "";
            if (r0 != null) goto L8;
            r0 = "";
        L8:
            Locale r3 = Locale.ROOT;
            String r2 = r0.toLowerCase(r3);
            String r4 = Build.MANUFACTURER;
            if (r4 == null) goto L12;
            r1 = r4;
        L12:
            String r5 = r1.toLowerCase(r3);
            if (StringsKt.contains$default(r2, "vivo", false, 2, null) == false) goto L15;
        L17:
            String r6 = r10.getMessage();
            if (r6 != null) goto L20;
        L23:
            boolean r7 = true;
        L24:
            if (r7 == false) goto L26;
            return false;
        L26:
            if (StringsKt.contains$default(r6, "DecorCaptionView.getCaption()", false, 2, null) == false) goto L52;
            StackTraceElement[] r11 = r10.getStackTrace();
            int r8 = r11.length;
            int r9 = 0;
            boolean r12 = false;
            boolean r13 = false;
        L29:
            if (r9 >= r8) goto L41;
            StackTraceElement r14 = r11[r9];
            if (Intrinsics.areEqual(r14.getClassName(), "com.android.internal.policy.DecorView") == false) goto L36;
            if (Intrinsics.areEqual(r14.getMethodName(), "updateColorViews") == false) goto L36;
            r12 = true;
        L36:
            if (Intrinsics.areEqual(r14.getClassName(), "com.android.internal.policy.PhoneWindow") == false) goto L40;
            if (Intrinsics.areEqual(r14.getMethodName(), "getDecorView") == false) goto L40;
            r13 = true;
        L40:
            r9 = r9 + 1;
            goto L29
        L41:
            if (r12 == false) goto L50;
            if (r13 == false) goto L51;
            return true;
        L51:
            return false;
        L50:
            return false;
        L52:
            return false;
        L20:
            if (r6.length() == 0) goto L23;
            r7 = false;
            goto L24
        L15:
            if (StringsKt.contains$default(r5, "vivo", false, 2, null) == true) goto L17;
            return false;
        }

        @Override // my7.d.a
        public final void a(Activity r3, Throwable r4) {
            Intrinsics.checkNotNullParameter(r3, "activity");
            Intrinsics.checkNotNullParameter("InsetsCompatAirActivity", "tag");
            Intrinsics.checkNotNullParameter(r4, "throwable");
            Log.e("InsetsCompatAirActivity", "skip setupWindowInsets for vivo DecorCaptionView crash, activity=".concat(r3.getClass().getSimpleName()), r4);
        }
    }

    public static final class c implements a {
        public c() {
        }

        @Override // my7.d.a
        public final boolean b(Throwable r11) {
            Intrinsics.checkNotNullParameter(r11, "throwable");
            if ((r11 instanceof SecurityException) == true) goto L5;
            return false;
        L5:
            String r0 = r11.getMessage();
            if (r0 != null) goto L8;
        L11:
            boolean r3 = true;
        L12:
            if (r3 == false) goto L14;
            return false;
        L14:
            if (StringsKt.contains$default(r0, "Binder invocation to an incorrect interface", false, 2, null) == false) goto L51;
            StackTraceElement[] r12 = ((SecurityException) r11).getStackTrace();
            int r1 = r12.length;
            int r4 = 0;
            boolean r5 = false;
            boolean r6 = false;
            boolean r7 = false;
        L17:
            if (r4 >= r1) goto L38;
            StackTraceElement r8 = r12[r4];
            if (Intrinsics.areEqual(r8.getClassName(), "android.view.IWindowManager$Stub$Proxy") == false) goto L26;
            if (Intrinsics.areEqual(r8.getMethodName(), "hasNavigationBar") == false) goto L23;
        L24:
            r5 = true;
            goto L26
        L23:
            if (Intrinsics.areEqual(r8.getMethodName(), "getWindowInsets") == true) goto L24;
        L26:
            if (Intrinsics.areEqual(r8.getClassName(), "com.android.internal.policy.DecorView") == false) goto L31;
            if (Intrinsics.areEqual(r8.getMethodName(), "<init>") == false) goto L31;
            r6 = true;
        L31:
            if (Intrinsics.areEqual(r8.getClassName(), "com.android.internal.policy.PhoneWindow") == false) goto L37;
            if (Intrinsics.areEqual(r8.getMethodName(), "getDecorView") == false) goto L35;
        L36:
            r7 = true;
            goto L37
        L35:
            if (Intrinsics.areEqual(r8.getMethodName(), "installDecor") == true) goto L36;
        L37:
            r4 = r4 + 1;
            goto L17
        L38:
            if (r5 == false) goto L48;
            if (r6 == false) goto L49;
            if (r7 == false) goto L50;
            return true;
        L50:
            return false;
        L49:
            return false;
        L48:
            return false;
        L51:
            return false;
        L8:
            if (r0.length() == 0) goto L11;
            r3 = false;
            goto L12
        }

        @Override // my7.d.a
        public final void a(Activity r4, Throwable r5) {
            Intrinsics.checkNotNullParameter(r4, "activity");
            Intrinsics.checkNotNullParameter("InsetsCompatAirActivity", "tag");
            Intrinsics.checkNotNullParameter(r5, "throwable");
            Log.e("InsetsCompatAirActivity", "skip setupWindowInsets for decorView IWindowManager binder crash, activity=" + r4.getClass().getSimpleName() + ", brand=" + Build.BRAND + ", manufacturer=" + Build.MANUFACTURER + ", model=" + Build.MODEL + ", sdk=" + Build.VERSION.SDK_INT, r5);
        }
    }

    static {
        a = CollectionsKt.listOf(new a[]{new b(), new c()});
    }
}
