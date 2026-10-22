package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.carnival.ui;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.i2;
import com.bytedance.android.livesdk.interactivity.api.barrage.data.j;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.test.CarnivalAutoTestUtil;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001bB'\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000e¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u0007J\u0006\u0010\u000f\u001a\u00020\u000eR\u0014\u0010\u0013\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/carnival/ui/ChatCarnivalView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/interactivity/api/barrage/model/a;", "msg", BuildConfig.FLAVOR, "setCurrentMsg", "getCurrentMsg", "Landroid/widget/ImageView;", "getChatCarnivalImgTitle", "getChatCarnivalBg", "getChatCarnivalBgBlack", "Landroid/widget/TextView;", "getChatCarnivalContent", "getCarnivalBtn", BuildConfig.FLAVOR, "getCurrentBgColor", BuildConfig.FLAVOR, "getTimeLeft", "()J", "timeLeft", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChatCarnivalView extends FrameLayout {
    public com.bytedance.android.livesdk.interactivity.api.barrage.model.a a;
    public int b;
    public boolean c;
    public com.bytedance.android.livesdk.interactivity.api.publicscreen.b d;
    public final CompositeDisposable e;
    public final ImageView f;
    public final ImageView g;
    public final HSImageView h;
    public final ImageView i;
    public final TextView j;
    public final TextView k;
    public final HSImageView l;
    public final ImageView m;
    public DraweeController n;
    public DraweeController o;
    public final SimpleDateFormat p;
    public final String q;
    public final String r;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ HSImageView a;
        public final /* synthetic */ ChatCarnivalView b;

        public b(HSImageView r1, ChatCarnivalView r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            ChatCarnivalView r0 = this.b;
            PipelineDraweeControllerBuilder r1 = Fresco.newDraweeControllerBuilder();
            r0.o = r1.setUri((Uri) r3).setAutoPlayAnimations(true).build();
            this.a.setController(this.b.o);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ Ref.LongRef a;
        public final /* synthetic */ ChatCarnivalView b;

        public c(Ref.LongRef r1, ChatCarnivalView r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            Long r6 = (Long) r5;
            long r0 = this.a.element;
            if (r0 <= 0) goto L6;
            String r7 = this.b.p.format(Long.valueOf(r0));
            TextView r1 = this.b.k;
            StringCompanionObject r2 = StringCompanionObject.INSTANCE;
            r1.setText(String.format("%1s", Arrays.copyOf(new Object[]{r7}, 1)));
            this.a.element -= 1000;
            return;
        }
    }

    static {
    }

    public ChatCarnivalView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ChatCarnivalView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final long getTimeLeft() {
        com.bytedance.android.livesdk.interactivity.api.barrage.model.a r0 = this.a;
        if (r0 == null) goto L5;
        long r1 = r0.n();
    L7:
        return ((r1 / 1000) + 1) * 1000;
    L5:
        r1 = 0;
        goto L7
    }

    public final ImageView getCarnivalBtn() {
        return this.m;
    }

    public final ImageView getChatCarnivalBg() {
        return this.f;
    }

    public final ImageView getChatCarnivalBgBlack() {
        return this.g;
    }

    public final TextView getChatCarnivalContent() {
        return this.j;
    }

    public final ImageView getChatCarnivalImgTitle() {
        return this.i;
    }

    public final int getCurrentBgColor() {
        return this.b;
    }

    public final com.bytedance.android.livesdk.interactivity.api.barrage.model.a getCurrentMsg() {
        return this.a;
    }

    public final void a(boolean r8) {
        com.bytedance.android.livesdk.interactivity.api.barrage.model.a r0 = this.a;
        if ((r0 instanceof j) == true) goto L5;
        r0 = null;
    L5:
        j r1 = (j) r0;
        if (r1 == null) goto L27;
        UtilityKotlinExtentionsKt.t(this.l);
        UtilityKotlinExtentionsKt.t(this.m);
        UtilityKotlinExtentionsKt.w(this.i);
        UtilityKotlinExtentionsKt.w(this.k);
        if (r8 == false) goto L16;
        HSImageView r9 = this.h;
        this.e.add(Observable.create(new oa2.b(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(r9, this)));
        if (r1.A() != 1) goto L12;
        int r4 = 0;
    L13:
        r9.setVisibility(r4);
        k r10 = r1.D();
        if (r10 == null) goto L16;
        ImageUtil.loadImage(this.i, r10, 0);
        goto L16
    L12:
        r4 = 8;
    L16:
        String r11 = r1.r();
        if (r11 == null) goto L25;
        TextView r2 = this.j;
        r2.setText(r11);
        r2.setPadding(0, 0, 0, 0);
        if (v.a() == false) goto L25;
        if (CarnivalAutoTestUtil.a == false) goto L25;
        if (CarnivalAutoTestUtil.a() == null) goto L25;
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
    L25:
        Ref.LongRef r13 = new Ref.LongRef();
        long r3 = getTimeLeft();
        r13.element = r3;
        String.valueOf(r3);
        Disposable r14 = Observable.interval(0, 1, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(r13, this));
        this.e.add(r14);
        return;
    }

    public final void setCurrentMsg(com.bytedance.android.livesdk.interactivity.api.barrage.model.a r1) {
        this.a = r1;
    }

    public ChatCarnivalView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = ColorProtector.parseColor("#FF308A");
        this.c = true;
        this.e = new CompositeDisposable();
        this.p = new SimpleDateFormat("mm:ss", Locale.CHINA);
        LayoutInflater.from(r2).inflate(2131567630, this);
        this.f = (ImageView) findViewById(2131365512);
        this.g = (ImageView) findViewById(2131365513);
        this.h = findViewById(2131365520);
        this.i = (ImageView) findViewById(2131365517);
        this.j = (TextView) findViewById(2131365519);
        this.k = (TextView) findViewById(2131365236);
        this.l = findViewById(2131365518);
        this.m = (ImageView) findViewById(2131365516);
        this.q = i2.b("/comment/ttlive_red_ball_chat_carnival.webp");
        this.r = i2.b("/comment/ttlive_loading_chat_carnival.webp");
    }

    public /* synthetic */ ChatCarnivalView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
