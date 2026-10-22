package com.bytedance.android.livesdk.ktvapi;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkMatchType;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.s0;
import com.bytedance.android.live.pushstream.d;
import com.bytedance.android.live.utility.ServiceDummyLookup;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.action.BaseActionMethod;
import com.bytedance.android.livesdk.chatroom.ui.g5;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.ktvapi.config.ScrollLyricConfigV2;
import com.bytedance.android.livesdk.ktvapi.model.mv.e;
import com.bytedance.android.livesdk.ktvapi.model.mv.j;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.message.linker.h;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.za;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerChangeMediaInfoContent;
import com.bytedance.android.livesdkapi.feed.IInteractFeedView;
import com.bytedance.android.livesdkapi.ktv.IKtvComponentFeedView;
import com.bytedance.android.livesdkapi.ktv.IKtvComponentFeedViewService;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.google.gson.JsonObject;
import fd2.f;
import fd2.g;
import fd2.i;
import fd2.l;
import fd2.q;
import fd2.v;
import fd2.w;
import fd2.x;
import fd2.y;
import fd2.z;
import gd2.c;
import hh1.w0;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import tf0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ServiceLookup("com.bytedance.android.livesdk.ktvimpl.base.KtvService")
@Metadata(d1 = {"\u0000\u0080\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\bg\u0018\u0000 ç\u00022\u00020\u0001:\u0002è\u0002J\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0010\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH&J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\u0015H&J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001b\u001a\u00020\rH&J(\u0010\u001f\u001a\"\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cj\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0018\u0001`\u001eH&J\u0010\u0010\"\u001a\u00020 2\u0006\u0010!\u001a\u00020 H&J\b\u0010#\u001a\u00020\u0011H&J\u0010\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010$H&J\u001a\u0010(\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u00010&H&J\u001a\u0010)\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u00010&H&J\u001a\u0010-\u001a\u00020\r2\b\u0010*\u001a\u0004\u0018\u00010\u001d2\u0006\u0010,\u001a\u00020+H&J\u0010\u0010/\u001a\u00020\r2\u0006\u0010.\u001a\u00020\u001dH&J\u0012\u00102\u001a\u00020\r2\b\u00101\u001a\u0004\u0018\u000100H&J\u0012\u00104\u001a\u00020\r2\b\u00103\u001a\u0004\u0018\u000100H\u0016J\n\u00106\u001a\u0004\u0018\u000105H&J\u0018\u0010:\u001a\n\u0012\u0004\u0012\u000209\u0018\u0001082\u0006\u00107\u001a\u00020\u001dH&J\u0018\u0010?\u001a\n\u0012\u0006\b\u0001\u0012\u00020>0=2\u0006\u0010<\u001a\u00020;H&J&\u0010E\u001a\u0004\u0018\u00010D2\u0006\u00103\u001a\u00020@2\u0006\u0010A\u001a\u00020\u00132\n\b\u0002\u0010C\u001a\u0004\u0018\u00010BH\u0016J\n\u0010G\u001a\u0004\u0018\u00010FH&J\b\u0010H\u001a\u00020\u0011H&J\u0018\u0010J\u001a\u00020\r2\u0006\u00103\u001a\u00020@2\u0006\u0010I\u001a\u00020\u001dH&J\u0010\u0010K\u001a\u00020\r2\u0006\u00103\u001a\u00020@H&J\b\u0010L\u001a\u00020\rH&J\u001e\u0010M\u001a\u00020\r2\b\u0010.\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u00103\u001a\u0004\u0018\u00010@H&J\u0010\u0010P\u001a\u00020\r2\u0006\u0010O\u001a\u00020NH&J0\u0010T\u001a\u00020\r2\b\u00103\u001a\u0004\u0018\u00010@2\b\u0010Q\u001a\u0004\u0018\u00010\u001d2\b\u0010R\u001a\u0004\u0018\u00010\u001d2\b\u0010S\u001a\u0004\u0018\u00010\u001dH&J(\u0010X\u001a\u00020\r2\u0006\u0010S\u001a\u00020\u001d2\u0006\u0010U\u001a\u00020\u001d2\u0006\u0010V\u001a\u00020\u001d2\u0006\u0010W\u001a\u00020\u001dH&J(\u0010Y\u001a\u00020\r2\u0006\u0010S\u001a\u00020\u001d2\u0006\u0010U\u001a\u00020\u001d2\u0006\u0010V\u001a\u00020\u001d2\u0006\u0010W\u001a\u00020\u001dH&J\u0010\u0010\\\u001a\u00020\r2\u0006\u0010[\u001a\u00020ZH&J#\u0010`\u001a\u00020\r2\b\u0010^\u001a\u0004\u0018\u00010]2\b\u0010_\u001a\u0004\u0018\u00010\u0013H&¢\u0006\u0004\b`\u0010aJ\n\u0010c\u001a\u0004\u0018\u00010bH&J\"\u0010f\u001a\u00020\r2\u0006\u00103\u001a\u00020@2\u0006\u0010e\u001a\u00020d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&J\b\u0010g\u001a\u00020\rH&J\n\u0010i\u001a\u0004\u0018\u00010hH&J\n\u0010k\u001a\u0004\u0018\u00010jH&J\u0010\u0010m\u001a\u00020\r2\u0006\u0010l\u001a\u00020\u001dH&J\u0012\u0010p\u001a\u0004\u0018\u00010o2\u0006\u0010n\u001a\u00020\u0011H&J\n\u0010q\u001a\u0004\u0018\u00010oH&J\b\u0010r\u001a\u00020\u001dH&J\b\u0010s\u001a\u00020\u0011H&J\u0010\u0010v\u001a\u00020\r2\u0006\u0010u\u001a\u00020tH&J$\u0010y\u001a\u0004\u0018\u00010x2\b\u00103\u001a\u0004\u0018\u00010@2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010w\u001a\u00020\u0013H&J,\u0010y\u001a\u0004\u0018\u00010x2\u0006\u0010{\u001a\u00020z2\b\u00103\u001a\u0004\u0018\u00010@2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010w\u001a\u00020\u0013H&J\u001c\u0010|\u001a\u0004\u0018\u00010x2\b\u00103\u001a\u0004\u0018\u00010@2\u0006\u0010w\u001a\u00020\u0013H&J\n\u0010}\u001a\u0004\u0018\u000100H&J\b\u0010~\u001a\u00020\u0013H&J\u0014\u0010\u0081\u0001\u001a\u00020\r2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u007fH&J@\u0010\u0089\u0001\u001a\u00020\r2\u0007\u0010\u0082\u0001\u001a\u00020\u00132\u0007\u0010\u0083\u0001\u001a\u00020\u001d2\u0007\u0010\u0084\u0001\u001a\u00020\u00132\b\u0010\u0086\u0001\u001a\u00030\u0085\u00012\u0007\u0010\u0087\u0001\u001a\u00020\u001d2\u0007\u0010\u0088\u0001\u001a\u00020\u001dH&J+\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008d\u00012\u0006\u0010S\u001a\u00020\u001d2\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008a\u00012\t\b\u0002\u0010\u008c\u0001\u001a\u00020\u0011H&J\u0012\u0010\u0090\u0001\u001a\u00020\r2\u0007\u0010\u008f\u0001\u001a\u00020\u001dH&J\t\u0010\u0091\u0001\u001a\u00020\u0011H&J\u001e\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0092\u00012\b\u00103\u001a\u0004\u0018\u00010@2\u0006\u0010\u0012\u001a\u00020\u0011H&J\t\u0010\u0094\u0001\u001a\u00020\u0011H&J\t\u0010\u0095\u0001\u001a\u00020\u0011H&J\u0012\u0010\u0097\u0001\u001a\u00020\r2\u0007\u0010\u0096\u0001\u001a\u00020NH&J\u0013\u0010\u009a\u0001\u001a\u00030\u0099\u00012\u0007\u0010\u0098\u0001\u001a\u00020\u001dH&J\t\u0010\u009b\u0001\u001a\u00020\u0011H&J\t\u0010\u009c\u0001\u001a\u00020\u0011H&J\u0013\u0010\u009f\u0001\u001a\f\u0012\u0005\u0012\u00030\u009e\u0001\u0018\u00010\u009d\u0001H&J\u0013\u0010 \u0001\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&J\t\u0010¡\u0001\u001a\u00020\u0011H&J\t\u0010¢\u0001\u001a\u00020\u0011H&J\t\u0010£\u0001\u001a\u00020\u0011H&J\u0010\u0010¤\u0001\u001a\t\u0012\u0002\b\u0003\u0018\u00010\u009d\u0001H&J\u0010\u0010¥\u0001\u001a\t\u0012\u0002\b\u0003\u0018\u00010\u009d\u0001H&J\f\u0010§\u0001\u001a\u0005\u0018\u00010¦\u0001H&J\u0010\u0010¨\u0001\u001a\t\u0012\u0002\b\u0003\u0018\u00010\u009d\u0001H&J\u0010\u0010©\u0001\u001a\t\u0012\u0002\b\u0003\u0018\u00010\u009d\u0001H&J\u001a\u0010¬\u0001\u001a\n\u0012\u0005\u0012\u00030«\u00010ª\u00012\u0007\u0010\u008f\u0001\u001a\u00020\u001dH&J\u0012\u0010\u00ad\u0001\u001a\u00020\u00112\u0007\u0010\u008f\u0001\u001a\u00020\u001dH&J\f\u0010¯\u0001\u001a\u0005\u0018\u00010®\u0001H\u0016J1\u0010´\u0001\u001a\u000b\u0012\u0004\u0012\u00028\u0000\u0018\u00010³\u0001\"\u0005\b\u0000\u0010°\u00012\u0006\u00103\u001a\u00020@2\u000e\u0010²\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000±\u0001H\u0016J\u001d\u0010µ\u0001\u001a\u00020\r2\b\u00103\u001a\u0004\u0018\u00010@2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&J\t\u0010¶\u0001\u001a\u00020\u0011H&J\u0012\u0010¸\u0001\u001a\u00020\u00112\u0007\u0010·\u0001\u001a\u00020\u0013H&J\u0013\u0010\\\u001a\u00020\r2\t\u0010[\u001a\u0005\u0018\u00010¹\u0001H&J\t\u0010º\u0001\u001a\u00020\u0011H&J\u001d\u0010¼\u0001\u001a\u00020\r2\u0007\u0010\u0096\u0001\u001a\u00020N2\t\u0010»\u0001\u001a\u0004\u0018\u00010\u001dH&J\u0011\u0010½\u0001\u001a\u00020\u00112\u0006\u0010!\u001a\u00020 H&J\f\u0010¿\u0001\u001a\u0005\u0018\u00010¾\u0001H\u0016J*\u0010Ã\u0001\u001a\u0004\u0018\u00010>2\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010Á\u0001\u001a\u0005\u0018\u00010À\u00012\t\b\u0002\u0010Â\u0001\u001a\u00020\u0011H&J\u001e\u0010Ç\u0001\u001a\u00020\u00112\u0007\u0010Ä\u0001\u001a\u00020\u00132\n\u0010Æ\u0001\u001a\u0005\u0018\u00010Å\u0001H&J\u0015\u0010Ê\u0001\u001a\u00020\r2\n\u0010É\u0001\u001a\u0005\u0018\u00010È\u0001H&J\u0013\u0010Í\u0001\u001a\f\u0012\u0005\u0012\u00030Ì\u0001\u0018\u00010Ë\u0001H&J\u001e\u0010Ñ\u0001\u001a\u00020\u00112\n\u0010Ï\u0001\u001a\u0005\u0018\u00010Î\u00012\u0007\u0010Ð\u0001\u001a\u00020\u0011H&J\u001c\u0010Ô\u0001\u001a\u00020\r2\u0007\u0010Ò\u0001\u001a\u00020\u00112\b\u0010Á\u0001\u001a\u00030Ó\u0001H&J\t\u0010Õ\u0001\u001a\u00020\rH&J\u001b\u0010Ö\u0001\u001a\u00020\r2\b\u00103\u001a\u0004\u0018\u00010@2\u0006\u0010!\u001a\u00020\u001dH&J2\u0010Ú\u0001\u001a\u00020\r2\u0007\u0010×\u0001\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00132\t\b\u0002\u0010Ø\u0001\u001a\u00020\u00132\u000b\b\u0002\u0010Ù\u0001\u001a\u0004\u0018\u00010\u001dH&JK\u0010à\u0001\u001a\u00020\r2\u0007\u0010Û\u0001\u001a\u00020\u00132\u0007\u0010Ü\u0001\u001a\u00020\u00112\t\b\u0002\u0010Ý\u0001\u001a\u00020\u00112\t\b\u0002\u0010Þ\u0001\u001a\u00020\u00112\u0018\b\u0002\u0010Á\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r\u0018\u00010ß\u0001H&J-\u0010á\u0001\u001a\u00020\r2\u0007\u0010\u0082\u0001\u001a\u00020\u00132\u0007\u0010\u0083\u0001\u001a\u00020\u001d2\u0007\u0010\u0084\u0001\u001a\u00020\u00132\u0007\u0010\u0087\u0001\u001a\u00020\u001dH&J5\u0010å\u0001\u001a\u00020\r2\u0012\b\u0002\u0010ã\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0011\u0018\u00010â\u00012\t\b\u0002\u0010ä\u0001\u001a\u00020\u00112\u000b\b\u0002\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u001dH&J\t\u0010æ\u0001\u001a\u00020\rH&J-\u0010ê\u0001\u001a\u00020\r2\u0007\u0010\u0096\u0001\u001a\u00020N2\u0007\u0010ç\u0001\u001a\u00020\u001d2\u0007\u0010è\u0001\u001a\u00020\u001d2\u0007\u0010é\u0001\u001a\u00020\u0013H&J\u001b\u0010ì\u0001\u001a\u00020\r2\u0007\u0010»\u0001\u001a\u00020\u001d2\u0007\u0010ë\u0001\u001a\u00020\u001dH&J\u0012\u0010î\u0001\u001a\u00020\r2\u0007\u0010í\u0001\u001a\u000200H&J\u001b\u0010ñ\u0001\u001a\u00020\r2\u0007\u0010ï\u0001\u001a\u00020\u001d2\u0007\u0010ð\u0001\u001a\u00020NH&J\u001b\u0010ô\u0001\u001a\u00020\r2\u0007\u0010ò\u0001\u001a\u00020\u001d2\u0007\u0010*\u001a\u00030ó\u0001H&J\u0017\u0010õ\u0001\u001a\u0004\u0018\u00010>2\n\u0010Á\u0001\u001a\u0005\u0018\u00010À\u0001H&J\u000b\u0010ö\u0001\u001a\u0004\u0018\u00010>H&J\u000b\u0010÷\u0001\u001a\u0004\u0018\u00010>H&J\u0017\u0010ú\u0001\u001a\u0005\u0018\u00010ù\u00012\t\b\u0002\u0010ø\u0001\u001a\u00020\u001dH&J\u000b\u0010û\u0001\u001a\u0004\u0018\u00010>H&J\f\u0010ü\u0001\u001a\u0005\u0018\u00010ù\u0001H&J(\u0010ý\u0001\u001a\u0004\u0018\u00010>2\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010Á\u0001\u001a\u0005\u0018\u00010À\u00012\u0007\u0010Â\u0001\u001a\u00020\u0011H&J\u0017\u0010þ\u0001\u001a\u0004\u0018\u00010>2\n\u0010Á\u0001\u001a\u0005\u0018\u00010À\u0001H&J\u0012\u0010ÿ\u0001\u001a\u00020\r2\u0007\u0010ð\u0001\u001a\u00020\u0013H&Jb\u0010\u0085\u0002\u001a\u0005\u0018\u00010¹\u00012\u000b\b\u0002\u0010\u0080\u0002\u001a\u0004\u0018\u00010\u00132\u000b\b\u0002\u0010\u0081\u0002\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u001d2\u000b\b\u0002\u0010\u0082\u0002\u001a\u0004\u0018\u00010\u00112\u000b\b\u0002\u0010\u0083\u0002\u001a\u0004\u0018\u00010\u001d2\u000b\b\u0002\u0010\u0084\u0002\u001a\u0004\u0018\u00010\u0013H&¢\u0006\u0006\b\u0085\u0002\u0010\u0086\u0002J\t\u0010\u0087\u0002\u001a\u00020\u0011H&J5\u0010\u008d\u0002\u001a\u0005\u0018\u00010\u008c\u00022\f\b\u0002\u0010\u0089\u0002\u001a\u0005\u0018\u00010\u0088\u00022\t\b\u0002\u0010\u008a\u0002\u001a\u00020\u00112\u000e\u0010\u008b\u0002\u001a\t\u0012\u0004\u0012\u00020\u00110â\u0001H&J\u0015\u0010\u008f\u0002\u001a\u00020\r2\n\u0010Á\u0001\u001a\u0005\u0018\u00010\u008e\u0002H&J\u001a\u0010\u0092\u0002\u001a\u00020\r2\u000f\u0010\u0091\u0002\u001a\n\u0012\u0005\u0012\u00030\u0090\u00020ª\u0001H&J\u0012\u0010\u0094\u0002\u001a\u00020\r2\u0007\u0010\u0093\u0002\u001a\u00020\u0011H&J\u0012\u0010\u0095\u0002\u001a\u00020\r2\u0007\u0010\u0093\u0002\u001a\u00020\u0011H&J\u0012\u0010\u0096\u0002\u001a\u00020\r2\u0007\u0010\u0093\u0002\u001a\u00020\u0011H&J\u001b\u0010\u0099\u0002\u001a\u00020\r2\u0007\u0010*\u001a\u00030\u0097\u00022\u0007\u0010\u0098\u0002\u001a\u00020\u0013H&JZ\u0010¤\u0002\u001a\u00020\r2\u0007\u0010\u009a\u0002\u001a\u00020\u00112\u000f\u0010\u009d\u0002\u001a\n\u0012\u0005\u0012\u00030\u009c\u00020\u009b\u00022\n\u0010\u009f\u0002\u001a\u0005\u0018\u00010\u009e\u00022\u0007\u0010 \u0002\u001a\u00020N2\u0017\u0010£\u0002\u001a\u0012\u0012\u0004\u0012\u00020N\u0012\u0005\u0012\u00030¢\u0002\u0018\u00010¡\u00022\u0007\u0010Ù\u0001\u001a\u00020\u001dH&J\u0013\u0010§\u0002\u001a\u00020\r2\b\u0010¦\u0002\u001a\u00030¥\u0002H&J\u000b\u0010¨\u0002\u001a\u0004\u0018\u000100H&Jo\u0010«\u0002\u001a\u0004\u0018\u00010Z2\u000b\b\u0002\u0010\u0080\u0002\u001a\u0004\u0018\u00010\u00132\u000b\b\u0002\u0010\u0081\u0002\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u001d2\f\b\u0002\u0010ª\u0002\u001a\u0005\u0018\u00010©\u00022\u000b\b\u0002\u0010\u0082\u0002\u001a\u0004\u0018\u00010\u00112\u000b\b\u0002\u0010\u0083\u0002\u001a\u0004\u0018\u00010\u001d2\u000b\b\u0002\u0010\u0084\u0002\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0006\b«\u0002\u0010¬\u0002J\f\u0010®\u0002\u001a\u0005\u0018\u00010\u00ad\u0002H&J\t\u0010¯\u0002\u001a\u00020\u0011H&J\t\u0010°\u0002\u001a\u00020\u0011H&J\u0013\u0010²\u0002\u001a\f\u0012\u0005\u0012\u00030±\u0002\u0018\u00010ª\u0001H&J9\u0010µ\u0002\u001a2\u0012\u0004\u0012\u00020\u001d\u0012%\u0012#\u0012\u0004\u0012\u00020\u001d\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001d\u0012\u000b\u0012\t\u0012\u0004\u0012\u0002000\u009b\u00020´\u00020´\u0002\u0018\u00010³\u0002H&J\u000b\u0010¶\u0002\u001a\u0004\u0018\u000100H&J\f\u0010¸\u0002\u001a\u0005\u0018\u00010·\u0002H&J\t\u0010¹\u0002\u001a\u00020\u0011H&J\u001c\u0010º\u0002\u001a\u0005\u0018\u00010\u008c\u00022\u000e\u0010\u008b\u0002\u001a\t\u0012\u0004\u0012\u00020\u00110â\u0001H&J\t\u0010»\u0002\u001a\u00020\u0011H&J\u0012\u0010½\u0002\u001a\u00020\r2\u0007\u0010¼\u0002\u001a\u00020\u0011H&J\t\u0010¾\u0002\u001a\u00020\u0011H&J\u0018\u0010Á\u0002\u001a\u0005\u0018\u00010¿\u00022\n\u0010À\u0002\u001a\u0005\u0018\u00010¿\u0002H&J\u0016\u0010Â\u0002\u001a\u0005\u0018\u00010¿\u00022\b\u0010À\u0002\u001a\u00030¿\u0002H&J(\u0010Æ\u0002\u001a\u0005\u0018\u00010Å\u00022\u0006\u00103\u001a\u00020@2\u0006\u0010\u0016\u001a\u00020\u00152\n\u0010Ä\u0002\u001a\u0005\u0018\u00010Ã\u0002H&J!\u0010È\u0002\u001a\u0005\u0018\u00010¿\u00022\n\u0010À\u0002\u001a\u0005\u0018\u00010¿\u00022\u0007\u0010Ç\u0002\u001a\u00020\u0011H&J\u001f\u0010É\u0002\u001a\u0005\u0018\u00010¿\u00022\b\u0010À\u0002\u001a\u00030¿\u00022\u0007\u0010Ç\u0002\u001a\u00020\u0011H&J\t\u0010Ê\u0002\u001a\u00020\u0011H&J\u001c\u0010Ì\u0002\u001a\u00020\r2\u0011\u0010Ë\u0002\u001a\f\u0012\u0005\u0012\u00030«\u0001\u0018\u00010\u009b\u0002H&R\u0019\u0010Ï\u0002\u001a\u0004\u0018\u00010\u001d8&X¦\u0004¢\u0006\b\u001a\u0006\bÍ\u0002\u0010Î\u0002R\u0017\u0010Ñ\u0002\u001a\u00020\u001d8&X¦\u0004¢\u0006\b\u001a\u0006\bÐ\u0002\u0010Î\u0002R!\u0010Ö\u0002\u001a\f\u0012\u0005\u0012\u00030Ó\u0002\u0018\u00010Ò\u00028&X¦\u0004¢\u0006\b\u001a\u0006\bÔ\u0002\u0010Õ\u0002R \u0010Ú\u0002\u001a\u000b\u0012\u0004\u0012\u00020\u0011\u0018\u00010×\u00028&X¦\u0004¢\u0006\b\u001a\u0006\bØ\u0002\u0010Ù\u0002R \u0010Ý\u0002\u001a\u000b\u0012\u0005\u0012\u00030«\u0001\u0018\u00010$8&X¦\u0004¢\u0006\b\u001a\u0006\bÛ\u0002\u0010Ü\u0002R\u0017\u0010ß\u0002\u001a\u00020\u001d8&X¦\u0004¢\u0006\b\u001a\u0006\bÞ\u0002\u0010Î\u0002R \u0010á\u0002\u001a\u000b\u0012\u0004\u0012\u00020\u0013\u0018\u00010×\u00028&X¦\u0004¢\u0006\b\u001a\u0006\bà\u0002\u0010Ù\u0002R \u0010ã\u0002\u001a\u000b\u0012\u0004\u0012\u00020\u0011\u0018\u00010×\u00028&X¦\u0004¢\u0006\b\u001a\u0006\bâ\u0002\u0010Ù\u0002R \u0010ä\u0002\u001a\u000b\u0012\u0004\u0012\u00020\u0011\u0018\u00010×\u00028&X¦\u0004¢\u0006\b\u001a\u0006\bä\u0002\u0010Ù\u0002R \u0010æ\u0002\u001a\u000b\u0012\u0004\u0012\u00020\u0013\u0018\u00010Ò\u00028&X¦\u0004¢\u0006\b\u001a\u0006\bå\u0002\u0010Õ\u0002¨\u0006é\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/IKtvService;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/android/livesdk/ktvapi/AbsKtvControlWidget$a;", "loader", "Lcom/bytedance/android/live/pushstream/d;", "liveStream", "Lcom/bytedance/android/livesdk/ktvapi/AbsKtvControlWidget;", "getKtvControlWidget", "Lj70/h;", "Ld90/d;", "getKtvAudioRoomWidgetDescriptor", "Lcom/bytedance/android/livesdk/chatroom/ui/g5;", "absInteractionFragment", BuildConfig.FLAVOR, "loadKtvControlWidget", "Lcom/bytedance/android/livesdkapi/ktv/IKtvComponentFeedViewService;", "getKtvComponentFeedViewService", BuildConfig.FLAVOR, "smallWindow", BuildConfig.FLAVOR, "getTtliveViewKtvRoomFeedResId", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Landroidx/lifecycle/ViewModel;", "installKtvContext", "Lfd2/q;", "prepareMvService", "removeKtvComponent", "Ljava/util/HashMap;", BuildConfig.FLAVOR, "Lkotlin/collections/HashMap;", "getGiftReportParam", "Lcom/bytedance/android/livesdk/ktvapi/KtvConflictScene;", "toScene", "requestConflictCheckForScene", "isEnableMvStage", "Lcom/bytedance/live/datacontext/n;", "ktvCardState", "Landroid/util/Pair;", "Lcom/bytedance/android/livesdk/log/filter/v;", "provideStageModeLogInjector", "provideKtvBizParamInjector", "info", "Lid2/d;", "ktvMusicSelectedCallBack", "openEffectMusicSelect", "source", "openKsong", BuildConfig.FLAVOR, "vm", "setKtvCoreViewModel", "context", "setKtvContext", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;", "provideKtvRoomBehavior", "host", "Lcom/bytedance/android/livesdk/action/BaseActionMethod;", "Ljava/lang/Void;", "providerSchemaActionImpl", "Lcom/bytedance/android/livesdk/ktvapi/AbsKtvControlWidget$WidgetType;", "widgetType", "Ljava/lang/Class;", "Lcom/bytedance/ies/sdk/widgets/Widget;", "getWidgetClassByType", "Landroid/content/Context;", "lyricType", "Lcom/bytedance/android/livesdk/ktvapi/config/ScrollLyricConfigV2;", "config", "Lfd2/l;", "createLyricService", "Lfd2/y;", "getKtvRoomInfo", "isKtvChallengeOpened", "groupdId", "openKtvGroupUserList", "createKtvGroup", "onChallengeIconShow", "openKtvChallenge", BuildConfig.FLAVOR, "time", "setVoiceKtvSwitchTime", "queryUserName", "queryUserId", "requestPage", "showHighScoreSongListDialog", "toUserId", "toUserType", "liveType", "logHighScoreSongLabelClick", "logHighScoreSongLabelShow", "Lfd2/x;", "cmd", "sendKtvComponentV2Command", BuildConfig.FLAVOR, "transY", "rightMargin", "ktvContainerPositionUpdate", "(Ljava/lang/Float;Ljava/lang/Integer;)V", "Lfd2/f;", "getChorusService", "Landroid/view/ViewGroup;", "parent", "initChorusService", "destroyChorusService", "Lgd2/c;", "getChorusConcertService", "Lgd2/f;", "getConcertStageService", "enterRoomType", "saveEnterRoomType", "isAIMVEnable", "Lfd2/v;", "createSpeechRecognizer", "getLyricsRecognizer", "getEnterRoomType", "isKtvComponentOpen", "Ljd2/g;", "model", "enableVideoChorus", "showFrom", "Lcom/bytedance/android/livesdkapi/feed/IInteractFeedView;", "getKtvRoomFeedView", "Landroid/view/View;", "inflatedKtvFeedView", "getRealTimeChorusFeedView", "getInteractAnimationService", "getSelfSilenceType", "Luf0/c;", "inviteCallback", "setInviteCallback", "position", "applySource", "applyType", "Lcom/bytedance/android/live/liveinteract/api/chatroom/model/LinkMatchType;", "matchType", "fromSource", "taskName", "checkMatchAndApply", "Lfd2/c;", "listener", "isFeedBackMode", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "getKtvFeedbackDialog", "uid", "onPermitSuccess", "currentIsMultipleKtvModeV2", "Lcom/bytedance/android/livesdkapi/ktv/IKtvComponentFeedView;", "getKtvComponentFeedView", "isMultiChorusEnable", "isInRealTimeChorus", "roomId", "moveOrderedSongToOtherRoom", "userId", "Lcom/bytedance/android/livesdk/ktvapi/KtvRoomUserLabel;", "getUserKtvRoomLabel", "currentIsMultipleKtvMode", "currentIsAudienceSingEnable", "Lcom/bytedance/live/datacontext/k;", "Lfd2/z;", "ktvComponentSingerChangedEvent", "isMultipleKtvEnable", "isKtvIsSingingState", "hasSelfPrivateSong", "inMultipleKtv", "stageChangeToPreparedEvent", "orderedListChangeEvent", "Lcom/bytedance/android/livesdk/message/model/za;", "ktvCurrentSingerOrderInfo", "stageChangeToIdleEvent", "ktvStageReadyEvent", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/message/model/KtvMusic;", "getKtvRoomCurSelfOrderList", "isUserSelectMusic", "Lfd2/m;", "getOpusPreviewDialogBuilder", "T", "Lcom/bytedance/android/livesdk/ktvapi/model/mv/j;", "provider", "Lcom/bytedance/android/livesdk/ktvapi/model/mv/e;", "createMvPreviewList", "openKtvRoomDialog", "isKtvComponentV2Enable", "state", "isInKtvState", "Lfd2/i;", "isAudienceSingEnableSwitchOn", "id", "inviteToKtvGroup", "requestConflictCheck", "Lcom/bytedance/android/livesdk/ktvapi/model/mv/d;", "createOpusMvService", "Lhh1/w0;", "callback", "isFromRadio", "createKtvRoomAnchorWidget", "scene", "Lcom/bytedance/android/livesdk/message/linker/h;", "infoData", "continueAnchorLinkMic", "Lcom/bytedance/android/livesdk/link/model/bridge/z0;", "message", "onSwitchSceneMessage", "Lcom/bytedance/android/live/liveinteract/plantform/base/i;", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "getLinkUserInfoCenter", "Ljava/lang/Runnable;", "runnable", "skippingToOtherRoom", "interceptCloseRoom", "isAddSong", "Ltf0/q;", "showLinkFollowDialog", "finishAudioTalk", "switchVoiceSceneWithCheck", "fromScene", "toUILayout", "reason", "switchScene", "disconnectSource", "needSureAgain", "needToastWhenSuccess", "needShowLinkResult", "Lkotlin/Function1;", "disconnect", "checkAndApply", "Lio/reactivex/functions/Consumer;", "consumer", "needShowSuccessToast", "cancelApply", "tryAutoFastMatch", "secToUserId", "toUserIdString", "replyType", "checkAndReply", "secUid", "accept", "params", "invite", "toUsers", "status", "updateRealtimeChorusGuestStatus", "sei", "Lye1/a;", "onSei", "createKtvRoomGuestWidget", "createConcertWidget", "createPcAudioWidget", "enterFrom", "Lfd2/g;", "createConcertFeedWidget", "createVideoChorusWidget", "createVideoChorusFeedWidget", "createRealTimeChorusRoomAnchorWidget", "createRealTimeChorusRoomGuestWidget", "onClickToolbar", "switch", "audienceSingEnable", "showMainDialog", "showMainDialogEnterFrom", "openSource", "createKtvComponentCmd", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;)Lfd2/i;", "isCurrentUserIsSinger", "Landroidx/lifecycle/LifecycleOwner;", "owner", "needObserveOnUi", "observer", "Lio/reactivex/disposables/Disposable;", "observerCurrentIsSinger", "Luf0/d;", "setPermitCallback", "Lcom/bytedance/android/livesdk/chatroom/interact/model/y;", "settings", "handleSettingUpdate", "open", "enableAtmosphere", "enablePreviewSong", "enableHardwareEcho", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerChangeMediaInfoContent;", "lastAudioBitRate", "onChangeMediaInfo", "isSilence", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "data", "Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "clientUIInfo", "version", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/link/model/bridge/g2;", "linkerContentMap", "switchAudioByClient", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "targetUser", "kickOut", "muteManager", "Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "musicPanel", "createKtvCommand", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Lcom/bytedance/android/livesdk/message/model/MusicPanel;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;)Lfd2/x;", "Ltf0/k;", "getLinkmicReturnRoomParams", "canSilenceSelf", "isEngineOn", "Lcom/bytedance/android/live/liveinteract/plantform/model/s0;", "getHeadPointList", "Lkotlin/Pair;", BuildConfig.FLAVOR, "getRoomWrdsListenerData", "getRealTimeChorusMicManager", "Lfd2/w;", "getVideoChorusService", "inMultipleKtvOld", "observeMultiChorusSwitchState", "getKtvComponentLyricsViewShowStatus", "show", "updateKtvComponentLyricsViewShowStatus", "getHideLyricsWhenSubtitleOpenSwitch", "Lcom/google/gson/JsonObject;", "extraData", "handleDynamicJsbGetAction", "handleDynamicJsbUpdateAction", "Lcom/bytedance/android/livesdk/chatroom/widget/j1;", "scoreProvider", "Lfd2/e;", "loadChorusDynamicJsbService", "isFeed", "handleKtvCommonJsbGetAction", "handleKtvCommonJsbUpdateAction", "hasEnterMultiChorusQueue", "ktvMusics", "prepareDownloadSongMaterials", "getRecentSongInfo", "()Ljava/lang/String;", "recentSongInfo", "getKtvRoomCurrentSingerIdString", "ktvRoomCurrentSingerIdString", "Lio/reactivex/Observable;", "Lfd2/a;", "getMusicPlayProgressObservable", "()Lio/reactivex/Observable;", "musicPlayProgressObservable", "Lcom/bytedance/live/datacontext/m;", "getHasBgm", "()Lcom/bytedance/live/datacontext/m;", "hasBgm", "getCurrentSongOfSelf", "()Lcom/bytedance/live/datacontext/n;", "currentSongOfSelf", "getKtvRoomCurrentSingerIdStr", "ktvRoomCurrentSingerIdStr", "getKtvComponentStatusChangedObservable", "ktvComponentStatusChangedObservable", "getCurrentIsMultipleKtvModeObservable", "currentIsMultipleKtvModeObservable", "isPushingExternalVideo", "getKtvAllStateObservable", "ktvAllStateObservable", "Companion", "a", "livektv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ServiceDummyLookup("com.bytedance.android.livesdk.KtvServiceDummy")
public interface IKtvService extends IService {
    public static final a Companion = null;
    public static final String KEY_OF_CHORUS_SCENE_WIDGET_FOR_DATACENTER = "ktv_chorus_scene_widget";
    public static final String KEY_OF_CHORUS_SUBSCENE_FOR_DATACENTER = "ktv_chorus_feed_subScene";
    public static final String KEY_OF_KTVCONTEXT_FOR_DATACENTER = "ktvContext";
    public static final String KEY_OF_SCENE_WIDGET_FOR_DATACENTER = "ktv_scene_widget";
    public static final String KEY_OF_SUBSCENE_FOR_DATACENTER = "ktv_feed_subScene";

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    public static final class b {
        public static /* synthetic */ Disposable b(IKtvService r0, LifecycleOwner r1, Consumer r2, int r3) {
            if ((r3 & 1) == 0) goto L6;
            r1 = null;
        L6:
            return r0.observerCurrentIsSinger(r1, false, r2);
        }

        public static /* synthetic */ void a(IKtvService r8, int r9, boolean r10, boolean r11, boolean r13, int r14) {
            if ((r14 & 4) == 0) goto L5;
            boolean r5 = false;
        L7:
            if ((r14 & 8) == 0) goto L9;
            boolean r6 = false;
        L10:
            r8.disconnect(r9, r10, r5, r6, null);
            return;
        L9:
            r6 = r13;
            goto L10
        L5:
            r5 = r11;
            goto L7
        }
    }

    static {
        Companion = a.a;
    }

    void accept(String r1, String r2);

    boolean canSilenceSelf();

    void cancelApply(Consumer<Boolean> r1, boolean r2, String r3);

    void checkAndApply(int r1, String r2, int r3, String r4);

    void checkAndReply(long r1, String r3, String r4, int r5);

    void checkMatchAndApply(int r1, String r2, int r3, LinkMatchType r4, String r5, String r6);

    boolean continueAnchorLinkMic(int r1, h r2);

    g createConcertFeedWidget(String r1);

    Widget createConcertWidget();

    x createKtvCommand(Integer r1, Boolean r2, String r3, MusicPanel r4, Boolean r5, String r6, Integer r7);

    i createKtvComponentCmd(Integer r1, Boolean r2, String r3, Boolean r4, String r5, Integer r6);

    void createKtvGroup(Context r1);

    Widget createKtvRoomAnchorWidget(d r1, w0 r2, boolean r3);

    Widget createKtvRoomGuestWidget(w0 r1);

    l createLyricService(Context r1, int r2, ScrollLyricConfigV2 r3);

    <T> e<T> createMvPreviewList(Context r1, j<T> r2);

    com.bytedance.android.livesdk.ktvapi.model.mv.d createOpusMvService();

    Widget createPcAudioWidget();

    Widget createRealTimeChorusRoomAnchorWidget(d r1, w0 r2, boolean r3);

    Widget createRealTimeChorusRoomGuestWidget(w0 r1);

    v createSpeechRecognizer(boolean r1);

    g createVideoChorusFeedWidget();

    Widget createVideoChorusWidget();

    boolean currentIsAudienceSingEnable();

    boolean currentIsMultipleKtvMode();

    boolean currentIsMultipleKtvModeV2();

    void destroyChorusService();

    void disconnect(int r1, boolean r2, boolean r3, boolean r4, Function1<? super Boolean, Unit> r5);

    void enableAtmosphere(boolean r1);

    void enableHardwareEcho(boolean r1);

    void enablePreviewSong(boolean r1);

    void enableVideoChorus(jd2.g r1);

    void finishAudioTalk();

    c getChorusConcertService();

    f getChorusService();

    gd2.f getConcertStageService();

    m<Boolean> getCurrentIsMultipleKtvModeObservable();

    n<KtvMusic> getCurrentSongOfSelf();

    String getEnterRoomType();

    HashMap<String, String> getGiftReportParam();

    m<Boolean> getHasBgm();

    List<s0> getHeadPointList();

    boolean getHideLyricsWhenSubtitleOpenSwitch();

    Object getInteractAnimationService();

    Observable<Integer> getKtvAllStateObservable();

    j70.h<d90.d> getKtvAudioRoomWidgetDescriptor();

    IKtvComponentFeedView getKtvComponentFeedView(Context r1, boolean r2);

    IKtvComponentFeedViewService getKtvComponentFeedViewService();

    boolean getKtvComponentLyricsViewShowStatus();

    m<Integer> getKtvComponentStatusChangedObservable();

    AbsKtvControlWidget getKtvControlWidget(AbsKtvControlWidget.a r1, d r2);

    LiveDialogFragment getKtvFeedbackDialog(String r1, fd2.c r2, boolean r3);

    List<KtvMusic> getKtvRoomCurSelfOrderList(String r1);

    String getKtvRoomCurrentSingerIdStr();

    String getKtvRoomCurrentSingerIdString();

    IInteractFeedView getKtvRoomFeedView(Context r1, boolean r2, int r3);

    IInteractFeedView getKtvRoomFeedView(View r1, Context r2, boolean r3, int r4);

    y getKtvRoomInfo();

    com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> getLinkUserInfoCenter();

    k getLinkmicReturnRoomParams();

    v getLyricsRecognizer();

    Observable<fd2.a> getMusicPlayProgressObservable();

    fd2.m getOpusPreviewDialogBuilder();

    IInteractFeedView getRealTimeChorusFeedView(Context r1, int r2);

    Object getRealTimeChorusMicManager();

    String getRecentSongInfo();

    Pair<String, Map<String, Map<String, List<Object>>>> getRoomWrdsListenerData();

    int getSelfSilenceType();

    int getTtliveViewKtvRoomFeedResId(boolean r1);

    KtvRoomUserLabel getUserKtvRoomLabel(String r1);

    w getVideoChorusService();

    Class<? extends Widget> getWidgetClassByType(AbsKtvControlWidget.WidgetType r1);

    JsonObject handleDynamicJsbGetAction(JsonObject r1);

    JsonObject handleDynamicJsbUpdateAction(JsonObject r1);

    JsonObject handleKtvCommonJsbGetAction(JsonObject r1, boolean r2);

    JsonObject handleKtvCommonJsbUpdateAction(JsonObject r1, boolean r2);

    void handleSettingUpdate(List<? extends com.bytedance.android.livesdk.chatroom.interact.model.y> r1);

    boolean hasEnterMultiChorusQueue();

    boolean hasSelfPrivateSong();

    boolean inMultipleKtv();

    boolean inMultipleKtvOld();

    void initChorusService(Context r1, ViewGroup r2, DataCenter r3);

    ViewModel installKtvContext(DataCenter r1);

    boolean interceptCloseRoom(Runnable r1, boolean r2);

    void invite(Object r1);

    void inviteToKtvGroup(long r1, String r3);

    boolean isAudienceSingEnableSwitchOn();

    boolean isCurrentUserIsSinger();

    boolean isEnableMvStage();

    boolean isEngineOn();

    boolean isInKtvState(int r1);

    boolean isInRealTimeChorus();

    boolean isKtvChallengeOpened();

    boolean isKtvComponentOpen();

    boolean isKtvComponentV2Enable();

    boolean isKtvIsSingingState();

    boolean isMultiChorusEnable();

    boolean isMultipleKtvEnable(DataCenter r1);

    m<Boolean> isPushingExternalVideo();

    boolean isUserSelectMusic(String r1);

    void kickOut(IBaseUser r1);

    n<Integer> ktvCardState();

    com.bytedance.live.datacontext.k<z> ktvComponentSingerChangedEvent();

    void ktvContainerPositionUpdate(Float r1, Integer r2);

    za ktvCurrentSingerOrderInfo();

    com.bytedance.live.datacontext.k<?> ktvStageReadyEvent();

    fd2.e loadChorusDynamicJsbService(Context r1, DataCenter r2, j1 r3);

    void loadKtvControlWidget(g5 r1);

    void logHighScoreSongLabelClick(String r1, String r2, String r3, String r4);

    void logHighScoreSongLabelShow(String r1, String r2, String r3, String r4);

    void moveOrderedSongToOtherRoom(long r1);

    Object muteManager();

    Disposable observeMultiChorusSwitchState(Consumer<Boolean> r1);

    Disposable observerCurrentIsSinger(LifecycleOwner r1, boolean r2, Consumer<Boolean> r3);

    void onChallengeIconShow();

    void onChangeMediaInfo(ILinkerChangeMediaInfoContent r1, int r2);

    void onClickToolbar(int r1);

    void onPermitSuccess(String r1);

    void onSei(String r1, ye1.a r2);

    void onSwitchSceneMessage(z0 r1);

    void openEffectMusicSelect(String r1, id2.d r2);

    void openKsong(String r1);

    void openKtvChallenge(String r1, Context r2);

    void openKtvGroupUserList(Context r1, String r2);

    void openKtvRoomDialog(Context r1, DataCenter r2);

    com.bytedance.live.datacontext.k<?> orderedListChangeEvent();

    void prepareDownloadSongMaterials(List<KtvMusic> r1);

    q prepareMvService();

    android.util.Pair<String, com.bytedance.android.livesdk.log.filter.v> provideKtvBizParamInjector();

    c0.b provideKtvRoomBehavior();

    android.util.Pair<String, com.bytedance.android.livesdk.log.filter.v> provideStageModeLogInjector();

    BaseActionMethod<Void> providerSchemaActionImpl(String r1);

    void removeKtvComponent();

    boolean requestConflictCheck(KtvConflictScene r1);

    KtvConflictScene requestConflictCheckForScene(KtvConflictScene r1);

    void saveEnterRoomType(String r1);

    void sendKtvComponentV2Command(i r1);

    void sendKtvComponentV2Command(x r1);

    void setInviteCallback(uf0.c r1);

    void setKtvContext(Object r1);

    void setKtvCoreViewModel(Object r1);

    void setPermitCallback(uf0.d r1);

    void setVoiceKtvSwitchTime(long r1);

    void showHighScoreSongListDialog(Context r1, String r2, String r3, String r4);

    void showLinkFollowDialog(boolean r1, tf0.q r2);

    com.bytedance.live.datacontext.k<?> stageChangeToIdleEvent();

    com.bytedance.live.datacontext.k<?> stageChangeToPreparedEvent();

    void switchAudioByClient(boolean r1, List<com.bytedance.android.livesdk.link.model.bridge.k> r2, ClientUIInfo r3, long r4, Map<Long, ? extends g2> r6, String r7);

    void switchScene(int r1, int r2, int r3, String r4);

    void switchVoiceSceneWithCheck(Context r1, String r2);

    void tryAutoFastMatch();

    void updateKtvComponentLyricsViewShowStatus(boolean r1);

    void updateRealtimeChorusGuestStatus(String r1, long r2);
}
