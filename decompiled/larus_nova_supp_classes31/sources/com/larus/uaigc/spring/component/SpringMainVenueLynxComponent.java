package com.larus.uaigc.spring.component;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.router.SmartRouter;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.Gson;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.actionbar.model.h1;
import com.larus.bmhome.actionbar.model.l1;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.CustomMultiAttachmentInfo;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.z8;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.common.apphost.AppHost;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.common_ui.dialog.l0;
import com.larus.home.impl.sdk.FlowAppletServiceImpl;
import com.larus.im.bean.message.FileParseState;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.e4;
import com.larus.platform.api.g3;
import com.larus.platform.service.c1;
import com.larus.platform.service.k2;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.lynx.LynxPageData;
import com.larus.uaigc.lynx.Scatter;
import com.larus.uaigc.lynx.pocket.ClickPocketInfo;
import com.larus.uaigc.lynx.pocket.JumpSomewherePocket;
import com.larus.uaigc.lynx.pocket.KeyboardInputPocket;
import com.larus.uaigc.lynx.pocket.Pocket;
import com.larus.uaigc.lynx.pocket.PocketDataCache;
import com.larus.uaigc.lynx.pocket.RoundInfo;
import com.larus.uaigc.lynx.pocket.SendMsgPocket;
import com.larus.uaigc.lynx.pocket.UploadInputPocket;
import com.larus.uaigc.service.IZLotteryService;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.y0;
import com.lynx.tasm.LynxEnv;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Function;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import tx9.l3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000ª\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 ½\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002½\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010i\u001a\u00020jH\u0016J\u0016\u0010k\u001a\u00020j2\f\u0010l\u001a\b\u0012\u0004\u0012\u00020n0mH\u0002J\b\u0010o\u001a\u00020jH\u0016J\u0016\u0010p\u001a\u0010\u0012\u0004\u0012\u00020R\u0012\u0006\u0012\u0004\u0018\u00010]0\\H\u0002J\u001e\u0010q\u001a\u0010\u0012\u0004\u0012\u00020R\u0012\u0006\u0012\u0004\u0018\u00010]0\\2\u0006\u0010r\u001a\u00020OH\u0002J\b\u0010s\u001a\u00020jH\u0016J\b\u0010t\u001a\u00020RH\u0002J\f\u0010u\u001a\u00020R*\u00020RH\u0002J \u0010v\u001a\u00020j2\u0006\u0010w\u001a\u00020_2\u0006\u0010x\u001a\u00020R2\u0006\u0010r\u001a\u00020OH\u0002J8\u0010y\u001a\u00020R2\u0016\u0010z\u001a\u0012\u0012\u0004\u0012\u00020R\u0012\u0006\u0012\u0004\u0018\u00010]\u0018\u00010\\2\u0006\u0010r\u001a\u00020O2\u0006\u0010{\u001a\u00020|2\u0006\u0010}\u001a\u00020|H\u0002J\b\u0010~\u001a\u00020OH\u0002J!\u0010\u007f\u001a\u00020O2\u0017\u0010\u0080\u0001\u001a\u0012\u0012\u0004\u0012\u00020R\u0012\u0006\u0012\u0004\u0018\u00010]\u0018\u00010\\H\u0002J\u0011\u0010\u0081\u0001\u001a\u00020j2\u0006\u0010w\u001a\u00020_H\u0002J\u0012\u0010\u0082\u0001\u001a\u00020j2\u0007\u0010\u0083\u0001\u001a\u00020_H\u0016J\t\u0010\u0084\u0001\u001a\u00020jH\u0002J\t\u0010\u0085\u0001\u001a\u00020jH\u0002J\u0012\u0010\u0086\u0001\u001a\u00030\u0087\u00012\u0006\u0010r\u001a\u00020OH\u0002J\t\u0010\u0088\u0001\u001a\u00020jH\u0002J\u0012\u0010\u0089\u0001\u001a\u00020j2\u0007\u0010\u0083\u0001\u001a\u00020_H\u0002J\t\u0010\u008a\u0001\u001a\u00020jH\u0016JA\u0010\u008b\u0001\u001a\u00020j2\b\u0010\u008c\u0001\u001a\u00030\u008d\u00012\u0015\u0010\u008e\u0001\u001a\u0010\u0012\u0004\u0012\u00020R\u0012\u0006\u0012\u0004\u0018\u00010]0\\2\u0015\u0010\u008f\u0001\u001a\u0010\u0012\u0004\u0012\u00020R\u0012\u0006\u0012\u0004\u0018\u00010]0\\H\u0002J'\u0010\u0090\u0001\u001a\u00020j2\u0007\u0010\u0091\u0001\u001a\u00020|2\u0007\u0010\u0092\u0001\u001a\u00020|2\n\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0094\u0001H\u0016J\u0012\u0010\u0095\u0001\u001a\u00020j2\u0007\u0010\u0096\u0001\u001a\u00020RH\u0002JA\u0010\u0097\u0001\u001a\u00020j2\b\u0010\u008c\u0001\u001a\u00030\u008d\u00012\u0015\u0010\u008e\u0001\u001a\u0010\u0012\u0004\u0012\u00020R\u0012\u0006\u0012\u0004\u0018\u00010]0\\2\u0015\u0010\u008f\u0001\u001a\u0010\u0012\u0004\u0012\u00020R\u0012\u0006\u0012\u0004\u0018\u00010]0\\H\u0002J\u001f\u0010\u0098\u0001\u001a\u00020j2\u0014\u0010\u0099\u0001\u001a\u000f\u0012\u0004\u0012\u00020R\u0012\u0005\u0012\u00030\u009a\u00010\\H\u0002J\u0015\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009c\u00012\u0007\u0010\u009d\u0001\u001a\u00020|H\u0002JL\u0010\u009e\u0001\u001a\u00020j2\b\u0010\u008c\u0001\u001a\u00030\u008d\u00012\u0015\u0010\u008e\u0001\u001a\u0010\u0012\u0004\u0012\u00020R\u0012\u0006\u0012\u0004\u0018\u00010]0\\2\u0015\u0010\u008f\u0001\u001a\u0010\u0012\u0004\u0012\u00020R\u0012\u0006\u0012\u0004\u0018\u00010]0\\2\t\b\u0002\u0010\u009f\u0001\u001a\u00020OH\u0002JL\u0010 \u0001\u001a\u00020j2\b\u0010\u008c\u0001\u001a\u00030\u008d\u00012\u0015\u0010\u008e\u0001\u001a\u0010\u0012\u0004\u0012\u00020R\u0012\u0006\u0012\u0004\u0018\u00010]0\\2\u0015\u0010\u008f\u0001\u001a\u0010\u0012\u0004\u0012\u00020R\u0012\u0006\u0012\u0004\u0018\u00010]0\\2\t\b\u0002\u0010\u009f\u0001\u001a\u00020OH\u0002JL\u0010¡\u0001\u001a\u00020j2\b\u0010\u008c\u0001\u001a\u00030\u008d\u00012\u0015\u0010\u008e\u0001\u001a\u0010\u0012\u0004\u0012\u00020R\u0012\u0006\u0012\u0004\u0018\u00010]0\\2\u0015\u0010\u008f\u0001\u001a\u0010\u0012\u0004\u0012\u00020R\u0012\u0006\u0012\u0004\u0018\u00010]0\\2\t\b\u0002\u0010\u009f\u0001\u001a\u00020OH\u0002J\u0019\u0010¢\u0001\u001a\u00020j2\u000e\u0010£\u0001\u001a\t\u0012\u0004\u0012\u00020j0¤\u0001H\u0002JB\u0010¥\u0001\u001a\u00020j2\u0015\u0010\u008e\u0001\u001a\u0010\u0012\u0004\u0012\u00020R\u0012\u0006\u0012\u0004\u0018\u00010]0\\2\u0015\u0010\u008f\u0001\u001a\u0010\u0012\u0004\u0012\u00020R\u0012\u0006\u0012\u0004\u0018\u00010]0\\2\t\b\u0002\u0010\u009f\u0001\u001a\u00020OH\u0002JC\u0010¦\u0001\u001a\u00020j2\n\u0010§\u0001\u001a\u0005\u0018\u00010¨\u00012\u0015\u0010\u0093\u0001\u001a\u0010\u0012\u0004\u0012\u00020R\u0012\u0006\u0012\u0004\u0018\u00010]0\\2\u0015\u0010\u008f\u0001\u001a\u0010\u0012\u0004\u0012\u00020R\u0012\u0006\u0012\u0004\u0018\u00010]0\\H\u0016J\u0015\u0010©\u0001\u001a\u00020j2\n\u0010§\u0001\u001a\u0005\u0018\u00010¨\u0001H\u0016J\u000b\u0010ª\u0001\u001a\u0004\u0018\u00010XH\u0016J\f\u0010«\u0001\u001a\u0005\u0018\u00010¬\u0001H\u0016J\t\u0010\u00ad\u0001\u001a\u00020jH\u0016J\u0012\u0010®\u0001\u001a\u00020j2\u0007\u0010¯\u0001\u001a\u00020XH\u0002J\u0012\u0010°\u0001\u001a\u00020j2\u0007\u0010¯\u0001\u001a\u00020XH\u0002J\u0012\u0010±\u0001\u001a\u00020j2\u0007\u0010\u008c\u0001\u001a\u00020XH\u0002J\u000b\u0010²\u0001\u001a\u0004\u0018\u00010XH\u0002J\u000b\u0010³\u0001\u001a\u0004\u0018\u00010XH\u0002J\u000b\u0010´\u0001\u001a\u0004\u0018\u00010XH\u0002J\t\u0010µ\u0001\u001a\u00020jH\u0002J\t\u0010¶\u0001\u001a\u00020jH\u0002J\t\u0010·\u0001\u001a\u00020jH\u0002J\u000b\u0010¸\u0001\u001a\u0004\u0018\u00010RH\u0002J\t\u0010¹\u0001\u001a\u00020|H\u0002J\u0015\u0010º\u0001\u001a\u00020j2\n\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0094\u0001H\u0016J\t\u0010»\u0001\u001a\u00020jH\u0002J\t\u0010¼\u0001\u001a\u00020OH\u0002R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b\"\u0010#R\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u000b\u001a\u0004\b'\u0010(R\u001d\u0010*\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u000b\u001a\u0004\b,\u0010-R\u001d\u0010/\u001a\u0004\u0018\u0001008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u000b\u001a\u0004\b1\u00102R\u001d\u00104\u001a\u0004\u0018\u0001058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u000b\u001a\u0004\b6\u00107R\u001b\u00109\u001a\u00020:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u000b\u001a\u0004\b;\u0010<R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010@\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\u000b\u001a\u0004\bB\u0010CR\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010HX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010I\u001a\u0004\u0018\u00010J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\u000b\u001a\u0004\bK\u0010LR\u0012\u0010N\u001a\u0004\u0018\u00010OX\u0082\u000e¢\u0006\u0004\n\u0002\u0010PR\u0010\u0010Q\u001a\u0004\u0018\u00010RX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020TX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020TX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020TX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010W\u001a\u0004\u0018\u00010XX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Y\u001a\u0004\u0018\u00010XX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Z\u001a\u0004\u0018\u00010XX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010[\u001a\u0012\u0012\u0004\u0012\u00020R\u0012\u0006\u0012\u0004\u0018\u00010]\u0018\u00010\\X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010^\u001a\u0004\u0018\u00010_X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010`\u001a\u00020a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bd\u0010\u000b\u001a\u0004\bb\u0010cR\u000e\u0010e\u001a\u00020fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020hX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006¾\u0001"}, d2 = {"Lcom/larus/uaigc/spring/component/SpringMainVenueLynxComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/uaigc/spring/ability/MainVenueLynxAbility;", "Lcom/larus/uaigc/lynx/OnMainVenueBridgeListener;", "<init>", "()V", "mainVenueInputAbility", "Lcom/larus/uaigc/spring/ability/MainVenueInputAbility;", "getMainVenueInputAbility", "()Lcom/larus/uaigc/spring/ability/MainVenueInputAbility;", "mainVenueInputAbility$delegate", "Lkotlin/Lazy;", "argumentData", "Lcom/larus/uaigc/spring/launcher/SpringMainVenueArgumentData;", "getArgumentData", "()Lcom/larus/uaigc/spring/launcher/SpringMainVenueArgumentData;", "argumentData$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "instructionAbility", "Lcom/larus/bmhome/instruction/IInstructionLogicAbility;", "getInstructionAbility", "()Lcom/larus/bmhome/instruction/IInstructionLogicAbility;", "instructionAbility$delegate", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionInputAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionInputAbility$delegate", "multiAttachmentSelectorAbility", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/IMultiAttachmentSelectorAbility;", "getMultiAttachmentSelectorAbility", "()Lcom/larus/uaigc/bean/createpage/component/mediacontainer/IMultiAttachmentSelectorAbility;", "multiAttachmentSelectorAbility$delegate", "mainVenueShuffleTimesAbility", "Lcom/larus/uaigc/spring/ability/SpringMainVenueShuffleTimesAbility;", "getMainVenueShuffleTimesAbility", "()Lcom/larus/uaigc/spring/ability/SpringMainVenueShuffleTimesAbility;", "mainVenueShuffleTimesAbility$delegate", "reportAbility", "Lcom/larus/uaigc/spring/ability/SpringMainVenueReportAbility;", "getReportAbility", "()Lcom/larus/uaigc/spring/ability/SpringMainVenueReportAbility;", "reportAbility$delegate", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "instructionEditorViewModel", "Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "getInstructionEditorViewModel", "()Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "instructionEditorViewModel$delegate", "lynxView", "Lcom/larus/platform/api/IvyPluginView;", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "aiBeautifyPickPhotoHelper", "Lcom/larus/bmhome/instruction/helper/IAiBeautifyPickPhotoHelper;", "multiAttachmentSelectorController", "Lcom/larus/bmhome/instruction/IMultiAttachmentSelectorController;", "coreInputManager", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "getCoreInputManager", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "coreInputManager$delegate", "lynxViewLoadResult", "", "Ljava/lang/Boolean;", "lynxViewLoadErrorMsg", "", "onLoadStartTimeMs", "", "nativeFirstFrameTimeMs", "lynxFirstFrameTimeMs", "currClickPocketInfo", "Lcom/larus/uaigc/lynx/pocket/ClickPocketInfo;", "albumClickPocketInfo", "avatarPendingPocketInf", "getPocketPageDataResponseDict", "", "", "rootView", "Landroid/view/View;", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "getLoadingDialog", "()Lcom/larus/common_ui/dialog/CommonLoadDialog;", "loadingDialog$delegate", "mainThreadHandler", "Landroid/os/Handler;", "showLoadingRunnable", "Ljava/lang/Runnable;", "onAttach", "", "onAlbumSelected", "uriList", "", "Landroid/net/Uri;", "onCreate", "getScatterMap", "getTraceInfo", "useCache", "onResume", "getActualUrl", "addCommonParamsForTestChannel", "initLynxView", "containerView", "pageData", "generateLynxPageDataJson", "pocketResponseDict", "cacheInvalid", "", "inputBoxShowSetting", "calculateNeedShowLoadingButton", "isPocketPageDataInValid", "pocketResponseCacheDict", "initLynx", "onViewCreated", "view", "showLoadingByDelay", "blockAndHideLoading", "createIvyPluginViewLifeCycle", "Lcom/larus/platform/api/IvyPluginViewLifeCycle;", "registerObservers", "setGradientBackground", "onDestroy", "pocketJumpSomeWhere", "pocket", "Lcom/larus/uaigc/lynx/pocket/Pocket;", "originData", "extra", "handleOnActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "handleOpenSchema", "jumpSchemaUrl", "pocketUploadInput", "updateCoreInputByAttachmentsStatus", "statusMap", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/MultiMediaSelectorStatus;", "createMultiAttachmentSelectorActionBarInstructionItem", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionItem;", "maxNum", "pocketKeyboardInput", "isFromAvatarResult", "pocketSendMsg", "sendMessageWithPocket", "checkImageReadPermission", "doNext", "Lkotlin/Function0;", "executeApplyPocket", "onApplyPocket", "ownerActivity", "Landroid/app/Activity;", "onPopNativePage", "getCurrentClickPocketInfo", "getCurrentNestedFileContent", "Lcom/larus/im/bean/message/NestedFileContent;", "clearCurrentClickPocketInfo", "setCurrClickPocket", "clickPocket", "setAlbumClickPocketInfo", "setAvatarPendingPocketInfo", "getCurrClickPocketInfo", "getAlbumClickPocketInfo", "getAvatarPendingPocketInfo", "clearCurrClickPocketInfo", "clearAlbumClickPocketInfo", "clearAvatarPendingPocketInfo", "getPocketPageDataIconUrl", "getInputBoxShowSetting", "onUploadDigitalAvatarResult", "jumpToCreateDigitalAvatar", "isInputBoxUseConfig", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SpringMainVenueLynxComponent extends BaseContentWidget implements zz9.b, com.larus.uaigc.lynx.i {
    public static final /* synthetic */ int P = 0;
    public com.larus.bmhome.instruction.k A;
    public final Lazy B;
    public Boolean C;
    public String D;
    public long E;
    public long F;
    public long G;
    public ClickPocketInfo H;
    public ClickPocketInfo I;
    public ClickPocketInfo J;
    public Map<String, ? extends Object> K;
    public View L;
    public final Lazy M;
    public final Handler N;
    public final s O;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public e4 x;
    public final Lazy y;
    public com.larus.bmhome.instruction.helper.f z;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(a0 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    public static final class c implements Function0<zz9.a> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(zz9.a.class));
        }
    }

    public static final class d implements Function0<ICoreInputAbility> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(ICoreInputAbility.class));
        }
    }

    public static final class e implements Function0<va8.o> {
        public final /* synthetic */ AttachReceiver a;

        public e(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.o.class));
        }
    }

    public static final class f implements Function0<com.larus.bmhome.instruction.h> {
        public final /* synthetic */ AttachReceiver a;

        public f(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.h.class));
        }
    }

    public static final class g implements Function0<com.larus.bmhome.instruction.g> {
        public final /* synthetic */ AttachReceiver a;

        public g(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.g.class));
        }
    }

    public static final class h implements Function0<ry9.h> {
        public final /* synthetic */ AttachReceiver a;

        public h(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(ry9.h.class));
        }
    }

    public static final class i implements Function0<zz9.e> {
        public final /* synthetic */ AttachReceiver a;

        public i(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(zz9.e.class));
        }
    }

    public static final class j implements Function0<zz9.d> {
        public final /* synthetic */ AttachReceiver a;

        public j(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(zz9.d.class));
        }
    }

    public static final class k implements Function0<com.larus.bmhome.chat.component.cvs.y> {
        public final /* synthetic */ AttachReceiver a;

        public k(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.cvs.y.class));
        }
    }

    public static final class l implements Function0<a0a.b> {
        public final /* synthetic */ AttachReceiver a;

        public l(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).g(Reflection.getOrCreateKotlinClass(a0a.b.class));
        }
    }

    static {
    }

    public final void C3() {
        this.H = null;
        zz9.d r1 = Z3();
        if (r1 == null) goto L5;
        r1.Lj(null);
    L5:
        FLogger.a.i("SpringMainVenueComponent", "[clearCurrClickPocketInfo] finish, currClickPocketInfo = null");
    }

    public final boolean B3() {
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L22
        IZLotteryService.Companion r4 = IZLotteryService.a;     // Catch: Throwable -> L22
        if (r4.d() == false) goto L6;
        return false;
    L6:
        com.larus.uaigc.lynx.j.a.getClass();     // Catch: Throwable -> L22
        int r5 = com.larus.uaigc.lynx.j.c();     // Catch: Throwable -> L22
        if (r5 <= 0) goto L10;
        if (r5 > 100) goto L10;
    L11:
        String r6 = com.larus.platform.service.o.a.getDeviceId();     // Catch: Throwable -> L22
        zz9.e r7 = (zz9.e) this.t.getValue();     // Catch: Throwable -> L22
        if (r7 == null) goto L14;
        double r8 = r7.bB(r6);     // Catch: Throwable -> L22
    L15:
        int r9 = (int) (((double) 100) * r8);     // Catch: Throwable -> L22
        FLogger.a.i("SpringMainVenueComponent", "[calculateNeedShowLoadingButton], showProbs = " + r5 + ", randomNum = " + r9 + ", unit = " + r8);     // Catch: Throwable -> L22
        if (r9 <= 0) goto L21;
        if (r9 > r5) goto L21;
        r4.b();     // Catch: Throwable -> L22
        return true;
    L21:
        return false;
    L14:
        r8 = 0.0d;
    L10:
        r5 = 0;
    L22:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Throwable r1 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
        if (r1 == null) goto L26;
        FLogger.a.i("SpringMainVenueComponent", "[calculateNeedShowLoadingButton] error = " + r1.getMessage());
    L26:
        return false;
    }

    public final a0a.b G3() {
        return (a0a.b) this.n.getValue();
    }

    public final va8.o H3() {
        return (va8.o) this.p.getValue();
    }

    public final ICoreInputAbility Q3() {
        return (ICoreInputAbility) this.o.getValue();
    }

    @Override // zz9.b
    public final NestedFileContent T() {
        com.larus.bmhome.instruction.k r0 = this.A;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.T();
    }

    public final com.larus.bmhome.view.actionbar.edit.c V3() {
        return (com.larus.bmhome.view.actionbar.edit.c) this.w.getValue();
    }

    public final zz9.a W3() {
        return (zz9.a) this.m.getValue();
    }

    public final String X3() {
        Map<String, ? extends Object> r0 = this.K;
        if (r0 == null) goto L5;
        Object r1 = r0.get("pocket_page_data");
    L7:
        if ((r1 instanceof Map) == false) goto L9;
        Map r2 = (Map) r1;
    L10:
        if (r2 != null) goto L12;
        return null;
    L12:
        Object r3 = r2.get("input_box_background_url");
        if ((r3 instanceof String) == true) goto L15;
        return null;
    L15:
        return (String) r3;
    L9:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L7
    }

    public final zz9.d Z3() {
        return (zz9.d) this.u.getValue();
    }

    public final Map<String, Object> a4() {
        zz9.e r1 = (zz9.e) this.t.getValue();
        if (r1 == null) goto L5;
        Map<String, zz9.c> r2 = r1.SH();
    L7:
        if (r2 == null) goto L9;
        zz9.c r3 = r2.get("z_main_enter");
    L10:
        boolean r4 = z2.a.enableNonLotteryShuffle();
        IZLotteryService.Companion r5 = IZLotteryService.a;
        boolean r6 = r5.k();
        FLogger r7 = FLogger.a;
        r7.i("SpringMainVenueComponent", "[getScatterMap] nonLotteryMainEnterItem = " + r3 + ", enableNonLotteryShuffle = " + r4 + ", isInLotteryRound = " + r6);
        if (r4 == false) goto L16;
        if (r6 == true) goto L16;
        if (r3 == null) goto L16;
        r5.l("z_main_enter");
        return MapsKt.mapOf(TuplesKt.to("z_main_enter", Integer.valueOf(r3.a)));
    L16:
        zz9.e r8 = (zz9.e) this.t.getValue();
        if (r8 == null) goto L19;
        Map<String, zz9.c> r9 = r8.Ex();
    L20:
        if (r9 == null) goto L22;
        zz9.c r10 = r9.get("z_main_enter");
    L23:
        r7.i("SpringMainVenueComponent", "[getScatterMap] horseMainEnterItem = " + r10);
        String r11 = ", shuffleTime = ";
        String r12 = ", curRound = ";
        if (r10 == null) goto L52;
        hy9.g r13 = r5.n();
        int r14 = r10.b;
        r7.i("SpringMainVenueComponent", "[getScatterMap] validDuration = " + r14 + ", curRound = " + r13 + ", shuffleTime = " + r10.a);
        if (r14 <= 0) goto L52;
        if (r13 == null) goto L52;
        if (r13.c() == null) goto L52;
        Long r15 = PollingConfigService.a.c();
        if (r15 == null) goto L33;
        long r17 = r15.longValue();
    L34:
        long r16 = r17;
        Long r18 = r13.c();
        if (r18 == null) goto L37;
        long r0 = r18.longValue();
    L38:
        Long r19 = r13.b();
        if (r19 == null) goto L41;
        long r110 = r19.longValue();
    L42:
        long r111 = ((long) r14) + r0;
        if (r111 < r110) goto L46;
        r111 = r110;
    L46:
        StringBuilder r20 = new StringBuilder("[getScatterMap] curTime = ");
        r20.append(r16);
        String r21 = "[getScatterMap] curTime = ";
        r20.append(", horseMs = ");
        r20.append(r0);
        r20.append(", shuffleEndMs = ");
        r20.append(r111);
        r20.append(", endMs = ");
        r20.append(r110);
        r7.i("SpringMainVenueComponent", r20.toString());
        if (r16 >= r0) goto L49;
    L53:
        zz9.e r22 = (zz9.e) this.t.getValue();
        if (r22 == null) goto L56;
        Map<String, zz9.c> r23 = r22.T20();
    L57:
        if (r23 == null) goto L59;
        zz9.c r24 = r23.get("z_main_enter");
    L60:
        r7.i("SpringMainVenueComponent", "[getScatterMap] beginMainEnterItem = " + r24);
        if (r24 == null) goto L113;
        com.larus.uaigc.lynx.j.a.getClass();
        Scatter r25 = com.larus.uaigc.lynx.j.e();
        int r26 = -1;
        if (r25 == null) goto L67;
        Integer r27 = r25.getLotteryFront();
        if (r27 == null) goto L67;
        int r28 = r27.intValue();
    L68:
        if (r25 == null) goto L72;
        Integer r29 = r25.getLotteryRear();
        if (r29 == null) goto L72;
        r26 = r29.intValue();
    L72:
        hy9.g r30 = r5.c(r28);
        r7.i("SpringMainVenueComponent", "[getScatterMap] lotteryFront = " + r28 + ", lotteryRear = " + r26 + r12 + r30 + r11 + r24.a);
        if (r28 <= 0) goto L113;
        if (r26 <= 0) goto L113;
        if (r30 == null) goto L113;
        if (r30.d() == null) goto L113;
        if (r30.a() == null) goto L113;
        Long r112 = PollingConfigService.a.c();
        if (r112 == null) goto L83;
        long r113 = r112.longValue();
    L84:
        Long r114 = r30.a();
        if (r114 == null) goto L87;
        long r115 = r114.longValue();
    L88:
        Long r116 = r30.b();
        if (r116 == null) goto L91;
        long r117 = r116.longValue();
    L92:
        long r31 = r115 - ((long) r28);
        if (r31 > 0) goto L96;
        r31 = r115;
    L96:
        long r32 = ((long) r26) + r115;
        if (r32 < r117) goto L100;
        r32 = r117;
    L100:
        r7.i("SpringMainVenueComponent", r21 + r113 + ", roundNum = " + r30.d() + ", beginMs = " + r115 + ", endMs = " + r117 + ", shuffleFrontMs = " + r31 + ", shuffleRearMs = " + r32);
        if (r113 < r31) goto L113;
        if (r113 >= r32) goto L113;
        Integer r33 = r30.d();
        if (r33 == null) goto L107;
        String r34 = r3;
        r5.p(r33.intValue(), r34);
    L109:
        return MapsKt.mapOf(TuplesKt.to(r34, Integer.valueOf(r24.a)));
    L107:
        r34 = r3;
        goto L109
    L91:
        r117 = 0;
        goto L92
    L87:
        r115 = 0;
        goto L88
    L83:
        r113 = AppHost.a.getAppClock().currentTimeMillis();
    L67:
        r28 = -1;
    L113:
        return MapsKt.mapOf(TuplesKt.to("z_main_enter", 0));
    L59:
        r24 = null;
        goto L60
    L56:
        r23 = null;
        goto L57
    L49:
        if (r16 >= r111) goto L53;
        r5.g("z_main_enter");
        return MapsKt.mapOf(TuplesKt.to("z_main_enter", Integer.valueOf(r10.a)));
    L41:
        r110 = 0;
        goto L42
    L37:
        r0 = 0;
        goto L38
    L33:
        r17 = AppHost.a.getAppClock().currentTimeMillis();
    L52:
        r21 = "[getScatterMap] curTime = ";
        r11 = ", shuffleTime = ";
        r12 = ", curRound = ";
        goto L53
    L22:
        r10 = null;
        goto L23
    L19:
        r9 = null;
        goto L20
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L7
    }

    public final void onDestroy() {
        CopyOnWriteArrayList<com.larus.uaigc.lynx.i> r0 = com.larus.uaigc.lynx.a.a;
        Intrinsics.checkNotNullParameter(this, "listener");
        CopyOnWriteArrayList<com.larus.uaigc.lynx.i> r1 = com.larus.uaigc.lynx.a.a;
        if (r1.contains(this) == false) goto L5;
        SpringMainVenueLynxComponent r2 = this;
    L6:
        if (r2 == null) goto L8;
        r1.remove(r2);
    L8:
        com.larus.bmhome.instruction.g r3 = vc();
        if (r3 == null) goto L11;
        r3.xy();
    L11:
        com.larus.bmhome.instruction.g r4 = vc();
        if (r4 == null) goto L14;
        r4.ls();
    L14:
        com.larus.bmhome.instruction.helper.f r5 = this.z;
        if (r5 == null) goto L17;
        r5.onDestroy();
    L17:
        e4 r6 = this.x;
        if (r6 == null) goto L20;
        r6.destroy();
    L20:
        this.x = null;
        yz9.b.a.clear();
        LynxEnv.inst().addBehavior(yz9.b.c);
        this.N.removeCallbacksAndMessages(null);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void onResume() {
        FLogger.a.i("SpringMainVenueComponent", "[onResume] timeMs: " + System.currentTimeMillis());
    }

    public final com.larus.bmhome.instruction.g vc() {
        return (com.larus.bmhome.instruction.g) this.r.getValue();
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, zz9.b.class);
        IAIChatUgcAIGCService.Companion r1 = IAIChatUgcAIGCService.a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        com.larus.bmhome.instruction.helper.f r0 = r1.H0(com.larus.ui.arch.component.internal.attach.a.b(this, this));
        r0.b(new v(this));
        r0.c(new w(this));
        this.z = r0;
    }

    /* JADX WARN: Type inference failed for: r0v30, types: [com.larus.uaigc.spring.component.s] */
    public SpringMainVenueLynxComponent() {
        this.m = LazyKt.lazy(new c(this));
        this.n = LazyKt.lazy(new l(this));
        this.o = LazyKt.lazy(new d(this));
        this.p = LazyKt.lazy(new e(this));
        this.q = LazyKt.lazy(new f(this));
        this.r = LazyKt.lazy(new g(this));
        this.s = LazyKt.lazy(new h(this));
        this.t = LazyKt.lazy(new i(this));
        this.u = LazyKt.lazy(new j(this));
        this.v = LazyKt.lazy(new k(this));
        this.w = LazyKt.lazy(new com.larus.uaigc.spring.component.i(this));
        this.y = LazyKt.lazy(new p());
        this.B = LazyKt.lazy(new q(this));
        this.E = -1;
        this.F = -1;
        this.G = -1;
        this.M = LazyKt.lazy(new r(this));
        this.N = new Handler(Looper.getMainLooper());
        this.O = new s(this);
    }

    public final void onCreate() {
        super/*com.larus.ui.arch.component.external.delegate.BaseComponentWidget*/.onCreate();
        FLogger.a.i("SpringMainVenueComponent", "[onCreate] timeMs: " + System.currentTimeMillis());
        CopyOnWriteArrayList<com.larus.uaigc.lynx.i> r0 = com.larus.uaigc.lynx.a.a;
        Intrinsics.checkNotNullParameter(this, "listener");
        CopyOnWriteArrayList<com.larus.uaigc.lynx.i> r1 = com.larus.uaigc.lynx.a.a;
        if ((!r1.contains(this)) == false) goto L5;
        SpringMainVenueLynxComponent r2 = this;
    L6:
        if (r2 == null) goto L8;
        r1.add(r2);
    L8:
        CopyOnWriteArrayList<yz9.a> r3 = yz9.b.a;
        yz9.a r4 = new AnonymousClass1(this);
        Intrinsics.checkNotNullParameter(r4, "onInputVisibleChangeListener");
        yz9.b.a.add(r4);
        LynxEnv.inst().addBehavior(yz9.b.b);
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // zz9.b
    public final void K9() {
        C3();
    }

    @Override // zz9.b
    public final ClickPocketInfo Ka() {
        return this.H;
    }

    public static final void Y2(SpringMainVenueLynxComponent r4) {
        r4.getClass();
        FLogger.a.i("SpringMainVenueComponent", "[blockAndHideLoading] start");
        r4.N.removeCallbacks(r4.O);
        l0 r5 = (l0) r4.M.getValue();
        Handler r0 = DialogLancet.resolveDialogHandler(r5);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r5);
        r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r5);
    L17:
        FLogger.a.i("SpringMainVenueComponent", "[blockAndHideLoading] end");
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r1 == null) goto L16;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r5);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(r5));
        goto L17
    }

    @Override // zz9.b
    public final void M8(Intent r4) {
        if (r4.getStringExtra("ipa_main_url") == null) goto L17;
        ClickPocketInfo r5 = this.J;
        this.J = null;
        FLogger.a.i("SpringMainVenueComponent", "[clearAvatarPendingPocketInfo] finish, avatarPendingPocketInf = null");
        if (r5 == null) goto L15;
        final Map<String, Object> r0 = r5.getOriginData();
        final Map<String, Object> r1 = r5.getExtra();
        Integer r6 = r5.getPocket().getPocketType();
        if (r6 != null) goto L11;
    L13:
        D3(r0, r1, true);
        return;
    L11:
        if (r6.intValue() != 2) goto L13;
        F2().postDelayed(new com.larus.uaigc.spring.component.l(this, r0, r1), 200);
        return;
    L15:
        return;
    }

    public final Map<String, Object> c4(boolean r11) {
        a0a.b r0 = G3();
        long r2 = -1;
        if (r0 == null) goto L11;
        Bundle r1 = r0.a;
        if (r1 == null) goto L7;
        long r4 = r1.getLong("click_action_bar_time");
    L8:
        Long r3 = Long.valueOf(r4);
        if (r3 == null) goto L11;
        long r5 = r3.longValue();
    L12:
        a0a.b r6 = G3();
        if (r6 == null) goto L21;
        Bundle r7 = r6.a;
        if (r7 == null) goto L17;
        long r8 = r7.getLong("schema_handle_time");
    L18:
        Long r9 = Long.valueOf(r8);
        if (r9 == null) goto L21;
        r2 = r9.longValue();
        goto L21
    L17:
        r8 = -1;
    L21:
        Pair[] r10 = new Pair[6];
        a0a.b r12 = G3();
        String r13 = null;
        if (r12 == null) goto L24;
        String r14 = r12.b();
    L25:
        r10[0] = TuplesKt.to("enter_method", r14);
        r10[1] = TuplesKt.to("current_page", "spring_guide_2026");
        a0a.b r15 = G3();
        if (r15 == null) goto L28;
        r13 = r15.a();
    L28:
        r10[2] = TuplesKt.to("action_bar_key", r13);
        r10[3] = TuplesKt.to("click_action_bar_time", Long.valueOf(r5));
        r10[4] = TuplesKt.to("schema_handle_time", Long.valueOf(r2));
        if (r11 == false) goto L31;
        String r16 = "cache";
    L32:
        r10[5] = TuplesKt.to("data_source", r16);
        return MapsKt.mapOf(r10);
    L31:
        r16 = "fetch";
        goto L32
    L24:
        r14 = null;
        goto L25
    L7:
        r4 = -1;
    L11:
        r5 = -1;
        goto L12
    }

    public final void e4(List<? extends Uri> r57) {
        if (this.I != null) goto L5;
        return;
    L5:
        ArrayList r3 = new ArrayList();
        Iterator<T> r1 = r57.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        Uri r2 = (Uri) r1.next();
        String r4 = vqc.d.d(AppHost.a.getApplication(), r2);
        ImFileUtil r5 = ImFileUtil.a;
        PolarisFileWrapper r6 = new PolarisFileWrapper(r4);
        r5.getClass();
        UplinkEntityContent r7 = new UplinkEntityContent(null, new Image(null, ImFileUtil.g(r6), null, new ImageObj(null, 0, 0, null, null, 31, null), null, r4, null, null, null, null, null, null, null, null, 16341, null), 1, null);
        r3.add(new UplinkFileEntity(Integer.valueOf(UplinkEntityType.EntityTypeImage.getValue()), r7, null, null, Integer.valueOf(FileReviewState.DEFAULT.getValue()), Integer.valueOf(FileParseState.DEFAULT.getValue()), 0, Integer.valueOf(UpLinkState.PROCESSING.getValue()), null, false, Uri.fromFile(new PolarisFileWrapper(r4)), null, null, null, 15116, null));
        goto L7
    L9:
        a0a.b r8 = G3();
        if (r8 == null) goto L15;
        String r9 = r8.b();
        if (r9 == null) goto L15;
        String r13 = r9;
    L16:
        CustomMultiAttachmentInfo r46 = new CustomMultiAttachmentInfo("album", r13, new NestedFileContent(r3, null, false, null, 14, null), false, false, true, IZLotteryService.a.k(), null, 136, null);
        ClickPocketInfo r10 = this.I;
        if (r10 == null) goto L24;
        Pocket r11 = r10.getPocket();
        if (r11 == null) goto L24;
        String r12 = r11.getPrompt();
        if (r12 == null) goto L24;
        String r20 = r12;
    L25:
        a0a.b r14 = G3();
        if (r14 == null) goto L31;
        String r15 = r14.b();
        if (r15 == null) goto L31;
        String r39 = r15;
    L32:
        ICoreInputAbility.OnSendParams r16 = new ICoreInputAbility.OnSendParams(r20, "", null, null, null, null, null, null, 8888, false, null, false, false, false, null, null, null, null, false, r39, null, null, null, null, null, null, r46, null, null, null, null, null, null, -67633472, 1, null);
        if (r10 == null) goto L41;
        com.larus.bmhome.instruction.g r17 = vc();
        if (r17 == null) goto L37;
        r17.A1();
    L37:
        h4(r10);
        this.I = null;
        zz9.d r18 = Z3();
        if (r18 == null) goto L40;
        r18.O2(null);
    L40:
        FLogger.a.i("SpringMainVenueComponent", "[clearAlbumClickPocketInfo] finish, currClickPocketInfo = null");
    L41:
        zz9.a r19 = W3();
        if (r19 == null) goto L46;
        zz9.a.C0088a.a(r19, r16, "spring_guide_2026_sug", null, false, 12);
        return;
    L46:
        return;
    L31:
        r39 = "";
    L24:
        r20 = "";
    L15:
        r13 = "";
        goto L16
    }

    public final void h4(ClickPocketInfo r3) {
        this.H = r3;
        zz9.d r0 = Z3();
        if (r0 == null) goto L5;
        r0.Lj(r3);
    L5:
        FLogger.a.i("SpringMainVenueComponent", "[setCurrClickPocket] finish, currClickPocketInfo = " + this.H);
    }

    public final void onViewCreated(View r19) {
        Intrinsics.checkNotNullParameter(r19, "view");
        this.L = r19;
        a0a.b r0 = G3();
        if (r0 == null) goto L16;
        ArrayList r4 = new ArrayList();
        Bundle r5 = r0.a;
        if (r5 == null) goto L7;
        String r6 = r5.getString("linear_bg");
    L121:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L14
        if (r6 == null) goto L11;
        Boolean r1 = Boolean.valueOf(r4.addAll(r0.c(r6)));     // Catch: Throwable -> L14
    L12:
        Result.constructor-impl(r1);     // Catch: Throwable -> L14
        List r8 = r4;
    L17:
        boolean r9 = false;
        if (r8.isEmpty() == false) goto L21;
    L31:
        this.N.postDelayed(this.O, 1000);
        PocketDataCache.a.getClass();
        Map<String, ? extends Object> r10 = PocketDataCache.c();
        com.larus.uaigc.lynx.j.a.getClass();
        boolean r2 = com.larus.uaigc.lynx.j.b();
        FLogger r11 = FLogger.a;
        r11.e("SpringMainVenueComponent", "[isPocketPageDataValidOptionOpen] isCacheOff = " + r2);
        if (r2 == false) goto L35;
        boolean r3 = true;
    L48:
        StringBuilder r12 = new StringBuilder("[initLynx] isInvalid = ");
        r12.append(r3);
        r12.append(", pocketResponseCacheDict.size = ");
        if (r10 == null) goto L51;
        int r13 = ((ConcurrentHashMap) r10).size();
    L52:
        r12.append(r13);
        r11.i("SpringMainVenueComponent", r12.toString());
        if (r3 == false) goto L55;
        boolean r14 = z2.a.getZMainInputBoxShow();
        String r15 = E3(MapsKt.emptyMap(), false, 1, r14 ? 1 : 0);
        d4(r19, r15, false);
        r11.e("SpringMainVenueComponent", "[initLynx] inValid: true, init lynx by empty pocketPageData");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain().getImmediate(), null, new SpringMainVenueLynxComponent$initLynx$1(this, r14 ? 1 : 0, r15, null), 2, null);
    L111:
        com.larus.bmhome.instruction.g r16 = vc();
        if (r16 == null) goto L114;
        r16.ST();
    L114:
        com.larus.bmhome.instruction.g r17 = vc();
        if (r17 == null) goto L117;
        r17.GR();
    L117:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new SpringMainVenueLynxComponent$registerObservers$1(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new SpringMainVenueLynxComponent$registerObservers$2(this, null), 3, null);
        this.F = System.currentTimeMillis();
        return;
    L55:
        if (r10 != null) goto L57;
    L60:
        boolean r18 = true;
    L61:
        if (r18 == false) goto L63;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain().getImmediate(), null, new SpringMainVenueLynxComponent$initLynx$2(this, r19, null), 2, null);
        goto L111
    L63:
        this.K = r10;
        r11.i("SpringMainVenueComponent", "[initLynx] inValid: false, use cache pocketPageData initLynx");
        boolean r20 = z2.a.getZMainInputBoxShow();
        String r110 = E3(r10, true, 0, r20 ? 1 : 0);
        r11.e("SpringMainVenueComponent", "[initLynx] inValid: false, cache pocketPageData pageDataJson generate = " + r110 + ", inputBoxShowSetting = " + (r20 ? 1 : 0));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new SpringMainVenueLynxComponent$initLynx$3(this, r19, r110, null), 2, null);
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L76
        s09.a r22 = PollingConfigService.a.h();     // Catch: Throwable -> L76
        if (r22 == null) goto L69;
        Map r23 = r22.a;     // Catch: Throwable -> L76
        if (r23 == null) goto L69;
        String r24 = (String) r23.get("t_scatter");     // Catch: Throwable -> L76
    L71:
        if (o0.d(r24) == false) goto L80;
        Integer r25 = ((Scatter) com.larus.uaigc.lynx.j.b.fromJson(r24, Scatter.class)).getBlockProbs();     // Catch: Throwable -> L76
        if (r25 == null) goto L80;
        int r26 = r25.intValue();     // Catch: Throwable -> L76
    L82:
        if (r26 <= 0) goto L85;
        if (r26 > 100) goto L85;
    L86:
        String r27 = com.larus.platform.service.o.a.getDeviceId().concat("_refresh_pocket");
        zz9.e r111 = (zz9.e) this.t.getValue();
        if (r111 == null) goto L89;
        double r112 = r111.bB(r27);
    L90:
        int r28 = (int) (r112 * ((double) 100));
        FLogger r29 = FLogger.a;
        r29.i("SpringMainVenueComponent", "[initLynx] inValid: false, realBlockProbs = " + r26 + ", randomNum = " + r28);
        if (r28 <= 0) goto L106;
        if (r28 > r26) goto L106;
        if (IZLotteryService.a.o() == false) goto L105;
        Object r30 = ((ConcurrentHashMap) r10).get("pocket_page_data");
        if ((r30 instanceof Map) == false) goto L98;
        Map r31 = (Map) r30;
    L99:
        if (r31 == null) goto L101;
        Object r32 = r31.get("can_support_be_gala_time_config");
    L102:
        r29.e("SpringMainVenueComponent", "[initLynx] inValid: false, cache data generate finish, start refresh cache, isInLotteryRound isHorseData = " + r32);
        if (Intrinsics.areEqual(r32, Boolean.TRUE) == false) goto L106;
    L107:
        r29.e("SpringMainVenueComponent", "[initLynx] inValid: false, cache data generate finish, start refresh cache, canDoRefresh = " + r9);
        if (r9 == false) goto L110;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new SpringMainVenueLynxComponent$initLynx$4(this, null), 3, null);
    L110:
        Unit r33 = Unit.INSTANCE;
        goto L111
    L101:
        r32 = null;
        goto L102
    L98:
        r31 = null;
        goto L99
    L105:
        r29.e("SpringMainVenueComponent", "[initLynx] inValid: false, cache data generate finish, start refresh cache, isNotInLotteryRound");
    L106:
        r9 = true;
        goto L107
    L89:
        r112 = 0.0d;
    L85:
        r26 = 0;
    L80:
        r26 = 0;
    L69:
        r24 = null;
    L76:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        Throwable r35 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
        if (r35 == null) goto L80;
        FLogger.a.e("PollingConfigInfoProvider", "[provideMainTimeScatterProbs] failed, error = " + r35);
        goto L80
    L57:
        if (((ConcurrentHashMap) r10).isEmpty() == true) goto L60;
        r18 = false;
        goto L61
    L51:
        r13 = -1;
        goto L52
    L35:
        if (IZLotteryService.a.o() == false) goto L47;
        if (r10 == null) goto L38;
        Object r36 = ((ConcurrentHashMap) r10).get("pocket_page_data");
    L40:
        if ((r36 instanceof Map) == false) goto L42;
        Map r37 = (Map) r36;
    L43:
        if (r37 == null) goto L45;
        Object r38 = r37.get("can_support_be_gala_time_config");
    L46:
        r3 = !Intrinsics.areEqual(r38, Boolean.TRUE);
        goto L48
    L45:
        r38 = null;
        goto L46
    L42:
        r37 = null;
        goto L43
    L38:
        r36 = null;
        goto L40
    L47:
        r3 = false;
        goto L48
    L21:
        if (r8.size() < 2) goto L30;
        ArrayList r39 = new ArrayList();
        ArrayList r40 = new ArrayList();
        Iterator r41 = r8.iterator();
        int r42 = 0;
    L24:
        if (r41.hasNext() == false) goto L29;
        Object r43 = r41.next();
        int r44 = r42 + 1;
        if (r42 >= 0) goto L28;
        CollectionsKt.throwIndexOverflow();
    L28:
        a0a.a r45 = (a0a.a) r43;
        r39.add(Integer.valueOf(ColorProtector.parseColor(r45.a)));
        r40.add(Float.valueOf(r45.b));
        r42 = r44;
        goto L24
    L29:
        LinearGradient r46 = new LinearGradient(0.0f, 0.0f, UIUtils.getScreenWidth(s1a.a.getActivity(this)), UIUtils.getScreenHeight(s1a.a.getActivity(this)), CollectionsKt.toIntArray(r39), CollectionsKt.toFloatArray(r40), Shader.TileMode.CLAMP);
        ShapeDrawable r47 = new ShapeDrawable(new RectShape());
        r47.getPaint().setShader(r46);
        r19.setBackground(r47);
        goto L31
    L30:
        r19.setBackgroundColor(ColorProtector.parseColor(((a0a.a) ListProtector.get(r8, 0)).a));
        goto L31
    L11:
        r1 = null;
    L14:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        r8 = r4;
        goto L17
    L7:
        r6 = null;
        goto L121
    L16:
        r8 = CollectionsKt.emptyList();
        goto L17
    }

    @Override // com.larus.uaigc.lynx.i
    public final void r(Activity r2) {
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (Intrinsics.areEqual(com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity(), r2) == false) goto L6;
        s1a.a.getActivity(this).finish();
        return;
    }

    @Override // zz9.b
    public final void r3(int r2, Intent r3) {
        if (r2 != (-1)) goto L21;
        if (r3 == null) goto L7;
        String r4 = r3.getStringExtra("result_from");
        if (r4 == null) goto L7;
    L9:
        if (Intrinsics.areEqual(r4, "creation") == false) goto L22;
        com.larus.bmhome.instruction.g r5 = vc();
        if (r5 == null) goto L17;
        if (r3 == null) goto L15;
        Bundle r6 = r3.getExtras();
        if (r6 == null) goto L15;
    L16:
        r5.Nb(r6);
    L15:
        r6 = new Bundle();
    L17:
        zz9.a r7 = W3();
        if (r7 == null) goto L23;
        r7.h6();
        return;
    L23:
        return;
    L22:
        return;
    L7:
        r4 = "";
        goto L9
    }

    public final void D3(Map<String, ? extends Object> r11, Map<String, ? extends Object> r12, boolean r13) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain().getImmediate(), null, new SpringMainVenueLynxComponent$executeApplyPocket$1(r11, this, r12, r13, null), 2, null);
    }

    @Override // com.larus.uaigc.lynx.i
    public final void b(Activity r2, Map<String, ? extends Object> r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "extra");
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (Intrinsics.areEqual(com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity(), r2) == false) goto L6;
        D3(r3, r4, false);
        return;
    }

    public final void d4(View r9, String r10, boolean r11) {
        c1 r0 = c1.a;
        if (r0.d() == true) goto L5;
        r0.f();
    L5:
        s09.a r1 = PollingConfigService.a.d();
        boolean r2 = false;
        if (r1 == null) goto L12;
        Map r3 = r1.a;
        if (r3 == null) goto L12;
        String r4 = (String) r3.get("builtin_dg_m");
        if (r4 == null) goto L12;
        int r5 = l3.e(r4, 0);
    L13:
        if (r1 == null) goto L19;
        Map r6 = r1.a;
        if (r6 == null) goto L19;
        String r7 = (String) r6.get("gecko_dg");
        if (r7 == null) goto L19;
        int r8 = l3.e(r7, 0);
    L20:
        StringBuilder r12 = new StringBuilder("sslocal://lynxview?url=");
        String r13 = "https://lf-doubao-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/z/lynx/template/z_activity_lynx_template/z-new-year.template.js";
        if (AppHost.a.isTestChannel() == false) goto L44;
        IFlowSdkDepend r14 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r14 == null) goto L29;
        FlowAppletServiceImpl r15 = r14.g0();
        if (r15 == null) goto L29;
        if (r15.e() != true) goto L29;
        r2 = true;
    L29:
        if (r2 == false) goto L44;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L38
        Uri r17 = y0.b(y0.b(UriProtector.parse(URLDecoder.decode("https://lf-doubao-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/z/lynx/template/z_activity_lynx_template/z-new-year.template.js", "UTF-8")), "gecko_channel", "z_activity_lynx_template"), "gecko_bundle", "z-new-year.template.js");     // Catch: Throwable -> L38
        IFlowSdkDepend r18 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: Throwable -> L38
        if (r18 == null) goto L35;
        FlowAppletServiceImpl r19 = r18.g0();     // Catch: Throwable -> L38
        if (r19 == null) goto L35;
        String r20 = r19.f();     // Catch: Throwable -> L38
    L36:
        Object r21 = Result.constructor-impl(Uri.encode(y0.b(r17, "gecko_access_key", r20).toString()));     // Catch: Throwable -> L38
    L40:
        Object r22 = r13;
        if (Result.exceptionOrNull-impl(r21) != null) goto L43;
        r22 = r21;
    L43:
        r13 = (String) r22;
    L35:
        r20 = null;
    L38:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r21 = Result.constructor-impl(ResultKt.createFailure(th));
    L44:
        r12.append(r13);
        r12.append("&disable_builtin=");
        r12.append(r5);
        r12.append("&disable_gecko=");
        r12.append(r8);
        r12.append("&loader_name=forest&bdhm_bid=z_activity&bdhm_pid=z_main&forest_newly_builtin=1&enable_lynx_generic_fetcher=1&enable_code_cache=1");
        String r24 = r12.toString();
        Resources r25 = F2().getContext().getResources();
        int r26 = WindowDisplayMetricsOverride.apply(r25, r25.getDisplayMetrics()).widthPixels;
        e4 r110 = c1.a.g(r9.getContext(), r24 + "&lynx_preset_width=" + r26 + "&lynx_preset_width_spec=" + View.MeasureSpec.makeMeasureSpec(r26, 1073741824), r10, new y(this, r11));
        this.x = r110;
        if (r110 == null) goto L54;
        View r111 = r110.getView();
        if (r111 == null) goto L55;
        ViewGroup r112 = (ViewGroup) r9.findViewById(2131372778);
        if ((r9 instanceof ViewGroup) == false) goto L56;
        r112.removeAllViews();
        r112.addView(r111, new ConstraintLayout.LayoutParams(-1, -1));
        return;
    L56:
        return;
    L55:
        return;
    L54:
        return;
    L19:
        r8 = 0;
    L12:
        r5 = 0;
        goto L13
    }

    public static final void h3(final SpringMainVenueLynxComponent r17, Pocket r18, Map r19, Map r20) {
        FLogger.a.i("SpringMainVenueComponent", "[pocketJumpSomeWhere] jumpSomewherePocket = " + r18.getJumpSomewherePocket());
        JumpSomewherePocket r1 = r18.getJumpSomewherePocket();
        int r2 = -1;
        String r3 = "";
        if (r1 == null) goto L50;
        String r5 = r1.getJumpInstructionId();
        Unit r8 = null;
        if (o0.d(r5) == false) goto L28;
        int r6 = l3.e(r5, 0);
        if (r6 <= 0) goto L27;
        com.larus.bmhome.instruction.g r7 = r17.vc();
        if (r7 == null) goto L11;
        r7.A1();
    L11:
        r17.h4(new ClickPocketInfo(r18, r19, r20, null, 8, null));
        z8 r9 = (z8) r17.B.getValue();
        if (r9 == null) goto L14;
        r9.a9(true);
    L14:
        z0 r10 = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).e(r6);
        if (r10 == null) goto L27;
        String r4 = r1.getInsertPrompt();
        if (o0.d(r4) == false) goto L19;
        String r11 = r4;
    L20:
        if (r11 == null) goto L24;
        ICoreInputAbility r12 = r17.Q3();
        if (r12 == null) goto L24;
        ICoreInputAbility.b.d(r12, r11, false, false, null, null, false, 62);
    L24:
        com.larus.bmhome.instruction.h r13 = (com.larus.bmhome.instruction.h) r17.q.getValue();
        if (r13 == null) goto L27;
        com.larus.bmhome.instruction.h.a.a(r13, r10, 5, new x(r17), 8);
        goto L27
    L19:
        r11 = null;
    L27:
        Unit r14 = Unit.INSTANCE;
    L49:
        if (r14 == null) goto L50;
        return;
    L28:
        String r15 = r1.getJumpSchemaUrl();
        if (o0.d(r15) == true) goto L32;
        r15 = null;
    L32:
        if (r15 == null) goto L38;
        Bundle r16 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("open_new_chat_page_on_send", Boolean.FALSE)});
        Uri r21 = UriProtector.parse(r15);
        Intrinsics.checkNotNullParameter(r17, "<this>");
        com.bytedance.router.i r22 = SmartRouter.buildRoute(com.larus.ui.arch.component.internal.attach.a.b(r17, r17).getContext(), r21.buildUpon().appendQueryParameter("android_no_clear_top", "1").build().toString());
        r22.c.putExtras(r16);
        r22.e(99323);
        zz9.d r23 = r17.Z3();
        if (r23 == null) goto L36;
        r23.j3("enter_new_page");
        r14 = Unit.INSTANCE;
    L37:
        if (r14 != null) goto L49;
    L36:
        r14 = null;
    L38:
        zz9.d r24 = r17.Z3();
        if (r24 == null) goto L48;
        String r25 = r18.getPocketId();
        if (r25 != null) goto L43;
        r25 = "";
    L43:
        Integer r26 = r18.getPocketType();
        if (r26 == null) goto L46;
        int r27 = r26.intValue();
    L47:
        r24.W7(r25, 0, r27, "invalid_data");
        r8 = Unit.INSTANCE;
        goto L48
    L46:
        r27 = -1;
    L48:
        r14 = r8;
    L50:
        zz9.d r0 = r17.Z3();
        if (r0 == null) goto L62;
        String r28 = r18.getPocketId();
        if (r28 == null) goto L56;
        r3 = r28;
    L56:
        Integer r29 = r18.getPocketType();
        if (r29 == null) goto L59;
        r2 = r29.intValue();
    L59:
        r0.W7(r3, 0, r2, "invalid_pocket");
        Unit r30 = Unit.INSTANCE;
        return;
    }

    public static final void z3(final SpringMainVenueLynxComponent r36, Pocket r37, Map r38, Map r39) {
        FLogger.a.i("SpringMainVenueComponent", "[pocketUploadInput] pocketUploadInput = " + r37.getUploadInputPocket());
        final UploadInputPocket r2 = r37.getUploadInputPocket();
        int r0 = -1;
        String r4 = "";
        if (r2 == null) goto L78;
        ClickPocketInfo r5 = r36.H;
        String r6 = null;
        if (r5 == null) goto L9;
        Pocket r7 = r5.getPocket();
        if (r7 == null) goto L9;
        String r8 = r7.getPocketId();
    L10:
        ClickPocketInfo r9 = r36.H;
        if (r9 == null) goto L15;
        Pocket r10 = r9.getPocket();
        if (r10 == null) goto L15;
        Integer r11 = r10.getPocketType();
    L17:
        if (Intrinsics.areEqual(r8, r37.getPocketId()) == false) goto L19;
    L23:
        r36.h4(new ClickPocketInfo(r37, r38, r39, null, 8, null));
        zz9.d r12 = r36.Z3();
        if (r12 == null) goto L32;
        String r13 = r37.getPocketId();
        if (r13 != null) goto L28;
        r13 = "";
    L28:
        Integer r14 = r37.getPocketType();
        if (r14 == null) goto L31;
        r0 = r14.intValue();
    L31:
        r12.W7(r13, 1, r0, "");
    L32:
        z8 r1 = (z8) r36.B.getValue();
        if (r1 == null) goto L35;
        r1.a9(true);
    L35:
        Integer r3 = r2.getSelectedPhotosCount();
        if (r3 == null) goto L38;
        final int r15 = r3.intValue();
    L39:
        ArrayList r16 = new ArrayList();
        if (r15 <= 0) goto L61;
        com.larus.bmhome.instruction.g r17 = r36.vc();
        if (r17 == null) goto L44;
        r17.ls();
    L44:
        com.larus.bmhome.instruction.g r18 = r36.vc();
        if (r18 == null) goto L47;
        r18.EF(new com.larus.uaigc.spring.component.j(r36, r15, r2));
    L47:
        com.larus.bmhome.actionbar.model.v r19 = new com.larus.bmhome.actionbar.model.v(Integer.valueOf(r15), new l1(0), 12);
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L50
        Object r21 = Result.constructor-impl(((Gson) r36.y.getValue()).toJson(r19));     // Catch: Throwable -> L50
    L53:
        if (Result.isFailure-impl(r21) == false) goto L55;
        r21 = null;
    L55:
        String r110 = (String) r21;
        if (r110 != null) goto L58;
        com.larus.bmhome.actionbar.model.u r22 = null;
    L59:
        if (r22 == null) goto L61;
        r16.add(r22);
        goto L61
    L58:
        Boolean r111 = Boolean.TRUE;
        r22 = new com.larus.bmhome.actionbar.model.u(1, 15, "", r110, r111, r111, 0, 16);
    L50:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r21 = Result.constructor-impl(ResultKt.createFailure(th));
    L61:
        String r24 = r36.X3();
        z0 r25 = new z0(null, null, new g1(null, r24, null, null, 29), new g1(null, r24, null, null, 29), r2.getInputBoxTitle(), null, null, null, null, null, new com.larus.bmhome.actionbar.model.r(null, r16, new h1(r2.getInputPlaceholder(), null, r2.getInputPlaceholderPrompt(), null, null, 1018), null, null, null, null, null, 4089), null, false, null, null, -65565, 15);
        com.larus.bmhome.instruction.h r26 = (com.larus.bmhome.instruction.h) r36.q.getValue();
        if (r26 == null) goto L64;
        r26.h50(r25, 5, new aq8.e(null, null, null, null, null, true, null, null, null, null, 991), new com.larus.uaigc.spring.component.k(r36));
    L64:
        a0a.b r27 = r36.G3();
        if (r27 == null) goto L67;
        String r112 = r27.a();
    L68:
        a0a.b r28 = r36.G3();
        if (r28 == null) goto L71;
        String r29 = r28.b();
    L72:
        ClickPocketInfo r30 = r36.H;
        if (r30 == null) goto L77;
        Pocket r31 = r30.getPocket();
        if (r31 == null) goto L77;
        r6 = r31.getPocketId();
    L77:
        tx9.c0.H(null, "spring_guide_2026", r29, null, null, "spring_guide_2026", null, null, null, null, r112, null, null, 0, null, null, null, null, null, null, null, r6, null, 31456217);
        return;
    L71:
        r29 = null;
        goto L72
    L67:
        r112 = null;
        goto L68
    L38:
        r15 = 0;
        goto L39
    L19:
        if (Intrinsics.areEqual(r11, r37.getPocketType()) == true) goto L23;
        com.larus.bmhome.instruction.g r32 = r36.vc();
        if (r32 == null) goto L23;
        r32.A1();
    L15:
        r11 = null;
    L9:
        r8 = null;
        goto L10
    L78:
        r36.C3();
        zz9.d r33 = r36.Z3();
        if (r33 == null) goto L92;
        String r34 = r37.getPocketId();
        if (r34 == null) goto L84;
        r4 = r34;
    L84:
        Integer r35 = r37.getPocketType();
        if (r35 == null) goto L87;
        r0 = r35.intValue();
    L87:
        r33.W7(r4, 0, r0, "invalid_pocket");
        return;
    }

    public final String E3(Map<String, ? extends Object> r24, boolean r25, int r26, int r27) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L45
        zz9.a r1 = W3();     // Catch: Throwable -> L45
        if (r1 == null) goto L6;
        int r7 = r1.K7();     // Catch: Throwable -> L45
    L7:
        List r2 = IZLotteryService.a.e();     // Catch: Throwable -> L45
        ArrayList r14 = new ArrayList();     // Catch: Throwable -> L45
        if (r2 == null) goto L15;
        Iterator r3 = r2.iterator();     // Catch: Throwable -> L45
    L11:
        if (r3.hasNext() == false) goto L15;
        Integer r5 = ((hy9.g) r3.next()).d();     // Catch: Throwable -> L45
        if (r5 == null) goto L11;
        int r6 = r5.intValue();     // Catch: Throwable -> L45
        r14.add(new RoundInfo(r6, IZLotteryService.a.j(r6)));     // Catch: Throwable -> L45
    L15:
        Map<String, Object> r13 = a4();     // Catch: Throwable -> L45
        Object r4 = r13.get("z_main_enter");     // Catch: Throwable -> L45
        if (r4 != null) goto L18;
        r4 = 0;     // Catch: Throwable -> L45
    L18:
        int r8 = l3.e(r4, 0);     // Catch: Throwable -> L45
        String r9 = "1";
        if (r8 > 0) goto L22;
    L24:
        String r15 = "0";
    L26:
        if (IZLotteryService.a.v() == true) goto L29;
        r9 = "0";
    L29:
        FLogger.a.i("SpringMainVenueComponent", "[generateLynxPageDataJson] needShowLoading = " + r15 + ", sendMessageStatus = " + r9 + ", zMainEnterValue = " + r8);     // Catch: Throwable -> L45
        if (r24 != null) goto L32;
        Map<String, ? extends Object> r10 = MapsKt.emptyMap();     // Catch: Throwable -> L45
    L33:
        Map<String, Object> r12 = c4(r25);     // Catch: Throwable -> L45
        String r16 = String.valueOf(r26);     // Catch: Throwable -> L45
        String r17 = String.valueOf(r27);     // Catch: Throwable -> L45
        a0a.b r11 = G3();     // Catch: Throwable -> L45
        if (r11 == null) goto L42;
        Bundle r18 = r11.a;     // Catch: Throwable -> L45
        if (r18 == null) goto L38;
        String r19 = r18.getString("enter_schema");     // Catch: Throwable -> L45
    L39:
        if (r19 == null) goto L42;
        String r110 = r19;
    L43:
        Object r20 = Result.constructor-impl(((Gson) this.y.getValue()).toJson(new LynxPageData(r10, r7, 0, 0, r12, r13, r14, r16, r17, r15, r9, r110, 0, 4108, null)));     // Catch: Throwable -> L45
    L48:
        if (Result.isFailure-impl(r20) == false) goto L50;
        Object r21 = null;
    L51:
        String r22 = (String) r21;
        if (r22 != null) goto L55;
        return "";
    L55:
        return r22;
    L50:
        r21 = r20;
        goto L51
    L38:
        r19 = null;
    L42:
        r110 = "";
        goto L43
    L32:
        r10 = r24;
        goto L33
    L22:
        if (B3() == false) goto L24;
        r15 = "1";
        goto L26
    L6:
        r7 = 0;
    L45:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L48
    }

    public static final void m3(final SpringMainVenueLynxComponent r38, Pocket r39, Map r40, Map r41, boolean r42) {
        FLogger.a.i("SpringMainVenueComponent", "[pocketKeyboardInput] keyboardInputPocket = " + r39.getKeyboardInputPocket());
        KeyboardInputPocket r1 = r39.getKeyboardInputPocket();
        int r2 = -1;
        String r3 = "";
        if (r1 == null) goto L38;
        ClickPocketInfo r4 = r38.H;
        Integer r5 = null;
        if (r4 == null) goto L9;
        Pocket r6 = r4.getPocket();
        if (r6 == null) goto L9;
        String r7 = r6.getPocketId();
    L10:
        ClickPocketInfo r8 = r38.H;
        if (r8 == null) goto L16;
        Pocket r9 = r8.getPocket();
        if (r9 == null) goto L16;
        r5 = r9.getPocketType();
    L16:
        if (Intrinsics.areEqual(r7, r39.getPocketId()) == false) goto L18;
    L22:
        r38.h4(new ClickPocketInfo(r39, r40, r41, Boolean.valueOf(r42)));
        zz9.d r10 = r38.Z3();
        if (r10 == null) goto L31;
        String r11 = r39.getPocketId();
        if (r11 != null) goto L27;
        r11 = "";
    L27:
        Integer r12 = r39.getPocketType();
        if (r12 == null) goto L30;
        r2 = r12.intValue();
    L30:
        r10.W7(r11, 1, r2, "");
    L31:
        z8 r13 = (z8) r38.B.getValue();
        if (r13 == null) goto L34;
        r13.a9(true);
    L34:
        String r14 = r38.X3();
        z0 r15 = new z0(null, null, new g1(null, r14, null, null, 29), new g1(null, r14, null, null, 29), r1.getInputBoxTitle(), null, null, null, null, null, new com.larus.bmhome.actionbar.model.r(null, null, new h1(r1.getInputPlaceholder(), null, r1.getInputPlaceholderPrompt(), null, null, 1018), null, null, null, null, null, 4091), null, false, null, null, -65565, 15);
        com.larus.bmhome.instruction.h r16 = (com.larus.bmhome.instruction.h) r38.q.getValue();
        if (r16 == null) goto L37;
        r16.h50(r15, 5, new aq8.e(null, null, null, null, null, true, null, null, null, null, 991), new t(r38));
    L37:
        r38.V3().setActionBarInstructionInputSendReady(true);
        return;
    L18:
        if (Intrinsics.areEqual(r5, r39.getPocketType()) == true) goto L22;
        com.larus.bmhome.instruction.g r17 = r38.vc();
        if (r17 == null) goto L22;
        r17.A1();
    L9:
        r7 = null;
        goto L10
    L38:
        r38.C3();
        zz9.d r0 = r38.Z3();
        if (r0 == null) goto L50;
        String r18 = r39.getPocketId();
        if (r18 == null) goto L44;
        r3 = r18;
    L44:
        Integer r19 = r39.getPocketType();
        if (r19 == null) goto L47;
        r2 = r19.intValue();
    L47:
        r0.W7(r3, 0, r2, "invalid_pocket");
        return;
    }

    /* JADX WARN: Type inference failed for: r9v4, types: [com.larus.uaigc.spring.component.u] */
    public static final void p3(final SpringMainVenueLynxComponent r47, final Pocket r48, final Map r49, final Map r50, final boolean r51) {
        FLogger r0 = FLogger.a;
        r0.i("SpringMainVenueComponent", "[sendMessageWithPocket] sendMsgPocket = " + r48.getSendMsgPocket());
        SendMsgPocket r1 = r48.getSendMsgPocket();
        int r4 = -1;
        String r7 = "";
        if (r1 == null) goto L42;
        zz9.d r9 = r47.Z3();
        if (r9 == null) goto L14;
        String r11 = r48.getPocketId();
        if (r11 != null) goto L9;
        r11 = "";
    L9:
        Integer r12 = r48.getPocketType();
        if (r12 == null) goto L12;
        r4 = r12.intValue();
    L12:
        r9.W7(r11, 1, r4, "");
    L14:
        if (Intrinsics.areEqual(r1.getAllowPhotos(), Boolean.TRUE) == true) goto L16;
        com.larus.bmhome.instruction.g r2 = r47.vc();
        if (r2 == null) goto L27;
        r2.A1();
    L27:
        r47.h4(new ClickPocketInfo(r48, r49, r50, Boolean.valueOf(r51)));
        String r13 = r48.getPrompt();
        if (r13 == null) goto L41;
        a0a.b r3 = r47.G3();
        if (r3 == null) goto L35;
        String r5 = r3.b();
        if (r5 == null) goto L35;
        String r30 = r5;
    L36:
        ICoreInputAbility.OnSendParams r6 = new ICoreInputAbility.OnSendParams(r13, "", null, null, null, null, null, null, 8888, false, null, false, false, false, null, null, null, null, false, r30, null, null, null, null, null, null, null, null, null, null, null, null, null, -524608, 1, null);
        zz9.a r14 = r47.W3();
        if (r14 == null) goto L39;
        zz9.a.C0088a.a(r14, r6, "spring_guide_2026_sug", null, false, 12);
        Unit r8 = Unit.INSTANCE;
    L40:
        if (r8 == null) goto L41;
        return;
    L39:
        r8 = null;
    L35:
        r30 = "";
    L41:
        r0.e("SpringMainVenueComponent", "[sendWithOnSendParams] id = " + r48.getPocketId() + ", type = " + r48.getPocketType() + ", prompt is empty.");
        return;
    L16:
        if (r1.getSelectedPhotosCount() != null) goto L18;
        return;
    L18:
        if (r1.getSelectedPhotosCount().intValue() > 0) goto L20;
        return;
    L20:
        if (r1.getSelectedPhotosCount().intValue() <= 1) goto L22;
        final boolean r10 = true;
    L23:
        final Integer r15 = r1.getSelectedPhotosCount();
        final ?? r16 = new u(r47, r48, r49, r50, r51, r10, r15);
        k2 r17 = k2.a;
        Intrinsics.checkNotNullParameter(r47, "<this>");
        g3.a.a(com.larus.ui.arch.component.internal.attach.a.b(r47, r47), null, false, null, false, new m(r16), 30);
        return;
    L22:
        r10 = false;
        goto L23
    L42:
        zz9.d r18 = r47.Z3();
        if (r18 == null) goto L52;
        String r19 = r48.getPocketId();
        if (r19 == null) goto L48;
        r7 = r19;
    L48:
        Integer r20 = r48.getPocketType();
        if (r20 == null) goto L51;
        r4 = r20.intValue();
    L51:
        r18.W7(r7, 0, r4, "invalid_pocket");
    L52:
        r0.e("SpringMainVenueComponent", "[sendWithOnSendParams] id = " + r48.getPocketId() + ", type = " + r48.getPocketType() + ", sendMsgPocket is null.");
    }
}
