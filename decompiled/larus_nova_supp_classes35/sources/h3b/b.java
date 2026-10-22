package h3b;

import android.R;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.blueprint.BlueprintCell;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.i;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.n;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.blueprint.v;
import com.ss.android.lark.chameleon.basewebview.BizScene;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.w;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.export.ui.message.style.BubbleStyle;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends BlueprintCell<y6b.a<?>> implements e6b.b<y6b.a<?>> {

    public static final class a {
    }

    /* JADX INFO: renamed from: h3b.b$b, reason: collision with other inner class name */
    public static final class C0229b implements wza.c<y6b.a<?>, com.ss.android.lark.blueprint.f> {
        public final Class<com.ss.android.lark.blueprint.f> a;

        public C0229b() {
            this.a = com.ss.android.lark.blueprint.f.class;
        }

        public final Class<com.ss.android.lark.blueprint.f> b() {
            return this.a;
        }

        public final m a(g r2, n r3) {
            com.ss.android.lark.blueprint.f r4 = (com.ss.android.lark.blueprint.f) r3;
            Intrinsics.checkNotNullParameter(r2, "ctx");
            Intrinsics.checkNotNullParameter(r4, "cellSpec");
            return new b(r2, r4);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ b a;
        public final /* synthetic */ y6b.a<?> b;

        public c(b r1, y6b.a<?> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r18) {
            b r1 = this.a;
            y6b.a<?> r2 = this.b;
            if (DevEnvUtil.isDebugMode(((BlueprintCell) r1).a.getContext()) == false) goto L39;
            StringBuilder r3 = new StringBuilder();
            StringBuilder r4 = new StringBuilder("BlueprintCell - ");
            r4.append(r2.getType());
            r4.append(" / ");
            r4.append(r2.getType().getNumber());
            r4.append(" - ");
            r4.append(r2.getId());
            r4.append(" - ");
            r4.append(r2.A());
            r4.append(" - ");
            if ((r2 instanceof y6b.c) == false) goto L8;
            y6b.c r5 = (y6b.c) r2;
        L9:
            if (r5 == null) goto L11;
            Object r6 = Integer.valueOf(r5.W2);
        L12:
            r4.append(r6);
            r4.append('\n');
            r3.append(r4.toString());
            r3.append("  layout: " + ((BlueprintCell) r1).b.a() + " - " + r1.l().getClass().getSimpleName() + '\n');
            r3.append("  blocks: [" + ((BlueprintCell) r1).b.b().size() + "] " + CollectionsKt.joinToString$default(((BlueprintCell) r1).b.b(), ", ", null, null, 0, null, null, 62, null) + '\n');
            r3.append("  slots:\n");
            h3b.c r7 = r1.l();
            if ((r7 instanceof h3b.c) == false) goto L15;
            h3b.c r8 = r7;
        L16:
            if (r8 == null) goto L38;
            Iterator<v> r9 = r8.g().iterator();
        L19:
            if (r9.hasNext() == false) goto L38;
            v r10 = r9.next();
            r3.append("    " + r10 + ": ");
            View r11 = r8.n(r10);
            if ((r11 instanceof ViewGroup) == false) goto L23;
            ViewGroup r12 = (ViewGroup) r11;
        L24:
            int r13 = 0;
            if (r12 == null) goto L34;
            int r14 = r12.getChildCount();
            int r15 = 0;
        L27:
            if (r13 >= r14) goto L33;
            j r16 = yza.a.a(r12.getChildAt(r13));
            if (r16 == null) goto L31;
            r3.append(r16 + ", ");
        L32:
            r13 = r13 + 1;
            r15 = 1;
            goto L27
        L31:
            r3.append("{View}, ");
            goto L32
        L33:
            r13 = r15;
        L34:
            if (r13 == 0) goto L36;
            r3.delete(r3.length() - 2, r3.length());
        L37:
            r3.append("\n");
            goto L19
        L36:
            r3.append("--");
            goto L37
        L23:
            r12 = null;
        L38:
            Log.d(r3.toString());
            goto L39
        L15:
            r8 = null;
            goto L16
        L11:
            r6 = "N/A";
            goto L12
        L8:
            r5 = null;
        L39:
            this.a.m(this.b);
        }
    }

    public static final class d implements View.OnLongClickListener {
        public final /* synthetic */ b a;
        public final /* synthetic */ y6b.a<?> b;

        public d(b r1, y6b.a<?> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r2) {
            return this.a.n(this.b);
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ b a;
        public final /* synthetic */ y6b.a<?> b;

        public e(b r1, y6b.a<?> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.m(this.b);
        }
    }

    public static final class f implements View.OnLongClickListener {
        public final /* synthetic */ b a;
        public final /* synthetic */ y6b.a<?> b;

        public f(b r1, y6b.a<?> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r2) {
            return this.a.n(this.b);
        }
    }

    static {
    }

    public final int k(j r7) {
        Intrinsics.checkNotNullParameter(r7, "blockKey");
        Iterator r1 = ((BlueprintCell) this).b.b().iterator();
        int r2 = 0;
    L4:
        if (r1.hasNext() == false) goto L19;
        j r3 = (j) r1.next();
        if (Intrinsics.areEqual(r3, r7) == true) goto L7;
        Intrinsics.checkNotNullParameter(r3, "blockKey");
        e6b.a r4 = (i) ((LinkedHashMap) ((BlueprintCell) this).d).get(r3);
        if ((r4 instanceof e6b.a) == true) goto L10;
        r2 = r2 + 1;
        goto L4
    L10:
        e6b.a.C0216a r5 = r4.e(r7);
        int r6 = r5.a;
        if (r6 >= 0) goto L13;
        if (Intrinsics.areEqual(r3, r7) == false) goto L17;
        Log.e("Fist block key must be found in sub order.");
    L17:
        r2 = r2 + r5.b;
        goto L4
    L13:
        return r2 + r6;
    L7:
        return r2;
    L19:
        return -1;
    }

    public final void m(y6b.a<?> r3) {
        i3b.a r0 = (i3b.a) ((BlueprintCell) this).a.c.a(i3b.a.class);
        if (r0 == null) goto L6;
        r0.d(this, r3);
        return;
    }

    public final boolean n(y6b.a<?> r4) {
        com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.g r0 = l();
        if ((r0 instanceof com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.g) == false) goto L5;
        com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.g r1 = r0;
    L6:
        if (r1 == null) goto L9;
        Point r2 = r1.i();
        if (r2 == null) goto L9;
    L10:
        i3b.a r3 = (i3b.a) ((BlueprintCell) this).a.c.a(i3b.a.class);
        if (r3 != null) goto L15;
        return false;
    L15:
        return r3.c(this, r4, r2);
    L9:
        r2 = new Point();
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public void update(y6b.a<?> r11) {
        Intrinsics.checkNotNullParameter(r11, Keys.API_RETURN_KEY_DATA);
        super.update(r11);
        boolean r3 = true;
        if (r11.getType() != Message.Type.UNKNOWN) goto L5;
    L10:
        boolean r1 = true;
    L11:
        View r2 = ((BlueprintCell) this).g;
        if (r2 == null) goto L14;
        r2.setOnClickListener(new c(this, r11));
    L14:
        l3b.a r4 = null;
        if (r1 == true) goto L27;
        com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.d r5 = l();
        if ((r5 instanceof com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.d) == false) goto L19;
        com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.d r6 = r5;
    L20:
        if (r6 == null) goto L27;
        View r7 = ((BlueprintCell) this).g;
        if (r7 == null) goto L24;
        r7.setOnLongClickListener(new d(this, r11));
    L24:
        ViewGroup r8 = r6.k();
        if (r8 == null) goto L27;
        r8.setOnClickListener(new e(this, r11));
        r8.setOnLongClickListener(new f(this, r11));
        goto L27
    L19:
        r6 = null;
    L27:
        Iterator r9 = ((BlueprintCell) this).b.b().iterator();
    L29:
        if (r9.hasNext() == false) goto L37;
        j r10 = (j) r9.next();
        Intrinsics.checkNotNullParameter(r10, "blockKey");
        e6b.d r12 = (i) ((LinkedHashMap) ((BlueprintCell) this).d).get(r10);
        if ((r12 instanceof e6b.d) == false) goto L33;
        e6b.d r13 = r12;
    L34:
        if (r13 == null) goto L29;
        r13.d(this, l(), r11);
        goto L29
    L33:
        r13 = null;
        goto L34
    L37:
        i3b.d r14 = (i3b.d) ((BlueprintCell) this).a.c.a(i3b.d.class);
        if (r14 == null) goto L79;
        q r15 = l();
        if ((r15 instanceof l3b.a) == false) goto L42;
        r4 = (l3b.a) r15;
    L42:
        if (r4 == null) goto L46;
        BubbleStyle r16 = r4.p();
        if (r16 == null) goto L46;
        int r17 = r16.f;
    L47:
        int r18 = h3b.a.a;
        m2b.a r19 = r14.a();
        FragmentActivity r20 = r14.a().getContext();
        y6b.c r21 = (y6b.c) r11;
        Intrinsics.checkNotNullParameter(this, "cell");
        Intrinsics.checkNotNullParameter(r19, "chatContext");
        Intrinsics.checkNotNullParameter(r20, "context");
        Intrinsics.checkNotNullParameter(r21, Keys.API_RETURN_KEY_DATA);
        if ((l() instanceof com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.a) == false) goto L79;
        View r0 = ((BlueprintCell) this).g;
        if (r0 == null) goto L79;
        Drawable r22 = r0.getBackground();
        if (r22 != null) goto L56;
    L60:
        if (r22 != null) goto L62;
    L64:
        boolean r23 = false;
    L65:
        if (r23 == true) goto L79;
        jdb.g r24 = w.a(r19).C();
        if (r21.V1 == false) goto L70;
    L77:
        r0.setTag(2131384415, r0.getBackground());
        goto L79
    L70:
        if (com.ss.android.lark.chat.utils.i.a(r21, r24, r19.getChat()) == true) goto L77;
        if (Intrinsics.areEqual(r21.c, r19.D8()) == false) goto L74;
        r0.setBackgroundColor(UIUtils.getColor(r20, 2131102443));
        goto L77
    L74:
        if (r17 == 0) goto L76;
        r0.setBackground(UIUtils.getDrawable(r20, r17));
        goto L77
    L76:
        int r25 = p3b.a.W;
        StateListDrawable r26 = new StateListDrawable();
        ColorDrawable r27 = new ColorDrawable();
        r27.setColor(v4b.a.v);
        ColorDrawable r28 = new ColorDrawable();
        r28.setColor(UIHelper.getColor(2131103546));
        r26.addState(new int[]{R.attr.state_selected}, r27);
        r26.addState(new int[]{-16842913}, r28);
        r0.setBackground(r26);
        goto L77
    L62:
        if ((r22 instanceof g2b.g) == false) goto L64;
    L63:
        r23 = true;
        goto L65
    L56:
        if ((r22 instanceof ColorDrawable) == false) goto L60;
        if (((ColorDrawable) r22).getColor() != ContextCompat.getColor(r0.getContext(), 2131108860)) goto L64;
    L46:
        r17 = 0;
    L79:
        if (TextUtils.isEmpty(r11.getId()) == true) goto L81;
    L83:
        r3 = false;
    L84:
        View r29 = ((BlueprintCell) this).g;
        if (r29 == null) goto L91;
        if (r3 == false) goto L88;
        int r30 = 8;
    L89:
        r29.setVisibility(r30);
        goto L91
    L88:
        r30 = 0;
    L91:
        if (Intrinsics.areEqual(r11.getId(), "fake_id_in_target_preview_when_wallpaper_set") == false) goto L93;
    L99:
        View r110 = ((BlueprintCell) this).g;
        if (r110 == null) goto L111;
        ViewGroup.LayoutParams r111 = r110.getLayoutParams();
        if (r111 == null) goto L112;
        r111.height = 0;
        return;
    L112:
        return;
    L111:
        return;
    L93:
        if (Intrinsics.areEqual(r11.getcId(), "fake_id_in_target_preview_when_wallpaper_set") == true) goto L99;
        if (Intrinsics.areEqual(r11.getChatId(), "fake_id_in_target_preview_when_wallpaper_set") == true) goto L99;
        if (Intrinsics.areEqual(r11.g(), "fake_id_in_target_preview_when_wallpaper_set") == true) goto L99;
        if (r3 == true) goto L99;
        return;
    L81:
        if (TextUtils.isEmpty(r11.getcId()) == false) goto L83;
    L5:
        if (((BlueprintCell) this).b.b().contains(IMMessageKeys$Blocks.UNKNOWN_CONTENT) == true) goto L10;
        if (((BlueprintCell) this).b.b().contains(IMMessageKeys$Blocks.FLOW_UNKNOWN_CONTENT) == true) goto L10;
        r1 = false;
        goto L11
    }

    public /* bridge */ /* synthetic */ void update(Object r1) {
        update((y6b.a) r1);
    }

    public b(g r2, n r3) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        Intrinsics.checkNotNullParameter(r3, "cellSpec");
        super(r2, r3);
    }

    public final void d(Object r3, List r4) {
        y6b.a r5 = (y6b.a) r3;
        Intrinsics.checkNotNullParameter(r5, Keys.API_RETURN_KEY_DATA);
        Intrinsics.checkNotNullParameter(r4, "patchData");
        super.d(r5, r4);
        Iterator r6 = ((BlueprintCell) this).b.b().iterator();
    L4:
        if (r6.hasNext() == false) goto L12;
        j r0 = (j) r6.next();
        Intrinsics.checkNotNullParameter(r0, "blockKey");
        e6b.d r1 = (i) ((LinkedHashMap) ((BlueprintCell) this).d).get(r0);
        if ((r1 instanceof e6b.d) == false) goto L8;
        e6b.d r2 = r1;
    L9:
        if (r2 == null) goto L4;
        r2.d(this, l(), r5);
        goto L4
    L8:
        r2 = null;
        goto L9
    }

    @Override // e6b.b
    public final boolean e(i r2, y6b.a<?> r3) {
        y6b.a<?> r4 = r3;
        Intrinsics.checkNotNullParameter(r2, BizScene.BLOCK);
        Intrinsics.checkNotNullParameter(r4, Keys.API_RETURN_KEY_DATA);
        return n(r4);
    }

    @Override // e6b.b
    public final void f(i r3, y6b.a<?> r4) {
        y6b.a<?> r5 = r4;
        Intrinsics.checkNotNullParameter(r3, BizScene.BLOCK);
        Intrinsics.checkNotNullParameter(r5, Keys.API_RETURN_KEY_DATA);
        com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.g r6 = l();
        if ((r6 instanceof com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.g) == false) goto L5;
        com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.g r7 = r6;
    L6:
        if (r7 == null) goto L9;
        Point r8 = r7.i();
        if (r8 == null) goto L9;
    L10:
        i3b.a r0 = (i3b.a) ((BlueprintCell) this).a.c.a(i3b.a.class);
        if (r0 == null) goto L14;
        r0.h(this, r5, r8);
        return;
    L14:
        return;
    L9:
        r8 = new Point();
        goto L10
    L5:
        r7 = null;
        goto L6
    }

    @Override // e6b.b
    public final void j(i r2, y6b.a<?> r3) {
        y6b.a<?> r4 = r3;
        Intrinsics.checkNotNullParameter(r2, BizScene.BLOCK);
        Intrinsics.checkNotNullParameter(r4, Keys.API_RETURN_KEY_DATA);
        m(r4);
    }
}
