package e4b;

import android.content.Context;
import android.content.Intent;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.extension.message.j;
import com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.ListMode;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.select.MessageListMultiSelectFeature$initMultiSelector$multiSelector$1;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.cleanresource.ResourceType;
import com.ss.android.lark.widget.recyclerview.MultiSelector;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import s2b.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements e4b.a {
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b a;
    public ListMode b;
    public MessageListMultiSelectFeature$initMultiSelector$multiSelector$1 c;
    public final List<j> d;
    public List<String> e;

    public static final class a {
    }

    /* JADX INFO: renamed from: e4b.b$b, reason: collision with other inner class name */
    public /* synthetic */ class C0214b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Message.Type.values().length];
            r0[Message.Type.MEDIA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[Message.Type.IMAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[Message.Type.STICKER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[Message.Type.FILE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onActivityResult(int r1, int r2, Intent r3) {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onDestroy() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onPause() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onResume() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onStart() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final /* synthetic */ void onStop() {
    }

    public b() {
        this.b = ListMode.NORMAL;
        this.d = new CopyOnWriteArrayList();
    }

    @Override // e4b.a
    public final ListMode o() {
        return this.b;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final void x(i7b.a r4) {
        Intrinsics.checkNotNullParameter(r4, "initData");
        Intrinsics.checkNotNullParameter(r4, "initData");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r5 = this.a;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r1 = null;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r5 = null;
    L5:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a r6 = (com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a) r5.b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.a.class);
        if (r6 == null) goto L8;
        com.ss.android.lark.chat.chatwindow.chat.a r7 = r6.getAdapter();
    L9:
        if (r7 == null) goto L20;
        MessageListMultiSelectFeature$initMultiSelector$multiSelector$1 r2 = new MessageListMultiSelectFeature$initMultiSelector$multiSelector$1(r7, this);
        this.c = r2;
        ((MultiSelector) r2).e = new c(this, r2);
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r8 = this.a;
        if (r8 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("env");
    L15:
        d r9 = r1.a();
        if (r9 == null) goto L19;
        r9.u8(r2);
        return;
    L19:
        return;
    L14:
        r1 = r8;
        goto L15
    L20:
        return;
    L8:
        r7 = null;
        goto L9
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a
    public final void y(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        this.a = r2;
    }

    @Override // e4b.a
    public final boolean E(y6b.c<?> r18, int r19) {
        Intrinsics.checkNotNullParameter(r18, "message");
        MessageListMultiSelectFeature$initMultiSelector$multiSelector$1 r2 = this.c;
        boolean r3 = false;
        if (r2 != null) goto L6;
        return false;
    L6:
        if (((MultiSelector) r2).d == true) goto L8;
        return false;
    L8:
        List<j> r4 = this.d;
        if ((r4 instanceof Collection) == true) goto L11;
    L13:
        Iterator r5 = ((CopyOnWriteArrayList) r4).iterator();
    L15:
        if (r5.hasNext() == false) goto L19;
        if (((j) r5.next()).a() == false) goto L15;
        boolean r6 = true;
    L20:
        if (r6 == false) goto L23;
    L117:
        return true;
    L23:
        if (lpc.a.d(r18) == false) goto L101;
        Message.Type r7 = r18.getType();
        int r8 = C0214b.a[r7.ordinal()];
        if (r8 == 1) goto L34;
        if (r8 == 2) goto L33;
        if (r8 == 3) goto L32;
        if (r8 == 4) goto L31;
        ResourceType r9 = ResourceType.FILE;
    L35:
        ResourceCleanScene r11 = lpc.a.b(r18);
        y6b.b r12 = r18.t;
        if (r12 == null) goto L38;
        String r13 = r12.w;
    L39:
        acc.d r10 = new acc.d(r9, r11, acc.a.d(r13));
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r14 = this.a;
        if (r14 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r14 = null;
    L42:
        Context r15 = r14.getContext();
        Intrinsics.checkNotNullParameter(r15, "context");
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r15, "context");
        Intrinsics.checkNotNullParameter(r10, "params");
        ResourceCleanScene r16 = r10.b;
        ResourceType r17 = r10.getType();
        if (r16 != null) goto L59;
        if (r10.c == false) goto L47;
        String r20 = UIUtils.getString(r15, 2131891031);
    L57:
        Intrinsics.checkNotNull(r20);
    L100:
        UICallbackExecutor.execute(new acc.c(r15, r20));
        r3 = true;
        goto L101
    L47:
        int r21 = acc.a.a.a[r17.ordinal()];
        if (r21 == 1) goto L56;
        if (r21 == 2) goto L56;
        if (r21 == 3) goto L55;
        if (r21 != 4) goto L54;
        r20 = UIUtils.getString(r15, 2131891110);
        goto L57
    L54:
        throw new NoWhenBranchMatchedException();
    L55:
        r20 = UIUtils.getString(r15, 2131891427);
    L56:
        r20 = UIUtils.getString(r15, 2131891153);
        goto L57
    L59:
        if (r16.isUnifiedRegularDelete() == false) goto L87;
        if (r16.isPersonalDelete() == false) goto L73;
        int r22 = acc.a.a.a[r17.ordinal()];
        if (r22 == 1) goto L71;
        if (r22 == 2) goto L71;
        if (r22 == 3) goto L70;
        if (r22 != 4) goto L69;
        r20 = UIUtils.getString(r15, 2131891113);
    L85:
        Intrinsics.checkNotNull(r20);
        goto L100
    L69:
        throw new NoWhenBranchMatchedException();
    L70:
        r20 = UIUtils.getString(r15, 2131891430);
    L71:
        r20 = UIUtils.getString(r15, 2131891156);
        goto L85
    L73:
        if (r10.c == false) goto L75;
        r20 = UIUtils.getString(r15, 2131891031);
        goto L85
    L75:
        int r23 = acc.a.a.a[r17.ordinal()];
        if (r23 == 1) goto L84;
        if (r23 == 2) goto L84;
        if (r23 == 3) goto L83;
        if (r23 != 4) goto L82;
        r20 = UIUtils.getString(r15, 2131891110);
        goto L85
    L82:
        throw new NoWhenBranchMatchedException();
    L83:
        r20 = UIUtils.getString(r15, 2131891427);
    L84:
        r20 = UIUtils.getString(r15, 2131891153);
        goto L85
    L87:
        if (r16.isCSAMDelete() == false) goto L89;
        r20 = UIUtils.getString(r15, 2131891118);
        goto L100
    L89:
        int r24 = acc.a.a.a[r17.ordinal()];
        if (r24 == 1) goto L98;
        if (r24 == 2) goto L98;
        if (r24 == 3) goto L97;
        if (r24 != 4) goto L96;
        r20 = UIUtils.getString(r15, 2131891113);
    L99:
        Intrinsics.checkNotNull(r20);
        goto L100
    L96:
        throw new NoWhenBranchMatchedException();
    L97:
        r20 = UIUtils.getString(r15, 2131891430);
    L98:
        r20 = UIUtils.getString(r15, 2131891156);
        goto L99
    L38:
        r13 = null;
        goto L39
    L31:
        r9 = ResourceType.FILE;
        goto L35
    L32:
        r9 = ResourceType.STICKER;
        goto L35
    L33:
        r9 = ResourceType.IMAGE;
        goto L35
    L34:
        r9 = ResourceType.VIDEO;
    L101:
        if (r3 == true) goto L117;
        if (r2.b(r18) == false) goto L117;
        String r25 = r18.c;
        List<String> r26 = this.e;
        if (r26 == null) goto L109;
        TypeIntrinsics.asMutableCollection(r26).remove(r25);
    L109:
        if (((MultiSelector) r2).b.containsKey(Integer.valueOf(r18.hashCode())) == false) goto L111;
    L116:
        r2.d(r19);
        goto L117
    L111:
        if (((MultiSelector) r2).b.size() < 100) goto L116;
        String r1 = UIHelper.getString(2131892001);
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.b r27 = this.a;
        if (r27 != null) goto L115;
        Intrinsics.throwUninitializedPropertyAccessException("env");
        r27 = null;
    L115:
        com.larksuite.component.ui.dialog.d r28 = new com.larksuite.component.ui.dialog.d(r27.getContext());
        r28.k(r1);
        r28.c.titleBold(true);
        r28.c.titleLineCount(2);
        r28.b(2131378551, UIHelper.getString(2131892215), null);
        l7b.a.a(r28.i());
    L19:
        r6 = false;
        goto L20
    L11:
        if (((CopyOnWriteArrayList) r4).isEmpty() == false) goto L13;
        goto L13
    }
}
