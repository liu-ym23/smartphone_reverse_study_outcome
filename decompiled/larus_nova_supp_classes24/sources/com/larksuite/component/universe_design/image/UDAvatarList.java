package com.larksuite.component.universe_design.image;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.apm.impl.protector.RunnableProtector;
import h18.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0003'()B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010 \u001a\u00020!2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0003J\b\u0010\"\u001a\u00020!H\u0002J\u0010\u0010\u0011\u001a\u00020!2\u0006\u0010#\u001a\u00020\nH\u0002J\u0012\u0010$\u001a\u00020!2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002R$\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00060\u0019R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001a2\f\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001a@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006*"}, d2 = {"Lcom/larksuite/component/universe_design/image/UDAvatarList;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/larksuite/component/universe_design/dimension/UDDimension;", "overlapWidth", "getOverlapWidth", "()Lcom/larksuite/component/universe_design/dimension/UDDimension;", "setOverlapWidth", "(Lcom/larksuite/component/universe_design/dimension/UDDimension;)V", "maxCount", "getMaxCount", "()I", "setMaxCount", "(I)V", "observer", "Lcom/larksuite/component/universe_design/image/UDAvatarList$DataObserver;", "Lcom/larksuite/component/universe_design/image/UDAvatarList$AvatarAdapter;", "adapter", "getAdapter", "()Lcom/larksuite/component/universe_design/image/UDAvatarList$AvatarAdapter;", "setAdapter", "(Lcom/larksuite/component/universe_design/image/UDAvatarList$AvatarAdapter;)V", "init", "", "onDataChanged", "avatarSize", "addAvatar", "avatar", "Lcom/larksuite/component/universe_design/image/UDAvatar;", "Companion", "AvatarAdapter", "DataObserver", "universe-ui-avatar_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class UDAvatarList extends LinearLayout {
    public static final a Companion = null;
    public static final int MAX_COUNT = 6;
    private AvatarAdapter<?> adapter;
    private int maxCount;
    private b observer;
    private UDDimension overlapWidth;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0004H&J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0004H\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0017\u0010\"\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010#J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u0018\u001a\u00020\u0004H\u0016J\b\u0010&\u001a\u00020\u0004H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR4\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00062\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\u0013¨\u0006'"}, d2 = {"Lcom/larksuite/component/universe_design/image/UDAvatarList$AvatarAdapter;", "DATA", "Landroid/widget/BaseAdapter;", "avatarSize", "", "data", "", "<init>", "(ILjava/util/List;)V", "getAvatarSize", "()I", "value", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "maxCount", "getMaxCount", "setMaxCount", "(I)V", "onItemCreated", "", "avatar", "Lcom/larksuite/component/universe_design/image/UDAvatar;", "position", "getAvatar", "context", "Landroid/content/Context;", "getMoreAvatar", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "getItem", "(I)Ljava/lang/Object;", "getItemId", "", "getCount", "universe-ui-avatar_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static abstract class AvatarAdapter<DATA> extends BaseAdapter {
        private final int avatarSize;
        private List<? extends DATA> data;
        private int maxCount;

        public AvatarAdapter() {
            List r0 = null;
            int r2 = 0;
            this(r2, r0, 3, r0);
        }

        @Override // android.widget.Adapter
        public long getItemId(int r3) {
            return r3;
        }

        @Override // android.widget.Adapter
        public View getView(int r1, View r2, ViewGroup r3) {
            return null;
        }

        public abstract void onItemCreated(UDAvatar r1, int r2);

        @Override // android.widget.Adapter
        public int getCount() {
            List<? extends DATA> r0 = this.data;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.size();
        }

        public final int getAvatarSize() {
            return this.avatarSize;
        }

        public final List<DATA> getData() {
            return this.data;
        }

        public final int getMaxCount() {
            return this.maxCount;
        }

        @Override // android.widget.Adapter
        public DATA getItem(int r2) {
            List<? extends DATA> r0 = this.data;
            if (r0 != null) goto L7;
            return null;
        L7:
            return (DATA) ListProtector.get(r0, r2);
        }

        public UDAvatar getMoreAvatar(Context r5) {
            Intrinsics.checkNotNullParameter(r5, "context");
            List<? extends DATA> r0 = this.data;
            if (r0 == null) goto L5;
            Integer r1 = Integer.valueOf(r0.size() - (this.maxCount - 1));
        L6:
            UDTextAvatar r2 = new UDTextAvatar(r5);
            r2.setBorderStyle(0);
            r2.setAvatarText("+" + r1);
            r2.setTextColor(Integer.valueOf(UDColorUtils.getColor(r5, 2131106607)));
            r2.setAvatarBgColor(UDColorUtils.getColor(r5, 2131100556));
            r2.setBorderColor(UDColorUtils.getColor(r5, 2131100548));
            r2.setAvatarSize(this.avatarSize);
            return r2;
        L5:
            r1 = null;
            goto L6
        }

        public final void setData(List<? extends DATA> r1) {
            this.data = r1;
            notifyDataSetChanged();
        }

        public final void setMaxCount(int r1) {
            this.maxCount = r1;
        }

        public AvatarAdapter(int r1, List<? extends DATA> r2) {
            this.avatarSize = r1;
            this.data = r2;
            this.maxCount = 6;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [android.widget.ImageView, com.larksuite.component.universe_design.image.UDAvatar] */
        public UDAvatar getAvatar(Context r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "context");
            if (getItem(r4) == null) goto L6;
            ?? r0 = new UDAvatar(r3);
            r0.setBorderColor(UDColorUtils.getColor(r3, 2131100548));
            r0.setAvatarSize(this.avatarSize);
            r0.setBackgroundColor(UDColorUtils.getColor(r3, 2131100556));
            onItemCreated(r0, r4);
            return r0;
        L6:
            return null;
        }

        public /* synthetic */ AvatarAdapter(int r1, List r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = -1;
        L6:
            if ((r3 & 2) == 0) goto L8;
            r2 = null;
        L8:
            this(r1, r2);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public final class b extends DataSetObserver {
        public final /* synthetic */ UDAvatarList a;

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            UDAvatarList.access$onDataChanged(this.a);
        }

        public b(UDAvatarList r1) {
            this.a = r1;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ UDAvatarList a;

        public c(UDAvatarList r1) {
            this.a = r1;
        }

        public final void a() {
            this.a.removeAllViews();
            AvatarAdapter<?> r0 = this.a.getAdapter();
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.getCount();
        L6:
            int r3 = Math.min(r2, this.a.getMaxCount() - 1);
            int r4 = 0;
        L7:
            UDAvatar r5 = null;
            if (r4 >= r3) goto L13;
            UDAvatarList r6 = this.a;
            AvatarAdapter<?> r7 = r6.getAdapter();
            if (r7 == null) goto L12;
            r5 = r7.getAvatar(this.a.getContext(), r4);
        L12:
            UDAvatarList.access$addAvatar(r6, r5);
            r4 = r4 + 1;
            goto L7
        L13:
            AvatarAdapter<?> r8 = this.a.getAdapter();
            if (r8 == null) goto L16;
            int r9 = r8.getCount();
        L18:
            if (r9 != this.a.getMaxCount()) goto L23;
            UDAvatarList r10 = this.a;
            AvatarAdapter<?> r11 = r10.getAdapter();
            if (r11 == null) goto L22;
            r5 = r11.getAvatar(this.a.getContext(), this.a.getMaxCount() - 1);
        L22:
            UDAvatarList.access$addAvatar(r10, r5);
            return;
        L23:
            AvatarAdapter<?> r12 = this.a.getAdapter();
            if (r12 == null) goto L27;
            r1 = r12.getCount();
        L27:
            if (r1 <= this.a.getMaxCount()) goto L37;
            UDAvatarList r13 = this.a;
            AvatarAdapter<?> r14 = r13.getAdapter();
            if (r14 == null) goto L31;
            r5 = r14.getMoreAvatar(this.a.getContext());
        L31:
            UDAvatarList.access$addAvatar(r13, r5);
            return;
        L37:
            return;
        L16:
            r9 = 0;
            goto L18
        L5:
            r2 = 0;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        Companion = new a();
    }

    private final void onDataChanged() {
        new Handler(Looper.getMainLooper()).post(new c(this));
    }

    public final AvatarAdapter<?> getAdapter() {
        return this.adapter;
    }

    public final int getMaxCount() {
        return this.maxCount;
    }

    public final UDDimension getOverlapWidth() {
        return this.overlapWidth;
    }

    public UDAvatarList(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public static final /* synthetic */ void access$onDataChanged(UDAvatarList r0) {
        r0.onDataChanged();
    }

    private final void addAvatar(UDAvatar r7) {
        int r0 = (int) this.overlapWidth.toPixels(getContext());
        if (r7 == null) goto L38;
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(-2, -2);
        if (getChildCount() <= 0) goto L15;
        int r4 = 0;
        if (getOrientation() != 0) goto L9;
        int r3 = -r0;
    L10:
        r1.leftMargin = r3;
        if (getOrientation() != 1) goto L13;
        r4 = -r0;
    L13:
        r1.topMargin = r4;
        goto L15
    L9:
        r3 = 0;
    L15:
        if (r7.getBorderColor() != 0) goto L17;
    L36:
        addView(r7.drawBorderDelegate$universe_ui_avatar_release(), r1);
        return;
    L17:
        if (r7.getBorderWidth() != null) goto L19;
    L20:
        int r2 = r7.getAvatarSize();
        if (r2 != (-5)) goto L23;
        int r5 = d.d(getContext(), 2131169328);
    L35:
        r7.setBorderWidth(Float.valueOf(r5));
        goto L36
    L23:
        if (r2 != (-4)) goto L25;
        r5 = d.d(getContext(), 2131169331);
        goto L35
    L25:
        if (r2 == (-3)) goto L32;
        if (r2 != (-2)) goto L28;
        r5 = d.d(getContext(), 2131169330);
        goto L35
    L28:
        if (r2 == (-1)) goto L30;
        r5 = d.d(getContext(), 2131169329);
        goto L35
    L30:
        r5 = d.d(getContext(), 2131169329);
        goto L35
    L32:
        r5 = d.d(getContext(), 2131169332);
        goto L35
    L19:
        if (Intrinsics.areEqual(r7.getBorderWidth(), 0.0f) == false) goto L36;
    }

    private final void setOverlapWidth(int r3) {
        if (r3 != (-5)) goto L5;
        int r4 = d.d(getContext(), 2131169342);
    L18:
        setOverlapWidth(new UDDimension.a(r4));
        return;
    L5:
        if (r3 != (-4)) goto L7;
        r4 = d.d(getContext(), 2131169345);
        goto L18
    L7:
        if (r3 != (-3)) goto L9;
        r4 = d.d(getContext(), 2131169346);
        goto L18
    L9:
        if (r3 != (-2)) goto L11;
        r4 = d.d(getContext(), 2131169344);
        goto L18
    L11:
        if (r3 == (-1)) goto L13;
        r4 = d.d(getContext(), 2131169343);
        goto L18
    L13:
        r4 = d.d(getContext(), 2131169343);
        goto L18
    }

    public final void setAdapter(AvatarAdapter<?> r3) {
        AvatarAdapter<?> r0 = this.adapter;
        if (r0 == null) goto L5;
        r0.unregisterDataSetObserver(this.observer);
    L5:
        this.adapter = r3;
        if (r3 == null) goto L8;
        r3.registerDataSetObserver(this.observer);
    L8:
        AvatarAdapter<?> r4 = this.adapter;
        if (r4 == null) goto L11;
        setOverlapWidth(r4.getAvatarSize());
        r4.setMaxCount(this.maxCount);
    L11:
        this.observer.onChanged();
    }

    public final void setMaxCount(int r2) {
        this.maxCount = r2;
        AvatarAdapter<?> r0 = this.adapter;
        if (r0 == null) goto L5;
        r0.setMaxCount(r2);
    L5:
        AvatarAdapter<?> r3 = this.adapter;
        if (r3 == null) goto L9;
        r3.notifyDataSetChanged();
        return;
    }

    public final void setOverlapWidth(UDDimension r4) {
        Intrinsics.checkNotNullParameter(r4, "value");
        if (r4.toPixels(getContext()) != this.overlapWidth.toPixels(getContext())) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L11;
        this.overlapWidth = r4;
        AvatarAdapter<?> r5 = this.adapter;
        if (r5 == null) goto L12;
        r5.notifyDataSetChanged();
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public UDAvatarList(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public static final /* synthetic */ void access$addAvatar(UDAvatarList r0, UDAvatar r1) {
        r0.addAvatar(r1);
    }

    private final void init(AttributeSet r5, int r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        TypedArray r7 = getContext().obtainStyledAttributes(r5, new int[]{2130974834}, r6, 0);
        setMaxCount(r7.getInt(0, 6));
        r7.recycle();
    }

    public UDAvatarList(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.overlapWidth = new UDDimension.a(0);
        this.maxCount = 6;
        this.observer = new b(this);
        init(r3, r4);
    }
}
