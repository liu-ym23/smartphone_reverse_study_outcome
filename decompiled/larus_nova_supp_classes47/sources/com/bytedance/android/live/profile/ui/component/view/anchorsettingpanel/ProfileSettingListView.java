package com.bytedance.android.live.profile.ui.component.view.anchorsettingpanel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\u000fH\u0002J\u0006\u0010\u001c\u001a\u00020\u000fJ\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u0007H\u0002J\u0012\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\u000e\u0010!\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000bJ)\u0010\"\u001a\u00020\u000f2!\u0010#\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000f0\nJ\u0012\u0010$\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002R+\u0010\t\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/view/anchorsettingpanel/ProfileSettingListView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "itemClickListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "tagInt", "", "items", "", "Lcom/bytedance/android/live/profile/ui/component/view/anchorsettingpanel/ProfileNewSettingItemView;", "root", "Landroid/widget/LinearLayout;", "createItem", "itemTag", "itemText", "", "isChecked", "", "init", "layout", "spaceWidth", "onClick", "view", "Landroid/view/View;", "setItemChecked", "setItemClickListener", "action", "setSpaceAdaptation", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProfileSettingListView extends FrameLayout {
    private Function1<? super Long, Unit> itemClickListener;
    private final Map<Long, ProfileNewSettingItemView> items;
    private LinearLayout root;

    public final class a implements View.OnClickListener {
        public final /* synthetic */ Function1 a;

        public a(Function1 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final /* synthetic */ void onClick(View r2) {
            this.a.invoke(r2);
        }
    }

    public ProfileSettingListView(Context r7) {
        this(r7, null, 0, 6, null);
    }

    public ProfileSettingListView(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    public final void layout() {
        int r0 = this.items.size();
        if (r0 != 2) goto L5;
        layout(UtilityKotlinExtentionsKt.i(60));
        return;
    L5:
        if (r0 != 3) goto L11;
        layout(UtilityKotlinExtentionsKt.i(40));
        return;
    }

    private final void init() {
        LayoutInflater.from(getContext()).inflate(2131567173, this, true);
        this.root = (LinearLayout) findViewById(2131384813);
    }

    private final void layout(int r7) {
        Iterator<Map.Entry<Long, ProfileNewSettingItemView>> r0 = this.items.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Map.Entry<Long, ProfileNewSettingItemView> r1 = r0.next();
        LinearLayout r3 = this.root;
        if (r3 == null) goto L8;
        r3.addView(new Space(getContext()), new LinearLayout.LayoutParams(r7, 1));
    L8:
        LinearLayout r2 = this.root;
        if (r2 == null) goto L4;
        r2.addView(r1.getValue());
        goto L4
    L11:
        LinearLayout r8 = this.root;
        if (r8 == null) goto L14;
        r8.addView(new Space(getContext()));
    L14:
        LinearLayout r9 = this.root;
        int r4 = 0;
        View r5 = null;
        if (r9 == null) goto L17;
        View r10 = r9.getChildAt(0);
    L18:
        setSpaceAdaptation(r10);
        LinearLayout r12 = this.root;
        if (r12 == null) goto L23;
        if (r12 == null) goto L22;
        r4 = r12.getChildCount();
    L22:
        r5 = r12.getChildAt(r4 - 1);
    L23:
        setSpaceAdaptation(r5);
        return;
    L17:
        r10 = null;
        goto L18
    }

    private final void onClick(View r7) {
        Object r1 = null;
        if ((r7 instanceof ProfileNewSettingItemView) == true) goto L5;
        r7 = null;
    L5:
        ProfileNewSettingItemView r8 = (ProfileNewSettingItemView) r7;
        if (r8 != null) goto L8;
        return;
    L8:
        Object r0 = r8.getTag();
        if ((r0 instanceof Long) == false) goto L12;
        r1 = r0;
    L12:
        Long r2 = (Long) r1;
        if (r2 == null) goto L32;
        long r3 = r2.longValue();
        if (r8.a == false) goto L17;
        return;
    L17:
        r8.setCheckState(true);
        Iterator<Map.Entry<Long, ProfileNewSettingItemView>> r9 = this.items.entrySet().iterator();
    L19:
        if (r9.hasNext() == false) goto L23;
        Map.Entry<Long, ProfileNewSettingItemView> r4 = r9.next();
        if (r4.getKey().longValue() == r3) goto L19;
        r4.getValue().setCheckState(false);
        goto L19
    L23:
        Function1<? super Long, Unit> r10 = this.itemClickListener;
        if (r10 == null) goto L33;
        Unit r12 = (Unit) r10.invoke(Long.valueOf(r3));
        return;
    L33:
        return;
    }

    private final void setSpaceAdaptation(View r4) {
        ViewGroup.LayoutParams r0 = null;
        if (r4 == null) goto L5;
        ViewGroup.LayoutParams r1 = r4.getLayoutParams();
    L7:
        if ((r1 instanceof LinearLayout.LayoutParams) == false) goto L10;
        r0 = r1;
    L10:
        LinearLayout.LayoutParams r2 = (LinearLayout.LayoutParams) r0;
        if (r2 != null) goto L13;
        return;
    L13:
        r2.width = 0;
        r2.weight = 1.0f;
        r4.setLayoutParams(r2);
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final void setItemChecked(long r6) {
        Iterator<Map.Entry<Long, ProfileNewSettingItemView>> r0 = this.items.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        Map.Entry<Long, ProfileNewSettingItemView> r1 = r0.next();
        ProfileNewSettingItemView r2 = r1.getValue();
        if (r1.getKey().longValue() != r6) goto L8;
        boolean r3 = true;
    L9:
        r2.setCheckState(r3);
        goto L4
    L8:
        r3 = false;
        goto L9
    }

    public final void setItemClickListener(Function1<? super Long, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        this.itemClickListener = r2;
    }

    public static final /* synthetic */ void access$onClick(ProfileSettingListView r0, View r1) {
        r0.onClick(r1);
    }

    public ProfileSettingListView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.items = new LinkedHashMap();
        init();
    }

    public final long createItem(long r6, String r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "itemText");
        ProfileNewSettingItemView r0 = new ProfileNewSettingItemView(getContext(), null, 6, 0);
        Intrinsics.checkNotNullParameter(r8, "text");
        TextView r1 = r0.d;
        if (r1 == null) goto L5;
        r1.setText(r8);
    L5:
        r0.setCheckState(r9);
        r0.setOnClickListener(new a(new ProfileSettingListView$createItem$item$1$1(this)));
        r0.setTag(Long.valueOf(r6));
        this.items.put(Long.valueOf(r6), r0);
        return r6;
    }

    public /* synthetic */ ProfileSettingListView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static /* synthetic */ long createItem$default(ProfileSettingListView r0, long r1, String r3, boolean r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r4 = false;
    L6:
        return r0.createItem(r1, r3, r4);
    }
}
