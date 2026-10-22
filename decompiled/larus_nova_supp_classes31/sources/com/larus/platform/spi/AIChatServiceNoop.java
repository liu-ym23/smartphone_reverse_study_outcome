package com.larus.platform.spi;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.auth.FeedbackMeta;
import com.larus.bmhome.bot.utils.c;
import com.larus.bmhome.chat.adapter.j;
import com.larus.bmhome.chat.api.b0;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.bean.PromptContent;
import com.larus.bmhome.chat.immerse.j0;
import com.larus.bmhome.chat.layout.holder.helper.LongClickSource;
import com.larus.bmhome.chat.layout.holder.helper.t0;
import com.larus.bmhome.chat.layout.holder.progressloading.LoadingType;
import com.larus.bmhome.chat.markdown.code.f;
import com.larus.bmhome.chat.markdown.code.h;
import com.larus.bmhome.tipoff.BaseTipOffDialog;
import com.larus.bmhome.tipoff.TipOffDialogParams;
import com.larus.bmhome.utils.c4;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.creation.TplType;
import com.larus.platform.model.EditPos;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import com.larus.platform.model.SlashMentionConfig;
import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.xbridge.custom.v;
import com.tencent.open.log.TraceLevel;
import hw8.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import lw8.l;
import nr9.g;
import sr9.a0;
import sr9.d;
import sr9.e0;
import sr9.i;
import sr9.k;
import sr9.n;
import sr9.o;
import sr9.s;
import sr9.t;
import sr9.u;
import sr9.w;
import sr9.z;
import st8.a;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000Ø\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J*\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J@\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\u0010H\u0016J\u0012\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u001d\u001a\u00020\tH\u0016J\u001e\u0010\u001e\u001a\u00020\t2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0010H\u0016J4\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010\u0005H\u0016Js\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u00052\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00050.23\u0010/\u001a/\u0012%\u0012#\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005010.¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\t00H\u0016J8\u00105\u001a\u00020\t2\u0006\u0010(\u001a\u00020)2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u00052\u000e\u0010:\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010;H\u0016J\b\u0010<\u001a\u00020\u0010H\u0016J\b\u0010=\u001a\u00020\u0010H\u0016J\b\u0010>\u001a\u00020\u0016H\u0016J&\u0010?\u001a\u00020\u00102\b\u0010@\u001a\u0004\u0018\u00010A2\b\u0010B\u001a\u0004\u0018\u00010C2\b\u0010D\u001a\u0004\u0018\u00010\u0005H\u0016J&\u0010E\u001a\u00020\u00102\b\u0010@\u001a\u0004\u0018\u00010A2\b\u0010B\u001a\u0004\u0018\u00010C2\b\u0010D\u001a\u0004\u0018\u00010\u0005H\u0016JT\u0010F\u001a\u0004\u0018\u00010G2\u0006\u0010@\u001a\u00020A2\u0006\u0010H\u001a\u00020\u00052\u0006\u0010I\u001a\u00020\u00102\u0006\u0010J\u001a\u00020\u00102\b\u0010K\u001a\u0004\u0018\u00010\u00052\u000e\u0010L\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010;2\u000e\u0010M\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010;H\u0016J \u0010N\u001a\u00020\u00162\u0006\u0010O\u001a\u00020\u00162\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020QH\u0016J\b\u0010S\u001a\u00020TH\u0016J\b\u0010U\u001a\u00020VH\u0016J\b\u0010W\u001a\u00020XH\u0016J\b\u0010Y\u001a\u00020ZH\u0016J\b\u0010[\u001a\u00020\\H\u0016J\b\u0010]\u001a\u00020^H\u0016J\u0010\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020bH\u0016J6\u0010c\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010d\u001a\u0004\u0018\u00010e2\b\u0010f\u001a\u0004\u0018\u00010g2\u0006\u0010h\u001a\u00020\u00102\u0006\u0010i\u001a\u00020\u0010H\u0016J@\u0010j\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010d\u001a\u0004\u0018\u00010e2\b\u0010f\u001a\u0004\u0018\u00010g2\u0006\u0010h\u001a\u00020\u00102\b\u0010k\u001a\u0004\u0018\u00010l2\u0006\u0010i\u001a\u00020\u0010H\u0016J\u0014\u0010m\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J \u0010n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010.2\b\u0010o\u001a\u0004\u0018\u00010\u0007H\u0096@¢\u0006\u0002\u0010pJ\u0010\u0010q\u001a\u00020\t2\u0006\u0010r\u001a\u00020\u0005H\u0016J\b\u0010s\u001a\u00020\tH\u0016J\b\u0010t\u001a\u00020\tH\u0016J\u0013\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00050vH\u0016¢\u0006\u0002\u0010wJ\u000e\u0010x\u001a\b\u0012\u0004\u0012\u00020\u00050.H\u0016J\u0010\u0010y\u001a\u00020\t2\u0006\u0010z\u001a\u00020\u0005H\u0016J\u0019\u0010{\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0002\u0010|J\u0014\u0010}\u001a\u0004\u0018\u00010~2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J-\u0010\u007f\u001a\u00020\u00052\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u00162\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00162\u0007\u0010\u0082\u0001\u001a\u00020\u0010H\u0016¢\u0006\u0003\u0010\u0083\u0001JS\u0010\u0084\u0001\u001a\u00020\u00102\b\u0010\u0085\u0001\u001a\u00030\u0086\u00012\b\u0010\u0087\u0001\u001a\u00030\u0088\u00012\b\u0010\u0089\u0001\u001a\u00030\u008a\u00012\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u008f\u0001\u001a\t\u0012\u0005\u0012\u00030\u0090\u00010.H\u0016J\f\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u0001H\u0016J\f\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0094\u0001H\u0016J\f\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u0001H\u0016J\u001d\u0010\u0097\u0001\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0016J\u0013\u0010\u0098\u0001\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u0005H\u0016J\u001d\u0010\u0099\u0001\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0016J\u001b\u0010\u009a\u0001\u001a\u00020\t2\b\u0010\u009b\u0001\u001a\u00030\u009c\u00012\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J,\u0010\u009d\u0001\u001a\u00020\t2\b\u0010\u009b\u0001\u001a\u00030\u009c\u00012\u0006\u0010\u0013\u001a\u00020\u00142\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0003\u0010\u009f\u0001J\u001f\u0010 \u0001\u001a\u00020\t2\b\u0010¡\u0001\u001a\u00030\u009c\u00012\n\u0010¢\u0001\u001a\u0005\u0018\u00010£\u0001H\u0016J\u0080\u0001\u0010¤\u0001\u001a\u00020\t2\b\u0010\u009b\u0001\u001a\u00030\u009c\u00012\u0007\u0010¥\u0001\u001a\u00020\u00142\n\u0010\u008e\u0001\u001a\u0005\u0018\u00010¦\u00012\t\u0010§\u0001\u001a\u0004\u0018\u00010\u00052\u0007\u0010¨\u0001\u001a\u00020\u00162\u0006\u0010D\u001a\u00020\u00052\u0007\u0010©\u0001\u001a\u00020\u00052\t\u0010ª\u0001\u001a\u0004\u0018\u00010\u00052\n\u0010«\u0001\u001a\u0005\u0018\u00010¬\u00012\t\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010®\u0001\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0003\u0010¯\u0001J*\u0010°\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050 2\u0013\u0010±\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000501H\u0016J\t\u0010²\u0001\u001a\u00020\u0010H\u0016J)\u0010³\u0001\u001a\u00020\t2\u0007\u0010´\u0001\u001a\u00020\u00102\u0015\u0010µ\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t\u0018\u000100H\u0016J\u0014\u0010¶\u0001\u001a\u00020\t2\t\u0010·\u0001\u001a\u0004\u0018\u00010\u0005H\u0016J\u0014\u0010¸\u0001\u001a\u00020\t2\t\u0010·\u0001\u001a\u0004\u0018\u00010\u0005H\u0016J\u0011\u0010¹\u0001\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010º\u0001\u001a\u00020\t2\u0007\u0010»\u0001\u001a\u00020\u0014H\u0016J\u0012\u0010¼\u0001\u001a\u00020\t2\u0007\u0010¥\u0001\u001a\u00020\u0014H\u0016J\u001b\u0010½\u0001\u001a\u00020\t2\u0006\u0010(\u001a\u00020)2\b\u0010¢\u0001\u001a\u00030£\u0001H\u0016J\u001b\u0010¾\u0001\u001a\u00020\t2\u0006\u0010(\u001a\u00020)2\b\u0010±\u0001\u001a\u00030¿\u0001H\u0016J\u0012\u0010À\u0001\u001a\u00020\t2\u0007\u0010¥\u0001\u001a\u00020\u0014H\u0016J4\u0010Á\u0001\u001a\u0005\u0018\u00010Â\u00012\r\u0010Ã\u0001\u001a\b\u0012\u0004\u0012\u00020\u00160.2\u0007\u0010Ä\u0001\u001a\u00020\u00162\u0007\u0010Å\u0001\u001a\u00020\u0005H\u0096@¢\u0006\u0003\u0010Æ\u0001J&\u0010Ç\u0001\u001a\u00020\t2\t\u0010È\u0001\u001a\u0004\u0018\u00010\u00052\u0007\u0010É\u0001\u001a\u00020\u00052\u0007\u0010Ê\u0001\u001a\u00020\rH\u0016J\"\u0010Ë\u0001\u001a\u00020\t2\u0007\u0010Ì\u0001\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0016J\u0013\u0010Í\u0001\u001a\u00020\t2\b\u0010Î\u0001\u001a\u00030Ï\u0001H\u0016J\u0013\u0010Ð\u0001\u001a\u00020\t2\b\u0010Î\u0001\u001a\u00030Ï\u0001H\u0016J/\u0010Ñ\u0001\u001a\u00020\t2\u0007\u0010¥\u0001\u001a\u00020\u00142\b\u0010%\u001a\u0004\u0018\u00010\u00052\u0007\u0010Ò\u0001\u001a\u00020\u00102\b\u0010o\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010Ó\u0001\u001a\u00020\t2\u0007\u0010Ô\u0001\u001a\u00020\u0010H\u0016J\u0012\u0010Õ\u0001\u001a\u00020\t2\u0007\u0010Ö\u0001\u001a\u00020\u0005H\u0016J:\u0010×\u0001\u001a\u00020\t2\b\u0010Ø\u0001\u001a\u00030\u0088\u00012\b\u0010Ù\u0001\u001a\u00030Ú\u00012\b\u0010Û\u0001\u001a\u00030Ü\u00012\u0007\u0010Ý\u0001\u001a\u00020\u00142\b\u0010Þ\u0001\u001a\u00030ß\u0001H\u0016Jx\u0010à\u0001\u001a\u00030á\u00012\u0007\u0010Ý\u0001\u001a\u00020\u00142\n\u0010â\u0001\u001a\u0005\u0018\u00010ã\u00012\n\u0010ä\u0001\u001a\u0005\u0018\u00010å\u00012\u0007\u0010æ\u0001\u001a\u00020\u00102\u000f\u0010ç\u0001\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010;2\u000f\u0010è\u0001\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010;2\u000f\u0010é\u0001\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010;2\u000f\u0010ê\u0001\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010;H\u0016J\u001c\u0010ë\u0001\u001a\u00030ì\u00012\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010o\u001a\u0004\u0018\u00010\u0007H\u0016J\u0083\u0001\u0010í\u0001\u001a\u00030î\u00012\b\u0010Ø\u0001\u001a\u00030\u0088\u00012\b\u0010ï\u0001\u001a\u00030ð\u00012\b\u0010â\u0001\u001a\u00030ã\u00012\n\u0010ñ\u0001\u001a\u0005\u0018\u00010ò\u00012\n\u0010ó\u0001\u001a\u0005\u0018\u00010Ü\u00012\n\u0010ä\u0001\u001a\u0005\u0018\u00010å\u00012\u0007\u0010Ý\u0001\u001a\u00020\u00142\r\u0010ô\u0001\u001a\b\u0012\u0004\u0012\u00020\u00140;2\u0007\u0010ª\u0001\u001a\u00020\u00102\n\u0010õ\u0001\u001a\u0005\u0018\u00010ö\u00012\b\u0010÷\u0001\u001a\u00030ø\u0001H\u0016J\n\u0010ù\u0001\u001a\u00030ú\u0001H\u0016J\u0014\u0010û\u0001\u001a\u0005\u0018\u00010ü\u00012\u0006\u0010\u0013\u001a\u00020\u0014H\u0016JB\u0010ý\u0001\u001a\u00030þ\u00012\u001f\u0010ÿ\u0001\u001a\u001a\u0012\u0005\u0012\u00030\u0081\u0002\u0018\u00010\u0080\u0002j\f\u0012\u0005\u0012\u00030\u0081\u0002\u0018\u0001`\u0082\u00022\t\u0010\u0083\u0002\u001a\u0004\u0018\u00010\u00052\n\u0010\u0084\u0002\u001a\u0005\u0018\u00010£\u0001H\u0016J\n\u0010\u0085\u0002\u001a\u00030\u0088\u0001H\u0016J\n\u0010\u0086\u0002\u001a\u00030\u0087\u0002H\u0016J'\u0010\u0088\u0002\u001a\u00020\t2\b\u0010¡\u0001\u001a\u00030\u009c\u00012\b\u0010\u0089\u0002\u001a\u00030\u008a\u00022\b\u0010\u008b\u0002\u001a\u00030\u008c\u0002H\u0016¨\u0006\u008d\u0002"}, d2 = {"Lcom/larus/platform/spi/AIChatServiceNoop;", "Lcom/larus/platform/spi/IAIChatService;", "<init>", "()V", "getSocialChatType", "", "cov", "Lcom/larus/im/bean/conversation/Conversation;", "onAsrRecError", "", "taskId", "path", "audioDuration", "", "vid", "insertMultiQuestionReference", "", "extra", "", "message", "Lcom/larus/im/bean/message/Message;", "searchIndex", "", "scene", "isReferenceAction", "getSelectIndex", "msgId", "onUpdateMessage", "convId", "tryBreakMusic", "getDeepResearchParamsToSend", "map", "", "hasSubBenefitsFromStore", "sendTextOnClickMsgLink", "content", "cvsId", "botId", "extras", "selectMsgIdsFromChatPage", "context", "Landroid/content/Context;", "schema", "pageMode", "enterMethod", "selectedMsgIds", "", "callback", "Lkotlin/Function1;", "Lkotlin/Pair;", "Lkotlin/ParameterName;", "name", "msgInfoList", "callMapSelectDialog", "latitude", "", "longitude", "destination", "clickCallBack", "Lkotlin/Function0;", "shouldSwitchToSpeakState", "shouldDisableAudioInput", "inputStatusByExperiment", "enableActionSpeech", "activity", "Landroidx/fragment/app/FragmentActivity;", "botModel", "Lcom/larus/im/bean/bot/BotModel;", "conversationId", "showOnSpeakText", "createBotAvatarViewerDialog", "Landroid/app/Dialog;", "avatarUrl", "canEditAvatar", "autoLogEnterPage", "from", "uploadPicClickListener", "autoGenBtnClickListener", "convertColorBySL", "color", "valueS", "", "valueL", "getBotSettingTrace", "Lcom/larus/bmhome/setting/IBotSettingTrace;", "createUgcVoiceUtils", "Lcom/larus/voice_setting/ICreateUgcVoiceUtils;", "getMixTracer", "Lcom/larus/voice_setting/voice/mix/IMixTracer;", "getChatImmerseUtil", "Lcom/larus/bmhome/chat/immerse/IChatImmerseUtil;", "getMessageShowRecord", "Lcom/larus/bmhome/chat/adapter/IMessageShowRecord;", "getGlobalNickNameHelper", "Lcom/larus/bmhome/bot/utils/IGlobalNickNameHelper;", "createTipOffDialog", "Lcom/larus/bmhome/tipoff/BaseTipOffDialog;", "params", "Lcom/larus/bmhome/tipoff/TipOffDialogParams;", "refreshValidVoiceItemText", "voiceItem", "Lcom/larus/bmhome/view/item/ItemTextArrow;", "speakerVoice", "Lcom/larus/im/bean/bot/SpeakerVoice;", "muted", "isRefreshByVoiceOnly", "refreshVoiceItemText", "botEditPos", "Lcom/larus/platform/model/EditPos;", "getContentWithTextTagInfo", "getBotIdList", SlashMentionConfig.MENTION_CONTENT_CONVERSATION, "(Lcom/larus/im/bean/conversation/Conversation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveAsrMainBotLanguage", "language", "initMarkdownResolver", "clearCachedTopic", "loadTccPromptTopic", "", "()[Ljava/lang/String;", "getAllCachedPromptTopic", "setNeedShowChangeIconBtn", "value", "isWelcomeBackMsg", "(Lcom/larus/im/bean/message/Message;)Ljava/lang/Boolean;", "toPromptContent", "Lcom/larus/bmhome/chat/bean/PromptContent;", "getChatType", "botConversationType", "botSourceType", "isOwnBot", "(Ljava/lang/Integer;Ljava/lang/Integer;Z)Ljava/lang/String;", "showSideNavConversationMenu", "anchor", "Landroid/view/View;", "hostFragment", "Landroidx/fragment/app/Fragment;", "conversationData", "Lcom/larus/bmhome/chat/model/api/ConversationData;", "clickFrom", "currentPage", "previousPage", "recommendFrom", "getCustomDataHandlers", "Lcom/larus/business/markdown/api/depend/ICustomDataHandler;", "getCustomImgHandler", "Lcom/larus/business/markdown/api/extplugin/image/ICustomImgHandler;", "getCustomCodeHandler", "Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeHandler;", "getCitationHandler", "Lcom/larus/business/markdown/api/citation/ICitationHandler;", "setUserBreakMsgId", "getUserBreakMsgId", "isUserBreakMsgId", "showDislikeFeedbackDialog", "fm", "Landroidx/fragment/app/FragmentManager;", "showDislikeFeedbackDialogAndReport", "conversationType", "(Landroidx/fragment/app/FragmentManager;Lcom/larus/im/bean/message/Message;Ljava/lang/Integer;)V", "showTtsFeedbackDialog", "fragmentManager", "bundle", "Landroid/os/Bundle;", "showTipOffDialog", "msg", "Lcom/larus/platform/model/RecommendFrom;", "fromPage", "reportSource", "severIndex", "isImmersive", "searchMobSource", "Lcom/larus/platform/model/SearchMobParam;", "commonMobParam", "reportType", "(Landroidx/fragment/app/FragmentManager;Lcom/larus/im/bean/message/Message;Lcom/larus/platform/model/RecommendFrom;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/model/SearchMobParam;Ljava/lang/String;Ljava/lang/Integer;)V", "messageSendExt", "param", "isExpertCardAutoCollapse", "updateExpertSwitchState", "switch", "listener", "waitAnswerReceiving", "question", "endAnswerReceiving", "checkIfAuthMessage", "replaceLatestMessage", "chatMessage", "broadcast", "openMainBot", "routeImportedImageToMainBot", "Lcom/larus/bmhome/chat/model/ImportedImageRouteParam;", "onReceiveMsg", "requireAllUserConfig", "Lcom/larus/platform/model/UserConfigResponse;", "configTypes", CustomFeedPlayerEvent.EXTRA_KEY_REASON, "source", "(Ljava/util/List;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onUpdateReceiveMsgTimeline", "localMsgId", "point", "curTime", "onStartSendMsg", "localSendMsgId", "observeRedDotCount", "observer", "Lcom/larus/bmhome/chat/reddot/ConversationRedDotListenerWrapper;", "unObserveRedDotCount", "onMsgShowRedDot", "isSocial", "setIsInDoraCall", "inCall", "markImageShown", "uriString", "showMessageMenuBalloon", "fragment", "recyclerView", "Lcom/larus/bmhome/chat/api/IMessageList;", "menuAnchor", "Lcom/larus/bmhome/view/textview/api/selector/IGestureTextView;", "data", TplType.MENU, "Lcom/larus/bmhome/view/screenmenu/CommonMenu;", "createCodeRenderLongClickHelper", "Landroid/view/View$OnLongClickListener;", "adapter", "Lcom/larus/bmhome/chat/api/MessageAdapter;", "modelProvider", "Lcom/larus/bmhome/chat/api/MessageAdapter$ModelProvider;", "isFromLynx", "onSaveCodeImage", "onFullscreen", "onCopyCode", "onCopyCodeImage", "textCellPopMenuGenerator", "Lcom/larus/bmhome/chat/layout/holder/helper/IPopMenuGroupCreator;", "createMenuTrigger", "Lcom/larus/platform/spi/TextCellMenuTrigger;", "hostView", "Landroidx/recyclerview/widget/RecyclerView;", "markdownView", "", "anchorView", "childMsgGetter", "markdownContent", "Lcom/larus/business/markdown/api/model/MarkdownContent;", "longClickSource", "Lcom/larus/bmhome/chat/layout/holder/helper/LongClickSource;", "getServiceBotCardHelper", "Lcom/larus/bmhome/chat/layout/holder/helper/api/IServiceBotCardHelper;", "getLoadingType", "Lcom/larus/bmhome/chat/layout/holder/progressloading/LoadingType;", "newFeedbackDialogFragmentInstance", "Landroidx/fragment/app/DialogFragment;", "metaList", "Ljava/util/ArrayList;", "Lcom/larus/bmhome/auth/FeedbackMeta;", "Lkotlin/collections/ArrayList;", "placeholder", "extraBundle", "createSettingFragment", "chatCameraCache", "Lcom/larus/platform/spi/IChatCameraCache;", "launchVideoDetail", "videoPlayData", "Lcom/larus/platform/model/video/VideoPlayData;", "eventParam", "Lcom/larus/bmhome/utils/VideoDetailEventParams;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class AIChatServiceNoop implements IAIChatService {
    public AIChatServiceNoop() {
    }

    public final LoadingType B7(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        return null;
    }

    public final void D7(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public final boolean F7(Map<String, String> r1, Message r2, int r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r1, "extra");
        return false;
    }

    public final void H7(FragmentManager r2, Message r3) {
        Intrinsics.checkNotNullParameter(r2, "fm");
        Intrinsics.checkNotNullParameter(r3, "message");
    }

    public final void I7(Fragment r2, b0 r3, a r4, Message r5, CommonMenu r6) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        Intrinsics.checkNotNullParameter(r4, "menuAnchor");
        Intrinsics.checkNotNullParameter(r5, "data");
        Intrinsics.checkNotNullParameter(r6, TplType.MENU);
    }

    public final boolean J7() {
        return false;
    }

    public final void K7(FragmentManager r2, g r3, c4 r4) {
        Intrinsics.checkNotNullParameter(r2, "fragmentManager");
        Intrinsics.checkNotNullParameter(r3, "videoPlayData");
        Intrinsics.checkNotNullParameter(r4, "eventParam");
    }

    public final PromptContent L7(Message r1) {
        return null;
    }

    public final void M7(Context r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "bundle");
    }

    public final boolean N7(FragmentActivity r1, BotModel r2, String r3) {
        return false;
    }

    public final boolean Q7(FragmentActivity r1, BotModel r2, String r3) {
        return false;
    }

    public final String T7(Message r1) {
        return null;
    }

    public final String U7(e r1) {
        return "";
    }

    public final boolean V7() {
        return false;
    }

    public final void W7(FragmentManager r1, Message r2, RecommendFrom r3, String r4, int r5, String r6, String r7, String r8, SearchMobParam r9, String r10, Integer r11) {
        Intrinsics.checkNotNullParameter(r1, "fm");
        Intrinsics.checkNotNullParameter(r2, "msg");
        Intrinsics.checkNotNullParameter(r6, "conversationId");
        Intrinsics.checkNotNullParameter(r7, "severIndex");
    }

    public final void X7() {
    }

    public final String[] a8() {
        return new String[0];
    }

    public final b b() {
        return null;
    }

    public final void b8(String r1) {
    }

    public final void c(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "convId");
        Intrinsics.checkNotNullParameter(r3, "taskId");
    }

    public final void c8(String r1, String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "point");
    }

    public final int d(String r1) {
        return -1;
    }

    public final void d8() {
    }

    public final jw8.a e() {
        return null;
    }

    public final String e7(String r1) {
        return "";
    }

    public final void f(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
    }

    public final String g(Integer r1, Integer r2, boolean r3) {
        return "";
    }

    public final void g7(Context r1, ItemTextArrow r2, SpeakerVoice r3, boolean r4) {
    }

    public final com.larus.business.markdown.api.extplugin.image.a h() {
        return null;
    }

    public final boolean h7() {
        return false;
    }

    public final void h8(boolean r1) {
    }

    public final void i7(Map<String, String> r1) {
    }

    public final void i8(String r1) {
    }

    public final void j7() {
    }

    public final void l8(String r1, String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r1, "content");
        Intrinsics.checkNotNullParameter(r2, "cvsId");
        Intrinsics.checkNotNullParameter(r4, "scene");
    }

    public final void m4(String r1, String r2) {
    }

    public final void m7(String r1, String r2, long r3, String r5) {
        Intrinsics.checkNotNullParameter(r1, "taskId");
        Intrinsics.checkNotNullParameter(r5, "vid");
    }

    public final void m8(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "localSendMsgId");
        Intrinsics.checkNotNullParameter(r3, "cvsId");
        Intrinsics.checkNotNullParameter("speak", "scene");
    }

    public final void n4() {
    }

    public final void n7(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uriString");
    }

    public final boolean n8() {
        return false;
    }

    public final void o4(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public final void q7(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "chatMessage");
    }

    public final boolean q8() {
        return false;
    }

    public final boolean r7(Message r1) {
        return false;
    }

    public final int w7() {
        return 0;
    }

    public final Dialog x7(FragmentActivity r1, String r2, boolean r3, String r4, Function0 r5, Function0 r6) {
        Intrinsics.checkNotNullParameter(r1, "activity");
        Intrinsics.checkNotNullParameter(r2, "avatarUrl");
        return null;
    }

    public final void y7(Context r1, double r2, double r4, String r6, Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r6, "destination");
    }

    public final void z7(Context r1, ItemTextArrow r2, SpeakerVoice r3, boolean r4, EditPos r5, boolean r6) {
    }

    public final Fragment R7() {
        return new Fragment();
    }

    public final List<com.larus.business.markdown.api.depend.a> a() {
        return CollectionsKt.emptyList();
    }

    public final List<String> p7() {
        return CollectionsKt.emptyList();
    }

    public final j Y7() {
        return s.a;
    }

    public final v2a.b f7() {
        return t.a;
    }

    public final j0 j8() {
        return k.a;
    }

    public final com.larus.bmhome.setting.b k8() {
        return i.a;
    }

    public final c l7() {
        return o.a;
    }

    public final cf8.a o7() {
        return w.a;
    }

    public final p2a.a u7() {
        return n.a;
    }

    public final d v7() {
        return sr9.j.a;
    }

    public final Map<String, String> A7(Pair<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "param");
        return MapsKt.emptyMap();
    }

    public final Boolean E7(Message r1) {
        return Boolean.FALSE;
    }

    public final ot8.a f8(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        return null;
    }

    public final BaseTipOffDialog g8(TipOffDialogParams r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        return new a0();
    }

    public final t0 O7(Message r1, e r2) {
        Intrinsics.checkNotNullParameter(r1, "message");
        return u.a;
    }

    public final Object s7(e r1, Continuation<? super List<String>> r2) {
        return CollectionsKt.emptyList();
    }

    public final void t7(boolean r1, Function1<? super Boolean, Unit> r2) {
        if (r2 == null) goto L5;
        r2.invoke(Boolean.FALSE);
        return;
    }

    public final boolean P7(Message r1, Fragment r2, LongClickSource r3) {
        Intrinsics.checkNotNullParameter(r3, "longClickSource");
        return false;
    }

    public final DialogFragment k7(ArrayList<FeedbackMeta> r1, String r2, Bundle r3) {
        return new DialogFragment();
    }

    public final boolean e8(Context r1, Fragment r2, Message r3, LongClickSource r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r4, "longClickSource");
        return false;
    }

    public final boolean S7(Context r1, Fragment r2, Message r3, BotModel r4, LongClickSource r5, String r6) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r4, "botModel");
        Intrinsics.checkNotNullParameter(r5, "longClickSource");
        e8(r1, r2, r3, r5);
        return false;
    }

    public final void Z7(Context r1, String r2, String r3, int r4, String r5, List r6, v r7) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "schema");
        Intrinsics.checkNotNullParameter(r3, "cvsId");
        Intrinsics.checkNotNullParameter(r5, "enterMethod");
        Intrinsics.checkNotNullParameter(r6, "selectedMsgIds");
        Intrinsics.checkNotNullParameter(r7, "callback");
        r7.invoke(CollectionsKt.emptyList());
    }

    public final View.OnLongClickListener C7(Message r1, q0 r2, q0.a r3, boolean r4, f r5, com.larus.bmhome.chat.markdown.code.g r6, h r7, com.larus.bmhome.chat.markdown.code.i r8) {
        Intrinsics.checkNotNullParameter(r1, "data");
        return new sr9.a();
    }

    public final e0 G7(Fragment r1, RecyclerView r2, q0 r3, Object r4, a r5, q0.a r6, Message r7, Function0<Message> r8, boolean r9, l r10, LongClickSource r11) {
        Intrinsics.checkNotNullParameter(r1, "fragment");
        Intrinsics.checkNotNullParameter(r2, "hostView");
        Intrinsics.checkNotNullParameter(r3, "adapter");
        Intrinsics.checkNotNullParameter(r7, "data");
        Intrinsics.checkNotNullParameter(r8, "childMsgGetter");
        Intrinsics.checkNotNullParameter(r11, "longClickSource");
        return z.a;
    }
}
