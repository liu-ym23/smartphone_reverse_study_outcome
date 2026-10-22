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
import com.larus.bmhome.chat.component.bottom.core.y8;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageContentData;
import com.larus.bmhome.chat.layout.holder.progressloading.ISketchLoadingController;
import com.larus.bmhome.chat.layout.holder.video.bean.AiGenVideoContentData;
import com.larus.bmhome.instruction.j;
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
import com.larus.uaigc.createpage.component.instruction.o1;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.tencent.open.log.TraceLevel;
import df8.a;
import fn8.w;
import ic8.f;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import nr9.g;
import org.json.JSONObject;
import sr9.b0;
import sr9.c0;
import sr9.d0;
import sr9.l;
import sr9.m;
import sr9.p;
import sr9.q;
import sr9.r;
import sr9.x;
import sr9.y;
import vp8.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0080\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u0018H\u0016J \u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u0018H\u0016J`\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00182\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00052\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020)07H\u0016J*\u00108\u001a\u00020)2\u0006\u00109\u001a\u00020\u00182\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020)07H\u0096@¢\u0006\u0002\u0010;J\u0010\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u00020\fH\u0016J\u0018\u0010>\u001a\u0012\u0012\u0004\u0012\u00020@0?j\b\u0012\u0004\u0012\u00020@`AH\u0016J\u0085\u0001\u0010B\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010G\u001a\u00020\u00182\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u00103\u001a\u0002042\u0006\u0010L\u001a\u00020M2\b\u0010N\u001a\u0004\u0018\u00010O2\b\u0010P\u001a\u0004\u0018\u00010\u00182\b\u0010Q\u001a\u0004\u0018\u00010\f2\u0014\u0010R\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010SH\u0016¢\u0006\u0002\u0010TJ4\u0010U\u001a\u0004\u0018\u00010\u00142\b\u0010V\u001a\u0004\u0018\u00010\u00142\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\f2\u0006\u0010Z\u001a\u00020\f2\u0006\u0010[\u001a\u00020\u0005H\u0016J\u0010\u0010\\\u001a\u00020I2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010]\u001a\u00020\u00052\u0006\u0010^\u001a\u00020_H\u0016JF\u0010`\u001a\u00020)*\u00020I2\u0006\u0010W\u001a\u00020_2\b\u0010a\u001a\u0004\u0018\u00010b2\b\u0010c\u001a\u0004\u0018\u00010d2\b\u0010e\u001a\u0004\u0018\u00010-2\b\u0010f\u001a\u0004\u0018\u00010\u00182\b\u0010g\u001a\u0004\u0018\u00010hH\u0016J\b\u0010i\u001a\u00020jH\u0016J\u0010\u0010k\u001a\u00020l2\u0006\u0010*\u001a\u00020+H\u0016JP\u0010m\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010n\u001a\u00020o2\b\u0010p\u001a\u0004\u0018\u00010q2\b\u00103\u001a\u0004\u0018\u0001042\b\u0010r\u001a\u0004\u0018\u00010s2\u0006\u0010t\u001a\u00020\f2\u0006\u0010u\u001a\u00020\u00052\b\u0010v\u001a\u0004\u0018\u00010\u0018H\u0016JÐ\u0001\u0010m\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010n\u001a\u00020o2\b\u00103\u001a\u0004\u0018\u0001042\b\u0010r\u001a\u0004\u0018\u00010s2\u0006\u0010t\u001a\u00020\f2\u0006\u0010u\u001a\u00020\u00052\b\u0010v\u001a\u0004\u0018\u00010\u00182\u0006\u0010w\u001a\u00020\u00182\b\u0010x\u001a\u0004\u0018\u00010\u00182\b\u0010y\u001a\u0004\u0018\u00010z2\u0014\u0010{\u001a\u0010\u0012\u0004\u0012\u00020|\u0012\u0004\u0012\u00020)\u0018\u0001072+\u0010}\u001a'\u0012\u0004\u0012\u00020\u007f\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0007\u0012\u0005\u0018\u00010\u0080\u0001\u0012\u0004\u0012\u00020)\u0018\u00010~2\u0017\u0010\u0081\u0001\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010F\u0012\u0004\u0012\u00020)\u0018\u0001072\u0010\u0010\u0082\u0001\u001a\u000b\u0012\u0004\u0012\u00020)\u0018\u00010\u0083\u0001H\u0016J\u008c\u0002\u0010\u0084\u0001\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\u0007\u0010\u0085\u0001\u001a\u00020O2\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00182\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00182\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00182\b\u0010v\u001a\u0004\u0018\u00010\u00182\u0006\u0010u\u001a\u00020\u00052\u008c\u0001\u0010\u0089\u0001\u001a\u0086\u0001\u0012\u0016\u0012\u00140O¢\u0006\u000f\b\u008a\u0001\u0012\n\b\u008b\u0001\u0012\u0005\b\b(\u0085\u0001\u0012\u0016\u0012\u00140\u0018¢\u0006\u000f\b\u008a\u0001\u0012\n\b\u008b\u0001\u0012\u0005\b\b(\u008c\u0001\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010S¢\u0006\u000f\b\u008a\u0001\u0012\n\b\u008b\u0001\u0012\u0005\b\b(\u008d\u0001\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010S¢\u0006\u000f\b\u008a\u0001\u0012\n\b\u008b\u0001\u0012\u0005\b\b(\u008e\u0001\u0012\u0004\u0012\u00020)\u0018\u00010~2\u0015\u0010\u008e\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010S2\u0015\u0010\u008f\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020)\u0018\u000107H\u0016J\u001f\u0010\u0090\u0001\u001a\u0004\u0018\u00010_2\b\u0010p\u001a\u0004\u0018\u00010q2\b\u0010G\u001a\u0004\u0018\u00010\u0018H\u0016J\u0016\u0010\u0091\u0001\u001a\u00030\u0092\u00012\n\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0094\u0001H\u0016J\n\u0010\u0095\u0001\u001a\u00030\u0096\u0001H\u0016J4\u0010\u0097\u0001\u001a\u00020)*\u00020I2\u0006\u0010W\u001a\u00020_2\t\u0010N\u001a\u0005\u0018\u00010\u0098\u00012\b\u0010a\u001a\u0004\u0018\u00010b2\b\u0010g\u001a\u0004\u0018\u00010hH\u0016J\u001f\u0010\u0099\u0001\u001a\u00020)*\u00020I2\u0006\u0010W\u001a\u00020_2\b\u0010a\u001a\u0004\u0018\u00010bH\u0016J\u0016\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u009b\u00012\b\u0010^\u001a\u0004\u0018\u00010_H\u0016J\u0016\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u0098\u00012\b\u0010^\u001a\u0004\u0018\u00010_H\u0016J§\u0001\u0010\u009d\u0001\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010N\u001a\u0004\u0018\u00010O2\u0007\u0010\u009e\u0001\u001a\u00020M2\u0007\u0010\u009f\u0001\u001a\u00020\u00182\u0006\u00103\u001a\u0002042\u0007\u0010 \u0001\u001a\u00020\u00052\u0007\u0010¡\u0001\u001a\u00020\u00052\t\u0010¢\u0001\u001a\u0004\u0018\u00010h2\u0014\u0010R\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010S2\t\u0010£\u0001\u001a\u0004\u0018\u00010\u00182\u0007\u0010¤\u0001\u001a\u00020\u00052'\u0010¥\u0001\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020)0~H\u0016Jb\u0010¦\u0001\u001a\u00020)2\b\u0010§\u0001\u001a\u00030¨\u00012\u0007\u0010©\u0001\u001a\u00020\u00182\u0006\u0010n\u001a\u00020|2\u0014\u0010ª\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180«\u00012&\u0010¬\u0001\u001a!\u0012\u0006\u0012\u0004\u0018\u00010|\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020)0\u00ad\u0001H\u0016J&\u0010®\u0001\u001a\u00030¯\u00012\b\u0010*\u001a\u0004\u0018\u00010+2\u0007\u0010°\u0001\u001a\u00020\f2\u0007\u0010±\u0001\u001a\u00020\u0005H\u0016J\u0011\u0010²\u0001\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J]\u0010³\u0001\u001a\u00020)2\u0006\u0010\u0013\u001a\u00020\u00142\u0011\u0010´\u0001\u001a\f\u0018\u00010µ\u0001j\u0005\u0018\u0001`¶\u00012\u0007\u0010·\u0001\u001a\u00020s2\t\u0010¸\u0001\u001a\u0004\u0018\u00010\u00052\u0007\u0010¹\u0001\u001a\u00020\u00052\t\u0010º\u0001\u001a\u0004\u0018\u00010\u001e2\t\u0010»\u0001\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0003\u0010¼\u0001J\n\u0010½\u0001\u001a\u00030¾\u0001H\u0016JQ\u0010¿\u0001\u001a\u0010\u0012\u0004\u0012\u00020s\u0012\u0005\u0012\u00030Á\u00010À\u00012\n\u0010Â\u0001\u001a\u0005\u0018\u00010Ã\u00012\b\u0010Ä\u0001\u001a\u00030Å\u00012\u0007\u0010Æ\u0001\u001a\u00020\u00052\u000f\u0010Ç\u0001\u001a\n\u0012\u0005\u0012\u00030É\u00010È\u00012\b\u0010Ê\u0001\u001a\u00030Ë\u0001H\u0016J\n\u0010Ì\u0001\u001a\u00030Ë\u0001H\u0016J\n\u0010Í\u0001\u001a\u00030Î\u0001H\u0016J7\u0010Ï\u0001\u001a\u00020)2\u0007\u0010Ð\u0001\u001a\u00020I2\u0006\u0010W\u001a\u00020_2\b\u0010p\u001a\u0004\u0018\u00010q2\b\u0010a\u001a\u0004\u0018\u00010b2\u0007\u0010Ñ\u0001\u001a\u00020\u0005H\u0016J.\u0010Ò\u0001\u001a\u00020)2\u0007\u0010Ð\u0001\u001a\u00020I2\u0006\u0010W\u001a\u00020_2\b\u0010p\u001a\u0004\u0018\u00010q2\b\u0010a\u001a\u0004\u0018\u00010bH\u0016J\u0012\u0010Ó\u0001\u001a\u00030Ô\u00012\u0006\u0010*\u001a\u00020+H\u0016J\n\u0010Õ\u0001\u001a\u00030Ö\u0001H\u0016J2\u0010×\u0001\u001a\u00020)2\u0007\u0010Ø\u0001\u001a\u00020\u00182\b\u0010x\u001a\u0004\u0018\u00010\u00182\b\u0010y\u001a\u0004\u0018\u00010z2\n\u0010Ù\u0001\u001a\u0005\u0018\u00010Ú\u0001H\u0016JF\u0010Û\u0001\u001a\u00020)2\u0007\u0010Ü\u0001\u001a\u00020\u00052\t\u0010Ý\u0001\u001a\u0004\u0018\u00010\u00182\u0006\u0010*\u001a\u00020+2\n\u0010Þ\u0001\u001a\u0005\u0018\u00010ß\u00012\n\u0010à\u0001\u001a\u0005\u0018\u00010Ú\u00012\u0007\u0010¤\u0001\u001a\u00020\u0005H\u0016J\u001a\u0010á\u0001\u001a\u00020)2\b\u0010â\u0001\u001a\u00030ã\u0001H\u0096@¢\u0006\u0003\u0010ä\u0001J\n\u0010å\u0001\u001a\u00030æ\u0001H\u0016J\n\u0010ç\u0001\u001a\u00030è\u0001H\u0016J\u001b\u0010é\u0001\u001a\u00020\u00142\u0007\u0010\u0085\u0001\u001a\u00020O2\u0007\u0010ê\u0001\u001a\u00020MH\u0016J\t\u0010ë\u0001\u001a\u00020\u0005H\u0016J\u0011\u0010ì\u0001\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bH\u0016J\t\u0010í\u0001\u001a\u00020\u0005H\u0016J(\u0010î\u0001\u001a\u00020)2\u0006\u0010w\u001a\u00020\u00182\u0015\u0010ï\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00180SH\u0016J\n\u0010ð\u0001\u001a\u00030ñ\u0001H\u0016JG\u0010ò\u0001\u001a\u00020\u00182\u0007\u0010ó\u0001\u001a\u00020\u00182\u0006\u0010f\u001a\u00020\u00182\u0007\u0010£\u0001\u001a\u00020\u00182\u0007\u0010ô\u0001\u001a\u00020\u00182\u0007\u0010¤\u0001\u001a\u00020\u00052\t\u0010õ\u0001\u001a\u0004\u0018\u00010\u0018H\u0096@¢\u0006\u0003\u0010ö\u0001J\t\u0010÷\u0001\u001a\u00020\u0005H\u0016J\u0017\u0010ø\u0001\u001a\u0004\u0018\u00010\u00182\n\u0010ù\u0001\u001a\u0005\u0018\u00010ú\u0001H\u0016J\u0016\u0010û\u0001\u001a\u0004\u0018\u0001002\t\u0010ü\u0001\u001a\u0004\u0018\u000100H\u0016J\u0018\u0010ý\u0001\u001a\u0005\u0018\u00010ú\u00012\n\u0010ü\u0001\u001a\u0005\u0018\u00010ú\u0001H\u0016J\u0015\u0010þ\u0001\u001a\u00020\u00052\n\u0010ù\u0001\u001a\u0005\u0018\u00010ú\u0001H\u0016J\u0017\u0010ÿ\u0001\u001a\u0004\u0018\u00010\u00182\n\u0010ù\u0001\u001a\u0005\u0018\u00010ú\u0001H\u0016J+\u0010\u0080\u0002\u001a\u0004\u0018\u00010O2\b\u00109\u001a\u0004\u0018\u00010\u00182\t\u0010ü\u0001\u001a\u0004\u0018\u00010O2\t\u0010\u0081\u0002\u001a\u0004\u0018\u00010\u0018H\u0016J+\u0010\u0082\u0002\u001a\u0004\u0018\u00010O2\b\u00109\u001a\u0004\u0018\u00010\u00182\t\u0010ü\u0001\u001a\u0004\u0018\u00010O2\t\u0010\u0081\u0002\u001a\u0004\u0018\u00010\u0018H\u0016J\u0018\u0010\u0083\u0002\u001a\u0005\u0018\u00010ú\u00012\n\u0010ü\u0001\u001a\u0005\u0018\u00010ú\u0001H\u0016J.\u0010\u0084\u0002\u001a\u0004\u0018\u00010O2\u0007\u0010\u0085\u0001\u001a\u00020O2\u0006\u0010f\u001a\u00020\u00182\t\u0010\u0081\u0002\u001a\u0004\u0018\u00010\u0018H\u0096@¢\u0006\u0003\u0010\u0085\u0002J\t\u0010\u0086\u0002\u001a\u00020)H\u0016J#\u0010\u0087\u0002\u001a\u00020)2\u0006\u0010w\u001a\u00020\u00182\u0007\u0010\u0088\u0002\u001a\u00020\u00182\u0007\u0010\u0089\u0002\u001a\u00020\u0018H\u0016J\u0012\u0010\u008a\u0002\u001a\u00020)2\u0007\u0010\u008b\u0002\u001a\u00020\u0018H\u0016J\t\u0010\u008c\u0002\u001a\u00020)H\u0016J\u0017\u0010\u008d\u0002\u001a\u0003H\u008e\u0002\"\u0005\b\u0000\u0010\u008e\u0002H\u0002¢\u0006\u0003\u0010\u008f\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0090\u0002"}, d2 = {"Lcom/larus/platform/spi/AIChatUgcAIGCServiceNoop;", "Lcom/larus/platform/spi/IAIChatUgcAIGCService;", "<init>", "()V", "globalShowShare", "", "getGlobalShowShare", "()Z", "globalShowDownload", "getGlobalShowDownload", "curChatDoubleTabPageIndex", "Lkotlinx/coroutines/flow/StateFlow;", "", "getCurChatDoubleTabPageIndex", "()Lkotlinx/coroutines/flow/StateFlow;", "getInstructionUtils", "Lcom/larus/bmhome/instruction/IInstructionUtils;", "createInstructionEditorViewModel", "Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "fragment", "Landroidx/fragment/app/Fragment;", "getOriginalRatioId", "", "getActionBarLanguage", "", "isChatDoubleTabActivity", "activity", "Landroid/app/Activity;", "handleCreationSendUiEventResult", "bundle", "Landroid/os/Bundle;", "createAiBeautifyPickPhotoHelper", "Lcom/larus/bmhome/instruction/helper/IAiBeautifyPickPhotoHelper;", "createTemplatePrefetchHelper", "Lcom/larus/bmhome/instruction/ITemplatePrefetchHelper;", "getBachDetectMessageExtKey", "openMusicDetailApplet", "arguments", "page", "routeMode", "saveMusicCreationAndLoading", "", "context", "Landroid/content/Context;", "viewParent", "Landroid/view/ViewGroup;", "downloadTaskKey", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "currentPage", "clickFrom", "scope", "Lkotlinx/coroutines/CoroutineScope;", "sendMusicSave", "completeCallback", "Lkotlin/Function1;", "collectMusicDownLoadingStatus", "vid", "loadingAction", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setRedDotNotShow", "instructionType", "getActionBarRouterProcessors", "Ljava/util/ArrayList;", "Lcom/larus/bmhome/view/actionbar/custom/router/IOpenBySchemaRouterProcessor;", "Lkotlin/collections/ArrayList;", "shareVideo", "shareItemConfig", "Lcom/larus/platform/model/share/ShareItemConfig;", "shareFragment", "Landroidx/fragment/app/DialogFragment;", "messageId", "shareContainer", "Landroid/view/View;", "shareScene", "Lcom/larus/bmhome/share/ShareScene;", "eventParams", "Lcom/larus/bmhome/utils/VideoDetailEventParams;", "videoContent", "Lcom/larus/platform/model/video/VideoPlayData;", "initUrl", "reportType", "metaDataMap", "", "(Landroid/content/Context;Lcom/larus/platform/model/share/ShareItemConfig;Landroidx/fragment/app/DialogFragment;Ljava/lang/String;Landroid/view/View;Lcom/larus/bmhome/share/ShareScene;Lkotlinx/coroutines/CoroutineScope;Lcom/larus/bmhome/utils/VideoDetailEventParams;Lcom/larus/platform/model/video/VideoPlayData;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;)V", "createMixedVideoDetailFragment", "parentFragment", "data", "Lcom/larus/bmhome/creation/bean/ICreationContentData;", "initPosition", "position", "isReadonlyForwardDetail", "createChatSpeakerView", "isShowProgressLoadingMsg", "message", "Lcom/larus/im/bean/message/Message;", "bindImageLongClickHelper", "modelProvider", "Lcom/larus/bmhome/chat/api/MessageAdapter$ModelProvider;", "imageItemInfo", "Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageItemInfo;", "parentScrollView", "scene", "extraParams", "Lorg/json/JSONObject;", "getVideoPlayerEngineManager", "Lcom/larus/bmhome/video/player/IVideoPlayerEngineManager;", "getIVideoPlayControl", "Lcom/larus/bmhome/video/view/IVideoPlayControl;", "handleImageBeautifyAction", "params", "Lcom/larus/bmhome/chat/bean/AiEditFunctionParams;", "adapter", "Lcom/larus/bmhome/chat/api/MessageAdapter;", "actionBarItem", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "imageBeautifyId", "openNewChatPage", "creationTaskId", "cvsId", "botId", SlashMentionConfig.MENTION_CONTENT_CONVERSATION, "Lcom/larus/im/bean/conversation/Conversation;", "doSend", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$OnSendParams;", "sendImageRemoveMessage", "Lkotlin/Function4;", "Ljava/io/Serializable;", "Lcom/larus/bmhome/view/actionbar/edit/creationpage/data/IInstructionHitPoint;", "showDialogFragment", "dismissCreationPage", "Lkotlin/Function0;", "handleVideoExtendAction", "videoPlayData", "msgId", "prompt", "refImageUrl", "sendRemoteVideo", "Lkotlin/ParameterName;", "name", "text", "extMap", "trackerExt", "onResult", "findMessageFromAdapter", "createSketchLoadingController", "Lcom/larus/bmhome/chat/layout/holder/progressloading/ISketchLoadingController;", "viewStub", "Landroid/view/ViewStub;", "getVideoGenerateSaver", "Lcom/larus/bmhome/video/save_share/IVideoGenerateSaver;", "bindVideoGenerateLongClickHelper", "Lcom/larus/bmhome/chat/layout/holder/video/bean/AiGenVideoContentData;", "bindSearchVideoLongClickHelper", "convertDataBean", "Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageContentData;", "convertVideoGenerateDataBean", "saveVideoAndLoading", "videoDetailEventParams", "clickMethod", "needTrace", "enableUseSRDownLoad", "customTraceParams", "subScene", "isAIGC", "dismissLoadingCallback", "uploadBeforeSendNestedFiles", "dependency", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputDependency;", "originContent", "ext", "", "originalLogic", "Lkotlin/Function3;", "createRightLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "orientation", "reverseLayout", "getInstructionEditorViewModel", "executeOnClickCustomActionBarAction", "component", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "item", "switchCheckState", "notReport", "bizArgs", "sendMsgMenuKey", "(Landroidx/fragment/app/Fragment;Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;Ljava/lang/Boolean;ZLandroid/os/Bundle;Ljava/lang/String;)V", "createInstructionBizAdapterFactory", "Lcom/larus/bmhome/instruction/biz/IInstructionBizAdapterFactory;", "createCustomActionBarAdapter", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/bmhome/view/actionbar/BaseActionBarHolder;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "callback", "Lcom/larus/bmhome/view/actionbar/custom/CustomActionBarHolderCallback;", "isImmerseStyle", "segmentFactory", "", "Lcom/larus/bmhome/view/actionbar/api/IActionBarSegment;", "actionBarShowTipCache", "Lcom/larus/bmhome/view/actionbar/custom/IActionBarShowTipCache;", "createActionBarShowTipCache", "createActionBarRedDotCacheHelper", "Lcom/larus/bmhome/view/actionbar/custom/cache/IActionBarRedDotCacheHelper;", "bindCommonLongClickListener", "targetView", "useSimpleMenuGroupCreator", "bindLyricsToSongListBoxLongClickListener", "createChatTitle", "Lcom/larus/platform/api/IChatTitle;", "getLoadingResource", "Lcom/larus/bmhome/chat/layout/holder/progressloading/LoadingResource;", "reportClickReEditEvent", "reeditType", "trackNode", "Lcom/ixigua/lib/track/ITrackNode;", "downloadImg", "share", "imgUrl", "sharePanelEventParam", "Lcom/larus/bmhome/share/panel/SharePanelEventParam;", "node", "uploadImage", "param", "Lcom/larus/platform/model/upload/ResourceUploadParam;", "(Lcom/larus/platform/model/upload/ResourceUploadParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActionBarContentBuilder", "Lcom/larus/bmhome/view/actionbar/custom/IActionBarContentBuilder;", "getMediaMessageWatcher", "Lcom/larus/bmhome/chat/model/media/IMediaMessageWatcher;", "createCreationDetailPromptVideoFragment", "eventParam", "isZDisableWcb", "zLotteryGuideMsgShowFlow", "canShowZLotteryGuideMsg", "setSendMessageTrackExtMap", "sendMsgTrackMap", "getChatConversationComponent", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "resolveFileFinalDownloadUrlIfNeeded", "url", "contentType", "resourceKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isNoWatermarkEnabled", "resolveUserCreationVideoCoverResourceUri", "imageInfo", "Lcom/larus/platform/api/ImageInfo;", "selectUserCreation", "original", "resolveNoWatermarkUserCreationImageInfo", "isUserCreationImageNoWatermarkSelected", "getUserCreationNoWatermarkImageDownloadUrl", "selectVideoPlayData", "coverKey", "selectPreviewVideoPlayData", "resolvePreviewUserCreationImageInfo", "resolveNoWatermarkVideoPlayData", "(Lcom/larus/platform/model/video/VideoPlayData;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onMembershipStatusChanged", "setChatTraceCreationInfo", "creationId", "creationType", "logSendStart", "traceId", "tryBreakMusic", "unsupportedCreationDependency", "T", "()Ljava/lang/Object;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class AIChatUgcAIGCServiceNoop implements IAIChatUgcAIGCService {
    public final StateFlowImpl b;

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final void A0(int r1) {
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final void C0(View r1, Message r2, q0.a r3, a r4, ViewGroup r5, String r6, JSONObject r7) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "data");
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final Object D(String r1, String r2, String r3, String r4, boolean r5, String r6, Continuation<? super String> r7) {
        return r1;
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final g D0(String r1, g r2, String r3) {
        return r2;
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final i1<Boolean> E() {
        return null;
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final boolean E0() {
        return false;
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final boolean F(Fragment r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "bundle");
        return false;
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final String F0() {
        return "";
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final void H() {
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final boolean J() {
        return false;
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final void J0(String r1, Context r2, h r3, e r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final String K0() {
        return "";
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final Object L0(g r1, String r2, String r3, Continuation<? super g> r4) {
        return r1;
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final void M0(w r1, Message r2, q0.a r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "data");
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final boolean N(Bundle r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "arguments");
        Intrinsics.checkNotNullParameter(r3, "page");
        Intrinsics.checkNotNullParameter("relaunch", "routeMode");
        return false;
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final void Q(View r1, Message r2, q0 r3, q0.a r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r1, "targetView");
        Intrinsics.checkNotNullParameter(r2, "data");
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final long R() {
        return 0;
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final void S(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "cvsId");
        Intrinsics.checkNotNullParameter(r3, "creationId");
        Intrinsics.checkNotNullParameter(r4, "creationType");
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final void T(View r1, Message r2, AiGenVideoContentData r3, q0.a r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "data");
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final boolean U() {
        return false;
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final String Z(ImageInfo r1) {
        return null;
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final void a0(Fragment r1, CreationEditorComponent r2, z0 r3, Boolean r4, boolean r5, Bundle r6, String r7) {
        Intrinsics.checkNotNullParameter(r1, "fragment");
        Intrinsics.checkNotNullParameter(r3, "item");
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final void c(String r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "cvsId");
        Intrinsics.checkNotNullParameter(r3, "sendMsgTrackMap");
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final void d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "traceId");
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final ImageContentData d0(Message r1) {
        return null;
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final boolean g0(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        return false;
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final void h0(View r1, Message r2, q0 r3, q0.a r4) {
        Intrinsics.checkNotNullParameter(r1, "targetView");
        Intrinsics.checkNotNullParameter(r2, "data");
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final void i0(Context r1, f r2, CoroutineScope r3, z0 r4, int r5, boolean r6, String r7, String r8, String r9, wc9.e r10, Function1<? super ICoreInputAbility.OnSendParams, Unit> r11, Function4<? super Serializable, ? super String, ? super String, ? super zs8.a, Unit> r12, Function1<? super DialogFragment, Unit> r13, Function0<Unit> r14) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r8, "cvsId");
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final boolean k0(ImageInfo r1) {
        return false;
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final boolean l0() {
        return false;
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final void n4() {
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final ImageInfo o0(ImageInfo r1) {
        return r1;
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final void p0(String r1, wc9.e r2, e r3) {
        Intrinsics.checkNotNullParameter("music", "reeditType");
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final Fragment q0(Fragment r1, zo8.a r2, int r3, int r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return null;
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final AiGenVideoContentData r0(Message r1) {
        return null;
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final boolean s0(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        return false;
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final void t0(Context r1, jr9.a r2, String r3, View r4, ShareScene r5, CoroutineScope r6, c4 r7, g r8, Integer r9, Map r10) {
        Intrinsics.checkNotNullParameter(r2, "shareItemConfig");
        Intrinsics.checkNotNullParameter(r3, "messageId");
        Intrinsics.checkNotNullParameter(r4, "shareContainer");
        Intrinsics.checkNotNullParameter(r5, "shareScene");
        Intrinsics.checkNotNullParameter(r6, "scope");
        Intrinsics.checkNotNullParameter(r7, "eventParams");
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final boolean y0() {
        return false;
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final ArrayList<b> P() {
        return new ArrayList();
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final com.larus.bmhome.chat.layout.holder.progressloading.e x0() {
        return new com.larus.bmhome.chat.layout.holder.progressloading.e.a(0);
    }

    public AIChatUgcAIGCServiceNoop() {
        this.b = j1.a(0);
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final com.larus.bmhome.video.save_share.a G() {
        return b0.a;
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final ps8.a L() {
        return d0.a;
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final i M() {
        return p.a;
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final x2 W() {
        return sr9.g.a;
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final ComponentFeature X() {
        return m.h;
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final yh8.a b0() {
        return r.a;
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final j e0() {
        return q.a;
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final k f0() {
        return sr9.f.a;
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final i1<Integer> n0() {
        return this.b;
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final com.larus.bmhome.instruction.m w0() {
        return y.a;
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final w2 z0() {
        return sr9.e.a;
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final qs8.a B0(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new c0(r2);
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final com.larus.bmhome.instruction.helper.f H0(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        return sr9.h.a;
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final c I(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        throw new IllegalStateException("IAIChatUgcAIGCService implementation is unavailable");
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final View K(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new View(r2);
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final g0 O(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new l(r2);
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final ISketchLoadingController Y(ViewStub r1) {
        return x.a;
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final c u0(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        throw new IllegalStateException("IAIChatUgcAIGCService implementation is unavailable");
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final LinearLayoutManager v0(Context r3) {
        if (r3 == null) goto L7;
        return new LinearLayoutManager(r3, 0, false);
    L7:
        throw new IllegalStateException("IAIChatUgcAIGCService implementation is unavailable");
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final Object I0(mr9.j r1, Continuation<? super Unit> r2) {
        return Unit.INSTANCE;
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final Fragment V(g r2, c4 r3) {
        Intrinsics.checkNotNullParameter(r2, "videoPlayData");
        Intrinsics.checkNotNullParameter(r3, "eventParam");
        return new Fragment();
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final Object j0(String r1, com.larus.bmhome.bigimg.download.c r2, Continuation r3) {
        r2.invoke(Boxing.boxBoolean(false));
        return Unit.INSTANCE;
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final ListAdapter m0(ChatParam r1, o1 r2, List r3, x2 r4) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        Intrinsics.checkNotNullParameter(r3, "segmentFactory");
        Intrinsics.checkNotNullParameter(r4, "actionBarShowTipCache");
        throw new IllegalStateException("IAIChatUgcAIGCService implementation is unavailable");
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final void a(y8 r2, String r3, ICoreInputAbility.OnSendParams r4, Map r5, com.larus.bmhome.chat.component.bottom.core.o1 r6) {
        Intrinsics.checkNotNullParameter(r2, "dependency");
        Intrinsics.checkNotNullParameter(r3, "originContent");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "ext");
        Intrinsics.checkNotNullParameter(r6, "originalLogic");
        r6.invoke(r4, r3, null);
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final void c0(Context r1, ViewGroup r2, String r3, UserCreation r4, String r5, String r6, LifecycleCoroutineScope r7, boolean r8, Function1 r9) {
        Intrinsics.checkNotNullParameter(r2, "viewParent");
        Intrinsics.checkNotNullParameter(r3, "downloadTaskKey");
        Intrinsics.checkNotNullParameter(r5, "currentPage");
        Intrinsics.checkNotNullParameter(r6, "clickFrom");
        Intrinsics.checkNotNullParameter(r7, "scope");
        Intrinsics.checkNotNullParameter(r9, "completeCallback");
        r9.invoke(Boolean.FALSE);
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final void G0(Context r1, g r2, String r3, String r4, String r5, String r6, boolean r7, Function4<? super g, ? super String, ? super Map<String, String>, ? super Map<String, String>, Unit> r8, Map<String, String> r9, Function1<? super Boolean, Unit> r10) {
        Intrinsics.checkNotNullParameter(r2, "videoPlayData");
        if (r10 == null) goto L6;
        r10.invoke(Boolean.FALSE);
        return;
    }

    @Override // com.larus.platform.spi.IAIChatUgcAIGCService
    public final void b(Context r1, g r2, c4 r3, String r4, CoroutineScope r5, boolean r6, boolean r7, JSONObject r8, Map<String, String> r9, String r10, boolean r11, Function4<? super Integer, ? super String, ? super Long, ? super Boolean, Unit> r12) {
        Intrinsics.checkNotNullParameter(r3, "videoDetailEventParams");
        Intrinsics.checkNotNullParameter(r4, "clickMethod");
        Intrinsics.checkNotNullParameter(r5, "scope");
        Intrinsics.checkNotNullParameter(r12, "dismissLoadingCallback");
        r12.invoke(0, "", 0L, Boolean.FALSE);
    }
}
