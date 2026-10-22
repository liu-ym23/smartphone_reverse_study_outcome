package com.larus.bmhome.chat.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.home.impl.sdk.ChatServiceImpl;
import com.larus.im.bean.bot.BgImageInfo;
import com.larus.im.bean.bot.BotConfItem;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotStatistic;
import com.larus.im.bean.bot.BotSwitchConfInfo;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.im.bean.bot.FirstMet;
import com.larus.im.bean.bot.ModelItem;
import com.larus.im.bean.bot.ShareInfo;
import com.larus.im.bean.bot.ShowTagInfo;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.internal.protocol.model.BotCommentInfo;
import com.larus.im.internal.protocol.model.LikeInfo;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000Ó\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0003\b\u008a\u0001\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u0097\u00022\u00020\u00012\u00020\u0002:\u0002\u0097\u0002B\u009d\u0004\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010%\u001a\u00020\u0011\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u000100\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000102\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000104\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000109\u0012\u0010\b\u0002\u0010:\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010)\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?\u0012\b\b\u0002\u0010@\u001a\u00020\u0011\u0012\b\b\u0002\u0010A\u001a\u00020\u0007\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010C\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010E\u0012\b\b\u0002\u0010F\u001a\u00020\u0011¢\u0006\u0004\bG\u0010HJ\t\u0010×\u0001\u001a\u0004\u0018\u00010\u0004J\t\u0010Ø\u0001\u001a\u00020\u0004H\u0016J\t\u0010Ù\u0001\u001a\u00020\u0004H\u0016J\u0011\u0010Ú\u0001\u001a\u00030Û\u00012\u0007\u0010Ü\u0001\u001a\u00020\u0004J\f\u0010Ý\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010Þ\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010ß\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010PJ\f\u0010à\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010á\u0001\u001a\u00020\u0007HÆ\u0003J\f\u0010â\u0001\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\n\u0010ã\u0001\u001a\u00020\rHÆ\u0003J\n\u0010ä\u0001\u001a\u00020\rHÆ\u0003J\n\u0010å\u0001\u001a\u00020\rHÆ\u0003J\n\u0010æ\u0001\u001a\u00020\u0011HÆ\u0003J\f\u0010ç\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010è\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\f\u0010é\u0001\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\f\u0010ê\u0001\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\f\u0010ë\u0001\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u0011\u0010ì\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010{J\f\u0010í\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010î\u0001\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\f\u0010ï\u0001\u001a\u0004\u0018\u00010 HÆ\u0003J\f\u0010ð\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010ñ\u0001\u001a\u0004\u0018\u00010#HÆ\u0003J\u0011\u0010ò\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010PJ\n\u0010ó\u0001\u001a\u00020\u0011HÆ\u0003J\f\u0010ô\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010õ\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0012\u0010ö\u0001\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)HÆ\u0003J\f\u0010÷\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010ø\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010ù\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010ú\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010û\u0001\u001a\u0004\u0018\u000100HÆ\u0003J\f\u0010ü\u0001\u001a\u0004\u0018\u000102HÆ\u0003J\f\u0010ý\u0001\u001a\u0004\u0018\u000104HÆ\u0003J\u0011\u0010þ\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010PJ\f\u0010ÿ\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010\u0080\u0002\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010{J\f\u0010\u0081\u0002\u001a\u0004\u0018\u000109HÆ\u0003J\u0012\u0010\u0082\u0002\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010)HÆ\u0003J\f\u0010\u0083\u0002\u001a\u0004\u0018\u00010=HÆ\u0003J\f\u0010\u0084\u0002\u001a\u0004\u0018\u00010?HÆ\u0003J\n\u0010\u0085\u0002\u001a\u00020\u0011HÆ\u0003J\n\u0010\u0086\u0002\u001a\u00020\u0007HÆ\u0003J\f\u0010\u0087\u0002\u001a\u0004\u0018\u00010CHÆ\u0003J\f\u0010\u0088\u0002\u001a\u0004\u0018\u00010EHÆ\u0003J\n\u0010\u0089\u0002\u001a\u00020\u0011HÆ\u0003J¦\u0004\u0010\u008a\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010%\u001a\u00020\u00112\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u00108\u001a\u0004\u0018\u0001092\u0010\b\u0002\u0010:\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010)2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?2\b\b\u0002\u0010@\u001a\u00020\u00112\b\b\u0002\u0010A\u001a\u00020\u00072\n\b\u0002\u0010B\u001a\u0004\u0018\u00010C2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010E2\b\b\u0002\u0010F\u001a\u00020\u0011HÆ\u0001¢\u0006\u0003\u0010\u008b\u0002J\u0007\u0010\u008c\u0002\u001a\u00020\u0007J\u0016\u0010\u008d\u0002\u001a\u00020\u00112\n\u0010\u008e\u0002\u001a\u0005\u0018\u00010\u008f\u0002HÖ\u0003J\n\u0010\u0090\u0002\u001a\u00020\u0007HÖ\u0001J\n\u0010\u0091\u0002\u001a\u00020\u0004HÖ\u0001J\u001b\u0010\u0092\u0002\u001a\u00030\u0093\u00022\b\u0010\u0094\u0002\u001a\u00030\u0095\u00022\u0007\u0010\u0096\u0002\u001a\u00020\u0007R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR \u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010J\"\u0004\bN\u0010LR\"\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010S\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR \u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010J\"\u0004\bU\u0010LR\u001e\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001e\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010_\"\u0004\bc\u0010aR\u001e\u0010\u000f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010_\"\u0004\be\u0010aR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010J\"\u0004\bk\u0010LR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010mR \u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR \u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR \u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\"\u0010\u001b\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010~\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R!\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b\u007f\u0010J\"\u0005\b\u0080\u0001\u0010LR$\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R$\u0010\u001f\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R\"\u0010!\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0089\u0001\u0010J\"\u0005\b\u008a\u0001\u0010LR$\u0010\"\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R$\u0010$\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010S\u001a\u0005\b\u008f\u0001\u0010P\"\u0005\b\u0090\u0001\u0010RR \u0010%\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0001\u0010g\"\u0005\b\u0092\u0001\u0010iR\"\u0010&\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010J\"\u0005\b\u0094\u0001\u0010LR\"\u0010'\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0095\u0001\u0010J\"\u0005\b\u0096\u0001\u0010LR*\u0010(\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\"\u0006\b\u0099\u0001\u0010\u009a\u0001R\"\u0010+\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009b\u0001\u0010J\"\u0005\b\u009c\u0001\u0010LR\"\u0010,\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009d\u0001\u0010J\"\u0005\b\u009e\u0001\u0010LR\"\u0010-\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009f\u0001\u0010J\"\u0005\b \u0001\u0010LR\"\u0010.\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¡\u0001\u0010J\"\u0005\b¢\u0001\u0010LR$\u0010/\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b£\u0001\u0010¤\u0001\"\u0006\b¥\u0001\u0010¦\u0001R$\u00101\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b§\u0001\u0010¨\u0001\"\u0006\b©\u0001\u0010ª\u0001R$\u00103\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b«\u0001\u0010¬\u0001\"\u0006\b\u00ad\u0001\u0010®\u0001R$\u00105\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010S\u001a\u0005\b¯\u0001\u0010P\"\u0005\b°\u0001\u0010RR\"\u00106\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b±\u0001\u0010J\"\u0005\b²\u0001\u0010LR$\u00107\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0002\u0010~\u001a\u0005\b³\u0001\u0010{\"\u0005\b´\u0001\u0010}R$\u00108\u001a\u0004\u0018\u0001098\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bµ\u0001\u0010¶\u0001\"\u0006\b·\u0001\u0010¸\u0001R*\u0010:\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¹\u0001\u0010\u0098\u0001\"\u0006\bº\u0001\u0010\u009a\u0001R$\u0010<\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b»\u0001\u0010¼\u0001\"\u0006\b½\u0001\u0010¾\u0001R$\u0010>\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¿\u0001\u0010À\u0001\"\u0006\bÁ\u0001\u0010Â\u0001R\u001f\u0010@\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b@\u0010g\"\u0005\bÃ\u0001\u0010iR \u0010A\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÄ\u0001\u0010W\"\u0005\bÅ\u0001\u0010YR \u0010B\u001a\u0004\u0018\u00010CX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÆ\u0001\u0010Ç\u0001\"\u0006\bÈ\u0001\u0010É\u0001R \u0010D\u001a\u0004\u0018\u00010EX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÊ\u0001\u0010Ë\u0001\"\u0006\bÌ\u0001\u0010Í\u0001R\u001b\u0010F\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\bF\u0010g\"\u0005\bÎ\u0001\u0010iR\u001a\u0010Ï\u0001\u001a\u0005\u0018\u00010Ð\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bÑ\u0001\u0010Ò\u0001R\u0013\u0010Ó\u0001\u001a\u00020\u00118F¢\u0006\u0007\u001a\u0005\bÓ\u0001\u0010gR\u0013\u0010Ô\u0001\u001a\u00020\u00118F¢\u0006\u0007\u001a\u0005\bÔ\u0001\u0010gR\u0013\u0010Õ\u0001\u001a\u00020\u00118F¢\u0006\u0007\u001a\u0005\bÖ\u0001\u0010g¨\u0006\u0098\u0002"}, d2 = {"Lcom/larus/bmhome/chat/bean/RecommendBot;", "Lcom/larus/im/bean/conversation/ActionbarBaseData;", "Landroid/os/Parcelable;", "botId", "", "name", "botType", "", "botFeatureLabel", "botMode", "iconImage", "Lcom/larus/im/bean/bot/BotIconImage;", "createTime", "", "updateTime", "recommendIndex", "hasConversation", "", "conversationId", "onboarding", "Lcom/larus/bmhome/chat/bean/BotOnBoarding;", "botAction", "Lcom/larus/bmhome/chat/bean/BotAction;", "botCreatorInfo", "Lcom/larus/im/bean/bot/BotCreatorInfo;", "botStatus", "Lcom/larus/im/bean/bot/BotStatistic;", "muted", "humanDescription", "model", "Lcom/larus/im/bean/bot/ModelItem;", "voice", "Lcom/larus/im/bean/bot/SpeakerVoice;", "editPos", "shareInfo", "Lcom/larus/im/bean/bot/ShareInfo;", "privateStatus", "disabled", "disabledTag", "bio", "botConf", "", "Lcom/larus/im/bean/bot/BotConfItem;", "bgImgUrl", "bgImgColor", "bgVideoModel", "bgImgUri", "bgImgInfo", "Lcom/larus/im/bean/bot/BgImageInfo;", "conversationPage", "Lcom/larus/im/bean/bot/ConversationPage;", "switchConfInfo", "Lcom/larus/im/bean/bot/BotSwitchConfInfo;", "contentDistType", "callerName", "callerNameSetting", "firstMet", "Lcom/larus/im/bean/bot/FirstMet;", "tagList", "Lcom/larus/im/bean/bot/ShowTagInfo;", "likeInfo", "Lcom/larus/im/internal/protocol/model/LikeInfo;", "commentInfo", "Lcom/larus/im/internal/protocol/model/BotCommentInfo;", "isPlaceHolder", "loadMoreStatus", "from", "Lcom/larus/platform/model/RecommendFrom;", "searchMobParam", "Lcom/larus/platform/model/SearchMobParam;", "isFromCache", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ILcom/larus/im/bean/bot/BotIconImage;JJJZLjava/lang/String;Lcom/larus/bmhome/chat/bean/BotOnBoarding;Lcom/larus/bmhome/chat/bean/BotAction;Lcom/larus/im/bean/bot/BotCreatorInfo;Lcom/larus/im/bean/bot/BotStatistic;Ljava/lang/Boolean;Ljava/lang/String;Lcom/larus/im/bean/bot/ModelItem;Lcom/larus/im/bean/bot/SpeakerVoice;Ljava/lang/String;Lcom/larus/im/bean/bot/ShareInfo;Ljava/lang/Integer;ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/BgImageInfo;Lcom/larus/im/bean/bot/ConversationPage;Lcom/larus/im/bean/bot/BotSwitchConfInfo;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/im/bean/bot/FirstMet;Ljava/util/List;Lcom/larus/im/internal/protocol/model/LikeInfo;Lcom/larus/im/internal/protocol/model/BotCommentInfo;ZILcom/larus/platform/model/RecommendFrom;Lcom/larus/platform/model/SearchMobParam;Z)V", "getBotId", "()Ljava/lang/String;", "setBotId", "(Ljava/lang/String;)V", "getName", "setName", "getBotType", "()Ljava/lang/Integer;", "setBotType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getBotFeatureLabel", "setBotFeatureLabel", "getBotMode", "()I", "setBotMode", "(I)V", "getIconImage", "()Lcom/larus/im/bean/bot/BotIconImage;", "setIconImage", "(Lcom/larus/im/bean/bot/BotIconImage;)V", "getCreateTime", "()J", "setCreateTime", "(J)V", "getUpdateTime", "setUpdateTime", "getRecommendIndex", "setRecommendIndex", "getHasConversation", "()Z", "setHasConversation", "(Z)V", "getConversationId", "setConversationId", "getOnboarding", "()Lcom/larus/bmhome/chat/bean/BotOnBoarding;", "getBotAction", "()Lcom/larus/bmhome/chat/bean/BotAction;", "setBotAction", "(Lcom/larus/bmhome/chat/bean/BotAction;)V", "getBotCreatorInfo", "()Lcom/larus/im/bean/bot/BotCreatorInfo;", "setBotCreatorInfo", "(Lcom/larus/im/bean/bot/BotCreatorInfo;)V", "getBotStatus", "()Lcom/larus/im/bean/bot/BotStatistic;", "setBotStatus", "(Lcom/larus/im/bean/bot/BotStatistic;)V", "getMuted", "()Ljava/lang/Boolean;", "setMuted", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getHumanDescription", "setHumanDescription", "getModel", "()Lcom/larus/im/bean/bot/ModelItem;", "setModel", "(Lcom/larus/im/bean/bot/ModelItem;)V", "getVoice", "()Lcom/larus/im/bean/bot/SpeakerVoice;", "setVoice", "(Lcom/larus/im/bean/bot/SpeakerVoice;)V", "getEditPos", "setEditPos", "getShareInfo", "()Lcom/larus/im/bean/bot/ShareInfo;", "setShareInfo", "(Lcom/larus/im/bean/bot/ShareInfo;)V", "getPrivateStatus", "setPrivateStatus", "getDisabled", "setDisabled", "getDisabledTag", "setDisabledTag", "getBio", "setBio", "getBotConf", "()Ljava/util/List;", "setBotConf", "(Ljava/util/List;)V", "getBgImgUrl", "setBgImgUrl", "getBgImgColor", "setBgImgColor", "getBgVideoModel", "setBgVideoModel", "getBgImgUri", "setBgImgUri", "getBgImgInfo", "()Lcom/larus/im/bean/bot/BgImageInfo;", "setBgImgInfo", "(Lcom/larus/im/bean/bot/BgImageInfo;)V", "getConversationPage", "()Lcom/larus/im/bean/bot/ConversationPage;", "setConversationPage", "(Lcom/larus/im/bean/bot/ConversationPage;)V", "getSwitchConfInfo", "()Lcom/larus/im/bean/bot/BotSwitchConfInfo;", "setSwitchConfInfo", "(Lcom/larus/im/bean/bot/BotSwitchConfInfo;)V", "getContentDistType", "setContentDistType", "getCallerName", "setCallerName", "getCallerNameSetting", "setCallerNameSetting", "getFirstMet", "()Lcom/larus/im/bean/bot/FirstMet;", "setFirstMet", "(Lcom/larus/im/bean/bot/FirstMet;)V", "getTagList", "setTagList", "getLikeInfo", "()Lcom/larus/im/internal/protocol/model/LikeInfo;", "setLikeInfo", "(Lcom/larus/im/internal/protocol/model/LikeInfo;)V", "getCommentInfo", "()Lcom/larus/im/internal/protocol/model/BotCommentInfo;", "setCommentInfo", "(Lcom/larus/im/internal/protocol/model/BotCommentInfo;)V", "setPlaceHolder", "getLoadMoreStatus", "setLoadMoreStatus", "getFrom", "()Lcom/larus/platform/model/RecommendFrom;", "setFrom", "(Lcom/larus/platform/model/RecommendFrom;)V", "getSearchMobParam", "()Lcom/larus/platform/model/SearchMobParam;", "setSearchMobParam", "(Lcom/larus/platform/model/SearchMobParam;)V", "setFromCache", "chatService", "Lcom/larus/platform/api/IChatService;", "getChatService", "()Lcom/larus/platform/api/IChatService;", "isAdded", "isChatOnly", "bgImgOpen", "getBgImgOpen", "language", "uniqueIdInType", "getContentFlag", "toRecommendMobInfo", "Lcom/larus/bmhome/chat/bean/BotRecommendMobInfo;", "tabId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ILcom/larus/im/bean/bot/BotIconImage;JJJZLjava/lang/String;Lcom/larus/bmhome/chat/bean/BotOnBoarding;Lcom/larus/bmhome/chat/bean/BotAction;Lcom/larus/im/bean/bot/BotCreatorInfo;Lcom/larus/im/bean/bot/BotStatistic;Ljava/lang/Boolean;Ljava/lang/String;Lcom/larus/im/bean/bot/ModelItem;Lcom/larus/im/bean/bot/SpeakerVoice;Ljava/lang/String;Lcom/larus/im/bean/bot/ShareInfo;Ljava/lang/Integer;ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/BgImageInfo;Lcom/larus/im/bean/bot/ConversationPage;Lcom/larus/im/bean/bot/BotSwitchConfInfo;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/im/bean/bot/FirstMet;Ljava/util/List;Lcom/larus/im/internal/protocol/model/LikeInfo;Lcom/larus/im/internal/protocol/model/BotCommentInfo;ZILcom/larus/platform/model/RecommendFrom;Lcom/larus/platform/model/SearchMobParam;Z)Lcom/larus/bmhome/chat/bean/RecommendBot;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class RecommendBot implements Parcelable {
    public static final Parcelable.Creator<RecommendBot> CREATOR = null;
    public transient RecommendFrom a;
    public transient SearchMobParam b;

    @SerializedName("bg_img_avg_hue")
    private String bgImgColor;

    @SerializedName("bg_img_info")
    private BgImageInfo bgImgInfo;

    @SerializedName("bg_img_uri")
    private String bgImgUri;

    @SerializedName("bg_img_url")
    private String bgImgUrl;

    @SerializedName("bg_video_model")
    private String bgVideoModel;

    @SerializedName("bio")
    private String bio;

    @SerializedName("action")
    private BotAction botAction;

    @SerializedName("bot_conf")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<BotConfItem> botConf;

    @SerializedName("creator_info")
    private BotCreatorInfo botCreatorInfo;

    @SerializedName("bot_feature_label")
    private String botFeatureLabel;

    @SerializedName("bot_id")
    private String botId;

    @SerializedName("bot_mode")
    private int botMode;

    @SerializedName("bot_stats")
    private BotStatistic botStatus;

    @SerializedName("bot_type")
    private Integer botType;
    public transient boolean c;

    @SerializedName("caller_name")
    private String callerName;

    @SerializedName("caller_name_setting")
    private Boolean callerNameSetting;

    @SerializedName("comment_info")
    private BotCommentInfo commentInfo;

    @SerializedName("content_dist_type")
    private Integer contentDistType;

    @SerializedName("conversation_id")
    private String conversationId;

    @SerializedName("conversation_page")
    private ConversationPage conversationPage;

    @SerializedName("create_time")
    private long createTime;

    @SerializedName("disabled")
    private boolean disabled;

    @SerializedName("disabled_tag")
    private String disabledTag;

    @SerializedName("edit_pos")
    private String editPos;

    @SerializedName("first_met")
    private FirstMet firstMet;

    @SerializedName("has_conversation")
    private boolean hasConversation;

    @SerializedName("description_for_human")
    private String humanDescription;

    @SerializedName("icon_image")
    private BotIconImage iconImage;

    @Expose(deserialize = false, serialize = false)
    private boolean isPlaceHolder;

    @SerializedName("like_info")
    private LikeInfo likeInfo;

    @Expose(deserialize = false, serialize = false)
    private int loadMoreStatus;

    @SerializedName("model")
    private ModelItem model;

    @SerializedName("muted")
    private Boolean muted;

    @SerializedName("name")
    private String name;

    @SerializedName("onboarding")
    private final BotOnBoarding onboarding;

    @SerializedName("private_status")
    private Integer privateStatus;

    @SerializedName("recommend_index")
    private long recommendIndex;

    @SerializedName("share_info")
    private ShareInfo shareInfo;

    @SerializedName("switch_conf")
    private BotSwitchConfInfo switchConfInfo;

    @SerializedName("show_tag_info_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<ShowTagInfo> tagList;

    @SerializedName("update_time")
    private long updateTime;

    @SerializedName("voice_type")
    private SpeakerVoice voice;

    public static final class a {
    }

    public static final class b implements Parcelable.Creator<RecommendBot> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final RecommendBot createFromParcel(Parcel r55) {
            Intrinsics.checkNotNullParameter(r55, "parcel");
            String r3 = r55.readString();
            String r4 = r55.readString();
            if (r55.readInt() != 0) goto L5;
            Integer r5 = null;
        L6:
            String r6 = r55.readString();
            int r7 = r55.readInt();
            BotIconImage r8 = r55.readSerializable();
            long r9 = r55.readLong();
            long r11 = r55.readLong();
            long r13 = r55.readLong();
            if (r55.readInt() == 0) goto L9;
            boolean r1 = true;
        L10:
            String r17 = r55.readString();
            if (r55.readInt() != 0) goto L13;
            BotOnBoarding r2 = null;
        L14:
            BotOnBoarding r19 = r2;
            if (r55.readInt() != 0) goto L17;
            BotAction r10 = null;
        L18:
            BotAction r20 = r10;
            BotCreatorInfo r21 = r55.readSerializable();
            BotStatistic r22 = r55.readSerializable();
            if (r55.readInt() != 0) goto L22;
            Boolean r23 = null;
        L26:
            String r24 = r55.readString();
            ModelItem r25 = r55.readSerializable();
            SpeakerVoice r26 = r55.readSerializable();
            String r27 = r55.readString();
            ShareInfo r28 = r55.readSerializable();
            if (r55.readInt() != 0) goto L29;
            Integer r29 = null;
        L31:
            if (r55.readInt() == 0) goto L33;
            boolean r30 = true;
        L34:
            String r31 = r55.readString();
            String r32 = r55.readString();
            if (r55.readInt() != 0) goto L37;
            ArrayList r12 = null;
        L41:
            String r35 = r55.readString();
            String r36 = r55.readString();
            String r37 = r55.readString();
            String r38 = r55.readString();
            BgImageInfo r39 = r55.readSerializable();
            ConversationPage r40 = r55.readSerializable();
            BotSwitchConfInfo r41 = r55.readSerializable();
            if (r55.readInt() != 0) goto L44;
            Integer r42 = null;
        L45:
            String r43 = r55.readString();
            if (r55.readInt() != 0) goto L49;
            Boolean r44 = null;
        L53:
            FirstMet r45 = r55.readSerializable();
            if (r55.readInt() != 0) goto L56;
            ArrayList r14 = null;
        L60:
            LikeInfo r47 = r55.readSerializable();
            BotCommentInfo r48 = r55.readSerializable();
            if (r55.readInt() == 0) goto L63;
            boolean r49 = true;
        L64:
            int r50 = r55.readInt();
            RecommendFrom r51 = r55.readParcelable(RecommendBot.class.getClassLoader());
            SearchMobParam r52 = r55.readParcelable(RecommendBot.class.getClassLoader());
            if (r55.readInt() == 0) goto L67;
            boolean r0 = true;
        L69:
            return new RecommendBot(r3, r4, r5, r6, r7, r8, r9, r11, r13, r1, r17, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r12, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r14, r47, r48, r49, r50, r51, r52, r0);
        L67:
            r0 = false;
            goto L69
        L63:
            r49 = false;
            goto L64
        L56:
            int r15 = r55.readInt();
            ArrayList r16 = new ArrayList(r15);
            int r18 = 0;
        L57:
            if (r18 == r15) goto L59;
            int r110 = r15;
            r16.add(r55.readSerializable());
            r18 = r18 + 1;
            r15 = r110;
            goto L57
        L59:
            r14 = r16;
            goto L60
        L49:
            if (r55.readInt() == 0) goto L51;
            boolean r33 = true;
        L52:
            r44 = Boolean.valueOf(r33);
            goto L53
        L51:
            r33 = false;
            goto L52
        L44:
            r42 = Integer.valueOf(r55.readInt());
            goto L45
        L37:
            int r34 = r55.readInt();
            ArrayList r111 = new ArrayList(r34);
            int r46 = 0;
        L38:
            if (r46 == r34) goto L40;
            int r310 = r34;
            r111.add(r55.readSerializable());
            r46 = r46 + 1;
            r34 = r310;
            goto L38
        L40:
            r12 = r111;
            goto L41
        L33:
            r30 = false;
            goto L34
        L29:
            r29 = Integer.valueOf(r55.readInt());
            goto L31
        L22:
            if (r55.readInt() == 0) goto L24;
            boolean r53 = true;
        L25:
            r23 = Boolean.valueOf(r53);
            goto L26
        L24:
            r53 = false;
            goto L25
        L17:
            r10 = BotAction.CREATOR.createFromParcel(r55);
            goto L18
        L13:
            r2 = BotOnBoarding.CREATOR.createFromParcel(r55);
            goto L14
        L9:
            r1 = false;
            goto L10
        L5:
            r5 = Integer.valueOf(r55.readInt());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final RecommendBot[] newArray(int r1) {
            return new RecommendBot[r1];
        }
    }

    static {
        CREATOR = new b();
    }

    public RecommendBot() {
        this(null, null, null, null, null, 0, 0, 0, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, -1, 8191);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof RecommendBot) == true) goto L8;
        return false;
    L8:
        RecommendBot r9 = (RecommendBot) r8;
        if (Intrinsics.areEqual(this.botId, r9.botId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r9.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.botType, r9.botType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.botFeatureLabel, r9.botFeatureLabel) == true) goto L21;
        return false;
    L21:
        if (this.botMode == r9.botMode) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.iconImage, r9.iconImage) == true) goto L27;
        return false;
    L27:
        if (this.createTime == r9.createTime) goto L30;
        return false;
    L30:
        if (this.updateTime == r9.updateTime) goto L33;
        return false;
    L33:
        if (this.recommendIndex == r9.recommendIndex) goto L36;
        return false;
    L36:
        if (this.hasConversation == r9.hasConversation) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.conversationId, r9.conversationId) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.onboarding, r9.onboarding) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.botAction, r9.botAction) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.botCreatorInfo, r9.botCreatorInfo) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.botStatus, r9.botStatus) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.muted, r9.muted) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.humanDescription, r9.humanDescription) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.model, r9.model) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.voice, r9.voice) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.editPos, r9.editPos) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.shareInfo, r9.shareInfo) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.privateStatus, r9.privateStatus) == true) goto L75;
        return false;
    L75:
        if (this.disabled == r9.disabled) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.disabledTag, r9.disabledTag) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.bio, r9.bio) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.botConf, r9.botConf) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.bgImgUrl, r9.bgImgUrl) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.bgImgColor, r9.bgImgColor) == true) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.bgVideoModel, r9.bgVideoModel) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.bgImgUri, r9.bgImgUri) == true) goto L99;
        return false;
    L99:
        if (Intrinsics.areEqual(this.bgImgInfo, r9.bgImgInfo) == true) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.conversationPage, r9.conversationPage) == true) goto L105;
        return false;
    L105:
        if (Intrinsics.areEqual(this.switchConfInfo, r9.switchConfInfo) == true) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(this.contentDistType, r9.contentDistType) == true) goto L111;
        return false;
    L111:
        if (Intrinsics.areEqual(this.callerName, r9.callerName) == true) goto L114;
        return false;
    L114:
        if (Intrinsics.areEqual(this.callerNameSetting, r9.callerNameSetting) == true) goto L117;
        return false;
    L117:
        if (Intrinsics.areEqual(this.firstMet, r9.firstMet) == true) goto L120;
        return false;
    L120:
        if (Intrinsics.areEqual(this.tagList, r9.tagList) == true) goto L123;
        return false;
    L123:
        if (Intrinsics.areEqual(this.likeInfo, r9.likeInfo) == true) goto L126;
        return false;
    L126:
        if (Intrinsics.areEqual(this.commentInfo, r9.commentInfo) == true) goto L129;
        return false;
    L129:
        if (this.isPlaceHolder == r9.isPlaceHolder) goto L132;
        return false;
    L132:
        if (this.loadMoreStatus == r9.loadMoreStatus) goto L135;
        return false;
    L135:
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L138;
        return false;
    L138:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L141;
        return false;
    L141:
        if (this.c == r9.c) goto L143;
        return false;
    L143:
        return true;
    }

    public final int hashCode() {
        String r0 = this.botId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.name;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.botType;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.botFeatureLabel;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (((r9 + r11) * 31) + this.botMode) * 31;
        BotIconImage r13 = this.iconImage;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        long r16 = this.createTime;
        int r17 = (r15 + ((int) (r16 ^ (r16 >>> 32)))) * 31;
        long r18 = this.updateTime;
        int r19 = (r17 + ((int) (r18 ^ (r18 >>> 32)))) * 31;
        long r20 = this.recommendIndex;
        int r21 = (r19 + ((int) (r20 ^ (r20 >>> 32)))) * 31;
        int r22 = 1231;
        if (this.hasConversation == false) goto L25;
        int r23 = 1231;
    L26:
        int r24 = (r21 + r23) * 31;
        String r25 = this.conversationId;
        if (r25 != null) goto L29;
        int r26 = 0;
    L30:
        int r27 = (r24 + r26) * 31;
        BotOnBoarding r28 = this.onboarding;
        if (r28 != null) goto L33;
        int r29 = 0;
    L34:
        int r30 = (r27 + r29) * 31;
        BotAction r31 = this.botAction;
        if (r31 != null) goto L37;
        int r32 = 0;
    L38:
        int r33 = (r30 + r32) * 31;
        BotCreatorInfo r34 = this.botCreatorInfo;
        if (r34 != null) goto L41;
        int r35 = 0;
    L42:
        int r36 = (r33 + r35) * 31;
        BotStatistic r37 = this.botStatus;
        if (r37 != null) goto L45;
        int r38 = 0;
    L46:
        int r39 = (r36 + r38) * 31;
        Boolean r40 = this.muted;
        if (r40 != null) goto L49;
        int r41 = 0;
    L50:
        int r42 = (r39 + r41) * 31;
        String r43 = this.humanDescription;
        if (r43 != null) goto L53;
        int r44 = 0;
    L54:
        int r45 = (r42 + r44) * 31;
        ModelItem r46 = this.model;
        if (r46 != null) goto L57;
        int r47 = 0;
    L58:
        int r48 = (r45 + r47) * 31;
        SpeakerVoice r49 = this.voice;
        if (r49 != null) goto L61;
        int r50 = 0;
    L62:
        int r51 = (r48 + r50) * 31;
        String r52 = this.editPos;
        if (r52 != null) goto L65;
        int r53 = 0;
    L66:
        int r54 = (r51 + r53) * 31;
        ShareInfo r55 = this.shareInfo;
        if (r55 != null) goto L69;
        int r56 = 0;
    L70:
        int r57 = (r54 + r56) * 31;
        Integer r58 = this.privateStatus;
        if (r58 != null) goto L73;
        int r59 = 0;
    L74:
        int r60 = (r57 + r59) * 31;
        if (this.disabled == false) goto L77;
        int r61 = 1231;
    L78:
        int r62 = (r60 + r61) * 31;
        String r63 = this.disabledTag;
        if (r63 != null) goto L81;
        int r64 = 0;
    L82:
        int r65 = (r62 + r64) * 31;
        String r66 = this.bio;
        if (r66 != null) goto L85;
        int r67 = 0;
    L86:
        int r68 = (r65 + r67) * 31;
        List<BotConfItem> r69 = this.botConf;
        if (r69 != null) goto L89;
        int r70 = 0;
    L90:
        int r71 = (r68 + r70) * 31;
        String r72 = this.bgImgUrl;
        if (r72 != null) goto L93;
        int r73 = 0;
    L94:
        int r74 = (r71 + r73) * 31;
        String r75 = this.bgImgColor;
        if (r75 != null) goto L97;
        int r76 = 0;
    L98:
        int r77 = (r74 + r76) * 31;
        String r78 = this.bgVideoModel;
        if (r78 != null) goto L101;
        int r79 = 0;
    L102:
        int r80 = (r77 + r79) * 31;
        String r81 = this.bgImgUri;
        if (r81 != null) goto L105;
        int r82 = 0;
    L106:
        int r83 = (r80 + r82) * 31;
        BgImageInfo r84 = this.bgImgInfo;
        if (r84 != null) goto L109;
        int r85 = 0;
    L110:
        int r86 = (r83 + r85) * 31;
        ConversationPage r87 = this.conversationPage;
        if (r87 != null) goto L113;
        int r88 = 0;
    L114:
        int r89 = (r86 + r88) * 31;
        BotSwitchConfInfo r90 = this.switchConfInfo;
        if (r90 != null) goto L117;
        int r91 = 0;
    L118:
        int r92 = (r89 + r91) * 31;
        Integer r93 = this.contentDistType;
        if (r93 != null) goto L121;
        int r94 = 0;
    L122:
        int r95 = (r92 + r94) * 31;
        String r96 = this.callerName;
        if (r96 != null) goto L125;
        int r97 = 0;
    L126:
        int r99 = (r95 + r97) * 31;
        Boolean r100 = this.callerNameSetting;
        if (r100 != null) goto L129;
        int r101 = 0;
    L130:
        int r102 = (r99 + r101) * 31;
        FirstMet r103 = this.firstMet;
        if (r103 != null) goto L133;
        int r104 = 0;
    L134:
        int r105 = (r102 + r104) * 31;
        List<ShowTagInfo> r106 = this.tagList;
        if (r106 != null) goto L137;
        int r107 = 0;
    L138:
        int r108 = (r105 + r107) * 31;
        LikeInfo r109 = this.likeInfo;
        if (r109 != null) goto L141;
        int r110 = 0;
    L142:
        int r111 = (r108 + r110) * 31;
        BotCommentInfo r112 = this.commentInfo;
        if (r112 != null) goto L145;
        int r113 = 0;
    L146:
        int r114 = (r111 + r113) * 31;
        if (this.isPlaceHolder == false) goto L149;
        int r115 = 1231;
    L150:
        int r116 = (((r114 + r115) * 31) + this.loadMoreStatus) * 31;
        RecommendFrom r117 = this.a;
        if (r117 != null) goto L153;
        int r118 = 0;
    L154:
        int r119 = (r116 + r118) * 31;
        SearchMobParam r120 = this.b;
        if (r120 == null) goto L158;
        r1 = r120.hashCode();
    L158:
        int r121 = (r119 + r1) * 31;
        if (this.c == true) goto L163;
        r22 = 1237;
    L163:
        return r121 + r22;
    L153:
        r118 = r117.hashCode();
        goto L154
    L149:
        r115 = 1237;
        goto L150
    L145:
        r113 = r112.hashCode();
        goto L146
    L141:
        r110 = r109.hashCode();
        goto L142
    L137:
        r107 = r106.hashCode();
        goto L138
    L133:
        r104 = r103.hashCode();
        goto L134
    L129:
        r101 = r100.hashCode();
        goto L130
    L125:
        r97 = r96.hashCode();
        goto L126
    L121:
        r94 = r93.hashCode();
        goto L122
    L117:
        r91 = r90.hashCode();
        goto L118
    L113:
        r88 = r87.hashCode();
        goto L114
    L109:
        r85 = r84.hashCode();
        goto L110
    L105:
        r82 = r81.hashCode();
        goto L106
    L101:
        r79 = r78.hashCode();
        goto L102
    L97:
        r76 = r75.hashCode();
        goto L98
    L93:
        r73 = r72.hashCode();
        goto L94
    L89:
        r70 = r69.hashCode();
        goto L90
    L85:
        r67 = r66.hashCode();
        goto L86
    L81:
        r64 = r63.hashCode();
        goto L82
    L77:
        r61 = 1237;
        goto L78
    L73:
        r59 = r58.hashCode();
        goto L74
    L69:
        r56 = r55.hashCode();
        goto L70
    L65:
        r53 = r52.hashCode();
        goto L66
    L61:
        r50 = r49.hashCode();
        goto L62
    L57:
        r47 = r46.hashCode();
        goto L58
    L53:
        r44 = r43.hashCode();
        goto L54
    L49:
        r41 = r40.hashCode();
        goto L50
    L45:
        r38 = r37.hashCode();
        goto L46
    L41:
        r35 = r34.hashCode();
        goto L42
    L37:
        r32 = r31.hashCode();
        goto L38
    L33:
        r29 = r28.hashCode();
        goto L34
    L29:
        r26 = r25.hashCode();
        goto L30
    L25:
        r23 = 1237;
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "RecommendBot(botId=" + this.botId + ", name=" + this.name + ", botType=" + this.botType + ", botFeatureLabel=" + this.botFeatureLabel + ", botMode=" + this.botMode + ", iconImage=" + this.iconImage + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ", recommendIndex=" + this.recommendIndex + ", hasConversation=" + this.hasConversation + ", conversationId=" + this.conversationId + ", onboarding=" + this.onboarding + ", botAction=" + this.botAction + ", botCreatorInfo=" + this.botCreatorInfo + ", botStatus=" + this.botStatus + ", muted=" + this.muted + ", humanDescription=" + this.humanDescription + ", model=" + this.model + ", voice=" + this.voice + ", editPos=" + this.editPos + ", shareInfo=" + this.shareInfo + ", privateStatus=" + this.privateStatus + ", disabled=" + this.disabled + ", disabledTag=" + this.disabledTag + ", bio=" + this.bio + ", botConf=" + this.botConf + ", bgImgUrl=" + this.bgImgUrl + ", bgImgColor=" + this.bgImgColor + ", bgVideoModel=" + this.bgVideoModel + ", bgImgUri=" + this.bgImgUri + ", bgImgInfo=" + this.bgImgInfo + ", conversationPage=" + this.conversationPage + ", switchConfInfo=" + this.switchConfInfo + ", contentDistType=" + this.contentDistType + ", callerName=" + this.callerName + ", callerNameSetting=" + this.callerNameSetting + ", firstMet=" + this.firstMet + ", tagList=" + this.tagList + ", likeInfo=" + this.likeInfo + ", commentInfo=" + this.commentInfo + ", isPlaceHolder=" + this.isPlaceHolder + ", loadMoreStatus=" + this.loadMoreStatus + ", from=" + this.a + ", searchMobParam=" + this.b + ", isFromCache=" + this.c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "dest");
        r6.writeString(this.botId);
        r6.writeString(this.name);
        Integer r0 = this.botType;
        if (r0 != null) goto L5;
        r6.writeInt(0);
    L6:
        r6.writeString(this.botFeatureLabel);
        r6.writeInt(this.botMode);
        r6.writeSerializable(this.iconImage);
        r6.writeLong(this.createTime);
        r6.writeLong(this.updateTime);
        r6.writeLong(this.recommendIndex);
        r6.writeInt(this.hasConversation ? 1 : 0);
        r6.writeString(this.conversationId);
        BotOnBoarding r1 = this.onboarding;
        if (r1 != null) goto L9;
        r6.writeInt(0);
    L10:
        BotAction r2 = this.botAction;
        if (r2 != null) goto L13;
        r6.writeInt(0);
    L14:
        r6.writeSerializable(this.botCreatorInfo);
        r6.writeSerializable(this.botStatus);
        Boolean r3 = this.muted;
        if (r3 != null) goto L17;
        r6.writeInt(0);
    L18:
        r6.writeString(this.humanDescription);
        r6.writeSerializable(this.model);
        r6.writeSerializable(this.voice);
        r6.writeString(this.editPos);
        r6.writeSerializable(this.shareInfo);
        Integer r4 = this.privateStatus;
        if (r4 != null) goto L21;
        r6.writeInt(0);
    L22:
        r6.writeInt(this.disabled ? 1 : 0);
        r6.writeString(this.disabledTag);
        r6.writeString(this.bio);
        List<BotConfItem> r5 = this.botConf;
        if (r5 != null) goto L25;
        r6.writeInt(0);
    L29:
        r6.writeString(this.bgImgUrl);
        r6.writeString(this.bgImgColor);
        r6.writeString(this.bgVideoModel);
        r6.writeString(this.bgImgUri);
        r6.writeSerializable(this.bgImgInfo);
        r6.writeSerializable(this.conversationPage);
        r6.writeSerializable(this.switchConfInfo);
        Integer r8 = this.contentDistType;
        if (r8 != null) goto L32;
        r6.writeInt(0);
    L33:
        r6.writeString(this.callerName);
        Boolean r9 = this.callerNameSetting;
        if (r9 != null) goto L36;
        r6.writeInt(0);
    L37:
        r6.writeSerializable(this.firstMet);
        List<ShowTagInfo> r10 = this.tagList;
        if (r10 != null) goto L40;
        r6.writeInt(0);
    L44:
        r6.writeSerializable(this.likeInfo);
        r6.writeSerializable(this.commentInfo);
        r6.writeInt(this.isPlaceHolder ? 1 : 0);
        r6.writeInt(this.loadMoreStatus);
        r6.writeParcelable(this.a, r7);
        r6.writeParcelable(this.b, r7);
        r6.writeInt(this.c ? 1 : 0);
        return;
    L40:
        r6.writeInt(1);
        r6.writeInt(r10.size());
        Iterator<ShowTagInfo> r11 = r10.iterator();
    L42:
        if (r11.hasNext() == false) goto L44;
        r6.writeSerializable((Serializable) r11.next());
        goto L42
    L36:
        r6.writeInt(1);
        r6.writeInt(r9.booleanValue() ? 1 : 0);
        goto L37
    L32:
        r6.writeInt(1);
        r6.writeInt(r8.intValue());
        goto L33
    L25:
        r6.writeInt(1);
        r6.writeInt(r5.size());
        Iterator<BotConfItem> r12 = r5.iterator();
    L27:
        if (r12.hasNext() == false) goto L29;
        r6.writeSerializable((Serializable) r12.next());
        goto L27
    L21:
        r6.writeInt(1);
        r6.writeInt(r4.intValue());
        goto L22
    L17:
        r6.writeInt(1);
        r6.writeInt(r3.booleanValue() ? 1 : 0);
        goto L18
    L13:
        r6.writeInt(1);
        r2.writeToParcel(r6, r7);
        goto L14
    L9:
        r6.writeInt(1);
        r1.writeToParcel(r6, r7);
        goto L10
    L5:
        r6.writeInt(1);
        r6.writeInt(r0.intValue());
        goto L6
    }

    public final boolean c() {
        BgImageInfo r0 = this.bgImgInfo;
        if (r0 == null) goto L7;
        Boolean r1 = r0.getBgImgOpen();
        if (r1 == null) goto L7;
        return r1.booleanValue();
    L7:
        return true;
    }

    public final boolean j0() {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L5;
        r0.P();
        ChatServiceImpl r1 = ChatServiceImpl.a;
    L6:
        if (r1 == null) goto L13;
        String r2 = this.botId;
        if (r2 != null) goto L10;
        r2 = "";
    L10:
        Boolean r3 = r1.e(r2);
        if (r3 == null) goto L13;
        return r3.booleanValue();
    L13:
        BotAction r4 = this.botAction;
        if (r4 == null) goto L21;
        Integer r5 = r4.a();
        if (r5 == null) goto L21;
        if (r5.intValue() != 2) goto L21;
        return true;
    L21:
        return false;
    L5:
        r1 = null;
        goto L6
    }

    public final boolean o0() {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L5;
        r0.P();
        ChatServiceImpl r1 = ChatServiceImpl.a;
    L6:
        if (r1 == null) goto L13;
        String r2 = this.botId;
        if (r2 != null) goto L10;
        r2 = "";
    L10:
        Boolean r3 = r1.h(r2);
        if (r3 == null) goto L13;
        return r3.booleanValue();
    L13:
        return false;
    L5:
        r1 = null;
        goto L6
    }

    public final Integer D() {
        return this.contentDistType;
    }

    public final String E() {
        return this.conversationId;
    }

    public final ConversationPage F() {
        return this.conversationPage;
    }

    public final long I() {
        return this.createTime;
    }

    public final boolean J() {
        return this.disabled;
    }

    public final String K() {
        return this.disabledTag;
    }

    public final String L() {
        return this.editPos;
    }

    public final boolean M() {
        return this.hasConversation;
    }

    public final String N() {
        return this.humanDescription;
    }

    public final BotIconImage O() {
        return this.iconImage;
    }

    public final LikeInfo R() {
        return this.likeInfo;
    }

    public final int S() {
        return this.loadMoreStatus;
    }

    public final ModelItem U() {
        return this.model;
    }

    public final Boolean W() {
        return this.muted;
    }

    public final BotOnBoarding Y() {
        return this.onboarding;
    }

    public final Integer Z() {
        return this.privateStatus;
    }

    public final String a() {
        return this.bgImgColor;
    }

    public final long a0() {
        return this.recommendIndex;
    }

    public final BgImageInfo b() {
        return this.bgImgInfo;
    }

    public final ShareInfo b0() {
        return this.shareInfo;
    }

    public final List<ShowTagInfo> c0() {
        return this.tagList;
    }

    public final String d() {
        return this.bgImgUri;
    }

    public final String e() {
        return this.bgImgUrl;
    }

    public final long f0() {
        return this.updateTime;
    }

    public final String g() {
        return this.bgVideoModel;
    }

    public final String getName() {
        return this.name;
    }

    public final String h() {
        return this.bio;
    }

    public final List<BotConfItem> i() {
        return this.botConf;
    }

    public final SpeakerVoice i0() {
        return this.voice;
    }

    public final BotCreatorInfo j() {
        return this.botCreatorInfo;
    }

    public final String k() {
        return this.botFeatureLabel;
    }

    public final String o() {
        return this.botId;
    }

    public final boolean p0() {
        return this.isPlaceHolder;
    }

    public final BotStatistic q() {
        return this.botStatus;
    }

    public final Integer r() {
        return this.botType;
    }

    public final String s() {
        return this.callerName;
    }

    public final Boolean t() {
        return this.callerNameSetting;
    }

    public final BotCommentInfo z() {
        return this.commentInfo;
    }

    public final void C0(String r1) {
        this.bgImgUrl = r1;
    }

    public final void F0(BotAction r1) {
        this.botAction = r1;
    }

    public final void G0(String r1) {
        this.conversationId = r1;
    }

    public final void H0(int r1) {
        this.loadMoreStatus = r1;
    }

    public final BotRecommendMobInfo I0(String r13) {
        Intrinsics.checkNotNullParameter(r13, "tabId");
        List<ShowTagInfo> r0 = this.tagList;
        if (r0 != null) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        List<ShowTagInfo> r1 = r0;
        Iterator<T> r2 = r1.iterator();
    L6:
        String r3 = null;
        if (r2.hasNext() == false) goto L11;
        Object r4 = r2.next();
        ShowTagInfo.Companion.getClass();
        if (ShowTagInfo.access$getCertificationLabels$cp().contains(Integer.valueOf(((ShowTagInfo) r4).getType())) == false) goto L6;
    L12:
        ShowTagInfo r5 = (ShowTagInfo) r4;
        if (r5 == null) goto L25;
        int r6 = r5.getType();
        if (r6 != 1) goto L17;
        String r7 = "selected";
    L24:
        r3 = r7;
        goto L25
    L17:
        if (r6 != 2) goto L19;
        r7 = "corporate";
        goto L24
    L19:
        if (r6 != 3) goto L25;
        r7 = "official";
    L25:
        String r8 = r3;
        int r9 = 0;
        if ((r1 instanceof Collection) == true) goto L28;
    L30:
        Iterator<T> r10 = r1.iterator();
    L32:
        if (r10.hasNext() == false) goto L38;
        ShowTagInfo r11 = (ShowTagInfo) r10.next();
        ShowTagInfo.Companion.getClass();
        if (ShowTagInfo.access$getCapabilityLabels$cp().contains(Integer.valueOf(r11.getType())) == false) goto L32;
        r9 = r9 + 1;
        if (r9 >= 0) goto L32;
        CollectionsKt.throwCountOverflow();
    L38:
        Iterator<T> r12 = r1.iterator();
        String r14 = "";
    L40:
        if (r12.hasNext() == false) goto L42;
        r14 = r14 + ((ShowTagInfo) r12.next()).getTagId() + ',';
        goto L40
    L42:
        String r15 = StringsKt.removeSuffix(r14, ",");
        String r16 = this.botId;
        if (r8 == null) goto L45;
        String r17 = "1";
    L46:
        if (r9 == 0) goto L48;
        String r18 = "1";
    L50:
        return new BotRecommendMobInfo(r16, r17, r8, r15, r18, String.valueOf(r9), r13);
    L48:
        r18 = "0";
        goto L50
    L45:
        r17 = "0";
        goto L46
    L28:
        if (r1.isEmpty() == false) goto L30;
    L11:
        r4 = null;
        goto L12
    }

    public final void v0(String r1) {
        this.bgImgColor = r1;
    }

    public final void w0(BgImageInfo r1) {
        this.bgImgInfo = r1;
    }

    public final void y0(String r1) {
        this.bgImgUri = r1;
    }

    public /* synthetic */ RecommendBot(String r54, String r55, Integer r56, String r57, BotIconImage r58, long r59, long r61, long r63, boolean r65, String r66, BotOnBoarding r67, BotCreatorInfo r68, BotStatistic r69, Boolean r70, String r71, ModelItem r72, SpeakerVoice r73, String r74, ShareInfo r75, Integer r76, String r77, String r78, List r79, String r80, String r81, String r82, String r83, BgImageInfo r84, ConversationPage r85, String r86, Boolean r87, List r88, LikeInfo r89, BotCommentInfo r90, boolean r91, RecommendFrom r92, int r93, int r94) {
        String r3 = "";
        if ((r93 & 1) == 0) goto L5;
        String r5 = "";
    L7:
        if ((r93 & 2) == 0) goto L9;
        String r6 = "";
    L11:
        if ((r93 & 4) == 0) goto L13;
        Integer r7 = null;
    L15:
        if ((r93 & 8) == 0) goto L17;
        String r8 = null;
    L19:
        if ((r93 & 16) == 0) goto L21;
        int r2 = -1;
    L23:
        if ((r93 & 32) == 0) goto L25;
        BotIconImage r10 = null;
    L27:
        if ((r93 & 64) == 0) goto L29;
        long r14 = 0;
    L31:
        if ((r93 & 128) == 0) goto L33;
        long r16 = 0;
    L35:
        if ((r93 & 256) == 0) goto L37;
        long r18 = 0;
    L39:
        if ((r93 & 512) == 0) goto L41;
        boolean r20 = false;
    L43:
        if ((r93 & 1024) == 0) goto L45;
        String r21 = "";
    L47:
        if ((r93 & 2048) == 0) goto L49;
        BotOnBoarding r22 = null;
    L51:
        if ((r93 & 8192) == 0) goto L53;
        BotCreatorInfo r24 = null;
    L55:
        if ((r93 & 16384) == 0) goto L57;
        BotStatistic r25 = null;
    L59:
        if ((32768 & r93) == 0) goto L61;
        Boolean r26 = Boolean.FALSE;
    L63:
        if ((65536 & r93) == 0) goto L65;
        String r27 = "";
    L67:
        if ((131072 & r93) == 0) goto L69;
        ModelItem r28 = null;
    L71:
        if ((262144 & r93) == 0) goto L73;
        SpeakerVoice r29 = null;
    L75:
        if ((524288 & r93) == 0) goto L77;
        String r30 = "";
    L79:
        if ((1048576 & r93) == 0) goto L81;
        ShareInfo r31 = null;
    L83:
        if ((2097152 & r93) == 0) goto L85;
        Integer r32 = null;
    L87:
        if ((8388608 & r93) == 0) goto L89;
        String r34 = "";
    L91:
        if ((16777216 & r93) != 0) goto L95;
        r3 = r78;
    L95:
        if ((33554432 & r93) == 0) goto L97;
        List r35 = null;
    L99:
        if ((67108864 & r93) == 0) goto L101;
        String r36 = null;
    L103:
        if ((134217728 & r93) == 0) goto L105;
        String r37 = null;
    L107:
        if ((268435456 & r93) == 0) goto L109;
        String r38 = null;
    L111:
        if ((536870912 & r93) == 0) goto L113;
        String r39 = null;
    L115:
        if ((1073741824 & r93) == 0) goto L117;
        BgImageInfo r40 = null;
    L119:
        if ((r93 & Integer.MIN_VALUE) == 0) goto L121;
        ConversationPage r0 = null;
    L123:
        if ((r94 & 2) == 0) goto L125;
        Integer r42 = 0;
    L127:
        if ((r94 & 4) == 0) goto L129;
        String r43 = null;
    L131:
        if ((r94 & 8) == 0) goto L133;
        Boolean r44 = Boolean.FALSE;
    L135:
        if ((r94 & 32) == 0) goto L137;
        List r46 = null;
    L139:
        if ((r94 & 64) == 0) goto L141;
        LikeInfo r47 = null;
    L143:
        if ((r94 & 128) == 0) goto L145;
        BotCommentInfo r48 = null;
    L147:
        if ((r94 & 256) == 0) goto L149;
        boolean r49 = false;
    L151:
        if ((r94 & 1024) == 0) goto L153;
        RecommendFrom r1 = null;
    L154:
        this(r5, r6, r7, r8, r2, r10, r14, r16, r18, r20, r21, r22, null, r24, r25, r26, r27, r28, r29, r30, r31, r32, false, r34, r3, r35, r36, r37, r38, r39, r40, r0, null, r42, r43, r44, null, r46, r47, r48, r49, 0, r1, null, false);
        return;
    L153:
        r1 = r92;
        goto L154
    L149:
        r49 = r91;
        goto L151
    L145:
        r48 = r90;
        goto L147
    L141:
        r47 = r89;
        goto L143
    L137:
        r46 = r88;
        goto L139
    L133:
        r44 = r87;
        goto L135
    L129:
        r43 = r86;
        goto L131
    L125:
        r42 = null;
        goto L127
    L121:
        r0 = r85;
        goto L123
    L117:
        r40 = r84;
        goto L119
    L113:
        r39 = r83;
        goto L115
    L109:
        r38 = r82;
        goto L111
    L105:
        r37 = r81;
        goto L107
    L101:
        r36 = r80;
        goto L103
    L97:
        r35 = r79;
        goto L99
    L89:
        r34 = r77;
        goto L91
    L85:
        r32 = r76;
        goto L87
    L81:
        r31 = r75;
        goto L83
    L77:
        r30 = r74;
        goto L79
    L73:
        r29 = r73;
        goto L75
    L69:
        r28 = r72;
        goto L71
    L65:
        r27 = r71;
        goto L67
    L61:
        r26 = r70;
        goto L63
    L57:
        r25 = r69;
        goto L59
    L53:
        r24 = r68;
        goto L55
    L49:
        r22 = r67;
        goto L51
    L45:
        r21 = r66;
        goto L47
    L41:
        r20 = r65;
        goto L43
    L37:
        r18 = r63;
        goto L39
    L33:
        r16 = r61;
        goto L35
    L29:
        r14 = r59;
        goto L31
    L25:
        r10 = r58;
        goto L27
    L21:
        r2 = 0;
        goto L23
    L17:
        r8 = r57;
        goto L19
    L13:
        r7 = r56;
        goto L15
    L9:
        r6 = r55;
        goto L11
    L5:
        r5 = r54;
        goto L7
    }

    public RecommendBot(String r4, String r5, Integer r6, String r7, int r8, BotIconImage r9, long r10, long r12, long r14, boolean r16, String r17, BotOnBoarding r18, BotAction r19, BotCreatorInfo r20, BotStatistic r21, Boolean r22, String r23, ModelItem r24, SpeakerVoice r25, String r26, ShareInfo r27, Integer r28, boolean r29, String r30, String r31, List<BotConfItem> r32, String r33, String r34, String r35, String r36, BgImageInfo r37, ConversationPage r38, BotSwitchConfInfo r39, Integer r40, String r41, Boolean r42, FirstMet r43, List<ShowTagInfo> r44, LikeInfo r45, BotCommentInfo r46, boolean r47, int r48, RecommendFrom r49, SearchMobParam r50, boolean r51) {
        this.botId = r4;
        this.name = r5;
        this.botType = r6;
        this.botFeatureLabel = r7;
        this.botMode = r8;
        this.iconImage = r9;
        this.createTime = r10;
        this.updateTime = r12;
        this.recommendIndex = r14;
        this.hasConversation = r16;
        this.conversationId = r17;
        this.onboarding = r18;
        this.botAction = r19;
        this.botCreatorInfo = r20;
        this.botStatus = r21;
        this.muted = r22;
        this.humanDescription = r23;
        this.model = r24;
        this.voice = r25;
        this.editPos = r26;
        this.shareInfo = r27;
        this.privateStatus = r28;
        this.disabled = r29;
        this.disabledTag = r30;
        this.bio = r31;
        this.botConf = r32;
        this.bgImgUrl = r33;
        this.bgImgColor = r34;
        this.bgVideoModel = r35;
        this.bgImgUri = r36;
        this.bgImgInfo = r37;
        this.conversationPage = r38;
        this.switchConfInfo = r39;
        this.contentDistType = r40;
        this.callerName = r41;
        this.callerNameSetting = r42;
        this.firstMet = r43;
        this.tagList = r44;
        this.likeInfo = r45;
        this.commentInfo = r46;
        this.isPlaceHolder = r47;
        this.loadMoreStatus = r48;
        this.a = r49;
        this.b = r50;
        this.c = r51;
    }
}
