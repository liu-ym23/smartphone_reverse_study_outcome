package com.larus.bmhome.model;

import android.R;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.model.api.DefaultReplyMenuItemTag;
import com.larus.bmhome.chat.model.api.DefaultReplySwitchMenuItem;
import com.larus.bmhome.chat.model.api.DefaultReplySwitchMenuMode;
import com.larus.bmhome.databinding.LarusItemModelSettingBinding;
import com.larus.bmhome.databinding.LarusItemModelSettingsTitleBinding;
import com.larus.common_ui.widget.TagTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005./012B?\u00126\u0010\u0003\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J\b\u0010\u001f\u001a\u00020\u001aH\u0016J*\u0010 \u001a\u00020\u000b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00100\"2\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00130$J\u001e\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020)J\u0010\u0010*\u001a\u00020+2\u0006\u0010\u001d\u001a\u00020\u001aH\u0002J!\u0010,\u001a\u0004\u0018\u00010\u001a2\u0006\u0010&\u001a\u00020\u00132\b\u0010'\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0002\u0010-R>\u0010\u0003\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/larus/bmhome/model/ModelSettingsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onModelClick", "Lkotlin/Function2;", "Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchMenuMode;", "Lkotlin/ParameterName;", "name", "mode", "Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchMenuItem;", "model", "", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "groups", "", "Lcom/larus/bmhome/model/ModelSettingsAdapter$Group;", "selectedKeys", "", "", "loadingKey", "Lkotlin/Pair;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemViewType", "getItemCount", "submitGroups", "newGroups", "", "initialSelectedKeys", "", "setLoading", "modeId", "modelKey", "loading", "", "findItem", "Lcom/larus/bmhome/model/ModelSettingsAdapter$Item;", "findPosition", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Integer;", "Companion", "Group", "Item", "TitleViewHolder", "ModelSettingViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ModelSettingsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final Function2<DefaultReplySwitchMenuMode, DefaultReplySwitchMenuItem, Unit> a;
    public final List<b> b;
    public final Map<String, String> c;
    public Pair<String, String> d;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/model/ModelSettingsAdapter$ModelSettingViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/bmhome/databinding/LarusItemModelSettingBinding;", "<init>", "(Lcom/larus/bmhome/model/ModelSettingsAdapter;Lcom/larus/bmhome/databinding/LarusItemModelSettingBinding;)V", "bind", "", "item", "Lcom/larus/bmhome/model/ModelSettingsAdapter$Item$Model;", "position", "", "itemBackground", "Landroid/graphics/drawable/StateListDrawable;", "index", "size", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ModelSettingViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int c = 0;
        public final LarusItemModelSettingBinding a;
        public final /* synthetic */ ModelSettingsAdapter b;

        public ModelSettingViewHolder(ModelSettingsAdapter r2, LarusItemModelSettingBinding r3) {
            Intrinsics.checkNotNullParameter(r3, "binding");
            this.b = r2;
            super(r3.a);
            this.a = r3;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/model/ModelSettingsAdapter$TitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/bmhome/databinding/LarusItemModelSettingsTitleBinding;", "<init>", "(Lcom/larus/bmhome/model/ModelSettingsAdapter;Lcom/larus/bmhome/databinding/LarusItemModelSettingsTitleBinding;)V", "bind", "", "group", "Lcom/larus/bmhome/model/ModelSettingsAdapter$Group;", "position", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class TitleViewHolder extends RecyclerView.ViewHolder {
        public final LarusItemModelSettingsTitleBinding a;

        public TitleViewHolder(LarusItemModelSettingsTitleBinding r2) {
            Intrinsics.checkNotNullParameter(r2, "binding");
            super(r2.a);
            this.a = r2;
        }
    }

    public static final class a {
    }

    public static final class b {
        public final DefaultReplySwitchMenuMode a;
        public final List<DefaultReplySwitchMenuItem> b;
        public final boolean c;

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
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "Group(mode=" + this.a + ", models=" + this.b + ", showTitle=" + this.c + ')';
        }

        public b(DefaultReplySwitchMenuMode r2, List<DefaultReplySwitchMenuItem> r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "mode");
            Intrinsics.checkNotNullParameter(r3, "models");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public interface c {

        public static final class a implements c {
            public final b a;
            public final DefaultReplySwitchMenuItem b;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof a) == true) goto L8;
                return false;
            L8:
                a r6 = (a) r5;
                if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.a.hashCode() * 31) + this.b.hashCode();
            }

            public final String toString() {
                return "Model(group=" + this.a + ", model=" + this.b + ')';
            }

            public a(b r2, DefaultReplySwitchMenuItem r3) {
                Intrinsics.checkNotNullParameter(r2, "group");
                Intrinsics.checkNotNullParameter(r3, "model");
                this.a = r2;
                this.b = r3;
            }
        }

        public static final class b implements c {
            public final b a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Title(group=" + this.a + ')';
            }

            public b(b r2) {
                Intrinsics.checkNotNullParameter(r2, "group");
                this.a = r2;
            }
        }
    }

    static {
    }

    public final int getItemCount() {
        Iterator<T> r0 = this.b.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L6;
        b r2 = (b) r0.next();
        r1 = r1 + (r2.b.size() + (r2.c ? 1 : 0));
        goto L4
    L6:
        return r1;
    }

    public ModelSettingsAdapter(Function2<? super DefaultReplySwitchMenuMode, ? super DefaultReplySwitchMenuItem, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "onModelClick");
        this.a = r2;
        this.b = new ArrayList();
        this.c = new LinkedHashMap();
    }

    public final int getItemViewType(int r1) {
        return !(y2(r1) instanceof c.b) ? 1 : 0;
    }

    public final c y2(int r5) {
        Iterator<T> r0 = this.b.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L15;
        b r2 = (b) r0.next();
        int r3 = r1 + (r2.c ? 1 : 0);
        if (r5 < r3) goto L8;
        if (r5 < (r2.b.size() + r3)) goto L12;
        r1 = r3 + r2.b.size();
        goto L4
    L12:
        return new c.a(r2, (DefaultReplySwitchMenuItem) ListProtector.get(r2.b, r5 - r3));
    L8:
        return new c.b(r2);
    L15:
        throw new IllegalStateException(("Invalid model settings adapter position: " + r5).toString());
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r18, int r19) {
        Intrinsics.checkNotNullParameter(r18, "holder");
        String r4 = "";
        if ((r18 instanceof TitleViewHolder) == false) goto L14;
        TitleViewHolder r1 = (TitleViewHolder) r18;
        c r3 = y2(r19);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.larus.bmhome.model.ModelSettingsAdapter.Item.Title");
        b r5 = ((c.b) r3).a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "group");
        TextView r6 = r1.a.b;
        String r7 = r5.a.getName();
        if (r7 == null) goto L8;
        r4 = r7;
    L8:
        r6.setText(r4);
        TextView r2 = r1.a.a;
        ViewGroup.LayoutParams r8 = r2.getLayoutParams();
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r8;
        if (r19 != 0) goto L11;
        int r10 = i5.r0();
    L12:
        r9.topMargin = r10;
        r9.bottomMargin = i5.r0();
        r2.setLayoutParams(r8);
        return;
    L11:
        r10 = i5.E();
        goto L12
    L14:
        if ((r18 instanceof ModelSettingViewHolder) == false) goto L84;
        ModelSettingViewHolder r11 = (ModelSettingViewHolder) r18;
        c r12 = y2(r19);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.larus.bmhome.model.ModelSettingsAdapter.Item.Model");
        c.a r13 = (c.a) r12;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r13, "item");
        final b r14 = r13.a;
        final DefaultReplySwitchMenuItem r15 = r13.b;
        String r16 = r14.a.getModeId();
        if (r16 != null) goto L18;
        r16 = "";
    L18:
        String r17 = r15.getModelItemKey();
        if (r17 != null) goto L21;
        r17 = "";
    L21:
        final boolean r20 = Intrinsics.areEqual(r11.b.d, TuplesKt.to(r16, r17));
        boolean r21 = Intrinsics.areEqual(((LinkedHashMap) r11.b.c).get(r16), r17);
        r11.a.a.setVisibility(0);
        ConstraintLayout r22 = r11.a.a;
        ViewGroup.LayoutParams r110 = r22.getLayoutParams();
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r23 = (ViewGroup.MarginLayoutParams) r110;
        if (r19 != 0) goto L24;
        int r24 = i5.r0();
    L25:
        r23.topMargin = r24;
        r22.setLayoutParams(r110);
        ConstraintLayout r25 = r11.a.d;
        int r26 = r14.b.indexOf(r15);
        int r27 = r14.b.size();
        Context r111 = r11.a.a.getContext();
        float r112 = i5.q();
        if (r26 != 0) goto L28;
        float r113 = r112;
    L30:
        if (r26 == (r27 - 1)) goto L33;
        r112 = 0.0f;
    L33:
        float[] r28 = {r113, r113, r113, r113, r112, r112, r112, r112};
        Intrinsics.checkNotNull(r111);
        int r114 = v19.c.a(2130970532, r111, 2131102539);
        int r29 = v19.c.a(2130972118, r111, 2131103188);
        StateListDrawable r115 = new StateListDrawable();
        int[] r116 = {R.attr.state_pressed};
        GradientDrawable r117 = new GradientDrawable();
        r117.setColor(r29);
        r117.setCornerRadii(r28);
        Unit r30 = Unit.INSTANCE;
        r115.addState(r116, r117);
        GradientDrawable r118 = new GradientDrawable();
        r118.setColor(r114);
        r118.setCornerRadii(r28);
        r115.addState(new int[0], r118);
        r25.setBackground(r115);
        TextView r31 = r11.a.f;
        String r32 = r15.getName();
        if (r32 == null) goto L37;
        r4 = r32;
    L37:
        r31.setText(r4);
        ImageView r33 = r11.a.b;
        if (r21 == false) goto L41;
        if (r20 == true) goto L41;
        boolean r34 = true;
    L42:
        if (r34 == false) goto L44;
        int r35 = 0;
    L45:
        r33.setVisibility(r35);
        ProgressBar r36 = r11.a.e;
        if (r20 == false) goto L48;
        int r37 = 0;
    L49:
        r36.setVisibility(r37);
        int r38 = r14.b.indexOf(r15);
        View r39 = r11.a.c;
        if (r38 >= CollectionsKt.getLastIndex(r14.b)) goto L52;
        boolean r40 = true;
    L53:
        if (r40 == false) goto L55;
        int r41 = 0;
    L56:
        r39.setVisibility(r41);
        r11.a.g.removeAllViews();
        List r42 = r15.getTagList();
        if (r42 != null) goto L59;
        r42 = CollectionsKt.emptyList();
    L59:
        ArrayList r43 = new ArrayList();
        Iterator r44 = r42.iterator();
    L60:
        String r45 = null;
        if (r44.hasNext() == false) goto L71;
        DefaultReplyMenuItemTag r46 = (DefaultReplyMenuItemTag) r44.next();
        if (r46 == null) goto L69;
        String r47 = r46.getText();
        if (r47 == null) goto L69;
        if ((!StringsKt.isBlank(r47)) == false) goto L69;
        r45 = r47;
    L69:
        if (r45 == null) goto L60;
        r43.add(r45);
        goto L60
    L71:
        Iterator r48 = r43.iterator();
    L73:
        if (r48.hasNext() == false) goto L75;
        String r49 = (String) r48.next();
        LinearLayout r50 = r11.a.g;
        TagTextView r51 = new TagTextView(r11.a.a.getContext(), null, 6, 0);
        r51.x(r49, TagTextView.TagStyle.BLUE);
        r51.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r50.addView(r51);
        goto L73
    L75:
        ConstraintLayout r52 = r11.a.a;
        final ModelSettingsAdapter r53 = r11.b;
        r52.setOnClickListener(new com.larus.bmhome.model.b(r20, r53, r14, r15));
        return;
    L55:
        r41 = 8;
        goto L56
    L52:
        r40 = false;
        goto L53
    L48:
        r37 = 8;
        goto L49
    L44:
        r35 = 8;
    L41:
        r34 = false;
        goto L42
    L28:
        r113 = 0.0f;
        goto L30
    L24:
        r24 = 0;
        goto L25
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, "parent");
        if (r12 != 0) goto L9;
        View r13 = LayoutInflater.from(r11.getContext()).inflate(2131562591, r11, false);
        if (r13 == null) goto L8;
        TextView r14 = (TextView) r13;
        RecyclerView.ViewHolder r15 = new TitleViewHolder(new LarusItemModelSettingsTitleBinding(r14, r14));
    L22:
        return r15;
    L8:
        throw new NullPointerException("rootView");
    L9:
        ConstraintLayout r16 = LayoutInflater.from(r11.getContext()).inflate(2131562590, r11, false);
        int r0 = 2131365639;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r16, 2131365639);
        if (r4 == null) goto L24;
        r0 = 2131367833;
        if (((LinearLayout) ViewBindings.findChildViewById(r16, 2131367833)) == null) goto L24;
        r0 = 2131369252;
        View r5 = ViewBindings.findChildViewById(r16, 2131369252);
        if (r5 == null) goto L24;
        ConstraintLayout r6 = r16;
        r0 = 2131379091;
        ProgressBar r7 = (ProgressBar) ViewBindings.findChildViewById(r16, 2131379091);
        if (r7 == null) goto L24;
        r0 = 2131380613;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r16, 2131380613);
        if (r8 == null) goto L24;
        r0 = 2131388106;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r16, 2131388106);
        if (r9 == null) goto L24;
        r15 = new ModelSettingViewHolder(this, new LarusItemModelSettingBinding(r6, r4, r5, r6, r7, r8, r9));
    L24:
        throw new NullPointerException("Missing required view with ID: ".concat(r16.getResources().getResourceName(r0)));
    }

    public final void z2(String r7, String r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r7, "modeId");
        Intrinsics.checkNotNullParameter(r8, "modelKey");
        Integer r0 = null;
        if (r9 == false) goto L5;
        Pair<String, String> r10 = TuplesKt.to(r7, r8);
    L6:
        this.d = r10;
        int r11 = 0;
        if (r8 != null) goto L9;
    L12:
        boolean r1 = true;
    L13:
        if (r1 == true) goto L30;
        Iterator r2 = ((ArrayList) this.b).iterator();
    L17:
        if (r2.hasNext() == false) goto L30;
        b r3 = (b) r2.next();
        if (r3.c == false) goto L21;
        r11 = r11 + 1;
    L21:
        Iterator<T> r4 = r3.b.iterator();
    L23:
        if (r4.hasNext() == false) goto L17;
        DefaultReplySwitchMenuItem r5 = (DefaultReplySwitchMenuItem) r4.next();
        if (Intrinsics.areEqual(r3.a.getModeId(), r7) == false) goto L29;
        if (Intrinsics.areEqual(r5.getModelItemKey(), r8) == false) goto L29;
        r0 = Integer.valueOf(r11);
    L29:
        r11 = r11 + 1;
    L30:
        if (r0 == null) goto L38;
        notifyItemChanged(r0.intValue());
        return;
    L38:
        return;
    L9:
        if (StringsKt.isBlank(r8) == true) goto L12;
        r1 = false;
        goto L13
    L5:
        r10 = null;
        goto L6
    }
}
