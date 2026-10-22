package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.live.base.annotation.IgnoreStyleCheck;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.profit.privilege.ProfitCheckConfig;
import com.bytedance.android.livesdk.message.model.cb;
import com.bytedance.android.livesdkapi.util.KotlinTypeUtilsKt;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.internal.FlexModelDelegate;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\t¢\u0006\u0006\b\u0094\u0002\u0010\u0095\u0002J\u0006\u0010\u0004\u001a\u00020\u0003J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0005H\u0007J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\bJ\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\bJ/\u0010\u0017\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0014*\b\u0012\u0004\u0012\u00020\u00020\u00132\u000e\b\u0001\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0017¢\u0006\u0004\b\u0017\u0010\u0018J1\u0010\u0019\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0014*\b\u0012\u0004\u0012\u00020\u00020\u00132\u000e\b\u0001\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0016¢\u0006\u0004\b\u0019\u0010\u0018R \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR*\u0010!\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f8W@VX\u0097\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R*\u0010(\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010\"\u001a\u0004\b/\u0010$\"\u0004\b0\u0010&R*\u00102\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010)\u001a\u0004\b3\u0010+\"\u0004\b4\u0010-R$\u00106\u001a\u0004\u0018\u0001058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\"\u0010>\u001a\u00020\b8V@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR*\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bD\u0010)\u001a\u0004\bE\u0010+\"\u0004\bF\u0010-R$\u0010H\u001a\u0004\u0018\u00010G8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010N\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bN\u0010=\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\"\u0010S\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bS\u0010=\u001a\u0004\bT\u0010P\"\u0004\bU\u0010RR\"\u0010\u000b\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010=\u001a\u0004\bV\u0010P\"\u0004\b\f\u0010RR\"\u0010W\u001a\u00020\u001f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bW\u0010\"\u001a\u0004\bX\u0010$\"\u0004\bY\u0010&R\"\u0010Z\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bZ\u0010=\u001a\u0004\b[\u0010P\"\u0004\b\\\u0010RR\"\u0010\u0011\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010=\u001a\u0004\b]\u0010P\"\u0004\b\u0012\u0010RR*\u0010^\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00058\u0016@WX\u0097\u000e¢\u0006\u0012\n\u0004\b^\u0010=\u001a\u0004\b_\u0010P\"\u0004\b`\u0010RR\"\u0010\r\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010=\u001a\u0004\ba\u0010P\"\u0004\b\u000e\u0010RR\"\u0010b\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bb\u0010?\u001a\u0004\bc\u0010A\"\u0004\bd\u0010CR\"\u0010\u000f\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010=\u001a\u0004\be\u0010P\"\u0004\b\u0010\u0010RR\"\u0010f\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bf\u0010=\u001a\u0004\bg\u0010P\"\u0004\bh\u0010RR*\u0010i\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00058V@VX\u0097\u000e¢\u0006\u0012\n\u0004\bi\u0010=\u001a\u0004\bj\u0010P\"\u0004\bk\u0010RR\u0016\u0010\u0004\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010=R\"\u0010\t\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\t\u0010=\u001a\u0004\bl\u0010P\"\u0004\b\n\u0010RR*\u0010n\u001a\n\u0012\u0004\u0012\u00020m\u0018\u0001018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bn\u0010)\u001a\u0004\bo\u0010+\"\u0004\bp\u0010-R*\u0010q\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00058\u0006@GX\u0087\u000e¢\u0006\u0012\n\u0004\bq\u0010=\u001a\u0004\br\u0010P\"\u0004\bs\u0010RR*\u0010t\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b8\u0006@GX\u0087\u000e¢\u0006\u0012\n\u0004\bt\u0010?\u001a\u0004\bu\u0010A\"\u0004\bv\u0010CR\u001e\u0010x\u001a\n\u0012\u0004\u0012\u00020w\u0018\u00010'8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bx\u0010)R\"\u0010y\u001a\u00020\u001f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\by\u0010\"\u001a\u0004\bz\u0010$\"\u0004\b{\u0010&R'\u0010}\u001a\u0004\u0018\u00010|8\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0004\b}\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R(\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u001f8G@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0083\u0001\u0010\"\u001a\u0005\b\u0084\u0001\u0010$\"\u0005\b\u0085\u0001\u0010&R,\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R&\u0010\u008d\u0001\u001a\u00020\b8V@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\b\u008d\u0001\u0010?\u001a\u0005\b\u008e\u0001\u0010A\"\u0005\b\u008f\u0001\u0010CR,\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0090\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R,\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0097\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b\u0098\u0001\u0010\u0099\u0001\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001\"\u0006\b\u009c\u0001\u0010\u009d\u0001R,\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u009e\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b\u009f\u0001\u0010 \u0001\u001a\u0006\b¡\u0001\u0010¢\u0001\"\u0006\b£\u0001\u0010¤\u0001R.\u0010¥\u0001\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b8V@VX\u0097\u000e¢\u0006\u0015\n\u0005\b¥\u0001\u0010?\u001a\u0005\b¦\u0001\u0010A\"\u0005\b§\u0001\u0010CR,\u0010©\u0001\u001a\u0005\u0018\u00010¨\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\b©\u0001\u0010ª\u0001\u001a\u0006\b«\u0001\u0010¬\u0001\"\u0006\b\u00ad\u0001\u0010®\u0001R,\u0010°\u0001\u001a\u0005\u0018\u00010¯\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b°\u0001\u0010±\u0001\u001a\u0006\b²\u0001\u0010³\u0001\"\u0006\b´\u0001\u0010µ\u0001R.\u0010¶\u0001\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00058V@VX\u0097\u000e¢\u0006\u0015\n\u0005\b¶\u0001\u0010=\u001a\u0005\b·\u0001\u0010P\"\u0005\b¸\u0001\u0010RR.\u0010¹\u0001\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00058V@VX\u0097\u000e¢\u0006\u0015\n\u0005\b¹\u0001\u0010=\u001a\u0005\bº\u0001\u0010P\"\u0005\b»\u0001\u0010RR.\u0010¼\u0001\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b8V@VX\u0097\u000e¢\u0006\u0015\n\u0005\b¼\u0001\u0010?\u001a\u0005\b½\u0001\u0010A\"\u0005\b¾\u0001\u0010CR,\u0010À\u0001\u001a\u0005\u0018\u00010¿\u00018\u0016@\u0016X\u0097\u000e¢\u0006\u0018\n\u0006\bÀ\u0001\u0010Á\u0001\u001a\u0006\bÂ\u0001\u0010Ã\u0001\"\u0006\bÄ\u0001\u0010Å\u0001R/\u0010Ç\u0001\u001a\u000b\u0012\u0005\u0012\u00030Æ\u0001\u0018\u00010'8\u0016@\u0016X\u0097\u000e¢\u0006\u0015\n\u0005\bÇ\u0001\u0010)\u001a\u0005\bÈ\u0001\u0010+\"\u0005\bÉ\u0001\u0010-R,\u0010Ë\u0001\u001a\u0005\u0018\u00010Ê\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bË\u0001\u0010Ì\u0001\u001a\u0006\bÍ\u0001\u0010Î\u0001\"\u0006\bÏ\u0001\u0010Ð\u0001R\u001c\u0010Ò\u0001\u001a\u0005\u0018\u00010Ñ\u00018\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bÒ\u0001\u0010Ó\u0001R(\u0010Ô\u0001\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÔ\u0001\u0010\"\u001a\u0005\bÕ\u0001\u0010$\"\u0005\bÖ\u0001\u0010&R&\u0010×\u0001\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b×\u0001\u0010=\u001a\u0005\bØ\u0001\u0010P\"\u0005\bÙ\u0001\u0010RR+\u0010Ú\u0001\u001a\u0004\u0018\u00010m8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bÚ\u0001\u0010Û\u0001\u001a\u0006\bÜ\u0001\u0010Ý\u0001\"\u0006\bÞ\u0001\u0010ß\u0001R.\u0010à\u0001\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b8V@VX\u0097\u000e¢\u0006\u0015\n\u0005\bà\u0001\u0010?\u001a\u0005\bá\u0001\u0010A\"\u0005\bâ\u0001\u0010CR&\u0010ã\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bã\u0001\u0010=\u001a\u0005\bä\u0001\u0010P\"\u0005\bå\u0001\u0010RR.\u0010æ\u0001\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b8V@VX\u0097\u000e¢\u0006\u0015\n\u0005\bæ\u0001\u0010?\u001a\u0005\bç\u0001\u0010A\"\u0005\bè\u0001\u0010CR(\u0010é\u0001\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bé\u0001\u0010\"\u001a\u0005\bê\u0001\u0010$\"\u0005\bë\u0001\u0010&R4\u0010ï\u0001\u001a\b\u0012\u0004\u0012\u00020\u001f0'2\r\u0010ì\u0001\u001a\b\u0012\u0004\u0012\u00020\u001f0'8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bí\u0001\u0010+\"\u0005\bî\u0001\u0010-R\u0016\u0010ñ\u0001\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bð\u0001\u0010$R4\u0010ô\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050'2\r\u0010ì\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050'8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bò\u0001\u0010+\"\u0005\bó\u0001\u0010-R8\u0010÷\u0001\u001a\n\u0012\u0004\u0012\u00020m\u0018\u00010'2\u000f\u0010ì\u0001\u001a\n\u0012\u0004\u0012\u00020m\u0018\u00010'8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bõ\u0001\u0010+\"\u0005\bö\u0001\u0010-R6\u0010û\u0001\u001a\t\u0012\u0005\u0012\u00030ø\u00010'2\u000e\u0010ì\u0001\u001a\t\u0012\u0005\u0012\u00030ø\u00010'8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bù\u0001\u0010+\"\u0005\bú\u0001\u0010-R(\u0010þ\u0001\u001a\u00020\u001f2\u0007\u0010ì\u0001\u001a\u00020\u001f8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\bü\u0001\u0010$\"\u0005\bý\u0001\u0010&R0\u0010\u0081\u0002\u001a\u0005\u0018\u00010Ê\u00012\n\u0010ì\u0001\u001a\u0005\u0018\u00010Ê\u00018V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\bÿ\u0001\u0010Î\u0001\"\u0006\b\u0080\u0002\u0010Ð\u0001R0\u0010\u0086\u0002\u001a\u0005\u0018\u00010Ñ\u00012\n\u0010ì\u0001\u001a\u0005\u0018\u00010Ñ\u00018V@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b\u0082\u0002\u0010\u0083\u0002\"\u0006\b\u0084\u0002\u0010\u0085\u0002R(\u0010\u0089\u0002\u001a\u00020\u001f2\u0007\u0010ì\u0001\u001a\u00020\u001f8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0087\u0002\u0010$\"\u0005\b\u0088\u0002\u0010&R,\u0010\u008a\u0002\u001a\u0004\u0018\u00010G2\t\u0010\u008a\u0002\u001a\u0004\u0018\u00010G8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u008b\u0002\u0010K\"\u0005\b\u008c\u0002\u0010MR*\u0010\u0090\u0002\u001a\u00020m2\u0007\u0010\u008d\u0002\u001a\u00020m8W@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b\u008e\u0002\u0010Ý\u0001\"\u0006\b\u008f\u0002\u0010ß\u0001R0\u0010\u0091\u0002\u001a\u0005\u0018\u00010¯\u00012\n\u0010\u0091\u0002\u001a\u0005\u0018\u00010¯\u00018W@VX\u0096\u000e¢\u0006\u0010\u001a\u0006\b\u0092\u0002\u0010³\u0001\"\u0006\b\u0093\u0002\u0010µ\u0001¨\u0006\u0096\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/i3;", "Lvh7/c$a;", "Lcom/bytedance/android/livesdk/gift/model/p2;", BuildConfig.FLAVOR, "isAwemeFreeGift", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "setIsAwemeFreeGift", BuildConfig.FLAVOR, "propType", "setPropType", "leftDiamonds", "setLeftDiamonds", "repeatCount", "setRepeatCount", "comboCount", "setComboCount", "groupCount", "setGroupCount", "Lvh7/e;", "R", "Ljava/lang/Class;", "aClass", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "delegate", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "getDelegate", "()Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", BuildConfig.FLAVOR, "<set-?>", "logId", "Ljava/lang/String;", "getLogId", "()Ljava/lang/String;", "setLogId", "(Ljava/lang/String;)V", BuildConfig.FLAVOR, "toUserOpenIds", "Ljava/util/List;", "getToUserOpenIds", "()Ljava/util/List;", "setToUserOpenIds", "(Ljava/util/List;)V", "multiSendToOpenUid", "getMultiSendToOpenUid", "setMultiSendToOpenUid", BuildConfig.FLAVOR, "_toUserIds", "get_toUserIds", "set_toUserIds", "Lcom/bytedance/android/livesdk/gift/model/r;", "dsAlertInfo", "Lcom/bytedance/android/livesdk/gift/model/r;", "getDsAlertInfo", "()Lcom/bytedance/android/livesdk/gift/model/r;", "setDsAlertInfo", "(Lcom/bytedance/android/livesdk/gift/model/r;)V", "_multiSendToUserId", "J", "count", "I", "getCount", "()I", "setCount", "(I)V", "_msgIdList", "get_msgIdList", "set_msgIdList", "Lcom/bytedance/android/live/base/model/message/a5;", "IdisplayText", "Lcom/bytedance/android/live/base/model/message/a5;", "getIdisplayText", "()Lcom/bytedance/android/live/base/model/message/a5;", "setIdisplayText", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "fanTicketCount", "getFanTicketCount", "()J", "setFanTicketCount", "(J)V", "roomFanTicketCount", "getRoomFanTicketCount", "setRoomFanTicketCount", "getLeftDiamonds", "describe", "getDescribe", "setDescribe", "giftId", "getGiftId", "setGiftId", "getGroupCount", "groupId", "getGroupId", "setGroupId", "getRepeatCount", "giftCnt", "getGiftCnt", "setGiftCnt", "getComboCount", "msgId", "getMsgId", "setMsgId", "propId", "getPropId", "setPropId", "getPropType", "Lcom/bytedance/android/livesdk/gift/model/l2;", "_props", "get_props", "set_props", "goldenBeanCount", "getGoldenBeanCount", "setGoldenBeanCount", "leftGoldenBeans", "getLeftGoldenBeans", "setLeftGoldenBeans", "Lcom/bytedance/android/livesdk/gift/model/GiftResultData;", "_gifts", "comment", "getComment", "setComment", "Lcom/bytedance/android/livesdk/gift/model/l;", "comboHint", "Lcom/bytedance/android/livesdk/gift/model/l;", "getComboHint", "()Lcom/bytedance/android/livesdk/gift/model/l;", "setComboHint", "(Lcom/bytedance/android/livesdk/gift/model/l;)V", "_diyItemInfo", "get_diyItemInfo", "set_diyItemInfo", "Lcom/bytedance/android/livesdk/gift/model/v2;", "nextSendParams", "Lcom/bytedance/android/livesdk/gift/model/v2;", "getNextSendParams", "()Lcom/bytedance/android/livesdk/gift/model/v2;", "setNextSendParams", "(Lcom/bytedance/android/livesdk/gift/model/v2;)V", "multiSendSuccessCount", "getMultiSendSuccessCount", "setMultiSendSuccessCount", "Lcom/bytedance/android/livesdk/gift/model/a1;", "anchorGift", "Lcom/bytedance/android/livesdk/gift/model/a1;", "getAnchorGift", "()Lcom/bytedance/android/livesdk/gift/model/a1;", "setAnchorGift", "(Lcom/bytedance/android/livesdk/gift/model/a1;)V", "Lcom/bytedance/android/livesdk/gift/model/h1;", "gift", "Lcom/bytedance/android/livesdk/gift/model/h1;", "getGift", "()Lcom/bytedance/android/livesdk/gift/model/h1;", "setGift", "(Lcom/bytedance/android/livesdk/gift/model/h1;)V", "Lcom/bytedance/android/live/core/model/profit/a;", "calmPeriod", "Lcom/bytedance/android/live/core/model/profit/a;", "getCalmPeriod", "()Lcom/bytedance/android/live/core/model/profit/a;", "setCalmPeriod", "(Lcom/bytedance/android/live/core/model/profit/a;)V", "clientGiftSource", "getClientGiftSource", "setClientGiftSource", "Lcom/bytedance/android/livesdk/gift/model/j3;", "sendTogetherInfo", "Lcom/bytedance/android/livesdk/gift/model/j3;", "getSendTogetherInfo", "()Lcom/bytedance/android/livesdk/gift/model/j3;", "setSendTogetherInfo", "(Lcom/bytedance/android/livesdk/gift/model/j3;)V", "Lcom/bytedance/android/livesdk/gift/model/w;", "extraEffect", "Lcom/bytedance/android/livesdk/gift/model/w;", "getExtraEffect", "()Lcom/bytedance/android/livesdk/gift/model/w;", "setExtraEffect", "(Lcom/bytedance/android/livesdk/gift/model/w;)V", "forceDisplayEffects", "getForceDisplayEffects", "setForceDisplayEffects", "sendGiftTime", "getSendGiftTime", "setSendGiftTime", "multiSendEffectLevel", "getMultiSendEffectLevel", "setMultiSendEffectLevel", "Lcom/bytedance/android/live/profit/privilege/ProfitCheckConfig;", "profitCheckConfig", "Lcom/bytedance/android/live/profit/privilege/ProfitCheckConfig;", "getProfitCheckConfig", "()Lcom/bytedance/android/live/profit/privilege/ProfitCheckConfig;", "setProfitCheckConfig", "(Lcom/bytedance/android/live/profit/privilege/ProfitCheckConfig;)V", "Lcom/bytedance/android/livesdk/gift/model/n3;", "seriesGiftData", "getSeriesGiftData", "setSeriesGiftData", "Lcom/bytedance/android/livesdk/message/model/cb;", "_petEffectInfo", "Lcom/bytedance/android/livesdk/message/model/cb;", "get_petEffectInfo", "()Lcom/bytedance/android/livesdk/message/model/cb;", "set_petEffectInfo", "(Lcom/bytedance/android/livesdk/message/model/cb;)V", "Lcom/bytedance/android/livesdk/gift/model/m0;", "_giftRecommendInfo", "Lcom/bytedance/android/livesdk/gift/model/m0;", "_traceId", "get_traceId", "set_traceId", "consumeDiamonds", "getConsumeDiamonds", "setConsumeDiamonds", "mProp", "Lcom/bytedance/android/livesdk/gift/model/l2;", "getMProp", "()Lcom/bytedance/android/livesdk/gift/model/l2;", "setMProp", "(Lcom/bytedance/android/livesdk/gift/model/l2;)V", "sendType", "getSendType", "setSendType", "targetUserId", "getTargetUserId", "setTargetUserId", "reqIndex", "getReqIndex", "setReqIndex", "giftType", "getGiftType", "setGiftType", "value", "getToUserIds", "setToUserIds", "toUserIds", "getMultiSendToUserId", "multiSendToUserId", "getMsgIdList", "setMsgIdList", "msgIdList", "getProps", "setProps", "props", "Lcom/bytedance/android/livesdk/gift/model/y1;", "getGifts", "setGifts", "gifts", "getDiyItemInfo", "setDiyItemInfo", "diyItemInfo", "getPetEffectInfo", "setPetEffectInfo", "petEffectInfo", "getGiftRecommendInfo", "()Lcom/bytedance/android/livesdk/gift/model/m0;", "setGiftRecommendInfo", "(Lcom/bytedance/android/livesdk/gift/model/m0;)V", "giftRecommendInfo", "getTraceId", "setTraceId", "traceId", "displayText", "getDisplayText", "setDisplayText", "iProp", "getProp", "setProp", "prop", "extraEffectInfo", "getExtraEffectInfo", "setExtraEffectInfo", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class i3 implements vh7.c.a<p2>, p2, vh7.h {

    @SerializedName("display_text")
    protected a5 IdisplayText;

    @SerializedName("diy_item_info")
    protected String _diyItemInfo;

    @SerializedName("recommend_info")
    protected m0 _giftRecommendInfo;

    @SerializedName("gifts")
    protected List<GiftResultData> _gifts;

    @SerializedName("msg_ids")
    protected List<Long> _msgIdList;

    @SerializedName("multi_send_to_user_id")
    protected long _multiSendToUserId;

    @SerializedName("pet_effect_info")
    protected cb _petEffectInfo;

    @SerializedName("props")
    protected List<l2> _props;

    @SerializedName("to_user_ids")
    protected List<Long> _toUserIds;

    @IgnoreProtoFieldCheck
    private String _traceId;

    @SerializedName("anchor_gift")
    protected a1 anchorGift;

    @SerializedName("calm_period")
    protected com.bytedance.android.live.core.model.profit.a calmPeriod;

    @SerializedName("client_gift_source")
    protected int clientGiftSource;

    @SerializedName("combo_count")
    protected long comboCount;

    @SerializedName("combo_hint")
    protected l comboHint;

    @IgnoreProtoFieldCheck
    private String comment;
    private long consumeDiamonds;

    @SerializedName("repeat_times")
    protected int count;
    private final transient FlexModelDelegate<p2> delegate;

    @SerializedName("describe")
    protected String describe;

    @SerializedName("ds_alert_info")
    protected r dsAlertInfo;

    @SerializedName("extra_effect")
    protected w extraEffect;

    @SerializedName("fan_ticket_count")
    protected long fanTicketCount;

    @SerializedName("force_display_effects")
    protected long forceDisplayEffects;

    @SerializedName("gift_struct")
    protected h1 gift;
    private int giftCnt;

    @SerializedName("gift_id")
    protected long giftId;

    @IgnoreStyleCheck
    private transient String giftType;

    @IgnoreProtoFieldCheck
    @SerializedName("golden_beans_count")
    private long goldenBeanCount;

    @SerializedName("group_count")
    protected long groupCount;

    @IgnoreProtoFieldCheck
    @SerializedName("group_id")
    protected long groupId;

    @IgnoreProtoFieldCheck
    @SerializedName("is_aweme_free_gift")
    private long isAwemeFreeGift;

    @SerializedName("left_diamond")
    protected long leftDiamonds;

    @IgnoreProtoFieldCheck
    @SerializedName("left_golden_beans")
    private int leftGoldenBeans;

    @IgnoreProtoFieldCheck
    private String logId;

    @IgnoreStyleCheck
    private transient l2 mProp;

    @SerializedName("msg_id")
    protected long msgId;

    @SerializedName("multi_send_effect_level")
    protected int multiSendEffectLevel;

    @SerializedName("multi_send_success_count")
    protected int multiSendSuccessCount;

    @SerializedName("multi_send_to_openuid")
    protected String multiSendToOpenUid;

    @SerializedName("next_send_ctl")
    protected v2 nextSendParams;

    @SerializedName("profit_check_config")
    protected ProfitCheckConfig profitCheckConfig;

    @SerializedName("prop_def_id")
    protected long propId;

    @SerializedName("prop_type")
    protected long propType;

    @SerializedName("repeat_count")
    protected long repeatCount;

    @IgnoreStyleCheck
    private transient int reqIndex;

    @SerializedName("room_fan_ticket_count")
    protected long roomFanTicketCount;

    @SerializedName("send_time")
    protected long sendGiftTime;

    @SerializedName("send_together")
    protected j3 sendTogetherInfo;

    @IgnoreStyleCheck
    private transient int sendType;

    @SerializedName("series_gift_data")
    protected List<? extends n3> seriesGiftData;

    @IgnoreStyleCheck
    private transient long targetUserId;

    @SerializedName("to_openids")
    protected List<String> toUserOpenIds;

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public List<y1> getGifts() {
        return KotlinTypeUtilsKt.castElementType(this._gifts);
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public List<Long> getMsgIdList() {
        List<Long> r0 = this._msgIdList;
        if (r0 == null) goto L9;
        Intrinsics.checkNotNull(r0);
        if (r0.isEmpty() == true) goto L9;
        return this._msgIdList;
    L9:
        return Arrays.asList(new Long[]{Long.valueOf(getMsgId())});
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public String getMultiSendToUserId() {
        com.bytedance.android.live.base.model.user.o0.a r0 = com.bytedance.android.live.base.model.user.o0.a;
        Long r1 = Long.valueOf(this._multiSendToUserId);
        String r2 = this.multiSendToOpenUid;
        r0.getClass();
        return com.bytedance.android.live.base.model.user.o0.a.g(r1, r2);
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public List<String> getToUserIds() {
        com.bytedance.android.live.base.model.user.o0.a r0 = com.bytedance.android.live.base.model.user.o0.a;
        List<String> r1 = this.toUserOpenIds;
        r0.getClass();
        return com.bytedance.android.live.base.model.user.o0.a.h(r1);
    }

    public final boolean isAwemeFreeGift() {
        if (this.isAwemeFreeGift != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public i3() {
        this.delegate = new FlexModelDelegate(p2.class, this);
        this.logId = BuildConfig.FLAVOR;
        this.comment = BuildConfig.FLAVOR;
        this._traceId = BuildConfig.FLAVOR;
        this.reqIndex = -1;
        this.describe = BuildConfig.FLAVOR;
        this.propId = -1;
        this._diyItemInfo = BuildConfig.FLAVOR;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public a1 getAnchorGift() {
        return this.anchorGift;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public com.bytedance.android.live.core.model.profit.a getCalmPeriod() {
        return this.calmPeriod;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public int getClientGiftSource() {
        return this.clientGiftSource;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public long getComboCount() {
        return this.comboCount;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public l getComboHint() {
        return this.comboHint;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public String getComment() {
        return this.comment;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public long getConsumeDiamonds() {
        return this.consumeDiamonds;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public int getCount() {
        return this.count;
    }

    public FlexModelDelegate<p2> getDelegate() {
        return this.delegate;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public String getDescribe() {
        return this.describe;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public a5 getDisplayText() {
        return this.IdisplayText;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public String getDiyItemInfo() {
        return this._diyItemInfo;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public r getDsAlertInfo() {
        return this.dsAlertInfo;
    }

    public final w getExtraEffect() {
        return this.extraEffect;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public w getExtraEffectInfo() {
        return this.extraEffect;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public long getFanTicketCount() {
        return this.fanTicketCount;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public long getForceDisplayEffects() {
        return this.forceDisplayEffects;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public h1 getGift() {
        return this.gift;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public int getGiftCnt() {
        return this.giftCnt;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public long getGiftId() {
        return this.giftId;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public m0 getGiftRecommendInfo() {
        return this._giftRecommendInfo;
    }

    public final String getGiftType() {
        return this.giftType;
    }

    public final long getGoldenBeanCount() {
        return this.goldenBeanCount;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public long getGroupCount() {
        return this.groupCount;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public long getGroupId() {
        return this.groupId;
    }

    public final a5 getIdisplayText() {
        return this.IdisplayText;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public long getLeftDiamonds() {
        return this.leftDiamonds;
    }

    public final int getLeftGoldenBeans() {
        return this.leftGoldenBeans;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public String getLogId() {
        return this.logId;
    }

    public final l2 getMProp() {
        return this.mProp;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public long getMsgId() {
        return this.msgId;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public int getMultiSendEffectLevel() {
        return this.multiSendEffectLevel;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public int getMultiSendSuccessCount() {
        return this.multiSendSuccessCount;
    }

    public final String getMultiSendToOpenUid() {
        return this.multiSendToOpenUid;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public v2 getNextSendParams() {
        return this.nextSendParams;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public cb getPetEffectInfo() {
        return this._petEffectInfo;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public ProfitCheckConfig getProfitCheckConfig() {
        return this.profitCheckConfig;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public l2 getProp() {
        return this.mProp;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public long getPropId() {
        return this.propId;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public long getPropType() {
        return this.propType;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public List<l2> getProps() {
        return this._props;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public long getRepeatCount() {
        return this.repeatCount;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public int getReqIndex() {
        return this.reqIndex;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public long getRoomFanTicketCount() {
        return this.roomFanTicketCount;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public long getSendGiftTime() {
        return this.sendGiftTime;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public j3 getSendTogetherInfo() {
        return this.sendTogetherInfo;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public int getSendType() {
        return this.sendType;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public List<n3> getSeriesGiftData() {
        return this.seriesGiftData;
    }

    public final long getTargetUserId() {
        return this.targetUserId;
    }

    public final List<String> getToUserOpenIds() {
        return this.toUserOpenIds;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public String getTraceId() {
        return this._traceId;
    }

    public final String get_diyItemInfo() {
        return this._diyItemInfo;
    }

    public final List<Long> get_msgIdList() {
        return this._msgIdList;
    }

    public final cb get_petEffectInfo() {
        return this._petEffectInfo;
    }

    public final List<l2> get_props() {
        return this._props;
    }

    public final List<Long> get_toUserIds() {
        return this._toUserIds;
    }

    public final String get_traceId() {
        return this._traceId;
    }

    /* JADX WARN: Type inference failed for: r2v11, types: [com.bytedance.android.livesdk.message.model.cb, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v13, types: [com.bytedance.android.livesdk.gift.model.m0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v20, types: [com.bytedance.android.livesdk.gift.model.a1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v24, types: [com.bytedance.android.livesdk.gift.model.h1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v27, types: [com.bytedance.android.livesdk.gift.model.j3, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v29, types: [com.bytedance.android.livesdk.gift.model.w, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v33, types: [com.bytedance.android.live.base.model.message.a5, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.bytedance.android.livesdk.gift.model.r, java.lang.Object] */
    public i3(am3.g r9) {
        this.toUserOpenIds = new ArrayList();
        this._toUserIds = new ArrayList();
        this._msgIdList = new ArrayList();
        this._props = new ArrayList();
        this._gifts = new ArrayList();
        this.seriesGiftData = new ArrayList();
        this.delegate = new FlexModelDelegate(p2.class, this);
        this.logId = BuildConfig.FLAVOR;
        this.comment = BuildConfig.FLAVOR;
        this._traceId = BuildConfig.FLAVOR;
        this.reqIndex = -1;
        boolean r3 = false;
        getDelegate().setThreadSafe(false);
        long r4 = r9.c();
    L3:
        int r2 = r9.f();
        if (r2 == (-1)) goto L55;
        am3.g.a r6 = getDelegate().decodeExtensionFields(r2, r9);
        if (r2 != 5000) goto L8;
        this.multiSendToOpenUid = am3.h.c(r9);
        goto L3
    L8:
        if (r2 == 5001) goto L53;
        switch(r2) {
            case 1: goto L52;
            case 2: goto L51;
            case 3: goto L50;
            case 4: goto L49;
            case 5: goto L48;
            case 6: goto L47;
            case 7: goto L46;
            case 8: goto L45;
            case 9: goto L44;
            case 10: goto L43;
            case 11: goto L40;
            case 12: goto L39;
            default: goto L10;
        };
    L39:
        this.msgId = r9.j();
        goto L3
    L40:
        List r5 = this._props;
        Class r7 = l2.class;
    L41:
        Object r8 = vh7.f.a(r9, r7);
    L42:
        r5.add(r8);
        goto L3
    L43:
        this.propType = r9.j();
        goto L3
    L44:
        this.propId = r9.j();
        r3 = r3 | true;
        goto L3
    L45:
        this.comboCount = r9.j();
        goto L3
    L46:
        this.repeatCount = r9.j();
        goto L3
    L47:
        this.leftDiamonds = r9.j();
        goto L3
    L48:
        this.groupCount = r9.j();
        goto L3
    L49:
        this.giftId = r9.j();
        goto L3
    L50:
        this.describe = am3.h.c(r9);
        goto L3
    L51:
        this.fanTicketCount = r9.j();
        goto L3
    L52:
        this.IdisplayText = vh7.f.a(r9, a5.class);
        goto L3
    L10:
        switch(r2) {
            case 15: goto L38;
            case 16: goto L37;
            case 17: goto L36;
            case 18: goto L35;
            case 19: goto L34;
            case 20: goto L33;
            case 21: goto L32;
            case 22: goto L31;
            case 23: goto L30;
            case 24: goto L28;
            case 25: goto L27;
            case 26: goto L26;
            case 27: goto L25;
            case 28: goto L24;
            case 29: goto L23;
            case 30: goto L22;
            case 31: goto L21;
            case 32: goto L20;
            default: goto L11;
        };
    L20:
        this.profitCheckConfig = new ProfitCheckConfig(r9);
        goto L3
    L21:
        this.multiSendEffectLevel = r9.i();
        goto L3
    L22:
        this.extraEffect = vh7.f.a(r9, w.class);
        goto L3
    L23:
        this.sendTogetherInfo = vh7.f.a(r9, j3.class);
        goto L3
    L24:
        this.clientGiftSource = r9.i();
        goto L3
    L25:
        this.gift = vh7.f.a(r9, h1.class);
        goto L3
    L26:
        this.forceDisplayEffects = r9.j();
        goto L3
    L27:
        this.sendGiftTime = r9.j();
        goto L3
    L28:
        r5 = this._toUserIds;
    L29:
        r8 = Long.valueOf(r9.j());
        goto L42
    L30:
        this.anchorGift = vh7.f.a(r9, a1.class);
        goto L3
    L31:
        this._multiSendToUserId = r9.j();
        goto L3
    L32:
        this.multiSendSuccessCount = r9.i();
        goto L3
    L33:
        this._diyItemInfo = am3.h.c(r9);
        goto L3
    L34:
        this.comboHint = new l(r9);
        goto L3
    L35:
        this.calmPeriod = new com.bytedance.android.live.core.model.profit.a(r9);
        goto L3
    L36:
        this.groupId = r9.j();
        goto L3
    L37:
        this.roomFanTicketCount = r9.j();
        goto L3
    L38:
        r5 = this._gifts;
        r8 = new GiftResultData(r9);
        goto L42
    L11:
        switch(r2) {
            case 35: goto L19;
            case 36: goto L18;
            case 37: goto L17;
            case 38: goto L16;
            case 39: goto L15;
            case 40: goto L14;
            case 41: goto L13;
            default: goto L12;
        };
    L13:
        this._giftRecommendInfo = vh7.f.a(r9, m0.class);
        goto L3
    L14:
        this._petEffectInfo = vh7.f.a(r9, cb.class);
        goto L3
    L15:
        r5 = this._msgIdList;
        goto L29
    L16:
        this.count = r9.i();
        goto L3
    L17:
        this.dsAlertInfo = vh7.f.a(r9, r.class);
        goto L3
    L18:
        r5 = this.seriesGiftData;
        r7 = n3.class;
        goto L41
    L19:
        this.nextSendParams = new v2(r9);
        goto L3
    L12:
        am3.h.d(r6, r9);
        goto L3
    L53:
        r5 = this.toUserOpenIds;
        r8 = am3.h.c(r9);
        goto L42
    L55:
        r9.d(r4);
        getDelegate().setThreadSafe(true);
        if (this.describe != null) goto L59;
        this.describe = BuildConfig.FLAVOR;
    L59:
        if ((r3 & true) == true) goto L62;
        this.propId = -1;
    L62:
        if (this._diyItemInfo != null) goto L145;
        this._diyItemInfo = BuildConfig.FLAVOR;
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public <R extends vh7.e<p2>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "aClass");
        return (R) getDelegate().castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public <R extends vh7.e<p2>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "aClass");
        return (R) getDelegate().castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public void setAnchorGift(a1 r1) {
        this.anchorGift = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public void setCalmPeriod(com.bytedance.android.live.core.model.profit.a r1) {
        this.calmPeriod = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public void setClientGiftSource(int r1) {
        this.clientGiftSource = r1;
    }

    public final void setComboCount(int r3) {
        setComboCount(r3);
    }

    public void setComboHint(l r1) {
        this.comboHint = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public void setComment(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.comment = r2;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public void setConsumeDiamonds(long r1) {
        this.consumeDiamonds = r1;
    }

    public void setCount(int r1) {
        this.count = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public void setDescribe(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.describe = r2;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public void setDisplayText(a5 r1) {
        this.IdisplayText = r1;
    }

    public void setDiyItemInfo(String r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this._diyItemInfo = r2;
    }

    public void setDsAlertInfo(r r1) {
        this.dsAlertInfo = r1;
    }

    public final void setExtraEffect(w r1) {
        this.extraEffect = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public void setExtraEffectInfo(w r1) {
        this.extraEffect = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public void setFanTicketCount(long r1) {
        this.fanTicketCount = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public void setForceDisplayEffects(long r1) {
        this.forceDisplayEffects = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public void setGift(h1 r1) {
        this.gift = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public void setGiftCnt(int r1) {
        this.giftCnt = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public void setGiftId(long r1) {
        this.giftId = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public void setGiftRecommendInfo(m0 r1) {
        this._giftRecommendInfo = r1;
    }

    public final void setGiftType(String r1) {
        this.giftType = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public void setGifts(List<? extends y1> r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        ArrayList r0 = new ArrayList();
        Iterator<? extends y1> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        y1 r1 = r4.next();
        if (r1 == null) goto L9;
        r0.add((GiftResultData) r1);
        goto L4
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.GiftResultData");
    L10:
        this._gifts = r0;
    }

    @SerializedName("golden_beans_count")
    public final void setGoldenBeanCount(long r1) {
        this.goldenBeanCount = r1;
    }

    public final void setGroupCount(int r3) {
        setGroupCount(r3);
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    @SerializedName("group_id")
    public void setGroupId(long r1) {
        this.groupId = r1;
    }

    public final void setIdisplayText(a5 r1) {
        this.IdisplayText = r1;
    }

    @SerializedName("is_aweme_free_gift")
    public final void setIsAwemeFreeGift(long r1) {
        this.isAwemeFreeGift = r1;
    }

    public final void setLeftDiamonds(int r3) {
        setLeftDiamonds(r3);
    }

    @SerializedName("left_golden_beans")
    public final void setLeftGoldenBeans(int r1) {
        this.leftGoldenBeans = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public void setLogId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.logId = r2;
    }

    public final void setMProp(l2 r1) {
        this.mProp = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public void setMsgId(long r1) {
        this.msgId = r1;
    }

    public void setMsgIdList(List<Long> r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this._msgIdList = r2;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public void setMultiSendEffectLevel(int r1) {
        this.multiSendEffectLevel = r1;
    }

    public void setMultiSendSuccessCount(int r1) {
        this.multiSendSuccessCount = r1;
    }

    public final void setMultiSendToOpenUid(String r1) {
        this.multiSendToOpenUid = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public void setNextSendParams(v2 r1) {
        this.nextSendParams = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public void setPetEffectInfo(cb r1) {
        this._petEffectInfo = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public void setProfitCheckConfig(ProfitCheckConfig r1) {
        this.profitCheckConfig = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public void setProp(l2 r2) {
        Intrinsics.checkNotNullParameter(r2, "iProp");
        this.mProp = r2;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public void setPropId(long r1) {
        this.propId = r1;
    }

    public final void setPropType(int r3) {
        setPropType(r3);
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public void setProps(List<? extends l2> r2) {
        ArrayList r0 = new ArrayList();
        r0.addAll(r2);
        this._props = r0;
    }

    public final void setRepeatCount(int r3) {
        setRepeatCount(r3);
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public void setReqIndex(int r1) {
        this.reqIndex = r1;
    }

    public void setRoomFanTicketCount(long r1) {
        this.roomFanTicketCount = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public void setSendGiftTime(long r1) {
        this.sendGiftTime = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public void setSendTogetherInfo(j3 r1) {
        this.sendTogetherInfo = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public void setSendType(int r1) {
        this.sendType = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public void setSeriesGiftData(List<? extends n3> r1) {
        this.seriesGiftData = r1;
    }

    public final void setTargetUserId(long r1) {
        this.targetUserId = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public void setToUserIds(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.toUserOpenIds = r2;
    }

    public final void setToUserOpenIds(List<String> r1) {
        this.toUserOpenIds = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public void setTraceId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this._traceId = r2;
    }

    public final void set_diyItemInfo(String r1) {
        this._diyItemInfo = r1;
    }

    public final void set_msgIdList(List<Long> r1) {
        this._msgIdList = r1;
    }

    public final void set_petEffectInfo(cb r1) {
        this._petEffectInfo = r1;
    }

    public final void set_props(List<l2> r1) {
        this._props = r1;
    }

    public final void set_toUserIds(List<Long> r1) {
        this._toUserIds = r1;
    }

    public final void set_traceId(String r1) {
        this._traceId = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public void setComboCount(long r1) {
        this.comboCount = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public void setGroupCount(long r1) {
        this.groupCount = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public void setLeftDiamonds(long r1) {
        this.leftDiamonds = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public void setPropType(long r1) {
        this.propType = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p2
    public void setRepeatCount(long r1) {
        this.repeatCount = r1;
    }
}
