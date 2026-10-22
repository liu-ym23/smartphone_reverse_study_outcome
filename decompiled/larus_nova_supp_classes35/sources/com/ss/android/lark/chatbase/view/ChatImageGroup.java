package com.ss.android.lark.chatbase.view;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.integration.webp.decoder.WebpDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.chat.chatwindow.chat.view.IMCircleLoadingView;
import com.ss.android.lark.widget.DonutProgress;
import com.ss.android.lark.widget.mark.MarkView;
import java.lang.ref.WeakReference;
import pl.droidsonroids.gif.GifImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ChatImageGroup extends FrameLayout {
    public static final /* synthetic */ int k = 0;
    public ChatImageView a;
    public GifImageView b;
    public DonutProgress c;
    public Context d;
    public boolean e;
    public WeakReference<RecyclerView> f;
    public b g;
    public MarkView h;
    public MarkView i;
    public IMCircleLoadingView j;

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.e == false) goto L5;
        return;
    L5:
        if (this.a.getVisibility() != 0) goto L25;
        ViewParent r0 = getParent();
    L9:
        if ((r0 instanceof ViewGroup) == false) goto L26;
        if ((r0 instanceof RecyclerView) == true) goto L13;
        r0 = ((ViewGroup) r0).getParent();
        goto L9
    L13:
        RecyclerView r1 = (RecyclerView) r0;
        this.f = new WeakReference(r1);
        if (this.g != null) goto L16;
        this.g = new b(this);
    L16:
        r1.addOnScrollListener(this.g);
        if (r1.getScrollState() != 0) goto L19;
        boolean r2 = true;
    L20:
        a(r2);
        this.e = true;
        return;
    L19:
        r2 = false;
        goto L20
    L26:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.e == false) goto L14;
        WeakReference<RecyclerView> r0 = this.f;
        if (r0 != null) goto L7;
        return;
    L7:
        if (this.g == null) goto L16;
        RecyclerView r1 = r0.get();
        if (r1 == null) goto L17;
        r1.removeOnScrollListener(this.g);
        this.e = false;
        return;
    L17:
        return;
    L16:
        return;
    }

    public ChatImageGroup(Context r1) {
        super(r1);
        b(r1);
    }

    public final void a(boolean r3) {
        Object r0 = this.a.getDrawable();
        if (this.a.getVisibility() == 0) goto L6;
        return;
    L6:
        if ((r0 instanceof GifDrawable) == false) goto L8;
    L9:
        if (r3 == false) goto L11;
        ((Animatable) r0).start();
        return;
    L11:
        ((Animatable) r0).stop();
        return;
    L8:
        if ((r0 instanceof WebpDrawable) == true) goto L9;
    }

    public final void b(Context r3) {
        this.d = r3;
        setBackgroundColor(v2c.a.b(r3, 2131100549));
        LayoutInflater.from(getContext()).inflate(2131559282, this, true);
        ChatImageView r4 = (ChatImageView) findViewById(2131365536);
        this.a = r4;
        r4.setOnImageDrawableChangedListener(new a(this));
        this.b = findViewById(2131365601);
        DonutProgress r5 = findViewById(2131391934);
        this.c = r5;
        r5.setMax(100);
        this.h = findViewById(2131384426);
        this.i = findViewById(2131390769);
        this.j = (IMCircleLoadingView) findViewById(2131379091);
        this.a.setVisibility(0);
        this.b.setVisibility(8);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public synchronized void setProgress(int r4) {
        monitor-enter(this);
        if (r4 >= 0) goto L19;
        r4 = 0;
    L19:
        if (r4 < 100) goto L9;
        this.c.setVisibility(8);     // Catch: Throwable -> L16
        this.a.clearColorFilter();     // Catch: Throwable -> L16
    L13:
        this.c.setProgress(r4);     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L9:
        if (this.c.getVisibility() == 0) goto L11;
        this.c.setVisibility(0);     // Catch: Throwable -> L16
    L11:
        this.a.setColorFilter(UDColorUtils.getColor(this.d, 2131108740));     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public ChatImageGroup(Context r1, AttributeSet r2) {
        super(r1, r2);
        b(r1);
    }

    public ChatImageGroup(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        b(r1);
    }
}
