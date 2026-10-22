package com.obric.memorydata.memory;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import android.security.obric.guard.ObricSecurityGuardStub;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crypto.utils.CryptoConst;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.obric.memorydata.memory.ui.settings.ShortcutMemoryConsentType;
import com.obric.memorydata.memory.ui.settings.ShortcutMemoryTrigger;
import com.obric.memorydata.memory.ui.share.ActiveMemoryConfirmDialogActivity;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.ak;
import com.ss.bduploader.BDVideoUploaderBase;
import com.ttnet.org.chromium.net.impl.URLDispatch;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bm;
import kotlinx.coroutines.bo;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.cu;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\f\u009c\u0001\u009d\u0001\u009e\u0001\u009f\u0001 \u0001¡\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u0005H\u0002J\u0018\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u0005H\u0002J\u0006\u0010)\u001a\u00020'J\u0018\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u0005H\u0002J\u0016\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201J\u0012\u00102\u001a\u0004\u0018\u00010\u00052\u0006\u00100\u001a\u000201H\u0002J\u0012\u00103\u001a\u0004\u0018\u00010\u00052\u0006\u0010.\u001a\u00020/H\u0002J\u0012\u00104\u001a\u0004\u0018\u00010/2\u0006\u00105\u001a\u00020/H\u0002J\u000e\u00106\u001a\u0004\u0018\u00010\u0005*\u00020\u0005H\u0002J\u0012\u00107\u001a\u0004\u0018\u0001082\u0006\u00100\u001a\u000201H\u0002J\u0018\u00109\u001a\u00020:2\u0006\u0010.\u001a\u00020/2\u0006\u0010;\u001a\u000208H\u0002JE\u0010<\u001a\u00020:2\u0006\u0010=\u001a\u00020>2\u0006\u0010;\u001a\u0002082\u0006\u0010?\u001a\u00020\u00052\u0006\u0010@\u001a\u00020:2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010CJ7\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010=\u001a\u00020>2\u0006\u0010;\u001a\u0002082\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010FJ\u001f\u0010G\u001a\u0004\u0018\u00010\u000b2\u0006\u0010=\u001a\u00020>2\u0006\u0010;\u001a\u000208H\u0002¢\u0006\u0002\u0010HJ\u0018\u0010I\u001a\u00020:2\u0006\u0010.\u001a\u00020/2\u0006\u0010;\u001a\u000208H\u0002J\u0010\u0010J\u001a\u00020'2\u0006\u0010.\u001a\u00020/H\u0002J \u0010K\u001a\u00020:2\u0006\u0010L\u001a\u00020M2\u0006\u0010+\u001a\u00020\r2\u0006\u0010N\u001a\u00020OH\u0002J2\u0010P\u001a\u00020:2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020O2\u0006\u0010+\u001a\u00020\r2\b\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010S\u001a\u00020TH\u0002J\u0006\u0010U\u001a\u00020'J\u0018\u0010V\u001a\u00020'2\u0006\u0010W\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u0005H\u0002J\u0006\u0010X\u001a\u00020'J\u0016\u0010Y\u001a\u00020'2\u0006\u0010+\u001a\u00020\r2\u0006\u0010N\u001a\u00020OJ\u0012\u0010Z\u001a\u0004\u0018\u00010\u00182\u0006\u0010%\u001a\u00020\u0005H\u0002J\b\u0010[\u001a\u00020'H\u0002J\u0010\u0010\\\u001a\u00020:2\u0006\u0010+\u001a\u00020\rH\u0002J\u0010\u0010]\u001a\u00020^2\u0006\u0010+\u001a\u00020\rH\u0002J\u000e\u0010_\u001a\u00020'2\u0006\u0010`\u001a\u00020\u0015J\u000e\u0010a\u001a\u00020'2\u0006\u0010`\u001a\u00020\u0015J6\u0010b\u001a\u00020'2\u0006\u0010N\u001a\u00020O2\u0006\u0010+\u001a\u00020\r2\b\b\u0002\u0010c\u001a\u00020:2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010S\u001a\u00020TH\u0003J0\u0010d\u001a\u00020:2\u0006\u0010e\u001a\u00020f2\u0006\u0010+\u001a\u00020\r2\u0006\u0010g\u001a\u00020\r2\u0006\u0010h\u001a\u00020\r2\u0006\u0010i\u001a\u00020\rH\u0002J\u0012\u0010j\u001a\u0004\u0018\u00010\u00052\u0006\u0010c\u001a\u00020:H\u0002J \u0010k\u001a\u00020l2\u0006\u0010+\u001a\u00020\r2\u0006\u0010N\u001a\u00020O2\u0006\u0010c\u001a\u00020:H\u0002J$\u0010m\u001a\u00020:2\u0006\u0010n\u001a\u00020:2\b\u0010o\u001a\u0004\u0018\u00010\u00052\b\u0010p\u001a\u0004\u0018\u00010\u0005H\u0002J \u0010q\u001a\u00020'2\u0006\u0010+\u001a\u00020\r2\u0006\u0010N\u001a\u00020O2\u0006\u0010c\u001a\u00020:H\u0002J$\u0010r\u001a\u0004\u0018\u00010R2\u0006\u0010+\u001a\u00020\r2\u0006\u0010N\u001a\u00020O2\b\u0010o\u001a\u0004\u0018\u00010\u0005H\u0003J\u001e\u0010s\u001a\b\u0012\u0004\u0012\u00020f0t2\u0006\u0010+\u001a\u00020\r2\u0006\u0010N\u001a\u00020OH\u0002J\u0012\u0010u\u001a\u0004\u0018\u0001082\u0006\u0010N\u001a\u00020OH\u0002J\u001a\u0010v\u001a\u00020:2\b\u0010,\u001a\u0004\u0018\u00010\u00052\u0006\u0010w\u001a\u00020\rH\u0002J\u0012\u0010x\u001a\u00020:2\b\u0010,\u001a\u0004\u0018\u00010\u0005H\u0002J \u0010y\u001a\u00020:2\u0006\u0010+\u001a\u00020\r2\u0006\u0010N\u001a\u00020O2\u0006\u0010z\u001a\u00020\rH\u0002J\u0018\u0010{\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\r2\u0006\u0010N\u001a\u00020OH\u0002J\u0018\u0010|\u001a\u00020\r2\u0006\u0010+\u001a\u00020\r2\u0006\u0010N\u001a\u00020OH\u0002J\u0010\u0010}\u001a\u00020\u00052\u0006\u0010N\u001a\u00020OH\u0002J\u0018\u0010~\u001a\u0004\u0018\u00010\u0005*\u0002082\b\b\u0002\u0010=\u001a\u00020>H\u0002J\u0014\u0010\u007f\u001a\u00020\u0005*\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0003\u0010\u0080\u0001J\u0019\u0010\u0081\u0001\u001a\u0004\u0018\u00010R*\u0002082\b\b\u0002\u0010=\u001a\u00020>H\u0002J$\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u0001*\u0002082\b\u0010e\u001a\u0004\u0018\u00010f2\b\b\u0002\u0010=\u001a\u00020>H\u0002J&\u0010\u0084\u0001\u001a\u0004\u0018\u00010f*\u0004\u0018\u00010f2\n\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0086\u00012\u0007\u0010\u0087\u0001\u001a\u00020:H\u0002J\u0016\u0010\u0088\u0001\u001a\u00020f*\u00020f2\u0007\u0010\u0089\u0001\u001a\u00020RH\u0002J\u001b\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00052\u0006\u0010+\u001a\u00020\r2\u0006\u0010N\u001a\u00020OH\u0002J\u0011\u0010\u008b\u0001\u001a\u00020\r2\u0006\u0010+\u001a\u00020\rH\u0002J\u0019\u0010\u008c\u0001\u001a\u00020\r2\u0006\u0010+\u001a\u00020\r2\u0006\u0010N\u001a\u00020OH\u0002J\u0011\u0010\u008d\u0001\u001a\u00020\r2\u0006\u0010N\u001a\u00020OH\u0002J\u0011\u0010\u008e\u0001\u001a\u00020'2\u0006\u0010`\u001a\u00020\u0015H\u0002JK\u0010\u008f\u0001\u001a\u00020'2\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u00052\t\b\u0002\u0010\u0090\u0001\u001a\u00020\u000b2\u001f\u0010\u0091\u0001\u001a\u001a\b\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020'0\u0093\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0092\u0001H\u0002¢\u0006\u0003\u0010\u0094\u0001J\u001b\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u00162\u0006\u0010`\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u0005H\u0002J,\u0010\u0096\u0001\u001a\u00020'2\u0006\u0010`\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\r2\b\u0010N\u001a\u0004\u0018\u00010O2\u0007\u0010\u0097\u0001\u001a\u00020\u0005H\u0002J\u0011\u0010\u0098\u0001\u001a\u00020'2\u0006\u0010`\u001a\u00020\u0015H\u0002J\u0010\u0010\u0099\u0001\u001a\t\u0012\u0004\u0012\u00020\u00150\u009a\u0001H\u0002J\u0011\u0010\u009b\u0001\u001a\u00020:2\u0006\u0010(\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006¢\u0001"}, d2 = {"Lcom/obric/memorydata/memory/MemoryManagerWrapper;", "", "<init>", "()V", "TAG", "", "KEY_IMAGE_ITEM_URI", "KEY_IMAGE_ITEM_HASH", "URI_BITMAP_DECODE_SCALE", "", "URI_BITMAP_COMPRESS_SIZE_THRESHOLD", "", "URI_BITMAP_COMPRESS_MIN_SIDE_THRESHOLD", "", "URI_BITMAP_COMPRESS_MAX_SIDE_THRESHOLD", "URI_BITMAP_COMPRESS_MAX_PIXELS_THRESHOLD", "MAX_SHARE_IMAGE_SIZE", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "delayedRequests", "", "Lcom/obric/memorydata/memory/ui/settings/ShortcutMemoryConsentType;", "Lcom/obric/memorydata/memory/MemoryManagerWrapper$DelayedRequest;", "pendingConfirmRequest", "Lcom/obric/memorydata/memory/MemoryManagerWrapper$ConfirmRequest;", "onActionInFlight", "GATE_HOLD_TIMEOUT_MS", "BATCH_GATE_HOLD_TIMEOUT_BUFFER_MS", "GUIDE_COMPLETE_DELAY_MS", "gateEpoch", "memoryTaskDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "memoryTaskScope", "Lkotlinx/coroutines/CoroutineScope;", "uiScope", "controlScope", "tryAcquireGate", InfoRequestQPSOptTraceLogger.REASON, "releaseGate", "", URLDispatch.KEY_EPOCH, "registerMemoryAction", "showEnterpriseAccountNotSupported", "from", AILabCheckPermissionTask.KEY_SOURCE, "onShareIntent", "activity", "Landroid/app/Activity;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "runShareAuthChecks", "getShareCallerPackage", "getProxyActivity", "pluginActivity", "toPackageNameFromReferrer", "extractSingleShareUri", "Landroid/net/Uri;", "isShareUriSafe", "", "uri", "isImageUriSafe", "contentResolver", "Landroid/content/ContentResolver;", MemoryInfoSectionEditActivity.KIND_SCENE, "requireKnownSize", "knownSize", "knownMimeType", "(Landroid/content/ContentResolver;Landroid/net/Uri;Ljava/lang/String;ZLjava/lang/Long;Ljava/lang/String;)Z", "inspectImageUri", "Lcom/obric/memorydata/memory/MemoryManagerWrapper$ImageUriSafetyInfo;", "(Landroid/content/ContentResolver;Landroid/net/Uri;Ljava/lang/Long;Ljava/lang/String;)Lcom/obric/memorydata/memory/MemoryManagerWrapper$ImageUriSafetyInfo;", "getShareUriSize", "(Landroid/content/ContentResolver;Landroid/net/Uri;)Ljava/lang/Long;", "hasExpectedImageHeader", "finishShareWithError", "shouldConfirmBeforeGenerateMemory", "context", "Landroid/content/Context;", "bundle", "Landroid/os/Bundle;", "requestConfirmBeforeGenerateMemory", "preloadedBitmap", "Landroid/graphics/Bitmap;", "logContext", "Lcom/obric/memorydata/middleware/api/logging/LogContext;", "confirmPendingManualMemory", "startConfirmedMemory", Ext.KEY_REQUEST, "cancelPendingManualMemory", "debugTriggerMemoryAction", "takePendingConfirmRequest", "clearPendingConfirmRequest", "ignoreWhenLockScreen", "resolveShortcutMemoryConsentDecision", "Lcom/obric/memorydata/memory/ui/settings/ShortcutMemoryConsentDecision;", "onShortcutConsentAccepted", "type", "onShortcutConsentCancelled", "onActionReal", "delayed", "shouldSkipByImageUriSafetyCheck", "imageInfo", "Lcom/obric/memorydata/memory/memoryentity/MemorySourceImageInfo;", "productType", "index", LBSLightLocationTraceLogger.TOTAL, "fallbackPackageName", "resolvePackageName", "Lcom/obric/memorydata/memory/MemoryManagerWrapper$ResolvedPackageName;", "shouldUseVisibleAssistantPackage", "isDelayedKeyShortcut", ObricMemoryConstants.KEY_PACKAGE_NAME, "currentTopPackage", "ensurePackageNameBeforeDecision", "getBitmap", "getSourceImageInfoList", "", "getPrimaryImageUri", "isCameraGalleryImageSource", "imageType", "isGalleryEditSource", "shouldCollectGalleryDocumentResult", "imageCount", "resolveGateTimeoutMs", "getCameraGalleryImageListCount", "cameraGalleryTypeName", "toContentMd5", "toReadableSizeLog", "(Ljava/lang/Long;)Ljava/lang/String;", "toBitmap", "toBitmapResult", "Lcom/obric/memorydata/memory/MemoryManagerWrapper$UriBitmapResult;", "withDecodeMeta", "meta", "Lcom/obric/memorydata/memory/MemoryManagerWrapper$UriImageMeta;", "compressed", "withPreloadedBitmapMeta", "bitmap", "getText", "actionFromToTrackType", "actionFromToProductType", "actionFromToProductTypeByLegacyImageType", "delayGenerateMemory", "launchGatedMemoryTask", "gateTimeoutMs", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(JLjava/lang/String;JLkotlin/jvm/functions/Function1;)V", "takeDelayedRequest", "setDelayedCache", "logId", "clearDelayedCache", "pendingConsentTypes", "", "isGateHeldBy", "DelayedRequest", "ConfirmRequest", "ResolvedPackageName", "UriBitmapResult", "ImageUriSafetyInfo", "UriImageMeta", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f11572a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static AtomicBoolean f11573b;
    private static final Map<ShortcutMemoryConsentType, b> c = null;
    private static volatile a d;
    private static final AtomicBoolean e = null;
    private static volatile long f;
    private static final bm g = null;
    private static final al h = null;
    private static final al i = null;
    private static final al j = null;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/memory/MemoryManagerWrapper$ConfirmRequest;", "", "from", "", "bundle", "Landroid/os/Bundle;", "preloadedBitmap", "Landroid/graphics/Bitmap;", "logContext", "Lcom/obric/memorydata/middleware/api/logging/LogContext;", "<init>", "(ILandroid/os/Bundle;Landroid/graphics/Bitmap;Lcom/obric/memorydata/middleware/api/logging/LogContext;)V", "getFrom", "()I", "getBundle", "()Landroid/os/Bundle;", "getPreloadedBitmap", "()Landroid/graphics/Bitmap;", "getLogContext", "()Lcom/obric/memorydata/middleware/api/logging/LogContext;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f11574a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Bundle f11575b;
        private final Bitmap c;
        private final com.obric.memorydata.middleware.api.logging.e d;

        public a(int r2, Bundle r3, Bitmap r4, com.obric.memorydata.middleware.api.logging.e r5) {
            Intrinsics.checkNotNullParameter(r3, "bundle");
            Intrinsics.checkNotNullParameter(r5, "logContext");
            this.f11574a = r2;
            this.f11575b = r3;
            this.c = r4;
            this.d = r5;
        }

        public final int a() {
            return this.f11574a;
        }

        public final Bundle b() {
            return this.f11575b;
        }

        public final Bitmap c() {
            return this.c;
        }

        public final com.obric.memorydata.middleware.api.logging.e d() {
            return this.d;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (this.f11574a == r6.f11574a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f11575b, r6.f11575b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r0 = ((Integer.hashCode(this.f11574a) * 31) + this.f11575b.hashCode()) * 31;
            Bitmap r1 = this.c;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((r0 + r2) * 31) + this.d.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "ConfirmRequest(from=" + this.f11574a + ", bundle=" + this.f11575b + ", preloadedBitmap=" + this.c + ", logContext=" + this.d + ')';
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/memory/MemoryManagerWrapper$DelayedRequest;", "", "from", "", "bundle", "Landroid/os/Bundle;", "logContext", "Lcom/obric/memorydata/middleware/api/logging/LogContext;", "<init>", "(ILandroid/os/Bundle;Lcom/obric/memorydata/middleware/api/logging/LogContext;)V", "getFrom", "()I", "getBundle", "()Landroid/os/Bundle;", "getLogContext", "()Lcom/obric/memorydata/middleware/api/logging/LogContext;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f11576a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Bundle f11577b;
        private final com.obric.memorydata.middleware.api.logging.e c;

        public b(int r2, Bundle r3, com.obric.memorydata.middleware.api.logging.e r4) {
            Intrinsics.checkNotNullParameter(r3, "bundle");
            Intrinsics.checkNotNullParameter(r4, "logContext");
            this.f11576a = r2;
            this.f11577b = r3;
            this.c = r4;
        }

        public final int a() {
            return this.f11576a;
        }

        public final Bundle b() {
            return this.f11577b;
        }

        public final com.obric.memorydata.middleware.api.logging.e c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (this.f11576a == r6.f11576a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f11577b, r6.f11577b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.f11576a) * 31) + this.f11577b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "DelayedRequest(from=" + this.f11576a + ", bundle=" + this.f11577b + ", logContext=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/memory/MemoryManagerWrapper$ImageUriSafetyInfo;", "", "size", "", "mimeType", "", "<init>", "(Ljava/lang/Long;Ljava/lang/String;)V", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMimeType", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/String;)Lcom/obric/memorydata/memory/MemoryManagerWrapper$ImageUriSafetyInfo;", "equals", "", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Long f11578a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f11579b;

        public c(Long r1, String r2) {
            this.f11578a = r1;
            this.f11579b = r2;
        }

        public final Long a() {
            return this.f11578a;
        }

        public final String b() {
            return this.f11579b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f11578a, r6.f11578a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f11579b, r6.f11579b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            Long r0 = this.f11578a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.f11579b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "ImageUriSafetyInfo(size=" + this.f11578a + ", mimeType=" + this.f11579b + ')';
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/memory/MemoryManagerWrapper$ResolvedPackageName;", "", "finalPackageName", "", AILabCheckPermissionTask.KEY_SOURCE, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getFinalPackageName", "()Ljava/lang/String;", "getSource", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f11580a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f11581b;

        public d(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, AILabCheckPermissionTask.KEY_SOURCE);
            this.f11580a = r2;
            this.f11581b = r3;
        }

        public final String a() {
            return this.f11580a;
        }

        public final String b() {
            return this.f11581b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f11580a, r6.f11580a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f11581b, r6.f11581b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            String r0 = this.f11580a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + this.f11581b.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "ResolvedPackageName(finalPackageName=" + this.f11580a + ", source=" + this.f11581b + ')';
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/memory/MemoryManagerWrapper$UriBitmapResult;", "", "bitmap", "Landroid/graphics/Bitmap;", "imageInfo", "Lcom/obric/memorydata/memory/memoryentity/MemorySourceImageInfo;", "<init>", "(Landroid/graphics/Bitmap;Lcom/obric/memorydata/memory/memoryentity/MemorySourceImageInfo;)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getImageInfo", "()Lcom/obric/memorydata/memory/memoryentity/MemorySourceImageInfo;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Bitmap f11582a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.obric.memorydata.memory.memoryentity.e f11583b;

        public e(Bitmap r2, com.obric.memorydata.memory.memoryentity.e r3) {
            Intrinsics.checkNotNullParameter(r2, "bitmap");
            this.f11582a = r2;
            this.f11583b = r3;
        }

        public final Bitmap a() {
            return this.f11582a;
        }

        public final com.obric.memorydata.memory.memoryentity.e b() {
            return this.f11583b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f11582a, r6.f11582a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f11583b, r6.f11583b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = this.f11582a.hashCode() * 31;
            com.obric.memorydata.memory.memoryentity.e r1 = this.f11583b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "UriBitmapResult(bitmap=" + this.f11582a + ", imageInfo=" + this.f11583b + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\r\b\u0082\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J:\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"Lcom/obric/memorydata/memory/MemoryManagerWrapper$UriImageMeta;", "", "mimeType", "", "size", "", "width", "", "height", "<init>", "(Ljava/lang/String;Ljava/lang/Long;II)V", "getMimeType", "()Ljava/lang/String;", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getWidth", "()I", "getHeight", "shouldCompress", "", "getShouldCompress", "()Z", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Long;II)Lcom/obric/memorydata/memory/MemoryManagerWrapper$UriImageMeta;", "equals", "other", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f11584a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Long f11585b;
        private final int c;
        private final int d;

        public f(String r1, Long r2, int r3, int r4) {
            this.f11584a = r1;
            this.f11585b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final String a() {
            return this.f11584a;
        }

        public final Long b() {
            return this.f11585b;
        }

        public final int c() {
            return this.c;
        }

        public final int d() {
            return this.d;
        }

        public final boolean e() {
            int r0 = Math.min(this.c, this.d);
            int r1 = Math.max(this.c, this.d);
            long r2 = ((long) this.c) * ((long) this.d);
            if (r1 <= 2560) goto L5;
        L8:
            boolean r3 = true;
        L9:
            Long r8 = this.f11585b;
            if (r8 == null) goto L12;
            long r4 = r8.longValue();
        L14:
            if (r4 > PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) goto L16;
        L18:
            boolean r9 = false;
        L19:
            if (r3 == true) goto L22;
            if (r9 == true) goto L22;
            return false;
        L22:
            return true;
        L16:
            if (r0 <= 1080) goto L18;
            r9 = true;
            goto L19
        L12:
            r4 = 0;
            goto L14
        L5:
            if (r2 > 4000000) goto L8;
            r3 = false;
            goto L9
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
            return false;
        L8:
            f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f11584a, r6.f11584a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f11585b, r6.f11585b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            String r0 = this.f11584a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Long r4 = this.f11585b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return ((((r3 + r1) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d);
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "UriImageMeta(mimeType=" + this.f11584a + ", size=" + this.f11585b + ", width=" + this.c + ", height=" + this.d + ')';
        }
    }

    static {
        f11572a = new v();
        f11573b = new AtomicBoolean(false);
        c = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        e = new AtomicBoolean(false);
        ExecutorService r0 = Executors.newSingleThreadExecutor($$Lambda$v$FtOj6OudPfB4UY3fwwTmDdMqNVk.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(r0, "newSingleThreadExecutor(...)");
        bm r1 = bo.a(r0);
        g = r1;
        h = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(r1, CoroutineContext.class, "com.obric.memorydata.plugin")));
        i = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.b().a(), CoroutineContext.class, "com.obric.memorydata.plugin")));
        j = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.a(), CoroutineContext.class, "com.obric.memorydata.plugin")));
    }

    private v() {
    }

    public static final /* synthetic */ long a(v r0, int r1, Bundle r2) {
        return r0.b(r1, r2);
    }

    public static final /* synthetic */ long a(v r0, String r1) {
        return r0.a(r1);
    }

    private final synchronized long a(String r10) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (e.compareAndSet(false, true) == true) goto L9;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryManagerWrapper", "[gate] busy, drop, reason=" + r10, false, 4, null);     // Catch: Throwable -> L12
        monitor-exit(this);
        return -1;
    L9:
        f++;     // Catch: Throwable -> L12
        long r0 = f;     // Catch: Throwable -> L12
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryManagerWrapper", "[gate] acquired, epoch=" + r0 + ", reason=" + r10, false, 4, null);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r0;
    }

    private final Bitmap a(int r8, Bundle r9, String r10) {
        if (r8 != 0) goto L5;
    L13:
        Uri r7 = a(r9);
        if (r7 == null) goto L19;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryManagerWrapper", "image uri: " + r7, false, 4, null);
        return b(f11572a, r7, null, 1, null);
    L19:
        return null;
    L5:
        if (r8 != 3) goto L7;
    L11:
        if (r10 != null) goto L18;
        return null;
    L18:
        return com.obric.memorydata.utils.e.c.a(com.obric.memorydata.utils.e.c.f13216a, r10, null, 2, null);
    L7:
        if (r8 == 4) goto L11;
        if (r8 == 5) goto L13;
        return null;
    }

    public static final /* synthetic */ Bitmap a(v r0, Uri r1, ContentResolver r2) {
        return r0.b(r1, r2);
    }

    private final Uri a(Bundle r7) {
        ArrayList r6 = com.obric.memorydata.utils.c.a.f13197a.b(r7, "com.aiassistant.memorydata.EXTRA_IMAGE_LIST", Bundle.class);
        if (r6 == null) goto L17;
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L5:
        Uri r2 = null;
        if (r8.hasNext() == false) goto L14;
        Bundle r1 = (Bundle) ZeusTransformUtils.preCheckCast(r8.next(), Bundle.class, "com.obric.memorydata.plugin");
        Uri r3 = (Uri) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.c.a.f13197a.a(r1, "uri", Uri.class), Uri.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L12;
        String r4 = r1.getString("uri");
        if (r4 == null) goto L13;
        r2 = Uri.parse(r4);
    L13:
        if (r2 == null) goto L5;
    L12:
        r2 = r3;
    L14:
        if (r2 == null) goto L17;
        return r2;
    L17:
        return (Uri) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.c.a.f13197a.a(r7, "com.aiassistant.memorydata.EXTRA_IMAGE_URI", Uri.class), Uri.class, "com.obric.memorydata.plugin");
    }

    private final com.obric.memorydata.memory.memoryentity.e a(com.obric.memorydata.memory.memoryentity.e r19, Bitmap r20) {
        int r0 = Math.min(r20.getWidth(), r20.getHeight());
        int r1 = Math.max(r20.getWidth(), r20.getHeight());
        long r2 = ((long) r20.getWidth()) * ((long) r20.getHeight());
        if (r1 <= 2560) goto L5;
    L16:
        boolean r3 = true;
    L17:
        Integer r4 = r19.g();
        if (r4 == null) goto L20;
        int r5 = r4.intValue();
    L21:
        Integer r13 = Integer.valueOf(r5);
        Integer r6 = r19.h();
        if (r6 == null) goto L24;
        int r7 = r6.intValue();
    L25:
        Integer r14 = Integer.valueOf(r7);
        if (r19.i() == true) goto L30;
        if (r3 == true) goto L30;
        boolean r15 = false;
    L32:
        return com.obric.memorydata.memory.memoryentity.e.a(r19, null, null, null, 0, null, null, r13, r14, r15, 63, null);
    L30:
        r15 = true;
        goto L32
    L24:
        r7 = r20.getHeight();
        goto L25
    L20:
        r5 = r20.getWidth();
        goto L21
    L5:
        if (r2 > 4000000) goto L16;
        Long r8 = r19.f();
        if (r8 == null) goto L9;
        long r9 = r8.longValue();
    L11:
        if (r9 > PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) goto L13;
    L15:
        r3 = false;
        goto L17
    L13:
        if (r0 <= 1080) goto L15;
    L9:
        r9 = 0;
        goto L11
    }

    private final com.obric.memorydata.memory.memoryentity.e a(com.obric.memorydata.memory.memoryentity.e r13, f r14, boolean r15) {
        if (r13 != null) goto L6;
        return null;
    L6:
        if (r14 == null) goto L9;
        String r12 = r14.a();
        if (r12 == null) goto L9;
    L10:
        String r5 = r12;
        if (r14 == null) goto L14;
        Long r16 = r14.b();
        if (r16 == null) goto L14;
    L15:
        Long r6 = r16;
        if (r14 == null) goto L18;
        Integer r17 = Integer.valueOf(r14.c());
    L19:
        Integer r7 = r17;
        if (r14 == null) goto L22;
        Integer r18 = Integer.valueOf(r14.d());
    L24:
        return com.obric.memorydata.memory.memoryentity.e.a(r13, null, null, null, 0, r5, r6, r7, r18, r15, 15, null);
    L22:
        r18 = r13.h();
        goto L24
    L18:
        r17 = r13.g();
    L14:
        r16 = r13.f();
    L9:
        r12 = r13.e();
        goto L10
    }

    private final b a(ShortcutMemoryConsentType r9, String r10) {
        monitor-enter(this);
        b r0 = (b) ZeusTransformUtils.preCheckCast(c.remove(r9), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r0 != null) goto L6;
        r0 = null;
    L7:
        monitor-exit(this);
        return r0;
    L6:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryManagerWrapper", "take delayed request, type=" + r9 + ", reason=" + r10 + ", from=" + r0.a(), false, 4, null);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private final c a(ContentResolver r5, Uri r6, Long r7, String r8) {
    L12:
        e = e;
        RunLog r9 = RunLog.INSTANCE;
        StringBuilder r10 = new StringBuilder();
        String r11 = "No permission for uri: ";
    L14:
        r9.error("MemoryManagerWrapper", r10.append(r11).append(r6).toString(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    L10:
        e = e;
        r9 = RunLog.INSTANCE;
        r10 = new StringBuilder();
        r11 = "Inspect uri failed: ";
        goto L14
    L4:
        if (r7 != null) goto L6;
        r7 = a(r5, r6);     // Catch: Exception -> L10 SecurityException -> L12
    L6:
        if (r8 != null) goto L8;
        r8 = ZeusProviderTransform.getType(r5, r6, "com.obric.memorydata.plugin");     // Catch: Exception -> L10 SecurityException -> L12
    L8:
    L18:
        return new c(r7, r8);
    }

    private final d a(int r9, Bundle r10, boolean r11) {
        String r12 = com.obric.memorydata.utils.c.a.f13197a.a(r10, "com.aiassistant.memorydata.EXTRA_PACKAGE");
        String r0 = null;
        if (r12 != null) goto L5;
        String r1 = a(r11);
    L7:
        if (r9 != 4) goto L10;
        if (r11 == false) goto L10;
        boolean r13 = true;
    L11:
        if (r13 == false) goto L15;
        ComponentName r14 = com.obric.memorydata.utils.ba.b();
        if (r14 == null) goto L15;
        r0 = r14.getPackageName();
    L15:
        if (r12 == null) goto L19;
        r1 = r12;
    L19:
        if (a(r13, r1, r0) == false) goto L22;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryManagerWrapper", "correct delayed key package by current top, rawPackage=" + r1 + ", currentTopPackage=" + r0, false, 4, null);
        return new d(r0, "corrected_delayed_key_top");
    L22:
        if (r12 == null) goto L24;
        String r15 = WsConstants.KEY_EXTRA;
    L26:
        return new d(r1, r15);
    L24:
        r15 = "fallback";
    L10:
        r13 = false;
        goto L11
    L5:
        r1 = null;
        goto L7
    }

    private final e a(final Uri r25, final com.obric.memorydata.memory.memoryentity.e r26, final ContentResolver r27) {
        long r11 = SystemClock.elapsedRealtime();
    L101:
        e = e;
        String r4 = "MemoryManagerWrapper";
    L103:
        e r1 = null;
    L104:
        RunLog r2 = RunLog.INSTANCE;
        String r3 = "Uri to Bitmap failed: " + r25;
        Throwable r0 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin");
    L105:
        r2.error(r4, r3, r0);
    L107:
        return r1;
    L97:
        e = e;
        String r17 = "MemoryManagerWrapper";
    L99:
        r1 = null;
    L100:
        r2 = RunLog.INSTANCE;
        r3 = "Uri to Bitmap OOM: " + r25;
        r0 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin");
        r4 = r17;
        goto L105
    L110:
        if (Build.VERSION.SDK_INT < 28) goto L13;
        ImageDecoder.Source r5 = ImageDecoder.createSource(r27, r25);     // Catch: OutOfMemoryError -> L97 Exception -> L101
        Intrinsics.checkNotNullExpressionValue(r5, "createSource(...)");     // Catch: OutOfMemoryError -> L97 Exception -> L101
        final Ref.ObjectRef r6 = new Ref.ObjectRef();     // Catch: OutOfMemoryError -> L97 Exception -> L101
        final Ref.BooleanRef r7 = new Ref.BooleanRef();     // Catch: OutOfMemoryError -> L97 Exception -> L101
    L9:
        Bitmap r8 = ImageDecoder.decodeBitmap(r5, new $$Lambda$v$1RM4f8M0wS5Qk1G6pfWaLPcESkQ(r6, r26, r25, r7, r27));     // Catch: Exception -> L31 OutOfMemoryError -> L92
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryManagerWrapper", "Uri to Bitmap success: size=" + r8.getWidth() + 'x' + r8.getHeight() + ", cost=" + (SystemClock.elapsedRealtime() - r11) + "ms, uri=" + r25, false, 4, null);     // Catch: Exception -> L31 OutOfMemoryError -> L92
        Intrinsics.checkNotNullExpressionValue(r8, "also(...)");     // Catch: Exception -> L31 OutOfMemoryError -> L92
        r1 = new e(r8, a(r26, (f) ZeusTransformUtils.preCheckCast(r6.element, f.class, "com.obric.memorydata.plugin"), r7.element));     // Catch: Exception -> L31 OutOfMemoryError -> L92
    L11:
        e = e;
    L32:
        r4 = "MemoryManagerWrapper";
        goto L103
    L13:
        r17 = "MemoryManagerWrapper";
        BitmapFactory.Options r9 = new BitmapFactory.Options();     // Catch: OutOfMemoryError -> L92 Exception -> L94
        int r10 = 1;
        r9.inJustDecodeBounds = true;     // Catch: OutOfMemoryError -> L92 Exception -> L94
        InputStream r12 = r27.openInputStream(r25);     // Catch: OutOfMemoryError -> L92 Exception -> L94
        if (r12 == null) goto L34;
        Closeable r13 = (Closeable) ZeusTransformUtils.preCheckCast(r12, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L31 OutOfMemoryError -> L92
        BitmapFactory.decodeStream((InputStream) ZeusTransformUtils.preCheckCast(r13, InputStream.class, "com.obric.memorydata.plugin"), null, r9);     // Catch: Throwable -> L24
        CloseableKt.closeFinally(r13, null);     // Catch: OutOfMemoryError -> L20 Exception -> L22
    L22:
        e = e;
        r1 = null;
    L96:
        r4 = r17;
    L20:
        e = e;
        r1 = null;
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        CloseableKt.closeFinally(r13, th);     // Catch: Exception -> L31 OutOfMemoryError -> L92
        throw th;     // Catch: Exception -> L31 OutOfMemoryError -> L92
    L34:
        if (r9.outWidth > 0) goto L36;
    L89:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryManagerWrapper", "Uri to Bitmap skipped: invalid bounds " + r9.outWidth + 'x' + r9.outHeight + ", uri=" + r25, null, 4, null);     // Catch: OutOfMemoryError -> L92 Exception -> L94
        return null;
    L36:
        if (r9.outHeight <= 0) goto L89;
        if (r26 == null) goto L125;
        String r14 = r26.e();     // Catch: Exception -> L31 OutOfMemoryError -> L92
        if (r14 == null) goto L125;
    L42:
        String r15 = r14;
        if (r26 == null) goto L119;
        Long r16 = r26.f();     // Catch: Exception -> L31 OutOfMemoryError -> L92
        if (r16 == null) goto L119;
    L62:
        f r18 = new f(r15, r16, r9.outWidth, r9.outHeight);     // Catch: Exception -> L31 OutOfMemoryError -> L92
        r9.inJustDecodeBounds = false;     // Catch: Exception -> L31 OutOfMemoryError -> L92
        if (r18.e() == false) goto L65;
        r10 = 2;
    L65:
        r9.inSampleSize = r10;     // Catch: Exception -> L31 OutOfMemoryError -> L92
        InputStream r19 = r27.openInputStream(r25);     // Catch: Exception -> L31 OutOfMemoryError -> L92
        if (r19 == null) goto L84;
        Closeable r20 = (Closeable) ZeusTransformUtils.preCheckCast(r19, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L31 OutOfMemoryError -> L92
        Bitmap r21 = BitmapFactory.decodeStream((InputStream) ZeusTransformUtils.preCheckCast(r20, InputStream.class, "com.obric.memorydata.plugin"), null, r9);     // Catch: Throwable -> L77
        CloseableKt.closeFinally(r20, null);     // Catch: OutOfMemoryError -> L73 Exception -> L75
        if (r21 == null) goto L84;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryManagerWrapper", "Uri to Bitmap success: " + r9.outWidth + 'x' + r9.outHeight + " -> " + r21.getWidth() + 'x' + r21.getHeight() + ", inSampleSize=" + r9.inSampleSize + ", compressed=" + r18.e() + ", fileSize=" + f11572a.a(r18.b()) + ", mime=" + r18.a() + ", cost=" + (SystemClock.elapsedRealtime() - r11) + "ms, uri=" + r25, false, 4, null);     // Catch: Exception -> L31 OutOfMemoryError -> L92
    L85:
        if (r21 != null) goto L131;
        return null;
    L131:
        return new e(r21, f11572a.a(r26, r18, r18.e()));
    L75:
        e = e;
        r1 = null;
    L73:
        e = e;
        r1 = null;
    L77:
        th = move-exception;
        throw th;     // Catch: Throwable -> L80
    L80:
        th = move-exception;
        CloseableKt.closeFinally(r20, th);     // Catch: Exception -> L31 OutOfMemoryError -> L92
        throw th;     // Catch: Exception -> L31 OutOfMemoryError -> L92
    L84:
        r21 = null;
    L119:
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L56
        Object r23 = Result.m1421constructorimpl(f11572a.a(r27, r25));     // Catch: Throwable -> L56
    L59:
        if (Result.m1427isFailureimpl(r23) == false) goto L61;
        r23 = null;
    L61:
        r16 = (Long) ZeusTransformUtils.preCheckCast(r23, Long.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L31 OutOfMemoryError -> L92
    L56:
        th = move-exception;
        Result.Companion r24 = Result.Companion;     // Catch: Exception -> L31 OutOfMemoryError -> L92
        r23 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L31 OutOfMemoryError -> L92
    L125:
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L45
        Object r29 = Result.m1421constructorimpl(ZeusProviderTransform.getType(r27, r25, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L45
    L48:
        if (Result.m1427isFailureimpl(r29) == false) goto L50;
        r29 = null;
    L50:
        r14 = (String) ZeusTransformUtils.preCheckCast(r29, String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L31 OutOfMemoryError -> L92
    L45:
        th = move-exception;
        Result.Companion r30 = Result.Companion;     // Catch: Exception -> L31 OutOfMemoryError -> L92
        r29 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L31 OutOfMemoryError -> L92
    L94:
        e = e;
        r1 = null;
    L92:
        e = e;
    L31:
        e = e;
        goto L32
    }

    static /* synthetic */ e a(v r0, Uri r1, com.obric.memorydata.memory.memoryentity.e r2, ContentResolver r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r3 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver();
    L6:
        return r0.a(r1, r2, r3);
    }

    private static final CharSequence a(byte r3) {
        String r4 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r3)}, 1));
        Intrinsics.checkNotNullExpressionValue(r4, "format(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
    }

    private final Long a(ContentResolver r8, Uri r9) {
        Cursor r0 = ZeusProviderTransform.query(r8, r9, new String[]{"_size"}, null, null, null, "com.obric.memorydata.plugin");
        if (r0 == null) goto L21;
        Closeable r1 = (Closeable) ZeusTransformUtils.preCheckCast(r0, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r5 = (Cursor) ZeusTransformUtils.preCheckCast(r1, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        if (r5.moveToFirst() == false) goto L14;
        int r7 = r5.getColumnIndex("_size");     // Catch: Throwable -> L16
        if (r7 < 0) goto L14;
        long r6 = r5.getLong(r7);     // Catch: Throwable -> L16
        if (r6 < 0) goto L14;
        Long r10 = Long.valueOf(r6);     // Catch: Throwable -> L16
        CloseableKt.closeFinally(r1, null);
        return r10;
    L14:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L16
        CloseableKt.closeFinally(r1, null);
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);
        throw th;
    L21:
        ParcelFileDescriptor r12 = r8.openFileDescriptor(r9, "r");
        if (r12 == null) goto L38;
        Closeable r13 = (Closeable) ZeusTransformUtils.preCheckCast(r12, Closeable.class, "com.obric.memorydata.plugin");
        Long r14 = Long.valueOf(((ParcelFileDescriptor) ZeusTransformUtils.preCheckCast(r13, ParcelFileDescriptor.class, "com.obric.memorydata.plugin")).getStatSize());     // Catch: Throwable -> L33
        if (((Number) ZeusTransformUtils.preCheckCast(r14, Number.class, "com.obric.memorydata.plugin")).longValue() < 0) goto L28;
        boolean r15 = true;
    L29:
        if (r15 == true) goto L32;
        r14 = null;
    L32:
        CloseableKt.closeFinally(r13, null);
        return r14;
    L28:
        r15 = false;
    L33:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        CloseableKt.closeFinally(r13, th);
        throw th;
    L38:
        return null;
    }

    private final String a(Activity r10) {
        Activity r11 = (Activity) ZeusTransformUtils.wrapperContextForParams(r10, Activity.class, "com.obric.memorydata.plugin");
        Activity r0 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b(r11), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = r11;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryManagerWrapper", "getShareCallerPackage --> activity: " + r11 + ", actualActivity: " + r0, false, 4, null);
        Field r2 = Activity.class.getDeclaredField("mReferrer");     // Catch: Exception -> L13
        r2.setAccessible(true);     // Catch: Exception -> L13
        Object r1 = r2.get(r0);     // Catch: Exception -> L13
        if (ZeusTransformUtils.instanceOf(r1, String.class) == false) goto L9;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L13
    L10:
        if (r3 == null) goto L18;
        return b(r3);
    L18:
        return null;
    L9:
        r3 = null;
    L13:
        e = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryManagerWrapper", "Read Activity.mReferrer failed: " + e.getMessage(), null, 4, null);
        return null;
    }

    private final String a(Intent r6) {
        String r5 = r6.getAction();
        if (Intrinsics.areEqual(r5, "android.intent.action.SEND") == true) goto L7;
        StringBuilder r7 = new StringBuilder().append("invalid action: ").append(r5);
    L6:
        return r7.toString();
    L7:
        String r8 = r6.getType();
        boolean r0 = true;
        if (r8 != null) goto L10;
    L12:
        r0 = false;
    L13:
        if (r0 == true) goto L16;
        r7 = new StringBuilder().append("invalid mime: ").append(r6.getType());
        goto L6
    L16:
        if (r6.hasExtra("android.intent.extra.STREAM") == true) goto L19;
        return "no EXTRA_STREAM";
    L19:
        return null;
    L10:
        if (StringsKt.startsWith$default(r8, "image/", false, 2, null) != true) goto L12;
        goto L12
    }

    private final String a(Uri r22, ContentResolver r23) {
        long r6 = SystemClock.elapsedRealtime();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r1 = Result.m1421constructorimpl(f11572a.a(r23, r22));     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r1) == false) goto L10;
        r1 = null;
    L10:
        Long r8 = (Long) ZeusTransformUtils.preCheckCast(r1, Long.class, "com.obric.memorydata.plugin");
        MessageDigest r2 = MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5);     // Catch: Exception -> L30
        InputStream r3 = r23.openInputStream(r22);     // Catch: Exception -> L30
        if (r3 != null) goto L15;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryManagerWrapper", "Uri to md5 skipped: inputStream is null, size=" + a(r8) + ", cost=" + (SystemClock.elapsedRealtime() - r6) + "ms, uri=" + r22, null, 4, null);     // Catch: Exception -> L30
        return null;
    L15:
        Closeable r4 = (Closeable) ZeusTransformUtils.preCheckCast(r3, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L30
        InputStream r11 = (InputStream) ZeusTransformUtils.preCheckCast(r4, InputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        byte[] r12 = new byte[8192];     // Catch: Throwable -> L23
    L17:
        int r13 = r11.read(r12);     // Catch: Throwable -> L23
        if (r13 <= 0) goto L20;
        r2.update(r12, 0, r13);     // Catch: Throwable -> L23
        goto L17
    L20:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L23
        CloseableKt.closeFinally(r4, null);     // Catch: Exception -> L30
        byte[] r15 = r2.digest();     // Catch: Exception -> L30
        Intrinsics.checkNotNullExpressionValue(r15, "digest(...)");     // Catch: Exception -> L30
        String r5 = ArraysKt.joinToString$default(r15, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$v$Ntpz36crtHJnX56XEvCtJgu4OA.INSTANCE, 30, null);     // Catch: Exception -> L30
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryManagerWrapper", "Uri to md5 success: size=" + a(r8) + ", cost=" + (SystemClock.elapsedRealtime() - r6) + "ms, uri=" + r22, false, 4, null);     // Catch: Exception -> L30
        return r5;
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);     // Catch: Exception -> L30
        throw th;     // Catch: Exception -> L30
    L30:
        e = move-exception;
        RunLog.INSTANCE.error("MemoryManagerWrapper", "Uri to md5 failed: size=" + a(r8) + ", cost=" + (SystemClock.elapsedRealtime() - r6) + "ms, uri=" + r22, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    L5:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r1 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    static /* synthetic */ String a(v r0, Uri r1, ContentResolver r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver();
    L6:
        return r0.a(r1, r2);
    }

    private final String a(Long r9) {
        if (r9 == null) goto L15;
        long r8 = r9.longValue();
        if (r8 < 1024) goto L6;
        String[] r0 = {"KB", "MB", "GB"};
        double r1 = r8;
        int r3 = -1;
    L9:
        if (r1 < 1024.0d) goto L13;
        if (r3 >= ArraysKt.getLastIndex(r0)) goto L13;
        r1 = r1 / 1024.0d;
        r3 = r3 + 1;
    L13:
        StringCompanionObject r4 = StringCompanionObject.INSTANCE;
        String r10 = String.format(Locale.US, "%.2f %s(%d bytes)", Arrays.copyOf(new Object[]{Double.valueOf(r1), r0[r3], Long.valueOf(r8)}, 3));
        Intrinsics.checkNotNullExpressionValue(r10, "format(...)");
        return r10;
    L6:
        return r8 + " bytes";
    L15:
        return "unknown";
    }

    private final String a(boolean r1) {
        if (r1 == false) goto L7;
        ComponentName r2 = com.obric.memorydata.utils.ba.e();
        if (r2 != null) goto L10;
        return null;
    L10:
        return r2.getPackageName();
    L7:
        r2 = com.obric.memorydata.utils.ba.b();
        if (r2 != null) goto L10;
        return null;
    }

    private static final Thread a(Runnable r2) {
        Thread r0 = new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin"), "MemoryShortcutQueue");
        r0.setDaemon(true);
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v53, types: [com.obric.memorydata.memory.v] */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v7, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r3v8, types: [android.net.Uri] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final List<com.obric.memorydata.memory.memoryentity.e> a(int r25, Bundle r26) {
        String r4 = com.obric.memorydata.utils.c.a.f13197a.a(r26, "com.aiassistant.memorydata.EXTRA_SOURCE");
        boolean r7 = false;
        int r5 = com.obric.memorydata.utils.c.a.f13197a.a(r26, "com.aiassistant.memorydata.EXTRA_IMAGE_TYPE", 0);
        String r15 = "getContentResolver(...)";
        String r18 = "";
        String r14 = "toString(...)";
        com.obric.memorydata.memory.memoryentity.e r13 = null;
        String r12 = "com.obric.memorydata.plugin";
        if (r25 != 0) goto L49;
        if (a(r4, r5) == false) goto L49;
        ArrayList r8 = com.obric.memorydata.utils.c.a.f13197a.b(r26, "com.aiassistant.memorydata.EXTRA_IMAGE_LIST", Bundle.class);
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L9;
    L10:
        r7 = true;
    L11:
        if (r7 == true) goto L49;
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r0.iterator();
    L14:
        if (r2.hasNext() == false) goto L47;
        Bundle r3 = (Bundle) ZeusTransformUtils.preCheckCast(r2.next(), Bundle.class, r12);
        ?? r6 = (Uri) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.c.a.f13197a.a(r3, "uri", Uri.class), Uri.class, r12);
        if (r6 != 0) goto L23;
        String r10 = r3.getString("uri");
        if (r10 == null) goto L20;
        r6 = Uri.parse(r10);
    L21:
        if (r6 != 0) goto L23;
    L43:
        if (r13 == null) goto L45;
        r1.add(r13);
    L45:
        r14 = r14;
        r12 = r12;
        r15 = r15;
        r13 = null;
        goto L14
    L20:
        r6 = r13;
    L23:
        String r11 = r6.toString();
        Intrinsics.checkNotNullExpressionValue(r11, r14);
        String r16 = r3.getString("hash");
        if (r16 != null) goto L26;
        String r17 = "";
    L79:
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L29
        Object r20 = Result.m1421constructorimpl(ZeusProviderTransform.getType(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), r12), Context.class, r12)).getContentResolver(), r6, r12));     // Catch: Throwable -> L29
    L32:
        if (Result.m1427isFailureimpl(r20) == false) goto L34;
        r20 = r13;
    L34:
        String r110 = (String) ZeusTransformUtils.preCheckCast(r20, String.class, r12);
        ?? r21 = f11572a;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L37
        ContentResolver r23 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), r12), Context.class, r12)).getContentResolver();     // Catch: Throwable -> L37
        Intrinsics.checkNotNullExpressionValue(r23, r15);     // Catch: Throwable -> L37
        Object r24 = Result.m1421constructorimpl(r21.a(r23, r6));     // Catch: Throwable -> L37
    L40:
        if (Result.m1427isFailureimpl(r24) == false) goto L42;
        r24 = r13;
    L42:
        r13 = new com.obric.memorydata.memory.memoryentity.e(r11, r17, r4, r5, r110, (Long) ZeusTransformUtils.preCheckCast(r24, Long.class, r12), null, null, false, BDVideoUploaderBase.KeyIsDynamicSliceLowSize, null);
    L37:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r24 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L29:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r20 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L32
    L26:
        r17 = r16;
        goto L79
    L47:
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, r12);
    L9:
        if (r9.isEmpty() == false) goto L11;
    L49:
        if (r25 != 0) goto L51;
    L54:
        Uri r29 = a(r26);
        if (r29 == null) goto L57;
        String r30 = r29.toString();
        Intrinsics.checkNotNullExpressionValue(r30, "toString(...)");
        String r31 = a(this, r29, null, 1, null);
        if (r31 == null) goto L85;
        r18 = r31;
    L85:
        Result.Companion r32 = Result.Companion;     // Catch: Throwable -> L64
        v r33 = (v) ZeusTransformUtils.preCheckCast(this, v.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L64
        Object r34 = Result.m1421constructorimpl(ZeusProviderTransform.getType(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), r29, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L64
    L66:
        Object r111 = r34;
        if (Result.m1427isFailureimpl(r111) == false) goto L69;
        r111 = null;
    L69:
        String r112 = (String) ZeusTransformUtils.preCheckCast(r111, String.class, "com.obric.memorydata.plugin");
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L72
        v r36 = (v) ZeusTransformUtils.preCheckCast(this, v.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L72
        ContentResolver r37 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver();     // Catch: Throwable -> L72
        Intrinsics.checkNotNullExpressionValue(r37, "getContentResolver(...)");     // Catch: Throwable -> L72
        Object r38 = Result.m1421constructorimpl(r36.a(r37, r29));     // Catch: Throwable -> L72
    L74:
        Object r113 = r38;
        if (Result.m1427isFailureimpl(r113) == false) goto L78;
        r113 = null;
    L78:
        return CollectionsKt.listOf(new com.obric.memorydata.memory.memoryentity.e(r30, r18, r4, r5, r112, (Long) ZeusTransformUtils.preCheckCast(r113, Long.class, "com.obric.memorydata.plugin"), null, null, false, BDVideoUploaderBase.KeyIsDynamicSliceLowSize, null));
    L72:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        r38 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L64:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        r34 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L66
    L57:
        return CollectionsKt.emptyList();
    L51:
        if (r25 == 5) goto L54;
        return CollectionsKt.emptyList();
    }

    private static final Unit a(int r2, int r3, List r4, com.obric.memorydata.middleware.api.logging.g r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "$this$mainTrace");
        r5.a("from", Integer.valueOf(r2));
        r5.a("product_type", Integer.valueOf(r3));
        r5.a("item_total", Integer.valueOf(r6.size()));
        return Unit.INSTANCE;
    }

    private static final Unit a(int r2, int r3, List r4, Ref.IntRef r5, com.obric.memorydata.middleware.api.logging.g r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "$this$mainTrace");
        r6.a("from", Integer.valueOf(r2));
        r6.a("product_type", Integer.valueOf(r3));
        r6.a("item_total", Integer.valueOf(r7.size()));
        r6.a("dispatched_count", Integer.valueOf(r5.element));
        return Unit.INSTANCE;
    }

    private static final Unit a(int r1, com.obric.memorydata.middleware.api.logging.g r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$errorTrace");
        r2.a("from", Integer.valueOf(r1));
        return Unit.INSTANCE;
    }

    private static final Unit a(int r1, Throwable r2, com.obric.memorydata.middleware.api.logging.g r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$errorTrace");
        r3.a("from", Integer.valueOf(r1));
        r3.a(CommonConsts.LOG_REPORT_TYPE_EXCEPTION, r2.getClass().getSimpleName());
        return Unit.INSTANCE;
    }

    private static final Unit a(int r1, boolean r2, d r3, String r4, com.obric.memorydata.middleware.api.logging.g r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$mainTrace");
        r5.a("from", Integer.valueOf(r1));
        r5.a("delayed", Boolean.valueOf(r2));
        r5.a("package_source", r3.b());
        if (r4 == null) goto L5;
        boolean r6 = true;
    L6:
        r5.a("has_package", Boolean.valueOf(r6));
        return Unit.INSTANCE;
    L5:
        r6 = false;
        goto L6
    }

    private static final Unit a(Intent r3, com.obric.memorydata.middleware.api.logging.g r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$mainTrace");
        r4.a("from", 5);
        String r0 = r3.getAction();
        String r1 = "null";
        if (r0 != null) goto L5;
        r0 = "null";
    L5:
        r4.a("action", r0);
        String r5 = r3.getType();
        if (r5 == null) goto L9;
        r1 = r5;
    L9:
        r4.a("mime_type", r1);
        return Unit.INSTANCE;
    }

    private static final Unit a(a r1, com.obric.memorydata.middleware.api.logging.g r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$mainTrace");
        r2.a("from", Integer.valueOf(r1.a()));
        return Unit.INSTANCE;
    }

    private static final Unit a(com.obric.memorydata.middleware.api.logging.e r28, List r29, final int r30, int r31, Bitmap r32, Bundle r33, String r34, long r35) {
        final int r15 = r31;
        String r12 = "com.obric.memorydata.plugin";
        final List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r29, List.class, "com.obric.memorydata.plugin");
        Ref.IntRef r11 = new Ref.IntRef();
        com.obric.memorydata.middleware.api.logging.o.a((com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.a.f11610a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin"), "系统主动记忆图片输入批次已识别", "input_batch_ready", com.obric.memorydata.middleware.api.logging.e.a(r28, null, null, "route", 3, null), new $$Lambda$v$0J3VjvsYcyEZQrXd06XNAb2U6nw(r30, r15, r13), null, 16, null);
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r7 = 0;
    L4:
        if (r16.hasNext() == false) goto L20;
        Object r0 = r16.next();
        int r9 = r7 + 1;
        if (r7 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        com.obric.memorydata.memory.memoryentity.e r8 = (com.obric.memorydata.memory.memoryentity.e) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.memory.memoryentity.e.class, r12);
        long r23 = SystemClock.elapsedRealtime();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, r12), "MemoryManagerWrapper", "image memory item begin, from=" + r30 + ", productType=" + r15 + ", source=" + r8.c() + ", imageType=" + r8.d() + ", index=" + r9 + '/' + r13.size() + ", hash=" + r8.b(), false, 4, null);
        v r1 = f11572a;
        Ref.IntRef r210 = r11;
        List r25 = r13;
        if (r1.a(r8, r30, r31, r7, r13.size()) == false) goto L12;
        Ref.IntRef r5 = r210;
        String r4 = r12;
        int r2 = r15;
        List r19 = r25;
        r7 = r9;
    L19:
        r15 = r2;
        r12 = r4;
        r11 = r5;
        r13 = r19;
        goto L4
    L12:
        if (r7 != 0) goto L15;
        if (r32 == 0) goto L15;
        e r3 = new e(r32, r1.a(r8, r32));
    L18:
        com.obric.memorydata.i r10 = com.obric.memorydata.i.f9874a;
        Bitmap r6 = r3.a();
        String r14 = r1.d(r30, r33);
        com.obric.memorydata.memory.memoryentity.e r17 = r3.b();
        r5 = r210;
        r4 = r12;
        r19 = r25;
        r2 = r15;
        r10.a(r31, r6, r14, r34, r35, r17, r28);
        r5.element++;
        r7 = r9;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, r4), "MemoryManagerWrapper", new StringBuilder().append("image memory item generate returned, from=").append(r30).append(", productType=").append(r2).append(", source=").append(r8.c()).append(", imageType=").append(r8.d()).append(", index=").append(r7).append('/').append(r19.size()).append(", cost=").append(SystemClock.elapsedRealtime() - r23).append("ms").toString(), false, 4, null);
    L15:
        r3 = a(r1, Uri.parse(r8.a()), r8, null, 2, null);
        if (r3 != null) goto L18;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, r12), "MemoryManagerWrapper", "image memory item decode failed, from=" + r30 + ", productType=" + r15 + ", source=" + r8.c() + ", imageType=" + r8.d() + ", index=" + r9 + '/' + r25.size() + ", cost=" + (SystemClock.elapsedRealtime() - r23) + "ms, uri=" + r8.a(), null, 4, null);
        r5 = r210;
        r7 = r9;
        r4 = r12;
        r2 = r15;
        r19 = r25;
        goto L19
    L20:
        final Ref.IntRef r18 = r11;
        String r20 = r12;
        final List r110 = r13;
        final int r21 = r15;
        if (r110.size() <= 1) goto L27;
        if (r18.element <= 0) goto L25;
        com.obric.memorydata.middleware.api.logging.o.a((com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.a.f11610a, com.obric.memorydata.middleware.api.logging.o.class, r20), "系统主动记忆图片批次已分发", "batch_dispatched", com.obric.memorydata.middleware.api.logging.e.a(r28, null, null, "route", 3, null), new $$Lambda$v$d62R9FZSfDZHzXAOQmjKnEbKh2w(r30, r21, r110, r18), null, 16, null);
        goto L27
    L25:
        com.obric.memorydata.middleware.api.logging.o.a((com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.a.f11610a, com.obric.memorydata.middleware.api.logging.o.class, r20), "系统主动记忆图片批次无有效输入", "input_prepare_failed", "no_valid_image_input", null, com.obric.memorydata.middleware.api.logging.e.a(r28, null, null, "route", 3, null), new $$Lambda$v$KKmWg13sUWXdUdqa4uHhXDeTdzw(r30, r21, r110), 8, null);
    L27:
        return Unit.INSTANCE;
    }

    private static final Unit a(String r1, com.obric.memorydata.middleware.api.logging.g r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$errorTrace");
        r2.a("auth_error", r1);
        return Unit.INSTANCE;
    }

    private static final Unit a(List r2, Bundle r3, Function0 r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        x.f11587a.a(r5.size(), f11572a.b(r3), r6);
        return Unit.INSTANCE;
    }

    private final void a(int r16, String r17) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryManagerWrapper", "ignore memory action for enterprise account, from=" + r16 + ", source=" + r17, false, 4, null);
        kotlinx.coroutines.i.a(i, null, null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryManagerWrapper$showEnterpriseAccountNotSupported$1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final synchronized void a(long r8, String r10) {
        monitor-enter(this);
        if (r8 > 0) goto L20;
        monitor-exit(this);
        return;
    L20:
    L17:
        th = move-exception;
        throw th;
    L8:
        if (f == r8) goto L13;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryManagerWrapper", "[gate] release epoch mismatch (cur=" + f + ", given=" + r8 + "), ignore, reason=" + r10, false, 4, null);     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L13:
        if (e.compareAndSet(true, false) == false) goto L15;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryManagerWrapper", "[gate] released, epoch=" + r8 + ", reason=" + r10, false, 4, null);     // Catch: Throwable -> L17
    L15:
        monitor-exit(this);
    }

    private final void a(long r16, String r18, long r19, Function1<? super Continuation<? super Unit>, ? extends Object> r21) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r21, Function1.class, "com.obric.memorydata.plugin");
        bx r7 = kotlinx.coroutines.i.a(j, null, null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryManagerWrapper$launchGatedMemoryTask$timeoutJob$1(r19, r16, r18, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a(h, null, null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryManagerWrapper$launchGatedMemoryTask$1(r16, r18, r6, r7, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void a(final Bundle r25, final int r26, final boolean r27, final Bitmap r28, final com.obric.memorydata.middleware.api.logging.e r29) {
        if (r27 == true) goto L5;
        long r1 = com.obric.memorydata.utils.c.a.a(com.obric.memorydata.utils.c.a.f13197a, r25, "com.aiassistant.memorydata.EXTRA_TIMESTAMP", 0, 4, null);
    L6:
        final long r9 = r1;
        final d r2 = a(r26, r25, r27);
        final String r13 = r2.a();
        com.obric.memorydata.middleware.api.logging.o.a((com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.a.f11610a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin"), "系统主动记忆输入路线已选择", "route_selected", com.obric.memorydata.middleware.api.logging.e.a(r29, null, null, "route", 3, null), new $$Lambda$v$mEYASQvBsWrQKj5h4iDw9TBYU(r26, r27, r2, r13), null, 16, null);
        final List<com.obric.memorydata.memory.memoryentity.e> r15 = a(r26, r25);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L13;
        final int r5 = e(r26, r25);
        final Function0 r8 = new $$Lambda$v$ZOlm0kddwrRrt8X4bDvINtNSLs(r29, r15, r26, r5, r28, r25, r13, r9);
        if (a(r26, r25, r15.size()) == false) goto L11;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryManagerWrapper", "collect gallery document memory result, count=" + r15.size(), false, 4, null);
        com.obric.memorydata.memory.c.a.f10081a.a(new $$Lambda$v$_Xn7IpbgZ2cYrVToOudgsi7d8so(r15, r25, r8));
        return;
    L11:
        r8.invoke();
        return;
    L13:
        if (r28 != null) goto L15;
        Bitmap r6 = a(r26, r25, r13);
    L16:
        com.obric.memorydata.i.a(com.obric.memorydata.i.f9874a, e(r26, r25), r6, d(r26, r25), r13, r9, null, r29, 32, null);
        return;
    L15:
        r6 = r28;
        goto L16
    L5:
        r1 = System.currentTimeMillis();
        goto L6
    }

    private final synchronized void a(ShortcutMemoryConsentType r10, int r11, Bundle r12, String r13) {
        monitor-enter(this);
        if (r12 != null) goto L7;
        c.remove(r10);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L7:
        c.put(r10, new b(r11, new Bundle(r12), new com.obric.memorydata.middleware.api.logging.e(null, r13, "trigger", 1, null)));     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private final void a(final a r12, String r13) {
        long r2 = a("confirmManualMemory:from=" + r12.a());
        if (r2 >= 0) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryManagerWrapper", "drop confirmed memory because gate is busy, from=" + r12.a(), null, 4, null);
        com.obric.memorydata.middleware.api.logging.o.a((com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.a.f11610a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin"), "主动记忆确认后因已有任务而终止", "build_blocked", "gate_busy_after_confirmation", null, com.obric.memorydata.middleware.api.logging.e.a(r12.d(), null, null, "trigger", 3, null), new $$Lambda$v$LU7dhIAWCZE3MNRMC0pbj6j3XPg(r12), 8, null);
        return;
    L6:
        a(r2, r13 + ":from=" + r12.a(), b(r12.a(), r12.b()), (Function1) ZeusTransformUtils.preCheckCast(new MemoryManagerWrapper$startConfirmedMemory$2(r12, null), Function1.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void a(v r0, int r1, Bundle r2, boolean r3) {
        r0.b(r1, r2, r3);
    }

    public static final /* synthetic */ void a(v r0, int r1, String r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(v r0, long r1, String r3) {
        r0.a(r1, r3);
    }

    public static final /* synthetic */ void a(v r7, long r8, String r10, long r11, Function1 r13) {
        r7.a(r8, r10, r11, (Function1) ZeusTransformUtils.wrapperContextForParams(r13, Function1.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void a(v r2, Activity r3) {
        r2.c((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ void a(v r6, Bundle r7, int r8, boolean r9, Bitmap r10, com.obric.memorydata.middleware.api.logging.e r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L5;
        r9 = false;
    L5:
        boolean r3 = r9;
        if ((r12 & 8) == 0) goto L8;
        r10 = null;
    L8:
        r6.a(r7, r8, r3, r10, r11);
    }

    public static final /* synthetic */ void a(v r0, ShortcutMemoryConsentType r1) {
        r0.d(r1);
    }

    public static final /* synthetic */ void a(v r0, ShortcutMemoryConsentType r1, int r2, Bundle r3, String r4) {
        r0.a(r1, r2, r3, r4);
    }

    public static final /* synthetic */ void a(v r0, a r1, String r2) {
        r0.a(r1, r2);
    }

    /* JADX WARN: Type inference failed for: r12v4, types: [T, com.obric.memorydata.memory.v$f] */
    private static final void a(Ref.ObjectRef r8, com.obric.memorydata.memory.memoryentity.e r9, Uri r10, Ref.BooleanRef r11, ContentResolver r12, ImageDecoder r13, ImageDecoder.ImageInfo r14, ImageDecoder.Source r15) {
        Intrinsics.checkNotNullParameter(r13, "decoder");
        Intrinsics.checkNotNullParameter(r14, "info");
        Intrinsics.checkNotNullParameter(r15, "<unused var>");
        int r16 = r14.getSize().getWidth();
        int r17 = r14.getSize().getHeight();
        String r0 = null;
        if (r9 == null) goto L52;
        String r2 = r9.e();
        if (r2 == null) goto L52;
    L14:
        if (r9 == null) goto L50;
        Long r18 = r9.f();
        if (r18 == null) goto L50;
    L25:
        r8.element = new f(r2, r18, r16, r17);
        f r19 = (f) ZeusTransformUtils.preCheckCast(r8.element, f.class, "com.obric.memorydata.plugin");
        boolean r110 = false;
        if (r19 != null) goto L28;
    L30:
        r11.element = r110;
        if (r11.element == false) goto L33;
        int r20 = RangesKt.coerceAtLeast((int) (r16 * 0.5f), 1);
    L35:
        if (r11.element == false) goto L37;
        int r111 = RangesKt.coerceAtLeast((int) (r17 * 0.5f), 1);
    L39:
        if (r11.element == false) goto L41;
        r13.setTargetSize(r20, r111);
    L41:
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r21 = new StringBuilder().append("Uri to Bitmap target size: ").append(r16).append('x').append(r17).append(" -> ").append(r20).append('x').append(r111).append(", compressed=").append(r11.element).append(", fileSize=");
        v r112 = f11572a;
        f r113 = (f) ZeusTransformUtils.preCheckCast(r8.element, f.class, "com.obric.memorydata.plugin");
        if (r113 == null) goto L44;
        Long r114 = r113.b();
    L45:
        StringBuilder r22 = r21.append(r112.a(r114)).append(", mime=");
        f r23 = (f) ZeusTransformUtils.preCheckCast(r8.element, f.class, "com.obric.memorydata.plugin");
        if (r23 == null) goto L48;
        r0 = r23.a();
    L48:
        IRunLog.a.a(r3, "MemoryManagerWrapper", r22.append(r0).append(", uri=").append(r10).toString(), false, 4, null);
        return;
    L44:
        r114 = null;
        goto L45
    L37:
        r111 = r17;
        goto L39
    L33:
        r20 = r16;
        goto L35
    L28:
        if (r19.e() != true) goto L30;
        r110 = true;
    L50:
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L19
        Object r25 = Result.m1421constructorimpl(f11572a.a(r12, r10));     // Catch: Throwable -> L19
    L22:
        if (Result.m1427isFailureimpl(r25) == false) goto L24;
        r25 = null;
    L24:
        r18 = (Long) ZeusTransformUtils.preCheckCast(r25, Long.class, "com.obric.memorydata.plugin");
    L19:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r25 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L52:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L8
        Object r5 = Result.m1421constructorimpl(ZeusProviderTransform.getType(r12, r10, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L8
    L11:
        if (Result.m1427isFailureimpl(r5) == false) goto L13;
        r5 = null;
    L13:
        r2 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin");
    L8:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    private final boolean a(int r1) {
        if (r1 == 4) goto L7;
        if (r1 == 3) goto L7;
    L9:
        return false;
    L7:
        if (com.obric.memorydata.utils.ba.f() == false) goto L9;
        return true;
    }

    private final boolean a(int r3, Bundle r4, int r5) {
        if (r3 == 0) goto L5;
        return false;
    L5:
        if (r5 <= 1) goto L15;
        String r6 = com.obric.memorydata.utils.c.a.f13197a.a(r4, "com.aiassistant.memorydata.EXTRA_SOURCE");
        int r7 = com.obric.memorydata.utils.c.a.f13197a.a(r4, "com.aiassistant.memorydata.EXTRA_IMAGE_TYPE", 0);
        if (Intrinsics.areEqual(r6, "gallery_document") == true) goto L12;
        if (r7 == 4) goto L12;
        return false;
    L12:
        return true;
    L15:
        return false;
    }

    private final synchronized boolean a(long r3) {
        monitor-enter(this);
        if (r3 > 0) goto L16;
    L13:
        boolean r4 = false;
    L14:
        monitor-exit(this);
        return r4;
    L16:
    L10:
        th = move-exception;
        throw th;
    L6:
        if (f != r3) goto L13;
        if (e.get() == false) goto L13;
        r4 = true;
        goto L14
    }

    private final boolean a(Activity r10, Uri r11) {
        ContentResolver r1 = ((Activity) ZeusTransformUtils.wrapperContextForParams(r10, Activity.class, "com.obric.memorydata.plugin")).getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r1, "getContentResolver(...)");
        return a(this, r1, r11, "share", true, null, null, 48, null);
    }

    private final boolean a(ContentResolver r15, Uri r16, String r17, boolean r18, Long r19, String r20) {
        if (Intrinsics.areEqual(r16.getScheme(), Params.CONTENT) == true) goto L9;
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r3 = new StringBuilder();
        String r5 = "Reject non-content uri, scene=";
    L5:
        StringBuilder r2 = r3.append(r5).append(r17);
    L6:
        IRunLog r14 = r0;
        String r110 = "MemoryManagerWrapper";
        String r111 = r2.append(", uri=").append(r16).toString();
        Throwable r112 = null;
        int r113 = 4;
        Object r114 = null;
    L7:
        IRunLog.a.a(r14, r110, r111, r112, r113, r114);
        return false;
    L9:
        c r4 = a(r15, r16, r19, r20);
        if (r4 != null) goto L13;
        return false;
    L13:
        if (r4.a() != null) goto L17;
        if (r18 == false) goto L16;
        r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r3 = new StringBuilder();
        r5 = "Reject uri with unknown size, scene=";
        goto L5
    L16:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryManagerWrapper", "Image uri size unknown, continue without size limit, scene=" + r17 + ", uri=" + r16, null, 4, null);
    L17:
        Long r7 = r4.a();
        if (r7 == null) goto L20;
        long r8 = r7.longValue();
    L22:
        if (r8 <= 10485760) goto L24;
        IRunLog r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r1 = "Reject oversized uri, scene=" + r17 + ", size=" + a(r4.a()) + ", max=" + a(10485760L) + ", uri=" + r16;
        r14 = r6;
        r110 = "MemoryManagerWrapper";
        r111 = r1;
        r112 = null;
        r113 = 4;
        r114 = null;
        goto L7
    L24:
        String r9 = r4.b();
        if (r9 != null) goto L27;
    L29:
        boolean r10 = false;
    L30:
        if (r10 == true) goto L32;
        r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r2 = new StringBuilder().append("Reject non-image uri, scene=").append(r17).append(", mime=").append(r4.b());
        goto L6
    L32:
        return true;
    L27:
        if (StringsKt.startsWith$default(r9, "image/", false, 2, null) != true) goto L29;
        r10 = true;
        goto L30
    L20:
        r8 = 0;
        goto L22
    }

    private final boolean a(Context r11, int r12, Bundle r13) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        if (r12 != 1) goto L5;
    L7:
        String r14 = com.obric.memorydata.utils.c.a.f13197a.a(r13, "com.aiassistant.memorydata.EXTRA_PACKAGE");
        boolean r1 = ak.f13164a.d(r14);
        boolean r15 = ak.f13164a.e(r14);
        com.obric.memorydata.middleware.api.logging.o.a((com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.a.f11610a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin"), "confirm decision, from=" + r12 + ", isSystemApp=" + r1 + ", isObricApp=" + r15, "confirm_decision", null, null, null, 28, null);
        if (r1 == true) goto L12;
        if (r15 == false) goto L11;
        return false;
    L11:
        return true;
    L12:
        return false;
    L5:
        if (r12 == 5) goto L7;
        return false;
    }

    private final boolean a(Context r16, Bundle r17, final int r18, Bitmap r19, com.obric.memorydata.middleware.api.logging.e r20) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r16, Context.class, "com.obric.memorydata.plugin");
        if (DeviceInfoState.INSTANCE.isGlobalMemoryDisabled() == false) goto L6;
        com.obric.memorydata.middleware.api.logging.o.a((com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.a.f11610a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin"), "主动记忆确认请求因全局开关关闭而终止", "confirmation_unavailable", "global_memory_disabled", null, com.obric.memorydata.middleware.api.logging.e.a(r20, null, null, "trigger", 3, null), new $$Lambda$v$kICuwsoQ_3CqCH3yPQDGAALyu8(r18), 8, null);
        return false;
    L6:
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L8:
        if (d == null) goto L12;
        com.obric.memorydata.middleware.api.logging.o.a((com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.a.f11610a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin"), "主动记忆确认请求因已有待确认任务而终止", "confirmation_unavailable", "confirmation_already_pending", null, com.obric.memorydata.middleware.api.logging.e.a(r20, null, null, "trigger", 3, null), new $$Lambda$v$XDQfJoh3MovE07DhePOxb14tnsI(r18), 8, null);     // Catch: Throwable -> L19
        monitor-exit(this);
        return false;
    L12:
        d = new a(r18, new Bundle(r17), r19, r20);     // Catch: Throwable -> L19
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(this);
        ActiveMemoryConfirmDialogActivity.f11521a.a(r0);     // Catch: Throwable -> L16
        return true;
    L16:
        th = move-exception;
        com.obric.memorydata.middleware.api.logging.o.a((com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.a.f11610a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin"), "主动记忆确认框启动失败", "confirmation_launch_failed", "confirmation_launch_failed", null, com.obric.memorydata.middleware.api.logging.e.a(r20, null, null, "trigger", 3, null), new $$Lambda$v$3ql0r10ExBhDnTpmldpNhckjt3M(r18, th), 8, null);
        d();
        return false;
    }

    private final boolean a(com.obric.memorydata.memory.memoryentity.e r15, int r16, int r17, int r18, int r19) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        v r1 = (v) ZeusTransformUtils.preCheckCast(this, v.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r2 = Result.m1421constructorimpl(Uri.parse(r15.a()));     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r2) == false) goto L10;
        r2 = null;
    L10:
        Uri r3 = (Uri) ZeusTransformUtils.preCheckCast(r2, Uri.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L14;
        v r4 = (v) ZeusTransformUtils.preCheckCast(this, v.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryManagerWrapper", "skip image memory because uri parse failed, from=" + r16 + ", productType=" + r17 + ", source=" + r15.c() + ", imageType=" + r15.d() + ", index=" + (r18 + 1) + '/' + r19 + ", uri=" + r15.a(), null, 4, null);
        return true;
    L14:
        ContentResolver r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r5, "getContentResolver(...)");
        return !a(r5, r3, "image memory, from=" + r16 + ", productType=" + r17 + ", source=" + r15.c() + ", imageType=" + r15.d() + ", index=" + (r18 + 1) + '/' + r19, false, r15.f(), r15.e());
    L5:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r2 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static final /* synthetic */ boolean a(v r0, int r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ boolean a(v r0, long r1) {
        return r0.a(r1);
    }

    static /* synthetic */ boolean a(v r9, ContentResolver r10, Uri r11, String r12, boolean r13, Long r14, String r15, int r16, Object r17) {
        if ((r16 & 16) == 0) goto L5;
        Long r7 = null;
    L7:
        if ((r16 & 32) == 0) goto L9;
        String r8 = null;
    L11:
        return r9.a(r10, r11, r12, r13, r7, r8);
    L9:
        r8 = r15;
        goto L11
    L5:
        r7 = r14;
        goto L7
    }

    public static final /* synthetic */ boolean a(v r2, Context r3, int r4, Bundle r5) {
        return r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    public static final /* synthetic */ boolean a(v r6, Context r7, Bundle r8, int r9, Bitmap r10, com.obric.memorydata.middleware.api.logging.e r11) {
        return r6.a((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11);
    }

    private final boolean a(String r1, int r2) {
        if (Intrinsics.areEqual(r1, "gallery") == false) goto L5;
    L24:
        return true;
    L5:
        if (Intrinsics.areEqual(r1, "gallery_scroll") == true) goto L24;
        if (Intrinsics.areEqual(r1, "camera_viewfinder") == true) goto L24;
        if (Intrinsics.areEqual(r1, "gallery_single") == true) goto L24;
        if (Intrinsics.areEqual(r1, "gallery_document") == true) goto L24;
        if (Intrinsics.areEqual(r1, "camera_postview") == true) goto L24;
        if (r2 == 2) goto L24;
        if (r2 == 3) goto L24;
        if (r2 == 4) goto L24;
        if (r2 == 5) goto L24;
        return false;
    }

    private final boolean a(boolean r1, String r2, String r3) {
        if (r1 == true) goto L4;
    L8:
        return false;
    L4:
        if (Intrinsics.areEqual(r2, AppInfo.Launcher.getPackageName()) == false) goto L8;
        if (Intrinsics.areEqual(r3, AppInfo.OAssistant.getPackageName()) == false) goto L8;
        return true;
    }

    private final long b(int r10, Bundle r11) {
        int r0 = c(r10, r11);
        long r1 = 30000;
        if (a(r10, r11, r0) == false) goto L5;
        r1 = 5000 + (((long) r0) * 30000);
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryManagerWrapper", "resolve gate timeout, from=" + r10 + ", imageCount=" + r0 + ", timeoutMs=" + r1, false, 4, null);
        return r1;
    }

    private final Activity b(Activity r9) {
        Activity r8 = (Activity) ZeusTransformUtils.wrapperContextForParams(r9, Activity.class, "com.obric.memorydata.plugin");
        Class<?> r10 = r8.getClass();
    L4:
        if (r10 == null) goto L14;
        Field r2 = r10.getDeclaredField("mProxyActivity");     // Catch: Exception -> L10 NoSuchFieldException -> L13
        r2.setAccessible(true);     // Catch: Exception -> L10 NoSuchFieldException -> L13
        Object r3 = r2.get(r8);     // Catch: Exception -> L10 NoSuchFieldException -> L13
        if (ZeusTransformUtils.instanceOf(r3, Activity.class) == false) goto L20;
    L9:
        return (Activity) ZeusTransformUtils.preCheckCast(r3, Activity.class, "com.obric.memorydata.plugin");
    L20:
        return null;
    L13:
        r10 = r10.getSuperclass();
    L10:
        e = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryManagerWrapper", "Read plugin proxy activity failed: " + e.getMessage(), null, 4, null);
        return null;
    L14:
        return null;
    }

    private final Bitmap b(Uri r2, ContentResolver r3) {
        e r1 = a(r2, null, r3);
        if (r1 != null) goto L5;
        return null;
    L5:
        return r1.a();
    }

    static /* synthetic */ Bitmap b(v r0, Uri r1, ContentResolver r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver();
    L6:
        return r0.b(r1, r2);
    }

    private final Uri b(Intent r4) {
        if (Build.VERSION.SDK_INT < 33) goto L5;
        Object r3 = r4.getParcelableExtra("android.intent.extra.STREAM", Uri.class);
    L7:
        return (Uri) ZeusTransformUtils.preCheckCast(r3, Uri.class, "com.obric.memorydata.plugin");
    L5:
        r3 = r4.getParcelableExtra("android.intent.extra.STREAM");
        goto L7
    }

    private final com.obric.memorydata.memory.ui.settings.u b(int r5) {
        com.obric.memorydata.memory.ui.settings.l r0 = com.obric.memorydata.memory.ui.settings.l.f11479a.a();
        if (r5 != 3) goto L5;
        ShortcutMemoryTrigger r6 = ShortcutMemoryTrigger.GESTURE;
    L10:
        return com.obric.memorydata.memory.ui.settings.v.a(r6, ((Boolean) ZeusTransformUtils.preCheckCast(r0.f().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), ((Boolean) ZeusTransformUtils.preCheckCast(r0.g().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), e());
    L5:
        if (r5 == 4) goto L7;
        r6 = ShortcutMemoryTrigger.OTHER;
        goto L10
    L7:
        r6 = ShortcutMemoryTrigger.AI_VOLUME;
        goto L10
    }

    public static final /* synthetic */ com.obric.memorydata.memory.ui.settings.u b(v r0, int r1) {
        return r0.b(r1);
    }

    private final String b(Bundle r4) {
        String r3 = com.obric.memorydata.utils.c.a.f13197a.a(r4, "com.aiassistant.memorydata.EXTRA_SOURCE");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        return r3;
    L11:
        int r5 = com.obric.memorydata.utils.c.a.f13197a.a(r4, "com.aiassistant.memorydata.EXTRA_IMAGE_TYPE", 0);
        if (r5 != 1) goto L14;
        return "screenshot_scroll";
    L14:
        if (r5 != 2) goto L16;
        return "camera_viewfinder";
    L16:
        if (r5 != 3) goto L18;
        return "gallery_single";
    L18:
        if (r5 != 4) goto L20;
        return "gallery_document";
    L20:
        if (r5 == 5) goto L22;
        return "screenshot";
    L22:
        return "camera_postview";
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    private final String b(String r5) {
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L6;
        return null;
    L6:
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("://", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L8;
        return r5;
    L8:
        return Uri.parse(r5).getHost();
    }

    private static final Unit b(int r2, int r3, List r4, com.obric.memorydata.middleware.api.logging.g r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "$this$errorTrace");
        r5.a("from", Integer.valueOf(r2));
        r5.a("product_type", Integer.valueOf(r3));
        r5.a("item_total", Integer.valueOf(r6.size()));
        return Unit.INSTANCE;
    }

    private static final Unit b(int r1, com.obric.memorydata.middleware.api.logging.g r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$errorTrace");
        r2.a("from", Integer.valueOf(r1));
        return Unit.INSTANCE;
    }

    private static final Unit b(a r1, com.obric.memorydata.middleware.api.logging.g r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$errorTrace");
        r2.a("from", Integer.valueOf(r1.a()));
        return Unit.INSTANCE;
    }

    private final void b(int r10, Bundle r11, boolean r12) {
        String r0 = com.obric.memorydata.utils.c.a.f13197a.a(r11, "com.aiassistant.memorydata.EXTRA_PACKAGE");
        if (r0 == null) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryManagerWrapper", "skip package fallback before decision, from=" + r10 + ", delayed=" + r12 + ", extraPackage=" + r0, false, 4, null);
        return;
    L6:
        String r9 = a(r12);
        if (r9 == null) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryManagerWrapper", "fill package before decision by fallback, from=" + r10 + ", delayed=" + r12 + ", fallbackPackage=" + r9, false, 4, null);
        r11.putString("com.aiassistant.memorydata.EXTRA_PACKAGE", r9);
        return;
    }

    public static final /* synthetic */ void b(v r0, ShortcutMemoryConsentType r1) {
        r0.c(r1);
    }

    private final boolean b(Activity r6, Uri r7) {
        InputStream r5 = ((Activity) ZeusTransformUtils.wrapperContextForParams(r6, Activity.class, "com.obric.memorydata.plugin")).getContentResolver().openInputStream(r7);     // Catch: Exception -> L20
        if (r5 == null) goto L28;
        Closeable r8 = (Closeable) ZeusTransformUtils.preCheckCast(r5, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L20
        byte[] r3 = new byte[12];     // Catch: Throwable -> L15
        if (((InputStream) ZeusTransformUtils.preCheckCast(r8, InputStream.class, "com.obric.memorydata.plugin")).read(r3) < 4) goto L12;
        if (com.obric.memorydata.utils.w.f13266a.a(r3) == false) goto L12;
        boolean r2 = true;
    L13:
        CloseableKt.closeFinally(r8, null);     // Catch: Exception -> L20
        return r2;
    L12:
        r2 = false;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);     // Catch: Exception -> L20
        throw th;     // Catch: Exception -> L20
    L28:
        return false;
    L20:
        e = move-exception;
        RunLog.INSTANCE.error("MemoryManagerWrapper", "Failed to inspect uri header: " + r7, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return false;
    }

    private final int c(int r4, Bundle r5) {
        if (r4 == 0) goto L6;
        return 0;
    L6:
        if (a(com.obric.memorydata.utils.c.a.f13197a.a(r5, "com.aiassistant.memorydata.EXTRA_SOURCE"), com.obric.memorydata.utils.c.a.f13197a.a(r5, "com.aiassistant.memorydata.EXTRA_IMAGE_TYPE", 0)) == true) goto L8;
        return 0;
    L8:
        ArrayList r3 = com.obric.memorydata.utils.c.a.f13197a.b(r5, "com.aiassistant.memorydata.EXTRA_IMAGE_LIST", Bundle.class);
        if (r3 != null) goto L11;
        return 0;
    L11:
        return r3.size();
    }

    private final int c(Bundle r3) {
        int r2 = com.obric.memorydata.utils.c.a.f13197a.a(r3, "com.aiassistant.memorydata.EXTRA_IMAGE_TYPE", 0);
        if (r2 != 1) goto L5;
        return 13;
    L5:
        if (r2 != 2) goto L7;
        return 17;
    L7:
        if (r2 != 3) goto L9;
        return 15;
    L9:
        if (r2 != 4) goto L11;
        return 16;
    L11:
        if (r2 == 5) goto L13;
        return 8;
    L13:
        return 18;
    }

    private final a c(String r10) {
        monitor-enter(this);
        a r0 = d;     // Catch: Throwable -> L9
        Integer r1 = null;
        d = null;     // Catch: Throwable -> L9
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        StringBuilder r2 = new StringBuilder().append("take pending confirm request: ");     // Catch: Throwable -> L9
        if (r0 == null) goto L6;
        r1 = Integer.valueOf(r0.a());     // Catch: Throwable -> L9
    L6:
        IRunLog.a.a(r3, "MemoryManagerWrapper", r2.append(r1).append(", reason=").append(r10).toString(), false, 4, null);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    L9:
        th = move-exception;
        throw th;
    }

    private static final Unit c(a r1, com.obric.memorydata.middleware.api.logging.g r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$mainTrace");
        r2.a("from", Integer.valueOf(r1.a()));
        return Unit.INSTANCE;
    }

    private final void c(Activity r5) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r5, Activity.class, "com.obric.memorydata.plugin");
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(r4, Context.class, "com.obric.memorydata.plugin");
        String r0 = r4.getString(ZeusTransformUtils.mapRes(R.string.memory_share_handle_error, TypedValues.Custom.S_STRING, "memory_share_handle_error"));
        Intrinsics.checkNotNullExpressionValue(r0, "getString(...)");
        com.obric.memorydata.utils.ba.a(r6, r0, 0, 4, null);
        r4.finish();
    }

    private final void c(ShortcutMemoryConsentType r12) {
        b r0 = a(r12, "delayGenerateMemory");
        if (r0 != null) goto L5;
        return;
    L5:
        long r5 = a("delayGenerateMemory:type=" + r12 + ",from=" + r0.a());
        if (r5 >= 0) goto L9;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryManagerWrapper", "drop delayed memory because gate is busy, type=" + r12 + ", from=" + r0.a(), false, 4, null);
        return;
    L9:
        a(r5, "delayGenerateMemory:type=" + r12 + ",from=" + r0.a(), b(r0.a(), r0.b()), (Function1) ZeusTransformUtils.preCheckCast(new MemoryManagerWrapper$delayGenerateMemory$1(r0, null), Function1.class, "com.obric.memorydata.plugin"));
    }

    private final String d(int r7, Bundle r8) {
        if (r7 != 1) goto L8;
        String r9 = com.obric.memorydata.utils.c.a.f13197a.a(r8, "com.aiassistant.memorydata.EXTRA_TEXT");
        if (r9 == null) goto L9;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryManagerWrapper", "text: " + com.obric.memorydata.utils.q.f13259a.b(r9), false, 4, null);
        return r9;
    L9:
        return null;
    L8:
        return null;
    }

    private final void d() {
        monitor-enter(this);
        IRunLog r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        StringBuilder r0 = new StringBuilder().append("clear pending confirm request: ");     // Catch: Throwable -> L10
        a r3 = d;     // Catch: Throwable -> L10
        if (r3 == null) goto L6;
        Integer r4 = Integer.valueOf(r3.a());     // Catch: Throwable -> L10
    L7:
        IRunLog.a.a(r1, "MemoryManagerWrapper", r0.append(r4).toString(), false, 4, null);     // Catch: Throwable -> L10
        d = null;     // Catch: Throwable -> L10
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        r4 = null;
    L10:
        th = move-exception;
        throw th;
    }

    private final synchronized void d(ShortcutMemoryConsentType r9) {
        monitor-enter(this);
        b r0 = (b) ZeusTransformUtils.preCheckCast(c.remove(r9), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        IRunLog r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        StringBuilder r10 = new StringBuilder().append("clear delayed request, type=").append(r9).append(", from=");     // Catch: Throwable -> L10
        if (r0 == null) goto L6;
        Integer r1 = Integer.valueOf(r0.a());     // Catch: Throwable -> L10
    L7:
        IRunLog.a.a(r2, "MemoryManagerWrapper", r10.append(r1).toString(), false, 4, null);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        r1 = null;
    L10:
        th = move-exception;
        throw th;
    }

    private final int e(int r8, Bundle r9) {
        if (r8 != 0) goto L4;
        String r10 = com.obric.memorydata.utils.c.a.f13197a.a(r9, "com.aiassistant.memorydata.EXTRA_SOURCE");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryManagerWrapper", "source: " + r10, false, 4, null);
        if (r10 != null) goto L19;
    L49:
        return 8;
    L19:
        switch(r10.hashCode()) {
            case -1122916504: goto L45;
            case -196315310: goto L41;
            case -66933985: goto L37;
            case 456850533: goto L33;
            case 998632538: goto L29;
            case 1004046805: goto L25;
            case 1976086787: goto L22;
            default: goto L62;
        };
    L22:
        if (r10.equals("systemui") == true) goto L49;
    L25:
        if (r10.equals("gallery_single") == false) goto L62;
        return 15;
    L29:
        if (r10.equals("gallery_scroll") == false) goto L62;
        return 13;
    L33:
        if (r10.equals("camera_viewfinder") == false) goto L62;
        return 17;
    L37:
        if (r10.equals("camera_postview") == false) goto L62;
        return 18;
    L41:
        if (r10.equals("gallery") == false) goto L62;
        return 19;
    L45:
        if (r10.equals("gallery_document") == false) goto L62;
        return 16;
    L62:
        return c(r9);
    L4:
        if (r8 != 1) goto L6;
        return 7;
    L6:
        if (r8 != 3) goto L8;
        return 9;
    L8:
        if (r8 != 4) goto L10;
        return 10;
    L10:
        if (r8 == 5) goto L12;
        return -1;
    L12:
        return 14;
    }

    private final synchronized Set<ShortcutMemoryConsentType> e() {
        monitor-enter(this);
        Set<ShortcutMemoryConsentType> r0 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(c.keySet(), Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ Unit lambda$0J3VjvsYcyEZQrXd06XNAb2U6nw(int r0, int r1, List r2, com.obric.memorydata.middleware.api.logging.g r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$1RM4f8M0wS5Qk1G6pfWaLPcESkQ(Ref.ObjectRef r0, com.obric.memorydata.memory.memoryentity.e r1, Uri r2, Ref.BooleanRef r3, ContentResolver r4, ImageDecoder r5, ImageDecoder.ImageInfo r6, ImageDecoder.Source r7) {
        a(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ Unit lambda$3ql0r10ExBhDnTpmldpNhckjt3M(int r0, Throwable r1, com.obric.memorydata.middleware.api.logging.g r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$CdOqB2K-o5yo4PvCOCrVlwsXFsE, reason: not valid java name */
    public static /* synthetic */ Unit m999lambda$CdOqB2Ko5yo4PvCOCrVlwsXFsE(a r0, com.obric.memorydata.middleware.api.logging.g r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Thread lambda$FtOj6OudPfB4UY3fwwTmDdMqNVk(Runnable r0) {
        return a(r0);
    }

    public static /* synthetic */ Unit lambda$KKmWg13sUWXdUdqa4uHhXDeTdzw(int r0, int r1, List r2, com.obric.memorydata.middleware.api.logging.g r3) {
        return b(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit lambda$LU7dhIAWCZE3MNRMC0pbj6j3XPg(a r0, com.obric.memorydata.middleware.api.logging.g r1) {
        return b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$Ntpz36crtHJnX56XEvC-tJgu4OA, reason: not valid java name */
    public static /* synthetic */ CharSequence m1000lambda$Ntpz36crtHJnX56XEvCtJgu4OA(byte r0) {
        return a(r0);
    }

    public static /* synthetic */ Unit lambda$XDQfJoh3MovE07DhePOxb14tnsI(int r0, com.obric.memorydata.middleware.api.logging.g r1) {
        return b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$ZOlm0kd-dwrRrt8X4bDvINtNSLs, reason: not valid java name */
    public static /* synthetic */ Unit m1001lambda$ZOlm0kddwrRrt8X4bDvINtNSLs(com.obric.memorydata.middleware.api.logging.e r0, List r1, int r2, int r3, Bitmap r4, Bundle r5, String r6, long r7) {
        return a(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ Unit lambda$_Xn7IpbgZ2cYrVToOudgsi7d8so(List r0, Bundle r1, Function0 r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$biXA8G2AeVI22WVPBPy8i1KCtSQ(String r0, com.obric.memorydata.middleware.api.logging.g r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Unit lambda$d62R9FZSfDZHzXAOQmjKnEbKh2w(int r0, int r1, List r2, Ref.IntRef r3, com.obric.memorydata.middleware.api.logging.g r4) {
        return a(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: lambda$kDVlGSP8zYZn-PO5o-QEbJzJf3o, reason: not valid java name */
    public static /* synthetic */ Unit m1002lambda$kDVlGSP8zYZnPO5oQEbJzJf3o(a r0, com.obric.memorydata.middleware.api.logging.g r1) {
        return c(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$kICuws-oQ_3CqCH3yPQDGAALyu8, reason: not valid java name */
    public static /* synthetic */ Unit m1003lambda$kICuwsoQ_3CqCH3yPQDGAALyu8(int r0, com.obric.memorydata.middleware.api.logging.g r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$mEYASQvBsWrQKj5h4iDw9TB--YU, reason: not valid java name */
    public static /* synthetic */ Unit m1004lambda$mEYASQvBsWrQKj5h4iDw9TBYU(int r0, boolean r1, d r2, String r3, com.obric.memorydata.middleware.api.logging.g r4) {
        return a(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: lambda$y7Q-gNSuhzwhTT7TKvCurKLyebs, reason: not valid java name */
    public static /* synthetic */ Unit m1005lambda$y7QgNSuhzwhTT7TKvCurKLyebs(Intent r0, com.obric.memorydata.middleware.api.logging.g r1) {
        return a(r0, r1);
    }

    public final void a() {
        if (f11573b.get() == false) goto L8;
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        boolean r3 = false;
        int r4 = 4;
        Object r5 = null;
        String r1 = "MemoryManagerWrapper";
        String r2 = "registerMemoryAction ignored, already initialized";
    L5:
        IRunLog.a.a(r0, r1, r2, r3, r4, r5);
        return;
    L8:
        if (DeviceInfoState.INSTANCE.isGlobalMemoryDisabled() == false) goto L15;
        r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r3 = false;
        r4 = 4;
        r5 = null;
        r1 = "MemoryManagerWrapper";
        r2 = "registerMemoryAction ignored, global memory disabled";
        goto L5
    L15:
        com.obric.memorydata.utils.c.b.a((com.obric.memorydata.utils.c.b.a) ZeusTransformUtils.preCheckCast(new MemoryManagerWrapper$registerMemoryAction$1(), com.obric.memorydata.utils.c.b.a.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L12
        f11573b.set(true);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        RunLog.INSTANCE.error("MemoryManagerWrapper", "registerMemoryActionCallback failed", th);
    }

    public final void a(Activity r17, final Intent r18) {
        Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r17, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "activity");
        Intrinsics.checkNotNullParameter(r18, MemorySourceLinkType.INTENT);
        com.obric.memorydata.middleware.api.logging.e r2 = new com.obric.memorydata.middleware.api.logging.e(null, null, "trigger", 3, null);
        com.obric.memorydata.middleware.api.logging.o.a((com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.a.f11610a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin"), "分享主动记忆操作已触发", "operation_received", com.obric.memorydata.middleware.api.logging.e.a(r2, null, null, "trigger", 3, null), new $$Lambda$v$y7QgNSuhzwhTT7TKvCurKLyebs(r18), null, 16, null);
        final String r4 = a(r18);
        if (r4 == null) goto L6;
        com.obric.memorydata.middleware.api.logging.o.a((com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.a.f11610a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin"), "分享主动记忆输入校验失败", "input_prepare_failed", "share_auth_failed", null, com.obric.memorydata.middleware.api.logging.e.a(r2, null, null, "trigger", 3, null), new $$Lambda$v$biXA8G2AeVI22WVPBPy8i1KCtSQ(r4), 8, null);
        c(r6);
        return;
    L6:
        String r5 = a(r6);
        Uri r8 = b(r18);
        if (r8 != null) goto L11;
        com.obric.memorydata.middleware.api.logging.o.a((com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.a.f11610a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin"), "分享主动记忆缺少有效图片 URI", "input_prepare_failed", "share_uri_missing", null, com.obric.memorydata.middleware.api.logging.e.a(r2, null, null, "route", 3, null), null, 40, null);
        c(r6);
        return;
    L11:
        if (a(r6, r8) == true) goto L15;
        com.obric.memorydata.middleware.api.logging.o.a((com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.a.f11610a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin"), "分享主动记忆图片 URI 校验失败", "input_prepare_failed", "share_uri_rejected", null, com.obric.memorydata.middleware.api.logging.e.a(r2, null, null, "route", 3, null), null, 40, null);
        c(r6);
        return;
    L15:
        if (b(r6, r8) == true) goto L18;
        com.obric.memorydata.middleware.api.logging.o.a((com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.a.f11610a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin"), "分享主动记忆图片文件头校验失败", "input_prepare_failed", "share_image_header_rejected", null, com.obric.memorydata.middleware.api.logging.e.a(r2, null, null, "route", 3, null), null, 40, null);
        c(r6);
        return;
    L18:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryManagerWrapper", "Share from caller package: " + r5, false, 4, null);
        Bundle r7 = new Bundle();
        r7.putLong("com.aiassistant.memorydata.EXTRA_TIMESTAMP", System.currentTimeMillis());
        r7.putString("com.aiassistant.memorydata.EXTRA_PACKAGE", r5);
        kotlinx.coroutines.i.a(i, null, null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryManagerWrapper$onShareIntent$3(r2, r6, r7, r8, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void a(ShortcutMemoryConsentType r7) {
        Intrinsics.checkNotNullParameter(r7, "type");
        kotlinx.coroutines.i.a(i, null, null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryManagerWrapper$onShortcutConsentAccepted$1(r7, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void b() {
        final a r0 = c(ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CONFIRM);
        if (r0 != null) goto L5;
        return;
    L5:
        com.obric.memorydata.middleware.api.logging.o.a((com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.a.f11610a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin"), "主动记忆用户确认已通过", "confirmation_accepted", com.obric.memorydata.middleware.api.logging.e.a(r0.d(), null, null, "trigger", 3, null), new $$Lambda$v$CdOqB2Ko5yo4PvCOCrVlwsXFsE(r0), null, 16, null);
        a(r0, "confirmManualMemory");
    }

    public final void b(ShortcutMemoryConsentType r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        d(r2);
    }

    public final void c() {
        final a r9 = c(ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL);
        if (r9 != null) goto L5;
        return;
    L5:
        com.obric.memorydata.middleware.api.logging.o.a((com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.a.f11610a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin"), "主动记忆用户已取消确认", "confirmation_cancelled", com.obric.memorydata.middleware.api.logging.e.a(r9.d(), null, null, "trigger", 3, null), new $$Lambda$v$kDVlGSP8zYZnPO5oQEbJzJf3o(r9), null, 16, null);
    }
}
