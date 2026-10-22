package com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.table;

import android.content.Context;
import android.text.Layout;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class TableUtils {
    public static HashMap<String, HashMap<Integer, Layout>> a;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/data/convert/textprocess/table/TableUtils$CalculateTableLayoutSceneInfo;", "Ljava/io/Serializable;", "messageId", BuildConfig.FLAVOR, "sceneTag", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getMessageId", "()Ljava/lang/String;", "getSceneTag", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "component1", "component2", "copy", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CalculateTableLayoutSceneInfo implements Serializable {
        private final String messageId;
        private final String sceneTag;

        public static /* synthetic */ CalculateTableLayoutSceneInfo copy$default(CalculateTableLayoutSceneInfo r0, String r1, String r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.messageId;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.sceneTag;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.messageId;
        }

        public final String component2() {
            return this.sceneTag;
        }

        public final CalculateTableLayoutSceneInfo copy(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "messageId");
            Intrinsics.checkNotNullParameter(r3, "sceneTag");
            return new CalculateTableLayoutSceneInfo(r2, r3);
        }

        public int hashCode() {
            return (this.messageId.hashCode() * 31) + this.sceneTag.hashCode();
        }

        public String toString() {
            return "calculateTableLayoutSceneInfo(messageId='" + this.messageId + "', sceneTag='" + this.sceneTag + "')";
        }

        public final String getMessageId() {
            return this.messageId;
        }

        public final String getSceneTag() {
            return this.sceneTag;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 == null) goto L8;
            Class<?> r2 = r5.getClass();
        L10:
            if (Intrinsics.areEqual(CalculateTableLayoutSceneInfo.class, r2) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.table.TableUtils.CalculateTableLayoutSceneInfo");
            CalculateTableLayoutSceneInfo r6 = (CalculateTableLayoutSceneInfo) r5;
            if (Intrinsics.areEqual(this.messageId, r6.messageId) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.sceneTag, r6.sceneTag) == true) goto L18;
            return false;
        L18:
            return true;
        L8:
            r2 = null;
            goto L10
        }

        public CalculateTableLayoutSceneInfo(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "messageId");
            Intrinsics.checkNotNullParameter(r3, "sceneTag");
            this.messageId = r2;
            this.sceneTag = r3;
        }
    }

    static {
    }

    @JvmStatic
    public static final void a(RichText r10, b r11, Context r12, w2b.b r13, CalculateTableLayoutSceneInfo r14) {
        Intrinsics.checkNotNullParameter(r11, "processParams");
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r14, "calculateTableLayoutSceneInfo");
        if (r10 != null) goto L5;
        return;
    L5:
        String r0 = r14.getMessageId();
        String r15 = r14.getSceneTag();
        List r1 = r10.getElementIds();
        Map r16 = r10.getElements().getDictionary();
        Intrinsics.checkNotNull(r1);
        Iterator r9 = r1.iterator();
    L7:
        if (r9.hasNext() == false) goto L11;
        String r2 = (String) r9.next();
        RichTextElement r3 = (RichTextElement) r16.get(r2);
        if (r3 == null) goto L7;
        Intrinsics.checkNotNull(r2);
        Intrinsics.checkNotNull(r16);
        b(r2, r3, r16, r0, r15, r13, r11, r12);
        goto L7
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 7281. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public static void b(java.lang.String r27, com.ss.android.lark.widget.richtext.RichTextElement r28, java.util.Map r29, java.lang.String r30, java.lang.String r31, w2b.b r32, com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r33, android.content.Context r34) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000a: INVOKE (r1v0 ?? I:com.ss.android.lark.widget.richtext.RichTextElement$RichTextTag) = (r28v0 com.ss.android.lark.widget.richtext.RichTextElement) VIRTUAL call: com.ss.android.lark.widget.richtext.RichTextElement.getTag():com.ss.android.lark.widget.richtext.RichTextElement$RichTextTag A[DECLARE_VAR] (LINE:134217738) in method: com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.table.TableUtils.b(java.lang.String, com.ss.android.lark.widget.richtext.RichTextElement, java.util.Map, java.lang.String, java.lang.String, w2b.b, com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b, android.content.Context):void, file: /private/tmp/nixiang/classes35.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
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
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 728
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.table.TableUtils.b(java.lang.String, com.ss.android.lark.widget.richtext.RichTextElement, java.util.Map, java.lang.String, java.lang.String, w2b.b, com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b, android.content.Context):void");
    }
}
