package com.larus.common_ui.search;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.utils.x1;
import com.larus.common_res.common_ui.databinding.LarusViewSearchBarBinding;
import com.larus.utils.e1;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.d1;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\u0018\u0000 02\u00020\u0001:\u00010B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\rJ\u000e\u0010&\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\rJ\u000e\u0010'\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\rJ\u0019\u0010(\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010)J\b\u0010*\u001a\u00020\u001cH\u0002J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010,\u001a\u00020\u001cH\u0002J\u0006\u0010-\u001a\u00020\u001cJ\u0006\u0010.\u001a\u00020\u001cJ\u0006\u0010/\u001a\u00020\u001cR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 ¨\u00061"}, d2 = {"Lcom/larus/common_ui/search/SearchBar;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/common_res/common_ui/databinding/LarusViewSearchBarBinding;", "style", "", "customHintText", "", "lastValue", "_inputText", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "inputTextFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getInputTextFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "_searchTextFlow", "searchTextFlow", "getSearchTextFlow", "imeManager", "Lcom/larus/bmhome/utils/ImeManager;", "customCancelClickAction", "Lkotlin/Function0;", "", "getCustomCancelClickAction", "()Lkotlin/jvm/functions/Function0;", "setCustomCancelClickAction", "(Lkotlin/jvm/functions/Function0;)V", "clearClickListener", "getClearClickListener", "setClearClickListener", "setHint", "text", "setText", "setTextNoSearch", "initAttr", "(Landroid/util/AttributeSet;)Lkotlin/Unit;", "initView", "changeStyle", "initAction", "requestShowIme", "requestHideIme", "showBackIcon", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchBar extends RelativeLayout {
    public static final /* synthetic */ int l = 0;
    public LarusViewSearchBarBinding a;
    public int b;
    public String c;
    public String d;
    public final MutableSharedFlow<String> e;
    public final MutableSharedFlow f;
    public final MutableSharedFlow<String> g;
    public final MutableSharedFlow h;
    public final x1 i;
    public Function0<Unit> j;
    public Function0<Unit> k;

    public static final class a {
    }

    static {
    }

    public final void a() {
        x1 r0 = this.i;
        if (r0 == null) goto L5;
        Set r1 = x1.d;
        r0.a(false);
    L5:
        LarusViewSearchBarBinding r2 = this.a;
        if (r2 == null) goto L11;
        EditText r3 = r2.f;
        if (r3 == null) goto L12;
        r3.clearFocus();
        return;
    L12:
        return;
    }

    public final void b() {
        LarusViewSearchBarBinding r0 = this.a;
        if (r0 == null) goto L7;
        EditText r1 = r0.f;
        if (r1 == null) goto L7;
        r1.postDelayed(new f(this), 200);
    L7:
        LarusViewSearchBarBinding r2 = this.a;
        if (r2 == null) goto L13;
        EditText r3 = r2.f;
        if (r3 == null) goto L14;
        r3.requestFocus();
        return;
    L14:
        return;
    }

    public final Function0<Unit> getClearClickListener() {
        return this.k;
    }

    public final Function0<Unit> getCustomCancelClickAction() {
        return this.j;
    }

    public final d1<String> getInputTextFlow() {
        return this.f;
    }

    public final d1<String> getSearchTextFlow() {
        return this.h;
    }

    public SearchBar(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void setClearClickListener(Function0<Unit> r1) {
        this.k = r1;
    }

    public final void setCustomCancelClickAction(Function0<Unit> r1) {
        this.j = r1;
    }

    public final void setHint(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        LarusViewSearchBarBinding r0 = this.a;
        if (r0 == null) goto L8;
        EditText r1 = r0.f;
        if (r1 == null) goto L9;
        r1.setHint(r2);
        return;
    L9:
        return;
    }

    public final void setText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        LarusViewSearchBarBinding r0 = this.a;
        if (r0 == null) goto L7;
        EditText r1 = r0.f;
        if (r1 == null) goto L7;
        r1.setText(r2);
    L7:
        LarusViewSearchBarBinding r3 = this.a;
        if (r3 == null) goto L13;
        EditText r4 = r3.f;
        if (r4 == null) goto L14;
        r4.setSelection(r2.length());
        return;
    L14:
        return;
    }

    public final void setTextNoSearch(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        this.d = r2;
        setText(r2);
    }

    public SearchBar(Context r14, AttributeSet r15) {
        Intrinsics.checkNotNullParameter(r14, "context");
        super(r14, r15);
        x1 r0 = null;
        MutableSharedFlow<String> r2 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.e = r2;
        this.f = r2;
        MutableSharedFlow<String> r1 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.g = r1;
        this.h = r1;
        if (r15 == null) goto L5;
        TypedArray r16 = getContext().obtainStyledAttributes(r15, new int[]{2130971629, 2130972316});
        this.b = r16.getInt(1, 0);
        this.c = r16.getString(0);
        r16.recycle();
        Unit r17 = Unit.INSTANCE;
    L5:
        View r18 = RelativeLayout.inflate(getContext(), 2131563230, this);
        int r3 = 2131385309;
        AppCompatImageView r7 = ViewBindings.findChildViewById(r18, 2131385309);
        if (r7 == null) goto L105;
        r3 = 2131385347;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r18, 2131385347);
        if (r8 == null) goto L105;
        r3 = 2131385348;
        AppCompatImageView r9 = ViewBindings.findChildViewById(r18, 2131385348);
        if (r9 == null) goto L105;
        r3 = 2131385505;
        AppCompatImageView r10 = ViewBindings.findChildViewById(r18, 2131385505);
        if (r10 == null) goto L105;
        r3 = 2131385509;
        EditText r11 = (EditText) ViewBindings.findChildViewById(r18, 2131385509);
        if (r11 == null) goto L105;
        r3 = 2131385514;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r18, 2131385514);
        if (r4 == null) goto L105;
        this.a = new LarusViewSearchBarBinding((RelativeLayout) r18, r7, r8, r9, r10, r11, r4);
        e1.t(r4, c7.b(Float.valueOf(16.0f)), v19.c.b(2130970533, null, 2131102542));
        int r110 = this.b;
        this.b = r110;
        if (r110 == 0) goto L31;
        if (r110 != 1) goto L51;
        LarusViewSearchBarBinding r111 = this.a;
        if (r111 == null) goto L26;
        TextView r112 = r111.c;
        if (r112 == null) goto L26;
        r112.setVisibility(0);
    L26:
        LarusViewSearchBarBinding r113 = this.a;
        if (r113 == null) goto L51;
        EditText r114 = r113.f;
        if (r114 == null) goto L51;
        r114.setInputType(1);
    L51:
        String r115 = this.c;
        if (r115 == null) goto L58;
        LarusViewSearchBarBinding r5 = this.a;
        if (r5 == null) goto L58;
        EditText r6 = r5.f;
        if (r6 == null) goto L58;
        r6.setHint(r115);
    L58:
        LarusViewSearchBarBinding r116 = this.a;
        if (r116 == null) goto L63;
        AppCompatImageView r117 = r116.b;
        if (r117 == null) goto L63;
        e1.d(r117, new com.larus.common_ui.search.a(this));
    L63:
        LarusViewSearchBarBinding r118 = this.a;
        if (r118 == null) goto L68;
        TextView r119 = r118.c;
        if (r119 == null) goto L68;
        e1.d(r119, new b(this));
    L68:
        LarusViewSearchBarBinding r120 = this.a;
        if (r120 == null) goto L73;
        AppCompatImageView r121 = r120.d;
        if (r121 == null) goto L73;
        e1.d(r121, new c(this));
    L73:
        LarusViewSearchBarBinding r122 = this.a;
        if (r122 == null) goto L78;
        EditText r123 = r122.f;
        if (r123 == null) goto L78;
        r123.setOnKeyListener(new d(this));
    L78:
        LarusViewSearchBarBinding r124 = this.a;
        if (r124 == null) goto L83;
        EditText r125 = r124.f;
        if (r125 == null) goto L83;
        r125.addTextChangedListener(new SearchBar$initAction$5(this));
    L83:
        View[] r126 = new View[2];
        LarusViewSearchBarBinding r12 = this.a;
        if (r12 == null) goto L86;
        EditText r13 = r12.f;
    L87:
        r126[0] = r13;
        if (r12 == null) goto L90;
        AppCompatImageView r127 = r12.e;
    L91:
        r126[1] = r127;
        Iterator r128 = CollectionsKt.listOf(r126).iterator();
    L93:
        if (r128.hasNext() == false) goto L97;
        View r129 = (View) r128.next();
        if (r129 == null) goto L93;
        r129.setOnClickListener(new e(this));
        goto L93
    L97:
        LarusViewSearchBarBinding r130 = this.a;
        if (r130 == null) goto L102;
        EditText r131 = r130.f;
        if (r131 == null) goto L102;
        r0 = new x1(r131);
    L102:
        this.i = r0;
        return;
    L90:
        r127 = null;
        goto L91
    L86:
        r13 = null;
        goto L87
    L31:
        LarusViewSearchBarBinding r132 = this.a;
        if (r132 == null) goto L36;
        TextView r133 = r132.c;
        if (r133 == null) goto L36;
        r133.setVisibility(8);
    L36:
        LarusViewSearchBarBinding r134 = this.a;
        if (r134 == null) goto L41;
        EditText r135 = r134.f;
        if (r135 == null) goto L41;
        r135.setInputType(0);
    L41:
        LarusViewSearchBarBinding r136 = this.a;
        if (r136 == null) goto L46;
        EditText r137 = r136.f;
        if (r137 == null) goto L46;
        r137.setFocusable(false);
    L46:
        LarusViewSearchBarBinding r138 = this.a;
        if (r138 == null) goto L51;
        EditText r139 = r138.f;
        if (r139 == null) goto L51;
        r139.setFocusableInTouchMode(false);
    L105:
        throw new NullPointerException("Missing required view with ID: ".concat(r18.getResources().getResourceName(r3)));
    }
}
