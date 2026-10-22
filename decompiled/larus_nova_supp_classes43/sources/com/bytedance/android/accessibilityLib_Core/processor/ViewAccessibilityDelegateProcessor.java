package com.bytedance.android.accessibilityLib_Core.processor;

import android.content.Context;
import android.os.Build;
import android.view.View;
import androidx.core.Config2AccessibilityDelegateGenerateProcessor;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig;
import com.bytedance.android.accessibilityLib_Core.config.base.IBaseLargeTouchAreaConfig;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.h;
import com.bytedance.android.accessibilityLib_Core.engine.AccessibilityConfigEngine;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ViewAccessibilityDelegateProcessor implements com.bytedance.android.accessibilityLib_Core.processor.a {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final k6.a d;

    public static final class a {
        public WeakReference<View> a;
        public int b;
        public boolean c;

        public a() {
            throw null;
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L4;
            return true;
        L4:
            if ((r10 instanceof a) == false) goto L12;
            a r11 = (a) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L8;
            return false;
        L8:
            if (this.b == r11.b) goto L10;
            return false;
        L10:
            if (this.c == r11.c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4 */
        public final int hashCode() {
            WeakReference<View> r0 = this.a;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L6:
            int r10 = ((r1 * 31) + this.b) * 31;
            boolean r11 = this.c;
            ?? r12 = r11;
            if (r11 == false) goto L10;
            r12 = 1;
        L10:
            return r10 + r12;
        L5:
            r1 = 0;
            goto L6
        }

        public final String toString() {
            return "ViewStruct(weakRefView=" + this.a + ", resourceId=" + this.b + ", isLarge=" + this.c + ")";
        }

        public final View a() {
            return this.a.get();
        }

        public a(WeakReference r1, int r10) {
            this.a = r1;
            this.b = r10;
            this.c = false;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ IBaseConfig a;
        public final /* synthetic */ View b;
        public final /* synthetic */ AccessibilityDelegateCompat c;

        public b(IBaseConfig r1, View r10, AccessibilityDelegateCompat r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }

        public final void a() {
            if (this.a.getVirtualNode().m == false) goto L17;
            ArrayList<IBaseConfig> r0 = AccessibilityConfigEngine.a;
            IBaseConfig r1 = this.a;
            int r10 = 1;
            if ((r1 instanceof i6.a) == false) goto L7;
        L10:
            boolean r11 = true;
        L11:
            if (r11 == true) goto L17;
            Context r12 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
            View r13 = this.b;
            if (this.a.getVirtualNode().i == false) goto L16;
            r10 = 2;
        L16:
            r13.setImportantForAccessibility(r10);
            goto L17
        L7:
            if (Intrinsics.areEqual(r1.name(), "largeTouchArea") == true) goto L10;
            r11 = false;
        L17:
            ViewCompat.setAccessibilityDelegate(this.b, this.c);
            if (("set delegate for config name = " + this.a.name() + ", view = " + this.b) == null) goto L21;
            Context r14 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public ViewAccessibilityDelegateProcessor(k6.a r1) {
        this.d = r1;
        this.a = LazyKt.lazy(new ViewAccessibilityDelegateProcessor$config2AccessibilityDelegateGenerateProcessor$2(this));
        this.b = LazyKt.lazy(ViewAccessibilityDelegateProcessor$buildTagBuildProcessor$2.INSTANCE);
        this.c = LazyKt.lazy(ViewAccessibilityDelegateProcessor$viewLabelBuildProcessor$2.INSTANCE);
    }

    public final void c(a r14) {
        View r1 = r14.a();
        if (r1 != null) goto L168;
        Context r15 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
        return;
    L168:
    L16:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L20;
        Context r10 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L20:
        Unit r11 = Unit.INSTANCE;
    L21:
        Iterator<IBaseConfig> r12 = AccessibilityConfigEngine.d.iterator();
    L22:
        boolean r13 = r12.hasNext();
        ArrayList<IBaseConfig> r16 = AccessibilityConfigEngine.a;
        Config2AccessibilityDelegateGenerateProcessor.AccessibilityDelegateComposite r17 = null;
        if (r13 == false) goto L27;
        IBaseConfig r18 = r12.next();
        if (AccessibilityConfigEngine.b(r18, r14) == false) goto L22;
    L28:
        IBaseConfig r19 = r18;
        boolean r20 = false;
        if (com.bytedance.android.accessibilityLib_Core.engine.a.a[com.bytedance.android.accessibilityLib_Core.base.largertoucharea.b.a.ordinal()] == 1) goto L67;
        Iterator<IBaseLargeTouchAreaConfig> r21 = AccessibilityConfigEngine.g.iterator();
    L32:
        if (r21.hasNext() == false) goto L51;
        IBaseLargeTouchAreaConfig r22 = r21.next();
        IBaseLargeTouchAreaConfig r110 = r22;
        if (Build.VERSION.SDK_INT < 29) goto L48;
        List<Integer> r111 = r110.supportLayoutRootList();
        View r112 = r14.a();
        if (r112 == null) goto L40;
        View r113 = r112.getRootView();
        if (r113 == null) goto L40;
        int r114 = r113.getSourceLayoutResId();
    L42:
        if (r111.contains(Integer.valueOf(r114)) == false) goto L44;
    L47:
        boolean r115 = true;
    L49:
        if (r115 == false) goto L32;
    L52:
        IBaseLargeTouchAreaConfig r23 = r22;
        StringBuilder r24 = new StringBuilder("largeAreaConfig = ");
        if (r23 == null) goto L55;
        List<Integer> r25 = r23.supportLayoutRootList();
    L56:
        r24.append(r25);
        if (r24.toString() == null) goto L59;
        Context r26 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L59:
        if (r19 != null) goto L73;
        if (r23 != null) goto L63;
    L66:
        r19 = null;
        goto L73
    L63:
        if (r14.c == false) goto L66;
        i6.a r27 = new i6.a();
    L65:
        r19 = r27;
    L73:
        if (r14.c == false) goto L76;
        if (r19 == null) goto L76;
        r19.getVirtualNode().e = true;
    L76:
        if (r19 == null) goto L184;
        String r28 = r19.getVirtualNode().r;
        if (r28 != null) goto L80;
    L83:
        boolean r29 = true;
    L85:
        if (r29 == true) goto L113;
        if (("appModeConfigStr = " + r28) == null) goto L89;
        Context r30 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L89:
        int r31 = com.bytedance.android.accessibilityLib_Core.helper.a.b;
        if (r31 != 1) goto L92;
        boolean r116 = true;
    L93:
        if (r116 == true) goto L95;
        if (r31 != 2) goto L99;
        boolean r117 = true;
    L100:
        if (r117 == false) goto L105;
        if ((!StringsKt.contains(r28, "dylite", true)) == false) goto L113;
        return;
    L105:
        if (r31 != 3) goto L107;
        boolean r32 = true;
    L108:
        if (r32 == false) goto L113;
        if ((!StringsKt.contains(r28, "hotsoon", true)) == false) goto L113;
        return;
    L107:
        r32 = false;
        goto L108
    L99:
        r117 = false;
        goto L100
    L95:
        if ((!StringsKt.contains(r28, "douyin", true)) == false) goto L113;
        return;
    L92:
        r116 = false;
    L113:
        if (("find config for view = " + r1 + ", config name = " + r19.name()) == null) goto L115;
        Context r33 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L115:
        Config2AccessibilityDelegateGenerateProcessor.AccessibilityDelegateComposite r34 = ViewCompat.getAccessibilityDelegate(r1);
        if (r34 != null) goto L118;
    L120:
        boolean r35 = false;
    L121:
        if (r35 == true) goto L170;
        View r0 = r14.a();
        if (r0 != null) goto L140;
    L149:
        if (r20 == true) goto L155;
        if (("replaceAccessibilityDelegate,overwrite = false for viewinfo = " + r14.a()) == null) goto L182;
        Context r118 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
        return;
    L182:
        return;
    L155:
        if (Build.VERSION.SDK_INT < 29) goto L157;
        AccessibilityDelegateCompat r119 = ((Config2AccessibilityDelegateGenerateProcessor) this.a.getValue()).wrap2AccessibilityDelegateCompat(r19, r1.getAccessibilityDelegate());
    L159:
        if (r1.isAttachedToWindow() == false) goto L161;
        r1.post(new b(r19, r1, r119));
        return;
    L161:
        if (("don't attached for viewnode>>> " + r1) == null) goto L183;
        Context r120 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
        return;
    L183:
        return;
    L157:
        r119 = Config2AccessibilityDelegateGenerateProcessor.wrap2AccessibilityDelegateCompat$default((Config2AccessibilityDelegateGenerateProcessor) this.a.getValue(), r19, null, 2, null);
        goto L159
    L140:
        if (ViewCompat.getAccessibilityDelegate(r0) != null) goto L144;
        if (ViewCompat.hasAccessibilityDelegate(r0) == true) goto L144;
    L148:
        r20 = true;
    L144:
        if (r19.getVirtualNode().m == false) goto L149;
        if (("replaceAccessibilityDelegate,overwrite = true for viewinfo = " + r14) == null) goto L148;
        Context r36 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
        goto L148
    L170:
    L131:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L135;
        Context r121 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L135:
        Unit r122 = Unit.INSTANCE;
        return;
    L123:
        if ((r34 instanceof Config2AccessibilityDelegateGenerateProcessor.AccessibilityDelegateComposite) == false) goto L126;
        r17 = r34;
    L126:
        Config2AccessibilityDelegateGenerateProcessor.AccessibilityDelegateComposite r37 = r17;     // Catch: Exception -> L131
        if (r37 == null) goto L129;
        r37.setConfig(r19);     // Catch: Exception -> L131
    L129:
        Unit r123 = Unit.INSTANCE;     // Catch: Exception -> L131
        return;
    L118:
        if ((r34 instanceof Config2AccessibilityDelegateGenerateProcessor.AccessibilityDelegateComposite) == false) goto L120;
        r35 = true;
        goto L121
    L80:
        if (r28.length() == 0) goto L83;
        r29 = false;
        goto L85
    L184:
        return;
    L55:
        r25 = null;
        goto L56
    L44:
        if (r110.supportLayoutRootList().contains(Integer.valueOf(r14.b)) == true) goto L47;
        r115 = false;
    L40:
        r114 = -1;
        goto L42
    L48:
        r115 = r110.supportLayoutRootList().contains(Integer.valueOf(r14.b));
        goto L49
    L51:
        r22 = null;
        goto L52
    L67:
        if (r19 != null) goto L73;
        if (r14.c == false) goto L66;
        r27 = new i6.a();
        goto L65
    L27:
        r18 = null;
        goto L28
    L6:
        if (com.bytedance.android.accessibilityLib_Core.engine.b.a == false) goto L8;
        ((c) this.b.getValue()).a(r14);     // Catch: Exception -> L16
    L8:
        ArrayList<IBaseConfig> r38 = AccessibilityConfigEngine.a;     // Catch: Exception -> L16
        View r39 = r14.a.get();     // Catch: Exception -> L16
        if (r39 == null) goto L11;
        int r40 = r39.getId();     // Catch: Exception -> L16
    L12:
        h r41 = AccessibilityConfigEngine.a(r40, r14.b);     // Catch: Exception -> L16
        if (r41 == null) goto L21;
        a(r14.a, r41);     // Catch: Exception -> L16
        Unit r42 = Unit.INSTANCE;     // Catch: Exception -> L16
        goto L21
    L11:
        r40 = -1;
        goto L12
    }

    @Override // com.bytedance.android.accessibilityLib_Core.processor.a
    public final void a(WeakReference<View> r10, h r11) {
        com.bytedance.android.accessibilityLib_Core.processor.b r0 = (com.bytedance.android.accessibilityLib_Core.processor.b) this.c.getValue();
        r0.getClass();
        if (r10 == null) goto L5;
        View r1 = r10.get();
    L6:
        if (r1 == null) goto L26;
        StringBuilder r12 = new StringBuilder();
        r12.append(r11.a);
        r12.append('-');
        r12.append(r11.b);
        String r13 = r12.toString();
        String r14 = com.bytedance.android.accessibilityLib_Core.processor.b.a(r1);
        if (r14 != null) goto L10;
    L13:
        boolean r15 = true;
    L14:
        if (r15 == false) goto L17;
    L20:
        if (r10 != null) goto L22;
        return;
    L22:
        if (r0.b.size() < r0.c) goto L24;
        Context r16 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
        return;
    L24:
        r0.b.put(r13, r10);
        return;
    L17:
        if (("store key = " + r13 + ", contentDesc = " + r14) == null) goto L19;
        Context r17 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L19:
        r0.a.put(r13, r14);
        goto L20
    L10:
        if (r14.length() == 0) goto L13;
        r15 = false;
        goto L14
    L26:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.accessibilityLib_Core.processor.a
    public final void b(View r10, int r11, boolean r12) {
    L12:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L16;
        Context r13 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L16:
        Unit r14 = Unit.INSTANCE;
        return;
    L4:
        if (("[ViewAccessibilityDelegateProcessor]>>>consumeViewDirectly,view = " + r10) == null) goto L6;
        Context r0 = com.bytedance.android.accessibilityLib_Core.helper.a.a;     // Catch: Exception -> L12
    L6:
        a r15 = this.d.a(r10, r11);     // Catch: Exception -> L12
        if (r15.b != (-1)) goto L10;
        if (r11 == (-1)) goto L10;
        r15.b = r11;     // Catch: Exception -> L12
    L10:
        r15.c = r12;     // Catch: Exception -> L12
        c(r15);     // Catch: Exception -> L12
        Unit r16 = Unit.INSTANCE;     // Catch: Exception -> L12
    }
}
