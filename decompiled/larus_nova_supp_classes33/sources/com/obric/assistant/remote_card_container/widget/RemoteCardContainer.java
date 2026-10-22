package com.obric.assistant.remote_card_container.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.aiagent.assistant_card.provider_core.bean.CardAction;
import com.obric.assistant.remote_card_container.cache.CardCacheManager;
import com.obric.assistant.remote_card_container.cache.m;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0001CB)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\fB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\rB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000eJ\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0012J\u0012\u0010$\u001a\u00020!2\b\u0010%\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010&\u001a\u00020!H\u0014J\b\u0010'\u001a\u00020!H\u0014J\u001c\u0010(\u001a\u00020!2\b\u0010)\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010*\u001a\u00020+H\u0002J\u001a\u0010,\u001a\u00020!2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010-\u001a\u0004\u0018\u00010.H\u0002J\u0010\u0010/\u001a\u00020!2\u0006\u00100\u001a\u00020\u0014H\u0016J\u0010\u00101\u001a\u00020!2\u0006\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020!2\u0006\u00102\u001a\u000203H\u0002J(\u00105\u001a\u00020!2\u0006\u00106\u001a\u00020\b2\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\bH\u0014J\u0018\u0010:\u001a\u00020!2\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\bH\u0002J(\u0010=\u001a\u00020!2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010>\u001a\u00020.2\u0006\u00100\u001a\u00020\u00142\u0006\u0010?\u001a\u00020@H\u0002J \u0010A\u001a\u00020!2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u00142\u0006\u0010B\u001a\u00020@H\u0002R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/obric/assistant/remote_card_container/widget/RemoteCardContainer;", "Landroid/widget/RelativeLayout;", "Lcom/obric/assistant/remote_card_container/manager/CardChangeListener$OnCardChangeListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "bindCardData", "Lcom/obric/assistant/remote_card_container/widget/MsgCardData;", "displayedCardUri", "", "roundAnglePath", "Landroid/graphics/Path;", "getRoundAnglePath", "()Landroid/graphics/Path;", "roundAnglePath$delegate", "Lkotlin/Lazy;", "loadJob", "Lkotlinx/coroutines/Job;", "defaultRoundAngle", "onLongClickListener", "Landroid/view/View$OnLongClickListener;", "setDefaultRoundAngle", "", "roundAngle", "cardData", "setOnLongClickListener", "listener", "onAttachedToWindow", "onDetachedFromWindow", "loadRemoteCard", "remoteCardData", "allowCache", "", "wrapChildWithHorizontalScrollView", "child", "Landroid/view/View;", "onCardStateChanged", "cardUri", "draw", "canvas", "Landroid/graphics/Canvas;", "drawWithAngle", "onSizeChanged", "w", "h", "oldw", "oldh", "updateRoundPath", "width", "height", "bindCardActionToView", "view", "cardAction", "Lcom/obric/aiagent/assistant_card/provider_core/bean/CardAction;", "handleCardActionClick", "action", "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RemoteCardContainer extends RelativeLayout implements com.obric.assistant.remote_card_container.manager.c.a {
    public static final /* synthetic */ int h = 0;
    public final CoroutineScope a;
    public com.obric.assistant.remote_card_container.widget.a b;
    public String c;
    public final Lazy d;
    public Job e;
    public int f;
    public View.OnLongClickListener g;

    public static final class a {
    }

    static {
    }

    private final Path getRoundAnglePath() {
        return (Path) this.d.getValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Set<com.obric.assistant.remote_card_container.manager.c.a> r0 = com.obric.assistant.remote_card_container.manager.c.a;
        Intrinsics.checkNotNullParameter(this, "listener");
        com.obric.assistant.remote_card_container.manager.c.a.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Set<com.obric.assistant.remote_card_container.manager.c.a> r0 = com.obric.assistant.remote_card_container.manager.c.a;
        Intrinsics.checkNotNullParameter(this, "listener");
        com.obric.assistant.remote_card_container.manager.c.a.remove(this);
    }

    public RemoteCardContainer(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    @Override // com.obric.assistant.remote_card_container.manager.c.a
    public final void a(String r8) {
        Intrinsics.checkNotNullParameter(r8, "cardUri");
        BuildersKt.launch$default(this.a, null, null, new RemoteCardContainer$onCardStateChanged$1(r8, this, null), 3, null);
    }

    public final void b(com.obric.assistant.remote_card_container.widget.a r3) {
        Intrinsics.checkNotNullParameter(r3, "cardData");
        p9a.e r0 = p9a.b.a;
        p9a.b.a("RemoteCardContainer", "bindCardData: cardUri = " + r3.a + ", messageId = " + r3.b + ", height = " + r3.d + ", extraParams = " + r3.c);
        this.b = r3;
        d(r3, true);
    }

    @Override // android.view.View
    public final void draw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        if (this.f <= 0) goto L5;
        r2.save();
        r2.clipPath(getRoundAnglePath());
        super.draw(r2);
        r2.restore();
        return;
    L5:
        super.draw(r2);
    }

    public final void setDefaultRoundAngle(int r1) {
        this.f = r1;
        if (r1 > 0) goto L5;
        boolean r2 = true;
    L6:
        setWillNotDraw(r2);
        return;
    L5:
        r2 = false;
        goto L6
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener r1) {
        this.g = r1;
        super.setOnLongClickListener(r1);
    }

    public RemoteCardContainer(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public final void d(com.obric.assistant.remote_card_container.widget.a r10, boolean r11) {
        if (r10 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L11;
        p9a.e r12 = p9a.b.a;
        p9a.b.a("RemoteCardContainer", "loadRemoteCard: card data is not valid " + r10);
        return;
    L11:
        Job r2 = this.e;
        if (r2 == null) goto L14;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L14:
        CoroutineScope r3 = this.a;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L17;
        CoroutineStart r0 = CoroutineStart.UNDISPATCHED;
    L18:
        this.e = BuildersKt.launch$default(r3, null, r0, new RemoteCardContainer$loadRemoteCard$1(r10, this, r11, null), 1, null);
        return;
    L17:
        r0 = CoroutineStart.DEFAULT;
        goto L18
    L5:
        if ((o0.d(r10.a) & o0.d(r10.b)) != true) goto L7;
        r1 = true;
        goto L8
    }

    public RemoteCardContainer(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4, 0);
        this.a = CoroutineScopeKt.MainScope();
        this.d = LazyKt.lazy(new d());
        setMinimumHeight(1);
    }

    public static void c(Context r7, String r8, CardAction r9) {
        p9a.e r0 = p9a.b.a;
        p9a.b.a("RemoteCardContainer", "handleCardActionClick: cardUri = " + r8 + ", action = " + r9);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new RemoteCardContainer$handleCardActionClick$1(r7, r8, r9, null), 3, null);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r8, final int r9, int r10, int r11) {
        super.onSizeChanged(r8, r9, r10, r11);
        if (r9 > 0) goto L5;
    L13:
        getRoundAnglePath().reset();
        int r12 = this.f;
        if (r12 <= 0) goto L18;
        float r13 = r12;
        getRoundAnglePath().addRoundRect(0.0f, 0.0f, r8, r9, new float[]{r13, r13, r13, r13, r13, r13, r13, r13}, Path.Direction.CW);
        return;
    L18:
        return;
    L5:
        if (getLayoutParams().height != (-2)) goto L13;
        p9a.e r14 = p9a.b.a;
        p9a.b.a("RemoteCardContainer", "onSizeChanged: displayedCardUri = " + this.c + ", height is " + r9);
        m r15 = m.a;
        String r0 = this.c;
        if (r0 != null) goto L10;
        r0 = "";
    L10:
        if (r15.a(r0) == null) goto L12;
        r15.b(this.c, new b(r9));
        goto L13
    L12:
        FLogger.a.i("RemoteCardContainer", "card info not found, create new one");
        final String r16 = this.c;
        final com.obric.assistant.remote_card_container.widget.a r17 = this.b;
        CardCacheManager r1 = CardCacheManager.a;
        CardCacheManager.b(new c(r16, r17, r9));
        goto L13
    }
}
