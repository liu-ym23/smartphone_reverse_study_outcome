package com.ss.android.lark.chat.preview.components.baseview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.preview.entity.component.property.ChattersPreviewProperty;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.export.entity.preview.ChatterPreviewChatterInfo;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.shapeimage.ShaderImageView;
import g6b.a;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class CrescentAvatarListView extends LinearLayout {
    public static final int k = 0;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public TextView f;
    public LKUIRoundedImageView2 g;
    public RecyclerView h;
    public final PhotoListAdapter i;
    public final boolean j;

    public class PhotoListAdapter extends RecyclerView.Adapter<MyViewHolder> {
        public final AsyncListDiffer<ChatterPreviewChatterInfo> a;
        public final /* synthetic */ CrescentAvatarListView b;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public final CrescentPhotoImageView a;

            /* JADX WARN: Multi-variable type inference failed */
            public MyViewHolder(CrescentPhotoImageView r1) {
                super(r1);
                this.a = r1;
            }
        }

        public class a extends DiffUtil.ItemCallback<ChatterPreviewChatterInfo> {
            public a() {
            }

            public final boolean areContentsTheSame(Object r1, Object r2) {
                ChatterPreviewChatterInfo r3 = (ChatterPreviewChatterInfo) r2;
                return r3.isContentSame((ChatterPreviewChatterInfo) r1);
            }

            public final boolean areItemsTheSame(Object r1, Object r2) {
                ChatterPreviewChatterInfo r3 = (ChatterPreviewChatterInfo) r2;
                return r3.isItemSame((ChatterPreviewChatterInfo) r1);
            }
        }

        public final int getItemCount() {
            return this.a.getCurrentList().size();
        }

        public PhotoListAdapter(CrescentAvatarListView r2) {
            this.b = r2;
            this.a = new AsyncListDiffer(this, new a());
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void onBindViewHolder(RecyclerView.ViewHolder r8, int r9) {
            ChatterPreviewChatterInfo r10 = (ChatterPreviewChatterInfo) ListProtector.get(this.a.getCurrentList(), r9);
            CrescentAvatarListView r0 = this.b;
            Context r1 = r0.getContext();
            ShaderImageView r2 = ((MyViewHolder) r8).a;
            String r3 = r10.getAvatarKey();
            String r4 = r10.getChatterId();
            int r6 = CrescentAvatarListView.k;
            r0.c(r1, r2, r3, r4, r6, r6);
        }

        /* JADX WARN: Type inference failed for: r3v2, types: [android.view.View, com.ss.android.lark.chat.preview.components.baseview.CrescentPhotoImageView] */
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
            ?? r5 = (CrescentPhotoImageView) LayoutInflater.from(r3.getContext()).inflate(2131564252, r3, false);
            CrescentAvatarListView r6 = this.b;
            int r0 = CrescentAvatarListView.k;
            r6.getClass();
            CrescentAvatarListView r7 = this.b;
            zz7.a.b(r5, r7.e, r7.d);
            return new MyViewHolder(r5);
        }
    }

    static {
        k = UIHelper.dp2px(24.0f);
    }

    public TextView getParticipantsNumbView() {
        return this.f;
    }

    public CrescentAvatarListView(Context r1) {
        super(r1);
        this.a = 5;
        this.b = 5;
        this.c = 5;
        this.d = 24;
        this.e = 22;
        this.i = new PhotoListAdapter(this);
        a.InterfaceC0223a r2 = a.a;
        if (r2 == null) goto L5;
        r2.c().getClass();
    L5:
        this.j = false;
        b(null);
    }

    public final void b(AttributeSet r4) {
        setOrientation(0);
        View r0 = LayoutInflater.from(getContext()).inflate(2131559971, this, true);
        this.h = r0.findViewById(2131368293);
        this.g = r0.findViewById(2131368292);
        this.f = (TextView) r0.findViewById(2131368295);
        if (r4 == null) goto L6;
        this.c = 5;
        this.b = 5;
        this.a = 5;
        zz7.a.b(this.g, 24, 24);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    public void setData(ChattersPreviewProperty r13) {
        if (CollectionUtils.isEmpty(r13.getChatterInfoList()) == false) goto L6;
        Log.e("[URLPreview]Chatters", "chatters is null or size == 0 return");
        return;
    L6:
        ?? r0 = new ArrayList(r13.getChatterInfoList());
        int r2 = r13.getMaxShowCount().intValue();
        this.c = r2;
        this.b = r2;
        this.a = r2;
        int r3 = r13.getChatterCounts().intValue();
        Log.i("[URLPreview]Chatters", "setData total = " + r13.getChatterCounts() + " , max = " + r13.getMaxShowCount());
        int r14 = this.a;
        if (r3 > r14) goto L9;
        this.f.setVisibility(8);
        this.g.setVisibility(0);
        zz7.a.b(this.g, 24, 24);
    L14:
        LinearLayoutManager r4 = new LinearLayoutManager(getContext());
        r4.setOrientation(0);
        this.h.setLayoutManager(r4);
        if (r0.size() < this.a) goto L17;
        int r15 = this.b;
    L18:
        if (r15 <= 0) goto L23;
        if (r15 >= r0.size()) goto L23;
        r0 = r0.subList(0, r15);
    L23:
        if (CollectionUtils.isEmpty(r0) == false) goto L25;
        this.h.setVisibility(8);
        return;
    L25:
        ?? r1 = r0;
        if (this.g.getVisibility() != 0) goto L34;
        ChatterPreviewChatterInfo r16 = (ChatterPreviewChatterInfo) ListProtector.get(r0, r0.size() - 1);
        if (r16 == null) goto L31;
        Context r6 = getContext();
        LKUIRoundedImageView2 r7 = this.g;
        String r8 = r16.getAvatarKey();
        String r9 = r16.getChatterId();
        int r11 = k;
        c(r6, r7, r8, r9, r11, r11);
    L31:
        if (r0.size() <= 1) goto L33;
        List r5 = r0.subList(0, r0.size() - 1);
        this.h.setVisibility(0);
        r1 = r5;
        goto L34
    L33:
        this.h.setVisibility(8);
        return;
    L34:
        this.h.setAdapter(this.i);
        this.i.a.submitList(r1);
        return;
    L17:
        r15 = this.c;
        goto L18
    L9:
        if ((r3 - r14) < 100) goto L11;
        this.f.setPadding(UIHelper.dp2px(0.0f), UIHelper.dp2px(0.0f), UIHelper.dp2px(0.0f), UIHelper.dp2px(9.0f));
        this.f.setText("...");
    L12:
        this.f.setVisibility(0);
        this.g.setVisibility(8);
        zz7.a.b(this.f, 24, 24);
        goto L14
    L11:
        this.f.setPadding(UIHelper.dp2px(0.0f), UIHelper.dp2px(0.0f), UIHelper.dp2px(0.0f), UIHelper.dp2px(0.0f));
        this.f.setText("+" + (r3 - this.a));
        goto L12
    }

    public CrescentAvatarListView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = 5;
        this.b = 5;
        this.c = 5;
        this.d = 24;
        this.e = 22;
        this.i = new PhotoListAdapter(this);
        a.InterfaceC0223a r3 = a.a;
        if (r3 == null) goto L5;
        r3.c().getClass();
    L5:
        this.j = false;
        b(r2);
    }

    public CrescentAvatarListView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = 5;
        this.b = 5;
        this.c = 5;
        this.d = 24;
        this.e = 22;
        this.i = new PhotoListAdapter(this);
        a.InterfaceC0223a r4 = a.a;
        if (r4 == null) goto L5;
        r4.c().getClass();
    L5:
        this.j = false;
        b(r2);
    }

    public static com.ss.android.lark.image.entity.a a(Context r2, int r3, int r4) {
        com.ss.android.lark.image.entity.a r0 = new com.ss.android.lark.image.entity.a();
        r0.setShape(1);
        r0.setCornerRadius(0.0f);
        r0.setColor(UIUtils.getColor(r2, 2131103450));
        r0.setSize(r3, r4);
        return r0;
    }

    public final void c(Context r1, ImageView r2, String r3, String r4, int r5, int r6) {
        DesktopUtil.a(r1);
        AvatarImage r7 = AvatarImage.Builder.obtain(r3, r4, r5, r6).build();
        com.ss.android.lark.image.entity.a r8 = a(r1, r5, r6);
        ImageLoader.with(r1).load(r7).isAsync(this.j).placeholder(r8).error(2131233724).override(r5, r6).into(r2);
    }
}
