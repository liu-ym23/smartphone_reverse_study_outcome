package com.obric.assistant.omnidetailpage.blockview.operatephone;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.layout.widget.ShimmerLinearLayout;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.OOmniDetailGUIProcessBlock;
import com.obric.assistant.card.databinding.ObricOmniBlockTaskOperatePhoneBinding;
import com.obric.assistant.omnidetailpage.blockview.base.OmniDetailVerticalLineFrameLayout;
import com.obric.assistant.omnidetailpage.util.OmniPageUtil;
import hfa.c;
import hfa.d;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0001\"B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0019\u001a\u00020\u0015H\u0002JN\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00112\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00180\u001f2\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00150\u00142\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00150\u0014J\b\u0010 \u001a\u00020\u0011H\u0002J\b\u0010!\u001a\u00020\u0015H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/assistant/omnidetailpage/blockview/operatephone/OperatePhoneView;", "Lcom/obric/assistant/omnidetailpage/blockview/base/OmniDetailVerticalLineFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/obric/assistant/card/databinding/ObricOmniBlockTaskOperatePhoneBinding;", "adapter", "Lcom/obric/assistant/omnidetailpage/blockview/operatephone/OperatePhoneInnerAdapter;", "block", "Lcom/larus/im/bean/message/block/Block;", "isExpanded", "", "forceExpand", "onExpandChange", "Lkotlin/Function1;", "", "shouldShowAnim", "onItemClick", "", "updateExpandState", "bind", "item", "Lcom/obric/assistant/omnidetailpage/model/OmniTaskItem$OperatePhone;", "expanded", "instructionTypeProvider", "Lkotlin/Function0;", "shouldShowProgress", "setProgressShimmerAnimStatus", "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OperatePhoneView extends OmniDetailVerticalLineFrameLayout {
    public static final /* synthetic */ int k = 0;
    public final ObricOmniBlockTaskOperatePhoneBinding c;
    public final OperatePhoneInnerAdapter d;
    public Block e;
    public boolean f;
    public boolean g;
    public Function1<? super Boolean, Unit> h;
    public boolean i;
    public Function1<? super String, Unit> j;

    public static final class a {
    }

    static {
    }

    public OperatePhoneView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public OperatePhoneView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void a() {
        ObricOmniBlockTaskOperatePhoneBinding r0 = this.c;
        if (r0 == null) goto L13;
        boolean r1 = h.a;
        if (h.a(null) == false) goto L7;
        r0.h.setShimmerColor(ContextCompat.getColor(getContext(), 2131100494));
    L9:
        if (this.i == false) goto L11;
        r0.h.b();
        return;
    L11:
        r0.h.a();
        return;
    L7:
        r0.h.setShimmerColor(ContextCompat.getColor(getContext(), 2131100492));
        goto L9
    }

    public final void b() {
        ObricOmniBlockTaskOperatePhoneBinding r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.f == false) goto L7;
    L10:
        r0.e.setRotation(90.0f);
        r0.d.setVisibility(0);
    L11:
        ImageView r1 = r0.e;
        boolean r5 = true;
        if ((!this.g) == false) goto L14;
        int r4 = 0;
    L15:
        r1.setVisibility(r4);
        ConcurrentHashMap<String, Pair<Drawable, String>> r2 = OmniPageUtil.a;
        Block r3 = this.e;
        if (r3 == null) goto L22;
        BlockContent r6 = r3.getContent();
        if (r6 == null) goto L22;
        OOmniDetailGUIProcessBlock r7 = r6.getOOmniDetailGUIBlock();
        if (r7 == null) goto L22;
        String r8 = r7.getNowPackageName();
    L23:
        if (r8 != null) goto L26;
        r8 = "";
    L26:
        if (OmniPageUtil.b(r8, getContext().getPackageManager(), getContext(), false).getFirst() != null) goto L44;
        Block r9 = this.e;
        if (r9 == null) goto L41;
        BlockContent r10 = r9.getContent();
        if (r10 == null) goto L41;
        OOmniDetailGUIProcessBlock r11 = r10.getOOmniDetailGUIBlock();
        if (r11 == null) goto L41;
        String r12 = r11.getNowProcessContent();
        if (r12 == null) goto L41;
        if (r12.length() <= 0) goto L38;
        boolean r13 = true;
    L39:
        if (r13 != true) goto L41;
        boolean r14 = true;
    L42:
        if (r14 == true) goto L44;
    L46:
        boolean r15 = false;
    L47:
        if (r15 == false) goto L49;
        r0.h.setVisibility(0);
        a();
    L50:
        Block r16 = this.e;
        if (r16 == null) goto L64;
        BlockContent r17 = r16.getContent();
        if (r17 == null) goto L64;
        OOmniDetailGUIProcessBlock r18 = r17.getOOmniDetailGUIBlock();
        if (r18 == null) goto L64;
        String r19 = r18.getNowPackageName();
        if (r19 == null) goto L64;
        if (r19.length() <= 0) goto L61;
        boolean r20 = true;
    L62:
        if (r20 != true) goto L64;
        boolean r21 = true;
    L65:
        if (r21 == true) goto L86;
        Block r22 = this.e;
        if (r22 == null) goto L80;
        BlockContent r23 = r22.getContent();
        if (r23 == null) goto L80;
        OOmniDetailGUIProcessBlock r24 = r23.getOOmniDetailGUIBlock();
        if (r24 == null) goto L80;
        String r25 = r24.getNowProcessContent();
        if (r25 == null) goto L80;
        if (r25.length() <= 0) goto L77;
        boolean r26 = true;
    L78:
        if (r26 != true) goto L80;
    L81:
        if (r5 == true) goto L86;
        if (this.f == true) goto L86;
        LinearLayout r27 = r0.b;
        ViewGroup.LayoutParams r28 = r27.getLayoutParams();
        r28.width = -2;
        r27.setLayoutParams(r28);
        r0.c.setVisibility(8);
        return;
    L77:
        r26 = false;
    L80:
        r5 = false;
    L86:
        LinearLayout r29 = r0.b;
        ViewGroup.LayoutParams r30 = r29.getLayoutParams();
        r30.width = -1;
        r29.setLayoutParams(r30);
        r0.c.setVisibility(0);
        return;
    L61:
        r20 = false;
    L64:
        r21 = false;
        goto L65
    L49:
        r0.h.setVisibility(8);
        r0.h.a();
        goto L50
    L38:
        r13 = false;
    L41:
        r14 = false;
    L44:
        if (this.f == true) goto L46;
        r15 = true;
    L22:
        r8 = null;
        goto L23
    L14:
        r4 = 8;
        goto L15
    L7:
        if (this.g == true) goto L10;
        r0.e.setRotation(0.0f);
        r0.d.setVisibility(8);
        goto L11
    }

    /* JADX WARN: Type inference failed for: r5v10, types: [hfa.c] */
    public OperatePhoneView(Context r18, AttributeSet r19, int r20) {
        Intrinsics.checkNotNullParameter(r18, "context");
        super(r18, r19, r20);
        View r2 = LayoutInflater.from(r18).inflate(2131564045, this, false);
        addView(r2);
        int r3 = 2131364330;
        if (((LinearLayout) ViewBindings.findChildViewById(r2, 2131364330)) == null) goto L27;
        r3 = 2131365145;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r2, 2131365145);
        if (r7 == null) goto L27;
        r3 = 2131369197;
        View r8 = ViewBindings.findChildViewById(r2, 2131369197);
        if (r8 == null) goto L27;
        r3 = 2131375306;
        RecyclerView r4 = ViewBindings.findChildViewById(r2, 2131375306);
        if (r4 == null) goto L27;
        r3 = 2131375898;
        ImageView r10 = (ImageView) ViewBindings.findChildViewById(r2, 2131375898);
        if (r10 == null) goto L27;
        r3 = 2131377404;
        LinearLayout r15 = (LinearLayout) ViewBindings.findChildViewById(r2, 2131377404);
        if (r15 == null) goto L27;
        r3 = 2131377698;
        AppCompatImageView r12 = ViewBindings.findChildViewById(r2, 2131377698);
        if (r12 == null) goto L27;
        r3 = 2131383292;
        ShimmerLinearLayout r13 = ViewBindings.findChildViewById(r2, 2131383292);
        if (r13 == null) goto L27;
        r3 = 2131384507;
        if (ViewBindings.findChildViewById(r2, 2131384507) == null) goto L27;
        r3 = 2131390061;
        CustomMarkdownTextView r14 = ViewBindings.findChildViewById(r2, 2131390061);
        if (r14 == null) goto L27;
        r3 = 2131390084;
        TextView r16 = (TextView) ViewBindings.findChildViewById(r2, 2131390084);
        if (r16 == null) goto L27;
        this.c = new ObricOmniBlockTaskOperatePhoneBinding((LinearLayout) r2, r7, r8, r4, r10, r15, r12, r13, r14, r16);
        setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        OperatePhoneInnerAdapter r5 = new OperatePhoneInnerAdapter(new c(this), 5);
        this.d = r5;
        r4.setLayoutManager(new LinearLayoutManager(r18));
        r4.setAdapter(r5);
        b();
        r15.setOnClickListener(new d(this));
        return;
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(r3)));
    }

    public /* synthetic */ OperatePhoneView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
