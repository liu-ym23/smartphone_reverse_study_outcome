package com.ss.android.lark.flow.chat.message;

import android.graphics.Point;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b3b.f;
import com.ss.android.lark.biz.im.api.extension.ImExtensionType;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.o;
import com.ss.android.lark.blueprint.p;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.SceneCoordinateRecyclerView;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.CotEntryBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.DLPBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ImageContentBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.MediaContentBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.MessageReplyCountBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.MultiSelectBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.PostContentBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.StickerContentBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.SystemContentBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ThreadReplyBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.UrlPreviewBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.UrlPreviewContentBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.recall.RecalledContentBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.sys.SysChatGuideContentBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.sys.SysRedPacketContentBlock;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.w;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.open.message.IMMessageKeys;
import com.ss.android.lark.flow.chat.message.block.FlowFileContentBlock;
import com.ss.android.lark.flow.chat.message.block.FlowMessageStatusBlock;
import com.ss.android.lark.flow.chat.message.block.FlowProfileContentBlock;
import com.ss.android.lark.flow.chat.message.block.FlowReactionBlock;
import com.ss.android.lark.flow.chat.message.block.FlowRecalledSystemContentBlock;
import com.ss.android.lark.flow.chat.message.block.FlowReplyInThreadExposureBlock;
import com.ss.android.lark.flow.chat.message.block.FlowUnknownContentBlock;
import com.ss.android.lark.flow.chat.message.block.FlowUsernameBlock;
import com.ss.android.lark.flow.chat.message.block.audio.FlowAudioContentBlock;
import com.ss.android.lark.flow.chat.message.block.replay.FlowReplyBlock;
import com.ss.android.lark.flow.chat.message.block.sharegroup.FlowShareGroupContentBlock;
import com.ss.android.lark.flow.chat.message.block.threadforward.FlowThreadForwardContentBlock;
import com.ss.android.lark.flow.chat.message.block.threadforward.FlowThreadForwardExposureBlock;
import com.ss.android.lark.flow.chat.message.block.threadforward.FlowThreadForwardHeaderBlock;
import com.ss.android.lark.flow.chat.message.cell.FlowChatCellSpecMapper;
import com.ss.android.lark.flow.chat.message.downgrade.block.FlowCalendarContentBlock;
import com.ss.android.lark.flow.chat.message.downgrade.block.FlowTodoContentBlock;
import com.ss.android.lark.flow.chat.message.downgrade.block.FlowVideoChatContentBlock;
import com.ss.android.lark.flow.chat.message.layout.h;
import com.ss.android.lark.flow.chat.message.layout.i;
import com.ss.android.lark.flow.chat.message.layout.l;
import com.ss.android.lark.flow.chat.message.redpacket.FlowRedPacketContentBlock;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import r5b.e;
import v4b.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowChatBlueprintFactory implements q2b.a {
    public final m2b.a a;
    public final e6b.b.a<y6b.a<?>, h3b.b> b;
    public final f c;
    public final d d;
    public final v4b.c e;
    public final Fragment f;
    public final RecyclerView g;
    public final Function3<m2b.a, List<? extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.open.a<?, ?, ?>>, List<? extends xya.a>, o<y6b.a<?>>> h;
    public final l3b.c i;
    public final List<e<?, ?, ?>> j;
    public final List<com.ss.android.lark.chat.chatwindow.chat.message.cellv2.open.a<?, ?, ?>> k;

    public static final class a implements i3b.a {
        public final /* synthetic */ FlowChatBlueprintFactory a;

        public final Class i() {
            return i3b.a.class;
        }

        public a(FlowChatBlueprintFactory r1) {
            this.a = r1;
        }

        public final void d(m r2, Object r3) {
            h3b.b r4 = (h3b.b) r2;
            y6b.a r5 = (y6b.a) r3;
            Intrinsics.checkNotNullParameter(r4, "cell");
            Intrinsics.checkNotNullParameter(r5, "data");
            this.a.b.d(r4, r5);
        }

        public final boolean c(m r2, Object r3, Point r4) {
            h3b.b r5 = (h3b.b) r2;
            y6b.a r6 = (y6b.a) r3;
            Intrinsics.checkNotNullParameter(r5, "cell");
            Intrinsics.checkNotNullParameter(r6, "data");
            Intrinsics.checkNotNullParameter(r4, "touchEventOnWindow");
            return this.a.b.c(r5, r6, r4);
        }

        public final void h(m r2, Object r3, Point r4) {
            h3b.b r5 = (h3b.b) r2;
            y6b.a r6 = (y6b.a) r3;
            Intrinsics.checkNotNullParameter(r5, "cell");
            Intrinsics.checkNotNullParameter(r6, "data");
            Intrinsics.checkNotNullParameter(r4, "touchEventOnWindow");
            this.a.b.h(r5, r6, r4);
        }
    }

    public static final class b implements i3b.b {
        public b() {
        }

        public final Class c() {
            return i3b.b.class;
        }

        public final float f(float r1) {
            return vgb.a.a(r1);
        }
    }

    public static final class c implements mza.a {
        public final Fragment a;
        public final RecyclerView b;

        public final Class<? extends p> c() {
            return mza.a.class;
        }

        public final Fragment getFragment() {
            return this.a;
        }

        public final RecyclerView getRecyclerView() {
            return this.b;
        }

        public c(FlowChatBlueprintFactory r2) {
            this.a = r2.f;
            this.b = r2.g;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.FlowChatBlueprintFactory$create$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<g, FlowUnknownContentBlock> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(1, FlowUnknownContentBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final FlowUnknownContentBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new FlowUnknownContentBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.FlowChatBlueprintFactory$create$10, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class AnonymousClass10 extends FunctionReferenceImpl implements Function1<g, FlowUsernameBlock> {
        public static final AnonymousClass10 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass10();
        }

        public AnonymousClass10() {
            super(1, FlowUsernameBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final FlowUsernameBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new FlowUsernameBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.FlowChatBlueprintFactory$create$11, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class AnonymousClass11 extends FunctionReferenceImpl implements Function1<g, FlowReactionBlock> {
        public static final AnonymousClass11 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass11();
        }

        public AnonymousClass11() {
            super(1, FlowReactionBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final FlowReactionBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new FlowReactionBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.FlowChatBlueprintFactory$create$12, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class AnonymousClass12 extends FunctionReferenceImpl implements Function1<g, FlowReplyInThreadExposureBlock> {
        public static final AnonymousClass12 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass12();
        }

        public AnonymousClass12() {
            super(1, FlowReplyInThreadExposureBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final FlowReplyInThreadExposureBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new FlowReplyInThreadExposureBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.FlowChatBlueprintFactory$create$13, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class AnonymousClass13 extends FunctionReferenceImpl implements Function1<g, UrlPreviewContentBlock> {
        public static final AnonymousClass13 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass13();
        }

        public AnonymousClass13() {
            super(1, UrlPreviewContentBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final UrlPreviewContentBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new UrlPreviewContentBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.FlowChatBlueprintFactory$create$14, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class AnonymousClass14 extends FunctionReferenceImpl implements Function1<g, FlowShareGroupContentBlock> {
        public static final AnonymousClass14 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass14();
        }

        public AnonymousClass14() {
            super(1, FlowShareGroupContentBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final FlowShareGroupContentBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new FlowShareGroupContentBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.FlowChatBlueprintFactory$create$15, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class AnonymousClass15 extends FunctionReferenceImpl implements Function1<g, StickerContentBlock> {
        public static final AnonymousClass15 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass15();
        }

        public AnonymousClass15() {
            super(1, StickerContentBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final StickerContentBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new StickerContentBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.FlowChatBlueprintFactory$create$16, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class AnonymousClass16 extends FunctionReferenceImpl implements Function1<g, FlowFileContentBlock> {
        public static final AnonymousClass16 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass16();
        }

        public AnonymousClass16() {
            super(1, FlowFileContentBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final FlowFileContentBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new FlowFileContentBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.FlowChatBlueprintFactory$create$17, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class AnonymousClass17 extends FunctionReferenceImpl implements Function1<g, com.ss.android.lark.flow.chat.message.block.c> {
        public static final AnonymousClass17 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass17();
        }

        public AnonymousClass17() {
            super(1, com.ss.android.lark.flow.chat.message.block.c.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final com.ss.android.lark.flow.chat.message.block.c invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new com.ss.android.lark.flow.chat.message.block.c(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.FlowChatBlueprintFactory$create$18, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class AnonymousClass18 extends FunctionReferenceImpl implements Function1<g, FlowReplyBlock> {
        public static final AnonymousClass18 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass18();
        }

        public AnonymousClass18() {
            super(1, FlowReplyBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final FlowReplyBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new FlowReplyBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.FlowChatBlueprintFactory$create$19, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class AnonymousClass19 extends FunctionReferenceImpl implements Function1<g, PostContentBlock> {
        public static final AnonymousClass19 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass19();
        }

        public AnonymousClass19() {
            super(1, PostContentBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final PostContentBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new PostContentBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.FlowChatBlueprintFactory$create$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<g, RecalledContentBlock> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
            super(1, RecalledContentBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final RecalledContentBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new RecalledContentBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.FlowChatBlueprintFactory$create$20, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class AnonymousClass20 extends FunctionReferenceImpl implements Function1<g, MediaContentBlock> {
        public static final AnonymousClass20 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass20();
        }

        public AnonymousClass20() {
            super(1, MediaContentBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final MediaContentBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new MediaContentBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.FlowChatBlueprintFactory$create$22, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class AnonymousClass22 extends FunctionReferenceImpl implements Function1<g, FlowThreadForwardContentBlock> {
        public static final AnonymousClass22 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass22();
        }

        public AnonymousClass22() {
            super(1, FlowThreadForwardContentBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final FlowThreadForwardContentBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new FlowThreadForwardContentBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.FlowChatBlueprintFactory$create$23, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class AnonymousClass23 extends FunctionReferenceImpl implements Function1<g, FlowThreadForwardHeaderBlock> {
        public static final AnonymousClass23 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass23();
        }

        public AnonymousClass23() {
            super(1, FlowThreadForwardHeaderBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final FlowThreadForwardHeaderBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new FlowThreadForwardHeaderBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.FlowChatBlueprintFactory$create$24, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class AnonymousClass24 extends FunctionReferenceImpl implements Function1<g, FlowThreadForwardExposureBlock> {
        public static final AnonymousClass24 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass24();
        }

        public AnonymousClass24() {
            super(1, FlowThreadForwardExposureBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final FlowThreadForwardExposureBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new FlowThreadForwardExposureBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.FlowChatBlueprintFactory$create$25, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class AnonymousClass25 extends FunctionReferenceImpl implements Function1<g, FlowProfileContentBlock> {
        public static final AnonymousClass25 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass25();
        }

        public AnonymousClass25() {
            super(1, FlowProfileContentBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final FlowProfileContentBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new FlowProfileContentBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.FlowChatBlueprintFactory$create$26, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class AnonymousClass26 extends FunctionReferenceImpl implements Function1<g, FlowCalendarContentBlock> {
        public static final AnonymousClass26 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass26();
        }

        public AnonymousClass26() {
            super(1, FlowCalendarContentBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final FlowCalendarContentBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new FlowCalendarContentBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.FlowChatBlueprintFactory$create$27, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class AnonymousClass27 extends FunctionReferenceImpl implements Function1<g, FlowVideoChatContentBlock> {
        public static final AnonymousClass27 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass27();
        }

        public AnonymousClass27() {
            super(1, FlowVideoChatContentBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final FlowVideoChatContentBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new FlowVideoChatContentBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.FlowChatBlueprintFactory$create$28, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class AnonymousClass28 extends FunctionReferenceImpl implements Function1<g, FlowRedPacketContentBlock> {
        public static final AnonymousClass28 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass28();
        }

        public AnonymousClass28() {
            super(1, FlowRedPacketContentBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final FlowRedPacketContentBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new FlowRedPacketContentBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.FlowChatBlueprintFactory$create$29, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class AnonymousClass29 extends FunctionReferenceImpl implements Function1<g, FlowTodoContentBlock> {
        public static final AnonymousClass29 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass29();
        }

        public AnonymousClass29() {
            super(1, FlowTodoContentBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final FlowTodoContentBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new FlowTodoContentBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.FlowChatBlueprintFactory$create$3, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<g, FlowRecalledSystemContentBlock> {
        public static final AnonymousClass3 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass3();
        }

        public AnonymousClass3() {
            super(1, FlowRecalledSystemContentBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final FlowRecalledSystemContentBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new FlowRecalledSystemContentBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.FlowChatBlueprintFactory$create$30, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class AnonymousClass30 extends FunctionReferenceImpl implements Function1<g, FlowAudioContentBlock> {
        public static final AnonymousClass30 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass30();
        }

        public AnonymousClass30() {
            super(1, FlowAudioContentBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final FlowAudioContentBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new FlowAudioContentBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.FlowChatBlueprintFactory$create$31, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class AnonymousClass31 extends FunctionReferenceImpl implements Function1<g, FlowMessageStatusBlock> {
        public static final AnonymousClass31 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass31();
        }

        public AnonymousClass31() {
            super(1, FlowMessageStatusBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final FlowMessageStatusBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new FlowMessageStatusBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.FlowChatBlueprintFactory$create$32, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class AnonymousClass32 extends FunctionReferenceImpl implements Function1<g, DLPBlock> {
        public static final AnonymousClass32 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass32();
        }

        public AnonymousClass32() {
            super(1, DLPBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final DLPBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new DLPBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.FlowChatBlueprintFactory$create$33, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class AnonymousClass33 extends FunctionReferenceImpl implements Function1<g, CotEntryBlock> {
        public static final AnonymousClass33 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass33();
        }

        public AnonymousClass33() {
            super(1, CotEntryBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final CotEntryBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new CotEntryBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.FlowChatBlueprintFactory$create$34, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class AnonymousClass34 extends FunctionReferenceImpl implements Function1<g, MessageReplyCountBlock> {
        public static final AnonymousClass34 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass34();
        }

        public AnonymousClass34() {
            super(1, MessageReplyCountBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final MessageReplyCountBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new MessageReplyCountBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.FlowChatBlueprintFactory$create$35, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class AnonymousClass35 extends FunctionReferenceImpl implements Function1<g, SysChatGuideContentBlock> {
        public static final AnonymousClass35 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass35();
        }

        public AnonymousClass35() {
            super(1, SysChatGuideContentBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final SysChatGuideContentBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new SysChatGuideContentBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.FlowChatBlueprintFactory$create$36, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class AnonymousClass36 extends FunctionReferenceImpl implements Function1<g, SysRedPacketContentBlock> {
        public static final AnonymousClass36 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass36();
        }

        public AnonymousClass36() {
            super(1, SysRedPacketContentBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final SysRedPacketContentBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new SysRedPacketContentBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.FlowChatBlueprintFactory$create$37, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class AnonymousClass37 extends FunctionReferenceImpl implements Function1<g, MultiSelectBlock> {
        public static final AnonymousClass37 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass37();
        }

        public AnonymousClass37() {
            super(1, MultiSelectBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final MultiSelectBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new MultiSelectBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.FlowChatBlueprintFactory$create$38, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class AnonymousClass38 extends FunctionReferenceImpl implements Function1<g, ThreadReplyBlock> {
        public static final AnonymousClass38 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass38();
        }

        public AnonymousClass38() {
            super(1, ThreadReplyBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final ThreadReplyBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new ThreadReplyBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.FlowChatBlueprintFactory$create$4, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<g, SystemContentBlock> {
        public static final AnonymousClass4 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass4();
        }

        public AnonymousClass4() {
            super(1, SystemContentBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final SystemContentBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new SystemContentBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.FlowChatBlueprintFactory$create$6, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class AnonymousClass6 extends AdaptedFunctionReference implements Function1<g, igb.a> {
        public static final AnonymousClass6 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass6();
        }

        public AnonymousClass6() {
            super(1, igb.a.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;Lcom/ss/android/lark/chat/chatwindow/chat/message/cellv2/block/TextContentBlock;)V", 0);
        }

        public final igb.a invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new igb.a(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.FlowChatBlueprintFactory$create$7, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class AnonymousClass7 extends FunctionReferenceImpl implements Function1<g, ImageContentBlock> {
        public static final AnonymousClass7 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass7();
        }

        public AnonymousClass7() {
            super(1, ImageContentBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final ImageContentBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new ImageContentBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.FlowChatBlueprintFactory$create$8, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class AnonymousClass8 extends FunctionReferenceImpl implements Function1<g, UrlPreviewBlock> {
        public static final AnonymousClass8 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass8();
        }

        public AnonymousClass8() {
            super(1, UrlPreviewBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final UrlPreviewBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new UrlPreviewBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.message.FlowChatBlueprintFactory$create$9, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class AnonymousClass9 extends FunctionReferenceImpl implements Function1<g, com.ss.android.lark.flow.chat.message.block.a> {
        public static final AnonymousClass9 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass9();
        }

        public AnonymousClass9() {
            super(1, com.ss.android.lark.flow.chat.message.block.a.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final com.ss.android.lark.flow.chat.message.block.a invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new com.ss.android.lark.flow.chat.message.block.a(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX WARN: Type inference failed for: r4v8, types: [com.ss.android.lark.flow.chat.message.FlowChatBlueprintFactory$create$39$1$1, java.lang.Object] */
    public final com.ss.android.lark.blueprint.d create() {
        Map<ImExtensionType, List<Class<?>>> r0 = com.ss.android.lark.im.base.d.a;
        List r1 = com.ss.android.lark.im.base.d.b(ImExtensionType.MESSAGE_CELL, xya.a.class);
        Function3<m2b.a, List<? extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.open.a<?, ?, ?>>, List<? extends xya.a>, o<y6b.a<?>>> r2 = this.h;
        if (r2 == null) goto L6;
        o r3 = (o) r2.invoke(this.a, this.k, r1);
        if (r3 == null) goto L6;
    L7:
        com.ss.android.lark.blueprint.d.a r4 = new com.ss.android.lark.blueprint.d.a(this.a.getContext());
        r4.f = 0;
        Intrinsics.checkNotNullParameter(r3, "cellMapper");
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r4.e = r3;
        h3b.b.b r5 = new h3b.b.b();
        Intrinsics.checkNotNullParameter(r5, "cellFactory");
        vza.e r6 = r4.b;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r5, "cellFactory");
        r6.a.put(r5.b(), r5);
        r4.b(new h.a());
        r4.b(new com.ss.android.lark.flow.chat.message.layout.b.a());
        r4.b(new com.ss.android.lark.flow.chat.message.layout.f.a());
        r4.b(new com.ss.android.lark.flow.chat.message.layout.d.a());
        r4.b(new com.ss.android.lark.flow.chat.message.layout.g.a());
        r4.b(new com.ss.android.lark.flow.chat.message.layout.o.a());
        r4.b(new com.ss.android.lark.flow.chat.message.layout.e.a());
        r4.b(new l3b.b.a(this.i));
        r4.b(new l3b.e.a(this.i));
        r4.b(new com.ss.android.lark.flow.chat.message.layout.d.c());
        r4.b(new com.ss.android.lark.flow.chat.message.layout.b.C0027b());
        r4.b(new com.ss.android.lark.flow.chat.message.layout.f.b());
        r4.b(new com.ss.android.lark.flow.chat.message.layout.d.b());
        r4.b(new com.ss.android.lark.flow.chat.message.layout.g.b());
        r4.b(new com.ss.android.lark.flow.chat.message.layout.o.b());
        r4.b(new l3b.b.b(this.i));
        r4.b(new l3b.e.b(this.i));
        r4.b(new com.ss.android.lark.flow.chat.message.layout.d.C0028d());
        r4.b(new xhb.b.a());
        r4.b(new xhb.a.C0344a());
        r4.b(new i.a());
        r4.b(new i.b());
        r4.b(new l.a());
        r4.b(new l.b());
        r4.b(new com.ss.android.lark.flow.chat.message.layout.e.b());
        r4.a(IMMessageKeys.Blocks.FLOW_UNKNOWN_CONTENT, AnonymousClass1.INSTANCE);
        r4.a(IMMessageKeys.Blocks.RECALLED_CONTENT, AnonymousClass2.INSTANCE);
        r4.a(IMMessageKeys.Blocks.RECALLED_SYSTEM_CONTENT, AnonymousClass3.INSTANCE);
        r4.a(IMMessageKeys.Blocks.SYSTEM_CONTENT, AnonymousClass4.INSTANCE);
        r4.a(IMMessageKeys.Blocks.TEXT_CONTENT, AnonymousClass6.INSTANCE);
        r4.a(IMMessageKeys.Blocks.IMAGE_CONTENT, AnonymousClass7.INSTANCE);
        r4.a(IMMessageKeys.Blocks.URL_PREVIEW, AnonymousClass8.INSTANCE);
        r4.a(IMMessageKeys.Blocks.AVATAR, AnonymousClass9.INSTANCE);
        r4.a(IMMessageKeys.Blocks.USERNAME, AnonymousClass10.INSTANCE);
        r4.a(IMMessageKeys.Blocks.REACTION, AnonymousClass11.INSTANCE);
        r4.a(IMMessageKeys.Blocks.REPLY_IN_THREAD_EXPOSURE, AnonymousClass12.INSTANCE);
        r4.a(IMMessageKeys.Blocks.URL_PREVIEW_CONTENT, AnonymousClass13.INSTANCE);
        r4.a(IMMessageKeys.Blocks.SHARE_GROUP_CHAT_CONTENT, AnonymousClass14.INSTANCE);
        r4.a(IMMessageKeys.Blocks.STICKER_CONTENT, AnonymousClass15.INSTANCE);
        r4.a(IMMessageKeys.Blocks.FILE_CONTENT, AnonymousClass16.INSTANCE);
        r4.a(IMMessageKeys.Blocks.FOLDER_CONTENT, AnonymousClass17.INSTANCE);
        r4.a(IMMessageKeys.Blocks.REPLY, AnonymousClass18.INSTANCE);
        r4.a(IMMessageKeys.Blocks.POST_CONTENT, AnonymousClass19.INSTANCE);
        r4.a(IMMessageKeys.Blocks.MEDIA_CONTENT, AnonymousClass20.INSTANCE);
        r4.a(IMMessageKeys.Blocks.MERGE_FORWARD_CONTENT, AnonymousClass21.INSTANCE);
        r4.a(IMMessageKeys.Blocks.THREAD_FORWARD_CONTENT, AnonymousClass22.INSTANCE);
        r4.a(IMMessageKeys.Blocks.FLOW_THREAD_FORWARD_HEADER, AnonymousClass23.INSTANCE);
        r4.a(IMMessageKeys.Blocks.FLOW_THREAD_FORWARD_EXPOSURE, AnonymousClass24.INSTANCE);
        r4.a(IMMessageKeys.Blocks.FLOW_PROFILE_CONTENT, AnonymousClass25.INSTANCE);
        r4.a(IMMessageKeys.Blocks.FLOW_CALENDAR_CONTENT, AnonymousClass26.INSTANCE);
        r4.a(IMMessageKeys.Blocks.FLOW_VIDEO_CHAT_CONTENT, AnonymousClass27.INSTANCE);
        r4.a(IMMessageKeys.Blocks.FLOW_RED_PACKET_CONTENT, AnonymousClass28.INSTANCE);
        r4.a(IMMessageKeys.Blocks.FLOW_TODO_CONTENT, AnonymousClass29.INSTANCE);
        r4.a(IMMessageKeys.Blocks.AUDIO_CONTENT, AnonymousClass30.INSTANCE);
        r4.a(IMMessageKeys.Blocks.MESSAGE_STATUS, AnonymousClass31.INSTANCE);
        r4.a(IMMessageKeys.Blocks.DLP, AnonymousClass32.INSTANCE);
        r4.a(IMMessageKeys.Blocks.COT_PROCESS, AnonymousClass33.INSTANCE);
        r4.a(IMMessageKeys.Blocks.REPLY_COUNT, AnonymousClass34.INSTANCE);
        r4.a(IMMessageKeys.Blocks.SYS_CHAT_GUIDE, AnonymousClass35.INSTANCE);
        r4.a(IMMessageKeys.Blocks.SYS_RED_PACKET, AnonymousClass36.INSTANCE);
        r4.a(IMMessageKeys.Blocks.MULTI_SELECT, AnonymousClass37.INSTANCE);
        r4.a(IMMessageKeys.Blocks.THREAD_REPLY, AnonymousClass38.INSTANCE);
        Iterator r7 = r1.iterator();
    L9:
        if (r7.hasNext() == false) goto L14;
        Iterator r8 = ((xya.a) r7.next()).b().iterator();
    L12:
        if (r8.hasNext() == false) goto L9;
        wza.b r9 = (wza.b) r8.next();
        Intrinsics.checkNotNullParameter(r9, "blockFactory");
        vza.e r10 = r4.b;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r9, "blockFactory");
        r10.c.put(r9.getKey(), r9);
        goto L12
    L14:
        Iterator<T> r11 = this.j.iterator();
    L16:
        if (r11.hasNext() == false) goto L18;
        final e r12 = (e) r11.next();
        ?? r13 = new FlowChatBlueprintFactory$create$39$1$1(this, r12);
        Intrinsics.checkNotNullParameter(r13, "blockFactory");
        vza.e r14 = r4.b;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r13, "blockFactory");
        r14.c.put(r13.getKey(), r13);
        goto L16
    L18:
        j3b.a r15 = new j3b.a(this.a, this.c, this.d, this.e);
        Intrinsics.checkNotNullParameter(r15, "env");
        vza.d r16 = r4.c;
        r16.getClass();
        Intrinsics.checkNotNullParameter(r15, "env");
        r16.a.put(r15.c(), r15);
        a r17 = new a(this);
        Intrinsics.checkNotNullParameter(r17, "env");
        vza.d r18 = r4.c;
        r18.getClass();
        Intrinsics.checkNotNullParameter(r17, "env");
        r18.a.put(r17.i(), r17);
        b r19 = new b();
        Intrinsics.checkNotNullParameter(r19, "env");
        vza.d r20 = r4.c;
        r20.getClass();
        Intrinsics.checkNotNullParameter(r19, "env");
        r20.a.put(r19.c(), r19);
        c r21 = new c(this);
        Intrinsics.checkNotNullParameter(r21, "env");
        vza.d r22 = r4.c;
        r22.getClass();
        Intrinsics.checkNotNullParameter(r21, "env");
        r22.a.put(r21.c(), r21);
        return new com.ss.android.lark.blueprint.d(r4);
    L6:
        m2b.a r23 = this.a;
        r3 = new FlowChatCellSpecMapper(r23, this.k, w.a(r23).C(), r1);
        goto L7
    }

    public FlowChatBlueprintFactory(m2b.a r2, com.ss.android.lark.flow.chat.page.flow.b r3, f r4, d r5, v4b.c r6, Fragment r7, SceneCoordinateRecyclerView r8, Function3 r9) {
        Intrinsics.checkNotNullParameter(r2, "chatContext");
        Intrinsics.checkNotNullParameter(r3, "onCellClickListener");
        Intrinsics.checkNotNullParameter(r7, "fragment");
        Intrinsics.checkNotNullParameter(r8, "recyclerView");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = new l3b.c();
        List<e<?, ?, ?>> r10 = ChatCoreModule.a().getExtensionDependency().c();
        this.j = r10;
        List<e<?, ?, ?>> r11 = r10;
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        e r14 = (e) r13.next();
        r12.add(new com.ss.android.lark.chat.chatwindow.chat.message.cellv2.open.a(this.a, this.c, r14));
        goto L4
    L6:
        this.k = r12;
    }
}
