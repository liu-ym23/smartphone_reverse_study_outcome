package com.bytedance.android.livesdk.interactivity.service.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.chatroom.model.interact.j0;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdkapi.depend.model.DesireInfo;
import com.bytedance.android.livesdkapi.depend.model.live.ActivityRoomSkinInfo;
import com.bytedance.android.livesdkapi.depend.model.live.AnchorTabLabel;
import com.bytedance.android.livesdkapi.depend.model.live.ClientComponent;
import com.bytedance.android.livesdkapi.depend.model.live.CommentaryRoomInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IAnchorData;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IEcomData;
import com.bytedance.android.livesdkapi.depend.model.live.IExtension;
import com.bytedance.android.livesdkapi.depend.model.live.IGameCPData;
import com.bytedance.android.livesdkapi.depend.model.live.ILabelInfo;
import com.bytedance.android.livesdkapi.depend.model.live.ILinkerUsers;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveHashTagInfo;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveNearbyTVInfo;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveStatusInfo;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveToolbarData;
import com.bytedance.android.livesdkapi.depend.model.live.IOfficialChannelInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IPSSelectedMessageInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IPreviewExposeData;
import com.bytedance.android.livesdkapi.depend.model.live.IPublicScreenSpeedConfig;
import com.bytedance.android.livesdkapi.depend.model.live.IRelevantRecommendation;
import com.bytedance.android.livesdkapi.depend.model.live.IReplayInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAppearance;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBasisData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomCart;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomGameData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomIMInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomOthersData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomPlatformComponentsData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomSpecificSceneTypeInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomStats;
import com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.OfficialChannelExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.RoomExtra;
import com.bytedance.android.livesdkapi.depend.model.live.RoomInteractData;
import com.bytedance.android.livesdkapi.depend.model.live.RoomStampInfo;
import com.bytedance.android.livesdkapi.depend.model.live.ShortTermIndicatorConfig;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.depend.model.live.circleinfo.ICircleInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfoBase;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IPaidLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.toolbar.RoomStreamDataObject;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import py.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000â\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bD\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\f\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u0012\u0012\u0007\u0010Ø\u0003\u001a\u00020\u0002¢\u0006\u0006\bÙ\u0003\u0010Ú\u0003J\u0011\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\t\u0010\n\u001a\u00020\tH\u0096\u0001J\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0096\u0001J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096\u0001J.\u0010\u0011\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0096\u0001¢\u0006\u0004\b\u0011\u0010\u0012J0\u0010\u0013\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0096\u0001¢\u0006\u0004\b\u0013\u0010\u0012J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0096\u0001J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0096\u0001J\u0017\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u0018H\u0096\u0001J\u0017\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u0018H\u0096\u0001J\u0013\u0010\u001c\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001b\u001a\u00020\rH\u0096\u0001J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\rH\u0096\u0001J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0096\u0001J\u000b\u0010!\u001a\u0004\u0018\u00010 H\u0096\u0001J\u000b\u0010\"\u001a\u0004\u0018\u00010\rH\u0096\u0001J\u000b\u0010#\u001a\u0004\u0018\u00010\u000bH\u0096\u0001J\u000b\u0010$\u001a\u0004\u0018\u00010\rH\u0096\u0001J\u000b\u0010&\u001a\u0004\u0018\u00010%H\u0096\u0001J\t\u0010'\u001a\u00020\u0005H\u0096\u0001J\u000b\u0010(\u001a\u0004\u0018\u00010\rH\u0096\u0001J\u000b\u0010)\u001a\u0004\u0018\u00010\rH\u0096\u0001J\u000b\u0010*\u001a\u0004\u0018\u00010\rH\u0096\u0001J\u000b\u0010,\u001a\u0004\u0018\u00010+H\u0096\u0001J\u000b\u0010-\u001a\u0004\u0018\u00010\rH\u0096\u0001J\u000b\u0010/\u001a\u0004\u0018\u00010.H\u0096\u0001J\u000b\u00100\u001a\u0004\u0018\u00010\rH\u0096\u0001J\u000b\u00102\u001a\u0004\u0018\u000101H\u0096\u0001J\u000b\u00104\u001a\u0004\u0018\u000103H\u0096\u0001J\u000b\u00105\u001a\u0004\u0018\u000103H\u0096\u0001J\u000b\u00107\u001a\u0004\u0018\u000106H\u0096\u0001J\t\u00108\u001a\u00020\u0005H\u0096\u0001J\t\u00109\u001a\u00020\u0005H\u0096\u0001J\u000b\u0010;\u001a\u0004\u0018\u00010:H\u0096\u0001J\u0011\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010<H\u0096\u0001J\t\u0010?\u001a\u00020>H\u0096\u0001J\t\u0010@\u001a\u00020\u0005H\u0096\u0001J\t\u0010A\u001a\u00020>H\u0096\u0001J\u0012\u0010B\u001a\u0004\u0018\u00010>H\u0096\u0001¢\u0006\u0004\bB\u0010CJ\t\u0010D\u001a\u00020>H\u0096\u0001J\u000b\u0010E\u001a\u0004\u0018\u00010\rH\u0096\u0001J\u000b\u0010G\u001a\u0004\u0018\u00010FH\u0096\u0001J\t\u0010H\u001a\u00020\u0005H\u0096\u0001J\u000b\u0010J\u001a\u0004\u0018\u00010IH\u0096\u0001J\u000b\u0010K\u001a\u0004\u0018\u00010\rH\u0096\u0001J\t\u0010L\u001a\u00020>H\u0096\u0001J\t\u0010M\u001a\u00020\rH\u0096\u0001J\t\u0010N\u001a\u00020\u0005H\u0096\u0001J\u000b\u0010O\u001a\u0004\u0018\u00010\rH\u0096\u0001J\u000b\u0010P\u001a\u0004\u0018\u00010\rH\u0096\u0001J\u000b\u0010Q\u001a\u0004\u0018\u00010\rH\u0096\u0001J\u000b\u0010S\u001a\u0004\u0018\u00010RH\u0096\u0001J\u000b\u0010U\u001a\u0004\u0018\u00010TH\u0096\u0001J\u000b\u0010V\u001a\u0004\u0018\u00010\rH\u0096\u0001J\u000b\u0010W\u001a\u0004\u0018\u00010\u000bH\u0096\u0001J\t\u0010X\u001a\u00020\rH\u0096\u0001J\u000b\u0010Z\u001a\u0004\u0018\u00010YH\u0096\u0001J\u000b\u0010\\\u001a\u0004\u0018\u00010[H\u0096\u0001J\t\u0010]\u001a\u00020\u0005H\u0096\u0001J\u000b\u0010_\u001a\u0004\u0018\u00010^H\u0096\u0001J\t\u0010`\u001a\u00020\rH\u0096\u0001J\t\u0010b\u001a\u00020aH\u0096\u0001J\t\u0010c\u001a\u00020>H\u0096\u0001J\u000b\u0010e\u001a\u0004\u0018\u00010dH\u0096\u0001J\u000b\u0010g\u001a\u0004\u0018\u00010fH\u0096\u0001J\t\u0010h\u001a\u00020>H\u0096\u0001J\u000b\u0010j\u001a\u0004\u0018\u00010iH\u0096\u0001J\u000b\u0010k\u001a\u0004\u0018\u00010\rH\u0096\u0001J\u0011\u0010n\u001a\n\u0012\u0004\u0012\u00020m\u0018\u00010lH\u0096\u0001J\u000b\u0010p\u001a\u0004\u0018\u00010oH\u0096\u0001J\t\u0010q\u001a\u00020\u0005H\u0096\u0001J\u000b\u0010s\u001a\u0004\u0018\u00010rH\u0096\u0001J\u000b\u0010t\u001a\u0004\u0018\u00010\rH\u0096\u0001J\t\u0010u\u001a\u00020>H\u0096\u0001J\u0011\u0010v\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010lH\u0096\u0001J\t\u0010x\u001a\u00020wH\u0096\u0001J\u000b\u0010z\u001a\u0004\u0018\u00010yH\u0096\u0001J\t\u0010{\u001a\u00020yH\u0096\u0001J\u000b\u0010|\u001a\u0004\u0018\u00010yH\u0096\u0001J\t\u0010}\u001a\u00020\u0005H\u0096\u0001J\t\u0010~\u001a\u00020\tH\u0096\u0001J\t\u0010\u007f\u001a\u00020\u0007H\u0096\u0001J\n\u0010\u0080\u0001\u001a\u00020\tH\u0096\u0001J\n\u0010\u0081\u0001\u001a\u00020\tH\u0096\u0001J\f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\rH\u0096\u0001J\n\u0010\u0083\u0001\u001a\u00020\tH\u0096\u0001J\u0013\u0010\u0085\u0001\u001a\u00020\t2\u0007\u0010\u0084\u0001\u001a\u00020\tH\u0096\u0001J\n\u0010\u0086\u0001\u001a\u00020\tH\u0096\u0001J\n\u0010\u0087\u0001\u001a\u00020\tH\u0096\u0001J\n\u0010\u0088\u0001\u001a\u00020\u0005H\u0096\u0001J\u0013\u0010\u008a\u0001\u001a\u00020\t2\u0007\u0010\u0089\u0001\u001a\u00020\rH\u0096\u0001J\n\u0010\u008b\u0001\u001a\u00020\tH\u0096\u0001J\n\u0010\u008c\u0001\u001a\u00020\tH\u0096\u0001J\n\u0010\u008d\u0001\u001a\u00020\tH\u0096\u0001J\n\u0010\u008e\u0001\u001a\u00020\tH\u0096\u0001J\n\u0010\u008f\u0001\u001a\u00020\tH\u0096\u0001J\n\u0010\u0090\u0001\u001a\u00020\tH\u0096\u0001J\n\u0010\u0091\u0001\u001a\u00020\tH\u0096\u0001J\n\u0010\u0092\u0001\u001a\u00020\tH\u0096\u0001J\n\u0010\u0093\u0001\u001a\u00020\tH\u0096\u0001J\n\u0010\u0094\u0001\u001a\u00020\tH\u0096\u0001J\n\u0010\u0095\u0001\u001a\u00020\tH\u0096\u0001J\n\u0010\u0096\u0001\u001a\u00020\tH\u0096\u0001J\n\u0010\u0097\u0001\u001a\u00020\tH\u0096\u0001J\n\u0010\u0098\u0001\u001a\u00020\tH\u0096\u0001J\n\u0010\u0099\u0001\u001a\u00020\tH\u0096\u0001J\n\u0010\u009a\u0001\u001a\u00020\tH\u0096\u0001J\n\u0010\u009b\u0001\u001a\u00020\tH\u0096\u0001J\n\u0010\u009c\u0001\u001a\u00020\tH\u0096\u0001J\n\u0010\u009d\u0001\u001a\u00020\tH\u0096\u0001J\n\u0010\u009e\u0001\u001a\u00020\tH\u0096\u0001J\n\u0010\u009f\u0001\u001a\u00020\tH\u0096\u0001J\n\u0010 \u0001\u001a\u00020\tH\u0096\u0001J\n\u0010¡\u0001\u001a\u00020\tH\u0096\u0001J\u0015\u0010£\u0001\u001a\u00020\u00072\t\u0010¢\u0001\u001a\u0004\u0018\u00010\u001eH\u0096\u0001J\u0015\u0010¥\u0001\u001a\u00020\u00072\t\u0010¤\u0001\u001a\u0004\u0018\u00010\u000bH\u0096\u0001J\u0015\u0010§\u0001\u001a\u00020\u00072\t\u0010¦\u0001\u001a\u0004\u0018\u00010\rH\u0096\u0001J\u0013\u0010©\u0001\u001a\u00020\u00072\u0007\u0010¨\u0001\u001a\u00020>H\u0096\u0001J\u001e\u0010«\u0001\u001a\u00020\u00072\t\u0010ª\u0001\u001a\u0004\u0018\u00010>H\u0096\u0001¢\u0006\u0006\b«\u0001\u0010¬\u0001J\u0013\u0010®\u0001\u001a\u00020\u00072\u0007\u0010\u00ad\u0001\u001a\u00020\tH\u0096\u0001J\u0015\u0010°\u0001\u001a\u00020\u00072\t\u0010¯\u0001\u001a\u0004\u0018\u00010FH\u0096\u0001J\u0015\u0010²\u0001\u001a\u00020\u00072\t\u0010±\u0001\u001a\u0004\u0018\u00010\rH\u0096\u0001J\u001b\u0010´\u0001\u001a\u00020\u00072\u000f\u0010³\u0001\u001a\n\u0012\u0004\u0012\u00020m\u0018\u00010lH\u0096\u0001J\u0015\u0010¶\u0001\u001a\u00020\u00072\t\u0010µ\u0001\u001a\u0004\u0018\u00010\rH\u0096\u0001J\u0015\u0010·\u0001\u001a\u00020\u00072\t\u0010¤\u0001\u001a\u0004\u0018\u00010\u000bH\u0096\u0001J\u0012\u0010¸\u0001\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\u0015\u0010º\u0001\u001a\u00020\u00072\t\u0010¹\u0001\u001a\u0004\u0018\u00010\rH\u0096\u0001J\u0015\u0010¼\u0001\u001a\u00020\u00072\t\u0010»\u0001\u001a\u0004\u0018\u00010oH\u0096\u0001J\u0014\u0010½\u0001\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\rH\u0096\u0001R\u001a\u0010Á\u0001\u001a\u0005\u0018\u00010¾\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b¿\u0001\u0010À\u0001R\u0019\u0010Ä\u0001\u001a\u0004\u0018\u00010:8VX\u0096\u0004¢\u0006\b\u001a\u0006\bÂ\u0001\u0010Ã\u0001R\u001a\u0010È\u0001\u001a\u0005\u0018\u00010Å\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\bÆ\u0001\u0010Ç\u0001R!\u0010Í\u0001\u001a\u00020>8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bÉ\u0001\u0010Ê\u0001\"\u0006\bË\u0001\u0010Ì\u0001R\u001a\u0010Ñ\u0001\u001a\u0005\u0018\u00010Î\u00018\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\bÏ\u0001\u0010Ð\u0001R!\u0010Ö\u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bÒ\u0001\u0010Ó\u0001\"\u0006\bÔ\u0001\u0010Õ\u0001R\u001a\u0010Ú\u0001\u001a\u0005\u0018\u00010×\u00018\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\bØ\u0001\u0010Ù\u0001R!\u0010Ý\u0001\u001a\u00020>8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bÛ\u0001\u0010Ê\u0001\"\u0006\bÜ\u0001\u0010Ì\u0001R$\u0010ã\u0001\u001a\u0005\u0018\u00010Þ\u00018\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bß\u0001\u0010à\u0001\"\u0006\bá\u0001\u0010â\u0001R$\u0010é\u0001\u001a\u0005\u0018\u00010ä\u00018\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bå\u0001\u0010æ\u0001\"\u0006\bç\u0001\u0010è\u0001R!\u0010ì\u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bê\u0001\u0010Ó\u0001\"\u0006\bë\u0001\u0010Õ\u0001R$\u0010ò\u0001\u001a\u0005\u0018\u00010í\u00018\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bî\u0001\u0010ï\u0001\"\u0006\bð\u0001\u0010ñ\u0001R$\u0010õ\u0001\u001a\u0005\u0018\u00010Þ\u00018\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bó\u0001\u0010à\u0001\"\u0006\bô\u0001\u0010â\u0001R!\u0010ú\u0001\u001a\u00020\r8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bö\u0001\u0010÷\u0001\"\u0006\bø\u0001\u0010ù\u0001R$\u0010ý\u0001\u001a\u0005\u0018\u00010Þ\u00018\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bû\u0001\u0010à\u0001\"\u0006\bü\u0001\u0010â\u0001R!\u0010\u0080\u0002\u001a\u00020>8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bþ\u0001\u0010Ê\u0001\"\u0006\bÿ\u0001\u0010Ì\u0001R!\u0010\u0083\u0002\u001a\u00020>8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b\u0081\u0002\u0010Ê\u0001\"\u0006\b\u0082\u0002\u0010Ì\u0001R#\u0010\u0086\u0002\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b\u0084\u0002\u0010÷\u0001\"\u0006\b\u0085\u0002\u0010ù\u0001R#\u0010\u0089\u0002\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b\u0087\u0002\u0010÷\u0001\"\u0006\b\u0088\u0002\u0010ù\u0001R\u001a\u0010\u008b\u0002\u001a\u0005\u0018\u00010×\u00018\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b\u008a\u0002\u0010Ù\u0001R\u0019\u0010\u008e\u0002\u001a\u0004\u0018\u0001018\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b\u008c\u0002\u0010\u008d\u0002R\u001a\u0010\u0092\u0002\u001a\u0005\u0018\u00010\u008f\u00028\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b\u0090\u0002\u0010\u0091\u0002R!\u0010\u0095\u0002\u001a\u00020>8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b\u0093\u0002\u0010Ê\u0001\"\u0006\b\u0094\u0002\u0010Ì\u0001R$\u0010\u009b\u0002\u001a\u0005\u0018\u00010\u0096\u00028\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b\u0097\u0002\u0010\u0098\u0002\"\u0006\b\u0099\u0002\u0010\u009a\u0002R!\u0010\u009e\u0002\u001a\u00020>8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b\u009c\u0002\u0010Ê\u0001\"\u0006\b\u009d\u0002\u0010Ì\u0001R!\u0010¡\u0002\u001a\u00020\r8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b\u009f\u0002\u0010÷\u0001\"\u0006\b \u0002\u0010ù\u0001R#\u0010¤\u0002\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b¢\u0002\u0010÷\u0001\"\u0006\b£\u0002\u0010ù\u0001R!\u0010¥\u0002\u001a\u00020\t8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b¥\u0002\u0010¦\u0002\"\u0006\b§\u0002\u0010¨\u0002R\u0017\u0010©\u0002\u001a\u00020\t8\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b©\u0002\u0010¦\u0002R!\u0010ª\u0002\u001a\u00020\t8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bª\u0002\u0010¦\u0002\"\u0006\b«\u0002\u0010¨\u0002R!\u0010¬\u0002\u001a\u00020\t8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b¬\u0002\u0010¦\u0002\"\u0006\b\u00ad\u0002\u0010¨\u0002R\u0017\u0010®\u0002\u001a\u00020\t8\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b®\u0002\u0010¦\u0002R\u0017\u0010¯\u0002\u001a\u00020\t8\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b¯\u0002\u0010¦\u0002R#\u0010²\u0002\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b°\u0002\u0010÷\u0001\"\u0006\b±\u0002\u0010ù\u0001R#\u0010µ\u0002\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b³\u0002\u0010÷\u0001\"\u0006\b´\u0002\u0010ù\u0001R\u001c\u0010¸\u0002\u001a\u00070>j\u0003`¶\u00028\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b·\u0002\u0010Ê\u0001R4\u0010¼\u0002\u001a\u001f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020>0\u0018j\u000f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020>`¹\u00028\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\bº\u0002\u0010»\u0002R!\u0010¿\u0002\u001a\u00020>8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b½\u0002\u0010Ê\u0001\"\u0006\b¾\u0002\u0010Ì\u0001R$\u0010Å\u0002\u001a\u0005\u0018\u00010À\u00028\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bÁ\u0002\u0010Â\u0002\"\u0006\bÃ\u0002\u0010Ä\u0002R\u001a\u0010É\u0002\u001a\u0005\u0018\u00010Æ\u00028\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\bÇ\u0002\u0010È\u0002R!\u0010Ì\u0002\u001a\u00020>8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bÊ\u0002\u0010Ê\u0001\"\u0006\bË\u0002\u0010Ì\u0001R#\u0010Ï\u0002\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bÍ\u0002\u0010÷\u0001\"\u0006\bÎ\u0002\u0010ù\u0001R#\u0010Ò\u0002\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bÐ\u0002\u0010÷\u0001\"\u0006\bÑ\u0002\u0010ù\u0001R\u001c\u0010Ô\u0002\u001a\u00070>j\u0003`¶\u00028\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\bÓ\u0002\u0010Ê\u0001R#\u0010×\u0002\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bÕ\u0002\u0010÷\u0001\"\u0006\bÖ\u0002\u0010ù\u0001R$\u0010Ý\u0002\u001a\u0005\u0018\u00010Ø\u00028\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bÙ\u0002\u0010Ú\u0002\"\u0006\bÛ\u0002\u0010Ü\u0002R!\u0010à\u0002\u001a\u00020\t8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bÞ\u0002\u0010¦\u0002\"\u0006\bß\u0002\u0010¨\u0002R!\u0010ã\u0002\u001a\u00020\t8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bá\u0002\u0010¦\u0002\"\u0006\bâ\u0002\u0010¨\u0002R!\u0010æ\u0002\u001a\u00020\t8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bä\u0002\u0010¦\u0002\"\u0006\bå\u0002\u0010¨\u0002R\u0019\u0010é\u0002\u001a\u0004\u0018\u00010a8\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\bç\u0002\u0010è\u0002R$\u0010ì\u0002\u001a\u0005\u0018\u00010Þ\u00018\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bê\u0002\u0010à\u0001\"\u0006\bë\u0002\u0010â\u0001R*\u0010ò\u0002\u001a\u000b\u0018\u00010\u000bj\u0005\u0018\u0001`í\u00028\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bî\u0002\u0010ï\u0002\"\u0006\bð\u0002\u0010ñ\u0002R\u001a\u0010ö\u0002\u001a\u0005\u0018\u00010ó\u00028\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\bô\u0002\u0010õ\u0002R\u0017\u0010ø\u0002\u001a\u00020>8\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b÷\u0002\u0010Ê\u0001R!\u0010û\u0002\u001a\u00020>8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bù\u0002\u0010Ê\u0001\"\u0006\bú\u0002\u0010Ì\u0001R#\u0010þ\u0002\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bü\u0002\u0010÷\u0001\"\u0006\bý\u0002\u0010ù\u0001R!\u0010\u0081\u0003\u001a\u00020>8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bÿ\u0002\u0010Ê\u0001\"\u0006\b\u0080\u0003\u0010Ì\u0001R!\u0010\u0084\u0003\u001a\u00020\t8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b\u0082\u0003\u0010¦\u0002\"\u0006\b\u0083\u0003\u0010¨\u0002R$\u0010\u008a\u0003\u001a\u0005\u0018\u00010\u0085\u00038\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b\u0086\u0003\u0010\u0087\u0003\"\u0006\b\u0088\u0003\u0010\u0089\u0003R$\u0010\u0090\u0003\u001a\u0005\u0018\u00010\u008b\u00038\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b\u008c\u0003\u0010\u008d\u0003\"\u0006\b\u008e\u0003\u0010\u008f\u0003R$\u0010\u0096\u0003\u001a\u0005\u0018\u00010\u0091\u00038\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b\u0092\u0003\u0010\u0093\u0003\"\u0006\b\u0094\u0003\u0010\u0095\u0003R\u001c\u0010\u0098\u0003\u001a\u00070>j\u0003`¶\u00028\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b\u0097\u0003\u0010Ê\u0001R\u001a\u0010\u009c\u0003\u001a\u0005\u0018\u00010\u0099\u00038\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b\u009a\u0003\u0010\u009b\u0003R#\u0010\u009f\u0003\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b\u009d\u0003\u0010÷\u0001\"\u0006\b\u009e\u0003\u0010ù\u0001R#\u0010¢\u0003\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b \u0003\u0010÷\u0001\"\u0006\b¡\u0003\u0010ù\u0001R$\u0010¨\u0003\u001a\u0005\u0018\u00010£\u00038\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b¤\u0003\u0010¥\u0003\"\u0006\b¦\u0003\u0010§\u0003R!\u0010«\u0003\u001a\u00020>8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b©\u0003\u0010Ê\u0001\"\u0006\bª\u0003\u0010Ì\u0001R!\u0010®\u0003\u001a\u00020>8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b¬\u0003\u0010Ê\u0001\"\u0006\b\u00ad\u0003\u0010Ì\u0001R!\u0010±\u0003\u001a\u00020>8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b¯\u0003\u0010Ê\u0001\"\u0006\b°\u0003\u0010Ì\u0001R\u001a\u0010µ\u0003\u001a\u0005\u0018\u00010²\u00038\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b³\u0003\u0010´\u0003R#\u0010¸\u0003\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b¶\u0003\u0010÷\u0001\"\u0006\b·\u0003\u0010ù\u0001R\u001a\u0010¼\u0003\u001a\u0005\u0018\u00010¹\u00038\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\bº\u0003\u0010»\u0003R$\u0010Â\u0003\u001a\u0005\u0018\u00010½\u00038\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b¾\u0003\u0010¿\u0003\"\u0006\bÀ\u0003\u0010Á\u0003R!\u0010Å\u0003\u001a\u00020>8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bÃ\u0003\u0010Ê\u0001\"\u0006\bÄ\u0003\u0010Ì\u0001R#\u0010È\u0003\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bÆ\u0003\u0010÷\u0001\"\u0006\bÇ\u0003\u0010ù\u0001R#\u0010Ë\u0003\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bÉ\u0003\u0010÷\u0001\"\u0006\bÊ\u0003\u0010ù\u0001R!\u0010Î\u0003\u001a\u00020\u00058\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bÌ\u0003\u0010Ó\u0001\"\u0006\bÍ\u0003\u0010Õ\u0001R$\u0010Ô\u0003\u001a\u0005\u0018\u00010Ï\u00038\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bÐ\u0003\u0010Ñ\u0003\"\u0006\bÒ\u0003\u0010Ó\u0003R!\u0010×\u0003\u001a\u00020\t8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bÕ\u0003\u0010¦\u0002\"\u0006\bÖ\u0003\u0010¨\u0002¨\u0006Û\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/service/model/ICommunityMainRoomExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lcom/bytedance/android/livesdk/interactivity/service/model/ICommunityMainRoom;", "Lvh7/e;", BuildConfig.FLAVOR, "type", BuildConfig.FLAVOR, "addGameStickerType", BuildConfig.FLAVOR, "allowGift", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "authorFlex", BuildConfig.FLAVOR, "buildPullUrl", "R", "Ljava/lang/Class;", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "Lcom/bytedance/android/livesdkapi/depend/model/live/ActivityRoomSkinInfo;", "getActivityRoomSkinInfo", "Lcom/bytedance/android/livesdk/strategy/a;", "getAdStrategyFeatures", BuildConfig.FLAVOR, "getAnchorABMap", "getAnchorAbMapFlex", "key", "getAnchorAbValue", "getAnchorId", "Lcom/bytedance/android/livesdkapi/depend/model/live/AnchorTabLabel;", "getAnchorTabLabel", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAppearance;", "getAppearanceFlex", "getAudienceType", "getBaseOwner", "getClientVersion", "Lcom/bytedance/android/livesdkapi/depend/model/live/CommentaryRoomInfo;", "getCommentaryRoomInfo", "getCompoundSceneType", "getCompoundStreamData", "getCoverUrl", "getDefaultQualityStrategy", "Lcom/bytedance/android/livesdkapi/depend/model/DesireInfo;", "getDesireInfo", "getDygamePromoteInstanceId", "Lcom/bytedance/android/livesdkapi/depend/model/live/IEcomData;", "getEcomData", "getEnterLogId", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeExtraInfo;", "getEpisodeComponentData", "Lcom/bytedance/android/livesdkapi/depend/model/live/IExtension;", "getExtension", "getExtensionFlex", "Lcom/bytedance/android/livesdkapi/depend/model/live/RoomExtra;", "getExtra", "getFansMessageStyle", "getFollowMessageStyle", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomGameData;", "getGameData", BuildConfig.FLAVOR, "getGameStickerTypes", BuildConfig.FLAVOR, "getGameTagId", "getGiftMessageStyle", "getId", "getInitTime", "()Ljava/lang/Long;", "getLandscapeCommentStyle", "getLifeShareId", "Lcom/bytedance/android/livesdk/chatroom/model/interact/j0;", "getLinkInitResult", "getLinkMicScene", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveHashTagInfo;", "getLiveHashTagInfo", "getLiveReason", "getLiveRoomModeKmp", "getLog_pb", "getMosaicStatusFlex", "getMultiStreamData", "getMultiStreamDataFromPool", "getMultiStreamDefaultQualitySdkKey", "Lcom/bytedance/android/livesdkapi/depend/model/live/OfficialChannelExtraInfo;", "getOfficialChannelExtraInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/IOfficialChannelInfo;", "getOfficialChannelInfo", "getOfficialChannelUidString", "getOwner", "getOwnerUserIdString", "Lcom/bytedance/android/livesdkapi/depend/model/live/IPSSelectedMessageInfo;", "getPSSelectedMessageInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/IPublicScreenSpeedConfig;", "getPublicScreenSpeedConfig", "getPullType", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRelevantRecommendation;", "getRelevantRecommendationFlex", "getRequestId", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatus;", "getRoomAuthStatus", "getRoomId", "Lcom/bytedance/android/livesdkapi/depend/model/live/RoomInteractData;", "getRoomInteractData", "Lpy/r;", "getRoomIntroLabel", "getRoomLayoutKmp", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomOthersData;", "getRoomOthers", "getRoomRevenueOpenGameAppId", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdkapi/depend/model/live/RoomStampInfo;", "getRoomStamps", "Lcom/bytedance/android/livesdkapi/depend/model/live/toolbar/RoomStreamDataObject;", "getRoomStreamDataObject", "getShareMessageStyle", "Lcom/bytedance/android/livesdkapi/depend/model/live/ShortTermIndicatorConfig;", "getShortTermIndicatorConfig", "getSourceType", "getStartTimeFlex", "getStrategyFeatWhitelist", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveMode;", "getStreamType", "Lcom/bytedance/android/livesdkapi/depend/model/live/IStreamUrlExtra;", "getStreamUrlExtra", "getStreamUrlExtraSafely", "getStreamUrlExtraSafelyFlex", "getVRType", "hasValidImInfo", "init", "isCompoundScene", "isD3Room", "isEcomCart", "isEcomNew", "isLandscape", "isEnableChat", "isFromRecommendCard", "isGameCPRoom", "isGameRoom", "targetId", "isGuestAnchor", "isKoiRoom", "isLifeLocal", "isMatchRoom", "isMediaRoom", "isMergeFirstShow", "isMergeVSRoom", "isPaidRoom", "isPaidSubscribeRoom", "isPrivatePlay", "isPullUrlValid", "isReplay", "isSofaRoom", "isStar", "isSupportCamera", "isTemplateEnable", "isUnionLiveInfoNotNull", "isUnionLiveRoom", "isVideoCameraVersion", "isVipRoom", "isVirtualLive", "isVrRoom", "isVsLive", "isVsRoom", "label", "setAnchorTabLabel", "owner", "setBaseOwner", "logId", "setEnterLogId", "id", "setId", "time", "setInitTime", "(Ljava/lang/Long;)V", "enable", "setIsFromRecommendCard", "result", "setLinkInitResult", "reason", "setLiveReason", "liveRoomStampInfos", "setLiveRoomStampsInfo", "logPb", "setLog_pb", "setOwner", "setPullType", "requestId", "setRequestId", "roomStreamDataObject", "setRoomStreamDataObject", "setSourceType", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomPlatformComponentsData;", "getRoomPlatformComponentsData", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomPlatformComponentsData;", "roomPlatformComponentsData", "getRoomGameData", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomGameData;", "roomGameData", "Lcom/bytedance/android/livesdkapi/depend/model/live/ClientComponent;", "getClientComponentData", "()Lcom/bytedance/android/livesdkapi/depend/model/live/ClientComponent;", "clientComponentData", "getAcquaintanceStatus", "()J", "setAcquaintanceStatus", "(J)V", "acquaintanceStatus", "Lcom/bytedance/android/livesdkapi/depend/model/live/IAnchorData;", "getAnchorData", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IAnchorData;", "anchorData", "getAnchorTabType", "()I", "setAnchorTabType", "(I)V", "anchorTabType", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILabelInfo;", "getAssistLabel", "()Lcom/bytedance/android/livesdkapi/depend/model/live/ILabelInfo;", "assistLabel", "getAutoCover", "setAutoCover", "autoCover", "Lpy/k;", "getBackground", "()Lpy/k;", "setBackground", "(Lpy/k;)V", "background", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomBasisData;", "getBasisRoomData", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomBasisData;", "setBasisRoomData", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomBasisData;)V", "basisRoomData", "getBusinessLive", "setBusinessLive", "businessLive", "Lcom/bytedance/android/livesdkapi/depend/model/live/circleinfo/ICircleInfo;", "getCircleInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/circleinfo/ICircleInfo;", "setCircleInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/circleinfo/ICircleInfo;)V", "circleInfo", "getContentLabel", "setContentLabel", "contentLabel", "getContentTag", "()Ljava/lang/String;", "setContentTag", "(Ljava/lang/String;)V", "contentTag", "getCover", "setCover", "cover", "getCreateTime", "setCreateTime", "createTime", "getDiggCount", "setDiggCount", "diggCount", "getDistanceCity", "setDistanceCity", "distanceCity", "getDistanceKm", "setDistanceKm", "distanceKm", "getDynamicLabel", "dynamicLabel", "getEpisodeExtra", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeExtraInfo;", "episodeExtra", "Lcom/bytedance/android/livesdkapi/depend/model/live/IPreviewExposeData;", "getExposeData", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IPreviewExposeData;", "exposeData", "getFinishTime", "setFinishTime", "finishTime", "Lcom/bytedance/android/livesdkapi/depend/model/live/IGameCPData;", "getGameCPData", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IGameCPData;", "setGameCPData", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IGameCPData;)V", "gameCPData", "getHasGamePromote", "setHasGamePromote", "hasGamePromote", "getIdStr", "setIdStr", "idStr", "getIntroduction", "setIntroduction", "introduction", "isHasCommerceGoods", "()Z", "setHasCommerceGoods", "(Z)V", "isLiveTypeAudio", "isOfficialChannelRoom", "setOfficialChannelRoom", "isOfficialType", "setOfficialType", "isScreenshot", "isThirdParty", "getItemExplicitInfo", "setItemExplicitInfo", "itemExplicitInfo", "getLabels", "setLabels", "labels", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getLayout", "layout", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getLinkMap", "()Ljava/util/Map;", "linkMap", "getLinkMicLayout", "setLinkMicLayout", "linkMicLayout", "Lcom/bytedance/android/livesdk/link/model/z5;", "getLinkerDetail", "()Lcom/bytedance/android/livesdk/link/model/z5;", "setLinkerDetail", "(Lcom/bytedance/android/livesdk/link/model/z5;)V", "linkerDetail", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILinkerUsers;", "getLinkerUsers", "()Lcom/bytedance/android/livesdkapi/depend/model/live/ILinkerUsers;", "linkerUsers", "getLinkmicDisplayType", "setLinkmicDisplayType", "linkmicDisplayType", "getLiveHashTagJson", "setLiveHashTagJson", "liveHashTagJson", "getLivePlatformSource", "setLivePlatformSource", "livePlatformSource", "getLiveRoomMode", "liveRoomMode", "getLiveRoomStampsJson", "setLiveRoomStampsJson", "liveRoomStampsJson", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveStatusInfo;", "getLiveStatusInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveStatusInfo;", "setLiveStatusInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveStatusInfo;)V", "liveStatusInfo", "getLiveTypeSandbox", "setLiveTypeSandbox", "liveTypeSandbox", "getLiveTypeVsLive", "setLiveTypeVsLive", "liveTypeVsLive", "getLiveTypeVsPremiere", "setLiveTypeVsPremiere", "liveTypeVsPremiere", "getMRoomAuthStatus", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAuthStatus;", "mRoomAuthStatus", "getOperationLabel", "setOperationLabel", "operationLabel", "Lcom/bytedance/android/live/base/model/user/IBaseUserKt;", "getOwnerKt", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setOwnerKt", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "ownerKt", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IPaidLiveData;", "getPaidLiveData", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IPaidLiveData;", "paidLiveData", "getPlatform", "platform", "getPreEnterTime", "setPreEnterTime", "preEnterTime", "getPrivateInfo", "setPrivateInfo", "privateInfo", "getRedEnvelopeNumber", "setRedEnvelopeNumber", "redEnvelopeNumber", "getReplay", "setReplay", "replay", "Lcom/bytedance/android/livesdkapi/depend/model/live/IReplayInfo;", "getReplayInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IReplayInfo;", "setReplayInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IReplayInfo;)V", "replayInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomCart;", "getRoomCart", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomCart;", "setRoomCart", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomCart;)V", "roomCart", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomIMInfo;", "getRoomIMInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomIMInfo;", "setRoomIMInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomIMInfo;)V", "roomIMInfo", "getRoomLayout", "roomLayout", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomSpecificSceneTypeInfo;", "getSceneTypeInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomSpecificSceneTypeInfo;", "sceneTypeInfo", "getShareUrl", "setShareUrl", "shareUrl", "getShortTitle", "setShortTitle", "shortTitle", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomStats;", "getStats", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomStats;", "setStats", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomStats;)V", "stats", "getStatus", "setStatus", "status", "getStreamCloseTime", "setStreamCloseTime", "streamCloseTime", "getStreamId", "setStreamId", "streamId", "Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrl;", "getStreamUrl", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrl;", "streamUrl", "getTitle", "setTitle", "title", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveToolbarData;", "getToolbarData", "()Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveToolbarData;", "toolbarData", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveNearbyTVInfo;", "getTvInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveNearbyTVInfo;", "setTvInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveNearbyTVInfo;)V", "tvInfo", "getUserCount", "setUserCount", "userCount", "getVid", "setVid", "vid", "getVideoFeedTag", "setVideoFeedTag", "videoFeedTag", "getVisibilityRange", "setVisibilityRange", "visibilityRange", "Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;", "getVoiceLiveTheme", "()Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;", "setVoiceLiveTheme", "(Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;)V", "voiceLiveTheme", "getWithLinkMic", "setWithLinkMic", "withLinkMic", "base", "<init>", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public class ICommunityMainRoomExtensionImpl extends ModelExtensionBase<IRoom, ICommunityMainRoom> implements ICommunityMainRoom, IRoom {
    private final /* synthetic */ IRoom $$delegate_0;

    public void addGameStickerType(int r2) {
        this.$$delegate_0.addGameStickerType(r2);
    }

    public boolean allowGift() {
        return this.$$delegate_0.allowGift();
    }

    public IBaseUser authorFlex() {
        return this.$$delegate_0.authorFlex();
    }

    public String buildPullUrl() {
        return this.$$delegate_0.buildPullUrl();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.ICommunityMainRoom
    public <R extends vh7.e<IRoom>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.ICommunityMainRoom
    public <R extends vh7.e<IRoom>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    public long getAcquaintanceStatus() {
        return this.$$delegate_0.getAcquaintanceStatus();
    }

    public ActivityRoomSkinInfo getActivityRoomSkinInfo() {
        return this.$$delegate_0.getActivityRoomSkinInfo();
    }

    public com.bytedance.android.livesdk.strategy.a getAdStrategyFeatures() {
        return this.$$delegate_0.getAdStrategyFeatures();
    }

    public Map<String, String> getAnchorABMap() {
        return this.$$delegate_0.getAnchorABMap();
    }

    public Map<String, String> getAnchorAbMapFlex() {
        return this.$$delegate_0.getAnchorAbMapFlex();
    }

    public String getAnchorAbValue(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.$$delegate_0.getAnchorAbValue(r2);
    }

    public IAnchorData getAnchorData() {
        return this.$$delegate_0.getAnchorData();
    }

    public String getAnchorId() {
        return this.$$delegate_0.getAnchorId();
    }

    public AnchorTabLabel getAnchorTabLabel() {
        return this.$$delegate_0.getAnchorTabLabel();
    }

    public int getAnchorTabType() {
        return this.$$delegate_0.getAnchorTabType();
    }

    public IRoomAppearance getAppearanceFlex() {
        return this.$$delegate_0.getAppearanceFlex();
    }

    public ILabelInfo getAssistLabel() {
        return this.$$delegate_0.getAssistLabel();
    }

    public String getAudienceType() {
        return this.$$delegate_0.getAudienceType();
    }

    public long getAutoCover() {
        return this.$$delegate_0.getAutoCover();
    }

    public k getBackground() {
        return this.$$delegate_0.getBackground();
    }

    public IBaseUser getBaseOwner() {
        return this.$$delegate_0.getBaseOwner();
    }

    public IRoomBasisData getBasisRoomData() {
        return this.$$delegate_0.getBasisRoomData();
    }

    public int getBusinessLive() {
        return this.$$delegate_0.getBusinessLive();
    }

    public ICircleInfo getCircleInfo() {
        return this.$$delegate_0.getCircleInfo();
    }

    public String getClientVersion() {
        return this.$$delegate_0.getClientVersion();
    }

    public CommentaryRoomInfo getCommentaryRoomInfo() {
        return this.$$delegate_0.getCommentaryRoomInfo();
    }

    public int getCompoundSceneType() {
        return this.$$delegate_0.getCompoundSceneType();
    }

    public String getCompoundStreamData() {
        return this.$$delegate_0.getCompoundStreamData();
    }

    public k getContentLabel() {
        return this.$$delegate_0.getContentLabel();
    }

    public String getContentTag() {
        return this.$$delegate_0.getContentTag();
    }

    public k getCover() {
        return this.$$delegate_0.getCover();
    }

    public String getCoverUrl() {
        return this.$$delegate_0.getCoverUrl();
    }

    public long getCreateTime() {
        return this.$$delegate_0.getCreateTime();
    }

    public String getDefaultQualityStrategy() {
        return this.$$delegate_0.getDefaultQualityStrategy();
    }

    public DesireInfo getDesireInfo() {
        return this.$$delegate_0.getDesireInfo();
    }

    public long getDiggCount() {
        return this.$$delegate_0.getDiggCount();
    }

    public String getDistanceCity() {
        return this.$$delegate_0.getDistanceCity();
    }

    public String getDistanceKm() {
        return this.$$delegate_0.getDistanceKm();
    }

    public String getDygamePromoteInstanceId() {
        return this.$$delegate_0.getDygamePromoteInstanceId();
    }

    public ILabelInfo getDynamicLabel() {
        return this.$$delegate_0.getDynamicLabel();
    }

    public IEcomData getEcomData() {
        return this.$$delegate_0.getEcomData();
    }

    public String getEnterLogId() {
        return this.$$delegate_0.getEnterLogId();
    }

    public IEpisodeExtraInfo getEpisodeComponentData() {
        return this.$$delegate_0.getEpisodeComponentData();
    }

    public IEpisodeExtraInfo getEpisodeExtra() {
        return this.$$delegate_0.getEpisodeExtra();
    }

    public IPreviewExposeData getExposeData() {
        return this.$$delegate_0.getExposeData();
    }

    public IExtension getExtension() {
        return this.$$delegate_0.getExtension();
    }

    public IExtension getExtensionFlex() {
        return this.$$delegate_0.getExtensionFlex();
    }

    public RoomExtra getExtra() {
        return this.$$delegate_0.getExtra();
    }

    public int getFansMessageStyle() {
        return this.$$delegate_0.getFansMessageStyle();
    }

    public long getFinishTime() {
        return this.$$delegate_0.getFinishTime();
    }

    public int getFollowMessageStyle() {
        return this.$$delegate_0.getFollowMessageStyle();
    }

    public IGameCPData getGameCPData() {
        return this.$$delegate_0.getGameCPData();
    }

    public IRoomGameData getGameData() {
        return this.$$delegate_0.getGameData();
    }

    public Set<Integer> getGameStickerTypes() {
        return this.$$delegate_0.getGameStickerTypes();
    }

    public long getGameTagId() {
        return this.$$delegate_0.getGameTagId();
    }

    public int getGiftMessageStyle() {
        return this.$$delegate_0.getGiftMessageStyle();
    }

    public long getHasGamePromote() {
        return this.$$delegate_0.getHasGamePromote();
    }

    public long getId() {
        return this.$$delegate_0.getId();
    }

    public String getIdStr() {
        return this.$$delegate_0.getIdStr();
    }

    public Long getInitTime() {
        return this.$$delegate_0.getInitTime();
    }

    public String getIntroduction() {
        return this.$$delegate_0.getIntroduction();
    }

    public String getItemExplicitInfo() {
        return this.$$delegate_0.getItemExplicitInfo();
    }

    public String getLabels() {
        return this.$$delegate_0.getLabels();
    }

    public long getLandscapeCommentStyle() {
        return this.$$delegate_0.getLandscapeCommentStyle();
    }

    public long getLayout() {
        return this.$$delegate_0.getLayout();
    }

    public String getLifeShareId() {
        return this.$$delegate_0.getLifeShareId();
    }

    public j0 getLinkInitResult() {
        return this.$$delegate_0.getLinkInitResult();
    }

    public Map<String, Long> getLinkMap() {
        return this.$$delegate_0.getLinkMap();
    }

    public long getLinkMicLayout() {
        return this.$$delegate_0.getLinkMicLayout();
    }

    public int getLinkMicScene() {
        return this.$$delegate_0.getLinkMicScene();
    }

    public z5 getLinkerDetail() {
        return this.$$delegate_0.getLinkerDetail();
    }

    public ILinkerUsers getLinkerUsers() {
        return this.$$delegate_0.getLinkerUsers();
    }

    public long getLinkmicDisplayType() {
        return this.$$delegate_0.getLinkmicDisplayType();
    }

    public ILiveHashTagInfo getLiveHashTagInfo() {
        return this.$$delegate_0.getLiveHashTagInfo();
    }

    public String getLiveHashTagJson() {
        return this.$$delegate_0.getLiveHashTagJson();
    }

    public String getLivePlatformSource() {
        return this.$$delegate_0.getLivePlatformSource();
    }

    public String getLiveReason() {
        return this.$$delegate_0.getLiveReason();
    }

    public long getLiveRoomMode() {
        return this.$$delegate_0.getLiveRoomMode();
    }

    public long getLiveRoomModeKmp() {
        return this.$$delegate_0.getLiveRoomModeKmp();
    }

    public String getLiveRoomStampsJson() {
        return this.$$delegate_0.getLiveRoomStampsJson();
    }

    public ILiveStatusInfo getLiveStatusInfo() {
        return this.$$delegate_0.getLiveStatusInfo();
    }

    public boolean getLiveTypeSandbox() {
        return this.$$delegate_0.getLiveTypeSandbox();
    }

    public boolean getLiveTypeVsLive() {
        return this.$$delegate_0.getLiveTypeVsLive();
    }

    public boolean getLiveTypeVsPremiere() {
        return this.$$delegate_0.getLiveTypeVsPremiere();
    }

    public String getLog_pb() {
        return this.$$delegate_0.getLog_pb();
    }

    public IRoomAuthStatus getMRoomAuthStatus() {
        return this.$$delegate_0.getMRoomAuthStatus();
    }

    public int getMosaicStatusFlex() {
        return this.$$delegate_0.getMosaicStatusFlex();
    }

    public String getMultiStreamData() {
        return this.$$delegate_0.getMultiStreamData();
    }

    public String getMultiStreamDataFromPool() {
        return this.$$delegate_0.getMultiStreamDataFromPool();
    }

    public String getMultiStreamDefaultQualitySdkKey() {
        return this.$$delegate_0.getMultiStreamDefaultQualitySdkKey();
    }

    public OfficialChannelExtraInfo getOfficialChannelExtraInfo() {
        return this.$$delegate_0.getOfficialChannelExtraInfo();
    }

    public IOfficialChannelInfo getOfficialChannelInfo() {
        return this.$$delegate_0.getOfficialChannelInfo();
    }

    public String getOfficialChannelUidString() {
        return this.$$delegate_0.getOfficialChannelUidString();
    }

    public k getOperationLabel() {
        return this.$$delegate_0.getOperationLabel();
    }

    public IBaseUser getOwner() {
        return this.$$delegate_0.getOwner();
    }

    public IBaseUser getOwnerKt() {
        return this.$$delegate_0.getOwnerKt();
    }

    public String getOwnerUserIdString() {
        return this.$$delegate_0.getOwnerUserIdString();
    }

    public IPSSelectedMessageInfo getPSSelectedMessageInfo() {
        return this.$$delegate_0.getPSSelectedMessageInfo();
    }

    public IPaidLiveData getPaidLiveData() {
        return this.$$delegate_0.getPaidLiveData();
    }

    public long getPlatform() {
        return this.$$delegate_0.getPlatform();
    }

    public long getPreEnterTime() {
        return this.$$delegate_0.getPreEnterTime();
    }

    public String getPrivateInfo() {
        return this.$$delegate_0.getPrivateInfo();
    }

    public IPublicScreenSpeedConfig getPublicScreenSpeedConfig() {
        return this.$$delegate_0.getPublicScreenSpeedConfig();
    }

    public int getPullType() {
        return this.$$delegate_0.getPullType();
    }

    public long getRedEnvelopeNumber() {
        return this.$$delegate_0.getRedEnvelopeNumber();
    }

    public IRelevantRecommendation getRelevantRecommendationFlex() {
        return this.$$delegate_0.getRelevantRecommendationFlex();
    }

    public boolean getReplay() {
        return this.$$delegate_0.getReplay();
    }

    public IReplayInfo getReplayInfo() {
        return this.$$delegate_0.getReplayInfo();
    }

    public String getRequestId() {
        return this.$$delegate_0.getRequestId();
    }

    public IRoomAuthStatus getRoomAuthStatus() {
        return this.$$delegate_0.getRoomAuthStatus();
    }

    public IRoomCart getRoomCart() {
        return this.$$delegate_0.getRoomCart();
    }

    public IRoomIMInfo getRoomIMInfo() {
        return this.$$delegate_0.getRoomIMInfo();
    }

    public long getRoomId() {
        return this.$$delegate_0.getRoomId();
    }

    public RoomInteractData getRoomInteractData() {
        return this.$$delegate_0.getRoomInteractData();
    }

    public r getRoomIntroLabel() {
        return this.$$delegate_0.getRoomIntroLabel();
    }

    public long getRoomLayout() {
        return this.$$delegate_0.getRoomLayout();
    }

    public long getRoomLayoutKmp() {
        return this.$$delegate_0.getRoomLayoutKmp();
    }

    public IRoomOthersData getRoomOthers() {
        return this.$$delegate_0.getRoomOthers();
    }

    public String getRoomRevenueOpenGameAppId() {
        return this.$$delegate_0.getRoomRevenueOpenGameAppId();
    }

    public List<RoomStampInfo> getRoomStamps() {
        return this.$$delegate_0.getRoomStamps();
    }

    public RoomStreamDataObject getRoomStreamDataObject() {
        return this.$$delegate_0.getRoomStreamDataObject();
    }

    public IRoomSpecificSceneTypeInfo getSceneTypeInfo() {
        return this.$$delegate_0.getSceneTypeInfo();
    }

    public int getShareMessageStyle() {
        return this.$$delegate_0.getShareMessageStyle();
    }

    public String getShareUrl() {
        return this.$$delegate_0.getShareUrl();
    }

    public ShortTermIndicatorConfig getShortTermIndicatorConfig() {
        return this.$$delegate_0.getShortTermIndicatorConfig();
    }

    public String getShortTitle() {
        return this.$$delegate_0.getShortTitle();
    }

    public String getSourceType() {
        return this.$$delegate_0.getSourceType();
    }

    public long getStartTimeFlex() {
        return this.$$delegate_0.getStartTimeFlex();
    }

    public IRoomStats getStats() {
        return this.$$delegate_0.getStats();
    }

    public long getStatus() {
        return this.$$delegate_0.getStatus();
    }

    public List<String> getStrategyFeatWhitelist() {
        return this.$$delegate_0.getStrategyFeatWhitelist();
    }

    public long getStreamCloseTime() {
        return this.$$delegate_0.getStreamCloseTime();
    }

    public long getStreamId() {
        return this.$$delegate_0.getStreamId();
    }

    public LiveMode getStreamType() {
        return this.$$delegate_0.getStreamType();
    }

    public IBaseStreamUrl getStreamUrl() {
        return this.$$delegate_0.getStreamUrl();
    }

    public IStreamUrlExtra getStreamUrlExtra() {
        return this.$$delegate_0.getStreamUrlExtra();
    }

    public IStreamUrlExtra getStreamUrlExtraSafely() {
        return this.$$delegate_0.getStreamUrlExtraSafely();
    }

    public IStreamUrlExtra getStreamUrlExtraSafelyFlex() {
        return this.$$delegate_0.getStreamUrlExtraSafelyFlex();
    }

    public String getTitle() {
        return this.$$delegate_0.getTitle();
    }

    public ILiveToolbarData getToolbarData() {
        return this.$$delegate_0.getToolbarData();
    }

    public ILiveNearbyTVInfo getTvInfo() {
        return this.$$delegate_0.getTvInfo();
    }

    public long getUserCount() {
        return this.$$delegate_0.getUserCount();
    }

    public int getVRType() {
        return this.$$delegate_0.getVRType();
    }

    public String getVid() {
        return this.$$delegate_0.getVid();
    }

    public String getVideoFeedTag() {
        return this.$$delegate_0.getVideoFeedTag();
    }

    public int getVisibilityRange() {
        return this.$$delegate_0.getVisibilityRange();
    }

    public IVoiceLiveTheme getVoiceLiveTheme() {
        return this.$$delegate_0.getVoiceLiveTheme();
    }

    public boolean getWithLinkMic() {
        return this.$$delegate_0.getWithLinkMic();
    }

    public boolean hasValidImInfo() {
        return this.$$delegate_0.hasValidImInfo();
    }

    public void init() {
        this.$$delegate_0.init();
    }

    public boolean isCompoundScene() {
        return this.$$delegate_0.isCompoundScene();
    }

    public boolean isD3Room() {
        return this.$$delegate_0.isD3Room();
    }

    public String isEcomCart() {
        return this.$$delegate_0.isEcomCart();
    }

    public boolean isEcomNew() {
        return this.$$delegate_0.isEcomNew();
    }

    public boolean isEnableChat(boolean r2) {
        return this.$$delegate_0.isEnableChat(r2);
    }

    public boolean isFromRecommendCard() {
        return this.$$delegate_0.isFromRecommendCard();
    }

    public boolean isGameCPRoom() {
        return this.$$delegate_0.isGameCPRoom();
    }

    public int isGameRoom() {
        return this.$$delegate_0.isGameRoom();
    }

    public boolean isGuestAnchor(String r2) {
        Intrinsics.checkNotNullParameter(r2, "targetId");
        return this.$$delegate_0.isGuestAnchor(r2);
    }

    public boolean isHasCommerceGoods() {
        return this.$$delegate_0.isHasCommerceGoods();
    }

    public boolean isKoiRoom() {
        return this.$$delegate_0.isKoiRoom();
    }

    public boolean isLifeLocal() {
        return this.$$delegate_0.isLifeLocal();
    }

    public boolean isLiveTypeAudio() {
        return this.$$delegate_0.isLiveTypeAudio();
    }

    public boolean isMatchRoom() {
        return this.$$delegate_0.isMatchRoom();
    }

    public boolean isMediaRoom() {
        return this.$$delegate_0.isMediaRoom();
    }

    public boolean isMergeFirstShow() {
        return this.$$delegate_0.isMergeFirstShow();
    }

    public boolean isMergeVSRoom() {
        return this.$$delegate_0.isMergeVSRoom();
    }

    public boolean isOfficialChannelRoom() {
        return this.$$delegate_0.isOfficialChannelRoom();
    }

    public boolean isOfficialType() {
        return this.$$delegate_0.isOfficialType();
    }

    public boolean isPaidRoom() {
        return this.$$delegate_0.isPaidRoom();
    }

    public boolean isPaidSubscribeRoom() {
        return this.$$delegate_0.isPaidSubscribeRoom();
    }

    public boolean isPrivatePlay() {
        return this.$$delegate_0.isPrivatePlay();
    }

    public boolean isPullUrlValid() {
        return this.$$delegate_0.isPullUrlValid();
    }

    public boolean isReplay() {
        return this.$$delegate_0.isReplay();
    }

    public boolean isScreenshot() {
        return this.$$delegate_0.isScreenshot();
    }

    public boolean isSofaRoom() {
        return this.$$delegate_0.isSofaRoom();
    }

    public boolean isStar() {
        return this.$$delegate_0.isStar();
    }

    public boolean isSupportCamera() {
        return this.$$delegate_0.isSupportCamera();
    }

    public boolean isTemplateEnable() {
        return this.$$delegate_0.isTemplateEnable();
    }

    public boolean isThirdParty() {
        return this.$$delegate_0.isThirdParty();
    }

    public boolean isUnionLiveInfoNotNull() {
        return this.$$delegate_0.isUnionLiveInfoNotNull();
    }

    public boolean isUnionLiveRoom() {
        return this.$$delegate_0.isUnionLiveRoom();
    }

    public boolean isVideoCameraVersion() {
        return this.$$delegate_0.isVideoCameraVersion();
    }

    public boolean isVipRoom() {
        return this.$$delegate_0.isVipRoom();
    }

    public boolean isVirtualLive() {
        return this.$$delegate_0.isVirtualLive();
    }

    public boolean isVrRoom() {
        return this.$$delegate_0.isVrRoom();
    }

    public boolean isVsLive() {
        return this.$$delegate_0.isVsLive();
    }

    public boolean isVsRoom() {
        return this.$$delegate_0.isVsRoom();
    }

    public void setAcquaintanceStatus(long r2) {
        this.$$delegate_0.setAcquaintanceStatus(r2);
    }

    public void setAnchorTabLabel(AnchorTabLabel r2) {
        this.$$delegate_0.setAnchorTabLabel(r2);
    }

    public void setAnchorTabType(int r2) {
        this.$$delegate_0.setAnchorTabType(r2);
    }

    public void setAutoCover(long r2) {
        this.$$delegate_0.setAutoCover(r2);
    }

    public void setBackground(k r2) {
        this.$$delegate_0.setBackground(r2);
    }

    public void setBaseOwner(IBaseUser r2) {
        this.$$delegate_0.setBaseOwner(r2);
    }

    public void setBasisRoomData(IRoomBasisData r2) {
        this.$$delegate_0.setBasisRoomData(r2);
    }

    public void setBusinessLive(int r2) {
        this.$$delegate_0.setBusinessLive(r2);
    }

    public void setCircleInfo(ICircleInfo r2) {
        this.$$delegate_0.setCircleInfo(r2);
    }

    public void setContentLabel(k r2) {
        this.$$delegate_0.setContentLabel(r2);
    }

    public void setContentTag(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.$$delegate_0.setContentTag(r2);
    }

    public void setCover(k r2) {
        this.$$delegate_0.setCover(r2);
    }

    public void setCreateTime(long r2) {
        this.$$delegate_0.setCreateTime(r2);
    }

    public void setDiggCount(long r2) {
        this.$$delegate_0.setDiggCount(r2);
    }

    public void setDistanceCity(String r2) {
        this.$$delegate_0.setDistanceCity(r2);
    }

    public void setDistanceKm(String r2) {
        this.$$delegate_0.setDistanceKm(r2);
    }

    public void setEnterLogId(String r2) {
        this.$$delegate_0.setEnterLogId(r2);
    }

    public void setFinishTime(long r2) {
        this.$$delegate_0.setFinishTime(r2);
    }

    public void setGameCPData(IGameCPData r2) {
        this.$$delegate_0.setGameCPData(r2);
    }

    public void setHasCommerceGoods(boolean r2) {
        this.$$delegate_0.setHasCommerceGoods(r2);
    }

    public void setHasGamePromote(long r2) {
        this.$$delegate_0.setHasGamePromote(r2);
    }

    public void setId(long r2) {
        this.$$delegate_0.setId(r2);
    }

    public void setIdStr(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.$$delegate_0.setIdStr(r2);
    }

    public void setInitTime(Long r2) {
        this.$$delegate_0.setInitTime(r2);
    }

    public void setIntroduction(String r2) {
        this.$$delegate_0.setIntroduction(r2);
    }

    public void setIsFromRecommendCard(boolean r2) {
        this.$$delegate_0.setIsFromRecommendCard(r2);
    }

    public void setItemExplicitInfo(String r2) {
        this.$$delegate_0.setItemExplicitInfo(r2);
    }

    public void setLabels(String r2) {
        this.$$delegate_0.setLabels(r2);
    }

    public void setLinkInitResult(j0 r2) {
        this.$$delegate_0.setLinkInitResult(r2);
    }

    public void setLinkMicLayout(long r2) {
        this.$$delegate_0.setLinkMicLayout(r2);
    }

    public void setLinkerDetail(z5 r2) {
        this.$$delegate_0.setLinkerDetail(r2);
    }

    public void setLinkmicDisplayType(long r2) {
        this.$$delegate_0.setLinkmicDisplayType(r2);
    }

    public void setLiveHashTagJson(String r2) {
        this.$$delegate_0.setLiveHashTagJson(r2);
    }

    public void setLivePlatformSource(String r2) {
        this.$$delegate_0.setLivePlatformSource(r2);
    }

    public void setLiveReason(String r2) {
        this.$$delegate_0.setLiveReason(r2);
    }

    public void setLiveRoomStampsInfo(List<RoomStampInfo> r2) {
        this.$$delegate_0.setLiveRoomStampsInfo(r2);
    }

    public void setLiveRoomStampsJson(String r2) {
        this.$$delegate_0.setLiveRoomStampsJson(r2);
    }

    public void setLiveStatusInfo(ILiveStatusInfo r2) {
        this.$$delegate_0.setLiveStatusInfo(r2);
    }

    public void setLiveTypeSandbox(boolean r2) {
        this.$$delegate_0.setLiveTypeSandbox(r2);
    }

    public void setLiveTypeVsLive(boolean r2) {
        this.$$delegate_0.setLiveTypeVsLive(r2);
    }

    public void setLiveTypeVsPremiere(boolean r2) {
        this.$$delegate_0.setLiveTypeVsPremiere(r2);
    }

    public void setLog_pb(String r2) {
        this.$$delegate_0.setLog_pb(r2);
    }

    public void setOfficialChannelRoom(boolean r2) {
        this.$$delegate_0.setOfficialChannelRoom(r2);
    }

    public void setOfficialType(boolean r2) {
        this.$$delegate_0.setOfficialType(r2);
    }

    public void setOperationLabel(k r2) {
        this.$$delegate_0.setOperationLabel(r2);
    }

    public void setOwner(IBaseUser r2) {
        this.$$delegate_0.setOwner(r2);
    }

    public void setOwnerKt(IBaseUser r2) {
        this.$$delegate_0.setOwnerKt(r2);
    }

    public void setPreEnterTime(long r2) {
        this.$$delegate_0.setPreEnterTime(r2);
    }

    public void setPrivateInfo(String r2) {
        this.$$delegate_0.setPrivateInfo(r2);
    }

    public void setPullType(int r2) {
        this.$$delegate_0.setPullType(r2);
    }

    public void setRedEnvelopeNumber(long r2) {
        this.$$delegate_0.setRedEnvelopeNumber(r2);
    }

    public void setReplay(boolean r2) {
        this.$$delegate_0.setReplay(r2);
    }

    public void setReplayInfo(IReplayInfo r2) {
        this.$$delegate_0.setReplayInfo(r2);
    }

    public void setRequestId(String r2) {
        this.$$delegate_0.setRequestId(r2);
    }

    public void setRoomCart(IRoomCart r2) {
        this.$$delegate_0.setRoomCart(r2);
    }

    public void setRoomIMInfo(IRoomIMInfo r2) {
        this.$$delegate_0.setRoomIMInfo(r2);
    }

    public void setRoomStreamDataObject(RoomStreamDataObject r2) {
        this.$$delegate_0.setRoomStreamDataObject(r2);
    }

    public void setShareUrl(String r2) {
        this.$$delegate_0.setShareUrl(r2);
    }

    public void setShortTitle(String r2) {
        this.$$delegate_0.setShortTitle(r2);
    }

    public void setSourceType(String r2) {
        this.$$delegate_0.setSourceType(r2);
    }

    public void setStats(IRoomStats r2) {
        this.$$delegate_0.setStats(r2);
    }

    public void setStatus(long r2) {
        this.$$delegate_0.setStatus(r2);
    }

    public void setStreamCloseTime(long r2) {
        this.$$delegate_0.setStreamCloseTime(r2);
    }

    public void setStreamId(long r2) {
        this.$$delegate_0.setStreamId(r2);
    }

    public void setTitle(String r2) {
        this.$$delegate_0.setTitle(r2);
    }

    public void setTvInfo(ILiveNearbyTVInfo r2) {
        this.$$delegate_0.setTvInfo(r2);
    }

    public void setUserCount(long r2) {
        this.$$delegate_0.setUserCount(r2);
    }

    public void setVid(String r2) {
        this.$$delegate_0.setVid(r2);
    }

    public void setVideoFeedTag(String r2) {
        this.$$delegate_0.setVideoFeedTag(r2);
    }

    public void setVisibilityRange(int r2) {
        this.$$delegate_0.setVisibilityRange(r2);
    }

    public void setVoiceLiveTheme(IVoiceLiveTheme r2) {
        this.$$delegate_0.setVoiceLiveTheme(r2);
    }

    public void setWithLinkMic(boolean r2) {
        this.$$delegate_0.setWithLinkMic(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.ICommunityMainRoom
    public ClientComponent getClientComponentData() {
        return (ClientComponent) get(310, ICommunityMainRoom.class);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.ICommunityMainRoom
    public IRoomGameData getRoomGameData() {
        return (IRoomGameData) get(307, ICommunityMainRoom.class);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.ICommunityMainRoom
    public IRoomPlatformComponentsData getRoomPlatformComponentsData() {
        return (IRoomPlatformComponentsData) get(311, ICommunityMainRoom.class);
    }

    /* JADX INFO: renamed from: getEpisodeExtra, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ IEpisodeExtraInfoBase m912getEpisodeExtra() {
        return getEpisodeExtra();
    }

    public ICommunityMainRoomExtensionImpl(IRoom r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }
}
