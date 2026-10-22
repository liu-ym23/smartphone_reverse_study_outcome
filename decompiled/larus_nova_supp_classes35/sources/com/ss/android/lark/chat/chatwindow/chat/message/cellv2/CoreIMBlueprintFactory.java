package com.ss.android.lark.chat.chatwindow.chat.message.cellv2;

import com.ss.android.lark.biz.im.api.extension.ImExtensionType;
import com.ss.android.lark.blueprint.d;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.AudioContentBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.AvatarBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.CotEntryBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.DLPBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.DingIconBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.EditStatusBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ExcelMessagePermissionBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.FileDetectBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.FolderContentBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ImageContentBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.MediaContentBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.MergeForwardContentBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.MessageDingDescBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.MessagePinInfoBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.MessageReplyCountBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.MessageTimeBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.MultiSelectBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.PostContentBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ReactionBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ReplyBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ReplyInThreadExposureBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ShareGroupChatContentBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.StickerContentBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.SystemContentBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.TextContentBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ThreadForwardContentBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ThreadReplyBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.UnknownContentBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.UrlPreviewBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.UrlPreviewContentBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.UsernameBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file.FileContentBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.recall.RecalledContentBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.recall.RecalledSystemContentBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.sys.SysChatGuideContentBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.sys.SysRedPacketContentBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.z;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class CoreIMBlueprintFactory implements q2b.a {

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.CoreIMBlueprintFactory$create$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<g, UnknownContentBlock> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(1, UnknownContentBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final UnknownContentBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new UnknownContentBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.CoreIMBlueprintFactory$create$10, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass10 extends FunctionReferenceImpl implements Function1<g, ReactionBlock> {
        public static final AnonymousClass10 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass10();
        }

        public AnonymousClass10() {
            super(1, ReactionBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final ReactionBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new ReactionBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.CoreIMBlueprintFactory$create$11, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass11 extends FunctionReferenceImpl implements Function1<g, ReplyInThreadExposureBlock> {
        public static final AnonymousClass11 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass11();
        }

        public AnonymousClass11() {
            super(1, ReplyInThreadExposureBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final ReplyInThreadExposureBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new ReplyInThreadExposureBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.CoreIMBlueprintFactory$create$12, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass12 extends FunctionReferenceImpl implements Function1<g, UrlPreviewContentBlock> {
        public static final AnonymousClass12 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass12();
        }

        public AnonymousClass12() {
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

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.CoreIMBlueprintFactory$create$13, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass13 extends FunctionReferenceImpl implements Function1<g, ShareGroupChatContentBlock> {
        public static final AnonymousClass13 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass13();
        }

        public AnonymousClass13() {
            super(1, ShareGroupChatContentBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final ShareGroupChatContentBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new ShareGroupChatContentBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.CoreIMBlueprintFactory$create$14, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass14 extends FunctionReferenceImpl implements Function1<g, StickerContentBlock> {
        public static final AnonymousClass14 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass14();
        }

        public AnonymousClass14() {
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

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.CoreIMBlueprintFactory$create$15, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass15 extends FunctionReferenceImpl implements Function1<g, FileContentBlock> {
        public static final AnonymousClass15 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass15();
        }

        public AnonymousClass15() {
            super(1, FileContentBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final FileContentBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new FileContentBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.CoreIMBlueprintFactory$create$16, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass16 extends FunctionReferenceImpl implements Function1<g, FolderContentBlock> {
        public static final AnonymousClass16 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass16();
        }

        public AnonymousClass16() {
            super(1, FolderContentBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final FolderContentBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new FolderContentBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.CoreIMBlueprintFactory$create$17, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass17 extends FunctionReferenceImpl implements Function1<g, ReplyBlock> {
        public static final AnonymousClass17 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass17();
        }

        public AnonymousClass17() {
            super(1, ReplyBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final ReplyBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new ReplyBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.CoreIMBlueprintFactory$create$18, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass18 extends FunctionReferenceImpl implements Function1<g, PostContentBlock> {
        public static final AnonymousClass18 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass18();
        }

        public AnonymousClass18() {
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

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.CoreIMBlueprintFactory$create$19, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass19 extends FunctionReferenceImpl implements Function1<g, MediaContentBlock> {
        public static final AnonymousClass19 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass19();
        }

        public AnonymousClass19() {
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

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.CoreIMBlueprintFactory$create$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
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

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.CoreIMBlueprintFactory$create$20, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass20 extends FunctionReferenceImpl implements Function1<g, MergeForwardContentBlock> {
        public static final AnonymousClass20 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass20();
        }

        public AnonymousClass20() {
            super(1, MergeForwardContentBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final MergeForwardContentBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new MergeForwardContentBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.CoreIMBlueprintFactory$create$21, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass21 extends FunctionReferenceImpl implements Function1<g, ThreadForwardContentBlock> {
        public static final AnonymousClass21 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass21();
        }

        public AnonymousClass21() {
            super(1, ThreadForwardContentBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final ThreadForwardContentBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new ThreadForwardContentBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.CoreIMBlueprintFactory$create$22, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass22 extends FunctionReferenceImpl implements Function1<g, AudioContentBlock> {
        public static final AnonymousClass22 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass22();
        }

        public AnonymousClass22() {
            super(1, AudioContentBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final AudioContentBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new AudioContentBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.CoreIMBlueprintFactory$create$23, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass23 extends FunctionReferenceImpl implements Function1<g, z> {
        public static final AnonymousClass23 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass23();
        }

        public AnonymousClass23() {
            super(1, z.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final z invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new z(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.CoreIMBlueprintFactory$create$24, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass24 extends FunctionReferenceImpl implements Function1<g, MessageTimeBlock> {
        public static final AnonymousClass24 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass24();
        }

        public AnonymousClass24() {
            super(1, MessageTimeBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final MessageTimeBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new MessageTimeBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.CoreIMBlueprintFactory$create$25, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass25 extends FunctionReferenceImpl implements Function1<g, MessageReplyCountBlock> {
        public static final AnonymousClass25 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass25();
        }

        public AnonymousClass25() {
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

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.CoreIMBlueprintFactory$create$26, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass26 extends FunctionReferenceImpl implements Function1<g, MessagePinInfoBlock> {
        public static final AnonymousClass26 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass26();
        }

        public AnonymousClass26() {
            super(1, MessagePinInfoBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final MessagePinInfoBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new MessagePinInfoBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.CoreIMBlueprintFactory$create$27, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass27 extends FunctionReferenceImpl implements Function1<g, MessageDingDescBlock> {
        public static final AnonymousClass27 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass27();
        }

        public AnonymousClass27() {
            super(1, MessageDingDescBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final MessageDingDescBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new MessageDingDescBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.CoreIMBlueprintFactory$create$28, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass28 extends FunctionReferenceImpl implements Function1<g, DingIconBlock> {
        public static final AnonymousClass28 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass28();
        }

        public AnonymousClass28() {
            super(1, DingIconBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final DingIconBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new DingIconBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.CoreIMBlueprintFactory$create$29, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass29 extends FunctionReferenceImpl implements Function1<g, SysChatGuideContentBlock> {
        public static final AnonymousClass29 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass29();
        }

        public AnonymousClass29() {
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

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.CoreIMBlueprintFactory$create$3, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<g, RecalledSystemContentBlock> {
        public static final AnonymousClass3 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass3();
        }

        public AnonymousClass3() {
            super(1, RecalledSystemContentBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final RecalledSystemContentBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new RecalledSystemContentBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.CoreIMBlueprintFactory$create$30, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass30 extends FunctionReferenceImpl implements Function1<g, SysRedPacketContentBlock> {
        public static final AnonymousClass30 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass30();
        }

        public AnonymousClass30() {
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

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.CoreIMBlueprintFactory$create$31, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass31 extends FunctionReferenceImpl implements Function1<g, MultiSelectBlock> {
        public static final AnonymousClass31 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass31();
        }

        public AnonymousClass31() {
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

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.CoreIMBlueprintFactory$create$32, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
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

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.CoreIMBlueprintFactory$create$33, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass33 extends FunctionReferenceImpl implements Function1<g, FileDetectBlock> {
        public static final AnonymousClass33 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass33();
        }

        public AnonymousClass33() {
            super(1, FileDetectBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final FileDetectBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new FileDetectBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.CoreIMBlueprintFactory$create$34, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass34 extends FunctionReferenceImpl implements Function1<g, EditStatusBlock> {
        public static final AnonymousClass34 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass34();
        }

        public AnonymousClass34() {
            super(1, EditStatusBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final EditStatusBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new EditStatusBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.CoreIMBlueprintFactory$create$35, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass35 extends FunctionReferenceImpl implements Function1<g, ThreadReplyBlock> {
        public static final AnonymousClass35 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass35();
        }

        public AnonymousClass35() {
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

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.CoreIMBlueprintFactory$create$36, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass36 extends FunctionReferenceImpl implements Function1<g, ExcelMessagePermissionBlock> {
        public static final AnonymousClass36 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass36();
        }

        public AnonymousClass36() {
            super(1, ExcelMessagePermissionBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final ExcelMessagePermissionBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new ExcelMessagePermissionBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.CoreIMBlueprintFactory$create$37, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass37 extends FunctionReferenceImpl implements Function1<g, CotEntryBlock> {
        public static final AnonymousClass37 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass37();
        }

        public AnonymousClass37() {
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

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.CoreIMBlueprintFactory$create$4, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
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

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.CoreIMBlueprintFactory$create$5, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<g, TextContentBlock> {
        public static final AnonymousClass5 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass5();
        }

        public AnonymousClass5() {
            super(1, TextContentBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final TextContentBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new TextContentBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.CoreIMBlueprintFactory$create$6, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass6 extends FunctionReferenceImpl implements Function1<g, ImageContentBlock> {
        public static final AnonymousClass6 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass6();
        }

        public AnonymousClass6() {
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

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.CoreIMBlueprintFactory$create$7, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass7 extends FunctionReferenceImpl implements Function1<g, UrlPreviewBlock> {
        public static final AnonymousClass7 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass7();
        }

        public AnonymousClass7() {
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

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.CoreIMBlueprintFactory$create$8, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass8 extends FunctionReferenceImpl implements Function1<g, AvatarBlock> {
        public static final AnonymousClass8 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass8();
        }

        public AnonymousClass8() {
            super(1, AvatarBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final AvatarBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new AvatarBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.CoreIMBlueprintFactory$create$9, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass9 extends FunctionReferenceImpl implements Function1<g, UsernameBlock> {
        public static final AnonymousClass9 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass9();
        }

        public AnonymousClass9() {
            super(1, UsernameBlock.class, "<init>", "<init>(Lcom/ss/android/lark/blueprint/BlueprintContext;)V", 0);
        }

        public final UsernameBlock invoke(g r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return new UsernameBlock(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((g) r1);
        }
    }

    @Override // q2b.a
    public d create() {
        Map r0 = com.ss.android.lark.im.base.d.a;
        com.ss.android.lark.im.base.d.b(ImExtensionType.MESSAGE_CELL, xya.a.class);
        throw null;
    }
}
