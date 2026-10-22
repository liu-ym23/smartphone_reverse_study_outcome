package com.ss.android.lark.chat.cot.detail.blueprint.block;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.blueprint.BlueprintCell;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.i;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.chat.cot.detail.blueprint.CotDetailCellKeys$Slots;
import com.ss.android.lark.chat.cot.detail.k;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class a implements i<k, com.ss.android.lark.chat.cot.detail.blueprint.e> {
    public final Class<com.ss.android.lark.chat.cot.detail.blueprint.e> a;
    public final CotDetailCellKeys$Slots b;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.cot.detail.blueprint.block.a$a, reason: collision with other inner class name */
    public static final class C0090a {
    }

    public static final class b implements View.OnTouchListener {
        public final /* synthetic */ a a;
        public final /* synthetic */ k b;

        public b(a r1, k r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r14, MotionEvent r15) {
            if (r15.getActionMasked() != 1) goto L27;
            long r2 = SystemClock.uptimeMillis();
            Object r4 = r14.getTag(2131367979);
            ClipboardManager r6 = null;
            if ((r4 instanceof long[]) == false) goto L7;
            long[] r5 = (long[]) r4;
        L8:
            if (r5 != null) goto L10;
            r5 = new long[2];
        L10:
            long r11 = 1;
            if ((r2 - r5[0]) > 800) goto L14;
            r11 = 1 + r5[1];
        L14:
            if (r11 < 3) goto L26;
            r5[0] = 0;
            r5[1] = 0;
            r14.setTag(2131367979, r5);
            a r16 = this.a;
            Context r17 = r14.getContext();
            k r1 = this.b;
            r16.getClass();
            String r3 = "CotDetailItem debug dump:\n" + r1;
            Object r7 = r17.getSystemService("clipboard");
            if ((r7 instanceof ClipboardManager) == false) goto L18;
            r6 = (ClipboardManager) r7;
        L18:
            if (r6 == null) goto L27;
            qf7.a.a.a(r6, ClipData.newPlainText("cot_debug", r3), new Token("LARK-PSDA-messenger-android-cot-detail-debug-dump"));     // Catch: Exception -> L22 SensitiveAPIException -> L24
            UDToast.show(r17, 2131891640);     // Catch: Exception -> L22 SensitiveAPIException -> L24
        L24:
            e = move-exception;
            com.ss.android.lark.chat.cot.f.b("debug_dump", "copy failed by psda restriction", e);
        L22:
            e = move-exception;
            com.ss.android.lark.chat.cot.f.b("debug_dump", "copy failed", e);
            goto L27
        L26:
            r5[0] = r2;
            r5[1] = r11;
            r14.setTag(2131367979, r5);
            goto L27
        L7:
            r5 = null;
        L27:
            return false;
        }
    }

    static {
    }

    public void d(com.ss.android.lark.blueprint.k<?> r1) {
    }

    public abstract /* synthetic */ void update(m r1, q r2, Object r3);

    public final Class<com.ss.android.lark.chat.cot.detail.blueprint.e> b() {
        return this.a;
    }

    public a(g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        this.a = com.ss.android.lark.chat.cot.detail.blueprint.e.class;
        this.b = CotDetailCellKeys$Slots.CONTENT;
    }

    public final void a(m<k> r2, q<k> r3) {
        Intrinsics.checkNotNullParameter(r2, "cell");
        Intrinsics.checkNotNullParameter(r3, "layout");
        d(r3.f(getKey(), this.b));
        r3.o(getKey(), this.b);
    }

    public final void e(View r2, k r3) {
        Intrinsics.checkNotNullParameter(r3, Keys.API_RETURN_KEY_DATA);
        if (r2 != null) goto L6;
        return;
    L6:
        if (DevEnvUtil.isDevelopPackage(r2.getContext()) == true) goto L8;
        return;
    L8:
        r2.setOnTouchListener(new b(this, r3));
    }

    public final void c(BlueprintCell r2, q r3, Object r4, Object r5) {
        k r6 = (k) r4;
        Intrinsics.checkNotNullParameter(r2, "cell");
        Intrinsics.checkNotNullParameter(r3, "layout");
        Intrinsics.checkNotNullParameter(r6, Keys.API_RETURN_KEY_DATA);
        Intrinsics.checkNotNullParameter((com.ss.android.lark.chat.cot.detail.blueprint.e) r5, "patch");
        update(r2, r3, r6);
    }
}
