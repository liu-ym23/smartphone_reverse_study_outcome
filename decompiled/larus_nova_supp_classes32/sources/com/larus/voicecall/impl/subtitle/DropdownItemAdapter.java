package com.larus.voicecall.impl.subtitle;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.image.loader.ImageLoaderKt;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B\u0019\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0005H\u0016R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/larus/voicecall/impl/subtitle/DropdownItemAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionOption;", "Lcom/larus/voicecall/impl/subtitle/DropdownItemHolder;", "dropdownBoxId", NameKeys.UnloadStrategy_No_Strategy, "callback", "Lcom/larus/voicecall/impl/subtitle/DropdownSelectorHolderCallback;", "<init>", "(Ljava/lang/Integer;Lcom/larus/voicecall/impl/subtitle/DropdownSelectorHolderCallback;)V", "Ljava/lang/Integer;", "maxWidth", "getMaxWidth", "()I", "setMaxWidth", "(I)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", NameKeys.UnloadStrategy_No_Strategy, "holder", "position", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DropdownItemAdapter extends ListAdapter<com.larus.bmhome.actionbar.model.w, DropdownItemHolder> {
    public static final DropdownItemAdapter$Companion$DIFF_CALLBACK$1 d = null;
    public final Integer a;
    public final e b;
    public int c;

    public static final class a {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.voicecall.impl.subtitle.DropdownItemAdapter$Companion$DIFF_CALLBACK$1] */
    static {
        d = new DropdownItemAdapter$Companion$DIFF_CALLBACK$1();
    }

    public DropdownItemAdapter(Integer r2, e r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        super(d);
        this.a = r2;
        this.b = r3;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r9, int r10) {
        final DropdownItemHolder r11 = (DropdownItemHolder) r9;
        Intrinsics.checkNotNullParameter(r11, "holder");
        final com.larus.bmhome.actionbar.model.w r12 = (com.larus.bmhome.actionbar.model.w) getItem(r10);
        Intrinsics.checkNotNull(r12);
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, LynxResourceModule.DATA_KEY);
        Integer r0 = r12.s;
        if (r0 != null) goto L6;
    L8:
        if (r0 != null) goto L11;
    L13:
        TextView r1 = r11.f;
        String r2 = r12.b;
        if (r2 != null) goto L16;
        r2 = NameKeys.UnloadStrategy_No_Strategy;
    L16:
        Map r3 = r12.q;
        RecyclerView.Adapter r4 = null;
        if (r3 == null) goto L19;
        String r5 = (String) r3.get("describe_text");
    L21:
        if (TextUtils.isEmpty(r5) == true) goto L23;
        r2 = r2 + r5;
    L23:
        r1.setText(r2);
        Map r6 = r12.q;
        if (r6 == null) goto L26;
        String r7 = (String) r6.get("sub_display");
    L27:
        if (r7 == null) goto L29;
        com.larus.utils.e1.x(r11.h);
        r11.h.setText(r7);
    L30:
        com.larus.utils.e1.d(r11.a, new d(r11, r12));
        boolean r8 = v19.h.a;
        if (v19.h.a(null) == false) goto L35;
        com.larus.bmhome.actionbar.model.g1 r13 = r12.g;
        if (r13 != null) goto L37;
        r13 = r12.f;
    L37:
        if (r13 == null) goto L68;
        Integer r14 = r13.c;
        if (r14 != null) goto L41;
    L64:
        SimpleDraweeView r15 = r11.g;
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        r16.width = j19.c.c(20);
        r16.height = j19.c.c(20);
        Integer r17 = r13.e;
        if (r17 == null) goto L67;
        r15.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadius(c7.c(Integer.valueOf(r17.intValue()))));
    L67:
        ImageLoaderKt.u(r15, r13.b, "template_item_photo");
        com.larus.utils.e1.x(r15);
    L69:
        RecyclerView r18 = r11.a.getParent();
        if ((r18 instanceof RecyclerView) == false) goto L72;
        RecyclerView r19 = r18;
    L73:
        if (r19 == null) goto L75;
        r4 = r19.getAdapter();
    L75:
        int r20 = r11.getAdapterPosition();
        if (r4 == null) goto L78;
        Object r21 = Integer.valueOf(r4.getItemCount() - 1);
    L80:
        if ((r21 instanceof Integer) == true) goto L83;
    L85:
        com.larus.utils.e1.x(r11.e);
    L86:
        r11.a.measure(0, 0);
        int r22 = r11.a.getMeasuredWidth();
        if (r22 <= this.c) goto L90;
        this.c = r22;
        return;
    L90:
        return;
    L83:
        if (r20 != ((Number) r21).intValue()) goto L85;
        com.larus.utils.e1.o(r11.e);
        goto L86
    L78:
        r21 = Boolean.FALSE;
        goto L80
    L72:
        r19 = null;
        goto L73
    L41:
        if (r14.intValue() <= 0) goto L43;
        boolean r23 = true;
    L44:
        if (r23 == true) goto L47;
        r14 = null;
    L47:
        if (r14 == null) goto L64;
        int r24 = r14.intValue();
        Integer r25 = r13.d;
        if (r25 != null) goto L51;
    L62:
        com.larus.utils.e1.o(r11.g);
        SimpleDraweeView r26 = Unit.INSTANCE;
    L63:
        if (r26 != null) goto L69;
    L51:
        if (r25.intValue() <= 0) goto L53;
        boolean r27 = true;
    L54:
        if (r27 == true) goto L57;
        r25 = null;
    L57:
        if (r25 == null) goto L62;
        int r28 = r25.intValue();
        ViewGroup.LayoutParams r29 = r11.g.getLayoutParams();
        r29.width = j19.c.c(Integer.valueOf(r24));
        r29.height = j19.c.c(Integer.valueOf(r28));
        r26 = r11.g;
        r26.requestLayout();
        ImageLoaderKt.u(r26, r13.b, "template_item_photo");
        Integer r30 = r13.e;
        if (r30 == null) goto L61;
        r26.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadius(c7.c(Integer.valueOf(r30.intValue()))));
    L61:
        com.larus.utils.e1.x(r26);
        goto L63
    L53:
        r27 = false;
        goto L54
    L43:
        r23 = false;
        goto L44
    L68:
        com.larus.utils.e1.o(r11.g);
        goto L69
    L35:
        r13 = r12.f;
        goto L37
    L29:
        com.larus.utils.e1.o(r11.h);
        goto L30
    L26:
        r7 = null;
        goto L27
    L19:
        r5 = null;
        goto L21
    L11:
        if (r0.intValue() != 1) goto L13;
        com.larus.utils.e1.x(r11.d);
        goto L13
    L6:
        if (r0.intValue() != 0) goto L8;
        com.larus.utils.e1.o(r11.d);
        goto L13
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        ConstraintLayout r5 = LayoutInflater.from(r3.getContext()).inflate(2131563096, r3, false);
        int r6 = 2131374690;
        if (ViewBindings.findChildViewById(r5, 2131374690) == null) goto L17;
        r6 = 2131374691;
        if (ViewBindings.findChildViewById(r5, 2131374691) == null) goto L17;
        r6 = 2131375736;
        if (ViewBindings.findChildViewById(r5, 2131375736) == null) goto L17;
        r6 = 2131378904;
        if (((LinearLayout) ViewBindings.findChildViewById(r5, 2131378904)) == null) goto L17;
        r6 = 2131390825;
        if (ViewBindings.findChildViewById(r5, 2131390825) == null) goto L17;
        r6 = 2131390830;
        if (ViewBindings.findChildViewById(r5, 2131390830) == null) goto L17;
        return new DropdownItemHolder(r5, this.a, this.b);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
