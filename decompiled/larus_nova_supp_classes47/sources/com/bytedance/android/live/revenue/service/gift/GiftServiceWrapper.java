package com.bytedance.android.live.revenue.service.gift;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import ca0.c;
import ca0.g;
import ca0.o;
import ca0.r;
import ca0.w;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.i;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.gift.IGiftCoreService;
import com.bytedance.android.live.core.resources.AssetsModel;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.gift.BaseCommentGiftGuideView;
import com.bytedance.android.live.gift.GiftType;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.live.gift.IGiftServiceExternal;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.service.base.RevenueExposedWrapperBase;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.gift.configmodel.k1;
import com.bytedance.android.livesdk.gift.effect.model.EffectMessage;
import com.bytedance.android.livesdk.gift.model.Gift;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.m1;
import com.bytedance.android.livesdk.gift.model.m2;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.platform.business.e;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.core.model.b0;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdkapi.depend.live.ILiveGiftService;
import com.bytedance.android.livesdkapi.depend.live.gift.ILiveGiftPlayControllerManager;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.IRevenueFeedGameEffectServiceContainer;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import g50.b;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import v12.f;
import zo2.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000Ú\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010%\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007B\t¢\u0006\u0006\bø\u0001\u0010ù\u0001J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\bH\u0016J\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u001c\u0010\u0015\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u001eH\u0017J\u001a\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u000eH\u0017J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001fH\u0016J2\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\bH\u0016J4\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J<\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010%\u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016JD\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010&2\u0006\u0010)\u001a\u00020(2\b\u0010*\u001a\u0004\u0018\u00010\u000eH\u0016JF\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010%\u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010*\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010-\u001a\u00020\u00142\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\u0012\u0010.\u001a\u00020\u00142\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\b\u0010/\u001a\u00020\u0014H\u0016J\b\u00100\u001a\u00020(H\u0016J\u0012\u00102\u001a\u00020\u00142\b\u00101\u001a\u0004\u0018\u00010\u001eH\u0016J\n\u00103\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u00106\u001a\u00020(2\b\u00105\u001a\u0004\u0018\u000104H\u0016J\u0010\u00108\u001a\u00020\u00142\u0006\u00107\u001a\u00020(H\u0016J\b\u00109\u001a\u00020(H\u0016J\u0010\u0010;\u001a\u00020\u00142\u0006\u0010:\u001a\u00020(H\u0016J\b\u0010<\u001a\u00020(H\u0016J\b\u0010=\u001a\u00020(H\u0016J\b\u0010>\u001a\u00020\u0014H\u0016JD\u0010D\u001a\u00020\u00142\u0006\u0010?\u001a\u00020\b2\u0006\u0010@\u001a\u00020\u000e2\u0014\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010A2\u0014\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010AH\u0016JD\u0010D\u001a\u00020\u00142\u0006\u0010?\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020\u000e2\u0014\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010A2\u0014\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010AH\u0016J&\u0010E\u001a\u00020\u00142\u0006\u0010@\u001a\u00020\u000e2\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010AH\u0016JM\u0010L\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010F\u001a\u00020\u001f2\b\u0010G\u001a\u0004\u0018\u00010\b2\u0006\u0010H\u001a\u00020\u000e2\u000e\u0010J\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010I2\b\u0010,\u001a\u0004\u0018\u00010KH\u0016¢\u0006\u0004\bL\u0010MJ\u0010\u0010O\u001a\u00020(2\u0006\u0010N\u001a\u00020\u001fH\u0016J\u0012\u0010P\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010Q\u001a\u00020\u0014H\u0016J\b\u0010R\u001a\u00020\u0014H\u0016J\b\u0010S\u001a\u00020\u001fH\u0016J\u000e\u0010V\u001a\b\u0012\u0004\u0012\u00020U0TH\u0016J\u000e\u0010W\u001a\b\u0012\u0004\u0012\u00020U0TH\u0016J\u001a\u0010X\u001a\u00020\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010F\u001a\u00020\u001fH\u0016J\n\u0010Y\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010[\u001a\u00020ZH\u0016J\u0012\u0010]\u001a\u0004\u0018\u00010\\2\u0006\u0010\t\u001a\u00020\bH\u0016J0\u0010e\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020c\u0012\u0006\b\u0001\u0012\u00020d0b\u0018\u00010a2\b\u0010_\u001a\u0004\u0018\u00010^2\u0006\u0010`\u001a\u00020\u001fH\u0016J,\u0010g\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020f\u0012\u0004\u0012\u00020d0b0a2\b\u0010_\u001a\u0004\u0018\u00010^2\u0006\u0010`\u001a\u00020\u001fH\u0016J\b\u0010i\u001a\u00020hH\u0016J.\u0010n\u001a\u00020m2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010k\u001a\u0004\u0018\u00010j2\b\u00105\u001a\u0004\u0018\u0001042\u0006\u0010l\u001a\u00020\u001fH\u0016J\b\u0010p\u001a\u00020oH\u0016J\b\u0010r\u001a\u00020qH\u0016J\u0010\u0010t\u001a\n\u0012\u0006\b\u0001\u0012\u00020q0sH\u0016J-\u0010w\u001a\u00020\u00142\b\u0010u\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010v\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\bw\u0010xJ\b\u0010y\u001a\u00020qH\u0016J\b\u0010z\u001a\u00020qH\u0016J\b\u0010{\u001a\u00020qH\u0016J\b\u0010|\u001a\u00020qH\u0016J\b\u0010}\u001a\u00020qH\u0016J\b\u0010~\u001a\u00020qH\u0016J\b\u0010\u007f\u001a\u00020qH\u0016J\u0013\u0010\u0080\u0001\u001a\u00020\u00142\b\u0010F\u001a\u0004\u0018\u00010\u000eH\u0016J!\u0010\u0085\u0001\u001a\u00020\u00142\n\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0081\u00012\n\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u0001H\u0016J\u0015\u0010\u0086\u0001\u001a\u00020\u00142\n\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0081\u0001H\u0016J\u0018\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0083\u00012\n\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0081\u0001H\u0016J\u000f\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020\n0TH\u0016J\u0011\u0010R\u001a\u00020\u00142\u0007\u0010\u0089\u0001\u001a\u00020\u001fH\u0016J:\u0010R\u001a\u00020\u00142\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008a\u00012\u0007\u0010\u008c\u0001\u001a\u00020\b2\u0007\u0010\u0089\u0001\u001a\u00020\u001f2\u0007\u0010\u008d\u0001\u001a\u00020(2\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u000eH\u0016Jg\u0010\u0096\u0001\u001a\u00030\u0095\u00012\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008f\u00012\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0091\u00012\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u0093\u00012\u0006\u0010\t\u001a\u00020\b2\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u000e2\u0006\u0010N\u001a\u00020\b2\b\u0010F\u001a\u0004\u0018\u00010\u000e2\b\u00105\u001a\u0004\u0018\u000104H\u0016J\u0014\u0010\u0098\u0001\u001a\u00030\u0097\u00012\b\u00105\u001a\u0004\u0018\u000104H\u0016J0\u0010\u009c\u0001\u001a\u00020\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0007\u0010\u0099\u0001\u001a\u00020\b2\n\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009a\u00012\u0006\u0010F\u001a\u00020\u001fH\u0016J\u001b\u0010\u009d\u0001\u001a\u00020(2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0013\u0010\u009e\u0001\u001a\u00020\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u001e\u0010 \u0001\u001a\u0005\u0018\u00010\u009f\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0012\u0010¡\u0001\u001a\u00020\u00142\u0007\u0010\u008c\u0001\u001a\u00020\bH\u0016J\n\u0010£\u0001\u001a\u00030¢\u0001H\u0016J\u0016\u0010¥\u0001\u001a\u0005\u0018\u00010¤\u00012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010§\u0001\u001a\u00020\u00142\u0007\u0010¦\u0001\u001a\u00020(H\u0016J\t\u0010¨\u0001\u001a\u00020\bH\u0016J'\u0010©\u0001\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010k\u001a\u0004\u0018\u00010j2\b\u00105\u001a\u0004\u0018\u000104H\u0016J\u0011\u0010ª\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00020o0sH\u0016J\u0013\u0010«\u0001\u001a\f\u0012\u0006\b\u0001\u0012\u00020o\u0018\u00010sH\u0016J'\u0010±\u0001\u001a\u00020\u00142\b\u0010\u00ad\u0001\u001a\u00030¬\u00012\b\u0010¯\u0001\u001a\u00030®\u00012\b\u0010°\u0001\u001a\u00030®\u0001H\u0016J\n\u0010³\u0001\u001a\u00030²\u0001H\u0016J\t\u0010´\u0001\u001a\u00020\u0014H\u0016J\t\u0010µ\u0001\u001a\u00020\u001bH\u0016J\t\u0010¶\u0001\u001a\u00020\u0014H\u0016J\u0012\u0010¸\u0001\u001a\u00020\b2\u0007\u0010·\u0001\u001a\u00020(H\u0016J\t\u0010¹\u0001\u001a\u00020\bH\u0016J\t\u0010º\u0001\u001a\u00020\u0014H\u0016J\u0015\u0010½\u0001\u001a\u00020\u00142\n\u0010¼\u0001\u001a\u0005\u0018\u00010»\u0001H\u0016J\t\u0010¾\u0001\u001a\u00020\u0014H\u0016J\u0012\u0010¿\u0001\u001a\u00020\u00142\u0007\u0010\u0099\u0001\u001a\u00020\bH\u0016J\u0012\u0010À\u0001\u001a\u00020\u00142\u0007\u0010\u0099\u0001\u001a\u00020\bH\u0016J\u0015\u0010Ã\u0001\u001a\u00020\u00142\n\u0010Â\u0001\u001a\u0005\u0018\u00010Á\u0001H\u0016J\t\u0010Ä\u0001\u001a\u00020\u0014H\u0016J\t\u0010Å\u0001\u001a\u00020\bH\u0016J\t\u0010Æ\u0001\u001a\u00020\bH\u0016J\t\u0010Ç\u0001\u001a\u00020\u0014H\u0016J\u0012\u0010É\u0001\u001a\u00020\u00142\u0007\u0010È\u0001\u001a\u00020(H\u0016J\t\u0010Ê\u0001\u001a\u00020(H\u0016J\u0015\u0010Í\u0001\u001a\u00020\u00142\n\u0010Ì\u0001\u001a\u0005\u0018\u00010Ë\u0001H\u0016J\u0012\u0010Ï\u0001\u001a\u00020\u00142\u0007\u0010Î\u0001\u001a\u00020#H\u0016J\"\u0010Ó\u0001\u001a\u0005\u0018\u00010Ò\u00012\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\u0010Ñ\u0001\u001a\u0005\u0018\u00010Ð\u0001H\u0016J\n\u0010Õ\u0001\u001a\u00030Ô\u0001H\u0016J\t\u0010Ö\u0001\u001a\u00020\u0014H\u0016J\u0013\u0010Ù\u0001\u001a\u00020\u00142\b\u0010Ø\u0001\u001a\u00030×\u0001H\u0016J:\u0010Ý\u0001\u001a\u00020\u00142\b\u0010Ø\u0001\u001a\u00030×\u00012\u0007\u0010Ú\u0001\u001a\u00020\u000e2\u0007\u0010Û\u0001\u001a\u00020\u001f2\t\u0010Ü\u0001\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010#H\u0016J:\u0010Ý\u0001\u001a\u00020\u00142\b\u0010ß\u0001\u001a\u00030Þ\u00012\u0007\u0010Ú\u0001\u001a\u00020\u000e2\u0007\u0010Û\u0001\u001a\u00020\u001f2\t\u0010Ü\u0001\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010#H\u0016JP\u0010ä\u0001\u001a\u00020\u00142\t\u0010à\u0001\u001a\u0004\u0018\u00010\u000e2\t\u0010Ü\u0001\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010#2%\u0010ã\u0001\u001a \u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0á\u0001j\u000f\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e`â\u0001H\u0016J4\u0010å\u0001\u001a\u00020\u00142)\u0010ã\u0001\u001a$\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010á\u0001j\u0011\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u0001`â\u0001H\u0016J4\u0010æ\u0001\u001a\u00020\u00142)\u0010ã\u0001\u001a$\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010á\u0001j\u0011\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u0001`â\u0001H\u0016J-\u0010ë\u0001\u001a\u0005\u0018\u00010ê\u00012\t\u0010ç\u0001\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\u0010é\u0001\u001a\u0005\u0018\u00010è\u0001H\u0016J\t\u0010ì\u0001\u001a\u00020\u001fH\u0016J\t\u0010í\u0001\u001a\u00020\u0014H\u0016J\u0014\u0010ñ\u0001\u001a\u00030ð\u00012\b\u0010ï\u0001\u001a\u00030î\u0001H\u0016J\t\u0010ò\u0001\u001a\u00020\u0014H\u0016J\u0011\u0010ó\u0001\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010aH\u0016J#\u0010õ\u0001\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0007\u0010\u008d\u0001\u001a\u00020(2\u0007\u0010ô\u0001\u001a\u00020(H\u0016J\n\u0010÷\u0001\u001a\u00030ö\u0001H\u0016¨\u0006ú\u0001"}, d2 = {"Lcom/bytedance/android/live/revenue/service/gift/GiftServiceWrapper;", "Lcom/bytedance/android/live/revenue/service/base/RevenueExposedWrapperBase;", "Lcom/bytedance/android/live/gift/IGiftService;", "Lcom/bytedance/android/live/core/gift/IGiftCoreService;", "Lcom/bytedance/android/livesdkapi/depend/live/ILiveGiftService;", "Lcom/bytedance/android/live/gift/IGiftServiceExternal;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/android/live/base/i;", "", "giftId", "Lcom/bytedance/android/livesdk/gift/model/Gift;", "findGiftById", "Lcom/bytedance/android/livesdk/gift/model/h2;", "findLiteGiftById", "", "panel", "effectId", "getAssetsPath", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "toUser", "", "openGiftDialog", "Landroid/content/Context;", "context", "extra", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;", "getEffectGameToolbarBehavior", "Landroid/os/Bundle;", "logExtra", "pageType", "Lcom/bytedance/android/live/base/model/user/User;", "", "refId", "defId", "toUserId", "Lorg/json/JSONObject;", "giftSendExtra", "buffLevel", "", "toUserIds", "", "isMultiSend", "cardName", "Lg50/b;", "listener", "addGiftSendResultListener", "removeGiftSendResultListener", "closeGiftDialog", "allowSendToGuest", "defaultUserToSendGift", "setDefaultUserToSendGift", "getDefaultUserToSendGift", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "isVSGiftIconShow", "showGiftEffect", "setNeedShowGiftEffectSwitch", "getNeedShowGiftEffectSwitch", "showTraySwitch", "setGiftTraySwitch", "getGiftTraySwitch", "needFrequencyRoomNotifyMessage", "initGiftEffectDialog", "targetUid", "reason", "", "registerLogExtra", "applyLogExtra", "registerRecommendReceiver", "unRegisterRecommendReceiver", "source", "locateGiftId", "clickFrom", "Lkotlin/Function0;", "cameraAction", "Landroid/content/DialogInterface$OnDismissListener;", "openInteractGiftDialog", "(Landroid/content/Context;ILjava/lang/Long;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroid/content/DialogInterface$OnDismissListener;)V", "type", "checkGroupContainerType", "initGiftResourceManager", "initGiftResourceCache", "syncGiftList", "getUserConsumeLevel", "", "Lzo2/a;", "getGiftNitaViewList", "getGiftPanelNitaViewList", "syncAssetsList", "getFastGift", "Lcom/bytedance/android/livesdkapi/depend/live/gift/ILiveGiftPlayControllerManager;", "giftPlayControllerManager", "Lcom/bytedance/android/livesdk/gift/model/m1;", "findGiftExtraInfo", "Lcom/bytedance/android/livesdk/gift/platform/core/model/b0;", "giftParams", "count", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/ExtraResponse;", "Lcom/bytedance/android/livesdk/gift/model/p2;", "Lcom/bytedance/android/live/base/model/Extra;", "sendGift", "Lcom/bytedance/android/livesdk/gift/model/m2;", "sendProp", "Lcom/bytedance/android/livesdk/gift/platform/business/effect/assets/IAssetsManager;", "getAssetsManager", "Landroidx/lifecycle/LifecycleOwner;", "owner", "landscapeSpiltTrayId", "Lf6/c;", "getGiftWidget", "Lcom/bytedance/ies/sdk/widgets/Widget;", "getMatchRoomGiftTrayWidget", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "getGestureGiftGuideWidget", "Ljava/lang/Class;", "getGiftPreviewDebugWidget", "assetUrl", "guidelineRes", "autoPlayMP4", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "getGiftTouchReceiveWidget", "getGiftEffectInfoLynxWidget", "getGiftFourthLineWidget", "getGiftFrontSeatLayerEffectWidget", "getPKTrayWidget", "getPKBattlePropEffectWidget", "getTopAtmosphereEffectWidget", "openGroupLiveDialog", "Lcom/bytedance/android/live/gift/GiftType;", "giftType", "Lca0/b;", "animationEngine", "setGiftAnimationEngine", "removeAnimationEngine", "getGiftAnimationEngine", "getStickerGifts", "requestSource", "Lca0/w;", "callback", "roomId", "isAnchor", "secAnchorId", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", "Lcom/bytedance/android/live/base/model/user/IUser;", "user", "Lga0/b;", "description", "Landroid/app/Dialog;", "getGiftGuideDialog", "Lga0/a;", "getGiftGuidePresenter", "id", "Lcom/bytedance/android/livesdk/gift/platform/business/effect/assets/f;", "result", "downloadAssets", "isAssetsDownloaded", "clearAssets", "Lcom/bytedance/android/live/core/resources/AssetsModel;", "getAssets", "removeFastGiftFromMap", "Lca0/r;", "getGiftUIStrategy", "Lcom/bytedance/android/live/gift/BaseCommentGiftGuideView;", "getCommentGiftGuideView", "show", "toggleVideoGiftView", "getLastEnterRoomTime", "initGiftModule", "getGiftWidgetClass", "getMultiPlayerClass", "", "temperature", "", "UIFps", "upStreamFps", "updateHotRoomInfo", "Lca0/c;", "getCommonPlayerControllerManager", "syncGiftPanel", "clearOverdueResource", "clearMarkResource", "isCleanMode", "clearAppAssetDir", "getSensitiveClearAssetSize", "clearSensitiveLRUAsset", "Lca0/g;", "service", "registerInRoomService", "unRegisterInRoomService", "setTemporaryFastGift", "removeTemporaryFastGift", "Lea0/a;", "monkeyGameEngine", "registerMonkeyGameEngine", "removeMonkeyGameEngine", "getSendGiftTime", "getSendGiftMoney", "syncMultiAnchorList", "allowed", "setAllowSendToGuest", "isGiftListLoaded", "Lzg1/h2;", "event", "sendPlayAlphaVideoEvent", "params", "triggerGiftAsyncSort", "Luu0/b;", "previewData", "Luu0/a;", "getGiftTrayPreviewView", "Lca0/a;", "getGiftTrayHeightInfo", "clearGiftExposureCache", "Lcom/bytedance/android/livesdk/message/model/o7;", "giftMessage", "receiveStickGiftMSgEvent", "step", "statusCode", "statusMsg", "monitorEffectPlayEvent", "Lcom/bytedance/android/livesdk/gift/effect/model/EffectMessage;", "message", "traceId", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "param", "stickFirstFrameEvent", "reportStickResourceLoadResult", "reportStickEffectRenderResult", "name", "Landroid/util/AttributeSet;", "attrs", "Landroid/view/View;", "createView", "getGiftUseDiskCacheSize", "cleanGiftDishCache", "Landroid/view/ViewGroup;", "container", "Lcom/bytedance/android/livesdkapi/feed/IRevenueFeedGameEffectServiceContainer;", "getRevenueFeedGameEffectServiceContainer", "clearGiftMemoryCache", "observeGiftMsgContent", "isBeforeLive", "openGiftEffectConfigurationDialog", "Lca0/o;", "getRevenueEventCenter", "<init>", "()V", "revenue-integration_saasRelease"}, k = 1, mv = {1, 4, 3})
public class GiftServiceWrapper extends RevenueExposedWrapperBase<IGiftService> implements IGiftCoreService, ILiveGiftService, IGiftServiceExternal, IService, i {
    public GiftServiceWrapper() {
        super(IGiftService.class);
    }

    public boolean allowSendToGuest() {
        return getRealInstance().allowSendToGuest();
    }

    public void cleanGiftDishCache() {
        getRealInstance().cleanGiftDishCache();
    }

    public void clearGiftExposureCache() {
        getRealInstance().clearGiftExposureCache();
    }

    public void clearGiftMemoryCache() {
        getRealInstance().clearGiftMemoryCache();
    }

    public void clearMarkResource() {
        getRealInstance().clearMarkResource();
    }

    public Bundle clearOverdueResource() {
        return getRealInstance().clearOverdueResource();
    }

    public void clearSensitiveLRUAsset() {
        getRealInstance().clearSensitiveLRUAsset();
    }

    public void closeGiftDialog() {
        getRealInstance().closeGiftDialog();
    }

    public IAssetsManager getAssetsManager() {
        return getRealInstance().getAssetsManager();
    }

    public c getCommonPlayerControllerManager() {
        return getRealInstance().getCommonPlayerControllerManager();
    }

    public IBaseUser getDefaultUserToSendGift() {
        return getRealInstance().getDefaultUserToSendGift();
    }

    public Gift getFastGift() {
        h1 r0 = getRealInstance().getFastGift();
        if ((r0 instanceof Gift) == true) goto L6;
        r0 = null;
    L6:
        return (Gift) r0;
    }

    public LiveRecyclableWidget getGestureGiftGuideWidget() {
        return getRealInstance().getGestureGiftGuideWidget();
    }

    public LiveRecyclableWidget getGiftEffectInfoLynxWidget() {
        return getRealInstance().getGiftEffectInfoLynxWidget();
    }

    public LiveRecyclableWidget getGiftFourthLineWidget() {
        return getRealInstance().getGiftFourthLineWidget();
    }

    public LiveRecyclableWidget getGiftFrontSeatLayerEffectWidget() {
        return getRealInstance().getGiftFrontSeatLayerEffectWidget();
    }

    public List<a> getGiftNitaViewList() {
        return getRealInstance().getGiftNitaViewList();
    }

    public List<a> getGiftPanelNitaViewList() {
        return getRealInstance().getGiftPanelNitaViewList();
    }

    public Class<? extends LiveRecyclableWidget> getGiftPreviewDebugWidget() {
        return getRealInstance().getGiftPreviewDebugWidget();
    }

    public LiveRecyclableWidget getGiftTouchReceiveWidget() {
        return getRealInstance().getGiftTouchReceiveWidget();
    }

    public ca0.a getGiftTrayHeightInfo() {
        int r0 = 2131168673;
        int r1 = s1.j(2131168673);
        int r2 = s1.j(2131168680);
        boolean r3 = ((k1) e.t.getValue(null, e.a[18])).a();
        if (r3 == false) goto L5;
        int r4 = 2131168664;
    L6:
        int r5 = s1.j(r4) + r1;
        if (r3 == true) goto L11;
        r0 = 2131168674;
    L11:
        return new ca0.a(r1, r2, r5, s1.j(r0) + r1);
    L5:
        r4 = 2131168662;
        goto L6
    }

    public boolean getGiftTraySwitch() {
        return getRealInstance().getGiftTraySwitch();
    }

    public r getGiftUIStrategy() {
        return getRealInstance().getGiftUIStrategy();
    }

    public int getGiftUseDiskCacheSize() {
        return getRealInstance().getGiftUseDiskCacheSize();
    }

    public Class<? extends Widget> getGiftWidgetClass() {
        return getRealInstance().getGiftWidgetClass();
    }

    public long getLastEnterRoomTime() {
        return getRealInstance().getLastEnterRoomTime();
    }

    public Widget getMatchRoomGiftTrayWidget() {
        return getRealInstance().getMatchRoomGiftTrayWidget();
    }

    public Class<? extends Widget> getMultiPlayerClass() {
        return getRealInstance().getMultiPlayerClass();
    }

    public boolean getNeedShowGiftEffectSwitch() {
        return getRealInstance().getNeedShowGiftEffectSwitch();
    }

    public LiveRecyclableWidget getPKBattlePropEffectWidget() {
        return getRealInstance().getPKBattlePropEffectWidget();
    }

    public LiveRecyclableWidget getPKTrayWidget() {
        return getRealInstance().getPKTrayWidget();
    }

    public long getSendGiftMoney() {
        return getRealInstance().getSendGiftMoney();
    }

    public long getSendGiftTime() {
        return getRealInstance().getSendGiftTime();
    }

    public long getSensitiveClearAssetSize() {
        return getRealInstance().getSensitiveClearAssetSize();
    }

    public List<Gift> getStickerGifts() {
        List r0 = getRealInstance().getStickerGifts();
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        h1 r3 = (h1) r2.next();
        if ((r3 instanceof Gift) == true) goto L8;
        r3 = null;
    L8:
        Gift r4 = (Gift) r3;
        if (r4 == null) goto L4;
        r1.add(r4);
        goto L4
    L11:
        return r1;
    }

    public LiveRecyclableWidget getTopAtmosphereEffectWidget() {
        return getRealInstance().getTopAtmosphereEffectWidget();
    }

    public int getUserConsumeLevel() {
        return getRealInstance().getUserConsumeLevel();
    }

    public ILiveGiftPlayControllerManager giftPlayControllerManager() {
        return getRealInstance().giftPlayControllerManager();
    }

    public void initGiftEffectDialog() {
        getRealInstance().initGiftEffectDialog();
    }

    public void initGiftResourceCache() {
        getRealInstance().initGiftResourceCache();
    }

    public boolean isGiftListLoaded() {
        return getRealInstance().isGiftListLoaded();
    }

    public boolean needFrequencyRoomNotifyMessage() {
        return getRealInstance().needFrequencyRoomNotifyMessage();
    }

    public Observable<JSONObject> observeGiftMsgContent() {
        return getRealInstance().observeGiftMsgContent();
    }

    public void removeMonkeyGameEngine() {
        getRealInstance().removeMonkeyGameEngine();
    }

    public void syncGiftList() {
        getRealInstance().syncGiftList();
    }

    public void syncGiftPanel() {
        getRealInstance().syncGiftPanel();
    }

    public void syncMultiAnchorList() {
        getRealInstance().syncMultiAnchorList();
    }

    public void unRegisterInRoomService() {
        getRealInstance().unRegisterInRoomService();
    }

    public o getRevenueEventCenter() {
        return da0.a.b;
    }

    public void addGiftSendResultListener(b r3) {
        IGiftService r0 = getRealInstance();
        if (r3 == null) goto L5;
        s01.a r1 = new s01.a(r3);
    L6:
        r0.addGiftSendResultListener(r1);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public boolean checkGroupContainerType(int r2) {
        return getRealInstance().checkGroupContainerType(r2);
    }

    public long clearAppAssetDir(boolean r3) {
        return getRealInstance().clearAppAssetDir(Boolean.valueOf(r3)).longValue();
    }

    public void clearAssets(String r2) {
        getRealInstance().clearAssets(r2);
    }

    public Gift findGiftById(long r2) {
        h1 r3 = getRealInstance().findGiftById(r2);
        if ((r3 instanceof Gift) == true) goto L6;
        r3 = null;
    L6:
        return (Gift) r3;
    }

    public m1 findGiftExtraInfo(long r2) {
        return getRealInstance().findGiftExtraInfo(r2);
    }

    public h2 findLiteGiftById(long r2) {
        return getRealInstance().findLiteGiftById(r2);
    }

    public BaseCommentGiftGuideView getCommentGiftGuideView(Context r2) {
        return getRealInstance().getCommentGiftGuideView(r2);
    }

    public ca0.b getGiftAnimationEngine(GiftType r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return com.bytedance.android.livesdk.gift.platform.core.manager.a.b().a(r2);
    }

    public ga0.a getGiftGuidePresenter(DataCenter r2) {
        return getRealInstance().getGiftGuidePresenter(r2);
    }

    public IRevenueFeedGameEffectServiceContainer getRevenueFeedGameEffectServiceContainer(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        return getRealInstance().getRevenueFeedGameEffectServiceContainer(r2);
    }

    public void initGiftResourceManager(Context r2) {
        getRealInstance().initGiftResourceManager(r2);
    }

    public boolean isVSGiftIconShow(DataCenter r2) {
        return getRealInstance().isVSGiftIconShow(r2);
    }

    public void openGiftDialog(int r2) {
        getRealInstance().openGiftDialog(r2);
    }

    public void openGroupLiveDialog(String r2) {
        getRealInstance().openGroupLiveDialog(r2);
    }

    public void receiveStickGiftMSgEvent(o7 r3) {
        Intrinsics.checkNotNullParameter(r3, "giftMessage");
        f.M(r3, true, false);
    }

    public void registerInRoomService(g r2) {
        getRealInstance().registerInRoomService(r2);
    }

    public void registerMonkeyGameEngine(ea0.a r2) {
        getRealInstance().registerMonkeyGameEngine(r2);
    }

    public void removeAnimationEngine(GiftType r2) {
        getRealInstance().removeAnimationEngine(r2);
    }

    public void removeFastGiftFromMap(long r2) {
        getRealInstance().removeFastGiftFromMap(r2);
    }

    public void removeGiftSendResultListener(b r3) {
        IGiftService r0 = getRealInstance();
        if (r3 == null) goto L5;
        s01.a r1 = new s01.a(r3);
    L6:
        r0.removeGiftSendResultListener(r1);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public void removeTemporaryFastGift(long r2) {
        getRealInstance().removeTemporaryFastGift(r2);
    }

    public void reportStickEffectRenderResult(HashMap<String, String> r1) {
        if (r1 == null) goto L5;
        com.bytedance.android.livesdk.gift.platform.core.utils.e.c(r1);
        return;
    }

    public void reportStickResourceLoadResult(HashMap<String, String> r1) {
        if (r1 == null) goto L5;
        com.bytedance.android.livesdk.gift.platform.core.utils.e.b(r1);
        return;
    }

    public void sendPlayAlphaVideoEvent(zg1.h2 r2) {
        getRealInstance().sendPlayAlphaVideoEvent(r2);
    }

    public void setAllowSendToGuest(boolean r2) {
        getRealInstance().setAllowSendToGuest(r2);
    }

    public void setDefaultUserToSendGift(User r2) {
        getRealInstance().setDefaultUserToSendGift(r2);
    }

    public void setGiftTraySwitch(boolean r2) {
        getRealInstance().setGiftTraySwitch(r2);
    }

    public void setNeedShowGiftEffectSwitch(boolean r2) {
        getRealInstance().setNeedShowGiftEffectSwitch(r2);
    }

    public void setTemporaryFastGift(long r2) {
        getRealInstance().setTemporaryFastGift(r2);
    }

    public void syncGiftList(int r2) {
        getRealInstance().syncGiftList(r2);
    }

    public void toggleVideoGiftView(boolean r2) {
        getRealInstance().toggleVideoGiftView(r2);
    }

    public void triggerGiftAsyncSort(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        getRealInstance().triggerGiftAsyncSort(r2);
    }

    public /* bridge */ /* synthetic */ Long clearAppAssetDir(Boolean r3) {
        return Long.valueOf(clearAppAssetDir(r3.booleanValue()));
    }

    /* JADX INFO: renamed from: findGiftById, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ h1 m448findGiftById(long r1) {
        return findGiftById(r1);
    }

    public void openGiftDialog(IBaseUser r2) {
        getRealInstance().openGiftDialog(r2);
    }

    @Deprecated(message = "Deprecated in Java")
    public void openGiftDialog(String r2) {
        getRealInstance().openGiftDialog(r2);
    }

    public AssetsModel getAssets(String r2, long r3) {
        com.bytedance.android.live.core.resources.e r4 = getRealInstance().getAssets(r2, r3);
        if ((r4 instanceof AssetsModel) == true) goto L6;
        r4 = null;
    L6:
        return (AssetsModel) r4;
    }

    public String getAssetsPath(String r2, long r3) {
        return getRealInstance().getAssetsPath(r2, r3);
    }

    public c0.b getEffectGameToolbarBehavior(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        View.OnClickListener r4 = getRealInstance().getEffectGameToolbarBehavior(r2, r3);
        if ((r4 instanceof c0.b) == true) goto L6;
        r4 = null;
    L6:
        return (c0.b) r4;
    }

    public uu0.a getGiftTrayPreviewView(Context r2, uu0.b r3) {
        return getRealInstance().getGiftTrayPreviewView(r2, r3);
    }

    public boolean isAssetsDownloaded(String r2, long r3) {
        return getRealInstance().isAssetsDownloaded(r2, r3);
    }

    public void openGiftDialog(int r2, User r3) {
        getRealInstance().openGiftDialog(r2, r3);
    }

    public Observable<ExtraResponse<p2, ? extends Extra>> sendGift(b0 r2, int r3) {
        return getRealInstance().sendGift(r2, r3);
    }

    public Observable<ExtraResponse<m2, Extra>> sendProp(b0 r2, int r3) {
        return getRealInstance().sendProp(r2, r3);
    }

    public void setGiftAnimationEngine(GiftType r2, ca0.b r3) {
        getRealInstance().setGiftAnimationEngine(r2, r3);
    }

    public void syncAssetsList(String r2, int r3) {
        getRealInstance().syncAssetsList(r2, r3);
    }

    public void unRegisterRecommendReceiver(String r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        getRealInstance().unRegisterRecommendReceiver(r2, r3);
    }

    public void openGiftDialog(IBaseUser r2, Bundle r3) {
        getRealInstance().openGiftDialog(r2, r3);
    }

    @Deprecated(message = "Deprecated in Java")
    public void openGiftDialog(String r2, User r3) {
        getRealInstance().openGiftDialog(r2, r3);
    }

    public void autoPlayMP4(String r2, Long r3, String r4) {
        getRealInstance().autoPlayMP4(r2, r3, r4);
    }

    public View createView(String r2, Context r3, AttributeSet r4) {
        return getRealInstance().createView(r2, r3, r4);
    }

    public void initGiftModule(Context r2, LifecycleOwner r3, DataCenter r4) {
        getRealInstance().initGiftModule(r2, r3, r4);
    }

    public void openGiftEffectConfigurationDialog(Context r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        getRealInstance().openGiftEffectConfigurationDialog(r2, Boolean.valueOf(r3), Boolean.valueOf(r4));
    }

    public void updateHotRoomInfo(float r8, double r9, double r12) {
        getRealInstance().updateHotRoomInfo(r8, r9, r12);
    }

    public /* bridge */ /* synthetic */ void openGiftEffectConfigurationDialog(Context r1, Boolean r2, Boolean r3) {
        openGiftEffectConfigurationDialog(r1, r2.booleanValue(), r3.booleanValue());
    }

    public void downloadAssets(String r8, long r9, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r12, int r13) {
        getRealInstance().downloadAssets(r8, r9, r12, r13);
    }

    public f6.c getGiftWidget(Context r2, LifecycleOwner r3, DataCenter r4, int r5) {
        return getRealInstance().getGiftWidget(r2, r3, r4, r5);
    }

    public void registerRecommendReceiver(long r8, String r10, Map<String, String> r12, Map<String, String> r13) {
        Intrinsics.checkNotNullParameter(r10, "reason");
        getRealInstance().registerRecommendReceiver(r8, r10, r12, r13);
    }

    public void stickFirstFrameEvent(String r1, String r2, JSONObject r3, HashMap<String, String> r4) {
        Intrinsics.checkNotNullParameter(r4, "param");
        f.A(r1, r3, r4);
    }

    public void registerRecommendReceiver(String r2, String r3, Map<String, String> r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r2, "targetUid");
        Intrinsics.checkNotNullParameter(r3, "reason");
        getRealInstance().registerRecommendReceiver(r2, r3, r4, r5);
    }

    public void monitorEffectPlayEvent(EffectMessage r2, String r3, int r4, String r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "step");
        f.u(r2, r3, r4, r5, r6);
    }

    public void openGiftDialog(int r10, long r12, Bundle r13, String r14, long r15) {
        Intrinsics.checkNotNullParameter(r14, "refId");
        getRealInstance().openGiftDialog(r10, r12, r13, r14, r15);
    }

    public void syncGiftList(w r9, long r10, int r12, boolean r13, String r14) {
        getRealInstance().syncGiftList(r9, r10, r12, r13, r14);
    }

    public void monitorEffectPlayEvent(o7 r2, String r3, int r4, String r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r2, "giftMessage");
        Intrinsics.checkNotNullParameter(r3, "step");
        f.s(r2, r3, r4, r5, r6);
    }

    public void openGiftDialog(int r9, long r10, String r12, Bundle r13, JSONObject r14) {
        Intrinsics.checkNotNullParameter(r12, "toUserId");
        getRealInstance().openGiftDialog(r9, r10, r12, r13, r14);
    }

    public void openGiftDialog(int r10, long r12, String r13, Bundle r14, int r15, JSONObject r16) {
        Intrinsics.checkNotNullParameter(r13, "toUserId");
        getRealInstance().openGiftDialog(r10, r12, r13, r14, r15, r16);
    }

    public void openInteractGiftDialog(Context r9, int r10, Long r12, String r13, Function0<Unit> r14, DialogInterface.OnDismissListener r15) {
        Intrinsics.checkNotNullParameter(r13, "clickFrom");
        getRealInstance().openInteractGiftDialog(r9, r10, r12, r13, r14, r15);
    }

    public void openGiftDialog(int r10, long r12, Bundle r13, List<String> r14, boolean r15, String r16) {
        getRealInstance().openGiftDialog(r10, r12, r13, r14, r15, r16);
    }

    public void openGiftDialog(int r12, long r13, String r14, Bundle r15, int r16, JSONObject r17, String r18) {
        Intrinsics.checkNotNullParameter(r14, "toUserId");
        getRealInstance().openGiftDialog(r12, r13, r14, r15, r16, r17, r18);
    }

    public Dialog getGiftGuideDialog(Context r14, Room r15, IUser r16, ga0.b r17, long r18, String r20, long r22, String r23, DataCenter r24) {
        return getRealInstance().getGiftGuideDialog(r14, r15, r16, r17, r18, r20, r22, r23, r24);
    }
}
