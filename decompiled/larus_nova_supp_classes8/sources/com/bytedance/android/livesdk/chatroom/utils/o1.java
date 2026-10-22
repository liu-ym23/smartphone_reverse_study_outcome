package com.bytedance.android.livesdk.chatroom.utils;

import android.text.TextUtils;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.utils.ab.MoreMixSharePanelUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o1 {
    public static final HashMap a = null;
    public static final HashMap b = null;
    public static final HashMap<String, Integer> c = null;
    public static final HashMap d = null;
    public static volatile o1 e;

    static {
        a = new HashMap();
        b = new HashMap();
        c = new HashMap();
        d = new HashMap();
    }

    public static synchronized o1 d() {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            java.lang.Class<com.bytedance.android.livesdk.chatroom.utils.o1> r0 = com.bytedance.android.livesdk.chatroom.utils.o1.class
            monitor-enter(r0)
            com.bytedance.android.livesdk.chatroom.utils.o1 r1 = com.bytedance.android.livesdk.chatroom.utils.o1.e     // Catch: java.lang.Throwable -> L1e
            if (r1 != 0) goto L1a
            java.lang.Class<com.bytedance.android.livesdk.chatroom.utils.o1> r1 = com.bytedance.android.livesdk.chatroom.utils.o1.class
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L1e
            com.bytedance.android.livesdk.chatroom.utils.o1 r2 = com.bytedance.android.livesdk.chatroom.utils.o1.e     // Catch: java.lang.Throwable -> L17
            if (r2 != 0) goto L15
            com.bytedance.android.livesdk.chatroom.utils.o1 r2 = new com.bytedance.android.livesdk.chatroom.utils.o1     // Catch: java.lang.Throwable -> L17
            r2.<init>()     // Catch: java.lang.Throwable -> L17
            com.bytedance.android.livesdk.chatroom.utils.o1.e = r2     // Catch: java.lang.Throwable -> L17
        L15:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L17
            goto L1a
        L17:
            r2 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L17
            throw r2     // Catch: java.lang.Throwable -> L1e
        L1a:
            com.bytedance.android.livesdk.chatroom.utils.o1 r1 = com.bytedance.android.livesdk.chatroom.utils.o1.e     // Catch: java.lang.Throwable -> L1e
            monitor-exit(r0)
            return r1
        L1e:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.android.livesdk.chatroom.utils.o1.d():com.bytedance.android.livesdk.chatroom.utils.o1");
    }

    public o1() {
        HashMap r0 = a;
        r0.put(ToolbarButton.INTERACTION.extended(), "guest_connection");
        HashMap r1 = b;
        r1.put(26, "guest_connection");
        r0.put(ToolbarButton.LIVE_IM_ENTRANCE.extended(), "IM");
        r1.put(21, "IM");
        ToolbarButton r2 = ToolbarButton.COMMERCE;
        r0.put(r2.extended(), "product");
        r1.put(1, "product");
        ToolbarButton r5 = ToolbarButton.COMMERCE_IM;
        r0.put(r5.extended(), "ecom_custom_service");
        r1.put(43, "ecom_custom_service");
        ToolbarButton r7 = ToolbarButton.COMMERCE_LIVE_AD;
        r0.put(r7.extended(), "windmill");
        r1.put(2, "windmill");
        ToolbarButton r10 = ToolbarButton.GAME_PROMOTE_AUDIENCE;
        r0.put(r10.extended(), "game_promote");
        r1.put(5, "game_promote");
        r0.put(ToolbarButton.GROUP_PURCHASE_AUDIENCE.extended(), "house");
        r1.put(7, "house");
        r0.put(ToolbarButton.OPEN_PLATFORM_MINI_APP.extended(), "small_program");
        r1.put(3, "small_program");
        r0.put(ToolbarButton.WELFARE.extended(), "charity");
        r1.put(4, "charity");
        r0.put(ToolbarButton.FAST_GIFT.extended(), "shortcut_gift");
        r1.put(29, "shortcut_gift");
        r0.put(ToolbarButton.GIFT.extended(), "gift");
        r1.put(28, "gift");
        r0.put(ToolbarButton.CASH_EXCHANGE.extended(), "exchange");
        r1.put(30, "exchange");
        r0.put(ToolbarButton.TREASURE_BOX.extended(), "treasure_box");
        r1.put(41, "treasure_box");
        r0.put(ToolbarButton.MORE.extended(), "more_function");
        r1.put(24, "more_function");
        r0.put(ToolbarButton.SHARE.extended(), "share");
        r1.put(20, "share");
        r0.put(ToolbarButton.VR_MODE.extended(), "VR");
        r1.put(23, "VR");
        r0.put(ToolbarButton.VS_MESSAGE_BOARD.extended(), "guest_book");
        r1.put(27, "guest_book");
        HashMap r3 = d;
        r3.put("product", r2.extended());
        r3.put("commerce_im", r5.extended());
        r3.put("windmill", r7.extended());
        r3.put("house", ToolbarButton.GROUP_PURCHASE.extended());
        r3.put("game_promote", r10.extended());
        HashMap<String, Integer> r4 = c;
        r4.put("product", 1);
        r4.put("commerce_im", 43);
        r4.put("windmill", 2);
        r4.put("house", 7);
        r4.put("game_promote", 5);
    }

    public static String a(int r1) {
        return (r1 + 1) + "";
    }

    public static int b(int r4) {
        if (jc1.k.f(IRoomContextService.class) == null) goto L7;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p r0 = jc1.k.f(IRoomContextService.class).getRoomDataContext(null, 0).j2();
        if (r0 == null) goto L7;
        return r0.getViewIndexById(r4);
    L7:
        return -1;
    }

    public static String c(int r2) {
        String r0 = (String) b.get(Integer.valueOf(r2));
        if (TextUtils.isEmpty(r0) == true) goto L5;
        return r0;
    L5:
        return Integer.toString(r2);
    }

    public static void g(String r3, ExtendedToolbarButton r4, int r5) {
        if (r5 != (-1)) goto L5;
        return;
    L5:
        if (r3.isEmpty() == true) goto L13;
        if (r4 == null) goto L14;
        HashMap r0 = a;
        if (r0.containsKey(r4) == false) goto L15;
        HashMap r1 = new HashMap();
        r1.put("icon_type", (String) r0.get(r4));
        r1.put("icon_order", a(r5));
        com.bytedance.android.livesdk.log.j0.l().sendLog(r3, r1, new Object[]{am2.x.class, IRoom.class});
        return;
    L15:
        return;
    L14:
        return;
    }

    public static void f(DataCenter r1, String r2, int r3, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r4) {
        if (((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3) com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(r1)).l == true) goto L5;
        return;
    L5:
        e(r1, r2, r3, b(r3), r4);
    }

    public static void e(DataCenter r4, String r5, int r6, int r7, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r8) {
        if (r5.isEmpty() == false) goto L6;
        return;
    L6:
        if (r6 == 24) goto L12;
        if (r8 != null) goto L9;
    L11:
        boolean r3 = false;
    L13:
        if (r4 != null) goto L15;
    L18:
        boolean r9 = false;
    L19:
        if (r9 == false) goto L21;
        return;
    L21:
        String r10 = (String) b.get(Integer.valueOf(r6));
        if (r6 != 24) goto L31;
        MiddlewareRoomContext r0 = MiddlewareRoomContext.getShared();
        if (r0 == null) goto L26;
        Room r1 = (Room) r0.getRoom().getValue();
    L28:
        if (MoreMixSharePanelUtils.isMoreShareMode(r1) == false) goto L31;
        r10 = "share";
        goto L31
    L26:
        r1 = null;
    L31:
        if (TextUtils.isEmpty(r10) == false) goto L33;
        r10 = Integer.toString(r6);
    L33:
        HashMap r2 = new HashMap();
        r2.put("icon_type", r10);
        r2.put("icon_order", a(r7));
        r2.put("component_type", String.valueOf(r6));
        if (r8 == null) goto L36;
        String r11 = String.valueOf(r8.f);
    L37:
        r2.put("component_group", r11);
        com.bytedance.android.livesdk.log.j0.l().sendLog(r5, r2, new Object[]{am2.x.class, IRoom.class});
        return;
    L36:
        r11 = "0";
        goto L37
    L15:
        if (ev1.p.c(r4) == false) goto L18;
        if (r3 == false) goto L18;
        r9 = true;
        goto L19
    L9:
        if (r8.a != 24) goto L11;
    L12:
        r3 = true;
        goto L13
    }
}
