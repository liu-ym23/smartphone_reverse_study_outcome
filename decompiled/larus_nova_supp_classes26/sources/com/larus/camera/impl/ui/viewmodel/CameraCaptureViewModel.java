package com.larus.camera.impl.ui.viewmodel;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.bmhome.utils.a4;
import com.larus.camera.api.params.CameraOutputContext;
import com.larus.camera.api.params.CameraResultRoute;
import com.larus.camera.api.params.CaptureMode;
import com.larus.camera.api.params.ImageParam;
import com.larus.camera.api.params.InputParam;
import com.larus.camera.api.params.OutputParam;
import com.larus.camera.api.params.VideoParam;
import com.larus.camera.contract.CameraServiceDiffContract;
import com.larus.camera.impl.edulibs.cameraapi.IdentifyDetectionResult;
import com.larus.camera.impl.monitor.CameraEvent;
import com.larus.camera.impl.ui.activity.CameraResultActivity;
import com.larus.camera.impl.ui.base.BaseCameraViewModel;
import com.larus.camera.impl.utils.CameraData;
import com.larus.camera.impl.utils.CameraScanLogic;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.c4;
import com.larus.platform.model.album.AlbumSelectItem;
import com.larus.platform.model.camera.ICameraEventExt;
import com.larus.platform.model.camera.ve.VeCameraOutputParam;
import com.larus.platform.service.h1;
import com.larus.platform.service.o3;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y0;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__DistinctKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;
import org.json.JSONObject;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000Ò\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0004Ô\u0001õ\u0001\u0018\u0000 \u0080\u00022\u00020\u0001:\u0002\u0080\u0002B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u00020\u0005H\u0002J\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018J\u0010\u0010C\u001a\u00020>2\b\u0010D\u001a\u0004\u0018\u00010)J\u0016\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020HJ\u000e\u0010/\u001a\u00020>2\u0006\u0010J\u001a\u00020\u0005J\u0010\u0010K\u001a\u00020>2\b\u0010L\u001a\u0004\u0018\u00010\u001dJ\u000e\u0010M\u001a\u00020>2\u0006\u0010L\u001a\u00020\u001dJ\u0006\u0010N\u001a\u00020>J\u000e\u00101\u001a\u00020F2\u0006\u0010O\u001a\u00020PJ(\u0010Q\u001a\u00020\u00052\u0006\u0010R\u001a\u00020S2\b\u0010T\u001a\u0004\u0018\u00010U2\u0006\u0010V\u001a\u00020WH\u0086@¢\u0006\u0002\u0010XJ(\u0010Y\u001a\u00020\u00052\u0006\u0010R\u001a\u00020S2\u0006\u0010V\u001a\u00020W2\b\u0010T\u001a\u0004\u0018\u00010UH\u0086@¢\u0006\u0002\u0010ZJ\"\u0010[\u001a\u00020>2\u0006\u0010\\\u001a\u00020]2\n\b\u0002\u0010^\u001a\u0004\u0018\u00010_2\u0006\u0010R\u001a\u00020SJ\u0006\u0010`\u001a\u00020\rJ\u0006\u0010a\u001a\u00020>J\u000e\u0010b\u001a\u00020\r2\u0006\u0010R\u001a\u00020SJ&\u0010c\u001a\u00020>2\u0006\u0010d\u001a\u00020H2\u0006\u0010e\u001a\u00020H2\u0006\u0010f\u001a\u00020\r2\u0006\u0010g\u001a\u00020\rJ\u000e\u0010h\u001a\u00020>2\u0006\u0010i\u001a\u00020jJ\u000e\u0010k\u001a\u00020>2\u0006\u0010l\u001a\u00020HJ\u000e\u0010m\u001a\u00020>2\u0006\u0010n\u001a\u00020\u0005J\u0006\u0010o\u001a\u00020>J\u0006\u0010p\u001a\u00020>J\u0006\u0010q\u001a\u00020)J\u0006\u0010r\u001a\u00020>J\u0006\u0010s\u001a\u00020>J\u000e\u0010t\u001a\u00020>2\u0006\u0010u\u001a\u00020vJ\u0006\u0010w\u001a\u00020vJ\f\u0010x\u001a\b\u0012\u0004\u0012\u00020v0yJ\b\u0010z\u001a\u0004\u0018\u00010)J\u0006\u0010{\u001a\u00020\u0005J\u000e\u0010|\u001a\u00020>2\u0006\u0010R\u001a\u00020SJ\u000e\u0010}\u001a\u00020\u00052\u0006\u0010R\u001a\u00020SJ\u0006\u0010~\u001a\u00020>J\u0006\u0010\u007f\u001a\u00020\u0005J\u001b\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u00012\u0006\u0010R\u001a\u00020SH\u0086@¢\u0006\u0003\u0010\u0082\u0001J'\u0010\u0083\u0001\u001a\u00020>2\u000e\u0010\u0084\u0001\u001a\t\u0012\u0004\u0012\u00020>0\u0085\u00012\u000e\u0010\u0086\u0001\u001a\t\u0012\u0004\u0012\u00020>0\u0085\u0001J\u0007\u0010\u0087\u0001\u001a\u00020>J\u0007\u0010\u0088\u0001\u001a\u00020>J\u0012\u0010\u0089\u0001\u001a\u00020\r2\u0007\u0010\u008a\u0001\u001a\u00020)H\u0002J\u0007\u0010\u008b\u0001\u001a\u00020>JB\u0010\u008c\u0001\u001a\u00020>2\u0006\u0010R\u001a\u00020S2\u001b\u0010\u008d\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u0081\u0001\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020>0\u008e\u00012\u0014\u0010\u008f\u0001\u001a\u000f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020>0\u0090\u0001JF\u0010\u0091\u0001\u001a\u00030\u0092\u00012\u0006\u0010R\u001a\u00020S2\u0016\b\u0002\u0010\u0093\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020>0\u0090\u00012\u001c\b\u0002\u0010\u0094\u0001\u001a\u0015\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020>0\u008e\u0001J\u0085\u0001\u0010\u0095\u0001\u001a\u00020>2\u0006\u0010R\u001a\u00020S2\u0007\u0010\u0096\u0001\u001a\u00020\u00052Z\b\u0002\u0010\u0097\u0001\u001aS\b\u0001\u0012\u001e\u0012\u001c\u0012\u0006\u0012\u0004\u0018\u00010W0y¢\u0006\u000f\b\u0099\u0001\u0012\n\b\u009a\u0001\u0012\u0005\b\b(\u009b\u0001\u0012\u0016\u0012\u00140\u0005¢\u0006\u000f\b\u0099\u0001\u0012\n\b\u009a\u0001\u0012\u0005\b\b(\u009c\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00050\u009d\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u009e\u00010\u0098\u00012\t\b\u0002\u0010\u009f\u0001\u001a\u00020)¢\u0006\u0003\u0010 \u0001J\u0010\u0010¡\u0001\u001a\u00020>2\u0007\u0010¢\u0001\u001a\u00020\u0005J\u0010\u0010£\u0001\u001a\u00020>2\u0007\u0010¤\u0001\u001a\u00020\u0016J\u001a\u0010¥\u0001\u001a\u00020>2\u0006\u0010R\u001a\u00020S2\u0007\u0010¦\u0001\u001a\u00020\rH\u0007J\u0007\u0010§\u0001\u001a\u00020\u0005J\u0081\u0001\u0010¨\u0001\u001a\u00020>2\u0006\u0010R\u001a\u00020S2\u000e\u0010©\u0001\u001a\t\u0012\u0005\u0012\u00030ª\u00010y2Z\b\u0002\u0010\u0097\u0001\u001aS\b\u0001\u0012\u001e\u0012\u001c\u0012\u0006\u0012\u0004\u0018\u00010W0y¢\u0006\u000f\b\u0099\u0001\u0012\n\b\u009a\u0001\u0012\u0005\b\b(\u009b\u0001\u0012\u0016\u0012\u00140\u0005¢\u0006\u000f\b\u0099\u0001\u0012\n\b\u009a\u0001\u0012\u0005\b\b(\u009c\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00050\u009d\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u009e\u00010\u0098\u0001¢\u0006\u0003\u0010«\u0001J\u0007\u0010¬\u0001\u001a\u00020>J\"\u0010\u00ad\u0001\u001a\u00020>2\u0007\u0010®\u0001\u001a\u00020)2\u0007\u0010¯\u0001\u001a\u00020)2\u0007\u0010°\u0001\u001a\u00020)J\u0010\u0010±\u0001\u001a\u00020>2\u0007\u0010²\u0001\u001a\u00020)J\u0010\u0010³\u0001\u001a\u00020>2\u0007\u0010´\u0001\u001a\u00020)J\u0007\u0010µ\u0001\u001a\u00020>J\u0007\u0010¶\u0001\u001a\u00020>J\u0007\u0010·\u0001\u001a\u00020>J\u0018\u0010¸\u0001\u001a\u00020>2\u0006\u0010D\u001a\u00020)2\u0007\u0010¯\u0001\u001a\u00020)J\u0019\u0010¹\u0001\u001a\u00020>2\u0007\u0010º\u0001\u001a\u00020)2\u0007\u0010»\u0001\u001a\u00020)J\u0007\u0010¼\u0001\u001a\u00020>J\u0007\u0010½\u0001\u001a\u00020>J\u0007\u0010¾\u0001\u001a\u00020>J\u0007\u0010¿\u0001\u001a\u00020>J\u0010\u0010À\u0001\u001a\u00020>2\u0007\u0010Á\u0001\u001a\u00020)J\u0007\u0010Â\u0001\u001a\u00020>J\u0010\u0010Ã\u0001\u001a\u00020>2\u0007\u0010Ä\u0001\u001a\u00020)J1\u0010Å\u0001\u001a\u00020>2\u0007\u0010Æ\u0001\u001a\u00020)2\t\u0010Ç\u0001\u001a\u0004\u0018\u00010)2\t\u0010È\u0001\u001a\u0004\u0018\u00010)2\t\u0010»\u0001\u001a\u0004\u0018\u00010)J\u000f\u0010É\u0001\u001a\u00020>2\u0006\u0010u\u001a\u00020)J\u0007\u0010Ê\u0001\u001a\u00020\rJ\u0007\u0010Ë\u0001\u001a\u00020\u0005J\u0007\u0010Ì\u0001\u001a\u00020>J\u001d\u0010Í\u0001\u001a\u00020>2\u0007\u0010Î\u0001\u001a\u00020)2\u000b\b\u0002\u0010Ï\u0001\u001a\u0004\u0018\u00010)J\t\u0010Ð\u0001\u001a\u00020>H\u0002J\t\u0010Ñ\u0001\u001a\u00020\u0005H\u0002J\u0007\u0010Ò\u0001\u001a\u00020)JB\u0010Ó\u0001\u001a\u00030Ô\u00012\u0014\u0010\u0093\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020>0\u0090\u00012\u001a\u0010\u0094\u0001\u001a\u0015\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020>0\u008e\u0001H\u0002¢\u0006\u0003\u0010Õ\u0001J\u0086\u0001\u0010Ö\u0001\u001a\u00020>2\u0006\u0010R\u001a\u00020S2\n\u0010×\u0001\u001a\u0005\u0018\u00010Ø\u00012\u0007\u0010Ù\u0001\u001a\u00020\r2X\u0010\u0097\u0001\u001aS\b\u0001\u0012\u001e\u0012\u001c\u0012\u0006\u0012\u0004\u0018\u00010W0y¢\u0006\u000f\b\u0099\u0001\u0012\n\b\u009a\u0001\u0012\u0005\b\b(\u009b\u0001\u0012\u0016\u0012\u00140\u0005¢\u0006\u000f\b\u0099\u0001\u0012\n\b\u009a\u0001\u0012\u0005\b\b(\u009c\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00050\u009d\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u009e\u00010\u0098\u0001H\u0002¢\u0006\u0003\u0010Ú\u0001J\u001f\u0010Û\u0001\u001a\u00020W2\b\u0010Ü\u0001\u001a\u00030Ý\u00012\n\u0010Þ\u0001\u001a\u0005\u0018\u00010Ø\u0001H\u0002J8\u0010ß\u0001\u001a\u00030à\u00012\u0006\u0010R\u001a\u00020S2\b\u0010á\u0001\u001a\u00030â\u00012\u0007\u0010Ù\u0001\u001a\u00020\r2\b\u0010T\u001a\u0004\u0018\u00010U2\u0007\u0010\u009c\u0001\u001a\u00020\u0005H\u0002J\u0084\u0001\u0010ã\u0001\u001a\u00020>2\u0006\u0010R\u001a\u00020S2\r\u0010\u009b\u0001\u001a\b\u0012\u0004\u0012\u00020W0y2\\\b\u0002\u0010\u0097\u0001\u001aU\b\u0001\u0012\u001e\u0012\u001c\u0012\u0006\u0012\u0004\u0018\u00010W0y¢\u0006\u000f\b\u0099\u0001\u0012\n\b\u009a\u0001\u0012\u0005\b\b(\u009b\u0001\u0012\u0016\u0012\u00140\u0005¢\u0006\u000f\b\u0099\u0001\u0012\n\b\u009a\u0001\u0012\u0005\b\b(\u009c\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00050\u009d\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u009e\u0001\u0018\u00010\u0098\u0001H\u0002¢\u0006\u0003\u0010«\u0001J\u008f\u0001\u0010ä\u0001\u001a\u00020>2\u0006\u0010R\u001a\u00020S2\u0006\u0010V\u001a\u00020W2\u0007\u0010Ù\u0001\u001a\u00020\r2\u0007\u0010å\u0001\u001a\u00020\u00052\\\b\u0002\u0010\u0097\u0001\u001aU\b\u0001\u0012\u001e\u0012\u001c\u0012\u0006\u0012\u0004\u0018\u00010W0y¢\u0006\u000f\b\u0099\u0001\u0012\n\b\u009a\u0001\u0012\u0005\b\b(\u009b\u0001\u0012\u0016\u0012\u00140\u0005¢\u0006\u000f\b\u0099\u0001\u0012\n\b\u009a\u0001\u0012\u0005\b\b(\u009c\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00050\u009d\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u009e\u0001\u0018\u00010\u0098\u0001H\u0002¢\u0006\u0003\u0010æ\u0001J#\u0010ç\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010W0è\u00012\u000f\u0010é\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010W0yH\u0002J\u001a\u0010ê\u0001\u001a\u00020\u00052\u000f\u0010\u009b\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010W0yH\u0002J\u000f\u0010ë\u0001\u001a\u00020\u00052\u0006\u0010R\u001a\u00020SJ\u0013\u0010ì\u0001\u001a\u00020>2\b\u0010í\u0001\u001a\u00030î\u0001H\u0002J\t\u0010ï\u0001\u001a\u00020>H\u0002J\u0013\u0010ð\u0001\u001a\u00020>2\n\u0010á\u0001\u001a\u0005\u0018\u00010â\u0001J\u0007\u0010ñ\u0001\u001a\u00020>J\u0013\u0010ò\u0001\u001a\u00020>2\b\u0010í\u0001\u001a\u00030î\u0001H\u0002J\t\u0010ó\u0001\u001a\u00020>H\u0002J\u0018\u0010ô\u0001\u001a\u00030õ\u00012\u0006\u0010R\u001a\u00020SH\u0002¢\u0006\u0003\u0010ö\u0001J\u001a\u0010÷\u0001\u001a\u00020>2\t\u0010í\u0001\u001a\u0004\u0018\u00010)2\u0006\u0010R\u001a\u00020SJ\u0014\u0010ø\u0001\u001a\u00020>2\t\u0010í\u0001\u001a\u0004\u0018\u00010)H\u0002J2\u0010ù\u0001\u001a\u00020>2\u0006\u0010R\u001a\u00020S2\u000f\u0010\u009b\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010W0y2\u0007\u0010\u009c\u0001\u001a\u00020\u0005H\u0086@¢\u0006\u0003\u0010ú\u0001J\n\u0010û\u0001\u001a\u0005\u0018\u00010ü\u0001J\n\u0010ý\u0001\u001a\u0005\u0018\u00010þ\u0001J\u000b\u0010ÿ\u0001\u001a\u0004\u0018\u00010)H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u00110\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\r0\u0018¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\r0\u0018¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\r0\u0018¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR!\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u001f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b*\u0010!R#\u0010-\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u00110\u0018¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001aR\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00130\u0018¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001aR\u0017\u00101\u001a\b\u0012\u0004\u0012\u00020\r0\u0018¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001aR\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u00106\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u000e\u0010;\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00050AX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0081\u0002"}, d2 = {"Lcom/larus/camera/impl/ui/viewmodel/CameraCaptureViewModel;", "Lcom/larus/camera/impl/ui/base/BaseCameraViewModel;", "<init>", "()V", "shouldHandleResult", "", "showBottomAlbum", "getShowBottomAlbum", "()Z", "setShowBottomAlbum", "(Z)V", "_flashStatus", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_flashLightStatus", "_scaleLengthStatus", "_surfaceFlingAction", "Lkotlin/Pair;", "_tryChangeAlbumThumbListState", "Lcom/larus/camera/impl/ui/viewmodel/MutableIntState;", "_albumThumbListStateChanged", "_recordingState", "Lcom/larus/camera/impl/entity/RecordControlUIState;", "recordingState", "Lkotlinx/coroutines/flow/StateFlow;", "getRecordingState", "()Lkotlinx/coroutines/flow/StateFlow;", "_captureButtonTouchEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Landroid/view/MotionEvent;", "captureButtonTouchEvent", "Lkotlinx/coroutines/flow/Flow;", "getCaptureButtonTouchEvent", "()Lkotlinx/coroutines/flow/Flow;", "flashStatus", "getFlashStatus", "flashLightStatus", "getFlashLightStatus", "scaleLengthStatus", "getScaleLengthStatus", "captureModeStatus", "", "getCaptureModeStatus", "captureModeStatus$delegate", "Lkotlin/Lazy;", "surfaceFlingAction", "getSurfaceFlingAction", "tryChangeAlbumThumbListState", "getTryChangeAlbumThumbListState", "albumThumbListStateChanged", "getAlbumThumbListStateChanged", "toResultConfig", "Lcom/larus/camera/impl/ui/viewmodel/ToResultPageConfig;", "enableEffectOpt", "downEvent", "getDownEvent", "()Landroid/view/MotionEvent;", "setDownEvent", "(Landroid/view/MotionEvent;)V", "startRecordTime", "", "onInitialized", "", "isLaunchedFromResultPage", "multiCaptureStatusHolder", "Lcom/larus/camera/impl/utils/StateFlowHolder;", "multiCaptureStatusFlow", "updateToResultPageConfig", "clickFrom", "updateOnSurfaceFling", "Lkotlinx/coroutines/Job;", "velocityX", "", "velocityY", "isShow", "postCaptureButtonTouchEvent", "event", "pendingDownEvent", "recycleDownEvent", "changeState", "Lcom/larus/camera/impl/ui/viewmodel/ChangeState;", "eduImageIdentifyCheck", "context", "Landroid/content/Context;", "albumUri", "Landroid/net/Uri;", "outputParam", "Lcom/larus/camera/api/params/OutputParam;", "(Landroid/content/Context;Landroid/net/Uri;Lcom/larus/camera/api/params/OutputParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "healthImageIdentifyCheck", "(Landroid/content/Context;Lcom/larus/camera/api/params/OutputParam;Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openCamera", "surfaceHolder", "Landroid/view/SurfaceHolder;", "cameraActionCallback", "Lcom/larus/platform/model/camera/ve/ICameraActionCallback;", "getRenderFps", "captureCurrentFrame", "getIconPadding", "focusAtPoint", "x", "y", "width", "height", "zoom", "ratio", "", "zoomByValue", "zoomValue", "updatePageStyle", "scanMode", "updateCameraDataOnSwitchTab", "closePage", "getCurrentCaptureMode", "resetCamera", "enterRecorder", "switchCaptureMode", "captureMode", "Lcom/larus/camera/api/params/CaptureMode;", "initCaptureMode", "getCaptureModeList", "", "returnExistingAlbumNodeId", "shouldReturnToExistingAlbum", "openAlbum", "checkAlbumPermission", "switchCamera", "isFrontCamera", "getMaskBitmap", "Landroid/graphics/Bitmap;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkupDarkMode", "onDark", "Lkotlin/Function0;", "onLight", "switchFlashLight", "initFlashStatus", "getFlashResourceByMode", "flashMode", "switchFlashStatus", "getAlbumCover", "setImageBitmap", "Lkotlin/Function2;", "setImageResource", "Lkotlin/Function1;", "createGestureDetector", "Landroid/view/GestureDetector;", "onSingleTap", "onFling", "capturePhoto", "autoOrientation", "pageInterceptor", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "outputParamList", "isFromAlbum", "Lkotlin/coroutines/Continuation;", "", "from", "(Landroid/content/Context;ZLkotlin/jvm/functions/Function3;Ljava/lang/String;)V", "startRecord", "enableAudio", "updateRecordingState", "state", "stopRecord", "duration", "isCurrentInRecording", "openResultPageFromAlbum", "resultList", "Lcom/larus/platform/model/album/AlbumSelectItem;", "(Landroid/content/Context;Ljava/util/List;Lkotlin/jvm/functions/Function3;)V", "checkCameraPermission", "enterPage", "currentPage", "enterMethod", "previousPage", "enterCapturePage", "mode", "leaveCapturePage", "leaveReason", "leaveCapturePageOnClose", "leaveCapturePageOnCapture", "leaveCapturePageOnSwitch", "clickUploadEntrance", "clickCameraButtonOnCapturePage", "buttonType", "switchMethod", "clickCaptureOnCapturePage", "clickFocusOnCapturePage", "clickFlashOnCapturePage", "clickAlbumPhotoOnCapturePage", "clickSwitchTabOnCapturePage", "toCaptureMode", "clickTorchOnCapturePage", "clickRecordOnCapturePage", "button", "clickZoomOnCapturePage", "zoomButtonType", "fromFocus", "toFocus", "updateMultiPickConfig", "getBottomAlbumMaxCount", "isSupportMultiPick", "resetEnterCapturePageTimer", "showCameraItemMobOnCapture", "itemType", "introTextInfo", "clearScaleLength", "hasOpenFlashLight", "getFlashMode", "createGestureListener", "com/larus/camera/impl/ui/viewmodel/CameraCaptureViewModel$createGestureListener$1", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lcom/larus/camera/impl/ui/viewmodel/CameraCaptureViewModel$createGestureListener$1;", "handleCameraResult", "veOutputParam", "Lcom/larus/platform/model/camera/ve/VeCameraOutputParam;", "orientation", "(Landroid/content/Context;Lcom/larus/platform/model/camera/ve/VeCameraOutputParam;ILkotlin/jvm/functions/Function3;)V", "createOutputParam", "resultType", "Lcom/larus/camera/api/params/OutputParam$ResultType;", "param", "createResultPageIntent", "Landroid/content/Intent;", "outputContext", "Lcom/larus/camera/api/params/CameraOutputContext;", "openResultPageWithMultiResult", "openResultPageWithSingleResult", "enablePageAnim", "(Landroid/content/Context;Lcom/larus/camera/api/params/OutputParam;IZLkotlin/jvm/functions/Function3;)V", "mergeInitialOutput", "", "newOutputs", "returnCapturedDeltaToOwner", "openResultPageWhenCaptureAgainBack", "processCameraResultCallback", "result", "Landroidx/activity/result/ActivityResult;", "mobEnterCameraMultiCapturePage", "finish", "finishAfterAlbumSend", "finishWith", "initCameraStatus", "createScanCallback", "com/larus/camera/impl/ui/viewmodel/CameraCaptureViewModel$createScanCallback$1", "(Landroid/content/Context;)Lcom/larus/camera/impl/ui/viewmodel/CameraCaptureViewModel$createScanCallback$1;", "handleScanResult", "scanResultHandle", "skipResultPageAndFinish", "(Landroid/content/Context;Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentFragment", "Landroidx/fragment/app/Fragment;", "getZoomService", "Lcom/larus/camera/impl/utils/capture/IZoomManager;", "invokeClickFrom", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraCaptureViewModel extends BaseCameraViewModel {
    public static final Companion Companion = null;
    public static final String TAG = "CameraCaptureViewModel";
    private static final List<Integer> flashLightResource = null;
    private static final List<Integer> flashResource = null;
    private final z0<Integer> _albumThumbListStateChanged;
    private final MutableSharedFlow<MotionEvent> _captureButtonTouchEvent;
    private final z0<Integer> _flashLightStatus;
    private final z0<Integer> _flashStatus;
    private final z0<px8.d> _recordingState;
    private final z0<Integer> _scaleLengthStatus;
    private final z0<Pair<Integer, Integer>> _surfaceFlingAction;
    private final z0<n0> _tryChangeAlbumThumbListState;
    private final i1<Integer> albumThumbListStateChanged;
    private final Flow<MotionEvent> captureButtonTouchEvent;
    private final Lazy captureModeStatus$delegate;
    private MotionEvent downEvent;
    private final boolean enableEffectOpt;
    private final i1<Integer> flashLightStatus;
    private final i1<Integer> flashStatus;
    private final com.larus.camera.impl.utils.g0<Boolean> multiCaptureStatusHolder;
    private final i1<px8.d> recordingState;
    private final i1<Integer> scaleLengthStatus;
    private boolean shouldHandleResult;
    private boolean showBottomAlbum;
    private long startRecordTime;
    private final i1<Pair<Integer, Integer>> surfaceFlingAction;
    private p0 toResultConfig;
    private final i1<n0> tryChangeAlbumThumbListState;

    public static final class Companion {
        public Companion() {
        }

        public final Object a(q0 r25, Context r26, Uri r27, String r28, Continuation<? super Boolean> r29) {
            if ((r29 instanceof CameraCaptureViewModel$Companion$eduImageIdentifyCheck$1) == false) goto L7;
            CameraCaptureViewModel$Companion$eduImageIdentifyCheck$1 r1 = (CameraCaptureViewModel$Companion$eduImageIdentifyCheck$1) r29;
            int r2 = r1.label;
            if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
            r1.label = r2 - Integer.MIN_VALUE;
        L8:
            CameraCaptureViewModel$Companion$eduImageIdentifyCheck$1 r8 = r1;
            Object r0 = r8.result;
            Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r8.label;
            boolean r12 = true;
            if (r3 == 0) goto L16;
            if (r3 == 1) goto L15;
            if (r3 != 2) goto L14;
            Uri r4 = (Uri) r8.L$2;
            Context r5 = (Context) r8.L$1;
            q0 r6 = (q0) r8.L$0;
            ResultKt.throwOnFailure(r0);
            Context r18 = r5;
        L41:
            IdentifyDetectionResult r7 = (IdentifyDetectionResult) r0;
            if (r7 != null) goto L44;
            r7 = new IdentifyDetectionResult(0, 7);
        L44:
            boolean r10 = r7.a;
            int r11 = r7.b;
            if (r11 != 1) goto L47;
            String r13 = AppHost.a.getApplication().getString(2131900543);
        L58:
            Intrinsics.checkNotNull(r13);
            if (r10 == true) goto L61;
            t19.s.j(t19.s.a, r18, r13, null, false, 28);
        L61:
            String r14 = r6.y0().getCaptureMode();
            if (r4 != null) goto L65;
            r12 = false;
        L65:
            r6.i0(r14, r13, r10, r12);
            r12 = r10;
            q0 r15 = r6;
        L66:
            if (r12 == false) goto L69;
            r15.m0(false, r15.y0().getCaptureMode());
        L69:
            return Boxing.boxBoolean(r12);
        L47:
            if (r11 != 2) goto L49;
            r13 = AppHost.a.getApplication().getString(2131900542);
            goto L58
        L49:
            if (r11 == 3) goto L51;
            r13 = "";
            goto L58
        L51:
            Application r16 = AppHost.a.getApplication();
            if (Intrinsics.areEqual(r6.y0().getCaptureMode(), "CAPTURE_MODE_EDU_ARTICLE_PHOTO") == false) goto L54;
            int r17 = 2131900545;
        L55:
            r13 = r16.getString(r17);
            goto L58
        L54:
            r17 = 2131900544;
            goto L55
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            String r19 = (String) r8.L$3;
            Uri r20 = (Uri) r8.L$2;
            Context r21 = (Context) r8.L$1;
            q0 r22 = (q0) r8.L$0;
            ResultKt.throwOnFailure(r0);
            String r23 = r19;
            Context r24 = r21;
            Object r30 = r0;
            r15 = r22;
        L34:
            Bitmap r31 = (Bitmap) r30;
            FLogger.a.i(CameraCaptureViewModel.TAG, "eduImageIdentifyCheck: start edu check: " + r31);
            if (r31 == null) goto L66;
            if (r23 == null) goto L66;
            CameraCaptureViewModel$Companion$eduImageIdentifyCheck$isCheckPass$checkResult$1 r32 = new CameraCaptureViewModel$Companion$eduImageIdentifyCheck$isCheckPass$checkResult$1(r24, r23, r31, 0);
            r8.L$0 = r15;
            r8.L$1 = r24;
            r8.L$2 = r20;
            r8.L$3 = r5;
            r8.label = 2;
            Object r33 = TimeoutKt.c(500, r32, r8);
            if (r33 != r9) goto L40;
            return r9;
        L40:
            r18 = r24;
            r4 = r20;
            r6 = r15;
            r0 = r33;
            goto L41
        L16:
            ResultKt.throwOnFailure(r0);
            if (r27 == null) goto L22;
            String r34 = r27.toString();
            if (r34 == null) goto L22;
            String r35 = r34;
        L30:
            FLogger.a.i(CameraCaptureViewModel.TAG, "eduImageIdentifyCheck: before load bitmap");
            String r210 = r35;
            CameraCaptureViewModel$Companion$eduImageIdentifyCheck$originBitmap$1 r36 = new CameraCaptureViewModel$Companion$eduImageIdentifyCheck$originBitmap$1(r27, r25, r26, r210, null);
            r15 = r25;
            r8.L$0 = r15;
            r24 = r26;
            r8.L$1 = r24;
            r8.L$2 = r27;
            r23 = r210;
            r8.L$3 = r23;
            r8.label = 1;
            Object r37 = TimeoutKt.c(500, r36, r8);
            if (r37 != r9) goto L33;
            return r9;
        L33:
            r30 = r37;
            r20 = r27;
        L22:
            if (r28 != null) goto L24;
        L29:
            r35 = null;
            goto L30
        L24:
            if (r28.length() <= 0) goto L26;
            boolean r38 = true;
        L27:
            if (r38 == false) goto L29;
            r35 = r28;
            goto L30
        L26:
            r38 = false;
        L7:
            r1 = new CameraCaptureViewModel$Companion$eduImageIdentifyCheck$1(this, r29);
            goto L8
        }
    }

    public static final class a implements pq9.i {
        public final /* synthetic */ CameraCaptureViewModel a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Function3<List<OutputParam>, Boolean, Continuation<? super Boolean>, Object> e;

        public final void a(VeCameraOutputParam r5) {
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("takePicture complete: path=");
            if (r5 == null) goto L5;
            String r2 = r5.getPath();
        L6:
            r1.append(r2);
            r0.v(CameraCaptureViewModel.TAG, r1.toString());
            CameraCaptureViewModel r3 = this.a;
            Context r4 = this.b;
            if (this.c == false) goto L9;
            z2.a.w3();
            int r6 = this.d;
        L10:
            CameraCaptureViewModel.access$handleCameraResult(r3, r4, r5, r6, this.e);
            return;
        L9:
            r6 = 0;
            goto L10
        L5:
            r2 = null;
            goto L6
        }

        public final void onError(String r3) {
            Intrinsics.checkNotNullParameter(r3, "errMsg");
            qx8.a.b.e(-15001, r3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(CameraCaptureViewModel r1, Context r2, boolean r3, int r4, Function3<? super List<OutputParam>, ? super Boolean, ? super Continuation<? super Boolean>, ? extends Object> r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$albumThumbListStateChanged$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$albumThumbListStateChanged$1", f = "CameraCaptureViewModel.kt", i = {}, l = {262}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ChangeState $changeState;
        int label;
        final /* synthetic */ CameraCaptureViewModel this$0;

        public AnonymousClass1(CameraCaptureViewModel r1, ChangeState r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$changeState = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$changeState, r4);
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
            z0 r5 = CameraCaptureViewModel.access$get_albumThumbListStateChanged$p(this.this$0);
            Integer r2 = Boxing.boxInt(this.$changeState.getState());
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public static final class b implements pq9.c {
        public Boolean a;
        public final /* synthetic */ CameraCaptureViewModel b;
        public final /* synthetic */ Function0<Unit> c;
        public final /* synthetic */ Function0<Unit> d;

        public final void onResult(boolean r3) {
            if (Intrinsics.areEqual(this.a, Boolean.valueOf(r3)) == false) goto L5;
            return;
        L5:
            this.a = Boolean.valueOf(r3);
            if (r3 == true) goto L8;
        L10:
            Function0<Unit> r4 = this.d;
        L11:
            r4.invoke();
            return;
        L8:
            if (CameraCaptureViewModel.access$hasOpenFlashLight(this.b) == true) goto L10;
            r4 = this.c;
            goto L11
        }

        public b(CameraCaptureViewModel r1, Function0<Unit> r2, Function0<Unit> r3) {
            this.b = r1;
            this.c = r2;
            this.d = r3;
        }
    }

    public static final class c extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ Function1<MotionEvent, Unit> a;
        public final /* synthetic */ Function2<Float, Float, Unit> b;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            this.a.invoke(r2);
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function1<? super MotionEvent, Unit> r1, Function2<? super Float, ? super Float, Unit> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r1, MotionEvent r2, float r3, float r4) {
            Intrinsics.checkNotNullParameter(r2, "e2");
            this.b.invoke(Float.valueOf(r3), Float.valueOf(r4));
            return true;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$capturePhoto$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "<unused var>", "", "Lcom/larus/camera/api/params/OutputParam;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$capturePhoto$1", f = "CameraCaptureViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02271 extends SuspendLambda implements Function3<List<? extends OutputParam>, Boolean, Continuation<? super Boolean>, Object> {
        int label;

        public C02271(Continuation<? super C02271> r2) {
            super(3, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
            return invoke((List) r1, ((Boolean) r2).booleanValue(), (Continuation) r3);
        }

        public final Object invoke(List<OutputParam> r1, boolean r2, Continuation<? super Boolean> r3) {
            return new C02271(r3).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            return Boxing.boxBoolean(false);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$clearScaleLength$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$clearScaleLength$1", f = "CameraCaptureViewModel.kt", i = {}, l = {796}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02281 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CameraCaptureViewModel this$0;

        public C02281(CameraCaptureViewModel r1, Continuation<? super C02281> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02281(this.this$0, r3);
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
            z0 r5 = CameraCaptureViewModel.access$get_scaleLengthStatus$p(this.this$0);
            Integer r2 = Boxing.boxInt(((Number) this.this$0.getScaleLengthStatus().getValue()).intValue() + 1);
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public static final class d implements pq9.a {
        public final /* synthetic */ CameraCaptureViewModel a;
        public final /* synthetic */ Context b;

        public final void onResult(String r3) {
            this.a.handleScanResult(r3, this.b);
        }

        public d(CameraCaptureViewModel r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class e implements Function1<Boolean, Unit> {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object r1) {
            ((Boolean) r1).booleanValue();
            return Unit.INSTANCE;
        }
    }

    public static final class f implements c4.b {
        public final /* synthetic */ Context a;
        public final /* synthetic */ Ref.ObjectRef<Function1<Boolean, Unit>> b;
        public final /* synthetic */ CameraCaptureViewModel c;

        public static final class a implements Function1<Boolean, Unit> {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }

            public final /* bridge */ /* synthetic */ Object invoke(Object r1) {
                ((Boolean) r1).booleanValue();
                return Unit.INSTANCE;
            }
        }

        public final void onError(String r8) {
            Intrinsics.checkNotNullParameter(r8, "errorMsg");
            t19.s.j(t19.s.a, this.a, r8, null, false, 28);
            ((Function1) this.b.element).invoke(Boolean.TRUE);
            Ref.ObjectRef<Function1<Boolean, Unit>> r9 = this.b;
            r9.element = a.a;
            CameraCaptureViewModel.access$ability(this.c).m0(false, CameraCaptureViewModel.access$ability(this.c).y0().getCaptureMode());
            CameraCaptureViewModel.access$ability(this.c).r0(1, CameraCaptureViewModel.access$ability(this.c).y0().getCaptureMode());
        }

        public final void onSuccess(boolean r4) {
            String r0 = CameraCaptureViewModel.access$ability(this.c).y0().getCaptureMode();
            if (r4 == false) goto L5;
            ((Function1) this.b.element).invoke(Boolean.TRUE);
            Ref.ObjectRef<Function1<Boolean, Unit>> r5 = this.b;
            r5.element = com.larus.camera.impl.ui.viewmodel.i.a;
            CameraCaptureViewModel.access$ability(this.c).m0(false, r0);
            CameraCaptureViewModel.access$ability(this.c).r0(1, r0);
            return;
        L5:
            ((Function1) this.b.element).invoke(Boolean.FALSE);
            Ref.ObjectRef<Function1<Boolean, Unit>> r6 = this.b;
            r6.element = com.larus.camera.impl.ui.viewmodel.j.a;
            CameraCaptureViewModel.access$ability(this.c).r0(0, r0);
            t19.s.a.g(this.a, 2131908177, false);
        }

        public f(Context r1, Ref.ObjectRef<Function1<Boolean, Unit>> r2, CameraCaptureViewModel r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class g implements Function1<Boolean, Unit> {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object r1) {
            ((Boolean) r1).booleanValue();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$getAlbumCover$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$getAlbumCover$1", f = "CameraCaptureViewModel.kt", i = {}, l = {539, 544}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02291 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ Function2<Bitmap, Boolean, Unit> $setImageBitmap;
        final /* synthetic */ Function1<Integer, Unit> $setImageResource;
        int label;
        final /* synthetic */ CameraCaptureViewModel this$0;

        /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$getAlbumCover$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$getAlbumCover$1$1", f = "CameraCaptureViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00831 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Pair<Bitmap, Boolean> $bitmapPair;
            final /* synthetic */ Function2<Bitmap, Boolean, Unit> $setImageBitmap;
            final /* synthetic */ Function1<Integer, Unit> $setImageResource;
            int label;

            /* JADX WARN: Multi-variable type inference failed */
            public C00831(Pair<Bitmap, Boolean> r1, Function2<? super Bitmap, ? super Boolean, Unit> r2, Function1<? super Integer, Unit> r3, Continuation<? super C00831> r4) {
                this.$bitmapPair = r1;
                this.$setImageBitmap = r2;
                this.$setImageResource = r3;
                super(2, r4);
            }

            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                return new C00831(this.$bitmapPair, this.$setImageBitmap, this.$setImageResource, r5);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r3) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L11;
                ResultKt.throwOnFailure(r3);
                Bitmap r4 = (Bitmap) this.$bitmapPair.getFirst();
                boolean r0 = ((Boolean) this.$bitmapPair.getSecond()).booleanValue();
                if (r4 == null) goto L7;
                this.$setImageBitmap.invoke(r4, Boxing.boxBoolean(r0));
            L9:
                return Unit.INSTANCE;
            L7:
                this.$setImageResource.invoke(Boxing.boxInt(2131241090));
                goto L9
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$getAlbumCover$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$getAlbumCover$1$2", f = "CameraCaptureViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Integer, Unit> $setImageResource;
            int label;

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass2(Function1<? super Integer, Unit> r1, Continuation<? super AnonymousClass2> r2) {
                this.$setImageResource = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new AnonymousClass2(this.$setImageResource, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                this.$setImageResource.invoke(Boxing.boxInt(2131241090));
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C02291(CameraCaptureViewModel r1, Context r2, Function2<? super Bitmap, ? super Boolean, Unit> r3, Function1<? super Integer, Unit> r4, Continuation<? super C02291> r5) {
            this.this$0 = r1;
            this.$context = r2;
            this.$setImageBitmap = r3;
            this.$setImageResource = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C02291(this.this$0, this.$context, this.$setImageBitmap, this.$setImageResource, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 == 2) goto L9;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r8);
        L21:
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r8);
            if (CameraCaptureViewModel.access$ability(this.this$0).B0(this.$context) == true) goto L13;
        L17:
            MainCoroutineDispatcher r9 = Dispatchers.getMain();
            AnonymousClass2 r3 = new AnonymousClass2(this.$setImageResource, null);
            this.label = 2;
            if (BuildersKt.withContext(r9, r3, this) != r0) goto L21;
            return r0;
        L13:
            if (Intrinsics.areEqual(CameraServiceDiffContract.b.isHideAlbumCover(), Boxing.boxBoolean(true)) == true) goto L17;
            Pair<Bitmap, Boolean> r10 = CameraCaptureViewModel.access$ability(this.this$0).P(this.$context, zx8.b.b());
            MainCoroutineDispatcher r2 = Dispatchers.getMain();
            C00831 r4 = new C00831(r10, this.$setImageBitmap, this.$setImageResource, null);
            this.label = 1;
            if (BuildersKt.withContext(r2, r4, this) != r0) goto L21;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$getMaskBitmap$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$getMaskBitmap$2", f = "CameraCaptureViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
        final /* synthetic */ Context $context;
        int label;
        final /* synthetic */ CameraCaptureViewModel this$0;

        public AnonymousClass2(CameraCaptureViewModel r1, Context r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$context = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.this$0, this.$context, r4);
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
            return CameraCaptureViewModel.access$ability(this.this$0).Q(this.$context, CameraCaptureViewModel.access$ability(this.this$0).G());
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class h implements Function1<Boolean, Unit> {
        public final /* synthetic */ kotlinx.coroutines.i<Boolean> a;

        public h(kotlinx.coroutines.j r1) {
            this.a = r1;
        }

        public final Object invoke(Object r2) {
            Boolean r3 = Boolean.valueOf(((Boolean) r2).booleanValue());
            this.a.resumeWith(Result.constructor-impl(r3));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$healthImageIdentifyCheck$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel", f = "CameraCaptureViewModel.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 2}, l = {273, 278, 1308}, m = "healthImageIdentifyCheck", n = {"context", "outputParam", "imagePath", "context", "outputParam", "imagePath", "context", "outputParam", "imagePath", "originBitmap"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
    public static final class C02301 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ CameraCaptureViewModel this$0;

        public C02301(CameraCaptureViewModel r1, Continuation<? super C02301> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.healthImageIdentifyCheck(null, null, null, this);
        }
    }

    public static final class i implements pq9.g {
        public final /* synthetic */ CameraCaptureViewModel a;

        public i(CameraCaptureViewModel r1) {
            this.a = r1;
        }

        public final void a(String r4, Bitmap r5) {
            FLogger.a.i(CameraCaptureViewModel.TAG, "[onFirstFrameBitmap] path" + r4 + ", bitmap:" + r5);
            if (r4 == null) goto L6;
            CameraCaptureViewModel.access$ability(this.a).H(r4, r5);
            return;
        }

        public final void b(boolean r4, int r5) {
            FLogger.a.i(CameraCaptureViewModel.TAG, "[onStartResult] isSuccess:" + r4 + ", code:" + r5);
            this.a.updateRecordingState(new px8.d.a(r4));
            if (r4 == true) goto L5;
            qx8.a.b.g(-16000, String.valueOf(r5));
            return;
        L5:
            CameraCaptureViewModel.access$setStartRecordTime$p(this.a, System.currentTimeMillis());
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$initFlashStatus$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$initFlashStatus$2", f = "CameraCaptureViewModel.kt", i = {}, l = {506, 507}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02312 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $resource;
        int label;
        final /* synthetic */ CameraCaptureViewModel this$0;

        public C02312(CameraCaptureViewModel r1, int r2, Continuation<? super C02312> r3) {
            this.this$0 = r1;
            this.$resource = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02312(this.this$0, this.$resource, r4);
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
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r5);
        L17:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r5);
        L13:
            z0 r6 = CameraCaptureViewModel.access$get_flashLightStatus$p(this.this$0);
            Integer r2 = Boxing.boxInt(2131241094);
            this.label = 2;
            if (r6.emit(r2, this) != r0) goto L17;
            return r0;
        L10:
            ResultKt.throwOnFailure(r5);
            z0 r7 = CameraCaptureViewModel.access$get_flashStatus$p(this.this$0);
            Integer r3 = Boxing.boxInt(this.$resource);
            this.label = 1;
            if (r7.emit(r3, this) != r0) goto L13;
            return r0;
        }
    }

    public static final class j implements pq9.f {
        public final /* synthetic */ CameraCaptureViewModel a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Context c;

        public final void a(String r14, Pair<Integer, Integer> r15) {
            Intrinsics.checkNotNullParameter(r14, MusicAppletPage.KEY_PATH);
            Intrinsics.checkNotNullParameter(r15, "size");
            long r0 = System.currentTimeMillis() - CameraCaptureViewModel.access$getStartRecordTime$p(this.a);
            FLogger r2 = FLogger.a;
            r2.i(CameraCaptureViewModel.TAG, "[stopRecord] path:" + r14 + " duration:" + this.b + " start:" + r0);
            if (r0 > 1000) goto L5;
            CameraCaptureViewModel.capturePhoto$default(this.a, this.c, false, null, "stop_Record", 4, null);
            qx8.a r16 = qx8.a.b;
            r16.getClass();
            r2.i("CameraMonitor", "[clearRecordPreviewEvent]");
            qx8.a.f = false;
            qx8.a.g = false;
            qx8.a.h = false;
            qx8.a.i = null;
            gx8.b r17 = r16.a;
            CameraEvent r18 = CameraEvent.PREVIEW_RECORD;
            r17.getClass();
            Intrinsics.checkNotNullParameter(r18, "event");
            r17.b.remove(r18.getUniqueKey());
            return;
        L5:
            CameraCaptureViewModel r3 = this.a;
            OutputParam.ResultType r4 = OutputParam.ResultType.VIDEO;
            VeCameraOutputParam r5 = new VeCameraOutputParam();
            r5.setPath(r14);
            r5.setWidth(((Number) r15.getFirst()).intValue());
            r5.setHeight(((Number) r15.getSecond()).intValue());
            Unit r19 = Unit.INSTANCE;
            OutputParam r7 = CameraCaptureViewModel.access$createOutputParam(r3, r4, r5);
            r7.getVideoParam().setDuration(r0);
            CameraCaptureViewModel.access$openResultPageWithSingleResult(this.a, this.c, r7, 0, false, null);
        }

        public j(CameraCaptureViewModel r1, int r2, Context r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$openResultPageFromAlbum$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "<unused var>", "", "Lcom/larus/camera/api/params/OutputParam;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$openResultPageFromAlbum$1", f = "CameraCaptureViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02321 extends SuspendLambda implements Function3<List<? extends OutputParam>, Boolean, Continuation<? super Boolean>, Object> {
        int label;

        public C02321(Continuation<? super C02321> r2) {
            super(3, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
            return invoke((List) r1, ((Boolean) r2).booleanValue(), (Continuation) r3);
        }

        public final Object invoke(List<OutputParam> r1, boolean r2, Continuation<? super Boolean> r3) {
            return new C02321(r3).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            return Boxing.boxBoolean(false);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$openResultPageWithMultiResult$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$openResultPageWithMultiResult$1", f = "CameraCaptureViewModel.kt", i = {}, l = {959}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02331 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ List<OutputParam> $outputParamList;
        final /* synthetic */ Function3<List<OutputParam>, Boolean, Continuation<? super Boolean>, Object> $pageInterceptor;
        int label;
        final /* synthetic */ CameraCaptureViewModel this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public C02331(CameraCaptureViewModel r1, List<OutputParam> r2, Function3<? super List<OutputParam>, ? super Boolean, ? super Continuation<? super Boolean>, ? extends Object> r3, Context r4, Continuation<? super C02331> r5) {
            this.this$0 = r1;
            this.$outputParamList = r2;
            this.$pageInterceptor = r3;
            this.$context = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C02331(this.this$0, this.$outputParamList, this.$pageInterceptor, this.$context, r8);
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
            boolean r3 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L18:
            if (((Boolean) r10).booleanValue() == true) goto L21;
        L20:
            r3 = false;
        L21:
            if (r3 == true) goto L23;
            FLogger r11 = FLogger.a;
            r11.i(CameraCaptureViewModel.TAG, "openResultPageWithMultiResult: pageInterceptor pass");
            CameraOutputContext r5 = new CameraOutputContext();
            r5.setOutputParamList(CameraCaptureViewModel.access$mergeInitialOutput(this.this$0, this.$outputParamList));
            if (Intrinsics.areEqual(this.this$0.getCameraData().getTarget(), "TARGET_GET") == true) goto L27;
        L30:
            q0 r12 = CameraCaptureViewModel.access$ability(this.this$0);
            CameraCaptureViewModel r4 = this.this$0;
            Context r6 = this.$context;
            OutputParam r2 = (OutputParam) CollectionsKt.firstOrNull(this.$outputParamList);
            if (r2 == null) goto L35;
            String r7 = r2.getSrcAlbumUri();
            if (r7 == null) goto L35;
            Uri r8 = y0.j(r7);
        L36:
            Intent r9 = CameraCaptureViewModel.access$createResultPageIntent(r4, r6, r5, 0, r8, true);
            final CameraCaptureViewModel r13 = this.this$0;
            r12.X(r9, false, new k(r13));
            return Unit.INSTANCE;
        L35:
            r8 = null;
            goto L36
        L27:
            if (CameraCaptureViewModel.access$isLaunchedFromResultPage(this.this$0) == false) goto L30;
            r11.i(CameraCaptureViewModel.TAG, "openResultPageWithMultiResult: launched from result page with TARGET_GET, finish directly");
            this.this$0.finish(r5);
            return Unit.INSTANCE;
        L23:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            if (CameraCaptureViewModel.access$returnCapturedDeltaToOwner(this.this$0, this.$outputParamList) == true) goto L11;
            Function3<List<OutputParam>, Boolean, Continuation<? super Boolean>, Object> r14 = this.$pageInterceptor;
            if (r14 == null) goto L20;
            List<OutputParam> r15 = this.$outputParamList;
            Boolean r16 = Boxing.boxBoolean(true);
            this.label = 1;
            r10 = r14.invoke(r15, r16, this);
            if (r10 != r0) goto L18;
            return r0;
        L11:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$openResultPageWithSingleResult$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$openResultPageWithSingleResult$1", f = "CameraCaptureViewModel.kt", i = {}, l = {1004}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02341 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ boolean $enablePageAnim;
        final /* synthetic */ int $orientation;
        final /* synthetic */ OutputParam $outputParam;
        final /* synthetic */ Function3<List<OutputParam>, Boolean, Continuation<? super Boolean>, Object> $pageInterceptor;
        int label;
        final /* synthetic */ CameraCaptureViewModel this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public C02341(CameraCaptureViewModel r1, OutputParam r2, Function3<? super List<OutputParam>, ? super Boolean, ? super Continuation<? super Boolean>, ? extends Object> r3, Context r4, int r5, boolean r6, Continuation<? super C02341> r7) {
            this.this$0 = r1;
            this.$outputParam = r2;
            this.$pageInterceptor = r3;
            this.$context = r4;
            this.$orientation = r5;
            this.$enablePageAnim = r6;
            super(2, r7);
        }

        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            return new C02341(this.this$0, this.$outputParam, this.$pageInterceptor, this.$context, this.$orientation, this.$enablePageAnim, r10);
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
            boolean r3 = false;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L18:
            if (((Boolean) r10).booleanValue() != true) goto L20;
            r3 = true;
        L20:
            if (r3 == false) goto L26;
            qx8.a r11 = qx8.a.b;
            r11.e(-15003, "user intercept");
            if (this.$outputParam.isVideo() == false) goto L25;
            r11.g(-15003, "user intercept");
        L25:
            return Unit.INSTANCE;
        L26:
            FLogger.a.i(CameraCaptureViewModel.TAG, "openResultPage: pageInterceptor pass");
            CameraOutputContext r5 = new CameraOutputContext();
            r5.setOutputParamList(CameraCaptureViewModel.access$mergeInitialOutput(this.this$0, CollectionsKt.listOf(this.$outputParam)));
            q0 r12 = CameraCaptureViewModel.access$ability(this.this$0);
            Intent r2 = CameraCaptureViewModel.access$createResultPageIntent(this.this$0, this.$context, r5, this.$orientation, null, false);
            boolean r4 = this.$enablePageAnim;
            final CameraCaptureViewModel r6 = this.this$0;
            r12.X(r2, r4, new l(r6));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            FLogger.a.i(CameraCaptureViewModel.TAG, "openResultPage start");
            if (CameraCaptureViewModel.access$returnCapturedDeltaToOwner(this.this$0, CollectionsKt.listOf(this.$outputParam)) == true) goto L11;
            Function3<List<OutputParam>, Boolean, Continuation<? super Boolean>, Object> r13 = this.$pageInterceptor;
            if (r13 == null) goto L20;
            List r7 = CollectionsKt.listOf(this.$outputParam);
            Boolean r8 = Boxing.boxBoolean(false);
            this.label = 1;
            r10 = r13.invoke(r7, r8, this);
            if (r10 != r0) goto L18;
            return r0;
        L11:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$skipResultPageAndFinish$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel", f = "CameraCaptureViewModel.kt", i = {0, 0, 0, 1, 1, 1}, l = {1247, 1257}, m = "skipResultPageAndFinish", n = {"context", "finalOutputParamList", "t1", "context", "finalOutputParamList", "t2"}, s = {"L$0", "L$1", "J$0", "L$0", "L$1", "J$0"})
    public static final class C02351 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ CameraCaptureViewModel this$0;

        public C02351(CameraCaptureViewModel r1, Continuation<? super C02351> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.skipResultPageAndFinish(null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$switchCaptureMode$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$switchCaptureMode$1", f = "CameraCaptureViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02361 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CaptureMode $captureMode;
        int label;
        final /* synthetic */ CameraCaptureViewModel this$0;

        public C02361(CameraCaptureViewModel r1, CaptureMode r2, Continuation<? super C02361> r3) {
            this.this$0 = r1;
            this.$captureMode = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02361(this.this$0, this.$captureMode, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r4);
            CameraCaptureViewModel.access$setShouldHandleResult$p(this.this$0, true);
            q0 r5 = CameraCaptureViewModel.access$ability(this.this$0);
            final CaptureMode r0 = this.$captureMode;
            r5.l0(new m(r0));
            qx8.a r6 = qx8.a.b;
            String r1 = this.$captureMode.getMode();
            r6.getClass();
            Intrinsics.checkNotNullParameter(r1, "mode");
            qx8.b r2 = qx8.a.c;
            if (r2 == null) goto L7;
            Intrinsics.checkNotNullParameter(r1, "mode");
            r2.b = qx8.b.b(r1);
        L7:
            Keva r7 = zx8.b.a;
            String r8 = this.$captureMode.getMode();
            Intrinsics.checkNotNullParameter(r8, "captureMode");
            FLogger.a.i("CameraRecordConfigManager", "updateCaptureMode, captureMode:" + r8);
            zx8.b.i = zx8.b.c.contains(r8);
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$switchFlashLight$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$switchFlashLight$1", f = "CameraCaptureViewModel.kt", i = {}, l = {498}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02371 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $nextStatus;
        int label;
        final /* synthetic */ CameraCaptureViewModel this$0;

        public C02371(CameraCaptureViewModel r1, int r2, Continuation<? super C02371> r3) {
            this.this$0 = r1;
            this.$nextStatus = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02371(this.this$0, this.$nextStatus, r4);
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
            z0 r5 = CameraCaptureViewModel.access$get_flashLightStatus$p(this.this$0);
            Integer r2 = Boxing.boxInt(this.$nextStatus);
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$switchFlashStatus$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$switchFlashStatus$1", f = "CameraCaptureViewModel.kt", i = {}, l = {528}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02381 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $nextStatus;
        int label;
        final /* synthetic */ CameraCaptureViewModel this$0;

        public C02381(CameraCaptureViewModel r1, int r2, Continuation<? super C02381> r3) {
            this.this$0 = r1;
            this.$nextStatus = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02381(this.this$0, this.$nextStatus, r4);
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
            z0 r5 = CameraCaptureViewModel.access$get_flashStatus$p(this.this$0);
            Integer r2 = Boxing.boxInt(this.$nextStatus);
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$tryChangeAlbumThumbListState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$tryChangeAlbumThumbListState$1", f = "CameraCaptureViewModel.kt", i = {}, l = {243}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02391 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ n0 $mutableShowState;
        int label;
        final /* synthetic */ CameraCaptureViewModel this$0;

        public C02391(CameraCaptureViewModel r1, n0 r2, Continuation<? super C02391> r3) {
            this.this$0 = r1;
            this.$mutableShowState = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02391(this.this$0, this.$mutableShowState, r4);
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
            z0 r5 = CameraCaptureViewModel.access$get_tryChangeAlbumThumbListState$p(this.this$0);
            n0 r2 = this.$mutableShowState;
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$updateOnSurfaceFling$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$updateOnSurfaceFling$1", f = "CameraCaptureViewModel.kt", i = {}, l = {232}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02401 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $velocityX;
        final /* synthetic */ float $velocityY;
        int label;
        final /* synthetic */ CameraCaptureViewModel this$0;

        public C02401(CameraCaptureViewModel r1, float r2, float r3, Continuation<? super C02401> r4) {
            this.this$0 = r1;
            this.$velocityX = r2;
            this.$velocityY = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C02401(this.this$0, this.$velocityX, this.$velocityY, r5);
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
            z0 r6 = CameraCaptureViewModel.access$get_surfaceFlingAction$p(this.this$0);
            Pair r2 = TuplesKt.to(Boxing.boxInt((int) this.$velocityX), Boxing.boxInt((int) this.$velocityY));
            this.label = 1;
            if (r6.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public static /* synthetic */ Unit Mo(MotionEvent r0) {
        return createGestureDetector$lambda$13(r0);
    }

    public static /* synthetic */ Unit No(CameraCaptureViewModel r0, String r1, String r2) {
        return scanResultHandle$lambda$34(r0, r1, r2);
    }

    public static /* synthetic */ Unit Oo(boolean r0, CameraCaptureViewModel r1) {
        return openAlbum$lambda$11(r0, r1);
    }

    public static /* synthetic */ String Po(CameraData r0) {
        return captureModeStatus_delegate$lambda$2$lambda$0(r0);
    }

    public static /* synthetic */ Flow Qo(CameraCaptureViewModel r0) {
        return captureModeStatus_delegate$lambda$2(r0);
    }

    public static /* synthetic */ Unit So(float r0, float r1) {
        return createGestureDetector$lambda$14(r0, r1);
    }

    public static /* synthetic */ CameraData To(CameraData r0) {
        return updateCameraDataOnSwitchTab$lambda$6(r0);
    }

    public static /* synthetic */ Unit Wo(CameraCaptureViewModel r0, boolean r1) {
        return openAlbum$lambda$10(r0, r1);
    }

    static {
        Companion = new Companion();
        ArrayList r0 = new ArrayList();
        r0.add(2131242193);
        r0.add(2131242194);
        r0.add(2131242195);
        flashResource = r0;
        ArrayList r1 = new ArrayList();
        r1.add(2131241094);
        r1.add(2131241095);
        flashLightResource = r1;
    }

    private final void initCameraStatus() {
        List<String> r0 = fx8.a.a;
        if (fx8.a.e.contains(getCameraData().getCaptureMode()) == true) goto L5;
        return;
    L5:
        if (getCameraData().getUseFontCamera() == ability().g()) goto L9;
        switchCamera();
        return;
    }

    public final void checkCameraPermission() {
        com.larus.camera.impl.starter.a.a.getClass();
        if (com.larus.camera.impl.starter.a.d(new String[]{"android.permission.CAMERA"}) == false) goto L5;
        return;
    L5:
        FLogger.a.e("CameraCaptureFragment", "no has camera permission");
        ability().closePage();
    }

    public final Flow<String> getCaptureModeStatus() {
        return (Flow) this.captureModeStatus$delegate.getValue();
    }

    public final void initFlashStatus() {
        int r1 = getFlashResourceByMode("FLASH_MODE_OFF");
        ability().j("FLASH_MODE_OFF");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02312(this, r1, null), 3, null);
    }

    @Override // com.larus.camera.impl.ui.base.BaseCameraViewModel
    public String invokeClickFrom() {
        if (((Boolean) this.multiCaptureStatusHolder.a.getValue()).booleanValue() == false) goto L7;
        return "camera_input_left_icon";
    L7:
        if (Intrinsics.areEqual(getCameraData().getScene(), "inject_input_photo_picker") == false) goto L10;
        return "album_input_left_icon";
    L10:
        return null;
    }

    public final boolean isCurrentInRecording() {
        if ((this._recordingState.getValue() instanceof px8.d.C0130d) == false) goto L5;
    L16:
        return true;
    L5:
        if ((this._recordingState.getValue() instanceof px8.d.e) == true) goto L16;
        if ((this._recordingState.getValue() instanceof px8.d.b) == true) goto L16;
        if ((this._recordingState.getValue() instanceof px8.d.c) == true) goto L16;
        if ((this._recordingState.getValue() instanceof px8.d.a) == false) goto L15;
        Object r0 = this._recordingState.getValue();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.larus.camera.impl.entity.RecordControlUIState.Capturing");
        if (((px8.d.a) r0).a == true) goto L16;
    L15:
        return false;
    }

    public final i1<Boolean> multiCaptureStatusFlow() {
        return this.multiCaptureStatusHolder.b;
    }

    public final void recycleDownEvent() {
        MotionEvent r0 = this.downEvent;
        if (r0 == null) goto L5;
        r0.recycle();
    L5:
        this.downEvent = null;
    }

    public final void switchFlashLight() {
        List<Integer> r0 = flashLightResource;
        int r1 = ((Number) ListProtector.get(r0, (r0.indexOf(this.flashLightStatus.getValue()) + 1) % r0.size())).intValue();
        if (r1 != 2131241095) goto L5;
        String r2 = "FLASH_MODE_TORCH";
    L6:
        ability().j(r2);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02371(this, r1, null), 3, null);
        return;
    L5:
        r2 = getCameraData().getFlashMode();
        goto L6
    }

    public final void switchFlashStatus() {
        List<Integer> r0 = flashResource;
        int r1 = ((Number) ListProtector.get(r0, (r0.indexOf(this.flashStatus.getValue()) + 1) % r0.size())).intValue();
        if (r1 != 2131242193) goto L6;
        String r2 = "FLASH_MODE_AUTO";
    L9:
        ability().j(r2);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02381(this, r1, null), 3, null);
        return;
    L6:
        if (r1 != 2131242194) goto L8;
        r2 = "FLASH_MODE_OFF";
        goto L9
    L8:
        r2 = "FLASH_MODE_ON";
        goto L9
    }

    public CameraCaptureViewModel() {
        this.shouldHandleResult = true;
        StateFlowImpl r1 = j1.a(ListProtector.get(flashResource, 0));
        this._flashStatus = r1;
        StateFlowImpl r4 = j1.a(ListProtector.get(flashLightResource, 0));
        this._flashLightStatus = r4;
        StateFlowImpl r5 = j1.a(0);
        this._scaleLengthStatus = r5;
        StateFlowImpl r3 = j1.a(TuplesKt.to(0, 0));
        this._surfaceFlingAction = r3;
        ChangeState r7 = ChangeState.DEFAULT;
        StateFlowImpl r6 = j1.a(new n0(r7.getState(), System.currentTimeMillis()));
        this._tryChangeAlbumThumbListState = r6;
        StateFlowImpl r8 = j1.a(Integer.valueOf(r7.getState()));
        this._albumThumbListStateChanged = r8;
        StateFlowImpl r9 = j1.a(new px8.d.a(false));
        this._recordingState = r9;
        this.recordingState = kotlinx.coroutines.flow.e.b(r9);
        MutableSharedFlow<MotionEvent> r0 = SharedFlowKt.MutableSharedFlow$default(0, 1, null, 4, null);
        this._captureButtonTouchEvent = r0;
        this.captureButtonTouchEvent = r0;
        this.flashStatus = kotlinx.coroutines.flow.e.b(r1);
        this.flashLightStatus = kotlinx.coroutines.flow.e.b(r4);
        this.scaleLengthStatus = kotlinx.coroutines.flow.e.b(r5);
        this.captureModeStatus$delegate = LazyKt.lazy(new com.larus.camera.impl.ui.viewmodel.e(this));
        this.surfaceFlingAction = kotlinx.coroutines.flow.e.b(r3);
        this.tryChangeAlbumThumbListState = kotlinx.coroutines.flow.e.b(r6);
        this.albumThumbListStateChanged = kotlinx.coroutines.flow.e.b(r8);
        this.enableEffectOpt = z2.a.enableCameraEffectOpt();
        this.startRecordTime = -1;
        this.multiCaptureStatusHolder = new com.larus.camera.impl.utils.g0(Boolean.FALSE);
    }

    private final void clearScaleLength() {
        ability().d(0.0f);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02281(this, null), 3, null);
    }

    private final boolean hasOpenFlashLight() {
        return Intrinsics.areEqual(ability().getFlashMode(), "FLASH_MODE_TORCH");
    }

    private final boolean isLaunchedFromResultPage() {
        Bundle r0 = ability().B();
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.getBoolean("EXTRA_LAUNCHED_FROM_RESULT", false);
    }

    private final void mobEnterCameraMultiCapturePage() {
        ability().o0(getCameraData().getSwitchTab(), getCameraData().getCaptureMode());
    }

    public final void captureCurrentFrame() {
        ability().s0();
    }

    public final void clickAlbumPhotoOnCapturePage() {
        ability().o(getCurrentCaptureMode());
    }

    public final void clickCaptureOnCapturePage() {
        ability().z0(getCurrentCaptureMode());
    }

    public final void clickFlashOnCapturePage() {
        ability().C0(getCurrentCaptureMode());
    }

    public final void clickFocusOnCapturePage() {
        ability().c(getCurrentCaptureMode());
    }

    public final void clickTorchOnCapturePage() {
        ability().N(getCameraData().getCaptureMode());
    }

    public final void closePage() {
        ability().closePage();
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
    public final void enterRecorder() {
        ability().A0();
        qx8.a r0 = qx8.a.b;
        r0.getClass();
        FLogger.a.i("CameraMonitor", "[onEnterRecord]");
        gx8.b r1 = r0.a;
        CameraEvent r2 = CameraEvent.START_RECORD;
        JSONObject r3 = new JSONObject();
        r3.put("enable_audio", qx8.a.h ? 1 : 0);
        Unit r4 = Unit.INSTANCE;
        r1.a(r2, r3);
    }

    public final void finishAfterAlbumSend() {
        ability().i();
        ability().setResult(100000, new Intent().putExtra("EXTRA_RESULT_REASON_SEND", true));
        ability().closePage();
    }

    public final int getBottomAlbumMaxCount() {
        return ability().u0();
    }

    public final List<CaptureMode> getCaptureModeList() {
        return getCameraData().getCaptureModeList();
    }

    public final String getCurrentCaptureMode() {
        return getCameraData().getCaptureMode();
    }

    public final Fragment getCurrentFragment() {
        return ability().getCurrentFragment();
    }

    public final String getFlashMode() {
        return ability().getFlashMode();
    }

    public final int getRenderFps() {
        return ability().getRenderFps();
    }

    public final xx8.c getZoomService() {
        return ability().W();
    }

    public final CaptureMode initCaptureMode() {
        List<CaptureMode> r0 = getCaptureModeList();
        CaptureMode.Companion.getClass();
        Object r4 = null;
        CaptureMode r1 = CaptureMode.copy$default(CaptureMode.access$getDEFAULT$cp(), getCameraData().getCaptureMode(), null, 2, null);
        if (r0.isEmpty() == false) goto L14;
        Iterator<T> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        Object r3 = r2.next();
        if (Intrinsics.areEqual(((CaptureMode) r3).getMode(), r1.getMode()) == false) goto L6;
        r4 = r3;
    L10:
        CaptureMode r5 = (CaptureMode) r4;
        if (r5 == null) goto L14;
        r1 = r5;
    L14:
        switchCaptureMode(r1);
        return r1;
    }

    public final boolean isFrontCamera() {
        return ability().g();
    }

    public final boolean isSupportMultiPick() {
        return ability().t();
    }

    public final void leaveCapturePageOnCapture() {
        ability().m0(getCameraData().getSwitchTab(), getCurrentCaptureMode());
    }

    public final void leaveCapturePageOnClose() {
        ability().H0(getCameraData().getSwitchTab(), getCurrentCaptureMode());
    }

    public final void leaveCapturePageOnSwitch() {
        ability().I0(getCurrentCaptureMode());
    }

    @Override // com.larus.camera.impl.ui.base.BaseCameraViewModel
    public void onInitialized() {
        super.onInitialized();
        Bundle r0 = ability().B();
        if (r0 == null) goto L5;
        boolean r1 = r0.getBoolean("SHOW_BOTTOM_ALBUM");
    L6:
        this.showBottomAlbum = r1;
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void resetCamera() {
        initCameraStatus();
        initFlashStatus();
        clearScaleLength();
    }

    public final void resetEnterCapturePageTimer() {
        ability().C();
    }

    public final String returnExistingAlbumNodeId() {
        if (uy8.b.c() == true) goto L5;
        return null;
    L5:
        String r0 = getCameraData().getReturnAlbumNodeId();
        if (kq9.b.c(r0) == true) goto L8;
        return null;
    L8:
        return r0;
    }

    public final boolean shouldReturnToExistingAlbum() {
        if (returnExistingAlbumNodeId() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void switchCamera() {
        ability().switchCamera();
        List<String> r0 = fx8.a.a;
        if (fx8.a.e.contains(getCameraData().getCaptureMode()) == false) goto L5;
        initFlashStatus();
    L5:
        clearScaleLength();
    }

    public final void updateCameraDataOnSwitchTab() {
        ability().l0(new com.larus.camera.impl.ui.viewmodel.a());
    }

    public final i1<Integer> getAlbumThumbListStateChanged() {
        return this.albumThumbListStateChanged;
    }

    public final Flow<MotionEvent> getCaptureButtonTouchEvent() {
        return this.captureButtonTouchEvent;
    }

    public final MotionEvent getDownEvent() {
        return this.downEvent;
    }

    public final i1<Integer> getFlashLightStatus() {
        return this.flashLightStatus;
    }

    public final i1<Integer> getFlashStatus() {
        return this.flashStatus;
    }

    public final i1<px8.d> getRecordingState() {
        return this.recordingState;
    }

    public final i1<Integer> getScaleLengthStatus() {
        return this.scaleLengthStatus;
    }

    public final boolean getShowBottomAlbum() {
        return this.showBottomAlbum;
    }

    public final i1<Pair<Integer, Integer>> getSurfaceFlingAction() {
        return this.surfaceFlingAction;
    }

    public final i1<n0> getTryChangeAlbumThumbListState() {
        return this.tryChangeAlbumThumbListState;
    }

    public static final /* synthetic */ q0 access$ability(CameraCaptureViewModel r0) {
        return r0.ability();
    }

    public static final /* synthetic */ long access$getStartRecordTime$p(CameraCaptureViewModel r2) {
        return r2.startRecordTime;
    }

    public static final /* synthetic */ z0 access$get_albumThumbListStateChanged$p(CameraCaptureViewModel r0) {
        return r0._albumThumbListStateChanged;
    }

    public static final /* synthetic */ z0 access$get_flashLightStatus$p(CameraCaptureViewModel r0) {
        return r0._flashLightStatus;
    }

    public static final /* synthetic */ z0 access$get_flashStatus$p(CameraCaptureViewModel r0) {
        return r0._flashStatus;
    }

    public static final /* synthetic */ z0 access$get_scaleLengthStatus$p(CameraCaptureViewModel r0) {
        return r0._scaleLengthStatus;
    }

    public static final /* synthetic */ z0 access$get_surfaceFlingAction$p(CameraCaptureViewModel r0) {
        return r0._surfaceFlingAction;
    }

    public static final /* synthetic */ z0 access$get_tryChangeAlbumThumbListState$p(CameraCaptureViewModel r0) {
        return r0._tryChangeAlbumThumbListState;
    }

    public static final /* synthetic */ boolean access$hasOpenFlashLight(CameraCaptureViewModel r0) {
        return r0.hasOpenFlashLight();
    }

    public static final /* synthetic */ boolean access$isLaunchedFromResultPage(CameraCaptureViewModel r0) {
        return r0.isLaunchedFromResultPage();
    }

    private static final Flow captureModeStatus_delegate$lambda$2(CameraCaptureViewModel r2) {
        final Flow r3 = FlowKt__DistinctKt.a(r2.getCameraDataFlow(), new com.larus.camera.impl.ui.viewmodel.f(), FlowKt__DistinctKt.b);
        return new CameraCaptureViewModel$captureModeStatus_delegate$lambda$2$$inlined$map$1(r3);
    }

    private static final String captureModeStatus_delegate$lambda$2$lambda$0(CameraData r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return r1.getCaptureMode();
    }

    private static final Unit createGestureDetector$lambda$13(MotionEvent r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return Unit.INSTANCE;
    }

    private final d createScanCallback(Context r2) {
        return new d(this, r2);
    }

    private final void finishWith(ActivityResult r3) {
        q0 r0 = ability();
        int r1 = r3.getResultCode();
        Intent r4 = r3.getData();
        if (r4 != null) goto L5;
        r4 = new Intent();
    L5:
        r0.setResult(r1, r4);
        ability().closePage();
    }

    private final int getFlashResourceByMode(String r2) {
        if (Intrinsics.areEqual(r2, "FLASH_MODE_ON") == false) goto L6;
        return ((Number) ListProtector.get(flashResource, 2)).intValue();
    L6:
        if (Intrinsics.areEqual(r2, "FLASH_MODE_OFF") == false) goto L9;
        return ((Number) ListProtector.get(flashResource, 1)).intValue();
    L9:
        return ((Number) ListProtector.get(flashResource, 0)).intValue();
    }

    private final List<OutputParam> mergeInitialOutput(List<OutputParam> r5) {
        if (getCameraData().getResultRoute() != null) goto L18;
        Bundle r0 = ability().B();
        List<OutputParam> r1 = null;
        if (r0 == null) goto L7;
        Serializable r2 = r0.getSerializable("CAMERA_INPUT_PARAM");
    L9:
        if ((r2 instanceof InputParam) == false) goto L11;
        InputParam r3 = (InputParam) r2;
    L12:
        if (r3 == null) goto L16;
        CameraOutputContext r4 = r3.getInitialOutputContext();
        if (r4 == null) goto L16;
        r1 = r4.getOutputParamList();
    L16:
        if (r1 != null) goto L19;
        r1 = CollectionsKt.emptyList();
    L19:
        List r6 = CollectionsKt.createListBuilder();
        r6.addAll(r1);
        r6.addAll(r5);
        List r7 = CollectionsKt.filterNotNull(CollectionsKt.build(r6));
        t r8 = t.a;
        HashSet r9 = new HashSet();
        ArrayList r10 = new ArrayList();
        Iterator r11 = r7.iterator();
    L21:
        if (r11.hasNext() == false) goto L25;
        Object r12 = r11.next();
        if (r9.add(t.g((OutputParam) r12)) == false) goto L21;
        r10.add(r12);
        goto L21
    L25:
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator r14 = r10.iterator();
    L27:
        if (r14.hasNext() == false) goto L30;
        r13.add((OutputParam) r14.next());
        goto L27
    L30:
        return CollectionsKt.toMutableList(r13);
    L11:
        r3 = null;
        goto L12
    L7:
        r2 = null;
        goto L9
    L18:
        r1 = CollectionsKt.emptyList();
        goto L19
    }

    private final void processCameraResultCallback(ActivityResult r3) {
        int r0 = r3.getResultCode();
        if (r0 == (-1)) goto L30;
        if (r0 != 0) goto L6;
        com.larus.camera.impl.utils.g0<Boolean> r4 = this.multiCaptureStatusHolder;
        r4.a.setValue(Boolean.FALSE);
        t r5 = t.a;
        t.h();
        return;
    L6:
        if (r0 != 200000) goto L8;
        Intent r6 = r3.getData();
        CameraOutputContext r1 = null;
        if (r6 == null) goto L24;
        Serializable r7 = r6.getSerializableExtra("CAMERA_OUTPUT_CONTEXT");
    L26:
        if ((r7 instanceof CameraOutputContext) == false) goto L28;
        r1 = (CameraOutputContext) r7;
    L28:
        finish(r1);
        return;
    L24:
        r7 = null;
        goto L26
    L8:
        if (r0 != 400000) goto L10;
        com.larus.camera.impl.utils.g0<Boolean> r8 = this.multiCaptureStatusHolder;
        r8.a.setValue(Boolean.TRUE);
        mobEnterCameraMultiCapturePage();
        WeakReference<com.larus.platform.api.a0> r9 = com.larus.camera.impl.utils.album.m.a;
        Intrinsics.checkNotNullParameter(this, "viewModel");
        int r10 = getBottomAlbumMaxCount();
        Fragment r2 = getCurrentFragment();
        if (r2 == null) goto L33;
        FragmentManager r11 = r2.getChildFragmentManager();
        if (r11 == null) goto L39;
        com.larus.platform.api.a0 r12 = com.larus.camera.impl.utils.album.m.a(r11);
        if (r12 == null) goto L34;
        r12.Nu(r10);
        return;
    L34:
        return;
    L39:
        return;
    L33:
        return;
    L10:
        if (r0 != 500000) goto L38;
        ability().i();
        ability().closePage();
        return;
    L38:
        return;
    L30:
        finishWith(r3);
    }

    private final boolean returnCapturedDeltaToOwner(List<OutputParam> r5) {
        CameraResultRoute r0 = getCameraData().getResultRoute();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.getDelivery() == CameraResultRoute.Delivery.PREVIEW_CAPTURE_APPEND) goto L8;
    L12:
        return false;
    L8:
        if (StringsKt.isBlank(r0.getOwnerNodeId()) == true) goto L12;
        CameraOutputContext r1 = new CameraOutputContext();
        r1.setOutputParamList(CollectionsKt.toMutableList(r5));
        r1.setResultRoute(r0);
        finish(r1);
        return true;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.camera.impl.ui.viewmodel.d] */
    private final void scanResultHandle(final String r4) {
        if (fx8.a.b.contains(getCurrentCaptureMode()) == true) goto L6;
        return;
    L6:
        if (this.shouldHandleResult == true) goto L8;
        return;
    L8:
        this.shouldHandleResult = false;
        if (AppHost.a.isTestChannel() == false) goto L11;
    L17:
        com.larus.platform.service.g0 r0 = com.larus.platform.service.g0.a;
        if (r4 != null) goto L20;
        String r1 = "";
    L21:
        r0.q(r1, new com.larus.camera.impl.ui.viewmodel.d(this, r4));
        return;
    L20:
        r1 = r4;
        goto L21
    L11:
        if (com.larus.platform.service.s.a.h() == true) goto L17;
        CameraScanLogic.a.getClass();
        if (CameraScanLogic.a(r4) == false) goto L16;
        ability().closePage();
        return;
    L16:
        this.shouldHandleResult = true;
    }

    private static final CameraData updateCameraDataOnSwitchTab$lambda$6(CameraData r42) {
        Intrinsics.checkNotNullParameter(r42, "$this$updateCameraData");
        return CameraData.copy$default(r42, null, null, null, null, false, null, true, null, null, null, null, null, null, false, 0, 0, 0, false, 0, false, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, false, false, false, -65, 63, null);
    }

    public final Job albumThumbListStateChanged(ChangeState r8) {
        Intrinsics.checkNotNullParameter(r8, "changeState");
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r8, null), 3, null);
    }

    public final boolean checkAlbumPermission(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return ability().B0(r2);
    }

    public final void clickRecordOnCapturePage(String r3) {
        Intrinsics.checkNotNullParameter(r3, "button");
        ability().T(getCameraData().getCaptureMode(), r3);
    }

    public final void clickSwitchTabOnCapturePage(String r3) {
        Intrinsics.checkNotNullParameter(r3, "toCaptureMode");
        ability().Y(getCurrentCaptureMode(), r3);
    }

    public final void enterCapturePage(String r3) {
        Intrinsics.checkNotNullParameter(r3, "mode");
        ability().o0(getCameraData().getSwitchTab(), r3);
    }

    public final void finish(CameraOutputContext r7) {
        ability().i();
        FragmentActivity r0 = null;
        if (r7 == null) goto L24;
        List<OutputParam> r1 = r7.getOutputParamList();
        if (r1 == null) goto L24;
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L24;
        OutputParam r3 = (OutputParam) r2.next();
        if (r3 == null) goto L22;
        HashMap<String, String> r4 = r3.getExt();
        if (r4 == null) goto L22;
        ICameraEventExt r5 = getCameraData().getEventExt();
        if (r5 == null) goto L16;
        String r6 = r5.getClickFrom();
    L18:
        if (Intrinsics.areEqual(r6, "one_more_qa_take_photos") == false) goto L20;
        String r8 = "1";
    L21:
        String r9 = r4.put("is_from_edu_continue_shot", r8);
        goto L22
    L20:
        r8 = TriggerSendLoading.NO_LOADING;
        goto L21
    L16:
        r6 = null;
    L22:
        if (r3 == null) goto L8;
        r3.setLeavingMode(getCameraData().getCaptureMode());
    L24:
        if (r7 == null) goto L32;
        com.larus.camera.impl.result.a r10 = com.larus.camera.impl.result.a.a;
        Fragment r11 = ability().getCurrentFragment();
        if (r11 == null) goto L28;
        r0 = r11.getActivity();
    L28:
        r10.getClass();
        if (com.larus.camera.impl.result.a.a(r0, r7) == false) goto L32;
        ability().closePage();
        return;
    L32:
        Intent r12 = new Intent();
        r12.putExtra("CAMERA_OUTPUT_CONTEXT", r7);
        ability().setResult(100000, r12);
        ability().closePage();
    }

    public final int getIconPadding(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (ability().B0(r2) == true) goto L5;
    L7:
        return 0;
    L5:
        if (Intrinsics.areEqual(CameraServiceDiffContract.b.isHideAlbumCover(), Boolean.TRUE) == true) goto L7;
        return c7.b(1);
    }

    public final void leaveCapturePage(String r4) {
        Intrinsics.checkNotNullParameter(r4, "leaveReason");
        ability().w0(getCameraData().getSwitchTab(), getCurrentCaptureMode(), r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.larus.camera.impl.ui.viewmodel.b] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.larus.camera.impl.ui.viewmodel.c] */
    public final void openAlbum(Context r11) {
        Intrinsics.checkNotNullParameter(r11, "context");
        ability().L(getCurrentCaptureMode());
        String r0 = returnExistingAlbumNodeId();
        if (r0 == null) goto L6;
        CameraOutputContext r12 = new CameraOutputContext();
        OutputParam r2 = new OutputParam();
        r2.getExt().put("CAMERA_RETURN_ALBUM_NODE_ID", r0);
        Unit r1 = Unit.INSTANCE;
        r12.setOutputParamList(CollectionsKt.mutableListOf(new OutputParam[]{r2}));
        finish(r12);
        return;
    L6:
        final boolean r13 = !ability().B0(r11);
        if (r13 == false) goto L9;
        ability().b(getCurrentCaptureMode());
    L9:
        FLogger.a.i(TAG, "[openAlbum] noPermission:" + r13);
        q0 r3 = ability();
        int r4 = com.larus.camera.impl.utils.r.j;
        String r6 = com.larus.camera.impl.utils.r.a.a(getCurrentCaptureMode());
        r3.d0(zx8.b.b(), Integer.valueOf(getCameraData().getAlbumLandingTabIndex()), r6, getCameraData().getAlbumSupportOriginalImage(), new com.larus.camera.impl.ui.viewmodel.b(this, r13), new com.larus.camera.impl.ui.viewmodel.c(r13, this));
    }

    public final boolean openResultPageWhenCaptureAgainBack(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        t r0 = t.a;
        OutputParam r1 = (OutputParam) CollectionsKt.lastOrNull(t.f());
        if (r1 != null) goto L6;
        FLogger.a.e(TAG, "openResultPageWhenCaptureAgainBack outputParam is null");
        com.larus.camera.impl.utils.g0<Boolean> r8 = this.multiCaptureStatusHolder;
        Boolean r2 = Boolean.FALSE;
        r8.a.setValue(r2);
        return false;
    L6:
        OutputParam r3 = r1.clone();
        r3.getImageParam().setBitmap(null);
        updateToResultPageConfig(null);
        openResultPageWithSingleResult(r7, r3, r3.getImageParam().getRotation(), false, null);
        return true;
    }

    public final void pendingDownEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        this.downEvent = r2;
    }

    public final void postCaptureButtonTouchEvent(MotionEvent r2) {
        if (r2 == null) goto L5;
        this._captureButtonTouchEvent.tryEmit(r2);
        return;
    }

    public final void setDownEvent(MotionEvent r1) {
        this.downEvent = r1;
    }

    public final void setShowBottomAlbum(boolean r1) {
        this.showBottomAlbum = r1;
    }

    public final void startRecord(boolean r3) {
        ability().G0(r3, new i(this));
    }

    public final void switchCaptureMode(CaptureMode r8) {
        Intrinsics.checkNotNullParameter(r8, "captureMode");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02361(this, r8, null), 3, null);
    }

    public final void tryChangeAlbumThumbListState(boolean r10) {
        if (r10 == false) goto L5;
        int r11 = ChangeState.SHOW.getState();
    L6:
        n0 r0 = new n0(r11, System.currentTimeMillis());
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02391(this, r0, null), 3, null);
        return;
    L5:
        r11 = ChangeState.HIDE.getState();
        goto L6
    }

    public final void updateMultiPickConfig(String r5) {
        Intrinsics.checkNotNullParameter(r5, "captureMode");
        ability().F(r5);
        WeakReference<com.larus.platform.api.a0> r6 = com.larus.camera.impl.utils.album.m.a;
        Intrinsics.checkNotNullParameter(this, "viewModel");
        Fragment r7 = getCurrentFragment();
        if (r7 == null) goto L14;
        FragmentManager r8 = r7.getChildFragmentManager();
        if (r8 == null) goto L16;
        boolean r0 = isSupportMultiPick();
        FLogger.a.i("ShowBottomPhotoPickerPageManager", "updateBottomAlbumMultiPick current:" + com.larus.camera.impl.utils.album.m.c + ", supportMultiPick=" + r0);
        if (com.larus.camera.impl.utils.album.m.c == r0) goto L17;
        com.larus.camera.impl.utils.album.m.c = r0;
        com.larus.platform.api.a0 r9 = com.larus.camera.impl.utils.album.m.a(r8);
        if (r9 == null) goto L15;
        r9.BA(!r0);
        return;
    L15:
        return;
    L17:
        return;
    L16:
        return;
    }

    public final void updatePageStyle(boolean r2) {
        ability().R(r2);
    }

    public final void updateRecordingState(px8.d r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this._recordingState.tryEmit(r2);
    }

    public final void updateToResultPageConfig(String r2) {
        this.toResultConfig = new p0(r2);
    }

    public final void zoom(double r2) {
        ability().d((float) r2);
    }

    public final void zoomByValue(float r2) {
        ability().h(r2);
    }

    public static final /* synthetic */ List access$mergeInitialOutput(CameraCaptureViewModel r0, List r1) {
        return r0.mergeInitialOutput(r1);
    }

    public static final /* synthetic */ void access$processCameraResultCallback(CameraCaptureViewModel r0, ActivityResult r1) {
        r0.processCameraResultCallback(r1);
    }

    public static final /* synthetic */ boolean access$returnCapturedDeltaToOwner(CameraCaptureViewModel r0, List r1) {
        return r0.returnCapturedDeltaToOwner(r1);
    }

    public static final /* synthetic */ void access$setShouldHandleResult$p(CameraCaptureViewModel r0, boolean r1) {
        r0.shouldHandleResult = r1;
    }

    public static final /* synthetic */ void access$setStartRecordTime$p(CameraCaptureViewModel r0, long r1) {
        r0.startRecordTime = r1;
    }

    private static final Unit createGestureDetector$lambda$14(float r0, float r1) {
        return Unit.INSTANCE;
    }

    private final c createGestureListener(Function1<? super MotionEvent, Unit> r2, Function2<? super Float, ? super Float, Unit> r3) {
        return new c(r2, r3);
    }

    private final OutputParam createOutputParam(OutputParam.ResultType r5, VeCameraOutputParam r6) {
        OutputParam r0 = new OutputParam();
        r0.setCamera("CAMERA_VE");
        r0.setFromScene(getCameraData().getScene());
        r0.setResultType(r5);
        if (r6 != null) goto L5;
    L8:
        ICameraEventExt r7 = getCameraData().getEventExt();
        if (r7 == null) goto L21;
        JSONObject r8 = r7.getExtraParams();
        if (r8 == null) goto L21;
        Iterator<String> r9 = r8.keys();
    L14:
        if (r9.hasNext() == false) goto L21;
        String r1 = r9.next();
        Object r2 = r8.opt(r1);
        if ((r2 instanceof String) == false) goto L18;
        String r3 = (String) r2;
    L19:
        if (r3 == null) goto L14;
        r0.getExt().put(r1, r3);
        goto L14
    L18:
        r3 = null;
    L21:
        return r0;
    L5:
        if (r5 != OutputParam.ResultType.VIDEO) goto L7;
        VideoParam r10 = new VideoParam();
        r10.setPath(r6.getPath());
        r10.setWidth(r6.getWidth());
        r10.setHeight(r6.getHeight());
        r0.setVideoParam(r10);
        goto L8
    L7:
        ImageParam r11 = new ImageParam();
        r11.setPath(r6.getPath());
        r11.setWidth(r6.getWidth());
        r11.setHeight(r6.getHeight());
        r11.setSize(r6.getSize());
        r0.setImageParam(r11);
        goto L8
    }

    private static final Unit openAlbum$lambda$10(CameraCaptureViewModel r3, boolean r4) {
        r3.ability().K0(r3.ability().y0().getSwitchTab(), r3.getCurrentCaptureMode());
        if (r4 == false) goto L6;
        r3.ability().I(r3.getCurrentCaptureMode());
        r3.updateLatestPhotoChanged(System.currentTimeMillis());
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit openAlbum$lambda$11(boolean r0, CameraCaptureViewModel r1) {
        if (r0 == false) goto L5;
        r1.ability().K(r1.getCurrentCaptureMode());
    L5:
        return Unit.INSTANCE;
    }

    public final void checkupDarkMode(Function0<Unit> r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "onDark");
        Intrinsics.checkNotNullParameter(r4, "onLight");
        ability().f(new b(this, r3, r4));
    }

    public final void clickCameraButtonOnCapturePage(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "buttonType");
        Intrinsics.checkNotNullParameter(r4, "switchMethod");
        ability().M(getCurrentCaptureMode(), r3, r4);
    }

    public final void clickUploadEntrance(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "clickFrom");
        Intrinsics.checkNotNullParameter(r4, "enterMethod");
        ability().J(getCurrentCaptureMode(), r3, r4);
    }

    public final Object getMaskBitmap(Context r4, Continuation<? super Bitmap> r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(this, r4, null), r5);
    }

    public final void handleScanResult(String r9, Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        CameraScanLogic.a.getClass();
        boolean r0 = false;
        if (r9 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        Uri r3 = null;
        if (r2 == true) goto L19;
        Object r4 = CameraScanLogic.c;
        monitor-enter(r4);
        CameraScanLogic.a r5 = CameraScanLogic.d;     // Catch: Throwable -> L54
        if (r5 == null) goto L17;
        CameraScanLogic.d = null;     // Catch: Throwable -> L54
    L17:
        monitor-exit(r4);
        if (r5 == null) goto L19;
        a4.a.getClass();
        a4.a(a4.b);
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L23
        r5.b.invoke(r9);     // Catch: Throwable -> L23
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L25:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L38;
        FLogger.a.e("CameraScanLogic", "host scanCode onResult failed", r8);
        Function1<String, Unit> r11 = r5.c;     // Catch: Throwable -> L33
        String r12 = r8.getMessage();     // Catch: Throwable -> L33
        if (r12 != null) goto L31;
        r12 = "scanCode callback error";
    L31:
        r11.invoke(r12);     // Catch: Throwable -> L33
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L33
    L35:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L38;
        FLogger.a.e("CameraScanLogic", "host scanCode onFailure failed", r14);
    L33:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
    L38:
        boolean r16 = true;
    L39:
        if (r16 == false) goto L42;
        FLogger.a.e(TAG, "createScanCallback host handle result");
        ability().closePage();
        return;
    L42:
        if (r9 == null) goto L44;
        r3 = y0.j(r9);
    L44:
        if (r3 != null) goto L46;
    L48:
        if (r0 == true) goto L50;
    L52:
        FLogger.a.e(TAG, "createScanCallback doubao handle result " + r9);
        scanResultHandle(r9);
        return;
    L50:
        if (h1.a.L(r9, r10) == false) goto L52;
        FLogger.a.e(TAG, "createScanCallback lark handle result " + r9);
        ability().closePage();
        return;
    L46:
        if (r3.isHierarchical() != true) goto L48;
        r0 = true;
    L23:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
    L54:
        th = move-exception;
        throw th;
    L19:
        r16 = false;
        goto L39
    L5:
        if (StringsKt.isBlank(r9) == true) goto L8;
        r2 = false;
        goto L9
    }

    public final void showCameraItemMobOnCapture(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "itemType");
        ability().p(r3, getCameraData().getCaptureMode(), r4);
    }

    public final void stopRecord(Context r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        ability().b0(new j(this, r4, r3));
    }

    public final Job updateOnSurfaceFling(float r7, float r8) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02401(this, r7, r8, null), 3, null);
    }

    public static final /* synthetic */ OutputParam access$createOutputParam(CameraCaptureViewModel r0, OutputParam.ResultType r1, VeCameraOutputParam r2) {
        return r0.createOutputParam(r1, r2);
    }

    private final void openResultPageWithMultiResult(Context r13, List<OutputParam> r14, Function3<? super List<OutputParam>, ? super Boolean, ? super Continuation<? super Boolean>, ? extends Object> r15) {
        FLogger.a.i(TAG, "openResultPageWithMultiResult size:" + r14.size());
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02331(this, r14, r15, r13, null), 3, null);
    }

    private static final Unit scanResultHandle$lambda$34(CameraCaptureViewModel r1, String r2, String r3) {
        if (r3 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == true) goto L12;
        r1.ability().closePage();
        return Unit.INSTANCE;
    L12:
        CameraScanLogic.a.getClass();
        if (CameraScanLogic.a(r2) == false) goto L15;
        r1.ability().closePage();
    L17:
        return Unit.INSTANCE;
    L15:
        r1.shouldHandleResult = true;
        goto L17
    L5:
        if (r3.length() == 0) goto L8;
        r4 = false;
        goto L9
    }

    public final GestureDetector createGestureDetector(Context r2, Function1<? super MotionEvent, Unit> r3, Function2<? super Float, ? super Float, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "onSingleTap");
        Intrinsics.checkNotNullParameter(r4, "onFling");
        return new GestureDetector(r2, createGestureListener(r3, r4));
    }

    public final void enterPage(String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "currentPage");
        Intrinsics.checkNotNullParameter(r4, "enterMethod");
        Intrinsics.checkNotNullParameter(r5, "previousPage");
        ability().q0(r3, getCurrentCaptureMode(), r4, r5);
    }

    public final void getAlbumCover(Context r11, Function2<? super Bitmap, ? super Boolean, Unit> r12, Function1<? super Integer, Unit> r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "setImageBitmap");
        Intrinsics.checkNotNullParameter(r13, "setImageResource");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02291(this, r11, r12, r13, null), 2, null);
    }

    public final void openCamera(SurfaceHolder r9, pq9.b r10, Context r11) {
        Intrinsics.checkNotNullParameter(r9, "surfaceHolder");
        Intrinsics.checkNotNullParameter(r11, "context");
        String r0 = getCurrentCaptureMode();
        boolean r7 = fx8.a.b.contains(r0);
        boolean r1 = fx8.a.c.contains(r0);
        FLogger.a.i(TAG, "enableEffectOpt:" + this.enableEffectOpt + ", mode:" + r0);
        if (this.enableEffectOpt == false) goto L7;
        if (r7 == false) goto L6;
        d r12 = createScanCallback(r11);
    L8:
        d r4 = r12;
    L10:
        if (this.enableEffectOpt == false) goto L17;
        if (r7 == true) goto L15;
        if (r1 == true) goto L15;
        boolean r13 = false;
    L16:
        Boolean r6 = Boolean.valueOf(r13);
    L18:
        ability().z(r9, r4, r10, r6, r7);
        return;
    L15:
        r13 = true;
        goto L16
    L17:
        r6 = null;
        goto L18
    L6:
        r4 = null;
        goto L10
    L7:
        r12 = createScanCallback(r11);
        goto L8
    }

    public final void openResultPageFromAlbum(Context r18, List<AlbumSelectItem> r19, Function3<? super List<OutputParam>, ? super Boolean, ? super Continuation<? super Boolean>, ? extends Object> r20) {
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r19, "resultList");
        Intrinsics.checkNotNullParameter(r20, "pageInterceptor");
        ArrayList r4 = new ArrayList();
        Iterator<T> r2 = r19.iterator();
        int r5 = 0;
    L4:
        if (r2.hasNext() == false) goto L42;
        Object r6 = r2.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        AlbumSelectItem r8 = (AlbumSelectItem) r6;
        Uri r9 = r8.a;
        ImFileUtil.a.getClass();
        if (ImFileUtil.y(r9) == false) goto L11;
        OutputParam.ResultType r10 = OutputParam.ResultType.VIDEO;
    L12:
        FLogger.a.i(TAG, "[openResultPageFromAlbum] index:" + r5 + ", uri:" + y0.k(r9));
        if (r9 == null) goto L41;
        String r11 = null;
        OutputParam r12 = createOutputParam(r10, null);
        r12.setSrcAlbumUri(r9.toString());
        r12.setFromAlbum(true);
        r12.setOriginalImageChecked(r8.g);
        if (r12.isVideo() == false) goto L18;
        VideoParam r13 = r12.getVideoParam();
        r13.setUri(r9.toString());
        r13.setWidth(r8.b);
        r13.setHeight(r8.c);
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new CameraCaptureViewModel$openResultPageFromAlbum$2$2(this, r18, r9, null), 2, null);
    L18:
        p0 r14 = this.toResultConfig;
        if (r14 == null) goto L21;
        r11 = r14.a;
    L21:
        if (r11 == null) goto L40;
        int r15 = r11.hashCode();
        if (r15 == (-1557522165)) goto L37;
        if (r15 == 705855376) goto L33;
        if (r15 != 1079682959) goto L40;
        if (r11.equals("camera_page_icon") == false) goto L40;
        r12.getExt().put("upload_file_click_from", "camera_page_icon");
        goto L40
    L33:
        if (r11.equals("camera_slide_album_click") == false) goto L40;
        r12.getExt().put("upload_file_click_from", "camera_slide_album_click");
        goto L40
    L37:
        if (r11.equals("camera_album_thumbnail_click") == false) goto L40;
        r12.getExt().put("upload_file_click_from", "camera_album_thumbnail_click");
    L40:
        r4.add(r12);
    L41:
        r5 = r7;
        goto L4
    L11:
        r10 = OutputParam.ResultType.PHOTO;
        goto L12
    L42:
        openResultPageWithMultiResult(r18, r4, r20);
    }

    private final void handleCameraResult(Context r9, VeCameraOutputParam r10, int r11, Function3<? super List<OutputParam>, ? super Boolean, ? super Continuation<? super Boolean>, ? extends Object> r12) {
        if (r10 != null) goto L6;
        finish(null);
        return;
    L6:
        OutputParam r4 = createOutputParam(OutputParam.ResultType.PHOTO, r10);
        com.larus.camera.impl.utils.y.b(r10.getPath());
        CameraData r1 = getCameraData();
        FLogger.a.i(TAG, "[handleCameraResult] enableResultDetect=" + enableResultDetect() + ", target=" + r1.getTarget() + ", scene=" + r1.getScene() + ", enableResultSuggestedAction=" + r1.getEnableResultSuggestedAction() + ", enableCaptureDetectModeList=" + r1.getEnableCaptureDetectModeList());
        if (enableResultDetect() == false) goto L9;
    L12:
        ability().H(r10.getPath(), r10.getPhotoBitmap());
        updateToResultPageConfig(null);
        openResultPageWithSingleResult(r9, r4, r11, false, r12);
        return;
    L9:
        if (Intrinsics.areEqual(getCameraData().getTarget(), "TARGET_SHOW_GET") == true) goto L12;
        CameraOutputContext r13 = new CameraOutputContext();
        r13.setOutputParamList(CollectionsKt.mutableListOf(new OutputParam[]{r4}));
        finish(r13);
    }

    public final void capturePhoto(Context r9, boolean r10, Function3<? super List<OutputParam>, ? super Boolean, ? super Continuation<? super Boolean>, ? extends Object> r11, String r12) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r11, "pageInterceptor");
        Intrinsics.checkNotNullParameter(r12, "from");
        FLogger.a.i(TAG, "call capturePhoto from:" + r12);
        int r13 = ((Number) getOnOrientationChanged().getValue()).intValue();
        ability().e(r13, new a(this, r9, r10, r13, r11));
    }

    public final void clickZoomOnCapturePage(String r8, String r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r8, "zoomButtonType");
        ability().j0(getCameraData().getCaptureMode(), r8, r9, r10, r11);
    }

    public final Object eduImageIdentifyCheck(Context r7, Uri r8, OutputParam r9, Continuation<? super Boolean> r10) {
        return Companion.a(ability(), r7, r8, r9.getPath(), r10);
    }

    public final void focusAtPoint(float r2, float r3, int r4, int r5) {
        ability().A((int) r2, (int) r3, r4, r5);
    }

    public final Object healthImageIdentifyCheck(Context r10, OutputParam r11, Uri r12, Continuation<? super Boolean> r13) {
        if ((r13 instanceof C02301) == false) goto L7;
        C02301 r0 = (C02301) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        Bitmap r15 = (Bitmap) r0.L$3;
        String r16 = (String) r0.L$2;
        OutputParam r17 = (OutputParam) r0.L$1;
        Context r18 = (Context) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L50:
        return r14;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        String r19 = (String) r0.L$2;
        r11 = (OutputParam) r0.L$1;
        Context r110 = (Context) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L36:
        Bitmap r111 = (Bitmap) r14;
    L37:
        r0.L$0 = r110;
        r0.L$1 = r11;
        r0.L$2 = r19;
        r0.L$3 = r111;
        r0.label = 3;
        kotlinx.coroutines.j r4 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r0), 1);
        r4.C();
        Ref.ObjectRef r5 = new Ref.ObjectRef();
        h r6 = new h(r4);
        r5.element = r6;
        if (r111 == null) goto L44;
        if (r19 == null) goto L44;
        if (Intrinsics.areEqual(r11.getExt().get("disable_text_check"), "1") == false) goto L43;
        String r112 = access$ability(this).y0().getCaptureMode();
        ((Function1) r5.element).invoke(Boxing.boxBoolean(true));
        r5.element = e.a;
        access$ability(this).m0(false, r112);
        access$ability(this).r0(1, r112);
    L45:
        r14 = r4.B();
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L48;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L48:
        if (r14 != r2) goto L50;
        return r2;
    L43:
        o3.b.f(r111, new f(r110, r5, this));
    L44:
        r6.invoke(Boxing.boxBoolean(false));
        r5.element = g.a;
        goto L45
    L17:
        r19 = (String) r0.L$2;
        r11 = (OutputParam) r0.L$1;
        r110 = (Context) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L24:
        r111 = (Bitmap) r14;
        goto L37
    L18:
        ResultKt.throwOnFailure(r14);
        if (r12 == null) goto L25;
        String r7 = r12.toString();
        CoroutineDispatcher r8 = Dispatchers.getIO();
        CameraCaptureViewModel$healthImageIdentifyCheck$originBitmap$1 r9 = new CameraCaptureViewModel$healthImageIdentifyCheck$originBitmap$1(this, r10, r12, null);
        r0.L$0 = r10;
        r0.L$1 = r11;
        r0.L$2 = r7;
        r0.label = 1;
        r14 = BuildersKt.withContext(r8, r9, r0);
        if (r14 != r2) goto L23;
        return r2;
    L23:
        r110 = r10;
        r19 = r7;
        goto L24
    L25:
        String r113 = r11.getPath();
        if (r113.length() <= 0) goto L28;
        boolean r20 = true;
    L29:
        if (r20 == true) goto L32;
        r113 = null;
    L32:
        CoroutineDispatcher r21 = Dispatchers.getIO();
        CameraCaptureViewModel$healthImageIdentifyCheck$originBitmap$3 r22 = new CameraCaptureViewModel$healthImageIdentifyCheck$originBitmap$3(r113, null);
        r0.L$0 = r10;
        r0.L$1 = r11;
        r0.L$2 = r113;
        r0.label = 2;
        r14 = BuildersKt.withContext(r21, r22, r0);
        if (r14 != r2) goto L35;
        return r2;
    L35:
        String r23 = r113;
        r110 = r10;
        r19 = r23;
        goto L36
    L28:
        r20 = false;
    L7:
        r0 = new C02301(this, r13);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00c0 -> B:49:0x01a9). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0157 -> B:45:0x0158). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x01ad -> B:51:0x01ae). Please report as a decompilation issue!!! */
    public final Object skipResultPageAndFinish(Context r19, List<OutputParam> r20, boolean r21, Continuation<? super Unit> r22) {
        if ((r22 instanceof C02351) == false) goto L7;
        C02351 r2 = (C02351) r22;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        Continuation r6 = null;
        int r7 = 1;
        String r8 = "ms";
        String r9 = TAG;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        long r10 = r2.J$0;
        Iterator r11 = (Iterator) r2.L$2;
        List<OutputParam> r12 = (List) r2.L$1;
        Context r13 = (Context) r2.L$0;
        ResultKt.throwOnFailure(r1);
        CameraCaptureViewModel r14 = this;
        Object r0 = r1;
    L45:
        String r15 = (String) r0;
        long r16 = System.currentTimeMillis();
        FLogger.a.i(r9, "Save photo cost " + (r16 - r10) + r8);
        OutputParam r17 = new OutputParam();
        r17.setFromScene(r14.getCameraData().getScene());
        ImageParam r18 = new ImageParam();
        if (r15 != null) goto L48;
        r15 = "";
    L48:
        r18.setPath(r15);
        r17.setImageParam(r18);
        r17.setResultType(OutputParam.ResultType.PHOTO);
        r17.setDataSource(1);
        CameraCaptureViewModel r110 = r14;
        String r111 = r9;
        String r23 = r8;
        Iterator r24 = r11;
        Object r25 = r4;
        C02351 r26 = r2;
        List<OutputParam> r27 = r12;
        Context r112 = r13;
        OutputParam r113 = r17;
        Context r28 = r112;
    L49:
        r27.add(r113);
    L51:
        r6 = null;
        r7 = 1;
    L22:
        if (r24.hasNext() == false) goto L52;
        OutputParam r114 = (OutputParam) r24.next();
        long r115 = System.currentTimeMillis();
        if (r114 == null) goto L51;
        String r116 = r114.getSrcAlbumUri();
        if (r116 == null) goto L51;
        Uri r117 = y0.j(r116);
        if (r117 == null) goto L51;
        ImFileUtil.a.getClass();
        if (ImFileUtil.y(r117) == false) goto L33;
        r113 = new OutputParam();
        r113.setFromScene(r110.getCameraData().getScene());
        VideoParam r118 = new VideoParam();
        r118.setPath(r117.toString());
        r113.setVideoParam(r118);
        r113.setResultType(OutputParam.ResultType.VIDEO);
        r113.setDataSource(r7);
        goto L49
    L33:
        CoroutineDispatcher r119 = Dispatchers.getIO();
        CameraCaptureViewModel$skipResultPageAndFinish$2$bitmap$1 r29 = new CameraCaptureViewModel$skipResultPageAndFinish$2$bitmap$1(r110, r28, r117, r6);
        r26.L$0 = r28;
        r26.L$1 = r27;
        r26.L$2 = r24;
        r26.J$0 = r115;
        r26.label = r7;
        Object r30 = BuildersKt.withContext(r119, r29, r26);
        if (r30 != r25) goto L36;
        return r25;
    L36:
        r12 = r27;
        r2 = r26;
        r4 = r25;
        r11 = r24;
        r8 = r23;
        r9 = r111;
        r13 = r28;
        r1 = r30;
        r14 = r110;
        long r120 = r115;
    L37:
        Bitmap r31 = (Bitmap) r1;
        if (r31 != null) goto L41;
        FLogger.a.e(r9, "Create bitmap failed");
        return Unit.INSTANCE;
    L41:
        long r121 = System.currentTimeMillis();
        FLogger.a.i(r9, "Create bitmap cost " + (r121 - r120) + r8);
        CoroutineDispatcher r32 = Dispatchers.getIO();
        CameraCaptureViewModel$skipResultPageAndFinish$2$filePath$1 r33 = new CameraCaptureViewModel$skipResultPageAndFinish$2$filePath$1(r14, r31, null);
        r2.L$0 = r13;
        r2.L$1 = r12;
        r2.L$2 = r11;
        r2.J$0 = r121;
        r2.label = 2;
        r0 = BuildersKt.withContext(r32, r33, r2);
        if (r0 != r4) goto L44;
        return r4;
    L44:
        r10 = r121;
        goto L45
    L52:
        CameraOutputContext r34 = new CameraOutputContext();
        r34.setOutputParamList(r27);
        r110.finish(r34);
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r120 = r2.J$0;
        r11 = (Iterator) r2.L$2;
        r12 = (List) r2.L$1;
        r13 = (Context) r2.L$0;
        ResultKt.throwOnFailure(r1);
        r14 = this;
        goto L37
    L16:
        ResultKt.throwOnFailure(r1);
        if (r21 == true) goto L20;
        CameraOutputContext r35 = new CameraOutputContext();
        r35.setOutputParamList(CollectionsKt.toMutableList(r20));
        finish(r35);
        return Unit.INSTANCE;
    L20:
        ArrayList r36 = new ArrayList();
        Iterator r37 = r20.iterator();
        r110 = this;
        r111 = TAG;
        r23 = "ms";
        r24 = r37;
        r25 = r4;
        r26 = r2;
        r27 = r36;
        r28 = r19;
    L7:
        r2 = new C02351(this, r22);
        goto L8
    }

    public static final /* synthetic */ void access$handleCameraResult(CameraCaptureViewModel r0, Context r1, VeCameraOutputParam r2, int r3, Function3 r4) {
        r0.handleCameraResult(r1, r2, r3, r4);
    }

    private final Intent createResultPageIntent(Context r51, CameraOutputContext r52, int r53, Uri r54, boolean r55) {
        Bundle r1 = ability().B();
        String r3 = null;
        if (r1 == null) goto L5;
        Serializable r2 = r1.getSerializable("CAMERA_INPUT_PARAM");
    L7:
        if ((r2 instanceof InputParam) == false) goto L9;
        InputParam r4 = (InputParam) r2;
    L10:
        Bundle r5 = ability().B();
        if (r5 == null) goto L13;
        String r6 = r5.getString("SUGGESTION_PREFIX");
    L15:
        if (r4 != null) goto L17;
    L19:
        boolean r7 = false;
    L20:
        if (r7 == true) goto L22;
    L27:
        CameraData r8 = getCameraData();
        ICameraEventExt r9 = r8.getEventExt();
        if (r9 == null) goto L30;
        ICameraEventExt r16 = r9.copy();
    L31:
        CameraData r10 = CameraData.copy$default(r8, null, null, null, null, false, null, false, r16, null, null, null, null, null, false, 0, 0, 0, false, 0, false, null, null, null, null, null, null, false, false, false, false, false, false, false, false, false, false, false, false, -129, 63, null);
        ICameraEventExt r11 = r10.getEventExt();
        if (r11 == null) goto L38;
        p0 r12 = this.toResultConfig;
        if (r12 == null) goto L36;
        String r13 = r12.a;
    L37:
        r11.setEnterPageEvent("camera", r13);
        goto L38
    L36:
        r13 = null;
    L38:
        FLogger.a.i(TAG, "[createResultPageIntent] nweCameraData: scene=" + r10.getScene() + ", captureMode=" + r10.getCaptureMode() + ", enableResultSuggestedAction=" + r10.getEnableResultSuggestedAction() + ", enableCaptureDetectModeList=" + r10.getEnableCaptureDetectModeList() + ", inputStyle=" + r10.getInputStyle() + ", target=" + r10.getTarget());
        Intent r14 = new Intent(r51, CameraResultActivity.class);
        r14.putExtra(CameraData.PARAM_CAMERA_DATA, r10);
        r14.putExtra("CAMERA_INPUT_PARAM", r4);
        r14.putExtra("CAMERA_OUTPUT_CONTEXT", r52);
        r14.putExtra("PREVIEW_PARAM_ORIENTATION", r53);
        if (r54 == null) goto L41;
        r3 = r54.toString();
    L41:
        if (r3 != null) goto L43;
        r3 = "";
    L43:
        r14.putExtra("PREVIEW_PARAM_ALBUM_URI", r3);
        r14.putExtra("PREVIEW_PARAM_MULTI_CAPTURE_MODE", ((Boolean) this.multiCaptureStatusHolder.a.getValue()).booleanValue());
        r14.putExtra("PREVIEW_PARAM_FROM_CAMERA_PAGE", true);
        if (r55 == false) goto L46;
    L52:
        if (r6 == null) goto L54;
        r14.putExtra("SUGGESTION_PREFIX", r6);
    L54:
        return r14;
    L46:
        if (r10.getEnableCameraResultUnifiedVisual() == false) goto L52;
        List<OutputParam> r15 = r52.getOutputParamList();
        if (r15 == null) goto L52;
        OutputParam r17 = (OutputParam) CollectionsKt.lastOrNull(r15);
        if (r17 == null) goto L52;
        t r18 = t.a;
        r14.putExtra("PREVIEW_PARAM_CAPTURE_OUTPUT_KEY", t.g(r17));
        goto L52
    L30:
        r16 = null;
        goto L31
    L22:
        if (r4.isFromChatAttachment() == false) goto L24;
        r4.setEnterMethod("attachment_preview_click");
        r4.setShowFrom("select_photo");
        goto L27
    L24:
        if (r55 == false) goto L26;
        r4.setEnterMethod("camera_album_icon_click");
        r4.setShowFrom("select_photo");
        goto L27
    L26:
        r4.setEnterMethod("complete_take_photo");
        r4.setShowFrom("take_photo");
        goto L27
    L17:
        if (r4.getSupportMark() != true) goto L19;
        r7 = true;
        goto L20
    L13:
        r6 = null;
        goto L15
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L7
    }

    private final void openResultPageWithSingleResult(Context r14, OutputParam r15, int r16, boolean r17, Function3<? super List<OutputParam>, ? super Boolean, ? super Continuation<? super Boolean>, ? extends Object> r18) {
        FLogger.a.i(TAG, "call openResultPage orientation:" + r16);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02341(this, r15, r18, r14, r16, r17, null), 3, null);
    }

    public static /* synthetic */ void showCameraItemMobOnCapture$default(CameraCaptureViewModel r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.showCameraItemMobOnCapture(r1, r2);
    }

    public static final /* synthetic */ Intent access$createResultPageIntent(CameraCaptureViewModel r0, Context r1, CameraOutputContext r2, int r3, Uri r4, boolean r5) {
        return r0.createResultPageIntent(r1, r2, r3, r4, r5);
    }

    public static final /* synthetic */ void access$openResultPageWithSingleResult(CameraCaptureViewModel r0, Context r1, OutputParam r2, int r3, boolean r4, Function3 r5) {
        r0.openResultPageWithSingleResult(r1, r2, r3, r4, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GestureDetector createGestureDetector$default(CameraCaptureViewModel r0, Context r1, Function1 r2, Function2 r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = new com.larus.camera.impl.ui.viewmodel.g();
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = new com.larus.camera.impl.ui.viewmodel.h();
    L9:
        return r0.createGestureDetector(r1, r2, r3);
    }

    public static /* synthetic */ void openCamera$default(CameraCaptureViewModel r0, SurfaceHolder r1, pq9.b r2, Context r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.openCamera(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void openResultPageFromAlbum$default(CameraCaptureViewModel r0, Context r1, List r2, Function3 r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = new C02321(null);
    L5:
        r0.openResultPageFromAlbum(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void openResultPageWithMultiResult$default(CameraCaptureViewModel r0, Context r1, List r2, Function3 r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.openResultPageWithMultiResult(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void capturePhoto$default(CameraCaptureViewModel r0, Context r1, boolean r2, Function3 r3, String r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = new C02271(null);
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = "capture";
    L8:
        r0.capturePhoto(r1, r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void openResultPageWithSingleResult$default(CameraCaptureViewModel r6, Context r7, OutputParam r8, int r9, boolean r10, Function3 r11, int r12, Object r13) {
        if ((r12 & 16) == 0) goto L5;
        r11 = null;
    L5:
        r6.openResultPageWithSingleResult(r7, r8, r9, r10, r11);
    }
}
