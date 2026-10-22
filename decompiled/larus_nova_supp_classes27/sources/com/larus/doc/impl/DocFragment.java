package com.larus.doc.impl;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.router.SmartRouter;
import com.google.gson.JsonObject;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.IFlowTtsClientService;
import com.larus.audioplayer.api.stream.AudioStreamPlayerDelegate;
import com.larus.audioplayer.api.stream.IStreamPlayerInterceptor;
import com.larus.bmhome.chat.ChatLandingChannel;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.layout.widget.ShimmerTextView;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.api.IShareService;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.bmhome.view.menu.CreateMenu;
import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.common.apphost.AppHost;
import com.larus.doc.biz.impl.databinding.LarusLayoutDocDetailFragmentBinding;
import com.larus.doc.impl.chat.data.DocArtifactInfo;
import com.larus.doc.impl.operation.DocOpManager;
import com.larus.doc.impl.operation.DocOpManager$showSharePanel$1;
import com.larus.doc.impl.view.InterceptTouchFrameLayout;
import com.larus.doc.sdk.api.IDocPermissionService;
import com.larus.doc.sdk.api.IDocSdkBaseService;
import com.larus.doc.sdk.api.IDocSdkServiceV2;
import com.larus.doc.sdk.api.model.DocMode;
import com.larus.doc.sdk.api.model.MinutesInfoModel;
import com.larus.dora.api.model.FlowDoraConnectReason;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.home.impl.sdk.FlowAppletServiceImpl;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockType;
import com.larus.office.OfflineDocReportGate;
import com.larus.office.base.preview.DocMeta;
import com.larus.office.base.view.DocLoadAndErrorLayout;
import com.larus.office.base.view.TextLoadingView;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.IFlowOfficeThemeConfigProvider;
import com.larus.platform.api.f3;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.platform.service.e2;
import com.larus.platform.service.z2;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import com.lynx.lottieadapter.LottieAdapterView;
import com.skydoves.balloon.Balloon;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000º\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b=\n\u0002\u0018\u0002\n\u0002\b\b*\b\u009f\u0001Ö\u0001Û\u0001è\u0001\b\u0016\u0018\u0000 ú\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002ú\u0002B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J,\u0010ê\u0001\u001a\u0004\u0018\u00010C2\b\u0010ë\u0001\u001a\u00030ì\u00012\t\u0010í\u0001\u001a\u0004\u0018\u00010K2\n\u0010î\u0001\u001a\u0005\u0018\u00010ï\u0001H\u0016J\u001e\u0010ð\u0001\u001a\u00020:2\u0007\u0010ñ\u0001\u001a\u00020C2\n\u0010î\u0001\u001a\u0005\u0018\u00010ï\u0001H\u0016J\t\u0010ò\u0001\u001a\u0004\u0018\u00010\u001aJ\t\u0010ó\u0001\u001a\u00020\bH\u0016J\t\u0010ô\u0001\u001a\u00020\bH\u0016J\t\u0010õ\u0001\u001a\u00020\bH\u0016J\t\u0010ö\u0001\u001a\u00020\bH\u0016J\t\u0010÷\u0001\u001a\u00020\bH\u0016J\t\u0010ø\u0001\u001a\u00020\bH\u0016J\t\u0010ù\u0001\u001a\u00020\bH\u0016J\t\u0010ú\u0001\u001a\u00020\bH\u0016J\t\u0010û\u0001\u001a\u00020:H\u0004J\u0013\u0010ü\u0001\u001a\u00020:2\b\u0010ý\u0001\u001a\u00030þ\u0001H\u0016J\t\u0010ÿ\u0001\u001a\u00020:H\u0002J\t\u0010\u0080\u0002\u001a\u00020:H\u0002J\u0007\u0010\u0081\u0002\u001a\u00020:J\t\u0010\u0082\u0002\u001a\u00020,H\u0016J\u0015\u0010\u0083\u0002\u001a\u00020:2\n\u0010\u0084\u0002\u001a\u0005\u0018\u00010\u0085\u0002H\u0002J\u0012\u0010\u0086\u0002\u001a\u00030ï\u00012\u0006\u0010+\u001a\u00020,H\u0002J\u0014\u0010\u0087\u0002\u001a\u00020:2\t\u0010\u0088\u0002\u001a\u0004\u0018\u00010\u000eH\u0002J\t\u0010\u0089\u0002\u001a\u00020:H\u0016J\t\u0010\u008a\u0002\u001a\u00020:H\u0004J\t\u0010\u008b\u0002\u001a\u00020:H\u0004J\t\u0010\u008c\u0002\u001a\u00020:H\u0016J\t\u0010\u008d\u0002\u001a\u00020:H\u0004J\t\u0010\u008e\u0002\u001a\u00020\u000eH\u0016J\t\u0010\u008f\u0002\u001a\u00020:H\u0002J\t\u0010\u0090\u0002\u001a\u00020:H\u0016J\t\u0010\u0091\u0002\u001a\u00020\bH\u0016J\u000b\u0010\u0092\u0002\u001a\u0004\u0018\u00010\u000eH\u0016J\u000b\u0010\u0093\u0002\u001a\u0004\u0018\u00010\u000eH\u0016J\u000b\u0010\u0094\u0002\u001a\u0004\u0018\u00010\u000eH\u0016J\u000b\u0010\u0095\u0002\u001a\u0004\u0018\u00010\u000eH\u0016J\u000b\u0010\u0096\u0002\u001a\u0004\u0018\u00010\u000eH\u0016J\u000f\u0010\u0097\u0002\u001a\u00030\u0098\u0002*\u00030\u0098\u0002H\u0002J\t\u0010\u0099\u0002\u001a\u00020:H\u0002J\t\u0010\u009a\u0002\u001a\u00020:H\u0002J\u0012\u0010\u009b\u0002\u001a\u00020:2\u0007\u0010\u009c\u0002\u001a\u00020\bH\u0016J\t\u0010\u009d\u0002\u001a\u00020,H\u0016J\t\u0010\u009e\u0002\u001a\u00020:H\u0002J\t\u0010¡\u0002\u001a\u00020:H\u0016J\u0014\u0010¢\u0002\u001a\u00020:2\t\b\u0002\u0010£\u0002\u001a\u00020\bH\u0002J\t\u0010¤\u0002\u001a\u00020:H\u0002J\u0013\u0010¥\u0002\u001a\u00020:2\b\u0010¦\u0002\u001a\u00030§\u0002H\u0016J\u000b\u0010¨\u0002\u001a\u0004\u0018\u00010KH\u0016J\t\u0010©\u0002\u001a\u00020:H\u0002J\t\u0010ª\u0002\u001a\u00020:H\u0002J\u0012\u0010«\u0002\u001a\u00020:2\u0007\u0010¬\u0002\u001a\u00020,H\u0002J*\u0010\u00ad\u0002\u001a\u00020:2\n\u0010À\u0001\u001a\u0005\u0018\u00010Á\u00012\u0013\u0010®\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020:06H\u0002J*\u0010¯\u0002\u001a\u00020:2\n\u0010À\u0001\u001a\u0005\u0018\u00010Á\u00012\u0013\u0010®\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020:06H\u0002J*\u0010°\u0002\u001a\u00020:2\n\u0010À\u0001\u001a\u0005\u0018\u00010Á\u00012\u0013\u0010®\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020:06H\u0002J\t\u0010±\u0002\u001a\u00020\u000eH\u0002J\f\u0010²\u0002\u001a\u0005\u0018\u00010³\u0002H\u0004J\f\u0010´\u0002\u001a\u0005\u0018\u00010µ\u0002H\u0004J\u0016\u0010¶\u0002\u001a\u00020:2\u000b\b\u0002\u0010·\u0002\u001a\u0004\u0018\u00010\u000eH\u0002J\u001f\u0010¸\u0002\u001a\u00020:2\u0007\u0010¹\u0002\u001a\u00020\u000e2\u000b\b\u0002\u0010º\u0002\u001a\u0004\u0018\u00010\u000eH\u0004J*\u0010»\u0002\u001a\u00020:2\n\u0010À\u0001\u001a\u0005\u0018\u00010Á\u00012\u0013\u0010®\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020:06H\u0002J*\u0010¼\u0002\u001a\u00020:2\n\u0010À\u0001\u001a\u0005\u0018\u00010Á\u00012\u0013\u0010®\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020:06H\u0002J*\u0010½\u0002\u001a\u00020:2\n\u0010À\u0001\u001a\u0005\u0018\u00010Á\u00012\u0013\u0010®\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020:06H\u0002J;\u0010¾\u0002\u001a\u00020:2\t\u0010¿\u0002\u001a\u0004\u0018\u00010,2\t\u0010À\u0002\u001a\u0004\u0018\u00010\u000e2\t\u0010Á\u0002\u001a\u0004\u0018\u00010\u000e2\t\u0010Â\u0002\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0003\u0010Ã\u0002J\u0015\u0010Ä\u0002\u001a\u00020:2\n\u0010À\u0001\u001a\u0005\u0018\u00010Á\u0001H\u0002J\t\u0010Å\u0002\u001a\u00020:H\u0002J\t\u0010Æ\u0002\u001a\u00020:H\u0002J\t\u0010Ç\u0002\u001a\u00020:H\u0002J\t\u0010È\u0002\u001a\u00020:H\u0002J\t\u0010É\u0002\u001a\u00020:H\u0002J\u0012\u0010Ê\u0002\u001a\u00020:2\u0007\u0010Ë\u0002\u001a\u00020\u000eH\u0002J\t\u0010Ì\u0002\u001a\u00020:H\u0002J\t\u0010Í\u0002\u001a\u00020:H\u0002J\t\u0010Î\u0002\u001a\u00020:H\u0002J\t\u0010Ï\u0002\u001a\u00020:H\u0002J\t\u0010Ð\u0002\u001a\u00020:H\u0003J\t\u0010Ñ\u0002\u001a\u00020:H\u0002J\t\u0010Ò\u0002\u001a\u00020:H\u0016J\t\u0010Ó\u0002\u001a\u00020:H\u0016J\t\u0010Ô\u0002\u001a\u00020:H\u0016J\u0012\u0010Õ\u0002\u001a\u00020:2\u0007\u0010Ö\u0002\u001a\u00020,H\u0004J\t\u0010×\u0002\u001a\u00020:H\u0016J\t\u0010Ø\u0002\u001a\u00020\u000eH\u0016J\t\u0010Ù\u0002\u001a\u00020,H\u0004J\t\u0010Ú\u0002\u001a\u00020:H\u0002J\t\u0010Û\u0002\u001a\u00020:H\u0016J\u0012\u0010Ü\u0002\u001a\u00020:2\u0007\u0010Ý\u0002\u001a\u00020\bH\u0016J\t\u0010Þ\u0002\u001a\u00020:H\u0002J\t\u0010ß\u0002\u001a\u00020:H\u0004J\u0013\u0010à\u0002\u001a\u00020:2\b\u0010á\u0002\u001a\u00030§\u0002H\u0002J\u0013\u0010â\u0002\u001a\u00020:2\b\u0010á\u0002\u001a\u00030§\u0002H\u0002J\u001b\u0010ã\u0002\u001a\u00020:2\u0007\u0010ä\u0002\u001a\u00020\b2\u0007\u0010å\u0002\u001a\u00020\bH\u0002J\u0012\u0010æ\u0002\u001a\u00020:2\u0007\u0010å\u0002\u001a\u00020\bH\u0002J2\u0010ç\u0002\u001a\u00020:2\b\u0010\"\u001a\u0004\u0018\u00010\u000e2\b\u0010%\u001a\u0004\u0018\u00010\u000e2\t\u0010è\u0002\u001a\u0004\u0018\u00010\u000e2\b\u0010\\\u001a\u0004\u0018\u00010\u000eH\u0016J\t\u0010ê\u0002\u001a\u00020:H\u0016J\u0012\u0010ë\u0002\u001a\u00020:2\u0007\u0010ì\u0002\u001a\u00020\bH\u0016J\u001b\u0010í\u0002\u001a\u00020:2\u0007\u0010î\u0002\u001a\u00020\b2\u0007\u0010ï\u0002\u001a\u00020\u000eH\u0002J\u0012\u0010ð\u0002\u001a\u00020:2\u0007\u0010¬\u0002\u001a\u00020,H\u0002J\u0011\u0010ñ\u0002\u001a\u00020:2\b\u0010ò\u0002\u001a\u00030ó\u0002J\u001f\u0010ô\u0002\u001a\u00020:2\t\b\u0002\u0010Ý\u0002\u001a\u00020\b2\t\b\u0002\u0010õ\u0002\u001a\u00020\bH\u0016J\u000b\u0010ö\u0002\u001a\u0004\u0018\u00010\u000eH\u0004J\u000f\u0010÷\u0002\u001a\u00020\u000e*\u0004\u0018\u00010\u000eH\u0002J\u001e\u0010ø\u0002\u001a\u00020:2\u0013\u0010ù\u0002\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020:06H\u0004R\u001a\u0010\u0007\u001a\u00020\bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001aX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u001c\u0010\"\u001a\u0004\u0018\u00010\u000eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R\u001c\u0010%\u001a\u0004\u0018\u00010\u000eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0010\"\u0004\b'\u0010\u0012R\u001c\u0010(\u001a\u0004\u0018\u00010\u000eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0010\"\u0004\b*\u0010\u0012R\u001a\u0010+\u001a\u00020,X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001b\u00101\u001a\u00020,8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b2\u0010.R7\u00105\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020:\u0018\u000106X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R7\u0010?\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020:\u0018\u000106X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010<\"\u0004\bA\u0010>R\u001c\u0010B\u001a\u0004\u0018\u00010CX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001a\u0010H\u001a\u00020\bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\n\"\u0004\bI\u0010\fR\u001c\u0010J\u001a\u0004\u0018\u00010KX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001c\u0010P\u001a\u0004\u0018\u00010KX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010M\"\u0004\bR\u0010OR\u001c\u0010S\u001a\u0004\u0018\u00010TX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001c\u0010Y\u001a\u0004\u0018\u00010CX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010E\"\u0004\b[\u0010GR\u001c\u0010\\\u001a\u0004\u0018\u00010\u000eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u0010\"\u0004\b^\u0010\u0012R\u001a\u0010_\u001a\u00020\u000eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u0010\"\u0004\ba\u0010\u0012R.\u0010b\u001a\u0016\u0012\u0004\u0012\u00020d\u0018\u00010cj\n\u0012\u0004\u0012\u00020d\u0018\u0001`eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u001c\u0010j\u001a\u0004\u0018\u00010\u000eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010\u0010\"\u0004\bl\u0010\u0012R\u001c\u0010m\u001a\u0004\u0018\u00010\u000eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010\u0010\"\u0004\bo\u0010\u0012R\u001a\u0010p\u001a\u00020\bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010\n\"\u0004\bq\u0010\fR\u001c\u0010r\u001a\u0004\u0018\u00010\u000eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010\u0010\"\u0004\bt\u0010\u0012R\u001c\u0010u\u001a\u0004\u0018\u00010\u000eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010\u0010\"\u0004\bw\u0010\u0012R\u001c\u0010x\u001a\u0004\u0018\u00010\u000eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010\u0010\"\u0004\bz\u0010\u0012R\u0010\u0010{\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010|\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010}\u001a\u0004\u0018\u00010\u000eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010\u0010\"\u0004\b\u007f\u0010\u0012R\u000f\u0010\u0080\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u0082\u0001\u001a\u00020,2\u0007\u0010\u0081\u0001\u001a\u00020,@BX\u0082\u000e¢\u0006\t\n\u0000\"\u0005\b\u0083\u0001\u00100R\u000f\u0010\u0084\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0085\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0086\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0087\u0001\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0088\u0001\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0089\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u008a\u0001\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u008b\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u0001X\u0084\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R\u0012\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u009b\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009d\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u009e\u0001\u001a\u00030\u009f\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010 \u0001R\u000f\u0010¡\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¢\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010£\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¤\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¥\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¦\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010§\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¨\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010©\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010ª\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010«\u0001\u001a\u00030¬\u0001X\u0084\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u00ad\u0001\u0010®\u0001\"\u0006\b¯\u0001\u0010°\u0001R\u000f\u0010±\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010²\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010³\u0001\u001a\u0004\u0018\u00010\u000eX\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b´\u0001\u0010\u0010\"\u0005\bµ\u0001\u0010\u0012R\u001f\u0010¶\u0001\u001a\u0004\u0018\u00010\u000eX\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b·\u0001\u0010\u0010\"\u0005\b¸\u0001\u0010\u0012R\u0011\u0010¹\u0001\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010º\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010»\u0001\u001a\u00030¬\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010¼\u0001\u001a\u0005\u0018\u00010½\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¾\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¿\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010À\u0001\u001a\u0005\u0018\u00010Á\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010Â\u0001\u001a\u00030Ã\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÆ\u0001\u00104\u001a\u0006\bÄ\u0001\u0010Å\u0001R\u000f\u0010Ç\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010È\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010É\u0001\u001a\u00030Ê\u0001X\u0084\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bË\u0001\u0010Ì\u0001\"\u0006\bÍ\u0001\u0010Î\u0001R \u0010Ï\u0001\u001a\u00030¬\u0001X\u0084\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÐ\u0001\u0010®\u0001\"\u0006\bÑ\u0001\u0010°\u0001R\u000f\u0010Ò\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010Ó\u0001\u001a!\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020:0Ô\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010Õ\u0001\u001a\u00030Ö\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÙ\u0001\u00104\u001a\u0006\b×\u0001\u0010Ø\u0001R\u0013\u0010Ú\u0001\u001a\u00030Û\u0001X\u0082\u000e¢\u0006\u0005\n\u0003\u0010Ü\u0001R\u001b\u0010Ý\u0001\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020:06X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010Þ\u0001\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\bß\u0001\u00104\u001a\u0005\bÞ\u0001\u0010\nR\u001e\u0010à\u0001\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\bá\u0001\u00104\u001a\u0005\bà\u0001\u0010\nR\u001e\u0010â\u0001\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\bä\u0001\u00104\u001a\u0005\bã\u0001\u0010\nR\u0012\u0010å\u0001\u001a\u0005\u0018\u00010æ\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010ç\u0001\u001a\u00030è\u0001X\u0082\u000e¢\u0006\u0005\n\u0003\u0010é\u0001R\u001d\u0010\u009f\u0002\u001a\u00020\bX\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009f\u0002\u0010\n\"\u0005\b \u0002\u0010\fR\u000f\u0010é\u0002\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006û\u0002"}, d2 = {"Lcom/larus/doc/impl/DocFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/larus/bmhome/ability/FloatChatFoldStatusChangeListener;", "Lcom/larus/doc/impl/chat/ability/IDocArtifactAbility;", "Lcom/larus/bmhome/ability/IDocTitleStateListener;", "<init>", "()V", "hasMobEnterPage", "", "getHasMobEnterPage", "()Z", "setHasMobEnterPage", "(Z)V", "docId", "", "getDocId", "()Ljava/lang/String;", "setDocId", "(Ljava/lang/String;)V", "binding", "Lcom/larus/doc/biz/impl/databinding/LarusLayoutDocDetailFragmentBinding;", "getBinding", "()Lcom/larus/doc/biz/impl/databinding/LarusLayoutDocDetailFragmentBinding;", "setBinding", "(Lcom/larus/doc/biz/impl/databinding/LarusLayoutDocDetailFragmentBinding;)V", "chatInputFragment", "Landroidx/fragment/app/Fragment;", "getChatInputFragment", "()Landroidx/fragment/app/Fragment;", "setChatInputFragment", "(Landroidx/fragment/app/Fragment;)V", "docContainerFragment", "getDocContainerFragment", "setDocContainerFragment", "artifactMetaId", "getArtifactMetaId", "setArtifactMetaId", "artifactVersionId", "getArtifactVersionId", "setArtifactVersionId", "docEnterFrom", "getDocEnterFrom", "setDocEnterFrom", "resourceType", "", "getResourceType", "()I", "setResourceType", "(I)V", "editIconStyle", "getEditIconStyle", "editIconStyle$delegate", "Lkotlin/Lazy;", "moreMenuItemClickHandler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "id", "", "getMoreMenuItemClickHandler", "()Lkotlin/jvm/functions/Function1;", "setMoreMenuItemClickHandler", "(Lkotlin/jvm/functions/Function1;)V", "menuClickHandler", "getMenuClickHandler", "setMenuClickHandler", "opBarRootView", "Landroid/view/View;", "getOpBarRootView", "()Landroid/view/View;", "setOpBarRootView", "(Landroid/view/View;)V", "isOpBarVisibilityChanged", "setOpBarVisibilityChanged", "chatInputAndOpBarContainer", "Landroid/view/ViewGroup;", "getChatInputAndOpBarContainer", "()Landroid/view/ViewGroup;", "setChatInputAndOpBarContainer", "(Landroid/view/ViewGroup;)V", "chatInputContainer", "getChatInputContainer", "setChatInputContainer", "loadingText", "Lcom/larus/office/base/view/TextLoadingView;", "getLoadingText", "()Lcom/larus/office/base/view/TextLoadingView;", "setLoadingText", "(Lcom/larus/office/base/view/TextLoadingView;)V", "chatInputBgMask", "getChatInputBgMask", "setChatInputBgMask", "bindedMessageId", "getBindedMessageId", "setBindedMessageId", "docConvId", "getDocConvId", "setDocConvId", "docListToApplyPermission", "Ljava/util/ArrayList;", "Lcom/larus/office/base/preview/DocMeta;", "Lkotlin/collections/ArrayList;", "getDocListToApplyPermission", "()Ljava/util/ArrayList;", "setDocListToApplyPermission", "(Ljava/util/ArrayList;)V", "applyPermissionConversationId", "getApplyPermissionConversationId", "setApplyPermissionConversationId", "applyPermissionMessageId", "getApplyPermissionMessageId", "setApplyPermissionMessageId", "isAudioRecordDoc", "setAudioRecordDoc", "docName", "getDocName", "setDocName", "generalAgent", "getGeneralAgent", "setGeneralAgent", "agentChatId", "getAgentChatId", "setAgentChatId", "latestMsgIdFromDB", "createdDocCardMessageId", "offlineCreateAttemptId", "getOfflineCreateAttemptId", "setOfflineCreateAttemptId", "isTransferringOfflineCreateAttempt", "value", "loadingTextState", "setLoadingTextState", "isAiAnswerInFlight", "canPlayTtsAndPodcast", "isDocEmpty", "docLatestVersion", "resourceVersion", "firstInitChatFrag", "createDocByMsgConvId", "isChatPanelExpanded", "chatService", "Lcom/larus/doc/sdk/api/IChatService;", "getChatService", "()Lcom/larus/doc/sdk/api/IChatService;", "setChatService", "(Lcom/larus/doc/sdk/api/IChatService;)V", "docModeService", "Lcom/larus/doc/sdk/api/IDocModeService;", "commonOperationService", "Lcom/larus/doc/sdk/api/ICommonOperationService;", "loadingService", "Lcom/larus/office/base/page/ILoadingService;", "titleBarService", "Lcom/larus/office/base/service/ITitleBarService;", "loadingDocStateService", "Lcom/larus/doc/sdk/api/ILoadingDocStateService;", "offlineDocCreateAbility", "Lcom/larus/doc/impl/offline/IOfflineDocCreateAbility;", "offlineDocCreateHostAbility", "com/larus/doc/impl/DocFragment$offlineDocCreateHostAbility$1", "Lcom/larus/doc/impl/DocFragment$offlineDocCreateHostAbility$1;", "undoBtnEnabled", "hasReportUndoBtnShow", "redoBtnEnabled", "hasReportRedoBtnShow", "exportBtnEnabled", "hasReportExportBtnShow", "hasReportCopyBtnShow", "copyBtnEnabled", "finishBtnEnabled", "hasReportFinishBtnShow", "docRenderCompleteTimestamp", "", "getDocRenderCompleteTimestamp", "()J", "setDocRenderCompleteTimestamp", "(J)V", "hasReportedDocFloatChatCreatedDuration", "isDocDeleted", "previousPage", "getPreviousPage", "setPreviousPage", "clickPreviousPage", "getClickPreviousPage", "setClickPreviousPage", "parentMenu", "startedTts", "startTtsTime", "hostAbilityProvider", "Lcom/larus/office/base/page/IHostAbilityProvider;", "isChatInputHasFocus", "isInSpeakStatus", "menuData", "Lcom/larus/office/base/service/BizMenuData;", "ttsReader", "Lcom/larus/bmhome/chat/model/repo/ITtsReader;", "getTtsReader", "()Lcom/larus/bmhome/chat/model/repo/ITtsReader;", "ttsReader$delegate", "hasSelectionText", "isCustomHeaderShowing", "docMode", "Lcom/larus/doc/sdk/api/model/DocMode;", "getDocMode", "()Lcom/larus/doc/sdk/api/model/DocMode;", "setDocMode", "(Lcom/larus/doc/sdk/api/model/DocMode;)V", "setServiceTimeStamp", "getSetServiceTimeStamp", "setSetServiceTimeStamp", "wasKeyboardShowing", "selectTextChangeListener", "Lkotlin/Function3;", "reportEventPluginParamAdder", "com/larus/doc/impl/DocFragment$reportEventPluginParamAdder$2$1", "getReportEventPluginParamAdder", "()Lcom/larus/doc/impl/DocFragment$reportEventPluginParamAdder$2$1;", "reportEventPluginParamAdder$delegate", "speakStateListener", "com/larus/doc/impl/DocFragment$speakStateListener$1", "Lcom/larus/doc/impl/DocFragment$speakStateListener$1;", "inputFocusChangeListener", "isDocPodcastEnable", "isDocPodcastEnable$delegate", "isDocTtsEnable", "isDocTtsEnable$delegate", "exportIconStyleOpt", "getExportIconStyleOpt", "exportIconStyleOpt$delegate", "podcastJob", "Lkotlinx/coroutines/Job;", "streamPlayerInterceptor", "com/larus/doc/impl/DocFragment$streamPlayerInterceptor$1", "Lcom/larus/doc/impl/DocFragment$streamPlayerInterceptor$1;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "getChatFragment", "canRead", "canShare", "canCopy", "canDelete", "canManage", "canEdit", "reviewSuccess", "isOwner", "adaptDocOperationBarInPad", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "setupTextLoadingView", "setupDocOpBtn", "refreshDocPermission", "getChatContainerId", "integrateFloatChatFragment", "frgManager", "Landroidx/fragment/app/FragmentManager;", "buildRemoteBindingRefreshBundle", "retryOpenWithOnlineCreateDoc", "docRealToken", "onFloatChatFragmentCreated", "reportDocFloatChatCreatedDurationIfNeeded", "querySubConvLatestDocMsgId", "setupServices", "setupOfflineDocCreateComponent", "generateDocLogicKeyForFindService", "initDocModeService", "onBackPressed", "autoLogEnterPage", "getFeishuRecordId", "getRecordContentType", "getRecordScene", "getRecordGeneralAgent", "getRecordAgentChatId", "putRecordingAgentParams", "Lorg/json/JSONObject;", "initHostAbilityProvider", "initOperationService", "notifyChatInputVisibilityChanged", "visible", "getChatPanelHeight", "initChatService", "isInTranscriptTab", "setInTranscriptTab", "setupChatAndOpBarContainer", "switchScene", "aiEditMode", "initLoadingService", "initFragment", "it", "Landroid/content/Context;", "getTitleView", "initTitleBarService", "initLoadingDocStateService", "updateLoadingDocState", "state", "updateCompleteIcon", "onMenuClick", "updateMoreIcon", "updateExportIcon", "getDefaultDocName", "getDocInfoProvider", "Lcom/larus/doc/sdk/api/IDocInfoProvider;", "getMinutesInfo", "Lcom/larus/doc/sdk/api/model/MinutesInfoModel;", "showDownloadFragment", "subtype", "mobCopyEditAndExportClick", "buttonName", "copyContentType", "updateCopyIcon", "updateRedoIcon", "updateUndoIcon", "updateTitle", "type", "title", "subTitle", "newDocName", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "setTitleSoundsBtn", "tryStopTts", "triggerAppletWhenModifyDoc", "startTts", "stopTtsAni", "startTtsAni", "mobTtsEnd", "endMethod", "mobStartTts", "mobClickPodCast", "sendPodcastRequest", "attachComponent", "setupInterceptView", "setUpChatInputBgMask", "foldStatusChanged", "onDestroyView", "onDestroy", "updateDocumentBriefWithOfflineContext", "artifactType", "updateDocBrief", "getCurrentPageName", "getTrackingResourceType", "showMoreMenu", "notifyEditPanelHeightChanged", "updateInputVisibility", "tryShow", "jumpToChatPage", "dismissAllBalloon", "showAudioRecordCopySubMenu", "ctx", "showSubMenu", "mobOnDocPermissionUpdate", FlowDoraConnectReason.SUCCESS, "isPublic", "internalChangeDocPermission", "updateArtifactInfo", "conversationId", "isInThinkingState", "onThinkingState", "onTitleStateReset", "isPartialEdit", "setAiAnswerInFlight", "inFlight", "reason", "notifyAiThinkingStateChangedToWeb", "onApplyWindowsInsets", "insets", "Landroidx/core/view/WindowInsetsCompat;", "updateDocOpBarVisibility", "needAdjustPanelHeight", "getLatestDocMessageId", "safeLogId", "copyPermissionValidate", "callback", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DocFragment extends TraceFragment implements va8.d, g39.a, va8.e0 {
    public static final /* synthetic */ int L2 = 0;
    public String A;
    public boolean B;
    public String C;
    public String D;
    public String E;
    public final Lazy E2;
    public String F;
    public final Lazy F2;
    public String G;
    public CommonMenu G1;
    public final Lazy G2;
    public String H;
    public boolean H0;
    public boolean H1;
    public Job H2;
    public boolean I;
    public final d I2;
    public int J;
    public boolean J2;
    public boolean K;
    public boolean K2;
    public boolean L;
    public boolean L0;
    public long L1;
    public boolean M;
    public x0 M1;
    public int N;
    public int O;
    public String P;
    public boolean P0;
    public boolean P1;
    public boolean Q;
    public boolean Q1;
    public DocFragment$initChatService$1 R;
    public DocFragment$initDocModeService$1 S;
    public final Lazy S1;
    public DocFragment$initOperationService$1 T;
    public boolean T1;
    public DocFragment$initLoadingService$1 U;
    public DocFragment$initTitleBarService$1 V;
    public boolean V0;
    public boolean V1;
    public DocFragment$initLoadingDocStateService$1 W;
    public com.larus.doc.impl.offline.c X;
    public final DocFragment$offlineDocCreateHostAbility$1 Y;
    public boolean Z;
    public boolean b1;
    public DocMode b2;
    public boolean e;
    public String f;
    public LarusLayoutDocDetailFragmentBinding g;
    public boolean g1;
    public long g2;
    public Fragment h;
    public boolean h1;
    public boolean h2;
    public Fragment i;
    public String j;
    public String k;
    public boolean k0;
    public long k1;
    public String l;
    public int m;
    public final Lazy n;
    public Function1<? super String, Unit> o;
    public Function1<? super String, Unit> p;
    public boolean p0;
    public boolean p1;
    public final q0 p2;
    public View q;
    public boolean r;
    public ViewGroup s;
    public ViewGroup t;
    public TextLoadingView u;
    public View v;
    public boolean v1;
    public final Lazy v2;
    public String w;
    public String x;
    public String x1;
    public final c x2;
    public ArrayList<DocMeta> y;
    public String y1;
    public final s0 y2;
    public String z;

    public static final class a {
    }

    public static final class b implements bn9.a {
        public final /* synthetic */ DocFragment a;

        public b(DocFragment r1) {
            this.a = r1;
        }

        public final void d(String r2, JSONObject r3) {
            Intrinsics.checkNotNullParameter(r2, "event");
            if (Intrinsics.areEqual(r2, "text_selection_bar_click") == true) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(r3.optString("page_token"), this.a.f) == false) goto L9;
            r3.put(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE, this.a.x1);
            return;
        }
    }

    public static final class c implements com.larus.bmhome.chat.component.bottom.core.speaker.h {
        public final /* synthetic */ DocFragment a;

        public c(DocFragment r1) {
            this.a = r1;
        }

        public final void a(com.larus.bmhome.chat.component.bottom.core.speaker.g r4) {
            Intrinsics.checkNotNullParameter(r4, "state");
            FLogger.a.i("onStateChanged", "onStateChanged state=" + r4);
            if (Intrinsics.areEqual(r4, com.larus.bmhome.chat.component.bottom.core.speaker.g.c.a) == false) goto L16;
            TextLoadingView r5 = this.a.u;
            if (r5 != null) goto L7;
        L9:
            boolean r6 = false;
        L10:
            if (r6 == false) goto L14;
            TextLoadingView r7 = this.a.u;
            if (r7 == null) goto L14;
            com.larus.utils.e1.q(r7);
        L14:
            this.a.Q1 = true;
        L46:
            DocFragment.za0(this.a, false, 3);
            return;
        L7:
            if (r5.getVisibility() != 0) goto L9;
            r6 = true;
            goto L10
        L16:
            if (Intrinsics.areEqual(r4, com.larus.bmhome.chat.component.bottom.core.speaker.g.b.a) == false) goto L21;
            TextLoadingView r8 = this.a.u;
            if (r8 == null) goto L20;
            com.larus.utils.e1.o(r8);
        L20:
            DocFragment r9 = this.a;
            r9.Q1 = false;
            r9.qa0(0);
            goto L46
        L21:
            TextLoadingView r0 = this.a.u;
            if (r0 != null) goto L24;
        L26:
            boolean r1 = false;
        L27:
            if (r1 == false) goto L29;
        L45:
            this.a.Q1 = false;
            goto L46
        L29:
            if (Intrinsics.areEqual(r4, com.larus.bmhome.chat.component.bottom.core.speaker.g.a.a) == true) goto L45;
            Fragment r10 = this.a.h;
            if (r10 == null) goto L39;
            t1a.b r11 = s1a.a.g(r10);
            if (r11 == null) goto L39;
            va8.g0 r12 = r11.getAbility(va8.g0.class);
            if (r12 == null) goto L39;
            if (r12.YC() != true) goto L39;
            boolean r13 = true;
        L40:
            if (r13 == true) goto L45;
            TextLoadingView r14 = this.a.u;
            if (r14 == null) goto L44;
            com.larus.utils.e1.x(r14);
        L44:
            this.a.qa0(1);
        L39:
            r13 = false;
            goto L40
        L24:
            if (r0.getVisibility() != 0) goto L26;
            r1 = true;
            goto L27
        }
    }

    public static final class d implements IStreamPlayerInterceptor {
        public final /* synthetic */ DocFragment a;

        public final void b() {
        }

        public final IStreamPlayerInterceptor.StreamType c() {
            return IStreamPlayerInterceptor.StreamType.DOC;
        }

        public d(DocFragment r1) {
            this.a = r1;
        }

        public final boolean a(JSONObject r6) {
            Intrinsics.checkNotNullParameter(r6, "param");
            int r7 = r6.optInt("docVersion", -1);
            LarusLayoutDocDetailFragmentBinding r0 = this.a.g;
            boolean r1 = true;
            if (r0 == null) goto L12;
            ImageView r2 = r0.j;
            if (r2 == null) goto L12;
            if (r2.getVisibility() != 0) goto L9;
            boolean r3 = true;
        L10:
            if (r3 != true) goto L12;
            boolean r4 = true;
        L14:
            if (r7 < this.a.N) goto L18;
            if (r4 == true) goto L18;
            r1 = false;
        L18:
            if (r1 == false) goto L20;
            FLogger.a.e("DocFragment", "current doc version: " + this.a.N + ", param doc version: " + r7 + ", isEditing=" + r4);
        L20:
            return r1;
        L9:
            r3 = false;
        L12:
            r4 = false;
            goto L14
        }
    }

    static {
    }

    @Override // g39.a
    public final String RR() {
        return null;
    }

    public final boolean S90() {
        return false;
    }

    @Override // g39.a
    public final DocArtifactInfo X4() {
        return null;
    }

    public String Y90() {
        return "default_doc_logic_key";
    }

    public int Z90() {
        return 2131369292;
    }

    public boolean canCopy() {
        return true;
    }

    public boolean canEdit() {
        return true;
    }

    public boolean canRead() {
        return true;
    }

    public boolean canShare() {
        return true;
    }

    public ViewGroup fa0() {
        return null;
    }

    public boolean isOwner() {
        return true;
    }

    public final String k() {
        return "ai_doc_detail";
    }

    public void ka0(boolean r1) {
    }

    public void la0() {
    }

    public boolean p6() {
        return true;
    }

    public boolean s8() {
        return true;
    }

    public boolean y4() {
        return true;
    }

    @Override // g39.a
    public final String Q40() {
        String r0 = this.E;
        if (r0 != null) goto L5;
    L14:
        Bundle r1 = getArguments();
        if (r1 != null) goto L17;
        return null;
    L17:
        return r1.getString("chat_id", null);
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L14;
        return r0;
    L7:
        r2 = false;
        goto L8
    }

    public final void W90() {
        if (e2.a.isPad() == true) goto L5;
        return;
    L5:
        int r0 = f3.a.b();
        View r1 = this.q;
        if (r1 == null) goto L11;
        ViewGroup r2 = (ViewGroup) r1.findViewById(2131364494);
        if (r2 == null) goto L12;
        r2.setPadding(i5.h() + r0, r2.getPaddingTop(), r0 + i5.h(), r2.getPaddingBottom());
        return;
    L12:
        return;
    }

    public final void X90() {
        CommonMenu r0 = this.G1;
        if (r0 == null) goto L5;
        com.larus.bmhome.view.screenmenu.d r1 = com.larus.bmhome.view.screenmenu.d.a;
        com.larus.bmhome.view.screenmenu.d.b(r0);
    L5:
        LarusLayoutDocDetailFragmentBinding r2 = this.g;
        if (r2 == null) goto L11;
        ConstraintLayout r3 = r2.h;
        if (r3 == null) goto L12;
        com.larus.bmhome.view.screenmenu.d r4 = com.larus.bmhome.view.screenmenu.d.a;
        com.larus.bmhome.view.screenmenu.d.b(r3);
        return;
    L12:
        return;
    }

    public int aa0() {
        ViewGroup r0 = this.t;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getHeight();
    }

    public final n39.f ca0() {
        IDocSdkBaseService r0 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDocInfoProvider(Y90());
    }

    public final int da0() {
        return ((Number) this.n.getValue()).intValue();
    }

    public final String ea0() {
        Fragment r0 = this.h;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if (r2 == false) goto L113;
        Fragment r3 = this.h;
        if (r3 == null) goto L17;
        t1a.b r4 = s1a.a.g(r3);
        if (r4 == null) goto L17;
        com.larus.bmhome.chat.component.cvs.y r5 = r4.getAbility(com.larus.bmhome.chat.component.cvs.y.class);
        if (r5 == null) goto L17;
        wc9.e r6 = r5.h();
    L19:
        if (r6 != null) goto L21;
    L73:
        String r7 = this.G;
        if (r7 != null) goto L76;
    L79:
        boolean r8 = true;
    L80:
        if (r8 == true) goto L83;
        FLogger.a.i("DocFragment", "Got the doc card message id from create_by_message response");
        return this.G;
    L83:
        Bundle r9 = getArguments();
        if (r9 == null) goto L86;
        String r10 = r9.getString("argPreviousPage");
    L88:
        if (Intrinsics.areEqual(r10, "ai_space_list") == false) goto L97;
        String r11 = this.w;
        if (r11 != null) goto L92;
    L93:
        r1 = true;
    L94:
        if (r1 == true) goto L97;
        FLogger.a.i("DocFragment", "Got the doc card message id from get_meta_by_resource response");
        return this.w;
    L92:
        if (r11.length() != 0) goto L94;
    L97:
        FLogger.a.i("DocFragment", "Got the doc card message id from main conversation message card");
        Bundle r12 = getArguments();
        if (r12 != null) goto L100;
        return null;
    L100:
        return r12.getString("key_message_id", null);
    L86:
        r10 = null;
        goto L88
    L76:
        if (r7.length() == 0) goto L79;
        r8 = false;
        goto L80
    L21:
        if (ic8.n.r(r6) == true) goto L73;
        if (ic8.n.v(r6) == true) goto L73;
        Fragment r13 = this.h;
        if (r13 == null) goto L114;
        t1a.b r14 = s1a.a.g(r13);
        if (r14 == null) goto L115;
        u7 r15 = r14.getAbility(u7.class);
        if (r15 == null) goto L116;
        MessageAdapter r16 = r15.MF();
        if (r16 == null) goto L117;
        Iterator r17 = r16.getCurrentList().iterator();
    L34:
        if (r17.hasNext() == false) goto L50;
        Object r18 = r17.next();
        Iterator r20 = com.larus.im.bean.message.a.d((Message) r18).iterator();
    L37:
        if (r20.hasNext() == false) goto L44;
        Object r21 = r20.next();
        if (((Block) r21).getBlockType() != BlockType.BLOCK_TYPE_ARTIFACT.getValue()) goto L41;
        boolean r22 = true;
    L42:
        if (r22 == false) goto L37;
    L45:
        if (r21 == null) goto L47;
        boolean r23 = true;
    L48:
        if (r23 == false) goto L34;
    L51:
        Message r24 = (Message) r18;
        if (r24 == null) goto L54;
        String r25 = r24.getMessageId();
    L56:
        if (TextUtils.isEmpty(r25) == false) goto L58;
        oa0();
    L58:
        FLogger r26 = FLogger.a;
        StringBuilder r27 = new StringBuilder("Got the sub conversation doc card message id: ");
        if (r24 == null) goto L61;
        String r28 = r24.getMessageId();
    L62:
        r27.append(r28);
        r26.i("DocFragment", r27.toString());
        if (r24 == null) goto L66;
        String r30 = r24.getMessageId();
        if (r30 == null) goto L66;
    L72:
        return r30;
    L66:
        r30 = this.F;
        if (r30 != null) goto L72;
        Bundle r31 = getArguments();
        if (r31 != null) goto L112;
        return null;
    L112:
        return r31.getString("key_message_id", null);
    L61:
        r28 = null;
        goto L62
    L54:
        r25 = null;
        goto L56
    L47:
        r23 = false;
        goto L48
    L41:
        r22 = false;
        goto L42
    L44:
        r21 = null;
        goto L45
    L50:
        r18 = null;
        goto L51
    L117:
        return null;
    L116:
        return null;
    L115:
        return null;
    L114:
        return null;
    L17:
        r6 = null;
        goto L19
    L113:
        return null;
    L5:
        if (r0.isAdded() != true) goto L7;
        r2 = true;
        goto L9
    }

    public void foldStatusChanged() {
        Fragment r0 = this.h;
        boolean r1 = true;
        if (r0 == null) goto L11;
        t1a.b r2 = s1a.a.g(r0);
        if (r2 == null) goto L11;
        va8.g0 r3 = r2.getAbility(va8.g0.class);
        if (r3 == null) goto L11;
        if (r3.YC() != true) goto L11;
        boolean r4 = true;
    L12:
        Integer r5 = null;
        Drawable r6 = null;
        r6 = null;
        if (r4 == false) goto L39;
        this.Q = true;
        Fragment r7 = this.h;
        if (r7 == null) goto L26;
        t1a.b r8 = s1a.a.g(r7);
        if (r8 == null) goto L26;
        va8.g0 r9 = r8.getAbility(va8.g0.class);
        if (r9 == null) goto L26;
        Context r10 = getContext();
        if (r10 == null) goto L25;
        Resources r11 = r10.getResources();
        if (r11 == null) goto L25;
        r6 = r11.getDrawable(2131240729);
    L25:
        r9.gA(r6);
    L26:
        View r12 = this.v;
        if (r12 == null) goto L29;
        com.larus.utils.e1.x(r12);
    L29:
        FLogger.a.i("DocFragment", "foldStatusChanged loadingText invisible");
        TextLoadingView r13 = this.u;
        if (r13 != null) goto L32;
    L34:
        r1 = false;
    L35:
        if (r1 == false) goto L50;
        TextLoadingView r14 = this.u;
        if (r14 == null) goto L50;
        com.larus.utils.e1.q(r14);
    L50:
        za0(this, false, 3);
        return;
    L32:
        if (r13.getVisibility() != 0) goto L34;
    L39:
        FLogger r15 = FLogger.a;
        StringBuilder r16 = new StringBuilder("foldStatusChanged loadingText visibility=");
        TextLoadingView r17 = this.u;
        if (r17 == null) goto L42;
        r5 = Integer.valueOf(r17.getVisibility());
    L42:
        r16.append(r5);
        r15.i("DocFragment", r16.toString());
        this.Q = false;
        if (this.J == 0) goto L47;
        TextLoadingView r18 = this.u;
        if (r18 == null) goto L47;
        com.larus.utils.e1.x(r18);
    L47:
        View r20 = this.v;
        if (r20 == null) goto L50;
        com.larus.utils.e1.o(r20);
    L11:
        r4 = false;
        goto L12
    }

    public final int ga0() {
        int r0 = com.larus.office.base.utils.o.a;
        Integer r1 = com.larus.office.base.utils.o.b(Integer.valueOf(this.m), 10);
        if (r1 == null) goto L6;
        return r1.intValue();
    L6:
        return this.m;
    }

    public void ma0() {
        SoftReference r0 = com.larus.utils.y.a;
        Runnable r1 = new e(this);
        Intrinsics.checkNotNullParameter(r1, "action");
        com.larus.utils.y.d(r1, 500);
    }

    @Override // g39.a
    public final String oh() {
        String r0 = this.D;
        if (r0 != null) goto L5;
    L14:
        Bundle r1 = getArguments();
        if (r1 != null) goto L17;
        return null;
    L17:
        return r1.getString("is_general_agent", null);
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L14;
        return r0;
    L7:
        r2 = false;
        goto L8
    }

    public void onDestroy() {
        FLogger.a.i("DocFragment", "[onDestroy]");
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (isRemoving() == true) goto L19;
        FragmentActivity r3 = getActivity();
        if (r3 != null) goto L13;
    L15:
        boolean r4 = false;
    L16:
        if (r4 == true) goto L19;
        boolean r5 = false;
    L20:
        if (r5 == false) goto L25;
        if (r1 == true) goto L25;
        if (this.I == true) goto L25;
        OfflineDocReportGate r2 = OfflineDocReportGate.a;
        String r6 = this.H;
        r2.getClass();
        OfflineDocReportGate.c(r6);
    L25:
        com.larus.doc.impl.offline.c r7 = this.X;
        if (r7 == null) goto L29;
        r7.b10(z2.a.getDocOfflineCreateConfig().a());
    L29:
        if (this.v1 == true) goto L34;
        IDocSdkBaseService r8 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);
        if (r8 == null) goto L34;
        r8.reportDocPageExit("click_back");
    L34:
        if (this.e == true) goto L40;
        this.e = true;
        int r9 = com.larus.doc.impl.offline.k.a;
        String r10 = this.H;
        if (Intrinsics.areEqual(this.l, "answer_manual_create") == false) goto L38;
        String r11 = "send_message_create";
    L39:
        String r12 = r11;
        String r13 = this.f;
        String r14 = this.j;
        int r15 = ga0();
        int r16 = ga0();
        String r17 = ea0();
        JSONObject r18 = new JSONObject();
        na0(r18);
        com.larus.doc.impl.offline.k.a(r10, r12, r13, r14, Integer.valueOf(r15), Integer.valueOf(r16), r17, r18, this);
        goto L40
    L38:
        r11 = this.l;
    L40:
        wa0();
        AudioStreamPlayerDelegate.b.g(this.I2);
        if (Intrinsics.areEqual(this.f, "fake_doc_id") == false) goto L43;
    L45:
        IDocSdkBaseService r20 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);
        if (r20 == null) goto L51;
        n39.l r21 = r20.getPartialRewriteService();
        if (r21 == null) goto L50;
        r21.removeSelectedTextChangeListener(this.p2);
    L50:
        r20.removeChatService(this.R);
        r20.removeDocModeService(this.S);
        r20.removeLoadingService(this.U);
        r20.removeOperationService(this.T);
        r20.removeTitleBarService(this.V);
        r20.removeLoadingDocStateService(this.W);
        r20.setHostAbilityProvider(null);
    L51:
        String r22 = m39.a.a;
        String r23 = this.f;
        if (m39.a.f == true) goto L54;
    L56:
        m39.a.f = false;
        m39.a.a = null;
        m39.a.b = null;
        m39.a.c = null;
        m39.a.d = "";
        m39.a.e = null;
    L57:
        IFlowTtsClientService.a.getClass();
        IFlowTtsClientService.a.a().n(false);
        Fragment r24 = this.h;
        if (r24 != null) goto L60;
    L73:
        this.p = null;
        this.o = null;
        this.i = null;
        this.K = false;
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        return;
    L60:
        if (r24.isAdded() == false) goto L73;
        va8.g0 r25 = s1a.a.g(r24).getAbility(va8.g0.class);
        if (r25 == null) goto L64;
        r25.Zh(this);
    L64:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r26 = s1a.a.g(r24).getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
        if (r26 == null) goto L67;
        r26.B9(this.x2);
    L67:
        va8.d0 r27 = s1a.a.g(r24).getAbility(va8.d0.class);
        if (r27 == null) goto L70;
        r27.UZ(this);
    L70:
        va8.o r28 = s1a.a.g(r24).getAbility(va8.o.class);
        if (r28 == null) goto L73;
        r28.oR(this.y2);
        goto L73
    L54:
        if (Intrinsics.areEqual(r23, m39.a.a) == false) goto L56;
        m39.a.f = false;
        goto L57
    L43:
        if (Intrinsics.areEqual(this.f, "fake_offline_doc_id") == true) goto L45;
        xa0();
        goto L45
    L13:
        if (r3.isFinishing() != true) goto L15;
        r4 = true;
    L19:
        r5 = true;
        goto L20
    L5:
        if (r0.isChangingConfigurations() != true) goto L7;
        r1 = true;
        goto L9
    }

    public final void onThinkingState() {
        com.larus.utils.t0.e(new n(this));
    }

    public void ra0() {
        LarusLayoutDocDetailFragmentBinding r0 = this.g;
        ViewStub r1 = null;
        if (r0 == null) goto L5;
        TextLoadingView r2 = r0.w;
    L6:
        this.u = r2;
        if (r2 == null) goto L10;
        com.larus.utils.e1.d(r2, new k(this));
    L10:
        if (this.q != null) goto L41;
        LarusLayoutDocDetailFragmentBinding r3 = this.g;
        if (r3 == null) goto L15;
        r1 = r3.f;
    L15:
        if (r1 != null) goto L17;
        return;
    L17:
        if (r1.getParent() == null) goto L42;
        int r4 = da0();
        if (r4 == 1) goto L24;
        if (r4 == 2) goto L23;
        int r5 = 2131562124;
    L25:
        r1.setLayoutResource(r5);
        this.q = r1.inflate();
        W90();
        za0(this, false, 2);
        if (da0() == 1) goto L32;
        View r6 = this.q;
        if (r6 == null) goto L32;
        View r7 = r6.findViewById(2131369311);
        if (r7 == null) goto L32;
        com.larus.utils.e1.d(r7, new m(this));
    L32:
        View r8 = this.q;
        if (r8 == null) goto L39;
        View r9 = r8.findViewById(2131369314);
        if (r9 == null) goto L40;
        com.larus.utils.e1.d(r9, new o(this));
        return;
    L40:
        return;
    L39:
        return;
    L23:
        r5 = 2131562123;
        goto L25
    L24:
        r5 = 2131562125;
        goto L25
    L42:
        return;
    L41:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void ta0() {
        final Context r1 = getContext();
        if (r1 == null) goto L85;
        LarusLayoutDocDetailFragmentBinding r2 = this.g;
        if (r2 == null) goto L86;
        final ConstraintLayout r3 = r2.h;
        if (r3 == null) goto L87;
        final ArrayList r4 = new ArrayList();
        if (canShare() == false) goto L12;
        r4.add(new com.larus.bmhome.view.screenmenu.l0(2131899603, 2131899603, null, null, null, null, null, null, null, false, false, null, 2131241671, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4100, 127));
    L12:
        ViewGroup.MarginLayoutParams r12 = null;
        if (da0() == 1) goto L25;
        if (canCopy() == false) goto L25;
        boolean r5 = this.B;
        if (r5 == false) goto L19;
        int r15 = 2131899598;
    L20:
        if (r5 == false) goto L22;
        Integer r21 = 2131241664;
    L23:
        r4.add(new com.larus.bmhome.view.screenmenu.l0(2131899528, r15, null, null, null, null, null, r21, null, false, false, null, 2131240381, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4228, 127));
        goto L25
    L22:
        r21 = null;
        goto L23
    L19:
        r15 = 2131899528;
    L25:
        if (canShare() == false) goto L27;
    L28:
        r4.add(new com.larus.bmhome.view.screenmenu.i0(1, getResources().getColor(2131103159)));
    L30:
        if (this.L == true) goto L32;
    L50:
        IFlowOfficeThemeConfigProvider r6 = (IFlowOfficeThemeConfigProvider) ServiceManager.get().getService(IFlowOfficeThemeConfigProvider.class);
        if (r6 == null) goto L54;
        r6.a(new d0(this, r4), AdaptThemeFeatureKey.OFFICE_DOCX_AI_PODCAST);
    L54:
        if (canRead() == false) goto L57;
        r4.add(new com.larus.bmhome.view.screenmenu.i0(2, getResources().getColor(2131103159)));
    L57:
        if (canEdit() == false) goto L60;
        r4.add(new com.larus.bmhome.view.screenmenu.l0(2131901780, 2131901780, null, null, null, null, null, null, null, false, false, null, 2131241676, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4100, 127));
        r4.add(new com.larus.bmhome.view.screenmenu.l0(2131899561, 2131899561, null, null, null, null, null, null, null, false, false, null, 2131240382, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4100, 127));
    L60:
        if (s8() == false) goto L63;
        r4.add(new com.larus.bmhome.view.screenmenu.l0(2131899592, 2131899592, null, null, null, null, null, 2131241664, null, false, false, null, 2131241216, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4228, 127));
    L63:
        if (canEdit() == false) goto L65;
    L66:
        r4.add(new com.larus.bmhome.view.screenmenu.i0(3, getResources().getColor(2131103159)));
    L68:
        if (isOwner() == true) goto L71;
        r4.add(new com.larus.bmhome.view.screenmenu.l0(2131907413, 2131907413, null, null, null, null, null, null, null, false, false, null, 2131240341, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4100, 127));
    L71:
        if (y4() == false) goto L73;
        r4.add(new com.larus.bmhome.view.screenmenu.l0(2131899533, 2131899533, null, null, null, 2131102650, null, null, null, false, false, null, 2131240380, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4132, 127));
    L73:
        CommonMenu r13 = new CommonMenu(r1);
        r13.h(Reflection.getOrCreateKotlinClass(com.larus.bmhome.view.screenmenu.i0.class), new com.larus.bmhome.view.screenmenu.j0());
        r13.h(Reflection.getOrCreateKotlinClass(com.larus.bmhome.view.screenmenu.l0.class), new com.larus.bmhome.view.screenmenu.q0());
        r13.d(i5.B());
        r13.h = i5.A();
        r13.g(r4, new e0(this, r1, r3));
        View r14 = r13.i();
        Balloon r7 = com.larus.bmhome.view.screenmenu.d.a(com.larus.bmhome.view.screenmenu.d.a, r3, r14, false, null, null, null, new f0(this), 56);
        ViewGroup.LayoutParams r8 = r14.getLayoutParams();
        if ((r8 instanceof ViewGroup.MarginLayoutParams) == false) goto L76;
        r12 = (ViewGroup.MarginLayoutParams) r8;
    L76:
        if (r12 == null) goto L80;
        r12.setMarginEnd((-i5.Q()) + i5.E());
    L80:
        if (com.larus.utils.i.h(r1) == false) goto L82;
        r7.x(r3, -r3.getMeasuredWidth(), -i5.Q());
    L83:
        this.G1 = r13;
        return;
    L82:
        r7.x(r3, r3.getMeasuredWidth(), -i5.Q());
        goto L83
    L65:
        if (s8() == false) goto L68;
    L32:
        if (((Boolean) this.F2.getValue()).booleanValue() == false) goto L50;
        if (canRead() == false) goto L50;
        if (getContext() == null) goto L50;
        boolean r9 = this.H1;
        if (r9 == false) goto L40;
        int r16 = 2131901782;
    L42:
        if (r9 == false) goto L44;
        int r10 = 2131240343;
    L45:
        r4.add(new com.larus.bmhome.view.screenmenu.l0(2131899625, r16, null, null, null, null, null, null, null, false, false, null, Integer.valueOf(r10), null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4100, 127));
        String r11 = m39.a.a;
        if (Intrinsics.areEqual(this.l, "answer_manual_create") == false) goto L48;
        String r17 = "send_message_create";
    L49:
        JSONObject r18 = new JSONObject();
        na0(r18);
        m39.a.c("listen", "play", r17, r18);
        goto L50
    L48:
        r17 = this.l;
        goto L49
    L44:
        r10 = 2131242639;
        goto L45
    L40:
        r16 = 2131899625;
        goto L42
    L27:
        if (canCopy() == false) goto L30;
    L87:
        return;
    L86:
        return;
    }

    public final void ua0() {
        LarusLayoutDocDetailFragmentBinding r0 = this.g;
        if (r0 == null) goto L8;
        LottieAdapterView r1 = r0.p;
        if (r1 == null) goto L9;
        r1.cancelAnimation();
        com.larus.utils.e1.o(r1);
        return;
    L9:
        return;
    }

    public final void wa0() {
        if (this.H1 == false) goto L6;
        this.H1 = false;
        ((com.larus.bmhome.chat.model.repo.x1) this.S1.getValue()).i6("enter_doc_edit_mode", false);
        return;
    }

    public void xa0() {
        Aa0(this.m);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.doc.impl.DocFragment$offlineDocCreateHostAbility$1] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.larus.doc.impl.q0] */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.larus.doc.impl.s0] */
    public DocFragment() {
        this.f = "";
        this.m = 3;
        this.n = LazyKt.lazy(new y());
        this.x = "";
        this.L = true;
        this.N = -1;
        this.O = -1;
        this.P = "";
        this.Y = new DocFragment$offlineDocCreateHostAbility$1(this);
        this.S1 = LazyKt.lazy(new j0());
        this.b2 = DocMode.READ_ONLY;
        this.p2 = new q0(this);
        this.v2 = LazyKt.lazy(new r0(this));
        this.x2 = new c(this);
        this.y2 = new s0(this);
        this.E2 = LazyKt.lazy(new t0());
        this.F2 = LazyKt.lazy(new u0());
        this.G2 = LazyKt.lazy(new v0());
        this.I2 = new d(this);
    }

    @Override // g39.a
    public final String Y0() {
        Bundle r0 = getArguments();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getString("record_scene", null);
    }

    public final String ba0() {
        Context r0 = getContext();
        if (r0 == null) goto L6;
        String r1 = ContextCompat.getString(r0, 2131899627);
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public final void oa0() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new DocFragment$querySubConvLatestDocMsgId$1(this, null), 2, null);
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        Lazy r0 = bn9.c.a;
        b r1 = (b) this.v2.getValue();
        Intrinsics.checkNotNullParameter(r1, "adder");
        Iterator r2 = bn9.c.a.a().iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if (Intrinsics.areEqual(((WeakReference) r3).get(), r1) == false) goto L4;
    L9:
        WeakReference r4 = (WeakReference) r3;
        if (r4 == null) goto L12;
        Lazy r5 = bn9.c.a;
        bn9.c.a.a().remove(r4);
    L12:
        this.q = null;
        return;
    L8:
        r3 = null;
        goto L9
    }

    @Override // g39.a
    public final String r1() {
        Bundle r0 = getArguments();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getString("feishu_record_generated_type", null);
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [com.larus.doc.impl.DocFragment$initTitleBarService$1] */
    /* JADX WARN: Type inference failed for: r0v17, types: [com.larus.doc.impl.DocFragment$initLoadingService$1] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.larus.doc.impl.DocFragment$initLoadingDocStateService$1] */
    /* JADX WARN: Type inference failed for: r0v32, types: [com.larus.doc.impl.DocFragment$initDocModeService$1] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.doc.impl.DocFragment$initOperationService$1] */
    public void sa0() {
        this.g2 = System.currentTimeMillis();
        this.R = new DocFragment$initChatService$1(this);
        IDocSdkBaseService r0 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);
        if (r0 == null) goto L5;
        r0.addChatService(this.R);
    L5:
        this.T = new DocFragment$initOperationService$1(this);
        IDocSdkBaseService r1 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);
        if (r1 == null) goto L8;
        r1.addOperationService(this.T);
    L8:
        this.V = new DocFragment$initTitleBarService$1(this);
        IDocSdkBaseService r2 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);
        if (r2 == null) goto L11;
        r2.addTitleBarService(this.V);
    L11:
        LarusLayoutDocDetailFragmentBinding r3 = this.g;
        if (r3 == null) goto L16;
        ImageView r4 = r3.i;
        if (r4 == null) goto L16;
        com.larus.utils.e1.d(r4, new j(this));
    L16:
        this.U = new DocFragment$initLoadingService$1(this);
        IDocSdkBaseService r5 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);
        if (r5 == null) goto L19;
        r5.addLoadingService(this.U);
    L19:
        this.M1 = new x0(this);
        IDocSdkBaseService r6 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);
        if (r6 == null) goto L22;
        r6.setHostAbilityProvider(this.M1);
    L22:
        this.W = new DocFragment$initLoadingDocStateService$1(this);
        IDocSdkBaseService r7 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);
        if (r7 == null) goto L25;
        r7.addLoadingDocStateService(this.W);
    L25:
        this.S = new DocFragment$initDocModeService$1(this);
        IDocSdkBaseService r8 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);
        if (r8 == null) goto L29;
        r8.addDocModeService(this.S);
        return;
    }

    @Override // g39.a
    public final String w0() {
        Bundle r0 = getArguments();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getString("feishu_record_id", null);
    }

    public final void Aa0(int r3) {
        com.larus.doc.impl.offline.c r0 = this.X;
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.wL() != true) goto L7;
    L8:
        if (r1 == false) goto L11;
        FLogger.a.i("DocFragment", "[updateDocBrief] skip after compensate create with realToken and useMessageContent=false");
        return;
    L11:
        DocOpManager r2 = DocOpManager.a;
        DocOpManager.l(this.f, this.k, r3);
        return;
    L7:
        r1 = false;
        goto L8
    }

    public final void Ba0(boolean r4) {
        FLogger.a.i("DocFragment", "updateInputVisibility tryShow: " + r4);
        if (canRead() == false) goto L17;
        if (r4 == false) goto L17;
        if (this.b2 != DocMode.NORMAL_EDIT) goto L9;
    L13:
        ViewGroup r5 = this.t;
        if (r5 == null) goto L23;
        com.larus.utils.e1.o(r5);
        return;
    L23:
        return;
    L9:
        if (this.J2 == true) goto L13;
        ViewGroup r6 = this.t;
        if (r6 == null) goto L21;
        com.larus.utils.e1.x(r6);
        return;
    L21:
        return;
    L17:
        ViewGroup r7 = this.t;
        if (r7 == null) goto L24;
        com.larus.utils.e1.o(r7);
        return;
    }

    @Override // g39.a
    public final void aT(DocArtifactInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "artifact");
    }

    public void ha0(Context r11) {
        Intrinsics.checkNotNullParameter(r11, "it");
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("DocFragment, initDocDetailFragment，hasReportFinishEvent=");
        Bundle r2 = getArguments();
        if (r2 == null) goto L5;
        Boolean r3 = Boolean.valueOf(r2.getBoolean("has_report_finish_event"));
    L6:
        r1.append(r3);
        r0.i("[DocTracer]", r1.toString());
        AppHost.Companion r4 = AppHost.a;
        if (r4.isDebug() == false) goto L9;
    L12:
        t19.s.j(t19.s.a, r11, "豆包文档", null, false, 28);
    L13:
        SoftReference r12 = com.larus.utils.y.a;
        Runnable r13 = new com.larus.doc.impl.c(this);
        Intrinsics.checkNotNullParameter(r13, "action");
        com.larus.utils.y.d(r13, 1000);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new DocFragment$refreshDocPermission$1(this, null), 2, null);
        return;
    L9:
        if (r4.isDebugChannel() == true) goto L12;
        if (r4.isTestChannel() == false) goto L13;
    L5:
        r3 = null;
        goto L6
    }

    public final void ja0(String r8) {
        if (isAdded() == true) goto L5;
    L9:
        FLogger.a.e("DocFragment", "mobTtsEnd failed. isAdded=" + isAdded() + " activity=" + getActivity());
        return;
    L5:
        if (getActivity() == null) goto L9;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), Dispatchers.getIO(), null, new DocFragment$mobTtsEnd$1(this, r8, null), 2, null);
    }

    public final void na0(JSONObject r6) {
        Bundle r0 = getArguments();
        Object r1 = null;
        if (r0 == null) goto L5;
        Object r2 = r0.getString("feishu_record_id", null);
    L6:
        r6.put("feishu_record_id", r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L9;
        Object r4 = r3.getString("feishu_record_generated_type", null);
    L10:
        r6.put("feishu_record_generated_type", r4);
        Bundle r5 = getArguments();
        if (r5 == null) goto L13;
        Object r7 = r5.getString("record_scene", null);
    L14:
        r6.put("record_scene", r7);
        Bundle r8 = getArguments();
        if (r8 == null) goto L17;
        String r9 = r8.getString("is_general_agent", null);
    L19:
        if (r9 != null) goto L21;
    L24:
        boolean r10 = true;
    L26:
        if ((true ^ r10) == true) goto L29;
        r9 = null;
    L29:
        if (r9 != null) goto L31;
        r9 = "0";
    L31:
        r6.put("is_general_agent", r9);
        Bundle r11 = getArguments();
        if (r11 == null) goto L34;
        r1 = r11.getString("chat_id", null);
    L34:
        if (r1 != null) goto L36;
        r1 = "";
    L36:
        r6.put("chat_id", r1);
        return;
    L21:
        if (r9.length() == 0) goto L24;
        r10 = false;
        goto L26
    L17:
        r9 = null;
        goto L19
    L13:
        r7 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        W90();
    }

    public final void onTitleStateReset(final boolean r2) {
        if (this.K2 == false) goto L6;
        com.larus.utils.t0.e(new f(this, r2));
        return;
    }

    public final void qa0(int r3) {
        int r0 = this.J;
        this.J = r3;
        if (r0 == 0) goto L5;
    L7:
        if (r0 == 0) goto L12;
        if (r3 != 0) goto L13;
        pa0(false, "loadingTextState_to_default");
        return;
    L13:
        return;
    L12:
        return;
    L5:
        if (r3 != 1) goto L7;
        pa0(true, "loadingTextState_default_to_thinking");
    }

    @Override // g39.a
    public final void u2(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
    }

    public final void va0(boolean r4) {
        if (r4 == false) goto L5;
        String r5 = "doc_ai_edit";
    L8:
        Fragment r0 = this.h;
        boolean r1 = false;
        if (r0 != null) goto L11;
    L13:
        if (r1 == false) goto L22;
        Fragment r2 = this.h;
        if (r2 == null) goto L22;
        t1a.b r3 = s1a.a.g(r2);
        if (r3 == null) goto L22;
        va8.r r6 = r3.getAbility(va8.r.class);
        if (r6 == null) goto L22;
        r6.JD(r5);
    L22:
        if (isAdded() == false) goto L27;
        j39.a r7 = (j39.a) s1a.a.g(this).getAbility(j39.a.class);
        if (r7 == null) goto L28;
        r7.a5(r5);
        return;
    L28:
        return;
    L27:
        return;
    L11:
        if (r0.isAdded() != true) goto L13;
        r1 = true;
        goto L13
    L5:
        if (this.M == false) goto L7;
        r5 = "doc_create_empty";
        goto L8
    L7:
        r5 = "doc_exist_content";
        goto L8
    }

    public final void ia0(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "buttonName");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new DocFragment$mobCopyEditAndExportClick$1(this, r8, r9, null), 2, null);
    }

    public void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r9, r10);
        AudioStreamPlayerDelegate.b.i(this.I2);
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L170
        Bundle r12 = getArguments();     // Catch: Throwable -> L170
        String r13 = "";
        if (r12 == null) goto L8;
        String r14 = r12.getString("key_doc_id");     // Catch: Throwable -> L170
        if (r14 == null) goto L8;
    L9:
        this.f = r14;     // Catch: Throwable -> L170
        Bundle r15 = getArguments();     // Catch: Throwable -> L170
        Unit r1 = null;
        if (r15 == null) goto L15;
        String r16 = r15.getString("offline_create_attempt_id");     // Catch: Throwable -> L170
        if (r16 == null) goto L15;
    L25:
        this.H = r16;     // Catch: Throwable -> L170
        Bundle r17 = getArguments();     // Catch: Throwable -> L170
        if (r17 == null) goto L29;
        String r18 = r17.getString("argConversationId", null);     // Catch: Throwable -> L170
        if (r18 == null) goto L29;
    L30:
        this.x = r18;     // Catch: Throwable -> L170
        Bundle r20 = getArguments();     // Catch: Throwable -> L170
        if (r20 == null) goto L34;
        String r21 = r20.getString("create_doc_by_msg_conv_id", null);     // Catch: Throwable -> L170
        if (r21 == null) goto L34;
    L35:
        this.P = r21;     // Catch: Throwable -> L170
        Bundle r22 = getArguments();     // Catch: Throwable -> L170
        if (r22 == null) goto L39;
        String r23 = r22.getString("is_general_agent", null);     // Catch: Throwable -> L170
        if (r23 == null) goto L39;
    L40:
        this.D = r23;     // Catch: Throwable -> L170
        Bundle r24 = getArguments();     // Catch: Throwable -> L170
        if (r24 == null) goto L46;
        String r25 = r24.getString("chat_id", null);     // Catch: Throwable -> L170
        if (r25 == null) goto L46;
        r13 = r25;
    L46:
        this.E = r13;     // Catch: Throwable -> L170
        Bundle r26 = getArguments();     // Catch: Throwable -> L170
        int r110 = 0;
        if (r26 == null) goto L49;
        int r27 = r26.getInt("resource_type", 0);     // Catch: Throwable -> L170
    L50:
        this.m = r27;     // Catch: Throwable -> L170
        if (r27 == 0) goto L53;
    L57:
        Bundle r28 = getArguments();     // Catch: Throwable -> L170
        if (r28 == null) goto L60;
        String r30 = r28.getString("artifact_meta_id", null);     // Catch: Throwable -> L170
    L61:
        this.j = r30;     // Catch: Throwable -> L170
        Bundle r31 = getArguments();     // Catch: Throwable -> L170
        int r0 = -1;
        if (r31 == null) goto L64;
        r0 = r31.getInt("resource_version", -1);     // Catch: Throwable -> L170
    L64:
        this.O = r0;     // Catch: Throwable -> L170
        Bundle r32 = getArguments();     // Catch: Throwable -> L170
        if (r32 == null) goto L67;
        String r33 = r32.getString("key_artifact_version_id", null);     // Catch: Throwable -> L170
    L68:
        this.k = r33;     // Catch: Throwable -> L170
        Bundle r34 = getArguments();     // Catch: Throwable -> L170
        if (r34 == null) goto L71;
        String r35 = r34.getString("key_doc_enter_from", null);     // Catch: Throwable -> L170
    L72:
        this.l = r35;     // Catch: Throwable -> L170
        Bundle r36 = getArguments();     // Catch: Throwable -> L170
        if (r36 == null) goto L75;
        String r37 = r36.getString("key_click_previous_page", null);     // Catch: Throwable -> L170
    L76:
        this.y1 = r37;     // Catch: Throwable -> L170
        Bundle r38 = getArguments();     // Catch: Throwable -> L170
        String r2 = "other";
        if (r38 == null) goto L83;
        String r40 = r38.getString("argPreviousPage", "other");     // Catch: Throwable -> L170
        if (r40 == null) goto L83;
        r2 = r40;
    L83:
        this.x1 = r2;     // Catch: Throwable -> L170
        Bundle r41 = getArguments();     // Catch: Throwable -> L170
        if (r41 == null) goto L86;
        String r42 = r41.getString("doc_title");     // Catch: Throwable -> L170
    L87:
        this.C = r42;     // Catch: Throwable -> L170
        Bundle r43 = getArguments();     // Catch: Throwable -> L170
        if (r43 == null) goto L90;
        ArrayList<DocMeta> r44 = com.larus.office.base.preview.a.a(r43, "key_doc_list_to_apply_permission");     // Catch: Throwable -> L170
    L91:
        this.y = r44;     // Catch: Throwable -> L170
        Bundle r45 = getArguments();     // Catch: Throwable -> L170
        if (r45 == null) goto L94;
        String r46 = r45.getString("key_apply_permission_conversation_id");     // Catch: Throwable -> L170
    L95:
        this.z = r46;     // Catch: Throwable -> L170
        Bundle r47 = getArguments();     // Catch: Throwable -> L170
        if (r47 == null) goto L98;
        String r48 = r47.getString("key_apply_permission_message_id");     // Catch: Throwable -> L170
    L99:
        this.A = r48;     // Catch: Throwable -> L170
        Bundle r50 = getArguments();     // Catch: Throwable -> L170
        boolean r3 = true;
        if (r50 != null) goto L102;
    L104:
        boolean r51 = false;
    L105:
        this.B = r51;     // Catch: Throwable -> L170
        String r52 = m39.a.a;     // Catch: Throwable -> L170
        String r53 = this.f;     // Catch: Throwable -> L170
        String r4 = this.j;     // Catch: Throwable -> L170
        Integer r5 = Integer.valueOf(ga0());     // Catch: Throwable -> L170
        String r6 = this.l;     // Catch: Throwable -> L170
        m39.a.a = r53;     // Catch: Throwable -> L170
        m39.a.b = r4;     // Catch: Throwable -> L170
        m39.a.c = r5;     // Catch: Throwable -> L170
        m39.a.e = r6;     // Catch: Throwable -> L170
        Lazy r54 = bn9.c.a;     // Catch: Throwable -> L170
        b r55 = (b) this.v2.getValue();     // Catch: Throwable -> L170
        Intrinsics.checkNotNullParameter(r55, "adder");     // Catch: Throwable -> L170
        Iterator r7 = bn9.c.a.a().iterator();     // Catch: Throwable -> L170
    L107:
        if (r7.hasNext() == false) goto L111;
        Object r8 = r7.next();     // Catch: Throwable -> L170
        if (Intrinsics.areEqual(((WeakReference) r8).get(), r55) == false) goto L107;
    L112:
        if (r8 != null) goto L114;
        bn9.c.a.a().add(new WeakReference(r55));     // Catch: Throwable -> L170
    L114:
        sa0();     // Catch: Throwable -> L170
        if (this.f.length() == 0) goto L118;
        r3 = false;
    L118:
        if (r3 == false) goto L122;
        FLogger.a.i("DocActivity", "Invalid docId: " + this.f);     // Catch: Throwable -> L170
        requireActivity().finish();     // Catch: Throwable -> L170
        return;
    L122:
        if (Intrinsics.areEqual(this.f, "fake_doc_id") == false) goto L129;
        LarusLayoutDocDetailFragmentBinding r56 = this.g;     // Catch: Throwable -> L170
        if (r56 == null) goto L128;
        DocLoadAndErrorLayout r57 = r56.d;     // Catch: Throwable -> L170
        if (r57 == null) goto L128;
        r57.setVisibility(0);     // Catch: Throwable -> L170
    L128:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new DocFragment$onViewCreated$1$2(this, null), 2, null);     // Catch: Throwable -> L170
    L132:
        s1a.a.g(this).c(this, g39.a.class);     // Catch: Throwable -> L170
        k1a.b.a(this, new l(this));     // Catch: Throwable -> L170
        LarusLayoutDocDetailFragmentBinding r58 = this.g;     // Catch: Throwable -> L170
        if (r58 == null) goto L137;
        View r60 = r58.v;     // Catch: Throwable -> L170
        if (r60 == null) goto L137;
        r60.setOnTouchListener(new h(this));     // Catch: Throwable -> L170
    L137:
        LarusLayoutDocDetailFragmentBinding r61 = this.g;     // Catch: Throwable -> L170
        if (r61 == null) goto L140;
        View r62 = r61.b;     // Catch: Throwable -> L170
    L141:
        this.v = r62;     // Catch: Throwable -> L170
        if (r62 == null) goto L144;
        r62.setOnClickListener(new p(this));     // Catch: Throwable -> L170
    L144:
        LarusLayoutDocDetailFragmentBinding r63 = this.g;     // Catch: Throwable -> L170
        if (r63 == null) goto L147;
        InterceptTouchFrameLayout r64 = r63.c;     // Catch: Throwable -> L170
    L148:
        this.t = r64;     // Catch: Throwable -> L170
        if (r63 == null) goto L163;
        FrameLayout r65 = r63.u;     // Catch: Throwable -> L170
        if (r65 == null) goto L163;
        ViewGroup.LayoutParams r66 = r65.getLayoutParams();     // Catch: Throwable -> L170
        if ((r66 instanceof ConstraintLayout.LayoutParams) == false) goto L155;
        ConstraintLayout.LayoutParams r67 = (ConstraintLayout.LayoutParams) r66;     // Catch: Throwable -> L170
    L156:
        if (r67 == null) goto L161;
        FragmentActivity r68 = getActivity();     // Catch: Throwable -> L170
        if (r68 == null) goto L160;
        r110 = com.larus.utils.u.c(r68);     // Catch: Throwable -> L170
    L160:
        ((ViewGroup.MarginLayoutParams) r67).topMargin = r110;     // Catch: Throwable -> L170
    L162:
        r65.setLayoutParams(r67);     // Catch: Throwable -> L170
        goto L163
    L161:
        r67 = null;
        goto L162
    L155:
        r67 = null;
    L163:
        LarusLayoutDocDetailFragmentBinding r70 = this.g;     // Catch: Throwable -> L170
        if (r70 == null) goto L168;
        LinearLayout r71 = r70.g;     // Catch: Throwable -> L170
        if (r71 == null) goto L168;
        com.larus.utils.e1.d(r71, new com.larus.doc.impl.d(this));     // Catch: Throwable -> L170
        r1 = Unit.INSTANCE;     // Catch: Throwable -> L170
    L168:
        Result.constructor-impl(r1);     // Catch: Throwable -> L170
    L172:
        int r72 = m39.b.a;
        m39.b.a("文档页面已创建");
        return;
    L147:
        r64 = null;
        goto L148
    L140:
        r62 = null;
        goto L141
    L129:
        Context r73 = getContext();     // Catch: Throwable -> L170
        if (r73 == null) goto L132;
        ha0(r73);     // Catch: Throwable -> L170
        goto L132
    L111:
        r8 = null;
        goto L112
    L102:
        if (r50.getBoolean("key_is_new_audio_record", false) != true) goto L104;
        r51 = true;
        goto L105
    L98:
        r48 = null;
        goto L99
    L94:
        r46 = null;
        goto L95
    L90:
        r44 = null;
        goto L91
    L86:
        r42 = null;
        goto L87
    L75:
        r37 = null;
        goto L76
    L71:
        r35 = null;
        goto L72
    L67:
        r33 = null;
        goto L68
    L60:
        r30 = null;
        goto L61
    L53:
        if (z2.a.getDocFusionConfig().a == false) goto L55;
        int r74 = 10;
    L56:
        this.m = r74;     // Catch: Throwable -> L170
        goto L57
    L55:
        r74 = 3;
        goto L56
    L49:
        r27 = 0;
    L39:
        r23 = "";
    L34:
        r21 = "";
    L29:
        r18 = "";
    L15:
        if (Intrinsics.areEqual(this.f, "fake_offline_doc_id") == false) goto L24;
        OfflineDocReportGate.a.getClass();     // Catch: Throwable -> L170
        r16 = OfflineDocReportGate.e();     // Catch: Throwable -> L170
        Bundle r75 = getArguments();     // Catch: Throwable -> L170
        if (r75 == null) goto L19;
        r75.putString("offline_create_attempt_id", r16);     // Catch: Throwable -> L170
    L19:
        FragmentActivity r76 = getActivity();     // Catch: Throwable -> L170
        if (r76 == null) goto L25;
        Intent r77 = r76.getIntent();     // Catch: Throwable -> L170
        if (r77 == null) goto L25;
        r77.putExtra("offline_create_attempt_id", r16);     // Catch: Throwable -> L170
        goto L25
    L24:
        r16 = null;
    L8:
        r14 = "";
    L170:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L172
    }

    public final void pa0(boolean r4, String r5) {
        if (this.K != r4) goto L5;
        return;
    L5:
        this.K = r4;
        FLogger.a.i("DocFragment", "setAiAnswerInFlight inFlight=" + r4 + " reason=" + r5);
        final int r6 = r4 ? 1 : 0;
        com.larus.utils.t0.e(new i(r6, this));
    }

    public void ya0(boolean r4, boolean r5) {
        FLogger.a.i("DocFragment", "updateDocOpBarVisibility, tryShow = " + r4 + ", needAdjustPanelHeight = " + r5);
        if (r4 == true) goto L9;
        View r6 = this.q;
        if (r6 == null) goto L56;
        com.larus.utils.e1.o(r6);
        return;
    L56:
        return;
    L9:
        if (canEdit() == false) goto L11;
    L18:
        TextLoadingView r7 = this.u;
        boolean r0 = false;
        if (r7 != null) goto L21;
    L23:
        boolean r8 = false;
    L24:
        if (r8 == false) goto L26;
    L47:
        View r9 = this.q;
        if (r9 != null) goto L50;
    L52:
        this.r = !r0;
        View r10 = this.q;
        if (r10 == null) goto L60;
        com.larus.utils.e1.o(r10);
        return;
    L60:
        return;
    L50:
        if (r9.getVisibility() != 8) goto L52;
        r0 = true;
        goto L52
    L26:
        if (this.Q == true) goto L47;
        if (this.T1 == true) goto L47;
        if (this.P1 == true) goto L47;
        if (this.Q1 == true) goto L47;
        if (this.b2 != DocMode.READ_ONLY) goto L47;
        if (this.V1 == true) goto L47;
        if (this.J2 == true) goto L47;
        View r11 = this.q;
        if (r11 != null) goto L42;
    L44:
        this.r = !r0;
        View r12 = this.q;
        if (r12 == null) goto L58;
        com.larus.utils.e1.x(r12);
        return;
    L58:
        return;
    L42:
        if (r11.getVisibility() != 0) goto L44;
        r0 = true;
        goto L44
    L21:
        if (r7.getVisibility() != 0) goto L23;
        r8 = true;
        goto L24
    L11:
        if (canCopy() == true) goto L13;
    L14:
        View r13 = this.q;
        if (r13 == null) goto L57;
        com.larus.utils.e1.o(r13);
        return;
    L57:
        return;
    L13:
        if (da0() != 1) goto L18;
        goto L14
    }

    public static final void V90(DocFragment r11, boolean r12, boolean r13) {
        String r4 = r11.f;
        String r5 = r11.j;
        int r0 = r11.ga0();
        if (r12 == false) goto L5;
        String r14 = "1";
    L6:
        String r1 = r14;
        if (r13 == false) goto L9;
        String r15 = "auth_manage_public";
    L10:
        JSONObject r8 = new JSONObject();
        r11.na0(r8);
        tx9.u0.f("upper_right", r1, null, r15, r4, r5, Integer.valueOf(r0), null, r8, r11, 132);
        return;
    L9:
        r15 = "auth_manage_private";
        goto L10
    L5:
        r14 = "0";
        goto L6
    }

    public static /* synthetic */ void za0(DocFragment r2, boolean r3, int r4) {
        boolean r1 = true;
        if ((r4 & 1) == 0) goto L6;
        r3 = true;
    L6:
        if ((r4 & 2) != 0) goto L9;
        r1 = false;
    L9:
        r2.ya0(r3, r1);
    }

    public final View onCreateView(LayoutInflater r27, ViewGroup r28, Bundle r210) {
        Intrinsics.checkNotNullParameter(r27, "inflater");
        ConstraintLayout r0 = r27.inflate(2131562803, r28, false);
        int r1 = 2131365538;
        View r4 = ViewBindings.findChildViewById(r0, 2131365538);
        if (r4 == null) goto L55;
        r1 = 2131369292;
        InterceptTouchFrameLayout r5 = (InterceptTouchFrameLayout) ViewBindings.findChildViewById(r0, 2131369292);
        if (r5 == null) goto L55;
        r1 = 2131369315;
        if (((InterceptTouchFrameLayout) ViewBindings.findChildViewById(r0, 2131369315)) == null) goto L55;
        r1 = 2131369331;
        DocLoadAndErrorLayout r6 = ViewBindings.findChildViewById(r0, 2131369331);
        if (r6 == null) goto L55;
        r1 = 2131369341;
        FrameLayout r7 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131369341);
        if (r7 == null) goto L55;
        r1 = 2131369344;
        ViewStub r8 = (ViewStub) ViewBindings.findChildViewById(r0, 2131369344);
        if (r8 == null) goto L55;
        r1 = 2131369362;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131369362);
        if (r9 == null) goto L55;
        r1 = 2131369363;
        ConstraintLayout r10 = ViewBindings.findChildViewById(r0, 2131369363);
        if (r10 == null) goto L55;
        r1 = 2131369364;
        ImageView r11 = (ImageView) ViewBindings.findChildViewById(r0, 2131369364);
        if (r11 == null) goto L55;
        r1 = 2131369365;
        ImageView r12 = (ImageView) ViewBindings.findChildViewById(r0, 2131369365);
        if (r12 == null) goto L55;
        r1 = 2131369366;
        ImageView r13 = (ImageView) ViewBindings.findChildViewById(r0, 2131369366);
        if (r13 == null) goto L55;
        r1 = 2131369367;
        if (((ImageView) ViewBindings.findChildViewById(r0, 2131369367)) == null) goto L55;
        r1 = 2131369368;
        ImageView r14 = (ImageView) ViewBindings.findChildViewById(r0, 2131369368);
        if (r14 == null) goto L55;
        r1 = 2131369369;
        FrameLayout r15 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131369369);
        if (r15 == null) goto L55;
        r1 = 2131369370;
        ImageView r16 = (ImageView) ViewBindings.findChildViewById(r0, 2131369370);
        if (r16 == null) goto L55;
        r1 = 2131369371;
        ImageView r17 = (ImageView) ViewBindings.findChildViewById(r0, 2131369371);
        if (r17 == null) goto L55;
        r1 = 2131369372;
        LottieAdapterView r18 = ViewBindings.findChildViewById(r0, 2131369372);
        if (r18 == null) goto L55;
        r1 = 2131369373;
        TextView r110 = (TextView) ViewBindings.findChildViewById(r0, 2131369373);
        if (r110 == null) goto L55;
        r1 = 2131369374;
        ShimmerTextView r20 = ViewBindings.findChildViewById(r0, 2131369374);
        if (r20 == null) goto L55;
        r1 = 2131369375;
        ImageView r21 = (ImageView) ViewBindings.findChildViewById(r0, 2131369375);
        if (r21 == null) goto L55;
        r1 = 2131369385;
        FrameLayout r22 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131369385);
        if (r22 == null) goto L55;
        r1 = 2131369386;
        FrameLayout r23 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131369386);
        if (r23 == null) goto L55;
        r1 = 2131369387;
        if (ViewBindings.findChildViewById(r0, 2131369387) == null) goto L55;
        r1 = 2131373339;
        View r24 = ViewBindings.findChildViewById(r0, 2131373339);
        if (r24 == null) goto L55;
        r1 = 2131379082;
        TextLoadingView r25 = ViewBindings.findChildViewById(r0, 2131379082);
        if (r25 == null) goto L55;
        ConstraintLayout r2 = r0;
        this.g = new LarusLayoutDocDetailFragmentBinding(r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r110, r20, r21, r22, r23, r24, r25);
        return r2;
    L55:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }

    /* JADX WARN: Type inference failed for: r15v1, types: [com.larus.doc.impl.operation.k] */
    /* JADX WARN: Type inference failed for: r32v7, types: [com.larus.doc.impl.operation.j] */
    /* JADX WARN: Type inference failed for: r9v1, types: [com.larus.doc.impl.g0] */
    public static Unit U90(final DocFragment r184, Context r185, ConstraintLayout r186, ot8.a r187) {
        Intrinsics.checkNotNullParameter(r187, "item");
        int r14 = r187.getId();
        if (r14 != 2131899603) goto L164;
        Fragment r1 = r184.h;
        if (r1 == null) goto L9;
        View r2 = r1.getView();
        if (r2 == null) goto L9;
        Integer r11 = Integer.valueOf(r2.getHeight());
    L10:
        DocOpManager r3 = DocOpManager.a;
        final Context r4 = r184.getActivity();
        final String r12 = r184.f;
        final int r13 = r184.O;
        String r10 = r184.C;
        if (r10 != null) goto L13;
        r10 = "";
    L13:
        final String r6 = r184.j;
        final e1 r7 = new e1(r184);
        String r52 = r184.ea0();
        final Boolean r9 = Boolean.valueOf(r184.B);
        Pair[] r8 = new Pair[11];
        String r92 = "copy_doc";
        r8[0] = TuplesKt.to("resource_type", Integer.valueOf(r184.m));
        String r15 = r184.C;
        if (r15 != null) goto L16;
        r15 = r184.ba0();
    L16:
        r8[1] = TuplesKt.to("doc_title", r15);
        r8[2] = TuplesKt.to("key_doc_logic_key", r184.Y90());
        if (r184.isOwner() == true) goto L19;
    L21:
        boolean r16 = false;
    L22:
        r8[3] = TuplesKt.to("key_review_failed", Boolean.valueOf(r16));
        r8[4] = TuplesKt.to("key_is_doc_owner", Boolean.valueOf(r184.isOwner()));
        r8[5] = TuplesKt.to("canvas_type", "writing");
        Bundle r17 = r184.getArguments();
        if (r17 == null) goto L26;
        String r18 = r17.getString("feishu_record_id");
        if (r18 == null) goto L26;
    L27:
        r8[6] = TuplesKt.to("feishu_record_id", r18);
        Bundle r110 = r184.getArguments();
        final Integer r95 = r11;
        if (r110 == null) goto L31;
        String r111 = r110.getString("feishu_record_generated_type");
        if (r111 == null) goto L31;
    L32:
        r8[7] = TuplesKt.to("feishu_record_generated_type", r111);
        Bundle r112 = r184.getArguments();
        if (r112 == null) goto L36;
        String r113 = r112.getString("record_scene");
        if (r113 == null) goto L36;
    L37:
        r8[8] = TuplesKt.to("record_scene", r113);
        String r114 = r184.D;
        if (r114 != null) goto L40;
    L43:
        boolean r21 = true;
    L45:
        if ((!r21) == true) goto L48;
        r114 = null;
    L48:
        if (r114 != null) goto L50;
        r114 = "0";
    L50:
        r8[9] = TuplesKt.to("is_general_agent", r114);
        String r115 = r184.E;
        if (r115 != null) goto L53;
        r115 = "";
    L53:
        r8[10] = TuplesKt.to("chat_id", r115);
        final Map r20 = MapsKt.mapOf(r8);
        Object r116 = o39.a.b;
        monitor-enter(r116);
        final MinutesInfoModel r97 = o39.a.a;     // Catch: Throwable -> L160
        monitor-exit(r116);
        Intrinsics.checkNotNullParameter(r12, "resourceId");
        Intrinsics.checkNotNullParameter(r10, "title");
        Intrinsics.checkNotNullParameter("upper_right", "showFrom");
        if (r4 == null) goto L159;
        FLogger.a.i("DocOpManager", "[showSharePanel] resourceId:" + r12);
        if (r12.length() != 0) goto L63;
        boolean r5 = true;
    L64:
        if (r5 == false) goto L66;
        t19.s r0 = t19.s.a;
        String r22 = AppHost.a.getApplication().getString(2131909350);
        r0.getClass();
        t19.s.t(r4, r22);
        goto L159
    L66:
        if (r20 == null) goto L68;
        Object r23 = r20.get("key_review_failed");
    L70:
        if ((r23 instanceof Boolean) == false) goto L72;
        Boolean r24 = (Boolean) r23;
    L73:
        if (r24 == null) goto L75;
        boolean r117 = r24.booleanValue();
    L76:
        IFlowOfficeThemeConfigProvider r25 = (IFlowOfficeThemeConfigProvider) ServiceManager.get().getService(IFlowOfficeThemeConfigProvider.class);
        if (r25 != null) goto L79;
    L81:
        boolean r26 = false;
    L82:
        if (r117 == false) goto L84;
        String r27 = AppHost.a.getApplication().getString(2131901794);
    L87:
        String r118 = r27;
    L88:
        if (r20 == null) goto L90;
        Object r28 = r20.get("resource_type");
    L92:
        if ((r28 instanceof Integer) == false) goto L94;
        Integer r30 = (Integer) r28;
    L95:
        if (r30 == null) goto L97;
        int r31 = r30.intValue();
    L98:
        int r32 = com.larus.office.base.utils.o.a;
        Integer r33 = com.larus.office.base.utils.o.b(Integer.valueOf(r31), 10);
        if (r33 == null) goto L101;
        r31 = r33.intValue();
    L101:
        final int r98 = r31;
        if (r117 == false) goto L104;
        TextUtils.TruncateAt r210 = TextUtils.TruncateAt.END;
        String r34 = r118;
        com.larus.bmhome.share.panel.n r211 = new com.larus.bmhome.share.panel.n(2131240342, AppHost.a.getApplication().getString(2131901774), new com.larus.doc.impl.operation.j(r4, r12, r6, r98, r184), 2131240319, r34, Integer.valueOf((int) UIUtils.dip2Px(r4, 16.0f)), Float.valueOf(14.0f), Boolean.TRUE, Integer.valueOf((int) UIUtils.dip2Px(r4, 12.0f)), Integer.valueOf((int) UIUtils.dip2Px(r4, 11.0f)), 128);
        Context r35 = r4;
        com.larus.bmhome.share.panel.i r119 = new com.larus.bmhome.share.panel.i(r10, r211, 12, 16, Integer.valueOf((int) UIUtils.dip2Px(r35, 20.0f)), 1, r210, 128);
    L105:
        if (r117 == false) goto L108;
        tx9.u0.i(false, r12, r6, Integer.valueOf(r98), "ai_doc_detail", r184);
    L108:
        ShareServiceDelegate r910 = ShareServiceDelegate.b;
        if (Intrinsics.areEqual("upper_right", "long_press") == false) goto L111;
        ShareScene r36 = ShareScene.MESSAGES_LINK;
    L112:
        com.larus.bmhome.share.panel.b r101 = new com.larus.bmhome.share.panel.b(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, false, false, null, false, null, null, 67108863);
        if (r20 == null) goto L115;
        Object r37 = r20.get("canvas_type");
    L117:
        if ((r37 instanceof String) == false) goto L119;
        String r71 = (String) r37;
    L120:
        if (r119 != null) goto L122;
        com.larus.bmhome.share.panel.i r77 = new com.larus.bmhome.share.panel.i(null, new com.larus.bmhome.share.panel.n(null, null, null, null, r118, null, null, null, null, null, 2031), null, null, null, null, null, 253);
    L123:
        if (r20 == null) goto L125;
        Object r38 = r20.get("feishu_record_id");
    L127:
        if ((r38 instanceof String) == false) goto L129;
        String r78 = (String) r38;
    L130:
        if (r20 == null) goto L132;
        Object r40 = r20.get("feishu_record_generated_type");
    L134:
        if ((r40 instanceof String) == false) goto L136;
        String r710 = (String) r40;
    L137:
        if (r20 == null) goto L139;
        Object r41 = r20.get("record_scene");
    L141:
        if ((r41 instanceof String) == false) goto L143;
        String r86 = (String) r41;
    L144:
        if (r20 == null) goto L146;
        Object r42 = r20.get("is_general_agent");
    L148:
        if ((r42 instanceof String) == false) goto L150;
        String r80 = (String) r42;
    L151:
        if (r20 == null) goto L153;
        Object r43 = r20.get("chat_id");
    L155:
        if ((r43 instanceof String) == false) goto L157;
        String r81 = (String) r43;
    L158:
        com.larus.bmhome.share.panel.h r120 = new com.larus.bmhome.share.panel.h(null, null, null, null, null, null, r52, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r12, r6, Integer.valueOf(r98), "ai_doc", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r71, null, null, null, null, null, r77, r78, r710, r80, r81, null, null, false, null, r86, null, null, -129, 1056964367, 888);
        final String r121 = r10;
        final FragmentActivity r122 = r35;
        IShareService.a.g(r910, r35, r36, r101, r120, new DocOpManager$showSharePanel$1(r20, r7, r95, r184, r9, r12, r13, r6, r97, r122, r121, r98), r184, false, 192);
        goto L159
    L157:
        r81 = null;
        goto L158
    L153:
        r43 = null;
        goto L155
    L150:
        r80 = null;
        goto L151
    L146:
        r42 = null;
        goto L148
    L143:
        r86 = null;
        goto L144
    L139:
        r41 = null;
        goto L141
    L136:
        r710 = null;
        goto L137
    L132:
        r40 = null;
        goto L134
    L129:
        r78 = null;
        goto L130
    L125:
        r38 = null;
        goto L127
    L122:
        r77 = r119;
        goto L123
    L119:
        r71 = null;
        goto L120
    L115:
        r37 = null;
        goto L117
    L111:
        r36 = ShareScene.DOCUMENT;
        goto L112
    L104:
        r35 = r4;
        r119 = null;
        goto L105
    L97:
        r31 = 3;
        goto L98
    L94:
        r30 = null;
        goto L95
    L90:
        r28 = null;
        goto L92
    L84:
        if (r26 == false) goto L86;
        r118 = null;
        goto L88
    L86:
        r27 = AppHost.a.getApplication().getString(2131899611);
        goto L87
    L79:
        if (r25.a(new com.larus.doc.impl.operation.i(), AdaptThemeFeatureKey.OFFICE_COPY_LINK_DIRECTLY) != true) goto L81;
        r26 = true;
        goto L82
    L75:
        r117 = false;
        goto L76
    L72:
        r24 = null;
        goto L73
    L68:
        r23 = null;
        goto L70
    L63:
        r5 = false;
    L159:
        Continuation r123 = null;
        final DocFragment r124 = r184;
        String r125 = "share";
        int r126 = r14;
    L349:
        if (r126 == 2131899592) goto L353;
        int r44 = 2131899528;
        if (r126 == 2131899528) goto L354;
    L357:
        com.larus.bmhome.view.screenmenu.d r45 = com.larus.bmhome.view.screenmenu.d.a;
        com.larus.bmhome.view.screenmenu.d.b(r186);
    L359:
        if (Intrinsics.areEqual(r125, r92) == true) goto L361;
        IDocSdkBaseService r46 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);
        if (r46 == null) goto L378;
        n39.o r47 = r46.getToolbarService();
        if (r47 == null) goto L378;
        if (r125 != null) goto L376;
        String r48 = "";
    L377:
        r47.notifyMoreAction(r48);
        goto L378
    L376:
        r48 = r125;
    L378:
        Function1<? super String, Unit> r50 = r124.o;
        if (r50 == null) goto L384;
        if (r125 != null) goto L382;
        String r51 = "";
    L383:
        r50.invoke(r51);
        goto L384
    L382:
        r51 = r125;
    L384:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r184), Dispatchers.getIO(), null, new DocFragment$showMoreMenu$1$commonMenu$1$1(r125, r124, r123), 2, null);
        return Unit.INSTANCE;
    L361:
        if (r124.B == true) goto L384;
        IDocSdkBaseService r53 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);
        if (r53 == null) goto L367;
        n39.o r54 = r53.getToolbarService();
        if (r54 == null) goto L367;
        r54.notifyMoreAction(r125);
    L367:
        Function1<? super String, Unit> r55 = r124.o;
        if (r55 == null) goto L384;
        r55.invoke(r125);
    L354:
        if (r126 != r44) goto L359;
        if (r124.B == true) goto L359;
    L353:
        r44 = 2131899528;
    L160:
        th = move-exception;
        throw th;
    L40:
        if (r114.length() == 0) goto L43;
        r21 = false;
    L36:
        r113 = "";
    L31:
        r111 = "";
    L26:
        r18 = "";
        goto L27
    L19:
        if (r184.p6() == true) goto L21;
        r16 = true;
    L9:
        r11 = null;
        goto L10
    L164:
        r92 = "copy_doc";
        r126 = r14;
        if (r126 != 2131899528) goto L186;
        r124 = r184;
        if (r124.B == false) goto L185;
        final CommonMenu r56 = r124.G1;
        if (r56 == null) goto L185;
        final CreateMenu r57 = r56.findViewById(2131392492);
        final Ref.BooleanRef r58 = new Ref.BooleanRef();
        List r60 = CollectionsKt.listOf(new com.larus.bmhome.view.screenmenu.l0[]{new com.larus.bmhome.view.screenmenu.l0(2131899598, 2131899598, null, null, null, null, null, 2131241206, null, false, false, null, 2131240381, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4228, 127), new com.larus.bmhome.view.screenmenu.l0(2131899971, 2131899971, null, null, null, null, null, null, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4, 127), new com.larus.bmhome.view.screenmenu.l0(2131899972, 2131899972, null, null, null, null, null, null, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4, 127)});
        CommonMenu r61 = new CommonMenu(r185);
        r61.d(i5.u());
        r61.g(r60, new l0(r58, r56, r57, r124));
        View r62 = r61.i();
        if (r57 == null) goto L174;
        r57.h(true, new m0(r124));
    L174:
        Balloon r63 = com.larus.bmhome.view.screenmenu.d.a(com.larus.bmhome.view.screenmenu.d.a, r56, r62, false, null, null, null, new n0(r58, r124), 56);
        ViewGroup.LayoutParams r64 = r62.getLayoutParams();
        if ((r64 instanceof ViewGroup.MarginLayoutParams) == false) goto L177;
        ViewGroup.MarginLayoutParams r65 = (ViewGroup.MarginLayoutParams) r64;
    L178:
        if (r65 == null) goto L182;
        r65.setMarginEnd((-i5.Q()) + i5.h());
    L182:
        if (com.larus.utils.i.h(r185) == false) goto L184;
        r63.x(r56, -r56.getMeasuredWidth(), ((-i5.Q()) - (i5.d0() * 7)) - i5.S());
        goto L185
    L184:
        r63.x(r56, r56.getMeasuredWidth(), ((-i5.Q()) - (i5.d0() * 7)) - i5.S());
        goto L185
    L177:
        r65 = null;
    L185:
        r125 = r92;
        r123 = null;
        goto L349
    L186:
        r124 = r184;
        if (r126 != 2131899561) goto L190;
        String r66 = "history";
        r123 = null;
    L277:
        r125 = r66;
        goto L349
    L190:
        if (r126 == 2131901780) goto L192;
        r123 = null;
        if (r126 != 2131899592) goto L252;
        final CommonMenu r67 = r124.G1;
        if (r67 == null) goto L250;
        final CreateMenu r68 = r67.findViewById(2131392492);
        final Ref.BooleanRef r70 = new Ref.BooleanRef();
        com.larus.bmhome.view.screenmenu.l0[] r72 = new com.larus.bmhome.view.screenmenu.l0[3];
        r72[0] = new com.larus.bmhome.view.screenmenu.l0(2131899592, 2131899592, null, null, null, null, null, 2131241216, null, false, false, null, 2131241206, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4228, 127);
        DocOpManager r73 = DocOpManager.a;
        String r74 = r124.f;
        Intrinsics.checkNotNullParameter(r74, "resourceId");
        HashMap<String, Boolean> r127 = DocOpManager.c;
        Boolean r75 = r127.get(r74);
        Boolean r128 = Boolean.TRUE;
        if (Intrinsics.areEqual(r75, r128) == false) goto L229;
        Integer r310 = 2131241215;
    L230:
        r72[1] = new com.larus.bmhome.view.screenmenu.l0(2131899588, 2131899588, null, null, null, null, null, r310, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -132, 127);
        String r76 = r124.f;
        Intrinsics.checkNotNullParameter(r76, "resourceId");
        if (Intrinsics.areEqual(r127.get(r76), r128) == false) goto L233;
        Integer r311 = null;
    L234:
        r72[2] = new com.larus.bmhome.view.screenmenu.l0(2131899590, 2131899590, null, null, null, null, null, r311, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -132, 127);
        View r82 = CreateMenu.f(new CreateMenu(r185), CollectionsKt.listOf(r72), 0, false, null, null, null, null, new h0(r70, r67, r68, r124), 510);
        CreateMenu r83 = ((ViewGroup) r82).findViewById(2131392492);
        if (r83 == null) goto L237;
        r83.getLayoutParams().width = r67.getMeasuredWidth() - i5.O();
    L237:
        if (r68 == null) goto L239;
        r68.h(true, new i0(r124));
    L239:
        Balloon r84 = com.larus.bmhome.view.screenmenu.d.a(com.larus.bmhome.view.screenmenu.d.a, r67, r82, false, null, null, null, new k0(r70, r124), 56);
        ViewGroup.LayoutParams r85 = r82.getLayoutParams();
        if ((r85 instanceof ViewGroup.MarginLayoutParams) == false) goto L242;
        ViewGroup.MarginLayoutParams r129 = (ViewGroup.MarginLayoutParams) r85;
    L243:
        if (r129 == null) goto L247;
        r129.setMarginEnd((-i5.Q()) + i5.h());
    L247:
        if (com.larus.utils.i.h(r185) == false) goto L249;
        r84.x(r67, -r67.getMeasuredWidth(), (((-i5.Q()) - i5.d0()) - i5.d0()) - i5.S());
        goto L250
    L249:
        r84.x(r67, r67.getMeasuredWidth(), (((-i5.Q()) - i5.d0()) - i5.d0()) - i5.S());
        goto L250
    L242:
        r129 = null;
        goto L243
    L233:
        r311 = 2131241215;
        goto L234
    L229:
        r310 = null;
    L250:
        r66 = "auth_manage";
        goto L277
    L252:
        if (r126 != 2131907413) goto L258;
        Context r87 = r184.getContext();
        if (r87 == null) goto L256;
        DocOpManager r88 = DocOpManager.a;
        DocOpManager.h(r87, r124, r184.getChildFragmentManager(), r124.f);
    L256:
        r66 = "report";
        goto L277
    L258:
        if (r126 != 2131899533) goto L278;
        final Context r90 = r184.getContext();
        if (r90 != null) goto L262;
    L276:
        r66 = "delete";
        goto L277
    L262:
        if (r184.isAdded() == false) goto L276;
        DocOpManager r91 = DocOpManager.a;
        final FragmentManager r93 = r184.getChildFragmentManager();
        final String r130 = r124.f;
        int r131 = r124.m;
        final String r94 = r124.j;
        final Map r96 = MapsKt.mapOf(TuplesKt.to("resource_type", Integer.valueOf(r131)));
        final ?? r100 = new g0(r124);
        Intrinsics.checkNotNullParameter(r90, "context");
        Intrinsics.checkNotNullParameter(r93, "fragmentManager");
        Intrinsics.checkNotNullParameter(r130, "resourceId");
        Intrinsics.checkNotNullParameter("upper_right", "showFrom");
        Intrinsics.checkNotNullParameter("ai_doc_detail", "currentPage");
        int r102 = com.larus.office.base.utils.o.a;
        Integer r103 = com.larus.office.base.utils.o.b(Integer.valueOf(r131), 10);
        if (r103 == null) goto L266;
        int r104 = r103.intValue();
    L267:
        final int r105 = r104;
        final ?? r132 = new com.larus.doc.impl.operation.k(r90, r93, r130, r94, r105, r184, r96, r100);
        IDocSdkServiceV2 r106 = (IDocSdkServiceV2) ServiceManager.get().getService(IDocSdkServiceV2.class);
        if (r106 == null) goto L270;
        IDocPermissionService r107 = r106.getPermissionService();
    L271:
        if (r107 != null) goto L273;
    L275:
        r132.invoke();
        goto L276
    L273:
        if (r131 != 10) goto L275;
        r107.validatePermission(r130, 22, "DELETE_ENTITY", new com.larus.doc.impl.operation.b(r132, r90));
        goto L276
    L270:
        r107 = null;
        goto L271
    L266:
        r104 = r131;
        goto L267
    L278:
        String r108 = "send_message_create";
        if (r126 != 2131899585) goto L311;
        r184.ua0();
        r184.wa0();
        Job r109 = r124.H2;
        if (r109 != null) goto L283;
    L285:
        boolean r133 = false;
    L287:
        if (r133 == false) goto L289;
        FLogger.a.e("DocFragment", "sendPodcastRequest fail. because podcastJob is running. ");
    L305:
        com.larus.platform.service.o r134 = com.larus.platform.service.o.a;
        JSONObject r135 = new JSONObject();
        r135.put("resource_id", r124.f);
        r135.put("click_from", "ai_doc");
        Unit r136 = Unit.INSTANCE;
        r134.reportEvent("click_podcast", r135);
        String r137 = m39.a.a;
        if (Intrinsics.areEqual(r124.l, "answer_manual_create") == true) goto L309;
        r108 = r124.l;
    L309:
        JSONObject r138 = new JSONObject();
        r124.na0(r138);
        m39.a.a("listen", "podcast", r108, r138);
        r125 = "podcast";
        goto L349
    L289:
        IFlowSdkDepend r139 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r139 == null) goto L294;
        FlowAppletServiceImpl r140 = r139.g0();
        if (r140 == null) goto L294;
        String r141 = r140.i();
    L296:
        if (Intrinsics.areEqual(r141, r124.f) == true) goto L298;
    L304:
        r124.H2 = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r184.getViewLifecycleOwner()), Dispatchers.getIO(), null, new DocFragment$sendPodcastRequest$2(r124, null), 2, null);
        goto L305
    L298:
        if ((!StringsKt.isBlank(r124.f)) == false) goto L304;
        FLogger.a.i("DocFragment", "target podcast is the same as current, so send resume order and return.resourceId=" + r124.f);
        IFlowSdkDepend r142 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r142 == null) goto L305;
        FlowAppletServiceImpl r143 = r142.g0();
        if (r143 == null) goto L305;
        JsonObject r144 = new JsonObject();
        r144.addProperty("resource_id", r124.f);
        r144.addProperty("open_player", Boolean.FALSE);
        Unit r145 = Unit.INSTANCE;
        r143.a("flow.playDeepResearch", r144);
    L294:
        r141 = null;
        goto L296
    L283:
        if (r109.isCompleted() == true) goto L285;
        r133 = true;
        goto L287
    L311:
        if (r126 == 2131899625) goto L313;
        r125 = null;
        goto L349
    L313:
        if (r124.H1 == false) goto L316;
        r184.ua0();
        r184.wa0();
    L346:
        r66 = "tts";
        goto L277
    L316:
        if (AudioServiceDelegate.a.P().isRecording() == false) goto L318;
        FLogger.a.i("DocFragment", "[TTS][AI_NOTE_RECORDING] can not start tts when ai note is recording.");
        t19.s r146 = t19.s.a;
        Context r147 = r184.requireContext();
        r146.getClass();
        t19.s.s(r147, 2131907356);
    L341:
        String r148 = m39.a.a;
        if (Intrinsics.areEqual(r124.l, "answer_manual_create") == true) goto L345;
        r108 = r124.l;
    L345:
        JSONObject r149 = new JSONObject();
        r124.na0(r149);
        m39.a.a("listen", "play", r108, r149);
        goto L346
    L318:
        IFlowSdkDepend r150 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r150 == null) goto L325;
        com.larus.home.impl.sdk.s r151 = r150.s0();
        if (r151 == null) goto L325;
        if (r151.c() != true) goto L325;
        boolean r152 = true;
    L326:
        if (r152 == false) goto L328;
        FLogger.a.i("DocFragment", "[TTS][DORA_WAKE_UP] can not start tts when dora is wake up.");
        t19.s r153 = t19.s.a;
        AppHost.Companion r154 = AppHost.a;
        Application r155 = r154.getApplication();
        String r156 = r154.getApplication().getString(2131901654);
        r153.getClass();
        t19.s.t(r155, r156);
        goto L341
    L328:
        LarusLayoutDocDetailFragmentBinding r157 = r124.g;
        if (r157 == null) goto L334;
        LottieAdapterView r158 = r157.p;
        if (r158 == null) goto L334;
        com.larus.utils.e1.x(r158);
        r158.setAnimation(2131820621);
        r158.playAnimation();
    L334:
        if (r184.isAdded() == true) goto L336;
    L339:
        FLogger.a.e("DocFragment", "mobStartTts failed. isAdded=" + r184.isAdded() + " activity=" + r184.getActivity());
    L340:
        r124.L1 = SystemClock.elapsedRealtime();
        com.larus.bmhome.chat.model.repo.x1 r159 = (com.larus.bmhome.chat.model.repo.x1) r124.S1.getValue();
        String r160 = r124.f;
        r159.k6(r160, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("doc_page_token", r160), TuplesKt.to("tts_scene", "doc")}), new o0(r124), new p0(r124));
        r124.H1 = true;
        goto L341
    L336:
        if (r184.getActivity() == null) goto L339;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r184.getViewLifecycleOwner()), Dispatchers.getIO(), null, new DocFragment$mobStartTts$1(r124, null), 2, null);
    L325:
        r152 = false;
        goto L326
    L192:
        if (r184.isAdded() == false) goto L219;
        j39.a r161 = (j39.a) s1a.a.g(r184).getAbility(j39.a.class);
        if (r161 == null) goto L199;
        wc9.e r162 = r161.p1();
        if (r162 == null) goto L199;
        String r163 = r162.a;
        if (r163 == null) goto L199;
    L201:
        if (TextUtils.isEmpty(r163) == true) goto L219;
        j39.a r164 = (j39.a) s1a.a.g(r184).getAbility(j39.a.class);
        if (r164 == null) goto L209;
        wc9.e r165 = r164.p1();
        if (r165 == null) goto L209;
        if (ic8.n.r(r165) == true) goto L209;
        boolean r166 = true;
    L210:
        if (r166 == false) goto L219;
        com.bytedance.router.i r167 = SmartRouter.buildRoute(r184.getContext(), "//flow/chat_page");
        r167.c.putExtra("landing_channel", ChatLandingChannel.CHAT_LIST.getChannel());
        j39.a r168 = (j39.a) s1a.a.g(r184).getAbility(j39.a.class);
        if (r168 == null) goto L217;
        wc9.e r169 = r168.p1();
        if (r169 == null) goto L217;
        String r170 = r169.a;
        if (r170 == null) goto L217;
    L218:
        r167.c.putExtra("argConversationId", r170);
        r167.d = 2130772343;
        r167.e = 2130772399;
        r167.d();
        r123 = null;
    L220:
        r66 = "open_conversation";
    L217:
        r170 = "";
    L209:
        r166 = false;
    L199:
        r163 = "";
    L219:
        r123 = null;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r184), Dispatchers.getIO(), null, new DocFragment$jumpToChatPage$1(r124, null), 2, null);
        goto L220
    }

    @Override // g39.a
    public void F8(String r10, String r11, String r12, String r13) {
        FLogger.a.i("DocFragment", "updateArtifactId, artifactId = " + r10);
        this.j = r10;
        this.k = r11;
        if (r12 != null) goto L5;
        r12 = "";
    L5:
        this.x = r12;
        this.w = r13;
        if (r10 == null) goto L9;
        String r14 = m39.a.a;
        Intrinsics.checkNotNullParameter(r10, "artifactId");
        m39.a.b = r10;
    L9:
        if (this.e == true) goto L16;
        this.e = true;
        int r15 = com.larus.doc.impl.offline.k.a;
        String r0 = this.H;
        if (Intrinsics.areEqual(this.l, "answer_manual_create") == false) goto L13;
        String r16 = "send_message_create";
    L14:
        String r1 = r16;
        String r2 = this.f;
        int r17 = ga0();
        int r18 = ga0();
        String r6 = ea0();
        JSONObject r7 = new JSONObject();
        na0(r7);
        com.larus.doc.impl.offline.k.a(r0, r1, r2, r10, Integer.valueOf(r17), Integer.valueOf(r18), r6, r7, this);
        return;
    L13:
        r16 = this.l;
        goto L14
    }
}
