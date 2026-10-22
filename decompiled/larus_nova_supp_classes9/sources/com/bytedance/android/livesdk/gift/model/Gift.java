package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomInteractEmoji;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoDecode;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.data.GiftStruct")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0014\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b^\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\bC\b\u0007\u0018\u0000 \u008b\u00032\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0002\u008c\u0003B\t¢\u0006\u0006\b\u0089\u0003\u0010\u008a\u0003J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0006\u0010\t\u001a\u00020\u0003J\u0006\u0010\n\u001a\u00020\u0003J\u0006\u0010\u000b\u001a\u00020\u0003J\u0006\u0010\f\u001a\u00020\u0003J\u0006\u0010\r\u001a\u00020\u0003R\u0016\u0010\u000e\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u000fR\u0016\u0010\u0018\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u000fR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010\u001bR\u0016\u0010!\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b!\u0010\u0016R\u0016\u0010\"\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u0012R\u0016\u0010#\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b#\u0010\u0012R\u0016\u0010$\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b$\u0010\u000fR(\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b-\u0010\u0016R\u0016\u0010.\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b.\u0010\u000fR\"\u0010/\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0012\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b4\u0010\u0012R\u0018\u00105\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b5\u0010\u001eR\"\u00106\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010\u000f\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0014\u0018\u00010;8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010>\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b>\u0010\u0016R\u0018\u0010?\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b?\u0010\u001bR\"\u0010A\u001a\u0004\u0018\u00010\u00192\b\u0010@\u001a\u0004\u0018\u00010\u00198\u0006@GX\u0087\u000e¢\u0006\u0006\n\u0004\bA\u0010\u001bR\u0018\u0010B\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bB\u0010\u001bR\u0016\u0010C\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bC\u0010\u0016R\u0016\u0010D\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bD\u0010\u0016R\u0016\u0010E\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bE\u0010\u000fR\u0018\u0010G\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010I\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bI\u0010\u0016R\u0016\u0010J\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bJ\u0010\u0012R$\u0010K\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bK\u0010\u001b\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u0018\u0010P\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bP\u0010\u001bR\u0018\u0010Q\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bQ\u0010\u001bR\u0016\u0010R\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bR\u0010\u000fR\u0016\u0010S\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bS\u0010\u000fR\u0018\u0010T\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bT\u0010\u001bR\u0018\u0010V\u001a\u0004\u0018\u00010U8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010X\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bX\u0010\u001bR\u001c\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00190%8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bY\u0010(R\u001c\u0010[\u001a\b\u0012\u0004\u0012\u00020Z0%8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b[\u0010(R\u0016\u0010\\\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\\\u0010\u000fR$\u0010]\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b]\u0010\u001e\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0016\u0010b\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bb\u0010\u0012R$\u0010c\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bc\u0010\u001b\u001a\u0004\bd\u0010M\"\u0004\be\u0010OR$\u0010f\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bf\u0010\u001e\u001a\u0004\bg\u0010_\"\u0004\bh\u0010aR\"\u0010i\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bi\u0010\u000f\u001a\u0004\bi\u00108\"\u0004\bj\u0010:R\"\u0010k\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bk\u0010\u0016\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR(\u0010p\u001a\b\u0012\u0004\u0012\u00020\u00140%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bp\u0010(\u001a\u0004\bq\u0010*\"\u0004\br\u0010,R(\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00140%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bs\u0010(\u001a\u0004\bt\u0010*\"\u0004\bu\u0010,R$\u0010w\u001a\u0004\u0018\u00010v8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bw\u0010x\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R(\u0010~\u001a\u0004\u0018\u00010}8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0004\b~\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R&\u0010\u0084\u0001\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0084\u0001\u0010\u0016\u001a\u0005\b\u0085\u0001\u0010m\"\u0005\b\u0086\u0001\u0010oR(\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0087\u0001\u0010\u001b\u001a\u0005\b\u0088\u0001\u0010M\"\u0005\b\u0089\u0001\u0010OR*\u0010\u008b\u0001\u001a\u00030\u008a\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u008b\u0001\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001\"\u0006\b\u008f\u0001\u0010\u0090\u0001R&\u0010\u0091\u0001\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0091\u0001\u0010\u0012\u001a\u0005\b\u0092\u0001\u00101\"\u0005\b\u0093\u0001\u00103R\u0018\u0010\u0094\u0001\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0007\n\u0005\b\u0094\u0001\u0010\u000fR\u0018\u0010\u0095\u0001\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0007\n\u0005\b\u0095\u0001\u0010\u000fR&\u0010\u0096\u0001\u001a\u00020\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b\u0096\u0001\u0010\u000f\u001a\u0005\b\u0096\u0001\u00108\"\u0005\b\u0097\u0001\u0010:R/\u0010\u0099\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0098\u0001\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0099\u0001\u0010(\u001a\u0005\b\u009a\u0001\u0010*\"\u0005\b\u009b\u0001\u0010,R,\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009c\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u009d\u0001\u0010\u009e\u0001\u001a\u0006\b\u009f\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R&\u0010£\u0001\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b£\u0001\u0010\u0012\u001a\u0005\b¤\u0001\u00101\"\u0005\b¥\u0001\u00103R,\u0010§\u0001\u001a\u0005\u0018\u00010¦\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b§\u0001\u0010¨\u0001\u001a\u0006\b©\u0001\u0010ª\u0001\"\u0006\b«\u0001\u0010¬\u0001R,\u0010®\u0001\u001a\u0005\u0018\u00010\u00ad\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b®\u0001\u0010¯\u0001\u001a\u0006\b°\u0001\u0010±\u0001\"\u0006\b²\u0001\u0010³\u0001R\u0018\u0010´\u0001\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0007\n\u0005\b´\u0001\u0010\u000fR&\u0010µ\u0001\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bµ\u0001\u0010\u0016\u001a\u0005\b¶\u0001\u0010m\"\u0005\b·\u0001\u0010oR,\u0010¹\u0001\u001a\u0005\u0018\u00010¸\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b¹\u0001\u0010º\u0001\u001a\u0006\b»\u0001\u0010¼\u0001\"\u0006\b½\u0001\u0010¾\u0001R,\u0010À\u0001\u001a\u0005\u0018\u00010¿\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bÀ\u0001\u0010Á\u0001\u001a\u0006\bÂ\u0001\u0010Ã\u0001\"\u0006\bÄ\u0001\u0010Å\u0001R,\u0010Ç\u0001\u001a\u0005\u0018\u00010Æ\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bÇ\u0001\u0010È\u0001\u001a\u0006\bÉ\u0001\u0010Ê\u0001\"\u0006\bË\u0001\u0010Ì\u0001R&\u0010Í\u0001\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÍ\u0001\u0010\u0012\u001a\u0005\bÎ\u0001\u00101\"\u0005\bÏ\u0001\u00103R,\u0010Ñ\u0001\u001a\u0005\u0018\u00010Ð\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bÑ\u0001\u0010Ò\u0001\u001a\u0006\bÓ\u0001\u0010Ô\u0001\"\u0006\bÕ\u0001\u0010Ö\u0001R&\u0010×\u0001\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b×\u0001\u0010\u0012\u001a\u0005\bØ\u0001\u00101\"\u0005\bÙ\u0001\u00103R,\u0010Ú\u0001\u001a\b\u0012\u0004\u0012\u00020\u00140%8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÚ\u0001\u0010(\u001a\u0005\bÛ\u0001\u0010*\"\u0005\bÜ\u0001\u0010,R,\u0010Þ\u0001\u001a\u0005\u0018\u00010Ý\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bÞ\u0001\u0010ß\u0001\u001a\u0006\bà\u0001\u0010á\u0001\"\u0006\bâ\u0001\u0010ã\u0001R&\u0010ä\u0001\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bä\u0001\u0010\u0016\u001a\u0005\bå\u0001\u0010m\"\u0005\bæ\u0001\u0010oR\u0018\u0010ç\u0001\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0007\n\u0005\bç\u0001\u0010\u0016R&\u0010è\u0001\u001a\u00020\u00148\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bè\u0001\u0010\u0016\u001a\u0005\bé\u0001\u0010m\"\u0005\bê\u0001\u0010oR0\u0010î\u0001\u001a\u0005\u0018\u00010Ý\u00012\n\u0010ë\u0001\u001a\u0005\u0018\u00010Ý\u00018V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\bì\u0001\u0010á\u0001\"\u0006\bí\u0001\u0010ã\u0001R\u0016\u0010ð\u0001\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bï\u0001\u00101R(\u0010ò\u0001\u001a\u00020\u00032\u0007\u0010ñ\u0001\u001a\u00020\u00038V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bò\u0001\u00108\"\u0005\bó\u0001\u0010:RB\u0010ø\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00140;2\u0013\u0010ñ\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00140;8V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\bô\u0001\u0010õ\u0001\"\u0006\bö\u0001\u0010÷\u0001R(\u0010û\u0001\u001a\u00020\u00142\u0007\u0010ñ\u0001\u001a\u00020\u00148V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bù\u0001\u0010m\"\u0005\bú\u0001\u0010oR\u0016\u0010ý\u0001\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bü\u0001\u0010MR4\u0010\u0080\u0002\u001a\b\u0012\u0004\u0012\u00020\u00190%2\r\u0010ñ\u0001\u001a\b\u0012\u0004\u0012\u00020\u00190%8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bþ\u0001\u0010*\"\u0005\bÿ\u0001\u0010,R\u0016\u0010\u0082\u0002\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0081\u0002\u0010MR\u0016\u0010\u0084\u0002\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0083\u0002\u0010mR6\u0010\u0087\u0002\u001a\t\u0012\u0005\u0012\u00030\u0098\u00010%2\u000e\u0010ñ\u0001\u001a\t\u0012\u0005\u0012\u00030\u0098\u00010%8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0085\u0002\u0010*\"\u0005\b\u0086\u0002\u0010,R(\u0010\u0088\u0002\u001a\u00020\u00032\u0007\u0010ñ\u0001\u001a\u00020\u00038V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0088\u0002\u00108\"\u0005\b\u0089\u0002\u0010:R\u001a\u0010\u008b\u0002\u001a\u0005\u0018\u00010Ý\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u008a\u0002\u0010á\u0001R(\u0010\u008e\u0002\u001a\u00020\u00102\u0007\u0010ñ\u0001\u001a\u00020\u00108V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u008c\u0002\u00101\"\u0005\b\u008d\u0002\u00103R\u0016\u0010\u0090\u0002\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u008f\u0002\u0010MR\u001a\u0010\u0092\u0002\u001a\u0005\u0018\u00010Ý\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0091\u0002\u0010á\u0001R(\u0010\u0095\u0002\u001a\u00020\u00102\u0007\u0010ñ\u0001\u001a\u00020\u00108V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0093\u0002\u00101\"\u0005\b\u0094\u0002\u00103R(\u0010\u0098\u0002\u001a\u00020\u00142\u0007\u0010ñ\u0001\u001a\u00020\u00148V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0096\u0002\u0010m\"\u0005\b\u0097\u0002\u0010oR4\u0010\u009b\u0002\u001a\b\u0012\u0004\u0012\u00020\u00140%2\r\u0010ñ\u0001\u001a\b\u0012\u0004\u0012\u00020\u00140%8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0099\u0002\u0010*\"\u0005\b\u009a\u0002\u0010,R4\u0010\u009e\u0002\u001a\b\u0012\u0004\u0012\u00020\u00140%2\r\u0010ñ\u0001\u001a\b\u0012\u0004\u0012\u00020\u00140%8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u009c\u0002\u0010*\"\u0005\b\u009d\u0002\u0010,R\u0016\u0010\u009f\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u009f\u0002\u00108R\u0019\u0010¢\u0002\u001a\u0004\u0018\u00010U8VX\u0096\u0004¢\u0006\b\u001a\u0006\b \u0002\u0010¡\u0002R\u0016\u0010£\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b£\u0002\u00108R\u0016\u0010¤\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b¤\u0002\u00108R.\u0010§\u0002\u001a\u0004\u0018\u00010}2\t\u0010ñ\u0001\u001a\u0004\u0018\u00010}8V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b¥\u0002\u0010\u0081\u0001\"\u0006\b¦\u0002\u0010\u0083\u0001R(\u0010¨\u0002\u001a\u00020\u00032\u0007\u0010ñ\u0001\u001a\u00020\u00038V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b¨\u0002\u00108\"\u0005\b©\u0002\u0010:R\u0016\u0010«\u0002\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bª\u0002\u0010mR(\u0010®\u0002\u001a\u00020\u00192\u0007\u0010ñ\u0001\u001a\u00020\u00198V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b¬\u0002\u0010M\"\u0005\b\u00ad\u0002\u0010OR\u001a\u0010°\u0002\u001a\u0005\u0018\u00010\u008a\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b¯\u0002\u0010\u008e\u0001R\u0016\u0010²\u0002\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b±\u0002\u00101R(\u0010³\u0002\u001a\u00020\u00032\u0007\u0010ñ\u0001\u001a\u00020\u00038V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b³\u0002\u00108\"\u0005\b´\u0002\u0010:R\u0016\u0010µ\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bµ\u0002\u00108R\u0016\u0010·\u0002\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b¶\u0002\u0010MR(\u0010¸\u0002\u001a\u00020\u00032\u0007\u0010ñ\u0001\u001a\u00020\u00038V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b¸\u0002\u00108\"\u0005\b¹\u0002\u0010:R(\u0010º\u0002\u001a\u00020\u00032\u0007\u0010ñ\u0001\u001a\u00020\u00038V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bº\u0002\u00108\"\u0005\b»\u0002\u0010:R\u001a\u0010¿\u0002\u001a\u0005\u0018\u00010¼\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\b½\u0002\u0010¾\u0002R\u0016\u0010Á\u0002\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÀ\u0002\u0010MR\u0016\u0010Ã\u0002\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÂ\u0002\u00101R0\u0010É\u0002\u001a\u0005\u0018\u00010Ä\u00022\n\u0010ñ\u0001\u001a\u0005\u0018\u00010Ä\u00028V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\bÅ\u0002\u0010Æ\u0002\"\u0006\bÇ\u0002\u0010È\u0002R\u001a\u0010Í\u0002\u001a\u0005\u0018\u00010Ê\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\bË\u0002\u0010Ì\u0002R\u0016\u0010Ï\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÎ\u0002\u00108R\u0016\u0010Ñ\u0002\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÐ\u0002\u0010mR\u001a\u0010Ó\u0002\u001a\u0005\u0018\u00010¸\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bÒ\u0002\u0010¼\u0001R\u001a\u0010Õ\u0002\u001a\u0005\u0018\u00010¿\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bÔ\u0002\u0010Ã\u0001R\u001a\u0010×\u0002\u001a\u0005\u0018\u00010Æ\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bÖ\u0002\u0010Ê\u0001R(\u0010Ú\u0002\u001a\u00020\u00102\u0007\u0010ñ\u0001\u001a\u00020\u00108V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bØ\u0002\u00101\"\u0005\bÙ\u0002\u00103R\u001a\u0010Ü\u0002\u001a\u0005\u0018\u00010Ð\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bÛ\u0002\u0010Ô\u0001R(\u0010ß\u0002\u001a\u00020\u00102\u0007\u0010ñ\u0001\u001a\u00020\u00108V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bÝ\u0002\u00101\"\u0005\bÞ\u0002\u00103R\u001c\u0010á\u0002\u001a\b\u0012\u0004\u0012\u00020\u00140%8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bà\u0002\u0010*R\u001a\u0010ã\u0002\u001a\u0005\u0018\u00010Ý\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bâ\u0002\u0010á\u0001R(\u0010æ\u0002\u001a\u00020\u00142\u0007\u0010ñ\u0001\u001a\u00020\u00148V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bä\u0002\u0010m\"\u0005\bå\u0002\u0010oR(\u0010é\u0002\u001a\u00020\u00192\u0007\u0010ñ\u0001\u001a\u00020\u00198V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bç\u0002\u0010M\"\u0005\bè\u0002\u0010OR0\u0010ì\u0002\u001a\u0005\u0018\u00010Ý\u00012\n\u0010ñ\u0001\u001a\u0005\u0018\u00010Ý\u00018V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\bê\u0002\u0010á\u0001\"\u0006\bë\u0002\u0010ã\u0001R(\u0010ï\u0002\u001a\u00020\u00192\u0007\u0010ñ\u0001\u001a\u00020\u00198V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bí\u0002\u0010M\"\u0005\bî\u0002\u0010OR(\u0010ò\u0002\u001a\u00020\u00142\u0007\u0010ñ\u0001\u001a\u00020\u00148V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bð\u0002\u0010m\"\u0005\bñ\u0002\u0010oR(\u0010õ\u0002\u001a\u00020\u00142\u0007\u0010ñ\u0001\u001a\u00020\u00148V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bó\u0002\u0010m\"\u0005\bô\u0002\u0010oR(\u0010ø\u0002\u001a\u00020\u00102\u0007\u0010ñ\u0001\u001a\u00020\u00108V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bö\u0002\u00101\"\u0005\b÷\u0002\u00103R(\u0010û\u0002\u001a\u00020\u00102\u0007\u0010ñ\u0001\u001a\u00020\u00108V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bù\u0002\u00101\"\u0005\bú\u0002\u00103R(\u0010þ\u0002\u001a\u00020\u00032\u0007\u0010ñ\u0001\u001a\u00020\u00038V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bü\u0002\u00108\"\u0005\bý\u0002\u0010:R\u0016\u0010ÿ\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÿ\u0002\u00108R0\u0010\u0080\u0003\u001a\u0005\u0018\u00010Ý\u00012\n\u0010\u0080\u0003\u001a\u0005\u0018\u00010Ý\u00018V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b\u0081\u0003\u0010á\u0001\"\u0006\b\u0082\u0003\u0010ã\u0001R(\u0010\u0085\u0003\u001a\u00020\u00142\u0007\u0010ñ\u0001\u001a\u00020\u00148V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0083\u0003\u0010m\"\u0005\b\u0084\u0003\u0010oR,\u0010\u0088\u0003\u001a\u0004\u0018\u00010\u00192\t\u0010ñ\u0001\u001a\u0004\u0018\u00010\u00198V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0086\u0003\u0010M\"\u0005\b\u0087\u0003\u0010O¨\u0006\u008d\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/Gift;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/h1;", BuildConfig.FLAVOR, "enableWebp", BuildConfig.FLAVOR, "enableImageFormatOpt", "enableDomain", "enableDomainOpt", "isSupportGroup", "isNewSupportGroup", "isSpecialOrStickerGift", "isHonorGift", "isNobleGift", "doodle", "Z", BuildConfig.FLAVOR, "mNameColor", "I", "mDescribeColor", BuildConfig.FLAVOR, "mVipLevel", "J", "imageFormatOpt", "imageUrlOpt", BuildConfig.FLAVOR, "mName", "Ljava/lang/String;", "Lcom/bytedance/android/live/base/model/ImageModel;", "mImage", "Lcom/bytedance/android/live/base/model/ImageModel;", "mWebpImage", "mDescribe", "mId", "mType", "mDiamondCount", "mCombo", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "mRedPacket", "Ljava/util/List;", "getMRedPacket", "()Ljava/util/List;", "setMRedPacket", "(Ljava/util/List;)V", "mDuration", "mForLinkMic", "_actionType", "get_actionType", "()I", "set_actionType", "(I)V", "mWatermelonSeeds", "mLeftLogo", "_isDisplayedOnPanel", "get_isDisplayedOnPanel", "()Z", "set_isDisplayedOnPanel", "(Z)V", BuildConfig.FLAVOR, "mSpecialEffects", "Ljava/util/Map;", "mPrimaryEffectId", "_manual", "<set-?>", "guideUrl", "mLiveUserPngInfo", "mGoldenBeanCount", "mHonorLevel", "mForFansClub", "Lcom/bytedance/android/livesdk/gift/model/n0;", "mFansClubInfo", "Lcom/bytedance/android/livesdk/gift/model/n0;", "mNobleLevel", "mItemType", "mSchemeUrl", "getMSchemeUrl", "()Ljava/lang/String;", "setMSchemeUrl", "(Ljava/lang/String;)V", "mEventName", "mBusinessText", "mCnyGift", "mIsGray", "mGrayAction", "Lcom/bytedance/android/livesdk/gift/model/e0;", "mGiftBanner", "Lcom/bytedance/android/livesdk/gift/model/e0;", "mBannerScheme", "mTriggerWords", "Lcom/bytedance/android/livesdk/gift/model/l1;", "giftBuffInfoList", "forFirstRecharge", "_dynamicImgForSelected", "get_dynamicImgForSelected", "()Lcom/bytedance/android/live/base/model/ImageModel;", "set_dynamicImgForSelected", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "_afterSendAction", "_topBarText", "get_topBarText", "set_topBarText", "_topRightAvatar", "get_topRightAvatar", "set_topRightAvatar", "isLocked", "setLocked", "_reqExtraType", "get_reqExtraType", "()J", "set_reqExtraType", "(J)V", "_assetIds", "get_assetIds", "set_assetIds", "_optionalAssetIds", "get_optionalAssetIds", "set_optionalAssetIds", "Lcom/bytedance/android/livesdk/gift/model/l;", "comboHint", "Lcom/bytedance/android/livesdk/gift/model/l;", "getComboHint", "()Lcom/bytedance/android/livesdk/gift/model/l;", "setComboHint", "(Lcom/bytedance/android/livesdk/gift/model/l;)V", "Lcom/bytedance/android/livesdk/gift/model/k0;", "_giftPreviewInfo", "Lcom/bytedance/android/livesdk/gift/model/k0;", "get_giftPreviewInfo", "()Lcom/bytedance/android/livesdk/gift/model/k0;", "set_giftPreviewInfo", "(Lcom/bytedance/android/livesdk/gift/model/k0;)V", "_topicId", "get_topicId", "set_topicId", "_sortExtra", "get_sortExtra", "set_sortExtra", "Lcom/bytedance/android/livesdk/gift/model/c2;", "_giftTip", "Lcom/bytedance/android/livesdk/gift/model/c2;", "get_giftTip", "()Lcom/bytedance/android/livesdk/gift/model/c2;", "set_giftTip", "(Lcom/bytedance/android/livesdk/gift/model/c2;)V", "_sweepLightCount", "get_sweepLightCount", "set_sweepLightCount", "hasSweepLight", "freeDisplay", "isTransformFromLiteGift", "setTransformFromLiteGift", "Lcom/bytedance/android/livesdk/gift/model/h0;", "mGiftGroupList", "getMGiftGroupList", "setMGiftGroupList", "Lcom/bytedance/android/livesdkapi/message/Text;", "_bottomText", "Lcom/bytedance/android/livesdkapi/message/Text;", "get_bottomText", "()Lcom/bytedance/android/livesdkapi/message/Text;", "set_bottomText", "(Lcom/bytedance/android/livesdkapi/message/Text;)V", "_mysteryShopStatus", "get_mysteryShopStatus", "set_mysteryShopStatus", "Lcom/bytedance/android/livesdk/gift/model/i0;", "_giftMsgBoard", "Lcom/bytedance/android/livesdk/gift/model/i0;", "get_giftMsgBoard", "()Lcom/bytedance/android/livesdk/gift/model/i0;", "set_giftMsgBoard", "(Lcom/bytedance/android/livesdk/gift/model/i0;)V", "Lcom/bytedance/android/live/liveinteract/videotalk/emoji/model/TalkRoomInteractEmoji;", "_emojiInteractResource", "Lcom/bytedance/android/live/liveinteract/videotalk/emoji/model/TalkRoomInteractEmoji;", "get_emojiInteractResource", "()Lcom/bytedance/android/live/liveinteract/videotalk/emoji/model/TalkRoomInteractEmoji;", "set_emojiInteractResource", "(Lcom/bytedance/android/live/liveinteract/videotalk/emoji/model/TalkRoomInteractEmoji;)V", "dynamicImgFlippable", "_sortScore", "get_sortScore", "set_sortScore", "Lcom/bytedance/android/livesdk/gift/model/e2;", "_giftTouchLabel", "Lcom/bytedance/android/livesdk/gift/model/e2;", "get_giftTouchLabel", "()Lcom/bytedance/android/livesdk/gift/model/e2;", "set_giftTouchLabel", "(Lcom/bytedance/android/livesdk/gift/model/e2;)V", "Lcom/bytedance/android/livesdk/gift/model/r0;", "_giftUnselectedBottomInfo", "Lcom/bytedance/android/livesdk/gift/model/r0;", "get_giftUnselectedBottomInfo", "()Lcom/bytedance/android/livesdk/gift/model/r0;", "set_giftUnselectedBottomInfo", "(Lcom/bytedance/android/livesdk/gift/model/r0;)V", "Lcom/bytedance/android/livesdk/gift/model/f0;", "_giftConfirmInfo", "Lcom/bytedance/android/livesdk/gift/model/f0;", "get_giftConfirmInfo", "()Lcom/bytedance/android/livesdk/gift/model/f0;", "set_giftConfirmInfo", "(Lcom/bytedance/android/livesdk/gift/model/f0;)V", "_bizType", "get_bizType", "set_bizType", "Lcom/bytedance/android/livesdk/gift/model/t0;", "_goodsBizItem", "Lcom/bytedance/android/livesdk/gift/model/t0;", "get_goodsBizItem", "()Lcom/bytedance/android/livesdk/gift/model/t0;", "set_goodsBizItem", "(Lcom/bytedance/android/livesdk/gift/model/t0;)V", "_giftSource", "get_giftSource", "set_giftSource", "_requiredAssets", "get_requiredAssets", "set_requiredAssets", "Lpy/k;", "_rightTopSelectedLabel", "Lpy/k;", "get_rightTopSelectedLabel", "()Lpy/k;", "set_rightTopSelectedLabel", "(Lpy/k;)V", "_selectedDynamicEffect", "get_selectedDynamicEffect", "set_selectedDynamicEffect", "_giftEndingTime", "nowTimeDiffSeconds", "getNowTimeDiffSeconds", "setNowTimeDiffSeconds", "iImageModel", "getWebpImage", "setWebpImage", "webpImage", "getActionType", "actionType", "value", "isDisplayedOnPanel", "setDisplayedOnPanel", "getSpecialEffects", "()Ljava/util/Map;", "setSpecialEffects", "(Ljava/util/Map;)V", "specialEffects", "getPrimaryEffectId", "setPrimaryEffectId", "primaryEffectId", "getSchemeUrl", "schemeUrl", "getTriggerWords", "setTriggerWords", "triggerWords", "getManual", "manual", "getGoldenBeanCount", "goldenBeanCount", "getGiftGroupList", "setGiftGroupList", "giftGroupList", "isForFansClub", "setForFansClub", "getDynamicImgForSelected", "dynamicImgForSelected", "getAfterSendAction", "setAfterSendAction", "afterSendAction", "getTopBarText", "topBarText", "getTopRightAvatar", "topRightAvatar", "getItemType", "setItemType", "itemType", "getReqExtraType", "setReqExtraType", "reqExtraType", "getAssetIds", "setAssetIds", "assetIds", "getOptionalAssetIds", "setOptionalAssetIds", "optionalAssetIds", "isSupportLongPressCombo", "getGiftBanner", "()Lcom/bytedance/android/livesdk/gift/model/e0;", "giftBanner", "isCnyGift", "isRepeat", "getGiftPreviewInfo", "setGiftPreviewInfo", "giftPreviewInfo", "isFreeDisplay", "setFreeDisplay", "getTopicId", "topicId", "getSortExtra", "setSortExtra", "sortExtra", "getGiftTip", "giftTip", "getSweepLightCount", "sweepLightCount", "isHasSweepLight", "setHasSweepLight", "isGray", "getGrayAction", "grayAction", "isForFirstRecharge", "setForFirstRecharge", "isDomainOptEnable", "setDomainOptEnable", "Lcom/bytedance/android/live/base/model/message/a5;", "getBottomText", "()Lcom/bytedance/android/live/base/model/message/a5;", "bottomText", "getLiveUserPngInfo", "liveUserPngInfo", "getMysteryShopStatus", "mysteryShopStatus", "Lcom/bytedance/android/livesdk/gift/model/GiftMsgBoard;", "getGiftMsgBoard", "()Lcom/bytedance/android/livesdk/gift/model/GiftMsgBoard;", "setGiftMsgBoard", "(Lcom/bytedance/android/livesdk/gift/model/GiftMsgBoard;)V", "giftMsgBoard", "Lcom/bytedance/android/live/liveinteract/videotalk/emoji/model/m;", "getEmojiInteractResource", "()Lcom/bytedance/android/live/liveinteract/videotalk/emoji/model/m;", "emojiInteractResource", "getTrayDynamicImgFlippable", "trayDynamicImgFlippable", "getSortScore", "sortScore", "getGiftTouchLabel", "giftTouchLabel", "getGiftUnselectedBottomInfo", "giftUnselectedBottomInfo", "getGiftConfirmInfo", "giftConfirmInfo", "getBizType", "setBizType", "bizType", "getGoodsBizItem", "goodsBizItem", "getGiftSource", "setGiftSource", "giftSource", "getRequiredAssets", "requiredAssets", "getRightTopSelectedLabel", "rightTopSelectedLabel", "getSelectedDynamicEffect", "setSelectedDynamicEffect", "selectedDynamicEffect", "getName", "setName", "name", "getImage", "setImage", "image", "getDescribe", "setDescribe", "describe", "getDuration", "setDuration", "duration", "getId", "setId", "id", "getType", "setType", "type", "getDiamondCount", "setDiamondCount", "diamondCount", "getRepeat", "setRepeat", "repeat", "isForLinkMic", "leftLogo", "getLeftLogo", "setLeftLogo", "getGiftEndingTime", "setGiftEndingTime", "giftEndingTime", "getBannerScheme", "setBannerScheme", "bannerScheme", "<init>", "()V", "Companion", "a", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Gift extends FlexModelBase<h1> implements h1, vh7.h {
    public static final int ACTION_CLOSE_COMBO = 1;
    public static final int ACTION_DEFAULT = 0;
    public static final a Companion = null;
    public static final int DEFAULT_DURATION = 3000;
    public static final int ITEM_TYPE_IMAGE = 2;
    public static final int ITEM_TYPE_NORMAL = 1;
    public static final int REWARD_UNLOCKED = 3;
    public static final int REWARD_UNLOCKING = 2;
    public static final int SEND_TYPE_COMBO_GROUP_SEND = 5;
    public static final int SEND_TYPE_DEFAULT = 0;
    public static final int SEND_TYPE_GROUP_SEND = 2;
    public static final int SEND_TYPE_NORMAL = 1;
    public static final int SEND_TYPE_NORMAL_SEND = 4;
    public static final int SEND_TYPE_TOUCH_AND_HOLD = 3;
    public static final int SHOP_UNRELATED = 0;
    public static final int TASK_TO_UNLOCK = 1;
    public static final int TYPE_BLIND_BOX = 12;
    public static final int TYPE_FREE_CELL = 9;
    public static final int TYPE_GAME = 11;
    public static final int TYPE_GOLDEN_BEAN = 10;
    public static final int TYPE_INTERACT_GIFT = 13;
    public static final int TYPE_MEMBER_GIFT = 14;
    public static final int TYPE_MIDDLE = 8;
    public static final int TYPE_MULTI_INTERACT = 15;
    public static final int TYPE_NORMAL_ANIMATION = 1;
    public static final int TYPE_RED_PACKET = 3;
    public static final int TYPE_SPECIAL_ANIMATION = 2;
    public static final int TYPE_STICKER = 4;
    public static final int TYPE_TASK_GIFT = 5;

    @SerializedName("action_type")
    protected int _actionType;

    @SerializedName("after_send_action")
    public int _afterSendAction;

    @SerializedName("asset_ids")
    protected List<Long> _assetIds;

    @SerializedName("biz_type")
    protected int _bizType;

    @SerializedName("bottom_text")
    protected Text _bottomText;

    @SerializedName("dynamic_img_for_selected")
    protected ImageModel _dynamicImgForSelected;

    @IgnoreProtoFieldCheck
    @SerializedName("emoji_interact_resource")
    protected TalkRoomInteractEmoji _emojiInteractResource;

    @SerializedName("gift_confirm_info")
    protected f0 _giftConfirmInfo;

    @SerializedName("gift_offline_time")
    public long _giftEndingTime;

    @SerializedName("gift_msg_board")
    protected i0 _giftMsgBoard;

    @SerializedName("gift_preview_info")
    protected k0 _giftPreviewInfo;

    @SerializedName("gift_source")
    protected int _giftSource;

    @SerializedName("gift_tip")
    protected c2 _giftTip;

    @SerializedName("gift_touch_label")
    protected e2 _giftTouchLabel;

    @SerializedName("unselected_bottom_info")
    protected r0 _giftUnselectedBottomInfo;

    @SerializedName("biz_item")
    protected t0 _goodsBizItem;

    @SerializedName("is_displayed_on_panel")
    protected boolean _isDisplayedOnPanel;

    @SerializedName("manual")
    public String _manual;

    @SerializedName("mystery_shop_status")
    protected int _mysteryShopStatus;

    @SerializedName("optional_asset_ids")
    protected List<Long> _optionalAssetIds;

    @SerializedName("req_extra_type")
    protected long _reqExtraType;

    @SerializedName("required_assets")
    protected List<Long> _requiredAssets;

    @SerializedName("selected_label")
    protected py.k _rightTopSelectedLabel;

    @SerializedName("selected_dynamic_effect")
    protected long _selectedDynamicEffect;

    @SerializedName("sort_extra")
    protected String _sortExtra;

    @IgnoreProtoFieldCheck
    @SerializedName("sort_score")
    protected long _sortScore;

    @SerializedName("need_sweep_light_count")
    protected int _sweepLightCount;

    @SerializedName("top_bar_text")
    protected String _topBarText;

    @SerializedName("top_right_avatar")
    protected ImageModel _topRightAvatar;

    @SerializedName("topic_id")
    protected long _topicId;

    @IgnoreProtoDecode
    private l comboHint;

    @SerializedName("doodle")
    public boolean doodle;

    @IgnoreProtoFieldCheck
    @SerializedName("tray_dynamic_img_flippable")
    public boolean dynamicImgFlippable;

    @SerializedName("for_first_recharge")
    public boolean forFirstRecharge;
    public boolean freeDisplay;

    @SerializedName("gift_buff_infos")
    public List<? extends l1> giftBuffInfoList;

    @SerializedName("guide_url")
    public String guideUrl;
    public boolean hasSweepLight;
    private boolean imageFormatOpt;
    private boolean imageUrlOpt;

    @SerializedName("is_locked")
    protected boolean isLocked;
    private boolean isTransformFromLiteGift;

    @SerializedName("banner_scheme_url")
    public String mBannerScheme;

    @SerializedName("business_text")
    public String mBusinessText;

    @SerializedName("cny_gift")
    public boolean mCnyGift;

    @SerializedName("combo")
    public boolean mCombo;

    @SerializedName("describe")
    public String mDescribe;

    @IgnoreProtoFieldCheck
    @SerializedName("describeColor")
    public int mDescribeColor;

    @SerializedName("diamond_count")
    public int mDiamondCount;

    @SerializedName("duration")
    public long mDuration;

    @SerializedName("event_name")
    public String mEventName;

    @SerializedName("fansclub_info")
    public n0 mFansClubInfo;

    @SerializedName("for_fansclub")
    public boolean mForFansClub;

    @SerializedName("for_linkmic")
    public boolean mForLinkMic;

    @SerializedName("gift_banner")
    public e0 mGiftBanner;

    @SerializedName("group_info")
    protected List<? extends h0> mGiftGroupList;

    @SerializedName("golden_beans")
    public long mGoldenBeanCount;

    @SerializedName("gray_scheme_url")
    public String mGrayAction;

    @SerializedName("honor_level")
    public long mHonorLevel;

    @SerializedName("id")
    public long mId;

    @SerializedName("image")
    public ImageModel mImage;

    @SerializedName("is_gray")
    public boolean mIsGray;

    @SerializedName("item_type")
    public int mItemType;

    @SerializedName("gift_label_icon")
    public ImageModel mLeftLogo;

    @SerializedName("gold_effect")
    public String mLiveUserPngInfo;

    @SerializedName("name")
    public String mName;

    @IgnoreProtoFieldCheck
    @SerializedName("nameColor")
    public int mNameColor;

    @SerializedName("noble_level")
    public long mNobleLevel;

    @SerializedName("primary_effect_id")
    public long mPrimaryEffectId;

    @SerializedName("subs")
    @IgnoreProtoDecode
    private List<Object> mRedPacket;

    @SerializedName("scheme_url")
    protected String mSchemeUrl;

    @SerializedName("special_effects")
    public Map<String, Long> mSpecialEffects;

    @SerializedName("trigger_words")
    public List<String> mTriggerWords;

    @SerializedName("type")
    public int mType;

    @SerializedName("vip_level")
    public long mVipLevel;

    @SerializedName("watermelon_seeds")
    public int mWatermelonSeeds;

    @SerializedName("webp_image")
    public ImageModel mWebpImage;
    private long nowTimeDiffSeconds;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public Gift() {
        super(h1.class);
        this.mNameColor = -1;
        this.mDescribeColor = -1711276033;
        this.mRedPacket = new ArrayList();
        this.mName = BuildConfig.FLAVOR;
        this.mDescribe = BuildConfig.FLAVOR;
        this._manual = BuildConfig.FLAVOR;
        this.guideUrl = BuildConfig.FLAVOR;
        this.mLiveUserPngInfo = BuildConfig.FLAVOR;
        this.mGrayAction = BuildConfig.FLAVOR;
        this.mBannerScheme = BuildConfig.FLAVOR;
        this.mTriggerWords = new ArrayList();
        this.giftBuffInfoList = new ArrayList();
        this._topBarText = BuildConfig.FLAVOR;
        this._assetIds = new ArrayList();
        this._optionalAssetIds = new ArrayList();
        this._giftTip = (c2) vh7.f.c(c2.class);
        this.mGiftGroupList = CollectionsKt.emptyList();
        this._requiredAssets = new ArrayList();
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1, com.bytedance.android.livesdk.gift.model.h2
    public long getDuration() {
        if (this.mDuration > 0) goto L6;
        this.mDuration = 3000;
    L6:
        return this.mDuration;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public py.k getDynamicImgForSelected() {
        ImageModel r0 = this._dynamicImgForSelected;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return new ImageModel();
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1, com.bytedance.android.livesdk.gift.model.h2
    public py.k getImage() {
        if (this.imageUrlOpt == true) goto L14;
        if (this.imageFormatOpt == false) goto L14;
        ImageModel r0 = this.mWebpImage;
        if (r0 == null) goto L14;
        List r1 = r0.mUrls;
        if (r1 == null) goto L14;
        if (r1.size() <= 0) goto L14;
        return this.mWebpImage;
    L14:
        return this.mImage;
    }

    public final boolean isHonorGift() {
        if (this.mHonorLevel <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isNewSupportGroup() {
        List<? extends h0> r0 = this.mGiftGroupList;
        if (r0 == null) goto L5;
        boolean r1 = r0.isEmpty();
    L7:
        return !r1;
    L5:
        r1 = true;
        goto L7
    }

    public final boolean isNobleGift() {
        if (this.mNobleLevel <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isSpecialOrStickerGift() {
        int r0 = this.mType;
        if (r0 != 2) goto L5;
    L10:
        return true;
    L5:
        if (r0 == 4) goto L10;
        if (r0 == 8) goto L10;
        return false;
    }

    public final boolean isSupportGroup() {
        if (this.mCombo == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mType == 12) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public boolean isSupportLongPressCombo() {
        if (this.mCombo == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mType == 12) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1, com.bytedance.android.livesdk.gift.model.h2
    public boolean getRepeat() {
        return isRepeat();
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public int getActionType() {
        return this._actionType;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1, com.bytedance.android.livesdk.gift.model.h2
    public int getAfterSendAction() {
        return this._afterSendAction;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1, com.bytedance.android.livesdk.gift.model.h2
    public List<Long> getAssetIds() {
        return this._assetIds;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public String getBannerScheme() {
        return this.mBannerScheme;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public int getBizType() {
        return this._bizType;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public a5 getBottomText() {
        return this._bottomText;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public l getComboHint() {
        return this.comboHint;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1, com.bytedance.android.livesdk.gift.model.h2
    public String getDescribe() {
        return this.mDescribe;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1, com.bytedance.android.livesdk.gift.model.h2
    public int getDiamondCount() {
        return this.mDiamondCount;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public com.bytedance.android.live.liveinteract.videotalk.emoji.model.m getEmojiInteractResource() {
        return this._emojiInteractResource;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public e0 getGiftBanner() {
        return this.mGiftBanner;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public f0 getGiftConfirmInfo() {
        return this._giftConfirmInfo;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1, com.bytedance.android.livesdk.gift.model.h2
    public long getGiftEndingTime() {
        return this._giftEndingTime;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public List<h0> getGiftGroupList() {
        return this.mGiftGroupList;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public GiftMsgBoard getGiftMsgBoard() {
        return this._giftMsgBoard;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1, com.bytedance.android.livesdk.gift.model.h2
    public k0 getGiftPreviewInfo() {
        return this._giftPreviewInfo;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public int getGiftSource() {
        return this._giftSource;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public c2 getGiftTip() {
        return this._giftTip;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public e2 getGiftTouchLabel() {
        return this._giftTouchLabel;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public r0 getGiftUnselectedBottomInfo() {
        return this._giftUnselectedBottomInfo;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public long getGoldenBeanCount() {
        return this.mGoldenBeanCount;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public t0 getGoodsBizItem() {
        return this._goodsBizItem;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public String getGrayAction() {
        return this.mGrayAction;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1, com.bytedance.android.livesdk.gift.model.h2
    public long getId() {
        return this.mId;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public int getItemType() {
        return this.mItemType;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1, com.bytedance.android.livesdk.gift.model.h2
    public py.k getLeftLogo() {
        return this.mLeftLogo;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public String getLiveUserPngInfo() {
        return this.mLiveUserPngInfo;
    }

    public final List<h0> getMGiftGroupList() {
        return this.mGiftGroupList;
    }

    public final List<Object> getMRedPacket() {
        return this.mRedPacket;
    }

    public final String getMSchemeUrl() {
        return this.mSchemeUrl;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public String getManual() {
        return this._manual;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public int getMysteryShopStatus() {
        return this._mysteryShopStatus;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1, com.bytedance.android.livesdk.gift.model.h2
    public String getName() {
        return this.mName;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public long getNowTimeDiffSeconds() {
        return this.nowTimeDiffSeconds;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public List<Long> getOptionalAssetIds() {
        return this._optionalAssetIds;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1, com.bytedance.android.livesdk.gift.model.h2
    public long getPrimaryEffectId() {
        return this.mPrimaryEffectId;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public long getReqExtraType() {
        return this._reqExtraType;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public List<Long> getRequiredAssets() {
        return this._requiredAssets;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public py.k getRightTopSelectedLabel() {
        return this._rightTopSelectedLabel;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public String getSchemeUrl() {
        return this.mSchemeUrl;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public long getSelectedDynamicEffect() {
        return this._selectedDynamicEffect;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1, com.bytedance.android.livesdk.gift.model.h2
    public String getSortExtra() {
        return this._sortExtra;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public long getSortScore() {
        return this._sortScore;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1, com.bytedance.android.livesdk.gift.model.h2
    public Map<String, Long> getSpecialEffects() {
        return this.mSpecialEffects;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public int getSweepLightCount() {
        return this._sweepLightCount;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public String getTopBarText() {
        return this._topBarText;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public py.k getTopRightAvatar() {
        return this._topRightAvatar;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public long getTopicId() {
        return this._topicId;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public boolean getTrayDynamicImgFlippable() {
        return this.dynamicImgFlippable;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public List<String> getTriggerWords() {
        return this.mTriggerWords;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1, com.bytedance.android.livesdk.gift.model.i1, com.bytedance.android.livesdk.gift.model.h2
    public int getType() {
        return this.mType;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public py.k getWebpImage() {
        return this.mWebpImage;
    }

    public final int get_actionType() {
        return this._actionType;
    }

    public final List<Long> get_assetIds() {
        return this._assetIds;
    }

    public final int get_bizType() {
        return this._bizType;
    }

    public final Text get_bottomText() {
        return this._bottomText;
    }

    public final ImageModel get_dynamicImgForSelected() {
        return this._dynamicImgForSelected;
    }

    public final TalkRoomInteractEmoji get_emojiInteractResource() {
        return this._emojiInteractResource;
    }

    public final f0 get_giftConfirmInfo() {
        return this._giftConfirmInfo;
    }

    public final i0 get_giftMsgBoard() {
        return this._giftMsgBoard;
    }

    public final k0 get_giftPreviewInfo() {
        return this._giftPreviewInfo;
    }

    public final int get_giftSource() {
        return this._giftSource;
    }

    public final c2 get_giftTip() {
        return this._giftTip;
    }

    public final e2 get_giftTouchLabel() {
        return this._giftTouchLabel;
    }

    public final r0 get_giftUnselectedBottomInfo() {
        return this._giftUnselectedBottomInfo;
    }

    public final t0 get_goodsBizItem() {
        return this._goodsBizItem;
    }

    public final boolean get_isDisplayedOnPanel() {
        return this._isDisplayedOnPanel;
    }

    public final int get_mysteryShopStatus() {
        return this._mysteryShopStatus;
    }

    public final List<Long> get_optionalAssetIds() {
        return this._optionalAssetIds;
    }

    public final long get_reqExtraType() {
        return this._reqExtraType;
    }

    public final List<Long> get_requiredAssets() {
        return this._requiredAssets;
    }

    public final py.k get_rightTopSelectedLabel() {
        return this._rightTopSelectedLabel;
    }

    public final long get_selectedDynamicEffect() {
        return this._selectedDynamicEffect;
    }

    public final String get_sortExtra() {
        return this._sortExtra;
    }

    public final long get_sortScore() {
        return this._sortScore;
    }

    public final int get_sweepLightCount() {
        return this._sweepLightCount;
    }

    public final String get_topBarText() {
        return this._topBarText;
    }

    public final ImageModel get_topRightAvatar() {
        return this._topRightAvatar;
    }

    public final long get_topicId() {
        return this._topicId;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public boolean isCnyGift() {
        return this.mCnyGift;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1, com.bytedance.android.livesdk.gift.model.h2
    public boolean isDisplayedOnPanel() {
        return this._isDisplayedOnPanel;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public boolean isDomainOptEnable() {
        return this.imageUrlOpt;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1, com.bytedance.android.livesdk.gift.model.h2
    public boolean isForFansClub() {
        return this.mForFansClub;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1, com.bytedance.android.livesdk.gift.model.h2
    public boolean isForFirstRecharge() {
        return this.forFirstRecharge;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public boolean isForLinkMic() {
        return this.mForLinkMic;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public boolean isFreeDisplay() {
        return this.freeDisplay;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public boolean isGray() {
        return this.mIsGray;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public boolean isHasSweepLight() {
        return this.hasSweepLight;
    }

    public final boolean isLocked() {
        return this.isLocked;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public boolean isRepeat() {
        return this.mCombo;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public boolean isTransformFromLiteGift() {
        return this.isTransformFromLiteGift;
    }

    /* JADX WARN: Type inference failed for: r3v50, types: [com.bytedance.android.livesdk.gift.model.k0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v52, types: [com.bytedance.android.livesdk.gift.model.c2, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v64, types: [com.bytedance.android.livesdk.gift.model.e2, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v75, types: [java.lang.Object, py.k] */
    public Gift(am3.g r11) {
        super(h1.class);
        this.mSpecialEffects = new HashMap();
        this.mTriggerWords = new ArrayList();
        this.giftBuffInfoList = new ArrayList();
        this._assetIds = new ArrayList();
        this._optionalAssetIds = new ArrayList();
        this.mGiftGroupList = new ArrayList();
        this._requiredAssets = new ArrayList();
        this.mNameColor = -1;
        this.mDescribeColor = -1711276033;
        this.mRedPacket = new ArrayList();
        setThreadSafe(false);
        long r1 = r11.c();
    L3:
        int r3 = r11.f();
        if (r3 == (-1)) goto L95;
        am3.g.a r5 = decodeExtensionFields(r3, r11);
        switch(r3) {
            case 1: goto L94;
            case 2: goto L93;
            case 3: goto L7;
            case 4: goto L92;
            case 5: goto L91;
            case 6: goto L90;
            case 7: goto L89;
            case 8: goto L88;
            case 9: goto L87;
            case 10: goto L86;
            case 11: goto L85;
            case 12: goto L84;
            case 13: goto L83;
            case 14: goto L82;
            case 15: goto L81;
            case 16: goto L80;
            case 17: goto L7;
            case 18: goto L79;
            case 19: goto L7;
            case 20: goto L62;
            case 21: goto L7;
            case 22: goto L61;
            case 23: goto L60;
            case 24: goto L59;
            case 25: goto L7;
            case 26: goto L58;
            case 27: goto L57;
            case 28: goto L56;
            case 29: goto L55;
            case 30: goto L7;
            case 31: goto L54;
            case 32: goto L53;
            case 33: goto L52;
            case 34: goto L7;
            case 35: goto L7;
            case 36: goto L51;
            case 37: goto L50;
            case 38: goto L7;
            case 39: goto L49;
            case 40: goto L48;
            case 41: goto L47;
            case 42: goto L7;
            case 43: goto L46;
            case 44: goto L44;
            case 45: goto L42;
            case 46: goto L41;
            case 47: goto L40;
            case 48: goto L39;
            case 49: goto L38;
            case 50: goto L37;
            case 51: goto L36;
            case 52: goto L35;
            case 53: goto L34;
            case 54: goto L33;
            case 55: goto L31;
            case 56: goto L30;
            case 57: goto L29;
            case 58: goto L28;
            case 59: goto L27;
            case 60: goto L26;
            case 61: goto L25;
            case 62: goto L24;
            case 63: goto L7;
            case 64: goto L23;
            case 65: goto L22;
            case 66: goto L21;
            case 67: goto L7;
            case 68: goto L20;
            case 69: goto L19;
            case 70: goto L18;
            case 71: goto L17;
            case 72: goto L16;
            case 73: goto L15;
            case 74: goto L14;
            case 75: goto L13;
            case 76: goto L12;
            case 77: goto L11;
            case 78: goto L10;
            case 79: goto L9;
            case 80: goto L8;
            default: goto L7;
        };
    L8:
        this._sortExtra = am3.h.c(r11);
        goto L3
    L9:
        this._topicId = r11.j();
        goto L3
    L10:
        this._sortScore = r11.j();
        goto L3
    L11:
        this._rightTopSelectedLabel = vh7.f.a(r11, py.k.class);
        goto L3
    L12:
        List r4 = this._requiredAssets;
    L32:
        Object r6 = Long.valueOf(r11.j());
    L45:
        r4.add(r6);
        goto L3
    L13:
        this._giftSource = r11.i();
        goto L3
    L14:
        this.mWebpImage = com.bytedance.android.live.base.model.x.a(r11);
        goto L3
    L15:
        this._goodsBizItem = new t0(r11);
        goto L3
    L16:
        this._bizType = r11.i();
        goto L3
    L17:
        this._giftConfirmInfo = new f0(r11);
        goto L3
    L18:
        this._giftUnselectedBottomInfo = new r0(r11);
        goto L3
    L19:
        this._giftTouchLabel = vh7.f.a(r11, e2.class);
        goto L3
    L20:
        this._selectedDynamicEffect = r11.j();
        goto L3
    L21:
        this.dynamicImgFlippable = am3.h.a(r11);
        goto L3
    L22:
        this._emojiInteractResource = com.bytedance.android.live.liveinteract.videotalk.emoji.model.y.a(r11);
        goto L3
    L23:
        this._giftMsgBoard = new i0(r11);
        goto L3
    L24:
        r4 = this._optionalAssetIds;
        goto L32
    L25:
        this._mysteryShopStatus = r11.i();
        goto L3
    L26:
        this._bottomText = _Text_ProtoDecoder.decodeStatic(r11);
        goto L3
    L27:
        r4 = this.mGiftGroupList;
        Class r7 = h0.class;
    L43:
        r6 = vh7.f.a(r11, r7);
        goto L45
    L28:
        this._sweepLightCount = r11.i();
        goto L3
    L29:
        this._giftTip = vh7.f.a(r11, c2.class);
        goto L3
    L30:
        this._giftPreviewInfo = vh7.f.a(r11, k0.class);
        goto L3
    L31:
        r4 = this._assetIds;
        goto L32
    L33:
        this._reqExtraType = r11.j();
        goto L3
    L34:
        this.isLocked = am3.h.a(r11);
        goto L3
    L35:
        this.mBannerScheme = am3.h.c(r11);
        goto L3
    L36:
        this._topRightAvatar = com.bytedance.android.live.base.model.x.a(r11);
        goto L3
    L37:
        this._topBarText = am3.h.c(r11);
        goto L3
    L38:
        this._giftEndingTime = r11.j();
        goto L3
    L39:
        this._afterSendAction = r11.i();
        goto L3
    L40:
        this._dynamicImgForSelected = com.bytedance.android.live.base.model.x.a(r11);
        goto L3
    L41:
        this.forFirstRecharge = am3.h.a(r11);
        goto L3
    L42:
        r4 = this.giftBuffInfoList;
        r7 = l1.class;
        goto L43
    L44:
        r4 = this.mTriggerWords;
        r6 = am3.h.c(r11);
        goto L45
    L46:
        this.mGiftBanner = new e0(r11);
        goto L3
    L47:
        this.mGrayAction = am3.h.c(r11);
        goto L3
    L48:
        this.mIsGray = am3.h.a(r11);
        goto L3
    L49:
        this.mVipLevel = r11.j();
        goto L3
    L50:
        this.mCnyGift = am3.h.a(r11);
        goto L3
    L51:
        this.mBusinessText = am3.h.c(r11);
        goto L3
    L52:
        this.guideUrl = am3.h.c(r11);
        goto L3
    L53:
        this.mNobleLevel = r11.j();
        goto L3
    L54:
        this.mEventName = am3.h.c(r11);
        goto L3
    L55:
        this.mSchemeUrl = am3.h.c(r11);
        goto L3
    L56:
        this.mItemType = r11.i();
        goto L3
    L57:
        this.mHonorLevel = r11.j();
        goto L3
    L58:
        this.mGoldenBeanCount = r11.j();
        goto L3
    L59:
        this.mLiveUserPngInfo = am3.h.c(r11);
        goto L3
    L60:
        this.mWatermelonSeeds = r11.i();
        goto L3
    L61:
        this._actionType = r11.i();
        goto L3
    L62:
        long r8 = r11.c();
        String r9 = null;
        Long r10 = null;
    L63:
        int r13 = r11.f();
        if (r13 == (-1)) goto L71;
        if (r13 != 1) goto L67;
        r9 = am3.h.c(r11);
        goto L63
    L67:
        if (r13 != 2) goto L68;
        r10 = Long.valueOf(r11.j());
        goto L63
    L68:
        am3.h.e(r11);
        goto L63
    L71:
        r11.d(r8);
        Map<String, Long> r14 = this.mSpecialEffects;
        if (r9 == null) goto L78;
        if (r10 == null) goto L76;
        r14.put(r9, r10);
        goto L3
    L76:
        throw new IllegalStateException("Value must not be null");
    L78:
        throw new IllegalStateException("Key must not be null");
    L79:
        this._manual = am3.h.c(r11);
        goto L3
    L80:
        this.mName = am3.h.c(r11);
        goto L3
    L81:
        this.mLeftLogo = com.bytedance.android.live.base.model.x.a(r11);
        goto L3
    L82:
        this.mPrimaryEffectId = r11.j();
        goto L3
    L83:
        this._isDisplayedOnPanel = am3.h.a(r11);
        goto L3
    L84:
        this.mDiamondCount = r11.i();
        goto L3
    L85:
        this.mType = r11.i();
        goto L3
    L86:
        this.mCombo = am3.h.a(r11);
        goto L3
    L87:
        this.mForFansClub = am3.h.a(r11);
        goto L3
    L88:
        this.doodle = am3.h.a(r11);
        goto L3
    L89:
        this.mForLinkMic = am3.h.a(r11);
        goto L3
    L90:
        this.mFansClubInfo = a4.a(r11);
        goto L3
    L91:
        this.mId = r11.j();
        goto L3
    L92:
        this.mDuration = r11.j();
        goto L3
    L93:
        this.mDescribe = am3.h.c(r11);
        goto L3
    L94:
        this.mImage = com.bytedance.android.live.base.model.x.a(r11);
        goto L3
    L7:
        am3.h.d(r5, r11);
        goto L3
    L95:
        r11.d(r1);
        setThreadSafe(true);
        if (this.mName != null) goto L99;
        this.mName = BuildConfig.FLAVOR;
    L99:
        if (this.mDescribe != null) goto L102;
        this.mDescribe = BuildConfig.FLAVOR;
    L102:
        if (this._manual != null) goto L105;
        this._manual = BuildConfig.FLAVOR;
    L105:
        if (this.guideUrl != null) goto L108;
        this.guideUrl = BuildConfig.FLAVOR;
    L108:
        if (this.mLiveUserPngInfo != null) goto L111;
        this.mLiveUserPngInfo = BuildConfig.FLAVOR;
    L111:
        if (this.mGrayAction != null) goto L114;
        this.mGrayAction = BuildConfig.FLAVOR;
    L114:
        if (this.mBannerScheme != null) goto L117;
        this.mBannerScheme = BuildConfig.FLAVOR;
    L117:
        if (this.mTriggerWords.isEmpty() == false) goto L120;
        this.mTriggerWords = new ArrayList();
    L120:
        if (this.giftBuffInfoList.isEmpty() == false) goto L123;
        this.giftBuffInfoList = new ArrayList();
    L123:
        if (this._topBarText != null) goto L126;
        this._topBarText = BuildConfig.FLAVOR;
    L126:
        if (this._assetIds.isEmpty() == false) goto L129;
        this._assetIds = new ArrayList();
    L129:
        if (this._optionalAssetIds.isEmpty() == false) goto L132;
        this._optionalAssetIds = new ArrayList();
    L132:
        if (this._giftTip != null) goto L135;
        this._giftTip = (c2) vh7.f.c(c2.class);
    L135:
        if (this.mGiftGroupList.isEmpty() == false) goto L138;
        this.mGiftGroupList = CollectionsKt.emptyList();
    L138:
        if (this._requiredAssets.isEmpty() == false) goto L287;
        this._requiredAssets = new ArrayList();
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public void enableDomainOpt(boolean r1) {
        this.imageUrlOpt = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public void enableImageFormatOpt(boolean r1) {
        this.imageFormatOpt = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public void setAfterSendAction(int r1) {
        this._afterSendAction = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public void setAssetIds(List<Long> r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this._assetIds = r2;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public void setBannerScheme(String r1) {
        this.mBannerScheme = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public void setBizType(int r1) {
        this._bizType = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public void setComboHint(l r1) {
        this.comboHint = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public void setDescribe(String r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.mDescribe = r2;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public void setDiamondCount(int r1) {
        this.mDiamondCount = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public void setDisplayedOnPanel(boolean r1) {
        this._isDisplayedOnPanel = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public void setDomainOptEnable(boolean r1) {
        this.imageUrlOpt = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public void setDuration(long r4) {
        if (r4 > 0) goto L5;
        return;
    L5:
        this.mDuration = r4;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public void setForFansClub(boolean r1) {
        this.mForFansClub = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public void setForFirstRecharge(boolean r1) {
        this.forFirstRecharge = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public void setFreeDisplay(boolean r1) {
        this.freeDisplay = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public void setGiftEndingTime(long r1) {
        this._giftEndingTime = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public void setGiftGroupList(List<? extends h0> r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.mGiftGroupList = r2;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public void setGiftMsgBoard(GiftMsgBoard r3) {
        if (r3 != null) goto L5;
        this._giftMsgBoard = null;
        return;
    L5:
        i0 r0 = new i0();
        r0.forMsgBoard = r3.forMsgBoard;
        r0.promptText = r3.promptText;
        this._giftMsgBoard = r0;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public void setGiftPreviewInfo(k0 r1) {
        this._giftPreviewInfo = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public void setGiftSource(int r1) {
        this._giftSource = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public void setHasSweepLight(boolean r1) {
        this.hasSweepLight = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public void setId(long r1) {
        this.mId = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public void setImage(py.k r2) {
        this.mImage = (ImageModel) com.bytedance.android.live.base.model.m.b(r2, ImageModel.class);
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public void setItemType(int r1) {
        this.mItemType = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public void setLeftLogo(py.k r2) {
        this.mLeftLogo = (ImageModel) com.bytedance.android.live.base.model.m.b(r2, ImageModel.class);
    }

    public final void setLocked(boolean r1) {
        this.isLocked = r1;
    }

    public final void setMGiftGroupList(List<? extends h0> r1) {
        this.mGiftGroupList = r1;
    }

    public final void setMRedPacket(List<Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mRedPacket = r2;
    }

    public final void setMSchemeUrl(String r1) {
        this.mSchemeUrl = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public void setName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.mName = r2;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public void setNowTimeDiffSeconds(long r1) {
        this.nowTimeDiffSeconds = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public void setOptionalAssetIds(List<Long> r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this._optionalAssetIds = r2;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public void setPrimaryEffectId(long r1) {
        this.mPrimaryEffectId = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public void setRepeat(boolean r1) {
        this.mCombo = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public void setReqExtraType(long r1) {
        this._reqExtraType = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public void setSelectedDynamicEffect(long r1) {
        this._selectedDynamicEffect = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public void setSortExtra(String r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this._sortExtra = r2;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public void setSpecialEffects(Map<String, Long> r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.mSpecialEffects = r2;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public void setTransformFromLiteGift(boolean r1) {
        this.isTransformFromLiteGift = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public void setTriggerWords(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.mTriggerWords = r2;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public void setType(int r1) {
        this.mType = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.h1
    public void setWebpImage(py.k r2) {
        this.mWebpImage = (ImageModel) com.bytedance.android.live.base.model.m.b(r2, ImageModel.class);
    }

    public final void set_actionType(int r1) {
        this._actionType = r1;
    }

    public final void set_assetIds(List<Long> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this._assetIds = r2;
    }

    public final void set_bizType(int r1) {
        this._bizType = r1;
    }

    public final void set_bottomText(Text r1) {
        this._bottomText = r1;
    }

    public final void set_dynamicImgForSelected(ImageModel r1) {
        this._dynamicImgForSelected = r1;
    }

    public final void set_emojiInteractResource(TalkRoomInteractEmoji r1) {
        this._emojiInteractResource = r1;
    }

    public final void set_giftConfirmInfo(f0 r1) {
        this._giftConfirmInfo = r1;
    }

    public final void set_giftMsgBoard(i0 r1) {
        this._giftMsgBoard = r1;
    }

    public final void set_giftPreviewInfo(k0 r1) {
        this._giftPreviewInfo = r1;
    }

    public final void set_giftSource(int r1) {
        this._giftSource = r1;
    }

    public final void set_giftTip(c2 r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this._giftTip = r2;
    }

    public final void set_giftTouchLabel(e2 r1) {
        this._giftTouchLabel = r1;
    }

    public final void set_giftUnselectedBottomInfo(r0 r1) {
        this._giftUnselectedBottomInfo = r1;
    }

    public final void set_goodsBizItem(t0 r1) {
        this._goodsBizItem = r1;
    }

    public final void set_isDisplayedOnPanel(boolean r1) {
        this._isDisplayedOnPanel = r1;
    }

    public final void set_mysteryShopStatus(int r1) {
        this._mysteryShopStatus = r1;
    }

    public final void set_optionalAssetIds(List<Long> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this._optionalAssetIds = r2;
    }

    public final void set_reqExtraType(long r1) {
        this._reqExtraType = r1;
    }

    public final void set_requiredAssets(List<Long> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this._requiredAssets = r2;
    }

    public final void set_rightTopSelectedLabel(py.k r1) {
        this._rightTopSelectedLabel = r1;
    }

    public final void set_selectedDynamicEffect(long r1) {
        this._selectedDynamicEffect = r1;
    }

    public final void set_sortExtra(String r1) {
        this._sortExtra = r1;
    }

    public final void set_sortScore(long r1) {
        this._sortScore = r1;
    }

    public final void set_sweepLightCount(int r1) {
        this._sweepLightCount = r1;
    }

    public final void set_topBarText(String r1) {
        this._topBarText = r1;
    }

    public final void set_topRightAvatar(ImageModel r1) {
        this._topRightAvatar = r1;
    }

    public final void set_topicId(long r1) {
        this._topicId = r1;
    }
}
