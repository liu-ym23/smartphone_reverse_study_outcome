package com.larus.bmhome.chat.standarduikit.localfileblock.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.chat.standarduikit.fileblock.view.FileAudioButtonView;
import com.larus.bmhome.chat.standarduikit.localfileblock.viewmodel.g;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.mainbot.impl.databinding.LarusBlockItemLocalFileBinding;
import com.larus.utils.e1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.h;
import vl8.a;
import vl8.b;
import vl8.c;
import vl8.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0004H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/localfileblock/view/LocalFileCardView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/localfileblock/view/LocalFileCardViewInput;", "Lcom/larus/bmhome/chat/standarduikit/localfileblock/view/LocalFileCardViewOutput;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "boundPath", "", "binding", "Lcom/larus/mainbot/impl/databinding/LarusBlockItemLocalFileBinding;", "getBinding", "()Lcom/larus/mainbot/impl/databinding/LarusBlockItemLocalFileBinding;", "binding$delegate", "Lkotlin/Lazy;", "bindData", "", "input", "output", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LocalFileCardView extends ConstraintLayout {
    public static final /* synthetic */ int c = 0;
    public String a;
    public final Lazy b;

    private final LarusBlockItemLocalFileBinding getBinding() {
        return (LarusBlockItemLocalFileBinding) this.b.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LocalFileCardView(final Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = "";
        this.b = LazyKt.lazy(new a(r2, this));
        setBackgroundResource(2131239091);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5(final e r5, final g r6) {
        Intrinsics.checkNotNullParameter(r5, "input");
        Intrinsics.checkNotNullParameter(r6, "output");
        this.a = r5.g;
        Integer r0 = r5.i;
        if (r0 == null) goto L5;
        setBackgroundResource(r0.intValue());
    L5:
        boolean r1 = h.a;
        if (h.b(getContext()) == false) goto L8;
        String r2 = r5.a;
    L9:
        ImageLoaderKt.u(getBinding().c, r2, "cot_detail_page");
        getBinding().d.setText(r5.c);
        TextView r3 = getBinding().d;
        if (r5.e == false) goto L12;
        int r4 = 2;
    L13:
        r3.setMaxLines(r4);
        TextView r7 = getBinding().d;
        if (r5.e == false) goto L16;
        TextUtils.TruncateAt r8 = TextUtils.TruncateAt.END;
    L17:
        r7.setEllipsize(r8);
        getBinding().e.setText(r5.d);
        TextView r9 = getBinding().e;
        int r10 = 0;
        if (r5.e == false) goto L25;
        boolean r11 = true;
        if (r5.d.length() <= 0) goto L22;
        boolean r12 = true;
    L23:
        if (r12 == false) goto L25;
    L27:
        if (r11 == false) goto L29;
        int r13 = 0;
    L30:
        r9.setVisibility(r13);
        FileAudioButtonView r14 = getBinding().b;
        if (r5.f == true) goto L34;
        r10 = 8;
    L34:
        r14.setVisibility(r10);
        getBinding().b.c(r5.h);
        e1.d(getBinding().b, new b(r5, r6, this));
        e1.d(getBinding().a, new c(r6));
        return;
    L29:
        r13 = 8;
        goto L30
    L22:
        r12 = false;
    L25:
        r11 = false;
        goto L27
    L16:
        r8 = null;
        goto L17
    L12:
        r4 = Integer.MAX_VALUE;
        goto L13
    L8:
        r2 = r5.b;
        goto L9
    }

    public static Unit R5(LocalFileCardView r1, String r2, vl8.g r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        if (Intrinsics.areEqual(r1.a, r2) == false) goto L6;
        r1.getBinding().b.c(r3);
    L6:
        return Unit.INSTANCE;
    }
}
