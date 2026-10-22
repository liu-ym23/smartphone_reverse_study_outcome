package com.larus.uaigc.service;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.bmhome.bigimg.download.CommonDownLoadLayout;
import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.share.ShareScene;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.uaigc.bean.remove.ImageEditDataWithMask;
import com.larus.ui.arch.component.external.api.Component;
import com.tencent.open.log.TraceLevel;
import java.io.File;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0096@¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J>\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0016J\u0012\u0010\u0014\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J2\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J<\u0010\u001e\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0018\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u00112\b\u0010!\u001a\u0004\u0018\u00010\u00062\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0#H\u0016J\b\u0010$\u001a\u00020\nH\u0016JK\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u001a2\b\u00101\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u00102J\b\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u00020\nH\u0016J\u0010\u00106\u001a\u00020\n2\u0006\u00107\u001a\u000208H\u0016J\u001e\u00109\u001a\u00020\n2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;2\u0006\u00107\u001a\u000208H\u0016J\u0018\u0010=\u001a\u00020\n2\u0006\u00107\u001a\u00020>2\u0006\u0010?\u001a\u00020-H\u0016J6\u0010@\u001a\u00020\n2\u0006\u00107\u001a\u00020>2\u0006\u0010?\u001a\u00020-2\u0006\u0010A\u001a\u00020\u001d2\u0014\u0010B\u001a\u0010\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020\n\u0018\u00010CH\u0016J\u0018\u0010E\u001a\u00020\n2\u0006\u00107\u001a\u00020>2\u0006\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u00020IH\u0016J\u0010\u0010J\u001a\u00020<2\u0006\u00107\u001a\u00020KH\u0016J*\u0010L\u001a\u0004\u0018\u00010M2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\u0006H\u0096@¢\u0006\u0002\u0010QJ*\u0010R\u001a\u0004\u0018\u00010M2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\u0006H\u0096@¢\u0006\u0002\u0010QJ\b\u0010S\u001a\u00020TH\u0016J(\u0010U\u001a\u00020\n2\u0006\u0010&\u001a\u00020'2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020X0W2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0016J \u0010[\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020]H\u0016J\u0010\u0010_\u001a\u00020M2\u0006\u0010`\u001a\u00020\u0006H\u0016J\b\u0010a\u001a\u00020bH\u0016J\u0010\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020/H\u0016J.\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020/2\u0014\u0010k\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020n\u0018\u00010m0lH\u0016J\b\u0010o\u001a\u00020pH\u0016J\u0010\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020tH\u0016J\b\u0010u\u001a\u00020\rH\u0016J\u001e\u0010v\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020w2\u0006\u0010x\u001a\u00020<H\u0096@¢\u0006\u0002\u0010yJ\u0010\u0010z\u001a\u00020\n2\u0006\u0010{\u001a\u00020|H\u0016J\u0091\u0001\u0010}\u001a\u00020r2[\u0010~\u001aW\u0012\u0017\u0012\u00150\u0080\u0001¢\u0006\u000f\b\u0081\u0001\u0012\n\b\u0082\u0001\u0012\u0005\b\b(\u0083\u0001\u0012\u0018\u0012\u0016\u0018\u00010\u0006¢\u0006\u000f\b\u0081\u0001\u0012\n\b\u0082\u0001\u0012\u0005\b\b(\u0084\u0001\u0012\u0018\u0012\u0016\u0018\u00010]¢\u0006\u000f\b\u0081\u0001\u0012\n\b\u0082\u0001\u0012\u0005\b\b(\u0085\u0001\u0012\u0004\u0012\u00020\n\u0018\u00010\u007f2\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J\u007f\u0010\u008a\u0001\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010'2\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00062\b\u0010\u008c\u0001\u001a\u00030\u008d\u00012\n\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u00012\n\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u00012\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u00012\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u00012\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u00172\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010-2\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0003\u0010\u0099\u0001J\t\u0010\u009a\u0001\u001a\u00020\nH\u0016Jd\u0010\u009b\u0001\u001a\u00020\n2\b\u0010\u009c\u0001\u001a\u00030\u009d\u00012\u0007\u0010\u009e\u0001\u001a\u00020\u00062\b\u0010\u009f\u0001\u001a\u00030 \u00012\u0014\u0010¡\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060¢\u00012&\u0010£\u0001\u001a!\u0012\u0007\u0012\u0005\u0018\u00010 \u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\n0\u007fH\u0016JÆ\u0001\u0010¤\u0001\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010'2\u0007\u0010¥\u0001\u001a\u00020\u00062\n\u0010¦\u0001\u001a\u0005\u0018\u00010§\u00012\u0006\u0010j\u001a\u00020/2\u000f\u0010¨\u0001\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010#2\u0007\u0010©\u0001\u001a\u00020\u001d2\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u00012\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u00172*\u0010ª\u0001\u001a%\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020|\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0012\u0004\u0012\u00020\n\u0018\u00010«\u00012\u000f\u0010¬\u0001\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010#2 \u0010\u00ad\u0001\u001a\u001b\b\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00060®\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010CH\u0016¢\u0006\u0003\u0010¯\u0001J.\u0010°\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u00012\t\u0010±\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J-\u0010°\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u00172\t\u0010±\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J.\u0010²\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u00012\t\u0010±\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J-\u0010²\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u00172\t\u0010±\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J.\u0010³\u0001\u001a\u0005\u0018\u00010\u0095\u00012\n\u0010´\u0001\u001a\u0005\u0018\u00010µ\u00012\t\u0010¶\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010·\u0001\u001a\u0004\u0018\u00010\u0006H\u0016JH\u0010¸\u0001\u001a\u00020\u00062\u0007\u0010¹\u0001\u001a\u00020\u00062\u0007\u0010º\u0001\u001a\u00020\u00062\u0007\u0010»\u0001\u001a\u00020\u00062\u0007\u0010¼\u0001\u001a\u00020\u00062\u0007\u0010½\u0001\u001a\u00020\u001d2\t\u0010¾\u0001\u001a\u0004\u0018\u00010\u0006H\u0096@¢\u0006\u0003\u0010¿\u0001J \u0010À\u0001\u001a\u00020\u001d2\u0015\u0010Á\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J-\u0010Â\u0001\u001a\u00030Ã\u00012\r\u0010Ä\u0001\u001a\b0Å\u0001j\u0003`Æ\u00012\n\u0010Ç\u0001\u001a\u0005\u0018\u00010È\u00012\u0006\u0010!\u001a\u00020\u0006H\u0016J/\u0010É\u0001\u001a\u00030Ã\u00012\r\u0010Ä\u0001\u001a\b0Å\u0001j\u0003`Æ\u00012\t\u0010Ê\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010Ë\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J\u0011\u0010Ì\u0001\u001a\n\u0012\u0005\u0012\u00030Î\u00010Í\u0001H\u0016J%\u0010Ï\u0001\u001a\u00030Ã\u00012\r\u0010Ä\u0001\u001a\b0Å\u0001j\u0003`Æ\u00012\n\u0010Ç\u0001\u001a\u0005\u0018\u00010È\u0001H\u0016JW\u0010Ð\u0001\u001a\u00030Ñ\u00012\n\u0010Ò\u0001\u001a\u0005\u0018\u00010Ó\u00012?\u0010Ô\u0001\u001a:\u0012\u0017\u0012\u00150Ö\u0001¢\u0006\u000f\b\u0081\u0001\u0012\n\b\u0082\u0001\u0012\u0005\b\b(\u0083\u0001\u0012\u0016\u0012\u00140\u0006¢\u0006\u000f\b\u0081\u0001\u0012\n\b\u0082\u0001\u0012\u0005\b\b(×\u0001\u0012\u0004\u0012\u00020\n0Õ\u0001H\u0016J\u0013\u0010Ø\u0001\u001a\u00020\u001d2\b\u0010Ù\u0001\u001a\u00030Ú\u0001H\u0016J%\u0010Û\u0001\u001a\u00020\u001d2\b\u0010Ù\u0001\u001a\u00030Ú\u00012\u0007\u0010Ü\u0001\u001a\u00020\u00062\u0007\u0010Ý\u0001\u001a\u00020\u0006H\u0016J\t\u0010Þ\u0001\u001a\u00020\u001dH\u0016J\t\u0010ß\u0001\u001a\u00020\u001dH\u0016J\t\u0010à\u0001\u001a\u00020\u001dH\u0016J\t\u0010á\u0001\u001a\u00020\nH\u0016J\u0013\u0010â\u0001\u001a\f\u0012\u0005\u0012\u00030ã\u0001\u0018\u00010Í\u0001H\u0016J\u0013\u0010ä\u0001\u001a\f\u0012\u0005\u0012\u00030ã\u0001\u0018\u00010Í\u0001H\u0016J\u0013\u0010å\u0001\u001a\f\u0012\u0005\u0012\u00030ã\u0001\u0018\u00010Í\u0001H\u0016J\f\u0010æ\u0001\u001a\u0005\u0018\u00010ã\u0001H\u0016J\f\u0010ç\u0001\u001a\u0005\u0018\u00010è\u0001H\u0016J\u0014\u0010é\u0001\u001a\u00020\n2\t\u0010ê\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010ë\u0001\u001a\u00020\n2\t\u0010ì\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J\t\u0010í\u0001\u001a\u00020\u001dH\u0016J\f\u0010î\u0001\u001a\u0005\u0018\u00010ï\u0001H\u0016J\u0011\u0010ð\u0001\u001a\u0004\u0018\u00010\u0006H\u0096@¢\u0006\u0002\u0010\bJ\t\u0010ñ\u0001\u001a\u00020\nH\u0016J\t\u0010ò\u0001\u001a\u00020\nH\u0016J\u0014\u0010ó\u0001\u001a\u00020\u001d2\t\u0010ô\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J\u0013\u0010õ\u0001\u001a\u00020\n2\b\u0010\u009f\u0001\u001a\u00030ö\u0001H\u0016J\f\u0010÷\u0001\u001a\u0005\u0018\u00010ø\u0001H\u0016Jw\u0010ù\u0001\u001a\u00020\u001d2\u0007\u0010ú\u0001\u001a\u00020\u001a2\n\u0010û\u0001\u001a\u0005\u0018\u00010Ñ\u00012\n\u0010´\u0001\u001a\u0005\u0018\u00010µ\u00012\t\u0010¶\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010ü\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010ý\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010þ\u0001\u001a\u0004\u0018\u00010\u00062\u0007\u0010ÿ\u0001\u001a\u00020\u00062\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005H\u0016J\f\u0010\u0080\u0002\u001a\u0005\u0018\u00010\u0081\u0002H\u0016J0\u0010\u0082\u0002\u001a\u00020\n2\t\u0010º\u0001\u001a\u0004\u0018\u00010\u00062\u0007\u0010\u0083\u0002\u001a\u00020]2\b\u0010\u0084\u0002\u001a\u00030\u0085\u00022\u0007\u0010\u0086\u0002\u001a\u00020|H\u0016J\u0012\u0010\u0087\u0002\u001a\u00030\u0088\u00022\u0006\u0010e\u001a\u00020/H\u0016¨\u0006\u0089\u0002"}, d2 = {"Lcom/larus/uaigc/service/IUgcAIGCServiceNoop;", "Lcom/larus/uaigc/service/IUgcAIGCService;", "<init>", "()V", "getCacheOrFetchSpringPocketData", "", "", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preFetchSpringPocketData", "", "startObservePollingConfig", "getSpringMainVenueRouterInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "getWorldCupMainRouterInterceptor", "onApplyPocket", "ownerActivity", "Landroid/app/Activity;", "data", "extra", "onPopNativePage", "pushCreationNotify", "creation", "Lcom/larus/platform/api/creation/UserCreation;", "activity", "shareContainer", "Landroid/view/View;", "targetActivity", "skipChannel", "", "pushCreationDoSameNotify", "notifyInfo", "Lcom/larus/uaigc/service/CreationDoSameNotifyInfo;", "enterMethod", "clickCallBack", "Lkotlin/Function0;", "dismissCreationNotify", "downloadCreation", "context", "Landroid/content/Context;", "imageUrl", "Lcom/larus/bmhome/bigimg/ImagePreviewDownloadUrl;", "reportParams", "Lorg/json/JSONObject;", "creationType", "", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "rootView", "creationId", "(Landroid/content/Context;Lcom/larus/bmhome/bigimg/ImagePreviewDownloadUrl;Lorg/json/JSONObject;Ljava/lang/Integer;Lkotlinx/coroutines/CoroutineScope;Landroid/view/View;Ljava/lang/String;)V", "reportHelper", "Lcom/larus/uaigc/bean/IUgcReportHelper;", "clearAvatarWhiteTUrl", "openCreatePage", "config", "Lcom/larus/uaigc/bean/createpage/ICreatePageConfig;", "openCreatePageForResult", "activityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "sendRemoteImageAndTextMessage", "Lcom/larus/uaigc/bean/ImageEditSendMessageStrategyConfig;", "instructionType", "sendImageAndTextMessage", "needPreprocessImage", "uploadSuccessCallback", "Lkotlin/Function1;", "Lcom/larus/uaigc/bean/UploadSuccessData;", "sendImageRemoveMessage", "imageEditDataWithMask", "Lcom/larus/uaigc/bean/remove/ImageEditDataWithMask;", "getAspectRatioSelectStrategy", "Lcom/larus/uaigc/bean/IAspectRatioSelectStrategy;", "getCreationIntent", "Lcom/larus/uaigc/bean/createpage/CreatePageConfig;", "saveBitmapToCleanableDir", "Ljava/io/File;", "bitmap", "Landroid/graphics/Bitmap;", "fileName", "(Landroid/content/Context;Landroid/graphics/Bitmap;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveBitMapToFile", "createImageRemoveDialogFragment", "Lcom/larus/uaigc/bean/remove/IImageRemoveDialogFragment;", "openBigImagesFragment", "properties", "Lcom/larus/uaigc/bean/chat/ImageDetailFragmentProp;", "Lcom/larus/bmhome/creation/bean/ICreationContentData;", "galleryContext", "Lcom/larus/uaigc/bean/chat/gallery/CreationGalleryContext;", "copyUri", "sourceUri", "Landroid/net/Uri;", "destinationUri", "buildSendImgCacheFile", "formatSuffix", "creationPagePerfMonitorHelper", "Lcom/larus/uaigc/bean/createpage/trace/ICreationPagePerfMonitorHelper;", "createCreationQueuingTaskViewModel", "Lcom/larus/bmhome/chat/component/loading/ICreationQueuingTaskViewModel;", "viewModelScope", "createImageLoadingProgressComponent", "Lcom/larus/uaigc/bean/chat/loading/ILoadingProgress;", "sketchProgressLoadingViewStub", "Landroid/view/ViewStub;", "scope", "loadingProgressState", "Lkotlin/Lazy;", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/larus/bmhome/creative/loading/MessageLoadingUIState;", "getDigitalAvatarOnboardingCacheManager", "Lcom/larus/platform/model/creation/IDigitalAvatarOnboardingCacheManager;", "createDigitalAvatarTemplateListDialogFragment", "Landroidx/fragment/app/DialogFragment;", "model", "Lcom/larus/uaigc/avatar/DigitalAvatarTemplateModel;", "createDigitalAvatarRouteInterceptor", "tryDirectlyJumpImageTemplate", "Landroidx/appcompat/app/AppCompatActivity;", "intent", "(Landroidx/appcompat/app/AppCompatActivity;Landroid/content/Intent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportTemplateRecommendOpCounter", "templatePrimaryKey", "", "createImageTemplateListDialogFragment", "imageTemplateChoose", "Lkotlin/Function3;", "Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateInfo;", "Lkotlin/ParameterName;", "name", "templateInfo", "conversationId", "localImagePath", "botId", "chatType", "recommendFrom", "cvsId", "showShareImagePanel", "imgUrl", "shareScene", "Lcom/larus/bmhome/share/ShareScene;", "callback", "Lcom/larus/bmhome/share/panel/ISharePanelClickListener;", "eventParam", "Lcom/larus/bmhome/share/panel/SharePanelEventParam;", "node", "Lcom/ixigua/lib/track/ITrackNode;", "userCreationFromIM", "Lcom/larus/platform/api/creation/UserCreationFromIM;", "userCreation", "taskType", "imageKey", "(Landroid/content/Context;Ljava/lang/String;Lcom/larus/bmhome/share/ShareScene;Lcom/larus/bmhome/share/panel/ISharePanelClickListener;Lcom/larus/bmhome/share/panel/SharePanelEventParam;Lcom/ixigua/lib/track/ITrackNode;Lcom/larus/platform/api/creation/UserCreationFromIM;Lcom/larus/platform/api/creation/UserCreation;Ljava/lang/Integer;Ljava/lang/String;)V", "clearCreationActionbarDependencyCache", "uploadBeforeSendNestedFiles", "dependency", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputDependency;", "originContent", "params", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$OnSendParams;", "ext", "", "originalLogic", "saveAigcVideoAndLoading", "downloadTaskKey", "videoPlayData", "Lcom/larus/platform/model/video/VideoPlayData;", "traceBlk", "enableUseSRDownLoad", "finishCallback", "Lkotlin/Function4;", "saveCreationTaskIdBlk", "onInterceptUrl", "Lkotlin/coroutines/Continuation;", "(Landroid/content/Context;Ljava/lang/String;Lcom/larus/platform/model/video/VideoPlayData;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;ZLcom/larus/platform/api/creation/UserCreationFromIM;Lcom/larus/platform/api/creation/UserCreation;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "getVideoMetaData", "taskId", "getImageMetadata", "getUserCreationFromIM", "message", "Lcom/larus/im/bean/message/Message;", "creationTaskId", "position", "resolveFileFinalDownloadUrlIfNeeded", "url", "scene", "subScene", "contentType", "isAIGC", "resourceKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkVideoMetaDataValid", "metaData", "createDigitalAvatarInstructionBizAdapter", "Lcom/larus/bmhome/instruction/biz/AbsInstructionBizAdapter;", "component", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "instructionDependency", "Lcom/larus/bmhome/instruction/biz/IInstructionDependency;", "createAiCreationInstructionBizAdapter", "previousPage", "currentPage", "getLyricsToSongCellInfoList", "", "Lcom/larus/bmhome/chat/cell/CellManager$CellInfo;", "createMusicInstructionBizAdapter", "createMusicTemplateListFragment", "Landroidx/fragment/app/Fragment;", "templateViewModel", "Lcom/larus/uaigc/bean/chat/template/TemplateViewModel;", "templateChooseCallback", "Lkotlin/Function2;", "Lcom/larus/bmhome/instruction/core/model/music/MusicGenTemplate;", "enterFrom", "openMusicTemplateApplet", "arguments", "Landroid/os/Bundle;", "openMusicDetailApplet", "page", "routeMode", "hasCreatedAvatar", "isAvatarInCreating", "isAvatarCreated", "initFetch", "getDigitalAvatarPreGenImagesOfScan", "Lcom/larus/uaigc/avatar/api/PreGenImage;", "getDigitalAvatarPreGenImagesOfUpload", "getDigitalAvatarPreGenImages", "getDigitalAvatarMasterPreGenImage", "getDigitalAvatarRefVideo", "Lcom/larus/uaigc/avatar/api/AiReplicaRefVideo;", "updateDigitalAvatarIpaMainTempUrl", "tempUrl", "updateDigitalAvatarIpaMainTempUri", "tempUri", "needCompleteVideoAvatar", "getAiReplicaInfo", "Lcom/larus/uaigc/api/AiReplicaInfoData;", "fetchAiReplicaIpaMainUrl", "avatarCleared", "avatarCreated", "isNestedFileProcessing", "identifier", "galleryShareVideo", "Lcom/larus/uaigc/creation/VideoSharePanelParams;", "createSpringMultiAttachmentSelectorComponent", "Lcom/larus/ui/arch/component/external/api/Component;", "citeOrQuestionAttachmentToInput", "anchorView", "fragment", "vid", "coverUrl", "downloadUrl", "fromScene", "getCreationImageUploadPolicy", "Lcom/larus/uaigc/utils/ICreationImageUploadPolicy;", "mobDuplicateStatAsync", "uri", "processFileResult", "Lcom/larus/bmhome/chat/bean/ProcessFileResult;", "processTime", "createCreationVideoManager", "Lcom/larus/bmhome/chat/markdown/creation/video/helper/ICreationVideoManager;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class IUgcAIGCServiceNoop implements IUgcAIGCService {

    public static final class a implements q97.a {
        public a() {
        }

        public final boolean a(Context r1, com.bytedance.router.c r2) {
            return false;
        }

        public final boolean b(com.bytedance.router.c r1) {
            return false;
        }
    }

    public static final class b implements xy9.b {
        public b() {
        }

        @Override // xy9.b
        public final void K00(Bundle r1, xy9.a r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r1, "bundle");
            Intrinsics.checkNotNullParameter(r2, "callback");
        }

        @Override // xy9.b
        public final void dismiss() {
        }

        @Override // xy9.b
        public final void show(FragmentManager r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "manager");
        }
    }

    public static final class c implements hy9.d {
        public c() {
        }

        @Override // hy9.d
        public final void a(String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9) {
        }

        @Override // hy9.d
        public final void c(String r1) {
        }

        @Override // hy9.d
        public final void d(int r1, String r2, String r3, String r4, String r5) {
        }

        @Override // hy9.d
        public final void f(String r1, String r2, String r3, String r4, String r5) {
        }

        @Override // hy9.d
        public final void g(String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, Boolean r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, JSONObject r21, by7.e r22) {
            Intrinsics.checkNotNullParameter(r15, "tabType");
            Intrinsics.checkNotNullParameter(r21, "params");
        }

        @Override // hy9.d
        public final void h(String r1, Integer r2, String r3, String r4, String r5, String r6, String r7, String r8, JSONObject r9, by7.e r10, String r11) {
            Intrinsics.checkNotNullParameter(r9, "params");
        }

        @Override // hy9.d
        public final void i(String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, Boolean r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, JSONObject r23, by7.e r24) {
            Intrinsics.checkNotNullParameter(r19, "tabType");
            Intrinsics.checkNotNullParameter(r23, "params");
        }

        @Override // hy9.d
        public final void j(Message r1, String r2) {
        }

        @Override // hy9.d
        public final void k(String r1, String r2, String r3, String r4) {
        }

        @Override // hy9.d
        public final ky9.a b() {
            return new o();
        }

        @Override // hy9.d
        public final ky9.b e() {
            return new p();
        }
    }

    public IUgcAIGCServiceNoop() {
    }

    public final void A(ActivityResultLauncher<Intent> r2, ny9.c r3) {
        Intrinsics.checkNotNullParameter(r2, "activityResultLauncher");
        Intrinsics.checkNotNullParameter(r3, "config");
    }

    public final Map<String, String> B(UserCreation r1, String r2) {
        return null;
    }

    public final Object C(Continuation<? super String> r1) {
        return null;
    }

    public final Object D(String r1, String r2, String r3, String r4, boolean r5, String r6, Continuation<? super String> r7) {
        return r1;
    }

    public final void F() {
    }

    public final com.larus.uaigc.api.a G() {
        return null;
    }

    public final Map<String, String> H(UserCreation r1, String r2) {
        return null;
    }

    public final UserCreationFromIM I(Message r1, String r2, String r3) {
        return null;
    }

    public final void J(UserCreation r1, FragmentActivity r2, View r3, Activity r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r1, "creation");
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "shareContainer");
    }

    public final List<ey9.k> K() {
        return null;
    }

    public final Map<String, String> L(UserCreationFromIM r1, String r2) {
        return null;
    }

    public final Component M() {
        return null;
    }

    public final void N(Context r1, String r2, ShareScene r3, com.larus.bmhome.share.panel.d r4, com.larus.bmhome.share.panel.h r5, by7.e r6, UserCreationFromIM r7, UserCreation r8, Integer r9, String r10) {
        Intrinsics.checkNotNullParameter(r3, "shareScene");
    }

    public final void O() {
    }

    public final void P() {
    }

    public final List<ey9.k> Q() {
        return null;
    }

    public final boolean S() {
        return false;
    }

    public final void T(String r1) {
    }

    public final void U(String r1, Uri r2, ic8.n0 r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        Intrinsics.checkNotNullParameter(r3, "processFileResult");
    }

    public final void W(ny9.b r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
    }

    public final boolean X(Bundle r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "arguments");
        Intrinsics.checkNotNullParameter(r3, "page");
        Intrinsics.checkNotNullParameter(r4, "routeMode");
        return false;
    }

    public final boolean Y(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "arguments");
        return false;
    }

    public final void Z(CreationDoSameNotifyInfo r1, FragmentActivity r2, FragmentActivity r3, String r4, Function0 r5) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r5, "clickCallBack");
    }

    public final void b(Activity r1, Map<String, ? extends Object> r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r3, "extra");
    }

    public final void c(String r1) {
    }

    public final q97.a d() {
        return null;
    }

    public final Object e(Context r1, Bitmap r2, String r3, Continuation<? super File> r4) {
        return null;
    }

    public final void f() {
    }

    public final void g(Context r1, String r2, nr9.g r3, CoroutineScope r4, Function0<Unit> r5, boolean r6, UserCreationFromIM r7, UserCreation r8, Function4<? super Integer, ? super String, ? super Long, ? super Boolean, Unit> r9, Function0<Unit> r10, Function1<? super Continuation<? super String>, ? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r2, "downloadTaskKey");
        Intrinsics.checkNotNullParameter(r4, "scope");
    }

    public final boolean h() {
        return false;
    }

    public final void i() {
    }

    public final q97.a k() {
        return null;
    }

    public final Object m(Context r1, Bitmap r2, String r3, Continuation<? super File> r4) {
        return null;
    }

    public final void n() {
    }

    public final void o(com.larus.uaigc.creation.f r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
    }

    public final ey9.k p() {
        return null;
    }

    public final ey9.a q() {
        return null;
    }

    public final void r(Activity r1) {
    }

    public final Map<String, String> s(UserCreationFromIM r1, String r2) {
        return null;
    }

    public final com.larus.uaigc.utils.a t() {
        return null;
    }

    public final List<ey9.k> u() {
        return null;
    }

    public final boolean v() {
        return false;
    }

    public final void w(Context r1, n1 r2, JSONObject r3, Integer r4, CoroutineScope r5, CommonDownLoadLayout r6, String r7) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r3, "reportParams");
        Intrinsics.checkNotNullParameter(r5, "mainScope");
        Intrinsics.checkNotNullParameter(r6, "rootView");
    }

    public final void x(hy9.f r2, ImageEditDataWithMask r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "imageEditDataWithMask");
    }

    public final void y() {
    }

    public final xy9.b E() {
        return new b();
    }

    public final q97.a a() {
        return new a();
    }

    public final hy9.d j() {
        return new c();
    }

    public final DialogFragment R(dy9.a r2) {
        Intrinsics.checkNotNullParameter(r2, "model");
        return new DialogFragment();
    }

    public final kh8.a V(LifecycleCoroutineScope r2) {
        Intrinsics.checkNotNullParameter(r2, "viewModelScope");
        return new n();
    }

    public final Object l(Continuation<? super Map<String, ? extends Object>> r1) {
        return MapsKt.emptyMap();
    }

    public final DialogFragment z(Function3 r1, String r2, String r3, String r4) {
        return new DialogFragment();
    }
}
