package com.bytedance.android.livesdk.gift.platform.core;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.LiveGiftComboWidget;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.DIYCardSelectType;
import com.bytedance.android.livesdk.gift.platform.business.pkProp.PKBattlePropEffectWidget;
import com.bytedance.android.livesdk.log.model.WishComboDataLog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.kmp.core.KmpEnv;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import zg1.h2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000è\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002©\u0002B\t¢\u0006\u0006\b§\u0002\u0010¨\u0002R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R-\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u000fR!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0015R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0019\u0010\u0015R!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0005\u001a\u0004\b\u001d\u0010\u000fR-\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0005\u001a\u0004\b#\u0010\u0007R!\u0010(\u001a\b\u0012\u0004\u0012\u00020%0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0005\u001a\u0004\b'\u0010\u0007R!\u0010,\u001a\b\u0012\u0004\u0012\u00020)0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0005\u001a\u0004\b+\u0010\u0007R!\u0010/\u001a\b\u0012\u0004\u0012\u00020)0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u0005\u001a\u0004\b.\u0010\u0007R!\u00105\u001a\b\u0012\u0004\u0012\u000201008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u0005\u001a\u0004\b3\u00104R'\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000207060\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u0005\u001a\u0004\b9\u0010\u000fR!\u0010?\u001a\b\u0012\u0004\u0012\u00020\u000b0;8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\u0005\u001a\u0004\b=\u0010>R!\u0010C\u001a\b\u0012\u0004\u0012\u00020@008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bA\u0010\u0005\u001a\u0004\bB\u00104R!\u0010E\u001a\b\u0012\u0004\u0012\u00020)008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\u0005\u001a\u0004\bE\u00104R/\u0010I\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020 \u0012\u0006\u0012\u0004\u0018\u00010\u000b0F0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bG\u0010\u0005\u001a\u0004\bH\u0010\u000fR-\u0010L\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0F0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010\u0005\u001a\u0004\bK\u0010\u000fR!\u0010P\u001a\b\u0012\u0004\u0012\u00020M0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bN\u0010\u0005\u001a\u0004\bO\u0010\u000fR!\u0010S\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010\u0005\u001a\u0004\bR\u0010\u0007R!\u0010W\u001a\b\u0012\u0004\u0012\u00020T0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bU\u0010\u0005\u001a\u0004\bV\u0010\u0007R!\u0010[\u001a\b\u0012\u0004\u0012\u00020X008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bY\u0010\u0005\u001a\u0004\bZ\u00104R!\u0010^\u001a\b\u0012\u0004\u0012\u00020X0;8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010\u0005\u001a\u0004\b]\u0010>R!\u0010b\u001a\b\u0012\u0004\u0012\u00020_0;8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b`\u0010\u0005\u001a\u0004\ba\u0010>R!\u0010d\u001a\b\u0012\u0004\u0012\u00020)0;8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bc\u0010\u0005\u001a\u0004\bd\u0010>R!\u0010h\u001a\b\u0012\u0004\u0012\u00020e008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bf\u0010\u0005\u001a\u0004\bg\u00104R!\u0010k\u001a\b\u0012\u0004\u0012\u00020 0;8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bi\u0010\u0005\u001a\u0004\bj\u0010>R-\u0010o\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020l0F0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bm\u0010\u0005\u001a\u0004\bn\u0010\u000fR'\u0010s\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0p0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bq\u0010\u0005\u001a\u0004\br\u0010\u0007R-\u0010v\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bt\u0010\u0005\u001a\u0004\bu\u00104R!\u0010z\u001a\b\u0012\u0004\u0012\u00020w0;8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bx\u0010\u0005\u001a\u0004\by\u0010>R!\u0010}\u001a\b\u0012\u0004\u0012\u00020)0;8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b{\u0010\u0005\u001a\u0004\b|\u0010>R\"\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020)0;8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b~\u0010\u0005\u001a\u0004\b\u007f\u0010>R%\u0010\u0084\u0001\u001a\t\u0012\u0005\u0012\u00030\u0081\u00010;8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0082\u0001\u0010\u0005\u001a\u0005\b\u0083\u0001\u0010>R1\u0010\u0088\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020 \u0012\u0005\u0012\u00030\u0085\u00010F0\t8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0086\u0001\u0010\u0005\u001a\u0005\b\u0087\u0001\u0010\u000fR$\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020)0;8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0089\u0001\u0010\u0005\u001a\u0005\b\u008a\u0001\u0010>R$\u0010\u008e\u0001\u001a\b\u0012\u0004\u0012\u00020)0;8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u008c\u0001\u0010\u0005\u001a\u0005\b\u008d\u0001\u0010>R%\u0010\u0092\u0001\u001a\t\u0012\u0005\u0012\u00030\u008f\u00010;8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0090\u0001\u0010\u0005\u001a\u0005\b\u0091\u0001\u0010>R%\u0010\u0096\u0001\u001a\t\u0012\u0005\u0012\u00030\u0093\u00010\t8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0094\u0001\u0010\u0005\u001a\u0005\b\u0095\u0001\u0010\u000fR0\u0010\u0099\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0F0\t8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0097\u0001\u0010\u0005\u001a\u0005\b\u0098\u0001\u0010\u000fR%\u0010\u009d\u0001\u001a\t\u0012\u0005\u0012\u00030\u009a\u00010;8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u009b\u0001\u0010\u0005\u001a\u0005\b\u009c\u0001\u0010>R%\u0010¡\u0001\u001a\t\u0012\u0005\u0012\u00030\u009e\u00010\u00028FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u009f\u0001\u0010\u0005\u001a\u0005\b \u0001\u0010\u0007R$\u0010¤\u0001\u001a\b\u0012\u0004\u0012\u00020 0;8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¢\u0001\u0010\u0005\u001a\u0005\b£\u0001\u0010>R0\u0010§\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020@0F0\t8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¥\u0001\u0010\u0005\u001a\u0005\b¦\u0001\u0010\u000fR0\u0010ª\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020@0F0\t8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¨\u0001\u0010\u0005\u001a\u0005\b©\u0001\u0010\u000fR$\u0010\u00ad\u0001\u001a\b\u0012\u0004\u0012\u00020 0;8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b«\u0001\u0010\u0005\u001a\u0005\b¬\u0001\u0010>R$\u0010°\u0001\u001a\b\u0012\u0004\u0012\u00020 0;8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b®\u0001\u0010\u0005\u001a\u0005\b¯\u0001\u0010>R$\u0010³\u0001\u001a\b\u0012\u0004\u0012\u00020)0;8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b±\u0001\u0010\u0005\u001a\u0005\b²\u0001\u0010>R$\u0010µ\u0001\u001a\b\u0012\u0004\u0012\u00020)0;8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b´\u0001\u0010\u0005\u001a\u0005\bµ\u0001\u0010>R$\u0010¸\u0001\u001a\b\u0012\u0004\u0012\u00020 0;8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¶\u0001\u0010\u0005\u001a\u0005\b·\u0001\u0010>R$\u0010»\u0001\u001a\b\u0012\u0004\u0012\u00020)0;8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¹\u0001\u0010\u0005\u001a\u0005\bº\u0001\u0010>R$\u0010¾\u0001\u001a\b\u0012\u0004\u0012\u00020 0;8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¼\u0001\u0010\u0005\u001a\u0005\b½\u0001\u0010>R$\u0010Á\u0001\u001a\b\u0012\u0004\u0012\u00020 0;8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¿\u0001\u0010\u0005\u001a\u0005\bÀ\u0001\u0010>R%\u0010Å\u0001\u001a\t\u0012\u0005\u0012\u00030Â\u00010;8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÃ\u0001\u0010\u0005\u001a\u0005\bÄ\u0001\u0010>R$\u0010È\u0001\u001a\b\u0012\u0004\u0012\u00020)0\u00028FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÆ\u0001\u0010\u0005\u001a\u0005\bÇ\u0001\u0010\u0007R$\u0010Ë\u0001\u001a\b\u0012\u0004\u0012\u00020)0;8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÉ\u0001\u0010\u0005\u001a\u0005\bÊ\u0001\u0010>R$\u0010Î\u0001\u001a\b\u0012\u0004\u0012\u00020)0;8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÌ\u0001\u0010\u0005\u001a\u0005\bÍ\u0001\u0010>R%\u0010Ò\u0001\u001a\t\u0012\u0005\u0012\u00030Ï\u0001008FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÐ\u0001\u0010\u0005\u001a\u0005\bÑ\u0001\u00104R%\u0010Ö\u0001\u001a\t\u0012\u0005\u0012\u00030Ó\u00010\u00028FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÔ\u0001\u0010\u0005\u001a\u0005\bÕ\u0001\u0010\u0007R%\u0010Ú\u0001\u001a\t\u0012\u0005\u0012\u00030×\u00010\u00028FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bØ\u0001\u0010\u0005\u001a\u0005\bÙ\u0001\u0010\u0007R$\u0010Ý\u0001\u001a\b\u0012\u0004\u0012\u00020)0\u00028FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÛ\u0001\u0010\u0005\u001a\u0005\bÜ\u0001\u0010\u0007R$\u0010à\u0001\u001a\b\u0012\u0004\u0012\u00020%0\u00028FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÞ\u0001\u0010\u0005\u001a\u0005\bß\u0001\u0010\u0007R$\u0010â\u0001\u001a\b\u0012\u0004\u0012\u00020)0;8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bá\u0001\u0010\u0005\u001a\u0005\bâ\u0001\u0010>R$\u0010å\u0001\u001a\b\u0012\u0004\u0012\u00020@0;8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bã\u0001\u0010\u0005\u001a\u0005\bä\u0001\u0010>R$\u0010ç\u0001\u001a\b\u0012\u0004\u0012\u00020)0;8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bæ\u0001\u0010\u0005\u001a\u0005\bç\u0001\u0010>R$\u0010ê\u0001\u001a\b\u0012\u0004\u0012\u00020@008FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bè\u0001\u0010\u0005\u001a\u0005\bé\u0001\u00104R%\u0010î\u0001\u001a\t\u0012\u0005\u0012\u00030ë\u00010\u00118FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bì\u0001\u0010\u0005\u001a\u0005\bí\u0001\u0010\u0015R%\u0010ò\u0001\u001a\t\u0012\u0005\u0012\u00030ï\u0001008FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bð\u0001\u0010\u0005\u001a\u0005\bñ\u0001\u00104R$\u0010õ\u0001\u001a\b\u0012\u0004\u0012\u00020@0;8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bó\u0001\u0010\u0005\u001a\u0005\bô\u0001\u0010>R$\u0010ø\u0001\u001a\b\u0012\u0004\u0012\u00020)0\u00028FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bö\u0001\u0010\u0005\u001a\u0005\b÷\u0001\u0010\u0007R%\u0010ü\u0001\u001a\t\u0012\u0005\u0012\u00030ù\u0001008FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bú\u0001\u0010\u0005\u001a\u0005\bû\u0001\u00104R%\u0010ÿ\u0001\u001a\t\u0012\u0005\u0012\u00030ù\u0001008FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bý\u0001\u0010\u0005\u001a\u0005\bþ\u0001\u00104RB\u0010\u0084\u0002\u001a&\u0012\"\u0012 \u0012\u0004\u0012\u00020\u000b\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000b0\u0080\u0002j\t\u0012\u0004\u0012\u00020\u000b`\u0081\u00020F0\t8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0082\u0002\u0010\u0005\u001a\u0005\b\u0083\u0002\u0010\u000fR%\u0010\u0088\u0002\u001a\t\u0012\u0005\u0012\u00030\u0085\u0002008FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0086\u0002\u0010\u0005\u001a\u0005\b\u0087\u0002\u00104R%\u0010\u008c\u0002\u001a\t\u0012\u0005\u0012\u00030\u0089\u0002008FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u008a\u0002\u0010\u0005\u001a\u0005\b\u008b\u0002\u00104R)\u0010\u008d\u0002\u001a\u00020@8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008d\u0002\u0010\u008e\u0002\u001a\u0006\b\u008f\u0002\u0010\u0090\u0002\"\u0006\b\u0091\u0002\u0010\u0092\u0002R%\u0010\u0096\u0002\u001a\t\u0012\u0005\u0012\u00030\u0093\u0002008FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0094\u0002\u0010\u0005\u001a\u0005\b\u0095\u0002\u00104R)\u0010\u0097\u0002\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0097\u0002\u0010\u0098\u0002\u001a\u0006\b\u0099\u0002\u0010\u009a\u0002\"\u0006\b\u009b\u0002\u0010\u009c\u0002R$\u0010\u009f\u0002\u001a\b\u0012\u0004\u0012\u00020)0;8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u009d\u0002\u0010\u0005\u001a\u0005\b\u009e\u0002\u0010>R$\u0010¢\u0002\u001a\b\u0012\u0004\u0012\u00020@0;8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b \u0002\u0010\u0005\u001a\u0005\b¡\u0002\u0010>R%\u0010¦\u0002\u001a\t\u0012\u0005\u0012\u00030£\u00020;8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¤\u0002\u0010\u0005\u001a\u0005\b¥\u0002\u0010>¨\u0006ª\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/GiftContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/k;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/viewmodel/GiftStateMachineConfig$Event;", "giftActionManager$delegate", "Lcom/bytedance/live/datacontext/p;", "getGiftActionManager", "()Lcom/bytedance/live/datacontext/k;", "giftActionManager", "Lcom/bytedance/live/datacontext/i;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/viewmodel/a;", "giftViewModelMap$delegate", "getGiftViewModelMap", "()Lcom/bytedance/live/datacontext/i;", "giftViewModelMap", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/viewmodel/c;", "giftPluginActionManager$delegate", "getGiftPluginActionManager", "()Lcom/bytedance/live/datacontext/j;", "giftPluginActionManager", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/viewmodel/b;", "giftLazyActionManager$delegate", "getGiftLazyActionManager", "giftLazyActionManager", "Lcom/bytedance/android/livesdk/gift/platform/business/config/j;", "giftConfigStore$delegate", "getGiftConfigStore", "giftConfigStore", "Lkotlin/Pair;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/e0;", "updateGiftBanner$delegate", "getUpdateGiftBanner", "updateGiftBanner", BuildConfig.FLAVOR, "hideDialog$delegate", "getHideDialog", "hideDialog", BuildConfig.FLAVOR, "toggleVideoGiftView$delegate", "getToggleVideoGiftView", "toggleVideoGiftView", "needStopEffect$delegate", "getNeedStopEffect", "needStopEffect", "Lcom/bytedance/live/datacontext/n;", "Landroid/os/Bundle;", "giftLogExtra$delegate", "getGiftLogExtra", "()Lcom/bytedance/live/datacontext/n;", "giftLogExtra", BuildConfig.FLAVOR, "Lca0/s;", "giftSendResultListeners$delegate", "getGiftSendResultListeners", "giftSendResultListeners", "Lcom/bytedance/live/datacontext/m;", "giftListResultLogId$delegate", "getGiftListResultLogId", "()Lcom/bytedance/live/datacontext/m;", "giftListResultLogId", BuildConfig.FLAVOR, "currentSelectedGiftPosition$delegate", "getCurrentSelectedGiftPosition", "currentSelectedGiftPosition", "isContinuous$delegate", "isContinuous", BuildConfig.FLAVOR, "giftExhibitionMap$delegate", "getGiftExhibitionMap", "giftExhibitionMap", "giftBuffIdToOriginIdMap$delegate", "getGiftBuffIdToOriginIdMap", "giftBuffIdToOriginIdMap", "Lcom/bytedance/android/livesdk/gift/platform/business/tray2/k;", "messageDispatcher$delegate", "getMessageDispatcher", "messageDispatcher", "openGroupLiveDialog$delegate", "getOpenGroupLiveDialog", "openGroupLiveDialog", "Lzg1/f0;", "updateGiftTrayPosition$delegate", "getUpdateGiftTrayPosition", "updateGiftTrayPosition", "Lcom/bytedance/android/livesdk/gift/platform/core/GiftContext$a;", "lastClickRechargeSelectGift$delegate", "getLastClickRechargeSelectGift", "lastClickRechargeSelectGift", "lastSendGiftId$delegate", "getLastSendGiftId", "lastSendGiftId", "Lcom/bytedance/android/livesdk/log/model/WishComboDataLog;", "wishComboDataLog$delegate", "getWishComboDataLog", "wishComboDataLog", "isVS$delegate", "isVS", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room$delegate", "getRoom", "room", "episodeId$delegate", "getEpisodeId", "episodeId", "Lcom/bytedance/android/livesdk/gift/platform/core/l;", "giftIdMapToInfo$delegate", "getGiftIdMapToInfo", "giftIdMapToInfo", BuildConfig.FLAVOR, "giftStructChangeEvent$delegate", "getGiftStructChangeEvent", "giftStructChangeEvent", "effectConfig$delegate", "getEffectConfig", "effectConfig", "Lcom/bytedance/android/livesdk/gift/platform/core/x;", "hotRoomInfo$delegate", "getHotRoomInfo", "hotRoomInfo", "needShowGiftEffectSwitch$delegate", "getNeedShowGiftEffectSwitch", "needShowGiftEffectSwitch", "needShowGiftTraySwitch$delegate", "getNeedShowGiftTraySwitch", "needShowGiftTraySwitch", "Lcom/bytedance/android/livesdk/gift/platform/core/i;", "lastEventTimeStamp$delegate", "getLastEventTimeStamp", "lastEventTimeStamp", "Lcom/bytedance/android/livesdk/gift/platform/core/a;", "assetFetchSaver$delegate", "getAssetFetchSaver", "assetFetchSaver", "effectVibrateSwitch$delegate", "getEffectVibrateSwitch", "effectVibrateSwitch", "effectAudioSwitch$delegate", "getEffectAudioSwitch", "effectAudioSwitch", "Lcom/bytedance/android/livesdk/gift/platform/core/f0;", "rowLocation$delegate", "getRowLocation", "rowLocation", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/LiveGiftComboWidget;", "liveGiftComboWidget$delegate", "getLiveGiftComboWidget", "liveGiftComboWidget", "newGiftProp$delegate", "getNewGiftProp", "newGiftProp", "Lcom/bytedance/android/livesdk/gift/platform/core/c;", "bubbleBuffLevel$delegate", "getBubbleBuffLevel", "bubbleBuffLevel", "Lcom/bytedance/android/livesdk/gift/platform/core/e0;", "openBigGiftDialogEvent$delegate", "getOpenBigGiftDialogEvent", "openBigGiftDialogEvent", "bigGiftKeyCount$delegate", "getBigGiftKeyCount", "bigGiftKeyCount", "viewHolderCreateTimes$delegate", "getViewHolderCreateTimes", "viewHolderCreateTimes", "viewHolderBindTimes$delegate", "getViewHolderBindTimes", "viewHolderBindTimes", "sendGiftTime$delegate", "getSendGiftTime", "sendGiftTime", "sendGiftMoney$delegate", "getSendGiftMoney", "sendGiftMoney", "degradeSetting$delegate", "getDegradeSetting", "degradeSetting", "isVSPadUseVerticalStyle$delegate", "isVSPadUseVerticalStyle", "firstGiftImageRenderSucAt$delegate", "getFirstGiftImageRenderSucAt", "firstGiftImageRenderSucAt", "firstViewHolderAttached$delegate", "getFirstViewHolderAttached", "firstViewHolderAttached", "giftPanelFirstRenderTs$delegate", "getGiftPanelFirstRenderTs", "giftPanelFirstRenderTs", "defaultGiftLocatedAt$delegate", "getDefaultGiftLocatedAt", "defaultGiftLocatedAt", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/DIYCardSelectType;", "customizeBuffSelectType$delegate", "getCustomizeBuffSelectType", "customizeBuffSelectType", "audienceListChange$delegate", "getAudienceListChange", "audienceListChange", "cancelComboForDegradeInMatch$delegate", "getCancelComboForDegradeInMatch", "cancelComboForDegradeInMatch", "needSendCloseMessageSwitch$delegate", "getNeedSendCloseMessageSwitch", "needSendCloseMessageSwitch", "Li02/a;", "currentSendTogetherInfo$delegate", "getCurrentSendTogetherInfo", "currentSendTogetherInfo", "Li02/d;", "sendTogetherSlotChangeEvent$delegate", "getSendTogetherSlotChangeEvent", "sendTogetherSlotChangeEvent", "Lzg1/h2;", "playLynxAlphaVideoEvent$delegate", "getPlayLynxAlphaVideoEvent", "playLynxAlphaVideoEvent", "giftBannerShowEvent$delegate", "getGiftBannerShowEvent", "giftBannerShowEvent", "giftDialogCloseEvent$delegate", "getGiftDialogCloseEvent", "giftDialogCloseEvent", "isGiftDialogOpen$delegate", "isGiftDialogOpen", "msgCount$delegate", "getMsgCount", "msgCount", "isIntercept$delegate", "isIntercept", "giftTrayTempPosition$delegate", "getGiftTrayTempPosition", "giftTrayTempPosition", "Lcom/bytedance/android/live/revenue/common/n;", "toolbarGiftAnimController$delegate", "getToolbarGiftAnimController", "toolbarGiftAnimController", "Lmy1/a;", "fastTaskGiftModel$delegate", "getFastTaskGiftModel", "fastTaskGiftModel", "pageType$delegate", "getPageType", "pageType", "giftTrayTempComboUpdateEvent$delegate", "getGiftTrayTempComboUpdateEvent", "giftTrayTempComboUpdateEvent", "Landroid/view/ViewGroup;", "pkTrayTempContainer$delegate", "getPkTrayTempContainer", "pkTrayTempContainer", "atmosphereContainer$delegate", "getAtmosphereContainer", "atmosphereContainer", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/revenue/platform/api/core/CopyOnWriteArrayList;", "loadedEffectResourceMap$delegate", "getLoadedEffectResourceMap", "loadedEffectResourceMap", "Lcom/bytedance/android/livesdk/gift/platform/business/pkProp/PKBattlePropEffectWidget;", "pkBattlePropEffectWidget$delegate", "getPkBattlePropEffectWidget", "pkBattlePropEffectWidget", "Landroid/view/View;", "giftIcon$delegate", "getGiftIcon", "giftIcon", "panelOpenTimes", "I", "getPanelOpenTimes", "()I", "setPanelOpenTimes", "(I)V", "Lcom/bytedance/android/livesdk/gift/platform/core/d;", "currentGiftEffect$delegate", "getCurrentGiftEffect", "currentGiftEffect", "enterRoomTime", "J", "getEnterRoomTime", "()J", "setEnterRoomTime", "(J)V", "hasLinkEffectSo$delegate", "getHasLinkEffectSo", "hasLinkEffectSo", "giftTabMarginWidth$delegate", "getGiftTabMarginWidth", "giftTabMarginWidth", "Lca0/i;", "giftRenderFilterWrapper$delegate", "getGiftRenderFilterWrapper", "giftRenderFilterWrapper", "<init>", "()V", "a", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final com.bytedance.live.datacontext.p assetFetchSaver$delegate;
    private final com.bytedance.live.datacontext.p atmosphereContainer$delegate;
    private final com.bytedance.live.datacontext.p audienceListChange$delegate;
    private final com.bytedance.live.datacontext.p bigGiftKeyCount$delegate;
    private final com.bytedance.live.datacontext.p bubbleBuffLevel$delegate;
    private final com.bytedance.live.datacontext.p cancelComboForDegradeInMatch$delegate;
    private final com.bytedance.live.datacontext.p currentGiftEffect$delegate;
    private final com.bytedance.live.datacontext.p currentSelectedGiftPosition$delegate;
    private final com.bytedance.live.datacontext.p currentSendTogetherInfo$delegate;
    private final com.bytedance.live.datacontext.p customizeBuffSelectType$delegate;
    private final com.bytedance.live.datacontext.p defaultGiftLocatedAt$delegate;
    private final com.bytedance.live.datacontext.p degradeSetting$delegate;
    private final com.bytedance.live.datacontext.p effectAudioSwitch$delegate;
    private final com.bytedance.live.datacontext.p effectConfig$delegate;
    private final com.bytedance.live.datacontext.p effectVibrateSwitch$delegate;
    private long enterRoomTime;
    private final com.bytedance.live.datacontext.p episodeId$delegate;
    private final com.bytedance.live.datacontext.p fastTaskGiftModel$delegate;
    private final com.bytedance.live.datacontext.p firstGiftImageRenderSucAt$delegate;
    private final com.bytedance.live.datacontext.p firstViewHolderAttached$delegate;
    private final com.bytedance.live.datacontext.p giftActionManager$delegate;
    private final com.bytedance.live.datacontext.p giftBannerShowEvent$delegate;
    private final com.bytedance.live.datacontext.p giftBuffIdToOriginIdMap$delegate;
    private final com.bytedance.live.datacontext.p giftConfigStore$delegate;
    private final com.bytedance.live.datacontext.p giftDialogCloseEvent$delegate;
    private final com.bytedance.live.datacontext.p giftExhibitionMap$delegate;
    private final com.bytedance.live.datacontext.p giftIcon$delegate;
    private final com.bytedance.live.datacontext.p giftIdMapToInfo$delegate;
    private final com.bytedance.live.datacontext.p giftLazyActionManager$delegate;
    private final com.bytedance.live.datacontext.p giftListResultLogId$delegate;
    private final com.bytedance.live.datacontext.p giftLogExtra$delegate;
    private final com.bytedance.live.datacontext.p giftPanelFirstRenderTs$delegate;
    private final com.bytedance.live.datacontext.p giftPluginActionManager$delegate;
    private final com.bytedance.live.datacontext.p giftRenderFilterWrapper$delegate;
    private final com.bytedance.live.datacontext.p giftSendResultListeners$delegate;
    private final com.bytedance.live.datacontext.p giftStructChangeEvent$delegate;
    private final com.bytedance.live.datacontext.p giftTabMarginWidth$delegate;
    private final com.bytedance.live.datacontext.p giftTrayTempComboUpdateEvent$delegate;
    private final com.bytedance.live.datacontext.p giftTrayTempPosition$delegate;
    private final com.bytedance.live.datacontext.p giftViewModelMap$delegate;
    private final com.bytedance.live.datacontext.p hasLinkEffectSo$delegate;
    private final com.bytedance.live.datacontext.p hideDialog$delegate;
    private final com.bytedance.live.datacontext.p hotRoomInfo$delegate;
    private final com.bytedance.live.datacontext.p isContinuous$delegate;
    private final com.bytedance.live.datacontext.p isGiftDialogOpen$delegate;
    private final com.bytedance.live.datacontext.p isIntercept$delegate;
    private final com.bytedance.live.datacontext.p isVS$delegate;
    private final com.bytedance.live.datacontext.p isVSPadUseVerticalStyle$delegate;
    private final com.bytedance.live.datacontext.p lastClickRechargeSelectGift$delegate;
    private final com.bytedance.live.datacontext.p lastEventTimeStamp$delegate;
    private final com.bytedance.live.datacontext.p lastSendGiftId$delegate;
    private final com.bytedance.live.datacontext.p liveGiftComboWidget$delegate;
    private final com.bytedance.live.datacontext.p loadedEffectResourceMap$delegate;
    private final com.bytedance.live.datacontext.p messageDispatcher$delegate;
    private final com.bytedance.live.datacontext.p msgCount$delegate;
    private final com.bytedance.live.datacontext.p needSendCloseMessageSwitch$delegate;
    private final com.bytedance.live.datacontext.p needShowGiftEffectSwitch$delegate;
    private final com.bytedance.live.datacontext.p needShowGiftTraySwitch$delegate;
    private final com.bytedance.live.datacontext.p needStopEffect$delegate;
    private final com.bytedance.live.datacontext.p newGiftProp$delegate;
    private final com.bytedance.live.datacontext.p openBigGiftDialogEvent$delegate;
    private final com.bytedance.live.datacontext.p openGroupLiveDialog$delegate;
    private final com.bytedance.live.datacontext.p pageType$delegate;
    private int panelOpenTimes;
    private final com.bytedance.live.datacontext.p pkBattlePropEffectWidget$delegate;
    private final com.bytedance.live.datacontext.p pkTrayTempContainer$delegate;
    private final com.bytedance.live.datacontext.p playLynxAlphaVideoEvent$delegate;
    private final com.bytedance.live.datacontext.p room$delegate;
    private final com.bytedance.live.datacontext.p rowLocation$delegate;
    private final com.bytedance.live.datacontext.p sendGiftMoney$delegate;
    private final com.bytedance.live.datacontext.p sendGiftTime$delegate;
    private final com.bytedance.live.datacontext.p sendTogetherSlotChangeEvent$delegate;
    private final com.bytedance.live.datacontext.p toggleVideoGiftView$delegate;
    private final com.bytedance.live.datacontext.p toolbarGiftAnimController$delegate;
    private final com.bytedance.live.datacontext.p updateGiftBanner$delegate;
    private final com.bytedance.live.datacontext.p updateGiftTrayPosition$delegate;
    private final com.bytedance.live.datacontext.p viewHolderBindTimes$delegate;
    private final com.bytedance.live.datacontext.p viewHolderCreateTimes$delegate;
    private final com.bytedance.live.datacontext.p wishComboDataLog$delegate;

    public static final class a {
        public final long a;
        public final int b;
        public final int c;

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof a) == false) goto L12;
            a r7 = (a) r6;
            if (this.a == r7.a) goto L8;
            return false;
        L8:
            if (this.b == r7.b) goto L10;
            return false;
        L10:
            if (this.c == r7.c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            long r0 = this.a;
            return (((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31) + this.c;
        }

        public final String toString() {
            return "DefaultGiftStruct(giftId=" + this.a + ", buffLevel=" + this.b + ", pageType=" + this.c + ")";
        }

        public /* synthetic */ a() {
            this(0, 0, 0);
        }

        public a(long r1, int r3, int r4) {
            this.a = r1;
            this.b = r3;
            this.c = r4;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(GiftContext.class, "giftActionManager", "getGiftActionManager()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "giftViewModelMap", "getGiftViewModelMap()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "giftPluginActionManager", "getGiftPluginActionManager()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "giftLazyActionManager", "getGiftLazyActionManager()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "giftConfigStore", "getGiftConfigStore()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "updateGiftBanner", "getUpdateGiftBanner()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "hideDialog", "getHideDialog()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "toggleVideoGiftView", "getToggleVideoGiftView()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "needStopEffect", "getNeedStopEffect()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "giftLogExtra", "getGiftLogExtra()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "giftSendResultListeners", "getGiftSendResultListeners()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "giftListResultLogId", "getGiftListResultLogId()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "currentSelectedGiftPosition", "getCurrentSelectedGiftPosition()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "isContinuous", "isContinuous()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "giftExhibitionMap", "getGiftExhibitionMap()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "giftBuffIdToOriginIdMap", "getGiftBuffIdToOriginIdMap()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "messageDispatcher", "getMessageDispatcher()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "openGroupLiveDialog", "getOpenGroupLiveDialog()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "updateGiftTrayPosition", "getUpdateGiftTrayPosition()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "lastClickRechargeSelectGift", "getLastClickRechargeSelectGift()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "lastSendGiftId", "getLastSendGiftId()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "wishComboDataLog", "getWishComboDataLog()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "isVS", "isVS()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "room", "getRoom()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "episodeId", "getEpisodeId()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "giftIdMapToInfo", "getGiftIdMapToInfo()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "giftStructChangeEvent", "getGiftStructChangeEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "effectConfig", "getEffectConfig()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "hotRoomInfo", "getHotRoomInfo()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "needShowGiftEffectSwitch", "getNeedShowGiftEffectSwitch()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "needShowGiftTraySwitch", "getNeedShowGiftTraySwitch()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "lastEventTimeStamp", "getLastEventTimeStamp()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "assetFetchSaver", "getAssetFetchSaver()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "effectVibrateSwitch", "getEffectVibrateSwitch()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "effectAudioSwitch", "getEffectAudioSwitch()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "rowLocation", "getRowLocation()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "liveGiftComboWidget", "getLiveGiftComboWidget()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "newGiftProp", "getNewGiftProp()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "bubbleBuffLevel", "getBubbleBuffLevel()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "openBigGiftDialogEvent", "getOpenBigGiftDialogEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "bigGiftKeyCount", "getBigGiftKeyCount()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "viewHolderCreateTimes", "getViewHolderCreateTimes()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "viewHolderBindTimes", "getViewHolderBindTimes()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "sendGiftTime", "getSendGiftTime()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "sendGiftMoney", "getSendGiftMoney()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "degradeSetting", "getDegradeSetting()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "isVSPadUseVerticalStyle", "isVSPadUseVerticalStyle()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "firstGiftImageRenderSucAt", "getFirstGiftImageRenderSucAt()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "firstViewHolderAttached", "getFirstViewHolderAttached()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "giftPanelFirstRenderTs", "getGiftPanelFirstRenderTs()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "defaultGiftLocatedAt", "getDefaultGiftLocatedAt()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "customizeBuffSelectType", "getCustomizeBuffSelectType()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "audienceListChange", "getAudienceListChange()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "cancelComboForDegradeInMatch", "getCancelComboForDegradeInMatch()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "needSendCloseMessageSwitch", "getNeedSendCloseMessageSwitch()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "currentSendTogetherInfo", "getCurrentSendTogetherInfo()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "sendTogetherSlotChangeEvent", "getSendTogetherSlotChangeEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "playLynxAlphaVideoEvent", "getPlayLynxAlphaVideoEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "giftBannerShowEvent", "getGiftBannerShowEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "giftDialogCloseEvent", "getGiftDialogCloseEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "isGiftDialogOpen", "isGiftDialogOpen()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "msgCount", "getMsgCount()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "isIntercept", "isIntercept()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "giftTrayTempPosition", "getGiftTrayTempPosition()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "toolbarGiftAnimController", "getToolbarGiftAnimController()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "fastTaskGiftModel", "getFastTaskGiftModel()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "pageType", "getPageType()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "giftTrayTempComboUpdateEvent", "getGiftTrayTempComboUpdateEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "pkTrayTempContainer", "getPkTrayTempContainer()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "atmosphereContainer", "getAtmosphereContainer()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "loadedEffectResourceMap", "getLoadedEffectResourceMap()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "pkBattlePropEffectWidget", "getPkBattlePropEffectWidget()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "giftIcon", "getGiftIcon()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "currentGiftEffect", "getCurrentGiftEffect()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "hasLinkEffectSo", "getHasLinkEffectSo()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "giftTabMarginWidth", "getGiftTabMarginWidth()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(GiftContext.class, "giftRenderFilterWrapper", "getGiftRenderFilterWrapper()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
    }

    public final com.bytedance.live.datacontext.i<Map<Long, com.bytedance.android.livesdk.gift.platform.core.a>> getAssetFetchSaver() {
        return (com.bytedance.live.datacontext.i) this.assetFetchSaver$delegate.a(this, $$delegatedProperties[32]);
    }

    public final com.bytedance.live.datacontext.n<ViewGroup> getAtmosphereContainer() {
        return (com.bytedance.live.datacontext.n) this.atmosphereContainer$delegate.a(this, $$delegatedProperties[69]);
    }

    public final com.bytedance.live.datacontext.k<Boolean> getAudienceListChange() {
        return (com.bytedance.live.datacontext.k) this.audienceListChange$delegate.a(this, $$delegatedProperties[52]);
    }

    public final com.bytedance.live.datacontext.m<Long> getBigGiftKeyCount() {
        return (com.bytedance.live.datacontext.m) this.bigGiftKeyCount$delegate.a(this, $$delegatedProperties[40]);
    }

    public final com.bytedance.live.datacontext.m<c> getBubbleBuffLevel() {
        return (com.bytedance.live.datacontext.m) this.bubbleBuffLevel$delegate.a(this, $$delegatedProperties[38]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> getCancelComboForDegradeInMatch() {
        return (com.bytedance.live.datacontext.m) this.cancelComboForDegradeInMatch$delegate.a(this, $$delegatedProperties[53]);
    }

    public final com.bytedance.live.datacontext.n<d> getCurrentGiftEffect() {
        return (com.bytedance.live.datacontext.n) this.currentGiftEffect$delegate.a(this, $$delegatedProperties[73]);
    }

    public final com.bytedance.live.datacontext.n<Integer> getCurrentSelectedGiftPosition() {
        return (com.bytedance.live.datacontext.n) this.currentSelectedGiftPosition$delegate.a(this, $$delegatedProperties[12]);
    }

    public final com.bytedance.live.datacontext.n<i02.a> getCurrentSendTogetherInfo() {
        return (com.bytedance.live.datacontext.n) this.currentSendTogetherInfo$delegate.a(this, $$delegatedProperties[55]);
    }

    public final com.bytedance.live.datacontext.m<DIYCardSelectType> getCustomizeBuffSelectType() {
        return (com.bytedance.live.datacontext.m) this.customizeBuffSelectType$delegate.a(this, $$delegatedProperties[51]);
    }

    public final com.bytedance.live.datacontext.m<Long> getDefaultGiftLocatedAt() {
        return (com.bytedance.live.datacontext.m) this.defaultGiftLocatedAt$delegate.a(this, $$delegatedProperties[50]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> getDegradeSetting() {
        return (com.bytedance.live.datacontext.m) this.degradeSetting$delegate.a(this, $$delegatedProperties[45]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> getEffectAudioSwitch() {
        return (com.bytedance.live.datacontext.m) this.effectAudioSwitch$delegate.a(this, $$delegatedProperties[34]);
    }

    public final com.bytedance.live.datacontext.n<Map<String, String>> getEffectConfig() {
        return (com.bytedance.live.datacontext.n) this.effectConfig$delegate.a(this, $$delegatedProperties[27]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> getEffectVibrateSwitch() {
        return (com.bytedance.live.datacontext.m) this.effectVibrateSwitch$delegate.a(this, $$delegatedProperties[33]);
    }

    public final com.bytedance.live.datacontext.m<Long> getEpisodeId() {
        return (com.bytedance.live.datacontext.m) this.episodeId$delegate.a(this, $$delegatedProperties[24]);
    }

    public final com.bytedance.live.datacontext.n<my1.a> getFastTaskGiftModel() {
        return (com.bytedance.live.datacontext.n) this.fastTaskGiftModel$delegate.a(this, $$delegatedProperties[65]);
    }

    public final com.bytedance.live.datacontext.m<Long> getFirstGiftImageRenderSucAt() {
        return (com.bytedance.live.datacontext.m) this.firstGiftImageRenderSucAt$delegate.a(this, $$delegatedProperties[47]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> getFirstViewHolderAttached() {
        return (com.bytedance.live.datacontext.m) this.firstViewHolderAttached$delegate.a(this, $$delegatedProperties[48]);
    }

    public final com.bytedance.live.datacontext.k<GiftStateMachineConfig.Event> getGiftActionManager() {
        return (com.bytedance.live.datacontext.k) this.giftActionManager$delegate.a(this, $$delegatedProperties[0]);
    }

    public final com.bytedance.live.datacontext.k<Boolean> getGiftBannerShowEvent() {
        return (com.bytedance.live.datacontext.k) this.giftBannerShowEvent$delegate.a(this, $$delegatedProperties[58]);
    }

    public final com.bytedance.live.datacontext.i<Map<Long, Long>> getGiftBuffIdToOriginIdMap() {
        return (com.bytedance.live.datacontext.i) this.giftBuffIdToOriginIdMap$delegate.a(this, $$delegatedProperties[15]);
    }

    public final com.bytedance.live.datacontext.i<com.bytedance.android.livesdk.gift.platform.business.config.j> getGiftConfigStore() {
        return (com.bytedance.live.datacontext.i) this.giftConfigStore$delegate.a(this, $$delegatedProperties[4]);
    }

    public final com.bytedance.live.datacontext.k<Unit> getGiftDialogCloseEvent() {
        return (com.bytedance.live.datacontext.k) this.giftDialogCloseEvent$delegate.a(this, $$delegatedProperties[59]);
    }

    public final com.bytedance.live.datacontext.i<Map<Long, String>> getGiftExhibitionMap() {
        return (com.bytedance.live.datacontext.i) this.giftExhibitionMap$delegate.a(this, $$delegatedProperties[14]);
    }

    public final com.bytedance.live.datacontext.n<View> getGiftIcon() {
        return (com.bytedance.live.datacontext.n) this.giftIcon$delegate.a(this, $$delegatedProperties[72]);
    }

    public final com.bytedance.live.datacontext.i<Map<Long, l>> getGiftIdMapToInfo() {
        return (com.bytedance.live.datacontext.i) this.giftIdMapToInfo$delegate.a(this, $$delegatedProperties[25]);
    }

    public final com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.b> getGiftLazyActionManager() {
        return (com.bytedance.live.datacontext.j) this.giftLazyActionManager$delegate.a(this, $$delegatedProperties[3]);
    }

    public final com.bytedance.live.datacontext.m<String> getGiftListResultLogId() {
        return (com.bytedance.live.datacontext.m) this.giftListResultLogId$delegate.a(this, $$delegatedProperties[11]);
    }

    public final com.bytedance.live.datacontext.n<Bundle> getGiftLogExtra() {
        return (com.bytedance.live.datacontext.n) this.giftLogExtra$delegate.a(this, $$delegatedProperties[9]);
    }

    public final com.bytedance.live.datacontext.m<Long> getGiftPanelFirstRenderTs() {
        return (com.bytedance.live.datacontext.m) this.giftPanelFirstRenderTs$delegate.a(this, $$delegatedProperties[49]);
    }

    public final com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.c> getGiftPluginActionManager() {
        return (com.bytedance.live.datacontext.j) this.giftPluginActionManager$delegate.a(this, $$delegatedProperties[2]);
    }

    public final com.bytedance.live.datacontext.m<ca0.i> getGiftRenderFilterWrapper() {
        return (com.bytedance.live.datacontext.m) this.giftRenderFilterWrapper$delegate.a(this, $$delegatedProperties[76]);
    }

    public final com.bytedance.live.datacontext.i<Set<ca0.s>> getGiftSendResultListeners() {
        return (com.bytedance.live.datacontext.i) this.giftSendResultListeners$delegate.a(this, $$delegatedProperties[10]);
    }

    public final com.bytedance.live.datacontext.k<List<Long>> getGiftStructChangeEvent() {
        return (com.bytedance.live.datacontext.k) this.giftStructChangeEvent$delegate.a(this, $$delegatedProperties[26]);
    }

    public final com.bytedance.live.datacontext.m<Integer> getGiftTabMarginWidth() {
        return (com.bytedance.live.datacontext.m) this.giftTabMarginWidth$delegate.a(this, $$delegatedProperties[75]);
    }

    public final com.bytedance.live.datacontext.k<Boolean> getGiftTrayTempComboUpdateEvent() {
        return (com.bytedance.live.datacontext.k) this.giftTrayTempComboUpdateEvent$delegate.a(this, $$delegatedProperties[67]);
    }

    public final com.bytedance.live.datacontext.n<Integer> getGiftTrayTempPosition() {
        return (com.bytedance.live.datacontext.n) this.giftTrayTempPosition$delegate.a(this, $$delegatedProperties[63]);
    }

    public final com.bytedance.live.datacontext.i<Map<String, com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a>> getGiftViewModelMap() {
        return (com.bytedance.live.datacontext.i) this.giftViewModelMap$delegate.a(this, $$delegatedProperties[1]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> getHasLinkEffectSo() {
        return (com.bytedance.live.datacontext.m) this.hasLinkEffectSo$delegate.a(this, $$delegatedProperties[74]);
    }

    public final com.bytedance.live.datacontext.k<Unit> getHideDialog() {
        return (com.bytedance.live.datacontext.k) this.hideDialog$delegate.a(this, $$delegatedProperties[6]);
    }

    public final com.bytedance.live.datacontext.m<x> getHotRoomInfo() {
        return (com.bytedance.live.datacontext.m) this.hotRoomInfo$delegate.a(this, $$delegatedProperties[28]);
    }

    public final com.bytedance.live.datacontext.n<a> getLastClickRechargeSelectGift() {
        return (com.bytedance.live.datacontext.n) this.lastClickRechargeSelectGift$delegate.a(this, $$delegatedProperties[19]);
    }

    public final com.bytedance.live.datacontext.m<i> getLastEventTimeStamp() {
        return (com.bytedance.live.datacontext.m) this.lastEventTimeStamp$delegate.a(this, $$delegatedProperties[31]);
    }

    public final com.bytedance.live.datacontext.m<a> getLastSendGiftId() {
        return (com.bytedance.live.datacontext.m) this.lastSendGiftId$delegate.a(this, $$delegatedProperties[20]);
    }

    public final com.bytedance.live.datacontext.i<LiveGiftComboWidget> getLiveGiftComboWidget() {
        return (com.bytedance.live.datacontext.i) this.liveGiftComboWidget$delegate.a(this, $$delegatedProperties[36]);
    }

    public final com.bytedance.live.datacontext.i<Map<String, CopyOnWriteArrayList<String>>> getLoadedEffectResourceMap() {
        return (com.bytedance.live.datacontext.i) this.loadedEffectResourceMap$delegate.a(this, $$delegatedProperties[70]);
    }

    public final com.bytedance.live.datacontext.i<com.bytedance.android.livesdk.gift.platform.business.tray2.k> getMessageDispatcher() {
        return (com.bytedance.live.datacontext.i) this.messageDispatcher$delegate.a(this, $$delegatedProperties[16]);
    }

    public final com.bytedance.live.datacontext.m<Integer> getMsgCount() {
        return (com.bytedance.live.datacontext.m) this.msgCount$delegate.a(this, $$delegatedProperties[61]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> getNeedSendCloseMessageSwitch() {
        return (com.bytedance.live.datacontext.m) this.needSendCloseMessageSwitch$delegate.a(this, $$delegatedProperties[54]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> getNeedShowGiftEffectSwitch() {
        return (com.bytedance.live.datacontext.m) this.needShowGiftEffectSwitch$delegate.a(this, $$delegatedProperties[29]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> getNeedShowGiftTraySwitch() {
        return (com.bytedance.live.datacontext.m) this.needShowGiftTraySwitch$delegate.a(this, $$delegatedProperties[30]);
    }

    public final com.bytedance.live.datacontext.k<Boolean> getNeedStopEffect() {
        return (com.bytedance.live.datacontext.k) this.needStopEffect$delegate.a(this, $$delegatedProperties[8]);
    }

    public final com.bytedance.live.datacontext.i<Map<Long, Long>> getNewGiftProp() {
        return (com.bytedance.live.datacontext.i) this.newGiftProp$delegate.a(this, $$delegatedProperties[37]);
    }

    public final com.bytedance.live.datacontext.k<e0> getOpenBigGiftDialogEvent() {
        return (com.bytedance.live.datacontext.k) this.openBigGiftDialogEvent$delegate.a(this, $$delegatedProperties[39]);
    }

    public final com.bytedance.live.datacontext.k<String> getOpenGroupLiveDialog() {
        return (com.bytedance.live.datacontext.k) this.openGroupLiveDialog$delegate.a(this, $$delegatedProperties[17]);
    }

    public final com.bytedance.live.datacontext.m<Integer> getPageType() {
        return (com.bytedance.live.datacontext.m) this.pageType$delegate.a(this, $$delegatedProperties[66]);
    }

    public final com.bytedance.live.datacontext.n<PKBattlePropEffectWidget> getPkBattlePropEffectWidget() {
        return (com.bytedance.live.datacontext.n) this.pkBattlePropEffectWidget$delegate.a(this, $$delegatedProperties[71]);
    }

    public final com.bytedance.live.datacontext.n<ViewGroup> getPkTrayTempContainer() {
        return (com.bytedance.live.datacontext.n) this.pkTrayTempContainer$delegate.a(this, $$delegatedProperties[68]);
    }

    public final com.bytedance.live.datacontext.k<h2> getPlayLynxAlphaVideoEvent() {
        return (com.bytedance.live.datacontext.k) this.playLynxAlphaVideoEvent$delegate.a(this, $$delegatedProperties[57]);
    }

    public final com.bytedance.live.datacontext.n<IRoom> getRoom() {
        return (com.bytedance.live.datacontext.n) this.room$delegate.a(this, $$delegatedProperties[23]);
    }

    public final com.bytedance.live.datacontext.m<f0> getRowLocation() {
        return (com.bytedance.live.datacontext.m) this.rowLocation$delegate.a(this, $$delegatedProperties[35]);
    }

    public final com.bytedance.live.datacontext.m<Long> getSendGiftMoney() {
        return (com.bytedance.live.datacontext.m) this.sendGiftMoney$delegate.a(this, $$delegatedProperties[44]);
    }

    public final com.bytedance.live.datacontext.m<Long> getSendGiftTime() {
        return (com.bytedance.live.datacontext.m) this.sendGiftTime$delegate.a(this, $$delegatedProperties[43]);
    }

    public final com.bytedance.live.datacontext.k<i02.d> getSendTogetherSlotChangeEvent() {
        return (com.bytedance.live.datacontext.k) this.sendTogetherSlotChangeEvent$delegate.a(this, $$delegatedProperties[56]);
    }

    public final com.bytedance.live.datacontext.k<Boolean> getToggleVideoGiftView() {
        return (com.bytedance.live.datacontext.k) this.toggleVideoGiftView$delegate.a(this, $$delegatedProperties[7]);
    }

    public final com.bytedance.live.datacontext.j<com.bytedance.android.live.revenue.common.n> getToolbarGiftAnimController() {
        return (com.bytedance.live.datacontext.j) this.toolbarGiftAnimController$delegate.a(this, $$delegatedProperties[64]);
    }

    public final com.bytedance.live.datacontext.k<Pair<Long, com.bytedance.android.livesdk.gift.model.e0>> getUpdateGiftBanner() {
        return (com.bytedance.live.datacontext.k) this.updateGiftBanner$delegate.a(this, $$delegatedProperties[5]);
    }

    public final com.bytedance.live.datacontext.k<zg1.f0> getUpdateGiftTrayPosition() {
        return (com.bytedance.live.datacontext.k) this.updateGiftTrayPosition$delegate.a(this, $$delegatedProperties[18]);
    }

    public final com.bytedance.live.datacontext.i<Map<String, Integer>> getViewHolderBindTimes() {
        return (com.bytedance.live.datacontext.i) this.viewHolderBindTimes$delegate.a(this, $$delegatedProperties[42]);
    }

    public final com.bytedance.live.datacontext.i<Map<Integer, Integer>> getViewHolderCreateTimes() {
        return (com.bytedance.live.datacontext.i) this.viewHolderCreateTimes$delegate.a(this, $$delegatedProperties[41]);
    }

    public final com.bytedance.live.datacontext.m<WishComboDataLog> getWishComboDataLog() {
        return (com.bytedance.live.datacontext.m) this.wishComboDataLog$delegate.a(this, $$delegatedProperties[21]);
    }

    public final com.bytedance.live.datacontext.n<Boolean> isContinuous() {
        return (com.bytedance.live.datacontext.n) this.isContinuous$delegate.a(this, $$delegatedProperties[13]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> isGiftDialogOpen() {
        return (com.bytedance.live.datacontext.m) this.isGiftDialogOpen$delegate.a(this, $$delegatedProperties[60]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> isIntercept() {
        return (com.bytedance.live.datacontext.m) this.isIntercept$delegate.a(this, $$delegatedProperties[62]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> isVS() {
        return (com.bytedance.live.datacontext.m) this.isVS$delegate.a(this, $$delegatedProperties[22]);
    }

    public final com.bytedance.live.datacontext.m<Boolean> isVSPadUseVerticalStyle() {
        return (com.bytedance.live.datacontext.m) this.isVSPadUseVerticalStyle$delegate.a(this, $$delegatedProperties[46]);
    }

    public GiftContext() {
        this.giftActionManager$delegate = com.bytedance.live.datacontext.e.b(this);
        this.giftViewModelMap$delegate = ConstantKt.a(this, new HashMap(), GiftContext$giftViewModelMap$2.INSTANCE);
        this.giftPluginActionManager$delegate = ConstantKt.b(this, GiftContext$giftPluginActionManager$2.INSTANCE);
        this.giftLazyActionManager$delegate = ConstantKt.b(this, GiftContext$giftLazyActionManager$2.INSTANCE);
        this.giftConfigStore$delegate = ConstantKt.d(this, new com.bytedance.android.livesdk.gift.platform.business.config.c().create());
        this.updateGiftBanner$delegate = com.bytedance.live.datacontext.e.b(this);
        this.hideDialog$delegate = com.bytedance.live.datacontext.e.b(this);
        this.toggleVideoGiftView$delegate = com.bytedance.live.datacontext.e.b(this);
        this.needStopEffect$delegate = com.bytedance.live.datacontext.e.b(this);
        this.giftLogExtra$delegate = com.bytedance.live.datacontext.q.c(this);
        this.giftSendResultListeners$delegate = ConstantKt.a(this, new LinkedHashSet(), GiftContext$giftSendResultListeners$2.INSTANCE);
        this.giftListResultLogId$delegate = com.bytedance.live.datacontext.q.d(this, BuildConfig.FLAVOR);
        this.currentSelectedGiftPosition$delegate = com.bytedance.live.datacontext.q.c(this);
        this.isContinuous$delegate = com.bytedance.live.datacontext.q.c(this);
        this.giftExhibitionMap$delegate = ConstantKt.d(this, new LinkedHashMap());
        this.giftBuffIdToOriginIdMap$delegate = ConstantKt.d(this, new LinkedHashMap());
        this.messageDispatcher$delegate = ConstantKt.d(this, new com.bytedance.android.livesdk.gift.platform.business.tray2.k());
        this.openGroupLiveDialog$delegate = com.bytedance.live.datacontext.e.b(this);
        this.updateGiftTrayPosition$delegate = com.bytedance.live.datacontext.e.b(this);
        this.lastClickRechargeSelectGift$delegate = com.bytedance.live.datacontext.q.c(this);
        this.lastSendGiftId$delegate = com.bytedance.live.datacontext.q.d(this, new a());
        this.wishComboDataLog$delegate = com.bytedance.live.datacontext.q.d(this, new WishComboDataLog());
        Boolean r1 = Boolean.FALSE;
        this.isVS$delegate = com.bytedance.live.datacontext.q.d(this, r1);
        this.room$delegate = com.bytedance.live.datacontext.q.c(this);
        this.episodeId$delegate = com.bytedance.live.datacontext.q.d(this, 0L);
        this.giftIdMapToInfo$delegate = ConstantKt.d(this, new LinkedHashMap());
        this.giftStructChangeEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.effectConfig$delegate = com.bytedance.live.datacontext.q.c(this);
        this.hotRoomInfo$delegate = com.bytedance.live.datacontext.q.d(this, new x(-1.0f, -1.0d, -1.0d));
        Boolean r5 = Boolean.TRUE;
        this.needShowGiftEffectSwitch$delegate = com.bytedance.live.datacontext.q.d(this, r5);
        this.needShowGiftTraySwitch$delegate = com.bytedance.live.datacontext.q.d(this, r5);
        this.lastEventTimeStamp$delegate = com.bytedance.live.datacontext.q.d(this, new i(0, 0, 0, 0, 0));
        this.assetFetchSaver$delegate = ConstantKt.d(this, new LinkedHashMap());
        this.effectVibrateSwitch$delegate = com.bytedance.live.datacontext.q.d(this, r5);
        this.effectAudioSwitch$delegate = com.bytedance.live.datacontext.q.d(this, r5);
        this.rowLocation$delegate = com.bytedance.live.datacontext.q.d(this, new f0(1, 2));
        this.liveGiftComboWidget$delegate = ConstantKt.d(this, new LiveGiftComboWidget());
        this.newGiftProp$delegate = ConstantKt.d(this, new LinkedHashMap());
        this.bubbleBuffLevel$delegate = com.bytedance.live.datacontext.q.d(this, new c(0, 0));
        this.openBigGiftDialogEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.bigGiftKeyCount$delegate = com.bytedance.live.datacontext.q.d(this, 0L);
        this.viewHolderCreateTimes$delegate = ConstantKt.d(this, new LinkedHashMap());
        this.viewHolderBindTimes$delegate = ConstantKt.d(this, new LinkedHashMap());
        this.sendGiftTime$delegate = com.bytedance.live.datacontext.q.d(this, 0L);
        this.sendGiftMoney$delegate = com.bytedance.live.datacontext.q.d(this, 0L);
        this.degradeSetting$delegate = com.bytedance.live.datacontext.q.d(this, r1);
        this.isVSPadUseVerticalStyle$delegate = com.bytedance.live.datacontext.q.d(this, r1);
        this.firstGiftImageRenderSucAt$delegate = com.bytedance.live.datacontext.q.d(this, 0L);
        this.firstViewHolderAttached$delegate = com.bytedance.live.datacontext.q.d(this, r1);
        this.giftPanelFirstRenderTs$delegate = com.bytedance.live.datacontext.q.d(this, 0L);
        this.defaultGiftLocatedAt$delegate = com.bytedance.live.datacontext.q.d(this, 0L);
        this.customizeBuffSelectType$delegate = com.bytedance.live.datacontext.q.d(this, DIYCardSelectType.IDLE);
        this.audienceListChange$delegate = com.bytedance.live.datacontext.e.b(this);
        this.cancelComboForDegradeInMatch$delegate = com.bytedance.live.datacontext.q.d(this, r1);
        this.needSendCloseMessageSwitch$delegate = com.bytedance.live.datacontext.q.d(this, r5);
        this.currentSendTogetherInfo$delegate = com.bytedance.live.datacontext.q.c(this);
        this.sendTogetherSlotChangeEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.playLynxAlphaVideoEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.giftBannerShowEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.giftDialogCloseEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.isGiftDialogOpen$delegate = com.bytedance.live.datacontext.q.d(this, r1);
        this.msgCount$delegate = com.bytedance.live.datacontext.q.d(this, 0);
        this.isIntercept$delegate = com.bytedance.live.datacontext.q.d(this, r1);
        this.giftTrayTempPosition$delegate = com.bytedance.live.datacontext.q.c(this);
        this.toolbarGiftAnimController$delegate = ConstantKt.b(this, GiftContext$toolbarGiftAnimController$2.INSTANCE);
        this.fastTaskGiftModel$delegate = com.bytedance.live.datacontext.q.c(this);
        this.pageType$delegate = com.bytedance.live.datacontext.q.d(this, 0);
        this.giftTrayTempComboUpdateEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.pkTrayTempContainer$delegate = com.bytedance.live.datacontext.q.c(this);
        this.atmosphereContainer$delegate = com.bytedance.live.datacontext.q.c(this);
        this.loadedEffectResourceMap$delegate = ConstantKt.d(this, new LinkedHashMap());
        this.pkBattlePropEffectWidget$delegate = com.bytedance.live.datacontext.q.c(this);
        this.giftIcon$delegate = com.bytedance.live.datacontext.q.c(this);
        this.currentGiftEffect$delegate = com.bytedance.live.datacontext.q.c(this);
        this.enterRoomTime = System.currentTimeMillis();
        KmpEnv r2 = KmpEnv.a;
        this.hasLinkEffectSo$delegate = com.bytedance.live.datacontext.q.d(this, Boolean.valueOf(!KmpEnv.b()));
        this.giftTabMarginWidth$delegate = com.bytedance.live.datacontext.q.d(this, 133);
        this.giftRenderFilterWrapper$delegate = com.bytedance.live.datacontext.q.a(this, new k02.f(), GiftContext$giftRenderFilterWrapper$2.INSTANCE);
    }

    public final long getEnterRoomTime() {
        return this.enterRoomTime;
    }

    public final int getPanelOpenTimes() {
        return this.panelOpenTimes;
    }

    public final void setEnterRoomTime(long r1) {
        this.enterRoomTime = r1;
    }

    public final void setPanelOpenTimes(int r1) {
        this.panelOpenTimes = r1;
    }
}
