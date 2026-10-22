package com.larus.drive.sdk.impl;

import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.constants.AscOrder;
import com.bytedance.ee.bear.list.constants.RankType;
import com.bytedance.ee.bear.list.create.r0;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority;
import com.bytedance.ee.bear.middleground.drive.export.UploadRequestInfo;
import com.bytedance.ee.permission.PermissionSdk;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.Gson;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.icon.CommonFileIconType;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.drive.biz.api.DrivePreloadScene;
import com.larus.drive.biz.api.IDriveService;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.biz.api.model.DriveListLoadType;
import com.larus.drive.biz.impl.view.AbsDriveListFragment;
import com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel;
import com.larus.drive.biz.impl.viewmodel.a0;
import com.larus.drive.biz.impl.viewmodel.r;
import com.larus.drive.biz.impl.viewmodel.z;
import com.larus.drive.sdk.api.DrivePickerScene;
import com.larus.drive.sdk.api.IDriveSdkService;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.drive.sdk.api.file.download.DriveDownloadPriority;
import com.larus.drive.sdk.api.file.list.RequestDriveFileListRankType;
import com.larus.drive.sdk.api.file.upload.DriveUploadPriority;
import com.larus.drive.sdk.impl.gallery.DriveGalleryHelper;
import com.larus.drive.sdk.impl.utils.MorePanelHelper;
import com.larus.drive.sdk.impl.utils.RegisterDriveResourceHelper;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.platform.model.OfficeAskDoubaoType;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.lark.picker.doubao.IDoubaoPickerController;
import com.ss.android.lark.picker.doubao.api.IDoubaoPicker;
import com.ss.android.lark.picker.doubao.entity.CheckBoxBindStatus;
import com.ss.android.lark.picker.doubao.entity.DobaoPickerScene;
import com.ss.android.lark.picker.doubao.entity.DoubaoPickerConfig;
import com.ss.android.lark.picker.doubao.entity.DoubaoPickerEntity;
import com.ss.android.lark.picker.doubao.entity.condition.DoubaoDocType;
import com.ss.android.lark.picker.doubao.entity.condition.DoubaoDocTypes;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import hq9.d2;
import hq9.e2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;
import tx9.p1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000þ\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0007\u0018\u0000 Â\u00012\u00020\u0001:\u0004Â\u0001Ã\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001bH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u001bH\u0002J\u0010\u0010$\u001a\u0004\u0018\u00010\u0005H\u0082@¢\u0006\u0002\u0010%J\u0012\u0010&\u001a\u00020\u001b2\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\u0012\u0010)\u001a\u00020\u001b2\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\u0010\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020,H\u0002JF\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\"2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020 2\b\u00105\u001a\u0004\u0018\u00010\"2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0016JT\u0010:\u001a\u0004\u0018\u00010.2\b\u0010;\u001a\u0004\u0018\u00010\"2\u0006\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010\"2\u0016\u0010?\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010A\u0012\u0004\u0012\u00020\u001b\u0018\u00010@2\u0014\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001b\u0018\u00010@H\u0016JJ\u0010C\u001a\u0004\u0018\u00010.2\u0006\u0010D\u001a\u00020\"2\u0006\u0010E\u001a\u00020 2\b\u0010F\u001a\u0004\u0018\u00010\"2\u000e\u0010?\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010G2\u0014\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001b\u0018\u00010@H\u0016JH\u0010H\u001a\u0004\u0018\u00010.2\u0006\u0010D\u001a\u00020\"2\u0006\u0010E\u001a\u00020 2\u0006\u0010>\u001a\u00020\"2\u000e\u0010?\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010G2\u0014\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001b\u0018\u00010@H\u0016J@\u0010I\u001a\u0004\u0018\u00010.2\u0006\u0010J\u001a\u00020A2\u0006\u0010/\u001a\u0002002\u000e\u0010?\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010G2\u0014\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001b\u0018\u00010@H\u0016JR\u0010K\u001a\u0004\u0018\u00010.2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020A0M2\u0006\u0010/\u001a\u0002002\u000e\u0010?\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010G2 \u0010N\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020 0O\u0012\u0004\u0012\u00020\u001b\u0018\u00010@H\u0016Ja\u0010P\u001a\u0004\u0018\u00010\"2\b\u0010Q\u001a\u0004\u0018\u00010\u00112\u0006\u0010R\u001a\u00020\"2\u0006\u0010S\u001a\u00020 2\u0006\u0010T\u001a\u00020 2#\u0010?\u001a\u001f\u0012\u0013\u0012\u00110\"¢\u0006\f\bU\u0012\b\bV\u0012\u0004\b\b(W\u0012\u0004\u0012\u00020\u001b\u0018\u00010@2\u000e\u0010N\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010GH\u0016J\u0018\u0010X\u001a\u00020\u001b2\u0006\u0010J\u001a\u00020A2\u0006\u0010Y\u001a\u00020ZH\u0016J(\u0010[\u001a\u00020\u001b2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010R\u001a\u00020\"2\u0006\u0010\\\u001a\u00020 2\u0006\u0010]\u001a\u00020\"H\u0016J\u0018\u0010[\u001a\u00020\u001b2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010W\u001a\u00020\"H\u0016J\b\u0010^\u001a\u000203H\u0016J8\u0010_\u001a\u0004\u0018\u00010`2\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020f2\u0006\u00108\u001a\u00020g2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020A0MH\u0016J\u0010\u0010i\u001a\u00020\u001b2\u0006\u0010e\u001a\u00020jH\u0002J\u0012\u0010k\u001a\u00020\"*\b\u0012\u0004\u0012\u00020l0MH\u0002J\f\u0010k\u001a\u00020\"*\u00020lH\u0002J(\u0010m\u001a\u00020\"2\u0006\u0010n\u001a\u00020o2\u0006\u0010R\u001a\u00020\"2\u0006\u0010S\u001a\u00020 2\u0006\u0010T\u001a\u00020 H\u0002J*\u0010p\u001a\u0004\u0018\u00010\"2\u0006\u0010D\u001a\u00020\"2\u0006\u0010q\u001a\u00020\"2\u0006\u0010r\u001a\u00020s2\u0006\u00108\u001a\u00020tH\u0016J2\u0010p\u001a\u00020\u001b2\u0006\u0010J\u001a\u00020A2\u0006\u0010u\u001a\u00020v2\u0006\u0010Q\u001a\u00020\u00112\u0006\u0010r\u001a\u00020s2\b\u0010w\u001a\u0004\u0018\u00010xH\u0016J\u0016\u0010y\u001a\u00020\u001b2\f\u0010z\u001a\b\u0012\u0004\u0012\u00020\"0MH\u0016J\u0018\u0010{\u001a\u00020\u001b2\u0006\u0010J\u001a\u00020A2\u0006\u0010|\u001a\u00020}H\u0016J4\u0010~\u001a\u0004\u0018\u00010\"2\u0006\u0010>\u001a\u00020\"2\u0006\u0010\u007f\u001a\u00020\"2\u0006\u0010;\u001a\u00020\"2\u0007\u0010r\u001a\u00030\u0080\u00012\u0007\u00108\u001a\u00030\u0081\u0001H\u0016J\u001d\u0010\u0082\u0001\u001a\u0004\u0018\u00010\"2\u0007\u0010\u0083\u0001\u001a\u00020\"2\u0007\u00108\u001a\u00030\u0081\u0001H\u0016J\u0017\u0010\u0084\u0001\u001a\u0002032\f\u0010z\u001a\b\u0012\u0004\u0012\u00020\"0MH\u0016J_\u0010\u0085\u0001\u001a\u0004\u0018\u00010\"2\u0006\u0010>\u001a\u00020\"2\u0006\u0010\u007f\u001a\u00020\"2\u0007\u0010\u0086\u0001\u001a\u00020\"2\u0007\u0010\u0087\u0001\u001a\u00020\"2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\"2\u0013\u0010\u0089\u0001\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"0O2\u0007\u0010r\u001a\u00030\u0080\u00012\u0007\u00108\u001a\u00030\u008a\u0001H\u0016J\u001d\u0010\u008b\u0001\u001a\u0004\u0018\u00010\"2\u0007\u0010\u0083\u0001\u001a\u00020\"2\u0007\u00108\u001a\u00030\u008a\u0001H\u0016J\t\u0010\u008c\u0001\u001a\u00020\u001bH\u0016J\u0011\u0010\u008d\u0001\u001a\u00020\u001b2\u0006\u0010J\u001a\u00020AH\u0016JR\u0010\u008e\u0001\u001a\u00020\u001b2\u0007\u0010\u008f\u0001\u001a\u00020A2\u0006\u0010Q\u001a\u00020\u00112&\u0010?\u001a\"\u0012\u0016\u0012\u0014\u0018\u00010\"¢\u0006\r\bU\u0012\t\bV\u0012\u0005\b\b(\u0090\u0001\u0012\u0004\u0012\u00020\u001b\u0018\u00010@2\u000e\u0010N\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010GH\u0016J\u001f\u0010\u0091\u0001\u001a\u00020\u001b2\b\u0010\u0092\u0001\u001a\u00030\u0093\u00012\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u0001H\u0016J0\u0010\u0091\u0001\u001a\u00020\u001b2\u0006\u0010D\u001a\u00020\"2\u0007\u0010\u0096\u0001\u001a\u00020 2\b\u0010>\u001a\u0004\u0018\u00010\"2\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u0001H\u0016J\u0013\u0010\u0097\u0001\u001a\u00020\u001b2\b\u0010\u0098\u0001\u001a\u00030\u0099\u0001H\u0016J\t\u0010\u009a\u0001\u001a\u00020\u001bH\u0002J\n\u0010\u009b\u0001\u001a\u00030\u0099\u0001H\u0016J\u0011\u0010\u009c\u0001\u001a\u0002032\u0006\u0010D\u001a\u00020\"H\u0016J,\u0010\u009d\u0001\u001a\u0004\u0018\u00010A2\u0006\u0010D\u001a\u00020\"2\u0007\u0010\u009e\u0001\u001a\u00020 2\u0007\u0010\u009f\u0001\u001a\u000203H\u0096@¢\u0006\u0003\u0010 \u0001J\u0012\u0010¡\u0001\u001a\u00020\u001b2\u0007\u00108\u001a\u00030¢\u0001H\u0016J*\u0010£\u0001\u001a\u00020 2\u0006\u0010D\u001a\u00020\"2\u0007\u0010¤\u0001\u001a\u00020 2\u0007\u0010¥\u0001\u001a\u00020\"H\u0096@¢\u0006\u0003\u0010¦\u0001J\u0012\u0010§\u0001\u001a\u00020\"2\u0007\u0010¨\u0001\u001a\u00020,H\u0016J\u000f\u0010©\u0001\u001a\b\u0012\u0004\u0012\u00020 0MH\u0016J1\u0010ª\u0001\u001a\u00020.2\u0007\u0010«\u0001\u001a\u00020\"2\u0006\u00108\u001a\u0002092\u0015\u0010¬\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010.0@H\u0002J-\u0010\u00ad\u0001\u001a\u0004\u0018\u00010.2\u0006\u00104\u001a\u00020 2\b\u00105\u001a\u0004\u0018\u00010\"2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0002JA\u0010®\u0001\u001a\u0004\u0018\u00010.2\b\u0010R\u001a\u0004\u0018\u00010\"2\u0006\u00104\u001a\u00020 2\b\u00105\u001a\u0004\u0018\u00010\"2\u0006\u00106\u001a\u0002072\b\b\u0002\u00102\u001a\u0002032\u0006\u00108\u001a\u000209H\u0002J\r\u0010¯\u0001\u001a\u00020A*\u00020lH\u0002J\r\u0010°\u0001\u001a\u00020l*\u00020AH\u0002J\u0019\u0010±\u0001\u001a\b\u0012\u0004\u0012\u00020A0M*\b\u0012\u0004\u0012\u00020l0MH\u0002J\u0014\u0010²\u0001\u001a\b\u0012\u0004\u0012\u00020A0M*\u00030³\u0001H\u0002J\u000f\u0010´\u0001\u001a\u00030µ\u0001*\u00030¶\u0001H\u0002J\u001b\u0010·\u0001\u001a\u00020=2\u0006\u0010\\\u001a\u00020 2\b\u0010>\u001a\u0004\u0018\u00010\"H\u0002J\u0018\u0010¸\u0001\u001a\u00020 *\u00020=2\t\u0010¹\u0001\u001a\u0004\u0018\u00010\"H\u0002J\u0013\u0010º\u0001\u001a\u00030»\u00012\u0007\u00108\u001a\u00030\u0081\u0001H\u0002J\u0013\u0010¼\u0001\u001a\u00030»\u00012\u0007\u00108\u001a\u00030\u008a\u0001H\u0002J\u0013\u0010½\u0001\u001a\u0002032\b\u0010¾\u0001\u001a\u00030¿\u0001H\u0002J\u0012\u0010À\u0001\u001a\u0002032\u0007\u0010Á\u0001\u001a\u00020 H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Ä\u0001"}, d2 = {"Lcom/larus/drive/sdk/impl/DriveSdkServiceImpl;", "Lcom/larus/drive/sdk/api/IDriveSdkService;", "<init>", "()V", "docSdk", "Lcom/bytedance/ee/bear/office/export/docs/IDocsSdk;", "doubaoPicker", "Lcom/ss/android/lark/picker/doubao/api/IDoubaoPicker;", "driveUploadDownloadService", "Lcom/bytedance/ee/bear/drive/sdk/service/IDriveUploadDownloadService;", "fileService", "Lcom/larus/drive/sdk/api/service/IDriveFileService;", "hasTriggeredDriveManagePreloadOnOfficeReady", "Ljava/util/concurrent/atomic/AtomicBoolean;", "menuConfigGson", "Lcom/google/gson/Gson;", "menuConfigScope", "Lkotlinx/coroutines/CoroutineScope;", "menuConfigGeneration", "Ljava/util/concurrent/atomic/AtomicLong;", "menuConfigCommitLock", "", "menuConfigInstallJob", "Lkotlinx/coroutines/Job;", "menuConfigOfficeSpaceSdk", "Lcom/bytedance/ee/bear/office/export/space/IOfficeSpaceSdk;", "initDocSdk", "", "officeSDKUserApi", "Lcom/ss/android/lark/officesdk/api/api/OfficeSDKUserApi;", "destroyDocSdk", "lifecycleOrder", "", "lifecycleCategory", "", "ensureOfficeSdkInitialized", "awaitOfficeDocsSdk", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preloadDriveManagePageOnOfficeReadyIfNeeded", "ccmService", "Lcom/bytedance/ee/bear/office/export/IOfficeCCMService;", "installOfficeSpaceMenuConfigOnInit", "buildOfficeSpaceMenuConfigJson", "generation", "", "requestDriveFileList", "Lcom/bytedance/ee/bear/list/callback/ICancelable;", "loadType", "Lcom/larus/drive/biz/api/model/DriveListLoadType;", "parentToken", "onlyFolder", "", "length", "loadMoreLabel", "rankType", "Lcom/larus/drive/sdk/api/file/list/RequestDriveFileListRankType;", "callback", "Lcom/larus/drive/sdk/api/file/list/IRequestDriveFileListCallback;", "createDriveFile", "parentDriveToken", "type", "Lcom/larus/drive/biz/api/model/DriveFileType;", "fileName", "onSuccess", "Lkotlin/Function1;", "Lcom/larus/drive/sdk/api/file/DriveFileItem;", "onError", "moveDriveFile", "fileToken", "driveObjType", "parentFolderToken", "Lkotlin/Function0;", "renameDriveFile", "deleteDriveFile", "file", "deleteDriveFiles", "fileList", "", "onFailure", "", "getImageCoverUrl", "scope", "token", "height", "width", "Lkotlin/ParameterName;", "name", "url", "loadFileTypeIcon", "imageView", "Landroid/widget/ImageView;", "loadDocumentIcon", "objType", "iconInfo", "isPickerInitialized", "attachPickerView", "Lcom/larus/drive/sdk/api/file/picker/IDrivePickerController;", "pickerScene", "Lcom/larus/drive/sdk/api/DrivePickerScene;", "activity", "Landroidx/fragment/app/FragmentActivity;", "rootView", "Landroid/view/ViewGroup;", "Lcom/larus/drive/sdk/api/file/picker/IDrivePickerViewCallback;", "preSelectedDriveItems", "refreshPickerRecyclerViews", "Landroid/view/View;", "toStr", "Lcom/ss/android/lark/picker/doubao/entity/DoubaoPickerEntity;", "doGetCoverUrl", "coverLoader", "Lcom/bytedance/ee/bear/list/cover/ICoverLoader;", "downloadDriveFile", "localPath", "priority", "Lcom/larus/drive/sdk/api/file/download/DriveDownloadPriority;", "Lcom/larus/drive/sdk/api/file/download/IDriveDownloadCallback;", "context", "Landroid/content/Context;", "fragment", "Landroidx/fragment/app/Fragment;", "cancelDownloadDriveFile", "taskKeys", "shareDriveFile", "param", "Lcom/larus/share/bean/DriveShareEventParam;", "startUploadingDriveFile", "uri", "Lcom/larus/drive/sdk/api/file/upload/DriveUploadPriority;", "Lcom/larus/drive/sdk/api/file/upload/IDriveUploadCallback;", "resumeUploadingDriveFile", "taskId", "cancelUploadDriveFile", "startUploadingDriveFileToMountPoint", "mountPoint", "mountNodeToken", "uploadCode", "extraRust", "Lcom/larus/drive/sdk/api/file/upload/IDriveMountUploadCallback;", "resumeUploadingDriveFileToMountPoint", "clearDriveUploadTasks", "refreshVisitedTime", "registerDriveResource", "item", "resourceId", "previewDriveFile", "galleryContext", "Lcom/larus/drive/sdk/api/gallery/bean/DriveGalleryContext;", "args", "Landroid/os/Bundle;", "ccmType", "updateDriveMetaInfo", "info", "Lcom/larus/drive/sdk/api/meta/DriveMetaInfo;", "clearOfficeSpaceMenuConfigOnSdkClear", "getDriveMetaInfo", "getDriveFilePermission", "fetchDriveFileInfo", "fileObjType", "markVisit", "(Ljava/lang/String;IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initLocalDbService", "Lcom/larus/drive/sdk/api/file/database/ILocalDatabaseCallback;", "validateDriveFileInLarkSecurityControl", "fileType", "operation", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "formatFileTime", "timestamp", "getFileTypeInList", "retryListRequestAfterDocSdkInit", "driveScene", "fetch", "requestRecentDriveFileList", "requestMyDriveFileList", "toDriveFile", "toDoubaoPickerEntity", "toDriveFileItemList", "toDriveFileList", "Lcom/bytedance/ee/bear/list/DocumentListInfo;", "toCheckBoxBindStatus", "Lcom/ss/android/lark/picker/doubao/entity/CheckBoxBindStatus;", "Lcom/larus/drive/sdk/api/file/picker/DrivePickerCheckBoxBindStatus;", "getDriveFileTypeFromObjType", "resolveIconResId", "fileUrl", "getUploadCallback", "Lcom/bytedance/ee/bear/middleground/drive/export/UploadCallback;", "getMountUploadCallback", "isDriveUpdateError", "t", "", "isDriveUpdateErrorCode", "code", "Companion", "RetryCancelable", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveSdkServiceImpl implements IDriveSdkService {
    public static final /* synthetic */ int l = 0;
    public ik5.a a;
    public IDoubaoPicker b;
    public com.bytedance.ee.bear.drive.sdk.service.g c;
    public final e89.c d;
    public final AtomicBoolean e;
    public final Gson f;
    public final CoroutineScope g;
    public final AtomicLong h;
    public final Object i;
    public volatile Job j;
    public volatile com.bytedance.ee.bear.office.export.space.a k;

    public static final class a {
    }

    public static final class b implements nc5.b {
        public volatile boolean a;
        public volatile nc5.b b;

        public b() {
        }

        public final void cancel() {
            this.a = true;
            nc5.b r0 = this.b;
            if (r0 == null) goto L6;
            r0.cancel();
            return;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;

        static {
            int[] r0 = new int[DriveListLoadType.values().length];
            r0[DriveListLoadType.FOLDER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L30:
            r0[DriveListLoadType.RECENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L6:
            a = r0;
            int[] r1 = new int[DriveFileType.values().length];
            r1[DriveFileType.AI_DOC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L42:
            r1[DriveFileType.AI_SLIDES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L34:
            r1[DriveFileType.AI_SHEET.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L36:
            r1[DriveFileType.BITABLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L22
        L26:
            r1[DriveFileType.FOLDER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L23
        L12:
            b = r1;
            int[] r2 = new int[DrivePickerScene.values().length];
            r2[DrivePickerScene.FINDER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L38:
            r2[DrivePickerScene.FILE_SELECTOR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L15:
            c = r2;
        }
    }

    public static final class d implements w79.b {
        public final /* synthetic */ IDoubaoPickerController a;
        public final /* synthetic */ DriveSdkServiceImpl b;
        public final /* synthetic */ ViewGroup c;

        @Override // w79.b
        public final void finishSelectMoreList() {
            this.a.finishSelectMoreList();
        }

        @Override // w79.b
        public final void deselectItem(List<DriveFileItem> r6) {
            Intrinsics.checkNotNullParameter(r6, "entities");
            if (r6.isEmpty() == false) goto L5;
            return;
        L5:
            IDoubaoPickerController r0 = this.a;
            List<DriveFileItem> r7 = r6;
            DriveSdkServiceImpl r1 = this.b;
            ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
            Iterator<T> r8 = r7.iterator();
        L7:
            if (r8.hasNext() == false) goto L9;
            DriveFileItem r3 = (DriveFileItem) r8.next();
            int r4 = DriveSdkServiceImpl.l;
            r1.getClass();
            r2.add(DriveSdkServiceImpl.F0(r3));
            goto L7
        L9:
            r0.deselectItem(r2);
        }

        @Override // w79.b
        public final void selectItem(List<DriveFileItem> r6) {
            Intrinsics.checkNotNullParameter(r6, "entities");
            if (r6.isEmpty() == false) goto L5;
            return;
        L5:
            IDoubaoPickerController r0 = this.a;
            List<DriveFileItem> r7 = r6;
            DriveSdkServiceImpl r1 = this.b;
            ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
            Iterator<T> r8 = r7.iterator();
        L7:
            if (r8.hasNext() == false) goto L9;
            DriveFileItem r3 = (DriveFileItem) r8.next();
            int r4 = DriveSdkServiceImpl.l;
            r1.getClass();
            r2.add(DriveSdkServiceImpl.F0(r3));
            goto L7
        L9:
            r0.selectItem(r2);
        }

        public d(IDoubaoPickerController r1, DriveSdkServiceImpl r2, ViewGroup r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class e implements DoubaoPickerConfig.IOnBusinessConsumeItem {
        public final /* synthetic */ DriveSdkServiceImpl a;
        public final /* synthetic */ w79.c b;

        public final CheckBoxBindStatus onBusinessBindItemCheckBox(DoubaoPickerEntity r4) {
            Intrinsics.checkNotNullParameter(r4, "data");
            DriveSdkServiceImpl r0 = this.a;
            w79.c r1 = this.b;
            int r2 = DriveSdkServiceImpl.l;
            r0.getClass();
            w79.a r5 = r1.e(DriveSdkServiceImpl.G0(r4));
            return new CheckBoxBindStatus(r5.a, r5.b, r5.c);
        }

        public final boolean onBusinessConsumeItemClick(DoubaoPickerEntity r4) {
            Intrinsics.checkNotNullParameter(r4, "data");
            w79.c r0 = this.b;
            DriveSdkServiceImpl r1 = this.a;
            int r2 = DriveSdkServiceImpl.l;
            r1.getClass();
            return r0.c(DriveSdkServiceImpl.G0(r4));
        }

        public e(DriveSdkServiceImpl r1, w79.c r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class f extends DoubaoPickerConfig.IPickSelectNotify {
        public final /* synthetic */ DriveSdkServiceImpl a;
        public final /* synthetic */ w79.c b;

        public final void onChanged(List<DoubaoPickerEntity> r4) {
            Intrinsics.checkNotNullParameter(r4, "infoList");
            FLogger.a.i("DriveSdkServiceImpl", "pickListener onChanged: " + DriveSdkServiceImpl.a0(this.a, r4));
            this.b.onChanged(DriveSdkServiceImpl.Y(this.a, r4));
        }

        public final void onSelected(DoubaoPickerEntity r5) {
            Intrinsics.checkNotNullParameter(r5, "info");
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("pickListener onSelected: ");
            DriveSdkServiceImpl r2 = this.a;
            int r3 = DriveSdkServiceImpl.l;
            r2.getClass();
            r1.append(DriveSdkServiceImpl.H0(r5));
            r0.i("DriveSdkServiceImpl", r1.toString());
            w79.c r4 = this.b;
            this.a.getClass();
            r4.b(DriveSdkServiceImpl.G0(r5));
        }

        public f(DriveSdkServiceImpl r1, w79.c r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onDeSelected(String r4, DoubaoPickerEntity r5) {
            Intrinsics.checkNotNullParameter(r4, "id");
            Intrinsics.checkNotNullParameter(r5, "info");
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("pickListener onDeSelected: ");
            r1.append(r4);
            r1.append(", ");
            DriveSdkServiceImpl r6 = this.a;
            int r2 = DriveSdkServiceImpl.l;
            r6.getClass();
            r1.append(DriveSdkServiceImpl.H0(r5));
            r0.i("DriveSdkServiceImpl", r1.toString());
            w79.c r7 = this.b;
            this.a.getClass();
            r7.a(DriveSdkServiceImpl.G0(r5));
        }
    }

    public static final class g implements DoubaoPickerConfig.OnPickerBottomActionListener {
        public final /* synthetic */ DriveSdkServiceImpl a;
        public final /* synthetic */ w79.c b;

        public final void onSelectMoreClick() {
            FLogger.a.i("DriveSdkServiceImpl", "pickListener onSelectMoreClick");
            this.b.onSelectMoreClick();
        }

        public final void onConfirmClick(List<DoubaoPickerEntity> r4) {
            Intrinsics.checkNotNullParameter(r4, "infoList");
            FLogger.a.i("DriveSdkServiceImpl", "pickListener onConfirmClick: " + DriveSdkServiceImpl.a0(this.a, r4));
            this.b.d(DriveSdkServiceImpl.Y(this.a, r4));
        }

        public g(DriveSdkServiceImpl r1, w79.c r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class h implements DoubaoPickerConfig.IOnCancelListener {
        public final /* synthetic */ w79.c a;

        public final void onCanceled() {
            FLogger.a.i("DriveSdkServiceImpl", "pickListener onCanceled");
            this.a.onCanceled();
        }

        public h(w79.c r1) {
            this.a = r1;
        }
    }

    public static final class i implements nc5.a<DocumentListInfo> {
        public final /* synthetic */ DriveFileType a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Function1<String, Unit> d;
        public final /* synthetic */ DriveSdkServiceImpl e;
        public final /* synthetic */ Function1<DriveFileItem, Unit> f;

        public final void onFailure(Throwable r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            FLogger.a.e("DriveSdkServiceImpl", "createDriveFile failed, type[" + this.a + "], parentDriveToken[" + this.b + "], fileName[" + this.c + ']', r4);
            Function1<String, Unit> r0 = this.d;
            if (r0 == null) goto L9;
            String r5 = r4.getMessage();
            if (r5 != null) goto L7;
            r5 = "";
        L7:
            r0.invoke(r5);
            return;
        }

        public final void onSuccess(Object r4) {
            DocumentListInfo r5 = (DocumentListInfo) r4;
            Intrinsics.checkNotNullParameter(r5, "result");
            FLogger.a.i("DriveSdkServiceImpl", "createDriveFile failed, type[" + this.a + "], parentDriveToken[" + this.b + "], fileName[" + this.c + ']');
            DriveFileItem r6 = (DriveFileItem) CollectionsKt.firstOrNull(DriveSdkServiceImpl.Z(this.e, r5));
            Function1<DriveFileItem, Unit> r0 = this.f;
            if (r0 == null) goto L6;
            r0.invoke(r6);
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public i(DriveFileType r1, String r2, String r3, Function1<? super String, Unit> r4, DriveSdkServiceImpl r5, Function1<? super DriveFileItem, Unit> r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    public static final class j implements v79.a {
        public final /* synthetic */ DriveListLoadType a;
        public final /* synthetic */ List<DriveFileItem> b;
        public final /* synthetic */ Function0<Unit> c;
        public final /* synthetic */ Function1<Map<String, Integer>, Unit> d;

        @Override // v79.a
        public final void onSuccess() {
            FLogger.a.i("DriveSdkServiceImpl", "[deleteDriveFiles] Delete succeeded, loadType[" + this.a + "], count[" + this.b.size() + ']');
            Function0<Unit> r0 = this.c;
            if (r0 == null) goto L6;
            r0.invoke();
            return;
        }

        @Override // v79.a
        public final void a(Map<String, Integer> r4) {
            Intrinsics.checkNotNullParameter(r4, "failFileWithCode");
            FLogger.a.e("DriveSdkServiceImpl", "[deleteDriveFiles] Delete failed, loadType[" + this.a + "], count[" + this.b.size() + "], failCount[" + r4.size() + ']');
            Function1<Map<String, Integer>, Unit> r0 = this.d;
            if (r0 == null) goto L6;
            r0.invoke(r4);
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public j(DriveListLoadType r1, List<DriveFileItem> r2, Function0<Unit> r3, Function1<? super Map<String, Integer>, Unit> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class k implements v79.a {
        public final /* synthetic */ DriveListLoadType a;
        public final /* synthetic */ List<DriveFileItem> b;
        public final /* synthetic */ Function0<Unit> c;
        public final /* synthetic */ Function1<Map<String, Integer>, Unit> d;

        @Override // v79.a
        public final void onSuccess() {
            FLogger.a.i("DriveSdkServiceImpl", "[deleteDriveFiles] Delete succeeded, loadType[" + this.a + "], count[" + this.b.size() + ']');
            Function0<Unit> r0 = this.c;
            if (r0 == null) goto L6;
            r0.invoke();
            return;
        }

        @Override // v79.a
        public final void a(Map<String, Integer> r4) {
            Intrinsics.checkNotNullParameter(r4, "failFileWithCode");
            FLogger.a.e("DriveSdkServiceImpl", "[deleteDriveFiles] Delete failed, loadType[" + this.a + "], count[" + this.b.size() + "], failCount[" + r4.size() + ']');
            Function1<Map<String, Integer>, Unit> r0 = this.d;
            if (r0 == null) goto L6;
            r0.invoke(r4);
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public k(DriveListLoadType r1, List<DriveFileItem> r2, Function0<Unit> r3, Function1<? super Map<String, Integer>, Unit> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
    }

    public final String lifecycleCategory() {
        return "drive";
    }

    public final int lifecycleOrder() {
        return 3;
    }

    public static void b0() {
        IOfficeSdkServiceV2 r0 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r0 == null) goto L6;
        IOfficeSdkServiceV2.a.b(r0, false, "DriveSdkServiceImpl", 5);
        return;
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final void h() {
        IDriveService.a.h();
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final boolean l() {
        if (this.b == null) goto L5;
        return true;
    L5:
        return false;
    }

    public DriveSdkServiceImpl() {
        this.d = com.larus.drive.sdk.impl.service.t.a();
        this.e = new AtomicBoolean(false);
        this.f = new Gson();
        this.g = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()));
        this.h = new AtomicLong(0);
        this.i = new Object();
        int r0 = com.larus.drive.sdk.impl.utils.f.a;
        mbb.c.a = true;
        mbb.c.b = new com.larus.drive.sdk.impl.utils.b();
        mbb.c.c = new com.larus.drive.sdk.impl.utils.c();
        mbb.c.d = new com.larus.drive.sdk.impl.utils.d();
        mbb.c.e = new com.larus.drive.sdk.impl.utils.e();
        FLogger.a.i("DriveIconHelper", "[ReferenceIconTrace] stage=drive_icon_provider_installed");
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final List<Integer> U() {
        return com.larus.drive.sdk.impl.utils.h.a();
    }

    public final void destroyDocSdk() {
        h();
        boolean r1 = false;
        this.e.set(false);
        long r2 = this.h.incrementAndGet();
        Job r4 = this.j;
        com.bytedance.ee.bear.office.export.space.a r5 = this.k;
        this.j = null;
        this.k = null;
        if (r4 == null) goto L5;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
    L5:
        long r8 = SystemClock.elapsedRealtime();
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L24
        Object r11 = this.i;     // Catch: Throwable -> L24
        monitor-enter(r11);     // Catch: Throwable -> L24
        if (r5 != null) goto L31;
    L14:
        monitor-exit(r11);     // Catch: Throwable -> L24
        FLogger r12 = FLogger.a;     // Catch: Throwable -> L24
        StringBuilder r13 = new StringBuilder("clear office space menu config on sdk clear, generation=");     // Catch: Throwable -> L24
        r13.append(r2);     // Catch: Throwable -> L24
        r13.append(", hadInstallJob=");     // Catch: Throwable -> L24
        if (r4 == null) goto L18;
        boolean r0 = true;
    L19:
        r13.append(r0);     // Catch: Throwable -> L24
        r13.append(", hadOfficeSpaceSdk=");     // Catch: Throwable -> L24
        if (r5 == null) goto L22;
        r1 = true;
    L22:
        r13.append(r1);     // Catch: Throwable -> L24
        r13.append(", costMs=");     // Catch: Throwable -> L24
        r13.append(SystemClock.elapsedRealtime() - r8);     // Catch: Throwable -> L24
        r13.append(", thread=");     // Catch: Throwable -> L24
        r13.append(ThreadMethodProxy.currentThread().getName());     // Catch: Throwable -> L24
        r13.append(", isMainThread=");     // Catch: Throwable -> L24
        r13.append(Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()));     // Catch: Throwable -> L24
        r12.i("DriveSdkServiceImpl", r13.toString());     // Catch: Throwable -> L24
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L26:
        Throwable r6 = Result.exceptionOrNull-impl(r3);
        if (r6 == null) goto L29;
        FLogger.a.w("DriveSdkServiceImpl", "clear office space menu config on sdk clear failed, generation=" + r2 + ", costMs=" + (SystemClock.elapsedRealtime() - r8), r6);
    L29:
        this.a = null;
        this.c = null;
        this.b = null;
        com.bytedance.ee.drive.preview.d r7 = com.larus.drive.sdk.impl.service.t.a;
        com.larus.drive.sdk.impl.service.t.a = null;
        com.larus.drive.sdk.impl.service.t.b = null;
        com.larus.drive.sdk.impl.service.t.c = null;
        com.larus.drive.sdk.impl.service.t.d = null;
        FLogger.a.i("DriveSdkServiceImpl", "destroyDocSdk");
        return;
    L18:
        r0 = false;
        goto L19
    L31:
        r5.f();     // Catch: Throwable -> L11
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    }

    public static boolean D0(int r3) {
        return CollectionsKt.listOf(new Integer[]{672020010, 672020011, 900004230}).contains(Integer.valueOf(r3));
    }

    public static DoubaoPickerEntity F0(DriveFileItem r3) {
        DoubaoPickerEntity r0 = new DoubaoPickerEntity();
        r0.setFileType(r3.d);
        r0.setFileName(r3.a);
        r0.setFileToken(r3.b);
        r0.setFileURL(r3.e);
        r0.setOpenTime(r3.f);
        r0.setEditTime(r3.g);
        r0.setIconInfo(r3.i);
        boolean r2 = true;
        if (r3.k == 1) goto L6;
        r2 = false;
    L6:
        r0.setOwner(r2);
        r0.setBitableBizType(com.larus.drive.sdk.impl.utils.a.b(r3));
        return r0;
    }

    public static DriveFileItem G0(DoubaoPickerEntity r17) {
        DriveFileType r14 = C0(r17.getFileType(), r17.getFileName());
        String r3 = r17.getFileName();
        String r4 = r17.getFileToken();
        int r6 = r17.getFileType();
        String r7 = r17.getFileURL();
        long r8 = r17.getOpenTime();
        long r10 = r17.getEditTime();
        String r1 = r17.getFileURL();
        DriveFileType r2 = DriveFileType.BITABLE;
        if (r14 == r2) goto L5;
    L7:
        int r5 = r14.getIconResId();
    L8:
        int r12 = r5;
        String r9 = r17.getIconInfo();
        if (r9 != null) goto L11;
        r9 = "";
    L11:
        String r13 = r9;
        boolean r15 = r17.isOwner();
        Integer r11 = r17.getBitableBizType();
        Intrinsics.checkNotNullParameter(r14, "type");
        if (r14 != r2) goto L16;
        if (r11 == null) goto L16;
        int r16 = r11.intValue();
        String r18 = new JSONObject().put("originBaseBizType", r16).toString();
    L17:
        int r110 = r15 ? 1 : 0;
        return new DriveFileItem(r3, r4, "", r6, r7, r8, r10, r12, r13, r14, r110, r18);
    L16:
        r18 = null;
        goto L17
    L5:
        if (bq9.b.b(r1) == false) goto L7;
        h19.b r20 = h19.b.a;
        CommonFileIconType r111 = CommonFileIconType.BITABLE_APP;
        r20.getClass();
        r5 = h19.b.a(r111);
        goto L8
    }

    public static String H0(DoubaoPickerEntity r3) {
        return "DoubaoPickerEntity(fileType=" + r3.getFileType() + ", fileName=" + r3.getFileName() + ", fileToken=" + r3.getFileToken() + ", fileURL=" + r3.getFileURL() + ", openTime=" + r3.getOpenTime() + ", editTime=" + r3.getEditTime() + ", iconInfo=" + r3.getIconInfo() + ", bitableBizType=" + r3.getBitableBizType() + ", isOwner=" + r3.isOwner() + ')';
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final boolean S(List<String> r3) {
        Intrinsics.checkNotNullParameter(r3, "taskKeys");
        com.bytedance.ee.bear.drive.sdk.service.g r0 = this.c;
        if (r0 != null) goto L5;
        return false;
    L5:
        r0.d((String[]) r3.toArray(new String[0]));
        return true;
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final void g(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "taskKeys");
        Iterator<T> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        String r0 = (String) r3.next();
        goto L4
    }

    public final void initDocSdk(OfficeSDKUserApi r20) {
        Intrinsics.checkNotNullParameter(r20, "officeSDKUserApi");
        gk5.e r10 = r20.getService(gk5.e.class);
        if (r10 == null) goto L5;
        ik5.a r2 = r10.c0();
    L6:
        this.a = r2;
        if (r10 == null) goto L9;
        com.bytedance.ee.bear.drive.sdk.service.g r3 = r10.p9();
    L10:
        this.c = r3;
        this.b = r20.getService(IDoubaoPicker.class);
        com.bytedance.ee.drive.preview.d r0 = com.larus.drive.sdk.impl.service.t.a;
        if (r10 == null) goto L13;
        com.bytedance.ee.drive.preview.d r1 = r10.Y2();
    L14:
        com.larus.drive.sdk.impl.service.t.a = r1;
        com.bytedance.ee.drive.preview.d r4 = com.larus.drive.sdk.impl.service.t.a;
        if (r4 == null) goto L17;
        r4.k1(new h89.a());
    L17:
        if (r10 == null) goto L19;
        com.bytedance.ee.bear.drive.sdk.service.g r5 = r10.p9();
    L20:
        com.larus.drive.sdk.impl.service.t.b = r5;
        if (r10 == null) goto L23;
        ik5.a r6 = r10.c0();
    L24:
        com.larus.drive.sdk.impl.service.t.c = r6;
        if (r10 == null) goto L29;
        PermissionSdk r7 = r10.i0();
        if (r7 == null) goto L29;
        com.bytedance.ee.permission.b r8 = r7.a();
    L30:
        com.larus.drive.sdk.impl.service.t.d = r8;
        wt5.c r9 = wt5.c.a;
        if (wt5.c.b == true) goto L43;
        monitor-enter(r9);
    L40:
        th = move-exception;
        throw th;
    L34:
        if (wt5.c.b == false) goto L37;
        monitor-exit(r9);
        goto L43
    L37:
        r9.a();     // Catch: Throwable -> L40
        monitor-exit(r9);
    L43:
        if (r10 == null) goto L45;
        com.bytedance.ee.bear.office.export.space.a r11 = r10.e7();
    L46:
        boolean r12 = false;
        if (r11 != null) goto L49;
        FLogger.a.i("DriveSdkServiceImpl", "skip install office space menu config, officeSpaceSdk is null");
    L60:
        if (r10 != null) goto L62;
        FLogger.a.i("DriveSdkServiceImpl", "skip preload drive manage page on office ready, ccmService is null");
    L69:
        FLogger r13 = FLogger.a;
        StringBuilder r14 = new StringBuilder("initDocSdk: hasDocsSdk=");
        if (this.a == null) goto L72;
        boolean r15 = true;
    L73:
        r14.append(r15);
        r14.append(", hasPicker=");
        if (this.b == null) goto L76;
        r12 = true;
    L76:
        r14.append(r12);
        r13.i("DriveSdkServiceImpl", r14.toString());
        return;
    L72:
        r15 = false;
        goto L73
    L62:
        IDriveService r16 = (IDriveService) ServiceManager.get().getService(IDriveService.class);
        if (r16 != null) goto L66;
        FLogger.a.i("DriveSdkServiceImpl", "skip preload drive manage page on office ready, driveService is null");
        goto L69
    L66:
        if (this.e.compareAndSet(false, true) == false) goto L69;
        r16.k(DrivePreloadScene.OFFICE_SDK_READY);
        FLogger.a.i("DriveSdkServiceImpl", "preload drive manage page on office ready");
        goto L69
    L49:
        long r17 = this.h.incrementAndGet();
        String r18 = AccountService.a.getUserId();
        int r21 = r18.hashCode();
        Job r22 = this.j;
        this.k = r11;
        if (r22 == null) goto L52;
        Job.DefaultImpls.cancel$default(r22, null, 1, null);
    L52:
        FLogger r23 = FLogger.a;
        StringBuilder r24 = new StringBuilder("schedule office space menu config async install, generation=");
        r24.append(r17);
        r24.append(", userIdHash=");
        r24.append(r21);
        r24.append(", previousJobActive=");
        if (r22 != null) goto L55;
    L57:
        boolean r25 = false;
    L58:
        r24.append(r25);
        r24.append(", thread=");
        r24.append(ThreadMethodProxy.currentThread().getName());
        r24.append(", isMainThread=");
        r24.append(Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()));
        r23.i("DriveSdkServiceImpl", r24.toString());
        this.j = BuildersKt.launch$default(this.g, null, null, new DriveSdkServiceImpl$installOfficeSpaceMenuConfigOnInit$1(r17, r21, this, r18, r11, null), 3, null);
        goto L60
    L55:
        if (r22.isActive() != true) goto L57;
        r25 = true;
        goto L58
    L45:
        r11 = null;
    L29:
        r8 = null;
        goto L30
    L23:
        r6 = null;
        goto L24
    L19:
        r5 = null;
        goto L20
    L13:
        r1 = null;
        goto L14
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final void k(AbsDriveListFragment.d r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        ((e89.b) com.larus.drive.sdk.impl.service.t.h.getValue()).k(r2);
    }

    public final void postInitDocSdk(OfficeSDKUserApi r2) {
        Intrinsics.checkNotNullParameter(r2, "officeSDKUserApi");
        Intrinsics.checkNotNullParameter(r2, "officeSDKUserApi");
    }

    public final void preInitDocSdk(OfficeSDKUserApi r2) {
        Intrinsics.checkNotNullParameter(r2, "officeSDKUserApi");
        Intrinsics.checkNotNullParameter(r2, "officeSDKUserApi");
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final Object w(Continuation r4) {
        return this.d.i(null, 0, null, r4);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final String x(long r1) {
        return com.larus.drive.sdk.impl.utils.m.a(r1);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final void z(DriveFileItem r3) {
        Intrinsics.checkNotNullParameter(r3, "file");
        this.d.q(r3.b, r3.d);
    }

    public static DriveFileType C0(int r1, String r2) {
        if (r1 == 0) goto L20;
        if (r1 == 3) goto L26;
        if (r1 == 8) goto L25;
        if (r1 == 11) goto L24;
        if (r1 == 22) goto L23;
        if (r1 == 30) goto L22;
        DriveFileType.Companion.getClass();
        return DriveFileType.a.b(r2);
    L22:
        return DriveFileType.AI_SLIDES;
    L23:
        return DriveFileType.AI_DOC;
    L24:
        return DriveFileType.MINDNOTE;
    L25:
        return DriveFileType.BITABLE;
    L26:
        return DriveFileType.AI_SHEET;
    L20:
        return DriveFileType.FOLDER;
    }

    public static final Object V(DriveSdkServiceImpl r3, Continuation r4) {
        r3.getClass();
        IOfficeSdkServiceV2 r5 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r5 != null) goto L5;
        return null;
    L5:
        IOfficeSdkServiceV2.a.b(r5, false, "DriveSdkServiceImpl", 5);
        return r5.o0(DoraObricDeviceHomeViewModel.SCAN_TIMEOUT_MS, r4);
    }

    public static final String W(DriveSdkServiceImpl r7, long r8) {
        r7.getClass();
        long r0 = SystemClock.elapsedRealtime();
        e2 r2 = z2.a.getLarkDriveConfigV2().b();
        long r3 = SystemClock.elapsedRealtime() - r0;
        long r1 = SystemClock.elapsedRealtime();
        String r9 = GsonProtectorUtils.toJson(r7.f, MapsKt.mapOf(TuplesKt.to("menu_config", r2)));
        long r5 = SystemClock.elapsedRealtime() - r1;
        FLogger.a.i("DriveSdkServiceImpl", "build office space menu config json, generation=" + r8 + ", settingsCostMs=" + r3 + ", gsonCostMs=" + r5 + ", jsonLength=" + r9.length() + ", thread=" + ThreadMethodProxy.currentThread().getName() + ", isMainThread=" + Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()));
        Intrinsics.checkNotNull(r9);
        return r9;
    }

    public static final boolean X(DriveSdkServiceImpl r4, Throwable r5) {
        r4.getClass();
        FLogger r6 = FLogger.a;
        r6.i("DriveSdkServiceImpl", "isDriveUpdateError, t[" + r5 + ']');
        NetService.HttpErrorException r2 = null;
        if ((r5 instanceof NetService.ServerErrorException) == false) goto L5;
        NetService.ServerErrorException r0 = (NetService.ServerErrorException) r5;
    L7:
        if (r0 == null) goto L10;
        r6.i("DriveSdkServiceImpl", "isDriveUpdateError, ServerErrorException, code[" + r0 + ".code]");
        return D0(r0.getCode());
    L10:
        if ((r5 instanceof NetService.HttpErrorException) == false) goto L12;
        r2 = (NetService.HttpErrorException) r5;
    L12:
        if (r2 != null) goto L14;
        return false;
    L14:
        r6.i("DriveSdkServiceImpl", "isDriveUpdateError, HttpErrorException, code[" + r2 + ".code]");
        return D0(r2.getCode());
    L5:
        r0 = null;
        goto L7
    }

    public static final List Y(DriveSdkServiceImpl r1, List r2) {
        r1.getClass();
        List r3 = r2;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r4.add(G0((DoubaoPickerEntity) r5.next()));
        goto L4
    L6:
        return r4;
    }

    public static final List Z(DriveSdkServiceImpl r20, DocumentListInfo r21) {
        r20.getClass();
        ArrayList r0 = new ArrayList();
        ArrayList r1 = r21.getDocumentList();
        if (r1 == null) goto L23;
        Iterator r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L23;
        Document r3 = (Document) r2.next();
        DriveFileType r4 = C0(r3.getType(), r3.a);
        String r6 = r3.a;
        String r7 = r3.d;
        String r8 = r3.c;
        String r10 = r3.p;
        long r5 = 0;
        String r9 = r3.l;     // Catch: Throwable -> L25
        if (r9 == null) goto L12;
        long r11 = CastLongProtector.parseLong(r9);     // Catch: Throwable -> L25
    L26:
        String r12 = r3.i;     // Catch: Throwable -> L24
        if (r12 == null) goto L16;
        r5 = CastLongProtector.parseLong(r12);     // Catch: Throwable -> L24
    L16:
        long r13 = r5;
        String r14 = r3.p;
        if (r4 == DriveFileType.BITABLE) goto L19;
    L21:
        int r15 = r4.getIconResId();
    L22:
        int r16 = r15;
        String r17 = r3.F2;
        boolean r18 = r3.I2;
        r0.add(new DriveFileItem(r6, r7, r8, r3.getType(), r10, r11, r13, r16, r17, r4, r18 ? 1 : 0, r3.O));
        goto L6
    L19:
        if (bq9.b.b(r14) == false) goto L21;
        h19.b r22 = h19.b.a;
        CommonFileIconType r23 = CommonFileIconType.BITABLE_APP;
        r22.getClass();
        r15 = h19.b.a(r23);
    L12:
        r11 = 0;
    L23:
        return r0;
    }

    public static final String a0(final DriveSdkServiceImpl r11, List r12) {
        r11.getClass();
        return "[" + CollectionsKt.joinToString$default(r12, ",", null, null, 0, null, new com.larus.drive.sdk.impl.e(r11), 30, null) + ']';
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final void F(DriveFileItem r5, ImageView r6) {
        Intrinsics.checkNotNullParameter(r5, "file");
        Intrinsics.checkNotNullParameter(r6, "imageView");
        if (this.a != null) goto L11;
        FLogger.a.i("DriveSdkServiceImpl", "loadFileTypeIcon skipped, sdk not initialized");
        return;
    L11:
        o(r6, r5.b, r5.d, r5.i);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        FLogger.a.e("DriveSdkServiceImpl", "loadFileTypeIcon failed, fileToken[" + r5.b + ']', e);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final String I(String r4, com.larus.drive.biz.impl.file.s r5) {
        Intrinsics.checkNotNullParameter(r4, "taskId");
        Intrinsics.checkNotNullParameter(r5, "callback");
        com.bytedance.ee.bear.drive.sdk.service.g r0 = this.c;
        if (r0 != null) goto L6;
        FLogger.a.i("DriveSdkServiceImpl", "resumeUploadingDriveFile, driveUploadDownloadService is null");
        return null;
    L6:
        Pair r6 = r0.h(r4, new DriveSdkServiceImpl$getUploadCallback$1(r5));
        if (r6 == null) goto L15;
        Integer r7 = (Integer) r6.first;
        if (r7 != null) goto L12;
        return null;
    L12:
        if (r7.intValue() == 0) goto L14;
        return null;
    L14:
        return (String) r6.second;
    L15:
        return null;
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final void P(DriveFileItem r5, kw9.c r6) {
        Intrinsics.checkNotNullParameter(r5, "file");
        Intrinsics.checkNotNullParameter(r6, "param");
        Lazy r2 = MorePanelHelper.a;
        Intrinsics.checkNotNullParameter(r5, "file");
        Intrinsics.checkNotNullParameter(r6, "param");
        MorePanelHelper.c().p(r5.b, r5.d, new com.larus.drive.sdk.impl.utils.s(r5, r6));
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final void e(ImageView r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "imageView");
        Intrinsics.checkNotNullParameter(r4, "url");
        boolean r0 = mbb.c.a;
        mbb.c.e(r3, r4, IconShape.SQUARE, null);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final void m(z79.b r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r1, "galleryContext");
        DriveGalleryHelper r3 = DriveGalleryHelper.a;
        DriveGalleryHelper.d(r1);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final String p(String r4, bo9.c r5) {
        Intrinsics.checkNotNullParameter(r4, "taskId");
        Intrinsics.checkNotNullParameter(r5, "callback");
        com.bytedance.ee.bear.drive.sdk.service.g r0 = this.c;
        if (r0 != null) goto L6;
        FLogger.a.i("DriveSdkServiceImpl", "resumeUploadingDriveFileToMountPoint, driveUploadDownloadService is null");
        return null;
    L6:
        Pair r6 = r0.h(r4, new DriveSdkServiceImpl$getMountUploadCallback$1(r5));
        if (r6 == null) goto L15;
        Integer r7 = (Integer) r6.first;
        if (r7 != null) goto L12;
        return null;
    L12:
        if (r7.intValue() == 0) goto L14;
        return null;
    L14:
        return (String) r6.second;
    L15:
        return null;
    }

    public final b E0(String r13, u79.b r14, Function1 r15) {
        b r7 = new b();
        b0();
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new DriveSdkServiceImpl$retryListRequestAfterDocSdkInit$1(this, r7, r13, r14, r15, null), 2, null);
        return r7;
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final void H(String r16, String r17, Bundle r18) {
        Intrinsics.checkNotNullParameter(r16, "fileToken");
        if (this.a != null) goto L6;
        FLogger.a.i("DriveSdkServiceImpl", "[previewDriveFile] officeSdk not initialized");
        b0();
        return;
    L6:
        FragmentActivity r0 = AppHost.a.a().getCurrentActivity();
        if ((r0 instanceof FragmentActivity) == false) goto L9;
        FragmentActivity r1 = r0;
    L10:
        FragmentActivity r4 = r1;
        if (r4 != null) goto L14;
        FLogger.a.i("DriveSdkServiceImpl", "[previewDriveFile] currentActivity is null");
        return;
    L14:
        LifecycleCoroutineScope r10 = LifecycleOwnerKt.getLifecycleScope(r4);
        BuildersKt.launch$default(r10, null, null, new DriveSdkServiceImpl$previewDriveFile$1(r17, r16, 12, r4, r10, r18, this, null), 3, null);
        return;
    L9:
        r1 = null;
        goto L10
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final void C(DriveFileItem r2, CoroutineScope r3, Function1<? super String, Unit> r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "scope");
        RegisterDriveResourceHelper.a(r2, r3, r4, r5);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final nc5.b O(DriveFileItem r2, DriveListLoadType r3, com.larus.drive.biz.impl.viewmodel.o r4, final com.larus.drive.biz.impl.viewmodel.p r5) {
        Intrinsics.checkNotNullParameter(r2, "file");
        Intrinsics.checkNotNullParameter(r3, "loadType");
        return q(CollectionsKt.listOf(r2), r3, r4, new com.larus.drive.sdk.impl.f(r5, this));
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final Object b(String r2, int r3, boolean r4, Continuation<? super DriveFileItem> r5) {
        return this.d.b(r2, r3, r4, r5);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final void o(ImageView r8, String r9, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r8, "imageView");
        Intrinsics.checkNotNullParameter(r9, "token");
        Intrinsics.checkNotNullParameter(r11, "iconInfo");
        mbb.c.g(r8, r9, r10, r11, null, 48);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final nc5.b q(List<DriveFileItem> r3, DriveListLoadType r4, Function0<Unit> r5, Function1<? super Map<String, Integer>, Unit> r6) {
        Intrinsics.checkNotNullParameter(r3, "fileList");
        Intrinsics.checkNotNullParameter(r4, "loadType");
        if (r3.isEmpty() == false) goto L6;
        FLogger.a.i("DriveSdkServiceImpl", "[deleteDriveFiles] Empty file list");
        r5.invoke();
        return null;
    L6:
        int r0 = c.a[r4.ordinal()];
        if (r0 == 1) goto L14;
        if (r0 != 2) goto L12;
        return this.d.m(r3, new j(r4, r3, r5, r6));
    L12:
        throw new NoWhenBranchMatchedException();
    L14:
        return this.d.e(r3, new k(r4, r3, r5, r6));
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final String r(String r7, String r8, DriveDownloadPriority r9, AbsDriveListViewModel.C05381 r10) {
        Intrinsics.checkNotNullParameter(r7, "fileToken");
        Intrinsics.checkNotNullParameter(r8, "localPath");
        Intrinsics.checkNotNullParameter(r9, "priority");
        Intrinsics.checkNotNullParameter(r10, "callback");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new DriveSdkServiceImpl$downloadDriveFile$1(r10, null), 2, null);
        return "100";
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final w79.b A(DrivePickerScene r10, FragmentActivity r11, ViewGroup r12, w79.c r13, List<DriveFileItem> r14) {
        Intrinsics.checkNotNullParameter(r10, "pickerScene");
        Intrinsics.checkNotNullParameter(r11, "activity");
        Intrinsics.checkNotNullParameter(r12, "rootView");
        Intrinsics.checkNotNullParameter(r13, "callback");
        Intrinsics.checkNotNullParameter(r14, "preSelectedDriveItems");
        IDoubaoPicker r0 = this.b;
        List r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        DoubaoPickerConfig r2 = new DoubaoPickerConfig();
        int r3 = c.c[r10.ordinal()];
        boolean r4 = true;
        if (r3 != 1) goto L8;
        DobaoPickerScene r5 = DobaoPickerScene.YUNPAN_SEARCH;
    L13:
        r2.setScene(r5);
        if (r10 != DrivePickerScene.FILE_SELECTOR) goto L16;
        boolean r6 = true;
    L17:
        r2.setMultiSelect(r6);
        r2.setEnableCancelBtn(false);
        r2.setItemConsumer(new e(this, r13));
        List<DriveFileItem> r15 = r14;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator<T> r16 = r15.iterator();
    L19:
        if (r16.hasNext() == false) goto L21;
        r7.add(F0((DriveFileItem) r16.next()));
        goto L19
    L21:
        r2.setPreSelectedItems(r7);
        r2.setOnPickListener(new f(this, r13));
        r2.setOnConfirmListener(new g(this, r13));
        r2.setOnCancelListener(new h(r13));
        if (r10 == DrivePickerScene.FINDER) goto L25;
        r4 = false;
    L25:
        r2.setEnableCancelBtn(r4);
        DrivePickerScene r17 = DrivePickerScene.FILE_SELECTOR;
        if (r10 != r17) goto L28;
        int r18 = 2131241245;
    L29:
        r2.setDefaultEmptyIconResId(r18);
        if (r10 != r17) goto L32;
        String r110 = r11.getString(2131905304);
    L33:
        r2.setDefaultEmptyHintText(r110);
        r2.setSearchEmptyHintText(r11.getString(2131906532));
        r2.setSearchBarHintText(r11.getString(2131898831));
        r2.setSelectedCountHintTemplate(r11.getString(2131900748));
        a89.a r111 = com.larus.drive.sdk.impl.utils.h.a;
        DobaoPickerScene r112 = r2.getScene();
        Intrinsics.checkNotNullParameter(r112, "scene");
        if (r112 == DobaoPickerScene.SELECT_FILE) goto L40;
        boolean r113 = com.larus.platform.exp.i.a.a();
        if (r113 == false) goto L38;
        Set<DoubaoDocType> r8 = SetsKt.plus(com.larus.drive.sdk.impl.utils.h.d, com.larus.drive.sdk.impl.utils.h.e);
    L39:
        FLogger.a.i("DriveInfoHelper", "[getPickerTypes] scene=" + r112 + ", enableNewDriveList=" + r113 + ", types=" + r8);
        DoubaoDocTypes.NEW r114 = new DoubaoDocTypes.NEW(r8);
    L68:
        r2.setDocTypes(r114);
        return new d(r0.createDoubaoPicker(r2).attach(r11, r12), this, r12);
    L38:
        r8 = com.larus.drive.sdk.impl.utils.h.d;
        goto L39
    L40:
        List r115 = ((d2) com.larus.drive.sdk.impl.utils.h.b.getValue()).c();
        if (r115 == null) goto L43;
        r1 = CollectionsKt.filterNotNull(r115);
    L43:
        if (r1 != null) goto L45;
        r1 = CollectionsKt.emptyList();
    L45:
        List r9 = r1;
        ArrayList r116 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r20 = r9.iterator();
    L47:
        if (r20.hasNext() == false) goto L60;
        switch(com.larus.drive.sdk.impl.utils.h.a.a[((OfficeAskDoubaoType) r20.next()).ordinal()]) {
            case 1: goto L58;
            case 2: goto L57;
            case 3: goto L56;
            case 4: goto L55;
            case 5: goto L54;
            case 6: goto L53;
            case 7: goto L52;
            default: goto L51;
        };
    L52:
        DoubaoDocType r21 = DoubaoDocType.WIKI;
    L59:
        r116.add(r21);
        goto L47
    L53:
        r21 = DoubaoDocType.MINDNOTE;
        goto L59
    L54:
        r21 = DoubaoDocType.BITABLE;
        goto L59
    L55:
        r21 = DoubaoDocType.SHEET;
        goto L59
    L56:
        r21 = DoubaoDocType.SLIDES;
        goto L59
    L57:
        r21 = DoubaoDocType.DOCX;
        goto L59
    L58:
        r21 = DoubaoDocType.FILE;
        goto L59
    L51:
        throw new NoWhenBranchMatchedException();
    L60:
        Set<DoubaoDocType> r117 = CollectionsKt.toSet(r116);
        ArrayList r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r23 = r9.iterator();
    L62:
        if (r23.hasNext() == false) goto L64;
        r22.add(((OfficeAskDoubaoType) r23.next()).getConfigValue());
        goto L62
    L64:
        FLogger.a.i("DriveInfoHelper", "[getPickerTypes] scene=" + r112 + ", officeAskDoubao=" + r22 + ", types=" + r117);
        Set<DoubaoDocType> r118 = r117;
        if (r118.isEmpty() == false) goto L67;
        r118 = com.larus.drive.sdk.impl.utils.h.d;
    L67:
        r114 = new DoubaoDocTypes.NEW(r118);
        goto L68
    L32:
        r110 = "";
        goto L33
    L28:
        r18 = 0;
        goto L29
    L16:
        r6 = false;
        goto L17
    L8:
        if (r3 != 2) goto L11;
        r5 = DobaoPickerScene.SELECT_FILE;
        goto L13
    L11:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final void E(DriveFileItem r2, FragmentActivity r3, CoroutineScope r4, DriveDownloadPriority r5, Fragment r6) {
        Intrinsics.checkNotNullParameter(r2, "file");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "scope");
        Intrinsics.checkNotNullParameter(r5, "priority");
        Lazy r0 = MorePanelHelper.a;
        MorePanelHelper.b(r2, r3, r4, r5, r6);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final nc5.b Q(String r9, int r10, String r11, com.larus.drive.biz.impl.viewmodel.q r12, r r13) {
        Intrinsics.checkNotNullParameter(r9, "fileToken");
        Intrinsics.checkNotNullParameter(r11, "fileName");
        ik5.a r0 = this.a;
        if (r0 == null) goto L9;
        qd5.a r1 = r0.A4();
        if (r1 == null) goto L9;
        return r1.f(r10, r9, r11, new com.larus.drive.sdk.impl.h(r9, r10, this, r13, r12));
    L9:
        r13.invoke("not_initialized");
        b0();
        return null;
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final nc5.b R(String r11, DriveFileType r12, String r13, Function1<? super DriveFileItem, Unit> r14, Function1<? super String, Unit> r15) {
        Intrinsics.checkNotNullParameter(r12, "type");
        ik5.a r0 = this.a;
        if (r0 == null) goto L29;
        r0 r2 = r0.Q3();
        if (r2 == null) goto L29;
        i r1 = new i(r12, r11, r13, r15, this, r14);
        int r16 = c.b[r12.ordinal()];
        if (r16 == 1) goto L28;
        if (r16 == 2) goto L35;
        if (r16 == 3) goto L34;
        if (r16 == 4) goto L33;
        if (r16 == 5) goto L19;
        r15.invoke("invalid_type");
        return null;
    L19:
        if (r13 != null) goto L21;
        r13 = "";
    L21:
        if (r11 != null) goto L32;
        r11 = "";
    L32:
        return r2.g(r13, r11, r1);
    L33:
        return r2.a(8, r11, r11 + '-' + System.currentTimeMillis(), "121", r1);
    L34:
        return r2.a(3, r11, r11 + '-' + System.currentTimeMillis(), "0", r1);
    L35:
        return r2.a(30, r11, r11 + '-' + System.currentTimeMillis(), "0", r1);
    L28:
        return r2.a(22, r11, r11 + '-' + System.currentTimeMillis(), "0", r1);
    L29:
        r15.invoke("not_initialized");
        b0();
        return null;
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final String t(String r17, String r18, String r110, DriveUploadPriority r20, com.larus.drive.biz.impl.file.s r21) {
        Intrinsics.checkNotNullParameter(r17, "fileName");
        Intrinsics.checkNotNullParameter(r18, "uri");
        Intrinsics.checkNotNullParameter(r110, "parentDriveToken");
        Intrinsics.checkNotNullParameter(r20, "priority");
        Intrinsics.checkNotNullParameter(r21, "callback");
        com.bytedance.ee.bear.drive.sdk.service.g r15 = this.c;
        if (r15 != null) goto L6;
        FLogger.a.i("DriveSdkServiceImpl", "startUploadingDriveFile, driveUploadDownloadService is null");
        return null;
    L6:
        DrivePriority.UploadPriority.DEFAULT.getPriority();
        UploadRequestInfo.UploadType r11 = UploadRequestInfo.UploadType.DRIVE;
        int r10 = DrivePriority.UploadPriority.getUploadPriority(r20.getValue()).getPriority();
        DriveSdkServiceImpl$getUploadCallback$1 r13 = new DriveSdkServiceImpl$getUploadCallback$1(r21);
        if (StringsKt.startsWith$default(r18, "content://", false, 2, null) == false) goto L9;
    L12:
        String r5 = r18;
        String r4 = "";
    L14:
        return r15.s(new UploadRequestInfo(r4, r5, r17, r110, "explorer", "", r10, r11, null, null, null, r13));
    L9:
        if (StringsKt.startsWith$default(r18, "file://", false, 2, null) == true) goto L12;
        r4 = r18;
        r5 = "";
        goto L14
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final nc5.b u(String r14, int r15, String r16, z r17, a0 r18) {
        Intrinsics.checkNotNullParameter(r14, "fileToken");
        ik5.a r1 = this.a;
        if (r1 == null) goto L12;
        com.bytedance.ee.bear.list.move.e r9 = r1.D2();
        if (r9 == null) goto L12;
        if (r16 != null) goto L9;
        String r10 = "";
    L10:
        String r4 = r10;
        r9.h(r14, r15, r4, 0, new com.larus.drive.sdk.impl.g(r14, r16, this, r18, r17));
        return null;
    L9:
        r10 = r16;
    L12:
        r18.invoke("not_initialized");
        b0();
        return null;
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final String f(CoroutineScope r13, String r14, int r15, int r16, Function1<? super String, Unit> r17, Function0<Unit> r18) {
        Intrinsics.checkNotNullParameter(r14, "token");
        ik5.a r0 = this.a;
        if (r0 == null) goto L12;
        com.bytedance.ee.bear.list.cover.a r1 = r0.F9();
        if (r1 == null) goto L12;
        String r2 = r1.a(r14, r15, r16, "near");
        if (r17 == null) goto L10;
        r17.invoke(r2);
    L10:
        return r2;
    L12:
        if (r13 == null) goto L16;
        BuildersKt.launch$default(r13, Dispatchers.getIO(), null, new DriveSdkServiceImpl$getImageCoverUrl$coverLoader$1$1(this, r18, r14, r15, r16, r17, null), 2, null);
        return null;
    L16:
        return null;
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final nc5.b B(DriveListLoadType r110, final String r20, boolean r21, final int r22, final String r23, RequestDriveFileListRankType r24, final u79.b r25) {
        Intrinsics.checkNotNullParameter(r110, "loadType");
        Intrinsics.checkNotNullParameter(r24, "rankType");
        Intrinsics.checkNotNullParameter(r25, "callback");
        int r0 = c.a[r110.ordinal()];
        if (r0 != 1) goto L5;
        p1.a("mine");
        ik5.a r1 = this.a;
        if (r1 == null) goto L18;
        com.bytedance.ee.bear.list.recent.b r2 = r1.Bb();
    L19:
        if (r2 == null) goto L28;
        if (r20 != null) goto L23;
        String r8 = "";
    L25:
        return r2.i(r8, r23, Integer.valueOf(AscOrder.DESC.getValue()), com.larus.drive.sdk.impl.utils.h.a(), r22, RankType.EDIT_TIME.getValue(), 40, 40, 4, new com.larus.drive.sdk.impl.j(r20, r23, r25, this));
    L23:
        r8 = r20;
        goto L25
    L28:
        return E0("mine", r25, new com.larus.drive.sdk.impl.d(r20, r23, r22, r25, this));
    L18:
        r2 = null;
        goto L19
    L5:
        if (r0 != 2) goto L14;
        p1.a("recent");
        ik5.a r3 = this.a;
        if (r3 == null) goto L9;
        com.bytedance.ee.bear.list.recent.b r4 = r3.Bb();
    L10:
        if (r4 != null) goto L27;
        return E0("recent", r25, new com.larus.drive.sdk.impl.c(r23, r22, r25, this));
    L27:
        return r4.d(r23, com.larus.drive.sdk.impl.utils.h.a(), r22, RankType.VISIT_TIME.getValue(), 40, 40, 4, new l(r23, r25, this));
    L9:
        r4 = null;
        goto L10
    L14:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final String J(String r25, String r26, String r27, String r28, String r210, Map r30, DriveUploadPriority r31, bo9.c r32) {
        Intrinsics.checkNotNullParameter(r25, "fileName");
        Intrinsics.checkNotNullParameter(r26, "uri");
        Intrinsics.checkNotNullParameter(r27, "mountPoint");
        Intrinsics.checkNotNullParameter(r28, "mountNodeToken");
        Intrinsics.checkNotNullParameter(r30, "extraRust");
        Intrinsics.checkNotNullParameter(r31, "priority");
        Intrinsics.checkNotNullParameter(r32, "callback");
        b0();
        com.bytedance.ee.bear.drive.sdk.service.g r15 = this.c;
        if (r15 != null) goto L6;
        FLogger.a.i("DriveSdkServiceImpl", "startUploadingDriveFileToMountPoint, driveUploadDownloadService is null");
        return null;
    L6:
        DrivePriority.UploadPriority.DEFAULT.getPriority();
        UploadRequestInfo.UploadType r11 = UploadRequestInfo.UploadType.DRIVE;
        int r10 = DrivePriority.UploadPriority.getUploadPriority(r31.getValue()).getPriority();
        DriveSdkServiceImpl$getMountUploadCallback$1 r12 = new DriveSdkServiceImpl$getMountUploadCallback$1(r32);
        String r18 = "";
        if (StringsKt.startsWith$default(r26, "content://", false, 2, null) == false) goto L9;
    L12:
        String r110 = r26;
        String r4 = "";
    L14:
        if (r210 != null) goto L16;
    L19:
        boolean r21 = true;
    L20:
        if (r21 == true) goto L23;
        r18 = r210;
    L23:
        if ((!r30.isEmpty()) == false) goto L25;
        Map r22 = r30;
    L26:
        String r2 = r15.s(new UploadRequestInfo(r4, r110, r25, r28, r27, r18, r10, r11, null, r22, null, r12));
        FLogger r3 = FLogger.a;
        StringBuilder r5 = new StringBuilder("startUploadingDriveFileToMountPoint, driveUpload returned taskId=");
        r5.append(r2);
        r5.append(", isLocalPath=");
        if (StringsKt.startsWith$default(r26, "content://", false, 2, null) == false) goto L29;
    L31:
        boolean r9 = false;
    L32:
        r5.append(r9);
        r3.i("DriveSdkServiceImpl", r5.toString());
        return r2;
    L29:
        if (StringsKt.startsWith$default(r26, "file://", false, 2, null) == true) goto L31;
        r9 = true;
        goto L32
    L25:
        r22 = null;
        goto L26
    L16:
        if (r210.length() == 0) goto L19;
        r21 = false;
        goto L20
    L9:
        if (StringsKt.startsWith$default(r26, "file://", false, 2, null) == true) goto L12;
        r4 = r26;
        r110 = "";
        goto L14
    }
}
