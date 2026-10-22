package com.larus.bmhome.chat.component.bottom.attachment;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.chat.adapter.MessageModifyMode;
import com.larus.bmhome.chat.api.ChatApi;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.attachment.entity.AttachmentPanelType;
import com.larus.bmhome.chat.component.bottom.core.CoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.g9;
import com.larus.bmhome.chat.component.bottom.core.k9;
import com.larus.bmhome.chat.component.bottom.multimodal.upload.FileUploader;
import com.larus.bmhome.chat.component.bottom.multimodal.upload.SharedAlbumUploadCoordinator;
import com.larus.bmhome.chat.component.bottom.p1;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.chat.model.j1;
import com.larus.bmhome.chat.o4;
import com.larus.bmhome.chat.picture.LocalTakePictureImpl;
import com.larus.bmhome.metadata.ExifInterface2;
import com.larus.bmhome.nestedfile.INestedFileCacheManagerService;
import com.larus.bmhome.nestedfile.NestedFileCacheManagerService;
import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.upload.ResourceUploader;
import com.larus.bmhome.utils.FileMimeTypeUtils;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.bmhome.view.g2;
import com.larus.bmhome.view.menu.CreateMenu;
import com.larus.bmhome.view.resourcebar.bean.Mode;
import com.larus.bmhome.view.resourcebar.bean.ResourceBarConfig;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder;
import com.larus.chat.gallery.api.IChatGalleryService;
import com.larus.chat.gallery.api.PreviewMediaType;
import com.larus.chat.gallery.api.PreviewScene;
import com.larus.chat.gallery.api.PreviewSendFailureReason;
import com.larus.chat.gallery.api.SelectResultReason;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotConfItem;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.FileParseState;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.FileType;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.VideoExtension;
import com.larus.platform.model.UploadUiStyle;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.model.action.SuggestedActionScene;
import com.larus.platform.model.chat.UploadFilePolicy;
import com.larus.platform.model.preview.AttachmentEditState;
import com.larus.platform.model.preview.AttachmentEditType;
import com.larus.platform.model.preview.AttachmentSnapshot;
import com.larus.platform.model.preview.MediaEntry;
import com.larus.platform.model.preview.MediaEntryScene;
import com.larus.platform.model.preview.ResourceRef;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.FlowDriveSdkService;
import com.larus.platform.service.b3;
import com.larus.platform.service.d3;
import com.larus.platform.service.z2;
import com.larus.trace.audioattachment.AudioAttachmentUploadEvent;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.SafeExtKt;
import com.larus.utils.logger.FLogger;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import v19.c7;
import v19.i5;
import v19.m5;
import yc9.l1;
import yc9.n1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000Ê\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0016\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0016\u0018\u0000 Þ\u00032\u00060\u0001j\u0002`\u00022\u00020\u00032\u00020\u0004:\u0006Þ\u0003ß\u0003à\u0003B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u0095\u0001\u001a\u00020yH\u0002J\u0012\u0010\u0096\u0001\u001a\u00020V2\u0007\u0010\u0097\u0001\u001a\u00020cH\u0002J\u0016\u0010\u0098\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020h0g0\u0099\u0001H\u0016J\u0016\u0010\u009a\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020h0g0\u0099\u0001H\u0016J\u0010\u0010\u009b\u0001\u001a\t\u0012\u0004\u0012\u00020P0\u0099\u0001H\u0016J\u0016\u0010\u009c\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020h0g0\u0099\u0001H\u0016J\t\u0010Ã\u0001\u001a\u00020yH\u0016J\u0012\u0010Ä\u0001\u001a\u00020P2\u0007\u0010\u0097\u0001\u001a\u00020cH\u0002J\u0019\u0010Å\u0001\u001a\u00020y2\u0007\u0010\u0097\u0001\u001a\u00020cH\u0082@¢\u0006\u0003\u0010Æ\u0001J\u001f\u0010Ç\u0001\u001a\u00020y2\r\u0010È\u0001\u001a\b\u0012\u0004\u0012\u00020c0gH\u0082@¢\u0006\u0003\u0010É\u0001J\u001f\u0010Ê\u0001\u001a\u00020y2\r\u0010Ë\u0001\u001a\b\u0012\u0004\u0012\u00020V0gH\u0082@¢\u0006\u0003\u0010É\u0001J,\u0010Ì\u0001\u001a\u00020y2\u001a\u0010Í\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020V\u0012\u0004\u0012\u00020V0³\u00010gH\u0082@¢\u0006\u0003\u0010É\u0001J\"\u0010Î\u0001\u001a\u000f\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020Z0³\u00012\n\u0010Ï\u0001\u001a\u0005\u0018\u00010¾\u0001H\u0002J\t\u0010Ð\u0001\u001a\u00020PH\u0002J\t\u0010Ñ\u0001\u001a\u00020PH\u0002J\t\u0010Ò\u0001\u001a\u00020PH\u0002J\t\u0010Ó\u0001\u001a\u00020PH\u0002J\u001b\u0010Ô\u0001\u001a\u00020P2\u0007\u0010Õ\u0001\u001a\u00020V2\u0007\u0010Ö\u0001\u001a\u00020VH\u0002J\u0012\u0010×\u0001\u001a\u00020V2\u0007\u0010Ø\u0001\u001a\u00020ZH\u0002J\u0015\u0010Ù\u0001\u001a\u0005\u0018\u00010¾\u00012\u0007\u0010Ú\u0001\u001a\u00020VH\u0016J\u0012\u0010Û\u0001\u001a\u00020y2\u0007\u0010Ú\u0001\u001a\u00020VH\u0016J\t\u0010\u009e\u0001\u001a\u00020PH\u0016J*\u0010Ü\u0001\u001a\u00020\u007f2\r\u0010È\u0001\u001a\b\u0012\u0004\u0012\u00020c0g2\u0007\u0010Ý\u0001\u001a\u00020P2\u0007\u0010Þ\u0001\u001a\u00020VH\u0016J\r\u0010ß\u0001\u001a\u00020c*\u00020cH\u0002J\r\u0010à\u0001\u001a\u00020c*\u00020cH\u0002J\r\u0010á\u0001\u001a\u00020P*\u00020cH\u0002J\r\u0010â\u0001\u001a\u00020P*\u00020cH\u0002J\u001b\u0010ã\u0001\u001a\u00020y2\u0007\u0010\u0097\u0001\u001a\u00020c2\u0007\u0010ä\u0001\u001a\u00020VH\u0002J\u0012\u0010å\u0001\u001a\u00020P2\u0007\u0010\u0097\u0001\u001a\u00020cH\u0002J\t\u0010æ\u0001\u001a\u00020PH\u0016J\u0012\u0010ç\u0001\u001a\u00020y2\u0007\u0010è\u0001\u001a\u00020PH\u0016J\t\u0010é\u0001\u001a\u00020PH\u0016J\t\u0010ê\u0001\u001a\u00020yH\u0016J\t\u0010ë\u0001\u001a\u00020PH\u0016J\t\u0010ì\u0001\u001a\u00020yH\u0016J\t\u0010í\u0001\u001a\u00020yH\u0016J\u0013\u0010î\u0001\u001a\u00020y2\b\u0010ï\u0001\u001a\u00030ð\u0001H\u0016J\t\u0010ñ\u0001\u001a\u00020yH\u0002J\t\u0010ò\u0001\u001a\u00020yH\u0002J\u0012\u0010ó\u0001\u001a\u00020y2\u0007\u0010ô\u0001\u001a\u00020PH\u0002J\t\u0010õ\u0001\u001a\u00020yH\u0016J\n\u0010ö\u0001\u001a\u00030÷\u0001H\u0016J$\u0010ø\u0001\u001a\u00020y2\u0019\u0010ù\u0001\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020x0g\u0012\u0004\u0012\u00020y0wH\u0016J$\u0010ú\u0001\u001a\u00020y2\u0019\u0010ù\u0001\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020x0g\u0012\u0004\u0012\u00020y0wH\u0016J\u0013\u0010û\u0001\u001a\u00020P2\b\u0010ü\u0001\u001a\u00030ý\u0001H\u0016J\u0018\u0010þ\u0001\u001a\u00020y2\r\u0010È\u0001\u001a\b\u0012\u0004\u0012\u00020c0gH\u0002J(\u0010ÿ\u0001\u001a\u00020P2\u0007\u0010\u0080\u0002\u001a\u00020V2\u0007\u0010\u0081\u0002\u001a\u00020x2\u000b\b\u0002\u0010\u0082\u0002\u001a\u0004\u0018\u00010VH\u0002J\u001b\u0010\u0083\u0002\u001a\u00020P2\u0007\u0010\u0084\u0002\u001a\u00020c2\u0007\u0010\u0085\u0002\u001a\u00020PH\u0002J\u0013\u0010\u0086\u0002\u001a\u00020P2\b\u0010ö\u0001\u001a\u00030÷\u0001H\u0016J\u0091\u0001\u0010\u0087\u0002\u001a\u00020P2\u0007\u0010\u0088\u0002\u001a\u00020\n2\u0007\u0010\u0089\u0002\u001a\u00020\u00102\u0007\u0010\u008a\u0002\u001a\u00020V2\f\b\u0002\u0010\u008b\u0002\u001a\u0005\u0018\u00010\u008c\u00022\u000b\b\u0002\u0010\u008d\u0002\u001a\u0004\u0018\u00010V2\u0018\b\u0002\u0010\u008e\u0002\u001a\u0011\u0012\u0004\u0012\u00020V\u0012\u0004\u0012\u00020V\u0018\u00010\u008f\u00022\u001a\b\u0002\u0010\u0090\u0002\u001a\u0013\u0012\u0004\u0012\u00020V\u0012\u0006\u0012\u0004\u0018\u00010V\u0018\u00010\u008f\u00022\u001a\b\u0002\u0010\u0091\u0002\u001a\u0013\u0012\u0004\u0012\u00020V\u0012\u0006\u0012\u0004\u0018\u00010V\u0018\u00010\u008f\u0002H\u0002J\t\u0010\u0092\u0002\u001a\u00020yH\u0016J.\u0010\u0093\u0002\u001a\u00020y2\u0007\u0010\u0097\u0001\u001a\u00020c2\t\u0010\u0094\u0002\u001a\u0004\u0018\u00010P2\t\u0010\u0095\u0002\u001a\u0004\u0018\u00010PH\u0002¢\u0006\u0003\u0010\u0096\u0002J¯\u0001\u0010\u0097\u0002\u001a\u00020P2\r\u0010\u0098\u0002\u001a\b\u0012\u0004\u0012\u00020c0b2\u0007\u0010\u0099\u0002\u001a\u00020P2\u0007\u0010Þ\u0001\u001a\u00020V2\t\u0010\u009a\u0002\u001a\u0004\u0018\u00010V2\t\u0010\u009b\u0002\u001a\u0004\u0018\u00010V2\t\u0010\u009c\u0002\u001a\u0004\u0018\u00010V2\t\u0010\u009d\u0002\u001a\u0004\u0018\u00010V2\u0007\u0010\u009e\u0002\u001a\u00020V2\u0007\u0010\u009f\u0002\u001a\u00020P2\t\u0010 \u0002\u001a\u0004\u0018\u00010V2\t\u0010¡\u0002\u001a\u0004\u0018\u00010V2\u0007\u0010¢\u0002\u001a\u00020P2\t\u0010£\u0002\u001a\u0004\u0018\u00010V2\t\u0010¤\u0002\u001a\u0004\u0018\u00010V2\n\u0010¥\u0002\u001a\u0005\u0018\u00010¦\u0002H\u0016¢\u0006\u0003\u0010§\u0002J!\u0010¨\u0002\u001a\u0005\u0018\u00010¢\u00012\u0007\u0010\u0097\u0001\u001a\u00020c2\n\u0010©\u0002\u001a\u0005\u0018\u00010¢\u0001H\u0002J\u0015\u0010ª\u0002\u001a\u0005\u0018\u00010¢\u00012\u0007\u0010«\u0002\u001a\u00020VH\u0002J\u000e\u0010¬\u0002\u001a\u00030\u00ad\u0002*\u00020VH\u0002J,\u0010®\u0002\u001a\u00020Z2\r\u0010\u0098\u0002\u001a\b\u0012\u0004\u0012\u00020c0b2\u0007\u0010\u0099\u0002\u001a\u00020P2\t\b\u0002\u0010\u009f\u0002\u001a\u00020PH\u0002J\u0012\u0010¯\u0002\u001a\u00020P2\u0007\u0010\u0097\u0001\u001a\u00020cH\u0002J\t\u0010°\u0002\u001a\u00020PH\u0016J\b\u0010T\u001a\u00020PH\u0016J\t\u0010±\u0002\u001a\u00020VH\u0016J\u000b\u0010²\u0002\u001a\u0004\u0018\u00010VH\u0016J\n\u0010X\u001a\u0004\u0018\u00010VH\u0016J\n\u0010Y\u001a\u0004\u0018\u00010ZH\u0016J\u000f\u0010³\u0002\u001a\b\u0012\u0004\u0012\u00020c0gH\u0017J\u0012\u0010´\u0002\u001a\u00020y2\u0007\u0010\u0097\u0001\u001a\u00020cH\u0016J\u0012\u0010µ\u0002\u001a\u00020y2\u0007\u0010\u0097\u0001\u001a\u00020cH\u0016J\u0012\u0010¶\u0002\u001a\u00020y2\u0007\u0010·\u0002\u001a\u00020PH\u0016J\u0012\u0010¸\u0002\u001a\u00020y2\u0007\u0010¹\u0002\u001a\u00020PH\u0016J\u0012\u0010º\u0002\u001a\u00020y2\u0007\u0010\u0097\u0001\u001a\u00020cH\u0002J\"\u0010»\u0002\u001a\u0011\u0012\u0004\u0012\u00020\u007f\u0012\u0004\u0012\u00020\u007f\u0018\u00010³\u00012\b\u0010¼\u0002\u001a\u00030½\u0002H\u0002J\u0013\u0010¾\u0002\u001a\u00020P2\b\u0010¼\u0002\u001a\u00030½\u0002H\u0002J\u001b\u0010¿\u0002\u001a\u0004\u0018\u00010\u007f2\b\u0010¼\u0002\u001a\u00030½\u0002H\u0002¢\u0006\u0003\u0010À\u0002J\u0012\u0010Á\u0002\u001a\u00020y2\u0007\u0010\u0097\u0001\u001a\u00020cH\u0016J,\u0010Â\u0002\u001a\u00020y2\u000f\u0010È\u0001\u001a\n\u0012\u0004\u0012\u00020c\u0018\u00010g2\u0007\u0010Ã\u0002\u001a\u00020P2\u0007\u0010Ä\u0002\u001a\u00020PH\u0016J>\u0010Å\u0002\u001a\u00020y2\u0007\u0010Æ\u0002\u001a\u00020c2\t\b\u0002\u0010ä\u0001\u001a\u00020V2\t\b\u0002\u0010Ã\u0002\u001a\u00020P2\t\b\u0002\u0010Ä\u0002\u001a\u00020P2\t\b\u0002\u0010\u0085\u0002\u001a\u00020PH\u0002J\u0015\u0010Ç\u0002\u001a\u00020y2\n\u0010¼\u0002\u001a\u0005\u0018\u00010½\u0002H\u0016J\u001e\u0010È\u0002\u001a\u00020\u007f2\u0013\u0010É\u0002\u001a\u000e\u0012\u0004\u0012\u00020c\u0012\u0004\u0012\u00020P0wH\u0016J\t\u0010Ê\u0002\u001a\u00020PH\u0016J\u0012\u0010Ì\u0002\u001a\u00020y2\u0007\u0010Í\u0002\u001a\u00020PH\u0016J\b\u0010m\u001a\u00020VH\u0016J\u0011\u0010Î\u0002\u001a\u00020y2\u0006\u0010_\u001a\u00020PH\u0016J\u0012\u0010Ï\u0002\u001a\u00020y2\u0007\u0010Ð\u0002\u001a\u00020PH\u0016J\t\u0010Ñ\u0002\u001a\u00020yH\u0002J\t\u0010Ò\u0002\u001a\u00020yH\u0016J\t\u0010Ó\u0002\u001a\u00020VH\u0002J\f\u0010Ô\u0002\u001a\u0005\u0018\u00010Õ\u0002H\u0002J\f\u0010Ö\u0002\u001a\u0005\u0018\u00010×\u0002H\u0002J\t\u0010Ø\u0002\u001a\u00020yH\u0002J\u0014\u0010Ù\u0002\u001a\u0004\u0018\u00010|2\u0007\u0010Ú\u0002\u001a\u00020VH\u0002J\u0012\u0010Û\u0002\u001a\u00020y2\u0007\u0010Ü\u0002\u001a\u00020|H\u0002J\u0012\u0010Ý\u0002\u001a\u00020y2\u0007\u0010Ú\u0002\u001a\u00020VH\u0002J\u0012\u0010Ý\u0002\u001a\u00020y2\u0007\u0010\u0097\u0001\u001a\u00020cH\u0002J\u0012\u0010´\u0002\u001a\u00020y2\u0007\u0010Ü\u0002\u001a\u00020|H\u0002J$\u0010Þ\u0002\u001a\u00020y2\u0019\u0010ß\u0002\u001a\u0014\u0012\u0004\u0012\u00020|0à\u0002j\t\u0012\u0004\u0012\u00020|`á\u0002H\u0002JÛ\u0001\u0010â\u0002\u001a\u00020P2\r\u0010ã\u0002\u001a\b\u0012\u0004\u0012\u00020|0g2£\u0001\u0010ä\u0002\u001a\u009d\u0001\u0012\u0004\u0012\u00020\u007f\u0012C\u0012A\u0012\u0017\u0012\u00150\u0081\u0001¢\u0006\u000f\b\u0082\u0001\u0012\n\b\u0083\u0001\u0012\u0005\b\b(\u0084\u0001\u0012\u0017\u0012\u00150\u0085\u0001¢\u0006\u000f\b\u0082\u0001\u0012\n\b\u0083\u0001\u0012\u0005\b\b(\u0086\u0001\u0012\u0005\u0012\u00030\u0087\u00010\u0080\u0001j\u0003`\u0088\u00010~jN\u0012\u0004\u0012\u00020\u007f\u0012C\u0012A\u0012\u0017\u0012\u00150\u0081\u0001¢\u0006\u000f\b\u0082\u0001\u0012\n\b\u0083\u0001\u0012\u0005\b\b(\u0084\u0001\u0012\u0017\u0012\u00150\u0085\u0001¢\u0006\u000f\b\u0082\u0001\u0012\n\b\u0083\u0001\u0012\u0005\b\b(\u0086\u0001\u0012\u0005\u0012\u00030\u0087\u00010\u0080\u0001j\u0003`\u0088\u0001`\u0089\u00012\u0007\u0010Þ\u0001\u001a\u00020V2\t\u0010\u009a\u0002\u001a\u0004\u0018\u00010V2\u0007\u0010\u009b\u0002\u001a\u00020VH\u0016J\t\u0010å\u0002\u001a\u00020yH\u0016J6\u0010æ\u0002\u001a\u0014\u0012\u0004\u0012\u00020|0à\u0002j\t\u0012\u0004\u0012\u00020|`á\u00022\u0019\u0010ã\u0002\u001a\u0014\u0012\u0004\u0012\u00020|0à\u0002j\t\u0012\u0004\u0012\u00020|`á\u0002H\u0002J\u001b\u0010ç\u0002\u001a\u0014\u0012\u0004\u0012\u00020|0à\u0002j\t\u0012\u0004\u0012\u00020|`á\u0002H\u0002J\t\u0010è\u0002\u001a\u00020yH\u0002J\u0012\u0010é\u0002\u001a\u00020y2\u0007\u0010ê\u0002\u001a\u00020PH\u0016J\t\u0010ë\u0002\u001a\u00020yH\u0002J\u0012\u0010ì\u0002\u001a\u00020y2\u0007\u0010í\u0002\u001a\u00020PH\u0002J\f\u0010î\u0002\u001a\u0005\u0018\u00010ï\u0002H\u0002J\u000f\u0010ð\u0002\u001a\u00030ï\u0002*\u00030ï\u0002H\u0002JS\u0010ñ\u0002\u001a\u00020y2\u0007\u0010±\u0002\u001a\u00020V2\u0007\u0010ò\u0002\u001a\u00020P2\u0007\u0010ó\u0002\u001a\u00020P2\u0007\u0010Þ\u0001\u001a\u00020V2\u0006\u0010Y\u001a\u00020Z2\t\u0010\u009a\u0002\u001a\u0004\u0018\u00010V2\u0007\u0010\u009b\u0002\u001a\u00020V2\b\u0010ô\u0002\u001a\u00030õ\u0002H\u0002J\t\u0010ö\u0002\u001a\u00020yH\u0002J\u0011\u0010÷\u0002\u001a\u00020P2\u0006\u0010Y\u001a\u00020ZH\u0002J\t\u0010ø\u0002\u001a\u00020PH\u0002J\t\u0010þ\u0002\u001a\u00020PH\u0002JQ\u0010ÿ\u0002\u001a\u00020y2\u0007\u0010ò\u0002\u001a\u00020P2\u0006\u0010Y\u001a\u00020Z2\u0007\u0010\u0099\u0002\u001a\u00020P2\u0007\u0010Þ\u0001\u001a\u00020V2\u000b\b\u0002\u0010\u009a\u0002\u001a\u0004\u0018\u00010V2\u000b\b\u0002\u0010\u009d\u0002\u001a\u0004\u0018\u00010V2\t\b\u0002\u0010\u009b\u0002\u001a\u00020VH\u0002J(\u0010\u0080\u0003\u001a\u00020y2\b\u0010\u0081\u0003\u001a\u00030\u0082\u00032\u0007\u0010\u0097\u0001\u001a\u00020c2\n\u0010\u0083\u0003\u001a\u0005\u0018\u00010\u0084\u0003H\u0002J\u0012\u0010\u0085\u0003\u001a\u00020y2\u0007\u0010\u0097\u0001\u001a\u00020cH\u0002J\u0012\u0010\u0086\u0003\u001a\u00020P2\u0007\u0010\u0097\u0001\u001a\u00020cH\u0002J\u000f\u0010\u0087\u0003\u001a\u00020V*\u0004\u0018\u00010VH\u0002J\u0012\u0010\u0088\u0003\u001a\u00020y2\u0007\u0010\u0089\u0003\u001a\u00020PH\u0016J\t\u0010\u008d\u0003\u001a\u00020yH\u0016J\t\u0010\u008e\u0003\u001a\u00020yH\u0016J\t\u0010\u008f\u0003\u001a\u00020yH\u0016J\t\u0010\u0090\u0003\u001a\u00020yH\u0002J\u0012\u0010\u0091\u0003\u001a\u00020y2\u0007\u0010\u008d\u0002\u001a\u00020VH\u0002J/\u0010\u0092\u0003\u001a\t\u0012\u0004\u0012\u00020y0\u0093\u00032\n\u0010\u0083\u0003\u001a\u0005\u0018\u00010\u0084\u00032\b\u0010\u0094\u0003\u001a\u00030\u0082\u0003H\u0002¢\u0006\u0006\b\u0095\u0003\u0010\u0096\u0003J5\u0010\u0097\u0003\u001a\t\u0012\u0004\u0012\u00020y0\u0093\u00032\u0007\u0010Ú\u0002\u001a\u00020V2\u0007\u0010\u0097\u0001\u001a\u00020c2\b\u0010\u0098\u0003\u001a\u00030ð\u0001H\u0002¢\u0006\u0006\b\u0099\u0003\u0010\u009a\u0003J\u0012\u0010\u009b\u0003\u001a\u00020P2\u0007\u0010\u009c\u0003\u001a\u00020cH\u0002J\t\u0010\u009d\u0003\u001a\u00020yH\u0002J\u0014\u0010\u009e\u0003\u001a\u0004\u0018\u00010V2\u0007\u0010\u0097\u0001\u001a\u00020cH\u0002J\u0010\u0010\u009f\u0003\u001a\t\u0012\u0005\u0012\u00030 \u00030gH\u0002J\u0012\u0010¡\u0003\u001a\u00020y2\u0007\u0010\u0097\u0001\u001a\u00020cH\u0002J\\\u0010¢\u0003\u001a\u00020y2\b\u0010£\u0003\u001a\u00030ð\u00012\u0007\u0010¤\u0003\u001a\u00020P2\t\b\u0002\u0010¥\u0003\u001a\u00020P2\u0012\b\u0002\u0010¦\u0003\u001a\u000b\u0012\u0005\u0012\u00030§\u0003\u0018\u00010g2\t\b\u0002\u0010¨\u0003\u001a\u00020P2\t\b\u0002\u0010©\u0003\u001a\u00020P2\t\b\u0002\u0010ª\u0003\u001a\u00020\u007fH\u0002J\u0010\u0010«\u0003\u001a\t\u0012\u0005\u0012\u00030§\u00030gH\u0002J\t\u0010¬\u0003\u001a\u00020yH\u0002J\t\u0010\u00ad\u0003\u001a\u00020PH\u0002J\u0012\u0010®\u0003\u001a\u00020y2\u0007\u0010ò\u0002\u001a\u00020PH\u0002J\t\u0010¯\u0003\u001a\u00020yH\u0002J\u0012\u0010°\u0003\u001a\u00020y2\u0007\u0010±\u0003\u001a\u00020\u007fH\u0002J\t\u0010²\u0003\u001a\u00020yH\u0002Jy\u0010³\u0003\u001a\u00030´\u00032\u0007\u0010µ\u0003\u001a\u00020P2\u0007\u0010\u0097\u0001\u001a\u00020c2\u0007\u0010Þ\u0001\u001a\u00020V2\u000b\b\u0002\u0010\u009a\u0002\u001a\u0004\u0018\u00010V2\u000b\b\u0002\u0010\u009b\u0002\u001a\u0004\u0018\u00010V2\u000b\b\u0002\u0010\u009c\u0002\u001a\u0004\u0018\u00010V2\u000b\b\u0002\u0010\u009d\u0002\u001a\u0004\u0018\u00010V2\u000b\b\u0002\u0010\u0094\u0002\u001a\u0004\u0018\u00010P2\u000b\b\u0002\u0010\u0095\u0002\u001a\u0004\u0018\u00010PH\u0002¢\u0006\u0003\u0010¶\u0003Jd\u0010·\u0003\u001a\u00030¸\u00032\u0007\u0010µ\u0003\u001a\u00020P2\u0007\u0010\u0097\u0001\u001a\u00020c2\u0007\u0010Þ\u0001\u001a\u00020V2\u000b\b\u0002\u0010\u009a\u0002\u001a\u0004\u0018\u00010V2\u000b\b\u0002\u0010\u009b\u0002\u001a\u0004\u0018\u00010V2\u000b\b\u0002\u0010\u009c\u0002\u001a\u0004\u0018\u00010V2\u000b\b\u0002\u0010\u009d\u0002\u001a\u0004\u0018\u00010V2\t\b\u0002\u0010ä\u0001\u001a\u00020VH\u0002J\u0018\u0010Ã\u0003\u001a\u0011\u0012\u0004\u0012\u00020V\u0012\u0004\u0012\u00020V\u0018\u00010\u008f\u0002H\u0016J\t\u0010È\u0003\u001a\u00020PH\u0002J\t\u0010É\u0003\u001a\u00020PH\u0002J\t\u0010Ê\u0003\u001a\u00020yH\u0002J\t\u0010Ë\u0003\u001a\u00020VH\u0002J\u001d\u0010Ì\u0003\u001a\u0005\u0018\u00010Å\u00032\u000f\u0010Í\u0003\u001a\n\u0012\u0004\u0012\u00020|\u0018\u00010gH\u0002J\u0018\u0010Î\u0003\u001a\u0005\u0018\u00010Ï\u00032\n\u0010\u008d\u0002\u001a\u0005\u0018\u00010Å\u0003H\u0002J&\u0010Ð\u0003\u001a\u00020y2\u0007\u0010µ\u0003\u001a\u00020P2\t\u0010\u009b\u0002\u001a\u0004\u0018\u00010V2\u0007\u0010Ñ\u0003\u001a\u00020PH\u0002J\u0014\u0010Ò\u0003\u001a\u00030Å\u00032\b\u0010\u008d\u0002\u001a\u00030Å\u0003H\u0002J\t\u0010Ó\u0003\u001a\u00020PH\u0002J\t\u0010Ô\u0003\u001a\u00020PH\u0002J\u001c\u0010Õ\u0003\u001a\u00020P2\u0011\b\u0002\u0010Í\u0003\u001a\n\u0012\u0004\u0012\u00020|\u0018\u00010gH\u0002J\u0013\u0010Ö\u0003\u001a\u00020\b2\b\u0010ï\u0001\u001a\u00030ð\u0001H\u0002J\f\u0010×\u0003\u001a\u0005\u0018\u00010\u0085\u0001H\u0016J\u0015\u0010Ø\u0003\u001a\u00020y2\n\u0010Ù\u0003\u001a\u0005\u0018\u00010 \u0001H\u0016J\u0015\u0010Ú\u0003\u001a\u00020y2\n\u0010©\u0002\u001a\u0005\u0018\u00010¢\u0001H\u0016J!\u0010Û\u0003\u001a\u00020y2\u0016\u0010É\u0002\u001a\u0011\u0012\u0005\u0012\u00030Å\u0003\u0012\u0004\u0012\u00020P\u0018\u00010wH\u0016J\"\u0010Ü\u0003\u001a\u00020y2\u0017\u0010Ý\u0003\u001a\u0012\u0012\u0005\u0012\u00030Å\u0003\u0012\u0005\u0012\u00030Å\u0003\u0018\u00010wH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u000e\u001a\u0004\b \u0010!R\u0016\u0010#\u001a\u0004\u0018\u00010$8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u001d\u0010'\u001a\u0004\u0018\u00010(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u000e\u001a\u0004\b)\u0010*R\u001d\u0010,\u001a\u0004\u0018\u00010-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u000e\u001a\u0004\b.\u0010/R\u001d\u00101\u001a\u0004\u0018\u0001028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u000e\u001a\u0004\b3\u00104R\u001d\u00106\u001a\u0004\u0018\u0001078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\u000e\u001a\u0004\b8\u00109R\u001d\u0010;\u001a\u0004\u0018\u00010<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\u000e\u001a\u0004\b=\u0010>R\u001d\u0010@\u001a\u0004\u0018\u00010A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\u000e\u001a\u0004\bB\u0010CR\u001d\u0010E\u001a\u0004\u0018\u00010F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010\u000e\u001a\u0004\bG\u0010HR\u001d\u0010J\u001a\u0004\u0018\u00010K8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010\u000e\u001a\u0004\bL\u0010MR\u000e\u0010O\u001a\u00020PX\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010Q\u001a\u00020P8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bR\u0010SR\u000e\u0010T\u001a\u00020PX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010W\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010X\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Y\u001a\u0004\u0018\u00010ZX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020PX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\\\u001a\u0004\u0018\u00010]X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020PX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020PX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020PX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010a\u001a\b\u0012\u0004\u0012\u00020c0b8\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\bd\u0010\u0006R\u001a\u0010e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020h0g0fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010i\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020h0g0fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010j\u001a\b\u0012\u0004\u0012\u00020P0fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010k\u001a\b\u0012\u0004\u0012\u00020c0bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010l\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020h0g0fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020VX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010n\u001a\u0004\u0018\u00010o8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\br\u0010\u000e\u001a\u0004\bp\u0010qR\u0010\u0010s\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010t\u001a\u0004\u0018\u00010uX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010v\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020x0g\u0012\u0004\u0012\u00020y0wX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010z\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010{\u001a\b\u0012\u0004\u0012\u00020|0gX\u0082\u000e¢\u0006\u0002\n\u0000Rª\u0001\u0010}\u001a\u009d\u0001\u0012\u0004\u0012\u00020\u007f\u0012C\u0012A\u0012\u0017\u0012\u00150\u0081\u0001¢\u0006\u000f\b\u0082\u0001\u0012\n\b\u0083\u0001\u0012\u0005\b\b(\u0084\u0001\u0012\u0017\u0012\u00150\u0085\u0001¢\u0006\u000f\b\u0082\u0001\u0012\n\b\u0083\u0001\u0012\u0005\b\b(\u0086\u0001\u0012\u0005\u0012\u00030\u0087\u00010\u0080\u0001j\u0003`\u0088\u00010~jN\u0012\u0004\u0012\u00020\u007f\u0012C\u0012A\u0012\u0017\u0012\u00150\u0081\u0001¢\u0006\u000f\b\u0082\u0001\u0012\n\b\u0083\u0001\u0012\u0005\b\b(\u0084\u0001\u0012\u0017\u0012\u00150\u0085\u0001¢\u0006\u000f\b\u0082\u0001\u0012\n\b\u0083\u0001\u0012\u0005\b\b(\u0086\u0001\u0012\u0005\u0012\u00030\u0087\u00010\u0080\u0001j\u0003`\u0088\u0001`\u0089\u0001X\u0082\u000e¢\u0006\u0002\n\u0000RE\u0010\u008a\u0001\u001a8\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020x0g\u0012\u0004\u0012\u00020y0w0\u008b\u0001j\u001b\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020x0g\u0012\u0004\u0012\u00020y0w`\u008c\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u008d\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020y0\u008f\u00010\u008e\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0090\u0001\u001a\u000f\u0012\u0004\u0012\u00020V\u0012\u0004\u0012\u00020V0\u0091\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0094\u0001\u001a\u00020PX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u009d\u0001\u001a\u00020PX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u009e\u0001\u001a\u00020PX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u009f\u0001\u001a\u0005\u0018\u00010 \u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010¡\u0001\u001a\u0005\u0018\u00010¢\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010£\u0001\u001a\u0010\u0012\u0004\u0012\u00020V\u0012\u0005\u0012\u00030¥\u00010¤\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010¦\u0001\u001a\u00030§\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bª\u0001\u0010\u000e\u001a\u0006\b¨\u0001\u0010©\u0001R.\u0010«\u0001\u001a\u0011\u0012\u0006\u0012\u0004\u0018\u00010V\u0012\u0004\u0012\u00020P0\u0091\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b®\u0001\u0010\u000e\u001a\u0006\b¬\u0001\u0010\u00ad\u0001R8\u0010¯\u0001\u001a+\u0012\r\u0012\u000b °\u0001*\u0004\u0018\u00010V0V °\u0001*\u0014\u0012\r\u0012\u000b °\u0001*\u0004\u0018\u00010V0V\u0018\u00010±\u00010\u008e\u0001X\u0082\u0004¢\u0006\u0002\n\u0000Rl\u0010²\u0001\u001a_\u0012'\u0012%\u0012\u0004\u0012\u00020V\u0012\u0004\u0012\u00020V °\u0001*\u0011\u0012\u0004\u0012\u00020V\u0012\u0004\u0012\u00020V\u0018\u00010³\u00010³\u0001 °\u0001*.\u0012'\u0012%\u0012\u0004\u0012\u00020V\u0012\u0004\u0012\u00020V °\u0001*\u0011\u0012\u0004\u0012\u00020V\u0012\u0004\u0012\u00020V\u0018\u00010³\u00010³\u0001\u0018\u00010±\u00010\u008e\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010´\u0001\u001a\u0005\u0018\u00010\u0085\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bµ\u0001\u0010¶\u0001R4\u0010·\u0001\u001a\u0017\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030¹\u0001\u0012\u0004\u0012\u00020c0³\u00010¸\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b¼\u0001\u0010\u000e\u001a\u0006\bº\u0001\u0010»\u0001R)\u0010½\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010¾\u00010¸\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÀ\u0001\u0010\u000e\u001a\u0006\b¿\u0001\u0010»\u0001R\u0011\u0010Á\u0001\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010Â\u0001\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ë\u0002\u001a\u00020PX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010ù\u0002\u001a\u00030ú\u00028BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bý\u0002\u0010\u000e\u001a\u0006\bû\u0002\u0010ü\u0002R\u000f\u0010\u008a\u0003\u001a\u00020PX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u008b\u0003\u001a\u00020PX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u008c\u0003\u001a\u00020PX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010¹\u0003\u001a\u0005\u0018\u00010º\u00038BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b½\u0003\u0010\u000e\u001a\u0006\b»\u0003\u0010¼\u0003R \u0010¾\u0003\u001a\u00030¿\u00038BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÂ\u0003\u0010\u000e\u001a\u0006\bÀ\u0003\u0010Á\u0003R\u0012\u0010Ä\u0003\u001a\u0005\u0018\u00010Å\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010Æ\u0003\u001a\u0011\u0012\u0005\u0012\u00030Å\u0003\u0012\u0004\u0012\u00020P\u0018\u00010wX\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010Ç\u0003\u001a\u0012\u0012\u0005\u0012\u00030Å\u0003\u0012\u0005\u0012\u00030Å\u0003\u0018\u00010wX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006á\u0003"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/attachment/AttachmentPanelComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "Lcom/larus/bmhome/injectinput/IAlbumGroupInputAccessAbility;", "<init>", "()V", "resourceBarOperator", "Lcom/larus/bmhome/view/resourcebar/bean/IResourceItemOperator;", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "Lkotlin/Lazy;", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionInputAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionInputAbility$delegate", "referenceMsgAbility", "Lcom/larus/bmhome/chat/component/bottom/reference/IReferenceMsgAbility;", "getReferenceMsgAbility", "()Lcom/larus/bmhome/chat/component/bottom/reference/IReferenceMsgAbility;", "referenceMsgAbility$delegate", "multimodalAbility", "Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "getMultimodalAbility", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "multimodalAbility$delegate", "bottomMenuAbility", "Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "getBottomMenuAbility", "()Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "chatCameraAbility", "Lcom/larus/bmhome/camera/IChatCameraAbility;", "getChatCameraAbility", "()Lcom/larus/bmhome/camera/IChatCameraAbility;", "chatCameraAbility$delegate", "fastSendImageAbility", "Lcom/larus/bmhome/chat/component/fastsend/IFastSendImageAbility;", "getFastSendImageAbility", "()Lcom/larus/bmhome/chat/component/fastsend/IFastSendImageAbility;", "fastSendImageAbility$delegate", "injectInputAbility", "Lcom/larus/bmhome/injectinput/IInjectInputAbility;", "getInjectInputAbility", "()Lcom/larus/bmhome/injectinput/IInjectInputAbility;", "injectInputAbility$delegate", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "chatBottomCombineAbility", "Lcom/obric/assistant/ability/chat/bottom/IObricChatBottomAbility;", "getChatBottomCombineAbility", "()Lcom/obric/assistant/ability/chat/bottom/IObricChatBottomAbility;", "chatBottomCombineAbility$delegate", "chatBottomAbility", "Lcom/larus/bmhome/chat/component/bottom/IChatBottomAbility;", "getChatBottomAbility", "()Lcom/larus/bmhome/chat/component/bottom/IChatBottomAbility;", "chatBottomAbility$delegate", "chatDraft", "Lcom/larus/bmhome/chat/model/IChatDraft;", "getChatDraft", "()Lcom/larus/bmhome/chat/model/IChatDraft;", "chatDraft$delegate", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "isChatViewOptEnable", "", "enableLarkAudioAbility", "getEnableLarkAudioAbility", "()Z", "attachmentAllUploadSuccess", "attachmentFirstFromScene", "", "attachmentClickFrom", "attachmentEnterMethod", "attachmentPanelType", "Lcom/larus/bmhome/chat/component/bottom/attachment/entity/AttachmentPanelType;", "allowReadImageOrientation", "cacheInputTextHint", "", "attachmentMode", "isImageAttachment", "isModifyModeActive", "attachmentEntityList", "", "Lcom/larus/im/bean/message/UplinkFileEntity;", "getAttachmentEntityList$annotations", "_attachmentEntityListFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/larus/bmhome/chat/component/bottom/attachment/entity/ImmutableUplinkFileEntity;", "_displayAttachmentEntityListFlow", "_hasAttachmentDisplayFlow", "directSendAttachmentEntityList", "_directSendAttachmentEntityListFlow", "attachmentEntityLocalMsgId", "quickAlbumConnection", "Lcom/larus/bmhome/injectinput/QuickAlbumInputConnection;", "getQuickAlbumConnection", "()Lcom/larus/bmhome/injectinput/QuickAlbumInputConnection;", "quickAlbumConnection$delegate", "quickAlbumSource", "quickAlbumTextBinding", "Lcom/larus/bmhome/chat/component/bottom/core/QuickAlbumTextBinding;", "quickAlbumAttachmentsListener", "Lkotlin/Function1;", "Lcom/larus/platform/model/preview/AttachmentSnapshot;", "", "lastAttachmentEntitySummary", "customResourceBarItems", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceItemBean;", "customResourceBarRender", "Ljava/util/HashMap;", "", "Lkotlin/Function2;", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceBarConfig;", "Lkotlin/ParameterName;", "name", "config", "Landroid/view/ViewGroup;", "parent", "Lcom/larus/bmhome/view/resourcebar/viewholder/BaseResourceViewHolder;", "Lcom/larus/bmhome/view/resourcebar/bean/CustomResourceViewHolderBuilder;", "Lkotlin/collections/HashMap;", "attachmentPreviewSelectionListeners", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "attachmentPreviewImeRecoveries", "", "Lkotlin/Function0;", "attachmentPreviewImageUrls", "", "attachmentPreviewResolveJob", "Lkotlinx/coroutines/Job;", "forceDisableAlbumIntent", "notifyAttachmentListChanged", "entityCompareKey", "entity", "getAttachmentEntityListStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getDisplayAttachmentEntityListStateFlow", "getHasAttachmentDisplayStateFlow", "getDirectSendAttachmentEntityListStateFlow", "forceBanSuggestedAction", "isAppendingHistoryAttachments", "customUploader", "Lcom/larus/bmhome/chat/component/bottom/multimodal/upload/IFileUploader;", "uploadProcessConfig", "Lcom/larus/bmhome/uploadmedia/bean/ProcessConfig;", "uploadProcessConfigByFileIdentifier", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/larus/bmhome/chat/component/bottom/attachment/AttachmentPanelComponent$UploadProcessConfigSnapshot;", "takePictureHelper", "Lcom/larus/bmhome/chat/picture/LocalTakePictureImpl;", "getTakePictureHelper", "()Lcom/larus/bmhome/chat/picture/LocalTakePictureImpl;", "takePictureHelper$delegate", "uploadSuccessCache", "getUploadSuccessCache", "()Ljava/util/Map;", "uploadSuccessCache$delegate", "sharedAlbumUploadFileIdentifiers", "kotlin.jvm.PlatformType", "", "systemDraftRemovalKeys", "Lkotlin/Pair;", "resourceBarAttachmentHolder", "getResourceBarAttachmentHolder", "()Landroid/view/ViewGroup;", "fileEntityObserver", "Landroidx/lifecycle/Observer;", "Lcom/larus/bmhome/nestedfile/INestedFileCacheManagerService$FileEvent;", "getFileEntityObserver", "()Landroidx/lifecycle/Observer;", "fileEntityObserver$delegate", "nestedFileObserver", "Lcom/larus/im/bean/message/NestedFileContent;", "getNestedFileObserver", "nestedFileObserver$delegate", "preCvsId", "preDraftIdentity", "updateForChatDraft", "disableRemoteDelete", "deleteRemoteResource", "(Lcom/larus/im/bean/message/UplinkFileEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "batchDeleteRemoteResources", "entities", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteResourceByResourceId", "resourceIds", "deleteResourceByUri", "resources", "parseDraftNestedFile", "nestedFileContent", "enableSendImageMenuForDraft", "enableSendFileMenuForDraft", "isImageSupportMultiTakeForDraft", "isSupportMixTakeForDraft", "isCurrentBotConfEnabled", "groupKey", "confKey", "getDraftFromScene", "type", "getNestedFile", "localMsgID", "removeNestedFile", "appendHistoryAttachments", "showIme", "fromScene", "deepCopyForHistoryReuse", "copyForAttachmentProjection", "canRetryUpload", "hasReusableRemoteResource", "retryUploadAttachment", "localMsgId", "isHistoryDuplicate", "uploadFinish", "setAttachmentModeOnSpeak", "enable", "attachmentModeOnSpeak", "batchDeleteUploadedEntities", "readyToSend", "closeAttachmentPanel", "onReferenceMessageClosed", "onViewCreated", "view", "Landroid/view/View;", "renderQuickAlbumOwner", "registerPhotoEditResult", "tryUpdateAlbumEduIntentAfterFirstImageChanged", "firstImageChanged", "onAttach", "snapshot", "Lcom/larus/bmhome/injectinput/AlbumGroupInputSnapshot;", "addAttachmentChangedListener", "listener", "removeAttachmentChangedListener", "apply", "mutation", "Lcom/larus/bmhome/injectinput/AlbumGroupInputMutation;", "materializeAlbumPreviewAttachments", "replacePreviewAttachment", "originStableId", "edited", "originUri", "removeAlbumGroupAttachmentAtomically", "origin", "notifySelectionOwner", "send", "performSendAndConfirmHandoff", "inputAbility", "inputUIAbility", "content", "suggestedAction", "Lcom/larus/platform/model/action/SuggestedAction;", "scene", "messageExt", "", "fileForceTraceMap", "textForceTraceMap", "onDestroy", "handleUploadAndReplaceAttachment", "isImageMarked", "isImageCropped", "(Lcom/larus/im/bean/message/UplinkFileEntity;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "handleUploadAttachments", "entityList", "isFromFileBrowser", "clickFrom", "enterMethod", "isMultiChooseMode", "actionBarTemplateName", "enterMethodForSendMessage", "isFromDrive", "uploadTaskShareTag", "preferredLocalMsgId", "replaceCurrentDraft", "replacementText", "replacementToken", "userEditedAt", "", "(Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Z", "getUplinkFileEntityProcessConfig", "processConfig", "getUploadProcessConfig", "fileIdentifier", "messageSceneToResourceScene", "Lcom/larus/bmhome/rc/FlowResourceScene;", "getCurAttachmentPanelType", "isMediaFromFileBrowser", "enableUseAttachmentPanel", "attachmentLocalMsgId", "attachmentFromScene", "getAttachmentEntities", "addAttachmentEntity", "addDirectSendAttachmentEntity", "setAllowReadImageOrientation", "allow", "setForceDisableAlbumIntent", "forceDisable", "fillImageSizeForAttachmentEntity", "getImageSizeFromUri", "uri", "Landroid/net/Uri;", "needSwapImageSize", "readImageOrientation", "(Landroid/net/Uri;)Ljava/lang/Integer;", "updateAttachmentEntity", "removeAllAttachmentEntities", "removeFromDraft", "preventAsyncReinsert", "removeAttachmentEntityInternal", "entityToRemove", "removeAttachmentEntityFromUri", "sizeOfAttachmentEntities", "filter", "isVisible", "resourceBarVisibleBeforeInputPanel", "setHiddenByInputPanel", "hidden", "setImageAttachment", "setModifyModeActive", "active", "updateAttachmentPanelBackground", "onFragmentViewDestroyed", "conversationId", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "currentBot", "Lcom/larus/im/bean/bot/BotModel;", "removeAttachmentObserverIfNeeded", "getAttachmentEntity", "key", "refreshAttachmentEntity", "item", "removeAttachmentEntity", "refreshAttachmentPanel", "itemList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "showCustomResourceBarAttachments", "items", "customRender", "clearCustomResourceBarAttachments", "withCustomResourceItems", "buildAttachmentResourceItems", "clearCustomResourceBarState", "updateParseFailureDisplayPolicy", "isTaskMode", "syncUploadFileRuntimePolicy", "updateAttachmentAllUploadSuccess", "success", "getAttachmentPanelBgDrawable", "Landroid/graphics/drawable/Drawable;", "withImageAttachmentTint", "initAndShowAttachmentPanel", "isShowIme", "showAddItem", "callback", "Lcom/larus/bmhome/view/resourcebar/viewholder/BaseResourceViewHolder$Callback;", "hideAttachmentPanel", "shouldShowAddItem", "enableInjectedPhotoPickerAttachmentAddItem", "uploadUiStyle", "Lcom/larus/platform/model/UploadUiStyle;", "getUploadUiStyle", "()Lcom/larus/platform/model/UploadUiStyle;", "uploadUiStyle$delegate", "isBottomDriveEnabled", "showAttachmentPanel", "openAttachmentFileLegacy", "context", "Landroid/content/Context;", "fileInfo", "Lcom/larus/im/bean/message/UplinkFileInfo;", "tryHandleOpenLarkFile", "tryInterceptOfficeDocumentClick", "safeLogId", "adapterResourceBarToInstructionHolderWhenShowAttachmentPanel", "isForceAdapter", "isSpringScene", "banAdjust", "temporaryBanAdjust", "markResourceIsSpringScene", "banAdjustOtherViewsWhenAttachmentPanelHide", "banNextAdjustOtherViewsWhenAttachmentPanelHide", "adapterResourceBarToAttachmentHolderWhenHideAttachmentPanel", "gotoCamera", "onClickAudioItem", "Lkotlin/Result;", "cxt", "onClickAudioItem-gIAlu-s", "(Lcom/larus/im/bean/message/UplinkFileInfo;Landroid/content/Context;)Ljava/lang/Object;", "onClickImageItem", "v", "onClickImageItem-0E7RQCE", "(Ljava/lang/String;Lcom/larus/im/bean/message/UplinkFileEntity;Landroid/view/View;)Ljava/lang/Object;", "tryOpenAttachmentPreview", "selectedEntity", "releaseHostInputForAttachmentPreview", "attachmentPreviewImageUri", "getAttachmentPreviewItems", "Lcom/larus/chat/gallery/api/PreviewMediaItem;", "onClickVideoItem", "showMoreMenu", "anchor", "showFile", "showDrive", "allowDriveFileTypeList", "Lcom/larus/platform/api/FlowDriveFileType;", "hidePic", "hideAlbum", "currentSize", "getExistingAttachmentSelectedTypes", "checkAttachmentsUploadStatus", "getAttachmentAreaDisableByConf", "adjustOtherViewsWhenAttachmentPanelShow", "adjustOtherViewsWhenAttachmentPanelHide", "switchInputStatus", "status", "observeNestedFiles", "getEdittedImageCallback", "Lcom/larus/bmhome/chat/component/bottom/multimodal/upload/EdittedImageUploadCallback;", "isImage", "(ZLcom/larus/im/bean/message/UplinkFileEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/larus/bmhome/chat/component/bottom/multimodal/upload/EdittedImageUploadCallback;", "getAttachmentCallback", "Lcom/larus/bmhome/chat/component/bottom/multimodal/upload/CommonFileUploadCallback;", "suggestedActionAbility", "Lcom/larus/bmhome/chat/action/ISuggestedActionAbility;", "getSuggestedActionAbility", "()Lcom/larus/bmhome/chat/action/ISuggestedActionAbility;", "suggestedActionAbility$delegate", "albumEduIntentSuggestController", "Lcom/larus/bmhome/chat/component/bottom/attachment/AlbumEduIntentSuggestController;", "getAlbumEduIntentSuggestController", "()Lcom/larus/bmhome/chat/component/bottom/attachment/AlbumEduIntentSuggestController;", "albumEduIntentSuggestController$delegate", "currentAlbumEduSolveQuestionMessageExt", "suggestedActionScene", "Lcom/larus/platform/model/action/SuggestedActionScene;", "suggestedActionBizSceneFilter", "suggestedActionSceneMapper", "isSelectionBasedVideoSugEnabled", "isVideoSuggestedActionBanned", "tryBindSuggestedActionData", "currentSuggestedActionBizScene", "resolveAudioSuggestedActionScene", "data", "createAlbumEduIntentSuggestSnapshot", "Lcom/larus/bmhome/chat/component/bottom/attachment/AlbumEduIntentSuggestSnapshot;", "bindSingleSuggestedActionData", "isFromDraft", "mapSuggestedActionScene", "hasReferenceMsg", "banSugByReferenceMsg", "isActualImageFileMixedAttachment", "findInputAttachmentView", "obtainResourceBarAttachmentHolder", "setCustomUploader", "uploader", "setUploadProcessConfig", "setSuggestedActionBizSceneFilter", "setSuggestedActionSceneMapper", "mapper", "Companion", "UploadProcessConfigSnapshot", "AttachmentPreviewMediaSession", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public class AttachmentPanelComponent extends BaseContentWidget implements g1, op8.d {
    public static final /* synthetic */ int g2 = 0;
    public boolean A;
    public String B;
    public String C;
    public String D;
    public AttachmentPanelType E;
    public boolean F;
    public boolean G;
    public boolean G1;
    public boolean H;
    public boolean H0;
    public final Lazy H1;
    public boolean I;
    public final List<UplinkFileEntity> J;
    public final StateFlowImpl K;
    public final StateFlowImpl L;
    public boolean L0;
    public boolean L1;
    public final StateFlowImpl M;
    public boolean M1;
    public final List<UplinkFileEntity> N;
    public final StateFlowImpl O;
    public String P;
    public ns8.b P0;
    public boolean P1;
    public final Lazy Q;
    public final Lazy Q1;
    public op8.d R;
    public k9 S;
    public final Lazy S1;
    public final r0 T;
    public SuggestedActionScene T1;
    public String U;
    public List<ResourceItemBean> V;
    public final ConcurrentHashMap<String, c> V0;
    public Function1<? super SuggestedActionScene, Boolean> V1;
    public HashMap<Integer, Function2<ResourceBarConfig, ViewGroup, BaseResourceViewHolder>> W;
    public final LinkedHashSet<Function1<List<AttachmentSnapshot>, Unit>> X;
    public final Set<Function0<Unit>> Y;
    public final Map<String, String> Z;
    public final Lazy b1;
    public Function1<? super SuggestedActionScene, ? extends SuggestedActionScene> b2;
    public final Lazy g1;
    public final Set<String> h1;
    public Job k0;
    public final Set<Pair<String, String>> k1;
    public mt8.a m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public boolean p0;
    public final Lazy p1;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy v1;
    public final Lazy w;
    public final Lazy x;
    public String x1;
    public final Lazy y;
    public String y1;
    public final Lazy z;

    public final class a extends com.larus.chat.gallery.api.a {
        public Function0<Unit> c;
        public final /* synthetic */ AttachmentPanelComponent d;

        public final List<AttachmentSnapshot> Qa() {
            List<UplinkFileEntity> r0 = this.d.J;
            ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
            Iterator r2 = ((ArrayList) r0).iterator();
            int r3 = 0;
        L4:
            if (r2.hasNext() == false) goto L9;
            Object r4 = r2.next();
            int r5 = r3 + 1;
            if (r3 >= 0) goto L8;
            CollectionsKt.throwIndexOverflow();
        L8:
            r1.add(d1.e((UplinkFileEntity) r4, r3));
            r3 = r5;
            goto L4
        L9:
            return r1;
        }

        public final String a() {
            AttachmentPanelComponent r0 = this.d;
            int r1 = AttachmentPanelComponent.g2;
            va8.o r2 = r0.k4();
            if (r2 == null) goto L5;
            String r3 = r2.u7();
        L6:
            if (r3 != null) goto L9;
            return "";
        L9:
            return r3;
        L5:
            r3 = null;
            goto L6
        }

        public final List<com.larus.chat.gallery.api.o> d() {
            AttachmentPanelComponent r0 = this.d;
            int r1 = AttachmentPanelComponent.g2;
            return r0.j4();
        }

        public final boolean g() {
            AttachmentPanelComponent r0 = this.d;
            int r1 = AttachmentPanelComponent.g2;
            if (r0.l4() != null) goto L5;
        L7:
            return false;
        L5:
            if (this.d.k4() == null) goto L7;
            return true;
        }

        public final String o() {
            AttachmentPanelComponent r0 = this.d;
            int r1 = AttachmentPanelComponent.g2;
            de8.c r2 = r0.f1();
            if (r2 == null) goto L11;
            Bundle r3 = r2.b;
            if (r3 == null) goto L11;
            String r4 = r3.getString("inject_input_album_node_id");
            if (r4 == null) goto L11;
            if (kq9.b.c(r4) == false) goto L11;
            return r4;
        L11:
            return null;
        }

        public final void u() {
            AttachmentPanelComponent r0 = this.d;     // Catch: Throwable -> L5
            int r1 = AttachmentPanelComponent.g2;     // Catch: Throwable -> L5
            r0.E5();     // Catch: Throwable -> L5
            x();
            return;
        L5:
            th = move-exception;
            x();
            throw th;
        }

        public final void x() {
            Function0<Unit> r0 = this.c;
            if (r0 == null) goto L5;
            this.d.Y.remove(r0);
            r0.invoke();
        L5:
            this.c = null;
        }

        public final com.larus.chat.gallery.api.l getCapability() {
            boolean r6 = g();
            return new com.larus.chat.gallery.api.l(r6, true, true, true, true, r6, false, 64);
        }

        public final boolean Oa(String r4) {
            Intrinsics.checkNotNullParameter(r4, "itemKey");
            List<UplinkFileEntity> r0 = this.d.J;
            if ((r0 instanceof Collection) == true) goto L5;
        L7:
            Iterator<T> r1 = r0.iterator();
        L9:
            if (r1.hasNext() == false) goto L18;
            if (Intrinsics.areEqual(((UplinkFileEntity) r1.next()).getFileIdentifier(), r4) == false) goto L9;
            return true;
        L18:
            return false;
        L5:
            if (r0.isEmpty() == false) goto L7;
            return false;
        }

        public final void b(Function1<? super List<AttachmentSnapshot>, Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.d.X.remove(r2);
        }

        public final void f(Function1<? super List<AttachmentSnapshot>, Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.d.X.add(r2);
            r2.invoke(Qa());
        }

        public final com.larus.chat.gallery.api.v m(com.larus.chat.gallery.api.w r12) {
            Intrinsics.checkNotNullParameter(r12, "snapshot");
            AttachmentPanelComponent r0 = this.d;
            int r1 = AttachmentPanelComponent.g2;
            ICoreInputAbility r2 = r0.l4();
            va8.o r3 = this.d.k4();
            if (r2 == null) goto L27;
            if (r3 == null) goto L27;
            List<AttachmentSnapshot> r4 = Qa();
            ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
            Iterator r6 = ((ArrayList) r4).iterator();
        L8:
            if (r6.hasNext() == false) goto L10;
            r5.add(((AttachmentSnapshot) r6.next()).getStableId());
            goto L8
        L10:
            List r7 = r12.a;
            ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
            Iterator r9 = r7.iterator();
        L12:
            if (r9.hasNext() == false) goto L15;
            r8.add(((AttachmentSnapshot) r9.next()).getStableId());
            goto L12
        L15:
            if (Intrinsics.areEqual(r5, r8) == true) goto L18;
            int r13 = com.larus.chat.gallery.api.v.d;
            return com.larus.chat.gallery.api.v.a.a(PreviewSendFailureReason.NOT_SENDABLE);
        L18:
            ICoreInputAbility.b.d(r2, r12.b, false, false, null, null, false, 56);
            if (Intrinsics.areEqual(r3.u7(), r12.b) == true) goto L23;
            int r14 = com.larus.chat.gallery.api.v.d;
            return com.larus.chat.gallery.api.v.a.a(PreviewSendFailureReason.NOT_SENDABLE);
        L23:
            if (this.d.y5(r2, r3, r12.b, r12.c, r12.d, r12.e, r12.f, r12.g) == true) goto L31;
            int r15 = com.larus.chat.gallery.api.v.d;
            return com.larus.chat.gallery.api.v.a.a(PreviewSendFailureReason.NOT_SENDABLE);
        L31:
            return new com.larus.chat.gallery.api.v(true, null, 6);
        L27:
            int r16 = com.larus.chat.gallery.api.v.d;
            return com.larus.chat.gallery.api.v.a.a(PreviewSendFailureReason.HOST_UNAVAILABLE);
        }

        public final boolean q(com.larus.chat.gallery.api.r r11) {
            Intrinsics.checkNotNullParameter(r11, "mutation");
            if ((r11 instanceof com.larus.chat.gallery.api.r.a) == false) goto L127;
            List r12 = ((com.larus.chat.gallery.api.r.a) r11).a;
            List r0 = r12;
            ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
            Iterator r3 = r0.iterator();
        L6:
            if (r3.hasNext() == false) goto L8;
            r1.add(((AttachmentSnapshot) r3.next()).getStableId());
            goto L6
        L8:
            ArrayList r4 = new ArrayList();
            Iterator r2 = r0.iterator();
        L10:
            if (r2.hasNext() == false) goto L14;
            ResourceRef r5 = ((AttachmentSnapshot) r2.next()).effectiveRef();
            if (r5 == null) goto L10;
            r4.add(r5);
            goto L10
        L14:
            List<AttachmentSnapshot> r6 = Qa();
            ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
            Iterator r8 = ((ArrayList) r6).iterator();
        L16:
            if (r8.hasNext() == false) goto L18;
            r7.add(((AttachmentSnapshot) r8.next()).getStableId());
            goto L16
        L18:
            Set r9 = CollectionsKt.toSet(r7);
            if (r12.isEmpty() == false) goto L21;
        L124:
            FLogger.a.e("AttachmentPanelComponent", "AttachmentPreviewMediaSession append contains invalid delta");
            return false;
        L21:
            if (r1.isEmpty() == true) goto L29;
            Iterator r10 = r1.iterator();
        L25:
            if (r10.hasNext() == false) goto L29;
            if (StringsKt.isBlank((String) r10.next()) == false) goto L25;
            boolean r13 = true;
        L30:
            if (r13 == true) goto L124;
            if (r1.size() != CollectionsKt.distinct(r1).size()) goto L124;
            if (r4.size() != CollectionsKt.distinct(r4).size()) goto L124;
            if (r1.isEmpty() == true) goto L44;
            Iterator r14 = r1.iterator();
        L40:
            if (r14.hasNext() == false) goto L44;
            if (r9.contains((String) r14.next()) == false) goto L40;
            boolean r15 = true;
        L45:
            if (r15 == true) goto L124;
            List r16 = r12;
            ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
            Iterator r18 = r16.iterator();
        L49:
            if (r18.hasNext() == false) goto L51;
            r17.add(d1.f((AttachmentSnapshot) r18.next()));
            goto L49
        L51:
            AttachmentPanelComponent r19 = this.d;
            if (r17.isEmpty() == true) goto L66;
            Iterator r20 = r17.iterator();
        L56:
            if (r20.hasNext() == false) goto L66;
            UplinkFileEntity r21 = (UplinkFileEntity) r20.next();
            if (r21.getUplinkEntityContent() != null) goto L60;
        L63:
            boolean r22 = true;
        L64:
            if (r22 == false) goto L56;
            boolean r110 = true;
        L67:
            if (r110 == false) goto L71;
            FLogger.a.e("AttachmentPanelComponent", "AttachmentPreviewMediaSession append contains duplicate resource");
            return false;
        L71:
            if (r17.isEmpty() == true) goto L87;
            Iterator r111 = r17.iterator();
        L75:
            if (r111.hasNext() == false) goto L87;
            UplinkFileEntity r23 = (UplinkFileEntity) r111.next();
            if (n1.b(r23) == false) goto L79;
        L84:
            boolean r24 = true;
        L85:
            if (r24 == false) goto L75;
            boolean r112 = true;
        L89:
            if (r17.isEmpty() == true) goto L97;
            Iterator r25 = r17.iterator();
        L93:
            if (r25.hasNext() == false) goto L97;
            if (n1.b((UplinkFileEntity) r25.next()) == false) goto L93;
            boolean r26 = true;
        L98:
            com.larus.bmhome.chat.component.bottom.multimodal.g r27 = this.d.v4();
            if (r27 == null) goto L101;
            int r113 = r27.zv(r112, Boolean.valueOf(r26));
        L105:
            if ((((ArrayList) this.d.J).size() + r17.size()) <= r113) goto L108;
            FLogger.a.e("AttachmentPanelComponent", "AttachmentPreviewMediaSession append exceeds attachment limit");
            return false;
        L108:
            int r114 = this.d.uW(r17, false, "preview_child_flow");
            if (r114 == r17.size()) goto L123;
            ArrayList r28 = new ArrayList();
            Iterator r29 = r17.iterator();
        L112:
            if (r29.hasNext() == false) goto L116;
            String r30 = ((UplinkFileEntity) r29.next()).getFileIdentifier();
            if (r30 == null) goto L112;
            r28.add(r30);
            goto L112
        L116:
            Set r31 = CollectionsKt.toSet(r28);
            AttachmentPanelComponent r32 = this.d;
            List<UplinkFileEntity> r33 = r32.J;
            ArrayList r34 = new ArrayList();
            Iterator r35 = ((ArrayList) r33).iterator();
        L118:
            if (r35.hasNext() == false) goto L122;
            Object r36 = r35.next();
            if (CollectionsKt.contains(r31, ((UplinkFileEntity) r36).getFileIdentifier()) == false) goto L118;
            r34.add(r36);
            goto L118
        L122:
            g1.a.a(r32, r34, 6);
            FLogger.a.e("AttachmentPanelComponent", "AttachmentPreviewMediaSession append partial " + r114 + '/' + r17.size());
            return false;
        L123:
            return true;
        L101:
            if (r112 == false) goto L103;
            ImFileUtil.a.getClass();
            r113 = ImFileUtil.l();
            goto L105
        L103:
            ImFileUtil.a.getClass();
            r113 = ImFileUtil.n();
        L97:
            r26 = false;
            goto L98
        L79:
            if (n1.a(r23) == true) goto L84;
            if (n1.e(r23) == true) goto L84;
            r24 = false;
        L87:
            r112 = false;
            goto L89
        L60:
            if (r19.d5(r21) == true) goto L63;
            r22 = false;
        L66:
            r110 = false;
        L44:
            r15 = false;
        L29:
            r13 = false;
            goto L30
        L127:
            if ((r11 instanceof com.larus.chat.gallery.api.r.b) == false) goto L131;
            AttachmentPanelComponent r37 = this.d;
            com.larus.chat.gallery.api.r.b r115 = (com.larus.chat.gallery.api.r.b) r11;
            String r38 = r115.a;
            AttachmentSnapshot r116 = r115.b;
            int r39 = AttachmentPanelComponent.g2;
            return r37.T5(r38, r116, null);
        L131:
            throw new NoWhenBranchMatchedException();
        }

        public final boolean s(String r11) {
            Intrinsics.checkNotNullParameter(r11, ChatDraftItem.TYPE_TEXT);
            AttachmentPanelComponent r0 = this.d;
            int r1 = AttachmentPanelComponent.g2;
            ICoreInputAbility r2 = r0.l4();
            if (r2 != null) goto L6;
            return false;
        L6:
            ICoreInputAbility.b.d(r2, r11, false, false, null, null, false, 56);
            return true;
        }

        public final boolean t(String r3) {
            Intrinsics.checkNotNullParameter(r3, "itemKey");
            if (Oa(r3) == true) goto L6;
            return false;
        L6:
            NestedFileCacheManagerService.b.b(this.d.P, r3);
            return true;
        }

        public a(AttachmentPanelComponent r1, com.larus.bmhome.view.t r2) {
            this.d = r1;
            this.c = r2;
        }

        public final com.larus.chat.gallery.api.a0 Pa(String r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r4, "itemKey");
            if (r5 == false) goto L7;
            int r6 = com.larus.chat.gallery.api.a0.d;
            return com.larus.chat.gallery.api.a0.a.a(Oa(r4), SelectResultReason.NOT_SUPPORTED);
        L7:
            if (Oa(r4) == false) goto L9;
            NestedFileCacheManagerService.b.b(this.d.P, r4);
            return new com.larus.chat.gallery.api.a0(true, false, SelectResultReason.OK);
        L9:
            return new com.larus.chat.gallery.api.a0(true, false, SelectResultReason.OK);
        }
    }

    public static final class b {
    }

    public static final class c {
        public final ns8.b a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((c) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            ns8.b r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "UploadProcessConfigSnapshot(processConfig=" + this.a + ')';
        }

        public c(ns8.b r1) {
            this.a = r1;
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[INestedFileCacheManagerService.FileEvent.values().length];
            r0[INestedFileCacheManagerService.FileEvent.INSERT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L26:
            r0[INestedFileCacheManagerService.FileEvent.REMOVE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L34:
            r0[INestedFileCacheManagerService.FileEvent.UPDATE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L8:
            a = r0;
            int[] r1 = new int[AttachmentPanelType.values().length];
            r1[AttachmentPanelType.SingleImage.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L28:
            r1[AttachmentPanelType.MultiImage.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L36:
            r1[AttachmentPanelType.MultiFile.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L24:
            r1[AttachmentPanelType.MixImageFile.ordinal()] = 4;     // Catch: NoSuchFieldError -> L22
        L30:
            r1[AttachmentPanelType.MultiAudio.ordinal()] = 5;     // Catch: NoSuchFieldError -> L23
        L14:
            b = r1;
        }
    }

    public static final class e implements ICoreInputAbility.d {
        public final /* synthetic */ Ref.BooleanRef a;

        public final void a() {
        }

        public final void c() {
        }

        public e(Ref.BooleanRef r1) {
            this.a = r1;
        }

        public final void b(ICoreInputAbility.OnSendParams r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            this.a.element = true;
        }
    }

    public static final class f implements Function0<oaa.a> {
        public final /* synthetic */ AttachReceiver a;

        public f(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(oaa.a.class));
        }
    }

    public static final class g implements Function0<p1> {
        public final /* synthetic */ AttachReceiver a;

        public g(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(p1.class));
        }
    }

    public static final class h implements dr9.c {
        public final /* synthetic */ Integer a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ a c;

        public final boolean a() {
            int r0 = od8.h0.a;
            if (od8.h0.c(this.a) == false) goto L5;
        L12:
            return true;
        L5:
            if (od8.h0.f(this.a) == true) goto L12;
            if (od8.h0.i(this.a) == true) goto L12;
            if (this.b == false) goto L12;
            return false;
        }

        public final boolean b() {
            return this.c.g();
        }

        public h(Integer r1, boolean r2, a r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final void Za() {
        this.p0 = true;
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final void mO() {
        this.P1 = true;
        FLogger.a.i("AttachmentPanelComponent", "[AttachmentPanelAdjust] next hide adjust banned");
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final void o50() {
        this.F = true;
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final void p20() {
        this.L1 = true;
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final void qe() {
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final void yj() {
        this.M1 = true;
        FLogger.a.i("AttachmentPanelComponent", "[AttachmentPanelAdjust] persistent hide adjust banned");
    }

    public static boolean q4() {
        return z2.a.getFlowMultiUploadConfig().c();
    }

    public final void A2() {
        Job r0 = this.k0;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.k0 = null;
        ((LinkedHashMap) this.Z).clear();
        Iterator r1 = CollectionsKt.toList(this.Y).iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((Function0) r1.next()).invoke();
        goto L7
    L9:
        this.Y.clear();
        op8.d r2 = this.R;
        if (r2 == null) goto L12;
        r2.dJ(this.T);
    L12:
        this.R = null;
        k9 r3 = this.S;
        if (r3 == null) goto L18;
        ICoreInputAbility r4 = r3.d;
        if (r4 == null) goto L17;
        r4.Vs(r3.f);
    L17:
        r3.b.Vs(r3.g);
    L18:
        this.S = null;
        R5();
    }

    public final op8.k B4() {
        return (op8.k) this.Q.getValue();
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final void Bg() {
        FLogger.a.i("AttachmentPanelComponent", "[onReferenceMessageClosed]");
        mt8.a r0 = this.m;
        boolean r1 = false;
        if (r0 == null) goto L12;
        View r2 = r0.getView();
        if (r2 == null) goto L12;
        if (r2.getVisibility() != 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 != true) goto L12;
        r1 = true;
        goto L12
    L9:
        r3 = false;
    L12:
        if (r1 == false) goto L20;
        mt8.a r4 = this.m;
        if (r4 == null) goto L18;
        View r5 = r4.getView();
        if (r5 == null) goto L18;
        r5.setBackground(i4());
    L18:
        W0();
        return;
    }

    public final ArrayList<ResourceItemBean> C3() {
        ArrayList<ResourceItemBean> r0 = new ArrayList();
        Iterator r1 = ((ArrayList) this.J).iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        UplinkFileEntity r2 = (UplinkFileEntity) r1.next();
        if (n1.d(r2) == false) goto L8;
    L11:
        int r3 = i5.w0();
    L12:
        r0.add(com.larus.bmhome.chat.c.a(r2, Mode.EDIT, r3, 0, 60));
        goto L4
    L8:
        if (n1.e(r2) == true) goto L11;
        r3 = i5.y();
        goto L12
    L13:
        return r0;
    }

    public final void E3() {
        if (((ArrayList) this.J).isEmpty() == false) goto L5;
        return;
    L5:
        com.larus.bmhome.chat.component.bottom.reference.a r0 = g5();
        if (r0 != null) goto L8;
    L10:
        boolean r1 = false;
    L11:
        boolean r2 = !r1;
        Iterator r3 = ((ArrayList) this.J).iterator();
    L13:
        if (r3.hasNext() == false) goto L25;
        UplinkFileEntity r4 = (UplinkFileEntity) r3.next();
        if (Intrinsics.areEqual(r4.isFromDraft(), Boolean.FALSE) == false) goto L13;
        if (Intrinsics.areEqual(G4().get(r4.getFileIdentifier()), Boolean.TRUE) == true) goto L13;
        x6(false);
        va8.o r5 = k4();
        if (r5 == null) goto L21;
        r5.SB(r2);
    L21:
        bc8.a r6 = aE();
        if (r6 == null) goto L38;
        r6.Bz();
        return;
    L38:
        return;
    L25:
        x6(true);
        bc8.a r7 = aE();
        if (r7 == null) goto L28;
        r7.Bz();
    L28:
        va8.o r8 = k4();
        if (r8 == null) goto L39;
        r8.SB(r2);
        return;
    L39:
        return;
    L8:
        if (r0.VM() == true) goto L10;
        r1 = true;
        goto L11
    }

    public final Map<String, Boolean> G4() {
        return (Map) this.g1.getValue();
    }

    public final wc9.e H3() {
        com.larus.bmhome.chat.component.cvs.y r0 = (com.larus.bmhome.chat.component.cvs.y) this.v.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.h();
    }

    public final String K() {
        com.larus.bmhome.chat.component.cvs.y r0 = (com.larus.bmhome.chat.component.cvs.y) this.v.getValue();
        if (r0 == null) goto L5;
        String r1 = r0.Y1();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final void R5() {
        if (this.P.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L14;
        NestedFileCacheManagerService r1 = NestedFileCacheManagerService.b;     // Catch: IllegalStateException -> L9
        r1.g(this.P).removeObserver((Observer) this.p1.getValue());     // Catch: IllegalStateException -> L9
        r1.j(this.P).removeObserver((Observer) this.v1.getValue());     // Catch: IllegalStateException -> L9
        return;
    L9:
        e = move-exception;
        FLogger.a.e("AttachmentPanelComponent", "[removeAttachmentObserverIfNeeded] called on background thread", e);
        return;
    L14:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final kotlinx.coroutines.flow.b1 Ry() {
        return kotlinx.coroutines.flow.e.b(this.M);
    }

    public final BotModel W3() {
        com.larus.bmhome.chat.component.cvs.y r0 = (com.larus.bmhome.chat.component.cvs.y) this.v.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.j0();
    }

    public final String X3() {
        if (Intrinsics.areEqual(this.B, "album") == false) goto L14;
        String r0 = this.D;
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == false) goto L13;
        String r2 = this.C;
    L15:
        if (r2 != null) goto L18;
        return "";
    L18:
        return r2;
    L13:
        r2 = this.D;
        goto L15
    L7:
        if (r0.length() == 0) goto L10;
        r1 = false;
        goto L11
    L14:
        r2 = this.D;
        goto L15
    }

    public final j1 Y3() {
        return (j1) this.y.getValue();
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final kotlinx.coroutines.flow.b1 YB() {
        return kotlinx.coroutines.flow.e.b(this.L);
    }

    public final bc8.a aE() {
        return (bc8.a) this.Q1.getValue();
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final kotlinx.coroutines.flow.b1 br() {
        return kotlinx.coroutines.flow.e.b(this.O);
    }

    public final AlbumEduIntentSuggestController d4() {
        return (AlbumEduIntentSuggestController) this.S1.getValue();
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final void dP() {
        if (this.V.isEmpty() == true) goto L5;
    L7:
        this.V = CollectionsKt.emptyList();
        this.W = new HashMap();
        if (((ArrayList) this.J).isEmpty() == false) goto L10;
        V4();
        return;
    L10:
        z5(C3());
        return;
    L5:
        if (this.W.isEmpty() == false) goto L7;
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final void dm() {
        if (B4() == null) goto L6;
        return;
    L6:
        if (d3.a.e() == false) goto L8;
        return;
    L8:
        if (b3.a.a() == true) goto L291;
        String r0 = K();
        j1 r1 = Y3();
        NestedFileContent r2 = null;
        if (r1 == null) goto L13;
        ChatDraftItem r3 = r1.d();
    L14:
        z2 r4 = z2.a;
        boolean r8 = z2.c4();
        StringBuilder r5 = new StringBuilder();
        if (r3 == null) goto L17;
        Long r6 = Long.valueOf(r3.getUpdateTime());
    L18:
        r5.append(r6);
        r5.append('_');
        if (r3 == null) goto L21;
        String r7 = r3.getKey();
    L22:
        r5.append(r7);
        String r9 = r5.toString();
        if (r3 != null) goto L31;
        if (r8 == true) goto L26;
    L28:
        if (r8 == false) goto L283;
        this.y1 = r9;
        return;
    L283:
        return;
    L26:
        if (Intrinsics.areEqual(this.y1, r9) == true) goto L28;
        this.x1 = r0;
        ((ArrayList) this.J).clear();
        x5();
        G4().clear();
        V4();
        goto L28
    L31:
        j1 r10 = Y3();
        boolean r11 = true;
        if (r10 != null) goto L34;
    L36:
        boolean r12 = false;
    L37:
        if (r12 == true) goto L39;
        return;
    L39:
        if (Intrinsics.areEqual(this.x1, r0) == false) goto L43;
        if (r8 == true) goto L42;
        return;
    L42:
        if (Intrinsics.areEqual(this.y1, r9) == false) goto L43;
        return;
    L43:
        this.x1 = r0;
        if (r8 == false) goto L46;
        this.y1 = r9;
    L46:
        NestedFileContent r13 = r3.getNestedFileContent();
        if (r13 != null) goto L49;
        Pair r14 = TuplesKt.to(Boolean.FALSE, AttachmentPanelType.Unknown);
    L153:
        if (((Boolean) r14.getFirst()).booleanValue() == true) goto L158;
        j1 r15 = Y3();
        if (r15 == null) goto L284;
        r15.i();
        return;
    L284:
        return;
    L158:
        R5();
        if (r8 == false) goto L161;
        ((ArrayList) this.J).clear();
        G4().clear();
    L161:
        String r16 = r3.getKey();
        if (r16 != null) goto L164;
        r16 = "";
    L164:
        this.P = r16;
        if (r8 == false) goto L178;
        NestedFileContent r17 = NestedFileCacheManagerService.b.b6(r16);
        if (r17 == null) goto L178;
        List r18 = r17.getEntities();
        if (r18 != null) goto L171;
    L174:
        boolean r19 = true;
    L176:
        if ((!r19) == false) goto L178;
    L179:
        if (r8 == false) goto L182;
        if (r17 == null) goto L182;
        boolean r110 = true;
    L183:
        if (r8 == false) goto L202;
        if (r17 != null) goto L201;
        NestedFileContent r20 = r3.getNestedFileContent();
        if (r20 == null) goto L203;
        r2 = com.larus.bmhome.chat.sendimage.e.e(com.larus.bmhome.chat.sendimage.e.a(r20));
        List r21 = r2.getEntities();
        if (r21 == null) goto L203;
        Iterator r22 = r21.iterator();
    L191:
        if (r22.hasNext() == false) goto L203;
        UplinkFileEntity r23 = (UplinkFileEntity) r22.next();
        Integer r24 = r23.getUpLinkStatus();
        int r25 = UpLinkState.SUCCESS.getValue();
        if (r24 == null) goto L200;
        if (r24.intValue() != r25) goto L200;
        if (T4(r23) == false) goto L200;
        r23.setFromDraft(Boolean.TRUE);
    L200:
        r23.setUpLinkProcess(0);
        r23.setUpLinkStatus(Integer.valueOf(UpLinkState.FAIL.getValue()));
        r23.setFromDraft(Boolean.FALSE);
        r23.setHistoryReuse(false);
    L203:
        NestedFileContent r111 = r2;
    L204:
        if (r111 == null) goto L215;
        List r26 = r111.getEntities();
        if (r26 == null) goto L215;
        Iterator r27 = r26.iterator();
    L209:
        if (r27.hasNext() == false) goto L215;
        UplinkFileEntity r112 = (UplinkFileEntity) r27.next();
        List<UplinkFileEntity> r28 = this.J;
        if (r8 == false) goto L213;
        UplinkFileEntity r29 = UplinkFileEntity.copy$default(r112, null, null, null, null, null, null, null, null, null, false, null, null, null, null, 16383, null);
    L214:
        ((ArrayList) r28).add(r29);
        goto L209
    L213:
        r112.setFromDraft(Boolean.TRUE);
        r29 = UplinkFileEntity.copy$default(r112, null, null, null, null, null, null, null, null, null, false, null, null, null, null, 16383, null);
    L215:
        x5();
        AttachmentPanelType r30 = (AttachmentPanelType) r14.getSecond();
        if (r30 != AttachmentPanelType.MixImageFile) goto L218;
    L228:
        String r113 = "file";
    L229:
        X5(this, (AttachmentPanelType) r14.getSecond(), Intrinsics.areEqual(r113, "file"), r113, null, null, DoraCallStateCode.DOUBAO_CMD_12);
        if (r111 == null) goto L289;
        ResourceCenter.a.getClass();
        if (ResourceCenter.f().a() == false) goto L261;
        List r31 = r111.getEntities();
        if (r31 == null) goto L292;
        j1 r32 = Y3();
        if (r32 != null) goto L239;
    L241:
        r11 = false;
    L242:
        if (r11 == false) goto L244;
        FlowResourceScene r33 = FlowResourceScene.ImageEDU;
    L245:
        Iterator r34 = r31.iterator();
    L247:
        if (r34.hasNext() == false) goto L261;
        UplinkFileEntity r35 = (UplinkFileEntity) r34.next();
        if (n1.e(r35) == false) goto L252;
        FlowResourceScene r36 = FlowResourceScene.VideoUpload;
    L257:
        ResourceCenter r37 = ResourceCenter.a;
        String r38 = r35.getFileIdentifier();
        if (r38 != null) goto L260;
        r38 = "";
    L260:
        r37.getClass();
        ResourceCenter.k(r38, r36);
        goto L247
    L252:
        if (n1.d(r35) == true) goto L254;
    L256:
        r36 = r33;
        goto L257
    L254:
        if (this.L1 == false) goto L256;
        r36 = FlowResourceScene.SpringMainVenue;
        goto L257
    L244:
        r33 = s5(r113);
        goto L245
    L239:
        if (r32.a() != 12) goto L241;
    L292:
        return;
    L261:
        if (r110 == true) goto L267;
        NestedFileCacheManagerService r39 = NestedFileCacheManagerService.b;
        String r40 = this.P;
        if (r8 == true) goto L266;
        r111 = com.larus.bmhome.chat.sendimage.e.e(com.larus.bmhome.chat.sendimage.e.a(r111));
    L266:
        r39.i(r40, r111);
        return;
    L267:
        ((Observer) this.v1.getValue()).onChanged(r111);
        return;
    L289:
        return;
    L218:
        if (r30 == AttachmentPanelType.MultiFile) goto L228;
        if (r30 != AttachmentPanelType.MultiImage) goto L223;
    L226:
        String r41 = "album";
    L227:
        r113 = r41;
        goto L229
    L223:
        if (r30 == AttachmentPanelType.SingleImage) goto L226;
        r41 = "other";
        goto L227
    L201:
        r111 = r17;
        goto L204
    L202:
        r2 = r3.getNestedFileContent();
    L182:
        r110 = false;
        goto L183
    L171:
        if (r18.isEmpty() == true) goto L174;
        r19 = false;
    L178:
        r17 = null;
        goto L179
    L49:
        j1 r42 = Y3();
        if (r42 == null) goto L52;
        Integer r43 = Integer.valueOf(r42.a());
    L54:
        if (od8.h0.e(r43) == false) goto L57;
        r14 = TuplesKt.to(Boolean.TRUE, AttachmentPanelType.MultiImage);
        goto L153
    L57:
        if (od8.h0.g(r43) == false) goto L59;
        r14 = TuplesKt.to(Boolean.TRUE, AttachmentPanelType.SingleFile);
        goto L153
    L59:
        ICoreInputAbility r44 = l4();
        if (r44 != null) goto L62;
    L64:
        boolean r45 = false;
    L66:
        if (r45 == false) goto L69;
    L72:
        boolean r46 = true;
    L74:
        ICoreInputAbility r47 = l4();
        if (r47 != null) goto L77;
    L79:
        boolean r48 = false;
    L80:
        if (r48 == false) goto L83;
    L86:
        boolean r49 = true;
    L88:
        ICoreInputAbility r50 = l4();
        if (r50 == null) goto L91;
        boolean r51 = r50.wy();
    L92:
        com.larus.bmhome.chat.component.bottom.multimodal.g r52 = v4();
        if (r52 == null) goto L95;
        boolean r53 = r52.nA(null);
    L96:
        int r114 = yc9.v0.b(r13, new yc9.q0());
        int r115 = yc9.v0.c(r13);
        int r116 = yc9.v0.a(r13);
        int r54 = yc9.v0.e(r13);
        if (r114 <= 0) goto L99;
        if (r49 == true) goto L99;
    L105:
        r14 = TuplesKt.to(Boolean.FALSE, AttachmentPanelType.Unknown);
    L99:
        if (r115 <= 0) goto L101;
        if (r46 == false) goto L105;
    L101:
        if (r116 <= 0) goto L103;
        if (r51 == false) goto L105;
    L103:
        if (r54 <= 0) goto L106;
        if (r53 == false) goto L105;
    L106:
        if (r116 <= 0) goto L121;
        if (r114 > 0) goto L111;
        if (r115 > 0) goto L111;
        if (r54 <= 0) goto L121;
    L111:
        if (q4() == false) goto L120;
        if (r114 <= 0) goto L120;
        if (r115 != 0) goto L120;
        if (r54 != 0) goto L120;
        Boolean r55 = Boolean.TRUE;
        if (o5() == false) goto L118;
        AttachmentPanelType r56 = AttachmentPanelType.MixImageFile;
    L119:
        r14 = TuplesKt.to(r55, r56);
        goto L153
    L118:
        r56 = AttachmentPanelType.MultiFile;
    L120:
        r14 = TuplesKt.to(Boolean.FALSE, AttachmentPanelType.Unknown);
    L121:
        if (r116 <= 0) goto L126;
        if (r114 != 0) goto L126;
        if (r115 != 0) goto L126;
        if (r54 != 0) goto L126;
        r14 = TuplesKt.to(Boolean.TRUE, AttachmentPanelType.MultiAudio);
    L126:
        if (r114 <= 0) goto L132;
        if (r115 <= 0) goto L132;
        if (o5() == false) goto L131;
        r14 = TuplesKt.to(Boolean.TRUE, AttachmentPanelType.MixImageFile);
        goto L153
    L131:
        r14 = TuplesKt.to(Boolean.FALSE, AttachmentPanelType.Unknown);
    L132:
        if (r114 > 0) goto L134;
        if (r115 > 0) goto L143;
        if (r54 > 0) goto L143;
        r14 = TuplesKt.to(Boolean.FALSE, AttachmentPanelType.Unknown);
    L143:
        if (f5() == true) goto L145;
        if (r115 != 1) goto L151;
        r14 = TuplesKt.to(Boolean.TRUE, AttachmentPanelType.SingleImage);
        goto L153
    L151:
        r14 = TuplesKt.to(Boolean.FALSE, AttachmentPanelType.Unknown);
        goto L153
    L145:
        if (o5() == false) goto L147;
        AttachmentPanelType r57 = AttachmentPanelType.MixImageFile;
    L148:
        r14 = TuplesKt.to(Boolean.TRUE, r57);
        goto L153
    L147:
        r57 = AttachmentPanelType.MultiImage;
        goto L148
    L134:
        if (o5() == false) goto L136;
        AttachmentPanelType r58 = AttachmentPanelType.MixImageFile;
    L137:
        r14 = TuplesKt.to(Boolean.TRUE, r58);
        goto L153
    L136:
        r58 = AttachmentPanelType.MultiFile;
        goto L137
    L95:
        r53 = false;
        goto L96
    L91:
        r51 = false;
        goto L92
    L83:
        if (FeatureKitDelegate.b.m0().b() == true) goto L85;
    L87:
        r49 = false;
        goto L88
    L85:
        if (W4("show_icon", "show_file_icon") == false) goto L87;
    L77:
        if (r47.CD(false) != true) goto L79;
        r48 = true;
        goto L80
    L69:
        if (o4.a() == true) goto L71;
    L73:
        r46 = false;
        goto L74
    L71:
        if (W4("show_icon", "show_image_icon") == false) goto L73;
    L62:
        if (r44.Qd(false) != true) goto L64;
        r45 = true;
        goto L66
    L52:
        r43 = null;
        goto L54
    L34:
        if (r10.u(r3) != true) goto L36;
        r12 = true;
        goto L37
    L21:
        r7 = null;
        goto L22
    L17:
        r6 = null;
        goto L18
    L13:
        r3 = null;
        goto L14
    }

    public final de8.c f1() {
        return (de8.c) this.z.getValue();
    }

    public final com.larus.bmhome.chat.component.bottom.reference.a g5() {
        return (com.larus.bmhome.chat.component.bottom.reference.a) this.q.getValue();
    }

    public final Drawable i4() {
        com.larus.bmhome.chat.component.bottom.reference.a r1 = g5();
        boolean r2 = true;
        if (r1 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        com.larus.bmhome.instruction.g r4 = vc();
        if (r4 != null) goto L11;
    L13:
        boolean r5 = false;
    L15:
        if (i9() == false) goto L17;
        if (r3 == false) goto L17;
    L22:
        boolean r6 = true;
    L23:
        FLogger.a.i("AttachmentPanelComponent", "[getAttachmentAreaBgDrawable] enableReferenceMsgWithAttachment:" + r3 + ", hasReferenceMsg:" + i9() + ", instructionOpen:" + r5 + ", isModifyModeActive:" + this.I);
        if (this.H == false) goto L32;
        int r7 = ContextCompat.getColor(getContext(), v19.c.b(2130970536, getContext(), 2131102551));
        GradientDrawable r8 = new GradientDrawable();
        r8.setShape(0);
        if (r6 == false) goto L28;
        float r9 = 0.0f;
    L29:
        r8.setCornerRadii(new float[]{r9, r9, r9, r9, 0.0f, 0.0f, 0.0f, 0.0f});
        r8.setColor(r7);
        return r8;
    L28:
        r9 = c7.b(16);
        goto L29
    L32:
        if (r6 == false) goto L50;
        de8.c r10 = f1();
        if (r10 != null) goto L36;
    L38:
        r2 = false;
    L39:
        if (r2 == false) goto L47;
        int r11 = com.larus.bmhome.chat.immerse.k0.a;
        de8.c r12 = f1();
        if (r12 == null) goto L45;
        Integer r13 = r12.m();
        if (r13 == null) goto L45;
        int r14 = r13.intValue();
    L46:
        int r15 = com.larus.bmhome.chat.immerse.k0.a(r14, 0.1f, 0.35f);
        GradientDrawable r16 = new GradientDrawable();
        r16.setShape(0);
        r16.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f});
        r16.setColor(r15);
        return r16;
    L45:
        r14 = 0;
        goto L46
    L47:
        Drawable r17 = ContextCompat.getDrawable(getContext(), v19.c.b(2130970554, getContext(), 2131238611));
        if (r17 != null) goto L70;
    L67:
        return null;
    L70:
        return D6(r17);
    L36:
        if (r10.C() != true) goto L38;
    L50:
        de8.c r18 = f1();
        if (r18 != null) goto L53;
    L55:
        boolean r19 = false;
    L56:
        if (r19 == false) goto L64;
        int r20 = com.larus.bmhome.chat.immerse.k0.a;
        de8.c r21 = f1();
        if (r21 == null) goto L62;
        Integer r22 = r21.m();
        if (r22 == null) goto L62;
        int r23 = r22.intValue();
    L63:
        int r24 = com.larus.bmhome.chat.immerse.k0.a(r23, 0.1f, 0.35f);
        GradientDrawable r25 = new GradientDrawable();
        r25.setShape(0);
        float r26 = c7.b(16);
        r25.setCornerRadii(new float[]{r26, r26, r26, r26, 0.0f, 0.0f, 0.0f, 0.0f});
        r25.setColor(r24);
        return r25;
    L62:
        r23 = 0;
        goto L63
    L64:
        Drawable r27 = ContextCompat.getDrawable(getContext(), v19.c.b(2130970553, getContext(), 2131238608));
        if (r27 == null) goto L67;
        return D6(r27);
    L53:
        if (r18.C() != true) goto L55;
        r19 = true;
    L17:
        if (r5 == true) goto L22;
        if (this.I == true) goto L22;
        r6 = false;
        goto L23
    L11:
        if (r4.z0() != true) goto L13;
        r5 = true;
        goto L15
    L5:
        if (r1.LX() != true) goto L7;
        r3 = true;
        goto L8
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final boolean isVisible() {
        mt8.a r0 = this.m;
        if (r0 == null) goto L13;
        View r1 = r0.getView();
        if (r1 != null) goto L7;
        return false;
    L7:
        if (r1.getVisibility() != 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 != true) goto L15;
        return true;
    L15:
        return false;
    L9:
        r2 = false;
        goto L10
    L13:
        return false;
    }

    public final List<com.larus.chat.gallery.api.o> j4() {
        List<UplinkFileEntity> r1 = this.J;
        ArrayList r2 = new ArrayList();
        Iterator r3 = ((ArrayList) r1).iterator();
    L4:
        if (r3.hasNext() == false) goto L96;
        UplinkFileEntity r4 = (UplinkFileEntity) r3.next();
        String r5 = r4.getFileIdentifier();
        String r6 = null;
        if (r5 == null) goto L94;
        boolean r7 = true;
        if (r5.length() <= 0) goto L10;
        boolean r8 = true;
    L11:
        if (r8 == false) goto L13;
        String r10 = r5;
    L14:
        if (r10 == null) goto L94;
        if (n1.d(r4) == false) goto L36;
        Image r9 = l1.c(r4);
        if (r9 == null) goto L94;
        String r11 = B3(r4);
        if (r11 == null) goto L94;
        PreviewMediaType r12 = PreviewMediaType.IMAGE;
        ImageObj r13 = r9.imageThumb;
        if (r13 == null) goto L27;
        r6 = r13.url;
    L27:
        String r14 = r6;
        ImageObj r15 = r9.imageOri;
        if (r15 == null) goto L30;
        int r16 = r15.width;
    L31:
        if (r15 == null) goto L33;
        int r17 = r15.height;
    L34:
        r6 = new com.larus.chat.gallery.api.o(r10, r11, r12, r14, r16, r17, 0, 64);
        goto L94
    L33:
        r17 = 0;
        goto L34
    L30:
        r16 = 0;
        goto L31
    L36:
        if (n1.e(r4) == false) goto L94;
        UplinkEntityContent r18 = r4.getUplinkEntityContent();
        if (r18 == null) goto L94;
        UplinkFileInfo r19 = r18.getUplinkFileInfo();
        if (r19 == null) goto L94;
        VideoExtension r20 = r19.getVideo();
        if (r20 == null) goto L94;
        String r21 = r19.getLocalResPath();
        if (r21 != null) goto L48;
    L52:
        r21 = r20.getDownloadUrl();
        if (r21 != null) goto L55;
    L60:
        r21 = null;
    L61:
        if (r21 == null) goto L94;
    L63:
        String r110 = r21;
        Image r22 = r20.getCover();
        PreviewMediaType r111 = PreviewMediaType.VIDEO;
        if (r22 == null) goto L69;
        ImageObj r23 = r22.imageThumb;
        if (r23 == null) goto L69;
        String r24 = r23.url;
        if (r24 == null) goto L69;
    L80:
        String r112 = r24;
    L81:
        Integer r25 = r20.getWidth();
        if (r25 == null) goto L84;
        int r113 = r25.intValue();
    L85:
        Integer r26 = r20.getHeight();
        if (r26 == null) goto L88;
        int r114 = r26.intValue();
    L89:
        Float r27 = r20.getDuration();
        if (r27 == null) goto L92;
        float r28 = r27.floatValue();
    L93:
        r6 = new com.larus.chat.gallery.api.o(r10, r110, r111, r112, r113, r114, (long) (r28 * 1000));
        goto L94
    L92:
        r28 = 0.0f;
        goto L93
    L88:
        r114 = 0;
        goto L89
    L84:
        r113 = 0;
    L69:
        if (r22 == null) goto L73;
        ImageObj r29 = r22.previewImage;
        if (r29 == null) goto L73;
        r24 = r29.url;
    L74:
        if (r24 != null) goto L80;
        if (r22 == null) goto L79;
        ImageObj r30 = r22.imageOri;
        if (r30 == null) goto L79;
        r6 = r30.url;
    L79:
        r112 = r6;
    L73:
        r24 = null;
        goto L74
    L55:
        if (r21.length() > 0) goto L58;
        r7 = false;
    L58:
        if (r7 == false) goto L60;
    L48:
        if (m5.c(r21) == true) goto L51;
        r21 = null;
    L51:
        if (r21 != null) goto L63;
    L13:
        r10 = null;
        goto L14
    L10:
        r8 = false;
    L94:
        if (r6 == null) goto L4;
        r2.add(r6);
        goto L4
    L96:
        return r2;
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final i1<List<id8.f>> k1() {
        return kotlinx.coroutines.flow.e.b(this.K);
    }

    public final va8.o k4() {
        return (va8.o) this.o.getValue();
    }

    public final ICoreInputAbility l4() {
        return (ICoreInputAbility) this.n.getValue();
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final boolean mT() {
        if (FeatureKitDelegate.b.t0().b() == false) goto L34;
        BotModel r0 = W3();
        String r2 = null;
        if (r0 == null) goto L7;
        List r1 = r0.getBotConf();
    L9:
        if (r1 == null) goto L26;
        Iterator r3 = r1.iterator();
    L12:
        if (r3.hasNext() == false) goto L21;
        Object r4 = r3.next();
        BotConfItem r5 = (BotConfItem) r4;
        if (Intrinsics.areEqual(r5.getConfGroupKey(), "disable_function") == true) goto L16;
    L18:
        boolean r6 = false;
    L19:
        if (r6 == false) goto L12;
    L22:
        BotConfItem r7 = (BotConfItem) r4;
        if (r7 == null) goto L26;
        r2 = r7.getConfValue();
        goto L26
    L16:
        if (Intrinsics.areEqual(r5.getConfKey(), "disable_attachment_area") == false) goto L18;
        r6 = true;
        goto L19
    L21:
        r4 = null;
    L26:
        if (Intrinsics.areEqual(r2, "1") == true) goto L35;
        return true;
    L35:
        return false;
    L7:
        r1 = null;
        goto L9
    L34:
        return false;
    }

    public final void o6() {
        mt8.a r0 = this.m;
        if (r0 == null) goto L17;
        ArrayList r1 = r0.getList();
        if (r1 == null) goto L17;
        ArrayList r4 = new ArrayList();
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L18;
        Object r5 = r2.next();
        ResourceItemBean r6 = (ResourceItemBean) r5;
        if (r6.getResourceType() != ResourceType.ADD) goto L12;
    L14:
        boolean r7 = false;
    L15:
        if (r7 == false) goto L8;
        r4.add(r5);
        goto L8
    L12:
        if (r6.getResourceType() == ResourceType.CUSTOM) goto L14;
        r7 = true;
    L18:
        com.larus.bmhome.instruction.g r3 = vc();
        if (r3 != null) goto L21;
    L23:
        boolean r8 = false;
    L24:
        if (r8 == true) goto L259;
        j1 r9 = Y3();
        if (r9 == null) goto L30;
        int r10 = r9.a();
        int r11 = od8.h0.a;
        if (od8.h0.e(Integer.valueOf(r10)) != true) goto L30;
        boolean r12 = true;
    L31:
        if (r12 == true) goto L259;
        j1 r13 = Y3();
        if (r13 == null) goto L37;
        int r14 = r13.a();
        int r15 = od8.h0.a;
        if (od8.h0.g(Integer.valueOf(r14)) != true) goto L37;
        boolean r16 = true;
    L38:
        if (r16 == true) goto L259;
        if (q5() == true) goto L259;
        if (i9() == false) goto L51;
        com.larus.bmhome.chat.component.bottom.reference.a r17 = g5();
        if (r17 != null) goto L46;
    L48:
        boolean r18 = false;
    L49:
        if (r18 == false) goto L51;
        boolean r19 = true;
    L52:
        if (r19 == true) goto L259;
        ICoreInputAbility r20 = l4();
        if (r20 != null) goto L56;
    L58:
        boolean r21 = false;
    L59:
        if (r21 == false) goto L165;
        if (r4 != null) goto L76;
        mt8.a r22 = this.m;
        if (r22 == null) goto L75;
        ArrayList r23 = r22.getList();
        if (r23 == null) goto L75;
        ArrayList r24 = new ArrayList();
        Iterator r25 = r23.iterator();
    L68:
        if (r25.hasNext() == false) goto L77;
        Object r26 = r25.next();
        if (((ResourceItemBean) r26).getResourceType() == ResourceType.ADD) goto L72;
        boolean r27 = true;
    L73:
        if (r27 == false) goto L68;
        r24.add(r26);
        goto L68
    L72:
        r27 = false;
    L77:
        if (r24 != null) goto L79;
    L82:
        boolean r28 = true;
    L83:
        if (r28 == true) goto L124;
        boolean r29 = r24 instanceof Collection;
        if (r29 == true) goto L87;
    L89:
        Iterator r30 = r24.iterator();
    L91:
        if (r30.hasNext() == false) goto L101;
        ResourceItemBean r31 = (ResourceItemBean) r30.next();
        if (r31.getResourceType() != ResourceType.IMAGE) goto L95;
    L98:
        boolean r32 = true;
    L99:
        if (r32 == false) goto L91;
        boolean r33 = true;
    L102:
        if (r29 == true) goto L104;
    L106:
        Iterator r34 = r24.iterator();
    L108:
        if (r34.hasNext() == false) goto L120;
        ResourceItemBean r35 = (ResourceItemBean) r34.next();
        if (r35.getResourceType() != ResourceType.FILE) goto L112;
    L117:
        boolean r36 = true;
    L118:
        if (r36 == false) goto L108;
        boolean r37 = true;
    L121:
        if (r33 == false) goto L165;
        if (r37 == false) goto L165;
    L164:
        boolean r38 = true;
    L166:
        if (r38 == true) goto L259;
        SuggestedActionScene r39 = U5(r4);
        if (r39 != null) goto L202;
        if (r4 != null) goto L172;
    L175:
        boolean r40 = true;
    L176:
        if (r40 == false) goto L179;
        r39 = SuggestedActionScene.Unknown;
        goto L202
    L179:
        if (r4.size() != 1) goto L184;
        if (((ResourceItemBean) ListProtector.get(r4, 0)).getResourceType() != ResourceType.IMAGE) goto L184;
        r39 = SuggestedActionScene.AttachmentAreaSingleImg;
    L184:
        if (r4.size() != 1) goto L187;
        r39 = SuggestedActionScene.AttachmentAreaSingleFile;
        goto L202
    L187:
        if (r4.isEmpty() == true) goto L198;
        Iterator r41 = r4.iterator();
    L191:
        if (r41.hasNext() == false) goto L198;
        if (((ResourceItemBean) r41.next()).getResourceType() != ResourceType.IMAGE) goto L195;
        boolean r42 = true;
    L196:
        if (r42 == true) goto L191;
        boolean r43 = false;
    L199:
        if (r43 == false) goto L201;
        r39 = SuggestedActionScene.AttachmentAreaMultiImg;
        goto L202
    L201:
        r39 = SuggestedActionScene.AttachmentAreaMultiFile;
        goto L202
    L195:
        r42 = false;
    L198:
        r43 = true;
        goto L199
    L172:
        if (r4.isEmpty() == true) goto L175;
        r40 = false;
    L202:
        Function1<? super SuggestedActionScene, ? extends SuggestedActionScene> r44 = this.b2;
        if (r44 == null) goto L208;
        SuggestedActionScene r45 = (SuggestedActionScene) r44.invoke(r39);
        if (r45 == null) goto L208;
        SuggestedActionScene r46 = r45;
    L210:
        if (r46 == this.T1) goto L212;
        boolean r47 = true;
    L213:
        if (r47 == false) goto L231;
        Function1<? super SuggestedActionScene, Boolean> r48 = this.V1;
        if (r48 != null) goto L217;
    L219:
        boolean r49 = false;
    L220:
        if (r49 == false) goto L230;
        d4().c();
        this.T1 = null;
        bc8.a r50 = aE();
        if (r50 == null) goto L225;
        r50.mX();
    L225:
        if (isVisible() == false) goto L306;
        va8.o r51 = k4();
        if (r51 == null) goto L307;
        r51.e10(true);
        return;
    L307:
        return;
    L306:
        return;
    L230:
        this.T1 = r46;
        goto L231
    L217:
        if (((Boolean) r48.invoke(r46)).booleanValue() == true) goto L219;
        r49 = true;
    L231:
        com.larus.bmhome.chat.component.bottom.attachment.g r52 = V3(r46);
        if (r52 != null) goto L253;
        d4().c();
        if (r47 == true) goto L238;
        bc8.a r53 = aE();
        if (r53 == null) goto L308;
        r53.np();
        return;
    L308:
        return;
    L238:
        bc8.a r54 = aE();
        if (r54 == null) goto L310;
        String r55 = X3();
        List<UplinkFileEntity> r56 = this.J;
        if ((r56 instanceof Collection) == true) goto L243;
    L245:
        Iterator r57 = ((ArrayList) r56).iterator();
    L247:
        if (r57.hasNext() == false) goto L251;
        if (Intrinsics.areEqual(((UplinkFileEntity) r57.next()).isFromDraft(), Boolean.TRUE) == false) goto L247;
        boolean r58 = true;
    L252:
        bc8.a.C0001a.a(r54, r46, r55, r58, this.J, false, 16);
        return;
    L251:
        r58 = false;
        goto L252
    L243:
        if (((ArrayList) r56).isEmpty() == false) goto L245;
    L310:
        return;
    L253:
        if (r47 == true) goto L257;
        bc8.a r59 = aE();
        if (r59 == null) goto L257;
        r59.np();
    L257:
        d4().update(r52);
        return;
    L212:
        r47 = false;
    L208:
        r46 = r39;
        goto L210
    L112:
        if (q4() == true) goto L114;
    L116:
        r36 = false;
        goto L118
    L114:
        if (r35.getResourceType() != ResourceType.AUDIO) goto L116;
    L120:
        r37 = false;
        goto L121
    L104:
        if (r24.isEmpty() == false) goto L106;
    L95:
        if (r31.getResourceType() == ResourceType.VIDEO) goto L98;
        r32 = false;
    L101:
        r33 = false;
        goto L102
    L87:
        if (r24.isEmpty() == false) goto L89;
    L124:
        List<UplinkFileEntity> r60 = this.J;
        if ((r60 instanceof Collection) == true) goto L127;
    L129:
        Iterator r61 = ((ArrayList) r60).iterator();
    L131:
        if (r61.hasNext() == false) goto L141;
        UplinkFileEntity r62 = (UplinkFileEntity) r61.next();
        if (n1.d(r62) == false) goto L135;
    L138:
        boolean r63 = true;
    L139:
        if (r63 == false) goto L131;
        boolean r64 = true;
    L142:
        List<UplinkFileEntity> r65 = this.J;
        if ((r65 instanceof Collection) == true) goto L145;
    L147:
        Iterator r66 = ((ArrayList) r65).iterator();
    L149:
        if (r66.hasNext() == false) goto L161;
        UplinkFileEntity r67 = (UplinkFileEntity) r66.next();
        if (n1.b(r67) == false) goto L153;
    L158:
        boolean r68 = true;
    L159:
        if (r68 == false) goto L149;
        boolean r69 = true;
    L162:
        if (r64 == false) goto L165;
        if (r69 == false) goto L165;
    L153:
        if (q4() == true) goto L155;
    L157:
        r68 = false;
        goto L159
    L155:
        if (n1.a(r67) == false) goto L157;
    L161:
        r69 = false;
        goto L162
    L145:
        if (((ArrayList) r65).isEmpty() == false) goto L147;
    L135:
        if (n1.e(r62) == true) goto L138;
        r63 = false;
    L141:
        r64 = false;
        goto L142
    L127:
        if (((ArrayList) r60).isEmpty() == false) goto L129;
    L79:
        if (r24.isEmpty() == true) goto L82;
        r28 = false;
    L75:
        r24 = null;
        goto L77
    L76:
        r24 = r4;
    L165:
        r38 = false;
        goto L166
    L56:
        if (r20.Pi() != true) goto L58;
        r21 = true;
        goto L59
    L46:
        if (r17.LX() != true) goto L48;
        r18 = true;
    L51:
        r19 = false;
    L37:
        r16 = false;
    L30:
        r12 = false;
    L259:
        d4().c();
        this.T1 = null;
        bc8.a r70 = aE();
        if (r70 == null) goto L263;
        r70.mX();
    L263:
        if (isVisible() == false) goto L312;
        va8.o r71 = k4();
        if (r71 == null) goto L313;
        r71.e10(true);
        return;
    L313:
        return;
    L312:
        return;
    L21:
        if (r3.Wa() != true) goto L23;
        r8 = true;
    L17:
        r4 = null;
        goto L18
    }

    public final void onDestroy() {
        FLogger.a.i("AttachmentPanelComponent", "[onDestroy_" + hashCode() + ']');
        this.V0.clear();
        d4().c();
        R5();
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final void u50() {
        ArrayList r0 = new ArrayList(this.J);
        Intrinsics.checkNotNullParameter(this, "<this>");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this)), Dispatchers.getIO(), null, new AttachmentPanelComponent$batchDeleteUploadedEntities$1(this, r0, null), 2, null);
    }

    public final com.larus.bmhome.chat.component.bottom.multimodal.g v4() {
        return (com.larus.bmhome.chat.component.bottom.multimodal.g) this.r.getValue();
    }

    public final com.larus.bmhome.instruction.g vc() {
        return (com.larus.bmhome.instruction.g) this.p.getValue();
    }

    public final void x5() {
        List<UplinkFileEntity> r0 = this.J;
        ArrayList r1 = new ArrayList();
        Iterator r2 = ((ArrayList) r0).iterator();
    L3:
        boolean r3 = true;
        int r4 = 0;
        if (r2.hasNext() == false) goto L24;
        Object r5 = r2.next();
        UplinkFileEntity r6 = (UplinkFileEntity) r5;
        if (r6.isHistoryReuse() == true) goto L22;
        UplinkEntityContent r7 = r6.getUplinkEntityContent();
        String r8 = null;
        if (r7 == null) goto L12;
        UplinkFileInfo r9 = r7.getUplinkFileInfo();
        if (r9 == null) goto L12;
        String r10 = r9.getLocalResPath();
    L13:
        if (r10 != null) goto L22;
        UplinkEntityContent r11 = r6.getUplinkEntityContent();
        if (r11 == null) goto L19;
        Image r12 = r11.getUplinkImageInfo();
        if (r12 == null) goto L19;
        r8 = r12.localResPath;
    L19:
        if (r8 != null) goto L22;
        r3 = false;
    L12:
        r10 = null;
    L22:
        if (r3 == false) goto L3;
        r1.add(r5);
        goto L3
    L24:
        String r13 = CollectionsKt.joinToString$default(this.J, "; ", null, null, 0, null, new b0(this), 30, null);
        FLogger.a.i("AttachmentPanelComponent", "[AttachmentEntityCollect] size=" + ((ArrayList) this.J).size() + ", entities=[" + r13 + ']');
        StateFlowImpl r14 = this.L;
        int r15 = id8.e.a;
        r14.setValue(id8.e.e((List) r14.getValue(), this.J));
        this.M.setValue(Boolean.valueOf(true ^ ((Collection) this.L.getValue()).isEmpty()));
        if (Intrinsics.areEqual(this.U, r13) == false) goto L27;
        return;
    L27:
        this.U = r13;
        StateFlowImpl r16 = this.K;
        r16.setValue(id8.e.e((List) r16.getValue(), r1));
        List<UplinkFileEntity> r17 = this.J;
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator r19 = ((ArrayList) r17).iterator();
    L29:
        if (r19.hasNext() == false) goto L34;
        Object r20 = r19.next();
        int r21 = r4 + 1;
        if (r4 >= 0) goto L33;
        CollectionsKt.throwIndexOverflow();
    L33:
        r18.add(d1.e((UplinkFileEntity) r20, r4));
        r4 = r21;
        goto L29
    L34:
        Iterator r22 = CollectionsKt.toList(this.X).iterator();
    L36:
        if (r22.hasNext() == false) goto L38;
        ((Function1) r22.next()).invoke(r18);
        goto L36
    }

    public final void y2() {
        FLogger.a.i("AttachmentPanelComponent", "[onAttach_" + hashCode() + ']');
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, g1.class);
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, op8.d.class);
    }

    /* JADX WARN: Type inference failed for: r0v39, types: [com.larus.bmhome.chat.component.bottom.attachment.r0] */
    public AttachmentPanelComponent() {
        this.n = LazyKt.lazy(new t(this));
        this.o = LazyKt.lazy(new l(this));
        this.p = LazyKt.lazy(new m(this));
        this.q = LazyKt.lazy(new n(this));
        this.r = LazyKt.lazy(new o(this));
        this.s = LazyKt.lazy(new p(this));
        this.t = LazyKt.lazy(new q(this));
        this.u = LazyKt.lazy(new r(this));
        this.v = LazyKt.lazy(new s(this));
        this.w = LazyKt.lazy(new f(this));
        this.x = LazyKt.lazy(new g(this));
        this.y = LazyKt.lazy(new u(this));
        this.z = LazyKt.lazy(new e0(this));
        this.J = new ArrayList();
        this.K = kotlinx.coroutines.flow.j1.a(CollectionsKt.emptyList());
        this.L = kotlinx.coroutines.flow.j1.a(CollectionsKt.emptyList());
        this.M = kotlinx.coroutines.flow.j1.a(Boolean.FALSE);
        this.N = new ArrayList();
        this.O = kotlinx.coroutines.flow.j1.a(CollectionsKt.emptyList());
        this.P = "";
        this.Q = LazyKt.lazy(new p0(this));
        this.T = new r0(this);
        this.V = CollectionsKt.emptyList();
        this.W = new HashMap();
        this.X = new LinkedHashSet();
        this.Y = new LinkedHashSet();
        this.Z = new LinkedHashMap();
        this.V0 = new ConcurrentHashMap();
        this.b1 = LazyKt.lazy(new s0());
        this.g1 = LazyKt.lazy(new t0());
        this.h1 = Collections.newSetFromMap(new ConcurrentHashMap());
        this.k1 = Collections.newSetFromMap(new ConcurrentHashMap());
        this.p1 = LazyKt.lazy(new u0(this));
        this.v1 = LazyKt.lazy(new v0(this));
        this.H1 = LazyKt.lazy(new w0());
        this.Q1 = LazyKt.lazy(new j(this));
        this.S1 = LazyKt.lazy(new k(this));
    }

    public final void C6() {
        if (s1a.a.e(this) == false) goto L6;
        FLogger.a.i("AttachmentPanelComponent", "[updateAttachmentPanelBackground] isWindowHost: " + s1a.a.e(this));
        return;
    L6:
        mt8.a r0 = this.m;
        if (r0 == null) goto L13;
        View r1 = r0.getView();
        if (r1 == null) goto L14;
        r1.setBackground(i4());
        return;
    L14:
        return;
    }

    public final void E5() {
        va8.o r0 = k4();
        Intrinsics.checkNotNullParameter(this, "<this>");
        op8.g r1 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        if ((r1 instanceof op8.g) == false) goto L5;
        op8.g r2 = r1;
    L6:
        boolean r3 = false;
        if (uy8.b.c() == false) goto L17;
        ICoreInputAbility r4 = l4();
        if (r4 != null) goto L11;
    L13:
        boolean r5 = false;
    L14:
        if (r5 == false) goto L17;
        if (r2 == null) goto L17;
        r3 = true;
        goto L17
    L11:
        if (r4.c1() != true) goto L13;
        r5 = true;
    L17:
        if (r3 == false) goto L19;
        r2.c3();
        return;
    L19:
        if (r0 == null) goto L23;
        r0.c3();
        return;
    L23:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final ViewGroup F4() {
        return (ViewGroup) F2().findViewById(2131377595);
    }

    public final void V4() {
        ICoreInputAbility r0 = l4();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        FLogger r3 = FLogger.a;
        if (r1 == false) goto L11;
        String r4 = "keep";
    L12:
        r3.i("AttachmentPanelComponent", "[hideAttachmentPanel] sharedDetectAction=".concat(r4));
        d4().c();
        String r5 = null;
        if (r1 == true) goto L35;
        AlbumEduIntentSuggestController.a.C0042a r2 = AlbumEduIntentSuggestController.j;
        String r6 = AlbumEduIntentSuggestController.i;
        if (r2 == null) goto L17;
        int r7 = r2.b;
    L18:
        if (r2 == null) goto L24;
        Deferred<ix8.d> r8 = r2.a;
        if (r8 == null) goto L24;
        if (r8.isActive() != true) goto L24;
        boolean r9 = true;
    L25:
        AlbumEduIntentSuggestController.i = null;
        AlbumEduIntentSuggestController.j = null;
        if (r2 == null) goto L30;
        Deferred<ix8.d> r10 = r2.a;
        if (r10 == null) goto L30;
        Job.DefaultImpls.cancel$default(r10, null, 1, null);
    L30:
        StringBuilder r11 = new StringBuilder("[cancelSharedDetectTask] cancelled=");
        if (r2 == null) goto L33;
        boolean r12 = true;
    L34:
        r11.append(r12);
        r11.append(", imageId=");
        r11.append(r6);
        r11.append(", subscriberCount=");
        r11.append(r7);
        r11.append(", taskActiveBeforeCancel=");
        r11.append(r9);
        r3.i("AlbumEduIntentSuggest", r11.toString());
        goto L35
    L33:
        r12 = false;
    L24:
        r9 = false;
        goto L25
    L17:
        r7 = 0;
    L35:
        this.T1 = null;
        this.H0 = false;
        int r13 = od8.h0.a;
        com.larus.bmhome.instruction.g r14 = vc();
        if (r14 == null) goto L38;
        Integer r15 = Integer.valueOf(r14.Q1());
    L40:
        if (od8.h0.f(r15) == true) goto L47;
        com.larus.bmhome.instruction.g r16 = vc();
        if (r16 == null) goto L44;
        Integer r17 = Integer.valueOf(r16.Q1());
    L46:
        if (od8.h0.i(r17) == true) goto L47;
    L69:
        x6(false);
        com.larus.bmhome.instruction.g r18 = vc();
        if (r18 != null) goto L72;
    L74:
        boolean r19 = false;
    L75:
        R5();
        this.P = "";
        this.B = null;
        this.E = null;
        this.D = null;
        this.V = CollectionsKt.emptyList();
        this.W = new HashMap();
        mt8.a r20 = this.m;
        if (r20 == null) goto L85;
        View r21 = r20.getView();
        if (r21 == null) goto L85;
        if (r21.getVisibility() != 0) goto L82;
        boolean r22 = true;
    L83:
        if (r22 == true) goto L85;
        boolean r23 = true;
    L86:
        if (r23 == false) goto L88;
        return;
    L88:
        mt8.a r24 = this.m;
        if (r24 == null) goto L91;
        r24.e(null);
    L91:
        mt8.a r25 = this.m;
        if (r25 == null) goto L96;
        View r26 = r25.getView();
        if (r26 == null) goto L96;
        com.larus.utils.e1.o(r26);
    L96:
        rv(false);
        bc8.a r27 = aE();
        if (r27 != null) goto L99;
    L101:
        boolean r28 = false;
    L102:
        if (r28 == true) goto L106;
        va8.o r29 = k4();
        if (r29 == null) goto L106;
        r29.e10(false);
    L106:
        com.larus.bmhome.instruction.g r30 = vc();
        if (r30 != null) goto L109;
    L111:
        boolean r31 = false;
    L112:
        if (r31 == false) goto L129;
        com.larus.bmhome.instruction.g r32 = vc();
        if (r32 == null) goto L118;
        int r33 = r32.Q1();
        int r34 = od8.h0.a;
        if (od8.h0.f(Integer.valueOf(r33)) != true) goto L118;
        boolean r35 = true;
    L119:
        if (r35 == true) goto L128;
        com.larus.bmhome.instruction.g r36 = vc();
        if (r36 == null) goto L125;
        int r37 = r36.Q1();
        int r38 = od8.h0.a;
        if (od8.h0.i(Integer.valueOf(r37)) != true) goto L125;
        boolean r39 = true;
    L126:
        if (r39 == true) goto L128;
    L125:
        r39 = false;
    L128:
        boolean r40 = false;
    L131:
        if (this.M1 == false) goto L133;
    L136:
        boolean r41 = true;
    L137:
        com.larus.bmhome.instruction.g r42 = vc();
        if (r42 != null) goto L140;
    L142:
        boolean r43 = false;
    L143:
        if (r43 == false) goto L146;
        if (r41 == false) goto L146;
        r40 = false;
    L146:
        if (r40 == false) goto L158;
        ICoreInputAbility r44 = l4();
        if (r44 == null) goto L150;
        MessageModifyMode r45 = r44.FF();
    L151:
        if (r45 == null) goto L155;
        va8.o r46 = k4();
        if (r46 == null) goto L158;
        r46.p9(v19.c.b(2130970690, getContext(), 2131239155));
        goto L158
    L155:
        ICoreInputAbility r47 = l4();
        if (r47 == null) goto L158;
        r47.zi();
        goto L158
    L150:
        r45 = null;
    L158:
        this.P1 = false;
        com.larus.bmhome.instruction.g r48 = vc();
        if (r48 == null) goto L161;
        r48.vW(true);
    L161:
        ICoreInputAbility r49 = l4();
        if (r49 != null) goto L164;
    L166:
        boolean r50 = false;
    L167:
        if (r50 == true) goto L182;
        va8.o r51 = k4();
        if (r51 == null) goto L173;
        String r52 = r51.u7();
        if (r52 == null) goto L173;
        r5 = StringsKt.trim(r52).toString();
    L173:
        if (r5 != null) goto L175;
    L178:
        boolean r53 = true;
    L179:
        if (r53 == false) goto L181;
        m6(1);
        goto L182
    L181:
        m6(3);
        goto L182
    L175:
        if (r5.length() == 0) goto L178;
        r53 = false;
    L182:
        va8.o r54 = k4();
        if (r54 == null) goto L185;
        r54.SB(F2().isEnabled());
    L185:
        ICoreInputAbility r55 = l4();
        if (r55 == null) goto L190;
        CoreInputAbility r56 = r55.JO();
        if (r56 == null) goto L190;
        r56.f9(false);
    L190:
        ICoreInputAbility r57 = l4();
        if (r57 == null) goto L193;
        r57.Rk();
    L193:
        com.larus.bmhome.chat.component.bottom.bottommenu.f1 r58 = (com.larus.bmhome.chat.component.bottom.bottommenu.f1) s1a.d.a(this).getAbility(com.larus.bmhome.chat.component.bottom.bottommenu.f1.class);
        if (r58 == null) goto L196;
        r58.Rw();
    L196:
        if (r19 == true) goto L204;
        com.larus.bmhome.instruction.g r59 = vc();
        if (r59 != null) goto L200;
    L202:
        boolean r60 = false;
    L203:
        if (r60 == true) goto L204;
    L207:
        va8.o r61 = k4();
        if (r61 == null) goto L210;
        r61.d90(true, true);
    L210:
        oaa.a r62 = (oaa.a) this.w.getValue();
        if (r62 == null) goto L216;
        r62.F0(false);
        return;
    L216:
        return;
    L200:
        if (r59.Q1() != 8) goto L202;
        r60 = true;
    L204:
        com.larus.bmhome.instruction.g r63 = vc();
        if (r63 == null) goto L207;
        r63.A1();
        goto L207
    L164:
        if (r49.Rp() != 2) goto L166;
        r50 = true;
        goto L167
    L140:
        if (r42.z0() != true) goto L142;
        r43 = true;
        goto L143
    L133:
        if (this.P1 == true) goto L136;
        r41 = false;
    L118:
        r35 = false;
    L129:
        r40 = true;
        goto L131
    L109:
        if (r30.z0() != true) goto L111;
        r31 = true;
        goto L112
    L99:
        if (r27.mt() != true) goto L101;
        r28 = true;
        goto L102
    L82:
        r22 = false;
    L85:
        r23 = false;
        goto L86
    L72:
        if (r18.Wa() != true) goto L74;
        r19 = true;
        goto L75
    L44:
        r17 = null;
    L47:
        mt8.a r64 = this.m;
        if (r64 == null) goto L69;
        View r65 = r64.getView();
        if (r65 == null) goto L69;
        com.larus.bmhome.instruction.g r66 = vc();     // Catch: Exception -> L64
        if (r66 == null) goto L56;
        r66.fN(r65);     // Catch: Exception -> L64
    L56:
        if (Intrinsics.areEqual(r65.getParent(), F4()) == false) goto L58;
    L66:
        ViewGroup r67 = F4();
        if (r67 == null) goto L69;
        com.larus.utils.e1.x(r67);
        goto L69
    L58:
        if (r65.getParent() == null) goto L60;
        ViewParent r68 = r65.getParent();     // Catch: Exception -> L64
        Intrinsics.checkNotNull(r68, "null cannot be cast to non-null type android.view.ViewGroup");     // Catch: Exception -> L64
        ((ViewGroup) r68).removeView(r65);     // Catch: Exception -> L64
    L60:
        ViewGroup r69 = F4();     // Catch: Exception -> L64
        if (r69 == null) goto L66;
        r69.addView(r65);     // Catch: Exception -> L64
    L64:
        e = move-exception;
        com.larus.platform.service.g.a.ensureNotReachHere(e);
        goto L66
    L38:
        r15 = null;
        goto L40
    L11:
        r4 = "cancel";
        goto L12
    L5:
        if (r0.c1() != true) goto L7;
        r1 = true;
        goto L8
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final void W0() {
        op8.k r0 = B4();
        if (r0 == null) goto L10;
        Fragment r1 = r0.a();
        if (r1 == null) goto L17;
        g1 r2 = s1a.a.g(r1).getAbility(g1.class);
        if (r2 == null) goto L18;
        r2.W0();
        return;
    L18:
        return;
    L17:
        return;
    L10:
        d4().c();
        ((ArrayList) this.J).clear();
        x5();
        G4().clear();
        this.h1.clear();
        V4();
        bc8.a r3 = aE();
        if (r3 == null) goto L13;
        r3.mX();
    L13:
        j1 r4 = Y3();
        if (r4 == null) goto L19;
        r4.i();
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final ViewGroup YK() {
        return F4();
    }

    public final boolean c4() {
        if (uy8.b.a().b == false) goto L28;
        ICoreInputAbility r0 = l4();
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L29;
        ICoreInputAbility r2 = l4();
        if (r2 == null) goto L14;
        String r3 = r2.EW();
    L16:
        if (Intrinsics.areEqual(r3, "inject_input_photo_picker") == false) goto L30;
        de8.c r4 = f1();
        if (r4 == null) goto L24;
        Bundle r5 = r4.b;
        if (r5 == null) goto L24;
        if (r5.getBoolean("inject_input_hide_album_entrance", false) != true) goto L24;
        boolean r6 = true;
    L25:
        if (r6 == false) goto L31;
        return true;
    L31:
        return false;
    L24:
        r6 = false;
        goto L25
    L30:
        return false;
    L14:
        r3 = null;
        goto L16
    L29:
        return false;
    L7:
        if (r0.c1() != true) goto L9;
        r1 = true;
        goto L10
    L28:
        return false;
    }

    public final boolean f5() {
        ICoreInputAbility r0 = l4();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L11;
        return true;
    L11:
        if (FeatureKitDelegate.b.y0().b() == true) goto L13;
        return false;
    L13:
        if (W4("upload_ability", "upload_multi_image_ability") == false) goto L17;
        return true;
    L17:
        return false;
    L5:
        if (r0.gj() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final boolean i5() {
        if (uy8.b.c() == false) goto L28;
        Intrinsics.checkNotNullParameter(this, "<this>");
        dr9.d r2 = s1a.a.g(com.larus.ui.arch.component.internal.attach.a.b(this, this)).a(dr9.d.class);
        if (r2 != null) goto L7;
    L9:
        boolean r3 = false;
    L10:
        if (r3 == false) goto L29;
        Intrinsics.checkNotNullParameter(this, "<this>");
        if ((com.larus.ui.arch.component.internal.attach.a.b(this, this) instanceof xe8.a) == true) goto L26;
        ICoreInputAbility r0 = l4();
        if (r0 != null) goto L16;
    L18:
        boolean r1 = false;
    L19:
        if (r1 == false) goto L30;
        ICoreInputAbility r4 = l4();
        if (r4 == null) goto L23;
        String r5 = r4.EW();
    L25:
        if (Intrinsics.areEqual(r5, "inject_input_photo_picker") == true) goto L26;
        return false;
    L23:
        r5 = null;
        goto L25
    L30:
        return false;
    L16:
        if (r0.c1() != true) goto L18;
        r1 = true;
    L26:
        return true;
    L29:
        return false;
    L7:
        if (r2.a != true) goto L9;
        r3 = true;
        goto L10
    L28:
        return false;
    }

    public final boolean i9() {
        com.larus.bmhome.chat.component.bottom.reference.a r0 = g5();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L17;
        j1 r2 = Y3();
        if (r2 == null) goto L12;
        ChatDraftItem r3 = r2.m();
    L13:
        if (r3 != null) goto L18;
        return false;
    L18:
        return true;
    L12:
        r3 = null;
        goto L13
    L17:
        return true;
    L5:
        if (r0.i9() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final boolean o5() {
        ICoreInputAbility r0 = l4();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L11;
        return true;
    L11:
        if (f5() == true) goto L13;
        return false;
    L13:
        if (FeatureKitDelegate.b.v0().b() == true) goto L15;
        return false;
    L15:
        if (W4("upload_ability", "upload_multi_file_image_ability") == false) goto L20;
        return true;
    L20:
        return false;
    L5:
        if (r0.Pi() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final boolean q5() {
        if (i5() == false) goto L16;
        List<UplinkFileEntity> r0 = this.J;
        if ((r0 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r1 = r0.iterator();
    L11:
        if (r1.hasNext() == false) goto L22;
        if (n1.e((UplinkFileEntity) r1.next()) == false) goto L11;
        return true;
    L22:
        return false;
    L7:
        if (r0.isEmpty() == false) goto L9;
        return false;
    L16:
        return this.H0;
    }

    public final op8.b snapshot() {
        op8.k r0 = B4();
        String r1 = "";
        if (r0 == null) goto L12;
        Fragment r2 = r0.a();
        if (r2 == null) goto L11;
        op8.d r3 = s1a.a.g(r2).getAbility(op8.d.class);
        if (r3 == null) goto L11;
        op8.b r4 = r3.snapshot();
        if (r4 == null) goto L11;
        return r4;
    L11:
        return new op8.b("", CollectionsKt.emptyList());
    L12:
        va8.o r5 = k4();
        if (r5 == null) goto L15;
        String r6 = r5.u7();
    L16:
        if (r6 == null) goto L19;
        r1 = r6;
    L19:
        List<UplinkFileEntity> r7 = this.J;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r9 = ((ArrayList) r7).iterator();
        int r10 = 0;
    L21:
        if (r9.hasNext() == false) goto L27;
        Object r11 = r9.next();
        int r12 = r10 + 1;
        if (r10 >= 0) goto L25;
        CollectionsKt.throwIndexOverflow();
    L25:
        r8.add(d1.e((UplinkFileEntity) r11, r10));
        r10 = r12;
        goto L21
    L27:
        return new op8.b(r1, r8);
    L15:
        r6 = null;
        goto L16
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final Map<String, String> xt() {
        AlbumEduIntentSuggestController r0 = d4();
        AlbumEduIntentSuggestController.b r1 = r0.g;
        if (r1 == null) goto L13;
        com.larus.bmhome.chat.component.bottom.attachment.g r2 = (com.larus.bmhome.chat.component.bottom.attachment.g) r0.c.invoke();
        if (r2 == null) goto L14;
        Map<String, String> r3 = r1.b;
        if (Intrinsics.areEqual(r1.a, r2.b) == true) goto L11;
        return null;
    L11:
        return r3;
    L14:
        return null;
    L13:
        return null;
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final boolean VS() {
        return this.A;
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final String Wv() {
        return this.P;
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final boolean XT() {
        return this.L0;
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final String ZO() {
        return this.B;
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final String aj() {
        return this.D;
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final AttachmentPanelType eC() {
        return this.E;
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final boolean iJ() {
        return this.G;
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    @Deprecated(message = "use state flow _attachmentEntityListFlow")
    public final List<UplinkFileEntity> q1() {
        return this.J;
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final String uM() {
        return this.P;
    }

    public static boolean D3(UplinkFileEntity r2) {
        if (r2.getUri() != null) goto L15;
        String r3 = l1.d(r2);
        if (r3 != null) goto L7;
    L10:
        boolean r4 = true;
    L11:
        if (r4 == false) goto L16;
        return false;
    L16:
        return true;
    L7:
        if (r3.length() == 0) goto L10;
        r4 = false;
        goto L11
    L15:
        return true;
    }

    public static UplinkFileEntity Q3(UplinkFileEntity r21) {
        UplinkEntityContent r0 = r21.getUplinkEntityContent();
        Map r1 = null;
        if (r0 == null) goto L33;
        UplinkEntityContent r2 = r21.getUplinkEntityContent();
        if (r2 == null) goto L9;
        UplinkFileInfo r3 = r2.getUplinkFileInfo();
        if (r3 == null) goto L9;
        UplinkFileInfo r4 = UplinkFileInfo.copy$default(r3, null, null, null, null, null, null, null, null, null, null, 1023, null);
    L10:
        UplinkEntityContent r5 = r21.getUplinkEntityContent();
        if (r5 == null) goto L31;
        Image r6 = r5.getUplinkImageInfo();
        if (r6 == null) goto L31;
        ImageObj r7 = r6.imageThumb;
        if (r7 == null) goto L17;
        ImageObj r8 = ImageObj.copy$default(r7, null, 0, 0, null, null, 31, null);
    L18:
        ImageObj r9 = r6.imageOri;
        if (r9 == null) goto L21;
        ImageObj r10 = ImageObj.copy$default(r9, null, 0, 0, null, null, 31, null);
    L22:
        ImageObj r11 = r6.previewImage;
        if (r11 == null) goto L25;
        ImageObj r13 = ImageObj.copy$default(r11, null, 0, 0, null, null, 31, null);
    L26:
        Map r12 = r6.ext;
        if (r12 == null) goto L29;
        Map r14 = MapsKt.toMap(r12);
    L30:
        Image r15 = Image.copy$default(r6, null, null, r8, r10, null, null, null, r14, r13, null, null, null, null, null, 15987, null);
    L32:
        UplinkEntityContent r16 = r0.copy(r4, r15);
    L34:
        Map r17 = r21.getExtra();
        if (r17 == null) goto L38;
        r1 = MapsKt.toMap(r17);
    L38:
        return UplinkFileEntity.copy$default(r21, null, r16, null, null, null, null, null, null, null, false, null, null, null, r1, 8189, null);
    L29:
        r14 = null;
        goto L30
    L25:
        r13 = null;
        goto L26
    L21:
        r10 = null;
        goto L22
    L17:
        r8 = null;
    L31:
        r15 = null;
    L9:
        r4 = null;
        goto L10
    L33:
        r16 = null;
        goto L34
    }

    public static boolean T4(UplinkFileEntity r5) {
        Image r0 = l1.c(r5);
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.key;
    L7:
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L24;
        String r4 = l1.g(r5);
        if (r4 != null) goto L17;
    L20:
        boolean r6 = true;
    L21:
        if (r6 == false) goto L24;
        boolean r7 = false;
    L25:
        UplinkEntityContent r8 = r5.getUplinkEntityContent();
        if (r8 == null) goto L28;
        UplinkFileInfo r9 = r8.getUplinkFileInfo();
    L29:
        String r10 = l1.g(r5);
        if (r10 != null) goto L32;
    L35:
        boolean r11 = true;
    L36:
        if (r11 == false) goto L48;
        if (r9 == null) goto L39;
        r1 = r9.getTosKey();
    L39:
        if (r1 != null) goto L41;
    L44:
        boolean r12 = true;
    L45:
        if (r12 == false) goto L48;
        boolean r13 = false;
    L49:
        if (r7 == true) goto L54;
        if (r13 == true) goto L55;
        return false;
    L55:
        return true;
    L54:
        return true;
    L41:
        if (StringsKt.isBlank(r1) == true) goto L44;
        r12 = false;
    L48:
        r13 = true;
        goto L49
    L32:
        if (StringsKt.isBlank(r10) == true) goto L35;
        r11 = false;
        goto L36
    L28:
        r9 = null;
        goto L29
    L17:
        if (StringsKt.isBlank(r4) == true) goto L20;
        r6 = false;
    L24:
        r7 = true;
        goto L25
    L9:
        if (StringsKt.isBlank(r2) == true) goto L12;
        r3 = false;
        goto L13
    L5:
        r2 = null;
        goto L7
    }

    public static SuggestedActionScene U5(List r9) {
        if (q4() == true) goto L5;
        return null;
    L5:
        FLogger.a.i("AttachmentPanelComponent", "[resolveAudioSuggestedActionScene] use new scene");
        if (r9 != null) goto L8;
        r9 = CollectionsKt.emptyList();
    L8:
        ArrayList r0 = new ArrayList();
        ArrayList r2 = new ArrayList();
        Iterator r10 = r9.iterator();
    L9:
        boolean r4 = false;
        if (r10.hasNext() == false) goto L23;
        Object r3 = r10.next();
        ResourceItemBean r6 = (ResourceItemBean) r3;
        if (r6.getResourceType() != ResourceType.AUDIO) goto L14;
    L19:
        r4 = true;
    L20:
        if (r4 == true) goto L21;
        r2.add(r3);
        goto L9
    L21:
        r0.add(r3);
        goto L9
    L14:
        if (r6.getResourceType() != ResourceType.FILE) goto L20;
        if (StringsKt.startsWith(r6.getMimeType(), "audio/", true) == true) goto L19;
        HashMap r7 = FileMimeTypeUtils.a;
        if (FileMimeTypeUtils.a(r6.getFileSuffixes()) == FileMimeTypeUtils.AudioMineTypeAbbr.UNCLEAR) goto L20;
    L23:
        Pair r11 = new Pair(r0, r2);
        List r1 = (List) r11.component1();
        List r12 = (List) r11.component2();
        if (r1.isEmpty() == false) goto L27;
        return null;
    L27:
        if (r12.isEmpty() == true) goto L29;
        List r13 = r12;
        if ((r13 instanceof Collection) == true) goto L33;
    L35:
        Iterator r5 = r13.iterator();
    L37:
        if (r5.hasNext() == false) goto L44;
        if (((ResourceItemBean) r5.next()).getResourceType() == ResourceType.FILE) goto L41;
        boolean r8 = true;
    L42:
        if (r8 == false) goto L37;
        boolean r14 = true;
    L45:
        if (r14 == false) goto L47;
        return null;
    L47:
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r16 = r13.iterator();
    L49:
        if (r16.hasNext() == false) goto L59;
        ResourceItemBean r17 = (ResourceItemBean) r16.next();
        String r18 = r17.getFileSuffixes().toLowerCase(Locale.ROOT);
        if (Intrinsics.areEqual(r18, "markdown") == false) goto L53;
        String r19 = "text/markdown";
    L57:
        r15.add(FileMimeTypeUtils.e(r19, null));
        goto L49
    L53:
        String r20 = FileMimeTypeUtils.c(r18);
        if (r20 != null) goto L56;
        r19 = r17.getMimeType();
        goto L57
    L56:
        r19 = r20;
        goto L57
    L59:
        if (r15.isEmpty() == true) goto L77;
        Iterator r21 = r15.iterator();
    L63:
        if (r21.hasNext() == false) goto L77;
        FileMimeTypeUtils.TextMineTypeAbbr r22 = (FileMimeTypeUtils.TextMineTypeAbbr) r21.next();
        if (r22 != FileMimeTypeUtils.TextMineTypeAbbr.XLS) goto L67;
    L74:
        boolean r23 = true;
    L75:
        if (r23 == true) goto L63;
        boolean r24 = false;
    L78:
        if (r24 == false) goto L81;
        return SuggestedActionScene.AttachmentAreaAudioSheet;
    L81:
        if (r15.isEmpty() == true) goto L109;
        Iterator r25 = r15.iterator();
    L85:
        if (r25.hasNext() == false) goto L109;
        FileMimeTypeUtils.TextMineTypeAbbr r26 = (FileMimeTypeUtils.TextMineTypeAbbr) r25.next();
        if (r26 != FileMimeTypeUtils.TextMineTypeAbbr.DOC) goto L89;
    L106:
        boolean r27 = true;
    L107:
        if (r27 == true) goto L85;
    L110:
        if (r4 == true) goto L112;
        return null;
    L112:
        return SuggestedActionScene.AttachmentAreaAudioFile;
    L89:
        if (r26 == FileMimeTypeUtils.TextMineTypeAbbr.DOCX) goto L106;
        if (r26 == FileMimeTypeUtils.TextMineTypeAbbr.PDF) goto L106;
        if (r26 == FileMimeTypeUtils.TextMineTypeAbbr.PPT) goto L106;
        if (r26 == FileMimeTypeUtils.TextMineTypeAbbr.PPTX) goto L106;
        if (r26 == FileMimeTypeUtils.TextMineTypeAbbr.TXT) goto L106;
        if (r26 == FileMimeTypeUtils.TextMineTypeAbbr.CODE) goto L106;
        if (r26 == FileMimeTypeUtils.TextMineTypeAbbr.AI_DOC) goto L106;
        if (r26 == FileMimeTypeUtils.TextMineTypeAbbr.AI_SLIDES) goto L106;
        r27 = false;
    L109:
        r4 = true;
        goto L110
    L67:
        if (r22 == FileMimeTypeUtils.TextMineTypeAbbr.XLSX) goto L74;
        if (r22 == FileMimeTypeUtils.TextMineTypeAbbr.CSV) goto L74;
        if (r22 == FileMimeTypeUtils.TextMineTypeAbbr.AI_SHEET) goto L74;
        r23 = false;
    L77:
        r24 = true;
        goto L78
    L41:
        r8 = false;
    L44:
        r14 = false;
        goto L45
    L33:
        if (r13.isEmpty() == false) goto L35;
    L29:
        return SuggestedActionScene.AttachmentAreaAudio;
    }

    public static boolean h5(UplinkFileEntity r5) {
        if (n1.d(r5) == false) goto L5;
        return true;
    L5:
        if (n1.e(r5) == true) goto L48;
        Uri r0 = r5.getUri();
        if (r0 == null) goto L14;
        ImFileUtil.a.getClass();
        if (ImFileUtil.w(r0) == false) goto L12;
    L13:
        return true;
    L12:
        if (ImFileUtil.y(r0) == true) goto L13;
    L14:
        UplinkEntityContent r1 = r5.getUplinkEntityContent();
        if (r1 == null) goto L17;
        UplinkFileInfo r2 = r1.getUplinkFileInfo();
    L19:
        if (r2 == null) goto L22;
        String r4 = r2.getMimeType();
        if (r4 == null) goto L22;
    L31:
        if (r4 != null) goto L33;
    L35:
        boolean r3 = false;
    L36:
        if (r3 == true) goto L47;
        if (r4 != null) goto L39;
    L41:
        boolean r6 = false;
    L42:
        if (r6 == true) goto L49;
        return false;
    L49:
        return true;
    L39:
        if (StringsKt.startsWith$default(r4, "video/", false, 2, null) != true) goto L41;
        r6 = true;
        goto L42
    L47:
        return true;
    L33:
        if (StringsKt.startsWith$default(r4, "image/", false, 2, null) != true) goto L35;
        r3 = true;
    L22:
        ImFileUtil r7 = ImFileUtil.a;
        if (r2 == null) goto L26;
        String r8 = r2.getLocalResPath();
        if (r8 == null) goto L26;
    L29:
        Uri r9 = UriProtector.parse(r8);
        r7.getClass();
        r4 = ImFileUtil.i(r9);
    L26:
        r8 = l1.a(r5);
        if (r8 != null) goto L29;
        return false;
    L17:
        r2 = null;
        goto L19
    L48:
        return true;
    }

    public static final boolean p3(AttachmentPanelComponent r2) {
        if (((UploadUiStyle) r2.H1.getValue()) == UploadUiStyle.LOCAL_DRIVE) goto L7;
        if (((UploadUiStyle) r2.H1.getValue()) == UploadUiStyle.LOCAL_DRIVE_RECENT) goto L7;
    L9:
        return false;
    L7:
        if (FlowDriveSdkService.a.h() == false) goto L9;
        return true;
    }

    public final String B3(UplinkFileEntity r4) {
        Image r5 = l1.c(r4);
        if (r5 != null) goto L5;
        return null;
    L5:
        String r1 = r5.localResPath;
        if (r1 != null) goto L8;
    L12:
        ImageObj r2 = r5.imageOri;
        if (r2 == null) goto L19;
        r1 = r2.url;
        if (r1 == null) goto L19;
        if ((!StringsKt.isBlank(r1)) == false) goto L19;
    L20:
        if (r1 != null) goto L43;
        ImageObj r3 = r5.previewImage;
        if (r3 == null) goto L28;
        r1 = r3.url;
        if (r1 == null) goto L28;
        if ((!StringsKt.isBlank(r1)) == false) goto L28;
    L29:
        if (r1 != null) goto L43;
        ImageObj r6 = r5.imageThumb;
        if (r6 == null) goto L37;
        r1 = r6.url;
        if (r1 == null) goto L37;
        if ((!StringsKt.isBlank(r1)) == false) goto L37;
    L38:
        if (r1 != null) goto L43;
        String r7 = r5.key;
        if (r7 != null) goto L45;
        return null;
    L45:
        return (String) ((LinkedHashMap) this.Z).get(r7);
    L37:
        r1 = null;
    L28:
        r1 = null;
    L43:
        return r1;
    L19:
        r1 = null;
        goto L20
    L8:
        if (m5.c(r1) == true) goto L11;
        r1 = null;
    L11:
        if (r1 != null) goto L43;
        goto L12
    }

    public final Drawable D6(Drawable r5) {
        if (this.H == true) goto L5;
        return r5;
    L5:
        Drawable r6 = r5.mutate();
        r6.setTint(ContextCompat.getColor(getContext(), v19.c.b(2130970536, getContext(), 2131102551)));
        return r6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final void EC(UplinkFileEntity r22) {
        String r1 = this;
        Intrinsics.checkNotNullParameter(r22, "entity");
        op8.k r3 = B4();
        if (r3 == null) goto L60;
        Fragment r2 = r3.a();
        if (r2 == null) goto L66;
        g1 r4 = s1a.a.g(r2).getAbility(g1.class);
        if (r4 == null) goto L67;
        r4.EC(r22);
        return;
    L67:
        return;
    L66:
        return;
    L60:
        String r5 = r22.getFileIdentifier();     // Catch: IndexOutOfBoundsException -> L53
        int r6 = 0;
        if (r5 == null) goto L37;
        boolean r7 = true;
        if (r5.length() <= 0) goto L15;
        boolean r8 = true;
    L16:
        Integer r9 = null;
        if (r8 == true) goto L20;
        r5 = null;
    L20:
        if (r5 == null) goto L37;
        Iterator r10 = ((ArrayList) r1.J).iterator();     // Catch: IndexOutOfBoundsException -> L53
        int r11 = 0;
    L23:
        if (r10.hasNext() == false) goto L28;
        if (Intrinsics.areEqual(((UplinkFileEntity) r10.next()).getFileIdentifier(), r5) == true) goto L29;
        r11 = r11 + 1;     // Catch: IndexOutOfBoundsException -> L53
    L29:
        Integer r12 = Integer.valueOf(r11);     // Catch: IndexOutOfBoundsException -> L53
        if (r12.intValue() >= 0) goto L33;
        r7 = false;
    L33:
        if (r7 == false) goto L35;
        r9 = r12;
    L35:
        if (r9 == null) goto L37;
        int r15 = r9.intValue();     // Catch: IndexOutOfBoundsException -> L53
    L58:
        if (r15 < 0) goto L49;
        FLogger.a.i("AttachmentPanelComponent", "[updateAttachmentEntity] " + r22);     // Catch: IndexOutOfBoundsException -> L53
        List<UplinkFileEntity> r14 = r1.J;     // Catch: IndexOutOfBoundsException -> L53
        r1 = "AttachmentPanelComponent";
        ListProtector.set(r14, r15, UplinkFileEntity.copy$default(r22, null, null, null, null, null, null, null, null, null, false, null, null, null, null, 16383, null));     // Catch: IndexOutOfBoundsException -> L51
        x5();     // Catch: IndexOutOfBoundsException -> L51
    L57:
        return;
    L49:
        String r13 = "AttachmentPanelComponent";
        FLogger.a.e(r13, "[updateAttachmentEntity] not in list");     // Catch: IndexOutOfBoundsException -> L51
        r1 = r13;
    L51:
        e = e;
    L55:
        FLogger.a.e(r1, "[updateAttachmentEntity] IndexOutOfBoundsException: " + e.getMessage(), e);
        return;
    L28:
        r11 = -1;
        goto L29
    L15:
        r8 = false;
    L37:
        Iterator r16 = ((ArrayList) r1.J).iterator();     // Catch: IndexOutOfBoundsException -> L53
    L39:
        if (r16.hasNext() == false) goto L44;
        if (Intrinsics.areEqual(((UplinkFileEntity) r16.next()).getUri(), r22.getUri()) == true) goto L42;
        r6 = r6 + 1;     // Catch: IndexOutOfBoundsException -> L53
        goto L39
    L42:
        r15 = r6;
        goto L58
    L44:
        r15 = -1;
    L53:
        e = e;
        r1 = "AttachmentPanelComponent";
        goto L55
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final void EZ(boolean r2) {
        boolean r0 = UploadFilePolicy.a;
        UploadFilePolicy.a = r2;
        mt8.a r3 = this.m;
        if (r3 == null) goto L6;
        r3.d();
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final void Es(boolean r2) {
        if (this.I != r2) goto L5;
        return;
    L5:
        this.I = r2;
        C6();
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final void Mi(boolean r3) {
        mt8.a r0 = this.m;
        if (r0 == null) goto L17;
        View r1 = r0.getView();
        if (r1 == null) goto L20;
        boolean r2 = false;
        if (r3 == false) goto L14;
        if (r1.getVisibility() != 0) goto L12;
        r2 = true;
    L12:
        this.G1 = r2;
        com.larus.utils.e1.o(r1);
        return;
    L14:
        if (this.G1 == false) goto L19;
        this.G1 = false;
        com.larus.utils.e1.x(r1);
        return;
    L19:
        return;
    L20:
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final void Pq(boolean r3) {
        int r0 = od8.h0.a;
        com.larus.bmhome.instruction.g r1 = vc();
        Integer r2 = null;
        if (r1 == null) goto L5;
        Integer r4 = Integer.valueOf(r1.Q1());
    L7:
        if (od8.h0.f(r4) == true) goto L14;
        com.larus.bmhome.instruction.g r5 = vc();
        if (r5 == null) goto L12;
        r2 = Integer.valueOf(r5.Q1());
    L12:
        if (od8.h0.i(r2) == true) goto L14;
        if (r3 == true) goto L14;
        return;
    L14:
        mt8.a r6 = this.m;
        if (r6 == null) goto L35;
        View r7 = r6.getView();
        if (r7 == null) goto L37;
        ViewGroup r8 = F4();     // Catch: Exception -> L29
        if (r8 == null) goto L22;
        r8.removeView(r7);     // Catch: Exception -> L29
    L22:
        ViewGroup r9 = F4();     // Catch: Exception -> L29
        if (r9 == null) goto L25;
        com.larus.utils.e1.o(r9);     // Catch: Exception -> L29
    L25:
        com.larus.bmhome.instruction.g r10 = vc();     // Catch: Exception -> L29
        if (r10 == null) goto L36;
        r10.oP(r7);     // Catch: Exception -> L29
        Unit r11 = Unit.INSTANCE;     // Catch: Exception -> L29
        return;
    L36:
        return;
    L29:
        e = move-exception;
        com.larus.platform.service.g.a.ensureNotReachHere(e);
        Unit r12 = Unit.INSTANCE;
        return;
    L37:
        return;
    L35:
        return;
    L5:
        r4 = null;
        goto L7
    }

    public final com.larus.bmhome.chat.component.bottom.attachment.g V3(SuggestedActionScene r30) {
        String r2 = K();
        ICoreInputAbility r1 = l4();
        if (r1 != null) goto L5;
    L7:
        boolean r17 = false;
    L9:
        if (r17 == false) goto L17;
        ICoreInputAbility r3 = l4();
        if (r3 == null) goto L13;
        String r4 = r3.EW();
    L15:
        if (Intrinsics.areEqual(r4, "inject_input_photo_picker") == false) goto L17;
        boolean r18 = true;
    L18:
        j1 r5 = Y3();
        if (r5 == null) goto L21;
        Integer r6 = Integer.valueOf(r5.a());
    L22:
        Set<SuggestedActionScene> r7 = AlbumEduIntentSuggestSnapshotFactory.a;
        String r8 = X3();
        String r9 = this.B;
        List r27 = CollectionsKt.toList(this.J);
        boolean r11 = z2.a.getAttachmentAlbumDetectConfig().b();
        boolean r12 = AppHost.a.isOversea();
        AccountService r10 = AccountService.a;
        boolean r13 = r10.isEnterpriseAccount();
        boolean r14 = r10.a();
        boolean r15 = com.larus.bmhome.utils.i.f(H3());
        Intrinsics.checkNotNullParameter(this, "<this>");
        if ((com.larus.ui.arch.component.internal.attach.a.b(this, this) instanceof xe8.a) == true) goto L27;
        if (r18 == true) goto L27;
        boolean r16 = false;
    L28:
        com.larus.bmhome.instruction.g r19 = vc();
        if (r19 != null) goto L31;
    L33:
        boolean r110 = false;
    L34:
        com.larus.bmhome.instruction.g r20 = vc();
        if (r20 != null) goto L37;
    L39:
        boolean r21 = false;
    L40:
        if (r6 != null) goto L42;
    L44:
        boolean r22 = false;
    L45:
        if (r6 != null) goto L47;
    L49:
        boolean r23 = false;
    L50:
        boolean r24 = q5();
        if (i9() == false) goto L60;
        com.larus.bmhome.chat.component.bottom.reference.a r25 = g5();
        if (r25 != null) goto L55;
    L57:
        boolean r26 = false;
    L58:
        if (r26 == false) goto L60;
        boolean r28 = true;
    L61:
        AlbumEduIntentSuggestSnapshotFactory.c r29 = new AlbumEduIntentSuggestSnapshotFactory.c(r2, r30, r8, r9, r27, new AlbumEduIntentSuggestSnapshotFactory.b(r11, r12, r13, r14, r15, r16, r17, r18, r110, r21, r22, r23, r24, r28, !this.V.isEmpty(), this.p0));
        Intrinsics.checkNotNullParameter(r29, "input");
        AlbumEduIntentSuggestSnapshotFactory.b r31 = r29.f;
        SuggestedActionScene r32 = r29.b;
        if (r32 != null) goto L66;
        AlbumEduIntentSuggestSnapshotFactory.BlockReason r33 = AlbumEduIntentSuggestSnapshotFactory.BlockReason.BASE_SCENE_UNAVAILABLE;
    L64:
        AlbumEduIntentSuggestSnapshotFactory.BlockReason r34 = r33;
    L133:
        if (r34 == null) goto L135;
        AlbumEduIntentSuggestSnapshotFactory.a(r29, r34, null);
    L265:
        return null;
    L135:
        SuggestedActionScene r35 = r29.b;
        if (r35 != null) goto L138;
        AlbumEduIntentSuggestSnapshotFactory.a(r29, AlbumEduIntentSuggestSnapshotFactory.BlockReason.BASE_SCENE_UNAVAILABLE, null);
        goto L265
    L138:
        UplinkFileEntity r36 = (UplinkFileEntity) CollectionsKt.first(r29.e);
        Image r37 = l1.c(r36);
        Uri r38 = r36.getUri();
        if (r38 != null) goto L141;
    L145:
        String r39 = l1.d(r36);
        if (r39 != null) goto L148;
    L157:
        r38 = null;
    L158:
        if (r37 == null) goto L168;
        ImageObj r40 = r37.imageOri;
        if (r40 == null) goto L168;
        String r41 = r40.url;
        if (r41 == null) goto L168;
        if ((!StringsKt.isBlank(r41)) == true) goto L167;
        r41 = null;
    L167:
        if (r41 == null) goto L168;
    L177:
        if (r37 == null) goto L193;
        Map r42 = r37.ext;
        if (r42 != null) goto L181;
    L183:
        boolean r43 = false;
    L184:
        if (r43 == false) goto L186;
        Image r44 = r37;
    L187:
        if (r44 == null) goto L193;
        String r45 = r44.key;
        if (r45 == null) goto L193;
        if ((!StringsKt.isBlank(r45)) == false) goto L193;
    L195:
        if (CollectionsKt.contains(AlbumEduIntentSuggestSnapshotFactory.b, r29.d) == true) goto L198;
        if (r45 != null) goto L198;
        AlbumEduIntentSuggestSnapshotFactory.a(r29, AlbumEduIntentSuggestSnapshotFactory.BlockReason.UNSUPPORTED_ATTACHMENT_SOURCE, "driveTokenAvailable=false");
    L198:
        if (r45 == null) goto L200;
        com.larus.bmhome.chat.component.bottom.attachment.a r46 = new com.larus.bmhome.chat.component.bottom.attachment.a.C0043a(r45);
    L204:
        com.larus.bmhome.chat.component.bottom.attachment.a r111 = r46;
    L206:
        List<UplinkFileEntity> r47 = r29.e;
        if ((r47 instanceof Collection) == true) goto L209;
    L211:
        Iterator<T> r48 = r47.iterator();
    L213:
        if (r48.hasNext() == false) goto L217;
        if (Intrinsics.areEqual(((UplinkFileEntity) r48.next()).isFromDraft(), Boolean.TRUE) == false) goto L213;
        boolean r112 = true;
    L218:
        if (r112 == true) goto L221;
        if (r111 != null) goto L221;
        AlbumEduIntentSuggestSnapshotFactory.a(r29, AlbumEduIntentSuggestSnapshotFactory.BlockReason.IMAGE_SOURCE_UNAVAILABLE, null);
    L221:
        String r49 = r36.getFileIdentifier();
        if (r49 != null) goto L224;
    L226:
        r49 = null;
    L227:
        if (r37 == null) goto L233;
        String r50 = r37.key;
        if (r50 == null) goto L233;
        if ((!StringsKt.isBlank(r50)) == false) goto L233;
    L235:
        if ((r111 instanceof com.larus.bmhome.chat.component.bottom.attachment.a.b) == false) goto L239;
        AlbumEduIntentSuggestSnapshotFactory.a r51 = new AlbumEduIntentSuggestSnapshotFactory.a(AlbumEduIntentSuggestSnapshotFactory.b(r111), "image_source");
    L237:
        AlbumEduIntentSuggestSnapshotFactory.a r52 = r51;
    L254:
        if (r52 != null) goto L257;
        AlbumEduIntentSuggestSnapshotFactory.a(r29, AlbumEduIntentSuggestSnapshotFactory.BlockReason.CACHE_KEY_UNAVAILABLE, "source=" + com.larus.bmhome.chat.component.bottom.attachment.h.b(r111));
        goto L265
    L257:
        com.larus.bmhome.chat.component.bottom.attachment.g r53 = new com.larus.bmhome.chat.component.bottom.attachment.g(r29.a, r52.a, r111, r35, r29.c, r29.e, r112);
        FLogger.a.i("AlbumEduSnapshotFactory", "[create] success, " + com.larus.bmhome.chat.component.bottom.attachment.h.a(r53) + ", firstFromScene=" + r29.d + ", cacheKeyOrigin=" + r52.b);
        return r53;
    L239:
        if ((r111 instanceof com.larus.bmhome.chat.component.bottom.attachment.a.c) == false) goto L241;
    L251:
        if (r50 == null) goto L253;
        r51 = new AlbumEduIntentSuggestSnapshotFactory.a(r50, "image_key");
        goto L237
    L253:
        r51 = new AlbumEduIntentSuggestSnapshotFactory.a(AlbumEduIntentSuggestSnapshotFactory.b(r111), "image_source");
        goto L237
    L241:
        if ((r111 instanceof com.larus.bmhome.chat.component.bottom.attachment.a.C0043a) == true) goto L251;
        if (r111 != null) goto L250;
        if (r49 == null) goto L246;
        r52 = new AlbumEduIntentSuggestSnapshotFactory.a(r49, "file_identifier");
        goto L254
    L246:
        if (r50 == null) goto L248;
        r51 = new AlbumEduIntentSuggestSnapshotFactory.a(r50, "image_key");
        goto L237
    L248:
        r52 = null;
        goto L254
    L250:
        throw new NoWhenBranchMatchedException();
    L233:
        r50 = null;
        goto L235
    L224:
        if ((!StringsKt.isBlank(r49)) == false) goto L226;
    L217:
        r112 = false;
        goto L218
    L209:
        if (r47.isEmpty() == false) goto L211;
    L200:
        if (r38 == null) goto L202;
        r111 = new com.larus.bmhome.chat.component.bottom.attachment.a.b(r38);
        goto L206
    L202:
        if (r41 == null) goto L205;
        r46 = new com.larus.bmhome.chat.component.bottom.attachment.a.c(r41);
        goto L204
    L205:
        r111 = null;
        goto L206
    L186:
        r44 = null;
        goto L187
    L181:
        if (r42.containsKey("ext_is_from_drive") != true) goto L183;
        r43 = true;
    L193:
        r45 = null;
    L168:
        if (r37 == null) goto L176;
        ImageObj r54 = r37.imageThumb;
        if (r54 == null) goto L176;
        r41 = r54.url;
        if (r41 == null) goto L176;
        if ((!StringsKt.isBlank(r41)) == true) goto L177;
    L176:
        r41 = null;
        goto L177
    L148:
        if ((!StringsKt.isBlank(r39)) == true) goto L151;
        r39 = null;
    L151:
        if (r39 == null) goto L157;
        r38 = UriProtector.parse(r39);
        if (r38 == null) goto L157;
        if (AlbumEduIntentSuggestSnapshotFactory.c(r38) == false) goto L157;
    L141:
        if (AlbumEduIntentSuggestSnapshotFactory.c(r38) == true) goto L144;
        r38 = null;
    L144:
        if (r38 != null) goto L158;
    L66:
        if (r31.p == false) goto L69;
        r33 = AlbumEduIntentSuggestSnapshotFactory.BlockReason.FORCE_DISABLE_ALBUM_INTENT;
        goto L64
    L69:
        if (r31.a == true) goto L72;
        r33 = AlbumEduIntentSuggestSnapshotFactory.BlockReason.DETECT_DISABLED;
        goto L64
    L72:
        if (r31.b == false) goto L75;
        r33 = AlbumEduIntentSuggestSnapshotFactory.BlockReason.OVERSEA;
        goto L64
    L75:
        if (r31.c == false) goto L78;
        r33 = AlbumEduIntentSuggestSnapshotFactory.BlockReason.ENTERPRISE_ACCOUNT;
        goto L64
    L78:
        if (r31.d == false) goto L81;
        r33 = AlbumEduIntentSuggestSnapshotFactory.BlockReason.MINOR_MODE;
        goto L64
    L81:
        if (r31.e == true) goto L84;
        r33 = AlbumEduIntentSuggestSnapshotFactory.BlockReason.NOT_MAIN_BOT_CONVERSATION;
        goto L64
    L84:
        if (r31.f == true) goto L87;
        r33 = AlbumEduIntentSuggestSnapshotFactory.BlockReason.NOT_MAIN_BOT_HOST_SCENE;
        goto L64
    L87:
        if (r31.g == false) goto L92;
        if (r31.h == true) goto L92;
        r33 = AlbumEduIntentSuggestSnapshotFactory.BlockReason.UNSUPPORTED_INJECT_INPUT;
    L92:
        if (r31.i == false) goto L95;
        r33 = AlbumEduIntentSuggestSnapshotFactory.BlockReason.INSTRUCTION_OPEN;
        goto L64
    L95:
        if (r31.j == false) goto L98;
        r33 = AlbumEduIntentSuggestSnapshotFactory.BlockReason.IMAGE_ATTACHMENT_INSTRUCTION_OPEN;
        goto L64
    L98:
        if (r31.k == false) goto L101;
        r33 = AlbumEduIntentSuggestSnapshotFactory.BlockReason.DRAFT_IMAGE_ATTACHMENT_INSTRUCTION;
        goto L64
    L101:
        if (r31.l == false) goto L104;
        r33 = AlbumEduIntentSuggestSnapshotFactory.BlockReason.DRAFT_PODCAST_INSTRUCTION;
        goto L64
    L104:
        if (r31.m == false) goto L107;
        r33 = AlbumEduIntentSuggestSnapshotFactory.BlockReason.SUGGESTED_ACTION_FORCED_BANNED;
        goto L64
    L107:
        if (r31.n == false) goto L110;
        r33 = AlbumEduIntentSuggestSnapshotFactory.BlockReason.REFERENCE_MESSAGE_BANNED;
        goto L64
    L110:
        if (r31.o == false) goto L113;
        r33 = AlbumEduIntentSuggestSnapshotFactory.BlockReason.CUSTOM_RESOURCE_BAR_ITEMS_EXIST;
        goto L64
    L113:
        if (AlbumEduIntentSuggestSnapshotFactory.a.contains(r32) == true) goto L116;
        r33 = AlbumEduIntentSuggestSnapshotFactory.BlockReason.UNSUPPORTED_SUGGESTED_ACTION_SCENE;
        goto L64
    L116:
        if (r29.e.isEmpty() == false) goto L118;
        r33 = AlbumEduIntentSuggestSnapshotFactory.BlockReason.EMPTY_ATTACHMENTS;
        goto L64
    L118:
        List<UplinkFileEntity> r55 = r29.e;
        if ((r55 instanceof Collection) == true) goto L121;
    L123:
        Iterator<T> r56 = r55.iterator();
    L125:
        if (r56.hasNext() == false) goto L129;
        if ((!n1.d((UplinkFileEntity) r56.next())) == false) goto L125;
        boolean r57 = true;
    L130:
        if (r57 == false) goto L132;
        r33 = AlbumEduIntentSuggestSnapshotFactory.BlockReason.NON_IMAGE_ATTACHMENT_EXISTS;
        goto L64
    L132:
        r34 = null;
    L129:
        r57 = false;
        goto L130
    L121:
        if (r55.isEmpty() == false) goto L123;
    L55:
        if (r25.LX() != true) goto L57;
        r26 = true;
    L60:
        r28 = false;
        goto L61
    L47:
        if (od8.h0.g(r6) != true) goto L49;
        r23 = true;
        goto L50
    L42:
        if (od8.h0.e(r6) != true) goto L44;
        r22 = true;
        goto L45
    L37:
        if (r20.Wa() != true) goto L39;
        r21 = true;
        goto L40
    L31:
        if (r19.z0() != true) goto L33;
        r110 = true;
    L27:
        r16 = true;
        goto L28
    L21:
        r6 = null;
        goto L22
    L13:
        r4 = null;
    L17:
        r18 = false;
        goto L18
    L5:
        if (r1.c1() != true) goto L7;
        r17 = true;
        goto L9
    }

    public final String V5(String r3) {
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return "empty";
    L10:
        return "len=" + r3.length() + ",hash=" + r3.hashCode();
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final int Y40(Function1<? super UplinkFileEntity, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r5, "filter");
        List<UplinkFileEntity> r0 = this.J;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        Object r3 = r2.next();
        if (((Boolean) r5.invoke((UplinkFileEntity) r3)).booleanValue() == false) goto L4;
        r1.add(r3);
        goto L4
    L9:
        return r1.size();
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final void b2(String r2) {
        Intrinsics.checkNotNullParameter(r2, "localMsgID");
        NestedFileCacheManagerService.b.b2(r2);
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final NestedFileContent b6(String r2) {
        Intrinsics.checkNotNullParameter(r2, "localMsgID");
        return NestedFileCacheManagerService.b.b6(r2);
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final void bD(UplinkFileEntity r8) {
        Intrinsics.checkNotNullParameter(r8, "entity");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AttachmentPanelComponent$addDirectSendAttachmentEntity$1(this, r8, null), 2, null);
    }

    public final boolean d5(UplinkFileEntity r11) {
        int r0 = com.larus.utils.p0.a;
        String r1 = com.larus.utils.p0.a(l1.g(r11));
        UplinkEntityContent r2 = r11.getUplinkEntityContent();
        if (r2 == null) goto L11;
        UplinkFileInfo r3 = r2.getUplinkFileInfo();
        if (r3 == null) goto L11;
        String r4 = r3.getTosKey();
        if (r4 == null) goto L11;
        String r5 = com.larus.utils.p0.a(r4);
        if (r5 == null) goto L11;
    L19:
        String r12 = com.larus.utils.p0.a(r11.getFileIdentifier());
        List<UplinkFileEntity> r6 = this.J;
        if ((r6 instanceof Collection) == true) goto L22;
    L24:
        Iterator r7 = ((ArrayList) r6).iterator();
    L26:
        if (r7.hasNext() == false) goto L83;
        UplinkFileEntity r8 = (UplinkFileEntity) r7.next();
        int r9 = com.larus.utils.p0.a;
        String r10 = com.larus.utils.p0.a(l1.g(r8));
        UplinkEntityContent r13 = r8.getUplinkEntityContent();
        if (r13 == null) goto L36;
        UplinkFileInfo r14 = r13.getUplinkFileInfo();
        if (r14 == null) goto L36;
        String r15 = r14.getTosKey();
        if (r15 == null) goto L36;
        String r16 = com.larus.utils.p0.a(r15);
        if (r16 == null) goto L36;
    L44:
        String r17 = com.larus.utils.p0.a(r8.getFileIdentifier());
        if (r1 != null) goto L47;
    L50:
        boolean r18 = true;
    L51:
        if (r18 == false) goto L53;
    L54:
        if (r5 != null) goto L56;
    L59:
        boolean r19 = true;
    L60:
        if (r19 == false) goto L62;
    L63:
        if (r12 != null) goto L65;
    L68:
        boolean r20 = true;
    L69:
        if (r20 == false) goto L71;
    L73:
        boolean r21 = false;
    L74:
        if (r21 == false) goto L26;
        return true;
    L71:
        if (Intrinsics.areEqual(r12, r17) == false) goto L73;
    L72:
        r21 = true;
        goto L74
    L65:
        if (r12.length() == 0) goto L68;
        r20 = false;
        goto L69
    L62:
        if (Intrinsics.areEqual(r5, r16) == true) goto L72;
    L56:
        if (r5.length() == 0) goto L59;
        r19 = false;
        goto L60
    L53:
        if (Intrinsics.areEqual(r1, r10) == true) goto L72;
    L47:
        if (r1.length() == 0) goto L50;
        r18 = false;
    L36:
        UplinkEntityContent r22 = r8.getUplinkEntityContent();
        if (r22 == null) goto L43;
        Image r23 = r22.getUplinkImageInfo();
        if (r23 == null) goto L43;
        String r24 = r23.key;
        if (r24 == null) goto L43;
        r16 = com.larus.utils.p0.a(r24);
    L43:
        r16 = null;
        goto L44
    L83:
        return false;
    L22:
        if (((ArrayList) r6).isEmpty() == false) goto L24;
        return false;
    L11:
        UplinkEntityContent r25 = r11.getUplinkEntityContent();
        if (r25 == null) goto L18;
        Image r26 = r25.getUplinkImageInfo();
        if (r26 == null) goto L18;
        String r27 = r26.key;
        if (r27 == null) goto L18;
        r5 = com.larus.utils.p0.a(r27);
    L18:
        r5 = null;
        goto L19
    }

    public final void dJ(Function1<? super List<AttachmentSnapshot>, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.X.remove(r2);
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final void f50(UplinkFileEntity r20) {
        Intrinsics.checkNotNullParameter(r20, "entity");
        op8.k r2 = B4();
        if (r2 == null) goto L10;
        Fragment r3 = r2.a();
        if (r3 == null) goto L28;
        g1 r4 = s1a.a.g(r3).getAbility(g1.class);
        if (r4 == null) goto L29;
        r4.f50(r20);
        return;
    L29:
        return;
    L28:
        return;
    L10:
        List<UplinkFileEntity> r15 = this.J;
        ArrayList r16 = (ArrayList) r15;
        r16.add(UplinkFileEntity.copy$default(r20, null, null, null, null, null, null, null, null, null, false, null, null, null, null, 16383, null));
        if (q4() == true) goto L13;
    L26:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AttachmentPanelComponent$addAttachmentEntity$2(this, r20, null), 2, null);
        return;
    L13:
        if (this.E != AttachmentPanelType.MultiAudio) goto L26;
        if (n1.a(r20) == true) goto L26;
        ICoreInputAbility r1 = l4();
        if (r1 == null) goto L21;
        boolean r5 = true;
        if (r1.Pi() != true) goto L21;
    L22:
        if (r5 == false) goto L24;
        AttachmentPanelType r6 = AttachmentPanelType.MixImageFile;
    L25:
        this.E = r6;
        goto L26
    L24:
        r6 = AttachmentPanelType.MultiFile;
    L21:
        r5 = false;
        goto L22
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final void hF(boolean r1) {
        this.H = r1;
        C6();
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final void kS(Uri r5) {
        op8.k r0 = B4();
        if (r0 == null) goto L10;
        Fragment r1 = r0.a();
        if (r1 == null) goto L39;
        g1 r2 = s1a.a.g(r1).getAbility(g1.class);
        if (r2 == null) goto L40;
        r2.kS(r5);
        return;
    L40:
        return;
    L39:
        return;
    L10:
        FLogger.a.i("AttachmentPanelComponent", "[removeAttachmentEntityFromUri] uri: " + r5);
        Iterator<T> r3 = this.J.iterator();
    L12:
        if (r3.hasNext() == false) goto L21;
        Object r4 = r3.next();
        UplinkFileEntity r6 = (UplinkFileEntity) r4;
        if (r5 != null) goto L16;
    L18:
        boolean r7 = false;
    L19:
        if (r7 == false) goto L12;
    L22:
        UplinkFileEntity r8 = (UplinkFileEntity) r4;
        if (r8 == null) goto L32;
        NestedFileCacheManagerService r9 = NestedFileCacheManagerService.b;
        String r10 = this.P;
        String r11 = r8.getFileIdentifier();
        String r12 = "";
        if (r11 != null) goto L27;
        r11 = "";
    L27:
        r9.n(r10, r11);
        String r13 = this.P;
        String r14 = r8.getFileIdentifier();
        if (r14 == null) goto L31;
        r12 = r14;
    L31:
        r9.b(r13, r12);
        return;
    L32:
        FLogger.a.w("AttachmentPanelComponent", "[removeAttachmentEntityFromUri] No entity found for uri: " + r5);
        return;
    L16:
        if (Intrinsics.areEqual(r6.getUri(), r5) == false) goto L18;
        r7 = true;
        goto L19
    L21:
        r4 = null;
        goto L22
    }

    public final void m6(int r6) {
        com.larus.bmhome.instruction.g r0 = vc();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        FLogger.a.i("AttachmentPanelComponent", "isOpenedHasImgAttachInstruct:" + r1 + ",status:" + r6);
        if (r1 == true) goto L14;
        ICoreInputAbility r2 = l4();
        if (r2 == null) goto L15;
        r2.g2(r6, true);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        if (r0.Wa() != true) goto L7;
        r1 = true;
        goto L8
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final void nJ(com.larus.common.venue.impl.venue.component.f r1) {
        this.b2 = r1;
    }

    public final boolean nU(op8.b r12) {
        Intrinsics.checkNotNullParameter(r12, "snapshot");
        op8.k r0 = B4();
        if (r0 == null) goto L12;
        Fragment r1 = r0.a();
        if (r1 == null) goto L56;
        op8.d r2 = s1a.a.g(r1).getAbility(op8.d.class);
        if (r2 != null) goto L9;
        return false;
    L9:
        if (r2.nU(r12) != true) goto L58;
        return true;
    L58:
        return false;
    L56:
        return false;
    L12:
        ICoreInputAbility r3 = l4();
        if (r3 != null) goto L15;
        return false;
    L15:
        va8.o r10 = k4();
        if (r10 != null) goto L18;
        return false;
    L18:
        List r4 = snapshot().b;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r6 = r4.iterator();
    L20:
        if (r6.hasNext() == false) goto L22;
        AttachmentSnapshot r7 = (AttachmentSnapshot) r6.next();
        r5.add(TuplesKt.to(r7.getStableId(), r7.effectiveRef()));
        goto L20
    L22:
        List r8 = r12.b;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r11 = r8.iterator();
    L24:
        if (r11.hasNext() == false) goto L27;
        AttachmentSnapshot r13 = (AttachmentSnapshot) r11.next();
        r9.add(TuplesKt.to(r13.getStableId(), r13.effectiveRef()));
        goto L24
    L27:
        if (Intrinsics.areEqual(r5, r9) == true) goto L29;
        return false;
    L29:
        NestedFileContent r14 = NestedFileCacheManagerService.b.b6(this.P);
        if (r14 == null) goto L32;
        List r15 = r14.getEntities();
    L33:
        if (r15 != null) goto L35;
        r15 = CollectionsKt.emptyList();
    L35:
        List r16 = r15;
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator r18 = r16.iterator();
        int r19 = 0;
    L37:
        if (r18.hasNext() == false) goto L43;
        Object r20 = r18.next();
        int r21 = r19 + 1;
        if (r19 >= 0) goto L41;
        CollectionsKt.throwIndexOverflow();
    L41:
        AttachmentSnapshot r22 = d1.e((UplinkFileEntity) r20, r19);
        r17.add(TuplesKt.to(r22.getStableId(), r22.effectiveRef()));
        r19 = r21;
        goto L37
    L43:
        if (Intrinsics.areEqual(r17, r5) == true) goto L46;
        FLogger.a.e("AttachmentPanelComponent", "[send] attachment owner/cache identity mismatch, owner=" + r5.size() + ", cache=" + r17.size());
        return false;
    L46:
        ICoreInputAbility.b.d(r3, r12.a, false, false, null, null, false, 56);
        if (Intrinsics.areEqual(r10.u7(), r12.a) == true) goto L50;
        return false;
    L50:
        return y5(r3, r10, r12.a, r12.c, r12.d, r12.e, r12.f, r12.g);
    L32:
        r15 = null;
        goto L33
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.larus.bmhome.chat.component.bottom.attachment.v] */
    public final void onViewCreated(View r6) {
        Intrinsics.checkNotNullParameter(r6, "view");
        Intrinsics.checkNotNullParameter(new g9.b(r6), "finder");
        String r0 = null;
        if (r6 == null) goto L5;
        View r7 = r6.findViewById(2131377552);
    L6:
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.larus.bmhome.view.resourcebar.bean.IResourceItemOperator");
        this.m = (mt8.a) r7;
        LocalTakePictureImpl r8 = (LocalTakePictureImpl) this.b1.getValue();
        Intrinsics.checkNotNullParameter(this, "<this>");
        r8.d(com.larus.ui.arch.component.internal.attach.a.b(this, this), new g0(this), new h0(this));
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), new e1(this), com.larus.bmhome.chat.component.bottom.core.speaker.n.class);
        op8.k r9 = B4();
        if (r9 == null) goto L31;
        Fragment r1 = r9.a();
        if (r1 == null) goto L11;
        op8.d r2 = (op8.d) s1a.a.g(r1).getAbility(op8.d.class);
    L12:
        this.R = r2;
        if (r2 == null) goto L15;
        r2.zN(this.T);
    L15:
        ICoreInputAbility r3 = l4();
        if (r3 == null) goto L32;
        k9 r4 = new k9(r9, r3, new v(this));
        ICoreInputAbility r10 = r4.d;
        if (r10 == null) goto L20;
        r10.QG(r4.f);
    L20:
        r4.b.QG(r4.g);
        Fragment r11 = r4.a.a();
        if (r11 == null) goto L27;
        op8.d r12 = s1a.a.g(r11).getAbility(op8.d.class);
        if (r12 == null) goto L27;
        op8.b r13 = r12.snapshot();
        if (r13 == null) goto L27;
        r0 = r13.a;
    L27:
        if (r0 != null) goto L29;
        r0 = "";
    L29:
        r4.a(r0);
        this.S = r4;
        return;
    L32:
        return;
    L11:
        r2 = null;
        goto L12
    L31:
        return;
    L5:
        r7 = null;
        goto L6
    }

    public final boolean r6(UplinkFileEntity r7) {
        Map r0 = r7.getExtra();
        if (r0 == null) goto L41;
        String r1 = (String) r0.get("originFileTypeString");
        if (r1 == null) goto L41;
        int r2 = bq9.a.a;
        if (l1.k(r1) == true) goto L10;
        return false;
    L10:
        UplinkEntityContent r8 = r7.getUplinkEntityContent();
        if (r8 == null) goto L41;
        UplinkFileInfo r9 = r8.getUplinkFileInfo();
        if (r9 == null) goto L41;
        String r10 = r9.getTosKey();
        if (r10 == null) goto L41;
        if ((!StringsKt.isBlank(r10)) == true) goto L20;
        r10 = null;
    L20:
        if (r10 == null) goto L41;
        Intrinsics.checkNotNullParameter(this, "<this>");
        sd8.a r3 = s1a.a.g(com.larus.ui.arch.component.internal.attach.a.b(this, this)).getAbility(sd8.a.class);
        if (r3 == null) goto L41;
        qy8.a r4 = r3.yu();
        if (r4 == null) goto L41;
        qy8.b r5 = r4.d;
        if (r5 == null) goto L41;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L29
        Intrinsics.checkNotNullParameter(this, "<this>");     // Catch: Throwable -> L29
        Object r11 = Result.constructor-impl(Boolean.valueOf(r5.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), r10)));     // Catch: Throwable -> L29
    L31:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L34;
        FLogger.a.w("AttachmentPanelComponent", "chat host artifact interceptor failed, resourceId=" + V5(r10), r12);
    L34:
        Boolean r13 = Boolean.FALSE;
        if (Result.isFailure-impl(r11) == false) goto L37;
        r11 = r13;
    L37:
        boolean r14 = ((Boolean) r11).booleanValue();
        if (r14 == false) goto L40;
        FLogger.a.i("AttachmentPanelComponent", "chat host artifact interceptor consumed resourceId=" + V5(r10));
    L40:
        return r14;
    L29:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
    L41:
        return false;
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final void rv(boolean r6) {
        ICoreInputAbility r0 = l4();
        if (r0 != null) goto L5;
        return;
    L5:
        int r2 = 3;
        boolean r3 = false;
        if (z2.a.enableAudioInputWithAttachment() != 1) goto L19;
        this.G = r6;
        int r7 = r0.Rp();
        com.larus.bmhome.instruction.g r1 = vc();
        if (r1 != null) goto L10;
    L12:
        if (r3 == false) goto L14;
        m6(r7);
        return;
    L14:
        if (r7 != 2) goto L17;
        r2 = 2;
    L17:
        m6(r2);
        return;
    L10:
        if (r1.z0() != true) goto L12;
        r3 = true;
        goto L12
    L19:
        com.larus.bmhome.instruction.g r4 = vc();
        if (r4 != null) goto L22;
    L24:
        if (r3 == true) goto L30;
        if (r6 == false) goto L31;
        m6(3);
        return;
    L31:
        return;
    L30:
        return;
    L22:
        if (r4.z0() != true) goto L24;
        r3 = true;
        goto L24
    }

    public final FlowResourceScene s5(String r4) {
        switch(r4.hashCode()) {
            case -2113586946: goto L27;
            case 3143036: goto L23;
            case 92896879: goto L12;
            case 109413407: goto L9;
            case 249793358: goto L6;
            default: goto L31;
        };
    L6:
        if (r4.equals("album_ocr") == false) goto L31;
    L35:
        return FlowResourceScene.ImageOCR;
    L9:
        if (r4.equals("shoot") == false) goto L31;
    L14:
        com.larus.bmhome.instruction.g r5 = vc();
        if (r5 == null) goto L17;
        int r6 = r5.Q1();
    L19:
        if (CollectionsKt.listOf(new Integer[]{12, 7, 13, 29, 23}).contains(Integer.valueOf(r6)) == false) goto L33;
        return FlowResourceScene.ImageEDU;
    L33:
        return FlowResourceScene.ImageVLM;
    L17:
        r6 = 0;
        goto L19
    L12:
        if (r4.equals("album") == true) goto L14;
    L23:
        if (r4.equals("file") == false) goto L31;
        return FlowResourceScene.FileUpload;
    L27:
        if (r4.equals("shoot_ocr") == true) goto L35;
    L31:
        return FlowResourceScene.FileUpload;
    }

    public final boolean u6(UplinkFileEntity r21) {
        com.larus.bmhome.instruction.g r0 = vc();
        String r1 = null;
        if (r0 == null) goto L5;
        Integer r14 = Integer.valueOf(r0.Q1());
    L6:
        Intrinsics.checkNotNullParameter(this, "<this>");
        dr9.d r2 = s1a.a.g(com.larus.ui.arch.component.internal.attach.a.b(this, this)).a(dr9.d.class);
        boolean r3 = false;
        if (r2 != null) goto L9;
    L11:
        boolean r4 = false;
    L13:
        if (od8.h0.c(r14) == true) goto L104;
        if (r4 == false) goto L104;
        if (IChatGalleryService.a.n(PreviewScene.ATTACHMENT_PANEL, false) == true) goto L19;
        return false;
    L19:
        List<UplinkFileEntity> r5 = this.J;
        ArrayList r6 = new ArrayList();
        Iterator r7 = ((ArrayList) r5).iterator();
    L21:
        if (r7.hasNext() == false) goto L48;
        Object r8 = r7.next();
        UplinkFileEntity r9 = (UplinkFileEntity) r8;
        Image r10 = l1.c(r9);
        if (r10 != null) goto L26;
    L44:
        boolean r11 = false;
    L45:
        if (r11 == false) goto L21;
        r6.add(r8);
        goto L21
    L26:
        if (n1.d(r9) == false) goto L44;
        Map r12 = r10.ext;
        if (r12 == null) goto L30;
        String r13 = (String) r12.get("ext_is_from_drive");
    L32:
        if (Intrinsics.areEqual(r13, "1") == false) goto L44;
        String r15 = r10.key;
        if (r15 != null) goto L36;
    L39:
        boolean r16 = true;
    L40:
        if (r16 == true) goto L44;
        if (B3(r9) != null) goto L44;
        r11 = true;
        goto L45
    L36:
        if (StringsKt.isBlank(r15) == true) goto L39;
        r16 = false;
        goto L40
    L30:
        r13 = null;
        goto L32
    L48:
        if ((!r6.isEmpty()) == false) goto L61;
        Job r17 = this.k0;
        if (r17 != null) goto L52;
    L54:
        if (r3 == false) goto L56;
        return true;
    L56:
        String r18 = this.P;
        String r19 = r21.getFileIdentifier();
        Image r20 = l1.c(r21);
        if (r20 == null) goto L59;
        r1 = r20.key;
    L59:
        Intrinsics.checkNotNullParameter(this, "<this>");
        this.k0 = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner()), null, null, new AttachmentPanelComponent$tryOpenAttachmentPreview$1(r6, this, r18, r19, r1, null), 3, null);
        return true;
    L52:
        if (r17.isActive() != true) goto L54;
        r3 = true;
        goto L54
    L61:
        List<com.larus.chat.gallery.api.o> r22 = j4();
        String r23 = r21.getFileIdentifier();
        if (r23 != null) goto L64;
        return false;
    L64:
        Iterator r24 = ((ArrayList) r22).iterator();
        int r25 = 0;
    L66:
        if (r24.hasNext() == false) goto L71;
        if (Intrinsics.areEqual(((com.larus.chat.gallery.api.o) r24.next()).a, r23) == true) goto L69;
        r25 = r25 + 1;
        goto L66
    L69:
        int r26 = r25;
    L72:
        if (r26 < 0) goto L104;
        IChatGalleryService.Companion r27 = IChatGalleryService.a;
        PreviewScene r28 = PreviewScene.ATTACHMENT_PANEL;
        if (r27.n(r28, false) == false) goto L104;
        Sequence r29 = SequencesKt.filter(SequencesKt.generateSequence(F2(), new w()), AttachmentPanelComponent$tryOpenAttachmentPreview$$inlined$filterIsInstance$1.INSTANCE);
        Intrinsics.checkNotNull(r29, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        ChatConstraintLayout r30 = (ChatConstraintLayout) SequencesKt.firstOrNull(r29);
        if (r30 == null) goto L79;
        g2 r31 = r30.C;
        r31.getClass();
        Object r32 = new Object();
        r31.a.add(r32);
        com.larus.bmhome.view.t r33 = new com.larus.bmhome.view.t(r30, r32);
    L80:
        if (r33 == null) goto L82;
        this.Y.add(r33);
    L82:
        a r34 = new a(this, r33);
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L91
        E5();     // Catch: Throwable -> L91
        Context r36 = getContext();     // Catch: Throwable -> L91
        FragmentManager r110 = s1a.a.getActivity(this).getSupportFragmentManager();     // Catch: Throwable -> L91
        MediaEntryScene r111 = MediaEntryScene.ATTACHMENT_PANEL;     // Catch: Throwable -> L91
        MediaEntry r112 = MediaEntry.ATTACHMENT_PANEL;     // Catch: Throwable -> L91
        String r37 = this.P;     // Catch: Throwable -> L91
        if (StringsKt.isBlank(r37) == false) goto L86;
        r37 = ((com.larus.chat.gallery.api.a) r34).a;     // Catch: Throwable -> L91
    L86:
        String r113 = r37;
        wc9.e r38 = H3();     // Catch: Throwable -> L91
        if (r38 == null) goto L89;
        r1 = r38.a;     // Catch: Throwable -> L91
    L89:
        Object r39 = Result.constructor-impl(Boolean.valueOf(IChatGalleryService.a.b(r27, r36, r110, r28, r22, r26, r34, null, new dr9.b(r111, r112, r113, r1, r14, new h(r14, r4, r34), 80), 64)));     // Catch: Throwable -> L91
    L93:
        Throwable r40 = Result.exceptionOrNull-impl(r39);
        if (r40 == null) goto L96;
        FLogger.a.e("AttachmentPanelComponent", "tryOpenAttachmentPreview failed", r40);
    L96:
        Boolean r41 = Boolean.FALSE;
        if (Result.isFailure-impl(r39) == false) goto L99;
        r39 = r41;
    L99:
        Boolean r42 = (Boolean) r39;
        if (r42.booleanValue() == true) goto L103;
        r34.x();
    L103:
        return r42.booleanValue();
    L91:
        th = move-exception;
        Result.Companion r43 = Result.Companion;
        r39 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L93
    L79:
        r33 = null;
        goto L80
    L71:
        r26 = -1;
    L104:
        return false;
    L9:
        if (r2.a != true) goto L11;
        r4 = true;
        goto L13
    L5:
        r14 = null;
        goto L6
    }

    public final boolean w00(op8.a r28) {
        Intrinsics.checkNotNullParameter(r28, "mutation");
        op8.k r2 = B4();
        if (r2 == null) goto L14;
        Fragment r3 = r2.a();
        if (r3 == null) goto L11;
        op8.d r4 = s1a.a.g(r3).getAbility(op8.d.class);
        if (r4 == null) goto L11;
        if (r4.w00(r28) != true) goto L11;
        return true;
    L11:
        return false;
    L14:
        if ((r28 instanceof op8.a.e) == false) goto L24;
        ICoreInputAbility r6 = l4();
        if (r6 != null) goto L18;
        return false;
    L18:
        op8.a.e r1 = (op8.a.e) r28;
        ICoreInputAbility.b.d(r6, r1.a, false, false, null, null, false, 56);
        va8.o r5 = k4();
        if (r5 == null) goto L21;
        String r7 = r5.u7();
    L302:
        return Intrinsics.areEqual(r7, r1.a);
    L21:
        r7 = null;
        goto L302
    L24:
        if ((r28 instanceof op8.a.d) == false) goto L27;
        op8.a.d r8 = (op8.a.d) r28;
        return T5(r8.a, r8.c, r8.b);
    L27:
        if ((r28 instanceof op8.a.c) == false) goto L54;
        Iterator r9 = ((ArrayList) this.J).iterator();
    L30:
        if (r9.hasNext() == false) goto L48;
        Object r10 = r9.next();
        UplinkFileEntity r11 = (UplinkFileEntity) r10;
        op8.a.c r12 = (op8.a.c) r28;
        if (Intrinsics.areEqual(r11.getFileIdentifier(), r12.a) == true) goto L45;
        String r13 = r12.b;
        if (r13 != null) goto L36;
    L39:
        boolean r14 = true;
    L40:
        if (r14 == false) goto L42;
    L44:
        boolean r15 = false;
    L46:
        if (r15 == false) goto L30;
        Object r16 = r10;
    L49:
        UplinkFileEntity r17 = (UplinkFileEntity) r16;
        if (r17 != null) goto L304;
        return false;
    L304:
        return I5(r17, true);
    L42:
        if (Intrinsics.areEqual(d1.c(d1.e(r11, 0)), r12.b) == false) goto L44;
    L36:
        if (StringsKt.isBlank(r13) == true) goto L39;
        r14 = false;
    L45:
        r15 = true;
        goto L46
    L48:
        r16 = null;
        goto L49
    L54:
        if ((r28 instanceof op8.a.b) == false) goto L103;
        if (uy8.b.c() == true) goto L58;
        return false;
    L58:
        op8.a.b r18 = (op8.a.b) r28;
        AttachmentSnapshot r19 = r18.c;
        if (r19 == null) goto L72;
        String r20 = r18.a;
        Map r21 = r19.getExtra();
        String r22 = r18.b;
        if (r22 != null) goto L63;
    L68:
        Map r23 = null;
    L69:
        if (r23 != null) goto L71;
        r23 = MapsKt.emptyMap();
    L71:
        AttachmentSnapshot r24 = AttachmentSnapshot.copy$default(r19, r20, null, null, null, null, null, null, null, null, null, null, 0, null, null, 0, null, MapsKt.plus(r21, r23), 65534, null);
    L73:
        Iterator r25 = ((ArrayList) this.J).iterator();
        int r26 = 0;
    L75:
        if (r25.hasNext() == false) goto L94;
        UplinkFileEntity r27 = (UplinkFileEntity) r25.next();
        if (Intrinsics.areEqual(r27.getFileIdentifier(), r18.a) == true) goto L90;
        String r29 = r18.b;
        if (r29 != null) goto L81;
    L84:
        boolean r30 = true;
    L85:
        if (r30 == false) goto L87;
    L89:
        boolean r31 = false;
    L91:
        if (r31 == true) goto L95;
        r26 = r26 + 1;
    L95:
        if (r24 != null) goto L99;
        if (r26 >= 0) goto L305;
    L244:
        return true;
    L305:
        return I5((UplinkFileEntity) ListProtector.get(this.J, r26), false);
    L99:
        if (r26 < 0) goto L307;
        return T5(r18.a, r24, r18.b);
    L307:
        return w00(new op8.a.a(CollectionsKt.listOf(r24)));
    L87:
        if (Intrinsics.areEqual(d1.c(d1.e(r27, 0)), r18.b) == false) goto L89;
    L81:
        if (StringsKt.isBlank(r29) == true) goto L84;
        r30 = false;
    L90:
        r31 = true;
        goto L91
    L94:
        r26 = -1;
        goto L95
    L63:
        if ((!StringsKt.isBlank(r22)) == true) goto L66;
        r22 = null;
    L66:
        if (r22 == null) goto L68;
        r23 = MapsKt.mapOf(TuplesKt.to("preview_attachment_source_media_uri", r22));
        goto L69
    L72:
        r24 = null;
        goto L73
    L103:
        if ((r28 instanceof op8.a.a) == false) goto L248;
        List r32 = ((op8.a.a) r28).a;
        List r33 = r32;
        ArrayList r34 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r33, 10));
        Iterator r35 = r33.iterator();
    L106:
        if (r35.hasNext() == false) goto L108;
        r34.add(((AttachmentSnapshot) r35.next()).getStableId());
        goto L106
    L108:
        ArrayList r36 = new ArrayList();
        Iterator r37 = r33.iterator();
    L110:
        if (r37.hasNext() == false) goto L114;
        ResourceRef r38 = ((AttachmentSnapshot) r37.next()).effectiveRef();
        if (r38 == null) goto L110;
        r36.add(r38);
        goto L110
    L114:
        List<UplinkFileEntity> r39 = this.J;
        ArrayList r40 = new ArrayList();
        Iterator r41 = ((ArrayList) r39).iterator();
    L116:
        if (r41.hasNext() == false) goto L120;
        String r42 = ((UplinkFileEntity) r41.next()).getFileIdentifier();
        if (r42 == null) goto L116;
        r40.add(r42);
        goto L116
    L120:
        Set r43 = CollectionsKt.toSet(r40);
        if (r32.isEmpty() == false) goto L123;
    L246:
        return false;
    L123:
        if (r34.isEmpty() == true) goto L131;
        Iterator r44 = r34.iterator();
    L127:
        if (r44.hasNext() == false) goto L131;
        if (StringsKt.isBlank((String) r44.next()) == false) goto L127;
        boolean r45 = true;
    L132:
        if (r45 == true) goto L246;
        if (r34.size() != CollectionsKt.distinct(r34).size()) goto L246;
        if (r36.size() != CollectionsKt.distinct(r36).size()) goto L246;
        if (r34.isEmpty() == true) goto L146;
        Iterator r46 = r34.iterator();
    L142:
        if (r46.hasNext() == false) goto L146;
        if (r43.contains((String) r46.next()) == false) goto L142;
        boolean r47 = true;
    L147:
        if (r47 == true) goto L246;
        List r48 = r32;
        ArrayList r49 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r48, 10));
        Iterator r50 = r48.iterator();
    L151:
        if (r50.hasNext() == false) goto L154;
        r49.add(d1.f((AttachmentSnapshot) r50.next()));
        goto L151
    L154:
        if (r49.isEmpty() == true) goto L168;
        Iterator r51 = r49.iterator();
    L158:
        if (r51.hasNext() == false) goto L168;
        UplinkFileEntity r52 = (UplinkFileEntity) r51.next();
        if (r52.getUplinkEntityContent() != null) goto L162;
    L165:
        boolean r53 = true;
    L166:
        if (r53 == false) goto L158;
        boolean r54 = true;
    L169:
        if (r54 == false) goto L172;
        return false;
    L172:
        if (r49.isEmpty() == true) goto L188;
        Iterator r55 = r49.iterator();
    L176:
        if (r55.hasNext() == false) goto L188;
        UplinkFileEntity r56 = (UplinkFileEntity) r55.next();
        if (n1.b(r56) == false) goto L180;
    L185:
        boolean r57 = true;
    L186:
        if (r57 == false) goto L176;
        boolean r58 = true;
    L190:
        if (r49.isEmpty() == true) goto L198;
        Iterator r59 = r49.iterator();
    L194:
        if (r59.hasNext() == false) goto L198;
        if (n1.b((UplinkFileEntity) r59.next()) == false) goto L194;
        boolean r60 = true;
    L199:
        com.larus.bmhome.chat.component.bottom.multimodal.g r61 = v4();
        if (r61 == null) goto L202;
        int r62 = r61.zv(r58, Boolean.valueOf(r60));
    L206:
        if ((((ArrayList) this.J).size() + r49.size()) <= r62) goto L209;
        return false;
    L209:
        if (uW(r49, false, "preview_child_flow") == r49.size()) goto L218;
        Set r63 = CollectionsKt.toSet(r34);
        List<UplinkFileEntity> r64 = this.J;
        ArrayList r65 = new ArrayList();
        Iterator r66 = ((ArrayList) r64).iterator();
    L212:
        if (r66.hasNext() == false) goto L216;
        Object r67 = r66.next();
        if (CollectionsKt.contains(r63, ((UplinkFileEntity) r67).getFileIdentifier()) == false) goto L212;
        r65.add(r67);
        goto L212
    L216:
        g1.a.a(this, r65, 6);
        return false;
    L218:
        if (uy8.b.c() == false) goto L244;
        ArrayList r68 = new ArrayList();
        Iterator r69 = r49.iterator();
    L221:
        if (r69.hasNext() == false) goto L237;
        Object r70 = r69.next();
        UplinkFileEntity r71 = (UplinkFileEntity) r70;
        List<UplinkFileEntity> r72 = this.J;
        if ((r72 instanceof Collection) == true) goto L225;
    L227:
        Iterator r73 = ((ArrayList) r72).iterator();
    L229:
        if (r73.hasNext() == false) goto L233;
        if (Intrinsics.areEqual(((UplinkFileEntity) r73.next()).getFileIdentifier(), r71.getFileIdentifier()) == false) goto L229;
        boolean r74 = false;
    L234:
        if (r74 == false) goto L221;
        r68.add(r70);
    L233:
        r74 = true;
        goto L234
    L225:
        if (((ArrayList) r72).isEmpty() == false) goto L227;
    L237:
        if (r68.isEmpty() == true) goto L244;
        List<UplinkFileEntity> r75 = this.J;
        ArrayList r76 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r68, 10));
        Iterator r77 = r68.iterator();
    L241:
        if (r77.hasNext() == false) goto L243;
        r76.add(UplinkFileEntity.copy$default((UplinkFileEntity) r77.next(), null, null, null, null, null, null, null, null, null, false, null, null, null, null, 16383, null));
        goto L241
    L243:
        CollectionsKt.addAll(r75, r76);
        x5();
        goto L244
    L202:
        if (r58 == false) goto L204;
        ImFileUtil.a.getClass();
        r62 = ImFileUtil.l();
        goto L206
    L204:
        ImFileUtil.a.getClass();
        r62 = ImFileUtil.n();
    L198:
        r60 = false;
        goto L199
    L180:
        if (n1.a(r56) == true) goto L185;
        if (n1.e(r56) == true) goto L185;
        r57 = false;
    L188:
        r58 = false;
        goto L190
    L162:
        if (d5(r52) == true) goto L165;
        r53 = false;
    L168:
        r54 = false;
    L146:
        r47 = false;
    L131:
        r45 = false;
        goto L132
    L248:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean w5(Uri r7) {
        Object r2 = null;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L22
        ParcelFileDescriptor r4 = G3(getContext().getContentResolver(), r7);     // Catch: Throwable -> L22
        if (r4 != null) goto L89;
        Integer r5 = null;
    L20:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L22
    L25:
        if (Result.isFailure-impl(r6) == false) goto L27;
        r6 = null;
    L27:
        Integer r8 = (Integer) r6;
        if (r8 == null) goto L77;
    L56:
        if (r8 != null) goto L59;
    L60:
        if (r8 != null) goto L63;
    L64:
        if (r8 != null) goto L67;
    L68:
        if (r8 != null) goto L71;
    L73:
        return false;
    L71:
        if (r8.intValue() != 7) goto L73;
        return true;
    L67:
        if (r8.intValue() != 5) goto L68;
        return true;
    L63:
        if (r8.intValue() != 8) goto L64;
        return true;
    L59:
        if (r8.intValue() != 6) goto L60;
        return true;
    L77:
        InputStream r9 = ContentResolverWrapper.openInputStream(getContext().getContentResolver(), r7);     // Catch: Throwable -> L49
        if (r9 != null) goto L87;
        Integer r0 = null;
    L47:
        Object r10 = Result.constructor-impl(r0);     // Catch: Throwable -> L49
    L52:
        if (Result.isFailure-impl(r10) == true) goto L55;
        r2 = r10;
    L55:
        r8 = (Integer) r2;
        goto L56
    L87:
        ExifInterface2 r11 = new ExifInterface2(r9);     // Catch: Throwable -> L37
        ExifInterface2.d r1 = r11.k("Orientation");     // Catch: Throwable -> L37
        if (r1 != null) goto L79;
    L34:
        int r12 = 1;
    L39:
        r0 = Integer.valueOf(r12);     // Catch: Throwable -> L37
        CloseableKt.closeFinally(r9, null);     // Catch: Throwable -> L49
        goto L47
    L79:
        r12 = r1.h(r11.g);     // Catch: NumberFormatException -> L76 Throwable -> L37
    L37:
        th = move-exception;
        throw th;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        CloseableKt.closeFinally(r9, th);     // Catch: Throwable -> L49
        throw th;     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L52
    L89:
        ExifInterface2 r14 = new ExifInterface2(r4.getFileDescriptor());     // Catch: Throwable -> L10
        ExifInterface2.d r15 = r14.k("Orientation");     // Catch: Throwable -> L10
        if (r15 != null) goto L81;
    L7:
        int r16 = 1;
    L12:
        r5 = Integer.valueOf(r16);     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r4, null);     // Catch: Throwable -> L22
        goto L20
    L81:
        r16 = r15.h(r14.g);     // Catch: NumberFormatException -> L75 Throwable -> L10
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    }

    public final void w6(boolean r2) {
        if (r2 == true) goto L4;
        return;
    L4:
        if (z2.a.getAttachmentAlbumDetectConfig().b() == false) goto L12;
        com.larus.bmhome.chat.component.bottom.attachment.g r3 = V3(this.T1);
        if (r3 != null) goto L9;
        return;
    L9:
        d4().update(r3);
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final void x2(ns8.b r1) {
        this.P0 = r1;
    }

    public final void x6(boolean r4) {
        FLogger.a.i("AttachmentPanelComponent", "[updateAttachmentAllUploadSuccess] success=" + r4);
        this.A = r4;
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final void yQ(Function1<? super SuggestedActionScene, Boolean> r1) {
        this.V1 = r1;
    }

    public final void z5(ArrayList<ResourceItemBean> r4) {
        if (r4.isEmpty() == true) goto L5;
    L8:
        mt8.a r0 = this.m;
        if (r0 == null) goto L11;
        ArrayList r1 = new ArrayList();
        r1.addAll(this.V);
        r1.addAll(r4);
        r0.e(r1);
    L11:
        o6();
        return;
    L5:
        if (this.V.isEmpty() == false) goto L8;
        ((ArrayList) this.J).clear();
        x5();
        G4().clear();
        V4();
    }

    public final void zN(Function1<? super List<AttachmentSnapshot>, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.X.add(r2);
        r2.invoke(snapshot().b);
    }

    public static ParcelFileDescriptor G3(ContentResolver r20, Uri r21) {
        ArrayList r1 = new ArrayList();
        Object[] r2 = {r21, "r"};
        f06.b r13 = new f06.b();
        g06.a r3 = (g06.a) ApiHookConfig.b.get(240020);
        if (r3 == null) goto L5;
        f06.a[] r4 = r3.i;
    L6:
        f06.a[] r10 = r4;
        int r9 = r10.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r10[r8];
        int r17 = r8;
        int r18 = r9;
        f06.a[] r19 = r10;
        f06.d r5 = r7.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r20, r2, "android.os.ParcelFileDescriptor", r13);     // Catch: Exception -> L22
        if (r5.a == true) goto L17;
        r1.add(r7);     // Catch: Exception -> L22
    L17:
        if (r5.a == false) goto L21;
        return (ParcelFileDescriptor) r5.b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r20, r21, "r");
    L14:
        r8 = r17 + 1;
        r9 = r18;
        r10 = r19;
        goto L8
    L15:
        r5 = new f06.d(false, null);
        goto L17
    L5:
        r4 = ApiHookConfig.d;
        goto L6
    }

    public static final void h3(AttachmentPanelComponent r10, UplinkFileEntity r11) {
        r10.getClass();
        UplinkEntityContent r0 = r11.getUplinkEntityContent();
        if (r0 == null) goto L52;
        Image r1 = r0.getUplinkImageInfo();
        if (r1 == null) goto L53;
        Uri r12 = r11.getUri();
        if (r12 == null) goto L54;
        Object r2 = null;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L33
        BitmapFactory.Options r4 = new BitmapFactory.Options();     // Catch: Throwable -> L33
        r4.inJustDecodeBounds = true;     // Catch: Throwable -> L33
        InputStream r5 = ContentResolverWrapper.openInputStream(r10.getContext().getContentResolver(), r12);     // Catch: Throwable -> L33
        if (r5 != null) goto L48;
    L21:
        int r6 = r4.outWidth;     // Catch: Throwable -> L33
        int r7 = r4.outHeight;     // Catch: Throwable -> L33
        if (r6 <= 0) goto L30;
        if (r7 <= 0) goto L30;
        if (r10.F == true) goto L27;
    L29:
        Pair r13 = TuplesKt.to(Integer.valueOf(r6), Integer.valueOf(r7));     // Catch: Throwable -> L33
    L31:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L33
    L36:
        if (Result.isFailure-impl(r14) == true) goto L39;
        r2 = r14;
    L39:
        Pair r8 = (Pair) r2;
        if (r8 == null) goto L55;
        ImageObj r15 = r1.imageOri;
        if (r15 != null) goto L45;
        r15 = new ImageObj(null, 0, 0, null, null, 31, null);
    L45:
        r15.width = ((Number) r8.getFirst()).intValue();
        r15.height = ((Number) r8.getSecond()).intValue();
        r1.imageOri = r15;
        return;
    L55:
        return;
    L27:
        if (r10.w5(r12) == false) goto L29;
        r13 = TuplesKt.to(Integer.valueOf(r7), Integer.valueOf(r6));     // Catch: Throwable -> L33
    L30:
        r13 = null;
        goto L31
    L48:
        BitmapFactory.decodeStream(r5, null, r4);     // Catch: Throwable -> L16
        CloseableKt.closeFinally(r5, null);     // Catch: Throwable -> L33
        goto L21
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);     // Catch: Throwable -> L33
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L36
    L54:
        return;
    L53:
        return;
    }

    public static final void z3(AttachmentPanelComponent r3, final UplinkFileEntity r4) {
        UplinkFileEntity r0 = (UplinkFileEntity) CollectionsKt.firstOrNull(r3.J);
        if (r0 == null) goto L5;
        String r1 = r0.getFileIdentifier();
    L6:
        boolean r2 = Intrinsics.areEqual(r1, r4.getFileIdentifier());
        CollectionsKt.removeAll(r3.J, new y(r4));
        r3.x5();
        if (r2 == false) goto L11;
        boolean r5 = true;
        if ((!((ArrayList) r3.J).isEmpty()) == false) goto L11;
    L12:
        r3.w6(r5);
        return;
    L11:
        r5 = false;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public final boolean I5(UplinkFileEntity r14, boolean r15) {
        String r0 = r14.getFileIdentifier();
        if (r0 == null) goto L55;
        List r4 = null;
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L58;
        String r2 = this.P;
        if ((!StringsKt.isBlank(r2)) == true) goto L14;
        r2 = null;
    L14:
        if (r2 != null) goto L16;
        return false;
    L16:
        NestedFileCacheManagerService r5 = NestedFileCacheManagerService.b;
        r5.n(r2, r0);
        Q5(this, r14, r2, false, false, r15, 12);
        r5.b(r2, r0);
        List<UplinkFileEntity> r16 = this.J;
        if ((r16 instanceof Collection) == true) goto L19;
    L21:
        Iterator r17 = ((ArrayList) r16).iterator();
    L23:
        if (r17.hasNext() == false) goto L27;
        if (Intrinsics.areEqual(((UplinkFileEntity) r17.next()).getFileIdentifier(), r0) == false) goto L23;
        boolean r18 = false;
    L28:
        NestedFileContent r19 = NestedFileCacheManagerService.b.b6(r2);
        if (r19 == null) goto L31;
        r4 = r19.getEntities();
    L31:
        if (r4 != null) goto L33;
        r4 = CollectionsKt.emptyList();
    L33:
        List r6 = r4;
        if ((r6 instanceof Collection) == true) goto L36;
    L38:
        Iterator r110 = r6.iterator();
    L40:
        if (r110.hasNext() == false) goto L44;
        if (Intrinsics.areEqual(((UplinkFileEntity) r110.next()).getFileIdentifier(), r0) == false) goto L40;
        boolean r111 = false;
    L45:
        if (r18 == false) goto L56;
        if (r111 == false) goto L57;
        return true;
    L57:
        return false;
    L56:
        return false;
    L44:
        r111 = true;
        goto L45
    L36:
        if (r6.isEmpty() == false) goto L38;
    L27:
        r18 = true;
        goto L28
    L19:
        if (((ArrayList) r16).isEmpty() == false) goto L21;
    L58:
        return false;
    L55:
        return false;
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final boolean RD(UplinkFileEntity r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        Intrinsics.checkNotNullParameter(r3, "fromScene");
        if (uW(CollectionsKt.listOf(r2), true, r3) > 0) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean W4(String r6, String r7) {
        BotModel r0 = W3();
        String r1 = null;
        if (r0 == null) goto L22;
        List r2 = r0.getBotConf();
        if (r2 == null) goto L22;
        Iterator r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L17;
        Object r4 = r3.next();
        BotConfItem r5 = (BotConfItem) r4;
        if (Intrinsics.areEqual(r5.getConfGroupKey(), r6) == true) goto L12;
    L14:
        boolean r8 = false;
    L15:
        if (r8 == false) goto L8;
    L18:
        BotConfItem r9 = (BotConfItem) r4;
        if (r9 == null) goto L22;
        r1 = r9.getConfValue();
        goto L22
    L12:
        if (Intrinsics.areEqual(r5.getConfKey(), r7) == false) goto L14;
        r8 = true;
        goto L15
    L17:
        r4 = null;
    L22:
        return Intrinsics.areEqual(r1, "1");
    }

    public final Object Z3(List<String> r5, Continuation<? super Unit> r6) {
        if ((r6 instanceof AttachmentPanelComponent$deleteResourceByResourceId$1) == false) goto L7;
        AttachmentPanelComponent$deleteResourceByResourceId$1 r0 = (AttachmentPanelComponent$deleteResourceByResourceId$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r5 = (List) r0.L$0;
        ResultKt.throwOnFailure(r7);
    L17:
        FLogger.a.i("AttachmentPanelComponent", "deleteResourceByResourceId result: " + ((String) r7) + ", resourceIds:" + r5);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        ResourceCenter r8 = ResourceCenter.a;
        r0.L$0 = r5;
        r0.label = 1;
        r7 = r8.b(r5, r0);
        if (r7 != r2) goto L17;
        return r2;
    L7:
        r0 = new AttachmentPanelComponent$deleteResourceByResourceId$1(this, r6);
        goto L8
    }

    public final Object a4(List<Pair<String, String>> r5, Continuation<? super Unit> r6) {
        if ((r6 instanceof AttachmentPanelComponent$deleteResourceByUri$1) == false) goto L7;
        AttachmentPanelComponent$deleteResourceByUri$1 r0 = (AttachmentPanelComponent$deleteResourceByUri$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r5 = (List) r0.L$0;
        ResultKt.throwOnFailure(r7);
    L17:
        FLogger.a.i("AttachmentPanelComponent", "deleteResourceByUri result:" + ((com.larus.network.http.a) r7) + ", resources:" + r5);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        Lazy<ChatApi> r8 = ChatApi.a;
        ChatApi r9 = ChatApi.a.a();
        r0.L$0 = r5;
        r0.label = 1;
        r9.getClass();
        r7 = ChatApi.a(r5, r0);
        if (r7 != r2) goto L17;
        return r2;
    L7:
        r0 = new AttachmentPanelComponent$deleteResourceByUri$1(this, r6);
        goto L8
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final boolean eY(List r8, HashMap r9) {
        Intrinsics.checkNotNullParameter(r8, "items");
        Intrinsics.checkNotNullParameter(r9, "customRender");
        Intrinsics.checkNotNullParameter("file", "fromScene");
        Intrinsics.checkNotNullParameter("humanMergeForward", "enterMethod");
        boolean r1 = false;
        if (this.m != null) goto L6;
        FLogger.a.w("AttachmentPanelComponent", "[showCustomResourceBarAttachments] resourceBarOperator is null");
        return false;
    L6:
        this.V = r8;
        this.W = new HashMap(r9);
        if (this.P.length() != 0) goto L9;
        r1 = true;
    L9:
        if (r1 == false) goto L11;
        int r10 = wf9.b.a;
        this.P = com.flow.kmp.common.util.i.a();
    L11:
        X5(this, AttachmentPanelType.MultiFile, true, "file", "humanMergeForward", "humanMergeForward", 32);
        z5(C3());
        return true;
    }

    public static final Object Y2(AttachmentPanelComponent r11, List r12, Continuation r13) {
        r11.getClass();
        if ((r13 instanceof AttachmentPanelComponent$batchDeleteRemoteResources$1) == false) goto L7;
        Continuation<? super Unit> r0 = (AttachmentPanelComponent$batchDeleteRemoteResources$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r14);
    L68:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        List<Pair<String, String>> r15 = (List) r0.L$0;
        ResultKt.throwOnFailure(r14);
        List<Pair<String, String>> r16 = r15;
    L61:
        List<Pair<String, String>> r4 = r16;
    L63:
        if ((!r4.isEmpty()) == false) goto L68;
        r0.L$0 = null;
        r0.label = 2;
        if (r11.a4(r4, r0) != r2) goto L68;
        return r2;
    L16:
        ResultKt.throwOnFailure(r14);
        ArrayList r17 = new ArrayList();
        ArrayList r5 = new ArrayList();
        Iterator r18 = r12.iterator();
    L18:
        if (r18.hasNext() == false) goto L55;
        UplinkFileEntity r6 = (UplinkFileEntity) r18.next();
        if (r6.isHistoryReuse() == true) goto L18;
        Integer r7 = r6.getUpLinkStatus();
        int r8 = UpLinkState.SUCCESS.getValue();
        if (r7 == null) goto L18;
        if (r7.intValue() != r8) goto L18;
        Map r9 = r6.getExtra();
        if (r9 == null) goto L31;
        String r10 = (String) r9.get("disable_remote_delete");
    L33:
        if (Intrinsics.areEqual(r10, "1") == true) goto L18;
        String r19 = l1.g(r6);
        ResourceCenter r20 = ResourceCenter.a;
        String r21 = r6.getFileIdentifier();
        String r110 = "";
        if (r21 != null) goto L38;
        r21 = "";
    L38:
        r20.getClass();
        if (ResourceCenter.d(r21) == true) goto L40;
        if (n1.d(r6) == false) goto L46;
        String r22 = "image";
    L47:
        Uri r23 = r6.getUri();
        if (r23 == null) goto L50;
        String r24 = r23.toString();
    L51:
        if (r24 == null) goto L54;
        r110 = r24;
    L54:
        r5.add(new Pair(r110, r22));
        goto L18
    L50:
        r24 = null;
        goto L51
    L46:
        r22 = "file";
        goto L47
    L40:
        if (r19 != null) goto L42;
        r19 = "";
    L42:
        r17.add(r19);
        goto L18
    L31:
        r10 = null;
        goto L33
    L55:
        r4 = r5;
        if ((!r17.isEmpty()) == false) goto L63;
        r0.L$0 = r5;
        r0.label = 1;
        if (r11.Z3(r17, r0) == r2) goto L83;
        r16 = r5;
        goto L61
    L83:
        return r2;
    L7:
        r0 = new AttachmentPanelComponent$batchDeleteRemoteResources$1(r11, r13);
        goto L8
    }

    public static final ns8.b m3(AttachmentPanelComponent r7, UplinkFileEntity r8, ns8.b r9) {
        r7.getClass();
        if (Intrinsics.areEqual(r8.isOriginalImageChecked(), Boolean.TRUE) == false) goto L8;
        if (r9 == null) goto L7;
        return ns8.b.a(r9, true, false, 126);
    L7:
        return new ns8.b(true, false, false, false, false, 126);
    L8:
        return r9;
    }

    public final void R4(UplinkFileEntity r29, Boolean r30, Boolean r31) {
        FLogger.a.i("AttachmentPanelComponent", "[handleUploadAndReplaceAttachment] isImageMarked:" + r30 + ", isImageCropped:" + r31);
        FileUploader r0 = FileUploader.a;
        String r1 = r29.getFileIdentifier();
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        FileUploader.a(r1);
        String r16 = K();
        BotModel r2 = W3();
        if (r2 == null) goto L8;
        String r17 = r2.getBotId();
    L9:
        wc9.e r3 = H3();
        if (r3 == null) goto L12;
        String r18 = r3.B;
    L13:
        com.larus.bmhome.instruction.g r4 = vc();
        if (r4 != null) goto L16;
    L18:
        boolean r5 = false;
    L19:
        if (r5 == true) goto L29;
        ICoreInputAbility r6 = l4();
        if (r6 != null) goto L23;
    L25:
        boolean r7 = false;
    L26:
        if (r7 == false) goto L29;
        boolean r8 = false;
    L30:
        WeakReference r11 = new WeakReference(this);
        String r9 = this.P;
        String r12 = K();
        BotModel r10 = W3();
        if (r10 == null) goto L33;
        String r13 = r10.getBotId();
    L34:
        com.larus.bmhome.chat.component.bottom.reference.a r14 = g5();
        if (r14 == null) goto L37;
        String r19 = r14.wf();
    L38:
        com.larus.bmhome.chat.component.bottom.reference.a r15 = g5();
        if (r15 == null) goto L41;
        ReferenceInfo r20 = r15.T6();
    L42:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AttachmentPanelComponent$handleUploadAndReplaceAttachment$1(this, r29, new com.larus.bmhome.chat.component.bottom.multimodal.upload.q(r16, true, new y0(r9, r29, r8, null, null, "1", null, r30, r31, this, r11, r12, r13, r19, r20), "replace", r29, false, this.P, r17, r18, null, 544), null), 2, null);
        return;
    L41:
        r20 = null;
        goto L42
    L37:
        r19 = null;
        goto L38
    L33:
        r13 = null;
        goto L34
    L23:
        if (r6.gj() != true) goto L25;
        r7 = true;
    L29:
        r8 = true;
        goto L30
    L16:
        if (r4.Wa() != true) goto L18;
        r5 = true;
        goto L19
    L12:
        r18 = null;
        goto L13
    L8:
        r17 = null;
        goto L9
    }

    public final boolean T5(String r31, AttachmentSnapshot r32, String r33) {
        Iterator r2 = ((ArrayList) this.J).iterator();
        boolean r3 = false;
        int r4 = 0;
    L4:
        if (r2.hasNext() == false) goto L22;
        UplinkFileEntity r5 = (UplinkFileEntity) r2.next();
        String r8 = r31;
        if (Intrinsics.areEqual(r5.getFileIdentifier(), r8) == true) goto L18;
        if (r33 != null) goto L9;
    L12:
        boolean r7 = true;
    L13:
        if (r7 == false) goto L15;
    L17:
        boolean r6 = false;
    L19:
        if (r6 == true) goto L23;
        r4 = r4 + 1;
    L23:
        if (r4 >= 0) goto L25;
        return false;
    L25:
        UplinkFileEntity r1 = UplinkFileEntity.copy$default((UplinkFileEntity) ListProtector.get(this.J, r4), null, null, null, null, null, null, null, null, null, false, null, null, null, null, 16383, null);
        AttachmentSnapshot r9 = d1.e(r1, r4);
        AttachmentSnapshot r10 = r32;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r9, "origin");
        String r11 = d1.c(r9);
        if (r11 == null) goto L29;
        r10 = AttachmentSnapshot.copy$default(r32, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, 0, null, MapsKt.plus(r32.getExtra(), TuplesKt.to("preview_attachment_source_media_uri", r11)), 65535, null);
    L29:
        String r12 = r1.getFileIdentifier();
        if (r12 == null) goto L33;
        r8 = r12;
    L33:
        AttachmentSnapshot r13 = AttachmentSnapshot.copy$default(r10, r8, null, null, null, null, null, null, null, null, null, null, 0, null, null, r4, null, null, 114686, null);
        UplinkFileEntity r14 = d1.f(r13);
        NestedFileContent r15 = NestedFileCacheManagerService.b.b6(this.P);
        AttachmentEditType r16 = null;
        if (r15 == null) goto L36;
        List r17 = r15.getEntities();
    L37:
        if (r17 != null) goto L39;
        r17 = CollectionsKt.emptyList();
    L39:
        List r18 = r17;
        if ((r18 instanceof Collection) == true) goto L42;
    L44:
        Iterator r19 = r18.iterator();
    L46:
        if (r19.hasNext() == false) goto L50;
        if (Intrinsics.areEqual(((UplinkFileEntity) r19.next()).getFileIdentifier(), r14.getFileIdentifier()) == false) goto L46;
        boolean r20 = false;
    L51:
        if (r20 == false) goto L53;
        return false;
    L53:
        boolean r21 = !d1.b(r9, r13);
        z2 r22 = z2.a;
        if (z2.c4() == false) goto L61;
        List r110 = CollectionsKt.toMutableList(this.J);
        ListProtector.set(r110, r4, r14);
        j1 r111 = Y3();
        if (r111 == null) goto L58;
        boolean r23 = j1.a.a(r111, this.P, null, r110, false, false, null, null, Long.valueOf(System.currentTimeMillis()), null, 378);
    L59:
        if (r23 == true) goto L61;
        return false;
    L58:
        r23 = true;
    L61:
        NestedFileCacheManagerService r24 = NestedFileCacheManagerService.b;
        r24.k(this.P, r14);
        UplinkFileEntity r112 = (UplinkFileEntity) CollectionsKt.getOrNull(this.J, r4);
        if (r112 != null) goto L64;
    L66:
        boolean r113 = false;
    L67:
        if (r113 == true) goto L69;
        EC(r14);
    L69:
        UplinkFileEntity r114 = (UplinkFileEntity) CollectionsKt.getOrNull(this.J, r4);
        if (r114 != null) goto L72;
    L74:
        boolean r25 = false;
    L75:
        if (r25 == true) goto L78;
        r24.k(this.P, r1);
        EC(r1);
        return false;
    L78:
        if (r21 == false) goto L97;
        Integer r26 = r14.getUpLinkStatus();
        int r27 = UpLinkState.SUCCESS.getValue();
        if (r26 == null) goto L85;
        if (r26.intValue() == r27) goto L97;
    L85:
        if (D3(r14) == false) goto L97;
        G4().put(r14.getFileIdentifier(), Boolean.FALSE);
        E3();
        AttachmentEditState r28 = r13.getEditState();
        if (r28 == null) goto L90;
        r16 = r28.getEditType();
    L90:
        if (r16 != AttachmentEditType.MARK) goto L92;
        boolean r29 = true;
    L93:
        Boolean r30 = Boolean.valueOf(r29);
        if (r16 != AttachmentEditType.CROP) goto L96;
        r3 = true;
    L96:
        R4(r14, r30, Boolean.valueOf(r3));
        goto L97
    L92:
        r29 = false;
    L97:
        return true;
    L72:
        if (d1.b(d1.e(r114, r4), r13) != true) goto L74;
        r25 = true;
        goto L75
    L64:
        if (d1.b(d1.e(r112, r4), r13) != true) goto L66;
        r113 = true;
    L50:
        r20 = true;
        goto L51
    L42:
        if (r18.isEmpty() == false) goto L44;
    L36:
        r17 = null;
        goto L37
    L15:
        if (Intrinsics.areEqual(d1.c(d1.e(r5, 0)), r33) == false) goto L17;
    L9:
        if (StringsKt.isBlank(r33) == true) goto L12;
        r7 = false;
    L18:
        r6 = true;
        goto L19
    L22:
        r8 = r31;
        r4 = -1;
        goto L23
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final void TU(List<UplinkFileEntity> r13, boolean r14, boolean r15) {
        op8.k r0 = B4();
        if (r0 == null) goto L10;
        Fragment r1 = r0.a();
        if (r1 == null) goto L104;
        g1 r2 = s1a.a.g(r1).getAbility(g1.class);
        if (r2 == null) goto L105;
        r2.TU(r13, r14, r15);
        return;
    L105:
        return;
    L104:
        return;
    L10:
        FLogger.a.i("AttachmentPanelComponent", "[removeAllAttachmentEntities] " + r13);
        String r3 = this.P;
        if (r13 == null) goto L20;
        List<UplinkFileEntity> r16 = r13;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator<T> r17 = r16.iterator();
    L14:
        if (r17.hasNext() == false) goto L19;
        UplinkFileEntity r5 = (UplinkFileEntity) r17.next();
        String r6 = r5.getFileIdentifier();
        if (r6 != null) goto L18;
        r6 = "";
    L18:
        r4.add(TuplesKt.to(r6, r5.getUri()));
        goto L14
    L19:
        Set r18 = CollectionsKt.toSet(r4);
    L21:
        List r7 = CollectionsKt.toList(this.J);
        ArrayList r8 = new ArrayList();
        Iterator r9 = r7.iterator();
    L22:
        boolean r10 = true;
        if (r9.hasNext() == false) goto L35;
        Object r11 = r9.next();
        UplinkFileEntity r12 = (UplinkFileEntity) r11;
        if (r18 == null) goto L33;
        String r19 = r12.getFileIdentifier();
        if (r19 != null) goto L30;
        r19 = "";
    L30:
        if (r18.contains(TuplesKt.to(r19, r12.getUri())) == true) goto L33;
        r10 = false;
    L33:
        if (r10 == false) goto L22;
        r8.add(r11);
        goto L22
    L35:
        UplinkFileEntity r110 = (UplinkFileEntity) CollectionsKt.firstOrNull(this.J);
        if (r110 != null) goto L38;
    L54:
        boolean r111 = false;
    L55:
        if (r15 == true) goto L57;
    L68:
        Iterator r20 = r8.iterator();
    L70:
        if (r20.hasNext() == false) goto L72;
        Q5(this, (UplinkFileEntity) r20.next(), r3, r14, r15, false, 16);
        goto L70
    L72:
        if (r15 == true) goto L74;
    L79:
        x5();
        if (r111 == true) goto L82;
    L84:
        r10 = false;
    L85:
        w6(r10);
        ((ArrayList) this.N).clear();
        this.O.setValue(CollectionsKt.emptyList());
        return;
    L82:
        if ((!((ArrayList) this.J).isEmpty()) == false) goto L84;
    L74:
        if (r3.length() <= 0) goto L76;
        boolean r112 = true;
    L77:
        if (r112 == false) goto L79;
        NestedFileCacheManagerService.b.b2(r3);
        goto L79
    L76:
        r112 = false;
        goto L77
    L57:
        if (r3.length() <= 0) goto L59;
        boolean r21 = true;
    L60:
        if (r21 == false) goto L68;
        Iterator r22 = r8.iterator();
    L63:
        if (r22.hasNext() == false) goto L68;
        UplinkFileEntity r23 = (UplinkFileEntity) r22.next();
        NestedFileCacheManagerService r24 = NestedFileCacheManagerService.b;
        String r25 = r23.getFileIdentifier();
        if (r25 != null) goto L67;
        r25 = "";
    L67:
        r24.n(r3, r25);
        goto L63
    L59:
        r21 = false;
        goto L60
    L38:
        if (r8.isEmpty() == true) goto L51;
        Iterator r26 = r8.iterator();
    L42:
        if (r26.hasNext() == false) goto L51;
        UplinkFileEntity r27 = (UplinkFileEntity) r26.next();
        if (Intrinsics.areEqual(r27.getFileIdentifier(), r110.getFileIdentifier()) == true) goto L46;
    L48:
        boolean r28 = false;
    L49:
        if (r28 == false) goto L42;
        boolean r113 = true;
    L52:
        if (r113 != true) goto L54;
        r111 = true;
        goto L55
    L46:
        if (Intrinsics.areEqual(r27.getUri(), r110.getUri()) == false) goto L48;
        r28 = true;
    L51:
        r113 = false;
        goto L52
    L20:
        r18 = null;
        goto L21
    }

    public final AttachmentPanelType p4(List<UplinkFileEntity> r5, boolean r6, boolean r7) {
        com.larus.bmhome.instruction.g r0 = vc();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L10;
        com.larus.bmhome.instruction.g r3 = vc();
        if (r3 != null) goto L14;
    L16:
        boolean r4 = false;
    L17:
        if (r4 == false) goto L21;
        return AttachmentPanelType.SingleFile;
    L21:
        if (q4() == true) goto L23;
        UplinkFileEntity r8 = (UplinkFileEntity) CollectionsKt.firstOrNull(r5);
        if (r8 == null) goto L50;
        UplinkEntityContent r9 = r8.getUplinkEntityContent();
        if (r9 == null) goto L50;
        UplinkFileInfo r10 = r9.getUplinkFileInfo();
        if (r10 == null) goto L50;
        Integer r11 = r10.getFileType();
        int r12 = FileType.FileTypeAudio.getValue();
        if (r11 == null) goto L50;
        if (r11.intValue() != r12) goto L50;
    L49:
        boolean r13 = true;
    L51:
        if (r13 == true) goto L53;
        ICoreInputAbility r14 = l4();
        if (r14 != null) goto L57;
    L59:
        boolean r15 = false;
    L60:
        if (r15 == true) goto L123;
        if (r6 == false) goto L98;
        List<UplinkFileEntity> r16 = r5;
        boolean r17 = r16 instanceof Collection;
        if (r17 == true) goto L66;
    L68:
        Iterator<T> r18 = r16.iterator();
    L70:
        if (r18.hasNext() == false) goto L74;
        if (h5((UplinkFileEntity) r18.next()) == false) goto L70;
        boolean r19 = true;
    L75:
        if (r17 == true) goto L77;
    L79:
        Iterator<T> r20 = r16.iterator();
    L81:
        if (r20.hasNext() == false) goto L85;
        if ((!h5((UplinkFileEntity) r20.next())) == false) goto L81;
        boolean r21 = true;
    L86:
        if (r19 == false) goto L126;
        if (r21 == true) goto L126;
        ICoreInputAbility r22 = l4();
        if (r22 != null) goto L91;
    L93:
        r1 = false;
    L94:
        if (r1 == false) goto L125;
        return AttachmentPanelType.MultiImage;
    L125:
        return AttachmentPanelType.SingleImage;
    L91:
        if (r22.gj() != true) goto L93;
    L126:
        return AttachmentPanelType.MultiFile;
    L85:
        r21 = false;
        goto L86
    L77:
        if (r16.isEmpty() == false) goto L79;
    L74:
        r19 = false;
        goto L75
    L66:
        if (r16.isEmpty() == false) goto L68;
    L98:
        if (r7 == true) goto L100;
    L104:
        ICoreInputAbility r23 = l4();
        if (r23 != null) goto L107;
    L109:
        r1 = false;
    L110:
        if (r1 == false) goto L113;
        return AttachmentPanelType.MultiImage;
    L113:
        return AttachmentPanelType.SingleImage;
    L107:
        if (r23.gj() != true) goto L109;
    L100:
        if ((!r5.isEmpty()) == false) goto L104;
        if (n1.b((UplinkFileEntity) ListProtector.get(r5, 0)) == false) goto L104;
        return AttachmentPanelType.MultiFile;
    L123:
        return AttachmentPanelType.MixImageFile;
    L57:
        if (r14.Pi() != true) goto L59;
        r15 = true;
        goto L60
    L53:
        return AttachmentPanelType.MultiAudio;
    L50:
        r13 = false;
        goto L51
    L23:
        if ((!r5.isEmpty()) == false) goto L50;
        List<UplinkFileEntity> r24 = r5;
        if ((r24 instanceof Collection) == true) goto L27;
    L29:
        Iterator<T> r25 = r24.iterator();
    L31:
        if (r25.hasNext() == false) goto L35;
        if (n1.a((UplinkFileEntity) r25.next()) == true) goto L31;
        boolean r26 = false;
    L36:
        if (r26 == false) goto L50;
    L35:
        r26 = true;
        goto L36
    L27:
        if (r24.isEmpty() == false) goto L29;
    L14:
        if (r3.k20() != true) goto L16;
        r4 = true;
        goto L17
    L10:
        return AttachmentPanelType.MultiImage;
    L5:
        if (r0.Wa() != true) goto L7;
        r2 = true;
        goto L8
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final int uW(List<UplinkFileEntity> r38, boolean r39, String r40) {
        Intrinsics.checkNotNullParameter(r38, "entities");
        Intrinsics.checkNotNullParameter(r40, "fromScene");
        op8.k r1 = B4();
        boolean r15 = false;
        if (r1 == null) goto L11;
        Fragment r2 = r1.a();
        if (r2 == null) goto L282;
        g1 r3 = s1a.a.g(r2).getAbility(g1.class);
        if (r3 != null) goto L9;
        return 0;
    L9:
        return r3.uW(r38, false, r40);
    L282:
        return 0;
    L11:
        if (r38.isEmpty() == false) goto L14;
        return 0;
    L14:
        if (mT() == true) goto L16;
        return 0;
    L16:
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r4 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getContext();
        if (r4 != null) goto L22;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r4 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r4 != null) goto L22;
        return 0;
    L22:
        FragmentActivity r14 = r4;
        ArrayList r10 = new ArrayList();
        Iterator<T> r0 = r38.iterator();
    L23:
        UplinkFileEntity r13 = null;
        boolean r12 = true;
        if (r0.hasNext() == false) goto L34;
        UplinkFileEntity r5 = (UplinkFileEntity) r0.next();
        if (r5.getUplinkEntityContent() != null) goto L29;
        r12 = false;
    L29:
        if (r12 == false) goto L31;
        r13 = r5;
    L31:
        if (r13 == null) goto L23;
        r10.add(r13);
        goto L23
    L34:
        if (r10.isEmpty() == false) goto L36;
        return 0;
    L36:
        this.L0 = true;
        if (r10.isEmpty() == true) goto L53;
        Iterator r6 = r10.iterator();
    L41:
        if (r6.hasNext() == false) goto L53;
        UplinkFileEntity r7 = (UplinkFileEntity) r6.next();
        if (n1.b(r7) == false) goto L45;
    L50:
        boolean r8 = true;
    L51:
        if (r8 == false) goto L41;
        boolean r11 = true;
    L55:
        if (r10.isEmpty() == true) goto L63;
        Iterator r9 = r10.iterator();
    L59:
        if (r9.hasNext() == false) goto L63;
        if (n1.b((UplinkFileEntity) r9.next()) == false) goto L59;
        boolean r20 = true;
    L64:
        mt8.a r16 = this.m;
        if (r16 == null) goto L74;
        View r17 = r16.getView();
        if (r17 == null) goto L74;
        if (r17.getVisibility() != 0) goto L71;
        boolean r18 = true;
    L72:
        if (r18 != true) goto L74;
        boolean r19 = true;
    L76:
        if (this.P.length() != 0) goto L78;
        boolean r21 = true;
    L79:
        if (r21 == false) goto L81;
        int r22 = wf9.b.a;
        this.P = com.flow.kmp.common.util.i.a();
        W5(r39, p4(CollectionsKt.toMutableList(r10), r11, false), r11, r40, null, null, "");
    L85:
        com.larus.bmhome.chat.component.bottom.multimodal.g r23 = v4();
        if (r23 == null) goto L89;
        int r24 = r23.zv(r11, Boolean.valueOf(r20));
    L88:
        int r25 = r24;
        int r26 = ((ArrayList) this.J).size();
        Iterator r27 = r10.iterator();
        int r28 = 0;
    L94:
        if (r27.hasNext() == false) goto L235;
        UplinkFileEntity r29 = (UplinkFileEntity) r27.next();
        int r30 = r26 + r28;
        if (r30 >= r25) goto L97;
        boolean r31 = T4(r29);
        UplinkFileEntity r32 = Q3(r29);
        UplinkEntityContent r33 = r32.getUplinkEntityContent();
        if (r33 == null) goto L113;
        Image r34 = r33.getUplinkImageInfo();
        if (r34 == null) goto L113;
        UplinkFileEntity r35 = r34.key;
        if (r35 != null) goto L109;
    L111:
        r35 = r13;
    L112:
        r34.key = r35;
        goto L113
    L109:
        if (Boolean.valueOf(StringsKt.isBlank(r35) ^ r12).booleanValue() == false) goto L111;
    L113:
        UplinkFileEntity r36 = r29.getFileIdentifier();
        if (r36 != null) goto L116;
    L120:
        r36 = UUID.randomUUID().toString();
    L121:
        r32.setFileIdentifier(r36);
        if (r31 == false) goto L124;
        r32.setHistoryReuse(r12);
        r32.setUri(r13);
        r32.setFromDraft(Boolean.TRUE);
        r32.setFileReviewStatus(Integer.valueOf(FileReviewState.ACCESS.getValue()));
        r32.setFileParsedStatus(Integer.valueOf(FileParseState.SUCCESS.getValue()));
        r32.setUpLinkProcess(100);
        r32.setUpLinkStatus(Integer.valueOf(UpLinkState.SUCCESS.getValue()));
    L126:
        if (d5(r32) == true) goto L94;
        if (n1.a(r32) == false) goto L187;
        UplinkEntityContent r37 = r32.getUplinkEntityContent();
        if (r37 == null) goto L133;
        UplinkFileEntity r41 = r37.getUplinkFileInfo();
    L134:
        ux9.a.a r110 = ux9.a.i;
        String r42 = r32.getFileIdentifier();
        if (r42 != null) goto L137;
        r42 = "";
    L137:
        String r43 = K();
        BotModel r44 = W3();
        if (r44 == null) goto L140;
        UplinkFileEntity r45 = r44.getBotId();
    L141:
        boolean r210 = r11;
        String r111 = r42;
        int r46 = 1;
        UplinkFileEntity r47 = r13;
        UplinkFileEntity r112 = r45;
        FragmentActivity r211 = r14;
        boolean r48 = false;
        ux9.a r49 = r110.e(r111, r43, r112, r30 + 1, "history", "recent_sent_file", r40, z2.a.getFlowMultiUploadConfig().c(), new a0());
        if (r41 == null) goto L146;
        String r113 = r41.getFileName();
        if (r113 == null) goto L146;
        UplinkFileEntity r114 = StringsKt.substringAfterLast(r113, '.', "");
    L147:
        if (r41 == null) goto L149;
        UplinkFileEntity r115 = r41.getSize();
    L150:
        if (r41 == null) goto L154;
        Float r116 = r41.getDuration();
        if (r116 == null) goto L154;
        UplinkFileEntity r117 = Long.valueOf((long) (r116.floatValue() * 1000));
    L155:
        r49.f(r114, r115, r117);
        r49.d(this.P, r47);
        Integer r118 = r32.getUpLinkStatus();
        int r119 = UpLinkState.SUCCESS.getValue();
        if (r118 != null) goto L159;
    L188:
        Integer r50 = r32.getUpLinkStatus();
        int r51 = UpLinkState.SUCCESS.getValue();
        if (r50 != null) goto L192;
    L194:
        G4().remove(r32.getFileIdentifier());
        if (D3(r32) == false) goto L198;
        r32.setUpLinkProcess(Integer.valueOf(r46));
        r32.setUpLinkStatus(Integer.valueOf(UpLinkState.PROCESSING.getValue()));
        r32.setFromDraft(Boolean.FALSE);
        r32.setHistoryReuse(r48);
    L198:
        if (uy8.b.c() == false) goto L203;
        NestedFileCacheManagerService r52 = NestedFileCacheManagerService.b;
        String r53 = this.P;
        String r120 = r32.getFileIdentifier();
        if (r120 != null) goto L202;
        r120 = "";
    L202:
        r52.h(r53, r120);
    L203:
        NestedFileCacheManagerService r121 = NestedFileCacheManagerService.b;
        r121.c(this.P, r32);
        String r122 = this.P;
        z2 r54 = z2.a;
        if (z2.c4() == true) goto L206;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AttachmentPanelComponent$appendHistoryAttachments$4(this, r122, r32, r47), 2, null);
    L206:
        Integer r55 = r32.getUpLinkStatus();
        int r56 = UpLinkState.PROCESSING.getValue();
        if (r55 == null) goto L234;
        if (r55.intValue() != r56) goto L234;
        if (D3(r32) == false) goto L234;
        String r57 = this.B;
        if (r57 != null) goto L216;
        r57 = "modify_retry_upload";
    L216:
        String r123 = r57;
        x0 r58 = h4(this, n1.d(r32), r32, r123, this.C, this.D, null, null, 224);
        String r59 = r32.getFileIdentifier();
        if (r59 != null) goto L219;
        r59 = "";
    L219:
        r58.a(0, r59);
        if (n1.e(r32) == false) goto L225;
        ResourceCenter r60 = ResourceCenter.a;
        String r61 = r32.getFileIdentifier();
        if (r61 != null) goto L224;
        r61 = "";
    L224:
        FlowResourceScene r62 = FlowResourceScene.VideoUpload;
        r60.getClass();
        ResourceCenter.k(r61, r62);
    L229:
        String r63 = r32.getFileIdentifier();
        if (r63 != null) goto L232;
        r63 = "";
    L232:
        r121.m(r122, r63, 1);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AttachmentPanelComponent$retryUploadAttachment$1(this, r32, r58, r123, r122, null), 2, null);
        goto L234
    L225:
        ResourceCenter r64 = ResourceCenter.a;
        String r65 = r32.getFileIdentifier();
        if (r65 != null) goto L228;
        r65 = "";
    L228:
        FlowResourceScene r66 = s5(r123);
        r64.getClass();
        ResourceCenter.k(r65, r66);
    L234:
        r28 = r28 + 1;
        r25 = r25;
        r13 = r47;
        r11 = r210;
        r14 = r211;
        r12 = true;
        r15 = false;
        goto L94
    L192:
        if (r50.intValue() != r51) goto L194;
        G4().put(r32.getFileIdentifier(), Boolean.TRUE);
        goto L198
    L159:
        if (r118.intValue() != r119) goto L188;
        ux9.a.c r67 = r49.e();
        if (r41 == null) goto L165;
        Float r124 = r41.getDuration();
        if (r124 == null) goto L165;
        float r125 = r124.floatValue();
    L167:
        if (r125 <= 0.0f) goto L169;
        AudioAttachmentUploadEvent.Result r126 = AudioAttachmentUploadEvent.Result.VALIDATED;
    L170:
        ux9.a.c.e(r67, r126, r47, r47, 6);
        ux9.a.c.e(r67, AudioAttachmentUploadEvent.Result.REMOTE_CACHE_SKIPPED, r47, r47, 6);
        ux9.a.c.e(r67, AudioAttachmentUploadEvent.Result.UPLOAD_DISPATCHED, r47, r47, 6);
        r67.a(AudioAttachmentUploadEvent.Result.HISTORY_REUSE);
        if (r41 == null) goto L173;
        UplinkFileEntity r127 = r41.getTosKey();
    L174:
        if (r41 == null) goto L176;
        UplinkFileEntity r128 = r41.getResourceId();
    L177:
        if (r41 == null) goto L179;
        UplinkFileEntity r68 = r41.getResourceId();
    L180:
        if (r68 != null) goto L182;
    L185:
        boolean r129 = true;
    L186:
        r67.b(r127, r128, !r129);
        goto L188
    L182:
        if (StringsKt.isBlank(r68) == true) goto L185;
        r129 = false;
        goto L186
    L179:
        r68 = r47;
        goto L180
    L176:
        r128 = r47;
        goto L177
    L173:
        r127 = r47;
        goto L174
    L169:
        r126 = AudioAttachmentUploadEvent.Result.WITHOUT_DURATION;
    L165:
        r125 = 0.0f;
    L154:
        r117 = r47;
        goto L155
    L149:
        r115 = r47;
    L146:
        r114 = r47;
        goto L147
    L140:
        r45 = r13;
        goto L141
    L133:
        r41 = r13;
        goto L134
    L187:
        r210 = r11;
        r47 = r13;
        r211 = r14;
        r46 = 1;
        r48 = false;
        goto L188
    L124:
        r32.setHistoryReuse(r15);
        r32.setFromDraft(Boolean.FALSE);
        r32.setUpLinkProcess(Integer.valueOf(r15 ? 1 : 0));
        r32.setUpLinkStatus(Integer.valueOf(UpLinkState.FAIL.getValue()));
        goto L126
    L116:
        if (Boolean.valueOf(StringsKt.isBlank(r36) ^ r12).booleanValue() == true) goto L119;
        r36 = r13;
    L119:
        if (r36 != null) goto L121;
    L97:
        com.larus.bmhome.chat.component.bottom.multimodal.g r69 = v4();
        if (r69 == null) goto L235;
        String r70 = r69.mS(r11, Boolean.valueOf(r20));
        if (r70 == null) goto L235;
        t19.s.a.getClass();
        t19.s.t(r14, r70);
    L235:
        UplinkFileEntity r130 = r13;
        if (r28 <= 0) goto L260;
        z2 r71 = z2.a;
        if (z2.c4() == false) goto L249;
        j1 r212 = Y3();
        if (r212 == null) goto L249;
        String r72 = this.P;
        NestedFileContent r73 = NestedFileCacheManagerService.b.b6(r72);
        if (r73 == null) goto L244;
        UplinkFileEntity r131 = r73.getEntities();
    L245:
        if (r131 != null) goto L247;
        UplinkFileEntity r213 = CollectionsKt.emptyList();
    L248:
        j1.a.a(r212, r72, null, r213, false, false, null, null, null, null, 506);
        goto L249
    L247:
        r213 = r131;
        goto L248
    L244:
        r131 = r130;
    L249:
        ux9.a.a r74 = ux9.a.i;
        NestedFileContent r75 = NestedFileCacheManagerService.b.b6(this.P);
        if (r75 == null) goto L252;
        UplinkFileEntity r132 = r75.getEntities();
    L253:
        if (r132 != null) goto L255;
        r132 = CollectionsKt.emptyList();
    L255:
        Iterable r133 = (Iterable) r132;
        ArrayList r76 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r133, 10));
        Iterator r77 = r133.iterator();
    L257:
        if (r77.hasNext() == false) goto L259;
        r76.add(((UplinkFileEntity) r77.next()).getFileIdentifier());
        goto L257
    L259:
        r74.a(r76, this.P);
        E3();
        goto L260
    L252:
        r132 = r130;
    L260:
        this.L0 = false;
        return r28;
    L89:
        if (r11 == false) goto L91;
        ImFileUtil.a.getClass();
        r24 = ImFileUtil.l();
        goto L88
    L91:
        ImFileUtil.a.getClass();
        r24 = ImFileUtil.n();
        goto L88
    L81:
        if (r19 == true) goto L83;
        W5(r39, p4(CollectionsKt.toMutableList(r10), r11, false), r11, r40, null, null, "");
        goto L85
    L83:
        if (r39 == false) goto L85;
        SafeExtKt.b(F2(), new z(this), 200);
        goto L85
    L78:
        r21 = false;
        goto L79
    L71:
        r18 = false;
    L74:
        r19 = false;
    L63:
        r20 = false;
        goto L64
    L45:
        if (n1.a(r7) == true) goto L50;
        if (n1.e(r7) == true) goto L50;
        r8 = false;
    L53:
        r11 = false;
        goto L55
    }

    public static void Q5(AttachmentPanelComponent r8, UplinkFileEntity r9, String r10, boolean r11, boolean r12, boolean r13, int r14) {
        if ((r14 & 2) == 0) goto L5;
        r10 = r8.P;
    L5:
        String r3 = r10;
        boolean r0 = true;
        if ((r14 & 4) == 0) goto L8;
        boolean r1 = true;
    L10:
        if ((r14 & 8) == 0) goto L13;
        r12 = false;
    L13:
        if ((r14 & 16) == 0) goto L15;
        r13 = true;
    L15:
        r8.getClass();
        if (uy8.b.c() == false) goto L23;
        String r15 = d1.c(d1.e(r9, 0));
        if (r15 == null) goto L22;
        Uri r16 = UriProtector.parse(r15);
        if (r16 == null) goto L22;
    L24:
        String r17 = r9.getFileIdentifier();
        if (r17 != null) goto L27;
        r17 = "";
    L27:
        final String r4 = r17;
        FLogger.a.i("AttachmentPanelComponent", "[removeAttachmentEntityInternal] uri: " + r16 + ", fileIdentifier: " + r4);
        boolean r18 = r8.i5();
        if (r18 == true) goto L33;
        mt8.a r2 = r8.m;
        if (r2 == null) goto L32;
        r2.c(r4);
    L32:
        r8.o6();
    L33:
        com.larus.utils.h.e(r8.J, new i(r4));
        if (r18 == false) goto L39;
        mt8.a r19 = r8.m;
        if (r19 == null) goto L38;
        r19.c(r4);
    L38:
        r8.o6();
    L39:
        r8.x5();
        r8.G4().remove(r4);
        r8.V0.remove(r4);
        r8.h1.remove(r4);
        if (r13 == false) goto L44;
        op8.e r110 = (op8.e) r8.u.getValue();
        if (r110 == null) goto L44;
        r110.h0(r16);
    L44:
        if (r16 == null) goto L59;
        List<UplinkFileEntity> r111 = r8.J;
        if ((r111 instanceof Collection) == true) goto L48;
    L50:
        Iterator r112 = ((ArrayList) r111).iterator();
    L52:
        if (r112.hasNext() == false) goto L56;
        if (Intrinsics.areEqual(((UplinkFileEntity) r112.next()).getUri(), r16) == false) goto L52;
        boolean r113 = true;
    L57:
        if (r113 == false) goto L59;
    L60:
        if (r13 == false) goto L68;
        if (com.larus.platform.exp.g.a() == false) goto L68;
        if (r0 == true) goto L68;
        com.larus.bmhome.chat.component.fastsend.e0 r114 = (com.larus.bmhome.chat.component.fastsend.e0) r8.t.getValue();
        if (r114 == null) goto L68;
        r114.h0(r16);
    L68:
        if (((ArrayList) r8.J).isEmpty() == false) goto L73;
        if (r8.V.isEmpty() == false) goto L73;
        r8.V4();
    L76:
        FileUploader r115 = FileUploader.a;
        ResourceUploader.a.b r116 = ResourceUploader.a.b.a;
        Intrinsics.checkNotNullParameter(r4, "fileIdentifier");
        Intrinsics.checkNotNullParameter(r116, "reason");
        ux9.a r117 = ux9.a.i.c(r4);
        if (r117 == null) goto L97;
        ux9.a.c r118 = r117.e();
        if (r118 == null) goto L97;
        if (Intrinsics.areEqual(r116, ResourceUploader.a.a.a) == false) goto L83;
        AudioAttachmentUploadEvent.Result r119 = AudioAttachmentUploadEvent.Result.LEAVE_CANCELED;
    L84:
        monitor-enter(r118);
        Intrinsics.checkNotNullParameter(r119, "result");     // Catch: Throwable -> L94
        if (r118.l == true) goto L88;
    L92:
        monitor-exit(r118);
        goto L97
    L88:
        if (r119 != AudioAttachmentUploadEvent.Result.USER_CANCELED) goto L90;
    L91:
        ux9.a.c.e(r118, r119, null, null, 6);     // Catch: Throwable -> L94
        goto L92
    L90:
        if (r119 != AudioAttachmentUploadEvent.Result.LEAVE_CANCELED) goto L92;
    L94:
        th = move-exception;
        throw th;
    L83:
        r119 = AudioAttachmentUploadEvent.Result.USER_CANCELED;
    L97:
        SharedAlbumUploadCoordinator r120 = SharedAlbumUploadCoordinator.a;
        if (z2.a.fastAlbumSingleUploadAttachmentSyncEnable() == true) goto L100;
        ResourceUploader r121 = ResourceUploader.a;
        ResourceUploader.b(r4, r116);
    L106:
        if (r12 == false) goto L108;
        FileUploader.a(r4);
    L108:
        Long r122 = Long.valueOf(System.currentTimeMillis());
        r122.longValue();
        if (r1 == false) goto L111;
        Long r5 = r122;
    L112:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r8), Dispatchers.getIO(), null, new AttachmentPanelComponent$removeAttachmentEntityInternal$2(r1, r8, r3, r4, r5, r9, null), 2, null);
        return;
    L111:
        r5 = null;
        goto L112
    L100:
        SharedAlbumUploadCoordinator.a r123 = SharedAlbumUploadCoordinator.c(r4);
        if (r123.a == true) goto L103;
        ResourceUploader r124 = ResourceUploader.a;
        ResourceUploader.b(r4, r116);
        goto L106
    L103:
        String r125 = r123.b;
        if (r125 == null) goto L106;
        ResourceUploader r126 = ResourceUploader.a;
        ResourceUploader.b(r125, r116);
    L73:
        if (((ArrayList) r8.J).isEmpty() == false) goto L75;
        r8.z5(new ArrayList());
    L75:
        r8.E3();
    L56:
        r113 = false;
        goto L57
    L48:
        if (((ArrayList) r111).isEmpty() == false) goto L50;
    L59:
        r0 = false;
    L22:
        r16 = r9.getUri();
        goto L24
    L23:
        r16 = r9.getUri();
        goto L24
    L8:
        r1 = r11;
        goto L10
    }

    public static /* synthetic */ void X5(AttachmentPanelComponent r8, AttachmentPanelType r9, boolean r10, String r11, String r12, String r13, int r14) {
        if ((r14 & 16) == 0) goto L5;
        r12 = null;
    L5:
        String r5 = r12;
        if ((r14 & 64) == 0) goto L8;
        r13 = "";
    L8:
        r8.W5(false, r9, r10, r11, r5, null, r13);
    }

    public final void W5(boolean r20, final AttachmentPanelType r21, final boolean r22, final String r23, final String r24, final String r25, String r26) {
        boolean r9 = false;
        if (c4() == false) goto L6;
        boolean r12 = true;
    L18:
        com.larus.bmhome.instruction.g r0 = vc();
        if (r0 == null) goto L21;
        r0.Vm(false, "");
    L21:
        Pq(false);
        String r10 = this.P;
        BaseResourceViewHolder.a r15 = new AttachmentPanelComponent$showAttachmentPanel$1(this, r21, r22, r24, r25, r23);
        FLogger.a.i("AttachmentPanelComponent", "[initAndShowAttachmentPanel] attachmentLocalMsgId:" + r10);
        this.B = r23;
        this.E = r21;
        this.C = r24;
        this.D = r26;
        ResourceBarConfig r1 = new ResourceBarConfig(Mode.EDIT, r12, 0, 0, this.W, null, 44, null);
        mt8.a r2 = this.m;
        if (r2 == null) goto L24;
        ArrayList r3 = new ArrayList();
        ArrayList r4 = new ArrayList();
        r4.addAll(this.V);
        r4.addAll(r3);
        r2.b(r1, r4, r15);
    L24:
        mt8.a r5 = this.m;
        if (r5 == null) goto L29;
        View r6 = r5.getView();
        if (r6 == null) goto L29;
        r6.setBackground(i4());
    L29:
        C6();
        mt8.a r7 = this.m;
        if (r7 == null) goto L34;
        View r8 = r7.getView();
        if (r8 == null) goto L34;
        com.larus.utils.e1.x(r8);
    L34:
        com.larus.bmhome.chat.component.bottom.reference.a r11 = g5();
        if (r11 != null) goto L37;
    L41:
        va8.o r13 = k4();
        if (r13 == null) goto L44;
        r13.e10(true);
    L44:
        com.larus.bmhome.instruction.g r14 = vc();
        if (r14 == null) goto L47;
        r14.vW(false);
    L47:
        rv(true);
        de8.c r16 = f1();
        if (r16 != null) goto L50;
    L52:
        boolean r17 = false;
    L54:
        if (r17 == false) goto L94;
        int r18 = com.larus.bmhome.chat.immerse.k0.a;
        de8.c r19 = f1();
        if (r19 == null) goto L60;
        Integer r27 = r19.m();
        if (r27 == null) goto L60;
        int r28 = r27.intValue();
    L61:
        int r29 = com.larus.bmhome.chat.immerse.k0.a(r28, 0.1f, 0.35f);
        GradientDrawable r30 = new GradientDrawable();
        r30.setShape(0);
        float r110 = c7.b(16);
        r30.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, r110, r110, r110, r110});
        r30.setColor(r29);
        com.larus.bmhome.chat.component.bottom.reference.a r111 = g5();
        if (r111 != null) goto L64;
    L66:
        boolean r112 = false;
    L67:
        com.larus.bmhome.instruction.g r113 = vc();
        if (r113 != null) goto L70;
    L72:
        boolean r114 = false;
    L74:
        if (i9() == false) goto L76;
        if (r112 == false) goto L76;
    L81:
        boolean r115 = true;
    L82:
        GradientDrawable r116 = new GradientDrawable();
        r116.setShape(0);
        if (r115 == false) goto L85;
        r116.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f});
    L86:
        r116.setColor(r29);
        mt8.a r117 = this.m;
        if (r117 == null) goto L91;
        View r118 = r117.getView();
        if (r118 == null) goto L91;
        r118.setBackground(r116);
    L91:
        va8.o r119 = k4();
        if (r119 == null) goto L97;
        r119.l70(r30, r29);
    L97:
        va8.o r31 = k4();
        if (r31 == null) goto L100;
        r31.SB(false);
    L100:
        com.larus.bmhome.instruction.g r32 = vc();
        if (r32 != null) goto L103;
    L105:
        boolean r33 = false;
    L106:
        ICoreInputAbility r34 = l4();
        if (r34 != null) goto L109;
    L110:
        getContext().getResources().getString(2131909200);
    L111:
        if (r33 == true) goto L182;
        va8.o r35 = k4();
        if (r35 == null) goto L116;
        r35.getHint();
    L116:
        AttachmentPanelType r36 = this.E;
        if (r36 != null) goto L119;
        int r37 = -1;
    L120:
        int r38 = 2131909197;
        if (r37 == 1) goto L141;
        if (r37 == 2) goto L141;
        if (r37 == 3) goto L132;
        if (r37 == 4) goto L132;
        if (r37 == 5) goto L132;
        ICoreInputAbility r39 = l4();
        if (r39 == null) goto L131;
        CoreInputAbility r40 = r39.JO();
        if (r40 == null) goto L131;
        r40.f9(true);
    L131:
        CharSequence r41 = getContext().getResources().getString(2131909197);
    L150:
        com.larus.bmhome.chat.component.bottom.reference.a r42 = g5();
        if (r42 != null) goto L153;
    L155:
        boolean r43 = false;
    L156:
        if (r43 == true) goto L158;
    L165:
        com.larus.bmhome.instruction.g r44 = vc();
        if (r44 != null) goto L168;
    L170:
        boolean r45 = false;
    L171:
        if (r45 == false) goto L173;
        r41 = getContext().getResources().getString(2131899656);
    L173:
        oaa.a r46 = (oaa.a) this.w.getValue();
        if (r46 == null) goto L179;
        CharSequence r47 = r46.I3();
        if (r47 == null) goto L179;
        r41 = r47;
    L179:
        ICoreInputAbility r48 = l4();
        if (r48 == null) goto L182;
        r48.Yk(r41);
        goto L182
    L168:
        if (r44.k20() != true) goto L170;
        r45 = true;
        goto L171
    L158:
        if (i9() == false) goto L165;
        ICoreInputAbility r49 = l4();
        if (r49 == null) goto L164;
        CoreInputAbility r50 = r49.JO();
        if (r50 == null) goto L164;
        r50.f9(true);
    L164:
        r41 = getContext().getResources().getString(2131909200);
        goto L165
    L153:
        if (r42.LX() != true) goto L155;
        r43 = true;
    L132:
        ICoreInputAbility r51 = l4();
        if (r51 == null) goto L137;
        CoreInputAbility r52 = r51.JO();
        if (r52 == null) goto L137;
        r52.f9(true);
    L137:
        Resources r53 = getContext().getResources();
        if (r17 == false) goto L140;
        r38 = 2131900365;
    L140:
        r41 = r53.getString(r38);
    L141:
        ICoreInputAbility r54 = l4();
        if (r54 == null) goto L146;
        CoreInputAbility r55 = r54.JO();
        if (r55 == null) goto L146;
        r55.f9(true);
    L146:
        Resources r56 = getContext().getResources();
        if (r17 == false) goto L149;
        r38 = 2131900365;
    L149:
        r41 = r56.getString(r38);
        goto L150
    L119:
        r37 = d.b[r36.ordinal()];
    L182:
        if (r20 == false) goto L184;
        SafeExtKt.b(F2(), new x(this), 200);
    L184:
        oaa.a r57 = (oaa.a) this.w.getValue();
        if (r57 == null) goto L188;
        r57.b4();
    L188:
        if (com.larus.platform.exp.g.a() == false) goto L195;
        com.larus.bmhome.chat.component.fastsend.e0 r58 = (com.larus.bmhome.chat.component.fastsend.e0) this.t.getValue();
        if (r58 != null) goto L192;
    L194:
        if (r9 == false) goto L195;
    L198:
        oaa.a r59 = (oaa.a) this.w.getValue();
        if (r59 == null) goto L202;
        r59.F0(true);
    L202:
        if (B4() != null) goto L206;
        NestedFileCacheManagerService r60 = NestedFileCacheManagerService.b;
        r60.g(this.P).observeForever((Observer) this.p1.getValue());
        r60.j(this.P).observeForever((Observer) this.v1.getValue());
        return;
    L206:
        return;
    L192:
        if (r58.IZ() != true) goto L194;
        r9 = true;
    L195:
        com.larus.bmhome.chat.component.bottom.bottommenu.f1 r61 = (com.larus.bmhome.chat.component.bottom.bottommenu.f1) s1a.d.a(this).getAbility(com.larus.bmhome.chat.component.bottom.bottommenu.f1.class);
        if (r61 == null) goto L198;
        r61.rJ();
        goto L198
    L109:
        if (r34.ws(getContext(), K()) != null) goto L111;
    L103:
        if (r32.Wa() != true) goto L105;
        r33 = true;
        goto L106
    L85:
        float r120 = c7.b(16);
        r116.setCornerRadii(new float[]{r120, r120, r120, r120, 0.0f, 0.0f, 0.0f, 0.0f});
    L76:
        if (r114 == true) goto L81;
        if (this.I == true) goto L81;
        r115 = false;
        goto L82
    L70:
        if (r113.z0() != true) goto L72;
        r114 = true;
        goto L74
    L64:
        if (r111.LX() != true) goto L66;
        r112 = true;
    L60:
        r28 = 0;
        goto L61
    L94:
        C6();
        va8.o r62 = k4();
        if (r62 == null) goto L97;
        r62.p9(v19.c.b(2130970690, getContext(), 2131239155));
        goto L97
    L50:
        if (r16.C() != true) goto L52;
        r17 = true;
        goto L54
    L37:
        if (r11.i9() == false) goto L41;
        if (r11.LX() == true) goto L41;
        r11.sZ();
        goto L41
    L6:
        if (r21.isSingleImage() == false) goto L8;
    L17:
        r12 = false;
        goto L18
    L8:
        if (r21.isSingleFile() == true) goto L17;
        ICoreInputAbility r63 = l4();
        if (r63 != null) goto L13;
    L15:
        boolean r64 = false;
    L16:
        r12 = !r64;
        goto L18
    L13:
        if (r63.c1() != true) goto L15;
        r64 = true;
        goto L16
    }

    public final x0 e4(UplinkFileEntity r22, String r23, String r24, String r25, String r26, String r27, String r28) {
        com.larus.bmhome.instruction.g r0 = vc();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L18;
        ICoreInputAbility r2 = l4();
        if (r2 != null) goto L12;
    L14:
        boolean r3 = false;
    L15:
        if (r3 == false) goto L18;
        boolean r4 = false;
    L19:
        WeakReference r10 = new WeakReference(this);
        String r11 = K();
        BotModel r5 = W3();
        if (r5 == null) goto L22;
        String r12 = r5.getBotId();
    L23:
        if (r22 == null) goto L29;
        UplinkEntityContent r6 = r22.getUplinkEntityContent();
        if (r6 == null) goto L29;
        Image r7 = r6.getUplinkImageInfo();
        if (r7 == null) goto L29;
        Boolean r13 = r7.isMarked();
    L30:
        if (r22 == null) goto L36;
        UplinkEntityContent r8 = r22.getUplinkEntityContent();
        if (r8 == null) goto L36;
        Image r9 = r8.getUplinkImageInfo();
        if (r9 == null) goto L36;
        Boolean r14 = r9.isCropped();
    L37:
        com.larus.bmhome.chat.component.bottom.reference.a r15 = g5();
        if (r15 == null) goto L40;
        String r16 = r15.wf();
    L41:
        com.larus.bmhome.chat.component.bottom.reference.a r17 = g5();
        if (r17 == null) goto L44;
        ReferenceInfo r18 = r17.T6();
    L46:
        if (Intrinsics.areEqual(r23, "file") == false) goto L48;
        String r19 = "local";
    L50:
        if (Intrinsics.areEqual(r23, "file") == false) goto L52;
        String r110 = "browser_folder";
    L54:
        return new x0(r28, r22, r4, r23, r24, r25, r26, r27, this, r10, r11, r12, r13, r14, r16, r18, r19, r110);
    L52:
        r110 = null;
        goto L54
    L48:
        r19 = null;
        goto L50
    L44:
        r18 = null;
        goto L46
    L40:
        r16 = null;
    L36:
        r14 = null;
    L29:
        r13 = null;
        goto L30
    L22:
        r12 = null;
        goto L23
    L12:
        if (r2.gj() != true) goto L14;
        r3 = true;
    L18:
        r4 = true;
        goto L19
    L5:
        if (r0.Wa() != true) goto L7;
        r1 = true;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r9v0, types: [com.larus.bmhome.chat.component.bottom.attachment.j0] */
    public final boolean y5(final ICoreInputAbility r11, va8.o r12, final String r13, final SuggestedAction r14, final String r15, final Map<String, String> r16, final Map<String, String> r17, final Map<String, String> r18) {
        boolean r0 = r12.ZI(new j0(this, r13, r11, r14, r15, r16, r17, r18));
        if (r0 == false) goto L19;
        dr9.g r1 = dr9.g.a;
        de8.c r2 = f1();
        if (r2 == null) goto L9;
        Bundle r3 = r2.b;
        if (r3 == null) goto L9;
        String r4 = r3.getString("inject_input_initial_source_node_id");
    L10:
        if (r4 != null) goto L12;
    L15:
        boolean r5 = true;
    L16:
        if (r5 == true) goto L19;
        dr9.g.g(r1);
        dr9.g.c.put(r4, Long.valueOf(System.currentTimeMillis()));
        goto L19
    L12:
        if (StringsKt.isBlank(r4) == true) goto L15;
        r5 = false;
    L9:
        r4 = null;
    L19:
        return r0;
    }

    public static /* synthetic */ x0 h4(AttachmentPanelComponent r11, boolean r12, UplinkFileEntity r13, String r14, String r15, String r16, String r17, String r18, int r19) {
        if ((r19 & 8) == 0) goto L5;
        String r6 = null;
    L7:
        if ((r19 & 16) == 0) goto L9;
        String r7 = null;
    L11:
        if ((r19 & 64) == 0) goto L13;
        String r9 = null;
    L15:
        if ((r19 & 128) == 0) goto L17;
        String r10 = r11.P;
    L19:
        return r11.e4(r13, r14, r6, r7, null, r9, r10);
    L17:
        r10 = r18;
        goto L19
    L13:
        r9 = r17;
        goto L15
    L9:
        r7 = r16;
        goto L11
    L5:
        r6 = r15;
        goto L7
    }

    public static void j6(final AttachmentPanelComponent r95, final View r96, boolean r97, boolean r99, List r910, boolean r100, boolean r101, int r102, int r103) {
        if ((r103 & 4) == 0) goto L5;
        boolean r0 = false;
    L7:
        if ((r103 & 8) == 0) goto L9;
        List r1 = null;
    L11:
        if ((r103 & 16) == 0) goto L13;
        boolean r3 = false;
    L15:
        if ((r103 & 32) == 0) goto L17;
        boolean r4 = false;
    L19:
        if ((r103 & 64) == 0) goto L21;
        int r5 = 0;
    L22:
        r95.getClass();
        ArrayList r12 = new ArrayList();
        if (r3 == true) goto L27;
        r12.add(new com.larus.bmhome.view.screenmenu.l0(2131900535, 2131900535, null, null, null, Integer.valueOf(v19.c.b(2130972079, r95.getContext(), 2131103136)), null, Integer.valueOf(v19.c.b(2130971909, r95.getContext(), 2131242410)), null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -164, 127));
        if (r4 == true) goto L27;
        r12.add(new com.larus.bmhome.view.screenmenu.l0(2131908357, 2131908357, null, null, null, Integer.valueOf(v19.c.b(2130972079, r95.getContext(), 2131103136)), null, Integer.valueOf(v19.c.b(2130971908, r95.getContext(), 2131242407)), null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -164, 127));
    L27:
        if (r97 == false) goto L29;
        r12.add(new com.larus.bmhome.view.screenmenu.l0(2131905683, 2131905683, null, null, null, Integer.valueOf(v19.c.b(2130972079, r95.getContext(), 2131103136)), null, Integer.valueOf(v19.c.b(2130971910, r95.getContext(), 2131242414)), null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -164, 127));
    L29:
        if (r0 == true) goto L31;
    L33:
        com.larus.bmhome.chat.component.fastsend.e0 r2 = (com.larus.bmhome.chat.component.fastsend.e0) r95.t.getValue();
        if (r2 == null) goto L38;
        com.larus.platform.api.a0 r6 = r2.WW();
        if (r6 == null) goto L38;
        final View r7 = r6.Yz();
    L39:
        final List r911 = r1;
        final int r104 = r5;
        final View r105 = r7;
        final View r8 = CreateMenu.f(new CreateMenu(r95.getContext()), r12, i5.E(), false, null, null, null, null, new m0(r95, r911, r104, r105, r96), 508);
        if (r7 != null) goto L42;
    L44:
        com.larus.bmhome.view.screenmenu.d.a(com.larus.bmhome.view.screenmenu.d.a, r96, r8, false, null, null, null, null, 120).v(r96, 0, i5.J());
        return;
    L42:
        if (com.larus.platform.exp.g.a() == false) goto L44;
        r7.post(new n0(r7, r96, r8));
        return;
    L38:
        r7 = null;
        goto L39
    L31:
        if (FlowDriveSdkService.a.h() == false) goto L33;
        r12.add(new com.larus.bmhome.view.screenmenu.l0(2131905374, 2131905374, null, null, null, 2131103136, null, 2131242413, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -164, 127));
        goto L33
    L21:
        r5 = r102;
        goto L22
    L17:
        r4 = r101;
        goto L19
    L13:
        r3 = r100;
        goto L15
    L9:
        r1 = r910;
        goto L11
    L5:
        r0 = r99;
        goto L7
    }

    @Override // com.larus.bmhome.chat.component.bottom.attachment.g1
    public final boolean w50(List<UplinkFileEntity> r31, boolean r32, String r33, String r34, String r35, String r36, String r37, String r38, boolean r39, String r40, String r41, boolean r42, String r43, String r44, Long r45) {
        Intrinsics.checkNotNullParameter(r31, "entityList");
        Intrinsics.checkNotNullParameter(r33, "fromScene");
        Intrinsics.checkNotNullParameter(r38, "enterMethodForSendMessage");
        op8.k r0 = B4();
        if (r0 == null) goto L10;
        Fragment r1 = r0.a();
        if (r1 == null) goto L162;
        g1 r2 = s1a.a.g(r1).getAbility(g1.class);
        if (r2 != null) goto L9;
        return false;
    L9:
        return r2.w50(r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45);
    L162:
        return false;
    L10:
        FLogger r3 = FLogger.a;
        r3.i("AttachmentPanelComponent", "[handleUploadAttachments] isFromFileBrowser:" + r32 + ", fromScene:" + r33 + ", clickFrom:" + r34 + ", enterMethod:" + r35 + ", isMultiChooseMode" + r36 + ", actionBarTemplateName:" + r37 + ", enterMethodForSendMessage:" + r38);
        StringBuilder r4 = new StringBuilder("[handleUploadAttachments] entityList(");
        r4.append(r31.size());
        r4.append("):");
        r4.append(r31);
        r3.i("AttachmentPanelComponent", r4.toString());
        if (r31.isEmpty() == false) goto L13;
        return false;
    L13:
        com.larus.bmhome.instruction.g r5 = vc();
        if (r5 != null) goto L16;
    L18:
        boolean r6 = false;
    L19:
        boolean r27 = !r6;
        if (r42 == false) goto L30;
        if (r41 != null) goto L23;
    L29:
        return false;
    L23:
        if ((!StringsKt.isBlank(r41)) == false) goto L25;
        String r7 = r41;
    L26:
        if (r7 == null) goto L29;
        String r16 = r7;
    L31:
        if (r42 == false) goto L33;
    L46:
        String r29 = "AttachmentPanelComponent";
        boolean r15 = true;
        if (r27 == false) goto L49;
        SafeExtKt.b(F2(), new i0(this), 200);
    L49:
        if (r16 != null) goto L51;
        String r8 = this.P;
    L52:
        if (r42 == true) goto L70;
        com.larus.bmhome.instruction.g r9 = vc();
        if (r9 != null) goto L56;
    L58:
        boolean r10 = false;
    L59:
        if (r10 == false) goto L70;
        j1 r11 = Y3();
        if (r11 == null) goto L70;
        z2 r12 = z2.a;
        if (z2.c4() == false) goto L67;
        com.larus.bmhome.instruction.g r13 = vc();
        if (r13 == null) goto L70;
        r13.Lg(r11, r15);
        goto L70
    L67:
        com.larus.bmhome.instruction.g r14 = vc();
        if (r14 == null) goto L70;
        r14.Lg(r11, false);
        goto L70
    L56:
        if (r9.Wa() != r15) goto L58;
        r10 = true;
    L70:
        if (r42 == false) goto L72;
        List<UplinkFileEntity> r17 = r31;
    L73:
        HashSet r18 = new HashSet();
        ArrayList r19 = new ArrayList();
        Iterator<T> r20 = r17.iterator();
    L75:
        if (r20.hasNext() == false) goto L79;
        Object r21 = r20.next();
        if (r18.add(((UplinkFileEntity) r21).getFileIdentifier()) == false) goto L75;
        r19.add(r21);
        goto L75
    L79:
        z2 r22 = z2.a;
        if (z2.c4() == false) goto L87;
        j1 r110 = Y3();
        if (r110 == null) goto L84;
        boolean r23 = j1.a.a(r110, r8, null, r19, false, r42, r43, r44, r45, null, 266);
    L88:
        if (r23 == true) goto L95;
        FLogger.a.w(r29, "ignore attachments because their draft origin is no longer current");
        if (((ArrayList) this.J).isEmpty() == true) goto L92;
    L94:
        return false;
    L92:
        if (this.V.isEmpty() == false) goto L94;
        V4();
        goto L94
    L95:
        String r24 = r29;
        if (r42 == false) goto L100;
        this.P = r8;
        String r111 = r24;
        String r112 = r8;
        W5(r27, p4(r31, r32, r39), r32, r33, r34, r37, r38);
        p1 r25 = (p1) this.x.getValue();
        if (r25 == null) goto L102;
        r25.cb(false);
    L102:
        if (z2.c4() == false) goto L107;
        Iterator<T> r26 = r31.iterator();
    L105:
        if (r26.hasNext() == false) goto L107;
        NestedFileCacheManagerService.b.c(r112, (UplinkFileEntity) r26.next());
    L107:
        Iterator<UplinkFileEntity> r28 = r31.iterator();
    L109:
        if (r28.hasNext() == false) goto L151;
        UplinkFileEntity r113 = r28.next();
        ux9.a r30 = ux9.a.i.c(r113.getFileIdentifier());
        if (r30 == null) goto L114;
        r30.d(r112, Integer.valueOf(((ArrayList) this.J).size()));
    L114:
        if (r113.getUri() == null) goto L149;
        n1.d(r113);
        if (n1.e(r113) == false) goto L121;
        if (this.H0 == true) goto L121;
        FLogger.a.i(r111, "[handleUploadAttachments] forceBanSuggestedAction:true");
        this.H0 = true;
    L121:
        String r114 = K();
        BotModel r46 = W3();
        if (r46 == null) goto L124;
        String r115 = r46.getBotId();
    L125:
        wc9.e r47 = H3();
        if (r47 == null) goto L128;
        String r116 = r47.B;
    L129:
        String r48 = r112;
        com.larus.bmhome.chat.component.bottom.multimodal.upload.q r49 = new com.larus.bmhome.chat.component.bottom.multimodal.upload.q(r114, true, e4(r113, r33, r34, r35, r36, r37, r112), r33, r113, false, r48, r115, r116, r40, 32);
        if (n1.e(r113) == false) goto L133;
        FlowResourceScene r50 = FlowResourceScene.VideoUpload;
    L138:
        ResourceCenter r51 = ResourceCenter.a;
        String r52 = r113.getFileIdentifier();
        String r53 = "";
        if (r52 != null) goto L141;
        r52 = "";
    L141:
        r51.getClass();
        ResourceCenter.k(r52, r50);
        ConcurrentHashMap<String, c> r54 = this.V0;
        String r55 = r113.getFileIdentifier();
        if (r55 == null) goto L145;
        r53 = r55;
    L145:
        r54.put(r53, new c(this.P0));
        z2 r56 = z2.a;
        if (z2.c4() == true) goto L148;
        NestedFileCacheManagerService.b.c(r48, r113);
    L148:
        String r117 = r48;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AttachmentPanelComponent$handleUploadAttachments$6$1(r39, r113, this, r117, r49, null), 2, null);
    L150:
        r111 = r111;
        r112 = r117;
        goto L109
    L133:
        if (n1.d(r113) == true) goto L135;
    L137:
        r50 = s5(r33);
        goto L138
    L135:
        if (this.L1 == false) goto L137;
        r50 = FlowResourceScene.SpringMainVenue;
        goto L138
    L128:
        r116 = null;
        goto L129
    L124:
        r115 = null;
        goto L125
    L149:
        r117 = r112;
        goto L150
    L151:
        return true;
    L100:
        r111 = r24;
        r112 = r8;
        goto L102
    L84:
        if (r42 == false) goto L87;
        r23 = false;
    L87:
        r23 = true;
        goto L88
    L72:
        r17 = CollectionsKt.plus(this.J, r31);
        goto L73
    L51:
        r8 = r16;
        goto L52
    L33:
        if (this.P.length() != 0) goto L35;
        boolean r57 = true;
    L36:
        if (r57 == false) goto L46;
        if (r41 != null) goto L39;
    L44:
        int r58 = wf9.b.a;
        String r59 = com.flow.kmp.common.util.i.a();
    L45:
        this.P = r59;
        r15 = true;
        r29 = "AttachmentPanelComponent";
        W5(r27, p4(r31, r32, r39), r32, r33, r34, r37, r38);
        goto L49
    L39:
        if ((!StringsKt.isBlank(r41)) == false) goto L41;
        r59 = r41;
    L42:
        if (r59 == null) goto L44;
    L41:
        r59 = null;
        goto L42
    L35:
        r57 = false;
        goto L36
    L25:
        r7 = null;
        goto L26
    L30:
        r16 = null;
        goto L31
    L16:
        if (r5.Wa() != true) goto L18;
        r6 = true;
        goto L19
    }
}
