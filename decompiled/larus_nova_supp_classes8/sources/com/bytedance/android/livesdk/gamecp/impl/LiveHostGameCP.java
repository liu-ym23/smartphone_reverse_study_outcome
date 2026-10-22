package com.bytedance.android.livesdk.gamecp.impl;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.gamecp.base.core.service.depend.v;
import com.bytedance.android.gamecp.base.core.service.depend.w;
import com.bytedance.android.gamecp.base.core.service.depend.x;
import com.bytedance.android.gamecp.business.downloadview.DownloadUIView;
import com.bytedance.android.livehostapi.business.IHostGameCP;
import com.bytedance.android.livehostapi.business.depend.ISimpleCallback;
import com.bytedance.android.livehostapi.business.depend.gamecp.IAirCompressListener;
import com.bytedance.android.livehostapi.business.depend.gamecp.IDownloadedGameCallback;
import com.bytedance.android.livehostapi.business.depend.gamecp.IFlowTipsDialogListener;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameAutoDownloadResultCallback;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPDownloadView;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPFmpMonitorService;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPSelectImageCallback;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPTrackService;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPUploadImageCallback;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPWhiteBoxTestService;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCancelOrderResultCallback;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpGameService;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpLiveService;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameDownloadListener;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameJSBCallerListener;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameOrderResultCallback;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGamePlayCard;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGamePromoteRankSettingCallback;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameResDownloadListener;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameStatusResultCallback;
import com.bytedance.android.livehostapi.business.depend.gamecp.InstalledFinishData;
import com.bytedance.android.livehostapi.business.depend.gamecp.MediaModel;
import com.bytedance.android.livehostapi.business.depend.gamecp.ProgressData;
import com.bytedance.android.livehostapi.business.depend.gamecp.cloudgame.IGameCPCloudGameService;
import com.bytedance.android.livesdkapi.AppLifeCycleMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.openlive.AsyncInitHelper;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000Ü\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0017\u0018\u00002\u00020\u0001B\t¢\u0006\u0006\b®\u0001\u0010¯\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J(\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0016J \u0010!\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0016J(\u0010\"\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0016J\b\u0010#\u001a\u00020\u0010H\u0016J\u0010\u0010$\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u001fH\u0016J(\u0010'\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b\u0018\u00010%H\u0016J0\u0010)\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0%H\u0016J-\u0010-\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010+\u001a\u0004\u0018\u00010*2\b\u0010,\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b-\u0010.J-\u0010/\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010+\u001a\u0004\u0018\u00010*2\b\u0010,\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b/\u0010.J(\u00102\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010100H\u0016J\u001a\u00106\u001a\u00020\u00102\u0006\u00103\u001a\u00020\u001b2\b\u00105\u001a\u0004\u0018\u000104H\u0016J$\u00107\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u00103\u001a\u00020\u001b2\b\u00105\u001a\u0004\u0018\u000104H\u0016J\"\u0010:\u001a\u00020\u00102\u0006\u00103\u001a\u00020\u001b2\u0006\u00109\u001a\u0002082\b\u00105\u001a\u0004\u0018\u000104H\u0016J,\u0010<\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010;\u001a\u0002082\u0006\u00103\u001a\u00020\u001b2\b\u00105\u001a\u0004\u0018\u000104H\u0016J\u0012\u0010=\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J0\u0010@\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u000101002\u0006\u0010?\u001a\u00020>H\u0016J>\u0010F\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010B\u001a\u0004\u0018\u00010A2\b\u0010D\u001a\u0004\u0018\u00010C2\u0016\u0010E\u001a\u0012\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010%H\u0016J\b\u0010G\u001a\u000208H\u0016J\"\u0010J\u001a\u0002082\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010(\u001a\u00020H2\u0006\u0010?\u001a\u00020IH\u0016J$\u0010L\u001a\u0002082\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010(\u001a\u00020H2\b\u0010?\u001a\u0004\u0018\u00010KH\u0016J\u001a\u0010M\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010(\u001a\u00020HH\u0016J\"\u0010O\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010(\u001a\u00020H2\u0006\u00105\u001a\u00020NH\u0016J&\u0010M\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010P\u001a\u0004\u0018\u00010\u001b2\b\u0010Q\u001a\u0004\u0018\u00010\u001bH\u0016J4\u0010S\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010P\u001a\u0004\u0018\u00010\u001b2\b\u00109\u001a\u0004\u0018\u00010\u001b2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00120RH\u0016J\u001a\u0010T\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010(\u001a\u00020HH\u0016J\u001a\u0010U\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010(\u001a\u00020HH\u0016J\u001a\u0010V\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010(\u001a\u00020HH\u0016J6\u0010[\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0W\u0018\u00010Z2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\n0W2\u0006\u0010Y\u001a\u000208H\u0016J\u0010\u0010\\\u001a\u0002012\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J,\u0010_\u001a\u00020\u00102\u0006\u0010]\u001a\u0002082\u0006\u0010^\u001a\u00020\u001b2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0%H\u0016J4\u0010_\u001a\u00020\u00102\u0006\u0010]\u001a\u0002082\u0006\u0010^\u001a\u00020\u001b2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0%2\u0006\u0010`\u001a\u00020\u0012H\u0016J$\u0010a\u001a\u00020\u00102\u0006\u0010^\u001a\u00020\u001b2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0%H\u0016J\b\u0010b\u001a\u00020\u0010H\u0016J\u0010\u0010d\u001a\u00020\u00102\u0006\u0010c\u001a\u00020\u0012H\u0016J\u0010\u0010f\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010eH\u0016J\u0012\u0010h\u001a\u00020\u00122\b\u00105\u001a\u0004\u0018\u00010gH\u0016J\n\u0010i\u001a\u0004\u0018\u00010\u001bH\u0016J(\u0010n\u001a\u00020\u00102\u0006\u0010j\u001a\u00020\u001b2\u0006\u0010k\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010m\u001a\u00020lH\u0016J<\u0010q\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010P\u001a\u00020\u001b2\u0006\u0010o\u001a\u00020\u001b2\u0006\u0010Q\u001a\u00020\u001b2\b\u0010(\u001a\u0004\u0018\u00010l2\b\u00105\u001a\u0004\u0018\u00010pH\u0016J4\u0010t\u001a\u00020\u00102\u0006\u0010r\u001a\u00020\u00192\u0006\u0010P\u001a\u00020\u001b2\u0006\u0010Q\u001a\u00020\u001b2\b\u0010(\u001a\u0004\u0018\u00010l2\b\u0010?\u001a\u0004\u0018\u00010sH\u0016J\"\u0010v\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010(\u001a\u00020l2\b\u00105\u001a\u0004\u0018\u00010uH\u0016J(\u0010y\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00192\f\u0010w\u001a\b\u0012\u0004\u0012\u00020l0W2\b\u00105\u001a\u0004\u0018\u00010xH\u0016J$\u0010{\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010(\u001a\u0004\u0018\u00010l2\b\u00105\u001a\u0004\u0018\u00010zH\u0016J\b\u0010}\u001a\u00020|H\u0016J\b\u0010\u007f\u001a\u00020~H\u0016J\f\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0080\u0001H\u0016J\t\u0010\u0082\u0001\u001a\u00020\u0012H\u0016J\"\u0010\u0084\u0001\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010P\u001a\u00020\u001b2\u0007\u00105\u001a\u00030\u0083\u0001H\u0016J\t\u0010\u0085\u0001\u001a\u00020\u0012H\u0016J\n\u0010\u0087\u0001\u001a\u00030\u0086\u0001H\u0016J\n\u0010\u0089\u0001\u001a\u00030\u0088\u0001H\u0016J\f\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008a\u0001H\u0016J\u0013\u0010\u008c\u0001\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\f\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008d\u0001H\u0016J\u0012\u0010\u0090\u0001\u001a\u000b\u0012\u0004\u0012\u000201\u0018\u00010\u008f\u0001H\u0016J\u000b\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u001bH\u0016J'\u0010\u0094\u0001\u001a\u00020\u00102\b\u0010P\u001a\u0004\u0018\u00010\u001b2\t\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u001b2\u0007\u0010?\u001a\u00030\u0093\u0001H\u0016J\u0013\u0010\u0095\u0001\u001a\u00020\u00122\b\u0010P\u001a\u0004\u0018\u00010\u001bH\u0016J\u0013\u0010\u0096\u0001\u001a\u00020\u00122\b\u0010P\u001a\u0004\u0018\u00010\u001bH\u0016J\u0013\u0010\u0097\u0001\u001a\u00020\u00102\b\u0010P\u001a\u0004\u0018\u00010\u001bH\u0016J\t\u0010\u0098\u0001\u001a\u00020\u0010H\u0016J,\u0010\u009a\u0001\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0007\u0010\u0099\u0001\u001a\u0002082\u0006\u0010\u001d\u001a\u00020\u001bH\u0016J\f\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009b\u0001H\u0016J\u0012\u0010\u009e\u0001\u001a\u00020\u00102\u0007\u0010\u009d\u0001\u001a\u00020\u0012H\u0016J\u0015\u0010¡\u0001\u001a\u0004\u0018\u0001012\b\u0010 \u0001\u001a\u00030\u009f\u0001H\u0016R\u001b\u0010¢\u0001\u001a\u0004\u0018\u00010|8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R\u001c\u0010¤\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0001\u0010¥\u0001R\u001b\u0010¦\u0001\u001a\u0004\u0018\u00010~8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¦\u0001\u0010§\u0001R\u001c\u0010¨\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R\u001c\u0010ª\u0001\u001a\u0005\u0018\u00010\u008a\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0001\u0010«\u0001R\u001c\u0010¬\u0001\u001a\u0005\u0018\u00010\u008d\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0001\u0010\u00ad\u0001¨\u0006°\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/gamecp/impl/LiveHostGameCP;", "Lcom/bytedance/android/livehostapi/business/IHostGameCP;", "Lcom/bytedance/android/gamecp/base/core/service/depend/x;", "progressData", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/ProgressData;", "convertProgressData", "Lcom/bytedance/android/gamecp/base/core/service/depend/v;", "installedFinishData", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/InstalledFinishData;", "convertInstalledFinishData", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/MediaModel;", "liveMediaModel", "Lcom/bytedance/android/gamecp/base/core/service/depend/w;", "convertMediaModel2GameCP", "gameCpMediaMode", "convertMediaModel2Live", "", "init", "", "hasInit", "isAppBackground", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", "onAnchorCreatedRoom", "onAnchorExitRoom", "Landroid/content/Context;", "context", "", "uniqueKey", "source", "onRoomEnter", "", "roomId", "onRoomExit", "onLoadAiPredictor", "stopAiPredictorTimer", "onUnloadAiPredictor", "", "trackParams", "showIntroDialog", "params", "showPromoteListDialog", "Landroid/os/Bundle;", "arguments", "isAnchor", "showGamePromoteDetailDialog", "(Landroid/content/Context;Landroid/os/Bundle;Ljava/lang/Boolean;)V", "showGameOrderDetailDialog", "", "", "showPropsDetailDialog", "from", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGamePromoteRankSettingCallback;", "callback", "getGamePromoteRankSetting", "showGamePromoteRankSetting", "", "status", "setGamePromoteRankSetting", "curItemValue", "showGamePromoteRankSettingDy", "openGameCPPlayerRankInstruction", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameJSBCallerListener;", "listener", "bindTencentRoleInTest", "Landroid/net/Uri;", "uri", "Landroid/view/View;", "view", "queryItems", "handleHttpSchema", "getDownloadToken", "Lcom/google/gson/JsonObject;", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameResDownloadListener;", "subscribeDownloadGameRes", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameDownloadListener;", "subscribeDownloadGame", "downloadGameAction", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IFlowTipsDialogListener;", "downloadGameResAction", "gameId", "enterFrom", "Lcom/bytedance/android/livehostapi/business/depend/ISimpleCallback;", "hasDownloadRecord", "unsubscribeDownloadGame", "unsubscribeDownloadGameRes", "cancelDownloadGame", "", "selected", "selectNumber", "Lio/reactivex/Observable;", "selectImages", "getLynxNestRecyclerView", "scene", "eventName", "logMonitorLinkEvent", "useParamPassing", "dataChannelLinkEvent", "clearLivePromoteIconShowStatus", "show", "livePromoteIconShowChange", "", "getDownloadingGames", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IDownloadedGameCallback;", "getHasDownloadedGame", "getDownloadedGameIconUri", "label", "refer", "Lorg/json/JSONObject;", "adExtraData", "sendAdLog", "gameName", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameOrderResultCallback;", "orderGame", "ctx", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCancelOrderResultCallback;", "cancelOrderGame", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCPSelectImageCallback;", "openAlbum", "list", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCPUploadImageCallback;", "uploadImage", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameAutoDownloadResultCallback;", "autoDownloadWhenOnline", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCPTrackService;", "getTrackService", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCPWhiteBoxTestService;", "getWhiteBoxTestService", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCPDownloadView;", "createGameCPDownload", "interceptLiveFloatWindow", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameStatusResultCallback;", "getGameDownloadStatus", "hasGamePromoteDialogShow", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/cloudgame/IGameCPCloudGameService;", "getCloudGameService", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCpLiveService;", "getGameCpLiveService", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCpGameService;", "getGameService", "onAnchorRoomContextCreated", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCPFmpMonitorService;", "getGameCPFmpMonitorService", "", "getBehaviorList", "getGameCpSdkVersion", "filePath", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IAirCompressListener;", "registerAirCompressListener", "isSupportAirCompress", "isRestoreFailed", "unregisterAirCompressListener", "checkInstallFailPushTips", "uniqueCode", "onWidgetLoaded", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGamePlayCard;", "createGamePlayCard", "degrade", "inDegradeScene", "Lcom/bytedance/live/kmp/core/a;", "liveRoomInstance", "createGameCpInstance", "mTrackService", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCPTrackService;", "mCloudGameService", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/cloudgame/IGameCPCloudGameService;", "mWhiteBoxTestService", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCPWhiteBoxTestService;", "mGameCpLiveService", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCpLiveService;", "mGameCpGameService", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCpGameService;", "mGameCPFmpMonitorService", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCPFmpMonitorService;", "<init>", "()V", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public class LiveHostGameCP implements IHostGameCP {
    private IGameCPCloudGameService mCloudGameService;
    private IGameCPFmpMonitorService mGameCPFmpMonitorService;
    private IGameCpGameService mGameCpGameService;
    private IGameCpLiveService mGameCpLiveService;
    private IGameCPTrackService mTrackService;
    private IGameCPWhiteBoxTestService mWhiteBoxTestService;

    public void bindTencentRoleInTest(Context r1, Map<String, Object> r2, IGameJSBCallerListener r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "listener");
    }

    public Object createGameCpInstance(com.bytedance.live.kmp.core.a r2) {
        Intrinsics.checkNotNullParameter(r2, "liveRoomInstance");
        return null;
    }

    public IGamePlayCard createGamePlayCard() {
        return null;
    }

    public boolean handleHttpSchema(Context r1, Uri r2, View r3, Map<String, String> r4) {
        return false;
    }

    public IGameCPCloudGameService getCloudGameService() {
        if (this.mCloudGameService != null) goto L5;
        this.mCloudGameService = new a();
    L5:
        IGameCPCloudGameService r0 = this.mCloudGameService;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public IGameCPFmpMonitorService getGameCPFmpMonitorService() {
        if (this.mGameCPFmpMonitorService != null) goto L5;
        this.mGameCPFmpMonitorService = new c();
    L5:
        IGameCPFmpMonitorService r0 = this.mGameCPFmpMonitorService;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public IGameCpLiveService getGameCpLiveService() {
        if (this.mGameCpLiveService != null) goto L5;
        this.mGameCpLiveService = new g();
    L5:
        IGameCpLiveService r0 = this.mGameCpLiveService;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public IGameCpGameService getGameService() {
        if (this.mGameCpGameService != null) goto L5;
        this.mGameCpGameService = new f();
    L5:
        IGameCpGameService r0 = this.mGameCpGameService;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public IGameCPTrackService getTrackService() {
        if (this.mTrackService != null) goto L5;
        this.mTrackService = new d();
    L5:
        IGameCPTrackService r0 = this.mTrackService;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public IGameCPWhiteBoxTestService getWhiteBoxTestService() {
        if (this.mWhiteBoxTestService != null) goto L5;
        this.mWhiteBoxTestService = new e();
    L5:
        IGameCPWhiteBoxTestService r0 = this.mWhiteBoxTestService;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public boolean hasInit() {
        boolean r0 = com.bytedance.android.livesdk.gamecp.b.a;
        return com.bytedance.android.livesdk.gamecp.b.a;
    }

    public boolean isAppBackground() {
        return AppLifeCycleMonitor.INSTANCE.isAppBackground();
    }

    public LiveHostGameCP() {
        jc1.k.l(IHostGameCP.class, this);
        AsyncInitHelper.postNormalTask("GameCPInit", AnonymousClass1.INSTANCE);
    }

    public void checkInstallFailPushTips() {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L6;
        r0.checkInstallFailPushTips();
        return;
    }

    public void clearLivePromoteIconShowStatus() {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L6;
        r0.clearLivePromoteIconShowStatus();
        return;
    }

    public IGameCPDownloadView createGameCPDownload() {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L9;
        DownloadUIView r1 = r0.createGameCPDownload();
        if (r1 != null) goto L8;
        return null;
    L8:
        return new b(r1);
    L9:
        return null;
    }

    public List<Object> getBehaviorList() {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getBehaviorList();
    }

    public int getDownloadToken() {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.genDownloadToken();
    }

    public String getDownloadedGameIconUri() {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDownloadedGameIconUri();
    }

    public Set<String> getDownloadingGames() {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDownloadingGames();
    }

    public String getGameCpSdkVersion() {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getGameCpSdkVersion();
    }

    public boolean hasGamePromoteDialogShow() {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.p0();
    }

    public void init() {
        com.bytedance.android.livesdk.gamecp.b.a();
        boolean r0 = com.bytedance.android.livesdk.gamecp.b.a;
        xr.f r1 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r1 == null) goto L6;
        r1.initJsBridge();
        return;
    }

    public boolean interceptLiveFloatWindow() {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.interceptLiveFloatWindow();
    }

    public void onAnchorExitRoom() {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L6;
        r0.onAnchorExitRoom();
        return;
    }

    public void stopAiPredictorTimer() {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L6;
        r0.stopAiPredictorTimer();
        return;
    }

    private final InstalledFinishData convertInstalledFinishData(v r3) {
        return new InstalledFinishData(r3.a, r3.b);
    }

    private final w convertMediaModel2GameCP(MediaModel r4) {
        w r0 = new w(r4.getId());
        r0.f = r4.getCompressPath();
        r0.j = r4.getDate();
        r0.v = r4.getDateToken();
        r0.l = r4.getDuration();
        r0.x = r4.getEndTime();
        r0.z = r4.getExtraInfo();
        r0.e = r4.getFileLocalUriPath();
        r0.i = r4.getFileName();
        r0.m = r4.getFileSize();
        r0.q = r4.getHeight();
        r0.r = r4.getLatitude();
        r0.s = r4.getLongitude();
        r0.n = r4.getMimeType();
        r0.t = r4.getModify();
        r0.u = r4.getOrientation();
        r0.h = r4.getRelativePath();
        r0.c = r4.getSelectIndex();
        r0.d = r4.getSelectPosition();
        r0.b = r4.getSelectState();
        r0.y = r4.getSpeed();
        r0.w = r4.getStartTime();
        r0.o = r4.getThumbnail();
        r0.k = r4.getType();
        r0.g = r4.getUri();
        r0.p = r4.getWidth();
        return r0;
    }

    private final MediaModel convertMediaModel2Live(w r4) {
        MediaModel r0 = new MediaModel(r4.A);
        r0.setCompressPath(r4.f);
        r0.setDate(r4.j);
        r0.setDateToken(r4.v);
        r0.setDuration(r4.l);
        r0.setEndTime(r4.x);
        r0.setExtraInfo(r4.z);
        r0.setFileLocalUriPath(r4.e);
        r0.setFileName(r4.i);
        r0.setFileSize(r4.m);
        r0.setHeight(r4.q);
        r0.setLatitude(r4.r);
        r0.setLongitude(r4.s);
        r0.setMimeType(r4.n);
        r0.setModify(r4.t);
        r0.setOrientation(r4.u);
        r0.setRelativePath(r4.h);
        r0.setSelectIndex(r4.c);
        r0.setSelectPosition(r4.d);
        r0.setSelectState(r4.b);
        r0.setSpeed(r4.y);
        r0.setStartTime(r4.w);
        r0.setThumbnail(r4.o);
        r0.setType(r4.getType());
        r0.setUri(r4.g);
        r0.setWidth(r4.p);
        return r0;
    }

    private final ProgressData convertProgressData(x r15) {
        int r1 = r15.a;
        int r3 = r15.c;
        return new ProgressData(r1, r15.b, r3, r15.d, r15.e, r15.f, r15.g, r15.h, r15.i, r15.k);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.bytedance.android.livesdk.gamecp.impl.LiveHostGameCP$getHasDownloadedGame$1] */
    public boolean getHasDownloadedGame(final IDownloadedGameCallback r3) {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.L(new C04491(r3));
    }

    public Object getLynxNestRecyclerView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L7;
        RecyclerView r1 = r0.getLynxNestRecyclerView(r2);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new RecyclerView(r2);
    }

    public void inDegradeScene(boolean r2) {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L6;
        r0.inDegradeScene(r2);
        return;
    }

    public boolean isRestoreFailed(String r2) {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isRestoreFailed(r2);
    }

    public boolean isSupportAirCompress(String r2) {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isSupportAirCompress(r2);
    }

    public void livePromoteIconShowChange(boolean r2) {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L6;
        r0.livePromoteIconShowChange(r2);
        return;
    }

    public void onAnchorCreatedRoom(Room r4) {
        Intrinsics.checkNotNullParameter(r4, "room");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L6;
        r0.n0(r4.getRoomId());
        return;
    }

    public void onAnchorRoomContextCreated(Room r4) {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L12;
        if (r4 == null) goto L6;
        long r1 = r4.getRoomId();
    L7:
        if (r4 == null) goto L9;
        String r5 = r4.getAnchorId();
    L10:
        r0.G(r1, r5);
        return;
    L9:
        r5 = null;
        goto L10
    L6:
        r1 = 0;
        goto L7
    }

    public void onUnloadAiPredictor(long r2) {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L6;
        r0.onUnloadAiPredictor(r2);
        return;
    }

    public void openGameCPPlayerRankInstruction(Context r2) {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L6;
        r0.openGameCPPlayerRankInstruction(r2);
        return;
    }

    public void unregisterAirCompressListener(String r2) {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L6;
        r0.unregisterAirCompressListener(r2);
        return;
    }

    public static final /* synthetic */ InstalledFinishData access$convertInstalledFinishData(LiveHostGameCP r0, v r1) {
        return r0.convertInstalledFinishData(r1);
    }

    public static final /* synthetic */ MediaModel access$convertMediaModel2Live(LiveHostGameCP r0, w r1) {
        return r0.convertMediaModel2Live(r1);
    }

    public static final /* synthetic */ ProgressData access$convertProgressData(LiveHostGameCP r0, x r1) {
        return r0.convertProgressData(r1);
    }

    public void cancelDownloadGame(Context r2, JsonObject r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L6;
        r0.cancelDownloadGame(r2, r3);
        return;
    }

    public void dataChannelLinkEvent(String r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "params");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L6;
        r0.dataChannelLinkEvent(r2, r3);
        return;
    }

    public void downloadGameAction(Context r3, JsonObject r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.b r1 = r0.p1();
        if (r1 == null) goto L9;
        r1.X0(r3, r4, null);
        return;
    L9:
        return;
    }

    public void getGamePromoteRankSetting(String r3, final IGamePromoteRankSettingCallback r4) {
        Intrinsics.checkNotNullParameter(r3, "from");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L6;
        r0.Z(r3, new C04481(r4));
        return;
    }

    public void showIntroDialog(Context r2, Map<String, String> r3) {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L6;
        r0.showIntroDialog(r2, r3);
        return;
    }

    public void showPropsDetailDialog(Context r2, Map<String, Object> r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L6;
        r0.showPropsDetailDialog(r2, r3);
        return;
    }

    public void unsubscribeDownloadGame(Context r1, JsonObject r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        xr.f r3 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r3 == null) goto L6;
        r3.N0(r2);
        return;
    }

    public void unsubscribeDownloadGameRes(Context r1, JsonObject r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        xr.f r3 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r3 == null) goto L6;
        r3.v2(r2);
        return;
    }

    public void autoDownloadWhenOnline(Context r3, JSONObject r4, final IGameAutoDownloadResultCallback r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L6;
        r0.W1(r3, r4, new C04441(r5));
        return;
    }

    public void downloadGameAction(Context r3, String r4, String r5) {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.b r1 = r0.p1();
        if (r1 == null) goto L9;
        r1.j1(r3, r4, r5, 1);
        return;
    L9:
        return;
    }

    public void downloadGameResAction(Context r3, JsonObject r4, final IFlowTipsDialogListener r5) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "callback");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L6;
        r0.q0(r3, r4, new C04461(r5));
        return;
    }

    public void getGameDownloadStatus(Context r3, String r4, final IGameStatusResultCallback r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "gameId");
        Intrinsics.checkNotNullParameter(r5, "callback");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L6;
        r0.g2(r3, r4, new C04471(r5));
        return;
    }

    public void logMonitorLinkEvent(int r3, String r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r4, "eventName");
        Intrinsics.checkNotNullParameter(r5, "params");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L6;
        r0.logMonitorLinkEvent(r3, r4, r5, true);
        return;
    }

    public void onRoomExit(long r2, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "uniqueKey");
        Intrinsics.checkNotNullParameter(r5, "source");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L6;
        r0.onRoomExit(r2, r4, r5);
        return;
    }

    public void openAlbum(Context r3, JSONObject r4, final IGameCPSelectImageCallback r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "params");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L6;
        r0.R1(r3, r4, new C04511(r5));
        return;
    }

    public void registerAirCompressListener(String r3, String r4, final IAirCompressListener r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L6;
        r0.y2(r3, r4, new C04531(r5));
        return;
    }

    public Observable<List<MediaModel>> selectImages(Context r3, List<? extends MediaModel> r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "selected");
        ArrayList r0 = new ArrayList();
        Iterator<? extends MediaModel> r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r0.add(convertMediaModel2GameCP(r6.next()));
        goto L4
    L6:
        xr.f r7 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r7 == null) goto L11;
        Observable r8 = r7.selectImages(r3, r0, r5);
        if (r8 == null) goto L11;
        return r8.map(new C04541(this));
    L11:
        return null;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.bytedance.android.livesdk.gamecp.impl.LiveHostGameCP$setGamePromoteRankSetting$1] */
    public void setGamePromoteRankSetting(String r3, int r4, final IGamePromoteRankSettingCallback r5) {
        Intrinsics.checkNotNullParameter(r3, "from");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L6;
        r0.t2(r3, r4, new C04551(r5));
        return;
    }

    public void showGameOrderDetailDialog(Context r2, Bundle r3, Boolean r4) {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L6;
        r0.showGameOrderDetailDialog(r2, r3, r4);
        return;
    }

    public void showGamePromoteDetailDialog(Context r2, Bundle r3, Boolean r4) {
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L6;
        r0.showGamePromoteDetailDialog(r2, r3, r4);
        return;
    }

    public void showGamePromoteRankSetting(Context r3, String r4, final IGamePromoteRankSettingCallback r5) {
        Intrinsics.checkNotNullParameter(r4, "from");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L6;
        r0.d1(r3, r4, new C04561(r5));
        return;
    }

    public void showPromoteListDialog(Context r2, Room r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L6;
        r0.E1(r2, com.bytedance.android.livesdk.gamecp.utils.b.b(r3), r4);
        return;
    }

    public int subscribeDownloadGame(Context r2, JsonObject r3, final IGameDownloadListener r4) {
        Intrinsics.checkNotNullParameter(r3, "params");
        xr.f r5 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.C1(r3, new C04581(this, r4));
    }

    public int subscribeDownloadGameRes(Context r2, JsonObject r3, final IGameResDownloadListener r4) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "listener");
        xr.f r5 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.T(r3, new C04591(this, r4));
    }

    public void uploadImage(Context r3, List<? extends JSONObject> r4, final IGameCPUploadImageCallback r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "list");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L6;
        r0.u0(r3, r4, new C04601(r5));
        return;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.bytedance.android.livesdk.gamecp.impl.LiveHostGameCP$hasDownloadRecord$1] */
    public void hasDownloadRecord(Context r3, String r4, String r5, final ISimpleCallback<Boolean> r6) {
        Intrinsics.checkNotNullParameter(r6, "callback");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L8;
        xr.b r1 = r0.p1();
        if (r1 == null) goto L9;
        r1.F0(r3, r4, r5, new C04501(r6));
        return;
    L9:
        return;
    }

    public void logMonitorLinkEvent(int r2, String r3, Map<String, String> r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "params");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L6;
        r0.logMonitorLinkEvent(r2, r3, r4, r5);
        return;
    }

    public void onLoadAiPredictor(Context r8, long r9, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r11, "uniqueKey");
        Intrinsics.checkNotNullParameter(r12, "source");
        xr.f r1 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r1 == null) goto L6;
        r1.onLoadAiPredictor(r8, r9, r11, r12);
        return;
    }

    public void onRoomEnter(Context r9, Room r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "room");
        Intrinsics.checkNotNullParameter(r11, "uniqueKey");
        Intrinsics.checkNotNullParameter(r12, "source");
        xr.f r1 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r1 == null) goto L6;
        r1.onRoomEnter(r9, r10.getRoomId(), r10.getAnchorId(), r11, r12);
        return;
    }

    public void onWidgetLoaded(Context r10, Room r11, int r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r13, "source");
        if (r11 == null) goto L5;
        long r0 = r11.getRoomId();
    L6:
        long r4 = r0;
        StringBuilder r1 = new StringBuilder();
        r1.append(r4);
        r1.append('_');
        r1.append(r12);
        String r6 = r1.toString();
        xr.f r2 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r2 == null) goto L15;
        if (r11 != null) goto L10;
    L12:
        boolean r8 = false;
    L13:
        r2.l2(r10, r4, r6, r13, r8);
        return;
    L10:
        if (r11.isGameRoom() != 1) goto L12;
        r8 = true;
        goto L13
    L15:
        return;
    L5:
        r0 = 0;
        goto L6
    }

    public void sendAdLog(String r8, String r9, long r10, JSONObject r12) {
        Intrinsics.checkNotNullParameter(r8, "label");
        Intrinsics.checkNotNullParameter(r9, "refer");
        Intrinsics.checkNotNullParameter(r12, "adExtraData");
        xr.f r1 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r1 == null) goto L6;
        r1.sendAdLog(r8, r9, r10, r12);
        return;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.bytedance.android.livesdk.gamecp.impl.LiveHostGameCP$showGamePromoteRankSettingDy$1] */
    public void showGamePromoteRankSettingDy(Context r3, int r4, String r5, final IGamePromoteRankSettingCallback r6) {
        Intrinsics.checkNotNullParameter(r5, "from");
        xr.f r0 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r0 == null) goto L6;
        r0.n(r3, r4, r5, new C04571(r6));
        return;
    }

    public void cancelOrderGame(Context r8, String r9, String r10, JSONObject r11, final IGameCancelOrderResultCallback r12) {
        Intrinsics.checkNotNullParameter(r8, "ctx");
        Intrinsics.checkNotNullParameter(r9, "gameId");
        Intrinsics.checkNotNullParameter(r10, "enterFrom");
        xr.f r1 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r1 == null) goto L6;
        r1.r0(r8, r9, r10, r11, new C04451(r12));
        return;
    }

    public void orderGame(Context r9, String r10, String r11, String r12, JSONObject r13, final IGameOrderResultCallback r14) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "gameId");
        Intrinsics.checkNotNullParameter(r11, "gameName");
        Intrinsics.checkNotNullParameter(r12, "enterFrom");
        xr.f r1 = com.bytedance.android.livesdk.gamecp.b.a();
        if (r1 == null) goto L6;
        r1.O1(r9, r10, r11, r12, r13, new C04521(r14));
        return;
    }
}
