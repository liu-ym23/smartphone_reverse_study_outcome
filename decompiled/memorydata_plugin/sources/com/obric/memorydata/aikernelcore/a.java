package com.obric.memorydata.aikernelcore;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.Ensure;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.IAIKernelManager;
import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.runtime.AIInferRuntime;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import com.obric.aikernel.sdk.ext.BundleExtKt;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.aikernel.sdk.ext.ParamsKt;
import com.obric.aikernel.sdk.response.Response;
import com.obric.aikernel.sdk.response.ResponseKt;
import com.obric.memorydata.aikernelcore.utils.OcrErrorCode;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bp;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002£\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JZ\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00052\u0010\b\u0002\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010;2\u0010\b\u0002\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010;2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020AH\u0086@¢\u0006\u0002\u0010BJN\u0010C\u001a\u0002082\u0006\u00109\u001a\u00020\u00052\u0010\b\u0002\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010;2\u0010\b\u0002\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010;2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00052\u0006\u0010@\u001a\u00020AH\u0086@¢\u0006\u0002\u0010DJ*\u0010E\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050G0F2\b\u0010H\u001a\u0004\u0018\u00010\u0005H\u0086@¢\u0006\u0002\u0010IJ6\u0010J\u001a\u0004\u0018\u00010K2\u0006\u0010L\u001a\u00020\u00052\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010N\u001a\u00020A2\u0006\u0010O\u001a\u00020AH\u0086@¢\u0006\u0002\u0010PJ.\u0010Q\u001a\u0004\u0018\u00010K2\u0006\u0010L\u001a\u00020\u00052\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010N\u001a\u00020AH\u0082@¢\u0006\u0002\u0010RJ.\u0010S\u001a\u0004\u0018\u00010K2\u0006\u0010L\u001a\u00020\u00052\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010N\u001a\u00020AH\u0082@¢\u0006\u0002\u0010RJ@\u0010T\u001a\u0004\u0018\u00010K2\u0006\u0010U\u001a\u00020V2\b\u0010W\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010N\u001a\u00020A2\u0006\u0010O\u001a\u00020AH\u0086@¢\u0006\u0002\u0010XJ8\u0010Y\u001a\u0004\u0018\u00010K2\u0006\u0010U\u001a\u00020V2\b\u0010W\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010N\u001a\u00020AH\u0082@¢\u0006\u0002\u0010ZJ8\u0010[\u001a\u0004\u0018\u00010K2\u0006\u0010U\u001a\u00020V2\b\u0010W\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010N\u001a\u00020AH\u0082@¢\u0006\u0002\u0010ZJ6\u0010\\\u001a\u0004\u0018\u00010\u00052\u0006\u0010]\u001a\u00020\u00052\u0006\u0010U\u001a\u00020V2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010N\u001a\u00020AH\u0086@¢\u0006\u0002\u0010^J6\u0010_\u001a\u0004\u0018\u00010\u00052\u0006\u0010]\u001a\u00020\u00052\u0006\u0010U\u001a\u00020V2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010N\u001a\u00020AH\u0086@¢\u0006\u0002\u0010^J0\u0010`\u001a\u0004\u0018\u0001012\u0006\u0010a\u001a\u00020\u00052\n\b\u0002\u0010b\u001a\u0004\u0018\u00010?2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010AH\u0082@¢\u0006\u0002\u0010dJ>\u0010e\u001a\u0004\u0018\u00010\u00052\u0006\u0010]\u001a\u00020\u00052\u0006\u0010U\u001a\u00020V2\u0006\u0010a\u001a\u00020\u00052\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010N\u001a\u00020AH\u0086@¢\u0006\u0002\u0010fJ>\u0010g\u001a\u0004\u0018\u00010K2\u0006\u0010]\u001a\u00020\u00052\u0006\u0010U\u001a\u00020V2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010N\u001a\u00020A2\u0006\u0010O\u001a\u00020AH\u0086@¢\u0006\u0002\u0010hJ6\u0010i\u001a\u0004\u0018\u00010K2\u0006\u0010]\u001a\u00020\u00052\u0006\u0010U\u001a\u00020V2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010N\u001a\u00020AH\u0082@¢\u0006\u0002\u0010^J,\u0010j\u001a\u0004\u0018\u00010K2\u0006\u0010L\u001a\u00020\u00052\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u00052\u0006\u0010O\u001a\u00020AH\u0086@¢\u0006\u0002\u0010RJ$\u0010k\u001a\u0004\u0018\u00010K2\u0006\u0010L\u001a\u00020\u00052\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u0005H\u0082@¢\u0006\u0002\u0010lJ0\u0010m\u001a\u0004\u0018\u0001012\u0006\u0010n\u001a\u00020\u00052\u0006\u0010o\u001a\u00020A2\u0006\u0010>\u001a\u00020?2\u0006\u0010p\u001a\u00020\u0019H\u0082@¢\u0006\u0002\u0010qJ \u0010r\u001a\u00020A2\u0006\u0010]\u001a\u00020\u00052\u0006\u0010s\u001a\u00020V2\u0006\u0010t\u001a\u00020?H\u0002JD\u0010u\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010v\u001a\u00020\u00052\b\b\u0002\u0010w\u001a\u00020\u00052\b\b\u0002\u0010o\u001a\u00020A2\b\b\u0002\u0010x\u001a\u00020\u00192\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u0005H\u0086@¢\u0006\u0002\u0010yJD\u0010z\u001a\u0004\u0018\u00010{2\b\b\u0002\u0010v\u001a\u00020\u00052\b\b\u0002\u0010w\u001a\u00020\u00052\b\b\u0002\u0010o\u001a\u00020A2\b\b\u0002\u0010x\u001a\u00020\u00192\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u0005H\u0086@¢\u0006\u0002\u0010yJ,\u0010|\u001a\u00020}2\u0006\u0010U\u001a\u00020V2\b\b\u0002\u0010~\u001a\u00020}2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u0005H\u0086@¢\u0006\u0002\u0010\u007fJG\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u00052\u0006\u0010U\u001a\u00020V2\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u00052\t\b\u0002\u0010\u0081\u0001\u001a\u00020A2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010N\u001a\u00020AH\u0086@¢\u0006\u0003\u0010\u0082\u0001J\u001a\u0010\u0083\u0001\u001a\u0004\u0018\u0001012\u0007\u0010\u0084\u0001\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010IJ,\u0010\u0085\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0F2\u000e\u0010\u0086\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050\u0087\u0001H\u0082@¢\u0006\u0003\u0010\u0088\u0001JK\u0010\u0089\u0001\u001a\u00020A2\u000e\u0010\u008a\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050\u0087\u00012)\b\u0002\u0010\u008b\u0001\u001a\"\u0012\u0015\u0012\u00130A¢\u0006\u000e\b\u008d\u0001\u0012\t\bn\u0012\u0005\b\b(\u008e\u0001\u0012\u0004\u0012\u000208\u0018\u00010\u008c\u0001H\u0086@¢\u0006\u0003\u0010\u008f\u0001JK\u0010\u0090\u0001\u001a\u00020A2\u000e\u0010\u0091\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050\u0087\u00012)\b\u0002\u0010\u008b\u0001\u001a\"\u0012\u0015\u0012\u00130A¢\u0006\u000e\b\u008d\u0001\u0012\t\bn\u0012\u0005\b\b(\u008e\u0001\u0012\u0004\u0012\u000208\u0018\u00010\u008c\u0001H\u0086@¢\u0006\u0003\u0010\u008f\u0001J,\u0010\u0092\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0F2\u000e\u0010\u0091\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050\u0087\u0001H\u0082@¢\u0006\u0003\u0010\u0088\u0001JJ\u0010\u0093\u0001\u001a\u0002082\r\u0010\u0094\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050G2)\b\u0002\u0010\u008b\u0001\u001a\"\u0012\u0015\u0012\u00130A¢\u0006\u000e\b\u008d\u0001\u0012\t\bn\u0012\u0005\b\b(\u008e\u0001\u0012\u0004\u0012\u000208\u0018\u00010\u008c\u0001H\u0082@¢\u0006\u0003\u0010\u0095\u0001JJ\u0010\u0096\u0001\u001a\u0002082\r\u0010\u0097\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050G2)\b\u0002\u0010\u008b\u0001\u001a\"\u0012\u0015\u0012\u00130A¢\u0006\u000e\b\u008d\u0001\u0012\t\bn\u0012\u0005\b\b(\u008e\u0001\u0012\u0004\u0012\u000208\u0018\u00010\u008c\u0001H\u0082@¢\u0006\u0003\u0010\u0095\u0001J\u001b\u0010\u0098\u0001\u001a\u0002082\u0007\u0010\u0099\u0001\u001a\u00020}2\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0005J\u001d\u0010\u009b\u0001\u001a\u0002082\u0007\u0010\u0099\u0001\u001a\u00020}2\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0005H\u0002J\u001a\u0010\u009c\u0001\u001a\u00020A2\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0003\u0010\u009e\u0001J\u001a\u0010\u009f\u0001\u001a\u00020A2\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0003\u0010\u009e\u0001J%\u0010 \u0001\u001a\u00020\u00192\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\f2\t\u0010¡\u0001\u001a\u0004\u0018\u00010}H\u0002¢\u0006\u0003\u0010¢\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0019X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0019X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0019X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082T¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010106X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¤\u0001"}, d2 = {"Lcom/obric/memorydata/aikernelcore/AiKernelRunModelCaller;", "", "<init>", "()V", "TAG", "", "readyModelSet", "Ljava/util/concurrent/CopyOnWriteArraySet;", "KEY_SOURCE_PKG", "KEY_PRIORITY", "KEY_FORCE_EXECUTE", "PRIORITY_BACKGROUND", "", "PRIORITY_FOREGROUND", "OCR_SERVICE_NAME", "TEXT_EMBEDDING_MODEL_NAME", "IMG_EMBEDDING_MODEL_NAME", "CLIP4CLIP_EMBEDDING_MODEL_NAME", "VLM_LOCAL", "CLIP_TEXT_EMBEDDING_MODEL_NAME", "ASSISTANT_QUERY_UNDERSTANDING_MODEL_NAME", "KG_SLM_MODEL_NAME", "ASSISTANT_GLOBAL_QUERY_UNDERSTANDING_MODEL_NAME", "EMBEDDING_LORA_TYPE", "ASSISTANT_QUERY_UNDERSTANDING_TIMEOUT", "", "MAX_PIXEL", "KEY_LORA", "KEY_MODEL", "KEY_USE_CLOUD", "KEY_LORA_TYPE", "KEY_FILE_PATH", "KEY_CONTENT", "KEY_MAX_PIXEL", "KEY_LOCK_TIME", "KEY_PADDING", "OCR_PACKAGE_KEY_USE_CLOUD", "OCR_PACKAGE_KEY_ALL_WORD_IN_SINGLE", "LOAD_AI_KERNEL_PACKAGE_TIMEOUT", "AI_KERNEL_ERROR_DELAY_TIME_MS", "AI_KERNEL_VML_TIMEOUT_ERROR_DELAY_TIME_MS", "ERROR_CODE_THERMAL_STATUS", "ERROR_CODE_BUSY_REQUEST", "ERROR_CODE_MODEL_EVICTED", "ERROR_CODE_AI_KERNEL_UPDATE", "ERROR_CODE_VLM_TIMEOUT", "LOCK_TIME", "", "textEmbeddingModel", "Lcom/obric/aikernel/phx/sdk/api/IBaseModel;", "imgEmbeddingModel", "clip4clipEmbeddingModel", "clipTextEmbeddingModel", "localVlmModels", "Ljava/util/concurrent/ConcurrentHashMap;", "preloadModels", "", MemoryInfoSectionEditActivity.KIND_SCENE, "modelNames", "", "loraNames", "callingPkg", TrackerImpl.PARAMS, "Lcom/obric/aikernel/sdk/config/RequestParams;", "loadLora", "", "(Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Lcom/obric/aikernel/sdk/config/RequestParams;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelPreloadModels", "(Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getModelNameListBy", "", "", "papayaPackageName", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "textEmbeddingToVector", "", "sentence", "foregroundCallerPkg", "throwThermalStatusError", "useVlmEmbedding", "(Ljava/lang/String;Ljava/lang/String;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "textEmbeddingToVectorByModel", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "textEmbeddingToVectorByLora", "runImgEmbedding", "img", "Landroid/net/Uri;", "sourcePkg", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runImgEmbeddingByModel", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runImgEmbeddingByLora", "runCaptionJob", ObricMemoryConstants.KEY_PACKAGE_NAME, "(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runTagsJob", "loadLocalVlmModels", "lora", "extras", "useCache", "(Ljava/lang/String;Lcom/obric/aikernel/sdk/config/RequestParams;Ljava/lang/Boolean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runLocalVlmJob", "(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runCLIP4ClipEmbedding", "(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runCLIP4ClipEmbeddingByModel", "clipTextEmbeddingToVector", "clipTextEmbeddingToVectorByModel", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadAiKernelPackage", ActivityLifecycle.NAME, a.KEY_USE_CLOUD, "timeoutMs", "(Ljava/lang/String;ZLcom/obric/aikernel/sdk/config/RequestParams;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPermissionGrant", "uri", "requestParams", "callBizAsFlow", "modelName", "content", LocationMonitorConst.TIMEOUT, "(Ljava/lang/String;Ljava/lang/String;ZJLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callBizAsFlowWithLogId", "Lcom/obric/memorydata/aikernelcore/ScriptModelResult;", "runOcrWithErrorInfo", "Lorg/json/JSONObject;", "args", "(Landroid/net/Uri;Lorg/json/JSONObject;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runOcr", "allWordInSingle", "(Landroid/net/Uri;Ljava/lang/String;ZLjava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadScriptModel", "biz", "checkBizModelWithCache", "bizModels", "", "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkOrLoadModels", "modelNameList", "loadCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "loadSuccess", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkOrLoadLoras", "loraNameList", "checkBizLoraWithCache", "downloadLoras", "loraList", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadModels", "models", "fillPriorityArgs", "sourceArgs", "topPkg", "fillPriorityArgsForVlm", "isFeatureRunModelError", "errorCode", "(Ljava/lang/Integer;)Z", "isVLMRunModeError", "getFeatureRunModelDelayTime", WsConstants.KEY_EXTRA, "(Ljava/lang/Integer;Lorg/json/JSONObject;)J", "ProcessResult", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {
    private static final long AI_KERNEL_ERROR_DELAY_TIME_MS = 5000;
    private static final long AI_KERNEL_VML_TIMEOUT_ERROR_DELAY_TIME_MS = 60000;
    private static final String ASSISTANT_QUERY_UNDERSTANDING_MODEL_NAME = "slm_query_understanding";
    private static final int ERROR_CODE_AI_KERNEL_UPDATE = 113;
    private static final int ERROR_CODE_BUSY_REQUEST = 120;
    private static final int ERROR_CODE_MODEL_EVICTED = 3002;
    private static final int ERROR_CODE_THERMAL_STATUS = 119;
    private static final int ERROR_CODE_VLM_TIMEOUT = 3001;
    public static final a INSTANCE = null;
    private static final String KEY_CONTENT = "content";
    private static final String KEY_FILE_PATH = "filePath";
    private static final String KEY_FORCE_EXECUTE = "_ForceExecute";
    private static final String KEY_LOCK_TIME = "lock_time";
    private static final String KEY_MAX_PIXEL = "max_pixel";
    private static final String KEY_PADDING = "padding";
    private static final String KEY_PRIORITY = "_Priority";
    private static final String KEY_SOURCE_PKG = "_SourcePackageName";
    private static final String KEY_USE_CLOUD = "useCloud";
    private static final long LOAD_AI_KERNEL_PACKAGE_TIMEOUT = 300000;
    private static final float LOCK_TIME = 60.0f;
    private static final int MAX_PIXEL = 896;
    private static final String TAG = "AiKernelRunModelCaller";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static IBaseModel f8451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static IBaseModel f8452b;
    private static IBaseModel c;
    private static IBaseModel d;
    private static ConcurrentHashMap<String, IBaseModel> e;
    private static final CopyOnWriteArraySet<String> readyModelSet = null;

    /* JADX INFO: renamed from: com.obric.memorydata.aikernelcore.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003JB\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0005\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/obric/memorydata/aikernelcore/AiKernelRunModelCaller$ProcessResult;", ExifInterface.GPS_DIRECTION_TRUE, "", "success", "", "data", "errorCode", "", WsConstants.KEY_EXTRA, "Lorg/json/JSONObject;", "<init>", "(ZLjava/lang/Object;Ljava/lang/Integer;Lorg/json/JSONObject;)V", "getSuccess", "()Z", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getErrorCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getExtra", "()Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", "copy", "(ZLjava/lang/Object;Ljava/lang/Integer;Lorg/json/JSONObject;)Lcom/obric/memorydata/aikernelcore/AiKernelRunModelCaller$ProcessResult;", "equals", "other", "hashCode", "toString", "", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0425a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f8453a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final T f8454b;
        private final Integer c;
        private final JSONObject d;

        public C0425a(boolean r1, T r2, Integer r3, JSONObject r4) {
            this.f8453a = r1;
            this.f8454b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final boolean a() {
            return this.f8453a;
        }

        public final T b() {
            return this.f8454b;
        }

        public final Integer c() {
            return this.c;
        }

        public final JSONObject d() {
            return this.d;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0425a.class) == true) goto L8;
            return false;
        L8:
            C0425a r6 = (C0425a) ZeusTransformUtils.preCheckCast(r5, C0425a.class, "com.obric.memorydata.plugin");
            if (this.f8453a == r6.f8453a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f8454b, r6.f8454b) == true) goto L15;
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
            int r0 = Boolean.hashCode(this.f8453a) * 31;
            T r1 = this.f8454b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            Integer r5 = this.c;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            JSONObject r8 = this.d;
            if (r8 == null) goto L15;
            r2 = r8.hashCode();
        L15:
            return r7 + r2;
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "ProcessResult(success=" + this.f8453a + ", data=" + this.f8454b + ", errorCode=" + this.c + ", extra=" + this.d + ')';
        }
    }

    static {
        INSTANCE = new a();
        readyModelSet = new CopyOnWriteArraySet();
        e = new ConcurrentHashMap();
    }

    private a() {
    }

    public static final /* synthetic */ long a(a r0, Integer r1, JSONObject r2) {
        return r0.a(r1, r2);
    }

    private final long a(Integer r11, JSONObject r12) {
        if (r12 == null) goto L5;
        long r2 = r12.optLong(IdlKeys.Args_Timeout, 0);
    L7:
        if (r2 <= 0) goto L11;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "getFeatureRunModelDelayTime, errorCode: " + r11 + ", timeOut: " + r2, false, 4, null);
        return r2;
    L11:
        if (r11 == null) goto L16;
        if (r11.intValue() != 120) goto L16;
    L34:
        return 5000;
    L16:
        if (r11 == null) goto L22;
        if (r11.intValue() == 3002) goto L34;
    L22:
        if (r11 == null) goto L28;
        if (r11.intValue() == 113) goto L34;
    L28:
        if (r11 != null) goto L31;
        return 0;
    L31:
        if (r11.intValue() != 3001) goto L35;
        return 60000;
    L35:
        return 0;
    L5:
        r2 = 0;
        goto L7
    }

    public static final /* synthetic */ IBaseModel a() {
        return f8451a;
    }

    private final Object a(Uri r9, String r10, String r11, boolean r12, Continuation<? super float[]> r13) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new AiKernelRunModelCaller$runImgEmbeddingByModel$2(r9, r11, r10, r12, null), Function2.class, "com.obric.memorydata.plugin"), r8);
    }

    public static /* synthetic */ Object a(a r7, Uri r8, String r9, String r10, boolean r11, boolean r12, Continuation r13, int r14, Object r15) {
        Continuation<? super float[]> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        if ((r14 & 4) == 0) goto L5;
        r10 = null;
    L5:
        String r3 = r10;
        if ((r14 & 8) == 0) goto L9;
        r11 = false;
    L9:
        return r7.a(r8, r9, r3, r11, r12, r6);
    }

    public static /* synthetic */ Object a(a r7, Uri r8, String r9, boolean r10, String r11, boolean r12, Continuation r13, int r14, Object r15) {
        Continuation<? super String> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        if ((r14 & 2) == 0) goto L5;
        r9 = "";
    L5:
        String r2 = r9;
        if ((r14 & 4) == 0) goto L8;
        boolean r3 = false;
    L10:
        if ((r14 & 8) == 0) goto L12;
        r11 = null;
    L12:
        String r4 = r11;
        if ((r14 & 16) == 0) goto L15;
        boolean r5 = false;
    L17:
        return r7.a(r8, r2, r3, r4, r5, r6);
    L15:
        r5 = r12;
        goto L17
    L8:
        r3 = r10;
        goto L10
    }

    public static final /* synthetic */ Object a(a r2, String r3, RequestParams r4, Boolean r5, Continuation r6) {
        return r2.a(r3, r4, r5, (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ Object a(a r1, String r2, RequestParams r3, Boolean r4, Continuation r5, int r6, Object r7) {
        Continuation<? super IBaseModel> r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = true;
    L9:
        return r1.a(r2, r3, r4, r8);
    }

    public static /* synthetic */ Object a(a r7, String r8, String r9, boolean r10, long r11, String r13, Continuation r14, int r15, Object r16) {
        Continuation<? super String> r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
        String r2 = "";
        if ((r15 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r15 & 2) != 0) goto L11;
        r2 = r9;
    L11:
        if ((r15 & 4) == 0) goto L13;
        boolean r3 = false;
    L15:
        if ((r15 & 8) == 0) goto L17;
        long r4 = 30000;
    L19:
        if ((r15 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        return r7.a(r1, r2, r3, r4, r6, r0);
    L21:
        r6 = r13;
        goto L23
    L17:
        r4 = r11;
        goto L19
    L13:
        r3 = r10;
        goto L15
    L5:
        r1 = r8;
        goto L7
    }

    static /* synthetic */ Object a(a r1, String r2, String r3, boolean r4, Continuation r5, int r6, Object r7) {
        Continuation<? super float[]> r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = false;
    L9:
        return r1.c(r2, r3, r4, r8);
    }

    public static /* synthetic */ Object a(a r6, String r7, String r8, boolean r9, boolean r10, Continuation r11, int r12, Object r13) {
        Continuation<? super float[]> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if ((r12 & 2) == 0) goto L5;
        r8 = null;
    L5:
        String r2 = r8;
        if ((r12 & 4) == 0) goto L9;
        r9 = false;
    L9:
        return r6.a(r7, r2, r9, r10, r5);
    }

    public static final /* synthetic */ Object a(a r2, String r3, Continuation r4) {
        return r2.b(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ Object a(a r9, String r10, String[] r11, String[] r12, String r13, RequestParams r14, boolean r15, Continuation r16, int r17, Object r18) {
        Continuation<? super Unit> r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r16, Continuation.class, "com.obric.memorydata.plugin");
        if ((r17 & 2) == 0) goto L5;
        String[] r3 = null;
    L7:
        if ((r17 & 4) == 0) goto L9;
        String[] r4 = null;
    L11:
        if ((r17 & 8) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r17 & 16) == 0) goto L17;
        RequestParams r6 = null;
    L19:
        return r9.a(r10, r3, r4, r5, r6, r15, r8);
    L17:
        r6 = r14;
        goto L19
    L13:
        r5 = r13;
        goto L15
    L9:
        r4 = r12;
        goto L11
    L5:
        r3 = r11;
        goto L7
    }

    public static final /* synthetic */ Object a(a r2, Collection r3, Continuation r4) {
        return r2.a((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ Object a(a r1, Collection r2, Function1 r3, Continuation r4, int r5, Object r6) {
        Collection<String> r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        Function1<? super Boolean, Unit> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Continuation<? super Boolean> r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        return r1.a(r7, r8, r9);
    }

    public static final /* synthetic */ Object a(a r2, List r3, Function1 r4, Continuation r5) {
        return r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object a(String r11, RequestParams r12, Boolean r13, Continuation<? super IBaseModel> r14) {
        Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r15, AiKernelRunModelCaller$loadLocalVlmModels$1.class) == false) goto L7;
        AiKernelRunModelCaller$loadLocalVlmModels$1 r0 = (AiKernelRunModelCaller$loadLocalVlmModels$1) ZeusTransformUtils.preCheckCast(r15, AiKernelRunModelCaller$loadLocalVlmModels$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        AiKernelRunModelCaller$loadLocalVlmModels$1 r8 = r0;
        Object r16 = r8.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r8.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r11 = (String) ZeusTransformUtils.preCheckCast(r8.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r16);
    L29:
        IBaseModel r10 = (IBaseModel) ZeusTransformUtils.preCheckCast(r16, IBaseModel.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L33;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "loadLocalVlmModels, loadPackage error", null, 4, null);
        return null;
    L33:
        ((Map) ZeusTransformUtils.preCheckCast(e, Map.class, "com.obric.memorydata.plugin")).put(r11, r10);
        return r10;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == true) goto L17;
    L35:
        Ensure.ensureNotReachHere("loadLocalVlmModels called when AIKernel not available or not support VLM");
        throw new RuntimeException("loadLocalVlmModels called when AIKernel not available or not support VLM");
    L17:
        if (DeviceInfoState.INSTANCE.isSupportVLM() == false) goto L35;
        if (e.get(r11) != null) goto L21;
    L24:
        if (r12 != null) goto L26;
        r12 = new RequestParams(null, null, 3, null);
    L26:
        RequestParams r5 = r12;
        r5.getBackend().putString(Params.LORA_TYPE, r11);
        r8.L$0 = r11;
        r8.label = 1;
        r16 = a("vlm_local", false, r5, 300000, r8);
        if (r16 != r1) goto L29;
        return r1;
    L21:
        if (Intrinsics.areEqual(r13, Boxing.boxBoolean(true)) == false) goto L24;
        return e.get(r11);
    L7:
        r0 = new AiKernelRunModelCaller$loadLocalVlmModels$1(this, r15);
        goto L8
    }

    private final Object a(String r4, String r5, Continuation<? super float[]> r6) {
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new AiKernelRunModelCaller$clipTextEmbeddingToVectorByModel$2(r4, r5, null), Function2.class, "com.obric.memorydata.plugin"), r3);
    }

    private final Object a(String r15, boolean r16, RequestParams r17, long r18, Continuation<? super IBaseModel> r20) {
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r20, Continuation.class, "com.obric.memorydata.plugin");
        o r2 = new o(IntrinsicsKt.intercepted(r0), 1);
        r2.e();
        n r10 = (n) ZeusTransformUtils.preCheckCast(r2, n.class, "com.obric.memorydata.plugin");
        i.a((al) ZeusTransformUtils.preCheckCast(bp.f17245a, al.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new AiKernelRunModelCaller$loadAiKernelPackage$2$1(r18, r15, r17, r16, r10, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
        Object r1 = r2.h();
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L5:
        return r1;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0190 -> B:43:0x0193). Please report as a decompilation issue!!! */
    private final Object a(Collection<String> r12, Continuation<? super Map<String, Integer>> r13) {
        Collection r14 = (Collection) ZeusTransformUtils.wrapperContextForParams(r12, Collection.class, "com.obric.memorydata.plugin");
        Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r15, AiKernelRunModelCaller$checkBizModelWithCache$1.class) == false) goto L7;
        AiKernelRunModelCaller$checkBizModelWithCache$1 r0 = (AiKernelRunModelCaller$checkBizModelWithCache$1) ZeusTransformUtils.preCheckCast(r15, AiKernelRunModelCaller$checkBizModelWithCache$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        String r17 = (String) ZeusTransformUtils.preCheckCast(r0.L$2, String.class, "com.obric.memorydata.plugin");
        Iterator r3 = (Iterator) ZeusTransformUtils.preCheckCast(r0.L$1, Iterator.class, "com.obric.memorydata.plugin");
        Map r4 = (Map) ZeusTransformUtils.preCheckCast(r0.L$0, Map.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);
        Object r18 = ((Result) ZeusTransformUtils.preCheckCast(r11, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();
    L44:
        if (Result.m1427isFailureimpl(r18) == false) goto L46;
        r18 = null;
    L46:
        PackageResource r19 = (PackageResource) ZeusTransformUtils.preCheckCast(r18, PackageResource.class, "com.obric.memorydata.plugin");
        boolean r5 = false;
        if (r19 != null) goto L49;
    L51:
        if (r5 == false) goto L53;
        readyModelSet.add(r17);
    L53:
        Map r110 = r4;
    L38:
        if (r3.hasNext() == false) goto L54;
        r17 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");
        IAIKernelManager r6 = (IAIKernelManager) ZeusTransformUtils.preCheckCast(AIKernelManager.INSTANCE, IAIKernelManager.class, "com.obric.memorydata.plugin");
        r0.L$0 = r110;
        r0.L$1 = r3;
        r0.L$2 = r17;
        r0.label = 1;
        Object r7 = IAIKernelManager.DefaultImpls.m190getPackage0E7RQCE$default(r6, r17, null, r0, 2, null);
        if (r7 != r16) goto L42;
        return r16;
    L42:
        r4 = r110;
        r18 = r7;
        goto L44
    L54:
        return r110;
    L49:
        if (r19.isAvailable() != true) goto L51;
        r5 = true;
        goto L51
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        r110 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        if (r14.isEmpty() == false) goto L17;
        return r110;
    L17:
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(readyModelSet, Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r8.iterator();
    L19:
        if (r10.hasNext() == false) goto L23;
        Object r20 = r10.next();
        if (r14.contains((String) ZeusTransformUtils.preCheckCast(r20, String.class, "com.obric.memorydata.plugin")) == false) goto L19;
        r9.add(r20);
        goto L19
    L23:
        List r21 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug(TAG, "ready models in cache: " + r21);
        Iterator r22 = ((Iterable) ZeusTransformUtils.preCheckCast(r21, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L25:
        if (r22.hasNext() == false) goto L27;
        r110.put((String) ZeusTransformUtils.preCheckCast(r22.next(), String.class, "com.obric.memorydata.plugin"), Boxing.boxInt(1));
        goto L25
    L27:
        Iterable r111 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin");
        Collection r23 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r112 = r111.iterator();
    L29:
        if (r112.hasNext() == false) goto L33;
        Object r24 = r112.next();
        if ((!r21.contains((String) ZeusTransformUtils.preCheckCast(r24, String.class, "com.obric.memorydata.plugin"))) == false) goto L29;
        r23.add(r24);
        goto L29
    L33:
        List r113 = (List) ZeusTransformUtils.preCheckCast(r23, List.class, "com.obric.memorydata.plugin");
        if (r113.isEmpty() == false) goto L36;
        return r110;
    L36:
        r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r113, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        r0 = new AiKernelRunModelCaller$checkBizModelWithCache$1(this, r15);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x015f -> B:53:0x01b7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x018c -> B:41:0x0191). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x01bc -> B:55:0x01c4). Please report as a decompilation issue!!! */
    private final Object a(List<String> r20, Function1<? super Boolean, Unit> r21, Continuation<? super Unit> r22) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin");
        Function1 r2 = (Function1) ZeusTransformUtils.wrapperContextForParams(r21, Function1.class, "com.obric.memorydata.plugin");
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r22, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, AiKernelRunModelCaller$downloadLoras$1.class) == false) goto L7;
        AiKernelRunModelCaller$downloadLoras$1 r4 = (AiKernelRunModelCaller$downloadLoras$1) ZeusTransformUtils.preCheckCast(r3, AiKernelRunModelCaller$downloadLoras$1.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        Object r5 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        if (r7 == 0) goto L16;
        if (r7 == 1) goto L15;
        if (r7 != 2) goto L14;
        Iterator r1 = (Iterator) ZeusTransformUtils.preCheckCast(r4.L$3, Iterator.class, "com.obric.memorydata.plugin");
        Ref.IntRef r8 = (Ref.IntRef) ZeusTransformUtils.preCheckCast(r4.L$2, Ref.IntRef.class, "com.obric.memorydata.plugin");
        Function1 r9 = (Function1) ZeusTransformUtils.preCheckCast(r4.L$1, Function1.class, "com.obric.memorydata.plugin");
        List r12 = (List) ZeusTransformUtils.preCheckCast(r4.L$0, List.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
        Object r10 = ((Result) ZeusTransformUtils.preCheckCast(r5, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();
    L42:
        if (Result.m1427isFailureimpl(r10) == false) goto L44;
        r10 = null;
    L44:
        PackageResource r11 = (PackageResource) ZeusTransformUtils.preCheckCast(r10, PackageResource.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L47;
    L49:
        boolean r13 = false;
    L50:
        if (r13 == false) goto L52;
        int r14 = r8.element;
        r8.element = r14 + 1;
        Boxing.boxInt(r14);
    L52:
        List r15 = r12;
    L53:
        Ref.IntRef r16 = r8;
        r2 = r9;
        Iterator r17 = r1;
        r0 = r15;
    L56:
        if (r16.element != r0.size()) goto L60;
        RunLog.INSTANCE.debug(TAG, "downloadLoraList " + r0 + " success");
        if (r2 == null) goto L24;
        Boolean r18 = Boxing.boxBoolean(true);
    L62:
        r2.invoke(r18);
    L24:
        if (r17.hasNext() == false) goto L64;
        String r19 = (String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.memorydata.plugin");
        RequestParams r110 = new RequestParams(null, null, 3, null);
        ParamsKt.setLora(r110, r19);
        AIKernelManager r111 = AIKernelManager.INSTANCE;
        r4.L$0 = r0;
        r4.L$1 = r2;
        r4.L$2 = r16;
        r4.L$3 = r17;
        r4.label = 1;
        Object r112 = r111.mo188getPackage0E7RQCE("vlm_local", r110, r4);
        if (r112 != r6) goto L28;
        return r6;
    L28:
        r15 = r0;
        r1 = r17;
        r9 = r2;
        r8 = r16;
        Object r23 = r112;
    L30:
        if (Result.m1427isFailureimpl(r23) == false) goto L32;
        r23 = null;
    L32:
        PackageResource r113 = (PackageResource) ZeusTransformUtils.preCheckCast(r23, PackageResource.class, "com.obric.memorydata.plugin");
        if (r113 != null) goto L35;
        Function1 r114 = r9;
        r17 = r1;
        r0 = r15;
        r16 = r8;
        r2 = r114;
        goto L56
    L35:
        if (r113.isAvailable() == false) goto L37;
        int r24 = r8.element;
        r8.element = r24 + 1;
        Boxing.boxInt(r24);
        goto L53
    L37:
        IAIKernelManager r115 = (IAIKernelManager) ZeusTransformUtils.preCheckCast(AIKernelManager.INSTANCE, IAIKernelManager.class, "com.obric.memorydata.plugin");
        r4.L$0 = r15;
        r4.L$1 = r9;
        r4.L$2 = r8;
        r4.L$3 = r1;
        r4.label = 2;
        List r25 = r15;
        Object r116 = IAIKernelManager.DefaultImpls.m191updatePackage0E7RQCE$default(r115, r113, null, r4, 2, null);
        if (r116 != r6) goto L40;
        return r6;
    L40:
        r12 = r25;
        r10 = r116;
        goto L42
    L64:
        return Unit.INSTANCE;
    L60:
        if (r2 == null) goto L24;
        r18 = Boxing.boxBoolean(false);
        goto L62
    L47:
        if (r11.isAvailable() != true) goto L49;
        r13 = true;
        goto L50
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r1 = (Iterator) ZeusTransformUtils.preCheckCast(r4.L$3, Iterator.class, "com.obric.memorydata.plugin");
        r8 = (Ref.IntRef) ZeusTransformUtils.preCheckCast(r4.L$2, Ref.IntRef.class, "com.obric.memorydata.plugin");
        r9 = (Function1) ZeusTransformUtils.preCheckCast(r4.L$1, Function1.class, "com.obric.memorydata.plugin");
        List r117 = (List) ZeusTransformUtils.preCheckCast(r4.L$0, List.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
        r23 = ((Result) ZeusTransformUtils.preCheckCast(r5, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();
        r15 = r117;
        goto L30
    L16:
        ResultKt.throwOnFailure(r5);
        if (r0.isEmpty() == false) goto L22;
        if (r2 == null) goto L21;
        r2.invoke(Boxing.boxBoolean(true));
    L21:
        return Unit.INSTANCE;
    L22:
        RunLog.INSTANCE.debug(TAG, "downloadLoraList: " + r0);
        r16 = new Ref.IntRef();
        r17 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        r4 = new AiKernelRunModelCaller$downloadLoras$1(this, r3);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final Unit a(Ref.ObjectRef r6, Ref.IntRef r7, Ref.ObjectRef r8, int r9, String r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r10, "errInfo");
        Intrinsics.checkNotNullParameter(r11, "<unused var>");
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, r9 + ", " + r10, null, 4, null);
        readyModelSet.remove("ocr_service");
        r6.element = null;
        r7.element = r9;
        r8.element = r10;
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [T, java.lang.String] */
    private static final Unit a(Ref.ObjectRef r0, Ref.IntRef r1, Ref.ObjectRef r2, boolean r3, Object r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "<unused var>");
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.String");
        r0.element = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin");
        r1.element = 0;
        r2.element = "";
        RunLog.INSTANCE.debug(TAG, "ocr ret: " + ((String) ZeusTransformUtils.preCheckCast(r0.element, String.class, "com.obric.memorydata.plugin")));
        return Unit.INSTANCE;
    }

    private static final Unit a(Ref.ObjectRef r7, boolean r8, int r9, String r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r10, "errInfo");
        Intrinsics.checkNotNullParameter(r11, WsConstants.KEY_EXTRA);
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "runOcr error: " + r9 + ", " + r10, null, 4, null);
        readyModelSet.remove("ocr_service");
        r7.element = null;
        if (r8 == false) goto L10;
        a r12 = INSTANCE;
        if (r12.a(Integer.valueOf(r9)) == false) goto L10;
        throw new AIKernelRunModelException(r12.a(Integer.valueOf(r9), r11));
    L10:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [T, java.lang.String] */
    private static final Unit a(Ref.ObjectRef r1, boolean r2, Object r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "<unused var>");
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.String");
        r1.element = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug(TAG, "ocr ret: " + ((String) ZeusTransformUtils.preCheckCast(r1.element, String.class, "com.obric.memorydata.plugin")));
        return Unit.INSTANCE;
    }

    private static final Unit a(JSONObject r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$setCustomArgs");
        r4.putAll(BundleExtKt.json2Bundle$default(r3, false, 2, null));
        return Unit.INSTANCE;
    }

    private static final Unit a(final JSONObject r1, RequestParams r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$RequestParams");
        ParamsKt.setCustomArgs(r2, new $$Lambda$a$nvY1AsgIwuIOeLHsedbomAi1s(r1));
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void a(IBaseModel r2) {
        f8451a = (IBaseModel) ZeusTransformUtils.wrapperContextForParams(r2, IBaseModel.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void a(a r0, JSONObject r1, String r2) {
        r0.b(r1, r2);
    }

    public static final /* synthetic */ boolean a(a r0, Integer r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ boolean a(a r0, String r1, Uri r2, RequestParams r3) {
        return r0.a(r1, r2, r3);
    }

    private final boolean a(Integer r2) {
        if (r2 == null) goto L7;
        if (r2.intValue() != 119) goto L7;
    L23:
        return true;
    L7:
        if (r2 == null) goto L12;
        if (r2.intValue() == 120) goto L23;
    L12:
        if (r2 == null) goto L17;
        if (r2.intValue() == 3002) goto L23;
    L17:
        if (r2 != null) goto L20;
    L22:
        return false;
    L20:
        if (r2.intValue() != 113) goto L22;
        goto L22
    }

    private final boolean a(String r2, Uri r3, RequestParams r4) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new AiKernelRunModelCaller$getPermissionGrant$1(r2, r3, r4, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    private final Object b(Uri r9, String r10, String r11, boolean r12, Continuation<? super float[]> r13) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new AiKernelRunModelCaller$runImgEmbeddingByLora$2(r10, r9, r11, r12, null), Function2.class, "com.obric.memorydata.plugin"), r8);
    }

    public static /* synthetic */ Object b(a r7, String r8, String r9, boolean r10, long r11, String r13, Continuation r14, int r15, Object r16) {
        Continuation<? super ScriptModelResult> r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
        String r2 = "";
        if ((r15 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r15 & 2) != 0) goto L11;
        r2 = r9;
    L11:
        if ((r15 & 4) == 0) goto L13;
        boolean r3 = false;
    L15:
        if ((r15 & 8) == 0) goto L17;
        long r4 = 20000;
    L19:
        if ((r15 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        return r7.b(r1, r2, r3, r4, r6, r0);
    L21:
        r6 = r13;
        goto L23
    L17:
        r4 = r11;
        goto L19
    L13:
        r3 = r10;
        goto L15
    L5:
        r1 = r8;
        goto L7
    }

    public static final /* synthetic */ Object b(a r2, Collection r3, Continuation r4) {
        return r2.b((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ Object b(a r1, Collection r2, Function1 r3, Continuation r4, int r5, Object r6) {
        Collection<String> r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        Function1<? super Boolean, Unit> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Continuation<? super Boolean> r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        return r1.b(r7, r8, r9);
    }

    public static final /* synthetic */ Object b(a r2, List r3, Function1 r4, Continuation r5) {
        return r2.b((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object b(String r4, String r5, boolean r6, Continuation<? super float[]> r7) {
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new AiKernelRunModelCaller$textEmbeddingToVectorByModel$2(r4, r5, r6, null), Function2.class, "com.obric.memorydata.plugin"), r3);
    }

    private final Object b(String r24, Continuation<? super IBaseModel> r25) {
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r25, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, AiKernelRunModelCaller$loadScriptModel$1.class) == false) goto L7;
        AiKernelRunModelCaller$loadScriptModel$1 r2 = (AiKernelRunModelCaller$loadScriptModel$1) ZeusTransformUtils.preCheckCast(r1, AiKernelRunModelCaller$loadScriptModel$1.class, "com.obric.memorydata.plugin");
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
    L8:
        AiKernelRunModelCaller$loadScriptModel$1 r14 = r2;
        Object r3 = r14.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r14.label;
        int r13 = 3;
        if (r4 == 0) goto L18;
        if (r4 == 1) goto L17;
        if (r4 == 2) goto L16;
        if (r4 != 3) goto L15;
        ResultKt.throwOnFailure(r3);
    L48:
        return (IBaseModel) ZeusTransformUtils.preCheckCast(r3, IBaseModel.class, "com.obric.memorydata.plugin");
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        String r0 = (String) ZeusTransformUtils.preCheckCast(r14.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        Object r12 = ((Result) ZeusTransformUtils.preCheckCast(r3, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();
        Object r5 = null;
    L34:
        if (Result.m1427isFailureimpl(r12) == false) goto L36;
        r12 = r5;
    L36:
        PackageResource r9 = (PackageResource) ZeusTransformUtils.preCheckCast(r12, PackageResource.class, "com.obric.memorydata.plugin");
    L38:
        if (r9 == null) goto L47;
        if (r9.isAvailable() == false) goto L47;
        IAIKernelManager r8 = (IAIKernelManager) ZeusTransformUtils.preCheckCast(AIKernelManager.INSTANCE, IAIKernelManager.class, "com.obric.memorydata.plugin");
        r14.L$0 = r5;
        r14.label = r13;
        r3 = IAIKernelManager.DefaultImpls.loadPackage$default(r8, r0, false, null, r14, 6, null);
        if (r3 != r15) goto L48;
        return r15;
    L47:
        return r5;
    L17:
        r0 = (String) ZeusTransformUtils.preCheckCast(r14.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        Object r6 = ((Result) ZeusTransformUtils.preCheckCast(r3, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();
    L23:
        if (Result.m1427isFailureimpl(r6) == false) goto L25;
        r6 = null;
    L25:
        r9 = (PackageResource) ZeusTransformUtils.preCheckCast(r6, PackageResource.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L28;
        r5 = null;
        goto L47
    L28:
        if (r9.isAvailable() == true) goto L37;
        IAIKernelManager r7 = (IAIKernelManager) ZeusTransformUtils.preCheckCast(AIKernelManager.INSTANCE, IAIKernelManager.class, "com.obric.memorydata.plugin");
        r14.L$0 = r0;
        r14.label = 2;
        r5 = null;
        Object r10 = IAIKernelManager.DefaultImpls.m191updatePackage0E7RQCE$default(r7, r9, null, r14, 2, null);
        if (r10 != r15) goto L32;
        return r15;
    L32:
        r12 = r10;
        goto L34
    L37:
        r5 = null;
        r13 = 3;
        goto L38
    L18:
        ResultKt.throwOnFailure(r3);
        a r11 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "model loadScriptModel " + r24, false, 4, null);
        IAIKernelManager r16 = (IAIKernelManager) ZeusTransformUtils.preCheckCast(AIKernelManager.INSTANCE, IAIKernelManager.class, "com.obric.memorydata.plugin");
        r14.L$0 = r24;
        r14.label = 1;
        r6 = IAIKernelManager.DefaultImpls.m190getPackage0E7RQCE$default(r16, r24, null, r14, 2, null);
        if (r6 != r15) goto L21;
        return r15;
    L21:
        r0 = r24;
    L7:
        r2 = new AiKernelRunModelCaller$loadScriptModel$1(this, r1);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x018f -> B:42:0x0192). Please report as a decompilation issue!!! */
    private final Object b(Collection<String> r9, Continuation<? super Map<String, Integer>> r10) {
        Collection r11 = (Collection) ZeusTransformUtils.wrapperContextForParams(r9, Collection.class, "com.obric.memorydata.plugin");
        Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r12, AiKernelRunModelCaller$checkBizLoraWithCache$1.class) == false) goto L7;
        AiKernelRunModelCaller$checkBizLoraWithCache$1 r0 = (AiKernelRunModelCaller$checkBizLoraWithCache$1) ZeusTransformUtils.preCheckCast(r12, AiKernelRunModelCaller$checkBizLoraWithCache$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r0.L$2, String.class, "com.obric.memorydata.plugin");
        Iterator r3 = (Iterator) ZeusTransformUtils.preCheckCast(r0.L$1, Iterator.class, "com.obric.memorydata.plugin");
        Map r5 = (Map) ZeusTransformUtils.preCheckCast(r0.L$0, Map.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r8);
        Object r15 = ((Result) ZeusTransformUtils.preCheckCast(r8, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();
    L43:
        if (Result.m1427isFailureimpl(r15) == false) goto L45;
        r15 = null;
    L45:
        PackageResource r16 = (PackageResource) ZeusTransformUtils.preCheckCast(r15, PackageResource.class, "com.obric.memorydata.plugin");
        boolean r6 = false;
        if (r16 != null) goto L48;
    L50:
        if (r6 == false) goto L38;
        readyModelSet.add(r14);
    L38:
        if (r3.hasNext() == false) goto L52;
        r14 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");
        RequestParams r17 = new RequestParams(null, null, 3, null);
        ParamsKt.setLora(r17, r14);
        AIKernelManager r7 = AIKernelManager.INSTANCE;
        r0.L$0 = r5;
        r0.L$1 = r3;
        r0.L$2 = r14;
        r0.label = 1;
        r15 = r7.mo188getPackage0E7RQCE("vlm_local", r17, r0);
        if (r15 != r13) goto L43;
        return r13;
    L52:
        return r5;
    L48:
        if (r16.isAvailable() != true) goto L50;
        r6 = true;
        goto L50
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        Map r18 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        if (r11.isEmpty() == false) goto L17;
        return r18;
    L17:
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(readyModelSet, Iterable.class, "com.obric.memorydata.plugin");
        Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r20 = r4.iterator();
    L19:
        if (r20.hasNext() == false) goto L23;
        Object r21 = r20.next();
        if (r11.contains((String) ZeusTransformUtils.preCheckCast(r21, String.class, "com.obric.memorydata.plugin")) == false) goto L19;
        r19.add(r21);
        goto L19
    L23:
        List r22 = (List) ZeusTransformUtils.preCheckCast(r19, List.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug(TAG, "ready loras in cache: " + r22);
        Iterator r23 = ((Iterable) ZeusTransformUtils.preCheckCast(r22, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L25:
        if (r23.hasNext() == false) goto L27;
        r18.put((String) ZeusTransformUtils.preCheckCast(r23.next(), String.class, "com.obric.memorydata.plugin"), Boxing.boxInt(1));
        goto L25
    L27:
        Iterable r24 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        Collection r25 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r26 = r24.iterator();
    L29:
        if (r26.hasNext() == false) goto L33;
        Object r27 = r26.next();
        if ((!r22.contains((String) ZeusTransformUtils.preCheckCast(r27, String.class, "com.obric.memorydata.plugin"))) == false) goto L29;
        r25.add(r27);
        goto L29
    L33:
        List r28 = (List) ZeusTransformUtils.preCheckCast(r25, List.class, "com.obric.memorydata.plugin");
        if (r28.isEmpty() == false) goto L36;
        return r18;
    L36:
        r5 = r18;
        r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r28, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        r0 = new AiKernelRunModelCaller$checkBizLoraWithCache$1(this, r12);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0162 -> B:53:0x01ba). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x018f -> B:41:0x0194). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x01bf -> B:55:0x01c7). Please report as a decompilation issue!!! */
    private final Object b(List<String> r20, Function1<? super Boolean, Unit> r21, Continuation<? super Unit> r22) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin");
        Function1 r2 = (Function1) ZeusTransformUtils.wrapperContextForParams(r21, Function1.class, "com.obric.memorydata.plugin");
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r22, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, AiKernelRunModelCaller$downloadModels$1.class) == false) goto L7;
        AiKernelRunModelCaller$downloadModels$1 r4 = (AiKernelRunModelCaller$downloadModels$1) ZeusTransformUtils.preCheckCast(r3, AiKernelRunModelCaller$downloadModels$1.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        Object r5 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        if (r7 == 0) goto L16;
        if (r7 == 1) goto L15;
        if (r7 != 2) goto L14;
        Iterator r1 = (Iterator) ZeusTransformUtils.preCheckCast(r4.L$3, Iterator.class, "com.obric.memorydata.plugin");
        Ref.IntRef r8 = (Ref.IntRef) ZeusTransformUtils.preCheckCast(r4.L$2, Ref.IntRef.class, "com.obric.memorydata.plugin");
        Function1 r9 = (Function1) ZeusTransformUtils.preCheckCast(r4.L$1, Function1.class, "com.obric.memorydata.plugin");
        List r12 = (List) ZeusTransformUtils.preCheckCast(r4.L$0, List.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
        Object r10 = ((Result) ZeusTransformUtils.preCheckCast(r5, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();
    L42:
        if (Result.m1427isFailureimpl(r10) == false) goto L44;
        r10 = null;
    L44:
        PackageResource r11 = (PackageResource) ZeusTransformUtils.preCheckCast(r10, PackageResource.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L47;
    L49:
        boolean r13 = false;
    L50:
        if (r13 == false) goto L52;
        int r14 = r8.element;
        r8.element = r14 + 1;
        Boxing.boxInt(r14);
    L52:
        List r15 = r12;
    L53:
        Ref.IntRef r16 = r8;
        r2 = r9;
        Iterator r17 = r1;
        r0 = r15;
    L56:
        if (r16.element != r0.size()) goto L60;
        RunLog.INSTANCE.debug(TAG, "downloadModels " + r0 + " success");
        if (r2 == null) goto L24;
        Boolean r18 = Boxing.boxBoolean(true);
    L62:
        r2.invoke(r18);
    L24:
        if (r17.hasNext() == false) goto L64;
        String r19 = (String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.memorydata.plugin");
        IAIKernelManager r110 = (IAIKernelManager) ZeusTransformUtils.preCheckCast(AIKernelManager.INSTANCE, IAIKernelManager.class, "com.obric.memorydata.plugin");
        r4.L$0 = r0;
        r4.L$1 = r2;
        r4.L$2 = r16;
        r4.L$3 = r17;
        r4.label = 1;
        Object r111 = IAIKernelManager.DefaultImpls.m190getPackage0E7RQCE$default(r110, r19, null, r4, 2, null);
        if (r111 != r6) goto L28;
        return r6;
    L28:
        r15 = r0;
        r1 = r17;
        r9 = r2;
        r8 = r16;
        Object r23 = r111;
    L30:
        if (Result.m1427isFailureimpl(r23) == false) goto L32;
        r23 = null;
    L32:
        PackageResource r112 = (PackageResource) ZeusTransformUtils.preCheckCast(r23, PackageResource.class, "com.obric.memorydata.plugin");
        if (r112 != null) goto L35;
        Function1 r113 = r9;
        r17 = r1;
        r0 = r15;
        r16 = r8;
        r2 = r113;
        goto L56
    L35:
        if (r112.isAvailable() == false) goto L37;
        int r24 = r8.element;
        r8.element = r24 + 1;
        Boxing.boxInt(r24);
        goto L53
    L37:
        IAIKernelManager r114 = (IAIKernelManager) ZeusTransformUtils.preCheckCast(AIKernelManager.INSTANCE, IAIKernelManager.class, "com.obric.memorydata.plugin");
        r4.L$0 = r15;
        r4.L$1 = r9;
        r4.L$2 = r8;
        r4.L$3 = r1;
        r4.label = 2;
        List r25 = r15;
        Object r115 = IAIKernelManager.DefaultImpls.m191updatePackage0E7RQCE$default(r114, r112, null, r4, 2, null);
        if (r115 != r6) goto L40;
        return r6;
    L40:
        r12 = r25;
        r10 = r115;
        goto L42
    L64:
        return Unit.INSTANCE;
    L60:
        if (r2 == null) goto L24;
        r18 = Boxing.boxBoolean(false);
        goto L62
    L47:
        if (r11.isAvailable() != true) goto L49;
        r13 = true;
        goto L50
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r1 = (Iterator) ZeusTransformUtils.preCheckCast(r4.L$3, Iterator.class, "com.obric.memorydata.plugin");
        r8 = (Ref.IntRef) ZeusTransformUtils.preCheckCast(r4.L$2, Ref.IntRef.class, "com.obric.memorydata.plugin");
        r9 = (Function1) ZeusTransformUtils.preCheckCast(r4.L$1, Function1.class, "com.obric.memorydata.plugin");
        List r116 = (List) ZeusTransformUtils.preCheckCast(r4.L$0, List.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
        r23 = ((Result) ZeusTransformUtils.preCheckCast(r5, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();
        r15 = r116;
        goto L30
    L16:
        ResultKt.throwOnFailure(r5);
        if (r0.isEmpty() == false) goto L22;
        if (r2 == null) goto L21;
        r2.invoke(Boxing.boxBoolean(true));
    L21:
        return Unit.INSTANCE;
    L22:
        RunLog.INSTANCE.debug(TAG, "downloadModels: " + r0);
        r16 = new Ref.IntRef();
        r17 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        r4 = new AiKernelRunModelCaller$downloadModels$1(this, r3);
        goto L8
    }

    public static final /* synthetic */ CopyOnWriteArraySet b() {
        return readyModelSet;
    }

    private static final Unit b(JSONObject r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$setCustomArgs");
        r4.putAll(BundleExtKt.json2Bundle$default(r3, false, 2, null));
        return Unit.INSTANCE;
    }

    private static final Unit b(final JSONObject r1, RequestParams r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$RequestParams");
        ParamsKt.setCustomArgs(r2, new $$Lambda$a$LDvflaqUmfqjlEljmbHmYU_3JM(r1));
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void b(IBaseModel r2) {
        f8452b = (IBaseModel) ZeusTransformUtils.wrapperContextForParams(r2, IBaseModel.class, "com.obric.memorydata.plugin");
    }

    private final void b(JSONObject r9, String r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L7;
        boolean r8 = true;
    L8:
        if (r8 == false) goto L11;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "vlm topPkg is " + r10, false, 4, null);
        r9.put("_SourcePackageName", r10);
        r9.put("_Priority", 1);
        r9.put("_ForceExecute", 1);
        r9.put(KEY_LOCK_TIME, Float.valueOf(LOCK_TIME));
        return;
    L11:
        return;
    L7:
        r8 = false;
        goto L8
    }

    public static final /* synthetic */ boolean b(a r0, Integer r1) {
        return r0.b(r1);
    }

    private final boolean b(Integer r1) {
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.intValue() != 3001) goto L7;
        return true;
    }

    public static final /* synthetic */ IBaseModel c() {
        return f8452b;
    }

    private final Object c(String r9, Uri r10, String r11, boolean r12, Continuation<? super float[]> r13) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new AiKernelRunModelCaller$runCLIP4ClipEmbeddingByModel$2(r10, r11, r9, r12, null), Function2.class, "com.obric.memorydata.plugin"), r8);
    }

    private final Object c(String r4, String r5, boolean r6, Continuation<? super float[]> r7) {
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new AiKernelRunModelCaller$textEmbeddingToVectorByLora$2(r4, r5, r6, null), Function2.class, "com.obric.memorydata.plugin"), r3);
    }

    public static final /* synthetic */ void c(IBaseModel r2) {
        c = (IBaseModel) ZeusTransformUtils.wrapperContextForParams(r2, IBaseModel.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ IBaseModel d() {
        return c;
    }

    public static final /* synthetic */ void d(IBaseModel r2) {
        d = (IBaseModel) ZeusTransformUtils.wrapperContextForParams(r2, IBaseModel.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ IBaseModel e() {
        return d;
    }

    public static /* synthetic */ Unit lambda$3kI2P8oM5V5tnvU_0HDoSCrEnmA(Ref.ObjectRef r0, boolean r1, int r2, String r3, JSONObject r4) {
        return a(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: lambda$67uIbT8YTZPk3KX2rWwh-qEsJZQ, reason: not valid java name */
    public static /* synthetic */ Unit m460lambda$67uIbT8YTZPk3KX2rWwhqEsJZQ(JSONObject r0, RequestParams r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Unit lambda$B0gHlFLJR3WMNNkpFmyk6CrJPvQ(JSONObject r0, RequestParams r1) {
        return b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$LDvflaqUmfqjlElj-mbHmYU_3JM, reason: not valid java name */
    public static /* synthetic */ Unit m461lambda$LDvflaqUmfqjlEljmbHmYU_3JM(JSONObject r0, Bundle r1) {
        return b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$_2Azef-8M1s7N02DqDA8YuRLOtk, reason: not valid java name */
    public static /* synthetic */ Unit m462lambda$_2Azef8M1s7N02DqDA8YuRLOtk(Ref.ObjectRef r0, Ref.IntRef r1, Ref.ObjectRef r2, boolean r3, Object r4, JSONObject r5) {
        return a(r0, r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: lambda$nvY1AsgI-wuIOeLHse-dbomAi1s, reason: not valid java name */
    public static /* synthetic */ Unit m463lambda$nvY1AsgIwuIOeLHsedbomAi1s(JSONObject r0, Bundle r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Unit lambda$qiovsVH4pWwS4hJb5oMlZh87t6k(Ref.ObjectRef r0, Ref.IntRef r1, Ref.ObjectRef r2, int r3, String r4, JSONObject r5) {
        return a(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit lambda$t_v8Vu3XQa34DE3burAIXsIQoxs(Ref.ObjectRef r0, boolean r1, Object r2, JSONObject r3) {
        return a(r0, r1, r2, r3);
    }

    public final Object a(Uri r7, String r8, String r9, boolean r10, boolean r11, Continuation<? super float[]> r12) {
        Continuation<? super float[]> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        if (r11 == false) goto L7;
        return b(r7, r8, r9, r10, r5);
    L7:
        return a(r7, r8, r9, r10, r5);
    }

    public final Object a(Uri r19, String r20, boolean r21, String r22, boolean r23, Continuation<? super String> r24) {
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r24, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, AiKernelRunModelCaller$runOcr$1.class) == false) goto L7;
        AiKernelRunModelCaller$runOcr$1 r3 = (AiKernelRunModelCaller$runOcr$1) ZeusTransformUtils.preCheckCast(r1, AiKernelRunModelCaller$runOcr$1.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r3.label;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        long r6 = r3.J$0;
        final boolean r0 = r3.Z$0;
        final Ref.ObjectRef r7 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r3.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);
    L48:
        Intrinsics.checkNotNull(r2);
        ResponseKt.fail(ResponseKt.ok((Response) ZeusTransformUtils.preCheckCast(r2, Response.class, "com.obric.memorydata.plugin"), new $$Lambda$a$t_v8Vu3XQa34DE3burAIXsIQoxs(r7)), new $$Lambda$a$3kI2P8oM5V5tnvU_0HDoSCrEnmA(r7, r0));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "ocr_service cost: " + (System.currentTimeMillis() - r6) + "ms", false, 4, null);
        Log.i(TAG, "ocr_service cost: " + (System.currentTimeMillis() - r6) + "ms");
        return r7.element;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r8 = r3.J$0;
        r0 = r3.Z$1;
        boolean r9 = r3.Z$0;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r3.L$3, String.class, "com.obric.memorydata.plugin");
        String r11 = (String) ZeusTransformUtils.preCheckCast(r3.L$2, String.class, "com.obric.memorydata.plugin");
        Uri r12 = (Uri) ZeusTransformUtils.preCheckCast(r3.L$1, Uri.class, "com.obric.memorydata.plugin");
        a r13 = (a) ZeusTransformUtils.preCheckCast(r3.L$0, a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);
    L22:
        IBaseModel r14 = (IBaseModel) ZeusTransformUtils.preCheckCast(r2, IBaseModel.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L25;
        return null;
    L25:
        final JSONObject r15 = new JSONObject();
        r15.put("filePath", r12.toString());
        r15.put("all_word_in_single", r9);
        CharSequence r16 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L28;
    L31:
        boolean r17 = true;
    L32:
        if (r17 == true) goto L34;
        r13.a(r15, r10);
    L34:
        Ref.ObjectRef r18 = new Ref.ObjectRef();
        boolean r110 = true;
        RequestParams r25 = new RequestParams(null, new $$Lambda$a$B0gHlFLJR3WMNNkpFmyk6CrJPvQ(r15), 1, null);
        CharSequence r111 = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin");
        if (r111 != null) goto L37;
    L40:
        if (r110 == false) goto L42;
    L44:
        r3.L$0 = r18;
        r3.L$1 = null;
        r3.L$2 = null;
        r3.L$3 = null;
        r3.Z$0 = r0;
        r3.J$0 = r8;
        r3.label = 2;
        r2 = r14.infer(r25, r3);
        if (r2 != r4) goto L47;
        return r4;
    L47:
        r7 = r18;
        r6 = r8;
        goto L48
    L42:
        if (INSTANCE.a(r11, r12, r25) == true) goto L44;
        return null;
    L37:
        if (r111.length() == 0) goto L40;
        r110 = false;
        goto L40
    L28:
        if (r16.length() == 0) goto L31;
        r17 = false;
        goto L32
    L16:
        ResultKt.throwOnFailure(r2);
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L50;
        r8 = System.currentTimeMillis();
        r3.L$0 = this;
        r3.L$1 = r19;
        r3.L$2 = r20;
        r10 = r22;
        r3.L$3 = r10;
        r3.Z$0 = r21;
        r3.Z$1 = r23;
        r3.J$0 = r8;
        r3.label = 1;
        Object r112 = b("ocr_service", r3);
        if (r112 != r4) goto L21;
        return r4;
    L21:
        r13 = this;
        r0 = r23;
        r12 = r19;
        r2 = r112;
        r11 = r20;
        r9 = r21;
        goto L22
    L50:
        Ensure.ensureNotReachHere("runOcr called when AIKernel not available");
        throw new RuntimeException("runOcr called when AIKernel not available");
    L7:
        r3 = new AiKernelRunModelCaller$runOcr$1(this, r1);
        goto L8
    }

    public final Object a(Uri r18, JSONObject r19, String r20, Continuation<? super JSONObject> r21) {
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r21, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, AiKernelRunModelCaller$runOcrWithErrorInfo$1.class) == false) goto L7;
        AiKernelRunModelCaller$runOcrWithErrorInfo$1 r3 = (AiKernelRunModelCaller$runOcrWithErrorInfo$1) ZeusTransformUtils.preCheckCast(r1, AiKernelRunModelCaller$runOcrWithErrorInfo$1.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r3.label;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        long r6 = r3.J$0;
        final Ref.ObjectRef r0 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r3.L$2, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        final Ref.IntRef r8 = (Ref.IntRef) ZeusTransformUtils.preCheckCast(r3.L$1, Ref.IntRef.class, "com.obric.memorydata.plugin");
        final Ref.ObjectRef r7 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r3.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);
    L30:
        Intrinsics.checkNotNull(r2);
        ResponseKt.fail(ResponseKt.ok((Response) ZeusTransformUtils.preCheckCast(r2, Response.class, "com.obric.memorydata.plugin"), new $$Lambda$a$_2Azef8M1s7N02DqDA8YuRLOtk(r7, r8, r0)), new $$Lambda$a$qiovsVH4pWwS4hJb5oMlZh87t6k(r7, r8, r0));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "ocr_service cost: " + (System.currentTimeMillis() - r6) + "ms", false, 4, null);
        Log.i(TAG, "ocr_service cost: " + (System.currentTimeMillis() - r6) + "ms");
        JSONObject r9 = new JSONObject();
        r9.put("errorCode", r8.element);
        r9.put("errorInfo", r0.element);
        r9.put("data", r7.element);
        return r9;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r10 = r3.J$0;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r3.L$3, String.class, "com.obric.memorydata.plugin");
        final JSONObject r12 = (JSONObject) ZeusTransformUtils.preCheckCast(r3.L$2, JSONObject.class, "com.obric.memorydata.plugin");
        Uri r13 = (Uri) ZeusTransformUtils.preCheckCast(r3.L$1, Uri.class, "com.obric.memorydata.plugin");
        a r14 = (a) ZeusTransformUtils.preCheckCast(r3.L$0, a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);
    L22:
        IBaseModel r15 = (IBaseModel) ZeusTransformUtils.preCheckCast(r2, IBaseModel.class, "com.obric.memorydata.plugin");
        if (r15 != null) goto L26;
        JSONObject r16 = new JSONObject();
        r16.put("errorCode", OcrErrorCode.LOAD_SCRIPT_MODEL_ERROR.getCode());
        r16.put("errorInfo", "获取ScriptModel失败");
        return r16;
    L26:
        r12.put("filePath", r13.toString());
        r14.a(r12, r11);
        Ref.ObjectRef r17 = new Ref.ObjectRef();
        Ref.IntRef r110 = new Ref.IntRef();
        Ref.ObjectRef r111 = new Ref.ObjectRef();
        r111.element = "";
        RequestParams r112 = new RequestParams(null, new $$Lambda$a$67uIbT8YTZPk3KX2rWwhqEsJZQ(r12), 1, null);
        r3.L$0 = r17;
        r3.L$1 = r110;
        r3.L$2 = r111;
        r3.L$3 = null;
        r3.J$0 = r10;
        r3.label = 2;
        r2 = r15.infer(r112, r3);
        if (r2 != r4) goto L29;
        return r4;
    L29:
        r7 = r17;
        r6 = r10;
        r8 = r110;
        r0 = r111;
        goto L30
    L16:
        ResultKt.throwOnFailure(r2);
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L32;
        r10 = System.currentTimeMillis();
        r3.L$0 = this;
        r3.L$1 = r18;
        r12 = r19;
        r3.L$2 = r12;
        r3.L$3 = r20;
        r3.J$0 = r10;
        r3.label = 1;
        Object r113 = b("ocr_service", r3);
        if (r113 != r4) goto L21;
        return r4;
    L21:
        r14 = this;
        r11 = r20;
        r13 = r18;
        r2 = r113;
        goto L22
    L32:
        Ensure.ensureNotReachHere("runOcrWithErrorInfo called when AIKernel not available");
        throw new RuntimeException("runOcrWithErrorInfo called when AIKernel not available");
    L7:
        r3 = new AiKernelRunModelCaller$runOcrWithErrorInfo$1(this, r1);
        goto L8
    }

    public final Object a(String r10, Uri r11, String r12, String r13, boolean r14, Continuation<? super String> r15) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new AiKernelRunModelCaller$runLocalVlmJob$2(r12, r10, r11, r14, r13, null), Function2.class, "com.obric.memorydata.plugin"), r9);
    }

    public final Object a(String r9, Uri r10, String r11, boolean r12, Continuation<? super String> r13) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new AiKernelRunModelCaller$runCaptionJob$2(r9, r10, r11, r12, null), Function2.class, "com.obric.memorydata.plugin"), r8);
    }

    public final Object a(String r7, Uri r8, String r9, boolean r10, boolean r11, Continuation<? super float[]> r12) {
        Continuation<? super float[]> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        if (r11 == false) goto L7;
        return b(r8, r7, r9, r10, r5);
    L7:
        return c(r7, r8, r9, r10, r5);
    }

    public final Object a(String r13, String r14, boolean r15, long r16, String r18, Continuation<? super String> r19) {
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r19, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new AiKernelRunModelCaller$callBizAsFlow$2(r13, r14, r15, r18, r16, null), Function2.class, "com.obric.memorydata.plugin"), r0);
    }

    public final Object a(String r8, String r9, boolean r10, Continuation<? super float[]> r11) {
        Continuation<? super float[]> r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if (r10 == false) goto L7;
        return a(this, r8, r9, false, r4, 4, null);
    L7:
        return a(r8, r9, r4);
    }

    public final Object a(String r3, String r4, boolean r5, boolean r6, Continuation<? super float[]> r7) {
        Continuation<? super float[]> r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (r6 == false) goto L7;
        return c(r3, r4, r5, r8);
    L7:
        return b(r3, r4, r5, r8);
    }

    public final Object a(String r7, Continuation<? super Map<String, ? extends List<String>>> r8) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, AiKernelRunModelCaller$getModelNameListBy$1.class) == false) goto L7;
        AiKernelRunModelCaller$getModelNameListBy$1 r0 = (AiKernelRunModelCaller$getModelNameListBy$1) ZeusTransformUtils.preCheckCast(r9, AiKernelRunModelCaller$getModelNameListBy$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r7 = (String) ZeusTransformUtils.preCheckCast(r0.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r6);
    L22:
        com.obric.aikernel.res.metadata.config.i r11 = (com.obric.aikernel.res.metadata.config.i) ZeusTransformUtils.preCheckCast(r6, com.obric.aikernel.res.metadata.config.i.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L25;
        JsonObject r12 = AIInferRuntime.f6160a.a(r11);
        if (r12 == null) goto L35;
        JsonArray r13 = r12.getAsJsonArray("dependent_model_packages");
        if (r13 == null) goto L35;
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r14.iterator();
    L32:
        if (r15.hasNext() == false) goto L34;
        r3.add(((JsonElement) ZeusTransformUtils.preCheckCast(r15.next(), JsonElement.class, "com.obric.memorydata.plugin")).getAsString());
        goto L32
    L34:
        List r16 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
    L36:
        JsonObject r17 = AIInferRuntime.f6160a.a(r11);
        if (r17 == null) goto L45;
        JsonArray r18 = r17.getAsJsonArray("dependent_lora_packages");
        if (r18 == null) goto L45;
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r20 = r19.iterator();
    L42:
        if (r20.hasNext() == false) goto L44;
        r1.add(((JsonElement) ZeusTransformUtils.preCheckCast(r20.next(), JsonElement.class, "com.obric.memorydata.plugin")).getAsString());
        goto L42
    L44:
        List r21 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
    L46:
        RunLog.INSTANCE.debug(TAG, "getModelNameListBy papayaPackageName: " + r7 + ", modelList: " + r16 + ", loraList: " + r21);
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("model", r16), TuplesKt.to("lora", r21)});
    L45:
        r21 = CollectionsKt.emptyList();
    L35:
        r16 = CollectionsKt.emptyList();
        goto L36
    L25:
        return MapsKt.emptyMap();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L48;
        if (r7 == null) goto L18;
        MemoryScriptEngineEnv r22 = MemoryScriptEngineEnv.INSTANCE;
        r0.L$0 = r7;
        r0.label = 1;
        r6 = r22.getPackageConfig(r7, r0);
        if (r6 != r10) goto L22;
        return r10;
    L18:
        return MapsKt.emptyMap();
    L48:
        Ensure.ensureNotReachHere("getModelNameListBy called when AIKernel not available");
        throw new RuntimeException("getModelNameListBy called when AIKernel not available");
    L7:
        r0 = new AiKernelRunModelCaller$getModelNameListBy$1(this, r9);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [android.os.Bundle, kotlin.jvm.functions.Function1, kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0127 -> B:32:0x012b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x01a5 -> B:46:0x01a6). Please report as a decompilation issue!!! */
    public final Object a(String r20, String[] r21, String[] r22, String r23, RequestParams r24, boolean r25, Continuation<? super Unit> r26) {
        String[] r0 = r21;
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r26, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, AiKernelRunModelCaller$preloadModels$1.class) == false) goto L7;
        AiKernelRunModelCaller$preloadModels$1 r3 = (AiKernelRunModelCaller$preloadModels$1) ZeusTransformUtils.preCheckCast(r1, AiKernelRunModelCaller$preloadModels$1.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r3.label;
        ?? r11 = 0;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        int r6 = r3.I$1;
        int r7 = r3.I$0;
        String[] r12 = (String[]) ZeusTransformUtils.preCheckCast(r3.L$1, String[].class, "com.obric.memorydata.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(r3.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);
        int r9 = 1;
    L46:
        r7 = r7 + r9;
    L38:
        if (r7 >= r6) goto L48;
        String r10 = r12[r7];
        RunLog.INSTANCE.debug(TAG, "preload lora: " + r10);
        RequestParams r13 = new RequestParams(null, null, 3, null);
        r13.getBackend().putBoolean(Params.NEED_PRELOAD, true);
        r13.getBackend().putFloat(KEY_LOCK_TIME, LOCK_TIME);
        if (r8 == null) goto L42;
        r13.getBackend().putString("_SourcePackageName", r8);
    L42:
        a r14 = INSTANCE;
        Boolean r15 = Boxing.boxBoolean(false);
        r3.L$0 = r8;
        r3.L$1 = r12;
        r3.L$2 = null;
        r3.L$3 = null;
        r3.I$0 = r7;
        r3.I$1 = r6;
        r3.label = 2;
        if (r14.a(r10, r13, r15, r3) != r4) goto L45;
        return r4;
    L45:
        r9 = 1;
    L48:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        int r16 = r3.I$1;
        int r17 = r3.I$0;
        boolean r18 = r3.Z$0;
        String[] r19 = (String[]) ZeusTransformUtils.preCheckCast(r3.L$3, String[].class, "com.obric.memorydata.plugin");
        RequestParams r110 = (RequestParams) ZeusTransformUtils.preCheckCast(r3.L$2, RequestParams.class, "com.obric.memorydata.plugin");
        String r27 = (String) ZeusTransformUtils.preCheckCast(r3.L$1, String.class, "com.obric.memorydata.plugin");
        String[] r28 = (String[]) ZeusTransformUtils.preCheckCast(r3.L$0, String[].class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);
        Object r111 = r4;
        String[] r29 = r28;
        boolean r30 = true;
        RequestParams r31 = r110;
        AiKernelRunModelCaller$preloadModels$1 r32 = r3;
        String r33 = r27;
        int r34 = r16;
        r0 = r19;
    L32:
        int r112 = r17 + 1;
        boolean r35 = r18;
        r11 = 0;
    L23:
        if (r112 >= r34) goto L33;
        String r113 = r0[r112];
        RunLog.INSTANCE.debug(TAG, "preload model: " + r113);
        if (r31 != null) goto L27;
        RequestParams r36 = new RequestParams(r11, r11, 3, r11);
    L28:
        ParamsKt.setPreloadSeconds(r36, 300);
        IAIKernelManager r114 = (IAIKernelManager) ZeusTransformUtils.preCheckCast(AIKernelManager.INSTANCE, IAIKernelManager.class, "com.obric.memorydata.plugin");
        r32.L$0 = r29;
        r32.L$1 = r33;
        r32.L$2 = r31;
        r32.L$3 = r0;
        r32.Z$0 = r35;
        r32.I$0 = r112;
        r32.I$1 = r34;
        r32.label = 1;
        int r115 = r112;
        Object r116 = r111;
        if (IAIKernelManager.DefaultImpls.loadPackage$default(r114, r113, false, r36, r32, 2, null) != r116) goto L31;
        return r116;
    L31:
        r18 = r35;
        r111 = r116;
        r17 = r115;
        r30 = true;
        goto L32
    L27:
        r36 = r31;
        goto L28
    L33:
        r4 = r111;
    L35:
        if (r35 == false) goto L48;
        if (r29 == null) goto L48;
        r6 = r29.length;
        r12 = r29;
        r8 = r33;
        r3 = r32;
        r7 = 0;
        goto L38
    L16:
        ResultKt.throwOnFailure(r2);
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L49;
        if (r25 == true) goto L20;
    L21:
        if (r0 == null) goto L34;
        r35 = r25;
        r34 = r0.length;
        r32 = r3;
        r111 = r4;
        r112 = 0;
        r29 = r22;
        r33 = r23;
        r31 = r24;
        goto L23
    L34:
        r29 = r22;
        r35 = r25;
        r32 = r3;
        r33 = r23;
        goto L35
    L20:
        if (DeviceInfoState.INSTANCE.isSupportVLM() == true) goto L21;
    L49:
        Ensure.ensureNotReachHere("preloadModels called when AIKernel not available");
        throw new RuntimeException("preloadModels called when AIKernel not available");
    L7:
        r3 = new AiKernelRunModelCaller$preloadModels$1(this, r1);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0120 -> B:30:0x0125). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x01d3 -> B:52:0x01d5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x01e2 -> B:54:0x01e7). Please report as a decompilation issue!!! */
    public final Object a(String r21, String[] r22, String[] r23, String r24, boolean r25, Continuation<? super Unit> r26) {
        String[] r0 = r22;
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r26, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, AiKernelRunModelCaller$cancelPreloadModels$1.class) == false) goto L7;
        AiKernelRunModelCaller$cancelPreloadModels$1 r3 = (AiKernelRunModelCaller$cancelPreloadModels$1) ZeusTransformUtils.preCheckCast(r1, AiKernelRunModelCaller$cancelPreloadModels$1.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r3.label;
        if (r5 == 0) goto L18;
        if (r5 == 1) goto L17;
        if (r5 == 2) goto L16;
        if (r5 != 3) goto L15;
        int r6 = r3.I$1;
        int r7 = r3.I$0;
        String[] r8 = (String[]) ZeusTransformUtils.preCheckCast(r3.L$1, String[].class, "com.obric.memorydata.plugin");
        String r12 = (String) ZeusTransformUtils.preCheckCast(r3.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);
    L52:
        Response r9 = (Response) ZeusTransformUtils.preCheckCast(r2, Response.class, "com.obric.memorydata.plugin");
        String[] r10 = r8;
        Object r11 = r4;
        AiKernelRunModelCaller$cancelPreloadModels$1 r13 = r3;
        String r14 = r12;
    L54:
        Object r19 = r11;
        int r15 = r7 + 1;
        Object r16 = r19;
    L38:
        if (r15 >= r6) goto L56;
        String r17 = r10[r15];
        RunLog.INSTANCE.debug(TAG, "cancelPreloadModel lora: " + r17);
        RequestParams r18 = new RequestParams(null, null, 3, null);
        r18.getBackend().putFloat(KEY_LOCK_TIME, 0.0f);
        r18.getBackend().putString(IdlKeys.Args_Infer_Event, "updateLock");
        if (r14 == null) goto L42;
        r18.getBackend().putString("_SourcePackageName", r14);
    L42:
        a r110 = INSTANCE;
        r13.L$0 = r14;
        r13.L$1 = r10;
        r13.L$2 = r18;
        r13.I$0 = r15;
        r13.I$1 = r6;
        r13.label = 2;
        Object r111 = a(r110, r17, null, null, r13, 6, null);
        if (r111 != r16) goto L45;
        return r16;
    L45:
        String r112 = r14;
        r3 = r13;
        r4 = r16;
        r7 = r15;
        RequestParams r20 = r18;
        String[] r113 = r10;
        r2 = r111;
    L46:
        IBaseModel r27 = (IBaseModel) ZeusTransformUtils.preCheckCast(r2, IBaseModel.class, "com.obric.memorydata.plugin");
        if (r27 == null) goto L53;
        r3.L$0 = r112;
        r3.L$1 = r113;
        r3.L$2 = null;
        r3.I$0 = r7;
        r3.I$1 = r6;
        r3.label = 3;
        r2 = r27.infer(r20, r3);
        if (r2 != r4) goto L51;
        return r4;
    L51:
        r8 = r113;
        r12 = r112;
        goto L52
    L53:
        r11 = r4;
        r10 = r113;
        r13 = r3;
        r14 = r112;
    L56:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r6 = r3.I$1;
        r7 = r3.I$0;
        r20 = (RequestParams) ZeusTransformUtils.preCheckCast(r3.L$2, RequestParams.class, "com.obric.memorydata.plugin");
        r113 = (String[]) ZeusTransformUtils.preCheckCast(r3.L$1, String[].class, "com.obric.memorydata.plugin");
        r112 = (String) ZeusTransformUtils.preCheckCast(r3.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);
        goto L46
    L17:
        int r28 = r3.I$1;
        int r29 = r3.I$0;
        boolean r114 = r3.Z$0;
        String[] r115 = (String[]) ZeusTransformUtils.preCheckCast(r3.L$2, String[].class, "com.obric.memorydata.plugin");
        String r116 = (String) ZeusTransformUtils.preCheckCast(r3.L$1, String.class, "com.obric.memorydata.plugin");
        String[] r30 = (String[]) ZeusTransformUtils.preCheckCast(r3.L$0, String[].class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);
        int r31 = r28;
        AiKernelRunModelCaller$cancelPreloadModels$1 r32 = r3;
        r0 = r115;
        r14 = r116;
        Object r117 = r4;
        boolean r33 = r114;
    L30:
        IBaseModel r34 = (IBaseModel) ZeusTransformUtils.preCheckCast(r2, IBaseModel.class, "com.obric.memorydata.plugin");
        if (r34 == null) goto L33;
        r34.close();
    L33:
        int r118 = r29 + 1;
        r10 = r30;
        int r35 = r31;
        AiKernelRunModelCaller$cancelPreloadModels$1 r36 = r32;
    L25:
        if (r118 >= r35) goto L35;
        String r119 = r0[r118];
        RunLog.INSTANCE.debug(TAG, "cancelPreloadModel model: " + r119);
        a r37 = INSTANCE;
        r36.L$0 = r10;
        r36.L$1 = r14;
        r36.L$2 = r0;
        r36.Z$0 = r33;
        r36.I$0 = r118;
        r36.I$1 = r35;
        r36.label = 1;
        Object r38 = r37.b(r119, r36);
        if (r38 != r117) goto L29;
        return r117;
    L29:
        r32 = r36;
        r30 = r10;
        r2 = r38;
        r31 = r35;
        r29 = r118;
    L35:
        if (r33 == false) goto L56;
        if (r10 == null) goto L56;
        r6 = r10.length;
        r13 = r36;
        r16 = r117;
        r15 = 0;
        goto L38
    L18:
        ResultKt.throwOnFailure(r2);
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L57;
        if (r25 == true) goto L22;
    L23:
        if (r0 == null) goto L34;
        r35 = r0.length;
        r36 = r3;
        r117 = r4;
        r118 = 0;
        r10 = r23;
        r14 = r24;
        r33 = r25;
        goto L25
    L34:
        r10 = r23;
        r36 = r3;
        r117 = r4;
        r14 = r24;
        r33 = r25;
        goto L35
    L22:
        if (DeviceInfoState.INSTANCE.isSupportVLM() == true) goto L23;
    L57:
        Ensure.ensureNotReachHere("cancelPreloadModels called when AIKernel not available");
        throw new RuntimeException("cancelPreloadModels called when AIKernel not available");
    L7:
        r3 = new AiKernelRunModelCaller$cancelPreloadModels$1(this, r1);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object a(Collection<String> r22, Function1<? super Boolean, Unit> r23, Continuation<? super Boolean> r24) {
        a r0 = this;
        Collection<String> r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r22, Collection.class, "com.obric.memorydata.plugin");
        Function1<? super Boolean, Unit> r3 = (Function1) ZeusTransformUtils.wrapperContextForParams(r23, Function1.class, "com.obric.memorydata.plugin");
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r24, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, AiKernelRunModelCaller$checkOrLoadModels$1.class) == false) goto L7;
        AiKernelRunModelCaller$checkOrLoadModels$1 r5 = (AiKernelRunModelCaller$checkOrLoadModels$1) ZeusTransformUtils.preCheckCast(r4, AiKernelRunModelCaller$checkOrLoadModels$1.class, "com.obric.memorydata.plugin");
        if ((r5.label & Integer.MIN_VALUE) == 0) goto L7;
        r5.label -= Integer.MIN_VALUE;
    L8:
        Object r6 = r5.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r8 = r5.label;
        int r10 = 1;
        if (r8 == 0) goto L16;
        if (r8 == 1) goto L15;
        if (r8 != 2) goto L14;
        boolean r2 = r5.Z$0;
        ResultKt.throwOnFailure(r6);
    L45:
        boolean r9 = r2;
    L47:
        return Boxing.boxBoolean(r9);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r3 = (Function1) ZeusTransformUtils.preCheckCast(r5.L$2, Function1.class, "com.obric.memorydata.plugin");
        r1 = (Collection) ZeusTransformUtils.preCheckCast(r5.L$1, Collection.class, "com.obric.memorydata.plugin");
        r0 = (a) ZeusTransformUtils.preCheckCast(r5.L$0, a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r6);
    L25:
        Map r11 = (Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.memorydata.plugin");
        List<String> r12 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L27:
        if (r13.hasNext() == false) goto L38;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.memorydata.plugin");
        Integer r15 = (Integer) ZeusTransformUtils.preCheckCast(r11.get(r14), Integer.class, "com.obric.memorydata.plugin");
        boolean r16 = 0;
        if (r15 == null) goto L31;
        int r17 = r15.intValue();
    L32:
        if (r17 != r10) goto L34;
        r16 = r10;
    L34:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, r14 + " model is ready: " + r16, false, 4, null);
        if (r16 != 0) goto L37;
        r12.add(r14);
    L37:
        r10 = 1;
        goto L27
    L31:
        r17 = 0;
        goto L32
    L38:
        r9 = r12.isEmpty();
        if (r9 == false) goto L41;
        RunLog.INSTANCE.debug(TAG, "checkOrLoadModels " + r1 + " success");
        goto L47
    L41:
        RunLog.INSTANCE.debug(TAG, "checkOrLoadModels failed, undownloaded Models: " + r12);
        r5.L$0 = null;
        r5.L$1 = null;
        r5.L$2 = null;
        r5.Z$0 = r9;
        r5.label = 2;
        if (r0.b(r12, r3, r5) != r7) goto L44;
        return r7;
    L44:
        r2 = r9;
        goto L45
    L16:
        ResultKt.throwOnFailure(r6);
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == true) goto L19;
        Ensure.ensureNotReachHere("checkOrLoadModels called when AIKernel not available");
        throw new RuntimeException("checkOrLoadModels called when AIKernel not available");
    L19:
        if (r1.isEmpty() == true) goto L21;
        RunLog.INSTANCE.debug(TAG, "start check models state: " + r1);
        r5.L$0 = r0;
        r5.L$1 = r1;
        r5.L$2 = r3;
        r5.label = 1;
        r6 = r0.a(r1, r5);
        if (r6 != r7) goto L25;
        return r7;
    L21:
        return Boxing.boxBoolean(true);
    L7:
        r5 = new AiKernelRunModelCaller$checkOrLoadModels$1(r0, r4);
        goto L8
    }

    public final void a(JSONObject r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "sourceArgs");
        if (r10 != null) goto L6;
        return;
    L6:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L8;
        boolean r8 = true;
    L9:
        if (r8 == false) goto L12;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "topPkg is " + r10, false, 4, null);
        r9.put("_SourcePackageName", r10);
        r9.put("_Priority", 1);
        r9.put("_ForceExecute", 1);
        return;
    L12:
        return;
    L8:
        r8 = false;
        goto L9
    }

    public final Object b(String r9, Uri r10, String r11, boolean r12, Continuation<? super String> r13) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new AiKernelRunModelCaller$runTagsJob$2(r9, r10, r11, r12, null), Function2.class, "com.obric.memorydata.plugin"), r8);
    }

    public final Object b(String r13, String r14, boolean r15, long r16, String r18, Continuation<? super ScriptModelResult> r19) {
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r19, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new AiKernelRunModelCaller$callBizAsFlowWithLogId$2(r13, r14, r15, r18, r16, null), Function2.class, "com.obric.memorydata.plugin"), r0);
    }

    public final Object b(Collection<String> r21, Function1<? super Boolean, Unit> r22, Continuation<? super Boolean> r23) {
        a r0 = this;
        Collection<String> r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r21, Collection.class, "com.obric.memorydata.plugin");
        Function1<? super Boolean, Unit> r3 = (Function1) ZeusTransformUtils.wrapperContextForParams(r22, Function1.class, "com.obric.memorydata.plugin");
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r23, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, AiKernelRunModelCaller$checkOrLoadLoras$1.class) == false) goto L7;
        AiKernelRunModelCaller$checkOrLoadLoras$1 r5 = (AiKernelRunModelCaller$checkOrLoadLoras$1) ZeusTransformUtils.preCheckCast(r4, AiKernelRunModelCaller$checkOrLoadLoras$1.class, "com.obric.memorydata.plugin");
        if ((r5.label & Integer.MIN_VALUE) == 0) goto L7;
        r5.label -= Integer.MIN_VALUE;
    L8:
        Object r6 = r5.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r8 = r5.label;
        if (r8 == 0) goto L16;
        if (r8 == 1) goto L15;
        if (r8 != 2) goto L14;
        boolean r2 = r5.Z$0;
        ResultKt.throwOnFailure(r6);
    L46:
        boolean r9 = r2;
    L48:
        return Boxing.boxBoolean(r9);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r3 = (Function1) ZeusTransformUtils.preCheckCast(r5.L$2, Function1.class, "com.obric.memorydata.plugin");
        r1 = (Collection) ZeusTransformUtils.preCheckCast(r5.L$1, Collection.class, "com.obric.memorydata.plugin");
        r0 = (a) ZeusTransformUtils.preCheckCast(r5.L$0, a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r6);
    L27:
        Map r10 = (Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.memorydata.plugin");
        List<String> r11 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L29:
        if (r12.hasNext() == false) goto L39;
        String r13 = (String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.memorydata.plugin");
        Integer r14 = (Integer) ZeusTransformUtils.preCheckCast(r10.get(r13), Integer.class, "com.obric.memorydata.plugin");
        boolean r15 = false;
        if (r14 == null) goto L33;
        int r16 = r14.intValue();
    L34:
        if (r16 != 1) goto L36;
        r15 = true;
    L36:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, r13 + " loraType is ready: " + r15, false, 4, null);
        if (r15 == true) goto L29;
        r11.add(r13);
        goto L29
    L33:
        r16 = 0;
        goto L34
    L39:
        r9 = r11.isEmpty();
        if (r9 == false) goto L42;
        RunLog.INSTANCE.debug(TAG, "checkOrLoadLoras " + r11 + " success");
        goto L48
    L42:
        RunLog.INSTANCE.debug(TAG, "checkOrLoadModels failed, undownloaded Loras: " + r11);
        r5.L$0 = null;
        r5.L$1 = null;
        r5.L$2 = null;
        r5.Z$0 = r9;
        r5.label = 2;
        if (r0.a(r11, r3, r5) != r7) goto L45;
        return r7;
    L45:
        r2 = r9;
        goto L46
    L16:
        ResultKt.throwOnFailure(r6);
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == true) goto L19;
    L49:
        Ensure.ensureNotReachHere("checkOrLoadLoras called when AIKernel not available");
        throw new RuntimeException("checkOrLoadLoras called when AIKernel not available");
    L19:
        if (DeviceInfoState.INSTANCE.isSupportVLM() == false) goto L49;
        if (r1.isEmpty() == true) goto L23;
        RunLog.INSTANCE.debug(TAG, "start check loras state: " + r1);
        r5.L$0 = r0;
        r5.L$1 = r1;
        r5.L$2 = r3;
        r5.label = 1;
        r6 = r0.b(r1, r5);
        if (r6 != r7) goto L27;
        return r7;
    L23:
        return Boxing.boxBoolean(true);
    L7:
        r5 = new AiKernelRunModelCaller$checkOrLoadLoras$1(r0, r4);
        goto L8
    }
}
