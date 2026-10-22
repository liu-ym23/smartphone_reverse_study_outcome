package com.larus.bmhome.chat.nestedmenu;

import android.view.View;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.clarification.h1;
import di8.o0;
import java.util.Collection;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 *2\u00020\u0001:\u0001*J\u008c\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00152\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015H&J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0014\u0010\u001a\u001a\u00020\u00172\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J:\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u00072\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00170 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00170 H\u0016J.\u0010\"\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00170\u0015H&J`\u0010$\u001a2\u0012\b\u0012\u00060\u0007j\u0002`&\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0'0%j\u0018\u0012\b\u0012\u00060\u0007j\u0002`&\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0'`)2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&Jf\u0010$\u001a2\u0012\b\u0012\u00060\u0007j\u0002`&\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0'0%j\u0018\u0012\b\u0012\u00060\u0007j\u0002`&\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0'`)2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006+"}, d2 = {"Lcom/larus/bmhome/chat/nestedmenu/IMainBotNestedMenuService;", "", "showActionBarNestedMenu", "", "scene", "Lcom/larus/bmhome/chat/nestedmenu/NestedMenuScene;", "enterFrom", "", "hostView", "Landroid/view/View;", "sourceView", "popupHostView", "actionBarItem", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "uiConfig", "Lcom/larus/bmhome/chat/nestedmenu/NestedMenuUiConfig;", "replyOption", "Lcom/larus/bmhome/actionbar/model/ReplyOption;", "hostVContext", "Lcom/larus/ui/arch/context/external/VContext;", "onUnEnableClick", "Lkotlin/Function1;", "Lcom/larus/bmhome/chat/nestedmenu/NestedMenuClickResult;", "", "onClick", "updateIfNeeded", "dismiss", "interceptOfflineOfficeTaskDevice", "conversationId", "localMessageIds", "", "onContinue", "Lkotlin/Function0;", "onCancel", "resolveAutoRouteTaskReplyOption", "onResolved", "generateMenuItemModels", "Ljava/util/LinkedHashMap;", "Lcom/larus/bmhome/chat/nestedmenu/NestedMenuSectionName;", "", "Lcom/larus/bmhome/chat/nestedmenu/NestedMenuItemModel;", "Lkotlin/collections/LinkedHashMap;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public interface IMainBotNestedMenuService {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0082\u0001\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001c2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001cH\u0016J\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010!\u001a\u00020\u001e2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J:\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u000e2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001e0'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001e0'H\u0016J.\u0010)\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001e0\u001cH\u0016J^\u0010+\u001a2\u0012\b\u0012\u00060\u000ej\u0002`-\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0.0,j\u0018\u0012\b\u0012\u00060\u000ej\u0002`-\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0.`02\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016Jf\u0010+\u001a2\u0012\b\u0012\u00060\u000ej\u0002`-\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0.0,j\u0018\u0012\b\u0012\u00060\u000ej\u0002`-\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0.`02\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u00061"}, d2 = {"Lcom/larus/bmhome/chat/nestedmenu/IMainBotNestedMenuService$Companion;", "Lcom/larus/bmhome/chat/nestedmenu/IMainBotNestedMenuService;", "<init>", "()V", "impl", "getImpl", "()Lcom/larus/bmhome/chat/nestedmenu/IMainBotNestedMenuService;", "impl$delegate", "Lkotlin/Lazy;", "showActionBarNestedMenu", "", "scene", "Lcom/larus/bmhome/chat/nestedmenu/NestedMenuScene;", "enterFrom", "", "hostView", "Landroid/view/View;", "sourceView", "popupHostView", "actionBarItem", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "uiConfig", "Lcom/larus/bmhome/chat/nestedmenu/NestedMenuUiConfig;", "replyOption", "Lcom/larus/bmhome/actionbar/model/ReplyOption;", "hostVContext", "Lcom/larus/ui/arch/context/external/VContext;", "onUnEnableClick", "Lkotlin/Function1;", "Lcom/larus/bmhome/chat/nestedmenu/NestedMenuClickResult;", "", "onClick", "updateIfNeeded", "dismiss", "interceptOfflineOfficeTaskDevice", "conversationId", "localMessageIds", "", "onContinue", "Lkotlin/Function0;", "onCancel", "resolveAutoRouteTaskReplyOption", "onResolved", "generateMenuItemModels", "Ljava/util/LinkedHashMap;", "Lcom/larus/bmhome/chat/nestedmenu/NestedMenuSectionName;", "", "Lcom/larus/bmhome/chat/nestedmenu/NestedMenuItemModel;", "Lkotlin/collections/LinkedHashMap;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class Companion implements IMainBotNestedMenuService {
        public static final /* synthetic */ Companion b = null;
        public static final Lazy<IMainBotNestedMenuService> c = null;

        private Companion() {
        }

        static {
            b = new Companion();
            c = LazyKt.lazy(new di8.b());
        }

        public static IMainBotNestedMenuService a() {
            return (IMainBotNestedMenuService) c.getValue();
        }

        @Override // com.larus.bmhome.chat.nestedmenu.IMainBotNestedMenuService
        public final void O8() {
            Intrinsics.checkNotNullParameter("action_bar_banner_request", "enterFrom");
            IMainBotNestedMenuService r0 = a();
            if (r0 == null) goto L6;
            r0.O8();
            return;
        }

        @Override // com.larus.bmhome.chat.nestedmenu.IMainBotNestedMenuService
        public final void g0(String r2) {
            IMainBotNestedMenuService r0 = a();
            if (r0 == null) goto L6;
            r0.g0(r2);
            return;
        }

        @Override // com.larus.bmhome.chat.nestedmenu.IMainBotNestedMenuService
        public final LinkedHashMap P8(NestedMenuScene r2, z0 r3, ReplyOption r4) {
            Intrinsics.checkNotNullParameter(r2, "scene");
            IMainBotNestedMenuService r0 = a();
            if (r0 == null) goto L7;
            LinkedHashMap r5 = r0.P8(r2, r3, r4);
            if (r5 == null) goto L7;
            return r5;
        L7:
            return new LinkedHashMap();
        }

        @Override // com.larus.bmhome.chat.nestedmenu.IMainBotNestedMenuService
        public final boolean Q8(View r2, z0 r3, h1 r4) {
            Intrinsics.checkNotNullParameter(r2, "hostView");
            Intrinsics.checkNotNullParameter(r4, "onResolved");
            IMainBotNestedMenuService r0 = a();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.Q8(r2, r3, r4);
        }

        @Override // com.larus.bmhome.chat.nestedmenu.IMainBotNestedMenuService
        public final LinkedHashMap R8(NestedMenuScene r2, z0 r3, ReplyOption r4, View r5) {
            Intrinsics.checkNotNullParameter(r2, "scene");
            Intrinsics.checkNotNullParameter(r5, "hostView");
            IMainBotNestedMenuService r0 = a();
            if (r0 == null) goto L7;
            LinkedHashMap r6 = r0.R8(r2, r3, r4, r5);
            if (r6 == null) goto L7;
            return r6;
        L7:
            return new LinkedHashMap();
        }

        @Override // com.larus.bmhome.chat.nestedmenu.IMainBotNestedMenuService
        public final void S8(String r3, Collection<String> r4, Function0<Unit> r5, Function0<Unit> r6) {
            Intrinsics.checkNotNullParameter(r3, "conversationId");
            Intrinsics.checkNotNullParameter(r4, "localMessageIds");
            Intrinsics.checkNotNullParameter(r5, "onContinue");
            Intrinsics.checkNotNullParameter(r6, "onCancel");
            if (Intrinsics.areEqual(qa9.a.a().a(), "1") == true) goto L6;
            r5.invoke();
            return;
        L6:
            IMainBotNestedMenuService r0 = a();
            if (r0 == null) goto L9;
            r0.S8(r3, r4, r5, r6);
            return;
        L9:
            r5.invoke();
        }

        @Override // com.larus.bmhome.chat.nestedmenu.IMainBotNestedMenuService
        public final boolean T8(NestedMenuScene r14, String r15, View r16, View r17, View r18, z0 r19, o0 r20, ReplyOption r21, t1a.b r22, Function1<? super c, Unit> r23, Function1<? super c, Unit> r24) {
            Intrinsics.checkNotNullParameter(r14, "scene");
            Intrinsics.checkNotNullParameter(r16, "hostView");
            Intrinsics.checkNotNullParameter(r17, "sourceView");
            Intrinsics.checkNotNullParameter(r18, "popupHostView");
            Intrinsics.checkNotNullParameter(r20, "uiConfig");
            Intrinsics.checkNotNullParameter(r24, "onClick");
            IMainBotNestedMenuService r1 = a();
            if (r1 != null) goto L7;
            return false;
        L7:
            return r1.T8(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
        }
    }

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ boolean a(Companion r29, NestedMenuScene r30, String r31, View r32, View r33, View r34, z0 r35, o0 r36, ReplyOption r37, Function1 r38, Function1 r39, int r40) {
            if ((r40 & 16) == 0) goto L5;
            View r7 = r32;
        L7:
            if ((r40 & 64) == 0) goto L9;
            o0 r9 = new o0(false, false, null, false, null, 0, 0, false, null, null, null, null, null, null, false, false, null, null, null, 33554431);
        L11:
            if ((r40 & 128) == 0) goto L13;
            ReplyOption r10 = null;
        L15:
            if ((r40 & 512) == 0) goto L17;
            Function1 r12 = null;
        L19:
            return r29.T8(r30, r31, r32, r33, r7, r35, r9, r10, null, r12, r39);
        L17:
            r12 = r38;
            goto L19
        L13:
            r10 = r37;
            goto L15
        L9:
            r9 = r36;
            goto L11
        L5:
            r7 = r34;
            goto L7
        }
    }

    static {
        a = Companion.b;
    }

    void O8();

    LinkedHashMap P8(NestedMenuScene r1, z0 r2, ReplyOption r3);

    boolean Q8(View r1, z0 r2, h1 r3);

    LinkedHashMap R8(NestedMenuScene r1, z0 r2, ReplyOption r3, View r4);

    void S8(String r1, Collection<String> r2, Function0<Unit> r3, Function0<Unit> r4);

    boolean T8(NestedMenuScene r1, String r2, View r3, View r4, View r5, z0 r6, o0 r7, ReplyOption r8, t1a.b r9, Function1<? super c, Unit> r10, Function1<? super c, Unit> r11);

    void g0(String r1);
}
