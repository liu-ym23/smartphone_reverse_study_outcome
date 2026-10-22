package com.larus.camera.impl.ui.viewmodel;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.DocumentsContract;
import androidx.activity.result.ActivityResult;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.camera.api.params.CameraOutputContext;
import com.larus.camera.api.params.CameraResultOutOpenParams;
import com.larus.camera.api.params.ImageParam;
import com.larus.camera.api.params.InputParam;
import com.larus.camera.api.params.InputParamExtra;
import com.larus.camera.api.params.OutputParam;
import com.larus.camera.api.params.VideoParam;
import com.larus.camera.api.vlm.VLMIntent;
import com.larus.camera.api.vlm.VLMSceneType;
import com.larus.camera.impl.FlowCameraImpl;
import com.larus.camera.impl.entity.EduIntentMode;
import com.larus.camera.impl.entity.EduResultMode;
import com.larus.camera.impl.entity.ResultBottomControlType;
import com.larus.camera.impl.entity.ResultSuggestType;
import com.larus.camera.impl.entity.ResultTabPresentationType;
import com.larus.camera.impl.monitor.CameraEvent;
import com.larus.camera.impl.result.CameraResultFirstFlow;
import com.larus.camera.impl.ui.activity.CameraCaptureActivity;
import com.larus.camera.impl.ui.activity.CameraResultFirstActivity;
import com.larus.camera.impl.ui.base.BaseCameraViewModel;
import com.larus.camera.impl.utils.CameraData;
import com.larus.camera.impl.utils.CaptureResultDetectLogic;
import com.larus.camera.impl.utils.VideoUtils;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.m1;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.model.camera.ICameraEventExt;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.i2;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;
import org.json.JSONObject;
import v19.m5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u009c\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b#*\u0002\u0089\u0001\u0018\u0000 æ\u00032\u00020\u0001:\fæ\u0003ç\u0003è\u0003é\u0003ê\u0003ë\u0003B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020%0\rJ\u0019\u0010\u0083\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\n0o0\rJ\u0010\u0010\u0084\u0001\u001a\u00020 2\u0007\u0010\u0085\u0001\u001a\u00020\nJ\u0010\u0010\u0086\u0001\u001a\u00020 2\u0007\u0010\u0087\u0001\u001a\u00020\nJ\t\u0010\u008b\u0001\u001a\u00020 H\u0016J\t\u0010\u008c\u0001\u001a\u00020 H\u0002J\u0013\u0010\u008d\u0001\u001a\u00020 2\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0002J\u0010\u0010\u0090\u0001\u001a\u00020 2\u0007\u0010\u0091\u0001\u001a\u00020\nJ\u0010\u0010\u0092\u0001\u001a\u00020 2\u0007\u0010\u0093\u0001\u001a\u00020\nJ\u0010\u0010\u0094\u0001\u001a\u00020 2\u0007\u0010\u0095\u0001\u001a\u00020\nJ\u0013\u0010\u0096\u0001\u001a\u00030\u0097\u00012\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0099\u0001\u001a\u00020\n2\u0007\u0010\u009a\u0001\u001a\u00020\nJ\u0007\u0010\u009b\u0001\u001a\u00020 J\u0010\u0010\u009c\u0001\u001a\u00020 2\u0007\u0010\u009d\u0001\u001a\u00020\nJ\u0010\u0010\u009e\u0001\u001a\u00020 2\u0007\u0010\u009f\u0001\u001a\u000207J\u0007\u0010 \u0001\u001a\u00020\nJ\u0014\u0010¡\u0001\u001a\u00020 2\t\u0010¢\u0001\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010£\u0001\u001a\u00020 2\u0007\u0010¢\u0001\u001a\u00020\u0015J\u0010\u0010¤\u0001\u001a\u00020 2\u0007\u0010¥\u0001\u001a\u00020pJ\u0007\u0010¦\u0001\u001a\u00020 J\u0007\u0010§\u0001\u001a\u00020 J\u0012\u0010¨\u0001\u001a\u00020 2\t\u0010©\u0001\u001a\u0004\u0018\u00010vJ\u001a\u0010ª\u0001\u001a\u00020 2\u0007\u0010«\u0001\u001a\u00020\u00062\b\u0010¬\u0001\u001a\u00030\u00ad\u0001J3\u0010®\u0001\u001a\u00020 2\b\u0010¬\u0001\u001a\u00030\u00ad\u00012\u0007\u0010¯\u0001\u001a\u00020\n2\u0017\b\u0002\u0010°\u0001\u001a\u0010\u0012\u0005\u0012\u00030²\u0001\u0012\u0004\u0012\u00020 0±\u0001J\u0007\u0010³\u0001\u001a\u00020\u0006J\u0007\u0010´\u0001\u001a\u00020vJ\u001f\u0010µ\u0001\u001a\u00020 2\u0016\u0010¶\u0001\u001a\u0011\u0012\u0006\u0012\u0004\u0018\u00010v\u0012\u0004\u0012\u00020 0±\u0001J\u0007\u0010·\u0001\u001a\u00020 J9\u0010¸\u0001\u001a\u00030¹\u00012\b\u0010º\u0001\u001a\u00030¹\u00012\b\u0010»\u0001\u001a\u00030¹\u00012\b\u0010¼\u0001\u001a\u00030¹\u00012\b\u0010½\u0001\u001a\u00030¹\u00012\u0007\u0010¾\u0001\u001a\u00020\u0006J\u0010\u0010¿\u0001\u001a\u00020 2\u0007\u0010À\u0001\u001a\u00020\u0006J$\u0010Á\u0001\u001a\u00020 2\t\u0010Â\u0001\u001a\u0004\u0018\u00010l2\u0007\u0010Ã\u0001\u001a\u00020(2\u0007\u0010Ä\u0001\u001a\u00020vJ\u0019\u0010Å\u0001\u001a\u00020 2\u0007\u0010Ã\u0001\u001a\u00020(2\u0007\u0010Ä\u0001\u001a\u00020vJ\u0012\u0010Æ\u0001\u001a\u00020 2\t\u0010Ã\u0001\u001a\u0004\u0018\u00010(J\u0011\u0010Ç\u0001\u001a\u00020 2\b\u0010È\u0001\u001a\u00030É\u0001J\u0014\u0010Ê\u0001\u001a\u00020 2\t\u0010Ë\u0001\u001a\u0004\u0018\u00010(H\u0002J\u001b\u0010Ì\u0001\u001a\u00020 2\u0007\u0010Í\u0001\u001a\u00020l2\u0007\u0010Ä\u0001\u001a\u00020vH\u0002J\u001d\u0010Î\u0001\u001a\u00020 2\t\u0010Í\u0001\u001a\u0004\u0018\u00010l2\u0007\u0010Ä\u0001\u001a\u00020vH\u0002J\u001b\u0010Ó\u0001\u001a\u00020 2\u0012\u0010Ô\u0001\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010(\u0018\u00010Ð\u0001J\u0007\u0010Õ\u0001\u001a\u00020 J\t\u0010Ö\u0001\u001a\u00020 H\u0002J\t\u0010×\u0001\u001a\u0004\u0018\u00010(J\u001b\u0010Ù\u0001\u001a\u00020 2\u0012\u0010Ô\u0001\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010(\u0018\u00010Ð\u0001J\u0010\u0010Ú\u0001\u001a\u00020 2\u0007\u0010Û\u0001\u001a\u00020\nJ\u0012\u0010ß\u0001\u001a\u00020 2\t\u0010Ã\u0001\u001a\u0004\u0018\u00010(J\t\u0010á\u0001\u001a\u0004\u0018\u00010(J\u001b\u0010â\u0001\u001a\u00020 2\t\b\u0002\u0010ã\u0001\u001a\u00020%H\u0082@¢\u0006\u0003\u0010ä\u0001J\u000b\u0010å\u0001\u001a\u0004\u0018\u00010(H\u0002J\u0014\u0010æ\u0001\u001a\u0004\u0018\u00010(2\t\u0010ç\u0001\u001a\u0004\u0018\u00010vJ\t\u0010è\u0001\u001a\u0004\u0018\u00010(J\u0007\u0010é\u0001\u001a\u00020\nJ\u0007\u0010ê\u0001\u001a\u00020\nJ\u0007\u0010ë\u0001\u001a\u00020\nJ\u0010\u0010ì\u0001\u001a\u00020 2\u0007\u0010í\u0001\u001a\u00020\nJ\u0007\u0010î\u0001\u001a\u00020 J\u0010\u0010ï\u0001\u001a\u00020 2\u0007\u0010Ä\u0001\u001a\u00020vJ\u0007\u0010ð\u0001\u001a\u00020 J\u0007\u0010ñ\u0001\u001a\u00020\nJ\u0014\u0010ò\u0001\u001a\u00020 2\t\u0010Í\u0001\u001a\u0004\u0018\u00010lH\u0002J\t\u0010ó\u0001\u001a\u00020 H\u0002J\t\u0010ô\u0001\u001a\u00020 H\u0002J\u0012\u0010õ\u0001\u001a\u00020 2\u0007\u0010Ä\u0001\u001a\u00020vH\u0002J\u0007\u0010ö\u0001\u001a\u00020\nJ)\u0010÷\u0001\u001a\u00020 2\u0017\b\u0002\u0010ø\u0001\u001a\u0010\u0012\u0004\u0012\u00020v\u0012\u0004\u0012\u00020\u0006\u0018\u00010o2\u0007\u0010Ä\u0001\u001a\u00020vJ-\u0010ù\u0001\u001a\u00020 2\u0017\b\u0002\u0010ø\u0001\u001a\u0010\u0012\u0004\u0012\u00020v\u0012\u0004\u0012\u00020\u0006\u0018\u00010o2\t\u0010Í\u0001\u001a\u0004\u0018\u00010lH\u0002J\u0013\u0010ú\u0001\u001a\u00020\n2\b\u0010û\u0001\u001a\u00030ü\u0001H\u0002J\t\u0010ý\u0001\u001a\u00020\nH\u0002J\u0007\u0010þ\u0001\u001a\u00020\nJ\u0007\u0010ÿ\u0001\u001a\u00020 J\t\u0010\u0080\u0002\u001a\u00020 H\u0002J\u0013\u0010\u0081\u0002\u001a\u00020 2\b\u0010\u0082\u0002\u001a\u00030²\u0001H\u0002J\u0011\u0010\u0083\u0002\u001a\u00020 2\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001J\u001d\u0010\u0084\u0002\u001a\u0004\u0018\u00010(2\t\u0010Í\u0001\u001a\u0004\u0018\u00010lH\u0082@¢\u0006\u0003\u0010\u0085\u0002J\u0016\u0010\u0086\u0002\u001a\u0004\u0018\u00010v2\t\u0010Í\u0001\u001a\u0004\u0018\u00010lH\u0002J\u0014\u0010\u0087\u0002\u001a\u00020\n2\t\u0010Í\u0001\u001a\u0004\u0018\u00010lH\u0002J\t\u0010\u0088\u0002\u001a\u00020\nH\u0002J&\u0010\u0089\u0002\u001a\u00020l2\u0007\u0010\u008a\u0002\u001a\u00020v2\u000b\b\u0002\u0010\u008b\u0002\u001a\u0004\u0018\u00010lH\u0086@¢\u0006\u0003\u0010\u008c\u0002J<\u0010\u008d\u0002\u001a\u00030\u008e\u00022\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\u0007\u0010\u008a\u0002\u001a\u00020v2\t\b\u0002\u0010\u008f\u0002\u001a\u00020\u00062\u000b\b\u0002\u0010\u008b\u0002\u001a\u0004\u0018\u00010lH\u0086@¢\u0006\u0003\u0010\u0090\u0002J'\u0010\u0091\u0002\u001a\u0004\u0018\u00010(2\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\t\u0010\u0092\u0002\u001a\u0004\u0018\u00010lH\u0086@¢\u0006\u0003\u0010\u0093\u0002J\t\u0010\u0094\u0002\u001a\u0004\u0018\u00010vJ\u0012\u0010\u0095\u0002\u001a\u00020 2\t\u0010Â\u0001\u001a\u0004\u0018\u00010lJ\u001d\u0010\u0096\u0002\u001a\u00020 2\t\u0010Â\u0001\u001a\u0004\u0018\u00010l2\t\u0010\u0097\u0002\u001a\u0004\u0018\u00010(J\u0010\u0010\u0098\u0002\u001a\u00020 2\u0007\u0010\u0099\u0002\u001a\u00020\u0013J\b\u0010\u009a\u0002\u001a\u00030\u009b\u0002J\u000b\u0010\u009c\u0002\u001a\u0004\u0018\u00010lH\u0016J\t\u0010\u009d\u0002\u001a\u0004\u0018\u00010lJ\u0007\u0010\u009e\u0002\u001a\u00020\nJ\u0007\u0010\u009f\u0002\u001a\u00020\nJ\u0007\u0010 \u0002\u001a\u00020\nJ\u0012\u0010¡\u0002\u001a\u00020\n2\t\b\u0002\u0010¢\u0002\u001a\u00020\u0011J\u0007\u0010£\u0002\u001a\u00020\nJ\u0007\u0010¤\u0002\u001a\u00020\nJ\u0007\u0010¥\u0002\u001a\u00020\nJ\u0012\u0010¦\u0002\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010l\u0018\u00010§\u0002J\u0010\u0010¨\u0002\u001a\u00020\n2\u0007\u0010©\u0002\u001a\u00020\nJ\u0007\u0010ª\u0002\u001a\u00020\u0006J\u0007\u0010«\u0002\u001a\u00020\nJ\u0007\u0010¬\u0002\u001a\u00020\nJ\u0007\u0010\u00ad\u0002\u001a\u00020\nJ\n\u0010®\u0002\u001a\u0005\u0018\u00010¯\u0002J\t\u0010°\u0002\u001a\u0004\u0018\u00010vJ\u0007\u0010±\u0002\u001a\u00020\nJ\u0007\u0010²\u0002\u001a\u00020\nJ\u0007\u0010³\u0002\u001a\u00020\nJ\u0014\u0010´\u0002\u001a\u00020\n2\u000b\b\u0002\u0010Í\u0001\u001a\u0004\u0018\u00010lJ\u001c\u0010µ\u0002\u001a\u00020 2\u0013\u0010ø\u0001\u001a\u000e\u0012\u0004\u0012\u00020v\u0012\u0004\u0012\u00020\u00060oJ\u0018\u0010¶\u0002\u001a\u0004\u0018\u00010v2\u000b\b\u0002\u0010Í\u0001\u001a\u0004\u0018\u00010lH\u0002J\t\u0010·\u0002\u001a\u00020\nH\u0016J\u0007\u0010¸\u0002\u001a\u00020\nJ\u0007\u0010¹\u0002\u001a\u00020\nJ\u0010\u0010º\u0002\u001a\u00020 2\u0007\u0010»\u0002\u001a\u00020vJ\u0007\u0010¼\u0002\u001a\u00020 J\u0007\u0010½\u0002\u001a\u00020 J\u0010\u0010¾\u0002\u001a\u00020 2\u0007\u0010¿\u0002\u001a\u00020vJ\u0010\u0010À\u0002\u001a\u00020 2\u0007\u0010Á\u0002\u001a\u00020\u0006J\u0007\u0010Â\u0002\u001a\u00020 J\u0007\u0010Ã\u0002\u001a\u00020 J\u0007\u0010Ä\u0002\u001a\u00020 J\u0007\u0010Å\u0002\u001a\u00020 J\u0007\u0010Æ\u0002\u001a\u00020 J\u0010\u0010Ç\u0002\u001a\u00020 2\u0007\u0010È\u0002\u001a\u00020vJ\u0007\u0010É\u0002\u001a\u00020 J\u0007\u0010Ê\u0002\u001a\u00020 J\u0007\u0010Ë\u0002\u001a\u00020 J\u0010\u0010Ì\u0002\u001a\u00020 2\u0007\u0010Í\u0002\u001a\u00020vJ0\u0010Î\u0002\u001a\u00020 2\u0007\u0010»\u0002\u001a\u00020v2\u000b\b\u0002\u0010Á\u0002\u001a\u0004\u0018\u00010\u00062\u000b\b\u0002\u0010Ï\u0002\u001a\u0004\u0018\u00010\n¢\u0006\u0003\u0010Ð\u0002J0\u0010Ñ\u0002\u001a\u00020 2\u0007\u0010»\u0002\u001a\u00020v2\u000b\b\u0002\u0010Á\u0002\u001a\u0004\u0018\u00010\u00062\u000b\b\u0002\u0010Ï\u0002\u001a\u0004\u0018\u00010\n¢\u0006\u0003\u0010Ð\u0002J\u0019\u0010Ò\u0002\u001a\u00020 2\u0007\u0010¥\u0001\u001a\u00020p2\u0007\u0010Ó\u0002\u001a\u00020\u0006J\u0007\u0010Ô\u0002\u001a\u00020\nJ'\u0010Õ\u0002\u001a\u00020 2\u001c\u0010¶\u0001\u001a\u0017\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010l0w\u0012\u0004\u0012\u00020 0±\u0001H\u0002J\u001d\u0010Ö\u0002\u001a\u0004\u0018\u00010l2\t\u0010Í\u0001\u001a\u0004\u0018\u00010lH\u0082@¢\u0006\u0003\u0010\u0085\u0002J!\u0010×\u0002\u001a\u00020l*\u00020l2\t\u0010Ø\u0002\u001a\u0004\u0018\u00010l2\u0007\u0010Ù\u0002\u001a\u00020\nH\u0002J\u001f\u0010Ú\u0002\u001a\u00020 2\u0014\u0010¶\u0001\u001a\u000f\u0012\u0004\u0012\u00020l\u0012\u0004\u0012\u00020 0±\u0001H\u0002J\u0015\u0010Û\u0002\u001a\u0005\u0018\u00010Ü\u00022\u0007\u0010Ý\u0002\u001a\u00020\nH\u0002J\u000b\u0010Þ\u0002\u001a\u0004\u0018\u00010(H\u0002J\b\u0010N\u001a\u0004\u0018\u00010(J(\u0010ß\u0002\u001a\u0004\u0018\u00010(2\t\u0010Í\u0001\u001a\u0004\u0018\u00010l2\t\u0010\u0097\u0002\u001a\u0004\u0018\u00010(H\u0082@¢\u0006\u0003\u0010à\u0002J!\u0010á\u0002\u001a\u0004\u0018\u00010(2\t\u0010Í\u0001\u001a\u0004\u0018\u00010l2\t\u0010\u0097\u0002\u001a\u0004\u0018\u00010(H\u0002J\u001f\u0010â\u0002\u001a\u00020 2\t\u0010\u0097\u0002\u001a\u0004\u0018\u00010(2\t\u0010Ã\u0001\u001a\u0004\u0018\u00010(H\u0002J-\u0010ã\u0002\u001a\u00020\n2\u0007\u0010ä\u0002\u001a\u00020\u00062\u0007\u0010å\u0002\u001a\u00020\u00062\u0007\u0010æ\u0002\u001a\u00020\u00062\u0007\u0010ç\u0002\u001a\u00020\u0006H\u0002JF\u0010è\u0002\u001a\u0003Hé\u0002\"\u0005\b\u0000\u0010é\u00022\t\u0010Í\u0001\u001a\u0004\u0018\u00010l2!\u0010ê\u0002\u001a\u001c\b\u0001\u0012\f\u0012\n\u0012\u0005\u0012\u0003Hé\u00020ë\u0002\u0012\u0007\u0012\u0005\u0018\u00010ì\u00020±\u0001H\u0082@¢\u0006\u0003\u0010í\u0002JD\u0010î\u0002\u001a\u0003Hé\u0002\"\u0005\b\u0000\u0010é\u00022\u0007\u0010ï\u0002\u001a\u00020\n2!\u0010ê\u0002\u001a\u001c\b\u0001\u0012\f\u0012\n\u0012\u0005\u0012\u0003Hé\u00020ë\u0002\u0012\u0007\u0012\u0005\u0018\u00010ì\u00020±\u0001H\u0082@¢\u0006\u0003\u0010ð\u0002J\f\u0010ñ\u0002\u001a\u0005\u0018\u00010ò\u0002H\u0002J\u001c\u0010ó\u0002\u001a\u00020 2\n\u0010ô\u0002\u001a\u0005\u0018\u00010ò\u0002H\u0082@¢\u0006\u0003\u0010õ\u0002J\u001c\u0010ö\u0002\u001a\u00020 2\n\u0010ô\u0002\u001a\u0005\u0018\u00010ò\u0002H\u0082@¢\u0006\u0003\u0010õ\u0002J\u001b\u0010÷\u0002\u001a\t\u0012\u0004\u0012\u00020x0§\u00022\t\u0010Í\u0001\u001a\u0004\u0018\u00010lH\u0002J\u0014\u0010ø\u0002\u001a\u0004\u0018\u00010\u00132\u0007\u0010Ë\u0001\u001a\u00020(H\u0002J%\u0010ù\u0002\u001a\u0004\u0018\u00010(2\u0007\u0010Ã\u0001\u001a\u00020(2\u000f\u0010ú\u0002\u001a\n\u0012\u0005\u0012\u00030û\u00020§\u0002H\u0002J\u0012\u0010ü\u0002\u001a\u00020(2\u0007\u0010Ã\u0001\u001a\u00020(H\u0002J\u001d\u0010ý\u0002\u001a\u00020 2\b\u0010þ\u0002\u001a\u00030ÿ\u00022\b\u0010\u0080\u0003\u001a\u00030¹\u0001H\u0002J\u001f\u0010\u0081\u0003\u001a\u0004\u0018\u00010(2\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\b\u0010\u0082\u0003\u001a\u00030\u0083\u0003H\u0002J&\u0010\u0084\u0003\u001a\u0004\u0018\u00010(2\t\u0010Í\u0001\u001a\u0004\u0018\u00010l2\u000e\u0010ú\u0002\u001a\t\u0012\u0004\u0012\u00020x0§\u0002H\u0002J7\u0010\u0085\u0003\u001a\u0005\u0018\u00010\u0086\u00032\u0007\u0010\u0087\u0003\u001a\u00020\u00062\u0007\u0010\u0088\u0003\u001a\u00020\u00062\u0007\u0010\u0089\u0003\u001a\u00020\u00062\u000e\u0010ú\u0002\u001a\t\u0012\u0004\u0012\u00020x0§\u0002H\u0002J\u0011\u0010\u008a\u0003\u001a\u00020\u00062\u0006\u0010O\u001a\u00020\u0006H\u0002J\u001e\u0010\u008b\u0003\u001a\u0004\u0018\u00010(2\u0007\u0010Ã\u0001\u001a\u00020(2\b\u0010\u008c\u0003\u001a\u00030\u0086\u0003H\u0002J9\u0010\u008d\u0003\u001a\u0004\u0018\u00010\u00132\b\u0010\u008e\u0003\u001a\u00030\u008f\u00032\u0007\u0010\u0090\u0003\u001a\u00020\u00062\u0007\u0010\u0091\u0003\u001a\u00020\u00062\u0007\u0010\u0092\u0003\u001a\u00020\u00062\u0007\u0010\u0093\u0003\u001a\u00020\u0006H\u0002J2\u0010\u0094\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010o2\u0007\u0010\u0087\u0003\u001a\u00020\u00062\u0007\u0010\u0088\u0003\u001a\u00020\u00062\u0007\u0010\u0089\u0003\u001a\u00020\u0006H\u0002J\u0012\u0010\u0095\u0003\u001a\u00020\n2\u0007\u0010\u0089\u0003\u001a\u00020\u0006H\u0002J/\u0010\u0096\u0003\u001a\u0004\u0018\u00010\u00132\u0007\u0010\u0097\u0003\u001a\u00020\u00132\u0007\u0010\u0087\u0003\u001a\u00020\u00062\u0007\u0010\u0088\u0003\u001a\u00020\u00062\u0007\u0010\u0089\u0003\u001a\u00020\u0006H\u0002J&\u0010\u0098\u0003\u001a\u0004\u0018\u00010\u00132\u0007\u0010\u0099\u0003\u001a\u00020\u00132\u0007\u0010\u009a\u0003\u001a\u00020\u00062\u0007\u0010\u009b\u0003\u001a\u00020\u0006H\u0002J(\u0010\u009c\u0003\u001a\u0005\u0018\u00010\u009d\u00032\b\u0010\u009e\u0003\u001a\u00030\u009f\u00032\u0007\u0010 \u0003\u001a\u00020\u00062\u0007\u0010¡\u0003\u001a\u00020\u0006H\u0002J \u0010¢\u0003\u001a\u0005\u0018\u00010ÿ\u00022\b\u0010£\u0003\u001a\u00030ÿ\u00022\b\u0010¤\u0003\u001a\u00030ÿ\u0002H\u0002J \u0010¥\u0003\u001a\u0005\u0018\u00010û\u00022\b\u0010¢\u0001\u001a\u00030\u009d\u00032\b\u0010¦\u0003\u001a\u00030ÿ\u0002H\u0002J\u001d\u0010§\u0003\u001a\u0004\u0018\u00010(2\u0007\u0010Ë\u0001\u001a\u00020(2\u0007\u0010¨\u0003\u001a\u00020\u0013H\u0002J'\u0010©\u0003\u001a\u0004\u0018\u00010\u00132\b\u0010\u0099\u0002\u001a\u00030ÿ\u00022\u0007\u0010º\u0001\u001a\u00020\u00062\u0007\u0010»\u0001\u001a\u00020\u0006H\u0002J(\u0010ª\u0003\u001a\u0005\u0018\u00010«\u00032\u0007\u0010 \u0003\u001a\u00020\u00062\u0007\u0010¡\u0003\u001a\u00020\u00062\b\u0010È\u0001\u001a\u00030É\u0001H\u0002J\n\u0010¬\u0003\u001a\u00030\u00ad\u0003H\u0002J \u0010®\u0003\u001a\u0005\u0018\u00010¯\u00032\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\b\u0010\u0082\u0003\u001a\u00030\u0083\u0003H\u0002J\u001d\u0010°\u0003\u001a\u00020\u00062\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\b\u0010\u0082\u0003\u001a\u00030\u0083\u0003H\u0002J\u001f\u0010±\u0003\u001a\u0004\u0018\u00010(2\t\u0010Ã\u0001\u001a\u0004\u0018\u00010(2\u0007\u0010\u0089\u0003\u001a\u00020\u0006H\u0002J\u001b\u0010²\u0003\u001a\u00020\u00062\u0007\u0010\u009a\u0003\u001a\u00020\u00062\u0007\u0010\u009b\u0003\u001a\u00020\u0006H\u0002J\u001c\u0010³\u0003\u001a\u0004\u0018\u00010(2\u0007\u0010Ã\u0001\u001a\u00020(2\u0006\u0010O\u001a\u00020\u0006H\u0002JE\u0010´\u0003\u001a\u0011\u0012\u0004\u0012\u00020v\u0012\u0004\u0012\u00020v\u0018\u00010µ\u00032\t\u0010¶\u0003\u001a\u0004\u0018\u00010v2\t\u0010·\u0003\u001a\u0004\u0018\u00010v2\u0007\u0010¸\u0003\u001a\u00020v2\f\b\u0002\u0010¹\u0003\u001a\u0005\u0018\u00010º\u0003H\u0002J&\u0010»\u0003\u001a\u0014\u0012\u0004\u0012\u00020v\u0012\u0007\u0012\u0005\u0018\u00010ì\u0002\u0018\u00010µ\u00032\t\u0010¼\u0003\u001a\u0004\u0018\u00010vH\u0002J,\u0010½\u0003\u001a\u00020 2\b\u0010¾\u0003\u001a\u00030¿\u00032\u0017\u0010À\u0003\u001a\u0012\u0012\u0004\u0012\u00020v\u0012\u0007\u0012\u0005\u0018\u00010ì\u00020µ\u0003H\u0002J\u0012\u0010Á\u0003\u001a\u00020\u00062\u0007\u0010À\u0001\u001a\u00020\u0006H\u0002J\u0011\u0010Â\u0003\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0003\u0010Ã\u0003J\u0007\u0010Ä\u0003\u001a\u00020\nJ\u0012\u0010Å\u0003\u001a\u00020\n2\u0007\u0010Í\u0001\u001a\u00020lH\u0002J\u001d\u0010Æ\u0003\u001a\u00020\u00062\t\u0010Í\u0001\u001a\u0004\u0018\u00010l2\u0007\u0010Ù\u0002\u001a\u00020\nH\u0002J\u0013\u0010Ç\u0003\u001a\u00020 2\b\u0010È\u0003\u001a\u00030É\u0003H\u0002J\u001c\u0010Ê\u0003\u001a\u00030\u0097\u00012\u0007\u0010Ã\u0001\u001a\u00020(2\t\u0010Í\u0001\u001a\u0004\u0018\u00010lJ\u000f\u0010Ë\u0003\u001a\u00020 2\u0006\u0010F\u001a\u00020\nJ\u000f\u0010Ì\u0003\u001a\u00020 2\u0006\u00108\u001a\u00020\nJ\u0010\u0010Í\u0003\u001a\u00020 2\u0007\u0010Î\u0003\u001a\u00020\nJ\u0010\u0010Ï\u0003\u001a\u00020 2\u0007\u0010Î\u0003\u001a\u00020\nJ\u000f\u0010Ð\u0003\u001a\u00020 2\u0006\u0010L\u001a\u00020\nJ\u0010\u0010Ñ\u0003\u001a\u00020 2\u0007\u0010Ò\u0003\u001a\u00020\nJ\u0007\u0010Ó\u0003\u001a\u00020 J\u0007\u0010Ô\u0003\u001a\u00020 J/\u0010Õ\u0003\u001a\u00020 2\u0007\u0010Ö\u0003\u001a\u00020v2\u0007\u0010×\u0003\u001a\u00020v2\u0007\u0010Ø\u0003\u001a\u00020v2\u000b\b\u0002\u0010È\u0002\u001a\u0004\u0018\u00010vJ\"\u0010Ù\u0003\u001a\u00020 2\u0007\u0010Ö\u0003\u001a\u00020v2\u0007\u0010×\u0003\u001a\u00020v2\u0007\u0010Ø\u0003\u001a\u00020vJ\"\u0010Ú\u0003\u001a\u00020 2\u0007\u0010Ö\u0003\u001a\u00020v2\u0007\u0010×\u0003\u001a\u00020v2\u0007\u0010Ø\u0003\u001a\u00020vJ&\u0010Û\u0003\u001a\u00020 2\u0007\u0010Ö\u0003\u001a\u00020v2\u0007\u0010×\u0003\u001a\u00020v2\u000b\b\u0002\u0010Ü\u0003\u001a\u0004\u0018\u00010vJ\u0007\u0010Ý\u0003\u001a\u00020 J\u0010\u0010Þ\u0003\u001a\u00020 2\u0007\u0010ß\u0003\u001a\u00020\nJ\t\u0010à\u0003\u001a\u00020 H\u0002J\u0010\u0010á\u0003\u001a\u00020 2\u0007\u0010â\u0003\u001a\u00020\nJ\u0007\u0010ã\u0003\u001a\u00020 J\u000b\u0010ä\u0003\u001a\u0004\u0018\u00010vH\u0016J\t\u0010å\u0003\u001a\u00020 H\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020\u00060\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00104\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u00105R\u000e\u00106\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u000f\"\u0004\b9\u0010:R\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020\n0\r¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u000fR\u0017\u0010<\u001a\b\u0012\u0004\u0012\u00020\n0\r¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u000fR\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020\n0\r¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u000fR\u0017\u0010@\u001a\b\u0012\u0004\u0012\u00020\n0\r¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u000fR\u0017\u0010B\u001a\b\u0012\u0004\u0012\u00020%0\r¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u000fR\u0017\u0010D\u001a\b\u0012\u0004\u0012\u00020%0\r¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u000fR\u0017\u0010F\u001a\b\u0012\u0004\u0012\u00020\n0\r¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\u000fR\u0017\u0010G\u001a\b\u0012\u0004\u0012\u00020\n0\r¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\u000fR\u0017\u0010H\u001a\b\u0012\u0004\u0012\u00020 0I¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0017\u0010L\u001a\b\u0012\u0004\u0012\u00020\n0\r¢\u0006\b\n\u0000\u001a\u0004\bL\u0010\u000fR\u0019\u0010M\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0\r¢\u0006\b\n\u0000\u001a\u0004\bN\u0010\u000fR\u0017\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00060\r¢\u0006\b\n\u0000\u001a\u0004\bP\u0010\u000fR\u0019\u0010Q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\r¢\u0006\b\n\u0000\u001a\u0004\bR\u0010\u000fR\u0017\u0010S\u001a\b\u0012\u0004\u0012\u00020\n0\r¢\u0006\b\n\u0000\u001a\u0004\bT\u0010\u000fR\u0017\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00110\r¢\u0006\b\n\u0000\u001a\u0004\bV\u0010\u000fR\u0017\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00130\r¢\u0006\b\n\u0000\u001a\u0004\bX\u0010\u000fR\u0017\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00150\r¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010\u000fR\u0019\u0010[\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\r¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010\u000fR\u0019\u0010]\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\r¢\u0006\b\n\u0000\u001a\u0004\b^\u0010\u000fR\u0017\u0010_\u001a\b\u0012\u0004\u0012\u00020\n0\r¢\u0006\b\n\u0000\u001a\u0004\b`\u0010\u000fR\u0017\u0010a\u001a\b\u0012\u0004\u0012\u00020\n0\r¢\u0006\b\n\u0000\u001a\u0004\bb\u0010\u000fR\u0017\u0010c\u001a\b\u0012\u0004\u0012\u00020\n0\r¢\u0006\b\n\u0000\u001a\u0004\bc\u0010\u000fR\u0017\u0010d\u001a\b\u0012\u0004\u0012\u00020\u00060\r¢\u0006\b\n\u0000\u001a\u0004\bd\u0010\u000fR\u0017\u0010e\u001a\b\u0012\u0004\u0012\u00020\n0\r¢\u0006\b\n\u0000\u001a\u0004\bf\u0010\u000fR\u0017\u0010g\u001a\b\u0012\u0004\u0012\u00020\u00060I¢\u0006\b\n\u0000\u001a\u0004\bh\u0010KR\u0019\u0010i\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0\r¢\u0006\b\n\u0000\u001a\u0004\bj\u0010\u000fR\u0010\u0010k\u001a\u0004\u0018\u00010lX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010m\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020p\u0012\u0004\u0012\u00020\u00060o0nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010t\u001a\u0014\u0012\u0004\u0012\u00020v\u0012\n\u0012\b\u0012\u0004\u0012\u00020x0w0uX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010y\u001a\u000e\u0012\u0004\u0012\u00020v\u0012\u0004\u0012\u00020\u00060uX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010z\u001a\u000e\u0012\u0004\u0012\u00020v\u0012\u0004\u0012\u00020\n0uX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010{\u001a\u000e\u0012\u0004\u0012\u00020v\u0012\u0004\u0012\u00020\u00060uX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010}\u001a\u00020\n2\u0006\u0010|\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b}\u0010~R\u0015\u0010\u007f\u001a\t\u0012\u0004\u0012\u00020%0\u0080\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0082\u0001\u001a\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\n0o0\u0080\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0088\u0001\u001a\u00030\u0089\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008a\u0001R\u001a\u0010Ï\u0001\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010(\u0018\u00010Ð\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ñ\u0001\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ò\u0001\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010Ø\u0001\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010(\u0018\u00010Ð\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010Ü\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010Ý\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0\r¢\u0006\t\n\u0000\u001a\u0005\bÞ\u0001\u0010\u000fR\u0011\u0010à\u0001\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006ì\u0003"}, d2 = {"Lcom/larus/camera/impl/ui/viewmodel/CameraResultViewModel;", "Lcom/larus/camera/impl/ui/base/BaseCameraViewModel;", "<init>", "()V", "_rotation", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_eduImageAbility", "Lcom/larus/camera/impl/edulibs/cameraapi/IEduClipImageView;", "_eduImageLoading", "", "_rawImageLoading", "rawImageLoading", "Lkotlinx/coroutines/flow/StateFlow;", "getRawImageLoading", "()Lkotlinx/coroutines/flow/StateFlow;", "_resultDetectionStatus", "Lcom/larus/camera/impl/ui/component/result/general/ResultDetectStatus;", "_resultPreviewBounds", "Landroid/graphics/Rect;", "_eduResultTabState", "Lcom/larus/camera/impl/entity/EduResultTabState;", "_resultBottomState", "Lcom/larus/camera/impl/entity/ResultBottomState;", "_resultSuggestType", "Lcom/larus/camera/impl/entity/ResultSuggestType;", "_isInCropMode", "_isInDrawingMode", "_isInMarkSelectMode", "_markInputActive", "_clearMarkSelectDrawing", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "_enableRedo", "_isImageCropped", "_enableUndo", "_redoPaint", "", "_undoPaint", "_currentBitmap", "Landroid/graphics/Bitmap;", "_bitmapToCrop", "_cropRegionChanged", "_isPhotoEditable", "_inFreeInputMode", "_hasAccessToAIBeauty", "_isSeekbarDragging", "_isMultiResultLoadComplete", "_suggestedActionBarDimmed", "_captureAppendComplete", "originRotation", "eduSelectedBoundsChange", "isEduMultiQuestionModel", "Ljava/lang/Boolean;", "currentEduIntent", "Lcom/larus/camera/impl/entity/EduIntentMode;", "isPhotoEditable", "setPhotoEditable", "(Lkotlinx/coroutines/flow/StateFlow;)V", "isImageCropped", "cropRegionChanged", "getCropRegionChanged", "enableRedo", "getEnableRedo", "enableUndo", "getEnableUndo", "redoPaint", "getRedoPaint", "undoPaint", "getUndoPaint", "isInDrawingMode", "isInMarkSelectMode", "clearMarkSelectDrawing", "Lkotlinx/coroutines/flow/SharedFlow;", "getClearMarkSelectDrawing", "()Lkotlinx/coroutines/flow/SharedFlow;", "isInCropMode", "bitmapToCrop", "getBitmapToCrop", "rotation", "getRotation", "eduImageAbility", "getEduImageAbility", "eduImageLoading", "getEduImageLoading", "resultDetectionStatus", "getResultDetectionStatus", "resultPreviewBounds", "getResultPreviewBounds", "eduResultTabState", "getEduResultTabState", "resultBottomState", "getResultBottomState", "resultSuggestType", "getResultSuggestType", "inFreeInputMode", "getInFreeInputMode", "hasAccessToAIBeauty", "getHasAccessToAIBeauty", "isSeekbarDragging", "isMultiResultLoadComplete", "suggestedActionBarDimmed", "getSuggestedActionBarDimmed", "captureAppendComplete", "getCaptureAppendComplete", "currentBitmap", "getCurrentBitmap", "currentDisplayOutputParam", "Lcom/larus/camera/api/params/OutputParam;", "reportedClipItems", "", "Lkotlin/Pair;", "Lcom/larus/camera/impl/entity/EduResultMode;", "hasBeenCropped", "hasBeenMarked", "usePreCropImageForFreeInputSubmit", "deferredEditOperations", "Lcom/flow/kmp/common/collections/ConcurrentHashMap;", "", "", "Lcom/larus/camera/impl/ui/viewmodel/CameraResultViewModel$DeferredEditOperation;", "activeMarkOperationIndex", "markSelectSessionMaskKeys", "markSelectSessionOperationSizes", "value", "isMultiResultFromCamera", "()Z", "previewThumbListStateFlowHolder", "Lcom/larus/camera/impl/utils/StateFlowHolder;", "previewThumbListStateFlow", "previewThumbListDeleteStateFlowHolder", "previewThumbListDeleteStateFlow", "setSuggestedActionBarDimmed", "dimmed", "updatePreviewThumbListDeleteState", "hasVideoDeleteBefore", "saveBitmapCallback", "com/larus/camera/impl/ui/viewmodel/CameraResultViewModel$saveBitmapCallback$1", "Lcom/larus/camera/impl/ui/viewmodel/CameraResultViewModel$saveBitmapCallback$1;", "onInitialized", "enterInitialMarkModeBeforeComponentsAttach", "setupMultiResult", "context", "Landroid/content/Context;", "enableFreeInputMode", "enable", "updateHasAccessToAIBeauty", "has", "updateSeekbarDraggingState", "isDragging", "updateEduImageAbility", "Lkotlinx/coroutines/Job;", "ability", "tryUpdateEduImageLoading", "isAnimating", "changeSelectedBounds", "changeMultiQuestionMode", "isMulti", "changeEduIntent", "eduIntentMode", "supportsEduIntentOnResultPage", "updateResultBottomState", "state", "updateEduResultTabState", "selectEduResultMode", "mode", "updatePageStyle", "closePage", "setCancelResult", "imagePath", "setResult", "code", "intent", "Landroid/content/Intent;", "openPage", "enablePageAnim", "resultCallback", "Lkotlin/Function1;", "Landroidx/activity/result/ActivityResult;", "getParamOrientation", "getParamAlbumUrl", "getParamAlbumUrlOrBitmapPath", "callback", "rotate", "rotation2Scale", "", "bitmapWidth", "bitmapHeight", "parentWidth", "parentHeight", "targetRotation", "recoverRotation", "originDegree", "changeCurrentBitmap", "previewParam", "bitmap", "from", "updateCurrentBitmap", "updateCurrentMarkedMaskBitmap", "recordCropEditOperation", "operation", "Lcom/larus/bmhome/view/crop/CropEditOperation;", "recordMarkEditOperation", "mask", "changePreviewThumbListState", "outputParam", "notifyPreviewThumbListStateChanged", "markedImageGetter", "Lkotlin/Function0;", "initialImageEditModeConsumed", "cropComponentReady", "setMarkedImageGetter", "imageGetter", "onCropComponentReady", "enterInitialImageEditModeIfReady", "getMarkedImageBitmap", "rawMarkedImageGetter", "setRawMarkedImageGetter", "setRawImageLoading", "loading", "_rawBaseBitmap", "rawBaseBitmap", "getRawBaseBitmap", "setRawBaseBitmap", "rawBitmapToCrop", "getRawBitmapToCrop", "awaitRawImageReady", "timeoutMs", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUploadBitmap", "getMarkedMaskBitmap", "outputKey", "getCurrentMarkedMaskBitmap", "shouldUseMarkSelectMode", "shouldEnableMark", "shouldDeferCurrentMarkBitmapUpdate", "setMarkInputActive", "active", "enterMarkSelectMode", "finishMarkSelectMode", "cancelMarkSelectMode", "handleUnifiedResultEditBack", "recordMarkSelectSessionSnapshot", "clearMarkSelectSession", "restoreMarkSelectSession", "commitCurrentMarkIfNeeded", "switchToCropMode", "onComplete", "inputContent", "processInputContent", "completeDirectCameraFlow", "outputContext", "Lcom/larus/camera/api/params/CameraOutputContext;", "completeWithMultiResult", "isMultiCaptureEnabled", "onMultiCameraCapture", "launchCapturePageForMultiCapture", "processCaptureResult", "result", "download", "getAiCreationMarkDownloadBitmap", "(Lcom/larus/camera/api/params/OutputParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAiCreationMarkWatermarkUrl", "shouldUseNoWatermarkForMarkDownload", "useNoWatermarkImageForMarkDownload", "getPreviewOutputParam", "albumPath", "specifyOutputParam", "(Ljava/lang/String;Lcom/larus/camera/api/params/OutputParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPreviewBitmap", "Lcom/larus/camera/impl/ui/viewmodel/PreviewBitmapState;", "recoverOrientation", "(Landroid/content/Context;Ljava/lang/String;ILcom/larus/camera/api/params/OutputParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPreviewBitmapByPath", "param", "(Landroid/content/Context;Lcom/larus/camera/api/params/OutputParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPreviewBitmapPath", "addPreviewBitmapHolder", "addPreviewBitmap", "previewBitmap", "recordPreviewBounds", "bounds", "detectedIntent", "Lcom/larus/camera/api/vlm/VLMIntentDetectResult;", "getCurrentDisplayOutputParam", "getInitialCaptureOutputParam", "currentPreviewIsVideo", "shouldUseUnifiedResultTopStyle", "shouldUseUnifiedMediaCanvas", "shouldUseUnifiedPreviewFramework", "detectStatus", "shouldUseLargeUnifiedThumbnails", "currentPreviewIsGif", "currentPreviewShouldHideEditControls", "getOriginMultiOutputParamList", "", "currentResultContainsVideo", "fromDelete", "getCurrentBitmapIndex", "isFromMultiCapture", "isFromMarkPage", "isFromCameraPage", "getInputParam", "Lcom/larus/camera/api/params/InputParam;", "getSuggestionPrefix", "isSupportMultiImages", "resultSupportMark", "resultSupportCrop", "shouldUseOriginalImageDeferredEdit", "prepareFreeInputImagePolicy", "currentOutputKey", "shouldSupportEdit", "isFromInputAttachment", "isInjectInputMode", "showCameraItemMobOnResult", "itemType", "enterResultPage", "leaveResultPageOnClose", "leaveResultPageOnSubmit", "leaveReason", "clickImageRangeOnResultPage", "itemRank", "clickRecaptureOnResultPage", "clickSubmitOnResultPage", "clickRotationOnResultPage", "clickDownloadOnResultPage", "clickSwitchQuestionOnResultPage", "clickSwitchDetectIntentOnResultPage", "buttonType", "clickInputIconOnResultPage", "clickInputFullBoxOnResultPage", "clickInputFunctionSwitchOnResultPage", "clickVideoPlayOnResultPage", "button", "showCameraItemForEduMode", "isDefault", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "clickCameraButtonForEduMode", "reportClipItemsIfNeeded", "questionCount", "shouldUseSuggestedActionCacheAsDefault", "saveMultipleResultAndCloseInternal", "saveResultInMultiCaptureMode", "createGeneralParams", "originParam", "isFromMulti", "saveSingleResultAndCloseInternal", "getSaveCallbackWhenFromCapture", "Lcom/larus/platform/model/camera/ve/ISaveBitmapResultCallback;", "isMultiQuestion", "getPreviewImage", "getBitmapForSave", "(Lcom/larus/camera/api/params/OutputParam;Landroid/graphics/Bitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyMarkedMaskIfNeeded", "recycleBitmapForSaveIfNeeded", "hasSameAspectRatio", "widthA", "heightA", "widthB", "heightB", "withOriginalImageDeferredEditLoading", "T", "block", "Lkotlin/coroutines/Continuation;", "", "(Lcom/larus/camera/api/params/OutputParam;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withBitmapSaveLoadingIfNeeded", "shouldShow", "(ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createBitmapSaveLoadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "showBitmapSaveLoadingDialog", "dialog", "(Lcom/larus/common_ui/dialog/CommonLoadDialog;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dismissBitmapSaveLoadingDialog", "getDeferredEditOperations", "getMaskContentBounds", "applyMarkOperations", "operations", "Lcom/larus/camera/impl/ui/viewmodel/CameraResultViewModel$FinalMarkOperation;", "createBitmapForMark", "scaleRect", "rect", "Landroid/graphics/RectF;", "scale", "decodeSampledBitmap", "uri", "Landroid/net/Uri;", "decodeOriginalBitmapWithEditPlan", "buildOriginalBitmapEditPlan", "Lcom/larus/camera/impl/ui/viewmodel/CameraResultViewModel$OriginalBitmapEditPlan;", "rawWidth", "rawHeight", "orientation", "normalizeRightAngleRotation", "renderOriginalBitmapEditPlan", "plan", "buildFinalSourceRegion", "originalToFinalMatrix", "Landroid/graphics/Matrix;", "finalWidth", "finalHeight", "normalizedWidth", "normalizedHeight", "getNormalizedBitmapSize", "isExifRightAngleRotated", "mapNormalizedRegionToRawRegion", "normalizedRegion", "createClippedRegion", "region", "width", "height", "createMarkTransformState", "Lcom/larus/camera/impl/ui/viewmodel/CameraResultViewModel$MarkTransformState;", "mark", "Lcom/larus/camera/impl/ui/viewmodel/CameraResultViewModel$DeferredEditOperation$Mark;", "currentWidth", "currentHeight", "intersectRectF", "first", "second", "createFinalMarkOperation", "finalBounds", "createFinalMarkBitmap", "sourceBounds", "createBitmapSourceBounds", "buildCropTransform", "Lcom/larus/camera/impl/ui/viewmodel/CameraResultViewModel$CropTransform;", "createOriginalBitmapDecodeOptions", "Landroid/graphics/BitmapFactory$Options;", "openBitmapInputStream", "Ljava/io/InputStream;", "readExifOrientation", "rotateByExif", "calculatePreviewInSampleSize", "createRotatedBitmap", "getEduMessageExt", "", "originImagePath", "eduExtraParam", "isPerspectiveCorrected", "sceneOverride", "Lcom/larus/camera/impl/edulibs/cameraapi/EduImageScene;", "parseEduExtraParam", "raw", "mergeEduExtraParam", "base", "Lorg/json/JSONObject;", "extra", "invertDegree", "boundsChanged", "()Ljava/lang/Boolean;", "isFromAlbum", "isFromAlbumInMultiCapture", "getDataSource", "logOnPreviewImageDetectFinished", "mobInfo", "Lcom/larus/camera/impl/utils/CaptureResultDetectLogic$IntentDetectAppLogInfo;", "detectPreviewImage", "setInDrawingMode", "setIsPhotoEditable", "setRedoEnabled", "enabled", "setUndoEnabled", "setInCropMode", "setCropRegionChanged", "changed", "notifyRedo", "notifyUndo", "onSingleFunctionEditButtonShow", "buttonName", "currentPage", "previousPage", "onEditEntranceEditButtonShow", "onEditEntranceEditButtonClick", "clickButton", "switchMethod", "enterCropPage", "setImageCropped", "isCropped", "resetMarkSelectSessionAfterCrop", "setImageHasBeenMarked", "hasMarked", "updateInputParamAfetrEduIntentDetected", "invokeClickFrom", "onCleared", "Companion", "DeferredEditOperation", "OriginalBitmapEditPlan", "CropTransform", "MarkTransformState", "FinalMarkOperation", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraResultViewModel extends BaseCameraViewModel {
    public static final a Companion = null;
    private static final Set<String> EDU_BASE_EXT_KEYS = null;
    private static final String EDU_MESSAGE_EXT_KEY = "Copilot:hippo:hippo_ext";
    private static final String TAG = "CameraResultViewModel";
    private final z0<Bitmap> _bitmapToCrop;
    private final MutableSharedFlow<Integer> _captureAppendComplete;
    private final MutableSharedFlow<Unit> _clearMarkSelectDrawing;
    private final z0<Boolean> _cropRegionChanged;
    private final z0<Bitmap> _currentBitmap;
    private final z0<nx8.m> _eduImageAbility;
    private final z0<Boolean> _eduImageLoading;
    private final z0<px8.b> _eduResultTabState;
    private final z0<Boolean> _enableRedo;
    private final z0<Boolean> _enableUndo;
    private final z0<Boolean> _hasAccessToAIBeauty;
    private final z0<Boolean> _inFreeInputMode;
    private final z0<Boolean> _isImageCropped;
    private final z0<Boolean> _isInCropMode;
    private final z0<Boolean> _isInDrawingMode;
    private final z0<Boolean> _isInMarkSelectMode;
    private final z0<Integer> _isMultiResultLoadComplete;
    private final z0<Boolean> _isPhotoEditable;
    private final z0<Boolean> _isSeekbarDragging;
    private final z0<Boolean> _markInputActive;
    private final z0<Bitmap> _rawBaseBitmap;
    private final z0<Boolean> _rawImageLoading;
    private final z0<Long> _redoPaint;
    private final z0<px8.e> _resultBottomState;
    private final z0<com.larus.camera.impl.ui.component.result.general.n> _resultDetectionStatus;
    private final z0<Rect> _resultPreviewBounds;
    private final z0<ResultSuggestType> _resultSuggestType;
    private final z0<Integer> _rotation;
    private final z0<Boolean> _suggestedActionBarDimmed;
    private final z0<Long> _undoPaint;
    private final vt7.a<String, Integer> activeMarkOperationIndex;
    private final i1<Bitmap> bitmapToCrop;
    private final d1<Integer> captureAppendComplete;
    private final d1<Unit> clearMarkSelectDrawing;
    private boolean cropComponentReady;
    private final i1<Boolean> cropRegionChanged;
    private final i1<Bitmap> currentBitmap;
    private OutputParam currentDisplayOutputParam;
    private EduIntentMode currentEduIntent;
    private final vt7.a<String, List<c>> deferredEditOperations;
    private final i1<nx8.m> eduImageAbility;
    private final i1<Boolean> eduImageLoading;
    private final i1<px8.b> eduResultTabState;
    private boolean eduSelectedBoundsChange;
    private final i1<Boolean> enableRedo;
    private final i1<Boolean> enableUndo;
    private final i1<Boolean> hasAccessToAIBeauty;
    private boolean hasBeenCropped;
    private boolean hasBeenMarked;
    private final i1<Boolean> inFreeInputMode;
    private boolean initialImageEditModeConsumed;
    private Boolean isEduMultiQuestionModel;
    private final i1<Boolean> isImageCropped;
    private final i1<Boolean> isInCropMode;
    private final i1<Boolean> isInDrawingMode;
    private final i1<Boolean> isInMarkSelectMode;
    private boolean isMultiResultFromCamera;
    private final i1<Integer> isMultiResultLoadComplete;
    private i1<Boolean> isPhotoEditable;
    private final i1<Boolean> isSeekbarDragging;
    private final vt7.a<String, Boolean> markSelectSessionMaskKeys;
    private final vt7.a<String, Integer> markSelectSessionOperationSizes;
    private Function0<Bitmap> markedImageGetter;
    private int originRotation;
    private final com.larus.camera.impl.utils.g0<Pair<Long, Boolean>> previewThumbListDeleteStateFlowHolder;
    private final com.larus.camera.impl.utils.g0<Long> previewThumbListStateFlowHolder;
    private final i1<Bitmap> rawBaseBitmap;
    private Bitmap rawBitmapToCrop;
    private final i1<Boolean> rawImageLoading;
    private Function0<Bitmap> rawMarkedImageGetter;
    private final i1<Long> redoPaint;
    private final Set<Pair<EduResultMode, Integer>> reportedClipItems;
    private final i1<px8.e> resultBottomState;
    private final i1<com.larus.camera.impl.ui.component.result.general.n> resultDetectionStatus;
    private final i1<Rect> resultPreviewBounds;
    private final i1<ResultSuggestType> resultSuggestType;
    private final i1<Integer> rotation;
    private final i saveBitmapCallback;
    private final i1<Boolean> suggestedActionBarDimmed;
    private final i1<Long> undoPaint;
    private boolean usePreCropImageForFreeInputSubmit;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$awaitRawImageReady$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$awaitRawImageReady$2", f = "CameraResultViewModel.kt", i = {}, l = {688}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        int label;
        final /* synthetic */ CameraResultViewModel this$0;

        /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$awaitRawImageReady$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "it"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$awaitRawImageReady$2$1", f = "CameraResultViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Boolean>, Object> {
            /* synthetic */ boolean Z$0;
            int label;

            public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                AnonymousClass1 r0 = new AnonymousClass1(r3);
                r0.Z$0 = ((Boolean) r2).booleanValue();
                return r0;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
            }

            public final Object invoke(boolean r1, Continuation<? super Boolean> r2) {
                return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                return Boxing.boxBoolean(!this.Z$0);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass2(CameraResultViewModel r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            z0 r6 = CameraResultViewModel.access$get_rawImageLoading$p(this.this$0);
            AnonymousClass1 r2 = new AnonymousClass1(null);
            this.label = 1;
            r5 = kotlinx.coroutines.flow.e.t(r6, r2, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    public static final class b {
        public final Matrix a;
        public final int b;
        public final int c;

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
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b) * 31) + this.c;
        }

        public final String toString() {
            return "CropTransform(matrix=" + this.a + ", outputWidth=" + this.b + ", outputHeight=" + this.c + ')';
        }

        public b(Matrix r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "matrix");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static abstract class c {

        public static final class a extends c {
            public final ft8.a a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Crop(operation=" + this.a + ')';
            }

            public a(ft8.a r2) {
                Intrinsics.checkNotNullParameter(r2, "operation");
                this.a = r2;
            }
        }

        public static final class b extends c {
            public final Bitmap a;
            public final int b;
            public final int c;

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
                if (this.b == r6.b) goto L15;
                return false;
            L15:
                if (this.c == r6.c) goto L17;
                return false;
            L17:
                return true;
            }

            public final int hashCode() {
                return (((this.a.hashCode() * 31) + this.b) * 31) + this.c;
            }

            public final String toString() {
                return "Mark(mask=" + this.a + ", sourceWidth=" + this.b + ", sourceHeight=" + this.c + ')';
            }

            public b(Bitmap r2, int r3, int r4) {
                Intrinsics.checkNotNullParameter(r2, "mask");
                this.a = r2;
                this.b = r3;
                this.c = r4;
            }
        }

        public c() {
        }
    }

    public static final class d {
        public final Bitmap a;
        public final Matrix b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
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
            return "FinalMarkOperation(bitmap=" + this.a + ", drawMatrix=" + this.b + ')';
        }

        public d(Bitmap r2, Matrix r3) {
            Intrinsics.checkNotNullParameter(r2, "bitmap");
            Intrinsics.checkNotNullParameter(r3, "drawMatrix");
            this.a = r2;
            this.b = r3;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$detectPreviewImage$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$detectPreviewImage$1", f = "CameraResultViewModel.kt", i = {1, 4, 5}, l = {2578, 2586, 2587, 2592, 2594, 2606, 2607}, m = "invokeSuspend", n = {"detectResult", "startTime", "detectResult"}, s = {"L$0", "J$0", "L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bitmap $bitmap;
        final /* synthetic */ OutputParam $outputParam;
        long J$0;
        Object L$0;
        int label;
        final /* synthetic */ CameraResultViewModel this$0;

        public AnonymousClass1(CameraResultViewModel r1, OutputParam r2, Bitmap r3, Continuation<? super AnonymousClass1> r4) {
            this.this$0 = r1;
            this.$outputParam = r2;
            this.$bitmap = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.this$0, this.$outputParam, this.$bitmap, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r20) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            boolean r4 = false;
            switch(this.label) {
                case 0: goto L13;
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                case 7: goto L6;
                default: goto L5;
            };
        L6:
            ResultKt.throwOnFailure(r20);
        L53:
            return Unit.INSTANCE;
        L7:
            ix8.d r2 = (ix8.d) this.L$0;
            ResultKt.throwOnFailure(r20);
        L49:
            z0 r5 = CameraResultViewModel.access$get_resultDetectionStatus$p(this.this$0);
            com.larus.camera.impl.ui.component.result.general.n.a r6 = new com.larus.camera.impl.ui.component.result.general.n.a(r2);
            this.L$0 = null;
            this.label = 7;
            if (r5.emit(r6, this) != r1) goto L53;
            return r1;
        L8:
            long r7 = this.J$0;
            ResultKt.throwOnFailure(r20);
            Object r3 = r20;
        L36:
            r2 = (ix8.d) r3;
            long r10 = System.currentTimeMillis() - r7;
            CaptureResultDetectLogic.a r8 = CaptureResultDetectLogic.a.a(CaptureResultDetectLogic.c, 0, r10, 0, 0, 0, null, r2, 61);
            CameraResultViewModel.access$logOnPreviewImageDetectFinished(this.this$0, r8);
            if (r2.a == VLMIntent.COMMON) goto L39;
        L41:
            this.this$0.updateDetectResult(r2);
            z0 r9 = CameraResultViewModel.access$get_isPhotoEditable$p(this.this$0);
            if (this.this$0.resultSupportMark() == true) goto L44;
        L46:
            Boolean r11 = Boxing.boxBoolean(r4);
            this.L$0 = r2;
            this.label = 6;
            if (r9.emit(r11, this) != r1) goto L49;
            return r1;
        L44:
            if (com.larus.camera.impl.ui.component.result.general.viewpager.u.a(this.$outputParam) == true) goto L46;
            r4 = true;
            goto L46
        L39:
            if (Intrinsics.areEqual(r2.b(), ix8.e.d.a) == false) goto L41;
            this.this$0.changeEduIntent(EduIntentMode.COMMON);
            goto L41
        L9:
            ResultKt.throwOnFailure(r20);
        L33:
            r7 = System.currentTimeMillis();
            CaptureResultDetectLogic r12 = CaptureResultDetectLogic.a;
            Bitmap r13 = this.$bitmap;
            this.J$0 = r7;
            this.label = 5;
            r3 = r12.b(r13, VLMSceneType.TAKE_PICTURE, this);
            if (r3 != r1) goto L36;
            return r1;
        L10:
            ResultKt.throwOnFailure(r20);
        L66:
            return Unit.INSTANCE;
        L11:
            ix8.d.a r14 = (ix8.d.a) this.L$0;
            ResultKt.throwOnFailure(r20);
        L62:
            z0 r15 = CameraResultViewModel.access$get_resultDetectionStatus$p(this.this$0);
            com.larus.camera.impl.ui.component.result.general.n.a r16 = new com.larus.camera.impl.ui.component.result.general.n.a(r14);
            this.L$0 = null;
            this.label = 3;
            if (r15.emit(r16, this) != r1) goto L66;
            return r1;
        L12:
            ResultKt.throwOnFailure(r20);
        L76:
            return Unit.INSTANCE;
        L13:
            ResultKt.throwOnFailure(r20);
            if (this.this$0.enableResultDetect() == true) goto L16;
        L67:
            FLogger.a.i(CameraResultViewModel.TAG, "[detectPreviewImage] skip");
            z0 r17 = CameraResultViewModel.access$get_isPhotoEditable$p(this.this$0);
            if (this.this$0.resultSupportMark() == true) goto L70;
        L72:
            Boolean r18 = Boxing.boxBoolean(r4);
            this.label = 1;
            if (r17.emit(r18, this) != r1) goto L76;
            return r1;
        L70:
            if (com.larus.camera.impl.ui.component.result.general.viewpager.u.a(this.$outputParam) == true) goto L72;
            r4 = true;
            goto L72
        L16:
            if (Intrinsics.areEqual(this.this$0.getResultDetectionStatus().getValue(), com.larus.camera.impl.ui.component.result.general.n.b.a) == false) goto L67;
            OutputParam r19 = this.$outputParam;
            if (r19 != null) goto L20;
        L22:
            boolean r21 = false;
        L23:
            if (r21 == true) goto L67;
            if (this.this$0.isFromMultiCapture() == false) goto L28;
        L54:
            r14 = new ix8.d.a(ix8.e.d.a);
            this.this$0.updateDetectResult(r14);
            z0 r22 = CameraResultViewModel.access$get_isPhotoEditable$p(this.this$0);
            if (this.this$0.resultSupportMark() == true) goto L57;
        L59:
            Boolean r23 = Boxing.boxBoolean(r4);
            this.L$0 = r14;
            this.label = 2;
            if (r22.emit(r23, this) != r1) goto L62;
            return r1;
        L57:
            if (com.larus.camera.impl.ui.component.result.general.viewpager.u.a(this.$outputParam) == true) goto L59;
            r4 = true;
            goto L59
        L28:
            if (this.this$0.isMultiResultFromCamera() == true) goto L54;
            FLogger.a.i(CameraResultViewModel.TAG, "[detectPreviewImage] start");
            z0 r24 = CameraResultViewModel.access$get_resultDetectionStatus$p(this.this$0);
            com.larus.camera.impl.ui.component.result.general.n.c r25 = com.larus.camera.impl.ui.component.result.general.n.c.a;
            this.label = 4;
            if (r24.emit(r25, this) != r1) goto L33;
            return r1;
        L20:
            if (r19.isVideo() != true) goto L22;
            r21 = true;
            goto L23
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$dismissBitmapSaveLoadingDialog$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$dismissBitmapSaveLoadingDialog$2", f = "CameraResultViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02412 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
        final /* synthetic */ com.larus.common_ui.dialog.l0 $dialog;
        int label;

        public C02412(com.larus.common_ui.dialog.l0 r1, Continuation<? super C02412> r2) {
            this.$dialog = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02412(this.$dialog, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Result<Unit>> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public static void INVOKEVIRTUAL_com_larus_camera_impl_ui_viewmodel_CameraResultViewModel$dismissBitmapSaveLoadingDialog$2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(com.larus.common_ui.dialog.l0 r3) {
            Handler r0 = DialogLancet.resolveDialogHandler(r3);
            if (r0 != null) goto L5;
        L8:
            DialogLancet.beforeDialogDismiss(r3);
            r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
        L10:
            DialogLancet.afterDialogDismiss(r3);
            return;
        L11:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r3);
            throw th;
        L13:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
            if (r1 == null) goto L10;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
            goto L10
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L8;
            r0.post(DialogLancet.createDismissRunnable(r3));
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L22;
            ResultKt.throwOnFailure(r5);
            com.larus.common_ui.dialog.l0 r6 = this.$dialog;
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L14
            boolean r1 = false;
            if (r6 != null) goto L8;
        L10:
            if (r1 == false) goto L12;
            INVOKEVIRTUAL_com_larus_camera_impl_ui_viewmodel_CameraResultViewModel$dismissBitmapSaveLoadingDialog$2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r6);     // Catch: Throwable -> L14
        L12:
            Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
        L16:
            Throwable r2 = Result.exceptionOrNull-impl(r7);
            if (r2 == null) goto L20;
            FLogger.a.e(CameraResultViewModel.TAG, "[dismissBitmapSaveLoadingDialog] fail:" + r2.getMessage());
        L20:
            return Result.box-impl(r7);
        L8:
            if (r6.isShowing() != true) goto L10;
            r1 = true;
        L14:
            th = move-exception;
            Result.Companion r3 = Result.Companion;
            r7 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L16
        L22:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$download$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$download$1", f = "CameraResultViewModel.kt", i = {}, l = {1045, 1060}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02421 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CameraResultViewModel this$0;

        public C02421(CameraResultViewModel r1, Context r2, Continuation<? super C02421> r3) {
            this.this$0 = r1;
            this.$context = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            C02421 r0 = new C02421(this.this$0, this.$context, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r3v2, types: [com.larus.camera.impl.ui.viewmodel.a0, java.lang.Object, kotlin.jvm.functions.Function1] */
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r3 = true;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r8);
        L43:
            String r9 = (String) r8;
            FLogger.a.i(CameraResultViewModel.TAG, "[download] path:" + r9);
            if (m5.c(r9) == false) goto L47;
            ShareServiceDelegate.b.y(AppHost.a.getApplication(), r9, new b0());
        L47:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r8);
        L33:
            String r10 = (String) r8;
            if (r10.length() > 0) goto L37;
            r3 = false;
        L37:
            if (r3 == false) goto L39;
            t19.s r2 = t19.s.a;
            Application r4 = AppHost.a.getApplication();
            r2.getClass();
            t19.s.o(r4, 2131908983, false);
            IAIChatService.a.n7(r10);
            goto L47
        L39:
            t19.s r11 = t19.s.a;
            Application r5 = AppHost.a.getApplication();
            r11.getClass();
            t19.s.b(r5, 2131908982, false);
            goto L47
        L10:
            ResultKt.throwOnFailure(r8);
            final CoroutineScope r12 = (CoroutineScope) this.L$0;
            if (this.this$0.currentPreviewIsVideo() == false) goto L29;
            int r6 = VideoUtils.a;
            FragmentActivity r7 = this.$context;
            OutputParam r13 = this.this$0.getCurrentDisplayOutputParam();
            if (r13 == null) goto L15;
            final String r14 = r13.getPath();
        L16:
            final CoroutineScope r15 = ViewModelKt.getViewModelScope(this.this$0);
            final ?? r16 = new a0(r12);
            Intrinsics.checkNotNullParameter(r7, "context");
            Intrinsics.checkNotNullParameter(r15, "scope");
            Intrinsics.checkNotNullParameter(r16, "finishCallback");
            FLogger.a.i("VideoUriUtils", "[saveVideo] path:" + r14);
            if (Build.VERSION.SDK_INT <= 28) goto L19;
        L27:
            VideoUtils.f(r14, r15, r16);
            goto L47
        L19:
            if (ContextCompat.checkSelfPermission(r7, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) goto L27;
            if ((r7 instanceof FragmentActivity) == false) goto L23;
            FragmentActivity r17 = r7;
        L24:
            if (r17 != null) goto L26;
            r16.invoke(null);
            goto L47
        L26:
            i2.b.a(r17, CollectionsKt.listOf(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}), new com.larus.camera.impl.utils.k0(r14, r15, r16));
            goto L47
        L23:
            r17 = null;
            goto L24
        L15:
            r14 = null;
            goto L16
        L29:
            if (this.this$0.currentPreviewIsGif() == false) goto L40;
            CoroutineDispatcher r18 = Dispatchers.getIO();
            CameraResultViewModel$download$1$uriString$1 r19 = new CameraResultViewModel$download$1$uriString$1(this.this$0, null);
            this.label = 1;
            r8 = BuildersKt.withContext(r18, r19, this);
            if (r8 != r0) goto L33;
            return r0;
        L40:
            OutputParam r20 = this.this$0.getCurrentDisplayOutputParam();
            CameraResultViewModel r21 = this.this$0;
            CameraResultViewModel$download$1$filePath$1 r22 = new CameraResultViewModel$download$1$filePath$1(r21, r20, null);
            this.label = 2;
            r8 = CameraResultViewModel.access$withOriginalImageDeferredEditLoading(r21, r20, r22, this);
            if (r8 != r0) goto L43;
            return r0;
        }
    }

    public static final class e {
        public final Bitmap a;
        public final Rect b;
        public final Matrix c;
        public final RectF d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof e) == true) goto L8;
            return false;
        L8:
            e r6 = (e) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
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

        public final int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public final String toString() {
            return "MarkTransformState(mask=" + this.a + ", sourceBounds=" + this.b + ", maskToCurrentMatrix=" + this.c + ", currentBounds=" + this.d + ')';
        }

        public e(Bitmap r2, Rect r3, Matrix r4, RectF r5) {
            Intrinsics.checkNotNullParameter(r2, "mask");
            Intrinsics.checkNotNullParameter(r3, "sourceBounds");
            Intrinsics.checkNotNullParameter(r4, "maskToCurrentMatrix");
            Intrinsics.checkNotNullParameter(r5, "currentBounds");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$enableFreeInputMode$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$enableFreeInputMode$1", f = "CameraResultViewModel.kt", i = {}, l = {329}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $enable;
        int label;
        final /* synthetic */ CameraResultViewModel this$0;

        public C02431(boolean r1, CameraResultViewModel r2, Continuation<? super C02431> r3) {
            this.$enable = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02431(this.$enable, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            FLogger.a.i(CameraResultViewModel.TAG, "[enableFreeInputMode] enable:" + this.$enable);
            z0 r6 = CameraResultViewModel.access$get_inFreeInputMode$p(this.this$0);
            Boolean r2 = Boxing.boxBoolean(this.$enable);
            this.label = 1;
            if (r6.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public static final class f {
        public final Rect a;
        public final Rect b;
        public final int c;
        public final int d;
        public final int e;
        public final Matrix f;
        public final List<d> g;
        public final int h;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof f) == true) goto L8;
            return false;
        L8:
            f r6 = (f) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (this.h == r6.h) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            return (((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h;
        }

        public final String toString() {
            return "OriginalBitmapEditPlan(normalizedRegion=" + this.a + ", rawDecodeRegion=" + this.b + ", finalWidth=" + this.c + ", finalHeight=" + this.d + ", finalRotation=" + this.e + ", originalToFinalMatrix=" + this.f + ", finalMarkOperations=" + this.g + ", cropOperationCount=" + this.h + ')';
        }

        public f(Rect r2, Rect r3, int r4, int r5, int r6, Matrix r7, List<d> r8, int r9) {
            Intrinsics.checkNotNullParameter(r2, "normalizedRegion");
            Intrinsics.checkNotNullParameter(r3, "rawDecodeRegion");
            Intrinsics.checkNotNullParameter(r7, "originalToFinalMatrix");
            Intrinsics.checkNotNullParameter(r8, "finalMarkOperations");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
        }
    }

    public /* synthetic */ class g {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[InputParam.InitialImageEditMode.values().length];
            r0[InputParam.InitialImageEditMode.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[InputParam.InitialImageEditMode.MARK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[InputParam.InitialImageEditMode.CROP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L7:
            a = r0;
            int[] r1 = new int[EduResultMode.values().length];
            r1[EduResultMode.SINGLE_QUESTION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L19:
            r1[EduResultMode.MULTI_QUESTION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L10:
            b = r1;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$getAiCreationMarkDownloadBitmap$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$getAiCreationMarkDownloadBitmap$2", f = "CameraResultViewModel.kt", i = {}, l = {1118}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02442 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
        final /* synthetic */ String $watermarkUrl;
        int label;

        public C02442(String r1, Continuation<? super C02442> r2) {
            this.$watermarkUrl = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02442(this.$watermarkUrl, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Bitmap> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L15 CancellationException -> L18
        L13:
        L22:
            return (Bitmap) r8;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r8);
            String r2 = this.$watermarkUrl;     // Catch: Throwable -> L15 CancellationException -> L18
            this.label = 1;     // Catch: Throwable -> L15 CancellationException -> L18
            r8 = ImageLoaderKt.n(r2, "camera_result_watermark_download", null, null, this, 124);     // Catch: Throwable -> L15 CancellationException -> L18
            if (r8 != r0) goto L13;
            return r0;
        L18:
            e = move-exception;
            throw e;
        L15:
            th = move-exception;
            FLogger.a.e(CameraResultViewModel.TAG, "[getAiCreationMarkDownloadBitmap] decode fail:" + th.getMessage(), th);
            return null;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$getBitmapForSave$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraResultViewModel", f = "CameraResultViewModel.kt", i = {0, 0}, l = {1839}, m = "getBitmapForSave", n = {"previewBitmap", "start"}, s = {"L$0", "J$0"})
    public static final class C02451 extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ CameraResultViewModel this$0;

        public C02451(CameraResultViewModel r1, Continuation<? super C02451> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return CameraResultViewModel.access$getBitmapForSave(this.this$0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$getParamAlbumUrlOrBitmapPath$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$getParamAlbumUrlOrBitmapPath$1", f = "CameraResultViewModel.kt", i = {}, l = {442, 444}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02461 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<String, Unit> $callback;
        int label;
        final /* synthetic */ CameraResultViewModel this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public C02461(CameraResultViewModel r1, Function1<? super String, Unit> r2, Continuation<? super C02461> r3) {
            this.this$0 = r1;
            this.$callback = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02461(this.this$0, this.$callback, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r4 = true;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r12);
        L16:
            String r13 = (String) r12;
            if (r13 != null) goto L19;
        L22:
            if (r4 == false) goto L24;
            this.$callback.invoke(null);
        L26:
            return Unit.INSTANCE;
        L24:
            this.$callback.invoke(Uri.fromFile(new PolarisFileWrapper(r13)).toString());
            goto L26
        L19:
            if (r13.length() == 0) goto L22;
            r4 = false;
            goto L22
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r12);
        L13:
            OutputParam r14 = this.this$0.getCurrentDisplayOutputParam();
            CameraResultViewModel r2 = this.this$0;
            CameraResultViewModel$getParamAlbumUrlOrBitmapPath$1$filePath$1 r5 = new CameraResultViewModel$getParamAlbumUrlOrBitmapPath$1$filePath$1(r2, r14, null);
            this.label = 2;
            r12 = CameraResultViewModel.access$withOriginalImageDeferredEditLoading(r2, r14, r5, this);
            if (r12 != r0) goto L16;
            return r0;
        L10:
            ResultKt.throwOnFailure(r12);
            CameraResultViewModel r6 = this.this$0;
            this.label = 1;
            if (CameraResultViewModel.awaitRawImageReady$default(r6, 0, this, 1, null) != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$getPreviewBitmap$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraResultViewModel", f = "CameraResultViewModel.kt", i = {0, 0, 1, 1}, l = {1182, 1184}, m = "getPreviewBitmap", n = {"context", "recoverOrientation", "previewParam", "recoverOrientation"}, s = {"L$0", "I$0", "L$0", "I$0"})
    public static final class C02471 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ CameraResultViewModel this$0;

        public C02471(CameraResultViewModel r1, Continuation<? super C02471> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r7) {
            this.result = r7;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.getPreviewBitmap(null, null, 0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$getPreviewBitmapByPath$7, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$getPreviewBitmapByPath$7", f = "CameraResultViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ OutputParam $param;
        final /* synthetic */ Uri $uri;
        int label;
        final /* synthetic */ CameraResultViewModel this$0;

        public AnonymousClass7(CameraResultViewModel r1, OutputParam r2, Context r3, Uri r4, Continuation<? super AnonymousClass7> r5) {
            this.this$0 = r1;
            this.$param = r2;
            this.$context = r3;
            this.$uri = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass7(this.this$0, this.$param, this.$context, this.$uri, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Bitmap> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r3);
            if (this.this$0.shouldUseOriginalImageDeferredEdit(this.$param) == false) goto L8;
            CameraResultViewModel r4 = this.this$0;
            Context r0 = this.$context;
            Uri r1 = this.$uri;
            Intrinsics.checkNotNull(r1);
            return CameraResultViewModel.access$decodeSampledBitmap(r4, r0, r1);
        L8:
            return CameraResultViewModel.access$ability(this.this$0).S(this.$context, this.$uri);
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$getPreviewBitmapByPath$8, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$getPreviewBitmapByPath$8", f = "CameraResultViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ Uri $uri;
        int label;
        final /* synthetic */ CameraResultViewModel this$0;

        public AnonymousClass8(CameraResultViewModel r1, Context r2, Uri r3, Continuation<? super AnonymousClass8> r4) {
            this.this$0 = r1;
            this.$context = r2;
            this.$uri = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass8(this.this$0, this.$context, this.$uri, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Bitmap> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            CameraResultViewModel r4 = this.this$0;
            Context r0 = this.$context;
            Uri r1 = this.$uri;
            Intrinsics.checkNotNull(r1);
            return CameraResultViewModel.access$decodeSampledBitmap(r4, r0, r1);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$getPreviewBitmapByPath$9, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$getPreviewBitmapByPath$9", f = "CameraResultViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass9 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
        final /* synthetic */ String $path;
        int label;

        public AnonymousClass9(String r1, Continuation<? super AnonymousClass9> r2) {
            this.$path = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass9(this.$path, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Bitmap> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            return BitmapFactory.decodeFile(this.$path);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$getPreviewOutputParam$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraResultViewModel", f = "CameraResultViewModel.kt", i = {0}, l = {1162}, m = "getPreviewOutputParam", n = {"previewParam"}, s = {"L$0"})
    public static final class C02481 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ CameraResultViewModel this$0;

        public C02481(CameraResultViewModel r1, Continuation<? super C02481> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.getPreviewOutputParam(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$getPreviewOutputParam$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$getPreviewOutputParam$2", f = "CameraResultViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02492 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $albumPath;
        final /* synthetic */ OutputParam $previewParam;
        int label;

        public C02492(String r1, OutputParam r2, Continuation<? super C02492> r3) {
            this.$albumPath = r1;
            this.$previewParam = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02492(this.$albumPath, this.$previewParam, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L62;
            ResultKt.throwOnFailure(r10);
            int r11 = VideoUtils.a;
            Application r12 = AppHost.a.getApplication();
            Uri r0 = UriProtector.parse(this.$albumPath);
            Intrinsics.checkNotNullParameter(r12, "context");
            Intrinsics.checkNotNullParameter(r0, "uri");
        L15:
            e = move-exception;
            FLogger.a.e("VideoUriUtils", "Failed to convert video URI to path: " + e.getMessage(), e);
        L17:
            String r3 = null;
        L19:
            if (r3 != null) goto L21;
        L24:
            boolean r5 = true;
        L25:
            if (r5 == false) goto L56;
            FLogger.a.i("VideoUriUtils", "Video path is null, trying to copy video to local directory");
            pq9.k.a.getClass();     // Catch: Exception -> L54
            PolarisFileWrapper r6 = new PolarisFileWrapper(pq9.k.g);     // Catch: Exception -> L54
            if (r6.exists() == true) goto L30;
            r6.mkdirs();     // Catch: Exception -> L54
        L30:
            PolarisFileWrapper r7 = new PolarisFileWrapper(r6, "video_" + System.currentTimeMillis() + '_' + UUID.randomUUID().toString().substring(0, 8) + ".mp4");     // Catch: Exception -> L54
            InputStream r13 = ContentResolverWrapper.openInputStream(r12.getContentResolver(), r0);     // Catch: Exception -> L54
            if (r13 != null) goto L68;
        L52:
            String r14 = r7.getAbsolutePath();     // Catch: Exception -> L54
            FLogger.a.i("VideoUriUtils", "Video copied successfully to: " + r14);     // Catch: Exception -> L54
        L57:
            FLogger.a.i(CameraResultViewModel.TAG, "[getPreviewOutputParam] video:" + r14);
            if (r14 == null) goto L73;
            this.$previewParam.getVideoParam().setPath(r14);
            return Unit.INSTANCE;
        L73:
            return null;
        L68:
            PolarisFileOutputStreamWrapper r1 = new PolarisFileOutputStreamWrapper(r7);     // Catch: Throwable -> L47
            byte[] r4 = new byte[8192];     // Catch: Throwable -> L42
        L35:
            int r8 = r13.read(r4);     // Catch: Throwable -> L42
            if (r8 == (-1)) goto L38;
            r1.write(r4, 0, r8);     // Catch: Throwable -> L42
            goto L35
        L38:
            r1.flush();     // Catch: Throwable -> L42
            Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L42
            CloseableKt.closeFinally(r1, null);     // Catch: Throwable -> L47
            CloseableKt.closeFinally(r13, null);     // Catch: Exception -> L54
            goto L52
        L42:
            th = move-exception;
            throw th;     // Catch: Throwable -> L44
        L44:
            th = move-exception;
            CloseableKt.closeFinally(r1, th);     // Catch: Throwable -> L47
            throw th;     // Catch: Throwable -> L47
        L47:
            th = move-exception;
            throw th;     // Catch: Throwable -> L49
        L49:
            th = move-exception;
            CloseableKt.closeFinally(r13, th);     // Catch: Exception -> L54
            throw th;     // Catch: Exception -> L54
        L54:
            e = move-exception;
            FLogger.a.e("VideoUriUtils", "Failed to copy video to local directory: " + e.getMessage(), e);
            r14 = null;
            goto L57
        L56:
            r14 = r3;
            goto L57
        L21:
            if (r3.length() == 0) goto L24;
            r5 = false;
            goto L25
        L6:
            if (Intrinsics.areEqual(ShareType.FILE, r0.getScheme()) == false) goto L9;
            r14 = r0.getPath();     // Catch: Exception -> L15
            goto L57
        L9:
            if (Intrinsics.areEqual("content", r0.getScheme()) == false) goto L17;
            if (DocumentsContract.isDocumentUri(r12, r0) == false) goto L13;
            r3 = VideoUtils.e(r12, r0);     // Catch: Exception -> L15
            goto L19
        L13:
            r3 = VideoUtils.d(r12, r0);     // Catch: Exception -> L15
            goto L19
        L62:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"com/larus/camera/impl/ui/viewmodel/CameraResultViewModel$parseEduExtraParam$1$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class h extends TypeToken<Map<String, ? extends Object>> {
        public h() {
        }
    }

    public static final class i implements pq9.h {
        public boolean a;
        public final /* synthetic */ CameraResultViewModel b;

        public i(CameraResultViewModel r1) {
            this.b = r1;
        }

        public final void a(int r5, String r6) {
            qx8.a r0 = qx8.a.b;
            if (r6 != null) goto L5;
            String r1 = "";
        L6:
            r0.f(r5, r1, this.a, this.b.isFromAlbum());
            if (r5 == 1002) goto L9;
            return;
        L9:
            if (Intrinsics.areEqual(r6, "_currentBitmap obj is null") == true) goto L20;
            IFlowSdkDepend r7 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r7 == null) goto L15;
            r7.A();
            if (m1.a.a() == true) goto L15;
            boolean r8 = true;
        L16:
            if (r8 == false) goto L21;
            t19.s r9 = t19.s.a;
            Application r10 = AppHost.a.getApplication();
            r9.getClass();
            t19.s.s(r10, 2131909198);
            return;
        L21:
            return;
        L15:
            r8 = false;
            goto L16
        L20:
            return;
        L5:
            r1 = r6;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$notifyPreviewThumbListStateChanged$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$notifyPreviewThumbListStateChanged$1", f = "CameraResultViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02501 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ OutputParam $outputParam;
        int label;
        final /* synthetic */ CameraResultViewModel this$0;

        public C02501(CameraResultViewModel r1, OutputParam r2, Continuation<? super C02501> r3) {
            this.this$0 = r1;
            this.$outputParam = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02501(this.this$0, this.$outputParam, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L13;
            ResultKt.throwOnFailure(r3);
            com.larus.camera.impl.utils.g0 r4 = CameraResultViewModel.access$getPreviewThumbListStateFlowHolder$p(this.this$0);
            OutputParam r0 = this.$outputParam;
            if (r0 == null) goto L9;
            ImageParam r1 = r0.getImageParam();
            if (r1 == null) goto L9;
            long r2 = r1.getBitmapChangedTime();
        L10:
            Long r5 = Boxing.boxLong(r2);
            r4.a.setValue(r5);
            return Unit.INSTANCE;
        L9:
            r2 = System.currentTimeMillis();
            goto L10
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$processCaptureResult$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$processCaptureResult$1", f = "CameraResultViewModel.kt", i = {}, l = {1017}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02511 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<OutputParam> $newOutputParamList;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ CameraResultViewModel this$0;

        public C02511(List<OutputParam> r1, CameraResultViewModel r2, Continuation<? super C02511> r3) {
            this.$newOutputParamList = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02511(this.$newOutputParamList, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0063 -> B:21:0x0066). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            Iterator r2 = (Iterator) this.L$1;
            CameraResultViewModel r3 = (CameraResultViewModel) this.L$0;
            ResultKt.throwOnFailure(r14);
            C02511 r11 = this;
        L21:
            o0 r15 = (o0) r14;
            t r4 = t.a;
            t.a(r15.b, r15.a, "processCaptureResult");
            FLogger.a.i(CameraResultViewModel.TAG, "[processCaptureResult] added bitmap for outputParam:" + r15.b);
            CameraResultViewModel r16 = r3;
        L10:
            if (r2.hasNext() == false) goto L22;
            OutputParam r7 = (OutputParam) r2.next();
            Application r5 = AppHost.a.getApplication();
            if (r7 == null) goto L14;
            String r6 = r7.getSrcAlbumUri();
        L15:
            if (r6 != null) goto L17;
            r6 = "";
        L17:
            r11.L$0 = r16;
            r11.L$1 = r2;
            r11.label = 1;
            Object r8 = CameraResultViewModel.getPreviewBitmap$default(r16, r5, r6, 0, r7, r11, 4, null);
            if (r8 != r0) goto L20;
            return r0;
        L20:
            r3 = r16;
            r14 = r8;
            goto L21
        L14:
            r6 = null;
            goto L15
        L22:
            CameraResultViewModel.access$get_captureAppendComplete$p(r11.this$0).tryEmit(Boxing.boxInt(r11.$newOutputParamList.size()));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r14);
            List<OutputParam> r17 = this.$newOutputParamList;
            CameraResultViewModel r9 = this.this$0;
            r11 = this;
            r2 = r17.iterator();
            r16 = r9;
            goto L10
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$recordPreviewBounds$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$recordPreviewBounds$1", f = "CameraResultViewModel.kt", i = {}, l = {1267}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02521 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Rect $bounds;
        int label;
        final /* synthetic */ CameraResultViewModel this$0;

        public C02521(Rect r1, CameraResultViewModel r2, Continuation<? super C02521> r3) {
            this.$bounds = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02521(this.$bounds, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            FLogger.a.i(CameraResultViewModel.TAG, "[recordPreviewBounds] emit bounds:" + this.$bounds);
            z0 r6 = CameraResultViewModel.access$get_resultPreviewBounds$p(this.this$0);
            Rect r2 = this.$bounds;
            this.label = 1;
            if (r6.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$recoverRotation$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$recoverRotation$1", f = "CameraResultViewModel.kt", i = {}, l = {507}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02531 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $originDegree;
        int label;
        final /* synthetic */ CameraResultViewModel this$0;

        public C02531(CameraResultViewModel r1, int r2, Continuation<? super C02531> r3) {
            this.this$0 = r1;
            this.$originDegree = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02531(this.this$0, this.$originDegree, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            t r6 = t.a;
            OutputParam r7 = t.l(CameraResultViewModel.access$getCurrentDisplayOutputParam$p(this.this$0), this.$originDegree);
            if (r7 == null) goto L14;
            CameraResultViewModel.access$setCurrentDisplayOutputParam$p(this.this$0, r7);
        L14:
            CameraResultViewModel r8 = this.this$0;
            CameraResultViewModel.access$setOriginRotation$p(r8, ((Number) r8.getRotation().getValue()).intValue());
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            z0 r9 = CameraResultViewModel.access$get_rotation$p(this.this$0);
            Integer r2 = Boxing.boxInt(CameraResultViewModel.access$invertDegree(this.this$0, this.$originDegree));
            this.label = 1;
            if (r9.emit(r2, this) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$rotate$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$rotate$1", f = "CameraResultViewModel.kt", i = {}, l = {474}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02541 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $newRotation;
        int label;
        final /* synthetic */ CameraResultViewModel this$0;

        public C02541(CameraResultViewModel r1, int r2, Continuation<? super C02541> r3) {
            this.this$0 = r1;
            this.$newRotation = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02541(this.this$0, this.$newRotation, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            z0 r5 = CameraResultViewModel.access$get_rotation$p(this.this$0);
            Integer r2 = Boxing.boxInt(this.$newRotation);
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$saveMultipleResultAndCloseInternal$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$saveMultipleResultAndCloseInternal$1", f = "CameraResultViewModel.kt", i = {}, l = {1549}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<List<OutputParam>, Unit> $callback;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CameraResultViewModel this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public C02551(CameraResultViewModel r1, Function1<? super List<OutputParam>, Unit> r2, Continuation<? super C02551> r3) {
            this.this$0 = r1;
            this.$callback = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            C02551 r0 = new C02551(this.this$0, this.$callback, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L23:
            Function1<List<OutputParam>, Unit> r2 = this.$callback;
            r2.invoke((List) r10);
            FLogger.a.i(CameraResultViewModel.TAG, "[saveMultipleBitmapAndCloseInternal] end");
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            CoroutineScope r11 = (CoroutineScope) this.L$0;
            FLogger.a.i(CameraResultViewModel.TAG, "[saveMultipleBitmapAndCloseInternal] start");
            t r3 = t.a;
            List r4 = t.f();
            CameraResultViewModel r5 = this.this$0;
            List r6 = r4;
            if ((r6 instanceof Collection) == true) goto L11;
        L13:
            Iterator r7 = r6.iterator();
        L15:
            if (r7.hasNext() == false) goto L19;
            if (r5.shouldUseOriginalImageDeferredEdit((OutputParam) r7.next()) == false) goto L15;
            boolean r8 = true;
        L20:
            CameraResultViewModel$saveMultipleResultAndCloseInternal$1$savedOutputParamList$2 r9 = new CameraResultViewModel$saveMultipleResultAndCloseInternal$1$savedOutputParamList$2(r4, r11, this.this$0, null);
            this.label = 1;
            r10 = CameraResultViewModel.access$withBitmapSaveLoadingIfNeeded(r5, r8, r9, this);
            if (r10 != r0) goto L23;
            return r0;
        L19:
            r8 = false;
            goto L20
        L11:
            if (r6.isEmpty() == false) goto L13;
            goto L13
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$saveResultInMultiCaptureMode$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraResultViewModel", f = "CameraResultViewModel.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {1583, 1585}, m = "saveResultInMultiCaptureMode", n = {"outputParam", "savedOutputParam", "previewBitmap", "outputParam", "savedOutputParam", "previewBitmap", "bitmap"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
    public static final class C02561 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ CameraResultViewModel this$0;

        public C02561(CameraResultViewModel r1, Continuation<? super C02561> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return CameraResultViewModel.access$saveResultInMultiCaptureMode(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$saveSingleResultAndCloseInternal$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$saveSingleResultAndCloseInternal$1", f = "CameraResultViewModel.kt", i = {1}, l = {1658, 1705}, m = "invokeSuspend", n = {"outputParam"}, s = {"L$0"})
    public static final class C02571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<OutputParam, Unit> $callback;
        Object L$0;
        int label;
        final /* synthetic */ CameraResultViewModel this$0;

        /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$saveSingleResultAndCloseInternal$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$saveSingleResultAndCloseInternal$1$2", f = "CameraResultViewModel.kt", i = {1, 2, 2}, l = {1708, 1712, 1756}, m = "invokeSuspend", n = {"bitmap", "bitmap", "filePath"}, s = {"L$6", "L$5", "L$6"})
        public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            final /* synthetic */ OutputParam $currentOutputParam;
            final /* synthetic */ Bitmap $eduBitmapForSubmit;
            final /* synthetic */ nx8.m $eduImage;
            final /* synthetic */ String $isPerspectiveCorrected;
            final /* synthetic */ Bitmap $markUploadBitmap;
            final /* synthetic */ int $orientation;
            final /* synthetic */ OutputParam $outputParam;
            final /* synthetic */ Bitmap $previewBitmap;
            final /* synthetic */ boolean $useOriginalImageDeferredEdit;
            final /* synthetic */ boolean $usePreCropImageForFreeInput;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            boolean Z$0;
            boolean Z$1;
            int label;
            final /* synthetic */ CameraResultViewModel this$0;

            /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$saveSingleResultAndCloseInternal$1$2$a */
            public /* synthetic */ class a {
                public static final /* synthetic */ int[] a = null;

                static {
                    int[] r0 = new int[EduIntentMode.values().length];
                    r0[EduIntentMode.SINGLE_QUESTION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
                L9:
                    r0[EduIntentMode.MULTI_QUESTION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
                L5:
                    a = r0;
                }
            }

            public AnonymousClass2(Bitmap r1, Bitmap r2, CameraResultViewModel r3, OutputParam r4, Bitmap r5, int r6, OutputParam r7, boolean r8, nx8.m r9, String r10, boolean r11, Continuation<? super AnonymousClass2> r12) {
                this.$eduBitmapForSubmit = r1;
                this.$markUploadBitmap = r2;
                this.this$0 = r3;
                this.$currentOutputParam = r4;
                this.$previewBitmap = r5;
                this.$orientation = r6;
                this.$outputParam = r7;
                this.$useOriginalImageDeferredEdit = r8;
                this.$eduImage = r9;
                this.$isPerspectiveCorrected = r10;
                this.$usePreCropImageForFreeInput = r11;
                super(1, r12);
            }

            public final Continuation<Unit> create(Continuation<?> r15) {
                return new AnonymousClass2(this.$eduBitmapForSubmit, this.$markUploadBitmap, this.this$0, this.$currentOutputParam, this.$previewBitmap, this.$orientation, this.$outputParam, this.$useOriginalImageDeferredEdit, this.$eduImage, this.$isPerspectiveCorrected, this.$usePreCropImageForFreeInput, r15);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1) {
                return invoke((Continuation) r1);
            }

            public final Object invoke(Continuation<? super Unit> r2) {
                return create(r2).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v66 */
            /* JADX WARN: Type inference failed for: r0v67, types: [ix8.d$b] */
            /* JADX WARN: Type inference failed for: r0v79 */
            /* JADX WARN: Type inference failed for: r2v36 */
            /* JADX WARN: Type inference failed for: r2v37, types: [nx8.i] */
            /* JADX WARN: Type inference failed for: r2v49 */
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
            public final Object invokeSuspend(Object r25) {
                String r3 = "[saveBitmapAndCloseInternal] save origin image, intent:";
                Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r5 = this.label;
                String r6 = "1";
                if (r5 == 0) goto L21;
                if (r5 == 1) goto L20;
                if (r5 == 2) goto L14;
                if (r5 != 3) goto L13;
                boolean r0 = this.Z$0;
                final String r2 = (String) this.L$6;
                Bitmap r7 = (Bitmap) this.L$5;
                String r8 = (String) this.L$4;
                Bitmap r9 = (Bitmap) this.L$3;
                Bitmap r10 = (Bitmap) this.L$2;
                OutputParam r14 = (OutputParam) this.L$1;
                CameraResultViewModel r15 = (CameraResultViewModel) this.L$0;
                ResultKt.throwOnFailure(r25);     // Catch: Throwable -> L10
                r3 = "[saveBitmapAndCloseInternal] save origin image, intent:";
                r6 = "1";
                String r18 = "";
                String r11 = CameraResultViewModel.TAG;
                String r13 = null;
                boolean r12 = r0;
                Object r1 = r25;
            L122:
                FLogger.a.i(r11, r3 + CameraResultViewModel.access$getCurrentEduIntent$p(r15) + ", path:" + ((String) r1));     // Catch: Throwable -> L10
                String r16 = (String) r1;     // Catch: Throwable -> L10
                OutputParam r17 = r14;
            L124:
                ImageParam r19 = new ImageParam();     // Catch: Throwable -> L10
                r19.setWidth(r7.getWidth());     // Catch: Throwable -> L10
                r19.setHeight(r7.getHeight());     // Catch: Throwable -> L10
                if (r2 != null) goto L127;
                String r20 = r18;
            L128:
                r19.setPath(r20);     // Catch: Throwable -> L10
                int r21 = com.larus.utils.l0.a;     // Catch: Throwable -> L10
                r19.setSize(((Number) com.larus.utils.l0.a(Boxing.boxLong(0), new c0(r2))).longValue());     // Catch: Throwable -> L10
                r19.setRotation(((Number) CameraResultViewModel.access$get_rotation$p(r15).getValue()).intValue());     // Catch: Throwable -> L10
                EduIntentMode.a r22 = EduIntentMode.Companion;     // Catch: Throwable -> L10
                EduIntentMode r23 = CameraResultViewModel.access$getCurrentEduIntent$p(r15);     // Catch: Throwable -> L10
                r22.getClass();     // Catch: Throwable -> L10
                r19.setDetectIntent(EduIntentMode.a.b(r23));     // Catch: Throwable -> L10
                r19.setPhotoMarked(CameraResultViewModel.access$getHasBeenMarked$p(r15));     // Catch: Throwable -> L10
                r19.setPhotoCropped(CameraResultViewModel.access$getHasBeenCropped$p(r15));     // Catch: Throwable -> L10
                InputParam r24 = r15.getInputParam();     // Catch: Throwable -> L10
                if (r24 == null) goto L133;
                InputParamExtra r26 = r24.getExtra();     // Catch: Throwable -> L10
                if (r26 == null) goto L133;
                String r27 = (String) r26.get(InputParamExtra.KEY_IS_AI_CREATION);     // Catch: Throwable -> L10
            L134:
                String r28 = r6;
                r19.setAiCreation(Intrinsics.areEqual(r27, r28));     // Catch: Throwable -> L10
                r17.setImageParam(r19);     // Catch: Throwable -> L10
                if (r15.enableResultDetect() == true) goto L137;
            L138:
                ix8.d r29 = r15.detectedIntent();     // Catch: Throwable -> L10
                if ((r29 instanceof ix8.d.b) == false) goto L141;
                ?? r30 = (ix8.d.b) r29;     // Catch: Throwable -> L10
            L142:
                if (r30 == 0) goto L144;
                String r31 = r30.j;     // Catch: Throwable -> L10
            L145:
                nx8.i.f r32 = nx8.i.f.d;     // Catch: Throwable -> L10
                if (r12 == false) goto L148;
                ?? r33 = r32;
            L149:
                Map<? extends String, ? extends String> r34 = CameraResultViewModel.access$getEduMessageExt(r15, r16, r31, r8, r33);     // Catch: Throwable -> L10
                if (r34 == null) goto L152;
                r17.getExt().putAll(r34);     // Catch: Throwable -> L10
            L152:
                if (r7 == r10) goto L172;
                CameraResultViewModel.access$recycleBitmapForSaveIfNeeded(r15, r9, r7);
            L172:
                if (this.$outputParam.getPath().length() <= 0) goto L174;
                boolean r35 = true;
            L175:
                if (r35 == false) goto L177;
                qx8.a r36 = qx8.a.b;
                boolean r37 = this.this$0.isFromAlbum();
                gx8.b r38 = r36.a;
                CameraEvent r39 = CameraEvent.SAVE_LOCAL_RESULT;
                JSONObject r40 = new JSONObject();
                r40.put("is_success", r28);
                r40.put("from_album", r37 ? 1 : 0);
                Unit r41 = Unit.INSTANCE;
                r38.b(r39, r40);
            L177:
                FLogger.a.i(r11, "[saveBitmapAndCloseInternal] output:" + this.$outputParam);
                return Unit.INSTANCE;
            L174:
                r35 = false;
                goto L175
            L148:
                r33 = r13;
                goto L149
            L144:
                r31 = r13;
                goto L145
            L141:
                r30 = r13;
                goto L142
            L137:
                if (CameraResultViewModel.access$getCurrentEduIntent$p(r15) == EduIntentMode.COMMON) goto L152;
            L133:
                r27 = r13;
                goto L134
            L127:
                r20 = r2;
            L10:
                th = th;
                Bitmap r42 = r7;
                CameraResultViewModel r43 = r15;
                Bitmap r210 = r10;
                Bitmap r110 = r9;
                Bitmap r44 = r210;
            L160:
                if (r42 == r44) goto L162;
                CameraResultViewModel.access$recycleBitmapForSaveIfNeeded(r43, r110, r42);
            L162:
                throw th;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                boolean r45 = this.Z$1;
                boolean r111 = this.Z$0;
                Bitmap r112 = (Bitmap) this.L$6;
                String r46 = (String) this.L$5;
                Bitmap r47 = (Bitmap) this.L$4;
                r10 = (Bitmap) this.L$3;
                r17 = (OutputParam) this.L$2;
                nx8.m r113 = (nx8.m) this.L$1;
                CameraResultViewModel r48 = (CameraResultViewModel) this.L$0;
                ResultKt.throwOnFailure(r25);     // Catch: Throwable -> L18
                r12 = r45;
                Object r49 = r25;
                Bitmap r211 = r47;
                r43 = r48;
                r8 = r46;
            L17:
                r9 = r211;
                r2 = (String) r49;     // Catch: Throwable -> L156
                r11 = CameraResultViewModel.TAG;
                FLogger.a.i(r11, "[saveBitmapAndCloseInternal] path:" + r2);     // Catch: Throwable -> L156
                if (com.larus.utils.o0.d(r2) == false) goto L105;
                ConcurrentHashMap<String, Bitmap> r50 = com.larus.camera.impl.utils.e0.a;     // Catch: Throwable -> L156
                OutputParam r51 = r43.getCurrentDisplayOutputParam();     // Catch: Throwable -> L156
                if (r51 == null) goto L41;
                String r114 = r51.getPath();     // Catch: Throwable -> L156
            L42:
                com.larus.camera.impl.utils.e0.c(r2, r114);     // Catch: Throwable -> L156
                if (CameraResultViewModel.access$getHasBeenCropped$p(r43) == false) goto L45;
            L48:
                boolean r52 = true;
            L49:
                Boolean r53 = Boxing.boxBoolean(r52);     // Catch: Throwable -> L156
                if (r2 != null) goto L52;
            L55:
                boolean r54 = true;
            L56:
                if (r54 == true) goto L60;
                if (r53 == null) goto L60;
                com.larus.camera.impl.utils.e0.c.put(r2, r53);     // Catch: Throwable -> L156
            L60:
                if (r111 == true) goto L189;
                Result.Companion r55 = Result.Companion;     // Catch: Throwable -> L71
                Bitmap r56 = r112.copy(com.larus.utils.z0.b(r112.getConfig()), false);     // Catch: Throwable -> L69
                if (r2 != null) goto L66;
                String r115 = "";
            L67:
                com.larus.camera.impl.utils.e0.b(r115, r56);     // Catch: Throwable -> L69
                Object r57 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L69
            L74:
                Throwable r58 = Result.exceptionOrNull-impl(r57);     // Catch: Throwable -> L156
                if (r58 == null) goto L189;
                FLogger.a.e(r11, "[saveBitmapAndCloseInternal] copy bitmap fail " + r58.getMessage());     // Catch: Throwable -> L156
                ConcurrentHashMap<String, Bitmap> r59 = com.larus.camera.impl.utils.e0.a;     // Catch: Throwable -> L156
                if (r2 != null) goto L79;
                String r60 = r18;
            L80:
                com.larus.camera.impl.utils.e0.a(r60);     // Catch: Throwable -> L156
                goto L189
            L79:
                r60 = r2;
                goto L80
            L66:
                r115 = r2;
            L69:
                th = th;
            L73:
                Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L156
                r57 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
            L71:
                th = th;
            L189:
                Result.Companion r61 = Result.Companion;     // Catch: Throwable -> L103
                if (r10 == null) goto L84;
                if (r2 != null) goto L99;
                String r62 = r18;
            L100:
                Unit r117 = Result.box-impl(com.larus.camera.impl.utils.y.b(r62));     // Catch: Throwable -> L103
            L101:
                Result.constructor-impl(r117);     // Catch: Throwable -> L103
            L99:
                r62 = r2;
                goto L100
            L84:
                if (r43.isFromAlbum() == false) goto L86;
                String r118 = vqc.d.d(AppHost.a.getApplication(), Uri.parse(r43.getParamAlbumUrl()));     // Catch: Throwable -> L103
            L90:
                if (r118 == null) goto L96;
                ExifInterface r63 = new ExifInterface(r118);     // Catch: Throwable -> L103
                if (r2 != null) goto L94;
                String r64 = r18;
            L95:
                com.larus.camera.impl.utils.y.a(r63, r64);     // Catch: Throwable -> L103
                r117 = Unit.INSTANCE;     // Catch: Throwable -> L103
                goto L101
            L94:
                r64 = r2;
                goto L95
            L96:
                r117 = null;
                goto L101
            L86:
                OutputParam r65 = r43.getCurrentDisplayOutputParam();     // Catch: Throwable -> L103
                if (r65 == null) goto L89;
                r118 = r65.getPath();     // Catch: Throwable -> L103
                goto L90
            L89:
                r118 = null;
            L103:
                th = move-exception;
                Result.Companion r66 = Result.Companion;     // Catch: Throwable -> L156
                Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
                goto L105
            L52:
                if (r2.length() == 0) goto L55;
                r54 = false;
                goto L56
            L45:
                if (CameraResultViewModel.access$getHasBeenMarked$p(r43) == true) goto L48;
                r52 = false;
                goto L49
            L41:
                r114 = null;
            L105:
                int r67 = a.a[CameraResultViewModel.access$getCurrentEduIntent$p(r43).ordinal()];     // Catch: Throwable -> L156
                if (r67 == 1) goto L113;
                if (r67 != 2) goto L116;
                if (r113 == null) goto L116;
                Bitmap r119 = r113.b();     // Catch: Throwable -> L156
            L117:
                if (r119 == null) goto L123;
                CoroutineDispatcher r68 = Dispatchers.getIO();     // Catch: Throwable -> L156
                r13 = null;
                CameraResultViewModel$saveSingleResultAndCloseInternal$1$2$1$originFilePath$1$1 r69 = new CameraResultViewModel$saveSingleResultAndCloseInternal$1$2$1$originFilePath$1$1(r43, r119, null);     // Catch: Throwable -> L156
                this.L$0 = r43;     // Catch: Throwable -> L156
                this.L$1 = r17;     // Catch: Throwable -> L156
                this.L$2 = r10;     // Catch: Throwable -> L156
                this.L$3 = r9;     // Catch: Throwable -> L156
                this.L$4 = r8;     // Catch: Throwable -> L156
                this.L$5 = r112;     // Catch: Throwable -> L156
                this.L$6 = r2;     // Catch: Throwable -> L156
                this.Z$0 = r12;     // Catch: Throwable -> L156
                this.label = 3;     // Catch: Throwable -> L156
                r1 = BuildersKt.withContext(r68, r69, this);     // Catch: Throwable -> L156
                if (r1 != r4) goto L121;
                return r4;
            L121:
                r14 = r17;
                r7 = r112;
                r15 = r43;
                goto L122
            L123:
                r13 = null;
                r16 = null;
                r7 = r112;
                r15 = r43;
            L116:
                r119 = null;
                goto L117
            L113:
                if (z2.a.eduUploadOriginImage() == false) goto L116;
                if (r113 == null) goto L116;
                r119 = r113.e();     // Catch: Throwable -> L156
            L156:
                th = th;
                r48 = r43;
                r47 = r9;
            L158:
                r44 = r10;
                r110 = r47;
                r43 = r48;
                r42 = r112;
            L18:
                th = th;
                goto L158
            L20:
                ResultKt.throwOnFailure(r25);
                Object r70 = r25;
            L28:
                r42 = (Bitmap) r70;
            L29:
                FLogger.a.i(CameraResultViewModel.TAG, "[saveBitmapAndCloseInternal] bitmap:" + r42 + ", orientation:" + this.$orientation);
                if (r42 == null) goto L163;
                r43 = this.this$0;
                r111 = this.$useOriginalImageDeferredEdit;
                r113 = this.$eduImage;
                r17 = this.$outputParam;
                r44 = this.$eduBitmapForSubmit;
                r110 = this.$previewBitmap;
                int r120 = this.$orientation;
                String r121 = this.$isPerspectiveCorrected;
                r12 = this.$usePreCropImageForFreeInput;
                CoroutineDispatcher r71 = Dispatchers.getIO();     // Catch: Throwable -> L159
                CameraResultViewModel$saveSingleResultAndCloseInternal$1$2$1$filePath$1 r72 = new CameraResultViewModel$saveSingleResultAndCloseInternal$1$2$1$filePath$1(r43, r42, r120, null);     // Catch: Throwable -> L159
                this.L$0 = r43;     // Catch: Throwable -> L159
                this.L$1 = r113;     // Catch: Throwable -> L159
                this.L$2 = r17;     // Catch: Throwable -> L159
                this.L$3 = r44;     // Catch: Throwable -> L159
                this.L$4 = r110;     // Catch: Throwable -> L159
                this.L$5 = r121;     // Catch: Throwable -> L159
                this.L$6 = r42;     // Catch: Throwable -> L159
                this.Z$0 = r111;     // Catch: Throwable -> L159
                this.Z$1 = r12;     // Catch: Throwable -> L159
                this.label = 2;     // Catch: Throwable -> L159
                r49 = BuildersKt.withContext(r71, r72, this);     // Catch: Throwable -> L159
                if (r49 != r4) goto L35;
                return r4;
            L35:
                r112 = r42;
                r8 = r121;
                r211 = r110;
                r10 = r44;
            L159:
                th = th;
                goto L160
            L163:
                r28 = "1";
                r11 = CameraResultViewModel.TAG;
                qx8.a r73 = qx8.a.b;
                nx8.m r74 = (nx8.m) this.this$0.getEduImageAbility().getValue();
                if (r74 == null) goto L169;
                if (r74.d() != true) goto L169;
                boolean r75 = true;
            L170:
                r73.f(1002, "_currentBitmap obj is null", r75, this.this$0.isFromAlbum());
                Unit r76 = Unit.INSTANCE;
            L169:
                r75 = false;
                goto L170
            L21:
                ResultKt.throwOnFailure(r25);
                r42 = this.$eduBitmapForSubmit;
                if (r42 != null) goto L29;
                r42 = this.$markUploadBitmap;
                if (r42 != null) goto L29;
                CameraResultViewModel r77 = this.this$0;
                OutputParam r78 = this.$currentOutputParam;
                Bitmap r79 = this.$previewBitmap;
                this.label = 1;
                r70 = CameraResultViewModel.access$getBitmapForSave(r77, r78, r79, this);
                if (r70 != r4) goto L28;
                return r4;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C02571(CameraResultViewModel r1, Function1<? super OutputParam, Unit> r2, Continuation<? super C02571> r3) {
            this.this$0 = r1;
            this.$callback = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02571(this.this$0, this.$callback, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r25) {
            Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            boolean r9 = true;
            if (r0 == 0) goto L10;
            if (r0 == 1) goto L9;
            if (r0 != 2) goto L8;
            OutputParam r1 = (OutputParam) this.L$0;
            ResultKt.throwOnFailure(r25);
        L75:
            this.$callback.invoke(r1);
            CameraResultViewModel.access$setUsePreCropImageForFreeInputSubmit$p(this.this$0, false);
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r25);
        L13:
            boolean r22 = CameraResultViewModel.access$getUsePreCropImageForFreeInputSubmit$p(this.this$0);
            OutputParam r2 = this.this$0.getCurrentDisplayOutputParam();
            OutputParam r3 = CameraResultViewModel.access$createGeneralParams(this.this$0, new OutputParam(), r2, false);
            FLogger r4 = FLogger.a;
            r4.i(CameraResultViewModel.TAG, "[saveSingleResultAndCloseInternal] getOutputParam: " + r2);
            if (r2 != null) goto L16;
        L18:
            boolean r5 = false;
        L19:
            if (r5 == false) goto L30;
            t r6 = t.a;
            Bitmap r8 = t.c(r3);
            VideoParam r10 = new VideoParam();
            r10.setPath(r2.getVideoParam().getPath());
            if (r8 == null) goto L23;
            int r11 = r8.getWidth();
        L24:
            r10.setWidth(r11);
            if (r8 == null) goto L27;
            int r12 = r8.getHeight();
        L28:
            r10.setHeight(r12);
            r3.setVideoParam(r10);
            r4.i(CameraResultViewModel.TAG, "[saveSingleResultAndCloseInternal] final:" + r3);
            this.$callback.invoke(r3);
            CameraResultViewModel.access$setUsePreCropImageForFreeInputSubmit$p(this.this$0, false);
            return Unit.INSTANCE;
        L27:
            r12 = r2.getVideoParam().getHeight();
            goto L28
        L23:
            r11 = r2.getVideoParam().getWidth();
            goto L24
        L30:
            nx8.m r20 = (nx8.m) this.this$0.getEduImageAbility().getValue();
            if (com.larus.camera.impl.utils.k.a() == true) goto L39;
            if (r22 == false) goto L36;
            if (r20 == null) goto L39;
            Bitmap r13 = r20.b();
        L38:
            Bitmap r14 = r13;
        L40:
            boolean r19 = this.this$0.shouldUseOriginalImageDeferredEdit(r2);
            if (r14 == null) goto L43;
            boolean r15 = true;
        L44:
            if (r15 == false) goto L52;
            if (r20 != null) goto L47;
        L49:
            r9 = false;
        L50:
            if (r9 == false) goto L52;
            String r16 = "1";
        L53:
            String r21 = r16;
            if (r15 == true) goto L62;
            if (r19 == true) goto L62;
            if (this.this$0.resultSupportMark() == true) goto L59;
        L61:
            int r17 = ((Number) this.this$0.getRotation().getValue()).intValue();
        L63:
            Bitmap r18 = CameraResultViewModel.access$getPreviewImage(this.this$0);
            if (this.this$0.resultSupportMark() == true) goto L66;
        L70:
            Bitmap r110 = null;
        L71:
            CameraResultViewModel r23 = this.this$0;
            AnonymousClass2 r24 = new AnonymousClass2(r14, r110, r23, r2, r18, r17, r3, r19, r20, r21, r22, null);
            this.L$0 = r3;
            this.label = 2;
            if (CameraResultViewModel.access$withOriginalImageDeferredEditLoading(r23, r2, r24, this) != r7) goto L74;
            return r7;
        L74:
            r1 = r3;
            goto L75
        L66:
            if (CameraResultViewModel.access$getRawMarkedImageGetter$p(this.this$0) == null) goto L70;
            Function0 r26 = CameraResultViewModel.access$getRawMarkedImageGetter$p(this.this$0);
            if (r26 == null) goto L70;
            r110 = (Bitmap) r26.invoke();
            goto L71
        L59:
            if (CameraResultViewModel.access$getMarkedImageGetter$p(this.this$0) == null) goto L61;
        L62:
            r17 = 0;
            goto L63
        L47:
            if (r20.p() != true) goto L49;
        L52:
            r16 = TriggerSendLoading.NO_LOADING;
            goto L53
        L43:
            r15 = false;
            goto L44
        L36:
            if (r20 == null) goto L39;
            r13 = r20.h();
        L39:
            r14 = null;
            goto L40
        L16:
            if (r2.isVideo() != true) goto L18;
            r5 = true;
            goto L19
        L10:
            ResultKt.throwOnFailure(r25);
            CameraResultViewModel r27 = this.this$0;
            this.label = 1;
            if (CameraResultViewModel.awaitRawImageReady$default(r27, 0, this, 1, null) != r7) goto L13;
            return r7;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$setupMultiResult$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$setupMultiResult$1", f = "CameraResultViewModel.kt", i = {0}, l = {314, 322}, m = "invokeSuspend", n = {"outputParam"}, s = {"L$3"})
    public static final class C02581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ List<OutputParam> $outputParamList;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ CameraResultViewModel this$0;

        public C02581(List<OutputParam> r1, CameraResultViewModel r2, Context r3, Continuation<? super C02581> r4) {
            this.$outputParamList = r1;
            this.this$0 = r2;
            this.$context = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C02581(this.$outputParamList, this.this$0, this.$context, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0082 -> B:23:0x0086). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r19) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L10;
            if (r2 == 1) goto L9;
            if (r2 != 2) goto L8;
            ResultKt.throwOnFailure(r19);
        L32:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            OutputParam r3 = (OutputParam) this.L$3;
            Iterator r5 = (Iterator) this.L$2;
            Context r6 = (Context) this.L$1;
            CameraResultViewModel r7 = (CameraResultViewModel) this.L$0;
            ResultKt.throwOnFailure(r19);
            C02581 r15 = this;
            CameraResultViewModel r14 = r7;
            Iterator r8 = r5;
            Context r9 = r6;
            Object r10 = r19;
        L23:
            o0 r11 = (o0) r10;
            t r12 = t.a;
            if (t.c(r3) != null) goto L26;
            FLogger.a.i(CameraResultViewModel.TAG, "[setupMultiResult] add bitmap to CameraMultiCaptureOutputManager outputParam:" + r11.b);
            t.a(r11.b, r11.a, "setupMultiResult");
        L27:
            Context r4 = r9;
            Iterator r13 = r8;
        L11:
            String r16 = null;
            if (r13.hasNext() == false) goto L28;
            OutputParam r17 = (OutputParam) r13.next();
            if (r17 == null) goto L16;
            r16 = r17.getSrcAlbumUri();
        L16:
            if (r16 != null) goto L18;
            String r18 = "";
        L19:
            r15.L$0 = r14;
            r15.L$1 = r4;
            r15.L$2 = r13;
            r15.L$3 = r17;
            r15.label = 1;
            r10 = CameraResultViewModel.getPreviewBitmap$default(r14, r4, r18, 0, r17, r15, 4, null);
            if (r10 != r1) goto L22;
            return r1;
        L22:
            r8 = r13;
            r9 = r4;
            r3 = r17;
            goto L23
        L18:
            r18 = r16;
            goto L19
        L28:
            z0 r20 = CameraResultViewModel.access$get_isMultiResultLoadComplete$p(r15.this$0);
            Integer r21 = Boxing.boxInt(r15.$outputParamList.size());
            r15.L$0 = null;
            r15.L$1 = null;
            r15.L$2 = null;
            r15.L$3 = null;
            r15.label = 2;
            if (r20.emit(r21, r15) != r1) goto L32;
            return r1;
        L26:
            FLogger.a.i(CameraResultViewModel.TAG, "[setupMultiResult] bitmap already in CameraMultiCaptureOutputManager outputParam:" + r11.b);
            goto L27
        L10:
            ResultKt.throwOnFailure(r19);
            List<OutputParam> r22 = this.$outputParamList;
            CameraResultViewModel r23 = this.this$0;
            Context r24 = this.$context;
            r15 = this;
            r14 = r23;
            r13 = r22.iterator();
            r4 = r24;
            goto L11
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$showBitmapSaveLoadingDialog$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$showBitmapSaveLoadingDialog$2", f = "CameraResultViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02592 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
        final /* synthetic */ com.larus.common_ui.dialog.l0 $dialog;
        int label;

        public C02592(com.larus.common_ui.dialog.l0 r1, Continuation<? super C02592> r2) {
            this.$dialog = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02592(this.$dialog, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Result<Unit>> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public static void INVOKEVIRTUAL_com_larus_camera_impl_ui_viewmodel_CameraResultViewModel$showBitmapSaveLoadingDialog$2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(com.larus.common_ui.dialog.l0 r1) {
            if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
            DialogLancet.handleBlockedDialogShow(r1);
            return;
        L10:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
        L7:
            DialogLancet.beforeDialogShow(r1);
            r1.show();
            DialogLancet.afterDialogShow(r1);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L23;
            ResultKt.throwOnFailure(r5);
            com.larus.common_ui.dialog.l0 r6 = this.$dialog;
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L15
            boolean r1 = false;
            if (r6 != null) goto L8;
        L10:
            if (r1 == true) goto L13;
            if (r6 == null) goto L13;
            INVOKEVIRTUAL_com_larus_camera_impl_ui_viewmodel_CameraResultViewModel$showBitmapSaveLoadingDialog$2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r6);     // Catch: Throwable -> L15
        L13:
            Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
        L17:
            Throwable r2 = Result.exceptionOrNull-impl(r7);
            if (r2 == null) goto L21;
            FLogger.a.e(CameraResultViewModel.TAG, "[showBitmapSaveLoadingDialog] fail:" + r2.getMessage());
        L21:
            return Result.box-impl(r7);
        L8:
            if (r6.isShowing() != true) goto L10;
            r1 = true;
        L15:
            th = move-exception;
            Result.Companion r3 = Result.Companion;
            r7 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L17
        L23:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$updateCurrentBitmap$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$updateCurrentBitmap$1", f = "CameraResultViewModel.kt", i = {}, l = {535}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02601 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bitmap $bitmap;
        int label;
        final /* synthetic */ CameraResultViewModel this$0;

        public C02601(CameraResultViewModel r1, Bitmap r2, Continuation<? super C02601> r3) {
            this.this$0 = r1;
            this.$bitmap = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02601(this.this$0, this.$bitmap, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            z0 r5 = CameraResultViewModel.access$get_currentBitmap$p(this.this$0);
            Bitmap r2 = this.$bitmap;
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$updateCurrentBitmap$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$updateCurrentBitmap$3", f = "CameraResultViewModel.kt", i = {}, l = {541}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bitmap $bitmap;
        int label;
        final /* synthetic */ CameraResultViewModel this$0;

        public AnonymousClass3(CameraResultViewModel r1, Bitmap r2, Continuation<? super AnonymousClass3> r3) {
            this.this$0 = r1;
            this.$bitmap = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass3(this.this$0, this.$bitmap, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            z0 r5 = CameraResultViewModel.access$get_currentBitmap$p(this.this$0);
            Bitmap r2 = this.$bitmap;
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$updateEduImageAbility$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$updateEduImageAbility$1", f = "CameraResultViewModel.kt", i = {}, l = {347}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02611 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ nx8.m $ability;
        int label;
        final /* synthetic */ CameraResultViewModel this$0;

        public C02611(CameraResultViewModel r1, nx8.m r2, Continuation<? super C02611> r3) {
            this.this$0 = r1;
            this.$ability = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02611(this.this$0, this.$ability, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            z0 r5 = CameraResultViewModel.access$get_eduImageAbility$p(this.this$0);
            nx8.m r2 = this.$ability;
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$updateHasAccessToAIBeauty$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$updateHasAccessToAIBeauty$1", f = "CameraResultViewModel.kt", i = {}, l = {336}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $has;
        int label;
        final /* synthetic */ CameraResultViewModel this$0;

        public C02621(boolean r1, CameraResultViewModel r2, Continuation<? super C02621> r3) {
            this.$has = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02621(this.$has, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            FLogger.a.i(CameraResultViewModel.TAG, "[updateHasAccessToAIBeauty] has:" + this.$has);
            z0 r6 = CameraResultViewModel.access$get_hasAccessToAIBeauty$p(this.this$0);
            Boolean r2 = Boxing.boxBoolean(this.$has);
            this.label = 1;
            if (r6.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$updateSeekbarDraggingState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$updateSeekbarDraggingState$1", f = "CameraResultViewModel.kt", i = {}, l = {342}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02631 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isDragging;
        int label;
        final /* synthetic */ CameraResultViewModel this$0;

        public C02631(CameraResultViewModel r1, boolean r2, Continuation<? super C02631> r3) {
            this.this$0 = r1;
            this.$isDragging = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02631(this.this$0, this.$isDragging, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            z0 r5 = CameraResultViewModel.access$get_isSeekbarDragging$p(this.this$0);
            Boolean r2 = Boxing.boxBoolean(this.$isDragging);
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$withBitmapSaveLoadingIfNeeded$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraResultViewModel", f = "CameraResultViewModel.kt", i = {1, 1, 2}, l = {1894, 1898, 1899, 1901, 1901}, m = "withBitmapSaveLoadingIfNeeded", n = {"block", "loadingDialog", "loadingDialog"}, s = {"L$0", "L$1", "L$0"})
    public static final class C02641<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ CameraResultViewModel this$0;

        public C02641(CameraResultViewModel r1, Continuation<? super C02641> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return CameraResultViewModel.access$withBitmapSaveLoadingIfNeeded(this.this$0, false, null, this);
        }
    }

    public static /* synthetic */ Unit Mo(CameraResultViewModel r0, Pair r1, OutputParam r2) {
        return onComplete$lambda$27(r0, r1, r2);
    }

    public static /* synthetic */ Unit No(ActivityResult r0) {
        return openPage$lambda$1(r0);
    }

    public static /* synthetic */ long Oo(String r2) {
        return saveResultInMultiCaptureMode$lambda$55$lambda$54$lambda$53$lambda$52(r2);
    }

    public static /* synthetic */ Unit Po(CameraResultViewModel r0, Pair r1, List r2) {
        return onComplete$lambda$23(r0, r1, r2);
    }

    public static /* synthetic */ Bitmap Qo(CameraResultViewModel r0, Context r1, Uri r2) {
        return getPreviewBitmapByPath$lambda$39(r0, r1, r2);
    }

    public static /* synthetic */ Unit So(CameraResultViewModel r0, ActivityResult r1) {
        return launchCapturePageForMultiCapture$lambda$32(r0, r1);
    }

    private final boolean isExifRightAngleRotated(int r2) {
        if (r2 != 6) goto L5;
    L8:
        return true;
    L5:
        if (r2 == 8) goto L8;
        return false;
    }

    public final void changeSelectedBounds() {
        this.eduSelectedBoundsChange = true;
    }

    public final void onCropComponentReady() {
        this.cropComponentReady = true;
        enterInitialImageEditModeIfReady();
    }

    public final boolean shouldDeferCurrentMarkBitmapUpdate() {
        if (shouldUseOriginalImageDeferredEdit$default(this, null, 1, null) == false) goto L5;
        return true;
    L5:
        if (shouldUseMarkSelectMode() == true) goto L7;
    L9:
        return false;
    L7:
        if (((Boolean) this.isInMarkSelectMode.getValue()).booleanValue() == false) goto L9;
        return true;
    }

    public final boolean shouldUseLargeUnifiedThumbnails() {
        if (shouldUseUnifiedPreviewFramework$default(this, null, 1, null) == false) goto L7;
        yx8.a r0 = yx8.c.a;
        if (yx8.c.b() == false) goto L7;
        return true;
    L7:
        return false;
    }

    static {
        Companion = new a();
        EDU_BASE_EXT_KEYS = SetsKt.setOf(new String[]{"os", "edu_camera_sdk_version", "picture_source", "detection_type", "detection_id", "user_change_boxes", "essay_scene", "search_content", "search_index", "detection_scene_type", "request_id", "origin_path"});
    }

    public CameraResultViewModel() {
        StateFlowImpl r2 = j1.a(0);
        this._rotation = r2;
        StateFlowImpl r4 = j1.a(null);
        this._eduImageAbility = r4;
        Boolean r5 = Boolean.FALSE;
        StateFlowImpl r6 = j1.a(r5);
        this._eduImageLoading = r6;
        StateFlowImpl r7 = j1.a(r5);
        this._rawImageLoading = r7;
        this.rawImageLoading = kotlinx.coroutines.flow.e.b(r7);
        StateFlowImpl r8 = j1.a(com.larus.camera.impl.ui.component.result.general.n.b.a);
        this._resultDetectionStatus = r8;
        StateFlowImpl r9 = j1.a(new Rect());
        this._resultPreviewBounds = r9;
        StateFlowImpl r10 = j1.a(px8.b.e);
        this._eduResultTabState = r10;
        StateFlowImpl r11 = j1.a(null);
        this._resultBottomState = r11;
        StateFlowImpl r12 = j1.a(null);
        this._resultSuggestType = r12;
        StateFlowImpl r13 = j1.a(r5);
        this._isInCropMode = r13;
        StateFlowImpl r14 = j1.a(r5);
        this._isInDrawingMode = r14;
        StateFlowImpl r15 = j1.a(r5);
        this._isInMarkSelectMode = r15;
        this._markInputActive = j1.a(r5);
        MutableSharedFlow<Unit> r16 = SharedFlowKt.MutableSharedFlow$default(0, 1, null, 5, null);
        this._clearMarkSelectDrawing = r16;
        StateFlowImpl r1 = j1.a(r5);
        this._enableRedo = r1;
        StateFlowImpl r17 = j1.a(r5);
        this._isImageCropped = r17;
        StateFlowImpl r18 = j1.a(r5);
        this._enableUndo = r18;
        StateFlowImpl r3 = j1.a(0L);
        this._redoPaint = r3;
        StateFlowImpl r19 = j1.a(0L);
        this._undoPaint = r19;
        StateFlowImpl r20 = j1.a(null);
        this._currentBitmap = r20;
        StateFlowImpl r21 = j1.a(null);
        this._bitmapToCrop = r21;
        StateFlowImpl r22 = j1.a(r5);
        this._cropRegionChanged = r22;
        StateFlowImpl r23 = j1.a(null);
        this._isPhotoEditable = r23;
        StateFlowImpl r24 = j1.a(r5);
        this._inFreeInputMode = r24;
        StateFlowImpl r25 = j1.a(r5);
        this._hasAccessToAIBeauty = r25;
        StateFlowImpl r26 = j1.a(r5);
        this._isSeekbarDragging = r26;
        StateFlowImpl r27 = j1.a(-1);
        this._isMultiResultLoadComplete = r27;
        StateFlowImpl r28 = j1.a(r5);
        this._suggestedActionBarDimmed = r28;
        MutableSharedFlow<Integer> r29 = SharedFlowKt.MutableSharedFlow$default(0, 1, null, 5, null);
        this._captureAppendComplete = r29;
        this.currentEduIntent = EduIntentMode.UNDETECTED;
        this.isPhotoEditable = kotlinx.coroutines.flow.e.b(r23);
        this.isImageCropped = kotlinx.coroutines.flow.e.b(r17);
        this.cropRegionChanged = kotlinx.coroutines.flow.e.b(r22);
        this.enableRedo = kotlinx.coroutines.flow.e.b(r1);
        this.enableUndo = kotlinx.coroutines.flow.e.b(r18);
        this.redoPaint = kotlinx.coroutines.flow.e.b(r3);
        this.undoPaint = kotlinx.coroutines.flow.e.b(r19);
        this.isInDrawingMode = kotlinx.coroutines.flow.e.b(r14);
        this.isInMarkSelectMode = kotlinx.coroutines.flow.e.b(r15);
        this.clearMarkSelectDrawing = kotlinx.coroutines.flow.e.a(r16);
        this.isInCropMode = kotlinx.coroutines.flow.e.b(r13);
        this.bitmapToCrop = kotlinx.coroutines.flow.e.b(r21);
        this.rotation = kotlinx.coroutines.flow.e.b(r2);
        this.eduImageAbility = kotlinx.coroutines.flow.e.b(r4);
        this.eduImageLoading = kotlinx.coroutines.flow.e.b(r6);
        this.resultDetectionStatus = kotlinx.coroutines.flow.e.b(r8);
        this.resultPreviewBounds = kotlinx.coroutines.flow.e.b(r9);
        this.eduResultTabState = kotlinx.coroutines.flow.e.b(r10);
        this.resultBottomState = kotlinx.coroutines.flow.e.b(r11);
        this.resultSuggestType = kotlinx.coroutines.flow.e.b(r12);
        this.inFreeInputMode = kotlinx.coroutines.flow.e.b(r24);
        this.hasAccessToAIBeauty = kotlinx.coroutines.flow.e.b(r25);
        this.isSeekbarDragging = kotlinx.coroutines.flow.e.b(r26);
        this.isMultiResultLoadComplete = kotlinx.coroutines.flow.e.b(r27);
        this.suggestedActionBarDimmed = kotlinx.coroutines.flow.e.b(r28);
        this.captureAppendComplete = kotlinx.coroutines.flow.e.a(r29);
        this.currentBitmap = kotlinx.coroutines.flow.e.b(r20);
        this.reportedClipItems = new LinkedHashSet();
        this.deferredEditOperations = new vt7.a();
        this.activeMarkOperationIndex = new vt7.a();
        this.markSelectSessionMaskKeys = new vt7.a();
        this.markSelectSessionOperationSizes = new vt7.a();
        this.previewThumbListStateFlowHolder = new com.larus.camera.impl.utils.g0(-1L);
        this.previewThumbListDeleteStateFlowHolder = new com.larus.camera.impl.utils.g0(new Pair(-1L, r5));
        this.saveBitmapCallback = new i(this);
        StateFlowImpl r30 = j1.a(null);
        this._rawBaseBitmap = r30;
        this.rawBaseBitmap = kotlinx.coroutines.flow.e.b(r30);
    }

    private final void clearMarkSelectSession() {
        this.markSelectSessionMaskKeys.clear();
        this.markSelectSessionOperationSizes.clear();
    }

    private final BitmapFactory.Options createOriginalBitmapDecodeOptions() {
        BitmapFactory.Options r0 = new BitmapFactory.Options();
        r0.inPreferredConfig = Bitmap.Config.ARGB_8888;
        r0.inMutable = true;
        return r0;
    }

    private final void enterInitialImageEditModeIfReady() {
        if (this.initialImageEditModeConsumed == false) goto L5;
        return;
    L5:
        if (this.markedImageGetter == null) goto L39;
        InputParam r0 = getInputParam();
        if (r0 == null) goto L11;
        InputParam.InitialImageEditMode r1 = r0.getInitialImageEditMode();
        if (r1 == null) goto L11;
    L12:
        int r2 = g.a[r1.ordinal()];
        if (r2 != 1) goto L15;
        return;
    L15:
        if (r2 != 2) goto L17;
        this.initialImageEditModeConsumed = true;
        if (shouldUseMarkSelectMode() == false) goto L38;
        enterMarkSelectMode();
        return;
    L38:
        return;
    L17:
        if (r2 != 3) goto L28;
        if (resultSupportCrop() == true) goto L23;
        this.initialImageEditModeConsumed = true;
        FLogger.a.e(TAG, "initial crop mode rejected: supportCrop=false");
        return;
    L23:
        if (this.cropComponentReady == true) goto L25;
        return;
    L25:
        if (switchToCropMode() == false) goto L36;
        this.initialImageEditModeConsumed = true;
        setCropRegionChanged(false);
        setImageCropped(false);
        return;
    L36:
        return;
    L28:
        throw new NoWhenBranchMatchedException();
    L11:
        r1 = InputParam.InitialImageEditMode.NONE;
        goto L12
    }

    private final Bitmap getPreviewImage() {
        return (Bitmap) this._currentBitmap.getValue();
    }

    private final Bitmap getUploadBitmap() {
        Function0<Bitmap> r0 = this.rawMarkedImageGetter;
        if (r0 == null) goto L6;
        Bitmap r1 = (Bitmap) r0.invoke();
        if (r1 == null) goto L6;
        return r1;
    L6:
        Function0<Bitmap> r2 = this.markedImageGetter;
        if (r2 != null) goto L12;
        return null;
    L12:
        return (Bitmap) r2.invoke();
    }

    private final void resetMarkSelectSessionAfterCrop() {
        if (((Boolean) this.isInMarkSelectMode.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        OutputParam r0 = this.currentDisplayOutputParam;
        String r1 = currentOutputKey(r0);
        this._clearMarkSelectDrawing.tryEmit(Unit.INSTANCE);
        setRedoEnabled(false);
        setUndoEnabled(false);
        setInDrawingMode(false);
        t r2 = t.a;
        OutputParam r3 = t.b(r0);
        if (r3 == null) goto L8;
        changePreviewThumbListState(r3, "resetMarkSelectSessionAfterCrop");
    L8:
        if (r1 != null) goto L10;
    L12:
        clearMarkSelectSession();
        recordMarkSelectSessionSnapshot(r0);
        return;
    L10:
        if (shouldUseOriginalImageDeferredEdit(r0) == false) goto L12;
        this.activeMarkOperationIndex.remove(r1);
        goto L12
    }

    private final void restoreMarkSelectSession() {
        FLogger.a.i(TAG, "restoreMarkSelectSession");
        t r0 = t.a;
        List r1 = t.f();
        OutputParam r3 = this.currentDisplayOutputParam;
        String r4 = currentOutputKey(r3);
        Iterator r5 = this.markSelectSessionMaskKeys.keySet().iterator();
    L3:
        Object r7 = null;
        if (r5.hasNext() == false) goto L20;
        String r6 = (String) r5.next();
        FLogger.a.i(TAG, "restoreMarkSelectSession key:" + r6 + " currentKey:" + r4);
        Iterator r8 = r1.iterator();
    L7:
        if (r8.hasNext() == false) goto L11;
        Object r9 = r8.next();
        t r11 = t.a;
        if (Intrinsics.areEqual(t.g((OutputParam) r9), r6) == false) goto L7;
        r7 = r9;
    L11:
        OutputParam r10 = (OutputParam) r7;
        if (r10 == null) goto L3;
        t r12 = t.a;
        OutputParam r13 = t.b(r10);
        if (Intrinsics.areEqual(r4, r6) == false) goto L3;
        if (r13 == null) goto L19;
        r10 = r13;
    L19:
        this.currentDisplayOutputParam = r10;
        goto L3
    L20:
        Iterator r2 = this.markSelectSessionOperationSizes.entrySet().iterator();
    L22:
        if (r2.hasNext() == false) goto L30;
        Map.Entry r14 = (Map.Entry) r2.next();
        String r15 = (String) r14.getKey();
        int r16 = ((Number) r14.getValue()).intValue();
        List r17 = (List) this.deferredEditOperations.get(r15);
        if (r17 == null) goto L22;
    L27:
        if (r17.size() <= r16) goto L29;
        ListProtector.remove(r17, CollectionsKt.getLastIndex(r17));
        goto L27
    L29:
        this.activeMarkOperationIndex.remove(r15);
        goto L22
    L30:
        Iterator r18 = r1.iterator();
    L32:
        if (r18.hasNext() == false) goto L36;
        Object r19 = r18.next();
        t r20 = t.a;
        if (Intrinsics.areEqual(t.g((OutputParam) r19), r4) == false) goto L32;
        r7 = r19;
    L36:
        OutputParam r21 = (OutputParam) r7;
        if (r21 == null) goto L40;
        r3 = r21;
    L40:
        this.currentDisplayOutputParam = r3;
        notifyPreviewThumbListStateChanged(r3, "restoreMarkSelectSession");
    }

    public final void cancelMarkSelectMode() {
        if (((Boolean) this.isInMarkSelectMode.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        this._clearMarkSelectDrawing.tryEmit(Unit.INSTANCE);
        this._isInMarkSelectMode.tryEmit(Boolean.FALSE);
        restoreMarkSelectSession();
        setRedoEnabled(false);
        setUndoEnabled(false);
        setInDrawingMode(false);
        clearMarkSelectSession();
    }

    public final ix8.d detectedIntent() {
        Object r0 = this.resultDetectionStatus.getValue();
        if ((r0 instanceof com.larus.camera.impl.ui.component.result.general.n.a) == false) goto L5;
        com.larus.camera.impl.ui.component.result.general.n.a r1 = (com.larus.camera.impl.ui.component.result.general.n.a) r0;
    L6:
        if (r1 == null) goto L11;
        ix8.d r2 = r1.a;
        if (r2 == null) goto L11;
        return r2;
    L11:
        return new ix8.d.a(ix8.e.c.a);
    L5:
        r1 = null;
        goto L6
    }

    public final void enterMarkSelectMode() {
        FLogger r0 = FLogger.a;
        r0.i(TAG, "enterMarkSelectMode");
        if (shouldUseMarkSelectMode() == true) goto L5;
    L9:
        r0.i(TAG, "enterMarkSelectMode not use mark select mode or in mark select mode");
        return;
    L5:
        if (((Boolean) this.isInMarkSelectMode.getValue()).booleanValue() == true) goto L9;
        clearMarkSelectSession();
        this._isInMarkSelectMode.tryEmit(Boolean.TRUE);
        recordMarkSelectSessionSnapshot(this.currentDisplayOutputParam);
    }

    public final Bitmap getBitmapToCrop() {
        return (Bitmap) this._bitmapToCrop.getValue();
    }

    public final int getCurrentBitmapIndex() {
        t r0 = t.a;
        return CollectionsKt.indexOf(t.f(), this.currentDisplayOutputParam);
    }

    @Override // com.larus.camera.impl.ui.base.BaseCameraViewModel
    public OutputParam getCurrentDisplayOutputParam() {
        OutputParam r0 = this.currentDisplayOutputParam;
        if (r0 == null) goto L5;
        return r0;
    L5:
        OutputParam r1 = getInitialCaptureOutputParam();
        if (r1 != null) goto L12;
        List<OutputParam> r2 = getOriginMultiOutputParamList();
        if (r2 != null) goto L13;
        return null;
    L13:
        return (OutputParam) CollectionsKt.firstOrNull(r2);
    L12:
        return r1;
    }

    public final Bitmap getCurrentMarkedMaskBitmap() {
        OutputParam r0 = this.currentDisplayOutputParam;
        if (r0 == null) goto L7;
        ImageParam r1 = r0.getImageParam();
        if (r1 == null) goto L7;
        return r1.getMarkedMaskBitmap();
    L7:
        return null;
    }

    public final Bitmap getMarkedImageBitmap() {
        Function0<Bitmap> r0 = this.markedImageGetter;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (Bitmap) r0.invoke();
    }

    public final String getPreviewBitmapPath() {
        OutputParam r0 = this.currentDisplayOutputParam;
        if (r0 == null) goto L7;
        ImageParam r1 = r0.getImageParam();
        if (r1 == null) goto L7;
        return r1.getPath();
    L7:
        return null;
    }

    public final boolean isMultiCaptureEnabled() {
        Lazy r0 = o.a;
        return o.a(isSupportMultiImages(), getCameraData());
    }

    public final void notifyRedo() {
        this._redoPaint.tryEmit(Long.valueOf(System.currentTimeMillis()));
    }

    public final void notifyUndo() {
        this._undoPaint.tryEmit(Long.valueOf(System.currentTimeMillis()));
    }

    public void onCleared() {
        FLogger.a.i(TAG, "onCleared");
        this.markedImageGetter = null;
        clearMarkSelectSession();
        super.onCleared();
    }

    public final i1<Pair<Long, Boolean>> previewThumbListDeleteStateFlow() {
        return this.previewThumbListDeleteStateFlowHolder.b;
    }

    public final i1<Long> previewThumbListStateFlow() {
        return this.previewThumbListStateFlowHolder.b;
    }

    public final void rotate() {
        int r0 = (((Number) this.rotation.getValue()).intValue() + 270) % 360;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02541(this, r0, null), 3, null);
        t r1 = t.a;
        OutputParam r2 = t.l(this.currentDisplayOutputParam, r0);
        if (r2 == null) goto L6;
        this.currentDisplayOutputParam = r2;
        return;
    }

    public final boolean shouldEnableMark() {
        if (((Boolean) this._markInputActive.getValue()).booleanValue() == false) goto L5;
    L9:
        return false;
    L5:
        if (shouldUseMarkSelectMode() == true) goto L7;
    L8:
        return true;
    L7:
        if (((Boolean) this.isInMarkSelectMode.getValue()).booleanValue() == false) goto L9;
        goto L8
    }

    public final boolean shouldUseSuggestedActionCacheAsDefault() {
        ex8.b r0 = FlowCameraImpl.c;
        if (FlowCameraImpl.c != null) goto L23;
        InputParam r1 = getInputParam();
        String r2 = null;
        if (r1 == null) goto L7;
        String r3 = r1.getScene();
    L9:
        if (Intrinsics.areEqual(r3, "toutiao_search") == false) goto L24;
        InputParam r4 = getInputParam();
        if (r4 == null) goto L14;
        r2 = r4.getBotId();
    L14:
        if (r2 != null) goto L16;
    L19:
        boolean r5 = true;
    L20:
        if (r5 == true) goto L25;
        return true;
    L25:
        return false;
    L16:
        if (r2.length() == 0) goto L19;
        r5 = false;
        goto L20
    L24:
        return false;
    L7:
        r3 = null;
        goto L9
    L23:
        return false;
    }

    public final boolean supportsEduIntentOnResultPage() {
        List<String> r0 = fx8.a.a;
        if (fx8.a.e.contains(getCameraData().getCaptureMode()) == false) goto L5;
    L8:
        return true;
    L5:
        if ((detectedIntent() instanceof ix8.d.b) == true) goto L8;
        return false;
    }

    public final boolean switchToCropMode() {
        FLogger r0 = FLogger.a;
        r0.i(TAG, "[switchToCropMode]");
        Function0<Bitmap> r1 = this.markedImageGetter;
        Bitmap r3 = null;
        if (r1 == null) goto L11;
        Bitmap r2 = (Bitmap) r1.invoke();
        if (r2 == null) goto L11;
        if (r2.isRecycled() == false) goto L10;
        r2 = null;
    L10:
        if (r2 == null) goto L11;
    L17:
        if (r2 != null) goto L20;
        r0.e(TAG, "[switchToCropMode] marked bitmap is unavailable");
        return false;
    L20:
        Function0<Bitmap> r4 = this.rawMarkedImageGetter;
        if (r4 == null) goto L23;
        r3 = (Bitmap) r4.invoke();
    L23:
        this.rawBitmapToCrop = r3;
        this._bitmapToCrop.setValue(r2);
        this._isInCropMode.setValue(Boolean.TRUE);
        return true;
    L11:
        r2 = (Bitmap) this._currentBitmap.getValue();
        if (r2 != null) goto L14;
    L16:
        r2 = null;
        goto L17
    L14:
        if (r2.isRecycled() == true) goto L16;
        goto L16
    }

    private final Boolean boundsChanged() {
        if (Intrinsics.areEqual(getCameraData().getCaptureMode(), "CAPTURE_MODE_EDU_GENERAL_PHOTO") == true) goto L7;
        return null;
    L7:
        return Boolean.valueOf(this.eduSelectedBoundsChange);
    }

    private final boolean completeWithMultiResult() {
        boolean r0 = isMultiCaptureEnabled();
        boolean r1 = isFromMultiCapture();
        if (r0 == true) goto L7;
        if (this.isMultiResultFromCamera == true) goto L7;
    L11:
        return false;
    L7:
        if (r1 == true) goto L13;
        t r2 = t.a;
        if (t.e() <= 1) goto L11;
        return true;
    L13:
        return true;
    }

    private final com.larus.common_ui.dialog.l0 createBitmapSaveLoadingDialog() {
        Fragment r0 = ability().getCurrentFragment();
        if (r0 == null) goto L14;
        FragmentActivity r1 = r0.getActivity();
        if (r1 != null) goto L8;
        return null;
    L8:
        if (r1.isFinishing() == false) goto L10;
        return null;
    L10:
        if (r1.isDestroyed() == false) goto L13;
        return null;
    L13:
        return new com.larus.common_ui.dialog.l0(r1, 0.0f, false, 6);
    L14:
        return null;
    }

    private final void enterInitialMarkModeBeforeComponentsAttach() {
        InputParam r0 = getInputParam();
        if (r0 == null) goto L5;
        InputParam.InitialImageEditMode r1 = r0.getInitialImageEditMode();
    L7:
        if (r1 == InputParam.InitialImageEditMode.MARK) goto L9;
        return;
    L9:
        if (shouldUseMarkSelectMode() == false) goto L14;
        this.initialImageEditModeConsumed = true;
        enterMarkSelectMode();
        return;
    L14:
        return;
    L5:
        r1 = null;
        goto L7
    }

    private final void launchCapturePageForMultiCapture() {
        InputParam r0 = getInputParam();
        Integer r1 = null;
        if (r0 == null) goto L7;
        InputParam r2 = r0.deepCopy();
        if (r2 == null) goto L7;
        r2.setTarget("TARGET_GET");
        r2.setEnableCaptureDetectModeList(CollectionsKt.emptyList());
        t r3 = t.a;
        r2.setAddedAttachmentCount(Integer.valueOf(t.e()));
    L8:
        String r4 = getSuggestionPrefix();
        Intent r5 = new Intent(AppHost.a.getApplication(), CameraCaptureActivity.class);
        r5.putExtra("CAMERA_INPUT_PARAM", r2);
        r5.putExtra("EXTRA_LAUNCHED_FROM_RESULT", true);
        if (r4 == null) goto L11;
        r5.putExtra("SUGGESTION_PREFIX", r4);
    L11:
        r5.putExtra("SHOW_BOTTOM_ALBUM", true);
        r5.setFlags(r5.getFlags() & (-33554433));
        FLogger r6 = FLogger.a;
        StringBuilder r7 = new StringBuilder("[launchCapturePageForMultiCapture] launching CameraCaptureActivity, target=");
        if (r2 == null) goto L14;
        String r8 = r2.getTarget();
    L15:
        r7.append(r8);
        r7.append(", addedAttachmentCount=");
        if (r2 == null) goto L18;
        r1 = r2.getAddedAttachmentCount();
    L18:
        r7.append(r1);
        r6.i(TAG, r7.toString());
        ability().X(r5, false, new v(this));
        return;
    L14:
        r8 = null;
    L7:
        r2 = null;
        goto L8
    }

    private final boolean useNoWatermarkImageForMarkDownload() {
        InputParam r0 = getInputParam();
        if (r0 == null) goto L7;
        InputParamExtra r1 = r0.getExtra();
        if (r1 == null) goto L7;
        String r2 = (String) r1.get(InputParamExtra.KEY_DOWNLOAD_USE_NO_WATERMARK_IMAGE);
    L9:
        return Intrinsics.areEqual(r2, "1");
    L7:
        r2 = null;
        goto L9
    }

    public final void clickDownloadOnResultPage() {
        ability().a0(getCameraData().getCaptureMode(), this.isEduMultiQuestionModel);
    }

    public final void clickInputFullBoxOnResultPage() {
        ability().x(getCameraData().getCaptureMode(), this.isEduMultiQuestionModel);
    }

    public final void clickInputFunctionSwitchOnResultPage() {
        ability().V(getCameraData().getCaptureMode(), this.isEduMultiQuestionModel);
    }

    public final void clickInputIconOnResultPage() {
        ability().q(getCameraData().getCaptureMode(), this.isEduMultiQuestionModel);
    }

    public final void clickRecaptureOnResultPage() {
        ability().v0(getCameraData().getCaptureMode(), this.isEduMultiQuestionModel);
    }

    public final void clickRotationOnResultPage() {
        ability().e0(getCameraData().getCaptureMode(), this.isEduMultiQuestionModel);
    }

    public final void clickSubmitOnResultPage() {
        ability().D0(getCameraData().getCaptureMode(), this.isEduMultiQuestionModel);
    }

    public final void clickSwitchQuestionOnResultPage() {
        ability().m(getCameraData().getCaptureMode(), this.isEduMultiQuestionModel);
    }

    public final void closePage() {
        ability().closePage();
    }

    public final boolean currentPreviewIsGif() {
        return com.larus.camera.impl.ui.component.result.general.viewpager.u.a(getCurrentDisplayOutputParam());
    }

    public final boolean currentPreviewIsVideo() {
        OutputParam r0 = getCurrentDisplayOutputParam();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isVideo() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean currentPreviewShouldHideEditControls() {
        if (currentPreviewIsVideo() == false) goto L5;
    L8:
        return true;
    L5:
        if (currentPreviewIsGif() == true) goto L8;
        return false;
    }

    public final void enterCropPage() {
        ability().E0();
    }

    public final void enterResultPage() {
        ability().D(getCameraData().getSwitchTab(), isFromAlbum(), getCameraData().getCaptureMode());
        OutputParam r0 = getCurrentDisplayOutputParam();
        if (r0 == null) goto L6;
        ability().k0(r0.getResultType(), r0.isFromAlbum());
        return;
    }

    public final OutputParam getInitialCaptureOutputParam() {
        Object r1 = null;
        if (shouldUseUnifiedResultTopStyle() == true) goto L5;
        return null;
    L5:
        Bundle r0 = ability().B();
        if (r0 == null) goto L25;
        String r2 = r0.getString("PREVIEW_PARAM_CAPTURE_OUTPUT_KEY");
        if (r2 == null) goto L28;
        List<OutputParam> r3 = getOriginMultiOutputParamList();
        if (r3 == null) goto L26;
        List r4 = CollectionsKt.filterNotNull(r3);
        if (r4 == null) goto L27;
        Iterator r5 = r4.iterator();
    L16:
        if (r5.hasNext() == false) goto L21;
        Object r6 = r5.next();
        t r7 = t.a;
        if (Intrinsics.areEqual(t.g((OutputParam) r6), r2) == false) goto L16;
        r1 = r6;
    L21:
        return (OutputParam) r1;
    L27:
        return null;
    L26:
        return null;
    L28:
        return null;
    L25:
        return null;
    }

    public final InputParam getInputParam() {
        Bundle r0 = ability().B();
        if (r0 == null) goto L5;
        Serializable r1 = r0.getSerializable("CAMERA_INPUT_PARAM");
    L7:
        if ((r1 instanceof InputParam) == true) goto L9;
        return null;
    L9:
        return (InputParam) r1;
    L5:
        r1 = null;
        goto L7
    }

    public final List<OutputParam> getOriginMultiOutputParamList() {
        Bundle r0 = ability().B();
        if (r0 == null) goto L5;
        Serializable r1 = r0.getSerializable("CAMERA_OUTPUT_CONTEXT");
    L6:
        CameraOutputContext r2 = (CameraOutputContext) r1;
        if (r2 != null) goto L9;
        return null;
    L9:
        return r2.getOutputParamList();
    L5:
        r1 = null;
        goto L6
    }

    public final String getParamAlbumUrl() {
        Bundle r0 = ability().B();
        String r1 = "";
        if (r0 == null) goto L8;
        String r2 = r0.getString("PREVIEW_PARAM_ALBUM_URI", "");
        if (r2 == null) goto L8;
        r1 = r2;
    L8:
        FLogger.a.i(TAG, "[getParamAlbumUrl] url:".concat(r1));
        return r1;
    }

    public final int getParamOrientation() {
        Bundle r0 = ability().B();
        int r1 = 0;
        if (r0 == null) goto L5;
        r1 = r0.getInt("PREVIEW_PARAM_ORIENTATION", 0);
    L5:
        FLogger.a.i(TAG, "[getParamOrientation] " + r1);
        return r1;
    }

    public final String getSuggestionPrefix() {
        Bundle r0 = ability().B();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getString("SUGGESTION_PREFIX");
    }

    public final boolean handleUnifiedResultEditBack() {
        InputParam r0 = getInputParam();
        if (r0 == null) goto L5;
        InputParam.InitialImageEditMode r1 = r0.getInitialImageEditMode();
    L7:
        if (r1 != InputParam.InitialImageEditMode.MARK) goto L9;
    L12:
        boolean r2 = true;
    L14:
        if (shouldUseUnifiedResultTopStyle() == true) goto L18;
        if (r2 == true) goto L18;
        return false;
    L18:
        if (((Boolean) this.isInCropMode.getValue()).booleanValue() == false) goto L22;
        setInCropMode(false);
        return true;
    L22:
        if (((Boolean) this.isInMarkSelectMode.getValue()).booleanValue() == false) goto L25;
        cancelMarkSelectMode();
        return true;
    L25:
        return false;
    L9:
        if (r1 == InputParam.InitialImageEditMode.CROP) goto L12;
        r2 = false;
        goto L14
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.larus.camera.impl.ui.base.BaseCameraViewModel
    public String invokeClickFrom() {
        if (isFromMultiCapture() == false) goto L6;
        return "camera_input_left_icon";
    L6:
        return null;
    }

    public final boolean isFromAlbum() {
        Bundle r0 = ability().B();
        String r1 = "";
        if (r0 == null) goto L5;
        String r2 = r0.getString("PREVIEW_PARAM_ALBUM_URI", "");
    L6:
        if (r2 == null) goto L10;
        r1 = r2;
    L10:
        if (r1.length() <= 0) goto L12;
        return true;
    L12:
        return false;
    L5:
        r2 = null;
        goto L6
    }

    public final boolean isFromCameraPage() {
        Bundle r0 = ability().B();
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.getBoolean("PREVIEW_PARAM_FROM_CAMERA_PAGE", false);
    }

    public final boolean isFromInputAttachment() {
        InputParam r0 = getInputParam();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isFromChatAttachment() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean isFromMarkPage() {
        Bundle r0 = ability().B();
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.getBoolean("PREVIEW_PARAM_FROM_MARK_PAGE", false);
    }

    public final boolean isFromMultiCapture() {
        Bundle r0 = ability().B();
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.getBoolean("PREVIEW_PARAM_MULTI_CAPTURE_MODE", false);
    }

    public final boolean isInjectInputMode() {
        InputParam r0 = getInputParam();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isInjectInputMode() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean isSupportMultiImages() {
        InputParam r0 = getInputParam();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.getSupportMultiImages();
    }

    public final void leaveResultPageOnClose() {
        ability().F0(isFromAlbum(), getCameraData().getSwitchTab(), getCameraData().getCaptureMode(), this.isEduMultiQuestionModel, boundsChanged(), this.currentEduIntent);
    }

    @Override // com.larus.camera.impl.ui.base.BaseCameraViewModel
    public void onInitialized() {
        super.onInitialized();
        Lazy r0 = com.larus.camera.impl.utils.w.a;
        CameraData r1 = getCameraData();
        boolean r2 = false;
        if (r1 != null) goto L5;
        FLogger.a.i("EduResultTabConfigManager", "[isAvailable] unavailable: cameraData is null");
    L19:
        boolean r5 = false;
    L20:
        if (r5 == false) goto L22;
        oq9.g r3 = (oq9.g) com.larus.camera.impl.utils.w.a.getValue();
    L23:
        com.larus.camera.impl.utils.w.b = r3;
        FLogger r4 = FLogger.a;
        StringBuilder r6 = new StringBuilder("[init] configAvailable=");
        r6.append(r5);
        r6.append(", scene=");
        if (r1 == null) goto L26;
        String r7 = r1.getScene();
    L27:
        r6.append(r7);
        r6.append(", captureMode=");
        if (r1 == null) goto L30;
        String r8 = r1.getCaptureMode();
    L31:
        r6.append(r8);
        r6.append(", enableResultTab=");
        r6.append(com.larus.camera.impl.utils.w.b.d());
        r6.append(", defaultQuestionMode=");
        r6.append(com.larus.camera.impl.utils.w.b.a());
        r6.append(", enableResultInput=");
        r6.append(com.larus.camera.impl.utils.w.b.c());
        r6.append(", freeInputImagePolicy=");
        r6.append(com.larus.camera.impl.utils.w.b.e());
        r6.append(", enableImageDewarp=");
        r6.append(com.larus.camera.impl.utils.w.b.b());
        r4.i("EduResultTabConfigManager", r6.toString());
        yx8.a r9 = yx8.c.a;
        CameraData r10 = getCameraData();
        Intrinsics.checkNotNullParameter(r10, "cameraData");
        if (com.larus.camera.impl.utils.w.a() == true) goto L34;
    L36:
        boolean r11 = false;
    L37:
        boolean r12 = CollectionsKt.listOf(new String[]{"CAPTURE_MODE_PHOTO", "CAPTURE_MODE_EDU_HOMEWORK_PHOTO"}).contains(r10.getCaptureMode());
        if (Intrinsics.areEqual(r10.getScene(), "attach_menu") == false) goto L40;
    L44:
        boolean r13 = false;
    L46:
        if (r10.getResultRoute() == null) goto L48;
        r2 = true;
    L48:
        yx8.c.b = r2;
        if (r12 == true) goto L51;
        if (r11 == true) goto L51;
    L73:
        yx8.a r14 = yx8.a.d.b;
    L74:
        yx8.c.a = r14;
        r4.i("ResultComponentProvider", "[setUp] inputEnabled:" + yx8.c.b() + ", inputStyle:" + r10.getInputStyle() + ", mode:" + r10.getCaptureMode());
        enterInitialMarkModeBeforeComponentsAttach();
        int r15 = px8.f.a;
        if (yx8.c.b() == false) goto L77;
        ResultBottomControlType r16 = ResultBottomControlType.INPUT;
    L78:
        updateResultBottomState(new px8.e(r16, null));
        Context r17 = requireFragment().getContext();
        if (r17 == null) goto L82;
        setupMultiResult(r17);
        return;
    L82:
        return;
    L77:
        r16 = ResultBottomControlType.CONFIRM;
    L51:
        if (r13 == false) goto L73;
        if (r10.getAddedAttachmentCount() > 0) goto L73;
        int r18 = yx8.a.a;
        int r19 = r10.getInputStyle();
        yx8.a r20 = yx8.a.c.b;
        if (r19 != 1) goto L57;
        r14 = r20;
    L61:
        yx8.a.d r21 = yx8.a.d.b;
        if (Intrinsics.areEqual(r14, r21) == false) goto L74;
        if (com.larus.camera.impl.utils.w.b.c() == false) goto L74;
        int r22 = z2.a.cameraFreeInputConfig().a;
        if (r22 == 1) goto L72;
        r20 = yx8.a.b.b;
        if (r22 == 2) goto L72;
        r20 = r21;
    L72:
        r14 = r20;
        goto L74
    L57:
        r14 = yx8.a.b.b;
        if (r19 == 2) goto L61;
        r14 = yx8.a.d.b;
        goto L61
    L40:
        if (Intrinsics.areEqual(r10.getScene(), "inject_input_photo_picker") == true) goto L44;
        if (Intrinsics.areEqual(r10.getScene(), "prompt_direct_send") == true) goto L44;
        r13 = true;
        goto L46
    L34:
        if (fx8.a.e.contains(r10.getCaptureMode()) == false) goto L36;
        r11 = true;
        goto L37
    L30:
        r8 = null;
        goto L31
    L26:
        r7 = null;
        goto L27
    L22:
        r3 = new oq9.g(0);
        goto L23
    L5:
        boolean r23 = AppHost.a.isOversea();
        boolean r24 = AccountService.a.isEnterpriseAccount();
        boolean r25 = Intrinsics.areEqual(r1.getScene(), "edu_live_tutor");
        if (r23 == true) goto L18;
        if (r24 == true) goto L18;
        if (r25 == true) goto L18;
        CaptureResultDetectLogic r26 = CaptureResultDetectLogic.a;
        boolean r27 = CaptureResultDetectLogic.a(r1);
        boolean r28 = fx8.a.e.contains(r1.getCaptureMode());
        if (r27 == true) goto L14;
        if (r28 == true) goto L14;
        FLogger.a.i("EduResultTabConfigManager", "[isAvailable] unavailable: supportsResultDetect=false, isEduCamera=false");
    L14:
        ICameraEventExt r29 = r1.getEventExt();
        if (r29 != null) goto L17;
        FLogger.a.i("EduResultTabConfigManager", "[isAvailable] unavailable: eventExt is null");
        goto L19
    L17:
        r5 = com.larus.bmhome.utils.i.e(r29.getConversationId(), r29.getBotConversationType());
        FLogger.a.i("EduResultTabConfigManager", "[isAvailable] supportsResultDetect=" + r27 + ", isEduCamera=" + r28 + ", mainBotMatched=" + r5);
    L18:
        FLogger.a.i("EduResultTabConfigManager", "[isAvailable] unavailable: isOversea=" + r23 + ", isEnterpriseAccount=" + r24 + ", isEduLiveTutor=" + r25);
        goto L19
    }

    public final void onMultiCameraCapture() {
        boolean r0 = isFromMarkPage();
        FLogger.a.i(TAG, "[onMultiCameraCapture] isFromMarkPage=" + r0);
        finishMarkSelectMode("onMultiCameraCapture");
        if (r0 == false) goto L5;
        launchCapturePageForMultiCapture();
        return;
    L5:
        ability().setResult(400000, new Intent());
        ability().closePage();
    }

    public final boolean resultSupportCrop() {
        InputParam r0 = getInputParam();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.getSupportCrop();
    }

    public final boolean resultSupportMark() {
        InputParam r0 = getInputParam();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.getSupportMark();
    }

    @Override // com.larus.camera.impl.ui.base.BaseCameraViewModel
    public boolean shouldSupportEdit() {
        return resultSupportCrop();
    }

    public final boolean shouldUseMarkSelectMode() {
        InputParam r0 = getInputParam();
        if (r0 == null) goto L5;
        InputParam.InitialImageEditMode r1 = r0.getInitialImageEditMode();
    L7:
        if (r1 != InputParam.InitialImageEditMode.MARK) goto L9;
        boolean r2 = true;
    L11:
        if (resultSupportMark() == false) goto L20;
        if (r2 == false) goto L14;
        return true;
    L14:
        if (z2.a.markSelectModeEnable() == true) goto L18;
        if (shouldUseUnifiedResultTopStyle() == false) goto L20;
    L18:
        if (isFromCameraPage() == false) goto L20;
        return true;
    L20:
        return false;
    L9:
        r2 = false;
        goto L11
    L5:
        r1 = null;
        goto L7
    }

    public final boolean shouldUseUnifiedMediaCanvas() {
        CameraData r0 = getCameraData();
        if (r0.getUseUnifiedMediaCanvas() == true) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r0.getCaptureMode(), "CAPTURE_MODE_PHOTO") == true) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(r0.getScene(), "ecom_page") == false) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(r0.getScene(), "attach_photo_edit") == false) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(r0.getScene(), "prompt_direct_send") == true) goto L30;
        Object r1 = this.resultDetectionStatus.getValue();
        if ((r1 instanceof com.larus.camera.impl.ui.component.result.general.n.a) == false) goto L16;
        com.larus.camera.impl.ui.component.result.general.n.a r2 = (com.larus.camera.impl.ui.component.result.general.n.a) r1;
    L18:
        if (this.eduImageAbility.getValue() != null) goto L28;
        if (r2 != null) goto L21;
    L22:
        return true;
    L21:
        if ((r2.a instanceof ix8.d.a) == true) goto L22;
        return false;
    L28:
        return false;
    L16:
        r2 = null;
        goto L18
    L30:
        return false;
    }

    public final boolean shouldUseUnifiedResultTopStyle() {
        if (getCameraData().getEnableCameraResultUnifiedVisual() == true) goto L5;
    L16:
        return false;
    L5:
        if (Intrinsics.areEqual(getCameraData().getCaptureMode(), "CAPTURE_MODE_PHOTO") == false) goto L16;
        if (Intrinsics.areEqual(getCameraData().getScene(), "ecom_page") == true) goto L16;
        if (Intrinsics.areEqual(getCameraData().getScene(), "attach_photo_edit") == true) goto L16;
        if (Intrinsics.areEqual(getCameraData().getScene(), "prompt_direct_send") == true) goto L16;
        return true;
    }

    public final void updateInputParamAfetrEduIntentDetected() {
        InputParam r0 = getInputParam();
        if (r0 == null) goto L6;
        r0.setSupportMark(false);
        r0.setSupportCrop(false);
        return;
    }

    public final void updatePageStyle() {
        ability().R(false);
    }

    public final d1<Integer> getCaptureAppendComplete() {
        return this.captureAppendComplete;
    }

    public final d1<Unit> getClearMarkSelectDrawing() {
        return this.clearMarkSelectDrawing;
    }

    public final i1<Boolean> getCropRegionChanged() {
        return this.cropRegionChanged;
    }

    public final i1<Bitmap> getCurrentBitmap() {
        return this.currentBitmap;
    }

    public final i1<nx8.m> getEduImageAbility() {
        return this.eduImageAbility;
    }

    public final i1<Boolean> getEduImageLoading() {
        return this.eduImageLoading;
    }

    public final i1<px8.b> getEduResultTabState() {
        return this.eduResultTabState;
    }

    public final i1<Boolean> getEnableRedo() {
        return this.enableRedo;
    }

    public final i1<Boolean> getEnableUndo() {
        return this.enableUndo;
    }

    public final i1<Boolean> getHasAccessToAIBeauty() {
        return this.hasAccessToAIBeauty;
    }

    public final i1<Boolean> getInFreeInputMode() {
        return this.inFreeInputMode;
    }

    public final i1<Bitmap> getRawBaseBitmap() {
        return this.rawBaseBitmap;
    }

    public final Bitmap getRawBitmapToCrop() {
        return this.rawBitmapToCrop;
    }

    public final i1<Boolean> getRawImageLoading() {
        return this.rawImageLoading;
    }

    public final i1<Long> getRedoPaint() {
        return this.redoPaint;
    }

    public final i1<px8.e> getResultBottomState() {
        return this.resultBottomState;
    }

    public final i1<com.larus.camera.impl.ui.component.result.general.n> getResultDetectionStatus() {
        return this.resultDetectionStatus;
    }

    public final i1<Rect> getResultPreviewBounds() {
        return this.resultPreviewBounds;
    }

    public final i1<ResultSuggestType> getResultSuggestType() {
        return this.resultSuggestType;
    }

    public final i1<Integer> getRotation() {
        return this.rotation;
    }

    public final i1<Boolean> getSuggestedActionBarDimmed() {
        return this.suggestedActionBarDimmed;
    }

    public final i1<Long> getUndoPaint() {
        return this.undoPaint;
    }

    public final i1<Boolean> isImageCropped() {
        return this.isImageCropped;
    }

    public final i1<Boolean> isInCropMode() {
        return this.isInCropMode;
    }

    public final i1<Boolean> isInDrawingMode() {
        return this.isInDrawingMode;
    }

    public final i1<Boolean> isInMarkSelectMode() {
        return this.isInMarkSelectMode;
    }

    public final boolean isMultiResultFromCamera() {
        return this.isMultiResultFromCamera;
    }

    public final i1<Integer> isMultiResultLoadComplete() {
        return this.isMultiResultLoadComplete;
    }

    public final i1<Boolean> isPhotoEditable() {
        return this.isPhotoEditable;
    }

    public final i1<Boolean> isSeekbarDragging() {
        return this.isSeekbarDragging;
    }

    /* JADX INFO: renamed from: getBitmapToCrop, reason: collision with other method in class */
    public final i1<Bitmap> m118getBitmapToCrop() {
        return this.bitmapToCrop;
    }

    public static final /* synthetic */ q0 access$ability(CameraResultViewModel r0) {
        return r0.ability();
    }

    public static final /* synthetic */ OutputParam access$getCurrentDisplayOutputParam$p(CameraResultViewModel r0) {
        return r0.currentDisplayOutputParam;
    }

    public static final /* synthetic */ EduIntentMode access$getCurrentEduIntent$p(CameraResultViewModel r0) {
        return r0.currentEduIntent;
    }

    public static final /* synthetic */ boolean access$getHasBeenCropped$p(CameraResultViewModel r0) {
        return r0.hasBeenCropped;
    }

    public static final /* synthetic */ boolean access$getHasBeenMarked$p(CameraResultViewModel r0) {
        return r0.hasBeenMarked;
    }

    public static final /* synthetic */ Function0 access$getMarkedImageGetter$p(CameraResultViewModel r0) {
        return r0.markedImageGetter;
    }

    public static final /* synthetic */ int access$getOriginRotation$p(CameraResultViewModel r0) {
        return r0.originRotation;
    }

    public static final /* synthetic */ Bitmap access$getPreviewImage(CameraResultViewModel r0) {
        return r0.getPreviewImage();
    }

    public static final /* synthetic */ com.larus.camera.impl.utils.g0 access$getPreviewThumbListStateFlowHolder$p(CameraResultViewModel r0) {
        return r0.previewThumbListStateFlowHolder;
    }

    public static final /* synthetic */ Function0 access$getRawMarkedImageGetter$p(CameraResultViewModel r0) {
        return r0.rawMarkedImageGetter;
    }

    public static final /* synthetic */ boolean access$getUsePreCropImageForFreeInputSubmit$p(CameraResultViewModel r0) {
        return r0.usePreCropImageForFreeInputSubmit;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_captureAppendComplete$p(CameraResultViewModel r0) {
        return r0._captureAppendComplete;
    }

    public static final /* synthetic */ z0 access$get_currentBitmap$p(CameraResultViewModel r0) {
        return r0._currentBitmap;
    }

    public static final /* synthetic */ z0 access$get_eduImageAbility$p(CameraResultViewModel r0) {
        return r0._eduImageAbility;
    }

    public static final /* synthetic */ z0 access$get_hasAccessToAIBeauty$p(CameraResultViewModel r0) {
        return r0._hasAccessToAIBeauty;
    }

    public static final /* synthetic */ z0 access$get_inFreeInputMode$p(CameraResultViewModel r0) {
        return r0._inFreeInputMode;
    }

    public static final /* synthetic */ z0 access$get_isMultiResultLoadComplete$p(CameraResultViewModel r0) {
        return r0._isMultiResultLoadComplete;
    }

    public static final /* synthetic */ z0 access$get_isPhotoEditable$p(CameraResultViewModel r0) {
        return r0._isPhotoEditable;
    }

    public static final /* synthetic */ z0 access$get_isSeekbarDragging$p(CameraResultViewModel r0) {
        return r0._isSeekbarDragging;
    }

    public static final /* synthetic */ z0 access$get_rawImageLoading$p(CameraResultViewModel r0) {
        return r0._rawImageLoading;
    }

    public static final /* synthetic */ z0 access$get_resultDetectionStatus$p(CameraResultViewModel r0) {
        return r0._resultDetectionStatus;
    }

    public static final /* synthetic */ z0 access$get_resultPreviewBounds$p(CameraResultViewModel r0) {
        return r0._resultPreviewBounds;
    }

    public static final /* synthetic */ z0 access$get_rotation$p(CameraResultViewModel r0) {
        return r0._rotation;
    }

    private final void commitCurrentMarkIfNeeded(String r5) {
        FLogger r0 = FLogger.a;
        r0.i(TAG, "commitCurrentMarkIfNeeded " + r5);
        if (resultSupportMark() == true) goto L7;
        r0.i(TAG, "commitCurrentMarkIfNeeded not support mark");
        return;
    L7:
        if (shouldUseOriginalImageDeferredEdit$default(this, null, 1, null) == false) goto L12;
        r0.i(TAG, "commitCurrentMarkIfNeeded shouldUseOriginalImageDeferredEdit");
        if (((Boolean) this.enableUndo.getValue()).booleanValue() == false) goto L23;
        setImageHasBeenMarked(true);
        return;
    L23:
        return;
    L12:
        Function0<Bitmap> r1 = this.markedImageGetter;
        if (r1 == null) goto L24;
        Bitmap r2 = (Bitmap) r1.invoke();
        if (r2 == null) goto L25;
        this._currentBitmap.tryEmit(r2);
        if (((Boolean) this.enableUndo.getValue()).booleanValue() == false) goto L19;
        setImageHasBeenMarked(true);
    L19:
        t r3 = t.a;
        OutputParam r4 = t.j(this.currentDisplayOutputParam, r2);
        if (r4 == null) goto L26;
        changePreviewThumbListState(r4, r5);
        return;
    L26:
        return;
    L25:
        return;
    }

    private final boolean completeDirectCameraFlow(CameraOutputContext r5) {
        Fragment r0 = ability().getCurrentFragment();
        SuggestedAction r1 = null;
        if (r0 == null) goto L5;
        FragmentActivity r2 = r0.getActivity();
    L6:
        com.larus.camera.impl.result.a.a.getClass();
        if (com.larus.camera.impl.result.a.a(r2, r5) == false) goto L10;
        ability().setResult(500000, new Intent());
        return true;
    L10:
        CameraResultFirstFlow.a.getClass();
        Intrinsics.checkNotNullParameter(r5, "outputContext");
        if (r2 == null) goto L30;
        Intent r3 = r2.getIntent();
        if (r3 == null) goto L30;
        String r4 = r3.getStringExtra("extra_camera_result_first_command_session_id");
        if (r4 == null) goto L30;
        Serializable r6 = r3.getSerializableExtra("KEY_OPEN_CAMERA_RESULT_PAGE_OUT_OPEN_PARAMS");
        if ((r6 instanceof CameraResultOutOpenParams) == false) goto L21;
        CameraResultOutOpenParams r7 = (CameraResultOutOpenParams) r6;
    L22:
        if (r7 == null) goto L30;
        CameraResultFirstFlow.a r8 = CameraResultFirstFlow.c.get(r4);
        if (r8 == null) goto L29;
        r1 = r8.j.d;
        if (r1 != null) goto L29;
        r1 = r8.h;
    L29:
        CameraResultFirstFlow.h(r4);
        return CameraResultFirstFlow.g(com.larus.bmhome.chat.camera.command.k.a(r5, r1), r7, "camera");
    L21:
        r7 = null;
    L30:
        return false;
    L5:
        r2 = null;
        goto L6
    }

    private final Bitmap createBitmapForMark(Bitmap r5) {
        if (r5.isMutable() == true) goto L5;
    L7:
        Bitmap r0 = r5.copy(Bitmap.Config.ARGB_8888, true);
        if (r0 != null) goto L11;
        Bitmap r1 = Bitmap.createBitmap(r5.getWidth(), r5.getHeight(), Bitmap.Config.ARGB_8888);
        new Canvas(r1).drawBitmap(r5, 0.0f, 0.0f, null);
        return r1;
    L11:
        return r0;
    L5:
        if (r5.getConfig() != Bitmap.Config.ARGB_8888) goto L7;
        return r5;
    }

    private final String currentOutputKey(OutputParam r2) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.getPath().length() != 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L13;
        t r1 = t.a;
        return t.g(r2);
    L13:
        return null;
    L6:
        r0 = false;
        goto L7
    }

    private final String getAiCreationMarkWatermarkUrl(OutputParam r5) {
        if (isFromMarkPage() == false) goto L33;
        boolean r0 = true;
        if (r5 == null) goto L11;
        ImageParam r3 = r5.getImageParam();
        if (r3 == null) goto L11;
        if (r3.isAiCreation() != true) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == true) goto L15;
        return null;
    L15:
        if (shouldUseNoWatermarkForMarkDownload(r5) == false) goto L18;
        return null;
    L18:
        if (r5.getImageParam().getMarkedMaskBitmap() != null) goto L20;
        return null;
    L20:
        InputParam r6 = getInputParam();
        if (r6 == null) goto L34;
        InputParamExtra r7 = r6.getExtra();
        if (r7 == null) goto L35;
        String r8 = (String) r7.get(InputParamExtra.KEY_DOWNLOAD_WATERMARK_URL);
        if (r8 != null) goto L27;
        return null;
    L27:
        if (r8.length() > 0) goto L30;
        r0 = false;
    L30:
        if (r0 == true) goto L32;
        return null;
    L32:
        return r8;
    L35:
        return null;
    L34:
        return null;
    L11:
        r4 = false;
        goto L12
    L33:
        return null;
    }

    private final List<c> getDeferredEditOperations(OutputParam r3) {
        String r4 = currentOutputKey(r3);
        List<c> r0 = null;
        if (r4 == null) goto L7;
        List r5 = (List) this.deferredEditOperations.get(r4);
        if (r5 == null) goto L7;
        r0 = CollectionsKt.toList(r5);
    L7:
        if (r0 == null) goto L9;
        return r0;
    L9:
        return CollectionsKt.emptyList();
    }

    private final Rect getMaskContentBounds(Bitmap r18) {
        int[] r0 = new int[r18.getWidth()];
        int r1 = r18.getWidth();
        int r2 = r18.getHeight();
        int r9 = r18.getHeight();
        int r11 = r1;
        int r12 = r2;
        int r13 = -1;
        int r14 = -1;
        int r15 = 0;
    L4:
        if (r15 >= r9) goto L20;
        int r6 = r15;
        r18.getPixels(r0, 0, r18.getWidth(), 0, r6, r18.getWidth(), 1);
        int r3 = r18.getWidth();
        int r4 = 0;
        boolean r5 = false;
    L6:
        if (r4 >= r3) goto L15;
        if ((r0[r4] >>> 24) == 0) goto L14;
        if (r4 >= r11) goto L11;
        r11 = r4;
    L11:
        if (r4 <= r13) goto L13;
        r13 = r4;
    L13:
        r5 = true;
    L14:
        r4 = r4 + 1;
        goto L6
    L15:
        if (r5 == false) goto L19;
        if (r15 >= r12) goto L18;
        r12 = r15;
    L18:
        r14 = r15;
    L19:
        r15 = r15 + 1;
        goto L4
    L20:
        if (r13 < r11) goto L25;
        if (r14 >= r12) goto L24;
        return null;
    L24:
        return new Rect(r11, r12, r13 + 1, r14 + 1);
    L25:
        return null;
    }

    private final pq9.h getSaveCallbackWhenFromCapture(boolean r2) {
        i r0 = this.saveBitmapCallback;
        r0.a = r2;
        return r0;
    }

    private final int invertDegree(int r1) {
        return (((360 - (r1 % 360)) % 360) / 90) * 90;
    }

    private final boolean isFromAlbumInMultiCapture(OutputParam r2) {
        if (r2.isVideo() == false) goto L7;
        return r2.isFromAlbum();
    L7:
        return Intrinsics.areEqual(UriProtector.parse(r2.getPath()).getScheme(), "content");
    }

    private final void logOnPreviewImageDetectFinished(CaptureResultDetectLogic.a r13) {
        ix8.e r0 = r13.g.b();
        if ((r0 instanceof ix8.e.b) == false) goto L6;
        int r2 = 0;
    L14:
        ix8.e r1 = r13.g.b();
        String r3 = null;
        if ((r1 instanceof ix8.e.b) == false) goto L17;
        ix8.e.b r4 = (ix8.e.b) r1;
    L18:
        if (r4 == null) goto L20;
        r3 = r4.a;
    L20:
        if (r3 != null) goto L22;
        String r9 = "";
    L23:
        ability().f0(CaptureResultDetectLogic.a.a(r13, r2, 0, 0, 0, 0, r9, null, 94));
        return;
    L22:
        r9 = r3;
        goto L23
    L17:
        r4 = null;
        goto L18
    L6:
        if (Intrinsics.areEqual(r0, ix8.e.d.a) == false) goto L9;
        r2 = 1;
        goto L14
    L9:
        if (Intrinsics.areEqual(r0, ix8.e.a.a) == false) goto L12;
        r2 = -1;
        goto L14
    L12:
        if (Intrinsics.areEqual(r0, ix8.e.c.a) == false) goto L26;
        r2 = -2;
        goto L14
    L26:
        throw new NoWhenBranchMatchedException();
    }

    private final int normalizeRightAngleRotation(int r1) {
        return ((r1 % 360) + 360) % 360;
    }

    private static final Unit openPage$lambda$1(ActivityResult r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return Unit.INSTANCE;
    }

    private final Map<String, Object> parseEduExtraParam(String r6) {
        if (r6 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        Object r1 = null;
        if (r0 == false) goto L24;
        return null;
    L24:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L13
        Object r7 = Result.constructor-impl((Map) new Gson().fromJson(r6, new h().getType()));     // Catch: Throwable -> L13
    L15:
        Throwable r3 = Result.exceptionOrNull-impl(r7);
        if (r3 == null) goto L19;
        FLogger.a.w(TAG, "[parseEduExtraParam] invalid edu_extra_param: " + r3.getMessage(), r3);
    L19:
        if (Result.isFailure-impl(r7) == true) goto L23;
        r1 = r7;
    L23:
        return (Map) r1;
    L13:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L4:
        if (StringsKt.isBlank(r6) == true) goto L7;
        r0 = false;
        goto L8
    }

    private final void processCaptureResult(ActivityResult r9) {
        FLogger r0 = FLogger.a;
        r0.i(TAG, "[processCaptureResult] resultCode=" + r9.getResultCode());
        if (r9.getResultCode() != 100000) goto L29;
        Intent r10 = r9.getData();
        if (r10 == null) goto L7;
        Serializable r11 = r10.getSerializableExtra("CAMERA_OUTPUT_CONTEXT");
    L9:
        if ((r11 instanceof CameraOutputContext) == false) goto L11;
        CameraOutputContext r12 = (CameraOutputContext) r11;
    L12:
        if (r12 == null) goto L14;
        List<OutputParam> r13 = r12.getOutputParamList();
    L15:
        StringBuilder r3 = new StringBuilder("[processCaptureResult] newOutputParamList size=");
        if (r13 == null) goto L18;
        Integer r4 = Integer.valueOf(r13.size());
    L19:
        r3.append(r4);
        r0.i(TAG, r3.toString());
        List<OutputParam> r1 = r13;
        if (r1 != null) goto L22;
    L25:
        boolean r2 = true;
    L26:
        if (r2 == true) goto L30;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02511(r13, this, null), 3, null);
        return;
    L30:
        return;
    L22:
        if (r1.isEmpty() == true) goto L25;
        r2 = false;
        goto L26
    L18:
        r4 = null;
        goto L19
    L14:
        r13 = null;
        goto L15
    L11:
        r12 = null;
        goto L12
    L7:
        r11 = null;
        goto L9
    }

    private final void recordMarkEditOperation(Bitmap r8) {
        String r0 = currentOutputKey$default(this, null, 1, null);
        if (r0 != null) goto L5;
        return;
    L5:
        vt7.a<String, List<c>> r1 = this.deferredEditOperations;
        Object r2 = r1.get(r0);
        if (r2 != null) goto L8;
        r2 = new ArrayList();
        r1.put(r0, r2);
    L8:
        List r3 = (List) r2;
        if (r8 != null) goto L16;
        Integer r9 = (Integer) this.activeMarkOperationIndex.remove(r0);
        if (r9 == null) goto L31;
        int r10 = r9.intValue();
        if ((CollectionsKt.getOrNull(r3, r10) instanceof c.b) == false) goto L32;
        ListProtector.remove(r3, r10);
        return;
    L32:
        return;
    L31:
        return;
    L16:
        Bitmap r4 = (Bitmap) this.currentBitmap.getValue();
        if (r4 == null) goto L19;
        int r5 = r4.getWidth();
    L20:
        if (r4 == null) goto L22;
        int r6 = r4.getHeight();
    L23:
        Integer r7 = (Integer) this.activeMarkOperationIndex.get(r0);
        c.b r11 = new c.b(r8, r5, r6);
        if (r7 != null) goto L26;
    L28:
        r3.add(r11);
        this.activeMarkOperationIndex.put(r0, Integer.valueOf(CollectionsKt.getLastIndex(r3)));
    L29:
        FLogger.a.i(TAG, "[recordMarkEditOperation] key:" + r0 + " mask:" + r8 + " source:" + r5 + 'x' + r6);
        return;
    L26:
        if ((CollectionsKt.getOrNull(r3, r7.intValue()) instanceof c.b) == false) goto L28;
        ListProtector.set(r3, r7.intValue(), r11);
        goto L29
    L22:
        r6 = r8.getHeight();
        goto L23
    L19:
        r5 = r8.getWidth();
        goto L20
    }

    private final void recordMarkSelectSessionSnapshot(OutputParam r4) {
        FLogger.a.i(TAG, "recordMarkSelectSessionSnapshot outputParam:" + r4);
        String r0 = currentOutputKey(r4);
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.markSelectSessionMaskKeys.containsKey(r0) == true) goto L9;
        this.markSelectSessionMaskKeys.put(r0, Boolean.TRUE);
    L9:
        if (shouldUseOriginalImageDeferredEdit(r4) == true) goto L11;
        return;
    L11:
        if (this.markSelectSessionOperationSizes.containsKey(r0) == true) goto L19;
        vt7.a<String, Integer> r5 = this.markSelectSessionOperationSizes;
        List r1 = (List) this.deferredEditOperations.get(r0);
        if (r1 == null) goto L15;
        int r2 = r1.size();
    L16:
        r5.put(r0, Integer.valueOf(r2));
        return;
    L15:
        r2 = 0;
        goto L16
    }

    private final void saveMultipleResultAndCloseInternal(Function1<? super List<OutputParam>, Unit> r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02551(this, r7, null), 3, null);
    }

    private static final long saveResultInMultiCaptureMode$lambda$55$lambda$54$lambda$53$lambda$52(String r2) {
        if (r2 != null) goto L6;
        return 0;
    L6:
        return new PolarisFileWrapper(r2).length();
    }

    private final void saveSingleResultAndCloseInternal(Function1<? super OutputParam, Unit> r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02571(this, r7, null), 3, null);
    }

    private final void setupMultiResult(Context r10) {
        List<OutputParam> r0 = getOriginMultiOutputParamList();
        if (r0 != null) goto L5;
        return;
    L5:
        FLogger.a.i(TAG, "[setupMultiResult] outputParamList size:" + r0.size());
        if (r0.size() > 1) goto L8;
        return;
    L8:
        this.isMultiResultFromCamera = true;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02581(r0, this, r10, null), 3, null);
    }

    private final boolean shouldUseNoWatermarkForMarkDownload(OutputParam r3) {
        if (isFromMarkPage() == false) goto L15;
        if (r3 == null) goto L10;
        ImageParam r4 = r3.getImageParam();
        if (r4 == null) goto L10;
        boolean r0 = true;
        if (r4.isAiCreation() != true) goto L10;
    L11:
        if (r0 == false) goto L15;
        return useNoWatermarkImageForMarkDownload();
    L10:
        r0 = false;
    L15:
        return false;
    }

    private final void updateResultBottomState(px8.e r2) {
        this._resultBottomState.setValue(r2);
        z0<ResultSuggestType> r0 = this._resultSuggestType;
        if (r2 == null) goto L5;
        ResultSuggestType r3 = r2.b;
    L6:
        r0.setValue(r3);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void addPreviewBitmapHolder(OutputParam r3) {
        t r0 = t.a;
        t.a(r3, null, "addPreviewBitmapHolder");
    }

    public final void changeEduIntent(EduIntentMode r3) {
        Intrinsics.checkNotNullParameter(r3, "eduIntentMode");
        this.currentEduIntent = r3;
        EduIntentMode r0 = EduIntentMode.MULTI_QUESTION;
        if (r3 != r0) goto L5;
    L8:
        if (r3 != r0) goto L10;
        boolean r4 = true;
    L11:
        Boolean r5 = Boolean.valueOf(r4);
    L12:
        this.isEduMultiQuestionModel = r5;
        return;
    L10:
        r4 = false;
        goto L11
    L5:
        if (r3 == EduIntentMode.SINGLE_QUESTION) goto L8;
        r5 = null;
        goto L12
    }

    public final void changeMultiQuestionMode(boolean r1) {
        this.isEduMultiQuestionModel = Boolean.valueOf(r1);
    }

    public final void clickImageRangeOnResultPage(int r4) {
        ability().n0(getCameraData().getCaptureMode(), this.isEduMultiQuestionModel, r4);
    }

    public final void clickSwitchDetectIntentOnResultPage(String r4) {
        Intrinsics.checkNotNullParameter(r4, "buttonType");
        ability().w(getCameraData().getCaptureMode(), r4, this.isEduMultiQuestionModel);
    }

    public final void clickVideoPlayOnResultPage(String r4) {
        Intrinsics.checkNotNullParameter(r4, "button");
        ability().J0(getCameraData().getCaptureMode(), r4, this.isEduMultiQuestionModel);
    }

    public final boolean currentResultContainsVideo(boolean r4) {
        if (zx8.b.b() == true) goto L6;
        return false;
    L6:
        if (r4 == false) goto L19;
        t r5 = t.a;
        List r6 = t.f();
        if ((r6 instanceof Collection) == true) goto L10;
    L12:
        Iterator r7 = r6.iterator();
    L14:
        if (r7.hasNext() == false) goto L94;
        if (((OutputParam) r7.next()).isVideo() == false) goto L14;
    L73:
        return true;
    L94:
        return false;
    L10:
        if (r6.isEmpty() == false) goto L12;
        return false;
    L19:
        if (this.isMultiResultFromCamera == false) goto L59;
        if (((Number) this.isMultiResultLoadComplete.getValue()).intValue() != (-1)) goto L59;
        List<OutputParam> r8 = getOriginMultiOutputParamList();
        if (r8 == null) goto L40;
        List<OutputParam> r9 = r8;
        if ((r9 instanceof Collection) == true) goto L27;
    L29:
        Iterator<T> r10 = r9.iterator();
    L31:
        if (r10.hasNext() == false) goto L40;
        OutputParam r2 = (OutputParam) r10.next();
        if (r2 != null) goto L35;
    L37:
        boolean r3 = false;
    L38:
        if (r3 == false) goto L31;
        boolean r11 = true;
    L41:
        if (r11 == true) goto L73;
        if (isFromMultiCapture() == false) goto L89;
        t r12 = t.a;
        List r13 = t.f();
        if ((r13 instanceof Collection) == true) goto L47;
    L49:
        Iterator r14 = r13.iterator();
    L51:
        if (r14.hasNext() == false) goto L55;
        if (((OutputParam) r14.next()).isVideo() == false) goto L51;
        boolean r15 = true;
    L56:
        if (r15 == true) goto L73;
        return false;
    L55:
        r15 = false;
        goto L56
    L47:
        if (r13.isEmpty() == false) goto L49;
    L89:
        return false;
    L35:
        if (r2.isVideo() != true) goto L37;
        r3 = true;
        goto L38
    L27:
        if (r9.isEmpty() == false) goto L29;
    L40:
        r11 = false;
    L59:
        if (currentPreviewIsVideo() == true) goto L73;
        t r16 = t.a;
        List r17 = t.f();
        if ((r17 instanceof Collection) == true) goto L63;
    L65:
        Iterator r18 = r17.iterator();
    L67:
        if (r18.hasNext() == false) goto L71;
        if (((OutputParam) r18.next()).isVideo() == false) goto L67;
        boolean r19 = true;
    L72:
        if (r19 == true) goto L73;
        return false;
    L71:
        r19 = false;
        goto L72
    L63:
        if (r17.isEmpty() == false) goto L65;
        goto L65
    }

    public final void download(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        FLogger.a.i(TAG, "[download]");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02421(this, r10, null), 3, null);
    }

    public final void enableFreeInputMode(boolean r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02431(r7, this, null), 3, null);
    }

    public final void finishMarkSelectMode(String r4) {
        Intrinsics.checkNotNullParameter(r4, "from");
        FLogger r0 = FLogger.a;
        r0.i(TAG, "finishMarkSelectMode " + r4);
        if (((Boolean) this.isInMarkSelectMode.getValue()).booleanValue() == true) goto L6;
        r0.i(TAG, "finishMarkSelectMode not in mark select mode");
        return;
    L6:
        commitCurrentMarkIfNeeded(r4);
        this._isInMarkSelectMode.tryEmit(Boolean.FALSE);
        setRedoEnabled(false);
        setUndoEnabled(false);
        setInDrawingMode(false);
        clearMarkSelectSession();
    }

    public final Bitmap getMarkedMaskBitmap(String r6) {
        if (r6 != null) goto L4;
    L7:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return null;
    L11:
        t r1 = t.a;
        Iterator r2 = t.f().iterator();
    L13:
        if (r2.hasNext() == false) goto L17;
        Object r3 = r2.next();
        t r4 = t.a;
        if (Intrinsics.areEqual(t.g((OutputParam) r3), r6) == false) goto L13;
    L18:
        OutputParam r5 = (OutputParam) r3;
        if (r5 == null) goto L27;
        ImageParam r7 = r5.getImageParam();
        if (r7 != null) goto L23;
        return null;
    L23:
        return r7.getMarkedMaskBitmap();
    L27:
        return null;
    L17:
        r3 = null;
        goto L18
    L4:
        if (r6.length() == 0) goto L7;
        r0 = false;
        goto L9
    }

    public final void getParamAlbumUrlOrBitmapPath(Function1<? super String, Unit> r8) {
        Intrinsics.checkNotNullParameter(r8, "callback");
        if (Intrinsics.areEqual(this._isPhotoEditable.getValue(), Boolean.TRUE) == false) goto L5;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02461(this, r8, null), 3, null);
        return;
    L5:
        r8.invoke(getParamAlbumUrl());
    }

    public final void leaveResultPageOnSubmit(String r10) {
        Intrinsics.checkNotNullParameter(r10, "leaveReason");
        ability().a(r10, isFromAlbum(), getCameraData().getSwitchTab(), getCameraData().getCaptureMode(), this.isEduMultiQuestionModel, boundsChanged(), this.currentEduIntent);
    }

    public final void prepareFreeInputImagePolicy(Pair<String, Integer> r5) {
        Intrinsics.checkNotNullParameter(r5, "inputContent");
        EduResultMode r0 = ((px8.b) this._eduResultTabState.getValue()).b;
        boolean r2 = false;
        if (com.larus.camera.impl.utils.w.a() == true) goto L5;
    L9:
        boolean r1 = false;
    L11:
        if (com.larus.utils.o0.d((String) r5.getFirst()) == false) goto L21;
        if (r1 == false) goto L21;
        if (com.larus.camera.impl.utils.w.b.c() == true) goto L16;
    L18:
        boolean r6 = false;
    L19:
        if (r6 == false) goto L21;
        r2 = true;
        goto L21
    L16:
        if (com.larus.camera.impl.utils.w.b.e() != 1) goto L18;
        r6 = true;
    L21:
        this.usePreCropImageForFreeInputSubmit = r2;
        FLogger.a.i(TAG, "[prepareFreeInputImagePolicy] usePreCropImage:" + this.usePreCropImageForFreeInputSubmit + ", selectedMode:" + r0);
        return;
    L5:
        if (r0 != EduResultMode.SINGLE_QUESTION) goto L7;
    L8:
        r1 = true;
        goto L11
    L7:
        if (r0 != EduResultMode.MULTI_QUESTION) goto L9;
        goto L8
    }

    public final void recordCropEditOperation(ft8.a r5) {
        Intrinsics.checkNotNullParameter(r5, "operation");
        if (shouldUseOriginalImageDeferredEdit$default(this, null, 1, null) == true) goto L5;
        return;
    L5:
        String r0 = currentOutputKey$default(this, null, 1, null);
        if (r0 != null) goto L8;
        return;
    L8:
        vt7.a<String, List<c>> r1 = this.deferredEditOperations;
        Object r2 = r1.get(r0);
        if (r2 != null) goto L11;
        r2 = new ArrayList();
        r1.put(r0, r2);
    L11:
        ((List) r2).add(new c.a(r5));
        this.activeMarkOperationIndex.remove(r0);
        FLogger.a.i(TAG, "[recordCropEditOperation] key:" + r0 + " operation:" + r5);
    }

    public final void recordPreviewBounds(Rect r8) {
        Intrinsics.checkNotNullParameter(r8, "bounds");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain(), null, new C02521(r8, this, null), 2, null);
    }

    public final void recoverRotation(int r10) {
        FLogger.a.i(TAG, "[recoverRotation] " + this.originRotation);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02531(this, r10, null), 3, null);
    }

    public final void selectEduResultMode(EduResultMode r5) {
        Intrinsics.checkNotNullParameter(r5, "mode");
        px8.b r0 = (px8.b) this._eduResultTabState.getValue();
        if (r0.a.contains(r5) == true) goto L5;
        return;
    L5:
        List<EduResultMode> r1 = r0.a;
        boolean r2 = r0.c;
        EduResultMode r3 = r0.d;
        Intrinsics.checkNotNullParameter(r1, "availableModes");
        Intrinsics.checkNotNullParameter(r5, "selectedMode");
        Intrinsics.checkNotNullParameter(r3, "defaultMode");
        updateEduResultTabState(new px8.b(r1, r5, r2, r3));
    }

    public final void setCancelResult(String r2) {
        ability().x0(r2);
    }

    public final void setCropRegionChanged(boolean r2) {
        this._cropRegionChanged.tryEmit(Boolean.valueOf(r2));
    }

    public final void setImageCropped(boolean r11) {
        if (r11 == false) goto L4;
        resetMarkSelectSessionAfterCrop();
    L4:
        this._isImageCropped.tryEmit(Boolean.valueOf(r11));
        if (r11 == false) goto L58;
        this.hasBeenCropped = true;
        t r0 = t.a;
        OutputParam r1 = this.currentDisplayOutputParam;
        boolean r2 = false;
        if (r1 != null) goto L9;
    L11:
        boolean r3 = false;
    L12:
        OutputParam r4 = null;
        if (r3 == true) goto L50;
        Iterator r5 = t.f().iterator();
    L17:
        if (r5.hasNext() == false) goto L35;
        Object r6 = r5.next();
        OutputParam r7 = (OutputParam) r6;
        if (r7.getPath().length() <= 0) goto L21;
        boolean r8 = true;
    L22:
        if (r8 == false) goto L32;
        String r9 = r7.getPath();
        if (r1 == null) goto L26;
        String r10 = r1.getPath();
    L28:
        if (Intrinsics.areEqual(r9, r10) == false) goto L32;
        if (r7.getCreateTime() != r1.getCreateTime()) goto L32;
        boolean r12 = true;
    L33:
        if (r12 == false) goto L17;
    L36:
        OutputParam r13 = (OutputParam) r6;
        if (r13 == null) goto L43;
        ImageParam r14 = r13.getImageParam();
        if (r14 == null) goto L43;
        if (r14.isPhotoCropped() != true) goto L43;
        r2 = true;
    L43:
        if (r2 == true) goto L50;
        if (r13 == null) goto L49;
        ImageParam r15 = r13.getImageParam();
        if (r15 == null) goto L49;
        r15.setPhotoCropped(true);
    L49:
        r4 = r13;
        goto L50
    L26:
        r10 = null;
    L32:
        r12 = false;
        goto L33
    L21:
        r8 = false;
        goto L22
    L35:
        r6 = null;
    L50:
        if (r4 == null) goto L59;
        this.currentDisplayOutputParam = r4;
        return;
    L59:
        return;
    L9:
        if (r1.isVideo() != true) goto L11;
        r3 = true;
        goto L12
    }

    public final void setImageHasBeenMarked(boolean r10) {
        this.hasBeenMarked = r10;
        if (r10 == false) goto L50;
        t r11 = t.a;
        OutputParam r12 = this.currentDisplayOutputParam;
        boolean r0 = false;
        if (r12 != null) goto L7;
    L9:
        boolean r2 = false;
    L10:
        if (r2 == true) goto L53;
        Iterator r3 = t.f().iterator();
    L13:
        Object r4 = null;
        if (r3.hasNext() == false) goto L31;
        Object r5 = r3.next();
        OutputParam r6 = (OutputParam) r5;
        if (r6.getPath().length() <= 0) goto L18;
        boolean r7 = true;
    L19:
        if (r7 == false) goto L28;
        String r8 = r6.getPath();
        if (r12 == null) goto L24;
        r4 = r12.getPath();
    L24:
        if (Intrinsics.areEqual(r8, r4) == false) goto L28;
        if (r6.getCreateTime() != r12.getCreateTime()) goto L28;
        boolean r9 = true;
    L29:
        if (r9 == false) goto L13;
        r4 = r5;
    L28:
        r9 = false;
        goto L29
    L18:
        r7 = false;
    L31:
        OutputParam r13 = (OutputParam) r4;
        if (r13 == null) goto L38;
        ImageParam r14 = r13.getImageParam();
        if (r14 == null) goto L38;
        if (r14.isPhotoMarked() != true) goto L38;
        r0 = true;
    L38:
        if (r0 == true) goto L54;
        if (r13 == null) goto L51;
        ImageParam r15 = r13.getImageParam();
        if (r15 == null) goto L52;
        r15.setPhotoMarked(true);
        return;
    L52:
        return;
    L51:
        return;
    L54:
        return;
    L53:
        return;
    L7:
        if (r12.isVideo() != true) goto L9;
        r2 = true;
        goto L10
    }

    public final void setInCropMode(boolean r3) {
        this._isInCropMode.tryEmit(Boolean.valueOf(r3));
        if (r3 == true) goto L6;
        this._bitmapToCrop.tryEmit(null);
        return;
    }

    public final void setInDrawingMode(boolean r2) {
        this._isInDrawingMode.tryEmit(Boolean.valueOf(r2));
    }

    public final void setIsPhotoEditable(boolean r2) {
        this._isPhotoEditable.tryEmit(Boolean.valueOf(r2));
    }

    public final void setMarkInputActive(boolean r2) {
        this._markInputActive.tryEmit(Boolean.valueOf(r2));
    }

    public final void setMarkedImageGetter(Function0<Bitmap> r1) {
        this.markedImageGetter = r1;
        enterInitialImageEditModeIfReady();
    }

    public final void setPhotoEditable(i1<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.isPhotoEditable = r2;
    }

    public final void setRawBaseBitmap(Bitmap r2) {
        this._rawBaseBitmap.setValue(r2);
    }

    public final void setRawImageLoading(boolean r2) {
        this._rawImageLoading.setValue(Boolean.valueOf(r2));
    }

    public final void setRawMarkedImageGetter(Function0<Bitmap> r1) {
        this.rawMarkedImageGetter = r1;
    }

    public final void setRedoEnabled(boolean r2) {
        this._enableRedo.tryEmit(Boolean.valueOf(r2));
    }

    public final void setSuggestedActionBarDimmed(boolean r2) {
        this._suggestedActionBarDimmed.setValue(Boolean.valueOf(r2));
    }

    public final void setUndoEnabled(boolean r2) {
        this._enableUndo.tryEmit(Boolean.valueOf(r2));
    }

    public final boolean shouldUseOriginalImageDeferredEdit(OutputParam r4) {
        InputParam r0 = getInputParam();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L18;
        if (r4 != null) goto L11;
    L13:
        boolean r2 = false;
    L14:
        if (r2 == true) goto L18;
        if (com.larus.camera.impl.ui.component.result.general.viewpager.u.a(r4) == true) goto L18;
        return true;
    L11:
        if (r4.isVideo() != true) goto L13;
        r2 = true;
    L18:
        return false;
    L5:
        if (r0.getEnableOriginalImageDeferredEdit() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final boolean shouldUseUnifiedPreviewFramework(com.larus.camera.impl.ui.component.result.general.n r5) {
        Intrinsics.checkNotNullParameter(r5, "detectStatus");
        InputParam r0 = getInputParam();
        if (r0 == null) goto L6;
        InputParam.InitialImageEditMode r1 = r0.getInitialImageEditMode();
        if (r1 == null) goto L6;
    L8:
        if (shouldUseUnifiedResultTopStyle() == true) goto L10;
    L35:
        return false;
    L10:
        if (isFromCameraPage() == false) goto L35;
        if (r1 != InputParam.InitialImageEditMode.NONE) goto L35;
        boolean r2 = currentPreviewIsVideo();
        if (enableResultDetect() == false) goto L24;
        if (r2 == true) goto L24;
        if (isMultiCaptureEnabled() == true) goto L24;
        if (isFromMultiCapture() == true) goto L24;
        if (this.isMultiResultFromCamera == true) goto L24;
        boolean r3 = true;
    L25:
        if (r3 == true) goto L28;
        return true;
    L28:
        if ((r5 instanceof com.larus.camera.impl.ui.component.result.general.n.a) == false) goto L30;
        com.larus.camera.impl.ui.component.result.general.n.a r6 = (com.larus.camera.impl.ui.component.result.general.n.a) r5;
    L31:
        if (r6 != null) goto L34;
        return false;
    L34:
        return r6.a instanceof ix8.d.a;
    L30:
        r6 = null;
    L24:
        r3 = false;
    L6:
        r1 = InputParam.InitialImageEditMode.NONE;
        goto L8
    }

    public final void showCameraItemMobOnResult(String r4) {
        Intrinsics.checkNotNullParameter(r4, "itemType");
        ability().c0(r4, getCameraData().getCaptureMode(), null, null);
    }

    public final boolean tryUpdateEduImageLoading(boolean r2) {
        return this._eduImageLoading.tryEmit(Boolean.valueOf(r2));
    }

    public final void updateCurrentMarkedMaskBitmap(Bitmap r7) {
        OutputParam r0 = null;
        boolean r1 = true;
        if (shouldUseOriginalImageDeferredEdit$default(this, null, 1, null) == false) goto L5;
        recordMarkEditOperation(r7);
    L5:
        t r2 = t.a;
        OutputParam r3 = this.currentDisplayOutputParam;
        FLogger.a.i("CameraMultiCaptureOutputManager", "updateMarkedMaskBitmap, param:" + r3 + ", bitmap:" + r7);
        if (r3 != null) goto L8;
    L19:
        if (r0 == null) goto L22;
        changePreviewThumbListState(r0, "updateCurrentMarkedMaskBitmap");
        return;
    L22:
        return;
    L8:
        if (r3.getPath().length() == 0) goto L11;
        r1 = false;
    L11:
        if (r1 == true) goto L19;
        if (r7 == null) goto L19;
        if (r7.isRecycled() == true) goto L19;
        if (r3.isVideo() == true) goto L19;
        r0 = t.k(r3, r7);
        goto L19
    }

    public final Job updateEduImageAbility(nx8.m r7) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02611(this, r7, null), 3, null);
    }

    public final void updateEduResultTabState(px8.b r6) {
        Intrinsics.checkNotNullParameter(r6, "state");
        this._eduResultTabState.setValue(r6);
        if (com.larus.camera.impl.utils.w.a() == true) goto L5;
        return;
    L5:
        if (r6.a.contains(r6.b) == false) goto L32;
        changeEduIntent(r6.b.toEduIntentMode());
        int r0 = px8.f.a;
        EduResultMode r7 = r6.b;
        Intrinsics.checkNotNullParameter(r7, "mode");
        int r1 = px8.g.a;
        Intrinsics.checkNotNullParameter(r7, "mode");
        if (com.larus.camera.impl.utils.w.b.c() == true) goto L18;
        int r8 = px8.g.a.a[r7.ordinal()];
        if (r8 == 1) goto L17;
        if (r8 == 2) goto L17;
        if (r8 == 3) goto L16;
        if (r8 != 4) goto L15;
        ResultTabPresentationType r9 = ResultTabPresentationType.PHOTO;
    L29:
        updateResultBottomState(r9.toBottomState());
        return;
    L15:
        throw new NoWhenBranchMatchedException();
    L16:
        r9 = ResultTabPresentationType.HOMEWORK_CORRECTION;
    L17:
        r9 = ResultTabPresentationType.QUESTION_LEGACY;
        goto L29
    L18:
        int r10 = px8.g.a.a[r7.ordinal()];
        if (r10 == 1) goto L28;
        if (r10 == 2) goto L27;
        if (r10 == 3) goto L26;
        if (r10 != 4) goto L25;
        r9 = ResultTabPresentationType.PHOTO;
        goto L29
    L25:
        throw new NoWhenBranchMatchedException();
    L26:
        r9 = ResultTabPresentationType.HOMEWORK_CORRECTION;
        goto L29
    L27:
        r9 = ResultTabPresentationType.MULTI_QUESTION;
        goto L29
    L28:
        r9 = ResultTabPresentationType.QUESTION;
        goto L29
    }

    public final void updateHasAccessToAIBeauty(boolean r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02621(r7, this, null), 3, null);
    }

    public final void updatePreviewThumbListDeleteState(boolean r5) {
        com.larus.camera.impl.utils.g0<Pair<Long, Boolean>> r0 = this.previewThumbListDeleteStateFlowHolder;
        Pair r1 = new Pair(Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(r5));
        r0.a.setValue(r1);
    }

    public final void updateSeekbarDraggingState(boolean r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02631(this, r7, null), 3, null);
    }

    public static final /* synthetic */ pq9.h access$getSaveCallbackWhenFromCapture(CameraResultViewModel r0, boolean r1) {
        return r0.getSaveCallbackWhenFromCapture(r1);
    }

    public static final /* synthetic */ int access$invertDegree(CameraResultViewModel r0, int r1) {
        return r0.invertDegree(r1);
    }

    public static final /* synthetic */ void access$logOnPreviewImageDetectFinished(CameraResultViewModel r0, CaptureResultDetectLogic.a r1) {
        r0.logOnPreviewImageDetectFinished(r1);
    }

    public static final /* synthetic */ void access$setCurrentDisplayOutputParam$p(CameraResultViewModel r0, OutputParam r1) {
        r0.currentDisplayOutputParam = r1;
    }

    public static final /* synthetic */ void access$setOriginRotation$p(CameraResultViewModel r0, int r1) {
        r0.originRotation = r1;
    }

    public static final /* synthetic */ void access$setUsePreCropImageForFreeInputSubmit$p(CameraResultViewModel r0, boolean r1) {
        r0.usePreCropImageForFreeInputSubmit = r1;
    }

    public static final /* synthetic */ boolean access$shouldUseNoWatermarkForMarkDownload(CameraResultViewModel r0, OutputParam r1) {
        return r0.shouldUseNoWatermarkForMarkDownload(r1);
    }

    private final Bitmap applyMarkOperations(Bitmap r7, List<d> r8) {
        Object r1 = null;
        if (r8.isEmpty() == false) goto L24;
        return null;
    L24:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L13
        Bitmap r9 = createBitmapForMark(r7);     // Catch: Throwable -> L13
        Paint r2 = new Paint(3);     // Catch: Throwable -> L13
        Canvas r3 = new Canvas(r9);     // Catch: Throwable -> L13
        Iterator<T> r10 = r8.iterator();     // Catch: Throwable -> L13
    L7:
        if (r10.hasNext() == false) goto L11;
        d r4 = (d) r10.next();     // Catch: Throwable -> L13
        Bitmap r5 = r4.a;     // Catch: Throwable -> L13
        if (r5.isRecycled() == true) goto L7;
        r3.drawBitmap(r5, r4.b, r2);     // Catch: Throwable -> L13
        goto L7
    L11:
        Object r11 = Result.constructor-impl(r9);     // Catch: Throwable -> L13
    L15:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L19;
        FLogger.a.e(TAG, "[applyMarkOperations] fail:" + r12.getMessage());
    L19:
        if (Result.isFailure-impl(r11) == true) goto L23;
        r1 = r11;
    L23:
        return (Bitmap) r1;
    L13:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    private final Bitmap applyMarkedMaskIfNeeded(OutputParam r8, Bitmap r9) {
        if (r8 == null) goto L51;
        ImageParam r10 = r8.getImageParam();
        if (r10 == null) goto L52;
        Bitmap r11 = r10.getMarkedMaskBitmap();
        if (r11 == null) goto L55;
        if (r9 != null) goto L10;
        return r9;
    L10:
        if (r9.isRecycled() == false) goto L12;
        return r9;
    L12:
        if (r11.isRecycled() == false) goto L15;
        return r9;
    L15:
        if (hasSameAspectRatio(r11.getWidth(), r11.getHeight(), r9.getWidth(), r9.getHeight()) == true) goto L18;
        FLogger.a.w(TAG, "[applyMarkedMaskIfNeeded] skip mismatched mask:" + r11.getWidth() + 'x' + r11.getHeight() + ", bitmap:" + r9.getWidth() + 'x' + r9.getHeight());
        return r9;
    L18:
        Object r0 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L35
        Bitmap r3 = r9.copy(Bitmap.Config.ARGB_8888, true);     // Catch: Throwable -> L35
        if (r3 != null) goto L23;
        r3 = Bitmap.createBitmap(r9.getWidth(), r9.getHeight(), Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L35
        new Canvas(r3).drawBitmap(r9, 0.0f, 0.0f, null);     // Catch: Throwable -> L35
    L23:
        if (r11.getWidth() == r3.getWidth()) goto L25;
    L27:
        Bitmap r4 = Bitmap.createScaledBitmap(r11, r3.getWidth(), r3.getHeight(), true);     // Catch: Throwable -> L35
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L35
    L28:
        new Canvas(r3).drawBitmap(r4, 0.0f, 0.0f, null);     // Catch: Throwable -> L35
        if (r4 != r11) goto L31;
    L33:
        Object r12 = Result.constructor-impl(r3);     // Catch: Throwable -> L35
    L37:
        Throwable r5 = Result.exceptionOrNull-impl(r12);
        if (r5 == null) goto L41;
        FLogger.a.e(TAG, "[applyMarkedMaskIfNeeded] fail:" + r5.getMessage());
    L41:
        if (Result.isFailure-impl(r12) == true) goto L44;
        r0 = r12;
    L44:
        Bitmap r1 = (Bitmap) r0;
        if (r1 != null) goto L48;
        return r9;
    L48:
        return r1;
    L31:
        if (r4.isRecycled() == true) goto L33;
        r4.recycle();     // Catch: Throwable -> L35
        goto L33
    L25:
        if (r11.getHeight() != r3.getHeight()) goto L27;
        r4 = r11;
    L35:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L37
    L55:
        return r9;
    L52:
        return r9;
    L51:
        return r9;
    }

    private final Object awaitRawImageReady(long r3, Continuation<? super Unit> r5) {
        if (((Boolean) this._rawImageLoading.getValue()).booleanValue() == false) goto L5;
        Object r4 = TimeoutKt.c(r3, new AnonymousClass2(this, null), r5);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r4;
    L10:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    private final int calculatePreviewInSampleSize(int r4, int r5) {
        int r0 = 1;
    L4:
        if ((r4 / r0) > 2560) goto L9;
        if ((r5 / r0) > 2560) goto L9;
        return r0;
    L9:
        r0 = r0 * 2;
        goto L4
    }

    private final void changePreviewThumbListState(OutputParam r4, String r5) {
        FLogger.a.i(TAG, "changePreviewThumbListState " + r5);
        this.currentDisplayOutputParam = r4;
        notifyPreviewThumbListStateChanged(r4, r5);
    }

    private final Bitmap createFinalMarkBitmap(Bitmap r5, Rect r6) {
        Object r1 = null;
        if (r5.isRecycled() == false) goto L5;
        return null;
    L5:
        if (r6.width() > 0) goto L7;
        return null;
    L7:
        if (r6.height() > 0) goto L10;
        return null;
    L10:
        if (r6.left == 0) goto L12;
    L31:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L20
        Object r7 = Result.constructor-impl(Bitmap.createBitmap(r5, r6.left, r6.top, r6.width(), r6.height()));     // Catch: Throwable -> L20
    L22:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L26;
        FLogger.a.e(TAG, "[createFinalMarkBitmap] fail:" + r8.getMessage());
    L26:
        if (Result.isFailure-impl(r7) == true) goto L30;
        r1 = r7;
    L30:
        return (Bitmap) r1;
    L20:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    L12:
        if (r6.top != 0) goto L31;
        if (r6.right != r5.getWidth()) goto L31;
        if (r6.bottom != r5.getHeight()) goto L31;
        return r5;
    }

    private final d createFinalMarkOperation(e r3, RectF r4) {
        if (intersectRectF(r3.d, r4) != null) goto L5;
        return null;
    L5:
        Bitmap r5 = createFinalMarkBitmap(r3.a, r3.b);
        if (r5 != null) goto L8;
        return null;
    L8:
        Matrix r0 = new Matrix(r3.c);
        Rect r6 = r3.b;
        r0.preTranslate(r6.left, r6.top);
        return new d(r5, r0);
    }

    private final Bitmap createRotatedBitmap(Bitmap r9, int r10) {
        if (r9.getWidth() != 0) goto L5;
        return null;
    L5:
        if (r9.getHeight() == 0) goto L11;
        Matrix r6 = new Matrix();
        r6.postRotate(r10);
        return Bitmap.createBitmap(r9, 0, 0, r9.getWidth(), r9.getHeight(), r6, true);
    L11:
        return null;
    }

    private final Bitmap decodeOriginalBitmapWithEditPlan(OutputParam r13, List<? extends c> r14) {
        boolean r3 = true;
        Object r5 = null;
        if (r13 == null) goto L14;
        String r6 = r13.getSrcAlbumUri();
        if (r6 == null) goto L14;
        if (r6.length() <= 0) goto L9;
        boolean r7 = true;
    L10:
        if (r7 == true) goto L13;
        r6 = null;
    L13:
        if (r6 == null) goto L14;
    L80:
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L67
        Application r16 = AppHost.a.getApplication();     // Catch: Throwable -> L67
        Uri r4 = UriProtector.parse(r6);     // Catch: Throwable -> L67
        int r8 = readExifOrientation(r16, r4);     // Catch: Throwable -> L67
        InputStream r17 = openBitmapInputStream(r16, r4);     // Catch: Throwable -> L67
        if (r17 != null) goto L81;
        Bitmap r2 = null;
    L65:
        Object r18 = Result.constructor-impl(r2);     // Catch: Throwable -> L67
    L69:
        Throwable r19 = Result.exceptionOrNull-impl(r18);
        if (r19 == null) goto L73;
        FLogger.a.e(TAG, "[decodeOriginalBitmapWithEditPlan] fail:" + r19.getMessage());
    L73:
        if (Result.isFailure-impl(r18) == true) goto L77;
        r5 = r18;
    L77:
        return (Bitmap) r5;
    L81:
        BitmapRegionDecoder r9 = BitmapRegionDecoder.newInstance(r17, false);     // Catch: Throwable -> L59
        if (r9 != null) goto L78;
    L40:
        r2 = null;
    L54:
        CloseableKt.closeFinally(r17, null);     // Catch: Throwable -> L67
        goto L65
    L78:
        f r110 = buildOriginalBitmapEditPlan(r9.getWidth(), r9.getHeight(), r8, r14);     // Catch: Throwable -> L56
        if (r110 != null) goto L45;
    L43:
        r9.recycle();     // Catch: Throwable -> L59
        goto L40
    L45:
        long r10 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L56
        Bitmap r11 = r9.decodeRegion(r110.b, createOriginalBitmapDecodeOptions());     // Catch: Throwable -> L56
        if (r11 == null) goto L43;
        Bitmap r12 = rotateByExif(r11, r8);     // Catch: Throwable -> L56
        if (r12 == null) goto L52;
        r11 = r12;
    L52:
        long r20 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L56
        FLogger r21 = FLogger.a;     // Catch: Throwable -> L56
        r21.i(TAG, "[decodeOriginalBitmapWithEditPlan] decode cost: " + (r20 - r10));     // Catch: Throwable -> L56
        r2 = renderOriginalBitmapEditPlan(r11, r110);     // Catch: Throwable -> L56
        r21.i(TAG, "[decodeOriginalBitmapWithEditPlan] render cost:" + (SystemClock.elapsedRealtime() - r20) + ", rawRegion:" + r110.b + ", normalizedRegion:" + r110.a + ", final:" + r110.c + 'x' + r110.d + ", finalRotation:" + r110.e + ", cropOperationCount:" + r110.h + ", finalMarks:" + r110.g.size());     // Catch: Throwable -> L56
        r9.recycle();     // Catch: Throwable -> L59
        goto L54
    L56:
        th = move-exception;
        r9.recycle();     // Catch: Throwable -> L59
        throw th;     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        throw th;     // Catch: Throwable -> L61
    L61:
        th = move-exception;
        CloseableKt.closeFinally(r17, th);     // Catch: Throwable -> L67
        throw th;     // Catch: Throwable -> L67
    L67:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L69
    L9:
        r7 = false;
    L14:
        if (r13 == null) goto L25;
        String r112 = r13.getPath();
        if (r112 == null) goto L25;
        if (r112.length() <= 0) goto L20;
        boolean r22 = true;
    L21:
        if (r22 == true) goto L24;
        r112 = null;
    L24:
        r6 = r112;
    L26:
        if (r6 != null) goto L80;
        String r113 = getParamAlbumUrl();
        if (r113.length() > 0) goto L31;
        r3 = false;
    L31:
        if (r3 == false) goto L33;
        r6 = r113;
    L34:
        if (r6 != null) goto L80;
        return null;
    L33:
        r6 = null;
        goto L34
    L20:
        r22 = false;
    L25:
        r6 = null;
        goto L26
    }

    private final Bitmap decodeSampledBitmap(Context r5, Uri r6) {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L32
        BitmapFactory.Options r2 = new BitmapFactory.Options();     // Catch: Throwable -> L32
        r2.inJustDecodeBounds = true;     // Catch: Throwable -> L32
        InputStream r3 = openBitmapInputStream(r5, r6);     // Catch: Throwable -> L32
        if (r3 != null) goto L46;
    L13:
        int r4 = r2.outWidth;     // Catch: Throwable -> L32
        if (r4 <= 0) goto L31;
        int r7 = r2.outHeight;     // Catch: Throwable -> L32
        if (r7 <= 0) goto L31;
        r2.inSampleSize = calculatePreviewInSampleSize(r4, r7);     // Catch: Throwable -> L32
        r2.inJustDecodeBounds = false;     // Catch: Throwable -> L32
        InputStream r8 = openBitmapInputStream(r5, r6);     // Catch: Throwable -> L32
        if (r8 != null) goto L50;
        Bitmap r9 = null;
    L29:
        Object r10 = Result.constructor-impl(rotateByExif(r9, readExifOrientation(r5, r6)));     // Catch: Throwable -> L32
    L34:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L38;
        FLogger.a.e(TAG, "[decodeSampledBitmap] fail:" + r11.getMessage());
    L38:
        if (Result.isFailure-impl(r10) == true) goto L42;
        r0 = r10;
    L42:
        return (Bitmap) r0;
    L50:
        r9 = BitmapFactory.decodeStream(r8, null, r2);     // Catch: Throwable -> L23
        CloseableKt.closeFinally(r8, null);     // Catch: Throwable -> L32
        goto L29
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);     // Catch: Throwable -> L32
        throw th;     // Catch: Throwable -> L32
    L31:
        return null;
    L46:
        BitmapFactory.decodeStream(r3, null, r2);     // Catch: Throwable -> L8
        CloseableKt.closeFinally(r3, null);     // Catch: Throwable -> L32
        goto L13
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);     // Catch: Throwable -> L32
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L34
    }

    private final Object dismissBitmapSaveLoadingDialog(com.larus.common_ui.dialog.l0 r4, Continuation<? super Unit> r5) {
        Object r6 = BuildersKt.withContext(Dispatchers.getMain(), new C02412(r4, null), r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r6;
    L6:
        return Unit.INSTANCE;
    }

    private final Object getAiCreationMarkDownloadBitmap(OutputParam r4, Continuation<? super Bitmap> r5) {
        String r6 = getAiCreationMarkWatermarkUrl(r4);
        if (r6 != null) goto L6;
        return null;
    L6:
        return BuildersKt.withContext(Dispatchers.getIO(), new C02442(r6, null), r5);
    }

    private final int getDataSource(OutputParam r2, boolean r3) {
        if (r2 != null) goto L5;
        return 0;
    L5:
        if (r3 == false) goto L7;
        boolean r4 = isFromAlbumInMultiCapture(r2);
    L8:
        if (r4 == false) goto L11;
        return 1;
    L11:
        return 0;
    L7:
        r4 = isFromAlbum();
        goto L8
    }

    private final RectF intersectRectF(RectF r5, RectF r6) {
        float r0 = Math.max(r5.left, r6.left);
        float r1 = Math.max(r5.top, r6.top);
        float r2 = Math.min(r5.right, r6.right);
        float r7 = Math.min(r5.bottom, r6.bottom);
        if (r2 > r0) goto L5;
        return null;
    L5:
        if (r7 > r1) goto L8;
        return null;
    L8:
        return new RectF(r0, r1, r2, r7);
    }

    private static final Unit launchCapturePageForMultiCapture$lambda$32(CameraResultViewModel r1, ActivityResult r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        r1.processCaptureResult(r2);
        return Unit.INSTANCE;
    }

    private final void mergeEduExtraParam(JSONObject r5, Map<String, ? extends Object> r6) {
        Iterator<Map.Entry<String, ? extends Object>> r7 = r6.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L16;
        Map.Entry<String, ? extends Object> r0 = r7.next();
        String r1 = r0.getKey();
        Object r2 = r0.getValue();
        if (r5.has(r1) == true) goto L15;
        if (EDU_BASE_EXT_KEYS.contains(r1) == true) goto L15;
        if (r2 == null) goto L13;
        Object r3 = JSONObject.wrap(r2);
        if (r3 == null) goto L13;
    L14:
        r5.put(r1, r3);
    L13:
        r3 = JSONObject.NULL;
    L15:
        FLogger.a.w(TAG, "[mergeEduExtraParam] skip conflict key:" + r1);
        goto L4
    }

    private final void notifyPreviewThumbListStateChanged(OutputParam r9, String r10) {
        FLogger.a.i(TAG, "notifyPreviewThumbListStateChanged " + r10);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02501(this, r9, null), 3, null);
    }

    private final InputStream openBitmapInputStream(Context r3, Uri r4) {
        if (Intrinsics.areEqual(r4.getScheme(), "content") == true) goto L17;
        if (Intrinsics.areEqual(r4.getScheme(), ShareType.FILE) == true) goto L17;
        String r0 = r4.getPath();
        if (r0 != null) goto L10;
        r0 = r4.toString();
    L10:
        File r5 = new PolarisFileWrapper(r0);
        if (r5.exists() == true) goto L14;
        r5 = null;
    L14:
        if (r5 != null) goto L19;
        return null;
    L19:
        return new PolarisFileInputStreamWrapper(r5);
    L17:
        return ContentResolverWrapper.openInputStream(r3.getContentResolver(), r4);
    }

    private final void processInputContent(Pair<String, Integer> r4, OutputParam r5) {
        if (r4 == null) goto L7;
        FLogger.a.i(TAG, "[saveBitmapAndClosePage] put inputContent:" + r4);
        if (r5 == null) goto L8;
        r5.setInputContent(r4);
        return;
    L8:
        return;
    }

    private final int readExifOrientation(Context r6, Uri r7) {
        Object r1 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L23
        if (Intrinsics.areEqual(r7.getScheme(), "content") == false) goto L7;
    L10:
        InputStream r8 = ContentResolverWrapper.openInputStream(r6.getContentResolver(), r7);     // Catch: Throwable -> L23
        if (r8 != null) goto L34;
        Integer r9 = null;
    L21:
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L23
    L26:
        if (Result.isFailure-impl(r10) == true) goto L29;
        r1 = r10;
    L29:
        Integer r3 = (Integer) r1;
        if (r3 != null) goto L32;
        return 0;
    L32:
        return r3.intValue();
    L34:
        Integer r11 = Integer.valueOf(new ExifInterface(r8).getAttributeInt("Orientation", 0));     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r8, null);     // Catch: Throwable -> L23
        r9 = r11;
        goto L21
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L7:
        if (Intrinsics.areEqual(r7.getScheme(), ShareType.FILE) == true) goto L10;
        r9 = Integer.valueOf(new ExifInterface(r7.toString()).getAttributeInt("Orientation", 0));     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    }

    private final void recycleBitmapForSaveIfNeeded(Bitmap r1, Bitmap r2) {
        if (r2 == null) goto L8;
        if (r2 != r1) goto L5;
        return;
    L5:
        if (r2.isRecycled() == true) goto L10;
        r2.recycle();
        return;
    L10:
        return;
    }

    private final Bitmap renderOriginalBitmapEditPlan(Bitmap r8, f r9) {
        if (r9.c > 0) goto L5;
    L25:
        return null;
    L5:
        if (r9.d <= 0) goto L25;
        Matrix r0 = new Matrix(r9.f);
        Rect r2 = r9.a;
        r0.preTranslate(r2.left, r2.top);
        long r3 = SystemClock.elapsedRealtime();
        if (r0.isIdentity() == true) goto L10;
    L18:
        Bitmap r4 = Bitmap.createBitmap(r9.c, r9.d, Bitmap.Config.ARGB_8888);
        new Canvas(r4).drawBitmap(r8, r0, null);
        r8 = r4;
    L19:
        long r1 = SystemClock.elapsedRealtime();
        Bitmap r5 = applyMarkOperations(r8, r9.g);
        if (r5 == null) goto L23;
        r8 = r5;
    L23:
        FLogger.a.i(TAG, "[renderOriginalBitmapEditPlan] base cost:" + (r1 - r3) + ", mark cost:" + (SystemClock.elapsedRealtime() - r1) + ", finalMarks:" + r9.g.size());
        return r8;
    L10:
        if (r8.getWidth() != r9.c) goto L18;
        if (r8.getHeight() != r9.d) goto L18;
        if (r8.isMutable() == false) goto L18;
        if (r8.getConfig() != Bitmap.Config.ARGB_8888) goto L18;
        goto L18
    }

    private final Bitmap rotateByExif(Bitmap r3, int r4) {
        if (r4 != 3) goto L5;
        if (r3 != null) goto L18;
        return null;
    L18:
        return createRotatedBitmap(r3, 180);
    L5:
        if (r4 != 6) goto L7;
        if (r3 != null) goto L20;
        return null;
    L20:
        return createRotatedBitmap(r3, 90);
    L7:
        if (r4 != 8) goto L21;
        if (r3 != null) goto L19;
        return null;
    L19:
        return createRotatedBitmap(r3, 270);
    L21:
        return r3;
    }

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
    private final Object saveResultInMultiCaptureMode(OutputParam r14, Continuation<? super OutputParam> r15) {
        if ((r15 instanceof C02561) == false) goto L7;
        C02561 r1 = (C02561) r15;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r16 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        boolean r5 = false;
        if (r4 == 0) goto L20;
        if (r4 == 1) goto L19;
        if (r4 != 2) goto L18;
        Bitmap r17 = (Bitmap) r1.L$3;
        Bitmap r6 = (Bitmap) r1.L$2;
        OutputParam r7 = (OutputParam) r1.L$1;
        OutputParam r8 = (OutputParam) r1.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L15
    L45:
        final String r18 = (String) r16;     // Catch: Throwable -> L15
        FLogger.a.i(TAG, "[saveBitmapInMultiCaptureMode] path:" + r18);     // Catch: Throwable -> L15
        String r9 = "";
        if (com.larus.utils.o0.d(r18) == false) goto L77;
        ConcurrentHashMap<String, Bitmap> r0 = com.larus.camera.impl.utils.e0.a;     // Catch: Throwable -> L15
        com.larus.camera.impl.utils.e0.c(r18, r8.getPath());     // Catch: Throwable -> L15
        if (r8.getImageParam().isPhotoCropped() == false) goto L51;
    L54:
        boolean r10 = true;
    L55:
        Boolean r11 = Boxing.boxBoolean(r10);     // Catch: Throwable -> L15
        if (r18 != null) goto L58;
    L61:
        boolean r12 = true;
    L62:
        if (r12 == true) goto L103;
        if (r11 == null) goto L103;
        com.larus.camera.impl.utils.e0.c.put(r18, r11);     // Catch: Throwable -> L15
    L103:
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L75
        String r19 = r8.getPath();     // Catch: Throwable -> L75
        if (isFromAlbumInMultiCapture(r8) == false) goto L69;
        r19 = vqc.d.d(AppHost.a.getApplication(), Uri.parse(r8.getPath()));     // Catch: Throwable -> L75
    L69:
        ExifInterface r20 = new ExifInterface(r19);     // Catch: Throwable -> L75
        if (r18 != null) goto L72;
        String r21 = "";
    L73:
        com.larus.camera.impl.utils.y.a(r20, r21);     // Catch: Throwable -> L75
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L75
    L72:
        r21 = r18;
    L75:
        th = move-exception;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L15
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L15
        goto L77
    L58:
        if (r18.length() == 0) goto L61;
        r12 = false;
        goto L62
    L51:
        if (r8.getImageParam().isPhotoMarked() == true) goto L54;
        r10 = false;
    L77:
        ImageParam r23 = new ImageParam();     // Catch: Throwable -> L15
        r23.setWidth(r17.getWidth());     // Catch: Throwable -> L15
        r23.setHeight(r17.getHeight());     // Catch: Throwable -> L15
        if (r18 == null) goto L81;
        r9 = r18;
    L81:
        r23.setPath(r9);     // Catch: Throwable -> L15
        int r24 = com.larus.utils.l0.a;     // Catch: Throwable -> L15
        r23.setSize(((Number) com.larus.utils.l0.a(Boxing.boxLong(0), new y(r18))).longValue());     // Catch: Throwable -> L15
        r23.setRotation(r8.getImageParam().getRotation());     // Catch: Throwable -> L15
        EduIntentMode.a r110 = EduIntentMode.Companion;     // Catch: Throwable -> L15
        EduIntentMode r25 = EduIntentMode.COMMON;     // Catch: Throwable -> L15
        r110.getClass();     // Catch: Throwable -> L15
        r23.setDetectIntent(EduIntentMode.a.b(r25));     // Catch: Throwable -> L15
        r23.setPhotoMarked(r8.getImageParam().isPhotoMarked());     // Catch: Throwable -> L15
        r23.setPhotoCropped(r8.getImageParam().isPhotoCropped());     // Catch: Throwable -> L15
        r23.setAiCreation(r8.getImageParam().isAiCreation());     // Catch: Throwable -> L15
        r7.setImageParam(r23);     // Catch: Throwable -> L15
        recycleBitmapForSaveIfNeeded(r6, r17);
        OutputParam r26 = r7;
    L95:
        if (r26.getPath().length() <= 0) goto L97;
        r5 = true;
    L97:
        if (r5 == false) goto L99;
        qx8.a r111 = qx8.a.b;
        boolean r112 = isFromAlbum();
        gx8.b r113 = r111.a;
        CameraEvent r27 = CameraEvent.SAVE_LOCAL_RESULT;
        JSONObject r28 = new JSONObject();
        r28.put("is_success", "1");
        r28.put("from_album", r112 ? 1 : 0);
        Unit r114 = Unit.INSTANCE;
        r113.b(r27, r28);
    L99:
        FLogger.a.i(TAG, "[saveBitmapInMultiCaptureMode] output:" + r26);
        return r26;
    L15:
        th = move-exception;
        Bitmap r29 = r6;
        Bitmap r115 = r17;
        th = th;
    L85:
        recycleBitmapForSaveIfNeeded(r29, r115);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        Bitmap r116 = (Bitmap) r1.L$2;
        OutputParam r30 = (OutputParam) r1.L$1;
        OutputParam r31 = (OutputParam) r1.L$0;
        ResultKt.throwOnFailure(r16);
        r29 = r116;
        r14 = r31;
        r26 = r30;
    L39:
        r115 = (Bitmap) r16;
        if (r115 != null) goto L105;
        qx8.a r117 = qx8.a.b;
        nx8.m r118 = (nx8.m) this.eduImageAbility.getValue();
        if (r118 != null) goto L90;
    L92:
        boolean r119 = false;
    L93:
        r117.f(1002, "_currentBitmap obj is null", r119, isFromAlbum());
        Unit r120 = Unit.INSTANCE;
        goto L95
    L90:
        if (r118.d() != true) goto L92;
        r119 = true;
        goto L93
    L105:
        CoroutineDispatcher r121 = Dispatchers.getIO();     // Catch: Throwable -> L84
        CameraResultViewModel$saveResultInMultiCaptureMode$3$filePath$1 r122 = new CameraResultViewModel$saveResultInMultiCaptureMode$3$filePath$1(this, r115, null);     // Catch: Throwable -> L84
        r1.L$0 = r14;     // Catch: Throwable -> L84
        r1.L$1 = r26;     // Catch: Throwable -> L84
        r1.L$2 = r29;     // Catch: Throwable -> L84
        r1.L$3 = r115;     // Catch: Throwable -> L84
        r1.label = 2;     // Catch: Throwable -> L84
        Object r32 = BuildersKt.withContext(r121, r122, r1);     // Catch: Throwable -> L84
        if (r32 != r3) goto L44;
        return r3;
    L44:
        r6 = r29;
        r7 = r26;
        r8 = r14;
        r17 = r115;
        r16 = r32;
    L84:
        th = th;
        goto L85
    L20:
        ResultKt.throwOnFailure(r16);
        if (r14 != null) goto L23;
        return null;
    L23:
        OutputParam r123 = createGeneralParams(new OutputParam(), r14, true);
        if (r14.isVideo() == false) goto L35;
        t r33 = t.a;
        Bitmap r34 = t.c(r14);
        VideoParam r35 = new VideoParam();
        r35.setPath(r14.getPath());
        if (r34 == null) goto L28;
        int r36 = r34.getWidth();
    L29:
        r35.setWidth(r36);
        if (r34 == null) goto L32;
        int r124 = r34.getHeight();
    L33:
        r35.setHeight(r124);
        r123.setVideoParam(r35);
        return r123;
    L32:
        r124 = r14.getVideoParam().getHeight();
        goto L33
    L28:
        r36 = r14.getVideoParam().getWidth();
        goto L29
    L35:
        t r37 = t.a;
        r29 = t.c(r14);
        r1.L$0 = r14;
        r1.L$1 = r123;
        r1.L$2 = r29;
        r1.label = 1;
        Object r38 = getBitmapForSave(r14, r29, r1);
        if (r38 != r3) goto L38;
        return r3;
    L38:
        r26 = r123;
        r16 = r38;
    L7:
        r1 = new C02561(this, r15);
        goto L8
    }

    private final void scaleRect(RectF r2, float r3) {
        r2.left *= r3;
        r2.top *= r3;
        r2.right *= r3;
        r2.bottom *= r3;
    }

    private final Object showBitmapSaveLoadingDialog(com.larus.common_ui.dialog.l0 r4, Continuation<? super Unit> r5) {
        Object r6 = BuildersKt.withContext(Dispatchers.getMain(), new C02592(r4, null), r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r6;
    L6:
        return Unit.INSTANCE;
    }

    public final void addPreviewBitmap(OutputParam r2, Bitmap r3) {
        t r0 = t.a;
        t.a(r2, r3, "addPreviewBitmap");
    }

    public final Job detectPreviewImage(Bitmap r8, OutputParam r9) {
        Intrinsics.checkNotNullParameter(r8, "bitmap");
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r9, r8, null), 3, null);
    }

    public final void onComplete(final Pair<String, Integer> r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "from");
        FLogger r0 = FLogger.a;
        r0.i(TAG, "[onComplete] from:" + r6);
        if (resultSupportMark() == false) goto L10;
        if (shouldUseOriginalImageDeferredEdit$default(this, null, 1, null) == false) goto L10;
        if (((Boolean) this.enableUndo.getValue()).booleanValue() == false) goto L23;
        setImageHasBeenMarked(true);
    L23:
        if (completeWithMultiResult() == false) goto L25;
        saveMultipleResultAndCloseInternal(new w(this, r5));
        return;
    L25:
        saveSingleResultAndCloseInternal(new x(this, r5));
        return;
    L10:
        if (resultSupportMark() == false) goto L23;
        Function0<Bitmap> r7 = this.markedImageGetter;
        if (r7 == null) goto L23;
        Bitmap r8 = (Bitmap) r7.invoke();
        if (r8 == null) goto L23;
        this._currentBitmap.tryEmit(r8);
        if (((Boolean) this.enableUndo.getValue()).booleanValue() == false) goto L18;
        setImageHasBeenMarked(true);
    L18:
        t r2 = t.a;
        OutputParam r3 = t.j(this.currentDisplayOutputParam, r8);
        if (r3 == null) goto L21;
        changePreviewThumbListState(r3, "onComplete");
    L21:
        r0.i(TAG, "[onComplete] updateCurrentBitmap " + r8);
        goto L23
    }

    public final void reportClipItemsIfNeeded(EduResultMode r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "mode");
        int r0 = g.b[r9.ordinal()];
        if (r0 != 1) goto L5;
        r10 = 1;
    L8:
        IntIterator r11 = new IntRange(1, r10).iterator();
    L10:
        if (r11.hasNext() == false) goto L14;
        int r1 = r11.nextInt();
        if (this.reportedClipItems.add(TuplesKt.to(r9, Integer.valueOf(r1))) == false) goto L10;
        showCameraItemForEduMode$default(this, "modify_range", Integer.valueOf(r1), null, 4, null);
        goto L10
    L14:
        return;
    L5:
        if (r0 == 2) goto L8;
        r10 = 0;
        goto L8
    }

    public final void setResult(int r2, Intent r3) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        ability().setResult(r2, r3);
    }

    public final void updateCurrentBitmap(Bitmap r18, String r19) {
        Intrinsics.checkNotNullParameter(r18, "bitmap");
        Intrinsics.checkNotNullParameter(r19, "from");
        FLogger.a.i(TAG, "[updateCurrentBitmap] bitmap:" + r18 + ", from:" + r19);
        if (shouldUseUnifiedPreviewFramework$default(this, null, 1, null) == false) goto L8;
        t r4 = t.a;
        OutputParam r5 = t.j(this.currentDisplayOutputParam, r18);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02601(this, r18, null), 3, null);
        if (r5 == null) goto L12;
        changePreviewThumbListState(r5, r19);
        return;
    L12:
        return;
    L8:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass3(this, r18, null), 3, null);
        t r3 = t.a;
        OutputParam r1 = t.j(this.currentDisplayOutputParam, r18);
        if (r1 == null) goto L13;
        changePreviewThumbListState(r1, r19);
        return;
    }

    public static final /* synthetic */ Bitmap access$applyMarkedMaskIfNeeded(CameraResultViewModel r0, OutputParam r1, Bitmap r2) {
        return r0.applyMarkedMaskIfNeeded(r1, r2);
    }

    public static final /* synthetic */ Object access$awaitRawImageReady(CameraResultViewModel r0, long r1, Continuation r3) {
        return r0.awaitRawImageReady(r1, r3);
    }

    public static final /* synthetic */ Bitmap access$decodeOriginalBitmapWithEditPlan(CameraResultViewModel r0, OutputParam r1, List r2) {
        return r0.decodeOriginalBitmapWithEditPlan(r1, r2);
    }

    public static final /* synthetic */ Bitmap access$decodeSampledBitmap(CameraResultViewModel r0, Context r1, Uri r2) {
        return r0.decodeSampledBitmap(r1, r2);
    }

    public static final /* synthetic */ Object access$dismissBitmapSaveLoadingDialog(CameraResultViewModel r0, com.larus.common_ui.dialog.l0 r1, Continuation r2) {
        return r0.dismissBitmapSaveLoadingDialog(r1, r2);
    }

    public static final /* synthetic */ Object access$getAiCreationMarkDownloadBitmap(CameraResultViewModel r0, OutputParam r1, Continuation r2) {
        return r0.getAiCreationMarkDownloadBitmap(r1, r2);
    }

    public static final /* synthetic */ void access$recycleBitmapForSaveIfNeeded(CameraResultViewModel r0, Bitmap r1, Bitmap r2) {
        r0.recycleBitmapForSaveIfNeeded(r1, r2);
    }

    public static final /* synthetic */ Object access$saveResultInMultiCaptureMode(CameraResultViewModel r0, OutputParam r1, Continuation r2) {
        return r0.saveResultInMultiCaptureMode(r1, r2);
    }

    public static final /* synthetic */ Object access$showBitmapSaveLoadingDialog(CameraResultViewModel r0, com.larus.common_ui.dialog.l0 r1, Continuation r2) {
        return r0.showBitmapSaveLoadingDialog(r1, r2);
    }

    private final b buildCropTransform(int r9, int r10, ft8.a r11) {
        if (r9 <= 0) goto L47;
        if (r10 <= 0) goto L48;
        int r1 = r11.d;
        if (r1 <= 0) goto L49;
        int r2 = r11.e;
        if (r2 > 0) goto L10;
        return null;
    L10:
        if ((r11.c % 90) != 0) goto L51;
        float r3 = Math.min(r9 / r1, r10 / r2);
        RectF r4 = new RectF(r11.a);
        RectF r5 = new RectF(r11.b);
        scaleRect(r4, r3);
        scaleRect(r5, r3);
        int r6 = (Math.abs(r11.c) / 90) % 4;
        if (r6 != 0) goto L21;
        int r12 = RangesKt.coerceIn((int) Math.floor(r4.left - r5.left), 0, r9 - 1);
        int r7 = RangesKt.coerceIn((int) Math.floor(r4.top - r5.top), 0, r10 - 1);
        int r8 = RangesKt.coerceAtLeast((int) r4.width(), 1);
        int r13 = RangesKt.coerceAtLeast((int) r4.height(), 1);
        int r14 = RangesKt.coerceAtMost(r8 + r12, r9);
        int r15 = RangesKt.coerceAtMost(r13 + r7, r10);
        if (r14 <= r12) goto L20;
        if (r15 <= r7) goto L20;
        Matrix r0 = new Matrix();
        r0.postTranslate(-r12, -r7);
        return new b(r0, r14 - r12, r15 - r7);
    L20:
        return null;
    L21:
        int r16 = r6 % 2;
        if (r16 != 1) goto L24;
        float r17 = r4.height();
    L25:
        int r18 = RangesKt.coerceAtLeast((int) r17, 1);
        if (r16 != 1) goto L28;
        float r19 = r4.width();
    L29:
        RectF r20 = new RectF(0.0f, 0.0f, r18, RangesKt.coerceAtLeast((int) r19, 1));
        Matrix r21 = new Matrix();
        r21.postRotate(r11.c);
        r21.mapRect(r20);
        if (r6 == 1) goto L36;
        if (r6 == 2) goto L35;
        if (r6 == 3) goto L34;
        float r22 = r5.left;
        float r23 = r4.left;
    L37:
        float r24 = r22 - r23;
        if (r6 == 1) goto L44;
        if (r6 == 2) goto L43;
        if (r6 == 3) goto L42;
        float r25 = r5.top;
        float r110 = r4.top;
    L45:
        float r26 = r25 - r110;
        Matrix r111 = new Matrix();
        r111.postTranslate(r24, r26);
        r111.postRotate(r11.c);
        r111.postTranslate(-r20.left, -r20.top);
        return new b(r111, RangesKt.coerceAtLeast((int) r20.width(), 1), RangesKt.coerceAtLeast((int) r20.height(), 1));
    L42:
        r25 = r4.right;
        r110 = r5.right;
        goto L45
    L43:
        r25 = r4.bottom;
        r110 = r5.bottom;
        goto L45
    L44:
        r25 = r5.left;
        r110 = r4.left;
        goto L45
    L34:
        r22 = r5.top;
        r23 = r4.top;
        goto L37
    L35:
        r22 = r4.right;
        r23 = r5.right;
        goto L37
    L36:
        r22 = r4.bottom;
        r23 = r5.bottom;
        goto L37
    L28:
        r19 = r4.height();
        goto L29
    L24:
        r17 = r4.width();
        goto L25
    L51:
        return null;
    L49:
        return null;
    L48:
        return null;
    L47:
        return null;
    }

    private final Rect createBitmapSourceBounds(RectF r7, int r8, int r9) {
        if (r8 <= 0) goto L12;
        if (r9 <= 0) goto L12;
        int r1 = RangesKt.coerceIn((int) Math.floor(r7.left), 0, r8 - 1);
        int r2 = RangesKt.coerceIn((int) Math.floor(r7.top), 0, r9 - 1);
        int r10 = RangesKt.coerceIn((int) Math.ceil(r7.right), r1 + 1, r8);
        int r11 = RangesKt.coerceIn((int) Math.ceil(r7.bottom), r2 + 1, r9);
        if (r10 <= r1) goto L12;
        if (r11 <= r2) goto L12;
        return new Rect(r1, r2, r10, r11);
    L12:
        return null;
    }

    private final Rect createClippedRegion(Rect r5, int r6, int r7) {
        int r0 = RangesKt.coerceIn(r5.left, 0, r6 - 1);
        int r1 = RangesKt.coerceIn(r5.top, 0, r7 - 1);
        int r8 = RangesKt.coerceIn(r5.right, r0 + 1, r6);
        int r9 = RangesKt.coerceIn(r5.bottom, r1 + 1, r7);
        if (r8 <= r0) goto L8;
        if (r9 > r1) goto L7;
        return null;
    L7:
        return new Rect(r0, r1, r8, r9);
    L8:
        return null;
    }

    private final OutputParam createGeneralParams(OutputParam r3, OutputParam r4, boolean r5) {
        r3.setFromScene(getCameraData().getScene());
        r3.setLeavingMode(getCameraData().getCaptureMode());
        r3.setDataSource(getDataSource(r4, r5));
        r3.getExt().put("camera_data_source", String.valueOf(r3.getDataSource()));
        if (r4 == null) goto L7;
        HashMap<String, String> r6 = r4.getExt();
        if (r6 == null) goto L7;
        r3.getExt().putAll(r6);
    L7:
        InputParam r7 = getInputParam();
        boolean r0 = false;
        if (r7 == null) goto L10;
        boolean r8 = r7.getShouldNotify();
    L11:
        r3.setShouldNotify(r8);
        if (r4 == null) goto L15;
        OutputParam.ResultType r9 = r4.getResultType();
        if (r9 == null) goto L15;
    L16:
        r3.setResultType(r9);
        if (r4 == null) goto L19;
        boolean r10 = r4.isFromAlbum();
    L20:
        r3.setFromAlbum(r10);
        if (r4 == null) goto L23;
        String r11 = r4.getSrcAlbumUri();
    L24:
        r3.setSrcAlbumUri(r11);
        if (r4 == null) goto L27;
        r0 = r4.isOriginalImageChecked();
    L27:
        r3.setOriginalImageChecked(r0);
        return r3;
    L23:
        r11 = null;
        goto L24
    L19:
        r10 = false;
    L15:
        r9 = OutputParam.ResultType.PHOTO;
        goto L16
    L10:
        r8 = false;
        goto L11
    }

    private final e createMarkTransformState(c.b r5, int r6, int r7) {
        Bitmap r8 = r5.a;
        if (r8.isRecycled() == false) goto L5;
    L19:
        return null;
    L5:
        if (r8.getWidth() <= 0) goto L19;
        if (r8.getHeight() <= 0) goto L19;
        Rect r0 = getMaskContentBounds(r8);
        if (r0 != null) goto L12;
        return null;
    L12:
        Matrix r2 = new Matrix();
        r2.postScale(r6 / r8.getWidth(), r7 / r8.getHeight());
        RectF r9 = new RectF(r0);
        r2.mapRect(r9);
        if (r9.width() <= 0.0f) goto L19;
        if (r9.height() <= 0.0f) goto L19;
        return new e(r8, r0, r2, r9);
    }

    private final Object getBitmapForSave(OutputParam r9, Bitmap r10, Continuation<? super Bitmap> r11) {
        if ((r11 instanceof C02451) == false) goto L7;
        C02451 r0 = (C02451) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        long r13 = r0.J$0;
        Bitmap r4 = (Bitmap) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L24:
        Bitmap r14 = (Bitmap) r12;
        if (r14 != null) goto L27;
        return r4;
    L27:
        FLogger.a.i(TAG, "[getBitmapForSave] decodeOriginalBitmapWithEditPlan cost " + (SystemClock.elapsedRealtime() - r13));
        return r14;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        if (shouldUseOriginalImageDeferredEdit(r9) == false) goto L17;
        List<c> r15 = getDeferredEditOperations(r9);
        long r5 = SystemClock.elapsedRealtime();
        CoroutineDispatcher r6 = Dispatchers.getIO();
        CameraResultViewModel$getBitmapForSave$result$1 r7 = new CameraResultViewModel$getBitmapForSave$result$1(this, r9, r15, null);
        r0.L$0 = r10;
        r0.J$0 = r5;
        r0.label = 1;
        r12 = BuildersKt.withContext(r6, r7, r0);
        if (r12 != r2) goto L23;
        return r2;
    L23:
        r4 = r10;
        r13 = r5;
        goto L24
    L17:
        if (shouldUseMarkSelectMode() == true) goto L19;
        return r10;
    L19:
        return applyMarkedMaskIfNeeded(r9, r10);
    L7:
        r0 = new C02451(this, r11);
        goto L8
    }

    private final Pair<Integer, Integer> getNormalizedBitmapSize(int r1, int r2, int r3) {
        if (r1 <= 0) goto L10;
        if (r2 > 0) goto L6;
        return null;
    L6:
        if (isExifRightAngleRotated(r3) == false) goto L9;
        return new Pair(Integer.valueOf(r2), Integer.valueOf(r1));
    L9:
        return new Pair(Integer.valueOf(r1), Integer.valueOf(r2));
    L10:
        return null;
    }

    private static final Bitmap getPreviewBitmapByPath$lambda$39(CameraResultViewModel r0, Context r1, Uri r2) {
        return r0.ability().S(r1, r2);
    }

    private static final Unit onComplete$lambda$23(CameraResultViewModel r2, Pair r3, List r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        Iterator r0 = r4.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r2.processInputContent(r3, (OutputParam) r0.next());
        goto L4
    L6:
        CameraOutputContext r5 = new CameraOutputContext();
        r5.setOutputParamList(r4);
        r5.setResultRoute(r2.getCameraData().getResultRoute());
        if (r2.completeDirectCameraFlow(r5) == false) goto L10;
        r2.ability().closePage();
        return Unit.INSTANCE;
    L10:
        q0 r6 = r2.ability();
        Intent r1 = new Intent();
        r1.putExtra("CAMERA_OUTPUT_CONTEXT", r5);
        Unit r7 = Unit.INSTANCE;
        r6.setResult(200000, r1);
        r2.ability().closePage();
        return Unit.INSTANCE;
    }

    private static final Unit onComplete$lambda$27(CameraResultViewModel r2, Pair r3, OutputParam r4) {
        Intrinsics.checkNotNullParameter(r4, "outputParam");
        r2.processInputContent(r3, r4);
        if (Intrinsics.areEqual(r4.getFromScene(), "attach_photo_edit") == false) goto L5;
        q0 r5 = r2.ability();
        Intent r0 = new Intent();
        r0.putExtra("KEY_EDIT_RESULT", r4);
        Unit r6 = Unit.INSTANCE;
        r5.setResult(300000, r0);
    L10:
        r2.ability().closePage();
        return Unit.INSTANCE;
    L5:
        CameraOutputContext r7 = new CameraOutputContext();
        r7.setOutputParamList(CollectionsKt.mutableListOf(new OutputParam[]{r4}));
        r7.setResultRoute(r2.getCameraData().getResultRoute());
        if (r2.completeDirectCameraFlow(r7) == false) goto L9;
        r2.ability().closePage();
        return Unit.INSTANCE;
    L9:
        q0 r8 = r2.ability();
        Intent r1 = new Intent();
        r1.putExtra("CAMERA_OUTPUT_CONTEXT", r7);
        Unit r9 = Unit.INSTANCE;
        r8.setResult(200000, r1);
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T> Object withBitmapSaveLoadingIfNeeded(boolean r11, Function1<? super Continuation<? super T>, ? extends Object> r12, Continuation<? super T> r13) {
        if ((r13 instanceof C02641) == false) goto L7;
        C02641 r0 = (C02641) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L28;
        if (r3 == 1) goto L27;
        if (r3 == 2) goto L22;
        if (r3 == 3) goto L19;
        if (r3 == 4) goto L18;
        if (r3 != 5) goto L16;
        Throwable r15 = (Throwable) r0.L$0;
        ResultKt.throwOnFailure(r14);
        throw r15;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        Object r16 = r0.L$0;
        ResultKt.throwOnFailure(r14);
        return r16;
    L19:
        com.larus.common_ui.dialog.l0 r17 = (com.larus.common_ui.dialog.l0) r0.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L25
    L41:
        r0.L$0 = r14;
        r0.label = 4;
        if (dismissBitmapSaveLoadingDialog(r17, r0) != r2) goto L45;
        return r2;
    L45:
        return r14;
    L22:
        r17 = (com.larus.common_ui.dialog.l0) r0.L$1;
        r12 = (Function1) r0.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L25
    L38:
        r0.L$0 = r17;     // Catch: Throwable -> L25
        r0.L$1 = null;     // Catch: Throwable -> L25
        r0.label = 3;     // Catch: Throwable -> L25
        r14 = r12.invoke(r0);     // Catch: Throwable -> L25
        if (r14 != r2) goto L41;
        return r2;
    L27:
        ResultKt.throwOnFailure(r14);
    L33:
        return r14;
    L28:
        ResultKt.throwOnFailure(r14);
        if (r11 != 0) goto L34;
        r0.label = 1;
        r14 = r12.invoke(r0);
        if (r14 != r2) goto L33;
        return r2;
    L34:
        r17 = createBitmapSaveLoadingDialog();
        r0.L$0 = r12;     // Catch: Throwable -> L25
        r0.L$1 = r17;     // Catch: Throwable -> L25
        r0.label = 2;     // Catch: Throwable -> L25
        if (showBitmapSaveLoadingDialog(r17, r0) != r2) goto L38;
        return r2;
    L25:
        th = move-exception;
        r0.L$0 = th;
        r0.L$1 = null;
        r0.label = 5;
        if (dismissBitmapSaveLoadingDialog(r11, r0) != r2) goto L52;
        return r2;
    L52:
        throw th;
    L7:
        r0 = new C02641(this, r13);
        goto L8
    }

    private final <T> Object withOriginalImageDeferredEditLoading(OutputParam r1, Function1<? super Continuation<? super T>, ? extends Object> r2, Continuation<? super T> r3) {
        return withBitmapSaveLoadingIfNeeded(shouldUseOriginalImageDeferredEdit(r1), r2, r3);
    }

    public final void changeCurrentBitmap(OutputParam r5, Bitmap r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "bitmap");
        Intrinsics.checkNotNullParameter(r7, "from");
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("[changeCurrentBitmap] path:");
        Long r2 = null;
        if (r5 == null) goto L5;
        String r3 = r5.getPath();
    L6:
        r1.append(r3);
        r1.append(", createdTime=");
        if (r5 == null) goto L11;
        ImageParam r4 = r5.getImageParam();
        if (r4 == null) goto L11;
        r2 = Long.valueOf(r4.getCreatedTime());
    L11:
        r1.append(r2);
        r1.append(", bitmap:");
        r1.append(r6);
        r1.append(", from:");
        r1.append(r7);
        r0.i(TAG, r1.toString());
        this.currentDisplayOutputParam = r5;
        if (r5 == null) goto L15;
        ability().k0(r5.getResultType(), r5.isFromAlbum());
    L15:
        if (((Boolean) this.isInMarkSelectMode.getValue()).booleanValue() == false) goto L17;
        recordMarkSelectSessionSnapshot(r5);
    L17:
        updateCurrentBitmap(r6, r7);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void clickButton(String r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r8, "buttonName");
        Intrinsics.checkNotNullParameter(r9, "currentPage");
        q0 r1 = ability();
        InputParam r0 = getInputParam();
        if (r0 == null) goto L5;
        String r4 = r0.getBotId();
    L6:
        InputParam r2 = getInputParam();
        if (r2 == null) goto L9;
        String r5 = r2.getEnterMethod();
    L10:
        r1.n(r8, r9, r4, r5, r10);
        return;
    L9:
        r5 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public final void clickCameraButtonForEduMode(String r8, Integer r9, Boolean r10) {
        Intrinsics.checkNotNullParameter(r8, "itemType");
        ability().Z(getCameraData().getCaptureMode(), r8, this.isEduMultiQuestionModel, r9, r10);
    }

    /* JADX WARN: Type inference failed for: r12v1, types: [com.larus.camera.impl.ui.viewmodel.z] */
    public final Object getPreviewBitmapByPath(final Context r11, OutputParam r12, Continuation<? super Bitmap> r13) {
        if (r12 == null) goto L5;
        String r0 = r12.getPath();
        if (r0 == null) goto L5;
    L6:
        String r1 = r0;
        FLogger r2 = FLogger.a;
        r2.i(TAG, "getPreviewBitmapByPath path:".concat(r1));
        final Uri r8 = UriProtector.parse(r1);
        String r3 = r8.getScheme();
        String r4 = null;
        if (r3 == null) goto L9;
        String r5 = r3.toLowerCase(Locale.getDefault());
    L10:
        boolean r6 = false;
        if (r12 != null) goto L13;
    L15:
        boolean r7 = false;
    L16:
        if (r7 == true) goto L20;
        Bitmap r9 = ability().p0(r1);
        if (r9 == null) goto L20;
        return r9;
    L20:
        if (r12 != null) goto L22;
    L24:
        boolean r10 = false;
    L25:
        if (r10 == false) goto L37;
        String r14 = r12.getVideoParam().getUri();
        if (r14 != null) goto L29;
        r14 = r1;
    L29:
        Bitmap r15 = ability().p0(r14);
        if (r15 != null) goto L85;
        r2.i(TAG, "getPreviewBitmapByPath get video");
        Object r16 = BuildersKt.withContext(Dispatchers.getIO(), new CameraResultViewModel$getPreviewBitmapByPath$5$1(this, r1, null), r13);
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L35;
        return r16;
    L35:
        return (Bitmap) r16;
    L85:
        return r15;
    L37:
        if (Intrinsics.areEqual(r5, "content") == false) goto L39;
    L60:
        CameraResultFirstFlow r17 = CameraResultFirstFlow.a;
        Fragment r18 = ability().getCurrentFragment();
        if (r18 == null) goto L63;
        FragmentActivity r19 = r18.getActivity();
    L64:
        Intrinsics.checkNotNull(r8);
        r17.getClass();
        Intrinsics.checkNotNullParameter(r8, "uri");
        String r20 = r8.getScheme();
        if (r20 == null) goto L68;
        r4 = r20.toLowerCase(Locale.getDefault());
    L68:
        if ((r19 instanceof CameraResultFirstActivity) == false) goto L80;
        if (r12 != null) goto L71;
    L73:
        boolean r21 = false;
    L74:
        if (r21 == true) goto L80;
        if (Intrinsics.areEqual(r4, "content") == false) goto L78;
    L79:
        r6 = true;
        goto L80
    L78:
        if (Intrinsics.areEqual(r4, ShareType.FILE) == false) goto L80;
    L71:
        if (r12.isFromAlbum() != true) goto L73;
        r21 = true;
    L80:
        if (r6 == false) goto L84;
        return CameraResultFirstFlow.f(r11, r8, new z(this, r11, r8), r13);
    L84:
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass7(this, r12, r11, r8, null), r13);
    L63:
        r19 = null;
        goto L64
    L39:
        if (Intrinsics.areEqual(r5, ShareType.FILE) == true) goto L60;
        if (r12 != null) goto L42;
    L44:
        boolean r22 = false;
    L45:
        if (r22 == true) goto L60;
        if (Intrinsics.areEqual(r5, "http") == true) goto L59;
        if (Intrinsics.areEqual(r5, "https") == true) goto L59;
        if (shouldUseOriginalImageDeferredEdit(r12) == false) goto L57;
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass8(this, r11, r8, null), r13);
    L57:
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass9(r1, null), r13);
    L59:
        return ImageLoaderKt.n(r1, "camera_result", null, null, r13, 124);
    L42:
        if (r12.isFromAlbum() != true) goto L44;
        r22 = true;
        goto L45
    L22:
        if (r12.isVideo() != true) goto L24;
        r10 = true;
        goto L25
    L13:
        if (r12.isVideo() != true) goto L15;
        r7 = true;
        goto L16
    L9:
        r5 = null;
    L5:
        r0 = "";
        goto L6
    }

    public final Object getPreviewOutputParam(String r6, OutputParam r7, Continuation<? super OutputParam> r8) {
        if ((r8 instanceof C02481) == false) goto L7;
        C02481 r0 = (C02481) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        OutputParam r10 = (OutputParam) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L39:
        return r10;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        if (r7 != null) goto L19;
        r7 = getCurrentDisplayOutputParam();
        if (r7 != null) goto L19;
        r7 = new OutputParam();
    L19:
        FLogger.a.i(TAG, "[getPreviewOutputParam] previewParam:" + r7);
        boolean r4 = false;
        if (r6.length() <= 0) goto L22;
        boolean r11 = true;
    L23:
        if (r11 == false) goto L37;
        r7.setFromAlbum(true);
        if (r7.isVideo() == true) goto L27;
        r7.getImageParam().setPath(r6);
        return r7;
    L27:
        if (r7.getPath().length() != 0) goto L29;
        r4 = true;
    L29:
        if (r4 == false) goto L38;
        CoroutineDispatcher r12 = Dispatchers.getIO();
        C02492 r5 = new C02492(r6, r7, null);
        r0.L$0 = r7;
        r0.label = 1;
        if (BuildersKt.withContext(r12, r5, r0) != r2) goto L33;
        return r2;
    L33:
        r10 = r7;
        goto L39
    L38:
        return r7;
    L37:
        return r7;
    L22:
        r11 = false;
    L7:
        r0 = new C02481(this, r8);
        goto L8
    }

    public final void onEditEntranceEditButtonClick(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "buttonName");
        Intrinsics.checkNotNullParameter(r11, "currentPage");
        Intrinsics.checkNotNullParameter(r12, "previousPage");
        Bundle r0 = ability().B();
        String r1 = null;
        if (r0 == null) goto L5;
        Serializable r2 = r0.getSerializable("CAMERA_INPUT_PARAM");
    L7:
        if ((r2 instanceof InputParam) == false) goto L9;
        InputParam r3 = (InputParam) r2;
    L10:
        q0 r4 = ability();
        if (r3 == null) goto L13;
        r1 = r3.getBotId();
    L13:
        r4.U(r10, r1, r11, r12, new JSONObject(), null);
        return;
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L7
    }

    public final void onEditEntranceEditButtonShow(String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, "buttonName");
        Intrinsics.checkNotNullParameter(r12, "currentPage");
        Intrinsics.checkNotNullParameter(r13, "previousPage");
        Bundle r0 = ability().B();
        String r1 = null;
        if (r0 == null) goto L5;
        Serializable r2 = r0.getSerializable("CAMERA_INPUT_PARAM");
    L7:
        if ((r2 instanceof InputParam) == false) goto L9;
        InputParam r3 = (InputParam) r2;
    L10:
        q0 r4 = ability();
        if (r3 == null) goto L13;
        r1 = r3.getBotId();
    L13:
        com.larus.camera.impl.utils.j0.a.a(r4, "edit_entrance", r11, "camera_confirm", r1, "click_camera_confirm_image_edit_button", r12, r13);
        return;
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L7
    }

    public final void openPage(Intent r2, boolean r3, Function1<? super ActivityResult, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "intent");
        Intrinsics.checkNotNullParameter(r4, "resultCallback");
        ability().X(r2, r3, r4);
    }

    public final void showCameraItemForEduMode(String r3, Integer r4, Boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "itemType");
        ability().c0(r3, getCameraData().getCaptureMode(), r4, r5);
    }

    public static final /* synthetic */ OutputParam access$createGeneralParams(CameraResultViewModel r0, OutputParam r1, OutputParam r2, boolean r3) {
        return r0.createGeneralParams(r1, r2, r3);
    }

    public static final /* synthetic */ Object access$getBitmapForSave(CameraResultViewModel r0, OutputParam r1, Bitmap r2, Continuation r3) {
        return r0.getBitmapForSave(r1, r2, r3);
    }

    public static final /* synthetic */ Object access$withBitmapSaveLoadingIfNeeded(CameraResultViewModel r0, boolean r1, Function1 r2, Continuation r3) {
        return r0.withBitmapSaveLoadingIfNeeded(r1, r2, r3);
    }

    public static final /* synthetic */ Object access$withOriginalImageDeferredEditLoading(CameraResultViewModel r0, OutputParam r1, Function1 r2, Continuation r3) {
        return r0.withOriginalImageDeferredEditLoading(r1, r2, r3);
    }

    private final f buildOriginalBitmapEditPlan(int r18, int r19, int r20, List<? extends c> r21) {
        Pair<Integer, Integer> r0 = getNormalizedBitmapSize(r18, r19, r20);
        if (r0 != null) goto L5;
        return null;
    L5:
        int r4 = ((Number) r0.getFirst()).intValue();
        int r5 = ((Number) r0.getSecond()).intValue();
        Matrix r14 = new Matrix();
        ArrayList r8 = new ArrayList();
        Iterator<? extends c> r1 = r21.iterator();
        int r11 = r4;
        int r12 = r5;
        int r13 = 0;
        int r16 = 0;
    L7:
        if (r1.hasNext() == false) goto L25;
        c r2 = r1.next();
        if ((r2 instanceof c.b) == true) goto L10;
        if ((r2 instanceof c.a) == false) goto L24;
        c.a r3 = (c.a) r2;
        b r6 = buildCropTransform(r11, r12, r3.a);
        if (r6 == null) goto L17;
        Iterator r7 = r8.iterator();
    L20:
        if (r7.hasNext() == false) goto L22;
        e r9 = (e) r7.next();
        r9.c.postConcat(r6.a);
        r6.a.mapRect(r9.d);
        goto L20
    L22:
        r14.postConcat(r6.a);
        r11 = r6.b;
        r12 = r6.c;
        r13 = normalizeRightAngleRotation(r13 + r3.a.c);
        r16 = r16 + 1;
        goto L7
    L17:
        return null;
    L24:
        throw new NoWhenBranchMatchedException();
    L10:
        e r10 = createMarkTransformState((c.b) r2, r11, r12);
        if (r10 == null) goto L7;
        r8.add(r10);
        goto L7
    L25:
        if (r11 <= 0) goto L42;
        if (r12 <= 0) goto L42;
        Rect r15 = buildFinalSourceRegion(r14, r11, r12, r4, r5);
        if (r15 != null) goto L31;
        return null;
    L31:
        Rect r17 = mapNormalizedRegionToRawRegion(r15, r18, r19, r20);
        if (r17 != null) goto L34;
        return null;
    L34:
        RectF r22 = new RectF(0.0f, 0.0f, r11, r12);
        ArrayList r110 = new ArrayList();
        Iterator r23 = r8.iterator();
    L36:
        if (r23.hasNext() == false) goto L41;
        d r24 = createFinalMarkOperation((e) r23.next(), r22);
        if (r24 == null) goto L36;
        r110.add(r24);
        goto L36
    L41:
        return new f(r15, r17, r11, r12, r13, r14, r110, r16);
    L42:
        return null;
    }

    public static /* synthetic */ String currentOutputKey$default(CameraResultViewModel r0, OutputParam r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.currentDisplayOutputParam;
    L6:
        return r0.currentOutputKey(r1);
    }

    private final Map<String, String> getEduMessageExt(String r4, String r5, String r6, nx8.i r7) {
        LinkedHashMap r0 = new LinkedHashMap();
        nx8.m r1 = (nx8.m) this.eduImageAbility.getValue();
        if (r1 == null) goto L5;
        nx8.g r8 = r1.j(r7);
    L6:
        if (r8 == null) goto L15;
        JSONObject r2 = new JSONObject(GsonProtectorUtils.toJson(new Gson(), r8));
        r2.put("origin_path", r4);
        r2.put("is_perspective_corrected", r6);
        Iterator r9 = CollectionsKt.listOf(new String[]{r5, r8.a}).iterator();
    L9:
        if (r9.hasNext() == false) goto L13;
        Map<String, Object> r10 = parseEduExtraParam((String) r9.next());
        if (r10 == null) goto L9;
        mergeEduExtraParam(r2, r10);
        goto L9
    L13:
        r0.put(EDU_MESSAGE_EXT_KEY, GsonProtectorUtils.toJson(new Gson(), new px8.a(r2.toString(), CollectionsKt.arrayListOf(new px8.c[]{new px8.c(4)}))));
        return r0;
    L15:
        return null;
    L5:
        r8 = null;
        goto L6
    }

    private final boolean hasSameAspectRatio(int r2, int r3, int r4, int r5) {
        if (r2 <= 0) goto L12;
        if (r3 <= 0) goto L13;
        if (r4 <= 0) goto L14;
        if (r5 > 0) goto L9;
        return false;
    L9:
        if (Math.abs((r2 / r3) - (r4 / r5)) > 0.01f) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    L13:
        return false;
    L12:
        return false;
    }

    private final Rect mapNormalizedRegionToRawRegion(Rect r4, int r5, int r6, int r7) {
        if (r7 != 3) goto L5;
        Rect r8 = new Rect(r5 - r4.right, r6 - r4.bottom, r5 - r4.left, r6 - r4.top);
    L13:
        return createClippedRegion(r8, r5, r6);
    L5:
        if (r7 != 6) goto L7;
        r8 = new Rect(r4.top, r6 - r4.right, r4.bottom, r6 - r4.left);
        goto L13
    L7:
        if (r7 == 8) goto L9;
        r8 = new Rect(r4);
        goto L13
    L9:
        r8 = new Rect(r5 - r4.bottom, r4.left, r5 - r4.top, r4.right);
        goto L13
    }

    public static /* synthetic */ boolean shouldUseOriginalImageDeferredEdit$default(CameraResultViewModel r0, OutputParam r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.currentDisplayOutputParam;
    L6:
        return r0.shouldUseOriginalImageDeferredEdit(r1);
    }

    public static /* synthetic */ boolean shouldUseUnifiedPreviewFramework$default(CameraResultViewModel r0, com.larus.camera.impl.ui.component.result.general.n r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = (com.larus.camera.impl.ui.component.result.general.n) r0.resultDetectionStatus.getValue();
    L6:
        return r0.shouldUseUnifiedPreviewFramework(r1);
    }

    public final void onSingleFunctionEditButtonShow(String r11, String r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r11, "buttonName");
        Intrinsics.checkNotNullParameter(r12, "currentPage");
        Intrinsics.checkNotNullParameter(r13, "previousPage");
        Bundle r0 = ability().B();
        String r1 = null;
        if (r0 == null) goto L5;
        Serializable r2 = r0.getSerializable("CAMERA_INPUT_PARAM");
    L7:
        if ((r2 instanceof InputParam) == false) goto L9;
        InputParam r3 = (InputParam) r2;
    L10:
        q0 r4 = ability();
        if (r14 != null) goto L13;
        r14 = "single_function";
    L13:
        String r5 = r14;
        if (r3 == null) goto L16;
        String r6 = r3.getShowFrom();
    L17:
        if (r3 == null) goto L19;
        String r7 = r3.getBotId();
    L20:
        if (r3 == null) goto L22;
        r1 = r3.getEnterMethod();
    L22:
        com.larus.camera.impl.utils.j0.a.a(r4, r5, r11, r6, r7, r1, r12, r13);
        return;
    L19:
        r7 = null;
        goto L20
    L16:
        r6 = null;
        goto L17
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L7
    }

    public static final /* synthetic */ Map access$getEduMessageExt(CameraResultViewModel r0, String r1, String r2, String r3, nx8.i r4) {
        return r0.getEduMessageExt(r1, r2, r3, r4);
    }

    public static /* synthetic */ Object awaitRawImageReady$default(CameraResultViewModel r0, long r1, Continuation r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 5000;
    L6:
        return r0.awaitRawImageReady(r1, r3);
    }

    private final Rect buildFinalSourceRegion(Matrix r3, int r4, int r5, int r6, int r7) {
        RectF r0 = new RectF(0.0f, 0.0f, r4, r5);
        Matrix r8 = new Matrix();
        if (r3.invert(r8) == true) goto L6;
        return null;
    L6:
        r8.mapRect(r0);
        return createBitmapSourceBounds(r0, r6, r7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void onComplete$default(CameraResultViewModel r0, Pair r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.onComplete(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void processInputContent$default(CameraResultViewModel r0, Pair r1, OutputParam r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.processInputContent(r1, r2);
    }

    public final Object getPreviewBitmap(Context r7, String r8, int r9, OutputParam r10, Continuation<? super o0> r11) {
        if ((r11 instanceof C02471) == false) goto L7;
        C02471 r0 = (C02471) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        int r13 = r0.I$0;
        OutputParam r14 = (OutputParam) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L25:
        Bitmap r15 = (Bitmap) r12;
        r9 = r13;
    L26:
        FLogger.a.i(TAG, "[getPreviewBitmap] end");
        if (r9 == 0) goto L34;
        if (r15 == null) goto L31;
        Bitmap r16 = createRotatedBitmap(r15, invertDegree(r9));
    L33:
        return new o0(r16, r14);
    L31:
        r16 = null;
        goto L33
    L34:
        return new o0(r15, r14);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r9 = r0.I$0;
        r7 = (Context) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L19:
        r14 = (OutputParam) r12;
        t r17 = t.a;
        r15 = t.c(r14);
        if (r15 != null) goto L26;
        r0.L$0 = r14;
        r0.I$0 = r9;
        r0.label = 2;
        r12 = getPreviewBitmapByPath(r7, r14, r0);
        if (r12 != r2) goto L24;
        return r2;
    L24:
        r13 = r9;
        goto L25
    L16:
        ResultKt.throwOnFailure(r12);
        FLogger.a.i(TAG, "[getPreviewBitmap] begin");
        r0.L$0 = r7;
        r0.I$0 = r9;
        r0.label = 1;
        r12 = getPreviewOutputParam(r8, r10, r0);
        if (r12 != r2) goto L19;
        return r2;
    L7:
        r0 = new C02471(this, r11);
        goto L8
    }

    public final float rotation2Scale(float r6, float r7, float r8, float r9, int r10) {
        boolean r0 = true;
        if (r6 != 0.0f) goto L5;
        boolean r3 = true;
    L7:
        if (r3 == false) goto L9;
    L48:
        return 1.0f;
    L9:
        if (r7 != 0.0f) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == true) goto L48;
        if (r8 != 0.0f) goto L16;
        boolean r5 = true;
    L17:
        if (r5 == true) goto L48;
        if (r9 != 0.0f) goto L21;
        boolean r2 = true;
    L22:
        if (r2 == true) goto L48;
        if (r6 != r7) goto L27;
        boolean r11 = true;
    L28:
        if (r11 == false) goto L30;
        return 1.0f;
    L30:
        if (r6 >= r7) goto L32;
        boolean r12 = true;
    L34:
        if ((Math.abs(r10 / 90) % 2) == 0) goto L37;
        r0 = false;
    L37:
        if (r0 == false) goto L39;
        float r13 = r8;
    L40:
        if (r0 == false) goto L42;
        float r14 = r9;
    L43:
        float r15 = r8 / r13;
        float r16 = r9 / r14;
        if (r12 == false) goto L47;
        return RangesKt.coerceAtMost(r15, r16);
    L47:
        return RangesKt.coerceAtLeast(r15, r16);
    L42:
        r14 = r8;
        goto L43
    L39:
        r13 = r9;
        goto L40
    L32:
        r12 = false;
        goto L34
    L27:
        r11 = false;
        goto L28
    L21:
        r2 = false;
        goto L22
    L16:
        r5 = false;
        goto L17
    L11:
        r4 = false;
        goto L12
    L5:
        r3 = false;
        goto L7
    }

    public static /* synthetic */ void clickButton$default(CameraResultViewModel r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.clickButton(r1, r2, r3);
    }

    public static /* synthetic */ void clickCameraButtonForEduMode$default(CameraResultViewModel r1, String r2, Integer r3, Boolean r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        r1.clickCameraButtonForEduMode(r2, r3, r4);
    }

    public static /* synthetic */ Object getPreviewOutputParam$default(CameraResultViewModel r0, String r1, OutputParam r2, Continuation r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.getPreviewOutputParam(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void openPage$default(CameraResultViewModel r0, Intent r1, boolean r2, Function1 r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = new u();
    L5:
        r0.openPage(r1, r2, r3);
    }

    public static /* synthetic */ void showCameraItemForEduMode$default(CameraResultViewModel r1, String r2, Integer r3, Boolean r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        r1.showCameraItemForEduMode(r2, r3, r4);
    }

    public static /* synthetic */ Map getEduMessageExt$default(CameraResultViewModel r0, String r1, String r2, String r3, nx8.i r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = null;
    L6:
        return r0.getEduMessageExt(r1, r2, r3, r4);
    }

    public static /* synthetic */ void onSingleFunctionEditButtonShow$default(CameraResultViewModel r0, String r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        r0.onSingleFunctionEditButtonShow(r1, r2, r3, r4);
    }

    public static /* synthetic */ Object getPreviewBitmap$default(CameraResultViewModel r6, Context r7, String r8, int r9, OutputParam r10, Continuation r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L5;
        int r3 = 0;
    L7:
        if ((r12 & 8) == 0) goto L10;
        r10 = null;
    L10:
        return r6.getPreviewBitmap(r7, r8, r3, r10, r11);
    L5:
        r3 = r9;
        goto L7
    }
}
