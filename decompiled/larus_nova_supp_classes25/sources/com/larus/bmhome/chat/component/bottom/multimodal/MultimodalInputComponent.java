package com.larus.bmhome.chat.component.bottom.multimodal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.collection.LruCache;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.asr.e2;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.attachment.entity.AttachmentPanelType;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.picture.LocalTakePictureImpl;
import com.larus.bmhome.chat.picture.LocalTakePictureImpl$registerResultForMultiFile$1;
import com.larus.bmhome.clarification.ClarificationComponent;
import com.larus.bmhome.instruction.core.model.ActionBarInstructionKey;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.bmhome.utils.y2;
import com.larus.home.impl.sdk.o2;
import com.larus.im.bean.bot.BotConfItem;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.AlbumHelper;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.FlowDriveFileType;
import com.larus.platform.model.action.DirectSendData;
import com.larus.platform.model.album.AlbumInputState;
import com.larus.platform.model.album.AlbumSettingConfig;
import com.larus.platform.model.chat.UploadFilePolicy;
import com.larus.platform.model.preview.InputDraftSnapshot;
import com.larus.platform.model.preview.MediaEntry;
import com.larus.platform.service.FlowDriveSdkService;
import com.larus.platform.service.k2;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.SafeExtKt;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import zb8.e$a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000Ä\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\f*\u0004»\u0001Â\u0001\b\u0016\u0018\u0000 ø\u00012\u00020\u00012\u00020\u0002:\u0004ø\u0001ù\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010u\u001a\u00020vH\u0016J\b\u0010w\u001a\u00020vH\u0016J\b\u0010x\u001a\u00020vH\u0016J\b\u0010y\u001a\u00020vH\u0002J\n\u0010z\u001a\u0004\u0018\u00010{H\u0016J\b\u0010|\u001a\u00020vH\u0016J\b\u0010}\u001a\u00020vH\u0016J\u0010\u0010~\u001a\u00020v2\u0006\u0010\u007f\u001a\u000209H\u0016J\t\u0010\u0080\u0001\u001a\u000209H\u0016J\t\u0010\u0081\u0001\u001a\u000209H\u0002J\u0013\u0010\u0082\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u0084\u0001\u001a\u00020dH\u0016J-\u0010\u0085\u0001\u001a\u0002092\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010d2\n\b\u0002\u0010\u0086\u0001\u001a\u00030\u0087\u00012\u000b\b\u0002\u0010\u0088\u0001\u001a\u0004\u0018\u00010dH\u0002J\t\u0010\u0089\u0001\u001a\u000209H\u0002J\u0015\u0010\u008a\u0001\u001a\u0002092\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u0001H\u0016J\u0015\u0010\u008d\u0001\u001a\u0002092\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u0001H\u0016J#\u0010\u008e\u0001\u001a\u0002092\b\u0010\u008f\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u0091\u0001\u001a\u00020dH\u0096@¢\u0006\u0003\u0010\u0092\u0001J\t\u0010\u0093\u0001\u001a\u000209H\u0016J\b\u0010`\u001a\u000209H\u0016J\u0012\u0010\u0094\u0001\u001a\u00020v2\u0007\u0010\u0095\u0001\u001a\u000209H\u0016J\u001a\u0010\u0096\u0001\u001a\u00020v2\t\u0010\u0095\u0001\u001a\u0004\u0018\u000109H\u0016¢\u0006\u0003\u0010\u0097\u0001J\u0012\u0010\u0098\u0001\u001a\u00020v2\u0007\u0010\u0095\u0001\u001a\u000209H\u0016J\u0015\u0010\u0099\u0001\u001a\u0002092\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u0001H\u0002J\u0014\u0010\u009a\u0001\u001a\u00020v2\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010\\H\u0016J\u0012\u0010\u009c\u0001\u001a\u00020v2\u0007\u0010\u009b\u0001\u001a\u00020\\H\u0016J:\u0010\u009d\u0001\u001a\u00020v2\u0007\u0010\u009e\u0001\u001a\u0002092\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010d2\n\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u0087\u00012\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010dH\u0002¢\u0006\u0003\u0010 \u0001J\u0013\u0010¡\u0001\u001a\u00020v2\b\u0010¢\u0001\u001a\u00030\u0083\u0001H\u0002J\u0015\u0010£\u0001\u001a\u0005\u0018\u00010¤\u00012\u0007\u0010¥\u0001\u001a\u000209H\u0002J$\u0010¦\u0001\u001a\u00020v2\u0007\u0010\u009e\u0001\u001a\u0002092\u0007\u0010§\u0001\u001a\u0002092\u0007\u0010¨\u0001\u001a\u000209H\u0002J\t\u0010©\u0001\u001a\u00020vH\u0016J\u0013\u0010ª\u0001\u001a\u00020v2\b\u0010«\u0001\u001a\u00030¬\u0001H\u0016J\u0014\u0010\u00ad\u0001\u001a\u0004\u0018\u00010h2\u0007\u0010®\u0001\u001a\u000209H\u0002J\u0013\u0010¯\u0001\u001a\u00020v2\b\u0010«\u0001\u001a\u00030¬\u0001H\u0002J\u000b\u0010°\u0001\u001a\u0004\u0018\u00010ZH\u0002J\u000b\u0010±\u0001\u001a\u0004\u0018\u00010dH\u0002J\f\u0010²\u0001\u001a\u0005\u0018\u00010\u008c\u0001H\u0002J\t\u0010³\u0001\u001a\u00020QH\u0002J\t\u0010´\u0001\u001a\u00020vH\u0002J\u0018\u0010µ\u0001\u001a\u00020v*\u00030¶\u00012\b\u0010·\u0001\u001a\u00030\u0087\u0001H\u0002J\t\u0010¸\u0001\u001a\u00020vH\u0002J\t\u0010¹\u0001\u001a\u00020vH\u0002J\t\u0010¿\u0001\u001a\u00020vH\u0002J\t\u0010À\u0001\u001a\u00020vH\u0002J\t\u0010Æ\u0001\u001a\u00020vH\u0002J\t\u0010Ç\u0001\u001a\u00020vH\u0002J\t\u0010È\u0001\u001a\u00020vH\u0002J9\u0010É\u0001\u001a\u0002092\u0007\u0010Ê\u0001\u001a\u00020d2\u0007\u0010Ë\u0001\u001a\u0002092\n\u0010Ì\u0001\u001a\u0005\u0018\u00010\u0087\u00012\n\u0010Í\u0001\u001a\u0005\u0018\u00010Î\u0001H\u0016¢\u0006\u0003\u0010Ï\u0001J$\u0010Ð\u0001\u001a\u00030\u0087\u00012\u0007\u0010Ñ\u0001\u001a\u0002092\t\u0010Ò\u0001\u001a\u0004\u0018\u000109H\u0016¢\u0006\u0003\u0010Ó\u0001J#\u0010Ô\u0001\u001a\u00020d2\u0007\u0010Ñ\u0001\u001a\u0002092\t\u0010Ò\u0001\u001a\u0004\u0018\u000109H\u0017¢\u0006\u0003\u0010Õ\u0001J\n\u0010Ö\u0001\u001a\u00030\u0087\u0001H\u0002J\n\u0010×\u0001\u001a\u00030\u0087\u0001H\u0002J\t\u0010Ø\u0001\u001a\u00020vH\u0002J\t\u0010Ù\u0001\u001a\u00020vH\u0002J\t\u0010ß\u0001\u001a\u00020vH\u0002J\t\u0010à\u0001\u001a\u00020vH\u0016J\t\u0010á\u0001\u001a\u00020vH\u0016J\u001d\u0010â\u0001\u001a\u00020v2\u0007\u0010\u0084\u0001\u001a\u00020d2\t\u0010ã\u0001\u001a\u0004\u0018\u00010dH\u0002J\t\u0010ä\u0001\u001a\u00020vH\u0002J\u0014\u0010å\u0001\u001a\u00020v2\t\u0010æ\u0001\u001a\u0004\u0018\u00010dH\u0016J\u000b\u0010ç\u0001\u001a\u0004\u0018\u00010dH\u0016J\u0014\u0010è\u0001\u001a\u00020v2\t\u0010é\u0001\u001a\u0004\u0018\u00010dH\u0016J#\u0010ê\u0001\u001a\u00020v2\u0007\u0010ë\u0001\u001a\u00020Q2\u000f\u0010ì\u0001\u001a\n\u0012\u0005\u0012\u00030î\u00010í\u0001H\u0016J\u0012\u0010ï\u0001\u001a\u00020v2\u0007\u0010ë\u0001\u001a\u00020QH\u0016J\u0012\u0010ð\u0001\u001a\u00020v2\u0007\u0010ñ\u0001\u001a\u000209H\u0016J\t\u0010ò\u0001\u001a\u000209H\u0016J\u0012\u0010ó\u0001\u001a\u00020v2\u0007\u0010ô\u0001\u001a\u000209H\u0016J\t\u0010õ\u0001\u001a\u000209H\u0016J\u0014\u0010ö\u0001\u001a\u00020v2\t\u0010÷\u0001\u001a\u0004\u0018\u00010hH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0015\u001a\u0004\b!\u0010\"R\u001d\u0010$\u001a\u0004\u0018\u00010%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0015\u001a\u0004\b&\u0010'R\u001d\u0010)\u001a\u0004\u0018\u00010*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u0015\u001a\u0004\b+\u0010,R\u001d\u0010.\u001a\u0004\u0018\u00010/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u0015\u001a\u0004\b0\u00101R\u001d\u00103\u001a\u0004\u0018\u0001048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\u0015\u001a\u0004\b5\u00106R\u0014\u00108\u001a\u0002098BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u001d\u0010<\u001a\u0004\u0018\u00010=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\u0015\u001a\u0004\b>\u0010?R\u001d\u0010A\u001a\u0004\u0018\u00010B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\u0015\u001a\u0004\bC\u0010DR\u001d\u0010F\u001a\u0004\u0018\u00010G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010\u0015\u001a\u0004\bH\u0010IR\u001d\u0010K\u001a\u0004\u0018\u00010L8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010\u0015\u001a\u0004\bM\u0010NR\u001b\u0010P\u001a\u00020Q8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bT\u0010\u0015\u001a\u0004\bR\u0010SR\u0014\u0010U\u001a\b\u0012\u0004\u0012\u00020W0VX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010X\u001a\n\u0012\u0004\u0012\u00020Z\u0018\u00010YX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u0004\u0018\u00010\\X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010]\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0004\n\u0002\u0010^R\u000e\u0010_\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010c\u001a\u0004\u0018\u00010dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010g\u001a\u0004\u0018\u00010hX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010i\u001a\u0004\u0018\u00010dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010j\u001a\u0004\u0018\u00010k8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bn\u0010\u0015\u001a\u0004\bl\u0010mR\u001d\u0010o\u001a\u0004\u0018\u00010p8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bs\u0010\u0015\u001a\u0004\bq\u0010rR\u000e\u0010t\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010~\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010º\u0001\u001a\u00030»\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b¾\u0001\u0010\u0015\u001a\u0006\b¼\u0001\u0010½\u0001R \u0010Á\u0001\u001a\u00030Â\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÅ\u0001\u0010\u0015\u001a\u0006\bÃ\u0001\u0010Ä\u0001R\"\u0010Ú\u0001\u001a\u0005\u0018\u00010Û\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÞ\u0001\u0010\u0015\u001a\u0006\bÜ\u0001\u0010Ý\u0001¨\u0006ú\u0001"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/multimodal/MultimodalInputComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "<init>", "()V", "viewModel", "Lcom/larus/bmhome/chat/component/bottom/multimodal/MultimodalInputComponentViewModel;", "getViewModel", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/MultimodalInputComponentViewModel;", "viewModel$delegate", "Lcom/larus/ui/arch/vm/internal/ComponentVMLazy;", "viewModelEx", "Lcom/larus/bmhome/chat/component/bottom/multimodal/MultimodalInputComponentViewModelEx;", "getViewModelEx", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/MultimodalInputComponentViewModelEx;", "viewModelEx$delegate", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "Lkotlin/Lazy;", "bottomMenuAbility", "Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "getBottomMenuAbility", "()Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "attachmentAbility", "Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "getAttachmentAbility", "()Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "attachmentAbility$delegate", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionInputAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionInputAbility$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "chatCameraAbility", "Lcom/larus/bmhome/camera/IChatCameraAbility;", "getChatCameraAbility", "()Lcom/larus/bmhome/camera/IChatCameraAbility;", "chatCameraAbility$delegate", "mobilePreviewHostEnabled", "", "getMobilePreviewHostEnabled", "()Z", "chatListAbility", "Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "getChatListAbility", "()Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "chatListAbility$delegate", "fastSendImageAbility", "Lcom/larus/bmhome/chat/component/fastsend/IFastSendImageAbility;", "getFastSendImageAbility", "()Lcom/larus/bmhome/chat/component/fastsend/IFastSendImageAbility;", "fastSendImageAbility$delegate", "chatClickTalkAbility", "Lcom/obric/assistant/ability/audio/IChatClickTalkAbility;", "getChatClickTalkAbility", "()Lcom/obric/assistant/ability/audio/IChatClickTalkAbility;", "chatClickTalkAbility$delegate", "touchSpeakerAbility", "Lcom/larus/asr/ITouchSpeakerAbility;", "getTouchSpeakerAbility", "()Lcom/larus/asr/ITouchSpeakerAbility;", "touchSpeakerAbility$delegate", "defaultProcessor", "Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalDataProcessor;", "getDefaultProcessor", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalDataProcessor;", "defaultProcessor$delegate", "externalDataProcessors", "", "Lcom/larus/bmhome/chat/component/bottom/multimodal/MultimodalInputComponent$ExternalProcessorEntry;", "onConversationIdOrTypeChanged", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility$ChangeListener;", "Lcom/larus/im/bean/conversation/Conversation;", "inputIntent", "Lcom/larus/bmhome/chat/component/bottom/multimodal/MultimodalInputIntent;", "localVideoUploadEnabled", "Ljava/lang/Boolean;", "localSupportOriginalImage", "enableOriginalImageDeferredEdit", "takePictureHelper", "Lcom/larus/bmhome/chat/picture/LocalTakePictureImpl;", "cameraSuggestionPrefix", "", "forceDisableInjectInputFlag", "keepBottomMenuAfterAttachmentSelection", "uploadProcessConfig", "Lcom/larus/bmhome/uploadmedia/bean/ProcessConfig;", "activeQuickInputSourceNodeId", "chatBottomAbility", "Lcom/larus/bmhome/chat/component/bottom/IChatBottomAbility;", "getChatBottomAbility", "()Lcom/larus/bmhome/chat/component/bottom/IChatBottomAbility;", "chatBottomAbility$delegate", "chatBottomCombineAbility", "Lcom/obric/assistant/ability/chat/bottom/IObricChatBottomAbility;", "getChatBottomCombineAbility", "()Lcom/obric/assistant/ability/chat/bottom/IObricChatBottomAbility;", "chatBottomCombineAbility$delegate", "isViewReadyInitialized", "onAttach", "", "onCreate", "onParentViewCreated", "initOnViewReady", "getMultimodalDowngradeData", "Lcom/larus/bmhome/chat/component/bottom/multimodal/MultimodalDowngradeData;", "onStart", "onResume", "forceCloseInjectInput", "close", "getForceCloseInjectInput", "isForceDisableInjectInput", "getAlbumSettingConfig", "Lcom/larus/platform/model/album/AlbumSettingConfig;", "clickFrom", "enableAlbumInput", "addedAttachmentCount", "", "fastInputEntry", "isLegacyAlbumInputEnabled", "supportVideoUpload", "botModel", "Lcom/larus/im/bean/bot/BotModel;", "supportAlbumVideo", "canProcessAsVideo", "uri", "Landroid/net/Uri;", "fileIdentifier", "(Landroid/net/Uri;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "supportOriginalImage", "setEnableOriginalImageDeferredEdit", "enabled", "setLocalVideoUploadEnabled", "(Ljava/lang/Boolean;)V", "setLocalSupportOriginalImage", "enableUploadVideo", "recordInputIntent", "multimodalInputIntent", "startIntent", "launchAlbum", "multiTake", "landingTabIndex", "(ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "openAlbumWithConfig", "albumConfig", "buildAlbumInputState", "Lcom/larus/platform/model/album/AlbumInputState;", "enableInjectInput", "launchFileBrowser", "supportTakeAudio", "supportAudioOnly", "onDestroy", "processMultimodalData", "data", "Lcom/larus/bmhome/chat/component/bottom/multimodal/MultimodalData;", "resolveImageProcessConfig", "entryEligible", "dispatchToProcessorChain", "getConversation", "getConversationId", "currentBot", "createMultimodalDataProcessor", "registerAlbumResult", "updateSendMessageEventExt", "Lcom/larus/bmhome/chat/component/bottom/multimodal/MultimodalTextMessageData;", "picCnt", "performAfterSendInAlbum", "registerAlbumMultiResult", "driveFileSelectionCallback", "com/larus/bmhome/chat/component/bottom/multimodal/MultimodalInputComponent$driveFileSelectionCallback$2$1", "getDriveFileSelectionCallback", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/MultimodalInputComponent$driveFileSelectionCallback$2$1;", "driveFileSelectionCallback$delegate", "registerDriveFileSelectionCallback", "unregisterDriveFileSelectionCallback", "chatFileSelectionCallback", "com/larus/bmhome/chat/component/bottom/multimodal/MultimodalInputComponent$chatFileSelectionCallback$2$1", "getChatFileSelectionCallback", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/MultimodalInputComponent$chatFileSelectionCallback$2$1;", "chatFileSelectionCallback$delegate", "registerChatFileSelectionCallback", "unregisterChatFileSelectionCallback", "registerMultiFileResult", "skipAttachment", "scene", "allImage", "cameraType", "directSendData", "Lcom/larus/platform/model/action/DirectSendData;", "(Ljava/lang/String;ZLjava/lang/Integer;Lcom/larus/platform/model/action/DirectSendData;)Z", "getSupportMaxEntityCount", "isFromFileBrowser", "isMultiFile", "(ZLjava/lang/Boolean;)I", "getCountOverLimitTips", "(ZLjava/lang/Boolean;)Ljava/lang/String;", "getImageCountOverLimit", "getImageAndVideoOverLimit", "initActivityResultLaunchers", "observerConversationChanged", "chatDraft", "Lcom/larus/bmhome/chat/model/IChatDraft;", "getChatDraft", "()Lcom/larus/bmhome/chat/model/IChatDraft;", "chatDraft$delegate", "autoOpenPlusCamera", "tryDirectOpenPlusCamera", "resetAutoOpenedCamera", "launchCamera", "captureScene", "syncUploadFileRuntimePolicy", "setCameraSuggestionPrefix", "prefix", "getCameraSuggestionPrefix", "setDowngradeEntrance", "entrance", "registerDataProcessor", "processor", "bizSceneFilter", "", "Lcom/larus/bmhome/chat/component/bottom/multimodal/MultimodalBizScene;", "unregisterDataProcessor", "setForceDisableInjectInput", "forceDisable", "getForceDisableInjectInput", "setKeepBottomMenuAfterAttachmentSelection", "keep", "shouldKeepBottomMenuAfterAttachmentSelection", "setUploadProcessConfig", "processConfig", "Companion", "ExternalProcessorEntry", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public class MultimodalInputComponent extends ComponentFeature implements com.larus.bmhome.chat.component.bottom.multimodal.g {
    public static final /* synthetic */ int N = 0;
    public boolean A;
    public final LocalTakePictureImpl B;
    public boolean C;
    public boolean D;
    public ns8.b E;
    public String F;
    public final Lazy G;
    public final Lazy H;
    public boolean I;
    public boolean J;
    public final Lazy K;
    public final Lazy L;
    public final Lazy M;
    public final com.larus.ui.arch.vm.internal.l h;
    public final com.larus.ui.arch.vm.internal.l i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final List<b> v;
    public n0 w;
    public e1 x;
    public Boolean y;
    public boolean z;

    public static final class a {
    }

    public static final class b {
        public final com.larus.bmhome.chat.component.bottom.multimodal.f a;
        public final Set<MultimodalBizScene> b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "ExternalProcessorEntry(processor=" + this.a + ", bizSceneFilter=" + this.b + ')';
        }

        public b(ClarificationComponent.e r2, Set r3) {
            Intrinsics.checkNotNullParameter(r2, "processor");
            Intrinsics.checkNotNullParameter(r3, "bizSceneFilter");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c implements aq9.d {
        public final /* synthetic */ MultimodalInputComponent a;

        public c(MultimodalInputComponent r1) {
            this.a = r1;
        }

        public final void a(String r21, List<com.larus.platform.api.u> r22) {
            Intrinsics.checkNotNullParameter(r22, "selectedList");
            if (Intrinsics.areEqual(r21, "MultimodalInputWrapper") == true) goto L5;
            return;
        L5:
            if (r22.isEmpty() == false) goto L8;
            return;
        L8:
            if (s1a.a.c(this.a).isAdded() == true) goto L11;
            FLogger.a.e("MultimodalInputWrapper", "[chatFileSelectionCallback] fragment is detached");
            return;
        L11:
            MultimodalInputComponent r3 = this.a;
            e1 r4 = r3.x;
            if (r4 != null) goto L15;
            FLogger.a.e("MultimodalInputWrapper", "[chatFileSelectionCallback] validInputContent is null");
            return;
        L15:
            List<com.larus.platform.api.u> r1 = r22;
            ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
            Iterator<T> r2 = r1.iterator();
        L17:
            if (r2.hasNext() == false) goto L19;
            com.larus.platform.api.u r5 = (com.larus.platform.api.u) r2.next();
            Uri r8 = UriProtector.parse(r5.a);
            String r9 = r5.b;
            String r11 = r5.g;
            FlowDriveFileType r12 = r5.f;
            long r13 = r5.c;
            int r7 = r5.h;
            Map r10 = r5.m;
            r6.add(new com.larus.bmhome.chat.component.bottom.multimodal.a.b(r8, r9, Long.valueOf(r13), r11, r12, r7, null, 0.0f, null, null, r10, 1922));
            goto L17
        L19:
            g1 r14 = r4.b;
            h1 r15 = r4.c;
            LinkedHashMap r16 = new LinkedHashMap();
            Map<String, String> r17 = r4.d;
            if (r17 == null) goto L22;
            r16.putAll(r17);
        L22:
            Unit r18 = Unit.INSTANCE;
            r3.gx(new n(r6, r14, r15, r16, null, 16));
            if (com.larus.platform.exp.g.a() == false) goto L32;
            MultimodalInputComponent r19 = this.a;
            if (r19.D == true) goto L33;
            ICoreInputAbility r20 = r19.h3();
            if (r20 == null) goto L34;
            r20.C1(false, false, "chatFileSelectionCallback");
            return;
        L34:
            return;
        L33:
            return;
        }
    }

    public static final class d implements com.larus.platform.api.i0 {
        public final /* synthetic */ MultimodalInputComponent a;

        public d(MultimodalInputComponent r1) {
            this.a = r1;
        }

        public final void a(String r23, List<com.larus.platform.api.s> r24) {
            Intrinsics.checkNotNullParameter(r24, "fileList");
            if (Intrinsics.areEqual(r23, "MultimodalInputWrapper") == false) goto L44;
            ArrayList r3 = (ArrayList) r24;
            if (r3.isEmpty() == false) goto L8;
            return;
        L8:
            if (s1a.a.c(this.a).isAdded() == true) goto L11;
            FLogger.a.e("MultimodalInputWrapper", "[driveFileSelectionCallback] fragment is detached");
            return;
        L11:
            e1 r4 = this.a.x;
            if (r4 != null) goto L15;
            FLogger.a.e("MultimodalInputWrapper", "[driveFileSelectionCallback] validInputContent is null");
            return;
        L15:
            FLogger.a.i("MultimodalInputWrapper", "[driveFileSelectionCallback] onSuccess, fileList(" + r3.size() + ')');
            MultimodalInputComponent r2 = this.a;
            ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r24, 10));
            Iterator r1 = r24.iterator();
        L17:
            if (r1.hasNext() == false) goto L30;
            com.larus.platform.api.s r5 = (com.larus.platform.api.s) r1.next();
            Map r7 = r5.h;
            String r8 = null;
            if (r7 == null) goto L21;
            String r9 = (String) r7.get("originFileTypeString");
        L22:
            Uri r10 = UriProtector.parse(r5.b);
            String r11 = r5.a;
            Map r12 = r5.h;
            if (r12 == null) goto L25;
            r8 = (String) r12.get("originUrl");
        L25:
            String r13 = r8;
            FlowDriveFileType r14 = r5.d;
            long r15 = r5.c;
            Integer r16 = FlowDriveSdkService.a.p(r9);
            if (r16 == null) goto L28;
            int r17 = r16.intValue();
        L29:
            String r18 = r5.f;
            float r19 = r5.g;
            String r20 = r5.e;
            r6.add(new com.larus.bmhome.chat.component.bottom.multimodal.a.b(r10, r11, Long.valueOf(r15), r13, r14, r17, r18, r19, r20, r20, r5.h, 2));
            r1 = r1;
            goto L17
        L28:
            r17 = 12;
            goto L29
        L21:
            r9 = null;
            goto L22
        L30:
            g1 r21 = r4.b;
            h1 r22 = r4.c;
            LinkedHashMap r25 = new LinkedHashMap();
            Map<String, String> r26 = r4.d;
            if (r26 == null) goto L33;
            r25.putAll(r26);
        L33:
            Unit r27 = Unit.INSTANCE;
            r2.gx(new n(r6, r21, r22, r25, null, 16));
            if (com.larus.platform.exp.g.a() == false) goto L45;
            MultimodalInputComponent r28 = this.a;
            if (r28.D == true) goto L46;
            ICoreInputAbility r29 = r28.h3();
            if (r29 == null) goto L47;
            r29.C1(false, false, "driveFileSelectionCallback");
            return;
        L47:
            return;
        L46:
            return;
        L45:
            return;
        }
    }

    public static final class e implements Function0<oaa.a> {
        public final /* synthetic */ AttachReceiver a;

        public e(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(oaa.a.class));
        }
    }

    public static final class f implements Function0<LifecycleOwner> {
        public final /* synthetic */ ComponentFeature a;

        public f(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class g implements Function0<ViewModelStoreOwner> {
        public final /* synthetic */ ComponentFeature a;

        public g(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return s1a.a.getActivity(this.a);
        }
    }

    public static final class h implements Function0<ViewModelProvider.Factory> {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
        }

        public final Object invoke() {
            return new ViewModelProvider.NewInstanceFactory();
        }
    }

    public static final class i implements Function0<LifecycleOwner> {
        public final /* synthetic */ ComponentFeature a;

        public i(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class j implements Function0<ViewModelStoreOwner> {
        public final /* synthetic */ ComponentFeature a;

        public j(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class k implements Function0<ViewModelProvider.Factory> {
        public static final k a = null;

        static {
            a = new k();
        }

        public k() {
        }

        public final Object invoke() {
            return new ViewModelProvider.NewInstanceFactory();
        }
    }

    static {
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.g
    public final void l90() {
        this.D = true;
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.g
    public final void pm() {
        this.A = true;
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.g
    public final void pn() {
        this.z = true;
    }

    public final boolean B3() {
        if (this.J == true) goto L60;
        Integer r3 = null;
        String r4 = null;
        r4 = null;
        if (uy8.b.c() == true) goto L8;
    L39:
        com.larus.bmhome.instruction.g r0 = vc();
        if (r0 != null) goto L42;
    L44:
        boolean r1 = false;
    L45:
        if (r1 == false) goto L58;
        com.larus.bmhome.instruction.g r2 = vc();
        if (r2 == null) goto L50;
        r3 = Integer.valueOf(r2.Q1());
    L50:
        if (od8.h0.f(r3) == false) goto L52;
    L55:
        boolean r5 = true;
    L56:
        if (r5 == false) goto L58;
        return true;
    L52:
        if (od8.h0.i(r3) == true) goto L55;
        r5 = false;
    L58:
        return false;
    L42:
        if (r0.z0() != true) goto L44;
        r1 = true;
        goto L45
    L8:
        if (p3() == false) goto L39;
        com.larus.bmhome.instruction.g r6 = vc();
        if (r6 != null) goto L13;
    L15:
        boolean r7 = false;
    L16:
        if (r7 == false) goto L58;
        com.larus.bmhome.instruction.g r8 = vc();
        if (r8 == null) goto L20;
        Integer r9 = Integer.valueOf(r8.Q1());
    L22:
        if (od8.h0.c(r9) == false) goto L24;
    L36:
        boolean r10 = true;
    L37:
        if (r10 == false) goto L58;
        return true;
    L24:
        if (od8.h0.f(r9) == true) goto L36;
        if (od8.h0.i(r9) == true) goto L36;
        com.larus.bmhome.instruction.g r11 = vc();
        if (r11 == null) goto L33;
        com.larus.bmhome.actionbar.model.z0 r12 = r11.yF();
        if (r12 == null) goto L33;
        r4 = r12.b;
    L33:
        if (Intrinsics.areEqual(r4, ActionBarInstructionKey.COCO_ECOM_ASSISTANT.getKey()) == true) goto L36;
        r10 = false;
        goto L37
    L20:
        r9 = null;
        goto L22
    L13:
        if (r6.z0() != true) goto L15;
        r7 = true;
        goto L16
    L60:
        return true;
    }

    public final void D3() {
        u7 r0 = (u7) this.q.getValue();
        if (r0 == null) goto L6;
        r0.TP(false);
    L6:
        if (uy8.b.c() == false) goto L10;
        ICoreInputAbility r1 = h3();
        if (r1 == null) goto L14;
        r1.mv("MultimodalInputComponent#performAfterSendInAlbum", true);
        return;
    L14:
        return;
    L10:
        ICoreInputAbility r2 = h3();
        if (r2 == null) goto L16;
        r2.C1(false, true, "");
        return;
    }

    public final void F2() {
        if (((MultimodalInputComponentViewExState) ((MultimodalInputComponentViewModelEx) this.i.getValue()).getState()).getHasAutoOpenedCamera() == false) goto L9;
        if (ObricFeatureServiceDelegate.b.c() == false) goto L9;
        FLogger.a.i("MultimodalInputWrapper", "hasAutoOpenCamera");
        return;
    L9:
        if (((de8.c) this.j.getValue()).v() == false) goto L21;
        com.larus.bmhome.chat.component.cvs.y r0 = u0();
        if (r0 == null) goto L13;
        wc9.e r1 = r0.h();
    L14:
        if (r1 == null) goto L16;
    L19:
        FLogger.a.i("MultimodalInputWrapper", "autoOpenPlusCamera");
        QS();
        return;
    L16:
        if (ObricFeatureServiceDelegate.b.c() == false) goto L19;
        FLogger.a.i("MultimodalInputWrapper", "autoOpenPlusCamera: conversation is null");
        return;
    L13:
        r1 = null;
        goto L14
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.g
    public final void M6() {
        e2 r0 = (e2) this.t.getValue();
        if (r0 == null) goto L6;
        r0.M6();
        return;
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [com.larus.bmhome.chat.component.bottom.multimodal.a0] */
    @Override // com.larus.bmhome.chat.component.bottom.multimodal.g
    public final void QS() {
        FLogger.a.i("MultimodalInputWrapper", "tryDirectOpenPlusCamera");
        Bundle r0 = ((de8.c) this.j.getValue()).b;
        if (r0 == null) goto L5;
        r0.remove("auto_open_plus_camera");
        Unit r1 = Unit.INSTANCE;
    L5:
        Bundle r2 = ((de8.c) this.j.getValue()).b;
        final String r3 = null;
        if (r2 == null) goto L8;
        r3 = r2.getString("capture_scene", null);
    L8:
        if (r3 != null) goto L10;
        r3 = "";
    L10:
        final ?? r4 = new a0(this, r3);
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r5 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getView();
        if (r5 == null) goto L14;
        SafeExtKt.b(r5, new c0(this, r4), 100);
        return;
    }

    public final com.larus.bmhome.chat.component.bottom.attachment.g1 Y2() {
        return (com.larus.bmhome.chat.component.bottom.attachment.g1) this.l.getValue();
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.g
    public final void cZ() {
        FLogger.a.i("MultimodalInputWrapper", "resetAutoOpenedCamera");
        ((MultimodalInputComponentViewModelEx) this.i.getValue()).setHasAutoOpenedCamera(false);
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.g
    public final AlbumSettingConfig eP() {
        Intrinsics.checkNotNullParameter("chat_album_preview_click", "clickFrom");
        boolean r2 = false;
        boolean r3 = true;
        if (p3() == true) goto L5;
    L7:
        boolean r0 = false;
    L9:
        if (p3() == true) goto L11;
    L13:
        boolean r4 = false;
    L15:
        if (r0 == true) goto L27;
        if (r4 == true) goto L27;
        boolean r1 = U2(this, "chat_album_preview_click", 0, 6);
        ICoreInputAbility r5 = h3();
        if (r5 != null) goto L20;
    L22:
        boolean r6 = false;
    L23:
        if (r6 == false) goto L25;
        AlbumSettingConfig.a r7 = new AlbumSettingConfig.a();
        r7.d = zv(false, null);
        r7.e = y2.a();
        r7.i = yb(null);
        r7.k = r1;
        r7.q = r1;
        r7.c = true;
        r7.f = "chat_album_preview_click";
        r7.x = this.z;
        return r7.a();
    L25:
        AlbumSettingConfig.a r8 = new AlbumSettingConfig.a();
        r8.i = yb(null);
        r8.k = r1;
        r8.q = r1;
        r8.f = "chat_album_preview_click";
        r8.c = false;
        return r8.a();
    L20:
        if (r5.gj() != true) goto L22;
        r6 = true;
    L27:
        com.larus.bmhome.chat.component.bottom.attachment.g1 r9 = Y2();
        if (r9 == null) goto L32;
        List<UplinkFileEntity> r10 = r9.q1();
        if (r10 == null) goto L32;
        int r11 = r10.size();
    L33:
        boolean r12 = U2(this, "chat_album_preview_click", r11, 4);
        ICoreInputAbility r13 = h3();
        if (r13 != null) goto L36;
    L38:
        boolean r14 = false;
    L39:
        if (r14 == false) goto L59;
        if (r0 == false) goto L42;
        int r15 = zv(false, null);
    L43:
        AlbumSettingConfig.a r16 = new AlbumSettingConfig.a();
        if (p3() == true) goto L46;
    L48:
        boolean r17 = false;
    L49:
        r16.n = r17;
        if (r4 == true) goto L52;
    L54:
        boolean r18 = false;
    L55:
        r16.m = r18;
        r16.c(MediaEntry.MAIN_INPUT);
        r16.d = r15;
        r16.e = y2.a();
        r16.i = yb(null);
        r16.k = r12;
        r16.b(L2(r12));
        r16.q = r12;
        if (r15 <= 1) goto L58;
        r2 = true;
    L58:
        r16.c = r2;
        r16.f = "chat_album_preview_click";
        r16.x = this.z;
        return r16.a();
    L52:
        if (B3() == true) goto L54;
        r18 = true;
        goto L55
    L46:
        if (B3() == true) goto L48;
        r17 = true;
        goto L49
    L42:
        r15 = RangesKt.coerceAtLeast(zv(false, null), 1);
        goto L43
    L59:
        AlbumSettingConfig.a r19 = new AlbumSettingConfig.a();
        if (p3() == true) goto L62;
    L64:
        boolean r20 = false;
    L65:
        r19.n = r20;
        if (r4 == true) goto L68;
    L70:
        r3 = false;
    L71:
        r19.m = r3;
        r19.c(MediaEntry.MAIN_INPUT);
        r19.i = yb(null);
        r19.k = r12;
        r19.b(L2(r12));
        r19.q = r12;
        r19.f = "chat_album_preview_click";
        r19.c = false;
        return r19.a();
    L68:
        if (B3() == true) goto L70;
    L62:
        if (B3() == true) goto L64;
        r20 = true;
        goto L65
    L36:
        if (r13.gj() != true) goto L38;
        r14 = true;
    L32:
        r11 = 0;
        goto L33
    L11:
        if (uy8.b.b("album") == false) goto L13;
        r4 = true;
        goto L15
    L5:
        if (uy8.b.c() == false) goto L7;
        r0 = true;
        goto L9
    }

    public final ICoreInputAbility h3() {
        return (ICoreInputAbility) this.n.getValue();
    }

    public final void onCreate() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Intrinsics.checkNotNullParameter(this, "<this>");     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(com.larus.ui.arch.component.internal.attach.a.b(this, this).getView());     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r1) == false) goto L9;
        r1 = null;
    L9:
        if (r1 == null) goto L14;
        z3();
        return;
    L14:
        return;
    L4:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final void onResume() {
        String r0 = this.F;
        if (r0 != null) goto L5;
    L12:
        ICoreInputAbility r1 = h3();
        if (r1 == null) goto L16;
        r1.cp();
        return;
    L16:
        return;
    L5:
        if (dr9.g.a.a(r0) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L12;
        this.F = null;
        ICoreInputAbility r2 = h3();
        if (r2 == null) goto L12;
        r2.p80(false);
        goto L12
    }

    public final com.larus.bmhome.chat.component.cvs.y u0() {
        return (com.larus.bmhome.chat.component.cvs.y) this.k.getValue();
    }

    public final com.larus.bmhome.instruction.g vc() {
        return (com.larus.bmhome.instruction.g) this.m.getValue();
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.larus.bmhome.chat.component.bottom.multimodal.g.class);
    }

    public final void z3() {
        if (this.I == false) goto L5;
        return;
    L5:
        this.I = true;
        LocalTakePictureImpl r0 = this.B;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r2 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        MultimodalInputComponent$registerAlbumResult$1 r3 = new MultimodalInputComponent$registerAlbumResult$1(this);
        Function1 r4 = new d0(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter("main_input_attachment", "resultScene");
        Intrinsics.checkNotNullParameter(r3, "onSend");
        Intrinsics.checkNotNullParameter(r4, "onSuccess");
        ((AlbumHelper) r0.f.getValue()).a(r2, "main_input_attachment", r3, r4);
        LocalTakePictureImpl r1 = this.B;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r5 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        Function1 r6 = new x(this);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "fragment");
        Intrinsics.checkNotNullParameter("main_input_attachment", "resultScene");
        Intrinsics.checkNotNullParameter(r6, "onSuccess");
        ((AlbumHelper) r1.f.getValue()).e(r5, "main_input_attachment", r6);
        final LocalTakePictureImpl r7 = this.B;
        Intrinsics.checkNotNullParameter(this, "<this>");
        final Fragment r8 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        final Function1 r9 = new y(this);
        final Function0 r10 = new z(this);
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "fragment");
        Intrinsics.checkNotNullParameter(r9, "onSuccess");
        Intrinsics.checkNotNullParameter(r10, "onFail");
        r8.getLifecycle().addObserver(new LocalTakePictureImpl$registerResultForMultiFile$1(r7, r8, r9, r10));
        FlowDriveSdkService r11 = FlowDriveSdkService.a;
        r11.r((d) this.K.getValue());
        ((MultimodalInputComponentViewModel) this.h.getValue()).setUploadProcessConfig(this.E);
        com.larus.bmhome.chat.component.bottom.attachment.g1 r12 = Y2();
        if (r12 == null) goto L8;
        r12.x2(this.E);
    L8:
        r11.x((c) this.L.getValue());
        this.w = new n0(this);
        com.larus.bmhome.chat.component.cvs.y r13 = u0();
        if (r13 == null) goto L12;
        r13.rh(new e0(), this.w);
        return;
    }

    public MultimodalInputComponent() {
        this.h = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(MultimodalInputComponentViewModel.class), Reflection.getOrCreateKotlinClass(MultimodalInputComponentViewState.class), new i(this), new j(this), k.a);
        this.i = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(MultimodalInputComponentViewModelEx.class), Reflection.getOrCreateKotlinClass(MultimodalInputComponentViewExState.class), new f(this), new g(this), h.a);
        this.j = LazyKt.lazy(new q(this));
        this.k = LazyKt.lazy(new k0(this));
        this.l = LazyKt.lazy(new l0(this));
        this.m = LazyKt.lazy(new m0(this));
        this.n = LazyKt.lazy(new r(this));
        this.o = LazyKt.lazy(new s(this));
        this.p = LazyKt.lazy(new t(this));
        this.q = LazyKt.lazy(new u(this));
        this.r = LazyKt.lazy(new v(this));
        this.s = LazyKt.lazy(new w(this));
        this.t = LazyKt.lazy(new b0(this));
        this.u = LazyKt.lazy(new f0(this));
        this.v = new ArrayList();
        this.B = new LocalTakePictureImpl();
        this.G = LazyKt.lazy(new g0(this));
        this.H = LazyKt.lazy(new e(this));
        this.K = LazyKt.lazy(new h0(this));
        this.L = LazyKt.lazy(new i0(this));
        this.M = LazyKt.lazy(new j0(this));
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.g
    public final MultimodalDowngradeData A6() {
        return p.a();
    }

    public final BotModel N2() {
        com.larus.bmhome.chat.component.cvs.y r0 = u0();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.j0();
    }

    public final int m3() {
        com.larus.bmhome.instruction.g r0 = vc();
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.Aq() != true) goto L7;
    L8:
        if (r1 == false) goto L15;
        IFlowSdkDepend r2 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r2 == null) goto L14;
        o2 r3 = r2.x0();
        if (r3 == null) goto L14;
        return r3.e4();
    L14:
        return 5;
    L15:
        ImFileUtil.a.getClass();
        return ImFileUtil.n();
    L7:
        r1 = false;
        goto L8
    }

    public final void onDestroy() {
        com.larus.bmhome.chat.component.cvs.y r0 = u0();
        if (r0 == null) goto L5;
        r0.lQ(this.w);
    L5:
        FlowDriveSdkService r1 = FlowDriveSdkService.a;
        r1.y((d) this.K.getValue());
        r1.e((c) this.L.getValue());
    }

    public final boolean p3() {
        dr9.d r0 = s1a.d.a(this).a(dr9.d.class);
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.a != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final void B2() {
        z3();
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.g
    public final boolean Fb() {
        return this.J;
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.g
    public final boolean g90() {
        return this.z;
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.g
    public final boolean ld() {
        return this.A;
    }

    public final void onStart() {
        F2();
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.g
    public final boolean xE() {
        return this.D;
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.g
    public final boolean yz() {
        return this.C;
    }

    public final void C3(AlbumSettingConfig r7) {
        Boolean r1 = null;
        if (r7.getEnableInjectInput() == false) goto L8;
        ew8.b r0 = s1a.d.a(this).getAbility(ew8.b.class);
        if (r0 == null) goto L7;
        r0.KA();
    L7:
        ChatPageContext r2 = (ChatPageContext) s1a.d.a(this).a(ChatPageContext.class);
    L9:
        Intrinsics.checkNotNullParameter(this, "<this>");
        Context r3 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getContext();
        if (r3 == null) goto L13;
        boolean r4 = v19.h.a;
        r1 = v19.h.c(r3);
    L13:
        if (Intrinsics.areEqual(r1, Boolean.FALSE) == false) goto L16;
        int r5 = 1;
    L20:
        LocalTakePictureImpl r6 = this.B;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r8 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        Bundle r9 = new Bundle();
        r9.putInt("extra.force.theme", r5);
        Unit r10 = Unit.INSTANCE;
        r6.h(r8, r7, r2, r9);
        return;
    L16:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L18;
        r5 = 2;
        goto L20
    L18:
        if (r1 != null) goto L23;
        r5 = 0;
        goto L20
    L23:
        throw new NoWhenBranchMatchedException();
    L8:
        r2 = null;
        goto L9
    }

    public final AlbumInputState L2(boolean r14) {
        String r0 = null;
        if (r14 == true) goto L5;
    L52:
        return null;
    L5:
        if (uy8.b.c() == false) goto L52;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r15 = Y2();
        if (r15 == null) goto L10;
        List<UplinkFileEntity> r16 = r15.q1();
    L11:
        if (r16 != null) goto L13;
        r16 = CollectionsKt.emptyList();
    L13:
        List<UplinkFileEntity> r17 = r16;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator<T> r18 = r17.iterator();
        int r1 = 0;
    L15:
        if (r18.hasNext() == false) goto L20;
        Object r2 = r18.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L19;
        CollectionsKt.throwIndexOverflow();
    L19:
        r9.add(com.larus.bmhome.chat.component.bottom.attachment.d1.e((UplinkFileEntity) r2, r1));
        r1 = r3;
        goto L15
    L20:
        StringBuilder r19 = new StringBuilder();
        com.larus.bmhome.chat.component.cvs.y r4 = u0();
        if (r4 == null) goto L23;
        String r5 = r4.Y1();
    L25:
        if (r5 != null) goto L27;
        r5 = "";
    L27:
        r19.append(r5);
        r19.append("#main_input#");
        com.larus.bmhome.chat.component.bottom.attachment.g1 r6 = Y2();
        if (r6 == null) goto L30;
        String r7 = r6.Wv();
    L31:
        if (r7 != null) goto L33;
        r7 = "";
    L33:
        r19.append(r7);
        String r110 = r19.toString();
        this.F = r110;
        if ((!r9.isEmpty()) == false) goto L43;
        dr9.g r11 = dr9.g.a;
        va8.o r8 = (va8.o) this.o.getValue();
        if (r8 == null) goto L38;
        String r10 = r8.u7();
    L39:
        if (r10 != null) goto L41;
        String r12 = "";
    L42:
        String r13 = r11.b(new InputDraftSnapshot(r12, r9, r110, 0, 8, null));
    L44:
        va8.o r20 = (va8.o) this.o.getValue();
        if (r20 == null) goto L47;
        r0 = r20.u7();
    L47:
        if (r0 != null) goto L49;
        String r21 = "";
    L51:
        return new AlbumInputState(r21, r9, r110, r13, null, 16, null);
    L49:
        r21 = r0;
        goto L51
    L41:
        r12 = r10;
        goto L42
    L38:
        r10 = null;
        goto L39
    L43:
        r13 = null;
        goto L44
    L30:
        r7 = null;
        goto L31
    L23:
        r5 = null;
        goto L25
    L10:
        r16 = null;
        goto L11
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.g
    public final void OR(e1 r6) {
        if (r6 != null) goto L6;
        FLogger.a.i("MultimodalInputWrapper", "[recordInputIntent] reset");
        this.x = null;
        return;
    L6:
        FLogger r1 = FLogger.a;
        r1.i("MultimodalInputWrapper", "[recordInputIntent] " + r6);
        com.larus.bmhome.chat.component.bottom.attachment.g1 r2 = Y2();
        if (r2 != null) goto L9;
    L11:
        boolean r3 = false;
    L13:
        if ((!r3) == true) goto L15;
    L17:
        this.x = r6;
        return;
    L15:
        if (r6.b.a == false) goto L17;
        r1.i("MultimodalInputWrapper", "[recordInputIntent] disable attachment panel");
        g1 r0 = r6.b;
        MultimodalBizScene r4 = r0.b;
        boolean r5 = r0.c;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "bizScene");
        g1 r7 = new g1(false, r4, r5);
        f1 r8 = r6.a;
        h1 r9 = r6.c;
        Map<String, String> r10 = r6.d;
        Intrinsics.checkNotNullParameter(r8, "source");
        Intrinsics.checkNotNullParameter(r7, "processConfig");
        r6 = new e1(r8, r7, r9, r10);
        goto L17
    L9:
        if (r2.mT() != true) goto L11;
        r3 = true;
        goto L13
    }

    public final boolean X2(BotModel r8) {
        Boolean r0 = this.y;
        if (r0 != null) goto L5;
        MultimodalDowngradeData r1 = A6();
        if (r1 == null) goto L14;
        Integer r2 = r1.getVideoDowngrade();
        if (r2 == null) goto L14;
        if (r2.intValue() != 1) goto L14;
        boolean r3 = true;
    L15:
        if (r3 == false) goto L18;
        FLogger.a.i("MultimodalInputWrapper", "enableUploadVideo videoDowngrade = 1, return false");
        return false;
    L18:
        if (r8 != null) goto L20;
        r8 = N2();
    L20:
        String r4 = null;
        if (r8 == null) goto L40;
        List r9 = r8.getBotConf();
        if (r9 == null) goto L40;
        Iterator r10 = r9.iterator();
    L26:
        if (r10.hasNext() == false) goto L35;
        Object r5 = r10.next();
        BotConfItem r6 = (BotConfItem) r5;
        if (Intrinsics.areEqual(r6.getConfGroupKey(), "upload_ability") == true) goto L30;
    L32:
        boolean r7 = false;
    L33:
        if (r7 == false) goto L26;
    L36:
        BotConfItem r11 = (BotConfItem) r5;
        if (r11 == null) goto L40;
        r4 = r11.getConfValue();
        goto L40
    L30:
        if (Intrinsics.areEqual(r6.getConfKey(), "upload_video_file_ability") == false) goto L32;
        r7 = true;
        goto L33
    L35:
        r5 = null;
    L40:
        return Intrinsics.areEqual(r4, "1");
    L14:
        r3 = false;
        goto L15
    L5:
        return r0.booleanValue();
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.g
    public final void Xc(Boolean r1) {
        this.y = r1;
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.g
    public final void bh(boolean r1) {
        this.J = r1;
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.g
    public final void f60(ClarificationComponent.e r5) {
        Intrinsics.checkNotNullParameter(r5, "processor");
        Iterator r0 = ((ArrayList) this.v).iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((b) r1).a != r5) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L4;
    L12:
        b r3 = (b) r1;
        if (r3 == null) goto L15;
        ((ArrayList) this.v).remove(r3);
        FLogger.a.i("MultimodalInputWrapper", "[unregisterDataProcessor] Unregistered processor: " + r5.getClass().getSimpleName() + ", remaining count: " + ((ArrayList) this.v).size());
        return;
    L15:
        FLogger.a.w("MultimodalInputWrapper", "[unregisterDataProcessor] Processor not found: ".concat(r5.getClass().getSimpleName()));
        return;
    L8:
        r2 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.g
    public final void gx(n r13) {
        Intrinsics.checkNotNullParameter(r13, "data");
        ICoreInputAbility r0 = h3();
        boolean r1 = true;
        int r2 = 0;
        if (r0 != null) goto L5;
    L7:
        boolean r3 = false;
    L9:
        if (r3 == false) goto L17;
        ICoreInputAbility r4 = h3();
        if (r4 == null) goto L13;
        String r5 = r4.EW();
    L15:
        if (Intrinsics.areEqual(r5, "inject_input_photo_picker") == false) goto L17;
        boolean r6 = true;
    L18:
        if (r6 == true) goto L20;
    L29:
        r1 = false;
    L30:
        if (r6 == false) goto L40;
        if (r1 == true) goto L33;
    L34:
        Intrinsics.checkNotNullParameter(r13, "<this>");
        Intrinsics.checkNotNullParameter("album", "scene");
        if (TypeIntrinsics.isMutableMap(r13.d) == false) goto L37;
        r13.d.put("scene", "album");
    L37:
        Intrinsics.checkNotNullParameter(r13, "<this>");
        Intrinsics.checkNotNullParameter("album", "scene");
        if (TypeIntrinsics.isMutableMap(r13.d) == false) goto L40;
        r13.d.put("enter_method", "album");
        r13.d.put("enter_method_trace", "album");
        goto L40
    L33:
        if (r13.b.b == MultimodalBizScene.PhotoPickerAttachmentPanel) goto L34;
    L40:
        OR(null);
        MultimodalBizScene r7 = r13.b.b;
        FLogger.a.i("MultimodalInputWrapper", "[dispatchToProcessorChain] Start processing, bizScene=" + r7 + ", external processors count: " + ((ArrayList) this.v).size());
        Iterator r8 = ((ArrayList) this.v).iterator();
    L42:
        if (r8.hasNext() == false) goto L50;
        int r9 = r2 + 1;
        b r10 = (b) r8.next();
        String r11 = r10.a.getClass().getSimpleName();
        if (r10.b.contains(r7) == true) goto L46;
        FLogger.a.i("MultimodalInputWrapper", "[dispatchToProcessorChain] External processor[" + r2 + "](" + r11 + ") skipped, bizScene=" + r7 + " not in filter=" + r10.b);
    L49:
        r2 = r9;
        goto L42
    L46:
        FLogger r12 = FLogger.a;
        r12.i("MultimodalInputWrapper", "[dispatchToProcessorChain] Invoking external processor[" + r2 + "](" + r11 + "), bizScene=" + r7 + " matched filter");
        boolean r14 = r10.a.a(r13);
        r12.i("MultimodalInputWrapper", "[dispatchToProcessorChain] External processor[" + r2 + "](" + r11 + ") result: intercepted=" + r14);
        if (r14 == false) goto L49;
        r12.i("MultimodalInputWrapper", "[dispatchToProcessorChain] Data intercepted by external processor[" + r2 + "](" + r11 + "), skipping remaining processors");
        return;
    L50:
        FLogger r15 = FLogger.a;
        r15.i("MultimodalInputWrapper", "[dispatchToProcessorChain] No external processor intercepted, invoking default processor for bizScene=" + r7);
        r15.i("MultimodalInputWrapper", "[dispatchToProcessorChain] Default processor result: intercepted=" + ((com.larus.bmhome.chat.component.bottom.multimodal.f) this.u.getValue()).a(r13));
        return;
    L20:
        if (uy8.b.a().b == false) goto L29;
        Bundle r16 = ((de8.c) this.j.getValue()).b;
        if (r16 != null) goto L24;
    L26:
        boolean r17 = false;
    L27:
        if (r17 == false) goto L29;
    L24:
        if (r16.getBoolean("inject_input_hide_album_entrance", false) != true) goto L26;
        r17 = true;
        goto L27
    L13:
        r5 = null;
    L17:
        r6 = false;
        goto L18
    L5:
        if (r0.c1() != true) goto L7;
        r3 = true;
        goto L9
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.g
    public final void n90(e1 r18) {
        Intrinsics.checkNotNullParameter(r18, "multimodalInputIntent");
        boolean r3 = true;
        int r4 = 0;
        Integer r5 = 0;
        if ((r18.a instanceof f1.a) == false) goto L13;
        Bundle r2 = ((de8.c) this.j.getValue()).b;
        if (r2 != null) goto L7;
    L9:
        boolean r6 = false;
    L10:
        if (r6 == false) goto L13;
        FLogger.a.w("MultimodalInputWrapper", "[startIntent] nested album rejected by host navigation policy");
        return;
    L7:
        if (r2.getBoolean("inject_input_hide_album_entrance", false) != true) goto L9;
        r6 = true;
    L13:
        OR(r18);
        f1 r7 = r18.a;
        String r8 = null;
        if ((r7 instanceof f1.a) == false) goto L140;
        ICoreInputAbility r9 = h3();
        if (r9 != null) goto L18;
    L20:
        boolean r10 = false;
    L21:
        Map<String, String> r11 = r18.d;
        if (r11 == null) goto L24;
        String r12 = r11.get("upload_file_click_from");
    L26:
        if (r18.b.b != MultimodalBizScene.ChatAttachmentPanelMoreAlbum) goto L28;
        String r1 = "attachment_panel";
    L29:
        f1.a r13 = (f1.a) r7;
        if (r13.a == false) goto L33;
        if (r10 == false) goto L33;
        boolean r14 = true;
    L34:
        Integer r15 = Integer.valueOf(r13.b);
        oaa.a r16 = (oaa.a) this.H.getValue();
        if (r16 == null) goto L37;
        r16.yw();
    L37:
        maa.e r17 = (maa.e) this.s.getValue();
        if (r17 == null) goto L40;
        maa.e.a.a(r17, null, null, false, 7);
    L40:
        oaa.a r19 = (oaa.a) this.H.getValue();
        if (r19 == null) goto L44;
        r19.yw();
    L44:
        if (p3() == true) goto L46;
    L48:
        boolean r20 = false;
    L50:
        if (p3() == true) goto L52;
    L54:
        boolean r110 = false;
    L55:
        if (r20 == true) goto L80;
        if (r110 == true) goto L80;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r21 = Y2();
        if (r21 == null) goto L62;
        List<UplinkFileEntity> r22 = r21.q1();
        if (r22 == null) goto L62;
        int r23 = r22.size();
    L63:
        boolean r24 = U2(this, r12, r23, 4);
        if (r14 == false) goto L73;
        AlbumSettingConfig.a r25 = new AlbumSettingConfig.a();
        int r26 = zv(false, null);
        com.larus.bmhome.chat.component.bottom.attachment.g1 r111 = Y2();
        if (r111 == null) goto L68;
        r4 = com.larus.bmhome.chat.component.bottom.attachment.g1.a.b(r111);
    L68:
        r25.d = r26 - r4;
        r25.e = y2.a();
        r25.f = r12;
        r25.c = true;
        r25.i = yb(null);
        if (r15 == null) goto L72;
        r5 = r15;
    L72:
        r25.j = r5;
        r25.k = r24;
        r25.q = r24;
        r25.x = this.z;
        AlbumSettingConfig r27 = r25.a();
    L78:
        C3(r27);
        return;
    L73:
        AlbumSettingConfig.a r28 = new AlbumSettingConfig.a();
        r28.f = r12;
        r28.i = yb(null);
        if (r15 == null) goto L77;
        r5 = r15;
    L77:
        r28.j = r5;
        r28.c = false;
        r28.k = r24;
        r28.q = r24;
        r27 = r28.a();
    L62:
        r23 = 0;
    L80:
        if (Intrinsics.areEqual(r1, "attachment_panel") == false) goto L82;
        MediaEntry r112 = MediaEntry.ATTACHMENT_PANEL;
    L83:
        if (r14 == false) goto L115;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r29 = Y2();
        if (r29 == null) goto L89;
        List<UplinkFileEntity> r30 = r29.q1();
        if (r30 == null) goto L89;
        int r31 = r30.size();
    L90:
        boolean r32 = P2(r12, r31, r1);
        int r33 = zv(false, null);
        if (r20 == false) goto L93;
        int r34 = RangesKt.coerceAtLeast(r33, 0);
    L94:
        AlbumSettingConfig.a r113 = new AlbumSettingConfig.a();
        if (p3() == true) goto L97;
    L99:
        boolean r114 = false;
    L100:
        r113.n = r114;
        if (r110 == true) goto L103;
    L105:
        boolean r115 = false;
    L106:
        r113.m = r115;
        r113.c(r112);
        r113.d = r34;
        r113.e = y2.a();
        r113.f = r12;
        if (r33 > 1) goto L110;
        r3 = false;
    L110:
        r113.c = r3;
        r113.i = yb(null);
        if (r15 == null) goto L114;
        r5 = r15;
    L114:
        r113.j = r5;
        r113.k = r32;
        r113.b(L2(r32));
        r113.q = r32;
        r113.x = this.z;
        AlbumSettingConfig r35 = r113.a();
    L138:
        C3(r35);
        return;
    L103:
        if (B3() == true) goto L105;
        r115 = true;
        goto L106
    L97:
        if (B3() == true) goto L99;
        r114 = true;
        goto L100
    L93:
        r34 = RangesKt.coerceAtLeast(r33, 1);
    L89:
        r31 = 0;
        goto L90
    L115:
        com.larus.bmhome.chat.component.bottom.attachment.g1 r36 = Y2();
        if (r36 == null) goto L120;
        List<UplinkFileEntity> r37 = r36.q1();
        if (r37 == null) goto L120;
        int r38 = r37.size();
    L121:
        boolean r39 = P2(r12, r38, r1);
        AlbumSettingConfig.a r40 = new AlbumSettingConfig.a();
        if (p3() == true) goto L124;
    L126:
        boolean r41 = false;
    L127:
        r40.n = r41;
        if (r110 == true) goto L130;
    L132:
        r3 = false;
    L133:
        r40.m = r3;
        r40.c(r112);
        r40.f = r12;
        r40.i = yb(null);
        if (r15 == null) goto L137;
        r5 = r15;
    L137:
        r40.j = r5;
        r40.c = false;
        r40.k = r39;
        r40.b(L2(r39));
        r40.q = r39;
        r35 = r40.a();
        goto L138
    L130:
        if (B3() == true) goto L132;
    L124:
        if (B3() == true) goto L126;
        r41 = true;
    L120:
        r38 = 0;
        goto L121
    L82:
        r112 = MediaEntry.MAIN_INPUT;
        goto L83
    L52:
        if (uy8.b.b("album") == false) goto L54;
        r110 = true;
        goto L55
    L46:
        if (uy8.b.c() == false) goto L48;
        r20 = true;
    L33:
        r14 = false;
        goto L34
    L28:
        r1 = null;
        goto L29
    L24:
        r12 = null;
        goto L26
    L18:
        if (r9.gj() != true) goto L20;
        r10 = true;
        goto L21
    L140:
        if ((r7 instanceof f1.c) == false) goto L167;
        f1.c r42 = (f1.c) r7;
        boolean r43 = r42.a;
        boolean r116 = r42.b;
        boolean r117 = r42.c;
        boolean r44 = UploadFilePolicy.a;
        com.larus.bmhome.instruction.g r45 = vc();
        if (r45 != null) goto L144;
    L146:
        boolean r46 = false;
    L147:
        UploadFilePolicy.a = r46;
        ICoreInputAbility r47 = h3();
        if (r47 == null) goto L151;
        r47.Pi();
    L151:
        if (r43 == false) goto L159;
        LocalTakePictureImpl r48 = this.B;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r49 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        ICoreInputAbility r50 = h3();
        if (r50 != null) goto L155;
    L157:
        boolean r51 = false;
    L158:
        r48.getClass();
        Intrinsics.checkNotNullParameter(r49, "fragment");
        r48.j(r49, r51, r116, r117, true);
        return;
    L155:
        if (r50.Pi() != true) goto L157;
        r51 = true;
        goto L158
    L159:
        LocalTakePictureImpl r52 = this.B;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r53 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        ICoreInputAbility r54 = h3();
        if (r54 != null) goto L162;
    L164:
        boolean r55 = false;
    L165:
        r52.getClass();
        Intrinsics.checkNotNullParameter(r53, "fragment");
        r52.j(r53, r55, r116, r117, false);
        return;
    L162:
        if (r54.Pi() != true) goto L164;
        r55 = true;
        goto L165
    L144:
        if (r45.yW() != true) goto L146;
        r46 = true;
        goto L147
    L167:
        if (Intrinsics.areEqual(r7, f1.b.a) == false) goto L226;
        Map<String, String> r56 = r18.d;
        if (r56 == null) goto L171;
        String r57 = r56.get("click_from");
    L172:
        Map<String, String> r58 = r18.d;
        if (r58 == null) goto L175;
        String r59 = r58.get("capture_scene");
    L176:
        if (r57 != null) goto L178;
        r57 = "plus_panel";
    L178:
        com.larus.bmhome.chat.component.bottom.bottommenu.f1 r60 = (com.larus.bmhome.chat.component.bottom.bottommenu.f1) s1a.d.a(this).getAbility(com.larus.bmhome.chat.component.bottom.bottommenu.f1.class);
        if (r60 == null) goto L181;
        Map<String, Object> r61 = r60.wV();
    L182:
        if (r61 == null) goto L184;
        Object r62 = r61.get("capture_scene");
    L186:
        if ((r62 instanceof String) == false) goto L188;
        String r63 = (String) r62;
    L189:
        HashMap r118 = new HashMap();
        Intrinsics.checkNotNullParameter(this, "<this>");
        xe8.a r64 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        if ((r64 instanceof xe8.a) == false) goto L192;
        r118.put("chat_key", Long.valueOf(r64.getChatUniqueKey()));
    L192:
        r118.put("click_from", r57);
        com.larus.bmhome.instruction.g r65 = vc();
        if (r65 == null) goto L209;
        com.larus.bmhome.actionbar.model.z0 r66 = r65.yF();
        if (r66 == null) goto L209;
        com.larus.bmhome.actionbar.model.r r67 = r66.q;
        if (r67 == null) goto L209;
        Integer r68 = r67.a;
        if (r68 == null) goto L209;
        int r69 = r68.intValue();
        r118.put("action_bar_instruction_type", Integer.valueOf(r69));
        int r70 = od8.h0.a;
        if (od8.h0.f(Integer.valueOf(r69)) == false) goto L203;
    L204:
        com.larus.bmhome.instruction.g r71 = vc();
        if (r71 == null) goto L209;
        String r72 = r71.gm();
        if (r72 == null) goto L209;
        r118.put("action_bar_instruction_items_template", r72);
        goto L209
    L203:
        if (od8.h0.i(Integer.valueOf(r69)) == true) goto L204;
    L209:
        if (r61 == null) goto L211;
        r118.putAll(r61);
    L211:
        LruCache r73 = ko8.a.a;
        LruCache r74 = IAIChatControlTraceService.a.xb();
        com.larus.bmhome.chat.component.cvs.y r75 = u0();
        if (r75 == null) goto L214;
        r8 = r75.Y1();
    L214:
        if (r8 != null) goto L216;
        r8 = "";
    L216:
        r74.put(r8, r57);
        zb8.e r76 = (zb8.e) this.p.getValue();
        if (r76 == null) goto L231;
        String r77 = com.larus.utils.p0.a(r59);
        if (r77 != null) goto L223;
        r77 = com.larus.utils.p0.a(r63);
        if (r77 != null) goto L223;
        r77 = "common_bottom_menu";
    L223:
        e$a.b(r76, r77, r118, null, null, null, !B3(), 52);
        return;
    L231:
        return;
    L188:
        r63 = null;
        goto L189
    L184:
        r62 = null;
        goto L186
    L181:
        r61 = null;
        goto L182
    L175:
        r59 = null;
        goto L176
    L171:
        r57 = null;
        goto L172
    L226:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.g
    public final boolean nA(BotModel r4) {
        if (X2(r4) == true) goto L14;
        zb8.e r5 = (zb8.e) this.p.getValue();
        if (r5 != null) goto L7;
    L9:
        boolean r6 = false;
    L10:
        if (r6 == true) goto L15;
        return false;
    L15:
        return true;
    L7:
        if (r5.gs("common_input") != true) goto L9;
        r6 = true;
        goto L10
    L14:
        return true;
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.g
    public final void pd(boolean r4) {
        FLogger.a.i("MultimodalInputWrapper", "[setForceDisableInjectInput] forceDisable:" + r4);
        this.C = r4;
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.g
    public final void x2(ns8.b r2) {
        this.E = r2;
        ((MultimodalInputComponentViewModel) this.h.getValue()).setUploadProcessConfig(r2);
        com.larus.bmhome.chat.component.bottom.attachment.g1 r0 = Y2();
        if (r0 == null) goto L6;
        r0.x2(r2);
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.g
    public final boolean yb(BotModel r1) {
        return X2(r1);
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.g
    public final void VR(ClarificationComponent.e r5, Set r6) {
        Intrinsics.checkNotNullParameter(r5, "processor");
        Intrinsics.checkNotNullParameter(r6, "bizSceneFilter");
        Iterator r0 = ((ArrayList) this.v).iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((b) r1).a != r5) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L4;
    L12:
        b r3 = (b) r1;
        if (r3 == null) goto L15;
        FLogger.a.w("MultimodalInputWrapper", "[registerDataProcessor] Processor already registered: " + r5.getClass().getSimpleName() + ", existing filter=" + r3.b);
        return;
    L15:
        if (r6.isEmpty() == false) goto L17;
        FLogger.a.w("MultimodalInputWrapper", "[registerDataProcessor] bizSceneFilter is empty, processor will not handle any data: ".concat(r5.getClass().getSimpleName()));
    L17:
        ((ArrayList) this.v).add(new b(r5, r6));
        FLogger.a.i("MultimodalInputWrapper", "[registerDataProcessor] Registered processor: " + r5.getClass().getSimpleName() + ", bizSceneFilter=" + r6 + ", total count: " + ((ArrayList) this.v).size());
        return;
    L8:
        r2 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.g
    public final String mS(boolean r7, Boolean r8) {
        com.larus.bmhome.chat.component.bottom.attachment.g1 r0 = Y2();
        if (r0 == null) goto L5;
        AttachmentPanelType r1 = r0.eC();
    L7:
        if (r1 != AttachmentPanelType.MultiFile) goto L9;
    L12:
        boolean r9 = true;
    L13:
        com.larus.bmhome.instruction.g r2 = vc();
        if (r2 != null) goto L16;
    L18:
        boolean r3 = false;
    L20:
        if (r3 == false) goto L23;
        String r10 = getContext().getString(2131907895, new Object[]{String.valueOf(m3())});
        Intrinsics.checkNotNull(r10);
        return r10;
    L23:
        if (r1 != AttachmentPanelType.MixImageFile) goto L25;
        Context r11 = getContext();
        ImFileUtil.a.getClass();
        String r12 = r11.getString(2131907886, new Object[]{String.valueOf(ImFileUtil.o())});
        Intrinsics.checkNotNull(r12);
        return r12;
    L25:
        if (r7 == true) goto L32;
        if (r9 == true) goto L32;
        if (nA(null) == false) goto L31;
        Context r13 = getContext();
        ImFileUtil.a.getClass();
        String r14 = r13.getString(2131910955, new Object[]{String.valueOf(ImFileUtil.m())});
        Intrinsics.checkNotNull(r14);
        return r14;
    L31:
        String r15 = getContext().getString(2131907895, new Object[]{String.valueOf(m3())});
        Intrinsics.checkNotNull(r15);
        return r15;
    L32:
        Context r16 = getContext();
        ImFileUtil.a.getClass();
        String r17 = r16.getString(2131907892, new Object[]{String.valueOf(ImFileUtil.l())});
        Intrinsics.checkNotNull(r17);
        return r17;
    L16:
        if (r2.HM() != true) goto L18;
        r3 = true;
        goto L20
    L9:
        if (Intrinsics.areEqual(r8, Boolean.TRUE) == true) goto L12;
        r9 = false;
        goto L13
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.g
    public final int zv(boolean r6, Boolean r7) {
        com.larus.bmhome.chat.component.bottom.attachment.g1 r0 = Y2();
        if (r0 == null) goto L5;
        AttachmentPanelType r1 = r0.eC();
    L6:
        boolean r3 = false;
        if (r1 != AttachmentPanelType.MultiFile) goto L9;
    L12:
        boolean r8 = true;
    L13:
        com.larus.bmhome.instruction.g r2 = vc();
        if (r2 != null) goto L16;
    L18:
        boolean r4 = false;
    L19:
        if (r4 == true) goto L50;
        ICoreInputAbility r5 = h3();
        if (r5 != null) goto L24;
    L26:
        boolean r9 = false;
    L27:
        if (r9 == false) goto L29;
        ImFileUtil.a.getClass();
        return ImFileUtil.o();
    L29:
        if (r6 == true) goto L48;
        if (r8 == true) goto L48;
        if (nA(null) == false) goto L55;
        com.larus.bmhome.instruction.g r10 = vc();
        if (r10 != null) goto L37;
    L39:
        if (r3 == false) goto L46;
        IFlowSdkDepend r11 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r11 == null) goto L45;
        o2 r12 = r11.x0();
        if (r12 == null) goto L45;
        return r12.e4();
    L45:
        return 5;
    L46:
        ImFileUtil.a.getClass();
        return ImFileUtil.m();
    L37:
        if (r10.Aq() != true) goto L39;
        r3 = true;
        goto L39
    L55:
        return m3();
    L48:
        ImFileUtil.a.getClass();
        return ImFileUtil.l();
    L24:
        if (r5.Pi() != true) goto L26;
        r9 = true;
        goto L27
    L50:
        return m3();
    L16:
        if (r2.HM() != true) goto L18;
        r4 = true;
        goto L19
    L9:
        if (Intrinsics.areEqual(r7, Boolean.TRUE) == true) goto L12;
        r8 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.g
    public final boolean Me(String r11, Integer r12, DirectSendData r13) {
        Intrinsics.checkNotNullParameter(r11, "scene");
        FLogger.a.i("MultimodalInputWrapper", "[skipAttachment] scene:" + r11 + ", allImage:true, cameraType:" + r12 + ", directSendData:" + r13);
        boolean r0 = true;
        if (r13 == null) goto L6;
        return true;
    L6:
        if (od8.h0.e(r12) == false) goto L8;
        return false;
    L8:
        com.larus.bmhome.chat.component.bottom.attachment.g1 r14 = Y2();
        if (r14 != null) goto L11;
    L13:
        boolean r15 = false;
    L14:
        if (r15 == false) goto L16;
        return false;
    L16:
        String r4 = null;
        if (FeatureKitDelegate.b.k0().b() == true) goto L41;
        BotModel r16 = N2();
        if (r16 == null) goto L37;
        List r17 = r16.getBotConf();
        if (r17 == null) goto L37;
        Iterator r18 = r17.iterator();
    L24:
        if (r18.hasNext() == false) goto L33;
        Object r5 = r18.next();
        BotConfItem r6 = (BotConfItem) r5;
        if (Intrinsics.areEqual(r6.getConfGroupKey(), "disable_function") == true) goto L28;
    L30:
        boolean r7 = false;
    L31:
        if (r7 == false) goto L24;
    L34:
        BotConfItem r8 = (BotConfItem) r5;
        if (r8 == null) goto L37;
        String r19 = r8.getConfValue();
    L39:
        if (Intrinsics.areEqual(r19, "1") == false) goto L41;
        boolean r110 = true;
    L43:
        if (FeatureKitDelegate.b.u0().b() == true) goto L67;
        BotModel r9 = N2();
        if (r9 == null) goto L63;
        List r10 = r9.getBotConf();
        if (r10 == null) goto L63;
        Iterator r20 = r10.iterator();
    L50:
        if (r20.hasNext() == false) goto L59;
        Object r21 = r20.next();
        BotConfItem r22 = (BotConfItem) r21;
        if (Intrinsics.areEqual(r22.getConfGroupKey(), "disable_function") == true) goto L54;
    L56:
        boolean r23 = false;
    L57:
        if (r23 == false) goto L50;
    L60:
        BotConfItem r24 = (BotConfItem) r21;
        if (r24 == null) goto L63;
        String r25 = r24.getConfValue();
    L65:
        if (Intrinsics.areEqual(r25, "1") == false) goto L67;
        boolean r26 = true;
    L69:
        if (FeatureKitDelegate.b.p0().b() == true) goto L92;
        BotModel r27 = N2();
        if (r27 == null) goto L90;
        List r28 = r27.getBotConf();
        if (r28 == null) goto L90;
        Iterator r29 = r28.iterator();
    L76:
        if (r29.hasNext() == false) goto L85;
        Object r30 = r29.next();
        BotConfItem r31 = (BotConfItem) r30;
        if (Intrinsics.areEqual(r31.getConfGroupKey(), "disable_function") == true) goto L80;
    L82:
        boolean r32 = false;
    L83:
        if (r32 == false) goto L76;
    L86:
        BotConfItem r33 = (BotConfItem) r30;
        if (r33 == null) goto L90;
        r4 = r33.getConfValue();
        goto L90
    L80:
        if (Intrinsics.areEqual(r31.getConfKey(), "apply_attachment_skip_optional") == false) goto L82;
        r32 = true;
        goto L83
    L85:
        r30 = null;
    L90:
        if (Intrinsics.areEqual(r4, "1") == false) goto L92;
    L94:
        switch(r11.hashCode()) {
            case -2113586946: goto L114;
            case 3143036: goto L110;
            case 92896879: goto L106;
            case 106438291: goto L103;
            case 109413407: goto L100;
            case 249793358: goto L97;
            default: goto L135;
        };
    L135:
        return false;
    L97:
        if (r11.equals("album_ocr") == true) goto L133;
        return false;
    L133:
        return r26;
    L100:
        if (r11.equals("shoot") == true) goto L117;
        return false;
    L117:
        return r110;
    L103:
        if (r11.equals("paste") == true) goto L133;
        return false;
    L106:
        if (r11.equals("album") == true) goto L133;
        return false;
    L110:
        if (r11.equals("file") == true) goto L134;
        return false;
    L134:
        return r0;
    L114:
        if (r11.equals("shoot_ocr") == true) goto L117;
        return false;
    L92:
        r0 = false;
        goto L94
    L54:
        if (Intrinsics.areEqual(r22.getConfKey(), "apply_attachment_skip_optional") == false) goto L56;
        r23 = true;
        goto L57
    L59:
        r21 = null;
    L63:
        r25 = null;
    L67:
        r26 = false;
        goto L69
    L28:
        if (Intrinsics.areEqual(r6.getConfKey(), "apply_attachment_skip_optional") == false) goto L30;
        r7 = true;
        goto L31
    L33:
        r5 = null;
    L37:
        r19 = null;
    L41:
        r110 = false;
        goto L43
    L11:
        if (r14.isVisible() != true) goto L13;
        r15 = true;
        goto L14
    }

    public final boolean P2(String r9, int r10, String r11) {
        if (B3() == false) goto L5;
        return false;
    L5:
        uy8.a r0 = uy8.b.a();
        IAIChatControlTraceService.Companion r2 = IAIChatControlTraceService.a;
        com.larus.bmhome.chat.trace.a r3 = r2.gc(r2.gb());
        if (r3 == null) goto L10;
        Integer r4 = r3.d;
        if (r4 == null) goto L10;
        int r5 = r4.intValue();
    L11:
        k2 r6 = k2.a;
        String r7 = null;
        if (r3 == null) goto L14;
        String r8 = r3.g;
    L16:
        if (r6.d(r8, Integer.valueOf(r5)) == true) goto L23;
        if (r3 == null) goto L20;
        r7 = r3.g;
    L20:
        if (r6.b(r7, Integer.valueOf(r5)) == true) goto L23;
        boolean r12 = false;
    L25:
        if (p3() == false) goto L33;
        if (r11 != null) goto L28;
    L30:
        boolean r13 = false;
    L31:
        if (r13 == false) goto L33;
        boolean r14 = true;
    L34:
        if (r14 == true) goto L36;
    L38:
        if (r11 != null) goto L48;
        if (r12 == false) goto L46;
        if (r10 > 0) goto L42;
    L45:
        r14 = true;
        goto L48
    L42:
        if (p3() == false) goto L46;
        if (r0.c == true) goto L45;
    L46:
        r14 = false;
    L48:
        if (p3() == true) goto L50;
    L52:
        boolean r1 = false;
    L54:
        if (Intrinsics.areEqual(r11, "attachment_panel") == false) goto L56;
    L63:
        boolean r15 = true;
    L64:
        if (r14 == false) goto L70;
        if (r10 <= 0) goto L67;
        if (r1 == true) goto L67;
        return false;
    L67:
        if (r15 == false) goto L72;
        return true;
    L72:
        return false;
    L70:
        return false;
    L56:
        if (Intrinsics.areEqual(r9, "plus_panel") == true) goto L63;
        if (Intrinsics.areEqual(r9, "long_press_input_left_camera") == true) goto L63;
        if (Intrinsics.areEqual(r9, "chat_album_preview_click") == true) goto L63;
        r15 = false;
        goto L64
    L50:
        if (r0.c == false) goto L52;
        r1 = true;
        goto L54
    L36:
        if (r6.x() == true) goto L38;
        return false;
    L28:
        if (r0.a(r11) != true) goto L30;
        r13 = true;
    L33:
        r14 = false;
    L23:
        r12 = true;
        goto L25
    L14:
        r8 = null;
    L10:
        r5 = 0;
        goto L11
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.g
    public final Object kp(Uri r5, String r6, Continuation<? super Boolean> r7) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        ImFileUtil.a.getClass();     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(ImFileUtil.f(r5));     // Catch: Throwable -> L4
    L6:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L13;
        FLogger.a.e("MultimodalInputWrapper", "[canProcessAsVideo] get file info failed", r2);
        return Boxing.boxBoolean(false);
    L13:
        return BuildersKt.withContext(Dispatchers.getIO(), new MultimodalInputComponent$canProcessAsVideo$2(r5, (ic8.m0) r1, r6, null), r7);
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public static /* synthetic */ boolean U2(MultimodalInputComponent r0, String r1, int r2, int r3) {
        if ((r3 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        return r0.P2(r1, r2, null);
    }
}
