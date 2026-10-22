package com.larus.bmhome.bigimg.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.view.e2;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.roundlayout.RoundTextView;
import com.larus.image.databinding.LarusLayoutBottomCreationEditAreaBinding;
import com.larus.network.http.HttpExtKt;
import com.larus.utils.e1;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\"\u001a\u00020\u0019H\u0002J<\u0010#\u001a\u00020\u00192\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020\u001b2\b\b\u0002\u0010,\u001a\u00020\u001bJ\u0010\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\bH\u0016J\u000e\u00100\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u001bJ\u0006\u00102\u001a\u00020\u0019J\u0006\u00103\u001a\u00020\u0019R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0015\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0016\u0010\u0012R#\u0010\u001c\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0014\u001a\u0004\b\u001f\u0010 R\u000e\u0010-\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/larus/bmhome/bigimg/widget/BottomCreationEditView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/bmhome/view/ICreationStatusChange;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/image/databinding/LarusLayoutBottomCreationEditAreaBinding;", "loadingStateJob", "Lkotlinx/coroutines/Job;", "remoteFunctionConfig", "Lcom/larus/platform/model/creation/EditFunctionArea;", "getRemoteFunctionConfig", "()Lcom/larus/platform/model/creation/EditFunctionArea;", "remoteFunctionConfig$delegate", "Lkotlin/Lazy;", "localFunctionConfig", "getLocalFunctionConfig", "localFunctionConfig$delegate", "setByPublisher", "", "isByPublisher", "", "cache", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "getCache", "()Lcom/bytedance/keva/Keva;", "cache$delegate", "handleRedVersion", "onBindData", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "imageUrl", "", "creationButtonStatus", "actionListener", "Lcom/larus/bmhome/bigimg/widget/ICreationEditActionListener;", "hasCreateVideoAbility", "hasCreateImageAbility", "currentCreationButtonStatus", "refreshCreationButtonStatus", "status", "setLayoutEnable", "enable", "showLoading", "hideLoading", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BottomCreationEditView extends ConstraintLayout implements e2 {
    public static final /* synthetic */ int g = 0;
    public final LarusLayoutBottomCreationEditAreaBinding a;
    public Job b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public int f;

    public BottomCreationEditView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BottomCreationEditView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public void setByPublisher(boolean r1) {
    }

    private final Keva getCache() {
        return (Keva) this.e.getValue();
    }

    private final sq9.r getLocalFunctionConfig() {
        return (sq9.r) this.d.getValue();
    }

    private final sq9.r getRemoteFunctionConfig() {
        return (sq9.r) this.c.getValue();
    }

    public final void S5() {
        sq9.r r0 = getRemoteFunctionConfig();
        getCache().storeString("creation_edit_function_list", GsonProtectorUtils.toJson(HttpExtKt.f, r0));
    }

    public static sq9.r R5(BottomCreationEditView r2) {
        String r3 = r2.getCache().getString("creation_edit_function_list", "");
        if (r3 == null) goto L7;
        sq9.r r4 = (sq9.r) GsonProtectorUtils.fromJson(HttpExtKt.f, r3, sq9.r.class);
        if (r4 == null) goto L7;
        return r4;
    L7:
        return new sq9.r(null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void r1(int r4) {
        this.f = r4;
        if (AppHost.a.isOversea() == false) goto L6;
        e1.o(this.a.h);
        return;
    L6:
        String r1 = "";
        if (r4 != 1) goto L9;
    L19:
        this.a.i.setImageResource(2131242403);
        AppCompatTextView r5 = this.a.j;
        Context r0 = getContext();
        if (r0 == null) goto L24;
        String r2 = r0.getString(2131901168);
        if (r2 == null) goto L24;
        r1 = r2;
    L24:
        r5.setText(r1);
        return;
    L9:
        if (r4 == 2) goto L19;
        if (r4 == 3) goto L13;
        this.a.h.setVisibility(8);
        return;
    L13:
        this.a.i.setImageResource(2131242559);
        AppCompatTextView r6 = this.a.j;
        Context r3 = getContext();
        if (r3 == null) goto L18;
        String r7 = r3.getString(2131900630);
        if (r7 == null) goto L18;
        r1 = r7;
    L18:
        r6.setText(r1);
    }

    public final void setLayoutEnable(boolean r5) {
        this.a.e.setEnabled(r5);
        ConstraintLayout r0 = this.a.e;
        float r1 = 1.0f;
        if (r5 == false) goto L5;
        float r3 = 1.0f;
    L6:
        r0.setAlpha(r3);
        this.a.h.setEnabled(r5);
        LinearLayout r2 = this.a.h;
        if (r5 == false) goto L9;
        float r4 = 1.0f;
    L10:
        r2.setAlpha(r4);
        this.a.k.setEnabled(r5);
        ConstraintLayout r6 = this.a.k;
        if (r5 == false) goto L13;
        float r7 = 1.0f;
    L14:
        r6.setAlpha(r7);
        this.a.b.setEnabled(r5);
        LinearLayout r8 = this.a.b;
        if (r5 == true) goto L18;
        r1 = 0.3f;
    L18:
        r8.setAlpha(r1);
        return;
    L13:
        r7 = 0.3f;
        goto L14
    L9:
        r4 = 0.3f;
        goto L10
    L5:
        r3 = 0.3f;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BottomCreationEditView(Context r13, AttributeSet r14, int r15) {
        Intrinsics.checkNotNullParameter(r13, "context");
        super(r13, r14, r15);
        LayoutInflater.from(r13).inflate(2131562759, this);
        int r16 = 2131370152;
        LinearLayout r2 = (LinearLayout) ViewBindings.findChildViewById(this, 2131370152);
        if (r2 == null) goto L31;
        r16 = 2131370175;
        AppCompatImageView r3 = ViewBindings.findChildViewById(this, 2131370175);
        if (r3 == null) goto L31;
        r16 = 2131370176;
        ProgressBar r4 = (ProgressBar) ViewBindings.findChildViewById(this, 2131370176);
        if (r4 == null) goto L31;
        r16 = 2131370178;
        if (ViewBindings.findChildViewById(this, 2131370178) == null) goto L31;
        r16 = 2131371412;
        if (ViewBindings.findChildViewById(this, 2131371412) == null) goto L31;
        r16 = 2131374980;
        ConstraintLayout r5 = ViewBindings.findChildViewById(this, 2131374980);
        if (r5 == null) goto L31;
        r16 = 2131376203;
        RoundTextView r6 = ViewBindings.findChildViewById(this, 2131376203);
        if (r6 == null) goto L31;
        r16 = 2131376204;
        RoundTextView r7 = ViewBindings.findChildViewById(this, 2131376204);
        if (r7 == null) goto L31;
        r16 = 2131383425;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(this, 2131383425);
        if (r8 == null) goto L31;
        r16 = 2131383426;
        AppCompatImageView r9 = ViewBindings.findChildViewById(this, 2131383426);
        if (r9 == null) goto L31;
        r16 = 2131383427;
        AppCompatTextView r10 = ViewBindings.findChildViewById(this, 2131383427);
        if (r10 == null) goto L31;
        r16 = 2131388940;
        ConstraintLayout r11 = ViewBindings.findChildViewById(this, 2131388940);
        if (r11 == null) goto L31;
        r16 = 2131388941;
        if (ViewBindings.findChildViewById(this, 2131388941) == null) goto L31;
        this.a = new LarusLayoutBottomCreationEditAreaBinding(this, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
        this.c = LazyKt.lazy(new a());
        this.d = LazyKt.lazy(new b(this));
        this.e = LazyKt.lazy(new c());
        setPadding(c7.b(12), 0, c7.b(12), c7.b(7));
        return;
    L31:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r16)));
    }

    public /* synthetic */ BottomCreationEditView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void T5(CoroutineScope r10, String r11, int r12, final j r13, boolean r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r11, "imageUrl");
        Intrinsics.checkNotNullParameter(r13, "actionListener");
        r1(r12);
        Job r0 = this.b;
        boolean r1 = true;
        Object r2 = null;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        if (r10 == null) goto L7;
        Job r16 = BuildersKt.launch$default(r10, Dispatchers.getMain(), null, new BottomCreationEditView$onBindData$1(r11, this, null), 2, null);
    L8:
        this.b = r16;
        e1.d(this.a.e, new d(r13, this));
        int r17 = 8;
        if (r15 == false) goto L50;
        this.a.e.setVisibility(0);
        sq9.r r18 = getRemoteFunctionConfig();
        if (r18 == null) goto L26;
        List r19 = r18.a();
        if (r19 == null) goto L26;
        Iterator r110 = r19.iterator();
    L16:
        if (r110.hasNext() == false) goto L20;
        Object r3 = r110.next();
        if (Intrinsics.areEqual(((sq9.s) r3).a(), "image_edit") == false) goto L16;
    L21:
        sq9.s r4 = (sq9.s) r3;
        if (r4 == null) goto L26;
        Integer r111 = r4.b();
        if (r111 == null) goto L26;
        int r112 = r111.intValue();
    L27:
        List r5 = getLocalFunctionConfig().a();
        if (r5 == null) goto L41;
        Iterator r6 = r5.iterator();
    L31:
        if (r6.hasNext() == false) goto L35;
        Object r7 = r6.next();
        if (Intrinsics.areEqual(((sq9.s) r7).a(), "image_edit") == false) goto L31;
    L36:
        sq9.s r8 = (sq9.s) r7;
        if (r8 == null) goto L41;
        Integer r9 = r8.b();
        if (r9 == null) goto L41;
        int r20 = r9.intValue();
    L42:
        if (r112 <= r20) goto L44;
        boolean r113 = true;
    L45:
        RoundTextView r21 = this.a.f;
        if (r113 == false) goto L48;
        int r114 = 0;
    L49:
        r21.setVisibility(r114);
    L51:
        if (r14 == false) goto L90;
        this.a.k.setVisibility(0);
        sq9.r r115 = getRemoteFunctionConfig();
        if (r115 == null) goto L68;
        List r116 = r115.a();
        if (r116 == null) goto L68;
        Iterator r117 = r116.iterator();
    L58:
        if (r117.hasNext() == false) goto L62;
        Object r22 = r117.next();
        if (Intrinsics.areEqual(((sq9.s) r22).a(), "to_video") == false) goto L58;
    L63:
        sq9.s r23 = (sq9.s) r22;
        if (r23 == null) goto L68;
        Integer r118 = r23.b();
        if (r118 == null) goto L68;
        int r119 = r118.intValue();
    L69:
        List r24 = getLocalFunctionConfig().a();
        if (r24 == null) goto L82;
        Iterator r25 = r24.iterator();
    L73:
        if (r25.hasNext() == false) goto L77;
        Object r26 = r25.next();
        if (Intrinsics.areEqual(((sq9.s) r26).a(), "to_video") == false) goto L73;
        r2 = r26;
    L77:
        sq9.s r27 = (sq9.s) r2;
        if (r27 == null) goto L82;
        Integer r120 = r27.b();
        if (r120 == null) goto L82;
        int r121 = r120.intValue();
    L83:
        if (r119 > r121) goto L86;
        r1 = false;
    L86:
        RoundTextView r122 = this.a.g;
        if (r1 == false) goto L89;
        r17 = 0;
    L89:
        r122.setVisibility(r17);
    L91:
        e1.d(this.a.k, new e(r13, this));
        e1.d(this.a.h, new f(this, r13));
        e1.d(this.a.b, new g(r13));
        r1(r12);
        return;
    L82:
        r121 = 0;
        goto L83
    L62:
        r22 = null;
    L68:
        r119 = 0;
        goto L69
    L90:
        this.a.k.setVisibility(8);
        goto L91
    L48:
        r114 = 8;
        goto L49
    L44:
        r113 = false;
        goto L45
    L35:
        r7 = null;
    L41:
        r20 = 0;
        goto L42
    L20:
        r3 = null;
    L26:
        r112 = 0;
        goto L27
    L50:
        this.a.e.setVisibility(8);
        goto L51
    L7:
        r16 = null;
        goto L8
    }
}
