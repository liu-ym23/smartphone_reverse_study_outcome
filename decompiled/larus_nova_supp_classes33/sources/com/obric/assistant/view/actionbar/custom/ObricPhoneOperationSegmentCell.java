package com.obric.assistant.view.actionbar.custom;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.view.actionbar.custom.t1;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.actionbar.statemanager.state.ObricOAutoTaskState;
import com.obric.assistant.impl.databinding.ObricItemCustomActionbarNormalHolderBinding;
import com.obric.assistant.spi.window.ChatWindowServiceDelegate;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import qha.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\u0018\u0000 &2\u00020\u0001:\u0002&'B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ(\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J \u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0014\u0010 \u001a\u00020\u0011*\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0014\u0010$\u001a\u00020\u0011*\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\f\u0010%\u001a\u00020\u001d*\u00020\u001bH\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/obric/assistant/view/actionbar/custom/ObricPhoneOperationSegmentCell;", "Lcom/obric/assistant/view/actionbar/custom/ObricActionBarSegmentCell;", "binding", "Lcom/obric/assistant/impl/databinding/ObricItemCustomActionbarNormalHolderBinding;", "defaultClickCallback", "Lcom/larus/bmhome/view/actionbar/custom/CustomActionBarHolderCallback;", "isImmerse", "", "extraData", "Lcom/larus/bmhome/instruction/core/model/InstructionExtraData;", "<init>", "(Lcom/obric/assistant/impl/databinding/ObricItemCustomActionbarNormalHolderBinding;Lcom/larus/bmhome/view/actionbar/custom/CustomActionBarHolderCallback;ZLcom/larus/bmhome/instruction/core/model/InstructionExtraData;)V", "getBinding", "()Lcom/obric/assistant/impl/databinding/ObricItemCustomActionbarNormalHolderBinding;", "context", "Landroid/content/Context;", "bind", "", "name", "", MemorySourceLinkType.URL, "item", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "position", "", "renderOAutoTask", "taskState", "Lcom/obric/assistant/actionbar/statemanager/state/ObricOAutoTaskState;", "config", "Lcom/obric/assistant/view/actionbar/custom/ObricPhoneOperationSegmentCell$StyleConfig;", "delegate", "Lcom/larus/common_ui/widget/roundlayout/RoundViewDelegate;", "applyTextGradient", "Landroid/widget/TextView;", "colors", "", "doApplyGradient", "getOAutoStyleConfig", "Companion", "StyleConfig", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricPhoneOperationSegmentCell extends ObricActionBarSegmentCell {
    public static final /* synthetic */ int h = 0;
    public final ObricItemCustomActionbarNormalHolderBinding f;
    public final Context g;

    public static final class a {
    }

    public static final class b {
        public final Integer a;
        public final Integer b;
        public final Integer c;
        public final int d;
        public final String e;
        public final Integer f;
        public final int[] g;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            Integer r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Integer r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            Integer r7 = this.c;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (((((r6 + r8) * 31) + this.d) * 31) + this.e.hashCode()) * 31;
            Integer r10 = this.f;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            int[] r13 = this.g;
            if (r13 == null) goto L23;
            r1 = Arrays.hashCode(r13);
        L23:
            return r12 + r1;
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "StyleConfig(bgColor=" + this.a + ", strokeColor=" + this.b + ", pressBgColor=" + this.c + ", iconColor=" + this.d + ", text=" + this.e + ", textColor=" + this.f + ", gradientColors=" + Arrays.toString(this.g) + ')';
        }

        public b(Integer r3, Integer r4, Integer r5, int r6, String r7, Integer r8, int[] r9, int r10) {
            if ((r10 & 1) == 0) goto L6;
            r3 = null;
        L6:
            if ((r10 & 2) == 0) goto L9;
            r4 = null;
        L9:
            if ((r10 & 4) == 0) goto L12;
            r5 = null;
        L12:
            if ((r10 & 32) == 0) goto L15;
            r8 = null;
        L15:
            if ((r10 & 64) == 0) goto L17;
            r9 = null;
        L17:
            Intrinsics.checkNotNullParameter(r7, "text");
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r8;
            this.g = r9;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ObricOAutoTaskState.values().length];
            r0[ObricOAutoTaskState.IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[ObricOAutoTaskState.EXECUTING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[ObricOAutoTaskState.WAITING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[ObricOAutoTaskState.CLARIFYING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[ObricOAutoTaskState.CALL_USER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[ObricOAutoTaskState.PAUSED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    static {
    }

    @Override // com.obric.assistant.view.actionbar.custom.ObricActionBarSegmentCell
    public final ObricItemCustomActionbarNormalHolderBinding W3() {
        return this.f;
    }

    public static void X3(TextView r10, int[] r11) {
        r10.getPaint().setShader(new LinearGradient(0.0f, 0.0f, r10.getWidth(), 0.0f, r11, null, Shader.TileMode.CLAMP));
        r10.setTextColor(r11[0]);
        r10.invalidate();
    }

    public ObricPhoneOperationSegmentCell(ObricItemCustomActionbarNormalHolderBinding r2, t1 r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        Intrinsics.checkNotNullParameter(r3, "defaultClickCallback");
        super(r2, r3, r4, null);
        this.f = r2;
        this.g = r2.a.getContext();
    }

    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8, types: [boolean] */
    @Override // com.obric.assistant.view.actionbar.custom.ObricActionBarSegmentCell
    public final void U3(String r27, String r28, z0 r29, int r30) {
        Intrinsics.checkNotNullParameter(r27, "name");
        Intrinsics.checkNotNullParameter(r28, MemorySourceLinkType.URL);
        Intrinsics.checkNotNullParameter(r29, "item");
        super.U3(r27, r28, r29, r30);
        if (ChatWindowServiceDelegate.b.d(this.g) == false) goto L6;
        FLogger.a.i("ObricPhoneOperationSegmentCell", "bind, isWindowContext");
        return;
    L6:
        c29.a r1 = this.f.a.getDelegate();
        ObricOAutoTaskState r2 = ObricOAutoTaskState.IDLE;
        switch(c.a[r2.ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            default: goto L9;
        };
    L10:
        ?? r4 = 1;
        b r3 = new b(2131103823, 2131103825, 2131103851, 2131103824, AppHost.a.getApplication().getString(2131911915), 2131103824, null, 64);
    L17:
        if (((Boolean) waa.a.d.getValue()).booleanValue() == true) goto L39;
        r1.s = r4;
        r1.c();
        if (r2 != ObricOAutoTaskState.EXECUTING) goto L21;
        boolean r13 = true;
    L22:
        if (r13 == true) goto L25;
        r2 = null;
    L25:
        if (r2 == null) goto L27;
        Integer[] r5 = new Integer[3];
        r5[0] = Integer.valueOf(ContextCompat.getColor(this.g, 2131103814));
        r5[r4] = Integer.valueOf(ContextCompat.getColor(this.g, 2131103815));
        r5[2] = Integer.valueOf(ContextCompat.getColor(this.g, 2131103816));
        List r6 = CollectionsKt.listOf(r5);
        Intrinsics.checkNotNullParameter(r6, "backgroundColorList");
        r1.f = r6;
        r1.c();
    L30:
        Context r7 = this.g;
        Integer r8 = r3.c;
        if (r8 == null) goto L33;
        int r9 = r8.intValue();
    L34:
        r1.b(ContextCompat.getColor(r7, r9));
        Context r10 = this.g;
        Integer r11 = r3.b;
        if (r11 == null) goto L37;
        int r12 = r11.intValue();
    L38:
        r1.g(ContextCompat.getColor(r10, r12));
        goto L39
    L37:
        r12 = v19.c.b(2130972087, r10, 2131103162);
        goto L38
    L33:
        r9 = v19.c.b(2130972118, r7, 2131103188);
        goto L34
    L27:
        Integer r14 = r3.a;
        if (r14 == null) goto L30;
        r1.a(ContextCompat.getColor(this.g, r14.intValue()));
        goto L30
    L21:
        r13 = false;
    L39:
        this.f.c.setColorFilter(ContextCompat.getColor(this.g, r3.d));
        this.f.d.setText(r3.e);
        Integer r15 = r3.f;
        if (r15 == null) goto L42;
        this.f.d.setTextColor(ContextCompat.getColor(this.g, r15.intValue()));
    L42:
        final int[] r16 = r3.g;
        if (r16 == null) goto L51;
        final AppCompatTextView r17 = this.f.d;
        if (r17.getWidth() != 0) goto L47;
    L50:
        r17.post(new n(this, r17, r16));
        return;
    L47:
        if (r17.getHeight() == 0) goto L50;
        X3(r17, r16);
        return;
    L51:
        this.f.d.getPaint().setShader(null);
        return;
    L11:
        r4 = 1;
        r3 = new b(2131103833, 2131103835, 2131103851, 2131103837, AppHost.a.getApplication().getString(2131911916), 2131103834, null, 64);
        goto L17
    L12:
        r4 = 1;
        r3 = new b(2131103836, 2131103838, 2131103851, 2131103837, AppHost.a.getApplication().getString(2131911917), 2131103837, null, 64);
        goto L17
    L13:
        r4 = 1;
        r3 = new b(2131103831, 2131103839, 2131103851, 2131103832, AppHost.a.getApplication().getString(2131911918), 2131103832, null, 64);
        goto L17
    L14:
        r4 = 1;
        r3 = new b(2131103814, 2131103818, 2131103851, 2131103817, AppHost.a.getApplication().getString(2131911914), null, new int[]{ContextCompat.getColor(this.g, 2131103778), ContextCompat.getColor(this.g, 2131103776), ContextCompat.getColor(this.g, 2131103777)}, 32);
        goto L17
    L15:
        r4 = 1;
        r3 = new b(null, null, null, 2131103820, AppHost.a.getApplication().getString(2131911902), 2131103849, null, 64);
        goto L17
    L9:
        throw new NoWhenBranchMatchedException();
    }
}
