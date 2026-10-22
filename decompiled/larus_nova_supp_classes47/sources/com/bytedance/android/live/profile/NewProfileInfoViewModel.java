package com.bytedance.android.live.profile;

import am2.c0;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.model.user.AdminInfo;
import com.bytedance.android.live.base.model.user.BaseProfileInfo;
import com.bytedance.android.live.base.model.user.DressSuitInfo;
import com.bytedance.android.live.base.model.user.GiftExhibitionHomeStats;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.LiveAgentInfo;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileConstant;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.base.model.user.ProfileFansClub;
import com.bytedance.android.live.base.model.user.ProfileFansClubData;
import com.bytedance.android.live.base.model.user.ProfilePotentialCustomerInfo;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.base.model.user.ProfileStyleParams;
import com.bytedance.android.live.base.model.user.UserProfileDataResp;
import com.bytedance.android.live.base.model.user.WhiteCategoryCert;
import com.bytedance.android.live.base.model.user.g0;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.gift.IGiftServiceExternal;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.profile.api.setting.models.ProfileLoginGuideConfig;
import com.bytedance.android.live.profile.event.EventHub;
import com.bytedance.android.live.profile.model.EnterExitStateType;
import com.bytedance.android.live.profile.model.ProfileRoomProxy;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profile.monitor.EventType;
import com.bytedance.android.live.profile.monitor.ProfileMonitor;
import com.bytedance.android.live.profile.monitor.TimeType;
import com.bytedance.android.live.profile.p000enum.DressClickArea;
import com.bytedance.android.live.profile.p000enum.ProfileMode;
import com.bytedance.android.live.profile.p000enum.TrackArea;
import com.bytedance.android.live.profile.profilecontext.ProfileContextUseCase;
import com.bytedance.android.live.profile.ui.component.ProfileCommonComponent;
import com.bytedance.android.live.profile.ui.util.DressType;
import com.bytedance.android.live.profile.usecase.NewProfileEnterExitUseCase;
import com.bytedance.android.live.profile.usecase.NewProfileTrackUseCase;
import com.bytedance.android.live.profile.usecase.n;
import com.bytedance.android.live.profile.usecase.q;
import com.bytedance.android.live.profile.usecase.r;
import com.bytedance.android.live.profile.whitetag.WhiteCertSubDialogFragment;
import com.bytedance.android.live.profit.dress.config.DressResource;
import com.bytedance.android.live.profit.dress.config.x;
import com.bytedance.android.live.profit.fansclub.FansClubEntranceParams;
import com.bytedance.android.live.profit.fansclub.p;
import com.bytedance.android.live.profit.privilege.model.ProfitCheckType;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.live.room.api.report.IMiddlewareReportService;
import com.bytedance.android.live.room.api.report.ReportObject;
import com.bytedance.android.live.room.api.userinfo.event.ReportConstant$BusinessSource;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.config.b8;
import com.bytedance.android.livesdk.interactivity.api.IBaseDiggService;
import com.bytedance.android.livesdk.interactivity.api.comment.event.OpenInputSource;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.vh;
import com.bytedance.android.livesdk.p8;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.user.LiveInteractFunction;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.android.livesdk.x3;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.live.IGroupLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomOthersData;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import gd0.v;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.text.StringsKt;
import mv0.k;
import org.json.JSONException;
import org.json.JSONObject;
import py.t;
import qs0.s;
import rs0.r0;
import rs0.s0;
import rs0.w0;
import zg1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000Ü\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b6\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000 Ø\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002Ù\u0002B\t¢\u0006\u0006\bÖ\u0002\u0010×\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\nH\u0002J\u000e\u0010\u0012\u001a\u0004\u0018\u00010\u000e*\u00020\u0011H\u0002J\u0012\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u0012\u0010\u0016\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0005H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\u0012\u0010\u001c\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\u0012\u0010\u001d\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010\u001e\u001a\u00020\u0005H\u0002J\b\u0010\u001f\u001a\u00020\u000eH\u0002J\b\u0010 \u001a\u00020\u0005H\u0002J\b\u0010!\u001a\u00020\u0005H\u0002J\b\u0010\"\u001a\u00020\u0018H\u0002J\b\u0010#\u001a\u00020\u0018H\u0002J\b\u0010$\u001a\u00020\u0018H\u0002J\b\u0010%\u001a\u00020\u0018H\u0002J\b\u0010&\u001a\u00020\u0018H\u0002J$\u0010+\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010(\u001a\u00020'2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016J \u00100\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010,2\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010.J\u0006\u00101\u001a\u00020\u0005J\u0006\u00102\u001a\u00020\u0005J\u0006\u00103\u001a\u00020\u0005J\u001c\u00107\u001a\u00020\u00052\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u000205\u0018\u000104J\u000e\u0010:\u001a\u00020\u00052\u0006\u00109\u001a\u000208J\u0010\u0010<\u001a\u00020\u00052\b\u0010;\u001a\u0004\u0018\u00010\nJ\u0006\u0010=\u001a\u00020\u0005J\u0010\u0010@\u001a\u00020\u00052\u0006\u0010?\u001a\u00020>H\u0016J\u000e\u0010C\u001a\u00020\u00052\u0006\u0010B\u001a\u00020AJ\u0012\u0010E\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010DH\u0016J\u0012\u0010F\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010G\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010H\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J.\u0010M\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010I\u001a\u00020>2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00110J2\u0006\u0010L\u001a\u00020\u000eH\u0016J\u0010\u0010P\u001a\u00020\u00052\u0006\u0010O\u001a\u00020NH\u0016J\u0018\u0010R\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020N2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0018\u0010S\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020N2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0012\u0010T\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010U\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010V\u001a\u00020\u00052\u0006\u0010O\u001a\u00020NH\u0016J\u0018\u0010W\u001a\u00020\u00052\u0006\u0010I\u001a\u00020>2\u0006\u0010L\u001a\u00020\u000eH\u0016J\b\u0010X\u001a\u00020\u0005H\u0016J\b\u0010Y\u001a\u00020\u0018H\u0016J \u0010[\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010L\u001a\u00020\u000e2\u0006\u0010Z\u001a\u00020\u0018H\u0016J\u0018\u0010]\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\\\u001a\u00020\u0018H\u0016J\u0010\u0010^\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010_\u001a\u00020\u0005H\u0016J\u0012\u0010`\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0014\u0010c\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0bH\u0016J\u0012\u0010e\u001a\u00020d2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\nJ\n\u0010f\u001a\u0004\u0018\u00010)H\u0016J\b\u0010h\u001a\u00020gH\u0016J\b\u0010i\u001a\u00020\nH\u0016J\u0016\u0010k\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010jH\u0016J\n\u0010l\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010m\u001a\u00020AH\u0016J\n\u0010o\u001a\u0004\u0018\u00010nH\u0016J\b\u0010q\u001a\u00020pH\u0016J\b\u0010s\u001a\u00020rH\u0016J\b\u0010t\u001a\u00020\u0005H\u0014J\b\u0010v\u001a\u00020uH\u0016J\b\u0010x\u001a\u00020wH\u0016J\b\u0010y\u001a\u00020\u0018H\u0016J\u0018\u0010{\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010z\u001a\u00020\u000eH\u0016J\u001a\u0010}\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010|\u001a\u0004\u0018\u00010\u000eH\u0016J\u001b\u0010\u0080\u0001\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u007f\u001a\u0004\u0018\u00010~H\u0016J\t\u0010\u0081\u0001\u001a\u00020\u0018H\u0016J\t\u0010\u0082\u0001\u001a\u00020\u0018H\u0016J\u0013\u0010\u0083\u0001\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0085\u0001\u001a\u00020\u00052\u0007\u0010\u0084\u0001\u001a\u00020\u000eJ\t\u0010\u0086\u0001\u001a\u00020\u0018H\u0016J\t\u0010\u0087\u0001\u001a\u00020\u0018H\u0016J\t\u0010\u0088\u0001\u001a\u00020\u0018H\u0016J\u0012\u0010\u008a\u0001\u001a\u00020\u00052\u0007\u0010\u0014\u001a\u00030\u0089\u0001H\u0016J\u0013\u0010\u008b\u0001\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u001b\u0010\u008c\u0001\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010|\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u008e\u0001\u001a\t\u0012\u0004\u0012\u00020>0\u008d\u0001H\u0016J\u0010\u0010\u008f\u0001\u001a\t\u0012\u0004\u0012\u00020\u00180\u008d\u0001H\u0016J\u0011\u0010\u0090\u0001\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0011\u0010\u0091\u0001\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0011\u0010\u0092\u0001\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u001b\u0010\u0093\u0001\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010|\u001a\u0004\u0018\u00010\u000eH\u0016J\u001b\u0010\u0094\u0001\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010|\u001a\u0004\u0018\u00010\u000eH\u0016J\u001d\u0010\u0097\u0001\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0095\u0001H\u0016J\u001d\u0010\u0098\u0001\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0095\u0001H\u0016J\t\u0010\u0099\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u009a\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u009b\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u009c\u0001\u001a\u00020\u0005H\u0016J\t\u0010\u009d\u0001\u001a\u00020\u0005H\u0016J:\u0010£\u0001\u001a\u00020\u00052\b\u0010\u009f\u0001\u001a\u00030\u009e\u00012%\u0010¢\u0001\u001a \u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0 \u0001j\u000f\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e`¡\u0001H\u0016J\t\u0010¤\u0001\u001a\u00020\u0018H\u0016J\u001e\u0010¦\u0001\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\t\u0010¥\u0001\u001a\u0004\u0018\u00010\u000eH\u0016J\u0016\u0010¨\u0001\u001a\u0005\u0018\u00010§\u00012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\t\u0010©\u0001\u001a\u00020\u0005H\u0016J\t\u0010ª\u0001\u001a\u00020\u0018H\u0016J\u0019\u0010\u00ad\u0001\u001a\u00020\u00052\u000e\u0010¬\u0001\u001a\t\u0012\u0004\u0012\u00020\u00110«\u0001H\u0016J\f\u0010¯\u0001\u001a\u0005\u0018\u00010®\u0001H\u0016J\u0016\u0010³\u0001\u001a\u0005\u0018\u00010²\u00012\b\u0010±\u0001\u001a\u00030°\u0001H\u0016J\u000b\u0010´\u0001\u001a\u0004\u0018\u00010\u000eH\u0016J\u001d\u0010¶\u0001\u001a\u00020>2\t\u0010µ\u0001\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0006\b¶\u0001\u0010·\u0001J\t\u0010¸\u0001\u001a\u00020\u0018H\u0016J\u0013\u0010»\u0001\u001a\u00020\u00052\b\u0010º\u0001\u001a\u00030¹\u0001H\u0016JH\u0010\\\u001a\u00020\u00052\u0007\u0010¼\u0001\u001a\u00020\u000e2\u0013\u0010½\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0j2\u0018\u0010¿\u0001\u001a\r\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00110¾\u0001\"\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0005\b\\\u0010À\u0001J\u001c\u0010Ã\u0001\u001a\u00020\u00052\b\u0010º\u0001\u001a\u00030Á\u00012\u0007\u0010Â\u0001\u001a\u00020\u000eH\u0016J\u001e\u0010Å\u0001\u001a\u00020\u00052\u0013\u0010Ä\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0jH\u0016J\u000b\u0010Æ\u0001\u001a\u0004\u0018\u00010\u000eH\u0016J/\u0010Ç\u0001\u001a\u00020\u00052\u0007\u0010Â\u0001\u001a\u00020\u000e2\u001b\u0010Ä\u0001\u001a\u0016\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010jH\u0016R0\u0010É\u0001\u001a\t\u0012\u0004\u0012\u00020\n0È\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÉ\u0001\u0010Ê\u0001\u001a\u0006\bË\u0001\u0010Ì\u0001\"\u0006\bÍ\u0001\u0010Î\u0001R0\u0010Ï\u0001\u001a\t\u0012\u0004\u0012\u00020\u00180È\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÏ\u0001\u0010Ê\u0001\u001a\u0006\bÐ\u0001\u0010Ì\u0001\"\u0006\bÑ\u0001\u0010Î\u0001R+\u0010Ò\u0001\u001a\u0004\u0018\u00010)8\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\bÒ\u0001\u0010Ó\u0001\u001a\u0006\bÔ\u0001\u0010Õ\u0001\"\u0006\bÖ\u0001\u0010×\u0001R\u001b\u0010Ø\u0001\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bØ\u0001\u0010Ù\u0001R+\u0010Ú\u0001\u001a\u0004\u0018\u00010A8\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\bÚ\u0001\u0010Û\u0001\u001a\u0006\bÜ\u0001\u0010Ý\u0001\"\u0006\bÞ\u0001\u0010ß\u0001R'\u0010\u000b\u001a\u00020\n8\u0004@\u0004X\u0084\u000e¢\u0006\u0017\n\u0005\b\u000b\u0010Ù\u0001\u001a\u0006\bà\u0001\u0010á\u0001\"\u0006\bâ\u0001\u0010ã\u0001R7\u0010ä\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010j8\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\bä\u0001\u0010å\u0001\u001a\u0006\bæ\u0001\u0010ç\u0001\"\u0006\bè\u0001\u0010é\u0001R)\u0010ê\u0001\u001a\u00020A8\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\bê\u0001\u0010Û\u0001\u001a\u0006\bë\u0001\u0010Ý\u0001\"\u0006\bì\u0001\u0010ß\u0001R\u0019\u0010í\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bí\u0001\u0010î\u0001R\u001b\u0010ï\u0001\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bï\u0001\u0010î\u0001R\u0019\u0010ð\u0001\u001a\u00020g8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bð\u0001\u0010ñ\u0001R\u001b\u0010ò\u0001\u001a\u0004\u0018\u00010n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bò\u0001\u0010ó\u0001R\u0019\u0010ô\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bô\u0001\u0010î\u0001R\u0019\u0010õ\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bõ\u0001\u0010î\u0001R\u0019\u0010ö\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bö\u0001\u0010î\u0001R\u0019\u0010÷\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b÷\u0001\u0010ø\u0001R\u001c\u0010ù\u0001\u001a\u0005\u0018\u00010®\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bù\u0001\u0010ú\u0001R\u0019\u0010û\u0001\u001a\u00020r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bû\u0001\u0010ü\u0001R\u0019\u0010ý\u0001\u001a\u00020p8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bý\u0001\u0010þ\u0001R,\u0010\u0080\u0002\u001a\u0005\u0018\u00010ÿ\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\b\u0080\u0002\u0010\u0081\u0002\u001a\u0006\b\u0082\u0002\u0010\u0083\u0002\"\u0006\b\u0084\u0002\u0010\u0085\u0002R\u001c\u0010\u0087\u0002\u001a\u0005\u0018\u00010\u0086\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0002\u0010\u0088\u0002R\u001a\u0010\u008a\u0002\u001a\u00030\u0089\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0002\u0010\u008b\u0002R\u001a\u0010\u008d\u0002\u001a\u00030\u008c\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0002\u0010\u008e\u0002R*\u0010\u0090\u0002\u001a\u00030\u008f\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\b\u0090\u0002\u0010\u0091\u0002\u001a\u0006\b\u0092\u0002\u0010\u0093\u0002\"\u0006\b\u0094\u0002\u0010\u0095\u0002R)\u0010\u0096\u0002\u001a\u00020u8\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\b\u0096\u0002\u0010\u0097\u0002\u001a\u0006\b\u0098\u0002\u0010\u0099\u0002\"\u0006\b\u009a\u0002\u0010\u009b\u0002R\u0018\u0010\u009d\u0002\u001a\u00030\u009c\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009d\u0002\u0010\u009e\u0002R\u0018\u0010 \u0002\u001a\u00030\u009f\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b \u0002\u0010¡\u0002R'\u0010¤\u0002\u001a\n\u0012\u0005\u0012\u00030£\u00020¢\u00028\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b¤\u0002\u0010¥\u0002\u001a\u0006\b¦\u0002\u0010§\u0002R'\u0010ª\u0002\u001a\n\u0012\u0005\u0012\u00030©\u00020¨\u00028\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bª\u0002\u0010«\u0002\u001a\u0006\b¬\u0002\u0010\u00ad\u0002R*\u0010¯\u0002\u001a\u00030®\u00028\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b¯\u0002\u0010°\u0002\u001a\u0006\b±\u0002\u0010²\u0002\"\u0006\b³\u0002\u0010´\u0002R,\u0010¶\u0002\u001a\u0005\u0018\u00010µ\u00028\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b¶\u0002\u0010·\u0002\u001a\u0006\b¸\u0002\u0010¹\u0002\"\u0006\bº\u0002\u0010»\u0002R-\u0010½\u0002\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\n0¼\u00020¨\u00028\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b½\u0002\u0010«\u0002\u001a\u0006\b¾\u0002\u0010\u00ad\u0002R)\u0010¿\u0002\u001a\u00020\u00188\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b¿\u0002\u0010ø\u0001\u001a\u0006\b¿\u0002\u0010À\u0002\"\u0006\bÁ\u0002\u0010Â\u0002R \u0010Ä\u0002\u001a\u00030Ã\u00028\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bÄ\u0002\u0010Å\u0002\u001a\u0006\bÆ\u0002\u0010Ç\u0002R\u0019\u0010È\u0002\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÈ\u0002\u0010ø\u0001R\u001c\u0010Ê\u0002\u001a\u0005\u0018\u00010É\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÊ\u0002\u0010Ë\u0002R,\u0010Í\u0002\u001a\u0005\u0018\u00010Ì\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\bÍ\u0002\u0010Î\u0002\u001a\u0006\bÏ\u0002\u0010Ð\u0002\"\u0006\bÑ\u0002\u0010Ò\u0002R)\u0010Ó\u0002\u001a\u00020\u00188\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\bÓ\u0002\u0010ø\u0001\u001a\u0006\bÔ\u0002\u0010À\u0002\"\u0006\bÕ\u0002\u0010Â\u0002¨\u0006Ú\u0002"}, d2 = {"Lcom/bytedance/android/live/profile/NewProfileInfoViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/android/live/profile/usecase/a;", "Lcom/bytedance/android/live/profile/a;", "Lcom/bytedance/android/live/profile/ui/base/h;", "", "runOnFinalDataAvailable", "Lcom/bytedance/android/live/base/model/user/UserProfileDataResp;", "targetUser", "onQueryTargetUserAndSelfUserInfoSuccess", "Lcom/bytedance/android/live/base/model/user/NewProfileUser;", "mTargetUser", "saveDataForJsb", "user", "", "getServerData", "assembleLocalData", "", "toJson", "Landroid/content/Context;", "context", "goLoginFirst", "registerIMPublicGroupCreatePageCallback", "unregisterIMPublicGroupCreatePageCallback", "", "noJumpInLinkCross", "Landroidx/fragment/app/FragmentActivity;", "activity", "douyinOsLiveStates", "canDouyinGoUserLiveRoom", "sendGift", "getTrackLogFrom", "inviteUser", "prepareInviteUser", "canJump", "isFromHourRank", "isShowInMediaRoom", "isMediaAccount", "isUserLogin", "Lcom/bytedance/android/live/profile/model/c;", "input", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "initThisViewModel", "Landroid/view/View;", "rootView", "Lkotlin/Function0;", "doOnFinish", "prepareEnter", "prepareExit", "ensureFinalDataAvailable", "savePreUser", "Lcom/bytedance/android/live/network/response/BaseResponse;", "Lcom/bytedance/android/live/base/model/user/UserProfileDataResp$UserProfileExtra;", "response", "loadData", "", "pageStartTime", "logProfileCardShow", "profileUser", "reportProfileProfitCheck", "onSlideDismiss", "", "status", "updateFollowInfo", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "selfUser", "updateSelfUserFansGroup", "Landroid/app/Activity;", "report", "manage", "atUser", "clickAvatar", "entranceType", "Ljava/lang/Class;", "clazz", "from", "clickShopEntrance", "Landroidx/fragment/app/DialogFragment;", "fragment", "showDressUpCenter", "dialogFragment", "clickEcomSet", "clickOwnerCenter", "clickFansGroupCreate", "clickFansGroupManage", "goStartLive", "showShopEntrance", "dismiss", "isVertical", "isSubscriber", "showFansClub", "sendLog", "showSubscribePanel", "showKtvPanel", "logHighScoreSongShow", "goUserLiveRoom", "goToSquareUserLiveRoom", "", "getSquareJumpTrackParams", "Lcom/bytedance/android/live/profile/model/d;", "getNewPageType", "getRoomDataCenter", "Lcom/bytedance/android/live/profile/model/ProfileRoomProxy;", "getRoom", "getTargetUser", "", "getTargetUserBizExtra", "getPreTargetUser", "getRoomUser", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getLiveRoom", "Lcom/bytedance/android/live/profile/usecase/q;", "getPageTypeUseCase", "Lcom/bytedance/android/live/profile/usecase/r;", "getNewProfileRequestManager", "onCleared", "Lcom/bytedance/android/live/profile/usecase/NewProfileTrackUseCase;", "getLogUseCase", "Lut0/f;", "getLogUseCaseForUi", "canManage", "scheme", "handleDynamicAction", "schema", "showGradePage", "Lcom/bytedance/android/live/base/model/user/GiftExhibitionHomeStats;", "exhibitionInfo", "clickGiftExhibitionCard", "showSquareButtonArea", "shouldShowJumpButton", "attention", "interactLogLabel", "setInteractLogLabel", "loadUserSuccess", "needShowFansGroupIcon", "needShowIMIcon", "Landroidx/fragment/app/Fragment;", "openIM", "showFansGroupDialog", "onVerifyViewClick", "Landroidx/lifecycle/LiveData;", "getFollowInfoLiveData", "getAnonymousSilentLiveData", "showAnonymousUserSilentDialog", "showFlashShop", "kickOut", "showVerifyPage", "showNewCertDescPage", "Lcom/bytedance/android/live/base/model/user/WhiteCategoryCert$SubCertInfo;", "pageInfo", "showWhiteCertPage", "showWhiteCertPageNoLog", "logSubscribeVIPCardShow", "logDressUpCardShow", "logDressUpCardClick", "logOwnerCenterShow", "logOwnerCenterClick", "Lcom/bytedance/android/live/profile/usecase/NewProfileTrackUseCase$LogProfileType;", "type", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "ext", "logProile", "showJumpLinkAnchorButton", "diggExtraInfo", "digg", "Lv32/b;", "getLikeView", "clickDynamicSpaceView", "needPerformHapticFeedback", "Lio/reactivex/Observable;", "wait", "enterWaitFor", "Lcom/bytedance/android/livesdk/chatroom/event/UserProfileEvent;", "getUserProfileEvent", "Lcom/bytedance/android/live/profile/ui/util/DressType;", "dressType", "Lpy/k;", "getDressImageModelWithFallback", "getParallaxAsset", "whenPortrait", "getProfileWidth", "(Ljava/lang/Boolean;)I", "isPad", "Lcom/bytedance/android/live/profile/enum/DressClickArea;", "area", "onDressClick", "eventName", "logMap", "", "args", "(Ljava/lang/String;Ljava/util/Map;[Ljava/lang/Object;)V", "Lcom/bytedance/android/live/profile/enum/TrackArea;", "name", "recordBusinessShow", "map", "recordShowMap", "getFlashCardAsset", "recordBusinessClick", "Landroidx/lifecycle/MutableLiveData;", "targetUserInfoLiveData", "Landroidx/lifecycle/MutableLiveData;", "getTargetUserInfoLiveData", "()Landroidx/lifecycle/MutableLiveData;", "setTargetUserInfoLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "needClose", "getNeedClose", "setNeedClose", "mDataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getMDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "setMDataCenter", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "preTargetUser", "Lcom/bytedance/android/live/base/model/user/NewProfileUser;", "preRoomUserData", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getPreRoomUserData", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setPreRoomUserData", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "getMTargetUser", "()Lcom/bytedance/android/live/base/model/user/NewProfileUser;", "setMTargetUser", "(Lcom/bytedance/android/live/base/model/user/NewProfileUser;)V", "mTargetUserBizExtra", "Ljava/util/Map;", "getMTargetUserBizExtra", "()Ljava/util/Map;", "setMTargetUserBizExtra", "(Ljava/util/Map;)V", "roomUserData", "getRoomUserData", "setRoomUserData", "mTargetUserId", "Ljava/lang/String;", "mTargetSecUserId", "mRoom", "Lcom/bytedance/android/live/profile/model/ProfileRoomProxy;", "mLiveRoom", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "mSelfUserId", "mFromSource", "mEnterLiveSource", "queryUserSuccess", "Z", "mUserProfileEvent", "Lcom/bytedance/android/livesdk/chatroom/event/UserProfileEvent;", "mRequestManager", "Lcom/bytedance/android/live/profile/usecase/r;", "mPageTypeProcess", "Lcom/bytedance/android/live/profile/usecase/q;", "Lut0/c;", "mJumpUseCase", "Lut0/c;", "getMJumpUseCase", "()Lut0/c;", "setMJumpUseCase", "(Lut0/c;)V", "Lcom/bytedance/android/live/profile/usecase/e;", "mFansClubUserCase", "Lcom/bytedance/android/live/profile/usecase/e;", "Lut0/e;", "mManageUseCase", "Lut0/e;", "Lut0/d;", "mLinkUseCase", "Lut0/d;", "Lut0/b;", "mFollowUseCase", "Lut0/b;", "getMFollowUseCase", "()Lut0/b;", "setMFollowUseCase", "(Lut0/b;)V", "mTrackLogUseCase", "Lcom/bytedance/android/live/profile/usecase/NewProfileTrackUseCase;", "getMTrackLogUseCase", "()Lcom/bytedance/android/live/profile/usecase/NewProfileTrackUseCase;", "setMTrackLogUseCase", "(Lcom/bytedance/android/live/profile/usecase/NewProfileTrackUseCase;)V", "Lcom/bytedance/android/live/profile/profilecontext/ProfileContextUseCase;", "mProfileContextUseCase", "Lcom/bytedance/android/live/profile/profilecontext/ProfileContextUseCase;", "Lut0/a;", "mEnterExitUseCase", "Lut0/a;", "Lcom/bytedance/android/live/core/arch/mvvm/d;", "Lcom/bytedance/android/live/profile/model/a;", "enterExitState", "Lcom/bytedance/android/live/core/arch/mvvm/d;", "getEnterExitState", "()Lcom/bytedance/android/live/core/arch/mvvm/d;", "Lcom/bytedance/android/live/core/arch/mvvm/PropertyOwner;", "Lcom/bytedance/android/live/profile/model/b;", "lifecycleState", "Lcom/bytedance/android/live/core/arch/mvvm/PropertyOwner;", "getLifecycleState", "()Lcom/bytedance/android/live/core/arch/mvvm/PropertyOwner;", "Lcom/bytedance/android/live/profile/enum/ProfileMode;", "profileMode", "Lcom/bytedance/android/live/profile/enum/ProfileMode;", "getProfileMode", "()Lcom/bytedance/android/live/profile/enum/ProfileMode;", "setProfileMode", "(Lcom/bytedance/android/live/profile/enum/ProfileMode;)V", "Lcom/bytedance/android/live/profile/monitor/ProfileMonitor;", "profileMonitor", "Lcom/bytedance/android/live/profile/monitor/ProfileMonitor;", "getProfileMonitor", "()Lcom/bytedance/android/live/profile/monitor/ProfileMonitor;", "setProfileMonitor", "(Lcom/bytedance/android/live/profile/monitor/ProfileMonitor;)V", "Lsh6/b;", "finalProfileUser", "getFinalProfileUser", "isMyLive", "()Z", "setMyLive", "(Z)V", "Lcom/bytedance/android/live/profile/event/EventHub;", "eventHub", "Lcom/bytedance/android/live/profile/event/EventHub;", "getEventHub", "()Lcom/bytedance/android/live/profile/event/EventHub;", "clickFollowBeforeFinalUserReady", "Lcom/bytedance/android/livehostapi/platform/IMiddlewareHostAction$IMPublicGroupCreatePageCallback;", "imPublicGroupCreatePageCallback", "Lcom/bytedance/android/livehostapi/platform/IMiddlewareHostAction$IMPublicGroupCreatePageCallback;", "Lu32/j;", "diggHandler", "Lu32/j;", "getDiggHandler", "()Lu32/j;", "setDiggHandler", "(Lu32/j;)V", "hasReportDiggDisable", "getHasReportDiggDisable", "setHasReportDiggDisable", "<init>", "()V", "Companion", "a", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class NewProfileInfoViewModel extends ViewModel implements com.bytedance.android.live.profile.usecase.a, com.bytedance.android.live.profile.a, com.bytedance.android.live.profile.ui.base.h {
    public static final a Companion = null;
    public static final String PAGE_NAME = "personal_profile";
    public static final String TAG = "NewUserProfile";
    public static final int VERIFY_ENTERPRISE = 46;
    public static final int VERIFY_PERSONAL = 47;
    private boolean clickFollowBeforeFinalUserReady;
    private u32.j diggHandler;
    private final com.bytedance.android.live.core.arch.mvvm.d<com.bytedance.android.live.profile.model.a> enterExitState;
    private final EventHub eventHub;
    private final PropertyOwner<sh6.b<NewProfileUser>> finalProfileUser;
    private boolean hasReportDiggDisable;
    private IMiddlewareHostAction.IMPublicGroupCreatePageCallback imPublicGroupCreatePageCallback;
    private boolean isMyLive;
    private final PropertyOwner<com.bytedance.android.live.profile.model.b> lifecycleState;
    private DataCenter mDataCenter;
    private final ut0.a mEnterExitUseCase;
    private String mEnterLiveSource;
    private com.bytedance.android.live.profile.usecase.e mFansClubUserCase;
    private ut0.b mFollowUseCase;
    private String mFromSource;
    private ut0.c mJumpUseCase;
    private ut0.d mLinkUseCase;
    private IRoom mLiveRoom;
    private ut0.e mManageUseCase;
    private q mPageTypeProcess;
    private final ProfileContextUseCase mProfileContextUseCase;
    private r mRequestManager;
    private ProfileRoomProxy mRoom;
    private String mSelfUserId;
    private String mTargetSecUserId;
    private NewProfileUser mTargetUser;
    private Map<String, String> mTargetUserBizExtra;
    private String mTargetUserId;
    private NewProfileTrackUseCase mTrackLogUseCase;
    private UserProfileEvent mUserProfileEvent;
    private MutableLiveData<Boolean> needClose;
    private IBaseUser preRoomUserData;
    private NewProfileUser preTargetUser;
    private ProfileMode profileMode;
    private ProfileMonitor profileMonitor;
    private boolean queryUserSuccess;
    private IBaseUser roomUserData;
    private MutableLiveData<NewProfileUser> targetUserInfoLiveData;

    public static final class a {
        public a() {
        }
    }

    public static final class b extends IMiddlewareHostAction.IMPublicGroupCreatePageCallback {
        public final /* synthetic */ NewProfileInfoViewModel a;
        public final /* synthetic */ Context b;

        public final void onCreateGroupFailed() {
        }

        public final void onCreateGroupSuccess() {
            this.a.dismiss();
            ut0.c r0 = this.a.getMJumpUseCase();
            if (r0 == null) goto L6;
            r0.b(this.b);
            return;
        }

        public final void onCreatePageClose(boolean r1) {
            NewProfileInfoViewModel.access$unregisterIMPublicGroupCreatePageCallback(this.a);
        }

        public b(NewProfileInfoViewModel r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        Companion = new a();
    }

    public boolean needShowIMIcon() {
        return false;
    }

    @Override // com.bytedance.android.live.profile.a
    public void openIM(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    private final boolean canJump() {
        if (this.mPageTypeProcess.c == false) goto L7;
        f2.b(2131920684, 0);
        return false;
    L7:
        if (os0.b.b(this.mDataCenter).isRecording() == false) goto L10;
        f2.b(2131921972, 0);
        return false;
    L10:
        k.b r0 = os0.b.c().getIInteractService().h(this.mDataCenter);
        if (r0 != null) goto L13;
    L16:
        return true;
    L13:
        if (r0.k() != true) goto L16;
        f2.b(2131920696, 0);
        return false;
    }

    private final String getTrackLogFrom() {
        com.bytedance.android.live.profile.model.f.a r0 = com.bytedance.android.live.profile.model.f.f;
        q r1 = this.mPageTypeProcess;
        boolean r2 = r1.c;
        boolean r3 = r1.b;
        boolean r4 = r1.d;
        boolean r5 = true;
        if (r2 == true) goto L23;
        r0.getClass();
        if (r3 == true) goto L8;
        if (r4 == true) goto L8;
        boolean r6 = true;
    L9:
        if (r6 == false) goto L11;
        return "audience_c_audience";
    L11:
        if (r3 == false) goto L14;
        if (r4 == true) goto L14;
        boolean r7 = true;
    L15:
        if (r7 == false) goto L17;
        return "audience_c_anchor";
    L17:
        if (r3 == true) goto L20;
        if (r4 == false) goto L20;
    L21:
        if (r5 == false) goto L38;
        return "audience_c_other_anchor";
    L38:
        return "un_known";
    L20:
        r5 = false;
    L14:
        r7 = false;
    L8:
        r6 = false;
        goto L9
    L23:
        r0.getClass();
        if (r3 == true) goto L27;
        if (r4 == true) goto L27;
        boolean r8 = true;
    L28:
        if (r8 == false) goto L30;
        return "anchor_c_audience";
    L30:
        if (r3 == true) goto L33;
        if (r4 == false) goto L33;
    L34:
        if (r5 == false) goto L36;
        return "anchor_c_other_anchor";
    L36:
        if (r3 == false) goto L38;
        return "anchor_c_anchor";
    L33:
        r5 = false;
    L27:
        r8 = false;
        goto L28
    }

    private final void inviteUser() {
        this.mLinkUseCase.b();
    }

    private final boolean isFromHourRank() {
        UserProfileEvent r0 = this.mUserProfileEvent;
        if (r0 == null) goto L5;
        String r1 = r0.mReportTypeForLog;
    L7:
        return Intrinsics.areEqual("data_card_hourly_rank", r1);
    L5:
        r1 = null;
        goto L7
    }

    private final boolean isMediaAccount() {
        py.c r0 = this.mTargetUser.mAuthenticationInfo;
        if (r0 == null) goto L11;
        py.a r1 = r0.getAccountTypeInfo();
        if (r1 == null) goto L11;
        Map r2 = r1.getTypeMap();
        if (r2 == null) goto L11;
        Boolean r3 = (Boolean) r2.get(1L);
        if (r3 == null) goto L11;
        return r3.booleanValue();
    L11:
        return false;
    }

    private final boolean isShowInMediaRoom() {
        return ((Boolean) rs0.b.a.getValue()).booleanValue();
    }

    private final boolean isUserLogin() {
        return jc1.k.n(IMiddlewareUserService.class).user().isLogin();
    }

    private final boolean noJumpInLinkCross() {
        DataCenter r0 = this.mDataCenter;
        if (r0 == null) goto L7;
        Integer r1 = (Integer) r0.get("data_link_state", 0);
        if (r1 == null) goto L7;
        int r2 = r1.intValue();
    L9:
        if (r2 != 32) goto L11;
    L14:
        boolean r3 = true;
    L15:
        boolean r4 = v.a(r2, 4);
        if (r3 == true) goto L18;
    L30:
        if (r4 == false) goto L34;
        if (os0.b.c().getLinkPlayerState().getData() != 2) goto L34;
    L36:
        return false;
    L34:
        if (os0.b.c().getLinkPlayerState().getData() != 2) goto L36;
        return true;
    L18:
        if (os0.b.c().getLinkPlayerState().getData() != 2) goto L30;
        k.c r5 = os0.b.c().getIInteractService().linkRoomFightService();
        if (r5 == null) goto L25;
        if (r5.k() != true) goto L25;
        return true;
    L25:
        if (os0.b.c().getIInteractService().isInLinkMicGameAnchorLinkMode() == false) goto L28;
        return true;
    L28:
        if (((Boolean) rs0.j.a.getValue()).booleanValue() == true) goto L36;
        return true;
    L11:
        if (r2 == 8) goto L14;
        r3 = false;
    L7:
        r2 = 0;
        goto L9
    }

    private final void prepareInviteUser() {
        this.mLinkUseCase.a();
    }

    private final void runOnFinalDataAvailable() {
        if (this.clickFollowBeforeFinalUserReady == false) goto L6;
        ALogger.i("NewUserProfile_ProfilePre", "continue attention after final user available");
        this.clickFollowBeforeFinalUserReady = false;
        attention(com.bytedance.android.live.core.utils.a.d());
        return;
    }

    private final void sendGift() {
        String r0 = this.mTargetUser.baseProfileInfo.getIdStr();
        o0.a.getClass();
        if ((!o0.a.b(r0)) == false) goto L5;
    L17:
        ALogger.i(TAG, "sendGift with id 0");
        return;
    L5:
        if (this.mRoom.getId() == 0) goto L17;
        boolean r1 = com.bytedance.android.live.revenue.core.util.h.a;
        ca0.j r2 = com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class);
        IBaseUser r3 = this.roomUserData;
        Bundle r4 = new Bundle();
        UserProfileEvent r5 = this.mUserProfileEvent;
        if (r5 == null) goto L10;
        String r6 = r5.getClickUserPosition();
    L12:
        if (Intrinsics.areEqual(r6, "group_live") == false) goto L14;
        String r7 = "group_member_personal_profile";
    L15:
        r4.putString("gift_show_from", r7);
        Unit r8 = Unit.INSTANCE;
        r2.openGiftDialog(r3, r4);
        return;
    L14:
        r7 = "profile_card";
        goto L15
    L10:
        r6 = null;
        goto L12
    }

    private final void unregisterIMPublicGroupCreatePageCallback() {
        IMiddlewareHostAction.IMPublicGroupCreatePageCallback r0 = this.imPublicGroupCreatePageCallback;
        if (r0 == null) goto L9;
        IMiddlewareHostAction r1 = jc1.k.f(IMiddlewareHostAction.class);
        if (r1 == null) goto L7;
        r1.unregisterPublicGroupCreatePageCallback(r0);
    L7:
        this.imPublicGroupCreatePageCallback = null;
        return;
    }

    public boolean canManage() {
        DataCenter r0 = this.mDataCenter;
        if (r0 == null) goto L5;
        IBaseUser r1 = (IBaseUser) r0.get("data_user_in_room");
    L7:
        if (r1 == null) goto L13;
        t r3 = r1.getUserAttrExt();
        if (r3 == null) goto L13;
        if (r3.isAdmin() != true) goto L13;
        boolean r4 = true;
    L14:
        AdminInfo r5 = this.mTargetUser.adminInfo;
        if (r5 == null) goto L17;
        boolean r6 = r5.isAdmin;
    L18:
        StringBuilder r7 = new StringBuilder("user is null = ");
        if (r1 != null) goto L21;
        boolean r2 = true;
    L22:
        r7.append(r2);
        r7.append(", selfIsAdmin=");
        r7.append(r4);
        r7.append(", targetIsAdmin=");
        r7.append(r6);
        ALogger.i(TAG, r7.toString());
        if (r4 == false) goto L26;
        if (r6 == true) goto L26;
        return true;
    L26:
        return false;
    L21:
        r2 = false;
        goto L22
    L17:
        r6 = false;
    L13:
        r4 = false;
        goto L14
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.profile.a, com.bytedance.android.live.profile.ui.base.h
    public void dismiss() {
        this.needClose.postValue(Boolean.FALSE);
    }

    @Override // com.bytedance.android.live.profile.a
    public LiveData<Boolean> getAnonymousSilentLiveData() {
        return this.mManageUseCase.a();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public String getFlashCardAsset() {
        x r0 = this.mProfileContextUseCase.a();
        if (r0 == null) goto L7;
        DressResource.a r1 = (DressResource.a) MapsKt.getOrImplicitDefaultNullable(r0.g, x.i[4].getName());
        if (r1 == null) goto L7;
        return (String) com.bytedance.android.live.profit.dress.config.a.a(r1);
    L7:
        return null;
    }

    @Override // com.bytedance.android.live.profile.a
    public LiveData<Integer> getFollowInfoLiveData() {
        return this.mFollowUseCase.b();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public String getParallaxAsset() {
        x r0 = this.mProfileContextUseCase.a();
        if (r0 == null) goto L7;
        DressResource.a r1 = (DressResource.a) MapsKt.getOrImplicitDefaultNullable(r0.c, x.i[0].getName());
        if (r1 == null) goto L7;
        return (String) com.bytedance.android.live.profit.dress.config.a.a(r1);
    L7:
        return null;
    }

    @Override // com.bytedance.android.live.profile.usecase.a, com.bytedance.android.live.profile.ui.base.h
    public boolean isVertical() {
        DataCenter r0 = this.mDataCenter;
        if (r0 == null) goto L7;
        Boolean r1 = (Boolean) r0.get("data_is_portrait");
        if (r1 == null) goto L7;
        return r1.booleanValue();
    L7:
        return true;
    }

    public void logDressUpCardClick() {
        NewProfileTrackUseCase r0 = this.mTrackLogUseCase;
        String r1 = this.mTargetUserId;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "toUserId");
        HashMap<String, String> r2 = r0.q(r1);
        j0.l().sendLog("livesdk_profile_card_package_click", r2, new Object[]{r0.a, r0.b, IRoom.class});
    }

    public void logDressUpCardShow() {
        NewProfileTrackUseCase r0 = this.mTrackLogUseCase;
        String r1 = this.mTargetUserId;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "toUserId");
        Map r2 = MapsKt.toMutableMap(r0.q(r1));
        if (r0.g.getProfileMode() == ProfileMode.NONE) goto L5;
        String r3 = "open_package";
    L6:
        r2.put("show_from", r3);
        j0.l().sendLog("livesdk_profile_card_package_show", r2, new Object[]{r0.a, r0.b, IRoom.class});
        return;
    L5:
        r3 = DataType.Normal;
        goto L6
    }

    public void logHighScoreSongShow() {
        NewProfileTrackUseCase r0 = this.mTrackLogUseCase;
        r0.B("livesdk_ksong_mark_label_show", r0.r());
    }

    public void logOwnerCenterClick() {
        NewProfileTrackUseCase r0 = this.mTrackLogUseCase;
        r0.getClass();
        HashMap r1 = new HashMap();
        NewProfileUser r2 = r0.g.getTargetUser();
        DressSuitInfo r3 = r2.getDressSuitInfo();
        String r4 = null;
        if (r3 == null) goto L5;
        String r5 = r3.getUserSuitId();
    L6:
        if (r5 != null) goto L8;
    L11:
        boolean r6 = true;
    L12:
        if (r6 == false) goto L14;
        String r7 = "none";
    L18:
        r1.put("package_id", r7);
        r0.B("livesdk_profile_card_personal_center_click", r1);
        return;
    L14:
        DressSuitInfo r8 = r2.getDressSuitInfo();
        if (r8 == null) goto L17;
        r4 = r8.getUserSuitId();
    L17:
        Intrinsics.checkNotNull(r4);
        r7 = r4;
        goto L18
    L8:
        if (r5.length() == 0) goto L11;
        r6 = false;
        goto L12
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.profile.a
    public void logOwnerCenterShow() {
        NewProfileTrackUseCase r0 = this.mTrackLogUseCase;
        r0.getClass();
        HashMap r1 = new HashMap();
        NewProfileUser r2 = r0.g.getTargetUser();
        DressSuitInfo r3 = r2.getDressSuitInfo();
        String r4 = null;
        if (r3 == null) goto L5;
        String r5 = r3.getUserSuitId();
    L6:
        if (r5 != null) goto L8;
    L11:
        boolean r6 = true;
    L12:
        if (r6 == false) goto L14;
        String r7 = "none";
    L18:
        r1.put("package_id", r7);
        if (r0.g.getProfileMode() == ProfileMode.NONE) goto L21;
        String r8 = "open_package";
    L22:
        r1.put("show_from", r8);
        r0.B("livesdk_profile_card_personal_center_show", r1);
        return;
    L21:
        r8 = DataType.Normal;
        goto L22
    L14:
        DressSuitInfo r9 = r2.getDressSuitInfo();
        if (r9 == null) goto L17;
        r4 = r9.getUserSuitId();
    L17:
        Intrinsics.checkNotNull(r4);
        r7 = r4;
        goto L18
    L8:
        if (r5.length() == 0) goto L11;
        r6 = false;
        goto L12
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public void logSubscribeVIPCardShow() {
        NewProfileTrackUseCase r0 = this.mTrackLogUseCase;
        String r1 = this.mTargetUserId;
        String r2 = this.mSelfUserId;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "targetId");
        Intrinsics.checkNotNullParameter(r2, "selfId");
        HashMap r3 = new HashMap();
        o r4 = j0.l().c(am2.x.class);
        String r5 = "";
        if (r4 == null) goto L14;
        String r6 = (String) r4.getMap().get("enter_from_merge");
        if (r6 != null) goto L7;
        r6 = "";
    L7:
        r3.put("enter_from_merge", r6);
        String r7 = (String) r4.getMap().get("enter_method");
        if (r7 != null) goto L10;
        r7 = "";
    L10:
        r3.put("enter_method", r7);
        String r8 = (String) r4.getMap().get("action_type");
        if (r8 != null) goto L13;
        r8 = "";
    L13:
        r3.put("action_type", r8);
    L14:
        com.bytedance.android.livesdk.chatroom.o r9 = os0.b.a();
        Long r10 = null;
        if (r9 == null) goto L19;
        m r12 = r9.getRoom();
        if (r12 == null) goto L19;
        IRoom r13 = (IRoom) r12.getValue();
    L20:
        if (r13 == null) goto L22;
        String r14 = r13.getOwnerUserIdString();
    L23:
        String r15 = String.valueOf(r14);
        r3.put("anchor_id", r15);
        if (r13 == null) goto L26;
        r10 = Long.valueOf(r13.getId());
    L26:
        r3.put("room_id", String.valueOf(r10));
        if (r13 == null) goto L32;
        String r16 = r13.getRequestId();
        if (r16 == null) goto L32;
        r5 = r16;
    L32:
        r3.put("request_id", r5);
        r3.put("card_type", NewProfileTrackUseCase.s(r15, r2, r1));
        if (r0.g.getProfileMode() == ProfileMode.NONE) goto L35;
        String r17 = "open_package";
    L36:
        r3.put("show_from", r17);
        j0.l().sendLog("livesdk_profile_card_livevip_show", r3, new Object[]{am2.o.class});
        return;
    L35:
        r17 = DataType.Normal;
        goto L36
    L22:
        r14 = null;
    L19:
        r13 = null;
        goto L20
    }

    @Override // com.bytedance.android.live.profile.a
    public boolean needPerformHapticFeedback() {
        IBaseDiggService r0 = jc1.k.f(IBaseDiggService.class);
        if (r0 == null) goto L5;
        boolean r1 = r0.needPerformHapticFeedback(this.mDataCenter, 0);
    L6:
        if (r1 == true) goto L10;
        return false;
    L10:
        return true;
    L5:
        r1 = true;
        goto L6
    }

    public boolean needShowFansGroupIcon() {
        if (this.mPageTypeProcess.b == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        boolean r3 = isShowInMediaRoom();
        boolean r4 = isMediaAccount();
        ALogger.i("profile_fans_group_scheme", "needShowFansGroup-true-" + this.mPageTypeProcess.b + "-" + isFromHourRank() + "-" + r3 + "-" + r4);
        if (r0 == false) goto L15;
        if (r3 == true) goto L13;
        if (r4 == false) goto L13;
        return false;
    L13:
        return true;
    L15:
        return false;
    L5:
        if (isFromHourRank() == true) goto L8;
        r0 = false;
        goto L9
    }

    public final void onSlideDismiss() {
        this.mProfileContextUseCase.b.a(new com.bytedance.android.live.profile.model.a(EnterExitStateType.SLIDE_DISMISS));
        this.mProfileContextUseCase.b.a(new com.bytedance.android.live.profile.model.a(EnterExitStateType.COMPLETE));
        this.mProfileContextUseCase.b.onComplete();
    }

    public final void prepareExit() {
        this.mEnterExitUseCase.b(new C03551(this));
    }

    public final void savePreUser() {
        this.preTargetUser = this.mTargetUser;
        this.preRoomUserData = this.roomUserData;
        ALogger.i("NewUserProfile_ProfilePre", "savePreUser, User: " + this.preRoomUserData + ", ProfileUser: " + this.preTargetUser);
    }

    public boolean shouldShowJumpButton() {
        int r0 = com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.e.a;
        UserProfileEvent r1 = this.mUserProfileEvent;
        if (r1 == null) goto L5;
        vh r2 = r1.originRoomInfo;
    L6:
        long r3 = this.mRoom.getId();
        if (r2 != null) goto L10;
        return false;
    L10:
        if (r2.a() == true) goto L12;
        return false;
    L12:
        if (r2.d() == null) goto L30;
        String r4 = r2.d();
        if (r4 != null) goto L16;
    L19:
        boolean r5 = true;
    L20:
        if (r5 == false) goto L22;
        return false;
    L22:
        if (r2.b() != null) goto L25;
        return false;
    L25:
        if (r2.c() == r3) goto L34;
        return true;
    L34:
        return false;
    L16:
        if (r4.length() == 0) goto L19;
        r5 = false;
        goto L20
    L30:
        return false;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.profile.a
    public boolean showJumpLinkAnchorButton() {
        ut0.c r0 = this.mJumpUseCase;
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.showJumpLinkAnchorButton();
    }

    @Override // com.bytedance.android.live.profile.a
    public boolean showSquareButtonArea() {
        UserProfileEvent r0 = this.mUserProfileEvent;
        if (r0 == null) goto L5;
        vh r1 = r0.originRoomInfo;
    L6:
        if (r1 == null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r1 = null;
        goto L6
    }

    public NewProfileInfoViewModel() {
        this.targetUserInfoLiveData = new MutableLiveData();
        this.needClose = new MutableLiveData();
        this.mTargetUser = new NewProfileUser();
        this.roomUserData = vh7.f.c(IBaseUser.class);
        this.mTargetUserId = DataType.FALSE;
        this.mRoom = new ProfileRoomProxy();
        this.mSelfUserId = "-1";
        this.mFromSource = "";
        this.mEnterLiveSource = "";
        this.mRequestManager = new r();
        this.mPageTypeProcess = new q(this.mRoom, this.mSelfUserId, this.mTargetUserId, false);
        this.mManageUseCase = new n(this);
        this.mLinkUseCase = new com.bytedance.android.live.profile.usecase.m(this);
        this.mFollowUseCase = new com.bytedance.android.live.profile.usecase.f(this);
        this.mTrackLogUseCase = new NewProfileTrackUseCase(this);
        ProfileContextUseCase r0 = new ProfileContextUseCase(this);
        this.mProfileContextUseCase = r0;
        this.mEnterExitUseCase = new NewProfileEnterExitUseCase(this, r0.b);
        this.enterExitState = r0.b;
        this.lifecycleState = r0.c;
        this.profileMode = ProfileMode.NONE;
        this.finalProfileUser = new PropertyOwner(sh6.a.a);
        this.eventHub = new EventHub();
    }

    public final void ensureFinalDataAvailable() {
        ProfileMonitor r0 = getProfileMonitor();
        if (r0 == null) goto L5;
        r0.i(TimeType.FinalDataAvailable);
    L5:
        NewProfileUser r1 = getTargetUser();
        PropertyOwner<sh6.b<NewProfileUser>> r2 = getFinalProfileUser();
        Intrinsics.checkNotNullParameter(r2, "$this$valueNullable");
        r2.a(sh6.c.a(r1));
        runOnFinalDataAvailable();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    /* JADX INFO: renamed from: getFinalProfileUser, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ com.bytedance.android.live.core.arch.mvvm.d mo5getFinalProfileUser() {
        return getFinalProfileUser();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    /* JADX INFO: renamed from: getLifecycleState, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ com.bytedance.android.live.core.arch.mvvm.d mo6getLifecycleState() {
        return getLifecycleState();
    }

    @Override // com.bytedance.android.live.profile.usecase.a, com.bytedance.android.live.profile.ui.base.h
    public /* bridge */ /* synthetic */ ps0.b getRoom() {
        return getRoom();
    }

    @Override // com.bytedance.android.live.profile.a
    public Map<String, String> getSquareJumpTrackParams() {
        UserProfileEvent r0 = getUserProfileEvent();
        if (r0 == null) goto L27;
        vh r1 = r0.originRoomInfo;
        if (r1 == null) goto L27;
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("go_to_ta_live_room_id", String.valueOf(r1.c()));
        r2.put("from_comment_id", String.valueOf(r1.a));
        r2.put("from_square_msg_type", "common");
        DataCenter r3 = this.mDataCenter;
        if (r3 == null) goto L10;
        IBaseUser r4 = (IBaseUser) r3.get("data_user_in_room");
    L11:
        if (r4 == null) goto L17;
        t r5 = r4.getUserAttrExt();
        if (r5 == null) goto L17;
        boolean r6 = true;
        if (r5.isAdmin() != true) goto L17;
    L19:
        if (this.mPageTypeProcess.c == false) goto L21;
        String r7 = "anchor";
    L24:
        r2.put("user_type", r7);
        return r2;
    L21:
        if (r6 == false) goto L23;
        r7 = "admin";
        goto L24
    L23:
        r7 = "user";
    L17:
        r6 = false;
        goto L19
    L10:
        r4 = null;
    L27:
        return new LinkedHashMap();
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public boolean isPad() {
        return PadConfigUtils.c();
    }

    public void onCleared() {
        super.onCleared();
        com.bytedance.android.live.profile.usecase.e r0 = this.mFansClubUserCase;
        if (r0 == null) goto L7;
        vlc.d r1 = r0.d;
        if (r1 == null) goto L7;
        r1.removeMessageListener(r0);
    L7:
        this.mRequestManager.a.clear();
        this.mTrackLogUseCase.getClass();
        u32.j r2 = this.diggHandler;
        if (r2 == null) goto L10;
        r2.dispose();
    L10:
        this.mEnterExitUseCase.clear();
        unregisterIMPublicGroupCreatePageCallback();
    }

    @Override // com.bytedance.android.live.profile.a
    public void clickDynamicSpaceView() {
        dismiss();
    }

    public final u32.j getDiggHandler() {
        return this.diggHandler;
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public com.bytedance.android.live.core.arch.mvvm.d<com.bytedance.android.live.profile.model.a> getEnterExitState() {
        return this.enterExitState;
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public EventHub getEventHub() {
        return this.eventHub;
    }

    public final boolean getHasReportDiggDisable() {
        return this.hasReportDiggDisable;
    }

    @Override // com.bytedance.android.live.profile.usecase.a
    public IRoom getLiveRoom() {
        return this.mLiveRoom;
    }

    @Override // com.bytedance.android.live.profile.usecase.a, com.bytedance.android.live.profile.ui.base.h
    public NewProfileTrackUseCase getLogUseCase() {
        return this.mTrackLogUseCase;
    }

    @Override // com.bytedance.android.live.profile.a
    public ut0.f getLogUseCaseForUi() {
        return this.mTrackLogUseCase;
    }

    public final DataCenter getMDataCenter() {
        return this.mDataCenter;
    }

    public final ut0.b getMFollowUseCase() {
        return this.mFollowUseCase;
    }

    public final ut0.c getMJumpUseCase() {
        return this.mJumpUseCase;
    }

    public final NewProfileUser getMTargetUser() {
        return this.mTargetUser;
    }

    public final Map<String, String> getMTargetUserBizExtra() {
        return this.mTargetUserBizExtra;
    }

    public final NewProfileTrackUseCase getMTrackLogUseCase() {
        return this.mTrackLogUseCase;
    }

    public final MutableLiveData<Boolean> getNeedClose() {
        return this.needClose;
    }

    @Override // com.bytedance.android.live.profile.usecase.a
    public r getNewProfileRequestManager() {
        return this.mRequestManager;
    }

    @Override // com.bytedance.android.live.profile.usecase.a, com.bytedance.android.live.profile.ui.base.h
    public q getPageTypeUseCase() {
        return this.mPageTypeProcess;
    }

    public final IBaseUser getPreRoomUserData() {
        return this.preRoomUserData;
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public NewProfileUser getPreTargetUser() {
        return this.preTargetUser;
    }

    @Override // com.bytedance.android.live.profile.usecase.a, com.bytedance.android.live.profile.ui.base.h
    public ProfileMode getProfileMode() {
        return this.profileMode;
    }

    @Override // com.bytedance.android.live.profile.usecase.a, com.bytedance.android.live.profile.ui.base.h
    public ProfileMonitor getProfileMonitor() {
        return this.profileMonitor;
    }

    @Override // com.bytedance.android.live.profile.usecase.a, com.bytedance.android.live.profile.ui.base.h
    public DataCenter getRoomDataCenter() {
        return this.mDataCenter;
    }

    @Override // com.bytedance.android.live.profile.usecase.a, com.bytedance.android.live.profile.ui.base.h
    public IBaseUser getRoomUser() {
        return this.roomUserData;
    }

    public final IBaseUser getRoomUserData() {
        return this.roomUserData;
    }

    @Override // com.bytedance.android.live.profile.usecase.a, com.bytedance.android.live.profile.ui.base.h
    public NewProfileUser getTargetUser() {
        return this.mTargetUser;
    }

    @Override // com.bytedance.android.live.profile.usecase.a
    public Map<String, String> getTargetUserBizExtra() {
        return this.mTargetUserBizExtra;
    }

    public final MutableLiveData<NewProfileUser> getTargetUserInfoLiveData() {
        return this.targetUserInfoLiveData;
    }

    @Override // com.bytedance.android.live.profile.usecase.a, com.bytedance.android.live.profile.ui.base.h
    public UserProfileEvent getUserProfileEvent() {
        return this.mUserProfileEvent;
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public boolean isMyLive() {
        return this.isMyLive;
    }

    @Override // com.bytedance.android.live.profile.usecase.a
    public boolean loadUserSuccess() {
        return this.queryUserSuccess;
    }

    public PropertyOwner<sh6.b<NewProfileUser>> getFinalProfileUser() {
        return this.finalProfileUser;
    }

    public PropertyOwner<com.bytedance.android.live.profile.model.b> getLifecycleState() {
        return this.lifecycleState;
    }

    @Override // com.bytedance.android.live.profile.usecase.a, com.bytedance.android.live.profile.ui.base.h
    public ProfileRoomProxy getRoom() {
        return this.mRoom;
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_live_profile_NewProfileInfoViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(Dialog r1) {
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

    public static final /* synthetic */ String access$getMEnterLiveSource$p(NewProfileInfoViewModel r0) {
        return r0.mEnterLiveSource;
    }

    public static final /* synthetic */ String access$getMTargetUserId$p(NewProfileInfoViewModel r0) {
        return r0.mTargetUserId;
    }

    public static final /* synthetic */ void access$unregisterIMPublicGroupCreatePageCallback(NewProfileInfoViewModel r0) {
        r0.unregisterIMPublicGroupCreatePageCallback();
    }

    private final String assembleLocalData(NewProfileUser r7) {
        String r0 = r7.baseProfileInfo.getIdStr();
        String r8 = r7.baseProfileInfo.secUid;
        if (r8 != null) goto L5;
        r8 = "";
    L5:
        UserProfileEvent r2 = this.mUserProfileEvent;
        if (r2 == null) goto L9;
        String r3 = r2.getClickUserPosition();
        if (r3 == null) goto L9;
    L10:
        LiveMode r9 = this.mRoom.getStreamType();
        int r1 = h1.a;
        Map r10 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click_user_position", r3), TuplesKt.to("user_id", r0), TuplesKt.to("sec_uid", r8), TuplesKt.to("anchor_id", this.mRoom.getOwnerUserIdStr()), TuplesKt.to("room_id", String.valueOf(this.mRoom.getId())), TuplesKt.to("live_type", i1.a(r9))});
        o r4 = j0.l().c(am2.x.class);
        if (r4 == null) goto L31;
        String r5 = (String) r4.getMap().get("enter_from_merge");
        if (r5 != null) goto L15;
        r5 = "";
    L15:
        String r6 = (String) r4.getMap().get("enter_method");
        if (r6 != null) goto L18;
        r6 = "";
    L18:
        r10.put("enter_from_merge", r5);
        String r12 = (String) r10.put("enter_method", r6);
    L31:
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L21
        Object r14 = Result.constructor-impl(toJson(r10));     // Catch: Throwable -> L21
    L24:
        if (Result.isFailure-impl(r14) == false) goto L26;
        r14 = null;
    L26:
        String r15 = (String) r14;
        if (r15 != null) goto L30;
        return "";
    L30:
        return r15;
    L21:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
    L9:
        r3 = "";
        goto L10
    }

    private final boolean canDouyinGoUserLiveRoom(FragmentActivity r2) {
        if (((Boolean) b8.a.getValue()).booleanValue() == true) goto L6;
        return false;
    L6:
        douyinOsLiveStates(r2);
        return true;
    }

    private final void douyinOsLiveStates(final FragmentActivity r4) {
        IMiddlewareRoomService r0 = (IMiddlewareRoomService) jc1.k.f(IMiddlewareRoomService.class);
        if (r0 == null) goto L6;
        r0.checkUerLiveFilterReason(String.valueOf(this.roomUserData.getLiveRoomId()), "183", new AnonymousClass1(this, r4));
        return;
    }

    private final String getServerData(NewProfileUser r2) {
        ProfilePotentialCustomerInfo r0 = r2.potentialCustomerInfo;
        if (r0 == null) goto L8;
        if (r0 != null) goto L9;
        return null;
    L9:
        return r0.subPanelJson;
    L8:
        return r2.anchorAudienceRelationInfo;
    }

    private final void goLoginFirst(Context r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        Bundle r0 = new Bundle();
        IMiddlewareUserService r1 = jc1.k.f(IMiddlewareUserService.class);
        if (r1 == null) goto L22;
        com.bytedance.android.livesdk.user.e r2 = r1.user();
        if (r2 == null) goto L22;
        l.a r3 = new l.a();
        int r4 = vt0.f.a;
        w0 r5 = w0.a;
        ProfileLoginGuideConfig r6 = (ProfileLoginGuideConfig) r5.getValue();
        if (r6 != null) goto L11;
    L13:
        String r8 = s1.B(2131915994);
    L14:
        r3.a = r8;
        ProfileLoginGuideConfig r9 = (ProfileLoginGuideConfig) r5.getValue();
        if (r9 != null) goto L17;
        String r10 = null;
    L18:
        r3.b = r10;
        r3.e = "live_detail";
        r3.h = r0;
        r3.g = "newprofile";
        r3.d = "live";
        r3.c = -1;
        Observable r12 = r2.login(r7, new l(r3));
        if (r12 == null) goto L22;
        r12.subscribe(new com.bytedance.android.livesdk.user.h());
        goto L22
    L17:
        r10 = r9.getImageUrlFromFollow();
        goto L18
    L11:
        if (TextUtils.isEmpty(r6.getFromFollow()) == true) goto L13;
        r8 = r6.getFromFollow();
    L22:
        if (isVertical() == true) goto L25;
        dismiss();
        return;
    }

    private final void onQueryTargetUserAndSelfUserInfoSuccess(UserProfileDataResp r4) {
        IBaseUser r0 = r4.roomUser;
        if (r0 == null) goto L5;
        this.roomUserData = r0;
    L8:
        NewProfileUser r5 = r4.profileUser;
        if (r5 == null) goto L11;
        this.mTargetUser = r5;
    L14:
        ALogger.i("NewUserProfile_ProfilePre", "set User: " + this.roomUserData + ", ProfileUser: " + this.mTargetUser);
        NewProfileUser r6 = this.mTargetUser;
        if (r6.baseProfileInfo != null) goto L17;
        r6.baseProfileInfo = new BaseProfileInfo();
    L17:
        saveDataForJsb(this.mTargetUser);
        UserProfileEvent r7 = this.mUserProfileEvent;
        if (r7 == null) goto L20;
        this.mTargetUser.setFromOtherIntercomRoom(r7.isFromOtherIntercomRoom());
    L20:
        this.mFollowUseCase.c(this.mTargetUser.isFollowed());
        com.bytedance.android.live.profile.usecase.e r8 = this.mFansClubUserCase;
        if (r8 == null) goto L31;
        ProfileFansClub r1 = this.mTargetUser.fansClub;
        boolean r2 = false;
        if (r1 == null) goto L27;
        ProfileFansClubData r3 = r1.getData();
        if (r3 == null) goto L27;
        int r9 = r3.userFansClubStatus;
    L28:
        if (r9 <= 0) goto L30;
        r2 = true;
    L30:
        r8.a = r2;
    L27:
        r9 = 0;
    L31:
        this.targetUserInfoLiveData.postValue(this.mTargetUser);
        this.queryUserSuccess = true;
        this.mLinkUseCase.c();
        return;
    L11:
        ProfileMonitor r10 = getProfileMonitor();
        if (r10 == null) goto L14;
        r10.g(EventType.ProfileUserInRespIsNull);
        goto L14
    L5:
        ProfileMonitor r12 = getProfileMonitor();
        if (r12 == null) goto L8;
        r12.g(EventType.RoomUserInRespIsNull);
        goto L8
    }

    private final void registerIMPublicGroupCreatePageCallback(Context r2) {
        this.imPublicGroupCreatePageCallback = new b(this, r2);
        IMiddlewareHostAction r3 = jc1.k.f(IMiddlewareHostAction.class);
        if (r3 == null) goto L6;
        r3.registerPublicGroupCreatePageCallback(this.imPublicGroupCreatePageCallback);
        return;
    }

    private final void saveDataForJsb(NewProfileUser r5) {
        if (r5 == null) goto L7;
        String r0 = this.mTargetUserId;
        String r1 = getServerData(r5);
        String r6 = assembleLocalData(r5);
        ns0.a r2 = ns0.c.a();
        if (r2 == null) goto L8;
        r2.setPersonCardData(r0.toString(), new ps0.c(r6, r1));
        return;
    L8:
        return;
    }

    private final String toJson(Object r2) {
        return GsonProtectorUtils.toJson(new Gson(), r2);
    }

    @Override // com.bytedance.android.live.profile.a
    public void atUser(Context r17) {
        NewProfileTrackUseCase r1 = this.mTrackLogUseCase;
        r1.getClass();
        HashMap r2 = new HashMap();
        NewProfileUser r3 = r1.g.getTargetUser();
        DressSuitInfo r4 = r3.getDressSuitInfo();
        String r5 = null;
        if (r4 == null) goto L5;
        String r6 = r4.getUserSuitId();
    L6:
        int r7 = 0;
        if (r6 != null) goto L9;
    L12:
        boolean r8 = true;
    L13:
        if (r8 == false) goto L15;
        String r9 = "none";
    L19:
        r2.put("package_id", r9);
        r1.B("livesdk_profile_card_at_click", r2);
        r1.B("livesdk_profile_card_atTA_click", r2);
        if (isUserLogin() == true) goto L24;
        goLoginFirst(r17);
        return;
    L24:
        if (jc1.k.n(IMiddlewareUserService.class).user().g(LiveInteractFunction.AT) == false) goto L27;
        ALogger.i(TAG, "livesdk_new_profile_load_interceptOperation-at");
        return;
    L27:
        dismiss();
        BaseProfileInfo r10 = this.mTargetUser.baseProfileInfo;
        String r12 = "";
        if (r10 == null) goto L31;
        String r13 = r10.nickName;
        if (r13 == null) goto L31;
    L32:
        boolean r14 = this.mPageTypeProcess.b;
        String r15 = this.mTargetUserId;
        o0.a.getClass();
        if (o0.a.b(r15) == false) goto L35;
        r12 = this.mTargetUserId.toString();
    L35:
        u22.m.a r16 = new u22.m.a(PAGE_NAME, r14, r12, 3, r13, 0, getRoomUser().getWebcastUid());
        r16.j = getRoomUser();
        u22.m r18 = new u22.m(r13);
        r18.l = OpenInputSource.ProfileAt;
        r18.e = r16;
        UserProfileEvent r19 = this.mUserProfileEvent;
        if (r19 == null) goto L38;
        r7 = r19.fromRoomChannelType;
    L38:
        r18.m = r7;
        xs2.b.a().post(r18);
        DataCenter r20 = this.mDataCenter;
        if (r20 == null) goto L42;
        r20.put("cmd_wanna_send_message", r18);
        return;
    L42:
        return;
    L31:
        r13 = "";
        goto L32
    L15:
        DressSuitInfo r22 = r3.getDressSuitInfo();
        if (r22 == null) goto L18;
        r5 = r22.getUserSuitId();
    L18:
        Intrinsics.checkNotNull(r5);
        r9 = r5;
        goto L19
    L9:
        if (r6.length() == 0) goto L12;
        r8 = false;
        goto L13
    L5:
        r6 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.profile.a
    public void attention(Context r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (isUserLogin() == true) goto L8;
        goLoginFirst(r4);
        return;
    L8:
        boolean r1 = false;
        if (NetworkUtils.f(r4) == true) goto L12;
        f2.b(2131916005, 0);
        return;
    L12:
        Intrinsics.checkNotNullParameter(this, "$this$isFinalUserAvailable");
        if (com.bytedance.android.live.core.arch.mvvm.f.a(mo5getFinalProfileUser()) == null) goto L15;
        r1 = true;
    L15:
        if (r1 == true) goto L18;
        ALogger.i("NewUserProfile_ProfilePre", "click follow button before final user available");
        this.clickFollowBeforeFinalUserReady = true;
        return;
    L18:
        ut0.b r0 = this.mFollowUseCase;
        UserProfileEvent r2 = this.mUserProfileEvent;
        if (r2 == null) goto L22;
        String r3 = r2.getClickUserPosition();
        if (r3 == null) goto L22;
    L23:
        r0.d(r4, r3, this.mFromSource);
        return;
    L22:
        r3 = "";
        goto L23
    }

    @Override // com.bytedance.android.live.profile.a
    public void clickAvatar(FragmentActivity r15) {
        Intrinsics.checkNotNullParameter(r15, "activity");
        String r0 = this.mTargetUser.baseProfileInfo.getIdStr();
        o0.a.getClass();
        if ((!o0.a.b(r0)) == false) goto L6;
        return;
    L6:
        if (this.mTargetUser.isVcdContentAuthorized() == true) goto L12;
        if (this.mPageTypeProcess.c == true) goto L108;
        f2.c(((ss0.e) rs0.v.a.getValue()).userpreviewToast, 0);
        return;
    L108:
        return;
    L12:
        if (canJump() == true) goto L15;
        return;
    L15:
        if (noJumpInLinkCross() == false) goto L18;
        f2.b(2131919283, 0);
        return;
    L18:
        NewProfileTrackUseCase r1 = this.mTrackLogUseCase;
        String r3 = this.mTargetUserId;
        boolean r4 = this.mPageTypeProcess.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "userId");
        Intrinsics.checkNotNullParameter("personal_profile_head", "from");
        HashMap r6 = new HashMap();
        r6.put("to_user_id", r3.toString());
        String r5 = DataType.FALSE;
        if (r4 == false) goto L21;
        Object r7 = DataType.TRUE;
    L22:
        r6.put("is_anchor", r7);
        r6.put("enter_position", "personal_profile_head");
        if (os0.b.c().getLinkPlayerState().getData() != 2) goto L25;
        Object r8 = DataType.TRUE;
    L26:
        r6.put("is_line", r8);
        os0.b.c().getLiveSdkLogUtil().e(r6);
        os0.b.c().getLiveSdkLogUtil().c(r6);
        com.bytedance.android.livesdk.chatroom.o r9 = os0.b.a();
        if (r9 == null) goto L33;
        m r10 = r9.isCleanMode();
        if (r10 == null) goto L33;
        if (((Boolean) r10.getValue()).booleanValue() != true) goto L33;
        Object r12 = DataType.TRUE;
    L34:
        r6.put("if_clear_mode", r12);
        r1.B("livesdk_enter_personal_detail", r6);
        NewProfileTrackUseCase r2 = this.mTrackLogUseCase;
        r2.getClass();
        int r13 = vt0.d.a;
        String r14 = String.valueOf(r2.g.getRoom().getId());
        IBaseUser r16 = r2.g.getRoomUser();
        Intrinsics.checkNotNullParameter(r14, "roomId");
        o r17 = j0.l().c(am2.x.class);
        o r18 = j0.l().c(IRoom.class);
        HashMap r19 = new HashMap();
        String r110 = "";
        if (r18 != null) goto L37;
    L42:
        if (r17 != null) goto L44;
    L62:
        String r20 = null;
        if (r16 == null) goto L65;
        String r22 = r16.getIdString();
    L66:
        r19.put("anchor_id", String.valueOf(r22));
        r19.put("room_id", r14);
        r19.put("scene_channel", "live");
        if (r16 == null) goto L69;
        py.c r23 = r16.getMAuthenticationInfo();
    L70:
        if (r23 == null) goto L72;
        r5 = DataType.TRUE;
    L72:
        r19.put("is_enterprise", r5);
        r19.put("action_type", "click");
        r19.put("enter_method", "live_cell");
        j0.l().h("enter_personal_detail", r19, new Object[0]);
        NewProfileTrackUseCase r24 = this.mTrackLogUseCase;
        String r25 = this.mTargetUserId;
        r24.getClass();
        Intrinsics.checkNotNullParameter("profile_card", "clickPosition");
        Intrinsics.checkNotNullParameter(r25, "toUserId");
        HashMap r26 = new HashMap();
        NewProfileUser r27 = r24.g.getTargetUser();
        DressSuitInfo r28 = r27.getDressSuitInfo();
        if (r28 == null) goto L75;
        String r29 = r28.getUserSuitId();
    L76:
        if (r29 != null) goto L78;
    L81:
        boolean r30 = true;
    L82:
        if (r30 == false) goto L84;
        String r32 = "none";
    L88:
        r26.put("wear_id", r32);
        r26.put("click_user_position", "profile_card");
        r26.put("to_user_id", r25.toString());
        if (NewProfileTrackUseCase.u() == false) goto L91;
        r26.put("user_type", "anchor");
    L103:
        j0.l().sendLog("livesdk_live_click_user", r26, new Object[]{am2.x.class, IRoom.class});
        ut0.c r33 = this.mJumpUseCase;
        if (r33 == null) goto L106;
        r33.g(r15);
    L106:
        dismiss();
        return;
    L91:
        IMiddlewareUserService r34 = jc1.k.f(IMiddlewareUserService.class);
        if (r34 == null) goto L102;
        com.bytedance.android.livesdk.user.e r35 = r34.user();
        if (r35 == null) goto L102;
        IBaseUser r36 = r35.b();
        if (r36 == null) goto L102;
        t r37 = r36.getUserAttrExt();
        if (r37 == null) goto L102;
        if (r37.isAdmin() != true) goto L102;
        r26.put("user_type", "admin");
    L102:
        r26.put("user_type", "user");
        goto L103
    L84:
        DressSuitInfo r38 = r27.getDressSuitInfo();
        if (r38 == null) goto L87;
        r20 = r38.getUserSuitId();
    L87:
        Intrinsics.checkNotNull(r20);
        r32 = r20;
        goto L88
    L78:
        if (r29.length() == 0) goto L81;
        r30 = false;
        goto L82
    L75:
        r29 = null;
        goto L76
    L69:
        r23 = null;
        goto L70
    L65:
        r22 = null;
        goto L66
    L44:
        if (r17.getMap().containsKey("video_id") == false) goto L50;
        String r39 = (String) r17.getMap().get("video_id");
        if (r39 != null) goto L48;
        r39 = "";
    L48:
        r19.put("group_id", r39);
    L50:
        if (r17.getMap().containsKey("enter_from_merge") == false) goto L56;
        String r40 = (String) r17.getMap().get("enter_from_merge");
        if (r40 != null) goto L54;
        r40 = "";
    L54:
        r19.put("enter_from_merge", r40);
    L56:
        if (r17.getMap().containsKey("search_params") == false) goto L62;
        String r42 = (String) r17.getMap().get("search_params");
        if (r42 == null) goto L61;
        r110 = r42;
    L61:
        r19.put("search_params", r110);
        goto L62
    L37:
        if (r18.getMap().containsKey("request_id") == false) goto L42;
        String r43 = (String) r18.getMap().get("request_id");
        if (r43 != null) goto L41;
        r43 = "";
    L41:
        r19.put("request_id", r43);
    L33:
        r12 = DataType.FALSE;
        goto L34
    L25:
        r8 = DataType.FALSE;
        goto L26
    L21:
        r7 = DataType.FALSE;
        goto L22
    }

    @Override // com.bytedance.android.live.profile.a
    public void clickFansGroupCreate(Context r5) {
        ut0.c r0 = this.mJumpUseCase;
        if (r0 == null) goto L5;
        r0.f(r5);
    L5:
        this.mTrackLogUseCase.getClass();
        j0.l().h("click_create_public_group_entry", MapsKt.mapOf(new Pair[]{TuplesKt.to("enter_method", "profile_card"), TuplesKt.to("enter_from", "live_room")}), new Object[0]);
        unregisterIMPublicGroupCreatePageCallback();
        registerIMPublicGroupCreatePageCallback(r5);
    }

    @Override // com.bytedance.android.live.profile.a
    public void clickFansGroupManage(Context r2) {
        ut0.c r0 = this.mJumpUseCase;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public void enterWaitFor(Observable<Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "wait");
        this.mEnterExitUseCase.enterWaitFor(r2);
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public py.k getDressImageModelWithFallback(DressType r3) {
        Intrinsics.checkNotNullParameter(r3, "dressType");
        ProfileContextUseCase r1 = this.mProfileContextUseCase;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "dressType");
        return com.bytedance.android.live.profile.ui.util.l.a(r1.d.getTargetUser(), r3, r1.a());
    }

    @Override // com.bytedance.android.live.profile.a
    public v32.b getLikeView(Context r4) {
        DataCenter r0 = this.mDataCenter;
        if (r0 == null) goto L8;
        IBaseDiggService r2 = jc1.k.f(IBaseDiggService.class);
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getLikeView(r4, r0);
    L8:
        return null;
    }

    public final com.bytedance.android.live.profile.model.d getNewPageType(NewProfileUser r2) {
        return this.mPageTypeProcess.a(r2);
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public int getProfileWidth(Boolean r3) {
        if (r3 != null) goto L9;
        ProfileContextUseCase r4 = this.mProfileContextUseCase;
        boolean r1 = isVertical();
        r4.getClass();
        if (r1 == false) goto L8;
        return j.a();
    L8:
        return UtilityKotlinExtentionsKt.i(340);
    L9:
        ProfileContextUseCase r2 = this.mProfileContextUseCase;
        boolean r5 = r3.booleanValue();
        r2.getClass();
        if (r5 == false) goto L13;
        return j.a();
    L13:
        return UtilityKotlinExtentionsKt.i(340);
    }

    @Override // com.bytedance.android.live.profile.a
    public void goStartLive(DialogFragment r5) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        JSONObject r0 = new JSONObject();
        r0.put("enter_from", "my_live");
        r0.put("enter_from_merge", "my_live");
        r0.put("previous_page", "my_live");
        String r1 = UriProtector.parse("sslocal://video_record?record_type=live").buildUpon().appendQueryParameter("source_params", r0.toString()).build().toString();
        IBaseLiveActionHandler r2 = jc1.k.f(IBaseLiveActionHandler.class);
        if (r2 == null) goto L5;
        r2.handle(r5.getContext(), r1);
    L5:
        j0.l().sendLog("livesdk_my_live_page_live_take_click", MapsKt.mapOf(new Pair[]{TuplesKt.to("user_id ", this.mTargetUserId.toString()), TuplesKt.to("room_id", String.valueOf(this.mRoom.getId())), TuplesKt.to("anchor_id", this.mRoom.getOwnerUserIdStr())}), new Object[0]);
        dismiss();
    }

    @Override // com.bytedance.android.live.profile.a
    public void goToSquareUserLiveRoom(FragmentActivity r5) {
        if (canJump() == true) goto L5;
        return;
    L5:
        boolean r1 = false;
        if (noJumpInLinkCross() == false) goto L10;
        f2.b(2131920696, 0);
        return;
    L10:
        if (canDouyinGoUserLiveRoom(r5) == false) goto L12;
        return;
    L12:
        UserProfileEvent r0 = getUserProfileEvent();
        if (r0 == null) goto L40;
        vh r2 = r0.originRoomInfo;
        if (r2 == null) goto L41;
        String r3 = r2.d();
        if (r3 == null) goto L42;
        UserProfileEvent r4 = getUserProfileEvent();
        if (r4 == null) goto L26;
        vh r6 = r4.originRoomInfo;
        if (r6 == null) goto L26;
        if (r6.e() != true) goto L26;
        r1 = true;
    L26:
        if (r1 == false) goto L28;
        String r7 = "audience_c_anchor";
    L38:
        JSONObject r8 = new JSONObject();     // Catch: Exception -> L31
        r8.put("profile_card_target_scene", r7);     // Catch: Exception -> L31
        r8.put("pre_enter_from", "square_msg");     // Catch: Exception -> L31
        r3 = r3 + "&extra_params=" + r8.toString();     // Catch: Exception -> L31
    L33:
        IBaseLiveActionHandler r9 = jc1.k.f(IBaseLiveActionHandler.class);
        if (r9 == null) goto L36;
        r9.handle(r5, r3);
    L36:
        dismiss();
        return;
    L31:
        e = move-exception;
        SafetyGuard.a("square_tab", e, null);
        goto L33
    L28:
        r7 = "audience_c_audience";
        goto L38
    L42:
        return;
    L41:
        return;
    }

    @Override // com.bytedance.android.live.profile.a
    public void goUserLiveRoom(FragmentActivity r4) {
        if (canJump() == true) goto L6;
        return;
    L6:
        if (noJumpInLinkCross() == false) goto L10;
        f2.b(2131920696, 0);
        return;
    L10:
        if (canDouyinGoUserLiveRoom(r4) == false) goto L12;
        return;
    L12:
        ut0.c r0 = this.mJumpUseCase;
        if (r0 == null) goto L15;
        r0.e(r4, this.mEnterLiveSource, this.roomUserData);
    L15:
        this.mTrackLogUseCase.x(this.mTargetUserId, this.mTargetUser.getLiveRoomId());
        dismiss();
    }

    @Override // com.bytedance.android.live.profile.a
    public void kickOut(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Dialog r10 = os0.b.b(this.mDataCenter).getEnsureKickOutDialog(r9, this.mRoom.getId(), this.mRoom.getOwnerUserIdStr(), this.mTargetUserId, this.mTargetSecUserId);
        if (r10 == null) goto L6;
        INVOKEVIRTUAL_com_bytedance_android_live_profile_NewProfileInfoViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r10);
        return;
    }

    public final void loadData(BaseResponse<UserProfileDataResp, UserProfileDataResp.UserProfileExtra> r5) {
        String r2 = null;
        Map<String, String> r3 = null;
        r2 = null;
        if (r5 != null) goto L37;
        UserProfileDataResp.UserProfileExtra r4 = null;
    L9:
        if ((r4 instanceof UserProfileDataResp.UserProfileExtra) == false) goto L24;
        if (r5 == null) goto L14;
        UserProfileDataResp.UserProfileExtra r0 = r5.extra;     // Catch: Exception -> L5
        if (r0 == null) goto L14;
        this.mManageUseCase.b(r0.anonymousIsSilence);     // Catch: Exception -> L5
    L14:
        if (r5 == null) goto L32;
        UserProfileDataResp.UserProfileExtra r1 = r5.extra;     // Catch: Exception -> L5
        if (r1 == null) goto L32;
        Map<String, String> r6 = r1.bizExtra;     // Catch: Exception -> L5
        if (r6 == null) goto L32;
        if ((!r6.isEmpty()) == false) goto L22;
        r3 = r6;
    L22:
        if (r3 == null) goto L32;
        this.mTargetUserBizExtra = r3;     // Catch: Exception -> L5
    L32:
        if (r5 == null) goto L38;
        UserProfileDataResp r7 = (UserProfileDataResp) r5.data;
        if (r7 == null) goto L39;
        onQueryTargetUserAndSelfUserInfoSuccess(r7);
        return;
    L39:
        return;
    L38:
        return;
    L24:
        StringBuilder r8 = new StringBuilder("extra cast error:");     // Catch: Exception -> L5
        if (r5 == null) goto L29;
        UserProfileDataResp.UserProfileExtra r9 = r5.extra;     // Catch: Exception -> L5
        if (r9 == null) goto L29;
        r2 = r9.getClass().getSimpleName();     // Catch: Exception -> L5
    L29:
        r8.append(r2);     // Catch: Exception -> L5
        ALogger.e(TAG, r8.toString());     // Catch: Exception -> L5
        goto L32
    L37:
        r4 = r5.extra;     // Catch: Exception -> L5
    L5:
        e = move-exception;
        ALogger.e(TAG, "extra-error:" + e);
        goto L32
    }

    public final void logProfileCardShow(long r17) {
        if (isMyLive() == false) goto L5;
        this.mTrackLogUseCase.getClass();
        j0.l().sendLog("livesdk_my_live_profile_card_show", null, new Object[]{IRoom.class, am2.x.class});
        return;
    L5:
        NewProfileTrackUseCase r1 = this.mTrackLogUseCase;
        UserProfileEvent r6 = this.mUserProfileEvent;
        String r7 = "";
        if (r6 == null) goto L9;
        String r8 = r6.getClickUserPosition();
        if (r8 == null) goto L9;
    L10:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r8, "position");
        r1.d = r8;
        NewProfileUser r9 = r1.g.getTargetUser();
        boolean r10 = r1.g.getPageTypeUseCase().c;
        ps0.b r12 = r1.g.getRoom();
        boolean r13 = r1.g.getPageTypeUseCase().b;
        s r14 = os0.b.c().getIMicRoomService();
        boolean r15 = r12.a();
        if (r14 == null) goto L14;
        if (r15 == false) goto L14;
        r14.isLoyalAudience();
    L14:
        if (r15 == false) goto L16;
        os0.b.c().getIInteractService().isMicRoomHost(r9.baseProfileInfo.getIdStr());
    L16:
        HashMap r16 = new HashMap();
        r16.put("to_user_id", r9.baseProfileInfo.getIdStr());
        r16.put("target_user_id", r9.baseProfileInfo.getIdStr());
        BaseProfileInfo r18 = r9.baseProfileInfo;
        if (r18 == null) goto L20;
        String r19 = r18.nickName;
        if (r19 == null) goto L20;
    L21:
        r16.put("target_user_name", r19);
        BaseProfileInfo r110 = r9.baseProfileInfo;
        if (r110 == null) goto L25;
        String r111 = r110.nickName;
        if (r111 == null) goto L25;
    L26:
        r16.put("to_user_name", r111);
        int r112 = vt0.h.a;
        IMiddlewareUserService r113 = jc1.k.f(IMiddlewareUserService.class);
        if (r113 == null) goto L31;
        com.bytedance.android.livesdk.user.e r114 = r113.user();
        if (r114 == null) goto L31;
        String r115 = r114.n();
    L32:
        r16.put("request_page", vt0.h.a(String.valueOf(r115), r9.baseProfileInfo.getIdStr(), r12.getOwnerUserIdStr()));
        int r116 = os0.b.c().getLinkPlayerState().getData();
        String r117 = DataType.FALSE;
        if (r116 != 2) goto L35;
        Object r118 = DataType.TRUE;
    L36:
        r16.put("is_line", r118);
        if (r1.g.getProfileMode() == ProfileMode.NONE) goto L39;
        r8 = "open_package";
    L39:
        r16.put("click_user_position", r8);
        DressSuitInfo r20 = r9.getDressSuitInfo();
        if (r20 == null) goto L42;
        String r22 = r20.getUserSuitId();
    L43:
        if (r22 != null) goto L45;
    L48:
        boolean r23 = true;
    L49:
        if (r23 == false) goto L51;
        String r24 = "none";
    L56:
        r16.put("package_id", r24);
        if (r1.g.getPageTypeUseCase().a == false) goto L59;
        Object r25 = DataType.TRUE;
    L60:
        r16.put("is_self", r25);
        if (r9.industryCertification == null) goto L63;
        r16.put("is_jade_room", DataType.TRUE);
        r16.put("EVENT_ORIGIN_FEATURE", "TEMAI");
    L63:
        int r26 = vt0.e.a;
        r16.put("user_type", vt0.e.a(r12.getOwnerUserIdStr(), r9.baseProfileInfo.getIdStr()));
        os0.b.c().getLiveSdkLogUtil().e(r16);
        os0.b.c().getLiveSdkLogUtil().c(r16);
        boolean r27 = com.bytedance.android.live.revenue.core.util.h.a;
        kc0.e r28 = ((ILinkService) com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class)).getRevLinkControlService();
        if (r28 == null) goto L66;
        String r29 = r28.getConnectionType();
    L68:
        if (r29 == null) goto L70;
        r16.put("connection_type", r29);
    L70:
        com.bytedance.android.livesdk.chatroom.o r30 = os0.b.a();
        if (r30 == null) goto L78;
        m r32 = r30.getRoom();
        if (r32 == null) goto L78;
        IRoom r33 = (IRoom) r32.getValue();
        if (r33 == null) goto L78;
        String r34 = r33.getOwnerUserIdString();
        if (r34 == null) goto L78;
    L79:
        IMiddlewareUserService r119 = jc1.k.f(IMiddlewareUserService.class);
        if (r119 == null) goto L84;
        com.bytedance.android.livesdk.user.e r120 = r119.user();
        if (r120 == null) goto L84;
        String r121 = r120.n();
    L85:
        String r122 = String.valueOf(r121);
        if (r1.g.getProfileMode() != ProfileMode.USER_BEFORE) goto L89;
        r16.put("show_type", "before");
    L91:
        ((ILinkService) com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class)).mo471getRevenueLinkDataHolder();
        UserProfileEvent r4 = r1.g.getUserProfileEvent();
        if (r4 == null) goto L96;
        Map r5 = r4.getExtraProfileShowLog();
        if (r5 == null) goto L96;
        r16.putAll(r5);
    L96:
        kc0.e r35 = ((ILinkService) com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class)).getRevLinkControlService();
        if (r35 == null) goto L99;
        Map r36 = r35.h();
    L100:
        if (r36 == null) goto L131;
        String r123 = (String) r36.get("anchor_connect_status");
        if (r123 != null) goto L104;
        r123 = "";
    L104:
        r16.put("anchor_connect_status", r123);
        String r124 = (String) r36.get("room_status");
        if (r124 != null) goto L107;
        r124 = "";
    L107:
        r16.put("room_status", r124);
        if (Intrinsics.areEqual(r34, r122) == false) goto L110;
        Object r37 = DataType.TRUE;
    L111:
        r16.put("is_anchor", r37);
        String r38 = (String) r36.get("invite_mode");
        if (r38 != null) goto L114;
        r38 = "";
    L114:
        r16.put("invite_mode", r38);
        String r39 = (String) r36.get("connection_type");
        if (r39 != null) goto L117;
        r39 = "";
    L117:
        r16.put("connection_type", r39);
        String r40 = (String) r36.get("connection_sub_type");
        if (r40 != null) goto L120;
        r40 = "";
    L120:
        r16.put("connection_sub_type", r40);
        String r42 = (String) r36.get("invitee_list");
        if (r42 != null) goto L123;
        r42 = "";
    L123:
        r16.put("invitee_list", r42);
        String r43 = (String) r36.get("is_manager");
        if (r43 != null) goto L126;
        r43 = "";
    L126:
        r16.put("is_manager", r43);
        String r44 = (String) r36.get("is_game_connection");
        if (r44 == null) goto L130;
        r7 = r44;
    L130:
        r16.put("is_game_connection", r7);
        goto L131
    L110:
        r37 = DataType.FALSE;
    L131:
        com.bytedance.android.live.profile.usecase.s r45 = r1.f;
        r45.getClass();
        Intrinsics.checkNotNullParameter(r16, "map");
        r45.a(r16);
        Intrinsics.checkNotNullParameter(r16, "map");
        r16.putAll(r45.b);
        IRoomOthersData r46 = r12.k3();
        if (r46 == null) goto L153;
        IGroupLiveData r47 = r46.getGroupData();
        if (r47 == null) goto L153;
        if (r47.isGroupLive() != 1) goto L153;
        r16.put("is_grouped_lived", DataType.TRUE);
        ProfileStyleParams r48 = r9.getProfileStyleParams();
        if (r48 == null) goto L140;
        Long r49 = Long.valueOf(r48.getProfileStyle());
    L141:
        long r50 = ProfileStyleParams.GROUP_LIVE;
        if (r49 != null) goto L145;
    L147:
        long r52 = ProfileStyleParams.HONOUR;
        if (r49 != null) goto L151;
    L154:
        Map<String, String> r53 = r1.g.getTargetUserBizExtra();
        if (r53 == null) goto L160;
        Iterator<Map.Entry<String, String>> r54 = r53.entrySet().iterator();
    L158:
        if (r54.hasNext() == false) goto L160;
        Map.Entry<String, String> r55 = r54.next();
        r16.put(r55.getKey(), r55.getValue());
    L160:
        LiveAgentInfo r56 = r9.liveAgentInfo;
        if (r56 != null) goto L163;
    L166:
        j0.l().sendLog("livesdk_profile_card_show", r16, new Object[]{xs0.a.a(), r1.a, r1.b, IRoom.class});
        IGiftServiceExternal r2 = jc1.k.f(IGiftServiceExternal.class);
        if (r2 == null) goto L174;
        ca0.o r3 = r2.getRevenueEventCenter();
        if (r3 == null) goto L175;
        r3.g();
        return;
    L175:
        return;
    L174:
        return;
    L163:
        if (r56.opened() == false) goto L165;
        r117 = "2";
    L165:
        r16.put("room_avatar_status", r117);
        goto L166
    L151:
        if (r49.longValue() != r52) goto L154;
        r16.put("group_show_type", "honor");
        goto L154
    L145:
        if (r49.longValue() != r50) goto L147;
        r16.put("group_show_type", "member");
        goto L154
    L140:
        r49 = null;
    L153:
        r16.put("is_grouped_lived", DataType.FALSE);
        goto L154
    L99:
        r36 = null;
        goto L100
    L89:
        if (r1.g.getProfileMode() != ProfileMode.USER_CURRENT) goto L91;
        r16.put("show_type", "after");
    L84:
        r121 = null;
    L78:
        r34 = DataType.FALSE;
        goto L79
    L66:
        r29 = null;
        goto L68
    L59:
        r25 = DataType.FALSE;
        goto L60
    L51:
        DressSuitInfo r57 = r9.getDressSuitInfo();
        if (r57 == null) goto L54;
        r24 = r57.getUserSuitId();
    L55:
        Intrinsics.checkNotNull(r24);
        goto L56
    L54:
        r24 = null;
        goto L55
    L45:
        if (r22.length() == 0) goto L48;
        r23 = false;
        goto L49
    L42:
        r22 = null;
        goto L43
    L35:
        r118 = DataType.FALSE;
    L31:
        r115 = null;
    L25:
        r111 = "";
    L20:
        r19 = "";
    L9:
        r8 = "";
        goto L10
    }

    @Override // com.bytedance.android.live.profile.a
    public void manage(Context r3) {
        if (r3 == null) goto L5;
        this.mManageUseCase.c(r3, this.mUserProfileEvent);
        return;
    }

    @Override // com.bytedance.android.live.profile.a
    public void onDressClick(DressClickArea r8) {
        Intrinsics.checkNotNullParameter(r8, "area");
        NewProfileTrackUseCase r1 = this.mTrackLogUseCase;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r8, "area");
        DressSuitInfo r0 = r1.g.getTargetUser().getDressSuitInfo();
        if (r0 == null) goto L6;
        String r2 = r0.getUserSuitId();
        if (r2 == null) goto L6;
    L7:
        boolean r3 = r1.g.getPageTypeUseCase().a;
        Pair[] r4 = new Pair[3];
        int r9 = com.bytedance.android.live.profile.usecase.t.b[r8.ordinal()];
        if (r9 == 1) goto L15;
        if (r9 == 2) goto L14;
        if (r9 != 3) goto L13;
        String r10 = "background";
    L16:
        r4[0] = TuplesKt.to("click_position", r10);
        r4[1] = TuplesKt.to("package_id", r2);
        if (r3 == false) goto L19;
        String r12 = DataType.TRUE;
    L20:
        r4[2] = TuplesKt.to("is_self", r12);
        Map<String, String> r13 = MapsKt.mutableMapOf(r4);
        r13.putAll(r1.t());
        Unit r5 = Unit.INSTANCE;
        r1.B("livesdk_profile_card_package_skin_click", r13);
        return;
    L19:
        r12 = DataType.FALSE;
        goto L20
    L13:
        throw new NoWhenBranchMatchedException();
    L14:
        r10 = "frame_left";
        goto L16
    L15:
        r10 = "frame_right";
    L6:
        r2 = "";
        goto L7
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public void recordShowMap(Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r3, "map");
        NewProfileTrackUseCase r1 = this.mTrackLogUseCase;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "map");
        com.bytedance.android.live.profile.usecase.s r2 = r1.f;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "map");
        r2.b.putAll(r3);
    }

    @Override // com.bytedance.android.live.profile.a
    public void report(Activity r13) {
        if (isUserLogin() == true) goto L6;
        goLoginFirst(r13);
        return;
    L6:
        if (r13 == null) goto L97;
        NewProfileTrackUseCase r0 = getLogUseCase();
        String r1 = this.mTargetUserId;
        UserProfileEvent r2 = this.mUserProfileEvent;
        String r3 = "";
        if (r2 == null) goto L11;
        String r4 = r2.mSource;
        if (r4 == null) goto L11;
    L12:
        if (r2 == null) goto L15;
        String r5 = r2.mReportTypeForLog;
        if (r5 == null) goto L15;
    L16:
        ReportObject r6 = null;
        if (r2 == null) goto L19;
        u r7 = r2.mCommentReportModel;
    L20:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "toUserId");
        Intrinsics.checkNotNullParameter(r4, "fromSource");
        Intrinsics.checkNotNullParameter(r5, "mReportTypeForLog");
        HashMap r8 = new HashMap();
        boolean r9 = false;
        if (Intrinsics.areEqual(PAGE_NAME, r4) == false) goto L23;
    L26:
        boolean r10 = true;
    L27:
        r8.put("report_type", ((IMiddlewareReportService) jc1.k.n(IMiddlewareReportService.class)).getReportType(r4, r5, r10));
        r8.put("request_page", ((IMiddlewareReportService) jc1.k.n(IMiddlewareReportService.class)).getRequestPage(r4, r5));
        r8.put("to_user_id", r1.toString());
        qs0.i r12 = os0.b.c().getIInteractService();
        if (r12 != null) goto L30;
    L32:
        if (r12 == null) goto L38;
        k.e r14 = r12.getVideoTalkService();
        if (r14 == null) goto L38;
        if (r14.m() != true) goto L38;
        r8.put("play_type", "video_friend");
    L38:
        if (r7 == null) goto L44;
        r8.put("to_comment_id", String.valueOf(r7.a()));
        String r15 = r7.f();
        if (r15 == null) goto L43;
        r3 = r15;
    L43:
        r8.put("to_comment_type", r3);
    L44:
        boolean r16 = com.bytedance.android.live.revenue.core.util.h.a;
        ((ILinkService) com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class)).mo471getRevenueLinkDataHolder();
        j0 r17 = j0.l();
        int r18 = c0.b;
        r17.sendLog("livesdk_live_user_report", r8, new Object[]{r0.a, r0.b, IRoom.class, am2.n.f(), c0.a.a(xs0.a.a())});
        if (am2.n.f().c().length() <= 0) goto L47;
        boolean r19 = true;
    L48:
        if (r19 == false) goto L71;
        JSONObject r20 = new JSONObject();
        com.bytedance.android.livesdk.chatroom.o r22 = os0.b.a();     // Catch: JSONException -> L68
        if (r22 == null) goto L57;
        m r23 = r22.getRoom();     // Catch: JSONException -> L68
        if (r23 == null) goto L57;
        IRoom r24 = (IRoom) r23.getValue();     // Catch: JSONException -> L68
        if (r24 == null) goto L57;
        String r25 = r24.getOwnerUserIdString();     // Catch: JSONException -> L68
    L58:
        r20.put("anchor_id", r25);     // Catch: JSONException -> L68
        com.bytedance.android.livesdk.chatroom.o r26 = os0.b.a();     // Catch: JSONException -> L68
        if (r26 == null) goto L65;
        m r27 = r26.getRoom();     // Catch: JSONException -> L68
        if (r27 == null) goto L65;
        IRoom r28 = (IRoom) r27.getValue();     // Catch: JSONException -> L68
        if (r28 == null) goto L65;
        Long r29 = Long.valueOf(r28.getId());     // Catch: JSONException -> L68
    L66:
        r20.put("room_id", r29);     // Catch: JSONException -> L68
    L70:
        os0.b.c().getLiveRoomEventParamUtils().handleLiveAdExtraData(r20);
        LinkedHashMap r30 = new LinkedHashMap();
        r30.put("value", am2.n.f().c());
        r30.put("log_extra", am2.n.f().d());
        ILiveDouPlusService r32 = jc1.k.n(ILiveDouPlusService.class);
        os0.c r33 = new os0.c();
        r33.a(r20);
        r33.b(r30);
        Intrinsics.checkNotNullParameter("report_homepage", "value");
        ((HashMap) r33.a).put("refer", "report_homepage");
        r32.logEvent(true, "live_ad", "otherclick", r33.a);
    L65:
        r29 = null;
    L57:
        r25 = null;
    L68:
        e = move-exception;
        e.printStackTrace();
    L71:
        this.mManageUseCase.d(r13, this.mUserProfileEvent);
        UserProfileEvent r110 = this.mUserProfileEvent;
        if (r110 == null) goto L98;
        y71.a r34 = new y71.a(ReportConstant$BusinessSource.NewProfile);
        r34.a = getRoomUser();
        ProfileRoomProxy r35 = getRoom();
        if (r35 == null) goto L76;
        IRoom r36 = r35.a;
    L78:
        if ((r36 instanceof IRoom) == true) goto L80;
        r36 = null;
    L80:
        r34.b = r36;
        r34.c = r110.mSource;
        r34.d = r110.mReportSource;
        r34.e = r110.mReportTypeForLog;
        r34.f = r110.mCommentReportModel;
        r34.a(r110.getReportObject());
        IMiddlewareReportService r111 = (IMiddlewareReportService) jc1.k.f(IMiddlewareReportService.class);
        if (r111 == null) goto L83;
        ReportObject r112 = r111.getReportType(r34);
    L84:
        if (r112 != null) goto L86;
        return;
    L86:
        if (r112 != ReportObject.Comment) goto L88;
    L89:
        r9 = true;
    L90:
        if (r9 == false) goto L92;
        r6 = r112;
    L92:
        if (r6 == null) goto L100;
        dismiss();
        return;
    L100:
        return;
    L88:
        if (r112 != ReportObject.User) goto L90;
    L83:
        r112 = null;
        goto L84
    L76:
        r36 = null;
        goto L78
    L98:
        return;
    L47:
        r19 = false;
        goto L48
    L30:
        if (r12.getCurrentScene() != 12) goto L32;
        r8.put("function_type", "party");
        goto L32
    L23:
        if (Intrinsics.areEqual("live_barrage", r4) == true) goto L26;
        r10 = false;
        goto L27
    L19:
        r7 = null;
    L15:
        r5 = "";
    L11:
        r4 = "";
        goto L12
    }

    public final void reportProfileProfitCheck(NewProfileUser r6) {
        this.mTrackLogUseCase.getClass();
        if (r6 == null) goto L7;
        BaseProfileInfo r1 = r6.baseProfileInfo;
        if (r1 == null) goto L7;
        String r2 = r1.getIdStr();
    L9:
        if ((!Intrinsics.areEqual(r2, jc1.k.n(IMiddlewareUserService.class).user().n())) == true) goto L34;
        LinkedHashMap r3 = new LinkedHashMap();
        if (r6 == null) goto L16;
        BaseProfileInfo r4 = r6.baseProfileInfo;
        if (r4 == null) goto L16;
        r3.put("mystery_man", Integer.valueOf(r4.mysteryMan));
    L16:
        if (r6 == null) goto L24;
        ProfileSkin r5 = r6.mProfileSkin;
        if (r5 == null) goto L24;
        ProfileCustomSkin r7 = r5.skin;
        if (r7 == null) goto L24;
        String r8 = r7.avatarBorderDressId;
        if (r8 == null) goto L24;
        r3.put("avatar_border_dress_id", r8);
    L24:
        if (r6 == null) goto L32;
        ProfileSkin r9 = r6.mProfileSkin;
        if (r9 == null) goto L32;
        ProfileCustomSkin r10 = r9.skin;
        if (r10 == null) goto L32;
        String r12 = r10.dressId;
        if (r12 == null) goto L32;
        r3.put("profile_skin_dress_id", r12);
    L32:
        r3.put("source", 1);
        boolean r13 = com.bytedance.android.live.revenue.core.util.h.a;
        ((com.bytedance.android.live.profit.privilege.c) com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.privilege.c.class)).B1(ProfitCheckType.DRESS_SHOW, r3, null);
        return;
    L34:
        return;
    L7:
        r2 = null;
        goto L9
    }

    public final void setDiggHandler(u32.j r1) {
        this.diggHandler = r1;
    }

    public final void setHasReportDiggDisable(boolean r1) {
        this.hasReportDiggDisable = r1;
    }

    public final void setInteractLogLabel(String r3) {
        Intrinsics.checkNotNullParameter(r3, "interactLogLabel");
        NewProfileTrackUseCase r1 = this.mTrackLogUseCase;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "interactLogLabel");
        r1.c = r3;
    }

    public final void setMDataCenter(DataCenter r1) {
        this.mDataCenter = r1;
    }

    public final void setMFollowUseCase(ut0.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mFollowUseCase = r2;
    }

    public final void setMJumpUseCase(ut0.c r1) {
        this.mJumpUseCase = r1;
    }

    public final void setMTargetUser(NewProfileUser r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mTargetUser = r2;
    }

    public final void setMTargetUserBizExtra(Map<String, String> r1) {
        this.mTargetUserBizExtra = r1;
    }

    public final void setMTrackLogUseCase(NewProfileTrackUseCase r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mTrackLogUseCase = r2;
    }

    public void setMyLive(boolean r1) {
        this.isMyLive = r1;
    }

    public final void setNeedClose(MutableLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.needClose = r2;
    }

    public final void setPreRoomUserData(IBaseUser r1) {
        this.preRoomUserData = r1;
    }

    public void setProfileMode(ProfileMode r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.profileMode = r2;
    }

    public void setProfileMonitor(ProfileMonitor r1) {
        this.profileMonitor = r1;
    }

    public final void setRoomUserData(IBaseUser r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.roomUserData = r2;
    }

    public final void setTargetUserInfoLiveData(MutableLiveData<NewProfileUser> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.targetUserInfoLiveData = r2;
    }

    @Override // com.bytedance.android.live.profile.a
    public void showAnonymousUserSilentDialog(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.mManageUseCase.showAnonymousUserSilentDialog(r2);
    }

    @Override // com.bytedance.android.live.profile.a
    public void showDressUpCenter(DialogFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        logDressUpCardClick();
        ut0.c r0 = this.mJumpUseCase;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    @Override // com.bytedance.android.live.profile.a
    public void showFansGroupDialog(FragmentActivity r8) {
        if (isUserLogin() == true) goto L6;
        goLoginFirst(r8);
        return;
    L6:
        com.bytedance.android.live.base.model.user.u r0 = this.mTargetUser.fansGroupInfo;
        if (r0 == null) goto L9;
        String r1 = r0.getFansGroupUrl();
    L11:
        if (r1 == null) goto L16;
        String r2 = this.mTargetUser.fansGroupInfo.getFansGroupUrl();
        if (r2 != null) goto L15;
        r2 = "";
    L15:
        long r3 = this.mRoom.getId();
        int r4 = vt0.c.a;
        String r5 = vt0.c.a(r2, this.roomUserData, r3);
        ALogger.i("profile_vs_fans_group_scheme", r5);
        jc1.k.n(IBaseLiveActionHandler.class).handle(r8, r5);
    L17:
        NewProfileTrackUseCase r9 = this.mTrackLogUseCase;
        String r6 = this.mTargetUser.baseProfileInfo.getIdStr();
        ProfileRoomProxy r7 = this.mRoom;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r6, "toUserId");
        Intrinsics.checkNotNullParameter(r7, "mRoom");
        HashMap r10 = new HashMap();
        r10.put("to_user_id", r6.toString());
        if (r7.c() != 1) goto L20;
        String r12 = "media";
    L21:
        r10.put("room_layout", r12);
        LiveMode r13 = r7.getStreamType();
        if (r13 != LiveMode.AUDIO) goto L25;
        String r14 = "voice_live";
    L28:
        r10.put("live_type", r14);
        r10.put("request_page", PAGE_NAME);
        r9.B("livesdk_profile_card_fansgroup_click", r10);
        return;
    L25:
        if (r13 != LiveMode.THIRD_PARTY) goto L27;
        r14 = "third_party";
        goto L28
    L27:
        r14 = "video_live";
        goto L28
    L20:
        r12 = DataType.Normal;
        goto L21
    L16:
        ALogger.i("profile_vs_fans_group_scheme", "no fans group url");
        goto L17
    L9:
        r1 = null;
        goto L11
    }

    @Override // com.bytedance.android.live.profile.a
    public void showFlashShop(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        dismiss();
        NewProfileTrackUseCase r0 = this.mTrackLogUseCase;
        long r1 = this.mRoom.getId();
        String r3 = this.mRoom.getOwnerUserIdStr();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "roomOwnerId");
        HashMap r4 = new HashMap(5);
        r4.put("page_name", "user_detail");
        r4.put("button_for", "定向闪购");
        r4.put("room_id", String.valueOf(r1));
        r4.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        r4.put("anchor_id", r3);
        r0.B("livesdk_click_button", r4);
        r0.B("livesdk_flash_shop_click", MapsKt.emptyMap());
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r2 = ts0.a.d;
        Boolean r5 = Boolean.TRUE;
        r2.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r2, r5);
        Bundle r6 = new Bundle();
        r6.putString("target_id", getRoomUser().getIdString());
        r6.putLong("click_time", System.currentTimeMillis());
        r6.putString("target_name", getRoomUser().getRealNickName());
        os0.b.c().getIHostCommerceServiceLive().tryShowLiveFlashFragment(r8, r6, null);
    }

    @Override // com.bytedance.android.live.profile.a, com.bytedance.android.live.profile.ui.base.h
    public void showKtvPanel(FragmentActivity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        ut0.c r0 = this.mJumpUseCase;
        if (r0 == null) goto L5;
        r0.h(r3);
    L5:
        NewProfileTrackUseCase r4 = this.mTrackLogUseCase;
        if (r4 == null) goto L9;
        r4.B("livesdk_ksong_mark_label_click", r4.r());
        return;
    }

    public void updateFollowInfo(int r2) {
        this.mFollowUseCase.a(r2);
    }

    public final void updateSelfUserFansGroup(IBaseUser r2) {
        Intrinsics.checkNotNullParameter(r2, "selfUser");
        com.bytedance.android.live.profile.usecase.e r0 = this.mFansClubUserCase;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }

    public static final /* synthetic */ void access$setMEnterLiveSource$p(NewProfileInfoViewModel r0, String r1) {
        r0.mEnterLiveSource = r1;
    }

    public static final /* synthetic */ void access$setMTargetUserId$p(NewProfileInfoViewModel r0, String r1) {
        r0.mTargetUserId = r1;
    }

    @Override // com.bytedance.android.live.profile.a
    public void clickEcomSet(DialogFragment r5, NewProfileUser r6) {
        Intrinsics.checkNotNullParameter(r5, "dialogFragment");
        Intrinsics.checkNotNullParameter(r6, "user");
        ns0.a r0 = ns0.c.a();
        if (r0 == null) goto L5;
        r0.noticeAnchorSetButtonClick();
    L5:
        HashMap<String, String> r1 = com.bytedance.android.live.profile.ui.util.s.a(this.mDataCenter);
        j0.l().sendLog("livesdk_personal_card_setting_entrance_click", r1, new Object[0]);
        int r2 = ProfileEcomSetDialogFragment.n;
        DataCenter r3 = this.mDataCenter;
        ProfileEcomSetDialogFragment r4 = new ProfileEcomSetDialogFragment();
        r4.e = r6;
        r4.d = r3;
        p8.a(r4, r5.getContext());
        dismiss();
    }

    @Override // com.bytedance.android.live.profile.a
    public void clickGiftExhibitionCard(Context r13, GiftExhibitionHomeStats r14) {
        Intrinsics.checkNotNullParameter(r13, "context");
        if (r14 == null) goto L5;
        String r1 = r14.url;
    L7:
        if (TextUtils.isEmpty(r1) == false) goto L9;
        ALogger.i(TAG, "clickGiftExhibitionCard_with_null");
    L9:
        if (r14 == null) goto L66;
        String r15 = r14.url;
        if (r15 == null) goto L67;
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r2 = ts0.a.c;
        Boolean r3 = Boolean.TRUE;
        r2.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r2, r3);
        IBaseLiveActionHandler r4 = jc1.k.n(IBaseLiveActionHandler.class);
        Map r5 = MapsKt.emptyMap();
        List r6 = CollectionsKt.listOf(new String[]{"url", "fallback_url"});
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "urlList");
        Uri r16 = UriProtector.parse(r15);
        Set r7 = UriProtector.getQueryParameterNames(r16);
        if (r7 != null) goto L15;
        Uri r8 = r16;
    L26:
        Uri.Builder r9 = r8.buildUpon();
        Iterator r10 = r6.iterator();
    L28:
        if (r10.hasNext() == false) goto L55;
        String r12 = (String) r10.next();
        String r17 = UriProtector.getQueryParameter(r16, r12);
        if (r17 != null) goto L32;
        r17 = "";
    L32:
        Uri.Builder r18 = UriProtector.parse(r17).buildUpon();
        com.bytedance.android.livesdk.chatroom.o r19 = os0.b.a();
        if (r19 == null) goto L37;
        m r20 = r19.getRoom();
        if (r20 == null) goto L37;
        IRoom r22 = (IRoom) r20.getValue();
    L38:
        Pair[] r23 = new Pair[3];
        if (r22 == null) goto L41;
        String r110 = r22.getIdStr();
    L42:
        r23[0] = TuplesKt.to("room_id", String.valueOf(r110));
        if (r22 == null) goto L45;
        String r24 = r22.getOwnerUserIdString();
    L46:
        r23[1] = TuplesKt.to("anchor_id", String.valueOf(r24));
        r23[2] = TuplesKt.to("user_id", jc1.k.n(IMiddlewareUserService.class).user().n().toString());
        Iterator r25 = MapsKt.mapOf(r23).entrySet().iterator();
    L48:
        if (r25.hasNext() == false) goto L50;
        Map.Entry r26 = (Map.Entry) r25.next();
        r18.appendQueryParameter((String) r26.getKey(), (String) r26.getValue());
        goto L48
    L50:
        Iterator r27 = r5.entrySet().iterator();
    L52:
        if (r27.hasNext() == false) goto L54;
        Map.Entry r28 = (Map.Entry) r27.next();
        r18.appendQueryParameter((String) r28.getKey(), (String) r28.getValue());
        goto L52
    L54:
        r9.appendQueryParameter(r12, r18.toString());
        goto L28
    L45:
        r24 = null;
        goto L46
    L41:
        r110 = null;
    L37:
        r22 = null;
        goto L38
    L55:
        r4.handle(r13, r9.toString());
        return;
    L15:
        Uri.Builder r29 = r16.buildUpon().clearQuery();
        ArrayList r30 = new ArrayList();
        Iterator r32 = r7.iterator();
    L17:
        if (r32.hasNext() == false) goto L21;
        Object r33 = r32.next();
        if ((!r6.contains((String) r33)) == false) goto L17;
        r30.add(r33);
        goto L17
    L21:
        Iterator r34 = r30.iterator();
    L23:
        if (r34.hasNext() == false) goto L25;
        String r35 = (String) r34.next();
        r29.appendQueryParameter(r35, UriProtector.getQueryParameter(r16, r35));
        goto L23
    L25:
        r8 = r29.build();
        goto L26
    L67:
        return;
    L66:
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.profile.a
    public void clickOwnerCenter(DialogFragment r2, NewProfileUser r3) {
        Intrinsics.checkNotNullParameter(r2, "dialogFragment");
        Intrinsics.checkNotNullParameter(r3, "user");
        logOwnerCenterClick();
        ut0.c r4 = this.mJumpUseCase;
        if (r4 == null) goto L6;
        r4.c(r2);
        return;
    }

    @Override // com.bytedance.android.live.profile.a
    public void digg(Context r9, String r10) {
        NewProfileTrackUseCase r0 = this.mTrackLogUseCase;
        r0.getClass();
        HashMap r1 = new HashMap();
        o r2 = j0.l().c(am2.x.class);
        String r3 = "";
        if (r2 == null) goto L14;
        String r4 = (String) r2.getMap().get("enter_from_merge");
        if (r4 != null) goto L7;
        r4 = "";
    L7:
        r1.put("enter_from_merge", r4);
        String r5 = (String) r2.getMap().get("enter_method");
        if (r5 != null) goto L10;
        r5 = "";
    L10:
        r1.put("enter_method", r5);
        String r6 = (String) r2.getMap().get("action_type");
        if (r6 != null) goto L13;
        r6 = "";
    L13:
        r1.put("action_type", r6);
    L14:
        ps0.b r7 = r0.g.getRoom();
        r1.put("room_id", String.valueOf(r7.getId()));
        String r8 = r7.getRequestId();
        if (r8 == null) goto L18;
        r3 = r8;
    L18:
        r1.put("request_id", r3);
        r1.put("anchor_id", r7.getOwnerUserIdStr().toString());
        LiveMode r12 = r7.getStreamType();
        int r13 = h1.a;
        r1.put("live_type", i1.a(r12));
        r1.put("function_type", os0.b.c().getIInteractService().getCurrentFunctionType());
        qs0.h r14 = os0.b.c().getInteractLogUtils();
        if (r14 == null) goto L23;
        String r15 = r14.getCurrentPlayModes();
        if (r15 == null) goto L23;
        r1.put("play_mode", r15);
    L23:
        com.bytedance.android.livesdk.chatroom.o r16 = os0.b.a();
        String r17 = "guest";
        if (r16 != null) goto L26;
    L33:
        IMiddlewareUserService r18 = jc1.k.f(IMiddlewareUserService.class);
        u32.j r19 = null;
        if (r18 == null) goto L38;
        com.bytedance.android.livesdk.user.e r20 = r18.user();
        if (r20 == null) goto L38;
        String r22 = r20.n();
    L39:
        r1.put("user_id", String.valueOf(r22));
        String r23 = r0.g.getTargetUser().baseProfileInfo.getIdStr();
        r1.put("to_user_id", r23.toString());
        if (Intrinsics.areEqual(r23, r7.getOwnerUserIdStr()) == false) goto L42;
        r17 = "anchor";
    L42:
        r1.put("to_user_type", r17);
        r1.put("request_page", "profile_card");
        r1.put("vr_type", os0.b.c().getVrUtils().P());
        r1.put("is_vr_machine", os0.b.c().getVrUtils().getVrMachineLogStr(null));
        r1.put("like_amount", DataType.TRUE);
        qs0.h r24 = os0.b.c().getInteractLogUtils();
        if (r24 == null) goto L45;
        r24.M0(r1);
    L45:
        j0.l().sendLog("livesdk_like", r1, new Object[0]);
        if (this.diggHandler != null) goto L52;
        IBaseDiggService r25 = jc1.k.f(IBaseDiggService.class);
        if (r25 == null) goto L50;
        r19 = r25.provideDiggHandler(this.mRoom.getId(), this.mTargetUserId, r10);
    L50:
        this.diggHandler = r19;
    L52:
        if (isUserLogin() == false) goto L54;
        u32.j r26 = this.diggHandler;
        if (r26 == null) goto L65;
        r26.onDiggButtonClick();
        return;
    L65:
        return;
    L54:
        if (this.hasReportDiggDisable == true) goto L59;
        u32.j r110 = this.diggHandler;
        if (r110 == null) goto L58;
        r110.a(this.mDataCenter);
    L58:
        this.hasReportDiggDisable = true;
    L59:
        goLoginFirst(r9);
        return;
    L38:
        r22 = null;
        goto L39
    L26:
        if (Intrinsics.areEqual(r16.isAnchor(), Boolean.TRUE) == false) goto L29;
        String r27 = "anchor";
    L32:
        r1.put("user_type", r27);
        goto L33
    L29:
        if (os0.b.c().getLinkPlayerState().getData() == 0) goto L31;
        r27 = "guest";
        goto L32
    L31:
        r27 = "audience";
        goto L32
    }

    @Override // com.bytedance.android.live.profile.a
    public void handleDynamicAction(Context r14, String r15) {
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r15, "scheme");
        ALogger.i(TAG, "scheme - " + r15);
        String r3 = null;
        if (StringsKt.contains$default(r15, "send_gift", false, 2, null) == false) goto L30;
        DataCenter r4 = this.mDataCenter;
        if (r4 == null) goto L7;
        Integer r5 = (Integer) r4.get("data_link_state", 0);
    L8:
        NewProfileTrackUseCase r6 = this.mTrackLogUseCase;
        boolean r7 = this.mPageTypeProcess.c;
        String r8 = this.mTargetUserId;
        ProfileRoomProxy r9 = this.mRoom;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r8, "mUserId");
        Intrinsics.checkNotNullParameter(r9, "room");
        HashMap r10 = new HashMap();
        r10.put("to_user_id", r8.toString());
        r10.put("anchor_id", r9.getOwnerUserIdStr());
        r10.put("room_id", String.valueOf(r9.getId()));
        if (Intrinsics.areEqual(r8, r9.getOwnerUserIdStr()) == false) goto L11;
        String r12 = "anchor";
    L12:
        r10.put("to_user_type", r12);
        int r13 = vt0.e.a;
        r10.put("user_type", vt0.e.a(r9.getOwnerUserIdStr(), r6.g.getTargetUser().baseProfileInfo.getIdStr()));
        qs0.i r16 = os0.b.c().getIInteractService();
        if (r5 == null) goto L16;
        r10.put("send_gift_scene", r16.changeMode2String(r5.intValue()));
    L16:
        if (r9.a() == true) goto L18;
    L26:
        boolean r17 = com.bytedance.android.live.revenue.core.util.h.a;
        kc0.e r18 = ((ILinkService) com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class)).getRevLinkControlService();
        if (r18 == null) goto L29;
        r10.put("connection_type", r18.getConnectionType());
    L29:
        r6.B("live_user_send_gift", r10);
    L32:
        if (StringsKt.contains$default(r15, "send_gift", false, 2, null) == false) goto L35;
        sendGift();
        return;
    L35:
        if (StringsKt.contains$default(r15, "prepare_invite_chat", false, 2, null) == false) goto L38;
        prepareInviteUser();
        return;
    L38:
        if (StringsKt.contains$default(r15, "invite_chat", false, 2, null) == false) goto L41;
        inviteUser();
        return;
    L41:
        if (StringsKt.contains$default(r15, "invite_wgame", false, 2, null) == false) goto L48;
        DataCenter r19 = this.mDataCenter;
        if (r19 == null) goto L66;
        Intrinsics.checkNotNullParameter(this, "profileViewModel");
        String r110 = this.mTargetUserId;
        Intrinsics.checkNotNullParameter(r19, "dataCenter");
        Intrinsics.checkNotNullParameter(r110, "userId");
        Disposable r111 = os0.b.b(r19).c(r19, r110);
        if (r111 == null) goto L67;
        r r112 = getNewProfileRequestManager();
        r112.getClass();
        Intrinsics.checkNotNullParameter(r111, "disposable");
        r112.a.add(r111);
        return;
    L67:
        return;
    L66:
        return;
    L48:
        if (StringsKt.contains$default(r15, "webcast_inroom_usercard_stop_connection", false, 2, null) == true) goto L50;
        IBaseLiveActionHandler r0 = jc1.k.f(IBaseLiveActionHandler.class);
        if (r0 == null) goto L71;
        r0.handle(r14, r15);
        return;
    L71:
        return;
    L50:
        if (StringsKt.contains$default(r15, "secId=&", false, 2, null) == false) goto L56;
        UserProfileEvent r1 = getUserProfileEvent();
        if (r1 == null) goto L54;
        r3 = r1.secUserId;
    L54:
        if (r3 == null) goto L56;
        r15 = StringsKt.replaceFirst$default(r15, "secId=&", "secId=" + r3 + '&', false, 4, null);
    L56:
        IBaseLiveActionHandler r2 = jc1.k.f(IBaseLiveActionHandler.class);
        if (r2 == null) goto L69;
        r2.handle(r14, r15);
        return;
    L69:
        return;
    L18:
        if (r16.isMicRoomHost(r8) == false) goto L26;
        if (r7 == false) goto L22;
        String r20 = "carousel_anchor_c_carousel_host";
    L25:
        r10.put("carousel_action_type", r20);
        goto L26
    L22:
        if (os0.b.c().getIMicRoomService().isLoyalAudience() == false) goto L24;
        r20 = "loyal_audience_c_carousel_host";
        goto L25
    L24:
        r20 = "carousel_audience_c_carousel_host";
        goto L25
    L11:
        r12 = "guest";
        goto L12
    L7:
        r5 = null;
        goto L8
    L30:
        StringsKt.contains$default(r15, "invite_chat", false, 2, null);
        goto L32
    }

    @Override // com.bytedance.android.live.profile.a
    public void logProile(NewProfileTrackUseCase.LogProfileType r9, HashMap<String, String> r10) {
        Intrinsics.checkNotNullParameter(r9, "type");
        Intrinsics.checkNotNullParameter(r10, "ext");
        this.mTrackLogUseCase.getClass();
        Intrinsics.checkNotNullParameter(r9, "type");
        Intrinsics.checkNotNullParameter(r10, "ext");
        if (com.bytedance.android.live.profile.usecase.t.a[r9.ordinal()] != 1) goto L7;
        Intrinsics.checkNotNullParameter(r10, "ext");
        HashMap r6 = new HashMap();
        r6.put("enter_method", "material_card");
        j0.l().g("enter_poi_detail", false, true, r6, new Object[]{am2.x.class, IRoom.class});
        return;
    }

    @Override // com.bytedance.android.live.profile.a
    public void onVerifyViewClick(Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        if (TextUtils.isEmpty(r4) == true) goto L5;
        jc1.k.n(IBaseLiveActionHandler.class).handle(r3, r4);
    L5:
        NewProfileTrackUseCase r5 = this.mTrackLogUseCase;
        r5.getClass();
        HashMap r6 = new HashMap();
        r6.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        r6.put("is_jade_room", DataType.TRUE);
        r5.B("livesdk_label_click", r6);
    }

    public final void prepareEnter(View r3, Function0<Unit> r4) {
        ut0.a r0 = this.mEnterExitUseCase;
        ProfileSkin r1 = this.mTargetUser.mProfileSkin;
        if (r1 == null) goto L7;
        ProfileCustomSkin r2 = r1.skin;
        if (r2 == null) goto L7;
        ProfileCustomSkin.Panel r5 = r2.panel;
    L8:
        r0.a(r3, r5, r4);
        return;
    L7:
        r5 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public void recordBusinessClick(String r2, Map<? extends String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        if (isMyLive() == false) goto L5;
        return;
    L5:
        this.mTrackLogUseCase.A(r2, r3);
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public void recordBusinessShow(TrackArea r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "area");
        Intrinsics.checkNotNullParameter(r3, "name");
        this.mTrackLogUseCase.recordBusinessShow(r2, r3);
    }

    @Override // com.bytedance.android.live.profile.a
    public void showGradePage(Context r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        if (r6 != null) goto L5;
    L17:
        ALogger.i(TAG, "showGradePage_with_scheme_null");
        return;
    L5:
        if (r6.length() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L17;
        NewProfileTrackUseCase r1 = this.mTrackLogUseCase;
        r1.getClass();
        LinkedHashMap r2 = new LinkedHashMap();
        r2.putAll(r1.e);
        if (r1.g.getPageTypeUseCase().c == false) goto L13;
        r2.put("action_type", "click");
    L13:
        r1.B("livesdk_profile_card_honor_level_click", r2);
        IBaseLiveActionHandler r3 = jc1.k.f(IBaseLiveActionHandler.class);
        if (r3 == null) goto L19;
        r3.handle(r5, r6);
        return;
    L19:
        return;
    L7:
        r0 = false;
        goto L8
    }

    @Override // com.bytedance.android.live.profile.a
    public void showNewCertDescPage(Context r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        if (TextUtils.isEmpty(r5) == true) goto L5;
        jc1.k.n(IBaseLiveActionHandler.class).handle(r4, r5);
    L5:
        NewProfileTrackUseCase r6 = this.mTrackLogUseCase;
        r6.getClass();
        Intrinsics.checkNotNullParameter("live_personal_card", "clickArea");
        HashMap r7 = new HashMap();
        r7.put("click_area", "live_personal_card");
        r7.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        j0.l().sendLog("livesdk_click_quality_anchor", r7, new Object[]{r6.b, IRoom.class});
    }

    @Override // com.bytedance.android.live.profile.a
    public void showShopEntrance(int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "from");
        this.mTrackLogUseCase.z("livesdk_show_store_entrance", r3, r4);
    }

    @Override // com.bytedance.android.live.profile.a, com.bytedance.android.live.profile.ui.base.h
    public void showSubscribePanel(FragmentActivity r10, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "activity");
        if (r12 == false) goto L6;
        NewProfileTrackUseCase r13 = this.mTrackLogUseCase;
        String r0 = this.mTargetUserId;
        String r1 = this.mSelfUserId;
        r13.getClass();
        NewProfileTrackUseCase.y(r0, r1);
    L6:
        if (isUserLogin() == true) goto L10;
        goLoginFirst(r10);
        return;
    L10:
        if (((Boolean) x3.a.getValue()).booleanValue() == false) goto L12;
        FansClubEntranceParams.Page r14 = FansClubEntranceParams.Page.VIP;
    L13:
        FansClubEntranceParams.Page r2 = r14;
        com.bytedance.android.live.profit.fansclub.o r15 = yt0.c.c();
        if (r15 == null) goto L19;
        p r16 = r15.Z8(new FansClubEntranceParams(r2, false, PAGE_NAME, null, FansClubEntranceParams.Entrance.PersonalProfile, true, null, 410));
        if (r16 == null) goto L20;
        r16.show();
        return;
    L20:
        return;
    L19:
        return;
    L12:
        r14 = FansClubEntranceParams.Page.Default;
        goto L13
    }

    @Override // com.bytedance.android.live.profile.a
    public void showVerifyPage(Context r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        py.c r0 = this.mTargetUser.mAuthenticationInfo;
        if (r0 == null) goto L7;
        py.k r1 = r0.getAuthenticationBadge();
        if (r1 == null) goto L7;
        Integer r2 = r1.getImageType();
    L8:
        if (r2 != null) goto L11;
    L13:
        if (r2 != null) goto L16;
    L18:
        String r3 = "";
    L20:
        if (TextUtils.isEmpty(r8) == true) goto L22;
        jc1.k.n(IBaseLiveActionHandler.class).handle(r7, Intrinsics.stringPlus(r8, Uri.encode("&verified_type=" + r3 + "&room_id=" + this.mRoom.getId() + "&anchor_id=" + this.mRoom.getOwnerUserIdStr() + "&to_user_id=" + this.mTargetUserId)));
    L22:
        NewProfileTrackUseCase r9 = this.mTrackLogUseCase;
        long r4 = this.mRoom.getId();
        String r10 = this.mRoom.getOwnerUserIdStr();
        String r5 = this.mTargetUserId;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r3, "verifyType");
        Intrinsics.checkNotNullParameter(r10, "anchorId");
        Intrinsics.checkNotNullParameter(r5, "toUserId");
        HashMap r6 = new HashMap();
        r6.put("verified_type", r3);
        r6.put("room_id", String.valueOf(r4));
        r6.put("anchor_id", r10);
        r6.put("to_user_id", r5.toString());
        j0.l().sendLog("livesdk_profile_card_Vicon_click", r6, new Object[]{r9.b, IRoom.class});
        return;
    L16:
        if (r2.intValue() != 47) goto L18;
        r3 = "personal";
        goto L20
    L11:
        if (r2.intValue() != 46) goto L13;
        r3 = "enterprise";
    L7:
        r2 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.profile.a
    public void showWhiteCertPage(Context r5, WhiteCategoryCert.SubCertInfo r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        if (r6 != null) goto L5;
        return;
    L5:
        NewProfileTrackUseCase r0 = this.mTrackLogUseCase;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r6, "pageInfo");
        if (r6.certStatus != 1) goto L8;
        String r1 = DataType.TRUE;
    L9:
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("tag_show_user_verify_status", r1);
        r0.B("livesdk_profile_card_vertical_tag_click", r2);
        int r3 = WhiteCertSubDialogFragment.j;
        WhiteCertSubDialogFragment.a.a(r5, r6, this.mPageTypeProcess.c, this.mDataCenter, this.mTargetUser);
        return;
    L8:
        r1 = DataType.FALSE;
        goto L9
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public void showWhiteCertPageNoLog(Context r4, WhiteCategoryCert.SubCertInfo r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        if (r5 != null) goto L5;
        return;
    L5:
        int r0 = WhiteCertSubDialogFragment.j;
        WhiteCertSubDialogFragment.a.a(r4, r5, this.mPageTypeProcess.c, this.mDataCenter, this.mTargetUser);
    }

    public void initThisViewModel(Context r4, com.bytedance.android.live.profile.model.c r5, DataCenter r6) {
        Intrinsics.checkNotNullParameter(r5, "input");
        ProfileRoomProxy r7 = r5.c;
        if (r7 == null) goto L5;
        this.mRoom = r7;
    L5:
        this.mEnterLiveSource = r5.f;
        this.mTargetUserId = r5.a;
        this.mTargetSecUserId = r5.b;
        this.mFromSource = r5.e;
        this.mUserProfileEvent = r5.g;
        this.mLiveRoom = r5.d;
        this.mDataCenter = r6;
        IMiddlewareUserService r8 = jc1.k.f(IMiddlewareUserService.class);
        if (r8 == null) goto L10;
        com.bytedance.android.livesdk.user.e r9 = r8.user();
        if (r9 == null) goto L10;
        String r10 = r9.n();
    L11:
        String r12 = String.valueOf(r10);
        this.mSelfUserId = r12;
        UserProfileEvent r13 = r5.g;
        if (r13 == null) goto L14;
        boolean r14 = r13.forceShowRoomEntrance;
    L15:
        this.mPageTypeProcess = new q(this.mRoom, r12, this.mTargetUserId, r14);
        this.mJumpUseCase = new com.bytedance.android.live.profile.usecase.l(this.mFromSource, this);
        NewProfileTrackUseCase r15 = this.mTrackLogUseCase;
        com.bytedance.android.live.profile.model.f r16 = new com.bytedance.android.live.profile.model.f();
        String r0 = getTrackLogFrom();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r16.a = r0;
        if (this.mRoom.isMediaRoom() == false) goto L18;
        String r1 = "media";
    L19:
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r16.b = r1;
        String r2 = this.mTargetUserId.toString();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r16.c = r2;
        String r3 = this.mSelfUserId.toString();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r16.e = r3;
        Unit r17 = Unit.INSTANCE;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r16, Constants.Keys.DATA);
        r15.a = r16;
        NewProfileTrackUseCase r18 = this.mTrackLogUseCase;
        UserProfileEvent r19 = this.mUserProfileEvent;
        if (r19 == null) goto L23;
        String r20 = r19.getClickUserPosition();
        if (r20 == null) goto L23;
    L24:
        r18.getClass();
        Intrinsics.checkNotNullParameter(r20, "<set-?>");
        r18.d = r20;
        this.mFansClubUserCase = new com.bytedance.android.live.profile.usecase.e(this);
        DataCenter r22 = this.mDataCenter;
        if (r22 == null) goto L31;
        IBaseUser r23 = (IBaseUser) r22.get("data_user_in_room");
        if (r23 == null) goto L31;
        com.bytedance.android.live.profile.usecase.e r24 = this.mFansClubUserCase;
        if (r24 == null) goto L31;
        r24.b(r23);
    L31:
        setProfileMode(r5.h);
        setProfileMonitor(r5.i);
        setMyLive(r5.j);
        StringBuilder r25 = new StringBuilder("livesdk_new_profile_init_");
        q r26 = this.mPageTypeProcess;
        r26.getClass();
        r25.append("mTargetIsSelf=" + r26.a + ",mTargetIsAnchor=" + r26.b + ", mSelfIsAnchor=" + r26.c + ", mTargetIsLinkCrossAnchor=" + r26.d);
        ALogger.i(TAG, r25.toString());
        if (this.mDataCenter != null) goto L35;
        ALogger.i(TAG, "livesdk_new_profile_data_center_is_null");
        return;
    L35:
        return;
    L23:
        r20 = "";
        goto L24
    L18:
        r1 = DataType.Normal;
        goto L19
    L14:
        r14 = false;
    L10:
        r10 = null;
        goto L11
    }

    @Override // com.bytedance.android.live.profile.ui.base.h
    public void sendLog(String r6, Map<String, String> r7, Object... r8) {
        Intrinsics.checkNotNullParameter(r6, "eventName");
        Intrinsics.checkNotNullParameter(r7, "logMap");
        Intrinsics.checkNotNullParameter(r8, "args");
        NewProfileTrackUseCase r3 = this.mTrackLogUseCase;
        Object[] r9 = Arrays.copyOf(r8, r8.length);
        r3.getClass();
        Intrinsics.checkNotNullParameter(r6, "eventName");
        Intrinsics.checkNotNullParameter(r7, "logMap");
        Intrinsics.checkNotNullParameter(r9, "args");
        j0 r0 = j0.l();
        SpreadBuilder r1 = new SpreadBuilder(4);
        r1.add(r3.a);
        r1.add(r3.b);
        r1.add(IRoom.class);
        r1.addSpread(r9);
        r0.sendLog(r6, r7, r1.toArray(new Object[r1.size()]));
    }

    @Override // com.bytedance.android.live.profile.a, com.bytedance.android.live.profile.ui.base.h
    public void showFansClub(FragmentActivity r13, String r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r13, "activity");
        Intrinsics.checkNotNullParameter(r14, "from");
        if (r15 == false) goto L6;
        NewProfileTrackUseCase r1 = this.mTrackLogUseCase;
        String r2 = this.mTargetUserId;
        String r3 = this.mSelfUserId;
        r1.getClass();
        NewProfileTrackUseCase.y(r2, r3);
    L6:
        if (isUserLogin() == true) goto L9;
        goLoginFirst(r13);
        return;
    L9:
        com.bytedance.android.live.profile.usecase.e r4 = this.mFansClubUserCase;
        if (r4 == null) goto L99;
        Context r16 = r13.getApplicationContext();
        Intrinsics.checkNotNullParameter("personal_profile_fansclub_entrance", "requestPage");
        Intrinsics.checkNotNullParameter(r14, "from");
        com.bytedance.android.livesdk.chatroom.o r0 = os0.b.a();
        String r5 = null;
        if (r0 == null) goto L16;
        m r6 = r0.getRoom();
        if (r6 == null) goto L16;
        IRoom r7 = (IRoom) r6.getValue();
    L17:
        com.bytedance.android.livesdk.chatroom.o r8 = os0.b.a();
        if (r8 == null) goto L20;
        Boolean r9 = r8.isAnchor();
    L21:
        boolean r10 = Intrinsics.areEqual(r9, Boolean.TRUE);
        if (r7 == null) goto L29;
        String r12 = r7.getOwnerUserIdString();
        if (r12 == null) goto L29;
        Boolean r17 = (Boolean) ((HashMap) ts0.a.b.getValue()).get(r12);
        if (r17 != null) goto L28;
        r17 = Boolean.FALSE;
    L28:
        if (r17 == null) goto L29;
    L30:
        boolean r18 = r17.booleanValue();
        if (r7 == null) goto L37;
        IBaseUser r19 = r7.getOwner();
        if (r19 == null) goto L37;
        g0 r20 = r19.getSubscribe();
        if (r20 == null) goto L37;
        long r22 = r20.getOpen();
    L38:
        boolean r23 = true;
        if (r22 != 1) goto L41;
        boolean r24 = true;
    L42:
        if (r7 == null) goto L46;
        IRoomAuthStatus r25 = r7.getRoomAuthStatus();
        if (r25 == null) goto L46;
        boolean r26 = r25.isShopFansClubMode();
    L47:
        boolean r27 = com.bytedance.android.live.revenue.core.util.h.a;
        boolean r28 = ((com.bytedance.android.live.profit.fansclub.n) com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.fansclub.n.class)).enableEcomFansClubReverse();
        if (r26 == false) goto L97;
        if (r28 == true) goto L97;
        if (((Boolean) s0.a.getValue()).booleanValue() == false) goto L72;
        com.bytedance.android.live.profit.fansclub.o r110 = yt0.c.c();
        if (r110 == null) goto L100;
        m<? extends com.bytedance.android.live.profit.fansclub.r> r111 = r110.getShopFansClubData();
        if (r111 == null) goto L101;
        com.bytedance.android.live.profit.fansclub.r r112 = (com.bytedance.android.live.profit.fansclub.r) r111.getValue();
        if (r112 == null) goto L102;
        String r113 = r112.fansClubSchema;
        if (r113 != null) goto L61;
        return;
    L61:
        if (r113.length() > 0) goto L64;
        r23 = false;
    L64:
        if (r23 == false) goto L104;
        if (r16 == null) goto L105;
        IBaseLiveActionHandler r114 = jc1.k.f(IBaseLiveActionHandler.class);
        if (r114 == null) goto L106;
        Uri r115 = UriProtector.parse(r113);
        if (r115 == null) goto L71;
        r5 = r115.toString();
    L71:
        r114.handleWithoutHost(r16, r5);
        return;
    L106:
        return;
    L105:
        return;
    L104:
        return;
    L102:
        return;
    L101:
        return;
    L100:
        return;
    L72:
        if (r10 == false) goto L74;
        if (r18 == true) goto L74;
    L76:
        com.bytedance.android.live.profit.fansclub.o r116 = yt0.c.c();
        if (r116 == null) goto L108;
        m<? extends com.bytedance.android.live.profit.fansclub.r> r117 = r116.getShopFansClubData();
        if (r117 == null) goto L109;
        com.bytedance.android.live.profit.fansclub.r r118 = (com.bytedance.android.live.profit.fansclub.r) r117.getValue();
        if (r118 == null) goto L110;
        String r119 = r118.fansClubSchema;
        if (r119 != null) goto L85;
        return;
    L85:
        if (r119.length() > 0) goto L88;
        r23 = false;
    L88:
        if (r23 == false) goto L112;
        if (r16 == null) goto L113;
        jc1.k.n(IBaseLiveActionHandler.class).handleWithoutHost(r16, UriProtector.parse(r119).toString());
        return;
    L113:
        return;
    L112:
        return;
    L110:
        return;
    L109:
        return;
    L108:
        return;
    L74:
        if (r10 == true) goto L91;
        if (r24 == false) goto L76;
    L91:
        if (r10 == false) goto L96;
        if (r18 == false) goto L96;
        if (((Boolean) r0.a.getValue()).booleanValue() == false) goto L115;
        r4.a(r14, false);
        return;
    L115:
        return;
    L96:
        r4.a(r14, r15);
        return;
    L97:
        r4.a(r14, r15);
        return;
    L46:
        r26 = false;
        goto L47
    L41:
        r24 = false;
    L37:
        r22 = 0;
    L29:
        r17 = Boolean.FALSE;
        goto L30
    L20:
        r9 = null;
    L16:
        r7 = null;
        goto L17
    }

    public static /* synthetic */ com.bytedance.android.live.profile.model.d getNewPageType$default(NewProfileInfoViewModel r0, NewProfileUser r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L7;
        r1 = null;
    L7:
        return r0.getNewPageType(r1);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getNewPageType");
    }

    @Override // com.bytedance.android.live.profile.a
    public void clickShopEntrance(Context r7, int r8, Class<Object> r9, String r10) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r9, "clazz");
        Intrinsics.checkNotNullParameter(r10, "from");
        this.mTrackLogUseCase.z("livesdk_click_store_entrance", r8, r10);
        String r1 = this.mTargetUser.baseProfileInfo.getIdStr();
        o0.a.getClass();
        if ((!o0.a.b(r1)) == false) goto L6;
        return;
    L6:
        if (this.mTargetUser.isVcdContentAuthorized() == true) goto L12;
        if (this.mPageTypeProcess.c == true) goto L52;
        f2.c(((ss0.e) rs0.v.a.getValue()).userpreviewToast, 0);
        return;
    L52:
        return;
    L12:
        if (canJump() == true) goto L15;
        return;
    L15:
        if (noJumpInLinkCross() == false) goto L18;
        f2.b(2131919284, 0);
        return;
    L18:
        this.mTrackLogUseCase.getClass();
        Intrinsics.checkNotNullParameter(r10, "from");
        HashMap r0 = new HashMap();
        if (r8 != ProfileConstant.ProfileType.SHOP.getType()) goto L21;
        String r2 = "shop";
    L22:
        r0.put("store_type", r2);
        r0.put("entrance_location", r10);
        o r3 = j0.l().c(am2.x.class);
        String r4 = "";
        if (r3 == null) goto L31;
        String r5 = (String) r3.getMap().get("enter_from_merge");
        if (r5 != null) goto L27;
        r5 = "";
    L27:
        String r6 = (String) r3.getMap().get("enter_method");
        if (r6 != null) goto L30;
        r6 = "";
    L30:
        r0.put("store_source_page", r5);
        r0.put("store_source_method", r6);
    L31:
        o r12 = j0.l().c(IRoom.class);
        if (r12 == null) goto L38;
        String r13 = (String) r12.getMap().get("anchor_id");
        if (r13 == null) goto L37;
        r4 = r13;
    L37:
        r0.put("author_id", r4);
    L38:
        r0.put("store_group_type", "live");
        j0.l().sendLog("livesdk_enter_store_page", r0, new Object[0]);
        if (Intrinsics.areEqual(r9, ProfileCommonComponent.class) == false) goto L44;
        ut0.c r14 = this.mJumpUseCase;
        if (r14 == null) goto L50;
        r14.d(r7, r8, r10);
    L50:
        dismiss();
        return;
    L44:
        if (Intrinsics.areEqual(r9, com.bytedance.android.live.profile.ui.component.s.class) == false) goto L46;
    L47:
        ut0.c r15 = this.mJumpUseCase;
        if (r15 == null) goto L50;
        r15.i(r7, r10);
        goto L50
    L46:
        if (Intrinsics.areEqual(r9, com.bytedance.android.live.profile.ui.component.i.class) == false) goto L50;
    L21:
        r2 = "window";
        goto L22
    }
}
