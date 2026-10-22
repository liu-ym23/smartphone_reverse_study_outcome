package com.larus.bmhome.chat.doc;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.IFlowTtsClientService;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.home.impl.sdk.n1;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ArtifactBlock;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.LarkConnectorArtifactService;
import com.larus.utils.f;
import com.larus.utils.logger.FLogger;
import com.larus.utils.p0;
import com.larus.utils.y;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import vd9.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class DocumentMessageProcessor {
    public static Message a;
    public static final DocumentMessageProcessor$map$1 b = null;
    public static final String c = null;
    public static Handler d;
    public static final StateFlowImpl e = null;
    public static final StateFlowImpl f = null;

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.bmhome.chat.doc.DocumentMessageProcessor$map$1] */
    static {
        final int r1 = DoraCallStateCode.DORA_OB_USER_END;
        b = new DocumentMessageProcessor$map$1(r1);
        c = "DocumentMessageProcessor";
        StateFlowImpl r0 = j1.a(new Pair(Boolean.FALSE, ""));
        e = r0;
        f = r0;
    }

    public static void a(boolean r23, String r24, Message r25, Context r26, boolean r27) {
        String r1 = r24;
        AudioServiceDelegate r0 = AudioServiceDelegate.a;
        if (r0 == null) goto L9;
        List r2 = r0.I();
        if (r2 == null) goto L9;
        if ((!r2.isEmpty()) != true) goto L9;
        boolean r3 = true;
    L10:
        IFlowSdkDepend r4 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r4 == null) goto L15;
        r4.N();
        if (n1.a.w() == true) goto L15;
        boolean r5 = true;
    L16:
        if (r5 == false) goto L78;
        if (r3 == true) goto L78;
        if (r27 == false) goto L78;
        FLogger.a.i(c, "jumped it" + r1);
        Map r6 = r25.getExt();
        Integer r18 = null;
        if (r6 == null) goto L22;
        String r7 = (String) r6.get("doc_render_mode");
    L24:
        if (Intrinsics.areEqual(r7, "1") == true) goto L88;
        Intrinsics.checkNotNullParameter(r25, "<this>");
        Iterator r8 = r.a(r25).iterator();
    L27:
        if (r8.hasNext() == false) goto L34;
        Object r9 = r8.next();
        if (((Block) r9).getBlockType() != BlockType.BLOCK_TYPE_ARTIFACT.getValue()) goto L31;
        boolean r10 = true;
    L32:
        if (r10 == false) goto L27;
    L35:
        Block r11 = (Block) r9;
        if (r11 == null) goto L40;
        BlockContent r12 = r11.getContent();
        if (r12 == null) goto L40;
        ArtifactBlock r19 = r12.getDocBlock();
    L41:
        int r13 = p0.a;
        if (r19 == null) goto L44;
        String r14 = r19.getResourceId();
    L45:
        String r15 = p0.a(r14);
        if (r15 != null) goto L48;
        String r16 = r1;
    L50:
        if (cr9.b.a(r16) == false) goto L54;
        FLogger.a.i(c, "skip auto jump for local Office resource");
        return;
    L54:
        if (r19 != null) goto L56;
        ArtifactBlock r17 = new ArtifactBlock(r24, null, null, null, null, null, null, null, null, null, 3, null, null, null, 15358, null);
    L57:
        IFlowTtsClientService.a.getClass();
        IFlowTtsClientService.a.a().n(true);
        if (LarkConnectorArtifactService.a.a(r26, r25, r17) == false) goto L60;
        return;
    L60:
        IFlowSdkDepend r20 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r20 == null) goto L89;
        r20.N();
        n1 r21 = n1.a;
        Pair[] r22 = new Pair[6];
        r22[0] = TuplesKt.to("key_doc_id", r16);
        if (r19 == null) goto L65;
        String r28 = r19.getArtifactMetaId();
    L66:
        r22[1] = TuplesKt.to("artifact_meta_id", r28);
        if (r19 == null) goto L69;
        String r29 = r19.getArtifactVersionId();
    L70:
        r22[2] = TuplesKt.to("key_artifact_version_id", r29);
        if (r19 == null) goto L73;
        r18 = r19.getResourceVersion();
    L73:
        r22[3] = TuplesKt.to("key_resource_version", r18);
        r22[4] = TuplesKt.to("key_doc_enter_from", "send_message_create");
        r22[5] = TuplesKt.to("argMessageId", r25.getMessageId());
        Bundle r30 = f.c(r22);
        if (r23 == false) goto L76;
        String r31 = "ai_doc_list";
    L77:
        r21.x(r26, r30, r31);
        return;
    L76:
        r31 = "chat";
        goto L77
    L69:
        r29 = null;
        goto L70
    L65:
        r28 = null;
        goto L66
    L89:
        return;
    L56:
        r17 = r19;
        goto L57
    L48:
        r16 = r15;
        goto L50
    L44:
        r14 = null;
    L40:
        r19 = null;
        goto L41
    L31:
        r10 = false;
        goto L32
    L34:
        r9 = null;
        goto L35
    L88:
        return;
    L22:
        r7 = null;
    L78:
        FLogger.a.i(c, "close float chat fragment");
        StateFlowImpl r32 = e;
        Boolean r33 = Boolean.TRUE;
        if (r1 != null) goto L81;
        r1 = "";
    L81:
        r32.setValue(new Pair(r33, r1));
        SoftReference r34 = y.a;
        Runnable r35 = new a();
        Intrinsics.checkNotNullParameter(r35, "action");
        y.d(r35, 100);
        return;
    L15:
        r5 = false;
    L9:
        r3 = false;
        goto L10
    }
}
