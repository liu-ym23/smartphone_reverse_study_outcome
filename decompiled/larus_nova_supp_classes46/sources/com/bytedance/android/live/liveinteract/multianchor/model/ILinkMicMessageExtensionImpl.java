package com.bytedance.android.live.liveinteract.multianchor.model;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo;
import com.bytedance.android.live.liveinteract.plantform.model.e0;
import com.bytedance.android.live.liveinteract.plantform.model.j0;
import com.bytedance.android.live.liveinteract.plantform.model.q0;
import com.bytedance.android.livesdk.chatroom.model.t;
import com.bytedance.android.livesdk.chatroom.model.v;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.bridge.j1;
import com.bytedance.android.livesdk.link.model.bridge.u1;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.link.model.c6;
import com.bytedance.android.livesdk.message.model.c8;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.model.live.linker.IBanUser;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u009c\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u0012\u0012\u0007\u0010ò\u0001\u001a\u00020\u0002¢\u0006\u0006\bó\u0001\u0010ô\u0001J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tJ\u0011\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010\u000f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0001R\u0014\u0010\u0012\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0014\u0010\u001c\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001bR\u0014\u0010 \u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0011R$\u0010%\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00138V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010$R\u0016\u0010'\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0011R$\u0010+\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u00198V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u0015R\u0016\u00101\u001a\u0004\u0018\u00010.8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0014\u00105\u001a\u0002028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0014\u00107\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\u0011R\u0016\u0010;\u001a\u0004\u0018\u0001088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0016\u0010?\u001a\u0004\u0018\u00010<8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0014\u0010A\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b@\u0010\u001bR\u0014\u0010C\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010\u0011R(\u0010G\u001a\u0004\u0018\u00010\u000b2\b\u0010!\u001a\u0004\u0018\u00010\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bD\u0010\u0011\"\u0004\bE\u0010FR(\u0010J\u001a\u0004\u0018\u00010\u000b2\b\u0010!\u001a\u0004\u0018\u00010\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bH\u0010\u0011\"\u0004\bI\u0010FR(\u0010M\u001a\u0004\u0018\u00010\u000b2\b\u0010!\u001a\u0004\u0018\u00010\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bK\u0010\u0011\"\u0004\bL\u0010FR\u0016\u0010Q\u001a\u0004\u0018\u00010N8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bO\u0010PR(\u0010T\u001a\u0004\u0018\u00010\u000b2\b\u0010!\u001a\u0004\u0018\u00010\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bR\u0010\u0011\"\u0004\bS\u0010FR(\u0010W\u001a\u0004\u0018\u00010\u000b2\b\u0010!\u001a\u0004\u0018\u00010\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bU\u0010\u0011\"\u0004\bV\u0010FR(\u0010]\u001a\u0004\u0018\u00010X2\b\u0010!\u001a\u0004\u0018\u00010X8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R(\u0010c\u001a\u0004\u0018\u00010^2\b\u0010!\u001a\u0004\u0018\u00010^8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR$\u0010f\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00138V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bd\u0010\u0015\"\u0004\be\u0010$R(\u0010l\u001a\u0004\u0018\u00010g2\b\u0010!\u001a\u0004\u0018\u00010g8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u0014\u0010n\u001a\u00020\u000b8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bm\u0010\u0011R\u0014\u0010p\u001a\u00020\u000b8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bo\u0010\u0011R\u0016\u0010r\u001a\u0004\u0018\u00010\u000b8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bq\u0010\u0011R\u0016\u0010v\u001a\u0004\u0018\u00010s8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bt\u0010uR\u0014\u0010x\u001a\u00020\u000b8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bw\u0010\u0011R\u0016\u0010|\u001a\u0004\u0018\u00010y8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bz\u0010{R\u0017\u0010\u0080\u0001\u001a\u0004\u0018\u00010}8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b~\u0010\u007fR\u001b\u0010\u0083\u0001\u001a\u00070gj\u0003`\u0081\u00018\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0082\u0001\u0010iR\u0018\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u000b8\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0084\u0001\u0010\u0011R\u001b\u0010\u0088\u0001\u001a\u00070\u0019j\u0003`\u0086\u00018\u0016X\u0097\u0005¢\u0006\u0007\u001a\u0005\b\u0087\u0001\u0010\u001bR$\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0016@\u0016X\u0096\u000f¢\u0006\u0010\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001R\"\u0010\u0094\u0001\u001a\u00030\u008f\u00018\u0016@\u0016X\u0096\u000f¢\u0006\u0010\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0016\u0010\u0096\u0001\u001a\u00020\u00138\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0095\u0001\u0010\u0015R\u0016\u0010\u0098\u0001\u001a\u00020\u000b8\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0097\u0001\u0010\u0011R\u0018\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u000b8\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0099\u0001\u0010\u0011R\u001a\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009b\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001R\u0016\u0010 \u0001\u001a\u00020\u000b8\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u009f\u0001\u0010\u0011R\u001f\u0010£\u0001\u001a\u00020\u00138\u0016@\u0016X\u0096\u000f¢\u0006\u000e\u001a\u0005\b¡\u0001\u0010\u0015\"\u0005\b¢\u0001\u0010$R\u001a\u0010§\u0001\u001a\u0005\u0018\u00010¤\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\b¥\u0001\u0010¦\u0001R!\u0010¬\u0001\u001a\f\u0018\u00010¨\u0001j\u0005\u0018\u0001`©\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\bª\u0001\u0010«\u0001R\u001a\u0010°\u0001\u001a\u0005\u0018\u00010\u00ad\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\b®\u0001\u0010¯\u0001R!\u0010±\u0001\u001a\u00020\r8\u0016@\u0016X\u0096\u000f¢\u0006\u0010\u001a\u0006\b±\u0001\u0010²\u0001\"\u0006\b³\u0001\u0010´\u0001R\u001a\u0010¸\u0001\u001a\u0005\u0018\u00010µ\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\b¶\u0001\u0010·\u0001R\u0016\u0010º\u0001\u001a\u00020\u00138\u0016X\u0097\u0005¢\u0006\u0007\u001a\u0005\b¹\u0001\u0010\u0015R\u001f\u0010½\u0001\u001a\u00020\u00138\u0016@\u0016X\u0096\u000f¢\u0006\u000e\u001a\u0005\b»\u0001\u0010\u0015\"\u0005\b¼\u0001\u0010$R\u0016\u0010¿\u0001\u001a\u00020\u00198\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\b¾\u0001\u0010\u001bR\u0016\u0010Á\u0001\u001a\u00020\u00138\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\bÀ\u0001\u0010\u0015R!\u0010Æ\u0001\u001a\f\u0012\u0005\u0012\u00030Ã\u0001\u0018\u00010Â\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\bÄ\u0001\u0010Å\u0001R\u001a\u0010Ê\u0001\u001a\u0005\u0018\u00010Ç\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\bÈ\u0001\u0010É\u0001R'\u0010Ï\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u0019\u0012\u0005\u0012\u00030Ì\u0001\u0018\u00010Ë\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\bÍ\u0001\u0010Î\u0001R!\u0010Ó\u0001\u001a\f\u0012\u0005\u0012\u00030Ñ\u0001\u0018\u00010Ð\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\bÒ\u0001\u0010Å\u0001R\u001a\u0010×\u0001\u001a\u0005\u0018\u00010Ô\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\bÕ\u0001\u0010Ö\u0001R\u0016\u0010Ù\u0001\u001a\u00020\u00198\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\bØ\u0001\u0010\u001bR\u0018\u0010Û\u0001\u001a\u0004\u0018\u00010\u000b8\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\bÚ\u0001\u0010\u0011R\u0016\u0010Ý\u0001\u001a\u00020\u00198\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\bÜ\u0001\u0010\u001bR\u001e\u0010ß\u0001\u001a\t\u0012\u0004\u0012\u00020\u00130Â\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\bÞ\u0001\u0010Å\u0001R\u0018\u0010á\u0001\u001a\u0004\u0018\u00010\u000b8\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\bà\u0001\u0010\u0011R\u0016\u0010ã\u0001\u001a\u00020\u000b8\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\bâ\u0001\u0010\u0011R\u0016\u0010å\u0001\u001a\u00020\u000b8\u0016X\u0097\u0005¢\u0006\u0007\u001a\u0005\bä\u0001\u0010\u0011R\u0017\u0010ç\u0001\u001a\u00020\r8\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\bæ\u0001\u0010²\u0001R\u0016\u0010é\u0001\u001a\u00020\u000b8\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\bè\u0001\u0010\u0011R!\u0010ì\u0001\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0096\u000f¢\u0006\u000e\u001a\u0005\bê\u0001\u0010\u0011\"\u0005\bë\u0001\u0010FR\u001b\u0010ï\u0001\u001a\u00070\u0019j\u0003`í\u00018\u0016X\u0097\u0005¢\u0006\u0007\u001a\u0005\bî\u0001\u0010\u001bR\u0016\u0010ñ\u0001\u001a\u00020\u00138\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\bð\u0001\u0010\u0015¨\u0006õ\u0001"}, d2 = {"Lcom/bytedance/android/live/liveinteract/multianchor/model/ILinkMicMessageExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/z0;", "Lcom/bytedance/android/live/liveinteract/multianchor/model/b;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "uid", "", "isFromUser", "isToUser", "getScoreUpdateLogId", "()Ljava/lang/String;", "scoreUpdateLogId", "", "getUpdateMessageFrom", "()I", "updateMessageFrom", "getSwitchPlayMode", "switchPlayMode", "", "getMatchType", "()J", "matchType", "getAnchorLinkMicId", "anchorLinkMicId", "getLiveCoreExtInfo", "liveCoreExtInfo", "value", "getUiLayout", "setUiLayout", "(I)V", "uiLayout", "getReplyPrompts", "replyPrompts", "getScene", "setScene", "(J)V", "scene", "getReplyType", "replyType", "Lcom/bytedance/android/live/liveinteract/plantform/model/e0;", "getMcuContent", "()Lcom/bytedance/android/live/liveinteract/plantform/model/e0;", "mcuContent", "Lcom/bytedance/android/livesdk/chatroom/model/interact/z0;", "getMultiRtcInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/z0;", "multiRtcInfo", "getRtcExtInfo", "rtcExtInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/j1;", "getGuestLinkMicInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/j1;", "guestLinkMicInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/u1;", "getMultiLiveCoreInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/u1;", "multiLiveCoreInfo", "getVersion", "version", "getFunctionType2", "functionType2", "getRivalLinkmicIdStr", "setRivalLinkmicIdStr", "(Ljava/lang/String;)V", "rivalLinkmicIdStr", "getLinkerSessionId", "setLinkerSessionId", "linkerSessionId", "getRemoteLinkerSessionId", "setRemoteLinkerSessionId", "remoteLinkerSessionId", "Lcom/bytedance/android/livesdk/link/model/c6;", "getLinkGameInfo", "()Lcom/bytedance/android/livesdk/link/model/c6;", "linkGameInfo", "getInvitePrompt", "setInvitePrompt", "invitePrompt", "getInviteSubtitle", "setInviteSubtitle", "inviteSubtitle", "Lcom/bytedance/android/live/liveinteract/plantform/model/q0;", "getJoinChannelData", "()Lcom/bytedance/android/live/liveinteract/plantform/model/q0;", "setJoinChannelData", "(Lcom/bytedance/android/live/liveinteract/plantform/model/q0;)V", "joinChannelData", "Lcom/bytedance/android/livesdk/chatroom/model/v;", "getChorusCDNInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/v;", "setChorusCDNInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/v;)V", "chorusCDNInfo", "getPushRtcType", "setPushRtcType", "pushRtcType", "Lcom/bytedance/android/live/base/model/message/m0;", "getCommonData", "()Lcom/bytedance/android/live/base/model/message/m0;", "setCommonData", "(Lcom/bytedance/android/live/base/model/message/m0;)V", "commonData", "get_fromUserId", "_fromUserId", "get_guestId", "_guestId", "getAckMessage", "ackMessage", "Lcom/bytedance/android/live/liveinteract/plantform/model/f;", "getActionSource", "()Lcom/bytedance/android/live/liveinteract/plantform/model/f;", "actionSource", "getAnchorLinkMicIdStr", "anchorLinkMicIdStr", "Lcom/bytedance/android/livesdk/message/linker/b;", "getBackupInfo", "()Lcom/bytedance/android/livesdk/message/linker/b;", "backupInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/IBanUser;", "getBanAnchorInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/IBanUser;", "banAnchorInfo", "Lcom/bytedance/android/live/base/model/message/ICommonMessageDataKt;", "getBaseMessage2", "baseMessage2", "getBizTag", "bizTag", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/ChannelId;", "getChannelId", "channelId", "Lcom/bytedance/android/livesdk/chatroom/model/t;", "getChorusAccompanimentInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/t;", "setChorusAccompanimentInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/t;)V", "chorusAccompanimentInfo", "Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "getClientUIInfo", "()Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "setClientUIInfo", "(Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;)V", "clientUIInfo", "getControlType", "controlType", "getFromUserIdStr", "fromUserIdStr", "getGameBarrageLinkerFinishReason", "gameBarrageLinkerFinishReason", "Lcom/bytedance/android/live/liveinteract/plantform/model/e;", "getGameInviteInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/e;", "gameInviteInfo", "getGetFromUserId", "getFromUserId", "getInitSource", "setInitSource", "initSource", "Lpy/k;", "getInviteImage", "()Lpy/k;", "inviteImage", "Lcom/bytedance/android/live/base/model/message/a5;", "Lcom/bytedance/android/live/base/model/message/ITextKt;", "getInviteMsg", "()Lcom/bytedance/android/live/base/model/message/a5;", "inviteMsg", "Lcom/bytedance/android/livesdk/message/model/c8;", "getInvitorInfo", "()Lcom/bytedance/android/livesdk/message/model/c8;", "invitorInfo", "isSupportCamera", "()Z", "setSupportCamera", "(Z)V", "Lcom/bytedance/android/live/liveinteract/plantform/model/j0;", "getJoinTeamFightInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/j0;", "joinTeamFightInfo", "getKickOutSource", "kickOutSource", "getLayout", "setLayout", "layout", "getLinkDuration", "linkDuration", "getLinkType", "linkType", "", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "getLinkedListUsers", "()Ljava/util/List;", "linkedListUsers", "Lcom/bytedance/android/live/liveinteract/plantform/model/q;", "getLinkerBaseInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/q;", "linkerBaseInfo", "", "Lcom/bytedance/android/livesdk/link/model/bridge/g2;", "getLinkerContentMap", "()Ljava/util/Map;", "linkerContentMap", "", "Lcom/bytedance/android/live/liveinteract/multianchor/model/LinkmicPositionItem;", "getLockedPositions", "lockedPositions", "Lcom/bytedance/android/live/liveinteract/plantform/model/IMessageBoardInfo;", "getMessageBoardInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/IMessageBoardInfo;", "messageBoardInfo", "getMessageId2", "messageId2", "getOpenSource", "openSource", "getPaidCount", "paidCount", "getPlayModes", "playModes", "getPrompts", "prompts", "getSceneLayoutInfo", "sceneLayoutInfo", "getSecFromUserId", "secFromUserId", "getSwitchToSilence", "switchToSilence", "getToUserId", "toUserId", "getTrackingData", "setTrackingData", "trackingData", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getType2", "type2", "getValidScene", "validScene", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/z0;)V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public class ILinkMicMessageExtensionImpl extends ModelExtensionBase<z0, b> implements b, z0 {
    private final /* synthetic */ z0 $$delegate_0;

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public <R extends vh7.e<z0>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public <R extends vh7.e<z0>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public String getAckMessage() {
        return this.$$delegate_0.getAckMessage();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public com.bytedance.android.live.liveinteract.plantform.model.f getActionSource() {
        return this.$$delegate_0.getActionSource();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public String getAnchorLinkMicIdStr() {
        return this.$$delegate_0.getAnchorLinkMicIdStr();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public com.bytedance.android.livesdk.message.linker.b getBackupInfo() {
        return this.$$delegate_0.getBackupInfo();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public IBanUser getBanAnchorInfo() {
        return this.$$delegate_0.getBanAnchorInfo();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public m0 getBaseMessage2() {
        return this.$$delegate_0.getBaseMessage2();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public String getBizTag() {
        return this.$$delegate_0.getBizTag();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public long getChannelId() {
        return this.$$delegate_0.getChannelId();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public t getChorusAccompanimentInfo() {
        return this.$$delegate_0.getChorusAccompanimentInfo();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public ClientUIInfo getClientUIInfo() {
        return this.$$delegate_0.getClientUIInfo();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public m0 getCommonData() {
        return (m0) get(1, b.class);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public int getControlType() {
        return this.$$delegate_0.getControlType();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public String getFromUserIdStr() {
        return this.$$delegate_0.getFromUserIdStr();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public String getGameBarrageLinkerFinishReason() {
        return this.$$delegate_0.getGameBarrageLinkerFinishReason();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public com.bytedance.android.live.liveinteract.plantform.model.e getGameInviteInfo() {
        return this.$$delegate_0.getGameInviteInfo();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public String getGetFromUserId() {
        return this.$$delegate_0.getGetFromUserId();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public int getInitSource() {
        return this.$$delegate_0.getInitSource();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public py.k getInviteImage() {
        return this.$$delegate_0.getInviteImage();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public a5 getInviteMsg() {
        return this.$$delegate_0.getInviteMsg();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public c8 getInvitorInfo() {
        return this.$$delegate_0.getInvitorInfo();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public j0 getJoinTeamFightInfo() {
        return this.$$delegate_0.getJoinTeamFightInfo();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public int getKickOutSource() {
        return this.$$delegate_0.getKickOutSource();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public int getLayout() {
        return this.$$delegate_0.getLayout();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public long getLinkDuration() {
        return this.$$delegate_0.getLinkDuration();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public int getLinkType() {
        return this.$$delegate_0.getLinkType();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public List<com.bytedance.android.livesdk.link.model.bridge.k> getLinkedListUsers() {
        return this.$$delegate_0.getLinkedListUsers();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public com.bytedance.android.live.liveinteract.plantform.model.q getLinkerBaseInfo() {
        return this.$$delegate_0.getLinkerBaseInfo();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public Map<Long, g2> getLinkerContentMap() {
        return this.$$delegate_0.getLinkerContentMap();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public List<LinkmicPositionItem> getLockedPositions() {
        return this.$$delegate_0.getLockedPositions();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public IMessageBoardInfo getMessageBoardInfo() {
        return this.$$delegate_0.getMessageBoardInfo();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public long getMessageId2() {
        return this.$$delegate_0.getMessageId2();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public String getOpenSource() {
        return this.$$delegate_0.getOpenSource();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public long getPaidCount() {
        return this.$$delegate_0.getPaidCount();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public List<Integer> getPlayModes() {
        return this.$$delegate_0.getPlayModes();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public String getPrompts() {
        return this.$$delegate_0.getPrompts();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public String getSceneLayoutInfo() {
        return this.$$delegate_0.getSceneLayoutInfo();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public String getSecFromUserId() {
        return this.$$delegate_0.getSecFromUserId();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public boolean getSwitchToSilence() {
        return this.$$delegate_0.getSwitchToSilence();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public String getToUserId() {
        return this.$$delegate_0.getToUserId();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public String getTrackingData() {
        return this.$$delegate_0.getTrackingData();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public long getType2() {
        return this.$$delegate_0.getType2();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public int getValidScene() {
        return this.$$delegate_0.getValidScene();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public String get_fromUserId() {
        return this.$$delegate_0.get_fromUserId();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public String get_guestId() {
        return this.$$delegate_0.get_guestId();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public boolean isFromUser(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        return this.$$delegate_0.isFromUser(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public boolean isSupportCamera() {
        return this.$$delegate_0.isSupportCamera();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public boolean isToUser(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        return this.$$delegate_0.isToUser(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public void setChorusAccompanimentInfo(t r2) {
        this.$$delegate_0.setChorusAccompanimentInfo(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public void setClientUIInfo(ClientUIInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.$$delegate_0.setClientUIInfo(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public void setInitSource(int r2) {
        this.$$delegate_0.setInitSource(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public void setLayout(int r2) {
        this.$$delegate_0.setLayout(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public void setSupportCamera(boolean r2) {
        this.$$delegate_0.setSupportCamera(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public void setTrackingData(String r2) {
        this.$$delegate_0.setTrackingData(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public long getAnchorLinkMicId() {
        return ((Number) get(4, b.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public v getChorusCDNInfo() {
        return (v) get(103, b.class);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public String getFunctionType2() {
        return (String) get(77, b.class, "");
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public j1 getGuestLinkMicInfo() {
        return (j1) get(85, b.class);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public String getInvitePrompt() {
        return (String) get(97, b.class);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public String getInviteSubtitle() {
        return (String) get(b.TYPE_CANCELED_BY_SERVER, b.class);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public q0 getJoinChannelData() {
        return (q0) get(98, b.class);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public c6 getLinkGameInfo() {
        return (c6) get(95, b.class);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public String getLinkerSessionId() {
        return (String) get(93, b.class);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public String getLiveCoreExtInfo() {
        return (String) get(70, b.class, "");
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public long getMatchType() {
        return ((Number) get(18, b.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public e0 getMcuContent() {
        return (e0) get(86, b.class);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public u1 getMultiLiveCoreInfo() {
        return (u1) get(62, b.class);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public com.bytedance.android.livesdk.chatroom.model.interact.z0 getMultiRtcInfo() {
        return (com.bytedance.android.livesdk.chatroom.model.interact.z0) get(61, b.class, com.bytedance.android.livesdk.chatroom.model.interact.z0.class);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public int getPushRtcType() {
        return ((Number) get(106, b.class, 0)).intValue();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public String getRemoteLinkerSessionId() {
        return (String) get(94, b.class);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public String getReplyPrompts() {
        return (String) get(48, b.class);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public int getReplyType() {
        return ((Number) get(47, b.class, 0)).intValue();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public String getRivalLinkmicIdStr() {
        return (String) get(40, b.class);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public String getRtcExtInfo() {
        return (String) get(32, b.class, "");
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public long getScene() {
        return ((Number) get(43, b.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public String getScoreUpdateLogId() {
        return (String) get(82, b.class, "");
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public int getSwitchPlayMode() {
        return ((Number) get(83, b.class, 0)).intValue();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public int getUiLayout() {
        return ((Number) get(72, b.class, 0)).intValue();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public int getUpdateMessageFrom() {
        return ((Number) get(84, b.class, 0)).intValue();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public long getVersion() {
        return ((Number) get(66, b.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    /* JADX INFO: renamed from: getMultiRtcInfo, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ v1 mo198getMultiRtcInfo() {
        return getMultiRtcInfo();
    }

    public ILinkMicMessageExtensionImpl(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public void setChorusCDNInfo(v r4) {
        set(103, "chorus_cdn_info", b.class, r4);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public void setCommonData(m0 r4) {
        set(1, "common", b.class, r4);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public void setInvitePrompt(String r4) {
        set(97, "invite_prompt", b.class, r4);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public void setInviteSubtitle(String r4) {
        set(b.TYPE_CANCELED_BY_SERVER, "invite_subtitle", b.class, r4);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public void setJoinChannelData(q0 r4) {
        set(98, "join_channel_data", b.class, r4);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public void setLinkerSessionId(String r4) {
        set(93, "linker_session_id", b.class, r4);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public void setPushRtcType(int r4) {
        set(106, "push_rtc_type", b.class, Integer.valueOf(r4));
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public void setRemoteLinkerSessionId(String r4) {
        set(94, "remote_linker_session_id", b.class, r4);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public void setRivalLinkmicIdStr(String r4) {
        set(40, "rival_linkmic_id_str", b.class, r4);
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public void setScene(long r3) {
        set(43, "scene", b.class, Long.valueOf(r3));
    }

    @Override // com.bytedance.android.live.liveinteract.multianchor.model.b
    public void setUiLayout(int r4) {
        set(72, "ui_layout", b.class, Integer.valueOf(r4));
    }
}
