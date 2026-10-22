package ue8;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.larus.avlink.model.DoraCallStateCode;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f {
    public final Activity a;
    public a b;
    public boolean c;

    public static final class a extends View {
        public com.larus.bmhome.chat.exposure.a a;
        public final Paint b;
        public final Paint c;
        public final Paint d;
        public final Paint e;
        public final Paint f;
        public final Paint g;
        public final int[] h;
        public final int[] i;

        public final com.larus.bmhome.chat.exposure.a getManager() {
            return this.a;
        }

        public a(Context r7) {
            Intrinsics.checkNotNullParameter(r7, "context");
            super(r7);
            Paint r8 = new Paint();
            r8.setColor(Color.argb(40, 66, 133, 244));
            r8.setStyle(Paint.Style.FILL);
            this.b = r8;
            Paint r9 = new Paint();
            r9.setColor(Color.argb(150, 66, 133, 244));
            r9.setStyle(Paint.Style.STROKE);
            r9.setStrokeWidth(4.0f);
            this.c = r9;
            Paint r10 = new Paint();
            r10.setColor(Color.argb(DoraCallStateCode.ENV_OBSERVE_END, 255, 193, 7));
            r10.setStyle(Paint.Style.STROKE);
            r10.setStrokeWidth(3.0f);
            this.d = r10;
            Paint r11 = new Paint();
            r11.setColor(Color.argb(50, 76, DoraCallStateCode.DOUBAO_STOP_RECORD_BY_GUI, 80));
            r11.setStyle(Paint.Style.FILL);
            this.e = r11;
            Paint r12 = new Paint();
            r12.setColor(Color.argb(DoraCallStateCode.DORA_OB_USER_END, 76, DoraCallStateCode.DOUBAO_STOP_RECORD_BY_GUI, 80));
            r12.setStyle(Paint.Style.STROKE);
            r12.setStrokeWidth(4.0f);
            this.f = r12;
            Paint r13 = new Paint();
            r13.setColor(-1);
            r13.setTextSize(28.0f);
            r13.setAntiAlias(true);
            r13.setShadowLayer(3.0f, 1.0f, 1.0f, -16777216);
            this.g = r13;
            this.h = new int[2];
            this.i = new int[2];
            setWillNotDraw(false);
            setElevation(Float.MAX_VALUE);
        }

        @Override // android.view.View
        public final void onDraw(Canvas r21) {
            Intrinsics.checkNotNullParameter(r21, "canvas");
            super.onDraw(r21);
            com.larus.bmhome.chat.exposure.a r8 = this.a;
            if (r8 != null) goto L5;
            return;
        L5:
            getLocationOnScreen(this.i);
            int[] r1 = this.i;
            int r10 = r1[0];
            int r12 = r1[1];
            Rect r2 = r8.a();
            if (r2 == null) goto L9;
            float r13 = r2.left - r10;
            float r14 = r2.top - r12;
            float r15 = r2.right - r10;
            float r6 = r2.bottom - r12;
            r21.drawRect(r13, r14, r15, r6, this.b);
            r21.drawRect(r13, r14, r15, r6, this.c);
            r21.drawText("检测区域", r13 + 12.0f, r14 + 36.0f, this.g);
        L9:
            Iterator r9 = r8.b.a().iterator();
        L11:
            if (r9.hasNext() == false) goto L21;
            j r16 = (j) r9.next();
            View r3 = r16.b.get();
            if (r3 == null) goto L11;
            if (r3.isAttachedToWindow() == false) goto L11;
            r3.getLocationOnScreen(this.h);
            int[] r4 = this.h;
            float r17 = r4[0] - r10;
            float r18 = r4[1] - r12;
            float r19 = r17 + r3.getWidth();
            float r110 = r18 + r3.getHeight();
            if (r16.d == true) goto L19;
            r21.drawRect(r17, r18, r19, r110, this.d);
            r21.drawText(r16.a, r17 + 8.0f, r18 + 32.0f, this.g);
            goto L11
        L19:
            r21.drawRect(r17, r18, r19, r110, this.e);
            r21.drawRect(r17, r18, r19, r110, this.f);
            r21.drawText("✓ " + r16.a, r17 + 8.0f, r18 + 32.0f, this.g);
            goto L11
        }

        public final void setManager(com.larus.bmhome.chat.exposure.a r1) {
            this.a = r1;
        }
    }

    public f(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a = r2;
    }
}
