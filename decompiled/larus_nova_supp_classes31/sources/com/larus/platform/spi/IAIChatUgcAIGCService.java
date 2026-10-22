package com.larus.platform.spi;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import by7.e;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.o1;
import com.larus.bmhome.chat.component.bottom.core.y8;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageContentData;
import com.larus.bmhome.chat.layout.holder.progressloading.ISketchLoadingController;
import com.larus.bmhome.chat.layout.holder.video.bean.AiGenVideoContentData;
import com.larus.bmhome.instruction.helper.f;
import com.larus.bmhome.instruction.m;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.panel.h;
import com.larus.bmhome.utils.c4;
import com.larus.bmhome.view.actionbar.custom.cache.k;
import com.larus.bmhome.view.actionbar.custom.router.b;
import com.larus.bmhome.view.actionbar.custom.w2;
import com.larus.bmhome.view.actionbar.custom.x2;
import com.larus.bmhome.view.actionbar.edit.c;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.g0;
import com.larus.platform.model.SlashMentionConfig;
import com.larus.uaigc.createpage.component.instruction.CreationEditorComponent;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import fn8.w;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.i1;
import mr9.j;
import nr9.g;
import org.json.JSONObject;
import vp8.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000ü\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\bg\u0018\u0000 \u008b\u00022\u00020\u0001:\u0002\u008b\u0002J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\u0015\u001a\u00020\u0016H&J\b\u0010\u0017\u001a\u00020\u000bH&J \u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000bH&J`\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\r2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001d0+H&J*\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\u000b2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001d0+H¦@¢\u0006\u0002\u0010/J\u0010\u00100\u001a\u00020\u001d2\u0006\u00101\u001a\u000202H&J\u0018\u00103\u001a\u0012\u0012\u0004\u0012\u00020504j\b\u0012\u0004\u0012\u000205`6H&J\u0089\u0001\u00107\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010'\u001a\u00020(2\u0006\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010D2\b\u0010E\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010F\u001a\u0004\u0018\u0001022\u0016\b\u0002\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010HH&¢\u0006\u0002\u0010IJ6\u0010J\u001a\u0004\u0018\u00010\u00072\b\u0010K\u001a\u0004\u0018\u00010\u00072\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u0002022\u0006\u0010O\u001a\u0002022\b\b\u0002\u0010P\u001a\u00020\rH&J\u0010\u0010Q\u001a\u00020>2\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0010\u0010R\u001a\u00020\r2\u0006\u0010S\u001a\u00020TH&JL\u0010Z\u001a\u00020\u001d*\u00020>2\u0006\u0010L\u001a\u00020T2\b\u0010[\u001a\u0004\u0018\u00010\\2\b\u0010]\u001a\u0004\u0018\u00010^2\n\b\u0002\u0010_\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010a\u001a\u0004\u0018\u00010bH&J\b\u0010c\u001a\u00020dH&J\u0010\u0010e\u001a\u00020f2\u0006\u0010\u001e\u001a\u00020\u001fH&JR\u0010g\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010h\u001a\u00020i2\b\u0010j\u001a\u0004\u0018\u00010k2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010l\u001a\u0004\u0018\u00010m2\u0006\u0010n\u001a\u0002022\u0006\u0010o\u001a\u00020\r2\n\b\u0002\u0010p\u001a\u0004\u0018\u00010\u000bH'JÒ\u0001\u0010g\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010h\u001a\u00020i2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010l\u001a\u0004\u0018\u00010m2\u0006\u0010n\u001a\u0002022\u0006\u0010o\u001a\u00020\r2\n\b\u0002\u0010p\u001a\u0004\u0018\u00010\u000b2\u0006\u0010q\u001a\u00020\u000b2\n\b\u0002\u0010r\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010s\u001a\u0004\u0018\u00010t2\u0014\u0010u\u001a\u0010\u0012\u0004\u0012\u00020v\u0012\u0004\u0012\u00020\u001d\u0018\u00010+2*\u0010w\u001a&\u0012\u0004\u0012\u00020y\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010z\u0012\u0004\u0012\u00020\u001d\u0018\u00010x2\u0016\u0010{\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010;\u0012\u0004\u0012\u00020\u001d\u0018\u00010+2\u000e\u0010|\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010}H&J\u008d\u0002\u0010~\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u007f\u001a\u00020D2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u000b2\b\u0010p\u001a\u0004\u0018\u00010\u000b2\u0006\u0010o\u001a\u00020\r2\u008b\u0001\u0010\u0083\u0001\u001a\u0085\u0001\u0012\u0015\u0012\u00130D¢\u0006\u000e\b\u0084\u0001\u0012\t\b\u0085\u0001\u0012\u0004\b\b(\u007f\u0012\u0016\u0012\u00140\u000b¢\u0006\u000f\b\u0084\u0001\u0012\n\b\u0085\u0001\u0012\u0005\b\b(\u0086\u0001\u0012$\u0012\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010H¢\u0006\u000f\b\u0084\u0001\u0012\n\b\u0085\u0001\u0012\u0005\b\b(\u0087\u0001\u0012$\u0012\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010H¢\u0006\u000f\b\u0084\u0001\u0012\n\b\u0085\u0001\u0012\u0005\b\b(\u0088\u0001\u0012\u0004\u0012\u00020\u001d\u0018\u00010x2\u0017\b\u0002\u0010\u0088\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010H2\u0017\b\u0002\u0010\u0089\u0001\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001d\u0018\u00010+H&J\u001f\u0010\u008a\u0001\u001a\u0004\u0018\u00010T2\b\u0010j\u001a\u0004\u0018\u00010k2\b\u0010<\u001a\u0004\u0018\u00010\u000bH&J\u0016\u0010\u008b\u0001\u001a\u00030\u008c\u00012\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001H&J\n\u0010\u008f\u0001\u001a\u00030\u0090\u0001H&J6\u0010\u0091\u0001\u001a\u00020\u001d*\u00020>2\u0006\u0010L\u001a\u00020T2\t\u0010C\u001a\u0005\u0018\u00010\u0092\u00012\b\u0010[\u001a\u0004\u0018\u00010\\2\n\b\u0002\u0010a\u001a\u0004\u0018\u00010bH&J\u001f\u0010\u0093\u0001\u001a\u00020\u001d*\u00020>2\u0006\u0010L\u001a\u00020T2\b\u0010[\u001a\u0004\u0018\u00010\\H&J\u0016\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u00012\b\u0010S\u001a\u0004\u0018\u00010TH&J\u0016\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0092\u00012\b\u0010S\u001a\u0004\u0018\u00010TH&J³\u0001\u0010\u0097\u0001\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010C\u001a\u0004\u0018\u00010D2\u0007\u0010\u0098\u0001\u001a\u00020B2\u0007\u0010\u0099\u0001\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020(2\t\b\u0002\u0010\u009a\u0001\u001a\u00020\r2\t\b\u0002\u0010\u009b\u0001\u001a\u00020\r2\u000b\b\u0002\u0010\u009c\u0001\u001a\u0004\u0018\u00010b2\u0016\b\u0002\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010H2\u000b\b\u0002\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u000b2\t\b\u0002\u0010\u009e\u0001\u001a\u00020\r2'\u0010\u009f\u0001\u001a\"\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u001d0xH&Jb\u0010 \u0001\u001a\u00020\u001d2\b\u0010¡\u0001\u001a\u00030¢\u00012\u0007\u0010£\u0001\u001a\u00020\u000b2\u0006\u0010h\u001a\u00020v2\u0014\u0010¤\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0¥\u00012&\u0010¦\u0001\u001a!\u0012\u0006\u0012\u0004\u0018\u00010v\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u001d0§\u0001H&J&\u0010¨\u0001\u001a\u00030©\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0007\u0010ª\u0001\u001a\u0002022\u0007\u0010«\u0001\u001a\u00020\rH&J\u0011\u0010¬\u0001\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&Jc\u0010\u00ad\u0001\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u00072\u0011\u0010®\u0001\u001a\f\u0018\u00010¯\u0001j\u0005\u0018\u0001`°\u00012\u0007\u0010±\u0001\u001a\u00020m2\t\u0010²\u0001\u001a\u0004\u0018\u00010\r2\t\b\u0002\u0010³\u0001\u001a\u00020\r2\u000b\b\u0002\u0010´\u0001\u001a\u0004\u0018\u00010\u00122\u000b\b\u0002\u0010µ\u0001\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0003\u0010¶\u0001J\n\u0010·\u0001\u001a\u00030¸\u0001H&JQ\u0010¹\u0001\u001a\u0010\u0012\u0004\u0012\u00020m\u0012\u0005\u0012\u00030»\u00010º\u00012\n\u0010¼\u0001\u001a\u0005\u0018\u00010½\u00012\b\u0010¾\u0001\u001a\u00030¿\u00012\u0007\u0010À\u0001\u001a\u00020\r2\u000f\u0010Á\u0001\u001a\n\u0012\u0005\u0012\u00030Ã\u00010Â\u00012\b\u0010Ä\u0001\u001a\u00030Å\u0001H&J\n\u0010Æ\u0001\u001a\u00030Å\u0001H&J\n\u0010Ç\u0001\u001a\u00030È\u0001H&J9\u0010É\u0001\u001a\u00020\u001d2\u0007\u0010Ê\u0001\u001a\u00020>2\u0006\u0010L\u001a\u00020T2\b\u0010j\u001a\u0004\u0018\u00010k2\b\u0010[\u001a\u0004\u0018\u00010\\2\t\b\u0002\u0010Ë\u0001\u001a\u00020\rH&J.\u0010Ì\u0001\u001a\u00020\u001d2\u0007\u0010Ê\u0001\u001a\u00020>2\u0006\u0010L\u001a\u00020T2\b\u0010j\u001a\u0004\u0018\u00010k2\b\u0010[\u001a\u0004\u0018\u00010\\H&J\u0012\u0010Ñ\u0001\u001a\u00030Ò\u00012\u0006\u0010\u001e\u001a\u00020\u001fH&J\n\u0010Ó\u0001\u001a\u00030Ô\u0001H&J2\u0010Õ\u0001\u001a\u00020\u001d2\u0007\u0010Ö\u0001\u001a\u00020\u000b2\b\u0010r\u001a\u0004\u0018\u00010\u000b2\b\u0010s\u001a\u0004\u0018\u00010t2\n\u0010×\u0001\u001a\u0005\u0018\u00010Ø\u0001H&JL\u0010Ù\u0001\u001a\u00020\u001d2\u0007\u0010Ú\u0001\u001a\u00020\r2\t\u0010Û\u0001\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001e\u001a\u00020\u001f2\f\b\u0002\u0010Ü\u0001\u001a\u0005\u0018\u00010Ý\u00012\f\b\u0002\u0010Þ\u0001\u001a\u0005\u0018\u00010Ø\u00012\t\b\u0002\u0010\u009e\u0001\u001a\u00020\rH&J\u001a\u0010ß\u0001\u001a\u00020\u001d2\b\u0010à\u0001\u001a\u00030á\u0001H¦@¢\u0006\u0003\u0010â\u0001J\n\u0010ã\u0001\u001a\u00030ä\u0001H&J\n\u0010å\u0001\u001a\u00030æ\u0001H&J\u001a\u0010ç\u0001\u001a\u00020\u00072\u0006\u0010\u007f\u001a\u00020D2\u0007\u0010è\u0001\u001a\u00020BH&J\t\u0010é\u0001\u001a\u00020\rH&J\u0012\u0010ê\u0001\u001a\u000b\u0012\u0004\u0012\u00020\r\u0018\u00010Î\u0001H&J\t\u0010ë\u0001\u001a\u00020\rH&J(\u0010ì\u0001\u001a\u00020\u001d2\u0006\u0010q\u001a\u00020\u000b2\u0015\u0010í\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0HH&J\n\u0010î\u0001\u001a\u00030ï\u0001H&J\t\u0010ð\u0001\u001a\u00020\rH&J\u0017\u0010ñ\u0001\u001a\u0004\u0018\u00010\u000b2\n\u0010ò\u0001\u001a\u0005\u0018\u00010ó\u0001H&J\u0016\u0010ô\u0001\u001a\u0004\u0018\u00010$2\t\u0010õ\u0001\u001a\u0004\u0018\u00010$H&J\u0018\u0010ö\u0001\u001a\u0005\u0018\u00010ó\u00012\n\u0010õ\u0001\u001a\u0005\u0018\u00010ó\u0001H&J\u0015\u0010÷\u0001\u001a\u00020\r2\n\u0010ò\u0001\u001a\u0005\u0018\u00010ó\u0001H&J\u0017\u0010ø\u0001\u001a\u0004\u0018\u00010\u000b2\n\u0010ò\u0001\u001a\u0005\u0018\u00010ó\u0001H&J-\u0010ù\u0001\u001a\u0004\u0018\u00010D2\b\u0010-\u001a\u0004\u0018\u00010\u000b2\t\u0010õ\u0001\u001a\u0004\u0018\u00010D2\u000b\b\u0002\u0010ú\u0001\u001a\u0004\u0018\u00010\u000bH&J-\u0010û\u0001\u001a\u0004\u0018\u00010D2\b\u0010-\u001a\u0004\u0018\u00010\u000b2\t\u0010õ\u0001\u001a\u0004\u0018\u00010D2\u000b\b\u0002\u0010ú\u0001\u001a\u0004\u0018\u00010\u000bH&J\u0018\u0010ü\u0001\u001a\u0005\u0018\u00010ó\u00012\n\u0010õ\u0001\u001a\u0005\u0018\u00010ó\u0001H&JK\u0010ý\u0001\u001a\u00020\u000b2\u0007\u0010þ\u0001\u001a\u00020\u000b2\u0006\u0010`\u001a\u00020\u000b2\u0007\u0010\u009d\u0001\u001a\u00020\u000b2\u0007\u0010ÿ\u0001\u001a\u00020\u000b2\t\b\u0002\u0010\u009e\u0001\u001a\u00020\r2\u000b\b\u0002\u0010\u0080\u0002\u001a\u0004\u0018\u00010\u000bH¦@¢\u0006\u0003\u0010\u0081\u0002J1\u0010\u0082\u0002\u001a\u0004\u0018\u00010D2\u0006\u0010\u007f\u001a\u00020D2\b\b\u0002\u0010`\u001a\u00020\u000b2\u000b\b\u0002\u0010ú\u0001\u001a\u0004\u0018\u00010\u000bH¦@¢\u0006\u0003\u0010\u0083\u0002J\t\u0010\u0084\u0002\u001a\u00020\u001dH&J#\u0010\u0085\u0002\u001a\u00020\u001d2\u0006\u0010q\u001a\u00020\u000b2\u0007\u0010\u0086\u0002\u001a\u00020\u000b2\u0007\u0010\u0087\u0002\u001a\u00020\u000bH&J\u0012\u0010\u0088\u0002\u001a\u00020\u001d2\u0007\u0010\u0089\u0002\u001a\u00020\u000bH&J\t\u0010\u008a\u0002\u001a\u00020\u001dH&R\u0012\u0010U\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\bV\u0010WR\u0012\u0010X\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\bY\u0010WR\u001c\u0010Í\u0001\u001a\t\u0012\u0004\u0012\u0002020Î\u0001X¦\u0004¢\u0006\b\u001a\u0006\bÏ\u0001\u0010Ð\u0001¨\u0006\u008c\u0002"}, d2 = {"Lcom/larus/platform/spi/IAIChatUgcAIGCService;", "", "getInstructionUtils", "Lcom/larus/bmhome/instruction/IInstructionUtils;", "createInstructionEditorViewModel", "Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "fragment", "Landroidx/fragment/app/Fragment;", "getOriginalRatioId", "", "getActionBarLanguage", "", "isChatDoubleTabActivity", "", "activity", "Landroid/app/Activity;", "handleCreationSendUiEventResult", "bundle", "Landroid/os/Bundle;", "createAiBeautifyPickPhotoHelper", "Lcom/larus/bmhome/instruction/helper/IAiBeautifyPickPhotoHelper;", "createTemplatePrefetchHelper", "Lcom/larus/bmhome/instruction/ITemplatePrefetchHelper;", "getBachDetectMessageExtKey", "openMusicDetailApplet", "arguments", "page", "routeMode", "saveMusicCreationAndLoading", "", "context", "Landroid/content/Context;", "viewParent", "Landroid/view/ViewGroup;", "downloadTaskKey", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "currentPage", "clickFrom", "scope", "Lkotlinx/coroutines/CoroutineScope;", "sendMusicSave", "completeCallback", "Lkotlin/Function1;", "collectMusicDownLoadingStatus", "vid", "loadingAction", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setRedDotNotShow", "instructionType", "", "getActionBarRouterProcessors", "Ljava/util/ArrayList;", "Lcom/larus/bmhome/view/actionbar/custom/router/IOpenBySchemaRouterProcessor;", "Lkotlin/collections/ArrayList;", "shareVideo", "shareItemConfig", "Lcom/larus/platform/model/share/ShareItemConfig;", "shareFragment", "Landroidx/fragment/app/DialogFragment;", "messageId", "shareContainer", "Landroid/view/View;", "shareScene", "Lcom/larus/bmhome/share/ShareScene;", "eventParams", "Lcom/larus/bmhome/utils/VideoDetailEventParams;", "videoContent", "Lcom/larus/platform/model/video/VideoPlayData;", "initUrl", "reportType", "metaDataMap", "", "(Landroid/content/Context;Lcom/larus/platform/model/share/ShareItemConfig;Landroidx/fragment/app/DialogFragment;Ljava/lang/String;Landroid/view/View;Lcom/larus/bmhome/share/ShareScene;Lkotlinx/coroutines/CoroutineScope;Lcom/larus/bmhome/utils/VideoDetailEventParams;Lcom/larus/platform/model/video/VideoPlayData;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;)V", "createMixedVideoDetailFragment", "parentFragment", "data", "Lcom/larus/bmhome/creation/bean/ICreationContentData;", "initPosition", "position", "isReadonlyForwardDetail", "createChatSpeakerView", "isShowProgressLoadingMsg", "message", "Lcom/larus/im/bean/message/Message;", "globalShowShare", "getGlobalShowShare", "()Z", "globalShowDownload", "getGlobalShowDownload", "bindImageLongClickHelper", "modelProvider", "Lcom/larus/bmhome/chat/api/MessageAdapter$ModelProvider;", "imageItemInfo", "Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageItemInfo;", "parentScrollView", "scene", "extraParams", "Lorg/json/JSONObject;", "getVideoPlayerEngineManager", "Lcom/larus/bmhome/video/player/IVideoPlayerEngineManager;", "getIVideoPlayControl", "Lcom/larus/bmhome/video/view/IVideoPlayControl;", "handleImageBeautifyAction", "params", "Lcom/larus/bmhome/chat/bean/AiEditFunctionParams;", "adapter", "Lcom/larus/bmhome/chat/api/MessageAdapter;", "actionBarItem", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "imageBeautifyId", "openNewChatPage", "creationTaskId", "cvsId", "botId", SlashMentionConfig.MENTION_CONTENT_CONVERSATION, "Lcom/larus/im/bean/conversation/Conversation;", "doSend", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$OnSendParams;", "sendImageRemoveMessage", "Lkotlin/Function4;", "Ljava/io/Serializable;", "Lcom/larus/bmhome/view/actionbar/edit/creationpage/data/IInstructionHitPoint;", "showDialogFragment", "dismissCreationPage", "Lkotlin/Function0;", "handleVideoExtendAction", "videoPlayData", "msgId", "prompt", "refImageUrl", "sendRemoteVideo", "Lkotlin/ParameterName;", "name", "text", "extMap", "trackerExt", "onResult", "findMessageFromAdapter", "createSketchLoadingController", "Lcom/larus/bmhome/chat/layout/holder/progressloading/ISketchLoadingController;", "viewStub", "Landroid/view/ViewStub;", "getVideoGenerateSaver", "Lcom/larus/bmhome/video/save_share/IVideoGenerateSaver;", "bindVideoGenerateLongClickHelper", "Lcom/larus/bmhome/chat/layout/holder/video/bean/AiGenVideoContentData;", "bindSearchVideoLongClickHelper", "convertDataBean", "Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageContentData;", "convertVideoGenerateDataBean", "saveVideoAndLoading", "videoDetailEventParams", "clickMethod", "needTrace", "enableUseSRDownLoad", "customTraceParams", "subScene", "isAIGC", "dismissLoadingCallback", "uploadBeforeSendNestedFiles", "dependency", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputDependency;", "originContent", "ext", "", "originalLogic", "Lkotlin/Function3;", "createRightLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "orientation", "reverseLayout", "getInstructionEditorViewModel", "executeOnClickCustomActionBarAction", "component", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "item", "switchCheckState", "notReport", "bizArgs", "sendMsgMenuKey", "(Landroidx/fragment/app/Fragment;Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;Ljava/lang/Boolean;ZLandroid/os/Bundle;Ljava/lang/String;)V", "createInstructionBizAdapterFactory", "Lcom/larus/bmhome/instruction/biz/IInstructionBizAdapterFactory;", "createCustomActionBarAdapter", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/bmhome/view/actionbar/BaseActionBarHolder;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "callback", "Lcom/larus/bmhome/view/actionbar/custom/CustomActionBarHolderCallback;", "isImmerseStyle", "segmentFactory", "", "Lcom/larus/bmhome/view/actionbar/api/IActionBarSegment;", "actionBarShowTipCache", "Lcom/larus/bmhome/view/actionbar/custom/IActionBarShowTipCache;", "createActionBarShowTipCache", "createActionBarRedDotCacheHelper", "Lcom/larus/bmhome/view/actionbar/custom/cache/IActionBarRedDotCacheHelper;", "bindCommonLongClickListener", "targetView", "useSimpleMenuGroupCreator", "bindLyricsToSongListBoxLongClickListener", "curChatDoubleTabPageIndex", "Lkotlinx/coroutines/flow/StateFlow;", "getCurChatDoubleTabPageIndex", "()Lkotlinx/coroutines/flow/StateFlow;", "createChatTitle", "Lcom/larus/platform/api/IChatTitle;", "getLoadingResource", "Lcom/larus/bmhome/chat/layout/holder/progressloading/LoadingResource;", "reportClickReEditEvent", "reeditType", "trackNode", "Lcom/ixigua/lib/track/ITrackNode;", "downloadImg", "share", "imgUrl", "sharePanelEventParam", "Lcom/larus/bmhome/share/panel/SharePanelEventParam;", "node", "uploadImage", "param", "Lcom/larus/platform/model/upload/ResourceUploadParam;", "(Lcom/larus/platform/model/upload/ResourceUploadParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActionBarContentBuilder", "Lcom/larus/bmhome/view/actionbar/custom/IActionBarContentBuilder;", "getMediaMessageWatcher", "Lcom/larus/bmhome/chat/model/media/IMediaMessageWatcher;", "createCreationDetailPromptVideoFragment", "eventParam", "isZDisableWcb", "zLotteryGuideMsgShowFlow", "canShowZLotteryGuideMsg", "setSendMessageTrackExtMap", "sendMsgTrackMap", "getChatConversationComponent", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "isNoWatermarkEnabled", "resolveUserCreationVideoCoverResourceUri", "imageInfo", "Lcom/larus/platform/api/ImageInfo;", "selectUserCreation", "original", "resolveNoWatermarkUserCreationImageInfo", "isUserCreationImageNoWatermarkSelected", "getUserCreationNoWatermarkImageDownloadUrl", "selectVideoPlayData", "coverKey", "selectPreviewVideoPlayData", "resolvePreviewUserCreationImageInfo", "resolveFileFinalDownloadUrlIfNeeded", "url", "contentType", "resourceKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveNoWatermarkVideoPlayData", "(Lcom/larus/platform/model/video/VideoPlayData;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onMembershipStatusChanged", "setChatTraceCreationInfo", "creationId", "creationType", "logSendStart", "traceId", "tryBreakMusic", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface IAIChatUgcAIGCService {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000þ\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0096\u0001JG\u0010\u0018\u001a\u00020\r*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0001J-\u0010 \u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0001J\u001f\u0010!\u001a\u00020\r*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0001J3\u0010\"\u001a\u00020\r*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0001J\t\u0010%\u001a\u00020\u0017H\u0096\u0001J*\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u00052\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\r0)H\u0096A¢\u0006\u0002\u0010*J\u0015\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010\u0011H\u0096\u0001J\u0015\u0010.\u001a\u0004\u0018\u00010$2\b\u0010-\u001a\u0004\u0018\u00010\u0011H\u0096\u0001J\t\u0010/\u001a\u000200H\u0096\u0001J\t\u00101\u001a\u000202H\u0096\u0001J\u0011\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0096\u0001J\u0011\u00107\u001a\u00020\u000f2\u0006\u00108\u001a\u000209H\u0096\u0001J\u0011\u0010:\u001a\u00020;2\u0006\u00108\u001a\u000209H\u0096\u0001J\u0019\u0010<\u001a\u0002062\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0096\u0001JE\u0010A\u001a\u000e\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020D0B2\b\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u00172\f\u0010J\u001a\b\u0012\u0004\u0012\u00020L0K2\u0006\u0010M\u001a\u000202H\u0096\u0001J\t\u0010N\u001a\u00020OH\u0096\u0001J\u0011\u0010P\u001a\u00020Q2\u0006\u00105\u001a\u000206H\u0096\u0001J5\u0010R\u001a\u0004\u0018\u0001062\b\u0010S\u001a\u0004\u0018\u0001062\u0006\u0010\u0010\u001a\u00020T2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020V2\u0006\u0010X\u001a\u00020\u0017H\u0096\u0001J#\u0010Y\u001a\u00020Z2\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010[\u001a\u00020V2\u0006\u0010\\\u001a\u00020\u0017H\u0096\u0001J\u0013\u0010]\u001a\u00020^2\b\u0010_\u001a\u0004\u0018\u00010`H\u0096\u0001J\t\u0010a\u001a\u00020bH\u0096\u0001J?\u0010c\u001a\u00020\r2\u0006\u0010d\u001a\u00020\u00172\b\u0010e\u001a\u0004\u0018\u00010\u00052\u0006\u00108\u001a\u0002092\b\u0010f\u001a\u0004\u0018\u00010g2\b\u0010h\u001a\u0004\u0018\u00010i2\u0006\u0010j\u001a\u00020\u0017H\u0096\u0001JT\u0010k\u001a\u00020\r2\u0006\u00105\u001a\u0002062\u000e\u0010l\u001a\n\u0018\u00010mj\u0004\u0018\u0001`n2\u0006\u0010o\u001a\u00020C2\b\u0010p\u001a\u0004\u0018\u00010\u00172\u0006\u0010q\u001a\u00020\u00172\b\u0010r\u001a\u0004\u0018\u00010s2\b\u0010t\u001a\u0004\u0018\u00010\u0005H\u0096\u0001¢\u0006\u0002\u0010uJ\u001f\u0010v\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010w\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\t\u0010x\u001a\u00020yH\u0096\u0001J\t\u0010z\u001a\u00020\u0005H\u0096\u0001J\u0019\u0010{\u001a\u0012\u0012\u0004\u0012\u00020}0|j\b\u0012\u0004\u0012\u00020}`~H\u0096\u0001J\t\u0010\u007f\u001a\u00020\u0005H\u0096\u0001J\u000b\u0010\u0080\u0001\u001a\u00030\u0081\u0001H\u0096\u0001J\u0013\u0010\u0082\u0001\u001a\u00030\u0083\u00012\u0006\u00108\u001a\u000209H\u0096\u0001J\u0012\u0010\u0084\u0001\u001a\u00020Q2\u0006\u00105\u001a\u000206H\u0096\u0001J\u000b\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0096\u0001J\u000b\u0010\u0087\u0001\u001a\u00030\u0088\u0001H\u0096\u0001J\u000b\u0010\u0089\u0001\u001a\u00030\u008a\u0001H\u0096\u0001J\u000b\u0010\u008b\u0001\u001a\u00030\u008c\u0001H\u0096\u0001J\u0018\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00052\n\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u0001H\u0096\u0001J\u000b\u0010\u0090\u0001\u001a\u00030\u0091\u0001H\u0096\u0001J\u000b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0096\u0001J\u001b\u0010\u0094\u0001\u001a\u00020\u00172\u0006\u00105\u001a\u0002062\u0007\u0010\u0095\u0001\u001a\u00020sH\u0096\u0001JZ\u0010\u0096\u0001\u001a\u00020\r2\u0006\u00108\u001a\u0002092\b\u0010\u0097\u0001\u001a\u00030\u0098\u00012\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u00012\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010C2\u0007\u0010\u009c\u0001\u001a\u00020V2\u0007\u0010\u009d\u0001\u001a\u00020\u00172\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0005H\u0097\u0001Jä\u0001\u0010\u0096\u0001\u001a\u00020\r2\u0006\u00108\u001a\u0002092\b\u0010\u0097\u0001\u001a\u00030\u0098\u00012\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u00012\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010C2\u0007\u0010\u009c\u0001\u001a\u00020V2\u0007\u0010\u009d\u0001\u001a\u00020\u00172\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u00052\u0007\u0010\u009f\u0001\u001a\u00020\u00052\t\u0010 \u0001\u001a\u0004\u0018\u00010\u00052\n\u0010¡\u0001\u001a\u0005\u0018\u00010¢\u00012\u0016\u0010£\u0001\u001a\u0011\u0012\u0005\u0012\u00030¤\u0001\u0012\u0004\u0012\u00020\r\u0018\u00010)2.\u0010¥\u0001\u001a)\u0012\u0005\u0012\u00030§\u0001\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0007\u0012\u0005\u0018\u00010¨\u0001\u0012\u0004\u0012\u00020\r\u0018\u00010¦\u00012\u0018\u0010©\u0001\u001a\u0013\u0012\u0007\u0012\u0005\u0018\u00010ª\u0001\u0012\u0004\u0012\u00020\r\u0018\u00010)2\u0010\u0010«\u0001\u001a\u000b\u0012\u0004\u0012\u00020\r\u0018\u00010¬\u0001H\u0096\u0001J\u0091\u0002\u0010\u00ad\u0001\u001a\u00020\r2\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010=\u001a\u00020>2\t\u0010®\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010¯\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010°\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u00052\u0007\u0010\u009d\u0001\u001a\u00020\u00172\u008e\u0001\u0010±\u0001\u001a\u0088\u0001\u0012\u0015\u0012\u00130>¢\u0006\u000e\b²\u0001\u0012\t\b³\u0001\u0012\u0004\b\b(=\u0012\u0016\u0012\u00140\u0005¢\u0006\u000f\b²\u0001\u0012\n\b³\u0001\u0012\u0005\b\b(´\u0001\u0012%\u0012#\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010µ\u0001¢\u0006\u000f\b²\u0001\u0012\n\b³\u0001\u0012\u0005\b\b(¶\u0001\u0012%\u0012#\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010µ\u0001¢\u0006\u000f\b²\u0001\u0012\n\b³\u0001\u0012\u0005\b\b(·\u0001\u0012\u0004\u0012\u00020\r\u0018\u00010¦\u00012\u0016\u0010·\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010µ\u00012\u0015\u0010¸\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\r\u0018\u00010)H\u0096\u0001J\u0014\u0010¹\u0001\u001a\u00020\u00172\b\u0010º\u0001\u001a\u00030»\u0001H\u0096\u0001J\n\u0010¼\u0001\u001a\u00020\u0017H\u0096\u0001J\u0012\u0010½\u0001\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u0011H\u0096\u0001J\u0016\u0010¾\u0001\u001a\u00020\u00172\n\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u0001H\u0096\u0001J\n\u0010¿\u0001\u001a\u00020\u0017H\u0096\u0001J\u0013\u0010À\u0001\u001a\u00020\r2\u0007\u0010Á\u0001\u001a\u00020\u0005H\u0096\u0001J\n\u0010Â\u0001\u001a\u00020\rH\u0096\u0001J%\u0010Ã\u0001\u001a\u00020\u00172\u0007\u0010Ä\u0001\u001a\u00020s2\u0007\u0010Å\u0001\u001a\u00020\u00052\u0007\u0010Æ\u0001\u001a\u00020\u0005H\u0096\u0001J5\u0010Ç\u0001\u001a\u00020\r2\u0007\u0010È\u0001\u001a\u00020\u00052\t\u0010 \u0001\u001a\u0004\u0018\u00010\u00052\n\u0010¡\u0001\u001a\u0005\u0018\u00010¢\u00012\t\u0010É\u0001\u001a\u0004\u0018\u00010iH\u0096\u0001JF\u0010Ê\u0001\u001a\u00020\u00052\u0007\u0010Ë\u0001\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0007\u0010Ì\u0001\u001a\u00020\u00052\u0007\u0010Í\u0001\u001a\u00020\u00052\u0006\u0010j\u001a\u00020\u00172\t\u0010Î\u0001\u001a\u0004\u0018\u00010\u0005H\u0096A¢\u0006\u0003\u0010Ï\u0001J\u0019\u0010Ð\u0001\u001a\u0005\u0018\u00010\u008f\u00012\n\u0010Ñ\u0001\u001a\u0005\u0018\u00010\u008f\u0001H\u0096\u0001J-\u0010Ò\u0001\u001a\u0004\u0018\u00010>2\u0006\u0010=\u001a\u00020>2\u0006\u0010\u001d\u001a\u00020\u00052\t\u0010Ó\u0001\u001a\u0004\u0018\u00010\u0005H\u0096A¢\u0006\u0003\u0010Ô\u0001J\u0019\u0010Õ\u0001\u001a\u0005\u0018\u00010\u008f\u00012\n\u0010Ñ\u0001\u001a\u0005\u0018\u00010\u008f\u0001H\u0096\u0001J\u0018\u0010Ö\u0001\u001a\u0004\u0018\u00010\u00052\n\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u0001H\u0096\u0001Jl\u0010×\u0001\u001a\u00020\r2\b\u00108\u001a\u0004\u0018\u0001092\u0007\u0010Ø\u0001\u001a\u00020\u001c2\u0007\u0010Ù\u0001\u001a\u00020\u00052\n\u0010Ú\u0001\u001a\u0005\u0018\u00010Û\u00012\u0007\u0010Ü\u0001\u001a\u00020\u00052\u0007\u0010Ý\u0001\u001a\u00020\u00052\b\u0010\u0099\u0001\u001a\u00030\u009a\u00012\u0007\u0010Þ\u0001\u001a\u00020\u00172\u0013\u0010ß\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\r0)H\u0096\u0001J\u00ad\u0001\u0010à\u0001\u001a\u00020\r2\b\u00108\u001a\u0004\u0018\u0001092\b\u0010#\u001a\u0004\u0018\u00010>2\u0007\u0010á\u0001\u001a\u00020@2\u0007\u0010â\u0001\u001a\u00020\u00052\b\u0010\u0099\u0001\u001a\u00030\u009a\u00012\u0007\u0010ã\u0001\u001a\u00020\u00172\u0007\u0010ä\u0001\u001a\u00020\u00172\t\u0010å\u0001\u001a\u0004\u0018\u00010\u001f2\u0016\u0010æ\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010µ\u00012\t\u0010Ì\u0001\u001a\u0004\u0018\u00010\u00052\u0006\u0010j\u001a\u00020\u00172)\u0010ç\u0001\u001a$\u0012\u0004\u0012\u00020V\u0012\u0004\u0012\u00020\u0005\u0012\u0005\u0012\u00030\u008c\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\r0¦\u0001H\u0096\u0001J,\u0010è\u0001\u001a\u0004\u0018\u00010>2\b\u0010'\u001a\u0004\u0018\u00010\u00052\t\u0010Ñ\u0001\u001a\u0004\u0018\u00010>2\t\u0010Ó\u0001\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\u0019\u0010é\u0001\u001a\u0005\u0018\u00010Û\u00012\n\u0010Ñ\u0001\u001a\u0005\u0018\u00010Û\u0001H\u0096\u0001J,\u0010ê\u0001\u001a\u0004\u0018\u00010>2\b\u0010'\u001a\u0004\u0018\u00010\u00052\t\u0010Ñ\u0001\u001a\u0004\u0018\u00010>2\t\u0010Ó\u0001\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J%\u0010ë\u0001\u001a\u00020\r2\u0007\u0010\u009f\u0001\u001a\u00020\u00052\u0007\u0010ì\u0001\u001a\u00020\u00052\u0007\u0010í\u0001\u001a\u00020\u0005H\u0096\u0001J\u0013\u0010î\u0001\u001a\u00020\r2\u0007\u0010ï\u0001\u001a\u00020VH\u0096\u0001J+\u0010ð\u0001\u001a\u00020\r2\u0007\u0010\u009f\u0001\u001a\u00020\u00052\u0016\u0010ñ\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050µ\u0001H\u0096\u0001J\u0096\u0001\u0010ò\u0001\u001a\u00020\r2\b\u00108\u001a\u0004\u0018\u0001092\b\u0010ó\u0001\u001a\u00030ô\u00012\n\u0010õ\u0001\u001a\u0005\u0018\u00010ª\u00012\u0006\u0010w\u001a\u00020\u00052\u0007\u0010ö\u0001\u001a\u00020\u000f2\b\u0010÷\u0001\u001a\u00030ø\u00012\b\u0010\u0099\u0001\u001a\u00030\u009a\u00012\u0007\u0010ù\u0001\u001a\u00020@2\b\u0010#\u001a\u0004\u0018\u00010>2\t\u0010ú\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010û\u0001\u001a\u0004\u0018\u00010V2\u0016\u0010æ\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010µ\u0001H\u0096\u0001¢\u0006\u0003\u0010ü\u0001J\n\u0010ý\u0001\u001a\u00020\rH\u0096\u0001Jf\u0010þ\u0001\u001a\u00020\r2\b\u0010ÿ\u0001\u001a\u00030\u0080\u00022\u0007\u0010\u0081\u0002\u001a\u00020\u00052\b\u0010\u0097\u0001\u001a\u00030¤\u00012\u0014\u0010\u0082\u0002\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0083\u00022'\u0010\u0084\u0002\u001a\"\u0012\u0007\u0012\u0005\u0018\u00010¤\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\r0\u0085\u0002H\u0096\u0001J\u001a\u0010\u0086\u0002\u001a\u00020\r2\b\u0010\u0087\u0002\u001a\u00030\u0088\u0002H\u0096A¢\u0006\u0003\u0010\u0089\u0002J\u0013\u0010\u008a\u0002\u001a\u000b\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u008b\u0002H\u0096\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u008c\u0002\u001a\t\u0012\u0004\u0012\u00020V0\u008b\u0002X\u0096\u0005¢\u0006\b\u001a\u0006\b\u008d\u0002\u0010\u008e\u0002R\u0015\u0010\u008f\u0002\u001a\u00020\u0017X\u0096\u0005¢\u0006\b\u001a\u0006\b\u0090\u0002\u0010\u0091\u0002R\u0015\u0010\u0092\u0002\u001a\u00020\u0017X\u0096\u0005¢\u0006\b\u001a\u0006\b\u0093\u0002\u0010\u0091\u0002¨\u0006\u0094\u0002"}, d2 = {"Lcom/larus/platform/spi/IAIChatUgcAIGCService$Companion;", "Lcom/larus/platform/spi/IAIChatUgcAIGCService;", "<init>", "()V", "KEY_MUSIC_APPLET_MESSAGE_ID", "", "KEY_MUSIC_APPLET_CONVERSATION_ID", "KEY_MUSIC_APPLET_SOURCE", "KEY_MUSIC_APPLET_DATA_KEY", "KEY_MUSIC_APPLET_AUTO_OPEN_INPUT_PANEL", "MUSIC_APPLET_SOURCE_CHAT_CARD", "MUSIC_APPLET_SOURCE_ACTION_BAR_SCHEMA", "bindCommonLongClickListener", "", "targetView", "Landroid/view/View;", "data", "Lcom/larus/im/bean/message/Message;", "adapter", "Lcom/larus/bmhome/chat/api/MessageAdapter;", "modelProvider", "Lcom/larus/bmhome/chat/api/MessageAdapter$ModelProvider;", "useSimpleMenuGroupCreator", "", "bindImageLongClickHelper", "imageItemInfo", "Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageItemInfo;", "parentScrollView", "Landroid/view/ViewGroup;", "scene", "extraParams", "Lorg/json/JSONObject;", "bindLyricsToSongListBoxLongClickListener", "bindSearchVideoLongClickHelper", "bindVideoGenerateLongClickHelper", "videoContent", "Lcom/larus/bmhome/chat/layout/holder/video/bean/AiGenVideoContentData;", "canShowZLotteryGuideMsg", "collectMusicDownLoadingStatus", "vid", "loadingAction", "Lkotlin/Function1;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "convertDataBean", "Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageContentData;", "message", "convertVideoGenerateDataBean", "createActionBarRedDotCacheHelper", "Lcom/larus/bmhome/view/actionbar/custom/cache/IActionBarRedDotCacheHelper;", "createActionBarShowTipCache", "Lcom/larus/bmhome/view/actionbar/custom/IActionBarShowTipCache;", "createAiBeautifyPickPhotoHelper", "Lcom/larus/bmhome/instruction/helper/IAiBeautifyPickPhotoHelper;", "fragment", "Landroidx/fragment/app/Fragment;", "createChatSpeakerView", "context", "Landroid/content/Context;", "createChatTitle", "Lcom/larus/platform/api/IChatTitle;", "createCreationDetailPromptVideoFragment", "videoPlayData", "Lcom/larus/platform/model/video/VideoPlayData;", "eventParam", "Lcom/larus/bmhome/utils/VideoDetailEventParams;", "createCustomActionBarAdapter", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "Lcom/larus/bmhome/view/actionbar/BaseActionBarHolder;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "callback", "Lcom/larus/bmhome/view/actionbar/custom/CustomActionBarHolderCallback;", "isImmerseStyle", "segmentFactory", "", "Lcom/larus/bmhome/view/actionbar/api/IActionBarSegment;", "actionBarShowTipCache", "createInstructionBizAdapterFactory", "Lcom/larus/bmhome/instruction/biz/IInstructionBizAdapterFactory;", "createInstructionEditorViewModel", "Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "createMixedVideoDetailFragment", "parentFragment", "Lcom/larus/bmhome/creation/bean/ICreationContentData;", "initPosition", "", "position", "isReadonlyForwardDetail", "createRightLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "orientation", "reverseLayout", "createSketchLoadingController", "Lcom/larus/bmhome/chat/layout/holder/progressloading/ISketchLoadingController;", "viewStub", "Landroid/view/ViewStub;", "createTemplatePrefetchHelper", "Lcom/larus/bmhome/instruction/ITemplatePrefetchHelper;", "downloadImg", "share", "imgUrl", "sharePanelEventParam", "Lcom/larus/bmhome/share/panel/SharePanelEventParam;", "node", "Lcom/ixigua/lib/track/ITrackNode;", "isAIGC", "executeOnClickCustomActionBarAction", "component", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "item", "switchCheckState", "notReport", "bizArgs", "Landroid/os/Bundle;", "sendMsgMenuKey", "(Landroidx/fragment/app/Fragment;Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;Ljava/lang/Boolean;ZLandroid/os/Bundle;Ljava/lang/String;)V", "findMessageFromAdapter", "messageId", "getActionBarContentBuilder", "Lcom/larus/bmhome/view/actionbar/custom/IActionBarContentBuilder;", "getActionBarLanguage", "getActionBarRouterProcessors", "Ljava/util/ArrayList;", "Lcom/larus/bmhome/view/actionbar/custom/router/IOpenBySchemaRouterProcessor;", "Lkotlin/collections/ArrayList;", "getBachDetectMessageExtKey", "getChatConversationComponent", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "getIVideoPlayControl", "Lcom/larus/bmhome/video/view/IVideoPlayControl;", "getInstructionEditorViewModel", "getInstructionUtils", "Lcom/larus/bmhome/instruction/IInstructionUtils;", "getLoadingResource", "Lcom/larus/bmhome/chat/layout/holder/progressloading/LoadingResource;", "getMediaMessageWatcher", "Lcom/larus/bmhome/chat/model/media/IMediaMessageWatcher;", "getOriginalRatioId", "", "getUserCreationNoWatermarkImageDownloadUrl", "imageInfo", "Lcom/larus/platform/api/ImageInfo;", "getVideoGenerateSaver", "Lcom/larus/bmhome/video/save_share/IVideoGenerateSaver;", "getVideoPlayerEngineManager", "Lcom/larus/bmhome/video/player/IVideoPlayerEngineManager;", "handleCreationSendUiEventResult", "bundle", "handleImageBeautifyAction", "params", "Lcom/larus/bmhome/chat/bean/AiEditFunctionParams;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "actionBarItem", "imageBeautifyId", "openNewChatPage", "creationTaskId", "cvsId", "botId", SlashMentionConfig.MENTION_CONTENT_CONVERSATION, "Lcom/larus/im/bean/conversation/Conversation;", "doSend", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$OnSendParams;", "sendImageRemoveMessage", "Lkotlin/Function4;", "Ljava/io/Serializable;", "Lcom/larus/bmhome/view/actionbar/edit/creationpage/data/IInstructionHitPoint;", "showDialogFragment", "Landroidx/fragment/app/DialogFragment;", "dismissCreationPage", "Lkotlin/Function0;", "handleVideoExtendAction", "msgId", "prompt", "refImageUrl", "sendRemoteVideo", "Lkotlin/ParameterName;", "name", "text", "", "extMap", "trackerExt", "onResult", "isChatDoubleTabActivity", "activity", "Landroid/app/Activity;", "isNoWatermarkEnabled", "isShowProgressLoadingMsg", "isUserCreationImageNoWatermarkSelected", "isZDisableWcb", "logSendStart", "traceId", "onMembershipStatusChanged", "openMusicDetailApplet", "arguments", "page", "routeMode", "reportClickReEditEvent", "reeditType", "trackNode", "resolveFileFinalDownloadUrlIfNeeded", "url", "subScene", "contentType", "resourceKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveNoWatermarkUserCreationImageInfo", "original", "resolveNoWatermarkVideoPlayData", "coverKey", "(Lcom/larus/platform/model/video/VideoPlayData;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolvePreviewUserCreationImageInfo", "resolveUserCreationVideoCoverResourceUri", "saveMusicCreationAndLoading", "viewParent", "downloadTaskKey", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "currentPage", "clickFrom", "sendMusicSave", "completeCallback", "saveVideoAndLoading", "videoDetailEventParams", "clickMethod", "needTrace", "enableUseSRDownLoad", "customTraceParams", "metaDataMap", "dismissLoadingCallback", "selectPreviewVideoPlayData", "selectUserCreation", "selectVideoPlayData", "setChatTraceCreationInfo", "creationId", "creationType", "setRedDotNotShow", "instructionType", "setSendMessageTrackExtMap", "sendMsgTrackMap", "shareVideo", "shareItemConfig", "Lcom/larus/platform/model/share/ShareItemConfig;", "shareFragment", "shareContainer", "shareScene", "Lcom/larus/bmhome/share/ShareScene;", "eventParams", "initUrl", "reportType", "(Landroid/content/Context;Lcom/larus/platform/model/share/ShareItemConfig;Landroidx/fragment/app/DialogFragment;Ljava/lang/String;Landroid/view/View;Lcom/larus/bmhome/share/ShareScene;Lkotlinx/coroutines/CoroutineScope;Lcom/larus/bmhome/utils/VideoDetailEventParams;Lcom/larus/platform/model/video/VideoPlayData;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;)V", "tryBreakMusic", "uploadBeforeSendNestedFiles", "dependency", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputDependency;", "originContent", "ext", "", "originalLogic", "Lkotlin/Function3;", "uploadImage", "param", "Lcom/larus/platform/model/upload/ResourceUploadParam;", "(Lcom/larus/platform/model/upload/ResourceUploadParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "zLotteryGuideMsgShowFlow", "Lkotlinx/coroutines/flow/StateFlow;", "curChatDoubleTabPageIndex", "getCurChatDoubleTabPageIndex", "()Lkotlinx/coroutines/flow/StateFlow;", "globalShowDownload", "getGlobalShowDownload", "()Z", "globalShowShare", "getGlobalShowShare", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class Companion implements IAIChatUgcAIGCService {
        public static final /* synthetic */ Companion c = null;
        public final /* synthetic */ IAIChatUgcAIGCService b;

        static {
            c = new Companion();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void A0(int r2) {
            this.b.A0(r2);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final qs8.a B0(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return this.b.B0(r2);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void C0(View r10, Message r11, q0.a r12, df8.a r13, ViewGroup r14, String r15, JSONObject r16) {
            Intrinsics.checkNotNullParameter(r10, "<this>");
            Intrinsics.checkNotNullParameter(r11, "data");
            this.b.C0(r10, r11, r12, r13, r14, r15, r16);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final Object D(String r9, String r10, String r11, String r12, boolean r13, String r14, Continuation<? super String> r15) {
            return this.b.D(r9, r10, r11, r12, r13, r14, r15);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final g D0(String r2, g r3, String r4) {
            return this.b.D0(r2, r3, r4);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final i1<Boolean> E() {
            return this.b.E();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final boolean E0() {
            return this.b.E0();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final boolean F(Fragment r2, Bundle r3) {
            Intrinsics.checkNotNullParameter(r2, "fragment");
            Intrinsics.checkNotNullParameter(r3, "bundle");
            return this.b.F(r2, r3);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final String F0() {
            return this.b.F0();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final com.larus.bmhome.video.save_share.a G() {
            return this.b.G();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void G0(Context r13, g r14, String r15, String r16, String r17, String r18, boolean r19, Function4<? super g, ? super String, ? super Map<String, String>, ? super Map<String, String>, Unit> r20, Map<String, String> r21, Function1<? super Boolean, Unit> r22) {
            Intrinsics.checkNotNullParameter(r14, "videoPlayData");
            this.b.G0(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void H() {
            this.b.H();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final f H0(Fragment r2) {
            Intrinsics.checkNotNullParameter(r2, "fragment");
            return this.b.H0(r2);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final c I(Fragment r2) {
            Intrinsics.checkNotNullParameter(r2, "fragment");
            return this.b.I(r2);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final Object I0(j r2, Continuation<? super Unit> r3) {
            return this.b.I0(r2, r3);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final boolean J() {
            return this.b.J();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void J0(String r8, Context r9, h r10, e r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r9, "context");
            this.b.J0(r8, r9, r10, r11, r12);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final View K(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return this.b.K(r2);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final String K0() {
            return this.b.K0();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final ps8.a L() {
            return this.b.L();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final Object L0(g r2, String r3, String r4, Continuation<? super g> r5) {
            return this.b.L0(r2, r3, r4, r5);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final i M() {
            return this.b.M();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void M0(w r2, Message r3, q0.a r4) {
            Intrinsics.checkNotNullParameter(r2, "<this>");
            Intrinsics.checkNotNullParameter(r3, "data");
            this.b.M0(r2, r3, r4);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final boolean N(Bundle r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "arguments");
            Intrinsics.checkNotNullParameter(r4, "page");
            Intrinsics.checkNotNullParameter("relaunch", "routeMode");
            return this.b.N(r3, r4);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final g0 O(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return this.b.O(r2);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final ArrayList<b> P() {
            return this.b.P();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void Q(View r8, Message r9, q0 r10, q0.a r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r8, "targetView");
            Intrinsics.checkNotNullParameter(r9, "data");
            this.b.Q(r8, r9, r10, r11, r12);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final long R() {
            return this.b.R();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void S(String r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "cvsId");
            Intrinsics.checkNotNullParameter(r3, "creationId");
            Intrinsics.checkNotNullParameter(r4, "creationType");
            this.b.S(r2, r3, r4);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void T(View r8, Message r9, AiGenVideoContentData r10, q0.a r11, JSONObject r12) {
            Intrinsics.checkNotNullParameter(r8, "<this>");
            Intrinsics.checkNotNullParameter(r9, "data");
            this.b.T(r8, r9, r10, r11, r12);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final boolean U() {
            return this.b.U();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final Fragment V(g r2, c4 r3) {
            Intrinsics.checkNotNullParameter(r2, "videoPlayData");
            Intrinsics.checkNotNullParameter(r3, "eventParam");
            return this.b.V(r2, r3);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final x2 W() {
            return this.b.W();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final ComponentFeature X() {
            return this.b.X();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final ISketchLoadingController Y(ViewStub r2) {
            return this.b.Y(r2);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final String Z(ImageInfo r2) {
            return this.b.Z(r2);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void a(y8 r8, String r9, ICoreInputAbility.OnSendParams r10, Map r11, o1 r12) {
            Intrinsics.checkNotNullParameter(r8, "dependency");
            Intrinsics.checkNotNullParameter(r9, "originContent");
            Intrinsics.checkNotNullParameter(r10, "params");
            Intrinsics.checkNotNullParameter(r11, "ext");
            Intrinsics.checkNotNullParameter(r12, "originalLogic");
            this.b.a(r8, r9, r10, r11, r12);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void a0(Fragment r10, CreationEditorComponent r11, z0 r12, Boolean r13, boolean r14, Bundle r15, String r16) {
            Intrinsics.checkNotNullParameter(r10, "fragment");
            Intrinsics.checkNotNullParameter(r12, "item");
            this.b.a0(r10, r11, r12, r13, r14, r15, r16);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void b(Context r15, g r16, c4 r17, String r18, CoroutineScope r19, boolean r20, boolean r21, JSONObject r22, Map<String, String> r23, String r24, boolean r25, Function4<? super Integer, ? super String, ? super Long, ? super Boolean, Unit> r26) {
            Intrinsics.checkNotNullParameter(r17, "videoDetailEventParams");
            Intrinsics.checkNotNullParameter(r18, "clickMethod");
            Intrinsics.checkNotNullParameter(r19, "scope");
            Intrinsics.checkNotNullParameter(r26, "dismissLoadingCallback");
            this.b.b(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final yh8.a b0() {
            return this.b.b0();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void c(String r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r2, "cvsId");
            Intrinsics.checkNotNullParameter(r3, "sendMsgTrackMap");
            this.b.c(r2, r3);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void c0(Context r12, ViewGroup r13, String r14, UserCreation r15, String r16, String r17, LifecycleCoroutineScope r18, boolean r19, Function1 r20) {
            Intrinsics.checkNotNullParameter(r13, "viewParent");
            Intrinsics.checkNotNullParameter(r14, "downloadTaskKey");
            Intrinsics.checkNotNullParameter(r16, "currentPage");
            Intrinsics.checkNotNullParameter(r17, "clickFrom");
            Intrinsics.checkNotNullParameter(r18, "scope");
            Intrinsics.checkNotNullParameter(r20, "completeCallback");
            this.b.c0(r12, r13, r14, r15, r16, r17, r18, r19, r20);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void d(String r2) {
            Intrinsics.checkNotNullParameter(r2, "traceId");
            this.b.d(r2);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final ImageContentData d0(Message r2) {
            return this.b.d0(r2);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final com.larus.bmhome.instruction.j e0() {
            return this.b.e0();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final k f0() {
            return this.b.f0();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final boolean g0(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
            return this.b.g0(r2);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void h0(View r2, Message r3, q0 r4, q0.a r5) {
            Intrinsics.checkNotNullParameter(r2, "targetView");
            Intrinsics.checkNotNullParameter(r3, "data");
            this.b.h0(r2, r3, r4, r5);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void i0(Context r17, ic8.f r18, CoroutineScope r19, z0 r20, int r21, boolean r22, String r23, String r24, String r25, wc9.e r26, Function1<? super ICoreInputAbility.OnSendParams, Unit> r27, Function4<? super Serializable, ? super String, ? super String, ? super zs8.a, Unit> r28, Function1<? super DialogFragment, Unit> r29, Function0<Unit> r30) {
            Intrinsics.checkNotNullParameter(r17, "context");
            Intrinsics.checkNotNullParameter(r18, "params");
            Intrinsics.checkNotNullParameter(r24, "cvsId");
            this.b.i0(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final Object j0(String r2, com.larus.bmhome.bigimg.download.c r3, Continuation r4) {
            return this.b.j0(r2, r3, r4);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final boolean k0(ImageInfo r2) {
            return this.b.k0(r2);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final boolean l0() {
            return this.b.l0();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final ListAdapter m0(ChatParam r2, com.larus.uaigc.createpage.component.instruction.o1 r3, List r4, x2 r5) {
            Intrinsics.checkNotNullParameter(r3, "callback");
            Intrinsics.checkNotNullParameter(r4, "segmentFactory");
            Intrinsics.checkNotNullParameter(r5, "actionBarShowTipCache");
            return this.b.m0(r2, r3, r4, r5);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final i1<Integer> n0() {
            return this.b.n0();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void n4() {
            this.b.n4();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final ImageInfo o0(ImageInfo r2) {
            return this.b.o0(r2);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void p0(String r3, wc9.e r4, e r5) {
            Intrinsics.checkNotNullParameter("music", "reeditType");
            this.b.p0(r3, r4, r5);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final Fragment q0(Fragment r8, zo8.a r9, int r10, int r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r9, "data");
            return this.b.q0(r8, r9, r10, r11, r12);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final AiGenVideoContentData r0(Message r2) {
            return this.b.r0(r2);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final boolean s0(FragmentActivity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            return this.b.s0(r2);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void t0(Context r13, jr9.a r14, String r15, View r16, ShareScene r17, CoroutineScope r18, c4 r19, g r20, Integer r21, Map r22) {
            Intrinsics.checkNotNullParameter(r14, "shareItemConfig");
            Intrinsics.checkNotNullParameter(r15, "messageId");
            Intrinsics.checkNotNullParameter(r16, "shareContainer");
            Intrinsics.checkNotNullParameter(r17, "shareScene");
            Intrinsics.checkNotNullParameter(r18, "scope");
            Intrinsics.checkNotNullParameter(r19, "eventParams");
            this.b.t0(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final c u0(Fragment r2) {
            Intrinsics.checkNotNullParameter(r2, "fragment");
            return this.b.u0(r2);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final LinearLayoutManager v0(Context r2) {
            return this.b.v0(r2);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final m w0() {
            return this.b.w0();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final com.larus.bmhome.chat.layout.holder.progressloading.e x0() {
            return this.b.x0();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final boolean y0() {
            return this.b.y0();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final w2 z0() {
            return this.b.z0();
        }

        private Companion() {
            IAIChatUgcAIGCService r0 = (IAIChatUgcAIGCService) ServiceManager.get().getService(IAIChatUgcAIGCService.class);
            if (r0 != null) goto L5;
            r0 = new AIChatUgcAIGCServiceNoop();
        L5:
            this.b = r0;
        }
    }

    public static final class a {
        public static /* synthetic */ Object d(Companion r8, String r9, String r10, String r11, Continuation r12) {
            return r8.D(r9, r10, r11, "file", false, null, r12);
        }

        public static /* synthetic */ void a(Companion r8, View r9, Message r10, q0.a r11, df8.a r12, ViewGroup r13, JSONObject r14) {
            r8.C0(r9, r10, r11, r12, r13, null, r14);
        }

        public static /* synthetic */ void c(Companion r11, Context r12, g r13, String r14, String r15, String r16, String r17, boolean r18, Function4 r19, Map r20) {
            r11.G0(r12, r13, r14, r15, r16, r17, r18, r19, r20, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void e(Companion r16, Context r17, g r18, c4 r19, String r20, CoroutineScope r21, JSONObject r22, Map r23, String r24, boolean r25, Function4 r26, int r27) {
            if ((r27 & 32) == 0) goto L5;
            boolean r9 = true;
        L7:
            if ((r27 & 128) == 0) goto L9;
            JSONObject r11 = null;
        L11:
            if ((r27 & 256) == 0) goto L13;
            Map r12 = null;
        L15:
            if ((r27 & 512) == 0) goto L17;
            String r13 = null;
        L19:
            if ((r27 & 1024) == 0) goto L21;
            boolean r14 = false;
        L22:
            r16.b(r17, r18, r19, r20, r21, r9, false, r11, r12, r13, r14, r26);
            return;
        L21:
            r14 = r25;
            goto L22
        L17:
            r13 = r24;
            goto L19
        L13:
            r12 = r23;
            goto L15
        L9:
            r11 = r22;
            goto L11
        L5:
            r9 = false;
            goto L7
        }

        public static /* synthetic */ void b(Companion r15, Context r16, ic8.f r17, CoroutineScope r18, z0 r19, int r20, boolean r21, String r22, String r23, wc9.e r24, Function1 r25, Function4 r26, Function1 r27, Function0 r28) {
            r15.i0(r16, r17, r18, r19, r20, r21, null, r22, r23, r24, r25, r26, r27, r28);
        }
    }

    static {
        a = Companion.c;
    }

    void A0(int r1);

    qs8.a B0(Context r1);

    void C0(View r1, Message r2, q0.a r3, df8.a r4, ViewGroup r5, String r6, JSONObject r7);

    Object D(String r1, String r2, String r3, String r4, boolean r5, String r6, Continuation<? super String> r7);

    g D0(String r1, g r2, String r3);

    i1<Boolean> E();

    boolean E0();

    boolean F(Fragment r1, Bundle r2);

    String F0();

    com.larus.bmhome.video.save_share.a G();

    void G0(Context r1, g r2, String r3, String r4, String r5, String r6, boolean r7, Function4<? super g, ? super String, ? super Map<String, String>, ? super Map<String, String>, Unit> r8, Map<String, String> r9, Function1<? super Boolean, Unit> r10);

    void H();

    f H0(Fragment r1);

    c I(Fragment r1);

    Object I0(j r1, Continuation<? super Unit> r2);

    boolean J();

    void J0(String r1, Context r2, h r3, e r4, boolean r5);

    View K(Context r1);

    String K0();

    ps8.a L();

    Object L0(g r1, String r2, String r3, Continuation<? super g> r4);

    i M();

    void M0(w r1, Message r2, q0.a r3);

    boolean N(Bundle r1, String r2);

    g0 O(Context r1);

    ArrayList<b> P();

    void Q(View r1, Message r2, q0 r3, q0.a r4, boolean r5);

    long R();

    void S(String r1, String r2, String r3);

    void T(View r1, Message r2, AiGenVideoContentData r3, q0.a r4, JSONObject r5);

    boolean U();

    Fragment V(g r1, c4 r2);

    x2 W();

    ComponentFeature X();

    ISketchLoadingController Y(ViewStub r1);

    String Z(ImageInfo r1);

    void a(y8 r1, String r2, ICoreInputAbility.OnSendParams r3, Map r4, o1 r5);

    void a0(Fragment r1, CreationEditorComponent r2, z0 r3, Boolean r4, boolean r5, Bundle r6, String r7);

    void b(Context r1, g r2, c4 r3, String r4, CoroutineScope r5, boolean r6, boolean r7, JSONObject r8, Map<String, String> r9, String r10, boolean r11, Function4<? super Integer, ? super String, ? super Long, ? super Boolean, Unit> r12);

    yh8.a b0();

    void c(String r1, Map<String, String> r2);

    void c0(Context r1, ViewGroup r2, String r3, UserCreation r4, String r5, String r6, LifecycleCoroutineScope r7, boolean r8, Function1 r9);

    void d(String r1);

    ImageContentData d0(Message r1);

    com.larus.bmhome.instruction.j e0();

    k f0();

    boolean g0(Message r1);

    void h0(View r1, Message r2, q0 r3, q0.a r4);

    void i0(Context r1, ic8.f r2, CoroutineScope r3, z0 r4, int r5, boolean r6, String r7, String r8, String r9, wc9.e r10, Function1<? super ICoreInputAbility.OnSendParams, Unit> r11, Function4<? super Serializable, ? super String, ? super String, ? super zs8.a, Unit> r12, Function1<? super DialogFragment, Unit> r13, Function0<Unit> r14);

    Object j0(String r1, com.larus.bmhome.bigimg.download.c r2, Continuation r3);

    boolean k0(ImageInfo r1);

    boolean l0();

    ListAdapter m0(ChatParam r1, com.larus.uaigc.createpage.component.instruction.o1 r2, List r3, x2 r4);

    i1<Integer> n0();

    void n4();

    ImageInfo o0(ImageInfo r1);

    void p0(String r1, wc9.e r2, e r3);

    Fragment q0(Fragment r1, zo8.a r2, int r3, int r4, boolean r5);

    AiGenVideoContentData r0(Message r1);

    boolean s0(FragmentActivity r1);

    void t0(Context r1, jr9.a r2, String r3, View r4, ShareScene r5, CoroutineScope r6, c4 r7, g r8, Integer r9, Map r10);

    c u0(Fragment r1);

    LinearLayoutManager v0(Context r1);

    m w0();

    com.larus.bmhome.chat.layout.holder.progressloading.e x0();

    boolean y0();

    w2 z0();
}
