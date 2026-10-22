package com.larksuite.component.card.component.personlist.avatar;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.card.component.personlist.PersonInfo;
import com.larksuite.component.card.component.personlist.g;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.utils.CollectionUtils;
import com.lynx.tasm.base.TraceEvent;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.y0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 :2\u00020\u0001:\u0004:;<=B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0014J\u0012\u0010&\u001a\u00020#2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020\nH\u0002J\u000e\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020+J\u0016\u0010.\u001a\u00020#2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020100H\u0002J:\u00102\u001a\u00020#2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u0001062\u0006\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\r8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00138FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00198FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u00060!R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/larksuite/component/card/component/personlist/avatar/PersonAvatarGroupView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ivPersonAvatarGroupLastAvatarFromXml", "Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;", "getIvPersonAvatarGroupLastAvatarFromXml", "()Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;", "setIvPersonAvatarGroupLastAvatarFromXml", "(Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView2;)V", "tvPersonAvatarGroupMoreNumberFromXml", "Landroid/widget/TextView;", "getTvPersonAvatarGroupMoreNumberFromXml", "()Landroid/widget/TextView;", "setTvPersonAvatarGroupMoreNumberFromXml", "(Landroid/widget/TextView;)V", "rvPersonAvatarGroupFromXml", "Lcom/larksuite/component/card/component/personlist/avatar/NonScrollableRecyclerView;", "getRvPersonAvatarGroupFromXml", "()Lcom/larksuite/component/card/component/personlist/avatar/NonScrollableRecyclerView;", "setRvPersonAvatarGroupFromXml", "(Lcom/larksuite/component/card/component/personlist/avatar/NonScrollableRecyclerView;)V", "avatarSize", "avatarGap", "avatarGroupAdapter", "Lcom/larksuite/component/card/component/personlist/avatar/PersonAvatarGroupView$AvatarGroupAdapter;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "initViews", "adjustSize", "moreTextSize", "setData", "personAvatarInfo", "Lcom/larksuite/component/card/component/personlist/avatar/PersonAvatarGroupShadowNode$PersonAvatarExtraData;", "checker", "Lcom/ss/android/lark/widget/listener/DuplicateEnterChecker;", "showRecyclerView", "personList", "", "Lcom/larksuite/component/card/component/personlist/PersonInfo;", "loadAvatar", "imageView", "Landroid/widget/ImageView;", "avatarKey", "", "entityId", "widthInPx", "heightInPx", "Companion", "ClickMoreListener", "AvatarGroupAdapter", "AvatarItemViewHolder", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class PersonAvatarGroupView extends LinearLayout {
    public LKUIRoundedImageView2 a;
    public TextView b;
    public NonScrollableRecyclerView c;
    public int d;
    public int e;
    public final AvatarGroupAdapter f;
    public final rcc.a g;

    public final class AvatarGroupAdapter extends RecyclerView.Adapter<AvatarItemViewHolder> {
        public final AsyncListDiffer<PersonInfo> a;
        public final /* synthetic */ PersonAvatarGroupView b;

        public final int getItemCount() {
            return this.a.getCurrentList().size();
        }

        public AvatarGroupAdapter(PersonAvatarGroupView r2) {
            this.b = r2;
            this.a = new AsyncListDiffer(this, new PersonAvatarGroupView$AvatarGroupAdapter$mDiffer$1());
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [android.widget.ImageView, com.larksuite.component.card.component.personlist.avatar.PersonAvatarImageView] */
        public final void onBindViewHolder(RecyclerView.ViewHolder r8, int r9) {
            AvatarItemViewHolder r10 = (AvatarItemViewHolder) r8;
            Intrinsics.checkNotNullParameter(r10, "holder");
            PersonInfo r11 = (PersonInfo) ListProtector.get(this.a.getCurrentList(), r9);
            Object r0 = ((RecyclerView.ViewHolder) r10).itemView;
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.larksuite.component.card.component.personlist.avatar.PersonAvatarImageView");
            ?? r1 = (PersonAvatarImageView) r0;
            PersonAvatarGroupView r2 = this.b;
            int r3 = r2.d;
            int r4 = r2.e;
            PersonAvatarImageView.a r5 = r1.b;
            if (r5 == null) goto L5;
            ((egc.a) r5).a = r3;
            ((egc.a) r5).b = r3;
        L5:
            ViewGroup.LayoutParams r6 = r1.getLayoutParams();
            if (r6 == null) goto L8;
            r6.width = r3 - r4;
            r6.height = r3;
        L9:
            Context r7 = this.b.getContext();
            View r12 = ((RecyclerView.ViewHolder) r10).itemView;
            Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type android.widget.ImageView");
            ImageView r13 = (ImageView) r12;
            String r14 = r11.getAvatarKey();
            String r15 = r11.getId();
            int r16 = this.b.d;
            PersonAvatarGroupView.b(r7, r13, r14, r15, r16, r16);
            return;
        L8:
            r1.setLayoutParams(new ViewGroup.LayoutParams(r3 - r4, r3));
            goto L9
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            Object r5 = LayoutInflater.from(r3.getContext()).inflate(2131559247, r3, false);
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.larksuite.component.card.component.personlist.avatar.PersonAvatarImageView");
            return new AvatarItemViewHolder((PersonAvatarImageView) r5);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/larksuite/component/card/component/personlist/avatar/PersonAvatarGroupView$AvatarItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "rootView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class AvatarItemViewHolder extends RecyclerView.ViewHolder {
        /* JADX WARN: Multi-variable type inference failed */
        public AvatarItemViewHolder(PersonAvatarImageView r2) {
            Intrinsics.checkNotNullParameter(r2, "rootView");
            super(r2);
        }
    }

    public static final class a implements View.OnClickListener {
        public final Context a;
        public final rcc.a b;
        public final List<PersonInfo> c;

        public final Context getContext() {
            return this.a;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            Intrinsics.checkNotNullParameter(r3, "v");
            if (this.b.a() == false) goto L6;
            Log.e("PersonAvatarGroupView", "more check isDuplicate: " + this.c.hashCode());
            return;
        L6:
            g r4 = g.a;
            FragmentActivity r0 = this.a;
            List<PersonInfo> r1 = this.c;
            r4.getClass();
            Intrinsics.checkNotNullParameter(r0, "context");
            Intrinsics.checkNotNullParameter(r1, "persons");
            if ((r0 instanceof FragmentActivity) == true) goto L14;
            r0 = AppLifecycle.a.a.f();
            if ((r0 instanceof FragmentActivity) == true) goto L14;
            r0 = null;
        L14:
            if (r0 == null) goto L17;
            int r5 = wy7.b.a;
            wy7.b.b((Activity) r0, r1);
            return;
        }

        public a(Context r2, rcc.a r3, List<PersonInfo> r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "checker");
            Intrinsics.checkNotNullParameter(r4, "persons");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class b {
    }

    static {
    }

    public final void a() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(2131559246, this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-2, this.d));
    }

    public final LKUIRoundedImageView2 getIvPersonAvatarGroupLastAvatarFromXml() {
        AppCompatImageView r0 = this.a;
        if (r0 != null) goto L6;
        r0 = findViewById(2131376461);
        this.a = (LKUIRoundedImageView2) r0;
    L6:
        return (LKUIRoundedImageView2) r0;
    }

    public final NonScrollableRecyclerView getRvPersonAvatarGroupFromXml() {
        RecyclerView r0 = this.c;
        if (r0 != null) goto L6;
        r0 = findViewById(2131384985);
        this.c = (NonScrollableRecyclerView) r0;
    L6:
        return (NonScrollableRecyclerView) r0;
    }

    public final TextView getTvPersonAvatarGroupMoreNumberFromXml() {
        KeyEvent.Callback r0 = this.b;
        if (r0 != null) goto L6;
        r0 = findViewById(2131391109);
        this.b = (TextView) r0;
    L6:
        return (TextView) r0;
    }

    public PersonAvatarGroupView(Context r2) {
        super(r2);
        g.a.getClass();
        this.d = g.d(null);
        this.e = g.a(null);
        this.f = new AvatarGroupAdapter(this);
        this.g = new rcc.a();
        a();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        TraceEvent.beginSection("PersonAvatarGroupView.onDraw");
        super.onDraw(r2);
        TraceEvent.endSection("PersonAvatarGroupView.onDraw");
    }

    public final void setData(PersonAvatarGroupShadowNode.b r13) {
        Intrinsics.checkNotNullParameter(r13, "personAvatarInfo");
        this.d = r13.a;
        this.e = r13.b;
        int r0 = r13.g;
        ViewGroup.LayoutParams r1 = getLayoutParams();
        int r2 = this.d;
        r1.height = r2;
        if (r2 <= 0) goto L6;
        ViewGroup.LayoutParams r3 = getIvPersonAvatarGroupLastAvatarFromXml().getLayoutParams();
        int r4 = this.d;
        r3.width = r4;
        r3.height = r4;
        ViewGroup.LayoutParams r5 = getTvPersonAvatarGroupMoreNumberFromXml().getLayoutParams();
        int r6 = this.d;
        r5.width = r6;
        r5.height = r6;
        getTvPersonAvatarGroupMoreNumberFromXml().setTextSize(0, a08.b.a(r0, getContext()));
        getRvPersonAvatarGroupFromXml().getLayoutParams().height = this.d;
    L6:
        ArrayList r7 = new ArrayList(r13.c);
        int r8 = r13.c.size();
        Log.i("PersonAvatarGroupView", "setData total = " + r13.c.size() + "  avatarSize:" + this.d);
        setOnClickListener(new a(getContext(), this.g, r7));
        int r9 = r13.d;
        if (r9 <= 5) goto L10;
        r9 = 5;
    L10:
        if (r13.e == false) goto L15;
        int r10 = r8 - r9;
        int r11 = r13.h;
        if (r10 <= r11) goto L14;
        r10 = r11;
    L14:
        getTvPersonAvatarGroupMoreNumberFromXml().setText("+" + r10);
        Drawable r12 = getTvPersonAvatarGroupMoreNumberFromXml().getBackground();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ((GradientDrawable) r12).setColor(r13.f);
        getTvPersonAvatarGroupMoreNumberFromXml().setVisibility(0);
        getIvPersonAvatarGroupLastAvatarFromXml().setVisibility(8);
    L16:
        LinearLayoutManager r14 = new LinearLayoutManager(getContext());
        r14.setOrientation(0);
        getRvPersonAvatarGroupFromXml().setLayoutManager(r14);
        List r15 = r7;
        if (r9 <= 0) goto L22;
        int r16 = r7.size();
        r15 = r7;
        if (r9 >= r16) goto L22;
        r15 = r7.subList(0, r9);
    L22:
        if (CollectionUtils.isEmpty(r15) == false) goto L24;
        getRvPersonAvatarGroupFromXml().setVisibility(8);
        return;
    L24:
        List r17 = r15;
        if (getIvPersonAvatarGroupLastAvatarFromXml().getVisibility() != 0) goto L33;
        PersonInfo r19 = (PersonInfo) ListProtector.get(r15, r15.size() - 1);
        if (r19 == null) goto L30;
        Context r20 = getContext();
        AppCompatImageView r21 = getIvPersonAvatarGroupLastAvatarFromXml();
        String r22 = r19.getAvatarKey();
        String r23 = r19.getId();
        int r110 = this.d;
        b(r20, r21, r22, r23, r110, r110);
    L30:
        if (r15.size() <= 1) goto L32;
        List r24 = r15.subList(0, r15.size() - 1);
        getRvPersonAvatarGroupFromXml().setVisibility(0);
        r17 = r24;
        goto L33
    L32:
        getRvPersonAvatarGroupFromXml().setVisibility(8);
        return;
    L33:
        getRvPersonAvatarGroupFromXml().setAdapter(this.f);
        AvatarGroupAdapter r111 = this.f;
        r111.getClass();
        ArrayList r25 = new ArrayList();
        if (r17 == null) goto L54;
        Iterator r26 = r17.iterator();
    L37:
        if (r26.hasNext() == false) goto L54;
        PersonInfo r27 = (PersonInfo) r26.next();
        if (TextUtils.isEmpty(r27.getAvatarKey()) == false) goto L37;
        if (TextUtils.isEmpty(r27.getId()) == true) goto L37;
        String r29 = r27.getId();
        if (r29 == null) goto L37;
        Lazy<SimpleUserLoader> r30 = SimpleUserLoader.d;
        SimpleUserLoader r31 = SimpleUserLoader.a.a();
        r31.getClass();
        Intrinsics.checkNotNullParameter(r29, "userId");
        wy7.c r32 = (wy7.c) ((LinkedHashMap) r31.a).get(r29);
        if (r32 == null) goto L52;
        if ((!TextUtils.isEmpty(r32.a)) == true) goto L50;
        r32 = null;
    L50:
        if (r32 == null) goto L52;
        r27.setAvatarKey(r32.a);
    L52:
        r25.add(r29);
    L54:
        if ((true ^ r25.isEmpty()) == false) goto L56;
        Lazy<SimpleUserLoader> r33 = SimpleUserLoader.d;
        SimpleUserLoader.a.a().b(r25, new e(r111));
    L56:
        r111.a.submitList(r17);
        return;
    L15:
        getTvPersonAvatarGroupMoreNumberFromXml().setVisibility(8);
        getIvPersonAvatarGroupLastAvatarFromXml().setVisibility(0);
        goto L16
    }

    public final void setIvPersonAvatarGroupLastAvatarFromXml(LKUIRoundedImageView2 r1) {
        this.a = r1;
    }

    public final void setRvPersonAvatarGroupFromXml(NonScrollableRecyclerView r1) {
        this.c = r1;
    }

    public final void setTvPersonAvatarGroupMoreNumberFromXml(TextView r1) {
        this.b = r1;
    }

    public PersonAvatarGroupView(Context r1, AttributeSet r2) {
        super(r1, r2);
        g.a.getClass();
        this.d = g.d(null);
        this.e = g.a(null);
        this.f = new AvatarGroupAdapter(this);
        this.g = new rcc.a();
        a();
    }

    public PersonAvatarGroupView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        g.a.getClass();
        this.d = g.d(null);
        this.e = g.a(null);
        this.f = new AvatarGroupAdapter(this);
        this.g = new rcc.a();
        a();
    }

    public static void b(Context r2, ImageView r3, String r4, String r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "imageView");
        if (y0.d(r4) == false) goto L6;
        Log.e("PersonAvatarGroupView", "avatarKey is empty");
        r3.setImageDrawable(AppCompatResources.getDrawable(r2, 2131232484));
        return;
    L6:
        AvatarImage r8 = AvatarImage.Builder.obtain(r4, r5, r6, r7).build();
        ImageLoader.with(r2).load(r8).placeholder(2131232484).override(r6, r7).into(r3);
    }
}
